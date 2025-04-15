package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertDataIntoExcelFile {

	public static void main(String[] args) throws Throwable {

		FileInputStream fis = new FileInputStream("./src/test/resources/AdvancedTestData.xlsx");
		
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Sheet1");
		Row row = sh.createRow(3);
		Cell cl = row.createCell(3);
		cl.setCellValue("Sasi");
		FileOutputStream fos = new FileOutputStream("./src/test/resources/AdvancedTestData.xlsx");
		book.write(fos);
		book.close();
		
		
		

}
}
