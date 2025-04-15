package product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import pomRepo.CampLookUpImg;
import pomRepo.CampValidation;
import pomRepo.CreateCampPage;
import pomRepo.CreatePrdPage;
import pomRepo.HomePage;
import pomRepo.LoginPage;
import pomRepo.PrdLookUpImg;
import pomRepo.SwtichingWindowPage;

@Test
public class CreateCrusadeWithProductTest extends BaseClass {

	public void createCrusadeWithProductTest() throws Throwable {

		Java_Utility jlib = new Java_Utility();
		Excel_Utility EU = new Excel_Utility();
        WebDriver_Utility wdl = new WebDriver_Utility();
//
//		File_Utility kp = new File_Utility();
//
//		String URL = kp.getKeyAndValue("url");
//		String USERNAME = kp.getKeyAndValue("username");
//		String PASSWORD = kp.getKeyAndValue("password");
//
//		wdl.maximizeWindow(driver);
//		wdl.waitElementsToLoad(driver);
//		driver.get(URL);
////		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
////		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
////		driver.findElement(By.id("submitButton")).click();
//		LoginPage login = new LoginPage(driver);
//		login.loginIntoApp(USERNAME, PASSWORD);

		HomePage home = new HomePage(driver);
		home.clickPrdLink();

//		driver.findElement(By.linkText("Products")).click();
//		driver.findElement(By.cssSelector("[alt=\"Create Product...\"]")).click();

		PrdLookUpImg lookUp = new PrdLookUpImg(driver);
		lookUp.clickPrdLookUp();

		int ranNum = jlib.getRandomNum();
		

		String prdName = EU.getExcelData("Product", 0, 0) + ranNum;
//		driver.findElement(By.name("productname")).sendKeys(prdName);
//
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		CreatePrdPage prdPage = new CreatePrdPage(driver);
		prdPage.enterPrdDetails(prdName);
//------------------------------------------------------------------------------------------
//		driver.findElement(By.linkText("More")).click();
//		driver.findElement(By.linkText("Campaigns")).click();

		home.ClickCampLink();
		// driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		CampLookUpImg lookUpImg = new CampLookUpImg(driver);
		lookUpImg.clickCampLookUp();

		String CampName = EU.getExcelData("Campaign1", 0, 0);
		System.out.println(CampName);

//		driver.findElement(By.name("campaignname")).sendKeys(CampName);
//
//		driver.findElement(By.xpath("//img[@alt=\"Select\"]")).click();
		CreateCampPage campPage = new CreateCampPage(driver);
		campPage.enterCampDetails(CampName);
		campPage.clickPrdPlusSign();
		wdl.windowSwitching(driver, "Products&action");
//		driver.findElement(By.name("search_text")).sendKeys(prdName);
//		driver.findElement(By.cssSelector("[name=\"search\"]")).click();

		SwtichingWindowPage switching = new SwtichingWindowPage(driver);
		switching.searchPrdName(CampName);
		switching.dynamicXpath(driver, prdName);
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//a[text()='" + prdName + "']")).click();

		wdl.windowSwitching(driver, "Campaigns&action");

		// driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		campPage.clickSaveButton();
//
//		String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Campaign Name\"]")).getText();
//
//		if (actData.equals(CampName)) {
//			System.out.println("Campaign name is created");
//		} else {
//			System.out.println("Campaign name is not created");
//		}
//
//		String actPrd = driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();
//		if (actPrd.equals(prdName)) {
//			System.out.println("product name is created");
//		} else {
//			System.out.println("product name is not created");
//		}

		CampValidation validate = new CampValidation(driver);
		validate.validateCamp(driver, CampName);
		validate.validatePrd(driver, prdName);
//		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
//		driver.findElement(By.linkText("Sign Out")).click();

		home.logOut(driver);
	}

}
