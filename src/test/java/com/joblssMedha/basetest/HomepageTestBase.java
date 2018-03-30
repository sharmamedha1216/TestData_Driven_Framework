package com.joblssMedha.basetest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.poifs.property.DirectoryProperty.PropertyComparator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.google.common.base.Function;
import com.joblssMedha.pages.ProjectConstants;

public class HomepageTestBase {
	public static WebDriver driver;
	public Logger logger = Logger.getLogger(HomepageTestBase.class);
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
	

	public void setValueOfPropertiesKey(String sPropertyKey, String sNewValueForPropertyKey){
		
			try {
			OutputStream outStream = new FileOutputStream(ProjectConstants.Location_PropertiesFile);
			prop.setProperty(sPropertyKey, sNewValueForPropertyKey);
			prop.store(outStream, "Updated Key "+sPropertyKey+" to value "+ sNewValueForPropertyKey +" in proerties file.");
			
			}
			catch(IOException e) {
				e.printStackTrace();
			}
	}
	
	
	protected final static String user_Dir = getPropertyValue("project_UserDir");
	protected final static String resource_Dir = getPropertyValue("project_ResourcesPath");
	protected final static String data_excelName = getPropertyValue("project_DataExcelxlsx");
	public final String sAppUrl = getPropertyValue("project_Application_Url");
	public final String sBrowserName = getPropertyValue("project_Browser");
	public final String sChromeDriverPath = getPropertyValue("project_chromeDriverLocation");
	public final String sIEDriverPath = getPropertyValue("project_ieDriverLocation");
	public final String sGeckoDriverPath = getPropertyValue("project_geckoDriverLocation");
	
	
	public boolean isAlertPresent() {
		
		try {
			driver.switchTo().alert();
			return true;
			
		}catch(NoAlertPresentException ex){
			return false;
		}
		
	}
	
	public void waitForPageToLoad(int waitForTime) {
		FluentWait<WebDriver> wait = fluentWaitLines(waitForTime);
		Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>(){
			public Boolean apply(WebDriver arg0) {
				JavascriptExecutor js = (JavascriptExecutor) arg0;
				return js.executeScript("return document.readyState").toString().equalsIgnoreCase("Complete");
			}
		};
	}
	
	public void waitForPageToLoad() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return document.readyState").toString().equalsIgnoreCase("Complete");
		
	}
	
	
	public FluentWait<WebDriver> fluentWaitLines(int waitTimout){
		@SuppressWarnings("deprecation")
		FluentWait <WebDriver> waitStd = new FluentWait<WebDriver>(driver)
				.withTimeout(waitTimout, TimeUnit.SECONDS)
				.pollingEvery(3, TimeUnit.SECONDS)
				.ignoring(Exception.class);
		return waitStd;
	}
 	
	public void waitForAlert (int waitTimout) {
		
		FluentWait <WebDriver> wait = fluentWaitLines(waitTimout);
		Function <WebDriver, Boolean> alertFound = new Function <WebDriver, Boolean> (){
			public Boolean apply(WebDriver driver) {
				return isAlertPresent();
			}
		};
		wait.until(alertFound);
	}
	
	public List<String> convertWebElementListToStringList (List<WebElement> listOfWebElement){
		List<String> lStringListOfWebElements = new ArrayList<String>();
		for(WebElement element : listOfWebElement) {
			String sElementString= element.getText();
			lStringListOfWebElements.add(sElementString);
		}
		
		return lStringListOfWebElements;
	}
	
	@BeforeTest
	public void setupAndLaunchBrowser() {
		
		if(sBrowserName.equalsIgnoreCase("Chrome")){
			//For MacIntosh Platform
			System.setProperty("webdriver.chrome.driver", sChromeDriverPath+"chromedriver");
			//for Windows Platform
			//System.setProperty("webdriver.chrome.driver", sChromeDriverPath+"chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(sBrowserName.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", sIEDriverPath+"IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		else if(sBrowserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", sGeckoDriverPath+"geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("Use correct Browser - Chrome / IE / FireFox");
		}
	}
	
	@AfterTest
	public void closingDown() {
		driver.close();
		driver.quit();
	}


}
