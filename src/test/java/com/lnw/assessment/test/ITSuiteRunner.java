package com.lnw.assessment.test;

import org.testng.annotations.DataProvider;

/*
 * This is test runner class , scenario Scenario execution starts from here.
 */

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features",
		glue = {"com.lnw.assessment.stedpdefinitions", "Hooks"},
	//	tags = "@sanity",
		plugin = {"pretty"},
		monochrome = true,
		dryRun = false,
		publish = true
		)
public class ITSuiteRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
