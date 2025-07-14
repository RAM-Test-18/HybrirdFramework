package com.swagLabs.Qa.PageObjects;

import org.openqa.selenium.By;

import com.swagLabs.Qa.Base.BaseClass;

public class InventoryPage extends BaseClass{

	// Inventory Page Locators and WebElements
	
	private static By addTocart = By.cssSelector("button[class='btn_primary btn_inventory']");

	private static By openMenu = By.cssSelector("#menu_button_container > div > div:nth-child(3) > div > button");

	private static By closeMenu = By.cssSelector("#menu_button_container > div > div.bm-menu-wrap > div:nth-child(2) > div > button");

	private static By all_Items = By.cssSelector("#inventory_sidebar_link");

	private static By about = By.cssSelector("#about_sidebar_link");

	private static By logout = By.cssSelector("#logout_sidebar_link");

	private static By reset_App_Store = By.cssSelector("#reset_sidebar_link");
	
	private static By shopping_Cart_Badge = By.cssSelector("#shopping_cart_container > a > span");
	
	private static By removeItems = By.cssSelector("button[class='btn_secondary cart_button']");
	
	private static By continueShopping = By.cssSelector("a[class='btn_secondary']");
	
	private static By checkOut = By.cssSelector("#cart_contents_container > div > div.cart_footer > a.btn_action.checkout_button");
	
	
	public static By addTocart() {return addTocart;}

	public static By openMenu() {return openMenu;}

	public static By closeMenu() {return closeMenu;}

	public static By all_Items() {return all_Items;}

	public static By about() {return about;}

	public static By logout() {return logout;}

	public static By reset_App_Store(){return reset_App_Store;}
	
	public static By shopping_Cart_Badge(){return shopping_Cart_Badge;}
	
	public static By removeItems(){return removeItems;}
	
	public static By continueShopping() {return continueShopping;}
	
	public static By checkOut() {return checkOut;}
	
	 
	// Checkout Locators and WebElements
	
	private static By firstName = By.id("first-name");
	
	private static By lastName = By.id("last-name");
	
	private static By postalCode = By.id("postal-code");
	
	private static By continueButton = By.cssSelector("#checkout_info_container > div > form > div.checkout_buttons > input");
	
	private static By cancelButton = By.cssSelector("#checkout_info_container > div > form > div.checkout_buttons > a");
	
	private static By finishButton = By.cssSelector("#checkout_summary_container > div > div.summary_info > div.cart_footer > a.btn_action.cart_button");
	
	private static By thanksForOrder = By.cssSelector("#checkout_complete_container > h2");
	
	public static By firstName() {return firstName;}
	
	public static By lastName() {return lastName;}
	
	public static By postalCode() {return postalCode;}
	
	public static By continueButton() {return continueButton;}
	
	public static By cancelButton() {return cancelButton;}
	
	public static By finishButton() {return finishButton;}
	
	public static By thanksForOrder() {return thanksForOrder;}
	
	
	
	
	

}
