package com.abc.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.abc.basesetup.TestBase;
import com.abc.stepdefinitions.CommonSteps;
import com.abc.utilities.Utility;

public class AdminPage {
	
	WebDriver driver;
	WebDriverWait wait;

	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = TestBase.getWebDriverWait();
	}
	
	@FindBy(xpath = "//*[@class='oxd-main-menu']//*[text()='Admin']")
	WebElement adminMenu;
	
	@FindBy(xpath = "//*[text()='Username']//parent::div/parent::div/div/input")
	WebElement usernameSearchBox;
	
	@FindBy(xpath = "//*[@type='submit']")
	WebElement searchButton;
	
	@FindBy(xpath = "//*[@class='oxd-table']//*[@class='oxd-table-body']//div[2]/div")
	WebElement searchResultUsername;
	
	@FindBy(xpath = "//*[@type='button']")
	WebElement resetButton;
	
	public void navigateToAdminPage() {
		click(adminMenu);
	}
	
	public void searchForUser() {
		usernameSearchBox.sendKeys(CommonSteps.excelReader.fieldsAndValues.get("user"));
		click(searchButton);
	}
	
	public boolean checkSearchResult() throws Exception {
		Thread.sleep(1000);
		return wait.until(ExpectedConditions.visibilityOf(searchResultUsername))
		.getText()
		.equalsIgnoreCase(CommonSteps.excelReader.fieldsAndValues.get("user")) ? true : false;
	}
	
	public void clearResults() {
		click(resetButton);
	}
	
	public void click(WebElement element) {
		Utility.highLighterMethod(driver, element);
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
}
