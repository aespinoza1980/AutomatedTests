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
            String IEDriver        = prop.getProperty("IEDriver");
            result = mainPage.trim() + ','  + IEDriver;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return result;
    }
}
