package com.herokuapp.tests;

import com.herokuapp.pages.DragNDropPage;
import com.herokuapp.pages.MainPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Alexis Espinoza on 7/19/16.
 */
public class DragNDropTest extends BaseTest  {
    @Parameters({"browser" })
    @BeforeTest
    public void setUpLocal(@Optional("firefox") String browser)throws IOException {
        this.setUp(browser);
    }
    @Test
    public void DragNDrop() throws InterruptedException {
        MainPage mainPage = new MainPage(driver, true, propertyValues);
        mainPage.clickOnMenuElement("Drag and Drop");
        DragNDropPage dragNDropPage = new DragNDropPage(driver, true, propertyValues);
        Thread.sleep(2000);
        dragNDropPage.DragNDrop("#column-a", "#column-b");
        System.out.println("Dragged box A to box B");
        Thread.sleep(2000);
        dragNDropPage.DragNDrop("#column-b", "#column-a");//Drag it back to how it was
        System.out.println("Dragged box B back to where it was");
        Thread.sleep(2000);
        close();
    }


}
