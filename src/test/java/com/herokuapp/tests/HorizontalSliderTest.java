package com.herokuapp.tests;

import com.herokuapp.pages.HorizontalSliderPage;
import com.herokuapp.pages.MainPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.IOException;

/**
 * Created by Alexis Espinoza on 7/20/16.
 */
public class HorizontalSliderTest extends BaseTest{
    @Parameters({"browser" })
    @BeforeTest
    public void setUpLocal(@Optional("firefox") String browser)throws IOException {
        this.setUp(browser);
    }
    @Test
    public void HorizontalSlider() throws InterruptedException {
        MainPage mainPage = new MainPage(driver, true, propertyValues);
        mainPage.clickOnMenuElement(horizontalSlider);
        HorizontalSliderPage horizontalSliderPage = new HorizontalSliderPage(driver, false, propertyValues);
        horizontalSliderPage.moveHorizontalSlider("#content > div > div > input[type=\"range\"]");
        Thread.sleep(2000);
        close();
    }

}
