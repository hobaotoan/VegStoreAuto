package cucumber.step;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import cucumber.page.AbstractPage;
import cucumber.utils.TestCaseFailed;
import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static java.awt.SystemColor.window;

public class ForwardStepDefinations extends AbstractPage {

	List<String> descriptions = null;
	List<String> nameProducts = new ArrayList<>();
	List<String> priceProducts = new ArrayList<>();
	List<String> dataProduct = new ArrayList<>();

	@Before
	public void setUp() throws MalformedURLException {
		getDefaultDriver();
	}


	@Given("^I navigate to Veg Store website$")
	public void luanchApp() throws Exception {
		getDriver().get(URL);
	}

	@Then("^I enter \"([^\"]*)\" into input \"([^\"]*)\" field$")
	public void enter_text(String text, String accessName) throws Exception {
		waitDefault(2);
		inputObj.enterTextField(text, focusOnEle(accessName));
	}

	@Then("^I click on \"(.*?)\" button$")
	public void click_ele(String accessName) throws TestCaseFailed, InterruptedException {
		waitDefault(2);
		clickObj.moveAndClickEle(focusOnEle(accessName),getDriver());
	}

	@Then("^I press enter into \"(.*?)\" field$")
	public void action_enter_keyboard(String accessName) throws TestCaseFailed {
		clickObj.actionEnterInEle(focusOnEle(accessName));
	}
	
	@Then("^I choose \"([^\"]*)\" option from dropdown \"([^\"]*)\"$")
	public void choose_option_from_dropdown(String value,String accessName) throws TestCaseFailed, Exception {
		clickObj.clickEleUseKeyBoard(value,focusOnEle(accessName));
	}

	@Then("^I should\\s*((?:not)?)\\s+see \"(.*?)\" on \"([^\"]*)\"$")
	public void check_element_text(String present, String value, String accessName) throws TestCaseFailed {
		assertionObj.checkElementTextCompare(value, focusOnEle(accessName), present.isEmpty());
	}

	@Then("^I wait for (\\d+) sec$")
	public void wait(int time) throws NumberFormatException, InterruptedException {
		progressObj.waitDefault(time);
	}
	
	@Then("^I should see \"(.*?)\" displayed on \"(.*?)\" list screen$")
	public void check_text_displayed(String text, String accessName) throws TestCaseFailed {
		assertionObj.checkTextDisplayed(text, focusOnLastElement(accessName));
	}
	
	@Then("^I should\\s*((?:not)?)\\s+see \"(.*?)\" will be displayed on UI$")
	public void check_element_displayed_on_ui(String present, String accessName) throws TestCaseFailed, InterruptedException {
		assertionObj.checkElementPresence(focusOnEle(accessName), present.isEmpty());
	}

	
	@Then("^I should\\s*((?:not)?)\\s+see \"(.*?)\" will be enabled on UI$")
	public void check_element_enabled_on_ui(String present, String accessName) throws TestCaseFailed {
		assertionObj.checkElementEnableToAction(focusOnEle(accessName), present.isEmpty());
	}

	@Then("^I get list name products with \"(.*?)\" list products$")
	public void get_list_name_products(String accessName) throws TestCaseFailed {
		nameProducts = assertionObj.getListNameProduct(focusOnLastElement(accessName));
	}

	@Then("^I get list price products with \"(.*?)\" list products$")
	public void get_list_price_products(String accessName) throws TestCaseFailed {
		priceProducts = assertionObj.getListPriceProduct(focusOnLastElement(accessName));
		System.out.println(priceProducts);
	}

	@Then("^I get data of product with \"(.*?)\"$")
	public void get_data_product(String accessName) throws TestCaseFailed {
		dataProduct.add(assertionObj.getDataProduct(focusOnEle(accessName)));
	}

	@Then("^I get image link of product with \"(.*?)\"$")
	public void get_image_product(String accessName) throws TestCaseFailed {
		dataProduct.add(assertionObj.getImageProduct(focusOnEle(accessName)));
	}

	@Then("^I should see content details displayed on \"(.*?)\"$")
	public void check_content_displayed(String accessName) throws TestCaseFailed {
		assertionObj.checkContentDisplayed(dataProduct, focusOnEle(accessName));
	}

	@Then("^I should see \"(.*?)\" list name product will change after sorted$")
	public void list_name_change_after_sorted(String accessName) throws TestCaseFailed {
		assertionObj.compareTwoList(focusOnLastElement(accessName),nameProducts);
	}

	@Then("^I should see \"(.*?)\" list price product will change after sorted$")
	public void list_price_change_after_sorted(String accessName) throws TestCaseFailed {
		assertionObj.compareTwoListWithTrim(focusOnLastElement(accessName),priceProducts);
	}

	@Then("^I should see \"(.*?)\" in alert message$")
	public void check_alert_message(String text) throws TestCaseFailed {
		assertionObj.checkAlertMessage(getDriver(),text);
	}

	@Then("^I should be navigate to Login Page$")
	public void backLogin() throws Exception {
		getDriver().getCurrentUrl().equals("https://hobaotoan.github.io/VegStore/sign-in.html?");
	}

	@Then("^I should be navigate to Home Page$")
	public void backHome() throws Exception {
		getDriver().getCurrentUrl().equals("https://hobaotoan.github.io/VegStore/index.html?");
	}
	@Then("^I should be navigate to Product Page$")
	public void backProduct() throws Exception {
		getDriver().getCurrentUrl().equals("https://hobaotoan.github.io/VegStore/product.html");
	}

	@Then("^I move to \"(.*?)\" element$")
	public void scrolltoElement(String accessName) throws Exception {
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", focusOnEle(accessName));
	}

	
	@After
	public void afterScenario(Scenario scenario) throws InterruptedException {		
		Thread.sleep(5000);
		closeBrowser();
	}
	@AfterStep
	public void addScreenshot(Scenario scenario){

		//validate if scenario has failed
		if(scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "image");
		}

	}
}
