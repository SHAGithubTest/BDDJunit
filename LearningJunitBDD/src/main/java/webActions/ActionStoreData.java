package webActions;

import org.openqa.selenium.By;

import driverFactory.ManageDriver;
import fixtureUtils.ExcelActions;

public class ActionStoreData {
	
	public static boolean storeDataInExcelColumn(String LocatorOfData,String colName)
	{
		String dataToBeStored = ManageDriver.getDriver().findElement(By.xpath(LocatorOfData)).getText();
		ExcelActions.setCellData(dataToBeStored, colName);
		return true;
		
	}
	

}
