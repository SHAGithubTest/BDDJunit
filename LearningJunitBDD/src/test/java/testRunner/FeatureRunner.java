package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)				
	@CucumberOptions(
			stepNotifications = true,
			plugin={"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
			features={"src/test/resources/features/"},
			glue={"stepDefs", "appHooks"}
			)
	public class FeatureRunner {
		

			
	}
	
	

//	plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},