package com.herokuapp.tests;

import com.herokuapp.properties.Property;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alexis Espinoza on 6/30/16.
 */
public class BaseTest {
    protected WebDriver driver;
    protected String mainPage                        = null;
    protected String aBTesting                       = null;
    protected String basicAuth                       = null;
    protected String brokenImages                    = null;
    protected String challengingDOM                  = null;
    protected String checkboxes                      = null;
    protected String contextMenu                     = null;
    protected String disappearingElements            = null;
    protected String dragandDrop                     = null;
    protected String dropdown                        = null;
    protected String dynamicContent                  = null;
    protected String dynamicControls                 = null;
    protected String dynamicLoading                  = null;
    protected String exitIntent                      = null;
    protected String fileDownload                    = null;
    protected String fileUpload                      = null;
    protected String floatingMenu                    = null;
    protected String forgotPassword                  = null;
    protected String formAuthentication              = null;
    protected String frames                          = null;
    protected String geolocation                     = null;
    protected String horizontalSlider                = null;
    protected String hovers                          = null;
    protected String infiniteScroll                  = null;
    protected String jQueryUIMenus                   = null;
    protected String javaScriptAlerts                = null;
    protected String javaScriptOnloadEventError      = null;
    protected String keyPresses                      = null;
    protected String largeNDeepDOM                   = null;
    protected String multipleWindows                 = null;
    protected String nestedFrames                    = null;
    protected String notificationMessages            = null;
    protected String redirectLink                    = null;
    protected String secureFileDownload              = null;
    protected String shiftingContent                 = null;
    protected String slowResources                   = null;
    protected String sortableDataTables              = null;
    protected String statusCodes                     = null;
    protected String typos                           = null;
    protected String WYSIWYGEditor                   = null;
    protected String[] propertyValues;
    protected String browser;
    protected String browser_version                 = "6.0";
    protected String os                              = "Windows";
    protected String os_version                      = "XP";
    protected String mobileBrowserName;
    protected String mobilePlatform;
    protected String mobileDevice;
    private final String USERNAME                    = "yourbrowserstackuser";
    private final String AUTOMATE_KEY                = "yourbrowserstackpass";
    private final String URL                         = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


    private HashMap<String, ArrayList<String>> osSetup() {
        HashMap<String, ArrayList<String>> operatingSystem = new HashMap<String, ArrayList<String>>();
        String [] osSupported         = {"Windows", "OS X"};
        String [] windows_os_version  = {"XP","7","8","8.1","10"};
        String [] osx_os_version      = {"El Capitan","Yosemite","Mavericks","Mountain Lion","Lion","Snow Leopard"};
        for(int i = 0; i < osSupported.length; i++) {
            operatingSystem.put(osSupported[i],new ArrayList<String>());
            switch (i) {
                case 0:  for (int j = 0; j < windows_os_version.length; j++) {
                                operatingSystem.get(osSupported[i]).add(windows_os_version[j]);
                         }
                         break;
                case 1:  for (int j = 0; j < osx_os_version.length; j++) {
                            operatingSystem.get(osSupported[i]).add(osx_os_version[j]);
                        }
                        break;
            }
        }
        return operatingSystem;
    }
    protected void setUp(String browser, String browser_version, String os, String os_version,
                         String mobileBrowserName, String mobilePlatform, String mobileDevice)throws IOException {
        Property properties = new Property();
        HashMap<String, ArrayList<String>> osDesktop = osSetup();
        propertyValues = properties.getPropValues().split(",");
        this.browser         = browser;
        this.browser_version    = browser_version;
        this.os                 = os;
        this.os_version         = os_version;
        this.mobileBrowserName  = mobileBrowserName;
        this.mobilePlatform     = mobilePlatform;
        this.mobileDevice       = mobileDevice;
        //Set capabilities for mobile in BrowserStack
        if(!this.mobileBrowserName.isEmpty()) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browserName", this.mobileBrowserName);
            caps.setCapability("platform", this.mobilePlatform);
            caps.setCapability("device", this.mobileDevice);
            driver = new RemoteWebDriver(new URL(URL), caps);
        } else {
            if(!this.browser_version.isEmpty()) {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("browser", this.browser);
                caps.setCapability("browser_version", this.browser_version);
                caps.setCapability("os", this.os);
                caps.setCapability("os_version", this.os_version);
                caps.setCapability("browserstack.debug", "true");
                driver = new RemoteWebDriver(new URL(URL), caps);
            } else { // using local drivers
                if(this.browser.equals("IE")) {
                    System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer.exe");
                // Launch InternetExplorerDriver
                    driver = new InternetExplorerDriver();

                }else if(this.browser.equals("chrome")){
                    System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver");//"/usr/bin/google-chrome"
                    System.out.println(System.getProperty("webdriver.chrome.driver"));
                    driver = new ChromeDriver();
                }else{
                    driver = new FirefoxDriver();
                }
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        mainPage                    = propertyValues[0];
        aBTesting                   = propertyValues[1];
        basicAuth                   = propertyValues[2];
        brokenImages                = propertyValues[3];
        challengingDOM              = propertyValues[4];
        checkboxes                  = propertyValues[5];
        contextMenu                 = propertyValues[6];
        disappearingElements        = propertyValues[7];
        dragandDrop                 = propertyValues[8];
        dropdown                    = propertyValues[9];
        dynamicContent              = propertyValues[10];
        dynamicControls             = propertyValues[11];
        dynamicLoading              = propertyValues[12];
        exitIntent                  = propertyValues[13];
        fileDownload                = propertyValues[14];
        fileUpload                  = propertyValues[15];
        floatingMenu                = propertyValues[16];
        forgotPassword              = propertyValues[17];
        formAuthentication          = propertyValues[18];
        frames                      = propertyValues[19];
        geolocation                 = propertyValues[20];
        horizontalSlider            = propertyValues[21];
        hovers                      = propertyValues[22];
        infiniteScroll              = propertyValues[23];
        jQueryUIMenus               = propertyValues[24];
        javaScriptAlerts            = propertyValues[25];
        javaScriptOnloadEventError  = propertyValues[26];
        keyPresses                  = propertyValues[27];
        largeNDeepDOM               = propertyValues[28];
        multipleWindows             = propertyValues[29];
        nestedFrames                = propertyValues[30];
        notificationMessages        = propertyValues[31];
        redirectLink                = propertyValues[32];
        secureFileDownload          = propertyValues[33];
        shiftingContent             = propertyValues[34];
        slowResources               = propertyValues[35];
        sortableDataTables          = propertyValues[36];
        statusCodes                 = propertyValues[37];
        typos                       = propertyValues[38];
        WYSIWYGEditor               = propertyValues[39];
    }
    @AfterTest
     public void close() {
        //Shutdown the browser
        driver.quit();
    }
}