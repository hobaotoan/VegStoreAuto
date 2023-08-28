package cucumber.utils;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.page.AbstractPage;

public class AssertionMethods extends AbstractPage implements BaseTest {
	
	private final String ERROR_OBJECT = "The Object Name does not exist in Properties file. Please check Object Name: ";
	private final String ERROR_ELEMENT_NOT_ENABLE  = "The element is not Enabled.";
	private final String ERROR_ELEMENT_ENABLE= "The element is Enabled.";
	private final String ERROR_ELEMENT_NOT_DISPLAY  = "The element is not Displayed.";
	private final String ERROR_ELEMENT_DISPLAY= "The element is Displayed.";
	
	private String actuals = null;
    
    private String expects = null;
    
	private String getIdentifierError = null;

    public String changeActual(AssertionMethods act) {
    	return act.actuals = act.actuals;
    }
    
    public String changeExpected(AssertionMethods exp) {
    	return exp.expects = exp.expects;
    }
    
    public String getIdentifier(AssertionMethods identifierError) {
		return identifierError.getIdentifierError = identifierError.getIdentifierError;
	}

    public String getElementTextCompare(WebElement element) {
        return element.getText();
    }
    
    public void checkElementFromProperties(String objectName) throws TestCaseFailed {
		actuals = ERROR_OBJECT + objectName;
		expects = MESSAGE_COMMENT;
		throw new TestCaseFailed(ERROR_OBJECT + objectName);
    }
    
    public void checkElementFindedOrNot(String accessName) throws TestCaseFailed {
		getIdentifierError = selectElementByType.getIdentifier(accessName).toString();
		actuals = null;
		expects = null;
	}
    
    public void checkElementClicked(WebElement element) throws TestCaseFailed, NoSuchFieldException {
		waitForElementClickable(element);
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
     * wait for element visible by element
     */
    @SuppressWarnings("unused")
	private void waitForElementVisible(WebElement element) {
        try {
            waitLong().until(new VisibilityOfElement(element));
        } catch (Exception ignored) {
        }
    }
    
    /**
     * Method to check element text
     * 
     * @param actualValue : String : Expected element text
     * @param accessName  : String : Locator value
     * @param testCase    : Boolean : test case [true or false]
     */
    
    public void checkElementTextCompare(String expectedValue, WebElement element, boolean testCase) throws TestCaseFailed {
        String elementText = getElementTextCompare(element);
        actuals = elementText;
    	expects = expectedValue;
        if (testCase) {
            if (!elementText.equals(expectedValue))
                throw new TestCaseFailed(messageFormat(expectedValue, elementText));
        } else {
            if (elementText.equals(expectedValue))
                throw new TestCaseFailed(messageFormat(expectedValue, elementText));
        }
    }
    
    public void checkTextDisplayed(String text, List<WebElement> elements) {
    	boolean flagCheck = false;
    	List<String> list_items = new ArrayList<String>();
		for (WebElement webElement : elements) {
			list_items.add(webElement.getText());
			if (webElement.getText().equals(text)) {
				flagCheck = true;
				break;
			}
		}
		assertTrue("The text does not exist on the list: " + text  + " and " + list_items, flagCheck);
    }

    public void checkContentDisplayed(List<String> listDataProduct, WebElement element) {
        listDataProduct.contains(element.getText());
    }

    /**
     * Method to return element status - enabled?
     *
     * @param accessName : String : Locator value
     * @return Boolean
     * @throws Exception 
     */
    public boolean isElementEnabled(WebElement element) {
        return element.isEnabled();
    }
    
    /**
     * method to get element status - displayed?
     *
     * @param accessName : String : Locator value
     * @return Boolean
     */
    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    /**
     * Element enabled checking
     *
     * @param accessName : String : Locator value
     * @param testCase   : Boolean : test case [true or false]
     */
    public void checkElementEnable(WebElement element, boolean testCase) throws TestCaseFailed {
        boolean result = isElementEnabled(element);
        if (testCase) {
            if (!result)
                throw new TestCaseFailed("Element Not Enabled");
        } else {
            if (result)
                throw new TestCaseFailed("Element Enabled");
        }
    }

    /**
     * method to get attribute value
     *
     * @param accessName    : String : Locator value
     * @param attributeName : String : attribute name
     * @return String
     * @throws Exception 
     */
    public String getElementAttribute(WebElement element, String attributeName) {
        return element.getAttribute(attributeName);
    }

    /**
     * method to check attribute value
     *
     * @param attributeName  : String : attribute name
     * @param attributeValue : String : attribute value
     * @param accessName     : String : Locator value
     * @param testCase       : Boolean : test case [true or false]
     */
    public void checkElementAttribute(String attributeName, String attributeValue, WebElement element, boolean testCase) throws TestCaseFailed {
        String attrVal = getElementAttribute(element, attributeName);
        if (testCase) {
            if (!attrVal.equals(attributeValue))
                throw new TestCaseFailed("Attribute Value Not Matched");
        } else {
            if (attrVal.equals(attributeValue))
                throw new TestCaseFailed("Attribute Value Matched");
        }
    }

    /**
     * method to check element presence
     *
     * @param accessName : String : Locator value
     * @param testCase   : Boolean : test case [true or false]
     */
    public void checkElementPresence(WebElement element, boolean testCase) throws TestCaseFailed {
        boolean check = isElementDisplayed(element);
        if (testCase) {
            if (!check) {
                throw new TestCaseFailed("Element is not displayed");
            }
        } else {
            if (check) {
                throw new TestCaseFailed("Element is displayed");
            }
        }
    }

    public List<String> getListNameProduct(List<WebElement> elements){
        List<String> listNameProduct = new ArrayList<String>();
        for(WebElement element : elements){
            listNameProduct.add(element.getText());
        }
        Collections.sort(listNameProduct, Collections.reverseOrder());
        return listNameProduct;
    }

    public List<String> getListPriceProduct(List<WebElement> elements){
        List<String> listPriceProduct = new ArrayList<String>();
        for(WebElement element : elements){
            listPriceProduct.add(element.getText().substring(1));
        }
        Collections.reverse(listPriceProduct);
        return listPriceProduct;
    }
    public String getDataProduct(WebElement element){
        return element.getText();
    }

    public String getImageProduct(WebElement element){
        return element.getAttribute("src");
    }

    public void compareTwoList(List<WebElement> elements, List<String> beCompare){
        List<String> listNameProduct = new ArrayList<String>();
        for(WebElement element : elements){
            listNameProduct.add(element.getText());
        }
        assertEquals("Two list not quals, please check!",beCompare,listNameProduct);
    }

    public void compareTwoListWithTrim(List<WebElement> elements, List<String> beCompare){
        List<String> listNameProduct = new ArrayList<String>();
        for(WebElement element : elements){
            listNameProduct.add(element.getText().substring(1));
        }
        assertEquals("Two list not quals, please check!",beCompare,listNameProduct);
    }

//    public void compareCurrentUrl(){
//        assertEquals("Not Home Page Url",getDriver().getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
//    }
    
    /**
     * method to check element presence
     *
     * @param accessName : String : Locator value
     * @param testCase   : Boolean : test case [true or false]
     */
    public void checkElementEnableToAction(WebElement element, boolean testCase) throws TestCaseFailed {
        if (testCase) {
            if (!isElementEnabled(element))
            	actuals = ERROR_ELEMENT_NOT_ENABLE;
				expects = MESSAGE_COMMENT;
                throw new TestCaseFailed(ERROR_ELEMENT_NOT_ENABLE);
        } else {
            try {
                if (isElementEnabled(element))
                	actuals = ERROR_ELEMENT_ENABLE;
					expects = MESSAGE_COMMENT;
                    throw new Exception(ERROR_ELEMENT_ENABLE);
            } catch (Exception e) {
                if (e.getMessage().equals(ERROR_ELEMENT_ENABLE))
                    throw new TestCaseFailed(ERROR_ELEMENT_ENABLE);
            }
        }
    }

    /**
     * method to assert checkbox check/uncheck
     *
     * @param accessName      : String : Locator value
     * @param shouldBeChecked : Boolean : test case [true or false]
     */
    public void isCheckboxChecked(WebElement element, boolean shouldBeChecked) throws TestCaseFailed {
        if ((!element.isSelected()) && shouldBeChecked)
            throw new TestCaseFailed("Checkbox is not checked");
        else if (element.isSelected() && !shouldBeChecked)
            throw new TestCaseFailed("Checkbox is checked");
    }

    /**
     * method to assert radio button selected/unselected
     *
     * @param accessName : String : Locator value
     */
    public void isRadioButtonSelected(WebElement element, boolean shouldBeSelected) throws TestCaseFailed {
        if ((!element.isSelected()) && shouldBeSelected)
            throw new TestCaseFailed("Radio Button not selected");
        else if (element.isSelected() && !shouldBeSelected)
            throw new TestCaseFailed("Radio Button is selected");
    }

    // method to assert option from radio button group is selected/unselected
    public void isOptionFromRadioButtonGroupSelected(String by, String option, List<WebElement> listElement,
                                                     boolean shouldBeSelected) throws TestCaseFailed {
        List<WebElement> radioButtonGroup = listElement;

        for (WebElement rb : radioButtonGroup) {
            if (by.equals("value")) {
                if (rb.getAttribute("value").equals(option)) {
                    if ((!rb.isSelected()) && shouldBeSelected)
                        throw new TestCaseFailed("Radio Button not selected");
                    else if (rb.isSelected() && !shouldBeSelected)
                        throw new TestCaseFailed("Radio Button is selected");
                }
            } else if (rb.getText().equals(option)) {
                if ((!rb.isSelected()) && shouldBeSelected)
                    throw new TestCaseFailed("Radio Button not selected");
                else if (rb.isSelected() && !shouldBeSelected)
                    throw new TestCaseFailed("Radio Button is selected");
            }
        }
    }

    /**
     * method to get javascript pop-up alert text
     *
     * @return String
     */
    public String getAlertText() {
        return getDriver().switchTo().alert().getText();
    }

    /**
     * method to check javascript pop-up alert text
     *
     * @param text : String : Text to verify in Alert
     * @throws TestCaseFailed
     */
    public void checkAlertText(String text) throws TestCaseFailed {
        if (!getAlertText().equals(text))
            throw new TestCaseFailed("Text on alert pop up not matched");
    }

    /**
     * Method to verify if the particular option is Selected from Dropdown
     *
     * @param by               : String : Select element from dropdown by text or value
     * @param option           : String : Element to select from dropdown
     * @param accessName       : String : Locator value
     * @param shouldBeSelected : Boolean : test case [true or false]
     * @throws TestCaseFailed
     */
    public void isOptionFromDropdownSelected(String by, String option, WebElement element,
                                             boolean shouldBeSelected) throws TestCaseFailed {
        Select selectList = null;
        selectList = new Select(element);

        String actualValue = "";
        if (by.equals("text"))
            actualValue = selectList.getFirstSelectedOption().getText();
        else
            actualValue = selectList.getFirstSelectedOption().getAttribute("value");

        if ((!actualValue.equals(option)) && (shouldBeSelected))
            throw new TestCaseFailed("Option Not Selected From Dropwdown");
        else if ((actualValue.equals(option)) && (!shouldBeSelected))
            throw new TestCaseFailed("Option Selected From Dropwdown");
    }
}

