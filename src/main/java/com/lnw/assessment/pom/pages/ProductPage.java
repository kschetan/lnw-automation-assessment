package com.lnw.assessment.pom.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.lnw.assessment.pom.utils.CommonUtils;
import com.lnw.assessment.pom.utils.WorldObject;

public class ProductPage extends CommonUtils {
	
	/*
	 *  ProductPage : Capture selector and actions related to Product Page 
	 *  Extended CommonUtill to make all the reusable method available to this class.
	 *  Interface is used for writing all the common selectors and methods which can be used across the classes.
	 */

	private static final String PRODUCT_PAGE_PRICE = "//div[contains(@id , 'corePriceDisplay_')]//span[@class='a-price-whole']";
	private static final String ADD_TO_CART = "//input[@id='add-to-cart-button']";
	private static final String CART_PRODUCT_PAGE = "//span[@id='attach-sidesheet-view-cart-button']";
	private static final String CART = "//div[@id='nav-cart-count-container']";
	private static final String SKIPP_WARRANTY_POPUP = "//span[text()='Skip'and @id='attachSiNoCoverage-announce']";

	public boolean getProductPrice(String item) {
		switchToChildWindow();
		WorldObject.world.put(item, getWebElement("xpath", PRODUCT_PAGE_PRICE).getText().replaceAll(",", ""));
		return ! getWebElement("xpath", PRODUCT_PAGE_PRICE).getText().replaceAll(",", "").isEmpty();
	}

	public void addToCart() {
		scrollToView();
		waitForElementToBeVisible(getWebElement("xpath", ADD_TO_CART), 20);
		getWebElement("xpath", ADD_TO_CART).click();
	}

	public void navigateToCart() {
		if (waitForElementToBeVisible(getWebElement("xpath", CART_PRODUCT_PAGE), 30).isDisplayed()) {

			WebElement element = waitForCondition(driver, d -> d.findElement(By.xpath(CART_PRODUCT_PAGE)),
					Duration.ofMillis(1000), Duration.ofSeconds(10));
			element.click();
		} else if (waitForElementToBeVisible(getWebElement("xpath", SKIPP_WARRANTY_POPUP), 30).isDisplayed()) {
			WebElement element = waitForCondition(driver, d -> d.findElement(By.xpath(SKIPP_WARRANTY_POPUP)),
					Duration.ofMillis(1000), Duration.ofSeconds(10));
			element.click();
			moveToElement(getWebElement("xpath", SKIPP_WARRANTY_POPUP));
			element.click();
			getWebElement("xpath", CART).click();
		} else {
			waitForElementToBeVisible(getWebElement("xpath", CART), 20).click();
		}
	}

}
