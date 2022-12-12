package com.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPagePom {

	//Identifying the elements present on loginpage
	
		@FindBy(how=How.XPATH,using="//input[@name='username']")
		private WebElement username;
		
		@FindBy(how=How.XPATH,using="//input[@name='password']")
		private WebElement password;
		
		@FindBy(how=How.XPATH,using="//button[@type='submit']")
		private WebElement btn_login;
		

		// getter methods for the elements
		
		public WebElement getusername() {
			return username;
		}

		public WebElement getpassword() {
			return password;
		}
		
		public WebElement btn_login() {
			return btn_login;
		}
		
		
}
