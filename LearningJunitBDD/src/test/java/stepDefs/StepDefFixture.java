package stepDefs;

import org.junit.Assert;

import fixtureUtils.FixtureManager;
import io.cucumber.java.en.Given;
import webActions.ActionStoreData;

public class StepDefFixture {

	@Given("user loads fixture {string}")
	public void user_loads_fixture(String excelFilePath) 
	{
		Assert.assertTrue(FixtureManager.setExcelFile(excelFilePath, "data"));
		
		
		
	}
	
	@Given("user captures {string} into {string}")
	public void user_captures_into(String LocatorOfData, String colName) {

		
		Assert.assertTrue(ActionStoreData.storeDataInExcelColumn(LocatorOfData,colName));

	
	}
}
