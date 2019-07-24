package com.automation.omt.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementUtils {
	ConfigUtil configUtil = new ConfigUtil();
	long timeOut = Long.parseLong(configUtil.getProperty("default.wait.timeout"));
	WebDriverWait wait = new WebDriverWait(DriverUtils.getWebDriver(), timeOut);

	public void waitForElementToAppear(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void clickUsingJS(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) DriverUtils.getWebDriver(); // need
																						// to
																						// know
		executor.executeScript("arguments[0].click();", element);
	}

	public void safeClick(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			clickUsingJS(element);
		}
	}

	public void waitForElementToDisappear(WebElement element) {
		try {
			wait.until(ExpectedConditions.invisibilityOf(element));
		} catch (Exception e) {

		}
	}

	public void waitForElementToClickable(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
