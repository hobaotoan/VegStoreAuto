package cucumber.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.page.AbstractPage;


public class ProgressMethods extends AbstractPage implements BaseTest {
    /**
     * Method to Explicitly wait for element to be displayed
     *
     * @param accessName : String : Locator value
     * @param duration   : String : Time to wait for element to be displayed
     * @throws TestCaseFailed 
     */
    public void waitForElementToDisplay(WebDriver driver, String accessName, String duration) throws TestCaseFailed {
        By byEle = selectElementByType.getIdentifier(accessName);
        WebDriverWait wait = (new WebDriverWait(driver, Integer.parseInt(duration) * 1000L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(byEle));
    }

    /**
     * Method to Explicitly wait for element to be enabled=click
     *
     * @param accessName : String : Locator value
     * @param duration   : String : Time to wait for element to be clickable
     * @throws TestCaseFailed 
     */
    public void waitForElementToClick(WebDriver driver,String accessName, String duration) throws TestCaseFailed {
        By byEle = selectElementByType.getIdentifier(accessName);
        WebDriverWait wait = (new WebDriverWait(driver, Integer.parseInt(duration) * 1000L));
        wait.until(ExpectedConditions.elementToBeClickable(byEle));
    }

}

