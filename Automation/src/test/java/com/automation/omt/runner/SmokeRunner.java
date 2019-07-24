package com.automation.omt.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

// Build-in reporter plug in for cucumber reporting

@RunWith(Cucumber.class)
@CucumberOptions(tags="@smoke", plugin = { "pretty", "html:target/cucumber-reports",
		"json:target/cucumber.json" },glue = "com.automation.omt.steps", features = "src//test//java//com//automation//omt//feature")

public class SmokeRunner {

	
}
