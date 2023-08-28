package cucumber.utils;

import org.openqa.selenium.By;

import cucumber.page.AbstractPage;

public class SelectElementByType extends AbstractPage implements BaseTest{

    /**
     * Method to select element 'by' type
     *
     * @param type        : String : 'By' type
     * @param access_name : String : Locator value
     * @return By
     */
    public By getelementbytype(String type, String access_name) {
        switch (type) {
            case "id":
                return By.id(access_name);
            case "name":
                return By.name(access_name);
            case "class":
                return By.className(access_name);
            case "xpath":
                return By.xpath(access_name);
            case "css":
                return By.cssSelector(access_name);
            case "linkText":
                return By.linkText(access_name);
            case "partialLinkText":
                return By.partialLinkText(access_name);
            case "tagName":
                return By.tagName(access_name);
            default:
                return null;

        }
    }
    
    public By getIdentifier(String objectName) throws TestCaseFailed {
		if (null != getDataTest(objectName + "-id")) {
			return By.id(getDataTest(objectName + "-id"));
		}  
		if (null != getDataTest(objectName + "-xp")) {
			return By.xpath(getDataTest(objectName + "-xp"));
		} 
		if (null != getDataTest(objectName + "-css")) {
			return By.cssSelector(getDataTest(objectName + "-css"));
		} 
		if (null != getDataTest(objectName + "-cln")) {
			return By.className(getDataTest(objectName + "-cln"));
		} 
		if (null != getDataTest(objectName + "-link")) {
			return By.linkText(getDataTest(objectName + "-link"));
		} 
		if (null != getDataTest(objectName + "-plink")) {
			return By.partialLinkText(getDataTest(objectName + "-plink"));
		} 
		if (null != getDataTest(objectName + "-tag")) {
			return By.tagName(getDataTest(objectName + "-tag"));
		} 
		if (null != getDataTest(objectName + "-name")) {
			return By.name(getDataTest(objectName + "-name"));
		} else {
			assertionObj.checkElementFromProperties(objectName);
			return null;
		}
	}
}
