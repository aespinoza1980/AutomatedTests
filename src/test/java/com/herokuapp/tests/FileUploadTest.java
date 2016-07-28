package com.herokuapp.tests;
import com.herokuapp.pages.FileUploadPage;
import com.herokuapp.pages.MainPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

/**
 * Created by Alexis Espinoza on 7/28/16.
 */
public class FileUploadTest extends BaseTest {
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
    public void loginLogOut() throws InterruptedException,AWTException {
        MainPage mainPage = new MainPage(driver, true, propertyValues);
        mainPage.clickOnMenuElement(fileUpload);
        FileUploadPage fileUploadPage = new FileUploadPage(driver, false, propertyValues,System.getProperty("user.dir") + "/src/test/resources/files/fileToUpload.txt");
        fileUploadPage.fileUpload();
        fileUploadPage.checkFileUploaded();
        Thread.sleep(1000);
        close();
    }
}
