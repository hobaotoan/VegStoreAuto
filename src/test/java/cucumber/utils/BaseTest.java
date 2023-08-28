package cucumber.utils;

public interface BaseTest {
	SelectElementByType selectElementByType = new SelectElementByType();
	BorderElement borderObj = new BorderElement();
	InputMethods inputObj = new InputMethods();
	AssertionMethods assertionObj = new AssertionMethods();
	ClickElementsMethods clickObj = new ClickElementsMethods();
	ProgressMethods progressObj = new ProgressMethods();
}
