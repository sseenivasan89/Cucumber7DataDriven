package com.abc.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.abc.basesetup.TestBase;

public class CommonPages extends TestBase{

	WebDriver driver;
	WebDriverWait wait;
	

	public CommonPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = TestBase.getWebDriverWait();
	}
	
	public void launchApplication() {
		driver.get(TestBase.url);
	}
	
	
}
