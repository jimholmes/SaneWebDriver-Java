package a_first_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.jupiter.api.Test;

    public class C_No_asserts
    {
        @Test
        public void grid_appears_on_page_and_has_rows()
        {
        	System.setProperty("webdriver.gecko.driver", "libs/geckodriver");

            WebDriver browser = new FirefoxDriver();
            browser.get("http://jhdemos.azurewebsites.net/KendoGrid.html");

            WebDriverWait wait = new WebDriverWait(browser, 30);
            
            /* Note there are no Asserts! NUnit tests will pass and show green
             *  as long as there are no Assert failures or exceptions.
             *  This test will pass unless either wait.Until condition throws
             *  an exception, meaning either the grid doesn't display or
             *  rows don't populate.
             *  
             *  I don't particularly care for this style as it takes me a bit of
             *  extra time to mentally unwind what's going on with the test.
             *  I prefer an explicit "Assert" for readability.
             */
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("grid")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr")));

            browser.quit();
        }
    }
