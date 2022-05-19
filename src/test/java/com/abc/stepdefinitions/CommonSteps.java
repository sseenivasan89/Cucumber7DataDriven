package com.abc.stepdefinitions;


import com.abc.basesetup.TestBase;
import com.abc.utilities.ExcelReader;

import io.cucumber.java.en.Given;

public class CommonSteps {
	
	public static ExcelReader excelReader;
	public static String row_number;
	public static String sheetName;
	
	TestBase testBase = new TestBase();
	
	@Given("get data from datasheet with {string} and {string}")
	public void get_data_from_datasheet_with_and(String row_number, String sheetName) {
		excelReader = new ExcelReader(row_number, sheetName);
		this.row_number = row_number;
		this.sheetName = sheetName;

	}
}
