package com.qa.hubspot.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class AccountsPage extends BasePage {
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	private By header = By.cssSelector("div#logo a");
	private By accountHeaders = By.xpath("//div[@id='content']/h2");
	private By searchText = By.cssSelector("div#search input[name='search']");
	private By searchButton = By.cssSelector("div#search button[type='button']");
	private By searchItemResult = By.cssSelector(".product-layout .product-thumb");
	private By resultItems = By.cssSelector(".product-thumb h4 a"); 
	
	public AccountsPage(WebDriver driver) {
		
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		
	}
	
	public String getAccountsPageTitle() {
		return elementUtil.getPageTitle(Constants.ACCOUNTS_PAGE_TITLE, 10);
	}
	
	public String getHeaderValue() {		
		if(elementUtil.doIsDisplayed(header)) {
			return elementUtil.doGetText(header);
		}
		return null;
		
	}

	public int getAccountsSectionCount() {
		return elementUtil.getSize(accountHeaders);				
	}
	
	public List<String> getAccountsSectionList() {
		return elementUtil.getElementsTextList(accountHeaders);
	}
	
	public boolean doSearch(String productName) {
		elementUtil.doSendKeys(searchText, productName);
		elementUtil.doClick(searchButton);
		
		if(elementUtil.getSize(searchItemResult) > 0) {
			return true;
		}
		return false;
	}
	
	public ProductInfoPage selectProductFromResults(String productName) {
		
		List<WebElement> resultItemsList = elementUtil.getElements(resultItems);
		System.out.println("total products from search: " + resultItemsList.size());
		
		for(WebElement e:resultItemsList) {
			if(e.getText().equalsIgnoreCase(productName)) {
				e.click();
				break;
			}
		}
		
		return new ProductInfoPage(driver);
		
	}
	
	
}
