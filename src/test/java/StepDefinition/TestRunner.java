package StepDefinition;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;



@CucumberOptions(
		dryRun = false,
		monochrome=true,
		features={"src/test/resources/Features"},
		glue= {"StepDefinition"},
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		tags ="@Login or @Automate"
		)

public class TestRunner extends AbstractTestNGCucumberTests {

}
