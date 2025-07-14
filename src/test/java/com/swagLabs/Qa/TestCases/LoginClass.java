package com.swagLabs.Qa.TestCases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.swagLabs.Qa.TestBase.TestBase;
import com.swagLabs.Qa.Utils.Input;



public class LoginClass extends TestBase{
	
	
	@BeforeMethod
	public void initialzation() throws InterruptedException 
	{
		Input.setting_Up_BrowserName(bName);
		Input.urlNavigation(browserURL_New);
	}
	
	
	@Test(priority = 0)
	public static void login_Into_Application_With_Valid_Creds() throws InterruptedException 
	{
		
		ChainTestListener.log("Going to Enter Valid Login Details");
		Input.textEnter(userNameField(), userName_New);
		TimeUnit.SECONDS.sleep(1);
		Input.textEnter(passwordField(), password_New);
		TimeUnit.SECONDS.sleep(1);
		Input.clickOn(loginButton(), click);
		TimeUnit.SECONDS.sleep(2);
		if(Input.getDriver().getTitle().contains(inventoryPageTitle)) 
		{
			ChainTestListener.log("Page Title is Matched :" + inventoryPageTitle);
		}else 
		{
			ChainTestListener.log("Unable to find page title: " + Input.getDriver().getTitle());
			Assert.assertTrue(false);
		}
		TimeUnit.SECONDS.sleep(2);
	}
	
	
	@Test(priority = 1)
	public static void login_Into_Application_With_InValid_Creds() throws InterruptedException 
	{
		ChainTestListener.log("Going to Enter In-Valid Login Username and Password.");
		Input.textEnter(userNameField(), userName_New);
		TimeUnit.SECONDS.sleep(1);
		Input.textEnter(passwordField(), "secret");
		TimeUnit.SECONDS.sleep(1);
		Input.clickOn(loginButton(), click);
		TimeUnit.SECONDS.sleep(2);
		if(Input.getElementText(errorTextForInvalidCreds()).equals(errorText())) 
		{
			ChainTestListener.log("Error Message for Invalid Cred's : "  +  Input.getElementText(errorTextForInvalidCreds()));
			
		}else 
		{
			ChainTestListener.log("Error Message for Invalid Cred's : "  +  Input.getElementText(errorTextForInvalidCreds()));
			Assert.assertTrue(false);
		}
		TimeUnit.SECONDS.sleep(2);
	}
	
	
	@Test(priority = 2)
	public static void login_Into_Application_With_Only_UserName() throws InterruptedException 
	{
	
		ChainTestListener.log("Going to Enter Only Username.");
		Input.textEnter(userNameField(), userName_New);
		TimeUnit.SECONDS.sleep(1);
		Input.clickOn(loginButton(), click);
		TimeUnit.SECONDS.sleep(2);
		if(Input.getElementText(errorTextForInvalidCreds()).equals(userNameErrorText())) 
		{
			ChainTestListener.log("Error Message for Invalid Cred's : "  +  Input.getElementText(errorTextForInvalidCreds()));
			
		}else 
		{
			ChainTestListener.log("Error Message for Invalid Cred's : "  +  Input.getElementText(errorTextForInvalidCreds()));
			Assert.assertTrue(false);
		}
		TimeUnit.SECONDS.sleep(2);
	}
	
	
	
	
	@Test(priority = 3)
	public static void login_Into_Application_With_Only_Password() throws InterruptedException 
	{
		ChainTestListener.log("Going to Enter Only Password.");
		Input.textEnter(passwordField(), password_New);
		TimeUnit.SECONDS.sleep(1);
		Input.clickOn(loginButton(), click);
		TimeUnit.SECONDS.sleep(2);
		if(Input.getElementText(errorTextForInvalidCreds()).equals(passwordErrortext())) 
		{
			ChainTestListener.log("Error Message for Invalid Cred's : "  +  Input.getElementText(errorTextForInvalidCreds()));
			
		}else 
		{
			ChainTestListener.log("Error Message for Invalid Cred's : "  +  Input.getElementText(errorTextForInvalidCreds()));
			Assert.assertTrue(false);
		}
		TimeUnit.SECONDS.sleep(2);
	}
	
	
	@AfterMethod
	public void tearDown() 
	{
		Input.getDriver().quit();
	}


}
