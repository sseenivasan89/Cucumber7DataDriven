package com.abc.stepdefinitions;

import java.io.File;
import java.io.IOException;
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
	public void close(Scenario scenario) throws IOException {

		if (scenario.isFailed() == true) {

			String screenshotName = scenario.getName().replaceAll(" ", "_");
			TakesScreenshot ts = (TakesScreenshot) testBase.getDriver();

			// attach the screenshot to report
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", screenshotName);

			// save the screenshots in folder
			File sourcePath = ts.getScreenshotAs(OutputType.FILE);
			File destinationPath = new File(
					System.getProperty("user.dir") + "/FailedScreenshots/" + screenshotName + ".png");
			Files.copy(sourcePath, destinationPath);

		}
		testBase.getDriver().close();
		testBase.getDriver().quit();
	}

}
