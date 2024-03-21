package com.lnw.assessment.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.lnw.assessment.pom.utils.CommonUtils;

public class LandingPage extends CommonUtils {
	
	/*
	 *  LandingPage : Capture selector and actions related to amazon home page 
	 *  Extended CommonUtill to make all the reusable method available to this class.
	 *  Interface is used for writing all the common selectors and methods which can be used across the classes.
	 */


	private static final String SEARCH_ITEM = "//*[@id='twotabsearchtextbox']";
	private static final String ITEM_ORDER = "//div[@*='s-search-result'][%s]//span[contains(@class,'base a-text-normal')]";

	public void clickOnSearch() {
		performClick("xpath", SEARCH_ITEM);
	}

	public boolean enterDetailsAndClickEnter(String item) {
		enterText("xpath", SEARCH_ITEM, item);
		getWebElement("xpath", SEARCH_ITEM).sendKeys(Keys.ENTER);
		return getWebElement("xpath", SEARCH_ITEM).isDisplayed();
	}

	public void selectOrderItem(WebDriver driver, int orderItem) {
		waitForElementToBeClickable(driver.findElement(By.xpath(String.format(ITEM_ORDER, orderItem))), 30);
		moveToElement(driver.findElement(By.xpath(String.format(ITEM_ORDER, orderItem))));
		driver.findElement(By.xpath(String.format(ITEM_ORDER, orderItem))).click();
	}
}
