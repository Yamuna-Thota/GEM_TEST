package DDT;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingDataToTheConsole {

	public static void main(String[] args) throws Throwable {
		FileInputStream Fis = new FileInputStream("./src/test/resources/AdvancedTestData.xlsx");
		Workbook book = WorkbookFactory.create(Fis);
		Sheet sh = book.getSheet("Sheet1");
		int lastRow = sh.getLastRowNum();
		for (int i = 0; i < lastRow; i++) {
			Row row = sh.getRow(i);
			Cell cell = row.getCell(0);
			String print = cell.getStringCellValue();
			System.out.println(print);

		}
	}

}
