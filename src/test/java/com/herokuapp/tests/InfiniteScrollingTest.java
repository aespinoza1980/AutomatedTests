package com.herokuapp.tests;

import com.herokuapp.pages.InfiniteScrollingPage;
import com.herokuapp.pages.MainPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Alexis Espinoza on 7/21/16.
 */
public class InfiniteScrollingTest extends BaseTest{
    private int scrollIterations;
    @Parameters({"scrollIterations","browser", "browser_version", "os", "os_version", "mobileBrowserName","mobilePlatform","mobileDevice"})
    @BeforeTest
    public void setUpLocal(@Optional("") String scrollIterations,
                           @Optional("firefox") String browser,@Optional("")String browser_version,@Optional("")String os,
                           @Optional("")String os_version,
                           @Optional("")String mobileBrowserName,
                           @Optional("")String mobilePlatform,
                           @Optional("")String mobileDevice)throws IOException {
        this.setUp(browser,browser_version,os,os_version,mobileBrowserName,mobilePlatform,mobileDevice);
        if(!scrollIterations.isEmpty()) {
            this.scrollIterations = Integer.valueOf(scrollIterations);
        } else {
            this.scrollIterations = 10;
        }

    }
    @Test
    public void InfiniteScrolling() throws InterruptedException {
        MainPage mainPage = new MainPage(driver, true, propertyValues);
        mainPage.clickOnMenuElement(infiniteScroll);
        InfiniteScrollingPage infiniteScrollingPage = new InfiniteScrollingPage(driver, false, propertyValues);
        infiniteScrollingPage.scrollDown(scrollIterations);
        Thread.sleep(2000);
    }
}
