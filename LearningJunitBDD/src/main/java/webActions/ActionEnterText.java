package webActions;

import org.openqa.selenium.By;

import driverFactory.ManageDriver;

public class ActionEnterText {


		public static boolean enterText(String textValue, String locator)
		{
			ManageDriver.getDriver().findElement(By.xpath(locator)).sendKeys(textValue);
			return true;
			
		}

}
