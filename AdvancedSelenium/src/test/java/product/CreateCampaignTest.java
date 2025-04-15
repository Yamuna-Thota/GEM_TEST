package product;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;

import pomRepo.CampLookUpImg;
import pomRepo.CampValidation;
import pomRepo.CampValidationAssertionEx;
import pomRepo.CreateCampPage;
import pomRepo.HomePage;
@Listeners(Generic_Utilities.ListenerImp.class)
public class CreateCampaignTest extends BaseClass {
	@Test(retryAnalyzer = Generic_Utilities.RetryImp.class)//(groups = "SmokeTesting")
	public void createCampaignTest() throws Throwable {

		Excel_Utility elib = new Excel_Utility();
//		WebDriver_Utility wlib = new WebDriver_Utility();

		// File_Utility flib = new File_Utility();
		// String BROWSER = flib.getKeyAndValue("browser");
//		String URL = flib.getKeyAndValue("url");
//		String USERNAME = flib.getKeyAndValue("username");
//		String PASSWORD = flib.getKeyAndValue("password");

		// WebDriver driver;

//		if (BROWSER.equalsIgnoreCase("chrome")) {
//			driver = new ChromeDriver();
//		} else if (BROWSER.equalsIgnoreCase("firefox")) {
//			driver = new FirefoxDriver();
//		} else if (BROWSER.equalsIgnoreCase("edge")) {
//			driver = new EdgeDriver();
//		} else {
//			driver = new ChromeDriver();
		// }

//		wlib.maximizeWindow(driver);
//		wlib.waitElementsToLoad(driver);
//
//		driver.get(URL);

//			driver.findElement(http://By.name("user_name")).sendKeys(USERNAME);
//			driver.findElement(http://By.name("user_password")).sendKeys(PASSWORD);
//			driver.findElement(http://By.id("submitButton")).click();

		// using getter methods
//			LoginPage login = new LoginPage(driver);
//			login.getUserTextField().sendKeys(USERNAME);
//			login.getPassWordTextField().sendKeys(PASSWORD);
//			login.getLoginButton().click();

//		// Business Logics
//		LoginPage login = new LoginPage(driver);
//		login.loginIntoApp(USERNAME, PASSWORD);

//			driver.findElement(By.linkText("More")).click();
//			driver.findElement(By.linkText("Campaigns")).click();

		HomePage home = new HomePage(driver);
		home.ClickCampLink();

		// driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		CampLookUpImg lookUp = new CampLookUpImg(driver);
		lookUp.clickCampLookUp();

		String CampName = elib.getExcelData("Campaign", 0, 0);
		System.out.println(CampName);

//		driver.findElement(By.name("campaignname")).sendKeys(CampName);
//
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		CreateCampPage camp = new CreateCampPage(driver);
		camp.enterCampDetails(CampName);
		camp.clickSaveButton();
		Assert.fail("Printing Wantedly");

//		String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Campaign Name\"]")).getText();
//
//		if (actData.equals(CampName)) {
//			System.out.println("Campaign name is created");
//		} else {
//			System.out.println("Campaign name is not created");
//		}

		//CampValidation validate = new CampValidation(driver);
		//validate.validateCamp(driver, CampName);
		CampValidationAssertionEx validate = new CampValidationAssertionEx(driver);
		String actData =validate.validateCamp(driver, CampName);
		Assert.assertEquals(actData, CampName);
		System.out.println("Assert Passed");

//		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
//		driver.findElement(By.linkText("Sign Out")).click();
		//home.signOut();
	}

}