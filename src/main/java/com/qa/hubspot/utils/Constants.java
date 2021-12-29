package com.qa.hubspot.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	
	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String ACCOUNTS_PAGE_TITLE = "My Account";
	public static final String ACCOUNTS_PAGE_HEADER_TITLE = "Your Store";
	public static final int ACCOUNTS_SECTION_COUNT= 4;
	public static final String REGISTER_SHEET_NAME = "registration";
	public static final int NUMBER_OF_ROWS = 5;
	public static final String ACCOUNT_SUCCESS_MESSAGE = "Your Account Has Been Created";
	
	public static List<String> getAccountSectionList() {
		List<String> accountList = new ArrayList<String>();
		accountList.add("My Account");
		accountList.add("My Orders");
		accountList.add("My Affiliate Account");
		accountList.add("Newsletter");
		
		return accountList;
	}
}
