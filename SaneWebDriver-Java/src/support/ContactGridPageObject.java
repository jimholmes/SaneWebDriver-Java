package support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/* TestInstance(Lifecycle.PER_CLASS) enables use of
 *   @BeforeClass on non-static methods.
 *   See discussion on how JUnit handles test class lifecycle at
 *   https://stackoverflow.com/questions/1052577/why-must-junits-fixturesetup-be-static 
 */

    public class ContactGridPageObject
    {
        public static String GRID_ID = "grid";
        public static String CREATE_BTN_ID = "create_btn";

        public WebElement GetContactGrid(WebDriver browser)
        {
            return browser.findElement(By.id(GRID_ID));
        }

        public WebElement GetCreateButton(WebDriver browser)
        {
            return browser.findElement(By.id(CREATE_BTN_ID));
        }

        public WebElement GetGridRowById(WebDriver browser, String rowId)
        {
            return browser.findElement(By.id(rowId));
        }

        /*
         * Grid as currently configured appends contact's LName to the dynamically
         * generated ID, in the form of
         *              48-Holmes
         * Ergo, we can use the CSS selector id$="Holmes" to match. Yay.
         */
        public WebElement GetGridRowByContactName(WebDriver browser, String contactName)
        {
            String selector = "tr[id$='" + contactName + "']";
            return browser.findElement(By.cssSelector(selector));
        }

        public WebElement GetRowByRowTextContent (WebDriver browser, String contentText)
        {
            String contentxpath = "//tbody/tr[contains(.," + contentText + ")]";
            return browser.findElement(By.xpath(contentxpath));
        }

        public Boolean WaitUntilGridIsPopulatedWithRows(WebDriver browser)
        {
            WebDriverWait wait = new WebDriverWait(browser, 30);
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//tbody/tr")));

            return true;
        }
    }

