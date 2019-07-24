package com.automation.omt.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.automation.omt.utils.ConfigUtil;
import com.automation.omt.utils.DriverUtils;
import com.automation.omt.utils.WebElementUtils;

public class LoginPage {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginPage.class.getName());
	@FindBy(id = "loginID")
	private WebElement inputUsername;

	@FindBy(id = "pass")
	private WebElement intputPassword;

	@FindBy(xpath = "//button[@label='Login']")
	private WebElement loginBtn;

	WebDriver driver;
	ConfigUtil configUtil = new ConfigUtil();   // Get OMT URL, USR, PWD, Browser type
	WebElementUtils webElementUtils = new WebElementUtils();

	// Constructor
	public LoginPage() {
		driver = DriverUtils.getWebDriver(); // intialize driver here
		PageFactory.initElements(driver, this); // page object model, page
												// factory class, defining
												// locators
	}

	public void openApplication() {
		driver.get(configUtil.getProperty("application.url"));
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
	}

	public void doLogin() {
//		webElementUtils.waitForElementToAppear(inputUsername);
//		inputUsername.sendKeys(configUtil.getProperty("login.username"));
//		intputPassword.sendKeys(configUtil.getProperty("login.password"));
//		loginBtn.click();
		LOGGER.info("Mock logged in through NUID");
	}
}
