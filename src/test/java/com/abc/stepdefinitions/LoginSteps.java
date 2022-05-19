package com.abc.stepdefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.abc.basesetup.TestBase;
import com.abc.pageobjects.CommonPages;
import com.abc.pageobjects.LoginPage;

import io.cucumber.java.en.Then;

public class LoginSteps {

	WebDriver driver;

	LoginPage loginPage;
	TestBase testBase;
	CommonPages commonPages;

	@Then("login to the application")
	public void login_to_the_application() {
		testBase = new TestBase();
		driver = testBase.getDriver();
		loginPage = new LoginPage(driver);
		commonPages = new CommonPages(driver);
		commonPages.launchApplication();
		assertEquals(loginPage.loginToApplication(), false);
	}

}
