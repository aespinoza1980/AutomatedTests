package com.herokuapp.tests;

import com.herokuapp.pages.MainPage;
import com.herokuapp.pages.TinyMcePage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Alexis Espinoza on 7/20/16.
 */
public class TinyMceTest extends BaseTest {
    @Parameters({"browser", "browser_version", "os", "os_version", "mobileBrowserName","mobilePlatform","mobileDevice"})
    @BeforeTest
    public void setUpLocal(@Optional("firefox") String browser,@Optional("")String browser_version,
                           @Optional("")String os, @Optional("")String os_version,
                           @Optional("")String mobileBrowserName,
                           @Optional("")String mobilePlatform,
                           @Optional("")String mobileDevice)throws IOException {
        this.setUp(browser,browser_version,os,os_version,mobileBrowserName,mobilePlatform,mobileDevice);
    }

    @Test
    public void TinyMce() throws InterruptedException{
        MainPage mainPage = new MainPage(driver, true, propertyValues);
        mainPage.clickOnMenuElement(WYSIWYGEditor);
        TinyMcePage tinyMcePage = new TinyMcePage(driver, false, propertyValues);
        tinyMcePage.writeMessage();
        Thread.sleep(2000);
        close();
    }
}
