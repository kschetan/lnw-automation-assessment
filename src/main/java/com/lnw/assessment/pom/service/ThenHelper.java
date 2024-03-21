package com.lnw.assessment.pom.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.lnw.assessment.pom.pages.CartPage;
import com.lnw.assessment.pom.utils.WorldObject;

public class ThenHelper {
	
	/*
	 * ThenHelper : is used for writing validation methods related to then step in feature file
	 * 
	 */

	private static Logger log = LoggerFactory.getLogger(ThenHelper.class);

	CartPage cartPage = new CartPage();

	public void validateThePrice(List<String> itemNames) {
		Double subtotal = 0.00;
		Double priceOnProductPage = 0.00;

		for (String itemName : itemNames) {
			log.info("Get the subtotal price");
			subtotal = Double.parseDouble(cartPage.getSubTotal(itemName));

			log.info("Fetch the price of item <%> on product page and parse into double", itemName);
			priceOnProductPage = Double.parseDouble(WorldObject.world.get(itemName));
            log.info("add the both the indivisual price captured at the product page");
			priceOnProductPage = +priceOnProductPage;
		}

		log.info("Asserting subtotal price and price on product page");
		Assert.assertEquals(subtotal, priceOnProductPage);
	}
}
