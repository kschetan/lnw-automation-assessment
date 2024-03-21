package com.lnw.assessment.pom.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Initializer {
	public static Properties prop;
	public static WebDriver driver;

	/**
	 * This method is used to load the properties from application.properties file
	 * @return it returns Properties prop object
	 */
	public static Properties init_prop() {
      if(prop==null) {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "//src//main//resources//application.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}}

		return prop;
	}

	/**
	 * This method is used to initialize the driver on the basis of given
	 * browser
	 * 
	 * @param browser
	 * @return this will return driver.
	 */
	public static WebDriver init_driver(String browser) {
		if(driver == null) {
			if (browser.equals(Constant.CHROME.toString())) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browser.equals(Constant.FIREFOX.toString())) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (browser.equals(Constant.SAFARI.toString())) {
				driver = new SafariDriver();
			} else {
				System.out.println("Please pass the correct browser value: " + browser);
			}}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}
}
