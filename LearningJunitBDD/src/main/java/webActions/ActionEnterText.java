package webActions;

import org.openqa.selenium.By;

import driverFactory.ManageDriver;
import fixtureUtils.FixtureManager;

public class ActionEnterText {


		public static boolean enterText(String textValue, String locator)
		{
			
			if (textValue.startsWith("#")) {
				
				textValue = FixtureManager.getExcelUtils().getCellData(textValue);
			}
			
			ManageDriver.getDriver().findElement(By.xpath(locator)).sendKeys(textValue);
			return true;
			
		}

}
