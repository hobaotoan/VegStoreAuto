package cucumber.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = { "cucumber.step" },
		monochrome = true, plugin = { 
						"pretty",
						"json:target/cucumber.json", 
						"pretty:target/cucumber-pretty.txt",
						"usage:target/cucumber-usage.json", 
						"junit:target/cucumber-results.xml",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						"rerun:target/rerun.txt",
						"html:target/cucumber.html" })
public class TestRunner {

}
