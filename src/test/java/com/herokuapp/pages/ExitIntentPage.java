package com.herokuapp.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

import static org.testng.Assert.assertEquals;

/**
 * Created by Alexis Espinoza on 7/27/16.
 */
public class ExitIntentPage extends BasePage{
    public ExitIntentPage(WebDriver driver, boolean navigate, String[] propertyValues){
        super (driver, navigate, propertyValues[0]+"exit_intent", propertyValues, "Exit Intent page. Mouse out of the viewport pane and see a modal window appear.");
    }
    public void checkExitIntent (int offSet) throws InterruptedException{
        Point coordinates = driver.findElement(By.cssSelector("#content > div.example > h3")).getLocation();
        try {
            Robot robot = new Robot();
            robot.mouseMove(coordinates.getX(),coordinates.getY() + offSet);
            String [] cssPath = {"#ouibounce-modal", "#ouibounce-modal > div.modal","#ouibounce-modal > div.modal > div.modal-title","#ouibounce-modal > div.modal > div.modal-title > h3"};
            Thread.sleep(1000);
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssPath[0])));
            WebElement webElement = findNestedElements(cssPath);
            assertEquals(webElement.getText(), "THIS IS A MODAL WINDOW");
            cssPath    = new String[2];
            cssPath[0] = "#ouibounce-modal > div.modal > div.modal-body";
            cssPath[1] = "#ouibounce-modal > div.modal > div.modal-body > p";
            webElement = findNestedElements(cssPath);
            assertEquals(webElement.getText(), "It's commonly used to encourage a user to take an action (e.g., give their e-mail address to sign up for something).");
            cssPath    = new String[1];
            cssPath[0] = "#ouibounce-modal > div.modal > div.modal-footer";
            findNestedElementsAndClick(cssPath,true);
        } catch (AWTException e) {
            e.printStackTrace();
        }

    }
}
