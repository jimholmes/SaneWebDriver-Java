package A_First_Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.Is.is;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

    
    public class A_Initial_version
    {
        @Test
        public void grid_appears_on_page_and_has_rows()
        {
            // ARRANGE
            WebDriver browser = new FirefoxDriver();
            browser.get("http://demosite.com/KendoGrid.html");
            //browser.Navigate().GoToUrl("http://jhdemos.azurewebsites.net/KendoGrid.html");

            // ACT
            WebElement grid = browser.findElement(By.id("grid"));
            // ASSERT
            assertNotNull(grid);

            List<WebElement> rows = browser.findElements(By.xpath("//tbody/tr"));
            assertThat(rows.isEmpty(), is(false));

            browser.quit();
        }
    }
