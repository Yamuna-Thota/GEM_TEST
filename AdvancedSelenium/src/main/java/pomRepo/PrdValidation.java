package pomRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class PrdValidation {

	public PrdValidation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public void validatePrd(WebDriver driver,String prdName)
	{
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();

////		if (actData.contains(prdName)) {
////			System.out.println("Product Name is created");
////		} else {
////			System.out.println("Product Name is not created");
//		}

//		Assert.assertEquals(actData, prdName);
//		System.out.println("Assert Passed");
		
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actData, prdName);
		System.out.println("Assert Passed");
	}
}

