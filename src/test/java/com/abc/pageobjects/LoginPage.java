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
import com.abc.utilities.Utility;

public class LoginPage {

	WebDriver driver;
	WebDriverWait wait;

	ExcelReader excelReader;

	@FindBy(name = "username")
	WebElement userNameBox;

	@FindBy(name = "password")
	WebElement passwordBox;

	@FindBy(xpath = "//*[@type='submit']")
	WebElement loginButton;

	@FindBy(xpath = "//*[@class='oxd-userdropdown']")
	WebElement userProfileIcon;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = TestBase.getWebDriverWait();
	}

	public boolean loginToApplication()  {
		boolean isLoginSuccess = false;
		excelReader = new ExcelReader(CommonSteps.row_number, CommonSteps.sheetName);
		Utility.highLighterMethod(driver, userNameBox);
		userNameBox.sendKeys(CommonSteps.excelReader.fieldsAndValues.get("username"));
		Utility.highLighterMethod(driver, passwordBox);
		passwordBox.sendKeys(CommonSteps.excelReader.fieldsAndValues.get("password"));
		Utility.highLighterMethod(driver, loginButton);
		loginButton.click();
		wait.until(ExpectedConditions.visibilityOf(userProfileIcon));
		isLoginSuccess = userProfileIcon.isDisplayed();
		return isLoginSuccess;
	}

}
