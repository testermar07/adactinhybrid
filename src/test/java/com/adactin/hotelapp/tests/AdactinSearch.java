package com.adactin.hotelapp.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Util.UtilKit;

public class AdactinSearch extends AdactinBase
{
	
	
	@Test(dataProvider="searchDataProvider")
	public void simpleLoginTest(String location,String hotel,String roomNos,String dateCheckIn,String dateCheckout,String adults,String children)
	{
		
		System.out.println(location+hotel+roomNos+dateCheckIn+dateCheckout+adults+children);
		
	}
	
	@DataProvider
	public Object[][] searchDataProvider() {
		return UtilKit.getTestData(project, application, "search");
	}

}
