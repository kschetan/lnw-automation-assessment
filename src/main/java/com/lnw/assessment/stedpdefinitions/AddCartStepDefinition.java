package com.lnw.assessment.stedpdefinitions;

import java.util.Arrays;
import java.util.List;

import com.lnw.assessment.pom.service.GivenHelper;
import com.lnw.assessment.pom.service.ThenHelper;
import com.lnw.assessment.pom.utils.CommonUtils;

import io.cucumber.java8.En;

public class AddCartStepDefinition implements En {
	
	GivenHelper givenHelper = new GivenHelper();
	ThenHelper thenHelper = new ThenHelper();
	CommonUtils commonUtils = new CommonUtils();	
	
	public AddCartStepDefinition() {
		Given("I am on amazon web page", () ->{	
			givenHelper.navigatetToAmazonPage();
		
		});

		And("I Search for an item {string} and press enter",(String itemName)->{
			givenHelper.searchItem(itemName);
		});
		
		And("I Select the {string} item from the result page", (String orderNumber)->{
			givenHelper.selectOrderItem(Integer.parseInt(orderNumber));
		});
		
		And ("I navigate to the product page and capture the product price of {string}",(String item)->{
			givenHelper.getProductPrice( item);
		});
		
		And ("I add the item to the cart by clicking on Add to Cart button",()->{
			givenHelper.addToCart();
		});
		
		And ("I open the Cart by clicking the top-right cart icon",()->{
			givenHelper.navigateToCart();
		});
		
		Then ("I validate that the sub total amount on cart page is identical to the product page for {string}",(String items)->{
			List<String> listItems = Arrays.asList(items.split(","));
			
			thenHelper.validateThePrice(listItems);
		
		});
		
//		Then ("I validate that the sub total amount on cart page is identical to the product page",(DataTable items)->{
//			thenHelper.validateThePrice(items.asList(String.class));
		
//		});
		
		And ("I navigate to Amazon Home page",()->{
			givenHelper.navigateToAmazonHomePage();
		});
		
//		And ("I close the browser",()->{
//			givenHelper.closeBrowser();
//		});
	}
}
