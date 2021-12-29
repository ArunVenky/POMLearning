package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utils.Constants;

public class AccountsPageTest extends BaseTest {
	
	@BeforeClass
	public void accountsPageSetup() {
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
					
	}
	
	@Test(priority=1)
	public void accountsPageTitleTest() {
		String title = accountsPage.getAccountsPageTitle();
		Assert.assertEquals(title, Constants.ACCOUNTS_PAGE_TITLE);
		
	}
	
	@Test(priority=2)
	public void accountsPageHeaderTest() {
		String headerValue = accountsPage.getHeaderValue();
		Assert.assertEquals(headerValue, Constants.ACCOUNTS_PAGE_HEADER_TITLE);
	}
	
	@Test(priority=3)
	public void verifyAccountsSectionCountTest() {		
		Assert.assertTrue(accountsPage.getAccountsSectionCount() == Constants.ACCOUNTS_SECTION_COUNT);
	}
	
	@Test(priority=4)
	public void verifyMyAccountSectionListTest() {
		Assert.assertEquals(accountsPage.getAccountsSectionList(), Constants.getAccountSectionList());
	}
	
	@Test(priority=5)
	public void verifyDoSearchTest() {
		Assert.assertTrue(accountsPage.doSearch("mac"));
	}
	
	
	
}
