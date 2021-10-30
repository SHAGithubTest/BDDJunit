package fixtureUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.aventstack.extentreports.gherkin.model.Feature;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import gherkinTagUtils.GherkinTagAction;
import gherkinTagUtils.GherkinTagManager;
import io.cucumber.java.Scenario;

public class ExcelActions {
	private String excelPath=null;
	private XSSFSheet excelWSheet;
	private XSSFWorkbook excelWBook;
	private XSSFCell cell;
	private XSSFRow row;
	private int lastRowNum;
	private String gherkinTestTag = null;

	public void setExcelFile(String Path, String SheetName) throws Exception {
		try {
			excelPath = Path;
			
			FileInputStream ExcelFile = new FileInputStream(Path);
			
			excelWBook = new XSSFWorkbook(ExcelFile);
			excelWSheet = excelWBook.getSheet(SheetName);
			lastRowNum = excelWSheet.getLastRowNum();
			System.out.println("Excel is set successfully");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public int findRowIndex(String gherkinTestTag) {

		lastRowNum = FixtureManager.getExcelUtils().excelWSheet.getLastRowNum();
		System.out.println("Lst row num" + lastRowNum);

		for (int i = 1; i <= lastRowNum; i++) {
			String firstColRowValue = FixtureManager.getExcelUtils().excelWSheet.getRow(i).getCell(0)
					.getStringCellValue().trim();

			if (gherkinTestTag.contains(firstColRowValue)) {
				return i;
			}
		}

		return -1;

	}

	public int findColIndex(String ColName) {

		lastRowNum = FixtureManager.getExcelUtils().excelWSheet.getLastRowNum();
		// System.out.println("Lst row num" + lastRowNum);

		for (int i = 0; i < FixtureManager.getExcelUtils().excelWSheet.getRow(0).getLastCellNum(); i++) {

			String firstRowColsValue = FixtureManager.getExcelUtils().excelWSheet.getRow(0).getCell(i)
					.getStringCellValue().trim();

			if (ColName.contains(firstRowColsValue)) {
				return i;
			}
		}

		return -1;

	}

	public static String getCellData(String ColName) {

		String gherkinTestTag = GherkinTagManager.getGherkinTag().gherkinTestTag;

		System.out.println(":::::::::gherkinTestTag:::::::" + gherkinTestTag);

		int rowNumber = FixtureManager.getExcelUtils().findRowIndex(gherkinTestTag);

		System.out.println("::::::::::::rowNumber:::::::::::::" + rowNumber);
		/*
		 * if (rowNumber == -1) { return null; }
		 */
		int colNumber = FixtureManager.getExcelUtils().findColIndex(ColName);

		System.out.println("::::::::::::colNumber:::::::::::::" + colNumber);
		String finalData = FixtureManager.getExcelUtils().excelWSheet.getRow(rowNumber).getCell(colNumber)
				.getStringCellValue();

		System.out.println("------------finalData------------" + finalData);
		return finalData;

	}

	public static String getCellData1(String ColName) {

		HashMap<String, ArrayList<String>> excelDataHashmap = copyExcelDataToMap();

		// ArrayList<String> stringList = excelDataHashmap.get("testId");
		// System.out.println("::GherkinTagingetCellData:::::"+
		// GherkinTagAction.gherkinTestTag);
		// System.out.println("::::excelDataHashmap::::::::"+excelDataHashmap);

		for (Map.Entry<String, ArrayList<String>> entry : excelDataHashmap.entrySet()) {
			System.out.println("::::entry.getKey()::::" + entry.getKey());
			System.out.println("::::entry.getVal()::::" + entry.getValue());

		}

		return "";

	}

	public static HashMap<String, ArrayList<String>> copyExcelDataToMap() {

		HashMap<String, ArrayList<String>> excelDataHashmap = new HashMap<String, ArrayList<String>>();

		for (int i = 0; i <= FixtureManager1.getExcelWorkBook().getSheet("Data").getLastRowNum(); i++) {

			ArrayList<String> tempColDataList = new ArrayList<String>();
			for (int j = 1; j < FixtureManager1.getExcelWorkBook().getSheet("Data").getRow(i).getLastCellNum(); j++) {

				tempColDataList.add(FixtureManager1.getExcelWorkBook().getSheet("Data").getRow(i).getCell(j)
						.getStringCellValue().trim());

			}
			System.out.println(":::::tempColDataList:::::" + tempColDataList);
			excelDataHashmap.put(FixtureManager1.getExcelWorkBook().getSheet("Data").getRow(i).getCell(0)
					.getStringCellValue().trim(), tempColDataList);

		}

		/*
		 * for (int i = 0; i <=
		 * FixtureManager.getExcelWorkBook().getSheet("Data").getLastRowNum();
		 * i++) {
		 * 
		 * System.out.println("::::Key:::" +
		 * FixtureManager.getExcelWorkBook().getSheet("Data").getRow(i).getCell(
		 * 0).getStringCellValue() + "::::::Hashmap value:::::" +
		 * excelDataHashmap.get(FixtureManager.getExcelWorkBook().getSheet(
		 * "Data").getRow(i).getCell(0).getStringCellValue().trim()));
		 * 
		 * }
		 */
		System.out.println("Excel data is copied successfully to map");
		return excelDataHashmap;

	}

	public String getCellData(int RowNum, int ColNum) throws Exception {
		try {

			cell = excelWSheet.getRow(RowNum).getCell(ColNum);
			// CellStyle textStyle = excelWBook.createCellStyle();
			// System.out.println("::::::::::DataForamte:::::::::"+textStyle.getDataFormat());
			String CellData = cell.getStringCellValue().trim();

			return CellData;

		} catch (Exception e) {
			return "";
		}
	}

	public int getRowCount(String SheetName) {
		excelWSheet = excelWBook.getSheet(SheetName);
		int number = excelWSheet.getLastRowNum() + 1;
		return number;
	}

	public void setCellData(String Result, int RowNum, int ColNum, String filename) throws Exception {
		try {

			//row = excelWSheet.createRow(RowNum);
			
			// cell = row.getCell(ColNum, row.RETURN_BLANK_AS_NULL);

			row =  excelWSheet.getRow(RowNum);
			
			if (row==null ) {
				row = excelWSheet.createRow(RowNum);
			}
			
			cell = row.createCell(ColNum);
			cell.setCellValue(Result);

			FileOutputStream fileOut = new FileOutputStream(filename);
			excelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static boolean setCellData(String Result, String colName) {
		try {
			
			String gherkinTestTag = GherkinTagManager.getGherkinTag().gherkinTestTag;

			System.out.println(":::::::::gherkinTestTag:::::::" + gherkinTestTag);

			int rowNumber = FixtureManager.getExcelUtils().findRowIndex(gherkinTestTag);

			System.out.println("::::::::::::rowNumber:::::::::::::" + rowNumber);
			
			int colNumber = FixtureManager.getExcelUtils().findColIndex(colName);

			System.out.println("::::::::::::colNumber:::::::::::::" + colNumber);
						
			XSSFRow row =  FixtureManager.getExcelUtils().excelWSheet.getRow(rowNumber);
			
			if (row==null ) {
				row = FixtureManager.getExcelUtils().excelWSheet.createRow(rowNumber);
			}
			
			XSSFCell cell = row.createCell(colNumber);
			cell.setCellValue(Result);

			FileOutputStream fileOut = new FileOutputStream(FixtureManager.getExcelUtils().excelPath);
			FixtureManager.getExcelUtils().excelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
			
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public void closefile() {
		try {

			FileOutputStream fileOut = new FileOutputStream(FixtureManager.getExcelUtils().excelPath);
			excelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String a[]) throws Exception {
		ExcelActions excelUtilsObj = new ExcelActions();

		excelUtilsObj.setExcelFile("./src/test/resources/fixtures/login6.xlsx", "data");
		/*
		 * int testIdRowNum = ExcelUtilsObj.findRow(gherkinScenario);
		 * System.out.println("::::testIdRowNum::::" + testIdRowNum);
		 * System.out.println("Excel Data::::::" +
		 * ExcelUtilsObj.getCellData(testIdRowNum, testIdRowNum));
		 */
		// excelUtilsObj.copyExcelDataToMap();

		/*System.out.println(":::::::GET::::::" + excelUtilsObj.getCellData(4, 0));
		excelUtilsObj.setCellData("Anand", 4, 0, "./src/test/resources/fixtures/login6.xlsx");
		System.out.println("::::::GET UPDADTED:::::::" + excelUtilsObj.getCellData(4, 0));
		
		System.out.println(":::::::GET::::::" + excelUtilsObj.getCellData(7, 0));
		excelUtilsObj.setCellData("Anand", 7, 0, "./src/test/resources/fixtures/login6.xlsx");
		System.out.println("::::::GET UPDADTED:::::::" + excelUtilsObj.getCellData(7, 0));
		
		
		System.out.println(":::::::GET::::::" + excelUtilsObj.getCellData(10, 0));
		excelUtilsObj.setCellData("Anand", 10, 0, "./src/test/resources/fixtures/login6.xlsx");
		System.out.println("::::::GET UPDADTED:::::::" + excelUtilsObj.getCellData(10, 0));
		
		System.out.println(":::::::GET::::::" + excelUtilsObj.getCellData(0, 0));
		excelUtilsObj.setCellData("Anand", 0, 0, "./src/test/resources/fixtures/login6.xlsx");
		System.out.println("::::::GET UPDADTED:::::::" + excelUtilsObj.getCellData(0, 0));
		*/
		
		
		  for (int i = 0; i < 10; i++) { System.out.println(":::::::GET::::::"
		  + excelUtilsObj.getCellData(i, 1));
		  excelUtilsObj.setCellData("Anand", i, 1,"./src/test/resources/fixtures/login6.xlsx");
		  System.out.println("::::::GET UPDADTED:::::::" +
		  excelUtilsObj.getCellData(i, 1));
		  
		  }
		 

	}

}
