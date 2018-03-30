package com.joblssMedha.webElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.joblssMedha.basetest.HomepageTestBase;

public class ProjectDropDownWebElement extends HomepageTestBase implements WebElement {

	Select sel = null;
	
	public void selectByText(ProjectDropDownWebElement element, String sTextForOptionToBeSelected) {
		sel = new Select (element);
		sel.selectByVisibleText(sTextForOptionToBeSelected);
	}
	
	public void selectByValue(ProjectDropDownWebElement element, String sValueForOptionToBeSelected) {
		sel = new Select (element);
		sel.selectByValue(sValueForOptionToBeSelected);
	}
	
	public void selectByIndex(ProjectDropDownWebElement element, String sIndexForOptionToBeSelected) {
		sel = new Select (element);
		sel.selectByVisibleText(sIndexForOptionToBeSelected);
	}
	
	public void selectByPartialText(ProjectDropDownWebElement element, String sPartialTextForOptionToBeSelected) {
		sel = new Select (element);
		List<WebElement> lDropDownWebElement = getAllOptionsFromDropdownList(element);
		List <String> lDropdownWebElementString = convertWebElementListToStringList(lDropDownWebElement);
		
		for(String sElementString : lDropdownWebElementString) {
			if(sElementString.contains(sPartialTextForOptionToBeSelected)) {
			sel.selectByVisibleText(sElementString);
			break;
			}
		}
	}
	
	public void selectByPartialTextFaster(ProjectDropDownWebElement element, String sPartialTextForOptionToBeSelected) {
		sel = new Select (element);
		List<WebElement> lDropDownWebElement = sel.getOptions();
		for(WebElement individualDDelement: lDropDownWebElement) {
			if(individualDDelement.getText().contains(sPartialTextForOptionToBeSelected)) {
				sel.selectByVisibleText(individualDDelement.getText());
				break;
			}
			
		}
		
	}
	
	public List<WebElement> getAllOptionsFromDropdownList(ProjectDropDownWebElement element) {
		sel = new Select (element);
		List<WebElement> lOptionsWebElementList = sel.getOptions();
		return lOptionsWebElementList;
	}
	
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
