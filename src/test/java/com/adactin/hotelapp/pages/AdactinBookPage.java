package com.adactin.hotelapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdactinBookPage {
	
WebDriver driver;
	
	public void bookhotel(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//input[@name = 'first_name']")
	WebElement fname;
	
	@FindBy (xpath = "//input[@name  = 'last_name']")
	WebElement lname;
	
	@FindBy (xpath = "//input[@name  = 'address']")
	WebElement add;
	
	@FindBy (xpath = "//input[@name = 'cc_num']")
	WebElement card;
	
	@FindBy (xpath = "//input[@name = 'cc_type']")
	WebElement cardtype;
	
	@FindBy (xpath = "//input[@name = 'cc_exp_month']")
	WebElement expmonth;
	
	@FindBy (xpath = "//input[@name = 'cc_exp_year']")
	WebElement expyear;
	
	@FindBy (xpath = "//input[@name = 'cc_cvv']")
	WebElement cvv;
	
	@FindBy (xpath = "//input[@name  = 'book_now']")
	WebElement booknow;
	
	@FindBy (xpath = "//input[@name  = 'cancel']")
	WebElement cancel;
	
	public void first_name(String text)
	{
		fname.sendKeys(text);
	}
	public void last_name(String text)
	{
		lname.sendKeys(text);
	}
	public void address(String text)
	{
		add.sendKeys(text);
	}
	public void cc_num(String num)
	{
		card.sendKeys(num);
	}
	public void cc_type(String text)
	{
		//Select cardl = new Select(cardtype);
		
		//cardl.selectByVisibleText("VISA");
		
		new Select(cardtype).selectByVisibleText("VISA");
	}
	public void ccexpmonth(String text)
	{
		Select exmon = new Select(expmonth);
		
		exmon.selectByVisibleText("November");
	}
	public void ccexpyear(String text)
	{
		Select exyear = new Select(expyear);
		
		exyear.selectByVisibleText("2022");
	}
	public void cc_cvv(String text)
	{
		cvv.sendKeys(text);
	}
	public void book()
	{
		booknow.click();
	}
	public void cancel()
	{
		cancel.click();
	}
	
	public void bookHotel(String fnameText, String lnameText, String addText, String cardText, String cardtypeText, String expmonthText, String expyearText, String cvvText )
	{
		fname.sendKeys(fnameText);
		lname.sendKeys(lnameText);
		add.sendKeys(addText);
		card.sendKeys(cardText);
		cardtype.sendKeys(cardtypeText);
		expmonth.sendKeys(expmonthText);
		expyear.sendKeys(expyearText);
		cvv.sendKeys(cvvText);
		booknow.click();
		cancel.click();
	}

}
