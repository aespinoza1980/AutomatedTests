package com.herokuapp.pages;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.http.HttpResponse;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by Alexis Espinoza on 7/26/16.
 * This test should fail because the image two if the images are not there
 */
public class BrokenImagesPage extends BasePage {
    public BrokenImagesPage(WebDriver driver, boolean navigate, String[] propertyValues){
        super (driver, navigate, propertyValues[0]+"broken_images", propertyValues, "Drag and Drop page");
    }
    public void checkBrokenImages () {
        String cssPath;
        WebElement imagesList;
        int i = 2;
        while(i < 5) {
            cssPath = "#content > div > img:nth-child(" + i + ")";
            imagesList = driver.findElement(By.cssSelector(cssPath));
            assertEquals(elementActive(imagesList, "src"), true);
            i++;
        }
    }
}
