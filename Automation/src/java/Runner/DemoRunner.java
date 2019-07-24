package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {
		"json:target/cucumber.json" }, glue = "com.webautomation.steps", features = "src\\test\\java\\feature\\Demo.feature")
public class DemoRunner {

}
