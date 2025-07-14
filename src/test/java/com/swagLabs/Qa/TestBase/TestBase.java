package com.swagLabs.Qa.TestBase;

import java.util.concurrent.TimeUnit;

import com.swagLabs.Qa.PageObjects.LoginPage;
import com.swagLabs.Qa.Utils.Input;

public class TestBase extends LoginPage{

	
	 static int RETRY =5;
	

	public static Boolean login_To_swagLabs() throws InterruptedException 
	{
		g_Task_Result = g_Task_Passed;
		
		Input.urlNavigation(browserURL);
		System.out.println("Going to login in to Swag Labs.");
		for(int i=0;i<RETRY;i++) 
		{
			for(int m=0;m<loginElement.length;m++) 
			{
				TimeUnit.SECONDS.sleep(1);
				Input.textEnter(loginElement[m], loginElementText[m]);
			}
			TimeUnit.SECONDS.sleep(1);
			Input.clickOn(loginButton(), click);
			if(Input.getDriver().getTitle().contains(inventoryPageTitle)) 
			{
				System.out.println("Page Title is Matched : "  +  inventoryPageTitle);
				break;
			}else 
			{
				System.out.println("Unable to Find Page Title : "  +  Input.getDriver().getTitle());
			}
			
			if(i == (RETRY-1)) 
			{
				System.err.println("RETRY Limit of  5 is Reached, Please Open Browser After some while.");
			}
			
		}
		
		
		return g_Task_Result;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
