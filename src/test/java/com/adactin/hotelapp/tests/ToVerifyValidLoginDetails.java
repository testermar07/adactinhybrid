package com.adactin.hotelapp.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.adactin.hotelapp.pages.AdactinLoginPage;

import Util.UtilKit;

public class ToVerifyValidLoginDetails extends AdactinBase{
	
	@Test(dataProvider="getData")
	public void toVerifyValidLoginDetailsTest(String username,String password,String expTitle)
	{
		AdactinLoginPage adactinLoginPage=new AdactinLoginPage(driver);
		
		adactinLoginPage.doLogin(username, password);
		
		Assert.assertTrue(adactinLoginPage.verifyValidLogin(expTitle), "Incorrect Credentials");	
		
		
	}
	
	@DataProvider
	public Object[][] getData() {
		
		return UtilKit.getTestData(project, application, "ToVerifyValidLoginDetails");
		
	}

}
