package com.herokuapp.tests;

import com.herokuapp.pages.ExitIntentPage;
import com.herokuapp.pages.MainPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Alexis Espinoza on 7/27/16.
 */
public class ExitIntentTest extends BaseTest{
    @Parameters({"scrollIterations","browser", "browser_version", "os", "os_version", "mobileBrowserName","mobilePlatform","mobileDevice"})
    @BeforeTest
    public void setUpLocal(@Optional("") String scrollIterations,
                           @Optional("firefox") String browser,@Optional("")String browser_version,@Optional("")String os,
                           @Optional("")String os_version,
                           @Optional("")String mobileBrowserName,
                           @Optional("")String mobilePlatform,
                           @Optional("")String mobileDevice)throws IOException {
        this.setUp(browser,browser_version,os,os_version,mobileBrowserName,mobilePlatform,mobileDevice);
    }
    @Test
    public void ExitIntentTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver, true, propertyValues);
        mainPage.clickOnMenuElement(exitIntent);
        ExitIntentPage exitIntentPage = new ExitIntentPage(driver, false, propertyValues);
        exitIntentPage.checkExitIntent(-200);
        Thread.sleep(2000);
    }
}
