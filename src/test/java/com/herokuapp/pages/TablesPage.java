package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import static org.testng.Assert.assertEquals;

/**
 * Created by Alexis Espinoza on 7/23/16.
 */
public class TablesPage extends BasePage {
    public TablesPage(WebDriver driver, boolean navigate, String[] propertyValues){
        super (driver, navigate, propertyValues[0]+"tables", propertyValues, "Data Tables");
    }

    public void example1() throws InterruptedException {
        WebElement webElement;
        int i = 1;
        int j;
        String cssPathHeader = "#table1 > thead > tr > th.header.headerSortDown";
        int cont;
        boolean elementFound = true;
        String cssPath;
        while (elementFound) {
            cssPath = "#table1 > thead > tr > th:nth-child(" + i + ")";
            elementFound = isElementPresent(By.cssSelector(cssPath)); // continue test even if element is no there
            if (elementFound) {
                webElement = driver.findElement(By.cssSelector(cssPath));
                webElement.click();
                System.out.println("Clicked on header " + webElement.getText());
                System.out.println("'***************************************");
                cont = i - 1;
                checkTableRows(cont, 1);
                System.out.println("'***************************************");
                Thread.sleep(2000);
                webElement = driver.findElement(By.cssSelector(cssPathHeader));
                webElement.click();
                System.out.println("Clicked back again on header " + webElement.getText());
                System.out.println("'***************************************");
                checkTableRows(cont, 2);
                System.out.println("'***************************************");
                Thread.sleep(2000);
                i++;
            } else {
                System.out.println("This element header was not found: " + cssPath);
            }
        }
    }

    private void checkTableRows(int checkHeaderColumnNumber, int order) {
        String cssPath;
        WebElement webElement;
        int j = 1;
        int i = 0;
        boolean elementFound = true;
        ArrayList<String> columnElements = new ArrayList<String>();
        while(elementFound) {
            cssPath = "#table1 > tbody > tr:nth-child(" + j + ")";
             elementFound = isElementPresent(By.cssSelector(cssPath)); // continue test even if element is no there
            if (elementFound) {
                webElement = driver.findElement(By.cssSelector(cssPath));
                String [] elementSplit = webElement.getText().split(" ");
                columnElements.add(i,elementSplit[checkHeaderColumnNumber]);
                i++;
                System.out.println(webElement.getText());
            } else {
                System.out.println("This element was not found: " + cssPath);
            }
            j++;
        }
        assertEquals(true,checkIntegrityOfColumnElements(columnElements, order)); //assserting that the columns afetr click
    }
    /**

     *
     * @param  columnElements  Array of Column elements
     * @param  order ASC =1 DESC =2
     * @return  bool    the image at the specified URL
     *
     */
    private boolean checkIntegrityOfColumnElements(ArrayList<String> columnElements, int order) {
        boolean areElementsOrdered = true;
        int i = 0;
        while((i  < columnElements.size() -1) && (areElementsOrdered)) {
            ///Let's first check if we are talking about money
            if(columnElements.get(i).matches("^\\$(([1-9]\\d{0,2}(,\\d{3})*)|(([1-9]\\d*)?\\d))(\\.\\d\\d)?$")) {
                int firstAmount  = Integer.valueOf(columnElements.get(i).replaceAll("[$]|[.*']", ""));
                int secondAmount = Integer.valueOf(columnElements.get(i + 1).replaceAll("[$]|[.*]", ""));
                if(((order == 1)&&(firstAmount > secondAmount)) || ((order == 2)&&(secondAmount > firstAmount))) {
                    areElementsOrdered = false;
                }
            } else if((columnElements.get(i).compareTo(columnElements.get(i + 1)) != 0) &&
                    ((order == 1) && columnElements.get(i).compareTo(columnElements.get(i + 1)) > -1)
                    || ((order == 2) && columnElements.get(i).compareTo(columnElements.get(i + 1)) == -1)) {
                areElementsOrdered = false;
            }

            i++;
        }
        return areElementsOrdered;
    }

}
