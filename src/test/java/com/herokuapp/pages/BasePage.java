package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.nio.charset.Charset;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

/**
 * Created by Alexis Espinoza on 7/5/16.
 */
public class BasePage {
    protected WebDriver driver;
    protected String[] propertyValues;
    WebDriverWait wait;

    public BasePage () { }
    public BasePage (WebDriver driver, boolean navigate, String mainUrl, String[] propertyValues, String message) {
        this.driver         = driver;
        this.propertyValues = propertyValues;
        if(navigate) {
            this.driver.navigate().to(mainUrl);
        }
        assertEquals(mainUrl, driver.getCurrentUrl());
        System.out.println(message);

    }

    protected void loadPage (String link ) {
        boolean pageLoaded = false;
        while (!pageLoaded) {
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            try {
                assertEquals(link, driver.getCurrentUrl());
                pageLoaded = true;
            }
            catch (AssertionError  e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("Could not load "+link+ ". I will try again");
            }
        }
    }

    protected  String randomWord(int length) {
        Random random = new Random();
        StringBuilder word = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            word.append((char)('a' + random.nextInt(26)));
        }
        return word.toString();
    }

    protected WebElement findNestedElements(String [] cssPath) {
        WebElement webElement;
        WebElement webElement1;
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssPath[0])));
        webElement  = driver.findElement(By.cssSelector(cssPath[0]));
        for (int i = 1; i < cssPath.length; i++) {
            webElement1 = webElement.findElement(By.cssSelector(cssPath[i]));
            webElement  = webElement1;
        }
        return webElement;
    }
    protected void findNestedElementsAndClick(String [] cssPath, boolean click) {
        if ((cssPath.length > 0) && (click)) {
            findNestedElements(cssPath).click();
        } else if ((cssPath.length > 0) && (!click)) {
            findNestedElements(cssPath);
        } else {
            System.out.println("Unable to click. Wrong params. Could not find elements.");
        }
    }

    protected void findNestedElementsAndSendKeys ( String [] cssPath, String keys) {
        WebElement webElement;
        if(cssPath.length > 0) {
            webElement = findNestedElements(cssPath);
            webElement.click();
            webElement.clear();
            webElement.sendKeys(keys);
        } else {
            System.out.println("Unable to send keys. Wrong params. Could not find elements");
        }
    }
    protected static String readFile(String file) throws IOException {
        Charset cs = Charset.forName("UTF-8");
        FileInputStream stream = new FileInputStream(file);
        try {
            Reader reader = new BufferedReader(new InputStreamReader(stream, cs));
            StringBuilder builder = new StringBuilder();
            char[] buffer = new char[8192];
            int read;
            while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
                builder.append(buffer, 0, read);
            }
            return builder.toString();
        } finally {
            stream.close();
        }
    }
    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}