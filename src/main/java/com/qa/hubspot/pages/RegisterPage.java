package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class RegisterPage extends BasePage{
	
	private ElementUtil elementUtil;
	
	private By firstName = By.cssSelector("#input-firstname");
	private By lastName = By.cssSelector("#input-lastname");
	private By email = By.cssSelector("#input-email");
	private By telephone = By.cssSelector("#input-telephone");
	private By password = By.cssSelector("#input-password");
	private By passwordConfirm = By.cssSelector("#input-confirm");
	private By subscribeYes = By.xpath("//input[@type = 'radio' and @name = 'newsletter' and @value = '1']");
	private By subscribeNo = By.xpath("//input[@type = 'radio' and @name = 'newsletter' and @value = '0']");
	private By agreeCheckbox = By.xpath("//input[@type = 'checkbox' and @name = 'agree']");
	private By continueButton = By.xpath("//input[@type = 'submit' and @value = 'Continue']");
	private By accountSuccessMessage = By.cssSelector("#content h1");
	
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public boolean accountRegistration(String firstName, String lastName, String email, String telephone, 
			String password, String subscribe) {
		elementUtil.doSendKeys(this.firstName, firstName);
		elementUtil.doSendKeys(this.lastName, lastName);
		elementUtil.doSendKeys(this.email, email);
		elementUtil.doSendKeys(this.telephone, telephone);
		elementUtil.doSendKeys(this.password, password);
		elementUtil.doSendKeys(this.passwordConfirm, password);
		
		if(subscribe.equals("yes")) {
			elementUtil.doClick(subscribeYes);
		} else {
			elementUtil.doClick(subscribeNo);
		}
		
		elementUtil.doClick(agreeCheckbox);
		elementUtil.doClick(continueButton);
		
		String text = elementUtil.doGetText(accountSuccessMessage);
		if(text.contains(Constants.ACCOUNT_SUCCESS_MESSAGE)) {
			elementUtil.doClick(logoutLink);
			elementUtil.doClick(registerLink);
			return true;
		}
		return false;
	}
		
		
		
		
		
		
		
		
	}


