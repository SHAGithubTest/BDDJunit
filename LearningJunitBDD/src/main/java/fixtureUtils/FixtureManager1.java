package fixtureUtils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FixtureManager1 {

	public static ThreadLocal<Workbook> tlExcelWorkBook = new ThreadLocal<>();

	public static boolean setExcelFile(String Path, String SheetName) {
		try {

			FileInputStream ExcelFile = new FileInputStream(Path);

			tlExcelWorkBook.set(new XSSFWorkbook(ExcelFile));

			System.out.println("Excel is set successfully with threadLocal");
			

			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;

		}
	}

	public static Workbook getExcelWorkBook() {
		return tlExcelWorkBook.get();
	}

}
