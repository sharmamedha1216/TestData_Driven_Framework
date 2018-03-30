package com.joblssMedha.webElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.joblssMedha.basetest.HomepageTestBase;

public class ProjectWebElement extends HomepageTestBase implements WebElement{
	
	
	WebDriverWait wait;
	 public void waitForVisible(ProjectWebElement element, int iWaitTimeInSeconds) {
		 wait = new WebDriverWait(driver, iWaitTimeInSeconds);
		 wait.until(ExpectedConditions.visibilityOf(element));
	 }
	 
	 public void waitForNotVisible(ProjectWebElement element, int iWaitTimeInSeconds) {
		 wait = new WebDriverWait(driver, iWaitTimeInSeconds);
		 wait.until(ExpectedConditions.invisibilityOf(element));
	 }
	
	 public void waitForAttribute(ProjectWebElement element, String attribute, String value, int iWaitTimeInSeconds) {
		 wait = new WebDriverWait(driver, iWaitTimeInSeconds);
		 wait.until(ExpectedConditions.attributeContains(element, attribute, value));
	 }
	 
	 public void waitForAttributeToPopulate(ProjectWebElement element, String attribute, int iWaitTimeInSeconds) {
		 wait = new WebDriverWait(driver, iWaitTimeInSeconds);
		 wait.until(ExpectedConditions.attributeToBeNotEmpty(element, attribute));
	 }
	 
	 public void click(ProjectWebElement element, String elementPresentingName) {
		 element.click();
		 Reporter.log("Clicked on '"+elementPresentingName+"' successfully.");
	 }
	 
	 public void sendKeys(ProjectWebElement element, String elementPresentingName, String stringToInput) {
		 element.sendKeys(stringToInput);;
		 Reporter.log("Successfully input '"+stringToInput+"' in '"+elementPresentingName+"' text field.");
	 }
	
	
	// Methods from WebElement Interface
	
	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		// TODO Auto-generated method stub
		return null;
	}

	public void click() {
		// TODO Auto-generated method stub
	}

	public void submit() {
		// TODO Auto-generated method stub
		
	}

	public void sendKeys(CharSequence... keysToSend) {
		// TODO Auto-generated method stub
		
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public String getTagName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAttribute(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isSelected() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<WebElement> findElements(By by) {
		// TODO Auto-generated method stub
		return null;
	}

	public WebElement findElement(By by) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	public Point getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	public Dimension getSize() {
		// TODO Auto-generated method stub
		return null;
	}

	public Rectangle getRect() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCssValue(String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}

}
