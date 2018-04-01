package com.joblssMedha.test;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLEngineResult.Status;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.IInvokedMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jobless.utilities.ExcelUtility;
import com.joblssMedha.basetest.HomepageTestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

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
		ExtentReports report;
		ExtentTest ex;
		String testName= testData.get("testCaseName");
		report = new ExtentReports("//Users//HiteshRatnani//eclipse-workspace//PracticeHome//reports//"+testName+".html");
		ex = report.startTest(testName);
		
		logger = Logger.getLogger(ApplicationTests.class);
		PropertyConfigurator.configure("/Users/HiteshRatnani/eclipse-workspace/PracticeHome/log4j.properties");
		logger.info("Madhu");
		ex.log(LogStatus.INFO, "details 1");
		System.out.println(testData.get("UserID"));
		logger.info("Madhu");
		ex.log(LogStatus.PASS, "details 2");
		System.out.println(testData.keySet());
		logger.info("Madhu");
		ex.log(LogStatus.FAIL, "details.3");
		System.out.println(testData.values());
		logger.info("Madhu");
		ex.log(LogStatus.INFO, "details4");
		report.endTest(ex);
	}

	
}
