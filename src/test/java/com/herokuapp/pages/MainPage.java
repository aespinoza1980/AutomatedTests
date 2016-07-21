package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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
    public void clickOnAuthenticate(String user, String pass) {
        try {
            Thread.sleep(5000);
            Robot rb = new Robot();
            System.out.println(user);
            StringSelection username = new StringSelection(user);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(username, null);
            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_V);
            rb.keyRelease(KeyEvent.VK_V);
            rb.keyRelease(KeyEvent.VK_CONTROL);

            //tab to password entry field
            rb.keyPress(KeyEvent.VK_TAB);
            rb.keyRelease(KeyEvent.VK_TAB);
            Thread.sleep(2000);

            //Enter password by ctrl-v
            StringSelection pwd = new StringSelection(pass);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(pwd, null);
            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_V);
            rb.keyRelease(KeyEvent.VK_V);
            rb.keyRelease(KeyEvent.VK_CONTROL);

            //press enter
            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
