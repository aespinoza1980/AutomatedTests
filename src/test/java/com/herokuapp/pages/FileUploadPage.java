package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static org.testng.Assert.assertEquals;

/**
 * Created by Alexis Espinoza on 7/28/16.
 */
public class FileUploadPage extends BasePage {
    private String sourceFile;
    public FileUploadPage(WebDriver driver, boolean navigate, String[] propertyValues, String sourceFile) {
        super (driver, navigate, propertyValues[0]+"upload", propertyValues, "File uploader. Choose a file on your system and then click upload. Or, drag and drop a file into the area below.");
        this.sourceFile = sourceFile;
    }

    public void fileUpload() throws InterruptedException, AWTException{
        String [] cssPath = {"#content > div.example > form","#file-upload"};
        WebElement upload = driver.findElement(By.cssSelector("#file-upload"));
        upload.sendKeys(this.sourceFile);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#file-submit")).click();
    }
    public void checkFileUploaded() throws InterruptedException {
        assertEquals(propertyValues[0]+"upload", driver.getCurrentUrl());
        String [] cssPath = {"#content", "#content > div","#content > div > h3"};
        assertEquals(findNestedElements(cssPath).getText(), "File Uploaded!");
        String [] fileName = this.sourceFile.split("/");
        cssPath    = new String[1];
        cssPath[0] = "#uploaded-files";
        assertEquals(findNestedElements(cssPath).getText(),fileName[fileName.length - 1]);
    }
}
