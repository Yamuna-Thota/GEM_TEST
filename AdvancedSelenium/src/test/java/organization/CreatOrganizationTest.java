package organization;



import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import pomRepo.CreateOrgnization;
import pomRepo.HomePage;
import pomRepo.LoginPage;
import pomRepo.OrgImgLookUp;
import pomRepo.OrgValidation;


public class CreatOrganizationTest extends BaseClass {
	@Test(groups = {"SmokeTesting","RegressionTesting"})
	public void creatOrganizationTest() throws Throwable {

//		File_Utility kp = new File_Utility();
        Java_Utility jlib = new Java_Utility();
		Excel_Utility EU = new Excel_Utility();
     	//WebDriver_Utility wdl = new WebDriver_Utility();
//		//String BROWSER = kp.getKeyAndValue("browser");
//		String URL = kp.getKeyAndValue("url");
//		String USERNAME = kp.getKeyAndValue("username");
//		String PASSWORD = kp.getKeyAndValue("password");
//
	//	wdl.maximizeWindow(driver);
	//	wdl.waitElementsToLoad(driver);
//		driver.get(URL);
//
//		LoginPage login = new LoginPage(driver);
//		login.loginIntoApp(USERNAME, PASSWORD);

		HomePage home = new HomePage(driver);
		home.getOrgLink();

		OrgImgLookUp imgLookUp = new OrgImgLookUp(driver);
		imgLookUp.orgImgClick();
		int ranNum1 = jlib.getRandomNum();
		

		String orgName = EU.getExcelData("Organization", 0, 0) + ranNum1;
		String phnNum = EU.getExcelDataUsingFormatter("Organization", 1, 0);
		String emailId = EU.getExcelDataUsingFormatter("Organization", 2, 0);
		
		CreateOrgnization orgDeatils = new CreateOrgnization(driver);
		orgDeatils.enterOrgDetails(orgName, phnNum, emailId);

		orgDeatils.saveOnClick();
		Thread.sleep(2000);
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//			wait.until(ExpectedConditions.elementToBeClickable());
//		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
//		if (actData.contains(orgName)) {
//			System.out.println("Organization name is created");
//		} else {
//			System.out.println("Organization name is not created");
//		}
		OrgValidation validate = new OrgValidation(driver);
		validate.validateOrg(driver, orgName);
//		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
//		driver.findElement(By.linkText("Sign Out")).click();
	//	home.signOut();

	}

}
