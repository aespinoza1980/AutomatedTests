package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.UUID;

/**
 * Created by Alexis Espinoza on 7/20/16.
 */
public class TinyMcePage extends BasePage{
    public TinyMcePage(WebDriver driver, boolean navigate, String[] propertyValues){
        super (driver, navigate, propertyValues[0]+"tinymce", propertyValues, "WYSIWYG Editor");
    }
    public void writeMessage() throws InterruptedException {
        WebElement iframeMsg = driver.findElement(By.xpath("//*[@id=\"mce_0_ifr\"]"));
        driver.switchTo().frame(iframeMsg);

        WebElement webElement = driver.findElement(By.cssSelector("body"));
        System.out.println(webElement.getText());
        webElement.click();
        webElement.clear();
        String keys = "This a random automated message: "+ UUID.randomUUID().toString();
        webElement.sendKeys(keys);
        System.out.println(keys);
    }
}
