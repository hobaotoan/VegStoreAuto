package cucumber.utils;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class InputMethods implements BaseTest {
    private Select selectList = null;
    
    /**
     * Method to enter text into text field
     *
     * @param text       : String : Text value to enter in field
     * @param accessName : WebElement : element
     */
    public void enterTextField(String text, WebElement element) throws Exception {
        element.sendKeys(text);
    }

    /**
     * Method to clear text of text field
     *
     * @param accessName : String : Locator value
     */
    public void clearText(WebElement element) {
        element.clear();
    }

    /**
     * Method to select element from Dropdown by type
     *
     * @param select_list : Select : Select variable
     * @param bytype      : String : Name of by type
     * @param option      : String : Option to select
     */
    public void selectelementfromdropdownbytype(Select select_list, String bytype, String option) {
        if (bytype.equals("selectByIndex")) {
            int index = Integer.parseInt(option);
            select_list.selectByIndex(index - 1);
        } else if (bytype.equals("value"))
            select_list.selectByValue(option);
        else if (bytype.equals("text"))
            select_list.selectByVisibleText(option);
    }

    /**
     * Method to select option from dropdown list
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param option     : String : Option to select
     * @param accessName : String : Locator value
     */
    public void selectOptionFromDropdown(String optionBy, String option, WebElement element) {
        selectList = new Select(element);

        if (optionBy.equals("selectByIndex"))
            selectList.selectByIndex(Integer.parseInt(option) - 1);
        else if (optionBy.equals("value"))
            selectList.selectByValue(option);
        else if (optionBy.equals("text"))
            selectList.selectByVisibleText(option);
    }
    
    /**
     * Method to select option from dropdown list
     * @param accessName 
     * @param option 
     *
     * @throws Exception 
     */
    public void selectOptionEleFromDropdown(String optionBy, String option, WebElement element) throws Exception {
        selectList = new Select(element);

        if (optionBy.equals("selectByIndex"))
            selectList.selectByIndex(Integer.parseInt(option) - 1);
        else if (optionBy.equals("value"))
            selectList.selectByValue(option);
        else if (optionBy.equals("text"))
            selectList.selectByVisibleText(option);
    }

    /**
     * Method to unselect all option from dropdwon list
     *
     * @param accessName : String : Locator value
     */
    public void unselectAllOptionFromMultiselectDropdown(WebElement element) {
        selectList = new Select(element);
        selectList.deselectAll();
    }

    /**
     * Method to unselect option from dropdwon list
     *
     * @param accessName : String : Locator value
     */
    public void deselectOptionFromDropdown(String optionBy, String option, WebElement element) {
        selectList = new Select(element);

        if (optionBy.equals("selectByIndex"))
            selectList.deselectByIndex(Integer.parseInt(option) - 1);
        else if (optionBy.equals("value"))
            selectList.deselectByValue(option);
        else if (optionBy.equals("text"))
            selectList.deselectByVisibleText(option);
    }

    /**
     * Method to check check-box
     *
     * @param accessName : String : Locator value
     */
    public void checkCheckbox(WebElement element) {
        if (!element.isSelected())
            element.click();
    }

    /**
     * Method to uncheck check-box
     *
     * @param accessName : String : Locator value
     */
    public void uncheckCheckbox(WebElement element) {
            element.click();
    }

    /**
     * Method to select radio button
     *
     * @param accessName : String : Locator value
     */
    public void selectRadioButton(WebElement element) {
        WebElement radioButton = element;
        if (!radioButton.isSelected())
            radioButton.click();
    }

    /**
     * Method to select option from radio button group
     *
     * @param by         : String : Name of by type
     * @param option     : String : Option to select
     * @param accessName : String : Locator value
     */
    public void selectOptionFromRadioButtonGroup(WebDriver driver, String option, String by, List<WebElement> element) {
        List<WebElement> radioButtonGroup = element;
        for (WebElement rb : radioButtonGroup) {
            if (by.equals("value")) {
                if (rb.getAttribute("value").equals(option) && !rb.isSelected())
                    rb.click();
            } else if (by.equals("text")) {
                if (rb.getText().equals(option) && !rb.isSelected())
                    rb.click();
            }
        }
    }

}
