package d_using_an_api;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import support.ContactDataObject;
import support.ContactGridPageObject;
import support.ContactPopUpPageObject;
import support.DataHelpers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class When_creating_a_contact {

	ContactDataObject testContact;
	WebDriver browser;
	WebDriverWait wait;

	@BeforeAll
	public void setup() {


		testContact = DataHelpers.Generate_random_contact();
		
		System.setProperty("webdriver.chrome.driver", "libs/chromedriver");
		browser = new ChromeDriver();
		browser.get("http://jhdemos.azurewebsites.net/KendoGrid.html");

		wait = new WebDriverWait(browser, 30);

		ContactGridPageObject page = new ContactGridPageObject(browser);
		ContactPopUpPageObject create = page.getContactPopUp();

		create.setCompany(testContact.getCompany());
		create.setRegion(testContact.getRegion());
		create.setLName(testContact.getLname());
		create.setFName(testContact.getFname());
		create.UpdateButton.click();
	}

	@AfterAll
	public void teardown() {
		DataHelpers.delete_contact_by_id(testContact);
		browser.quit();
	}

	@Test
	public void contact_shows_on_grid() {
		ContactGridPageObject page = new ContactGridPageObject(browser);
		WebElement row = 
				page.getGridRowByIdSubStringContactName(testContact.getLname());
		assertNotNull(row);

	}

	@Test
	public void contact_properly_stored_in_database() {
		ContactDataObject contactFromDb = DataHelpers.return_contact_by_id(testContact);
		assertEquals(contactFromDb.getRegion(), testContact.getRegion()); 
		assertEquals(contactFromDb.getCompany(), testContact.getCompany());
		assertEquals(contactFromDb.getLname(), testContact.getLname());
		assertEquals(contactFromDb.getFname(), testContact.getFname());

	}

}
