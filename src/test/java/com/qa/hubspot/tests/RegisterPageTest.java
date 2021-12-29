package com.qa.hubspot.tests;

import java.util.Random;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ExcelUtil;

public class RegisterPageTest extends BaseTest {
	
	Faker faker = new Faker();
	Random ran = new Random();
	String[] s = {"yes", "no"};
	
	
	@BeforeClass
	public void registerPageSetUp() {
		registerPage = loginPage.navigateToRegisterPage();
	}
	
	@DataProvider
	public Object[][] getRegisterData() {
		Object data[][] = ExcelUtil.getTestDataNNumber(Constants.NUMBER_OF_ROWS);
		return data;
	}
	
	@Test(dataProvider="getRegisterData")
	public void userRegistrationTest(String firstName, String lastName, String email, String telephone, String password, String subscribe) {
		registerPage.accountRegistration(firstName, lastName, email, telephone, password, subscribe);
		
	}

}
