package A_First_Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.Is.is;

import static org.junit.Assert.assertThat;
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

            WebDriverWait wait = new WebDriverWait(browser, 30);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr")));
            List<WebElement> rows = browser.findElements(By.xpath("//tbody/tr"));
            
            assertThat(rows.isEmpty(), is(false));

            browser.quit();
        }
    }
