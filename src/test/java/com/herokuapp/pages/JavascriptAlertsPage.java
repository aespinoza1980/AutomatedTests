package com.herokuapp.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Random;

import static org.testng.Assert.assertEquals;

/**
 * Created by Alexis Espinoza on 7/25/16.
 */
public class JavascriptAlertsPage extends BasePage {
    public JavascriptAlertsPage(WebDriver driver, boolean navigate, String[] propertyValues){
        super (driver, navigate, propertyValues[0]+"javascript_alerts", propertyValues, "Javascript alerts");
    }
    public void javascriptAlertsButtons () throws InterruptedException{
        int i = 1;
        WebElement webElement;
        String cssPath;
        String randomText = null;
        Random ran = new Random();
        int ranNumber;
        while(i < 4) {
            cssPath = "#content > div > ul > li:nth-child(" + i + ") > button";
            System.out.println(cssPath);
            webElement = driver.findElement(By.cssSelector(cssPath));
            webElement.click();
            Thread.sleep(1000);
            if(i == 3) {
                try {
                    Thread.sleep(1000);
                    Robot rb = new Robot();
                    randomText = "Some random text " + randomWord(10);
                    StringSelection textString = new StringSelection(randomText);
                    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(textString, null);
                    rb.keyPress(KeyEvent.VK_CONTROL);
                    rb.keyPress(KeyEvent.VK_V);
                    rb.keyRelease(KeyEvent.VK_V);
                    rb.keyRelease(KeyEvent.VK_CONTROL);
                    Thread.sleep(1000);
                    driver.switchTo().alert().accept();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if(i == 2) {
                ranNumber = ran.nextInt(2) + 1;
                if(ranNumber == 1) {
                    randomText =  "You clicked: Ok";
                    driver.switchTo().alert().accept();
                } else {
                    randomText =  "You clicked: Cancel";
                    driver.switchTo().alert().dismiss();
                }

            } else {
                driver.switchTo().alert().accept();
            }

            //Assertions
            webElement = driver.findElement(By.cssSelector("#result"));
            switch (i) {
                case 1: assertEquals(webElement.getText(), "You successfuly clicked an alert");
                        break;
                case 2: assertEquals(webElement.getText(), randomText);
                        break;
                case 3: randomText = "You entered: " + randomText;
                        assertEquals(webElement.getText(), randomText);
                        break;

            }

            i++;
            Thread.sleep(1000);
        }
    }
}
