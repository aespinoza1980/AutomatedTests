package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.Random;

/**
 * Created by Alexis Espinoza on 7/20/16.
 */
public class HorizontalSliderPage extends BasePage {
    public HorizontalSliderPage(WebDriver driver, boolean navigate, String[] propertyValues){
        super (driver, navigate, propertyValues[0]+"horizontal_slider", propertyValues, "Horizontal Slider page");
    }

    public void moveHorizontalSlider(String cssPath) throws InterruptedException {
        Random r = new Random();
        WebElement slider = driver.findElement(By.cssSelector(cssPath));
        Actions move = new Actions(driver);
        int coordinates;
        Action action;
        for (int i = 0; i < 5; i++) {
            coordinates = r.nextInt((100 - 0) + 1) + 0;
            action = move.dragAndDropBy(slider, coordinates, 0).build();
            action.perform();
            Thread.sleep(1000);
        }
    }
}
