package support;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPopUpPageObject {
	private WebDriver browser;

	private WebElement region;
	private String REGION_NAME_TAG = "Region";

	private WebElement company;
	private String COMPANY_NAME_TAG = "Company";
	
	private WebElement lname;
	private String LNAME_NAME_TAG = "LName";
	
	private WebElement fname;
	private String FNAME_NAME_TAG = "FName";

	public WebElement UpdateButton;
	private static String UPDATE_BTN_XPATH = "//a[contains(@class,'k-grid-update')]";

	/*
	 * KendoGrid's editor popup has an odd input which requires a tab or focus event
	 * to actually update values on the grid. Each Property setter method calls
	 * SetFocusToField which WebDriver's Actions to focus on a different field,
	 * thereby causing KendoGrid to properly update.
	 * 
	 * This is the sort of stuff that comes from experience. And pain.
	 */
	public String getRegion() {
		return region.getText();
	}

	public void setRegion(String region) {
		this.region.sendKeys(region);
		this.region.sendKeys(Keys.TAB);
		//setFocusToField(company);
	}

	public String getCompany() {
		return company.getText();
	}

	public void setCompany(String company) {
		this.company.sendKeys(company);
		
		
		//inputTextToFieldViaJS(COMPANY_NAME_TAG, company);
		setFocusToField(region);
	}

	private void inputTextToFieldViaJS(String fieldNameAttribText, String text) {
		JavascriptExecutor exec = (JavascriptExecutor)browser;
		
		String scriptText = "document.getElementsByName('" + fieldNameAttribText +
				"')[0].value='"+text+"';";
		exec.executeScript(scriptText);
		
	}

	public String getLName() {
		return lname.getText();
	}

	public void setLName(String lname) {
		this.lname.sendKeys(lname);		
		this.lname.sendKeys(Keys.TAB);

		//setFocusToField(fname);
	}

	public String getFName() {
		return fname.getText();
	}

	public void setFName(String fname) {
		this.fname.sendKeys(fname);
		this.fname.sendKeys(Keys.TAB);
		//setFocusToField(lname);
	}

	public ContactPopUpPageObject(WebDriver browser) {
		this.browser = browser;

		WebDriverWait wait = new WebDriverWait(browser, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("k-window-titlebar")));

		region = browser.findElement(By.name(REGION_NAME_TAG));
		company = browser.findElement(By.name(COMPANY_NAME_TAG));
		lname = browser.findElement(By.name(LNAME_NAME_TAG));
		fname = browser.findElement(By.name(FNAME_NAME_TAG));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(UPDATE_BTN_XPATH)));
		UpdateButton = browser.findElement(By.xpath(UPDATE_BTN_XPATH));
	}

	// See comments above Setters in this class
	private void setFocusToField(WebElement field) {
		new Actions(browser).moveToElement(field).click().build().perform();
	}

}
