package com.adactin.hotelapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinSelectPage {
	
WebDriver driver;
	
	public void selecthotel(WebDriver driver)
	{
		PageFactory.initElements( driver, this);
	}
	
	@FindBy (xpath = "//input[@name = 'radiobutton_0']")
	WebElement rb0;
	
	@FindBy (xpath = "//input[@name = 'continue']")
	WebElement cont;
	
	@FindBy (xpath = "//input[@name  = 'cancel']")
	WebElement cancel;
	
	public void radiobutton()
	{
		rb0.click();
	}
	public boolean continuee()
	{
		cont.click();
		
		if(driver.getTitle().equalsIgnoreCase("Adactin.com - Book A Hotel"))
		return true;

		return false;
		
	}

}
