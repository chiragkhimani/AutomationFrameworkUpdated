package com.automation.omt.steps;

import com.automation.omt.pages.HomePage;
import com.automation.omt.utils.Helper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HomePageSteps {
	HomePage homePage = new HomePage();

	@Given("Verify user is on homepage")
	public void verify_user_is_on_homepage() {
		homePage.verifyHomePage();
	}

	@Given("User selects {string} tab")
	public void user_selects_tab(String menu) {
		homePage.selectMenu(menu);
	}
	
	@Given("click on Create Offer button")
	public void click_on_Create_Offer_button() {
		homePage.clickCreateOffer();
	}	
}
