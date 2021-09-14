package excelUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.cucumber.java.Scenario;

public class ExcelUtils {
	private  XSSFSheet ExcelWSheet;
	private  XSSFWorkbook ExcelWBook;
	private  XSSFCell Cell;
	private  XSSFRow Row;
	//private  int rowCount;

	// This method is to set the File path and to open the Excel file, Pass
	// Excel Path and Sheetname as Arguments to this method
	public synchronized  void setExcelFile(String Path, String SheetName) throws Exception {
		try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(Path);
			//Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			//rowCount = ExcelWSheet.getLastRowNum();
		} catch (Exception e) {
			throw (e);
		}
	}

	public int findRow(Scenario gherkinScenario) {

		int lastRow = ExcelWSheet.getLastRowNum();
		int lastCell = ExcelWSheet.getRow(lastRow).getLastCellNum();
		String gherkinTestTag = null;

		for (String gherkinTag : gherkinScenario.getSourceTagNames()) {

			if (gherkinTag.contains("Test_ID")) {
				gherkinTestTag = gherkinTag;
				break;
			}

		}

		System.out.println("::::::::::::::::::Final Test ID:::::"+gherkinTestTag);
		
		
		for (int i = 0; i < lastRow; i++) {

			for (int j = 0; j < lastCell; j++) {

				if (ExcelWSheet.getRow(i).getCell(j).getStringCellValue().equals(gherkinTestTag)) {
					return ExcelWSheet.getRow(i).getCell(j).getRowIndex();
				}
			}

		}

		return -1;

	}

	public String getCellData(int RowNum, int ColNum) throws Exception {
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			String CellData = Cell.getStringCellValue().trim();

			return CellData;

		} catch (Exception e) {
			return "";
		}
	}

	public int getRowCount(String SheetName) {
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
		int number = ExcelWSheet.getLastRowNum() + 1;
		return number;
	}

	public void setCellData(String Result, int RowNum, int ColNum, String filename) throws Exception {
		try {
			Row = ExcelWSheet.getRow(RowNum);
			// Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
			Cell = Row.getCell(ColNum);
			if (Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(Result);
			} else {
				Cell.setCellValue(Result);
			}
			// Constant variables Test Data path and Test Data file name
			FileOutputStream fileOut = new FileOutputStream("");
			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			throw (e);
		}
	}

	public void setCellDataNew(String Result, int RowNum, int ColNum) throws Exception {
		try {
			Row = ExcelWSheet.getRow(RowNum);
			// Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
			Cell = Row.getCell(ColNum);
			if (Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(Result);
			} else {
				Cell.setCellValue(Result);
			}
			// Constant variables Test Data path and Test Data file name

			/*
			 * FileInputStream ExcelFile = new FileInputStream(filename); //
			 * Access the required test data sheet ExcelWBook = new
			 * XSSFWorkbook(ExcelFile);
			 */

		} catch (Exception e) {
			throw (e);
		}

	}

	public void closefile() {
		try {

			FileOutputStream fileOut = new FileOutputStream("");
			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
