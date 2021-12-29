package com.qa.hubspot.tests;


import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;

public class ProductInfoTest extends BaseTest{
	
	@BeforeClass
	public void productInfoSetup() {
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyProductInfoTest() {
		
		String productName = "macbook";
		String selectProductName = "MacBook Pro";
		Assert.assertTrue(accountsPage.doSearch(productName));
		productInfoPage = accountsPage.selectProductFromResults("MacBook Pro");
		 
		Assert.assertTrue(productInfoPage.getProductImages() == 4);
		
		Map<String,String> productInfoMap = productInfoPage.getProductInformation();
		System.out.println(productInfoMap);
		//{Brand=Apple, Availability=In Stock, price=$2,000.00, Ex Tax=$2,000.00, 
		//name=MacBook Pro, Product Code=Product 18, Reward Points=800}
		
		Assert.assertEquals(productInfoMap.get("name"), selectProductName);
		Assert.assertEquals(productInfoMap.get("Brand"), "Apple");
		Assert.assertEquals(productInfoMap.get("Availability"), "In Stock");
		Assert.assertEquals(productInfoMap.get("Ex Tax"), "$2,000.00");
		Assert.assertEquals(productInfoMap.get("price"), "$2,000.00");
		Assert.assertEquals(productInfoMap.get("Product Code"), "Product 18");
		Assert.assertEquals(productInfoMap.get("Reward Points"), "800");
		
	}
	
	@Test(priority=2)
	public void addToCartTest() {
		productInfoPage.selectQuantity("4");
		Assert.assertEquals(productInfoPage.addToCart(), "Success: You have added ");
		
		
	}

}
