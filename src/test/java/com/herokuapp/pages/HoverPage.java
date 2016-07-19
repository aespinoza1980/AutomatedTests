package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.testng.Assert.assertEquals;

/**
 * Created by Alexis Espinoza on 7/19/16.
 */
public class HoverPage extends BasePage {
    public HoverPage(WebDriver driver, boolean navigate, String[] propertyValues) {
        super (driver, navigate, propertyValues[0]+"hovers", propertyValues, "Drag and Drop page");
    }
    public void Hover(String cssPath1) throws InterruptedException {
        WebElement webElement1 = driver.findElement(By.cssSelector(cssPath1));
        Actions builder = new Actions(driver);
        builder.moveToElement(webElement1).perform();
        Thread.sleep(1000);
    }
    public void assertViewProfile(String [] cssPath, String nextPage) throws InterruptedException {
        findNestedElementsAndClick(cssPath, true);
        assertEquals(propertyValues[0]+nextPage, driver.getCurrentUrl());
        Thread.sleep(1000);
    }

}
