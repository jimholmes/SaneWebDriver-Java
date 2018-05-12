package C_Starting_To_Structure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import support.ContactGridPageObject;
import support.Settings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/*
 * Page Objects and settings files let you keep separate responsibilities
 * out of your tests. Your tests shouldn't know a thing about the mechanics
 * of the page--how to find things, how to handle asynch, etc.
 * All of that info is stored in the ContactGridPageObject.
 * 
 * Similarly, using a Settings file (or similar concept) ensures your tests
 * aren't hardwired up to environment specifics. Your build system can update
 * files, environment settings, etc. for each run, and the Settings
 * will handle reading those specifics in.
 */

/* TestInstance(Lifecycle.PER_CLASS) enables use of
 *   @BeforeClass on non-static methods.
 *   See discussion on how JUnit handles test class lifecycle at
 *   https://stackoverflow.com/questions/1052577/why-must-junits-fixturesetup-be-static 
 */
    @TestInstance(Lifecycle.PER_CLASS)
    public class Using_page_objects_and_settings
    {
        WebDriver browser;
        WebDriverWait wait;

        @BeforeAll
        public void Setup()
        {
        	System.setProperty("webdriver.gecko.driver", "libs/geckodriver");
            browser = new FirefoxDriver();
            wait = new WebDriverWait(browser, 30);

            browser.get(Settings.GRID_URL);
        }

        @AfterAll
        public void Teardown()
        {
            browser.quit();
        }

        @Test
        public void grid_shows_on_page()
        {
            wait.until(ExpectedConditions.presenceOfElementLocated(
            		By.id(ContactGridPageObject.GRID_ID)));
        }

       
        @Test
        public void create_button_is_on_page()
        {
            wait.until(ExpectedConditions.presenceOfElementLocated(
            		By.id(ContactGridPageObject.CREATE_BTN_ID)));

        }

        @Test
        public void grid_is_populated()
        {
            ContactGridPageObject page = new ContactGridPageObject();

            //I'm not happy with this implementation right now. Need to rethink!
            assertTrue(page.WaitUntilGridIsPopulatedWithRows(browser));
        }

        //This test totally depends on knowing the test data set -- "Jim"
        // is part of the baseline dataset that would be loaded when the
        // overall test suite execution is started.
        @Test
        public void check_jim_is_on_page()
        {
            ContactGridPageObject page = new ContactGridPageObject();
            page.WaitUntilGridIsPopulatedWithRows(browser);
            assertNotNull(page.GetRowByRowTextContent(browser, "Holmes") );
        }
    }

