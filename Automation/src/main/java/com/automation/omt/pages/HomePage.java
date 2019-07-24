package com.automation.omt.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.automation.omt.utils.ConfigUtil;
import com.automation.omt.utils.DriverUtils;
import com.automation.omt.utils.Helper;
import com.automation.omt.utils.WebElementUtils;

public class HomePage {
	private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class.getName());
	
	private static final String XPATH_MENU_ITEM = "//a[contains(@id,'omt-menu') and text()='%s']";

	@FindBy(id = "omt-logout")
	private WebElement logoutBtn;

	@FindBy(id = "omt-logo")
	private WebElement logo;

	@FindBy(id = "omt-menu-home")
	private WebElement menuItemHome;

	@FindBy(xpath = "//div[@id='search-container']//button[text()='Create Offer']")
	private WebElement createOfferBtn;

	@FindBy(id="offersOffers")
	private WebElement offerTab;
	WebDriver driver;
	ConfigUtil configUtil = new ConfigUtil();
	WebElementUtils webElementUtils = new WebElementUtils();

	public HomePage() {
		driver = DriverUtils.getWebDriver();
		PageFactory.initElements(driver, this);
	}

	public void verifyHomePage() {
		webElementUtils.waitForElementToAppear(logo);
		webElementUtils.waitForElementToAppear(menuItemHome);
		Helper.pause(8000);
		Assert.assertTrue("Logo is not displayed on homepage", webElementUtils.isDisplayed(logo));
		Helper.pause(3000);
		Assert.assertTrue("Sign Out button is not displayed on homepage", webElementUtils.isDisplayed(logoutBtn));
		Assert.assertTrue("Menu item Home is not displayed on homepage", webElementUtils.isDisplayed(menuItemHome));
	}

	public void selectMenu(String menu) {
		Helper.pause(3000);
		String loc = String.format(XPATH_MENU_ITEM, menu);
		webElementUtils.safeClick(driver.findElement(By.xpath(loc)));
	}

	public void clickCreateOffer() {
		webElementUtils.waitForElementToAppear(offerTab);
		webElementUtils.safeClick(offerTab);
		webElementUtils.waitForElementToAppear(createOfferBtn);
		webElementUtils.safeClick(createOfferBtn);
		LOGGER.info("User is in HOMEPAGE");
	}
}
