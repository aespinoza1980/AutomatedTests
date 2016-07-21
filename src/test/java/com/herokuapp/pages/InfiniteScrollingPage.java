package com.herokuapp.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Created by Alexis Espinoza on 7/21/16.
 */
public class InfiniteScrollingPage extends BasePage{
    public InfiniteScrollingPage(WebDriver driver, boolean navigate, String[] propertyValues) {
        super (driver, navigate, propertyValues[0]+"infinite_scroll", propertyValues, "infinite scroll");
    }
    public void scrollDown (int iterations) throws InterruptedException {
        int j = 1;
        for (int i = 0; i < iterations; i++) {
            ((JavascriptExecutor) driver).executeScript("scroll(0,"+j*350+");");
            Thread.sleep(100);
            j++;
        }

    }
}
