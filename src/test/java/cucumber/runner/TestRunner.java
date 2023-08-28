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
						"rerun:target/rerun.txt",
						"html:target/cucumber.html" })
public class TestRunner {

}
