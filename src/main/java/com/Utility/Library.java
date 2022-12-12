package com.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

public class Library {

	public static ExtentTest test;
	public static WebDriver driver;

	public static void Custom_Sendkeys(WebElement element,String value) {
		try {
		element.sendKeys(value);
		
	}	
	    catch (Exception e) {
	    	System.out.println(e.getMessage());
	    }	
	}
	
	
	public static void Custom_Click(WebElement element) {
		try {
		element.click();
		}
		 catch (Exception e) {
		    	System.out.println(e.getMessage());
		    }	
		
	}	
}
