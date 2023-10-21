package com.abc.utilities;

import java.util.Base64;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utility {
	
	//element highlighter
	public static void highLighterMethod(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		js.executeScript("arguments[0].setAttribute('style', 'border: solid 2px white')", element);
	}

	
	//encryption
	static String password = "Abc@123";
	static byte[] encrypt; static byte[] decrypt;

	public static void encryptPassword() {
		encrypt = Base64.getEncoder().encode(password.getBytes());
		System.out.println(new String(encrypt));
	}

	//decryption
	public static void decrypt() {
		decrypt = Base64.getDecoder().decode(encrypt);
		System.out.println(new String(decrypt));
	}
	
	public static void main(String[] args) {
		encryptPassword();
		decrypt();
	}
}
