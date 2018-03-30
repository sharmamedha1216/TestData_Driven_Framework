package com.jobless.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.joblssMedha.basetest.HomepageTestBase;

public class TakeScreenPrint extends HomepageTestBase {
	
	
	public void takeScreenShotImage() {
		//1. Convert WebDriver to TakesScreenshot object
		
		TakesScreenshot tScr = (TakesScreenshot)driver;
		
		//2. Call getScreenshotAs() method to create image file
		File srcFile = tScr.getScreenshotAs(OutputType.FILE);
		
		//3. Copy File to Desired location
		File destFile = new File("D:\\Medha_Practice\\EvidenceImgFiles");
		
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
