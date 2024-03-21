package com.lnw.assessment.stedpdefinitions;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.lnw.assessment.pom.service.GivenHelper;
import com.lnw.assessment.pom.utils.Initializer;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	private static Logger log = LoggerFactory.getLogger(GivenHelper.class);
	
	public static WebDriver driver;
	public static Properties prop;

	@BeforeSuite
	public void getProperty() {
		log.info("Initializing the Properties file");
		prop = Initializer.init_prop();
	}

	@BeforeTest
	public void launchBrowser() {
		String browser = prop.getProperty("browserType");
		log.info("Launching the browser");
		driver = Initializer.init_driver(browser);
		
	}

	@AfterTest
	public void quitBrowser() {
		log.info("Closing the browser");
		driver.quit();
	}

//	@After(order = 1)
//	public void tearDown(Scenario scenario) {
//		if (scenario.isFailed()) {
//			// take screenshot:
//			String screenshotName = scenario.getName().replaceAll(" ", "_");
//			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//			scenario.attach(sourcePath, "image/png", screenshotName);
//		}
//	}	 	
}
