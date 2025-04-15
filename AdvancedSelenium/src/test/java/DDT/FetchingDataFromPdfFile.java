package DDT;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;

public class FetchingDataFromPdfFile {

	public static void main(String[] args) throws IOException {
File file = new File("./src/test/resources/Interview questions.pdf");
PDDocument pdfDoc = PDDocument.load(file);
int pages = pdfDoc.getNumberOfPages();

System.out.println(pages);


	}

}
