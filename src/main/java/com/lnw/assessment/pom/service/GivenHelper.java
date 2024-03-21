package com.lnw.assessment.pom.service;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.lnw.assessment.pom.pages.CartPage;
import com.lnw.assessment.pom.pages.LandingPage;
import com.lnw.assessment.pom.pages.ProductPage;
import com.lnw.assessment.pom.utils.CommonUtils;
import com.lnw.assessment.pom.utils.Initializer;

public class GivenHelper {
	
	/*
	 * GivenHelper : here we are combining each actions captured in the pom pages and writing the assertion  related to all the actions performed 
	 * (We capture validation related to Given, When an And steps)
	 */
	
	CommonUtils commonUtils = new CommonUtils();
	LandingPage landingPage = new LandingPage();
	ProductPage productPage = new ProductPage();
	CartPage cartPage = new CartPage();

	private static Logger log = LoggerFactory.getLogger(GivenHelper.class);

	public static WebDriver driver;
	public static Properties prop;

	public void navigatetToAmazonPage() {
		prop = Initializer.init_prop();
		driver = Initializer.init_driver(prop.getProperty("browserType"));
		log.info("Navigating to amazon web page");
		driver.get(prop.getProperty("url"));
	}

	public void searchItem(String item) {
		log.debug("clicking on search field");
		landingPage.clickOnSearch();

		log.debug("Entering the search text in seach field");
		Assert.assertEquals(landingPage.enterDetailsAndClickEnter(item), true);
	}

	public void selectOrderItem(Integer order) {
		log.debug("Select the  %s items from the search result", order);
		landingPage.selectOrderItem(driver, order);
	}

	public void getProductPrice(String item) {
		log.debug("Get the product price and save into the world");
		Assert.assertEquals(productPage.getProductPrice(item), true);
	}

	public void addToCart() {
		log.debug("Click on Add to cart button");
		productPage.addToCart();
	}

	public void navigateToCart() {
		log.debug("Navigate to the cart");
		productPage.navigateToCart();
	}

	public void navigateToAmazonHomePage() {
		log.debug("Navigate to Amazon home page");
		cartPage.clickOnAmazonIcon();
	}

//	public void closeBrowser() {
//		log.debug("Close the browser");
//		driver.quit();
//	}
}
