package product;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import pomRepo.CreatePrdPage;
import pomRepo.HomePage;
import pomRepo.PrdLookUpImg;
import pomRepo.PrdValidation;




public class CreateProductTest extends BaseClass {

	public void createProductTest() throws Throwable {
		Excel_Utility elib = new Excel_Utility();
//		Java_Utility jlib = new Java_Utility();
//		WebDriver_Utility wlib = new WebDriver_Utility();
//
//		File_Utility flib = new File_Utility();
//		//String BROWSER = flib.getKeyAndValue("browser");
//		String URL = flib.getKeyAndValue("url");
//		String USERNAME = flib.getKeyAndValue("username");
//		String PASSWORD = flib.getKeyAndValue("password");

//		wlib.maximizeWindow(driver);
//		wlib.waitElementsToLoad(driver);
//		driver.get(URL);

//		LoginPage login = new LoginPage(driver);
//		login.loginIntoApp(USERNAME, PASSWORD);

		HomePage home = new HomePage(driver);
		home.clickPrdLink();

		PrdLookUpImg lookUp = new PrdLookUpImg(driver);
		lookUp.clickPrdLookUp();
		
		String prdName = elib.getExcelData("Product", 0, 0);
		System.out.println(prdName);
	


		CreatePrdPage prdPage = new CreatePrdPage(driver);
		prdPage.enterPrdDetails(prdName);

		PrdValidation validate = new PrdValidation(driver);
		validate.validatePrd(driver, prdName);

		home.logOut(driver);

	}

}
