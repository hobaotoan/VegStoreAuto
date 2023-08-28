package cucumber.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BorderElement implements BaseTest {
	private final DecorateFormat decorate = new DecorateFormat();

	public void makeBorder(WebDriver driver, WebElement element) {
		setAttribute(driver, element, decorate.STYLE, decorate.COLOR_PROPERTIES);
	}
	
	public void setAttribute(WebDriver driver, WebElement element, String attName, String attValue) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript(decorate.JS_ARGUMENT, element, attName, attValue);
	}

}
