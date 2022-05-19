package com.abc.stepdefinitions;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.abc.basesetup.TestBase;
import com.google.common.io.Files;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	TestBase testBase;
	CommonSteps commonSteps;
	
	@Before
	public void initialization() {
		testBase = new TestBase();
		testBase.selectBrowser();
	}
	
	@After
	public void close(Scenario scenario) {
		if (scenario.isFailed() == true) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				TakesScreenshot ts = (TakesScreenshot) testBase.getDriver();
				File sourcePath = ts.getScreenshotAs(OutputType.FILE);
				File destinationPath = new File(
						System.getProperty("user.dir") + "/FailedScreenshots/"+screenshotName+".png");
				Files.copy(sourcePath, destinationPath);
			} catch (IOException e) {
			}
		}
		testBase.getDriver().close();
		
	}

}
