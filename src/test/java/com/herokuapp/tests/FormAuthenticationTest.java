package com.herokuapp.tests;

import com.herokuapp.pages.FormAuthenticationPage;
import com.herokuapp.pages.MainPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Alexis Espinoza on 7/25/16.
 */
public class FormAuthenticationTest extends BaseTest{
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
    public void loginLogOut() throws InterruptedException {
        MainPage mainPage = new MainPage(driver, true, propertyValues);
        mainPage.clickOnMenuElement(formAuthentication);
        FormAuthenticationPage formAuthenticationTest = new FormAuthenticationPage(driver, false, propertyValues);
        formAuthenticationTest.formAuthentication(usernameForm,passwordForm);
        formAuthenticationTest.secureArea();
        formAuthenticationTest.checkTopMessage("You logged out of the secure area!");
        Thread.sleep(1000);
    }
    @Test(dependsOnMethods = "loginLogOut")
    public void failedLoginLogOut() throws InterruptedException {
        FormAuthenticationPage formAuthenticationTest = new FormAuthenticationPage(driver, false, propertyValues);
        formAuthenticationTest.formAuthentication(usernameForm, "FailedPassword");
        formAuthenticationTest.checkTopMessage("Your password is invalid!");
        formAuthenticationTest.formAuthentication("FailedUsername", "FailedPassword");
        formAuthenticationTest.checkTopMessage("Your username is invalid!");
        Thread.sleep(1000);
        close();
    }
}
