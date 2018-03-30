package com.joblssMedha.test;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.IInvokedMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jobless.utilities.ExcelUtility;
import com.joblssMedha.basetest.HomepageTestBase;

public class ApplicationTests extends HomepageTestBase {
	
	@DataProvider(name = "get ExcelData")
	public Iterator<Object[]> getExcelData(Method m){
		List<Map<String, String>> dataList = new ArrayList <Map<String, String>> ();
		int rowNum = ExcelUtility.getRowNameOnSearchingString(m.getName(), "Sheet1");
		Map<String, String> dataMap = new HashMap<String, String>();
		dataMap = ExcelUtility.getRowData(rowNum);
		dataList.add(dataMap);
		Collection <Object[]> testData = new ArrayList<Object[]>();
		for(Map<String, String> map : dataList) {
			testData.add(new Object[] {map});
		}
		return testData.iterator();
		
	}

	@Test (dataProvider = "get ExcelData") 
	public void launchApplication(Map <String, String> testData) {
		System.out.println(testData.get("UserID"));
		System.out.println(testData.keySet());
		System.out.println(testData.values());
	}

	
}
