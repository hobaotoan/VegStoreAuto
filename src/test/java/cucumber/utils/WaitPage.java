package cucumber.utils;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScriptTimeoutException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.paulhammant.ngwebdriver.NgWebDriver;

public class WaitPage extends DriverManager {
    private final Logger logger = LoggerFactory.getLogger(WaitPage.class);


	protected void waitUntilAngularReady() {

		final Boolean angularUnDefined = (Boolean) ((JavascriptExecutor) getDriver())
				.executeScript("return window.angular === undefined");

		if (!angularUnDefined) {
			Boolean angularInjectorUnDefined = (Boolean) ((JavascriptExecutor) getDriver())
					.executeScript("return angular.element(document).injector() === undefined");
			if (!angularInjectorUnDefined) {
				waitForAngularLoad();
				waitUntilJSReady();
				waitForJQueryLoad();
				ngDriverWait();
			}
		}
	}
	

	
	/**
	 * Wait for Angular loads using Ng Driver
	 */
	private void ngDriverWait() {
		final NgWebDriver ngWebDriver = new NgWebDriver((JavascriptExecutor) getDriver());
		try {
			ngWebDriver.waitForAngularRequestsToFinish();
		} catch (ScriptTimeoutException exception) {
			logger.info("Problems waiting for Angular to load with NgWeb Driver");
			logger.debug("Problems waiting for Angular to load with NgWeb Driver");
		}
	}

	private void waitForAngularLoad() {

		final String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";

		final ExpectedCondition<Boolean> angularLoad = driver -> Boolean
				.valueOf(((JavascriptExecutor) driver).executeScript(angularReadyScript).toString());

		boolean angularReady = Boolean
				.parseBoolean(((JavascriptExecutor) getDriver()).executeScript(angularReadyScript).toString());

		if (!angularReady) {
			waitLong().until(angularLoad);
		}
	}

	private void waitUntilJSReady() {
		final ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driver)
				.executeScript("return document.readyState").toString().equals("complete");

		boolean jsReady = ((JavascriptExecutor) getDriver()).executeScript("return document.readyState").toString()
				.equals("complete");

		if (!jsReady) {
			waitLong().until(jsLoad);
		}
	}

	private void waitForJQueryLoad() {
		final ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) driver)
				.executeScript("return jQuery.active") == 0);

		boolean jqueryReady = (Boolean) ((JavascriptExecutor) getDriver()).executeScript("return jQuery.active==0");

		if (!jqueryReady) {
			waitLong().until(jQueryLoad);
		}
	}

	public Wait<WebDriver> waitLong() {
		return new FluentWait<>(getDriver()).withTimeout(Duration.ofSeconds(Constants.timeoutLong))
				.pollingEvery(Duration.ofMillis(Constants.pollingLong))
				.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
	}
	
	 public Wait<WebDriver> waitShort() {
	        return new FluentWait<>(getDriver())
	                .withTimeout(Duration.ofSeconds(Constants.timeoutShort))
	                .pollingEvery(Duration.ofMillis(Constants.pollingShort))
	                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
	    }

	

}
