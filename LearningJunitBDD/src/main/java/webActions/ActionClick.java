package webActions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByAll;

import driverFactory.ManageDriver;

public class ActionClick {
	
	
	public static boolean click(String locator)
	{
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {		}
		
		
		
		//ManageDriver.getDriver().findElement(By.linkText(locator)).click();;
		
	    ManageDriver.getDriver().findElement(
				new ByAll(
						By.linkText(locator),
						By.className(locator),
						By.id(locator),
						By.xpath(locator),
						By.cssSelector(locator),
						By.name(locator),
						By.partialLinkText(locator)
						)).click();
		
		return true;
		
			
	}

}
