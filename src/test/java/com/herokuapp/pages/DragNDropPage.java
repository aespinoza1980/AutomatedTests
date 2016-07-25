package com.herokuapp.pages;

import org.openqa.selenium.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alexis Espinoza on 7/19/16.
 */
public class DragNDropPage extends BasePage{
    public DragNDropPage(WebDriver driver, boolean navigate, String[] propertyValues){
        super (driver, navigate, propertyValues[0]+"drag_and_drop", propertyValues, "Drag and Drop page");
    }
    public void DragNDrop (String source,String target) {
        try {
            String basePath = new File("").getAbsolutePath();
            final String JQUERY_LOAD_SCRIPT = (basePath + "/src/test/java/com/herokuapp/js/jquery_load_helper.js");
            String jQueryLoader = readFile(JQUERY_LOAD_SCRIPT);

            driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeAsyncScript(jQueryLoader);
            js.executeScript("jQuery(function($) { " + " $('input[name=\"q\"]').val('bada-bing').closest('form').submit(); "
                    + " }); ");
            String filePath = basePath + "/src/test/java/com/herokuapp/js/drag_and_drop_helper.js";
            StringBuffer buffer = new StringBuffer();
            String line;
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while((line = br.readLine())!=null)
                buffer.append(line);
            String javaScript = buffer.toString();
            javaScript = javaScript + "window.jQuery('" + source + "').simulateDragDrop({ dropTarget: '" + target + "'});";
            ((JavascriptExecutor)driver).executeScript(javaScript);

        }catch(Exception e){
        e.printStackTrace();
        }
    }

}
