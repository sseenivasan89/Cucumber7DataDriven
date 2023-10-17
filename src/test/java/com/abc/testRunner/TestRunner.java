package com.abc.testRunner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.json.support.Status;
import net.masterthought.cucumber.presentation.PresentationMode;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "json:target/json/cucumber-report.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, 
		features = {"src/test/java/features" }, 
		glue = { "com/abc/stepdefinitions" }, 
		tags = "@smoke",
		dryRun = false, monochrome = true, publish =false)

public class TestRunner {
	@AfterClass
	public static void reportSetup() throws IOException {

		File reportOutputDirectory = new File("target");
		List<String> jsonFiles = new ArrayList<>();
		jsonFiles.add("target\\json\\cucumber-report.json");
		// jsonFiles.add("cucumber-report-2.json");

		String buildNumber = "1";
		String projectName = "My_Project_Name";

		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
		// optional configuration - check javadoc for details
		configuration.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
		// do not make scenario failed when step has status SKIPPED
		configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
		configuration.setBuildNumber(buildNumber);
		// addidtional metadata presented on main page
		configuration.addClassifications("Platform", "Windows");
		configuration.addClassifications("Browser", "Firefox");
		configuration.addClassifications("Branch", "release/1.0");
		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		Reportable result = reportBuilder.generateReports();

	}
}
