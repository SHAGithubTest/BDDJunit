package appHooks;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import driverFactory.ManageDriver;
import gherkinTagUtils.GherkinTagManager;
import io.cucumber.core.backend.TestCaseState;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestCase;
import io.cucumber.plugin.event.TestStepStarted;

public class ApplicationHooks {

	// ExcelUtils excelUtilsObj = new ExcelUtils();

	@Before(order = 1)
	public void setExcel(Scenario gherkinScenario) {

		try {
			GherkinTagManager.setGherkinTag(gherkinScenario);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@AfterStep()
	public void afterStep(Scenario gherkinScenario) throws Exception {
		
		/*
		 * PickleStepTestStep steps = (PickleStepTestStep) event.getTestStep(); String
		 * stepName = steps.getStep().getText();
		 * System.out.println("::::::::stepName::::::::::"+stepName);
		 */
	/*
		 * System.out.println("==========="+gherkinScenario.getUri());
		 * System.out.println("==========="+gherkinScenario.toString());
		 * System.out.println("==========="+gherkinScenario.getLine());
		 * System.out.println("==========="+gherkinScenario.getClass());
		 * System.out.println("==========="+gherkinScenario.getId());
		 * System.out.println("==========="+gherkinScenario);
		 */

		ArrayList<String> tags;
		int currentStepID = 0;
		
		tags = (ArrayList<String>) gherkinScenario.getSourceTagNames();
		System.out.println("At Hooks: " + gherkinScenario.getId());
		Iterator ite = tags.iterator();

		while (ite.hasNext()) {

			ite.next().toString();
			// Field[] field=scenario.getClass().getDeclaredFields();
			Field f = gherkinScenario.getClass().getDeclaredField("delegate");
			f.setAccessible(true);
			TestCaseState tcs = (TestCaseState) f.get(gherkinScenario);

			Field f2 = tcs.getClass().getDeclaredField("testCase");
			f2.setAccessible(true);
			TestCase r = (TestCase) f2.get(tcs);
			
			System.out.println(":::::::TEst case::::::::"+r.getTestSteps());
			
			 
			/*
			 * List<PickleStepTestStep> testSteps = r.getTestSteps().stream().filter(x -> x
			 * instanceof PickleStepTestStep) .map(x -> (PickleStepTestStep) x).toList();
			 * 
			 * PickleStepTestStep currentStepDef = testSteps.get(currentStepID);
			 * 
			 * // this will print scenario name
			 * System.out.println("::::::::::Current Step:::::::::" + currentStepDef);
			 */
		}

		if (ManageDriver.getDriver() != null) {
			String ScreenshotName = gherkinScenario.getName().replace(" ", "_");
			final byte[] screenshot = ((TakesScreenshot) ManageDriver.getDriver()).getScreenshotAs(OutputType.BYTES);
			gherkinScenario.attach(screenshot, "image/png", ScreenshotName);
			System.out.println(":::::::::::::::" + gherkinScenario.getSourceTagNames());
		}
	}

	@After
	public void tearDown() {
		if (ManageDriver.getDriver() != null) {
			ManageDriver.getDriver().quit();
		}

	}

}
