package com.herokuapp.tests;

import com.herokuapp.pages.MainPage;
import com.herokuapp.pages.FloatingMenuPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Alexis Espinoza on 7/29/16.
 */
public class FloatingMenuTest extends BaseTest {
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
    public void FloatingMenuTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver, true, propertyValues);
        mainPage.clickOnMenuElement(floatingMenu);
        FloatingMenuPage floatingMenuPage = new FloatingMenuPage(driver, false, propertyValues);
        floatingMenuPage.checkTabsMenu();
        floatingMenuPage.scrollDown(2350);
        Thread.sleep(1000);
        floatingMenuPage.checkTabsMenu();
        floatingMenuPage.scrollDown(1150);
        Thread.sleep(1000);
        floatingMenuPage.checkTabsMenu();
        Thread.sleep(1000);
    }
}
