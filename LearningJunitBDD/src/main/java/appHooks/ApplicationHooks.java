package appHooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import driverFactory.ManageDriver;
import excelUtility.ExcelUtils;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	ExcelUtils ExcelUtilsObj = new ExcelUtils();
	
	@Before
    public void setExcel(Scenario gherkinScenario){

				/*try {
					ExcelUtilsObj.setExcelFile("./fixtures/login1.xlsx", "data");
					int testIdRowNum = ExcelUtilsObj.findRow(gherkinScenario);
					ExcelUtilsObj.getCellData(testIdRowNum, 1);
					
					
				} catch (Exception e) {

					e.printStackTrace();
				}
*/		
				}
	
	
	

	@AfterStep
    public void afterStep(Scenario gherkinScenario){

				  String ScreenshotName = gherkinScenario.getName().replace(" ", "_"); 
			      final byte[] screenshot = ((TakesScreenshot) ManageDriver.getDriver()).getScreenshotAs(OutputType.BYTES);
			      gherkinScenario.attach(screenshot, "image/png", ScreenshotName); 
			      System.out.println(":::::::::::::::"+gherkinScenario.getSourceTagNames());
	}
	
	@After
    public void tearDown(){
			ManageDriver.getDriver().close();		
		
    }

}
