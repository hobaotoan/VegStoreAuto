package cucumber.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import cucumber.page.AbstractPage;

public class DriverWait extends AbstractPage{
		
	public void waitForAngular() {
        waitUntilAngularReady();
    }

    public void waitForElementToLoad(WebElement element) throws NoSuchFieldException {
        waitForAngular();
        waitForElementVisible(element);
        waitForElementClickable(element);
    }

    public void waitForElementToLoad(By locator) throws NoSuchFieldException {
        waitForAngular();
        waitForElementVisible(locator);
        waitForElementClickable(locator);
    }
    
    public boolean waitForElementToGetText(By locator) {
        waitForAngular();
        return waitForElementVisible(locator);
    }
    
    /**
     * wait for element visible by element
     */
    private void waitForElementVisible(WebElement element) {
        try {
            waitLong().until(new VisibilityOfElement(element));
        } catch (Exception ignored) {
        }
    }

    /**
     * wait for element visible by locator
     * @return 
     */
    private boolean waitForElementVisible(By locator) {
        try {
            waitLong().until(new VisibilityOfElementByLocator(locator));
        } catch (Exception ignored) {
        }
		return false;
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
     * wait for element clickable by element
     */
    private void waitForElementClickable(WebElement element) throws NoSuchFieldException {
        try {
            new ClickabilityOfElement(element);
        } catch (Exception t) {
            throw new NoSuchFieldException("could not interact with the element " + element);
        }
    }

    /**
     * wait for element clickable by locator
     */
    private void waitForElementClickable(By locator) throws NoSuchFieldException {
        try {
            new ClickabilityOfElementByLocator(locator);
        } catch (Exception t) {
            throw new NoSuchFieldException("could not interact with the element by locator " + locator);
        }
    }

}
