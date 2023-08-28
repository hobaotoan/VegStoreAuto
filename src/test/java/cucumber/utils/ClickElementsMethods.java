package cucumber.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ClickElementsMethods implements BaseTest {

	/**
	 * Method to click on an element
	 * 
	 * @param accessNames : String : Locator identifier
	 */
	public void moveAndClickEle(WebElement element) {
		element.click();
	}

	/**
	 * Method to click on an element
	 * 
	 * @param accessNames : String : Locator identifier
	 * @return keyboard
	 */
	public void clickEleUseKeyBoard(String value,WebElement element) {
		Select selectByValue = new Select(element);
		selectByValue.selectByVisibleText(value);
	}

	/**
	 * Test
	 * @param element
	 */
	public void actionEnterInEle(WebElement element){
		element.sendKeys(Keys.ENTER);
	}

	/**
	 * Method to forcefully click on an element
	 * 
	 * @param accessName : String : Locator value
	 */
	public void clickForcefully(WebElement element, WebDriver driver) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	/**
	 * Method to Double click on an element
	 *
	 * @param accessName
	 */
	public void doubleClick(WebElement element, WebDriver driver) {

		Actions action = new Actions(driver);
		action.moveToElement(element).doubleClick().perform();
	}
}