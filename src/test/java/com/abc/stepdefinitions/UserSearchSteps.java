package com.abc.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.abc.basesetup.TestBase;
import com.abc.pageobjects.AdminPage;
import com.abc.pageobjects.CommonPages;
import com.abc.pageobjects.LoginPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class UserSearchSteps {
	
	WebDriver driver;
	WebDriverWait wait;
	
	TestBase testBase;
	AdminPage adminPage;
		
	@When("User navigate to admin page")
	public void user_navigate_to_admin_page() {
		testBase = new TestBase();
		driver = testBase.getDriver();
		adminPage = new AdminPage(driver);
		adminPage.navigateToAdminPage();
	}
	
	@Then("User search for username")
	public void user_search_for_username() {
		adminPage.searchForUser();
	}
	
	@Then("User verify the search results")
	public void user_verify_the_search_results() throws Exception {
		Assert.assertEquals(true, adminPage.checkSearchResult());
	}
	
	@Then("User clear the search results")
	public void user_clear_the_search_results() {
		adminPage.clearResults();
	}

}
