package webActions;

import driverFactory.ManageDriver;

public class ActionBrowserOperation {

	public static boolean launchBrowser(String browserName)
	{
		ManageDriver manageDriver= new ManageDriver();
		manageDriver.initDriver(browserName);
		return true;
		
	}
	
	
	public static boolean navigateToUrl(String url)
	{
		ManageDriver.getDriver().get(url);
		return true;
		
	}
	
	
}
