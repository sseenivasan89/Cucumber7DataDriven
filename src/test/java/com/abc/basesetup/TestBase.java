package com.abc.basesetup;

import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	static WebDriver driver;
	static WebDriverWait wait;
	Properties config;
	public static String url;
	
	public WebDriver selectBrowser() {

		config = new ConfigReader().readProperties();
		url = config.getProperty("url");

		String browserName = config.getProperty("browserName");

		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	public static WebDriverWait getWebDriverWait() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait;
	}

}
