package com.automation.omt.steps;

import com.automation.omt.utils.DriverUtils;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	@Before
	public void setUp() {
		DriverUtils.initDriver();
	}

	@After
	public void quit() {
		DriverUtils.getWebDriver().quit();
	}

}
