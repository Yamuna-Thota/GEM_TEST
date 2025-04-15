package Generic_Utilities;

import java.io.FileInputStream;

import java.util.Properties;

public class File_Utility {
	
	/**
	 * 
	 * This method is used to get the values from external file(txt)
	 *@return
	 * @author Sasi
	 */

	public String getKeyAndValue(String key) throws Throwable {

		// reading the file using FIS
		FileInputStream fis = new FileInputStream("./src/test/resources/createproduct.properties.txt");
		// loading the keys using Properties Class
		Properties pro = new Properties();
		pro.load(fis);

		String value = pro.getProperty(key);

		return value;
	}

}
