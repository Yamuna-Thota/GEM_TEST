package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {

	private static final String[][] objArr = null;

	/**
	 * 
	 * @param sheetNum
	 * @param rowNum
	 * @param cellNum  This method is used to get the data from Excel
	 * @throws Throwable
	 * @author Sasi
	 *
	 */

	public String getExcelData(String SheetName, int rowNum, int cellNum) throws Throwable, Throwable {
		// step1:- path connection
		FileInputStream fis1 = new FileInputStream("./src/test/resources/AdvancedTestData.xlsx");

		// step2:-keeps the workbook/excelfile in read mode
		Workbook book = WorkbookFactory.create(fis1);

		// step3:- Navigating expected sheet
		Sheet sheet = book.getSheet(SheetName);

		// step4:- Navigating expected row--->row value starts from 0
		Row row1 = sheet.getRow(rowNum);

		// step5:- Navigating expected cell--->cell value starts from 0
		Cell cell1 = row1.getCell(cellNum);

		String ExcelData = cell1.getStringCellValue();

		return ExcelData;
	}
	
	public String getExcelDataUsingFormatter(String SheetName, int rowNum, int cellNum) throws Throwable {
		// step1:- path connection
		FileInputStream fis1 = new FileInputStream("./src/test/resources/AdvancedTestData.xlsx");

		// step2:-keeps the workbook/excelfile in read mode
		Workbook book = WorkbookFactory.create(fis1);

		// step3:- Navigating expected sheet
		Sheet sheet = book.getSheet(SheetName);

		// step4:- Navigating expected row--->row value starts from 0
		Row row = sheet.getRow(rowNum);

		// step5:- Navigating expected cell--->cell value starts from 0
		Cell cell = row.getCell(cellNum);

		DataFormatter format = new DataFormatter();
		String ExcelData = format.formatCellValue(cell);

		return ExcelData;
	}
	
	public Object[][] getExcelDataForDataProvider(String SheetName) throws Throwable {
		FileInputStream fis1 = new FileInputStream("./src/test/resources/AdvancedTestData.xlsx");

		// step2:-keeps the workbook/excelfile in read mode
		Workbook book = WorkbookFactory.create(fis1);

		Sheet sheet = book.getSheet(SheetName);
		int lastRow = sheet.getLastRowNum()+1;
	    int lastCell = sheet.getRow(0).getLastCellNum();
	    
		Object[][] objArr = new Object[lastRow][lastCell];
		
		for (int i = 0; i < objArr.length; i++)
		{
			
			for (int j = 0; j < objArr.length; j++) 
			{
			
				objArr[i][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		return objArr;
		
	}

	
}


