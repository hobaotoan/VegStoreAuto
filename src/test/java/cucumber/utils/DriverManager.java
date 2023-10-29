package cucumber.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	private final Logger logger = LoggerFactory.getLogger(DriverManager.class);

	private WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * By default to web driver will be chrome
	 * <p>
	 * Override it by acbpassing -Dbrowser=Chrome to the command line arguments
	 * Test
	 * @return webdriver
	 */
	private static WebDriver chooseDriver() throws MalformedURLException {
		String preferredDriver = System.getProperty("browser", "chrome");
		boolean headless = System.getProperty("headless", "false").equals("true");

		switch (preferredDriver.toLowerCase()) {
		case "safari":
			return new SafariDriver();
		case "edge":
			return new EdgeDriver();
		case "chrome":
			WebDriverManager.chromedriver().setup();
			final ChromeOptions chromeOptions = new ChromeOptions();

			if (headless) {
				chromeOptions.addArguments("--headless");
			}

			chromeOptions.addArguments("window-size=1920,1080");
			chromeOptions.addArguments("-incognito");
			chromeOptions.addArguments("start-maximized");
			chromeOptions.addArguments("disable-infobars");
			chromeOptions.addArguments("--disable-extensions");
			chromeOptions.addArguments("--disable-gpu");
			chromeOptions.addArguments("--disable-dev-shm-usage");	
			chromeOptions.addArguments("--no-sandbox");
			chromeOptions.addArguments("--disable-application-cache");
			chromeOptions.addArguments("--remote-allow-origins=*");
			chromeOptions.addArguments("--disable-notifications");
			chromeOptions.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));

			return new RemoteWebDriver(new URL("http://13.229.74.9:4444/wd/hub"), chromeOptions);
//			return new ChromeDriver(chromeOptions);
		default:
			final FirefoxOptions ffOptions = new FirefoxOptions();

			if (headless) {
				ffOptions.setHeadless(true);
			}
//			return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), ffOptions);
			return new FirefoxDriver(ffOptions);
		}
	}

	public WebDriver getDefaultDriver() throws MalformedURLException {
		String enviroment = "desktop";
		switch (enviroment) {
		case "desktop":
			driver = chooseDriver();
			logger.info("Running on Desktop");
			break;
		default:
			logger.info("\nException : Invalid platform " + enviroment);
			System.exit(0);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
	}

}
