package com.adactin.hotelapp.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Util.UtilKit;

public class AdactinLogin extends AdactinBase
{
	
	
	@Test(dataProvider="loginDataProvider")
	public void simpleLoginTest(String username,String password)
	{
		
		System.out.println("Username "+username+"\tPassword "+password);
		
	}
	
	@DataProvider
	public Object[][] loginDataProvider() {
		return UtilKit.getTestData(project, application, "ValidLogin");
	}

}
