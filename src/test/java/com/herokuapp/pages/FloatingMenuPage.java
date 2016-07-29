package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;

/**
 * Created by Alexis Espinoza on 7/29/16.
 */
public class FloatingMenuPage extends BasePage {
    public FloatingMenuPage(WebDriver driver, boolean navigate, String[] propertyValues){
        super (driver, navigate, propertyValues[0]+"floating_menu", propertyValues, "floating menu page");
    }
    public void checkTabsMenu () throws InterruptedException{
        String [] cssPath = new String[1];
        String [] menuOptions = {"#home", "#news", "#contact", "#about"};
        int j = 0;
        for(int i = 1; i < 4; i++) {
            cssPath[0] = "#menu > ul > li:nth-child(" + i + ") > a";
            findNestedElementsAndClick(cssPath,true);
            assertEquals(propertyValues[0] + "floating_menu"+menuOptions[j], driver.getCurrentUrl());
            j++;
       }
     }
    public void scrollDown (int pos) {
        super.scrollDown(pos);
    }
}
