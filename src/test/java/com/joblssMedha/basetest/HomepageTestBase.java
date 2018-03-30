package com.joblssMedha.basetest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.Reporter;

import com.jobless.utilities.ExcelUtility;

public class HomepageTestBase {
	ExcelUtility excel;
	static Properties prop = new Properties();
	
	public static String getPropertyValue(String propertyName) {
		String propertyValue = "";
		try {
			InputStream inStream = new FileInputStream(new File("/Users/HiteshRatnani/eclipse-workspace/PracticeHome/src/test/resources/projectPracticeHome.properties"));
			prop.load(inStream);
			propertyValue = prop.getProperty(propertyName);
			} catch (Exception e) {
				Reporter.log("Unable to access the properties file");
			} 
		return propertyValue;
	}
	
	protected final static String user_Dir = getPropertyValue("project_UserDir");
	protected final static String resource_Dir = getPropertyValue("project_ResourcesPath");
	protected final static String data_excelName = getPropertyValue("project_DataExcelxlsx");
	

}
