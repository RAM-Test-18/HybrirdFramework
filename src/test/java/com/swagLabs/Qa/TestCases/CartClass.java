package com.swagLabs.Qa.TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.swagLabs.Qa.TestBase.TestBase;
import com.swagLabs.Qa.Utils.Input;

public class CartClass extends TestBase{
	
	
	@BeforeMethod
	public void initialzation() throws InterruptedException 
	{
		Input.setting_Up_BrowserName(bName);
		Input.urlNavigation(browserURL);
		ChainTestListener.log("Going to Enter Valid Login Username and Password.");
		Input.textEnter(userNameField(), userName_New);
		Input.textEnter(passwordField(), password_New);
		Input.clickOn(loginButton(), click);
	}
	
	
	@Test(priority=0)
	public static void adding_Items_To_cart() throws InterruptedException 
	{
	
		if(Input.getDriver().getTitle().contains(inventoryPageTitle)) 
		{
			ChainTestListener.log("Page Title is Matched : "  +  inventoryPageTitle);
		}else 
		{
			ChainTestListener.log("Unable to Find Page Title : "  +  Input.getDriver().getTitle());
			Assert.assertTrue(false);
		}
		ChainTestListener.log("Going to Add 6 Items To Cart.");
		 List<WebElement> allItems = Input.getDriver().findElements(addTocart());
		TimeUnit.SECONDS.sleep(1);
		for(int i=0;i<allItems.size();i++) 
		{
			allItems.get(i).click();
			
		}
		ChainTestListener.log("Number of Items Added to cart : " + allItems.size());
		TimeUnit.SECONDS.sleep(1);
		ChainTestListener.log("Going to remove all 6 items from Shopping Cart.");
		TimeUnit.SECONDS.sleep(1);
		Input.clickOn(shopping_Cart_Badge(), click);
		TimeUnit.SECONDS.sleep(1);
		List<WebElement> removeItems = Input.getDriver().findElements(removeItems());
		TimeUnit.SECONDS.sleep(1);
		for(int i=0;i<removeItems.size();i++) 
		{
			removeItems.get(i).click();
		}
		ChainTestListener.log("Number of Items Removed from  cart : " + removeItems.size());
		System.out.println();
		Input.clickOn(continueShopping(), click);
		TimeUnit.SECONDS.sleep(1);
		Input.clickOn(openMenu(), click);
		Input.clickOn(logout(), click);
		
	}
	
	
	@Test(priority = 1)
	public static void perfrom_Checkout_For_Added_Items() throws InterruptedException 
	{
		
		System.out.println("Going to Add 6 Items To Cart.");
		 List<WebElement> allItems = Input.getDriver().findElements(addTocart());
		TimeUnit.SECONDS.sleep(1);
		for(int i=0;i<allItems.size();i++) 
		{
			allItems.get(i).click();
		}
		ChainTestListener.log("Going to perform Checkout.");
		TimeUnit.SECONDS.sleep(1);
		Input.clickOn(shopping_Cart_Badge(), click);
		Input.clickOn(checkOut(), click);
		Input.textEnter(firstName(), "Test");
		Input.textEnter(lastName(), "User");
		Input.textEnter(postalCode(), "500013");
		Input.clickOn(continueButton(), click);
		Input.scrollToElement(finishButton());
		Input.clickOn(finishButton(), click);
		if(Input.getElementText(thanksForOrder()).contains(thanksForOrderText)) 
		{
			ChainTestListener.log("Your order has been dispatched, and will arrive just as fast as the pony can get there!");
		}else
		{
			ChainTestListener.log("Failed to Find the Element.");
			Assert.assertTrue(false);
		}
		
	}
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() 
	{
		Input.getDriver().quit();
	}
	



}
