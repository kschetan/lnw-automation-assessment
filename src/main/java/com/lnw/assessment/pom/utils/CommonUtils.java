package com.lnw.assessment.pom.utils;

import java.time.Duration;
import java.util.Properties;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils {
	
	/*
	 * This class is created for keeping all the reusable commonly used methods performing UI actions
	 * Note : As of now i have kept only few , we can keep adding reusable methods as and when needed 
	 * 
	 */

	public static WebDriver driver ;
	public static Properties prop;

	Actions action = null;

	
	/**
	 * This method is used to find the web element based on the type of locator
	 * passed and return the webelemnt
	 * 
	 * @param it accepts two params: 1. locator type and 2. locatorValue , this is
	 *           the element identified on web page
	 * @return it returns webelement object
	 */
	
	public WebElement getWebElement(String locatorType, String locatorValue) {
		prop = Initializer.init_prop();
		driver = Initializer.init_driver(prop.getProperty("browserType"));
		WebElement webElement = null;
		switch (locatorType) {
		case "id": {
			try {
				webElement = driver.findElement(By.name(locatorValue));
				break;
			} catch (NoSuchElementException e) {

			}
		}

		case "name": {
			webElement = driver.findElement(By.name(locatorValue));
			break;
		}

		case "css": {
			webElement = driver.findElement(By.cssSelector(locatorValue));
			break;
		}

		case "xpath": {
			webElement = driver.findElement(By.xpath(locatorValue));
			break;
		}

		case "className": {
			webElement = driver.findElement(By.className(locatorValue));
			break;
		}

		case "linkText": {
			webElement = driver.findElement(By.linkText(locatorValue));
			break;
		}

		case "partialLinkText": {
			webElement = driver.findElement(By.partialLinkText(locatorValue));
			break;
		}
		default:
			webElement = null;

		}
		return waitForElementToBeVisible(webElement, 20);
	}
	
	/**
	 * This method is used to wait for the web elementto be visible based on time
	 * given
	 * 
	 * @param it accepts two params: 1. Webelement and 2. Max time durtion
	 * @return it returns webelement object
	 */

	protected WebElement waitForElementToBeVisible(WebElement webElement, long time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		try {
			wait.until(ExpectedConditions.visibilityOf(webElement));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
		}
		return webElement;
	}
	
	/**
	 * This method is used to wait for the web element to be clickable based on time
	 * given.
	 * 
	 * @param it accepts two params: 1. Webelement and 2. Max time durtion.
	 * @return it returns webelement object.
	 */

	protected WebElement waitForElementToBeClickable(WebElement webElement, long time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(webElement));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
		}
		return webElement;
	}
	
	/**
	 * This method is used for close all the browser session.
	 * 
	 * @param no parameter
	 * @return returns void
	 */

	public void tearbrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
		}
	}
	
	/**
	 * This method is used for scroll to webelemnt using java script executor
	 * 
	 * @param no parameter
	 * @return returns void
	 */

	public void scrollToView() {		
		try {
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("window.scrollBy(0,-700);", "");
		} catch (Exception e) {
			Thread.currentThread().interrupt();
		}
	}
	
	/**
	 * This method is used for scroll to webelemnt using actions class
	 * 
	 * @param no parameter
	 * @return returns void
	 */

	public void scrollToElement(WebElement element) {
		try {
			action = new Actions(driver);
			action.scrollToElement(element).click().perform();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
		}
	}
	
	/**
	 * This method is used for scroll to webelemnt using actions class
	 * 
	 * @param no parameter
	 * @return returns void
	 */

	public void moveToElement(WebElement element) {		
		try {
			action = new Actions(driver);
			action.moveToElement(element).perform();
		} catch (Exception e) {

		}
	}
	
	/**
	 * This method is used for new tab or child window using window handler
	 * 
	 * @param no parameter
	 * @return returns void
	 */

	public void switchToChildWindow() {
		
		String parent = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String child : windows) {
			if (!child.equals(parent)) {

				driver.switchTo().window(child);
			}
		}
	}
	
	/**
	 * This method is used to perform the clock operaton on web page 
	 * 
	 * @param it accepts two params: 1. locator type and 2. locatorValue
	 * @return returns void
	 */

	public void performClick(String locatorType, String locatorValue) {		
		waitForElementToBeClickable(getWebElement(locatorType, locatorValue), 20);
		try {
			getWebElement(locatorType, locatorValue).click();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
		}
	}
	
	/**
	 * This method is used to perform the clock operaton on web page 
	 * 
	 * @param it accepts two params: 1. locator type and 2. locatorValue
	 * @return returns void
	 */

	public void enterText(String locatorType, String locatorValue, String text) {		
		try {
			getWebElement(locatorType, locatorValue).sendKeys(text);
		} catch (Exception e) {
			Thread.currentThread().interrupt();
		}
	}

    // Generic polling method
	    public <T> T waitForCondition(WebDriver driver, Function<WebDriver, T> condition, Duration timeoutInSeconds, Duration pollingIntervalInMillis) {
	    	WebDriverWait wait = new WebDriverWait (driver, timeoutInSeconds, pollingIntervalInMillis);
	        return wait.until(condition);
	    }
	
}
