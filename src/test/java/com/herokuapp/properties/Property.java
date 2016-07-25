package com.herokuapp.properties;
/**
 * Created by Alexis Espinoza on 11/13/15.
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class Property {
    String result = "";
    InputStream inputStream;
    public String getPropValues() throws IOException {
        try {
            java.util.Properties prop = new java.util.Properties();
            String propFileName = "config.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            Date time = new Date(System.currentTimeMillis());
            // getlinkAssertion the property value and print its out
            String mainPage        = prop.getProperty("mainPage");

            result = mainPage.trim() + ','  + prop.getProperty("aBTesting") + ','  + prop.getProperty("basicAuth")
                    + ','  + prop.getProperty("brokenImages") + ','  + prop.getProperty("challengingDOM") + ','  + prop.getProperty("checkboxes")
                    + ','  + prop.getProperty("contextMenu") + ','  + prop.getProperty("disappearingElements") + ','  + prop.getProperty("dragandDrop")
                    + ','  + prop.getProperty("dropdown") + ','  + prop.getProperty("dynamicContent") + ','  + prop.getProperty("dynamicControls")
                    + ','  + prop.getProperty("dynamicLoading") + ','  + prop.getProperty("exitIntent") + ','  + prop.getProperty("fileDownload")
                    + ','  + prop.getProperty("fileUpload") + ','  + prop.getProperty("floatingMenu") + ','  + prop.getProperty("forgotPassword")
                    + ','  + prop.getProperty("formAuthentication") + ','  + prop.getProperty("frames") + ','  + prop.getProperty("geolocation")
                    + ','  + prop.getProperty("horizontalSlider") + ','  + prop.getProperty("hovers") + ','  + prop.getProperty("infiniteScroll")
                    + ','  + prop.getProperty("jQueryUIMenus") + ','  + prop.getProperty("javaScriptAlerts") + ','  + prop.getProperty("javaScriptOnloadEventError")
                    + ','  + prop.getProperty("keyPresses") + ','  + prop.getProperty("largeNDeepDOM") + ','  + prop.getProperty("multipleWindows")
                    + ','  + prop.getProperty("nestedFrames") + ','  + prop.getProperty("notificationMessages") + ','  + prop.getProperty("redirectLink")
                    + ','  + prop.getProperty("secureFileDownload") + ','  + prop.getProperty("shiftingContent") + ','  + prop.getProperty("slowResources")
                    + ','  + prop.getProperty("sortableDataTables")+ ','  + prop.getProperty("statusCodes")+ ','  + prop.getProperty("typos")
                    + ','  + prop.getProperty("WYSIWYGEditor")+ ','  + prop.getProperty("usernameForm")+ ','  + prop.getProperty("passwordForm");

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return result;
    }
}
