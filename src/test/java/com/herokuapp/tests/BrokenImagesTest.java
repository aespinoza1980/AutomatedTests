package com.herokuapp.tests;

import com.herokuapp.pages.BrokenImagesPage;
import com.herokuapp.pages.MainPage;
import com.herokuapp.pages.TablesPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by Alexis Espinoza on 7/26/16.
 */
public class BrokenImagesTest extends BaseTest {
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
    public void BrokenImages() throws InterruptedException {
        MainPage mainPage = new MainPage(driver, true, propertyValues);
        mainPage.clickOnMenuElement(brokenImages);
        BrokenImagesPage brokenImagesPage = new BrokenImagesPage(driver, false, propertyValues);
        brokenImagesPage.checkBrokenImages();
        Thread.sleep(2000);
        close();
    }
}
