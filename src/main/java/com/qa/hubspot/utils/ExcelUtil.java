package com.qa.hubspot.utils;

//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.util.Random;

//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.github.javafaker.Faker;

public class ExcelUtil {
	
	//private static Workbook book;
	//private static Sheet sheet;
	public static String TEST_DATA_SHEET_PATH = "./src/main/java/com/qa/hubspot/testdata/tutorialsNinjaTestData.xlsx";
	public static Faker faker = new Faker();
	public static Random ran = new Random();
	
	private static String[] s = {"yes", "no"};
	
	/*public static Object[][] getTestData(String sheetName) {
		Object data[][] = null;
		try {
			FileInputStream ip = new FileInputStream(TEST_DATA_SHEET_PATH);
			WorkbookFactory.create(ip);
			sheet = book.getSheet(sheetName);
			
			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			for(int r = 0;r<sheet.getLastRowNum();r++) {
				for(int c = 0;c<sheet.getRow(0).getLastCellNum();c++) {
					data[r][c] = sheet.getRow(r+1).getCell(c).toString();
				}
			}*/
			
			public static Object[][] getTestDataNNumber(int count) {
				Object data[][] = null;
				
					
					data = new Object[count][6];
					
					for(int r = 0;r<count;r++) {
						
						String s_ran = s[ran.nextInt(s.length)];
						
							data[r][0] = faker.name().firstName();
							data[r][1] = faker.name().lastName();
							data[r][2] = faker.internet().emailAddress();
							data[r][3] = faker.phoneNumber().cellPhone();
							data[r][4] = faker.internet().password(8, 16);
							data[r][5] = s_ran;
						
					}
				
		return data;
		
	}
	
}
