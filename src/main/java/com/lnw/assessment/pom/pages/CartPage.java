package com.lnw.assessment.pom.pages;

import com.lnw.assessment.pom.utils.CommonUtils;

public class CartPage extends CommonUtils implements AbstractPage{
	
	/*
	 *  CartPage : Capture selector and actions related to add to cart page 
	 *  Extended CommonUtill to make all the reusable method available to this class.
	 *  Interface is used for writing all the common selectors and methods which can be used across the classes.
	 */

	private static final String SUB_TOTAL_PRICE = "//span[@id='sc-subtotal-amount-buybox']//span[contains(@class,'sc-price sc')]";	
	
	public String getSubTotal(String itemName) {
		return getWebElement("xpath",SUB_TOTAL_PRICE).getText().replaceAll(",", "");
	}
	
	public void clickOnAmazonIcon() {
		 getWebElement("xpath",AMAZON_ICON).click();
	}
}
