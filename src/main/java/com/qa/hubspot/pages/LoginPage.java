package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class LoginPage extends BasePage{
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	
	//By Locators: OR
	
	private By emailID = By.id("input-email");
	private By password = By.id("input-password");
	private By loginButton = By.xpath("//input[@type='submit' and @value = 'Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	private By registerLink = By.linkText("Register");
	
	
	//Constructor
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public String getLoginPageTitle() {
		return elementUtil.getPageTitle(Constants.LOGIN_PAGE_TITLE, 10);
	}
	
	public boolean isForgotPwdLinkExist() {
		return elementUtil.doIsDisplayed(forgotPwdLink);
	}
	
	public AccountsPage doLogin(String un, String pwd) {
		System.out.println("Login With: " + un + " and " + pwd);
		elementUtil.doSendKeys(emailID, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
		
		return new AccountsPage(driver);
	}
	
	public RegisterPage navigateToRegisterPage() {
		elementUtil.doClick(registerLink);
		
		return new RegisterPage(driver);
		
		
	}

}
