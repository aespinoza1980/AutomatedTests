package com.herokuapp.tests;

import com.herokuapp.pages.DragNDropPage;
import com.herokuapp.pages.HoverPage;
import com.herokuapp.pages.MainPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Alexis Espinoza on 7/19/16.
 */
public class HoverTest extends BaseTest{
    @Parameters({"browser", "browser_version", "os", "os_version", "mobileBrowserName","mobilePlatform","mobileDevice"})
    @BeforeTest
    public void setUpLocal(@Optional("firefox") String browser,@Optional("")String browser_version,@Optional("")String os,
                           @Optional("")String os_version,
                           @Optional("")String mobileBrowserName,
                           @Optional("")String mobilePlatform,
                           @Optional("")String mobileDevice)throws IOException {
        this.setUp(browser,browser_version,os,os_version,mobileBrowserName,mobilePlatform,mobileDevice);
    }
    @Test
    public void Hover() throws InterruptedException {
        MainPage mainPage = new MainPage(driver, true, propertyValues);
        mainPage.clickOnMenuElement(hovers);
        boolean click = false;
        int k = 3;
        String [] cssPath = {"#content > div > div:nth-child(" + k + ") > div > a"};
        int j = 1;
        for (int i = 0; i < 3; i++) {
            HoverPage HoverPage = new HoverPage(driver, click, propertyValues);
            HoverPage.Hover("#content > div > div:nth-child(" + k + ")");
            HoverPage.assertViewProfile(cssPath, "users/" + j);
            Thread.sleep(2000);
            k++;
            j++;
            cssPath    = new String[1];
            cssPath[0] = "#content > div > div:nth-child(" + k + ") > div > a";
            click = true;
        }
        close();
    }
}
