package A_First_Tests;

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
            
            // Notice there are no asserts in this test. If either wait condition
            //  fails (the grid doesn't appear, the rows don't load) an
            //  Exception will be thrown, causing the test to fail.
            // You don't *NEED* asserts to make a test; however, I *prefer*
            //   to have them in there because it makes the test more explicit
            //   and readable. I don't write my tests without asserts.
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("grid")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr")));

            browser.quit();
        }
    }
