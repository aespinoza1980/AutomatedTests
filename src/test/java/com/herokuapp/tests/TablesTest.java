package com.herokuapp.tests;


import com.herokuapp.pages.MainPage;
import com.herokuapp.pages.TablesPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.IOException;


/**
 * Created by Alexis Espinoza on 7/23/16.
 */
public class TablesTest extends BaseTest{
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
    public void Tables() throws InterruptedException {
        MainPage mainPage = new MainPage(driver, true, propertyValues);
        mainPage.clickOnMenuElement(sortableDataTables);
        TablesPage tablesPage = new TablesPage(driver, false, propertyValues);
        tablesPage.example1();
        Thread.sleep(2000);
        close();
    }
}
