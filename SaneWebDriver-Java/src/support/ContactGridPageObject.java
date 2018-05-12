package support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



    public class ContactGridPageObject
    {
    	public static String GRID_ID = "grid";
        public static String CREATE_BTN_ID = "create_btn";

        public WebElement CreateButton;

        private WebDriver browser;

        public ContactGridPageObject (WebDriver browser)
        {
            this.browser = browser;
            WebDriverWait wait = new WebDriverWait(browser,30);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id(CREATE_BTN_ID)));
            CreateButton = browser.findElement(By.id(CREATE_BTN_ID));
        }

        public WebElement getContactGrid()
        {
            return browser.findElement(By.id(GRID_ID));
        }

        public WebElement getCreateButton()
        {
            return browser.findElement(By.id(CREATE_BTN_ID));
        }

        public ContactPopUpPageObject getContactPopUp()
        {
            CreateButton.click();
            ContactPopUpPageObject popup =  
                new ContactPopUpPageObject(browser);
            return popup;
        }

        public WebElement getGridRowById(String rowId)
        {
            return browser.findElement(By.id(rowId));
        }

        /*
         * Grid as currently configured appends contact's LName to the dynamically
         * generated ID, in the form of
         *              48-Holmes
         * Ergo, we can use the CSS selector id$="Holmes" to match. Yay.
         */
        public WebElement getGridRowByIdSubStringContactName( String contactName)
        {
            String selector = "tr[id$='" + contactName + "']";
            return browser.findElement(By.cssSelector(selector));
        }

        public WebElement getRowByRowTextContent (String contentText)
        {
            String contentXpath = "//tbody/tr[contains(.," + contentText + ")]";
            return browser.findElement(By.xpath(contentXpath));
        }

        public Boolean waitUntilGridIsPopulatedWithRows(WebDriver browser)
        {
            WebDriverWait wait = new WebDriverWait(browser, 30000);
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//tbody/tr")));

            return true;
        }
    }

