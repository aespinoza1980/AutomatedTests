package com.herokuapp.tests;

import com.herokuapp.properties.Property;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alexis Espinoza on 6/30/16.
 */
public class BaseTest {
    protected WebDriver driver;
    protected String mainPage         = null;
    protected String[] propertyValues;
    protected void setUp(String browser)throws IOException {
        Property properties = new Property();
        propertyValues = properties.getPropValues().split(",");
        String IEDriver= propertyValues[1];
        if(browser.equals("IE")) {
            System.setProperty("webdriver.ie.driver", IEDriver);

            // Launch InternetExplorerDriver
            driver = new InternetExplorerDriver();

        }else if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver");//"/usr/bin/google-chrome"
            System.out.println(System.getProperty("webdriver.chrome.driver"));
            driver = new ChromeDriver();
        }else{
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage        = propertyValues[0];

    }


    @AfterTest
    public void close() {
        //Shutdown the browser
        driver.quit();
    }
}