package com.abc.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.abc.basesetup.TestBase;
import com.abc.stepdefinitions.CommonSteps;
import com.abc.utilities.ExcelReader;

public class LoginPage {

	WebDriver driver;
	WebDriverWait wait;

	ExcelReader excelReader;

	@FindBy(id = "txtUsername")
	WebElement userNameBox;

	@FindBy(id = "txtPassword")
	WebElement passwordBox;

	@FindBy(id = "btnLogin")
	WebElement loginButton;

	@FindBy(id = "welcome")
	WebElement userProfileIcon;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = TestBase.getWebDriverWait();
	}

	public boolean loginToApplication() {
		boolean isLoginSuccess = false;
		excelReader = new ExcelReader(CommonSteps.row_number, CommonSteps.sheetName);
		userNameBox.sendKeys(CommonSteps.excelReader.fieldsAndValues.get("username"));
		passwordBox.sendKeys(CommonSteps.excelReader.fieldsAndValues.get("password"));
		loginButton.click();
		wait.until(ExpectedConditions.visibilityOf(userProfileIcon));
		isLoginSuccess = userProfileIcon.isDisplayed();
		return isLoginSuccess;
	}

}
