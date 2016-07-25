package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;

/**
 * Created by Alexis Espinoza on 7/25/16.
 */
public class FormAuthenticationPage extends BasePage{
    public FormAuthenticationPage(WebDriver driver, boolean navigate, String[] propertyValues){
        super (driver, navigate, propertyValues[0]+"login", propertyValues, "Form authentication page");
    }
    public void formAuthentication (String user, String pass) {
        String [] cssPath = {"#login > div:nth-child(1) > div", "#username"};
        findNestedElementsAndSendKeys ( cssPath, user);
        cssPath = new String[1];
        cssPath[0] = "#password";
        findNestedElementsAndSendKeys ( cssPath, pass);
        cssPath    = new String[2];
        cssPath[0] = "#login > button";
        cssPath[1] = "#login > button > i";
        findNestedElementsAndClick(cssPath,true);
    }
    public void checkTopMessage(String message) {
        String [] cssPath;
        assertEquals(propertyValues[0]+"login", driver.getCurrentUrl());
        cssPath    = new String[3];
        cssPath[0] = "body > div:nth-child(1)";
        cssPath[1] = "#flash-messages";
        cssPath[2] = "#flash";
        WebElement webElement = findNestedElements(cssPath);
        assertEquals(webElement.getText().replace("×","").trim(), message);
    }
    public void secureArea() {
        assertEquals(propertyValues[0]+"secure", driver.getCurrentUrl());
        String [] cssPath = {"body > div:nth-child(1)","#flash-messages","#flash"};
        WebElement webElement = findNestedElements(cssPath);
        assertEquals(webElement.getText().replace("×","").trim(), "You logged into a secure area!");
        cssPath    = new String[2];
        cssPath[0] = "#content > div";
        cssPath[1] = "#content > div > h2";
        webElement = findNestedElements(cssPath);
        assertEquals(webElement.getText(),"Secure Area");
        cssPath    = new String[1];
        cssPath[0] = "#content > div > h4";
        webElement = findNestedElements(cssPath);
        assertEquals(webElement.getText(),"Welcome to the Secure Area. When you are done click logout below.");
        cssPath    = new String[1];
        cssPath[0] = "#content > div > a";
        findNestedElementsAndClick(cssPath,true);
    }
}
