package CommonUtilityPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {
	public static ArrayList<String> ReadExcelData(String FileName, String SheetName, String TestCaseName)
			throws IOException {

		ArrayList<String> ArrayData = new ArrayList<String>();

		// Step 1 : Locate the file
		String ProjectDir = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(ProjectDir + "\\InputData\\" + FileName);

		// Step 2 : Access the located excel file
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Step 3 : Count the number of sheets available in the excel file
		int CountOfSheet = wb.getNumberOfSheets();
		System.out.println("Count of Sheet : " +CountOfSheet);

		// Step 4 : Access the desired sheet
		for (int i = 0; i < CountOfSheet; i++) {
			String sheetname = wb.getSheetName(i);
			if (sheetname.equals(SheetName)) {
				System.out.println("inside the sheet : " + sheetname);
				XSSFSheet sheet = wb.getSheetAt(i);
				Iterator<Row> Rows = sheet.iterator();
				while (Rows.hasNext()) {
					Row CurrentRow = Rows.next();

					// Step 5 : Access the row corrosponding desired test case
					if (CurrentRow.getCell(0).getStringCellValue().equals(TestCaseName)) {
						Iterator<Cell> Cell = CurrentRow.iterator();
						while (Cell.hasNext()) {
							String Data = Cell.next().getStringCellValue();
							System.out.println(Data);
							ArrayData.add(Data);
						}
					}

				}
			}
		}
		wb.close();
		return ArrayData;
	}

}
