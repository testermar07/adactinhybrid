package com.adactin.hotelapp.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import Util.UtilKit;

public class AdactinBase {
	
		
	public static WebDriver driver;
	
	static String browser="chrome";
	
	String project="com.adactin.hotelapp";
	
	String application=project;
	
	@BeforeClass
	public void startClass()
	{
		
		
		driver=UtilKit.initTest(project,application,browser);
		
	}

}
