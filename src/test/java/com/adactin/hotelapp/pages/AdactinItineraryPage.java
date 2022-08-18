package com.adactin.hotelapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinItineraryPage {
	
WebDriver driver;
	
	public void booked(WebDriver driver)
	{
		PageFactory.initElements( driver, this);
	}
	
	@FindBy (xpath = "//input[@value  = '663274'] ")
	WebElement hotel;
	
	@FindBy (xpath = "//input[@name = 'cancelall;]")
	WebElement cancelbooking;
	
	@FindBy (xpath = "//input[@name  = 'search_hotel']")
	WebElement search;
	
	@FindBy (xpath = "//input[@name = 'logout']")
	WebElement logoutbtn;
	
	public void bookconf()
	{
		hotel.click();
	}
	public void cancel()
	{
		cancelbooking.click();
	}
	public void search_hotel()
	{
		search.click();
	}
	public void logout()
	{
		logoutbtn.click();
	}

}
