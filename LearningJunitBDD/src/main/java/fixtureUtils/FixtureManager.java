package fixtureUtils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FixtureManager {

	public static ThreadLocal<ExcelActions> tlExcelUtils = new ThreadLocal<>();

	public static boolean setExcelFile(String Path, String SheetName) {
		try {

			tlExcelUtils.set(new ExcelActions());
			getExcelUtils().setExcelFile(Path, SheetName);
			System.out.println("Excel is set successfully with threadLocal");
			

			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;

		}
	}

	public static ExcelActions getExcelUtils() {
		return tlExcelUtils.get();
	}

}
