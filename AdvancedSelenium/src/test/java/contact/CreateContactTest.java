package contact;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;

import pomRepo.ContactLookUp;
import pomRepo.ContactValidationAssertionEx;
import pomRepo.ContactValidationPage;
import pomRepo.CreateContactPage;
import pomRepo.HomePage;

public class CreateContactTest extends BaseClass {
	@Test(groups = "SmokeTesting")
	public void createContactTest() throws Throwable {

		// File_Utility kp = new File_Utility();
		Excel_Utility elib = new Excel_Utility();
		//Engineer 1 Pushed
//		WebDriver_Utility wdl = new WebDriver_Utility();
		// String BROWSER = kp.getKeyAndValue("browser");
//		String URL = kp.getKeyAndValue("url");
//		String USERNAME = kp.getKeyAndValue("username");
//		String PASSWORD = kp.getKeyAndValue("password");

//		wdl.maximizeWindow(driver);
//		wdl.waitElementsToLoad(driver);
		// driver.get(URL);
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
//		LoginPage login = new LoginPage(driver);
//		login.loginIntoApp(USERNAME, PASSWORD);
		// driver.findElement(By.xpath("//a[.='Contacts']")).click();
		HomePage home = new HomePage(driver);
		home.ContactLink();

//		driver.findElement(By.cssSelector("[alt=\"Create Contact...\"]")).click();
		ContactLookUp lookUp = new ContactLookUp(driver);
		lookUp.clickContactLookUp();

		CreateContactPage contactPage = new CreateContactPage(driver);
		contactPage.selectDropDOwnVAlue(driver);

		String FirstName = elib.getExcelData("Contact", 0, 0);
		String LastName = elib.getExcelData("Contact", 1, 0);
		contactPage.enterContactDetails(FirstName,LastName);

		contactPage.clickSaveButton();

		// ContactValidationPage validate = new ContactValidationPage(driver);
		ContactValidationAssertionEx validate = new ContactValidationAssertionEx(driver);
		String actData = validate.validateContactFirstNAme(driver, FirstName);
		String actData2 = validate.validateContactLastNAme(driver, LastName);

		Assert.assertEquals(actData, FirstName);
		System.out.println("Asserts Passed");
//		Assert.assertNotSame(actData2, LastName);
//		System.out.println("Asserts Passed");
        SoftAssert soft = new  SoftAssert();
        soft.assertEquals(actData2, LastName);
        System.out.println("Assert Passed");
        soft.assertAll();
//		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
//		driver.findElement(By.linkText("Sign Out")).click();

		// home.logOut(driver);
	}

}
