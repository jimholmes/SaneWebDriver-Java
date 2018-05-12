package a_first_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;


    public class B_Async_solved_with_wait
    {
        @Test
        public void grid_appears_on_page_and_has_rows() 
        {
        	System.setProperty("webdriver.gecko.driver", "libs/geckodriver");
            WebDriver browser = new FirefoxDriver();
            //browser.get("http://demosite.com/KendoGrid.html");
            browser.get("http://jhdemos.azurewebsites.net/KendoGrid.html");

            WebElement grid = browser.findElement(By.id("grid"));
            assertNotNull(grid);

            //WebDriverWait causes the test to pause until the rows in the grid
            //  load, or the timeout of 30 seconds is reached.
            WebDriverWait wait = new WebDriverWait(browser, 30);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr")));
            List<WebElement> rows = browser.findElements(By.xpath("//tbody/tr"));
            
            assertFalse(rows.isEmpty());

            browser.quit();
        }
    }
