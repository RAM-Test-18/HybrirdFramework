package com.swagLabs.Qa.PageObjects;

import org.openqa.selenium.By;

public class LoginPage extends InventoryPage{
	
	
	// Login Page WebElement and Locators

	private static String errorText  = "Epic sadface: Username and password do not match any user in this service";
	
	private static String userNameErrorText = "Epic sadface: Password is required";
	
	private static String passwordErrortext ="Epic sadface: Username is required";
	
	private static By userNameField = By.id("user-name");
	
	private static By passwordField = By.id("password");
	
	private static By loginButton = By.id("login-button");
	
	private static By errorTextForInvalidCreds =By.cssSelector("#login_button_container>div>form>h3");
	
	
	public static By userNameField() {
		return userNameField;
	}
	
	
	public static By passwordField() {
		return passwordField;
	}
	
	public static By loginButton() {
		return loginButton;
	}
	
	
	public static By errorTextForInvalidCreds() {
		return errorTextForInvalidCreds;
	}
	
	public static String errorText() {
		return errorText;
	}
	
	
	public static String userNameErrorText() {
		return userNameErrorText;
	}
	
	public static String passwordErrortext() {
		return passwordErrortext;
	}
	
	protected static By loginElement[] = {userNameField(),passwordField()};
	
	
}
