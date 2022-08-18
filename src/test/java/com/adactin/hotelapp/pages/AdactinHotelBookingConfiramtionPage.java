package com.adactin.hotelapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinHotelBookingConfiramtionPage {
	
WebDriver driver;
	
	public void booking(WebDriver driver)
	{
		PageFactory.initElements( driver, this );
	}
	
	@FindBy (xpath = "//input[@name  = 'my_itinerary']")
	WebElement itineary;
	
	public void conform()
	{
		itineary.click();
	}

}
