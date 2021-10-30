package webActions;

import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.Set;

import driverFactory.ManageDriver;
import fixtureUtils.ExcelActions;
import fixtureUtils.FixtureManager1;

public class ActionBrowserOperation {

	// ExcelUtils excelUtilObj = new ExcelUtils();

	public static boolean launchBrowser(String browserName) {

		ManageDriver manageDriver = new ManageDriver();
		manageDriver.initDriver(browserName);
		return true;

	}

	public static boolean navigateToUrl(String url) {

		ManageDriver.getDriver().get(url);
		return true;

	}
	
	public static boolean switchWindow(String windowName) {

		Set<String> currentWindowHandles=ManageDriver.getDriver().getWindowHandles();
		Iterator<String> itrCurrentWindowHandles= currentWindowHandles.iterator();
	
		String pageTitle=null;
		
		while (itrCurrentWindowHandles.hasNext()) {
			
			
			pageTitle = ManageDriver.getDriver().switchTo().window(itrCurrentWindowHandles.next()).getTitle();
			if(pageTitle.contains(windowName))
			{	
				System.out.println("--------pageTitle--------"+pageTitle);
				break;
			}
		}
		
		
		/*
			System.out.println(":::::::::----itrCurrentWindowHandles------:::::::::"+itrCurrentWindowHandles.toString());
			String childWindow = itrCurrentWindowHandles.next();
			System.out.println("::::::::::childWindow:::::::"+childWindow);
			ManageDriver.getDriver().switchTo().window(childWindow);
			System.out.println("Child Title name-------------"+ManageDriver.getDriver().getTitle());
			String parantWindow = itrCurrentWindowHandles.next();
			System.out.println("::::::::::childWindow:::::::"+parantWindow);
			ManageDriver.getDriver().switchTo().window(parantWindow);
		*/
		
		//System.out.println("Child Title name-------------"+ManageDriver.getDriver().getTitle());

		
		return true;

	}

}
