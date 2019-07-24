package com.automation.omt.steps;

import com.automation.omt.pages.LoginPage;

import cucumber.api.java.en.Given;

public class LoginSteps {
 
	LoginPage loginPage = new LoginPage();

	@Given("Launch test application")
	public void launch_test_application() {
		loginPage.openApplication();  
	}

	@Given("User login into application")
	public void user_login_into_application() {
		loginPage.doLogin();
	}

}
