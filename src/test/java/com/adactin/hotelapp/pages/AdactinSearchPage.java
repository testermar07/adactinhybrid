package com.adactin.hotelapp.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdactinSearchPage {
	
	WebDriver driver;
	public void Search_Page(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "location")
	WebElement loc;
		
	@FindBy(id = "hotels")
	WebElement hotel;
	
	@FindBy(id = "room_type")
	WebElement room;
	
	@FindBy(id = "room_nos")
	WebElement Nooffrooms;
	
	@FindBy(id = "datepick_in")
	WebElement startdate;
	
	@FindBy(id = "datepick_out")
	WebElement enddate;

	@FindBy(id = "adult_room")
	WebElement Nooffadult;
	
	@FindBy(id = "child_room")
	WebElement Nooffchild;
	
	@FindBy(xpath = "//*[@id=\"Submit\"]")
	WebElement search;
	
	@FindBy(xpath = "//*[@id=\"Reset\"]")
	 WebElement reset;
	
	
		public void searchPage(String keywords, String value) {
			
			Select loc1 = new Select(loc);
			loc1.selectByVisibleText("Sydney");
			
			// by using list in webelement
			
     	List<WebElement>	hot1 = (List<WebElement>) new Select(hotel);
	    ((Select) hot1).selectByVisibleText("Hotel Creek");
	    
	    // by using select class
			
			Select room1 = new Select(room);
			room1.selectByVisibleText("Standard");
			
			Select noofroom = new Select(Nooffrooms);
			noofroom.selectByVisibleText("1 - One");
			
			startdate.sendKeys(keywords);
			
			enddate.sendKeys(keywords);
			
			Select noofadults = new Select(Nooffadult);
			noofadults.selectByVisibleText("1 - One");
			
			Select noofchild = new Select(Nooffchild);
			noofchild.selectByVisibleText("0 - None");
			
			search.click();
			
			reset.click();
			
			
			
			
			
		}

}
