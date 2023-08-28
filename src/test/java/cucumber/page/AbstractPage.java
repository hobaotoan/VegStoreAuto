package cucumber.page;

import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScriptTimeoutException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.paulhammant.ngwebdriver.NgWebDriver;

import cucumber.properties.ReadProperties;
import cucumber.utils.ApplicationProperties;
import cucumber.utils.BaseTest;
import cucumber.utils.ClickabilityOfElementByLocator;
import cucumber.utils.Constants;
import cucumber.utils.DecorateFormat;
import cucumber.utils.DriverManager;
import cucumber.utils.InvisibilityOfElement;
import cucumber.utils.InvisibilityOfElementByLocator;
import cucumber.utils.TestCaseFailed;
import cucumber.utils.VisibilityOfElementByLocator;
import io.cucumber.core.backend.TestCaseState;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestCase;

public abstract class AbstractPage implements BaseTest{
    private final Logger logger = LoggerFactory.getLogger(AbstractPage.class);
    
    public WebElement element;
    public Actions action;
    
	private final DriverManager driverManager = new DriverManager();

	private final ReadProperties properties = new ReadProperties();
	private final DecorateFormat decorate = new DecorateFormat();
	
	public final String URL = ApplicationProperties.INSTANCE.getUrl();
	public final String URLOFDA = ApplicationProperties.INSTANCE.getUrlOfDA();
	public final String ACTUAL_TEXT = ApplicationProperties.INSTANCE.getFormatActualMessage();
	public final String EXPECTED_TEXT = ApplicationProperties.INSTANCE.getFormatExpectedMessage();
	public final String JIRA_ISSUE = ApplicationProperties.INSTANCE.getJiraIssue();

	private final String DELEGATE = "delegate";
	private final String TESTCASE = "testCase";
	private final String MESSAGE_ERROR = "Cannot locate using by: ";
	public final String MESSAGE_COMMENT = "Please double check yours test case and test script again, be carefull !!!";

	private int currentStepDefIndex = 0;
	private String  currentStepDescr = null;
	private List<String> description = new ArrayList<String>();

	
	public WebDriver getDefaultDriver() throws MalformedURLException {
		return driverManager.getDefaultDriver();
	}
	
	public WebDriver getDriver() {
		return driverManager.getDriver();
	}
	
	public String getDataTest(String key) {
		return properties.getDataObject(key);
	}
	
	public String getLines() {
		return decorate.LINES;
	}
	
	public String getLineSepearator() {
		return decorate.LINE_SEPARATOR;
	}
	
	
	public String messageFormat(String expected, String actual) {
		String getFormat =  decorate.LINES_STAR 
									   + decorate.COLOR_ACTUAL 
									   + actual
									   + decorate.LINE_SEPARATOR 
									   + decorate.COLOR_EXPECTED 
									   + expected
									   + decorate.LINES_STAR;
		return getFormat;
	}
	
	/**
	 * Return String format 
	 * @param List Step Gerkin language
	 * 
	 * ***/
	public String formatGherkinText(List<String> contentGerkins) {
		String textFormatted = contentGerkins.toString().replace(decorate.BRACKETS_OPEN, decorate.EMPTY)
														.replace(decorate.COMMA, decorate.EMPTY)
														.replace(decorate.BRACKETS_CLOSE, decorate.EMPTY);
		return textFormatted;
	}
	
	public List<String> getStepOfScenario(Scenario scenario) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field file = scenario.getClass().getDeclaredField(DELEGATE);
        file.setAccessible(true);
        TestCaseState tcs = (TestCaseState) file.get(scenario);

        Field file_test_case = tcs.getClass().getDeclaredField(TESTCASE);
        file_test_case.setAccessible(true);
        TestCase test_case = (TestCase) file_test_case.get(tcs);

        List<PickleStepTestStep> stepDefs = test_case.getTestSteps()
                .stream()
                .filter(checkInsatnce -> checkInsatnce instanceof PickleStepTestStep)
                .map(checkInsatnce -> (PickleStepTestStep) checkInsatnce)
                .collect(Collectors.toList());

        PickleStepTestStep currentStepDef = stepDefs.get(currentStepDefIndex);
        
        currentStepDescr =  System.lineSeparator() + currentStepDef.getStep().getKeyword() + decorate.WHITE_SPACE + currentStepDef.getStep().getText() + System.lineSeparator();
        currentStepDefIndex += 1;   
 
        description.add(currentStepDescr);
		return description;
	}
	

	public void endOfRunTest(Boolean check_flag, Scenario scenario, List<String> descriptions) throws InterruptedException {
		if (check_flag) {
			if (scenario.isFailed()) {
				
				String currentActual = null;
				String currentExpected = null;

				if (assertionObj.changeActual(assertionObj) != null && assertionObj.changeExpected(assertionObj) !=null) {
					currentActual = assertionObj.changeActual(assertionObj);
					currentExpected = assertionObj.changeExpected(assertionObj);
				}else {
					currentActual = MESSAGE_ERROR + assertionObj.getIdentifier(assertionObj);
					currentExpected = MESSAGE_COMMENT;
				}
				descriptions.add(getLines());
				descriptions.add(getLineSepearator() + ACTUAL_TEXT   + currentActual   + getLineSepearator());
				descriptions.add(getLineSepearator() + EXPECTED_TEXT + currentExpected + getLineSepearator());
				descriptions.add(getLines());
				logger.info(formatGherkinText(descriptions));
				captureImage(scenario);

			} else {
				captureImage(scenario);				
				
			}
		}
		else {
			if (scenario.isFailed()) {
				captureImage(scenario);
			} else {
				captureImage(scenario);
			}
		}
	}

	public void waitDefault(int time) throws InterruptedException {
		Thread.sleep(time * 1000);
	}
	
	public WebElement focusOnEle(String accessName) throws TestCaseFailed {
		return focusOnLastElement(accessName).get(0);
	}
	
	/**
	 * Method focus on first element visible in DOM
	 * 
	 * @param String access name
	 * @return List Webelement
	 * @throws TestCaseFailed 
	 * */
	public List<WebElement> focusOnLastElement(String accessName) throws TestCaseFailed {
		waitUntilAngularReady();        
		assertionObj.checkElementFindedOrNot(accessName);
		action = new Actions(getDriver());
		List<WebElement> element = waitShort()
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selectElementByType.getIdentifier(accessName)));
		int index = element.size();
		WebElement eleIndex = element.get(index - 1);
        action.moveToElement(eleIndex).perform();
		borderObj.makeBorder(getDriver(), eleIndex);
		return element;
	}
	
	/**
	 * Method to return element status - enabled?
	 *
	 * @param accessName : String : Locator value
	 * @return Boolean
	 * @throws TestCaseFailed 
	 * @throws Exception
	 */
	public WebElement isElementLocated(String accessName) throws TestCaseFailed {
		element = waitShort()
				.until(ExpectedConditions.presenceOfElementLocated(selectElementByType.getIdentifier(accessName)));
		return element;
	}

    /**
     * wait for element visible by locator
     */
    @SuppressWarnings("unused")
	private void waitForElementVisible(By locator) {
        try {
            waitLong().until(new VisibilityOfElementByLocator(locator));
        } catch (Exception ignored) {
        }
    }

    /**
     * wait for element Invisible by locator
     */
    @SuppressWarnings("unused")
	private void waitForElementInVisible(By locator) {
        try {
            new InvisibilityOfElementByLocator(locator);
        } catch (Exception ignored) {
        }
    }

    /**
     * wait for element Invisible by locator
     */
    @SuppressWarnings("unused")
	private void waitForElementInVisible(WebElement element) {
        try {
            new InvisibilityOfElement(element);
        } catch (Exception ignored) {
        }
    }

    /**
     * wait for element clickable by locator
     */
    @SuppressWarnings("unused")
	private void waitForElementClickable(By locator) throws NoSuchFieldException {
        try {
            new ClickabilityOfElementByLocator(locator);
        } catch (Exception t) {
            throw new NoSuchFieldException("could not interact with the element by locator " + locator);
        }
    }
	
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
	 
	 public void closeBrowser() {
			getDriver().quit();
	}
	 /**
		 * Take picture
		 * @param scenario
		 * **/
	public void captureImage(Scenario scenario) {
		String filename = format_file(scenario);
		byte[] sourcePath = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
		scenario.attach(sourcePath, decorate.IMAGES_TYPE, filename);
	}
	
	public String format_file(Scenario scenario) {
		return scenario.getName().replaceAll(decorate.SPACE, decorate.UNDER_CORE).toString();
	}
	
}
