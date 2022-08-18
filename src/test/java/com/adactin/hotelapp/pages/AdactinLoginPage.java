package com.adactin.hotelapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactin.hotelapp.tests.AdactinBase;

public class AdactinLoginPage extends AdactinBase{
	
	
	
	public AdactinLoginPage(WebDriver driver) {
		
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);

	}

		@FindBy(xpath = "//input[@id='username']")
		WebElement username;
		
		@FindBy(xpath = "//input[@name='password']")
		WebElement password;
		
		@FindBy(xpath = "//input[@name='login']")
		WebElement button;
		
			
		public void doLogin(String usernameText,String passwordText) {
			username.sendKeys(usernameText);
			password.sendKeys(passwordText);
			button.click();
		}
		
		public boolean verifyValidLogin(String expTitle)
		{
			
			System.out.println("Adactin Search Page Title "+driver.getTitle());
			
			if(driver.getTitle().equals(expTitle))
				return true;
			return false;
			
			
			
		}

}
