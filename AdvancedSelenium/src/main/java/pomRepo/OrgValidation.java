package pomRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class OrgValidation {
	public OrgValidation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void validateOrg(WebDriver driver, String orgName) {
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
//		if (actData.contains(orgName)) {
//			System.out.println("Organization name is created");
//		} else {
//			System.out.println("Organization name is not created");
//		}
		Assert.assertEquals(actData, orgName);
	System.out.println("Assert Passed");
		
//		SoftAssert soft = new SoftAssert();
//		soft.assertEquals(actData, orgName);
//		System.out.println("Assert Passed");
	}
}
