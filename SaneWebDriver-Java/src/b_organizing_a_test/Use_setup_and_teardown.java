package b_organizing_a_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/* TestInstance(Lifecycle.PER_CLASS) enables use of
 *   @BeforeClass on non-static methods.
 *   See discussion on how JUnit handles test class lifecycle at
 *   https://stackoverflow.com/questions/1052577/why-must-junits-fixturesetup-be-static 
 */
    @TestInstance(Lifecycle.PER_CLASS)
    public class Use_setup_and_teardown
    {
        static WebDriver browser;
        static WebDriverWait wait;
        
        @BeforeAll
        public void run_once_before_anything_else_in_this_fixture()
        {
        	System.setProperty("webdriver.gecko.driver", "libs/geckodriver");

        	browser = new FirefoxDriver();
            wait = new WebDriverWait(browser, 30);

            browser.get("http://jhdemos.azurewebsites.net/KendoGrid.html");
        }

        @AfterAll
        public void run_once_after_everything_else_in_this_fixture()
        {
            browser.quit();
        }

        @Test
        public void grid_appears_on_page()
        {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("grid")));
            
            WebElement grid = browser.findElement(By.id("grid"));
            assertNotNull(grid);
        }
        
        @Test
        public void grid_populates_with_rows()
        {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr")));
            List<WebElement> rows = browser.findElements(By.xpath("//tbody/tr"));
            assertNotNull(rows);
        }

        @Test
        public void create_button_displays()
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("create_btn")));
            WebElement create = browser.findElement(By.id("create_btn"));
            assertTrue(create.isDisplayed());
        }
    }

