package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

import static org.testng.Assert.assertEquals;

/**
 * Created by Alexis Espinoza on 7/19/16.
 */
public class MainPage extends BasePage{
    public MainPage(WebDriver driver, boolean navigate, String[] propertyValues){
        super (driver, navigate, propertyValues[0], propertyValues, "Main page");

    }
    public void clickOnMenuElement(String menuOption) {
        try {
            driver.findElement(By.partialLinkText(menuOption)).click();
        }  catch (NoSuchElementException e) {
            System.out.println("Element " +menuOption+ " Not Found");
        }

    }
}
