package c_starting_to_structure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import support.ContactDataObject;
import support.ContactGridPageObject;
import support.ContactPopUpPageObject;
import support.Settings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/*
 * This class shows making use of setup and teardown methods to sort out
 * parts of functionality.
 * 
 * The test itself is still rather messy and should have data setup 
 * handled elsewhere -- but you'll see that in the API examples!
 */
@TestInstance(Lifecycle.PER_CLASS)
class When_creating_a_contact {

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
     public void teardown()
     {
         browser.quit();
     }

     @Test
     public void create_contact_appears_on_grid()
     {
         ContactDataObject contact = new ContactDataObject();
         contact.setCompany("Guidepost Systems LLC");
         contact.setRegion("Oregon");
         contact.setLname("Holmes");
         contact.setFname("Lydia");

         ContactGridPageObject gridPage = new ContactGridPageObject(browser);
         ContactPopUpPageObject editWindow = gridPage.getContactPopUp();

         editWindow.setCompany(contact.getCompany());
         editWindow.setRegion(contact.getRegion());
         editWindow.setLName(contact.getLname());
         editWindow.setFName(contact.getFname());
         editWindow.UpdateButton.click();
         String testXPath = "//tbody/tr[contains(.,'Lydia')]";
         wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(testXPath)));
         assertNotNull(gridPage.getRowByRowTextContent("Lydia"));
     }

}
