package com.herokuapp.tests;

import com.herokuapp.pages.MainPage;
import org.testng.annotations.*;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

/**
 * Created by Alexis Espinoza on 7/21/16.
 */
public class AuthenticationTest extends BaseTest{
    private String user;
    private String pass;

    @Parameters({"browser", "browser_version", "os", "os_version", "mobileBrowserName","mobilePlatform","mobileDevice", "user", "pass"})
    @BeforeTest
    public void setUpLocal(@Optional("firefox") String browser,@Optional("")String browser_version,
                           @Optional("")String os, @Optional("")String os_version,
                           @Optional("")String mobileBrowserName,
                           @Optional("")String mobilePlatform,
                           @Optional("")String mobileDevice,
                           @Optional("") String user, @Optional("") String pass)throws IOException {
        this.setUp(browser,browser_version,os,os_version,mobileBrowserName,mobilePlatform,mobileDevice);
        if(user.isEmpty()) {
            this.user = "admin";
        } else {
            this.user = user;
        }
        if(pass.isEmpty()) {
            this.pass = "admin";
        } else {
            this.pass = pass;
        }

    }
    @Test
    public void successfulAuthentication() throws InterruptedException{
        MainPage mainPage = new MainPage(driver, true, propertyValues);
        mainPage.clickOnMenuElement(basicAuth);
        mainPage.clickOnAuthenticate(user,pass);
        assertEquals(propertyValues[0]+"basic_auth", driver.getCurrentUrl());
        Thread.sleep(2000);
        close();
    }
}
