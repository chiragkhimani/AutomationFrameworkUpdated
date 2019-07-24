package com.automation.omt.utils;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverUtils {
	static private WebDriver driver;

	public static WebDriver getWebDriver() {
		if (driver == null) {
			initDriver();
		}
		return driver;
	}

	public static void initDriver() {
		ConfigUtil configUtil = new ConfigUtil();
		String browser = configUtil.getProperty("selenium.browser");
		try {

			if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "driver//geckodriver");
				driver = new FirefoxDriver();
				// Creating Chrome driver object
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "driver//chromedriver");
				driver = new ChromeDriver();

			} else if (browser.equalsIgnoreCase("safari")) {
				driver = new SafariDriver();

			} else if (browser.equalsIgnoreCase("headless")) {
				ChromeOptions option = new ChromeOptions();
				option.addArguments("headless");
				option.addArguments("no-sandbox");
				option.addArguments("disable-extensions");
				option.addArguments("disable-gpu");
				option.addArguments("whitelisted-ips=");
				option.addArguments("ignore-certificate-errors");
				option.addArguments("disable-software-rasterizer");

				// Proxy proxy = new Proxy();
				// proxy.setHttpProxy("http://anycast.sig.target.com:8080");

				DesiredCapabilities capabilities = new DesiredCapabilities();
				// capabilities.setCapability(CapabilityType.PROXY, proxy);
  			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				capabilities.setCapability(ChromeOptions.CAPABILITY, option);

				// System.setProperty("webdriver.chrome.verboseLogging", "true");
				// System.setProperty("webdriver.chrome.driver", "chromedriver");
				driver = new ChromeDriver(capabilities);

			} else if (browser.equals("remote")) {
				System.setProperty("webdriver.chrome.driver", "driver//chromedriver");
//				driver = new RemoteWebDriver(new URL("http://169.254.151.168:5556/wd/hub"), DesiredCapabilities.chrome()); // drone
				driver = new RemoteWebDriver(new URL(" http://10.112.137.32:5556/wd/hub"), DesiredCapabilities.chrome()); // Grid
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
