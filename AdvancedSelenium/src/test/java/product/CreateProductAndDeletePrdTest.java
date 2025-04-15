package product;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import pomRepo.CreatePrdPage;
import pomRepo.HomePage;
import pomRepo.LoginPage;
@Test
public class CreateProductAndDeletePrdTest extends BaseClass {

	public  void createProductAndDeletePrdTest() throws Throwable {

		Excel_Utility elib = new Excel_Utility();
		Java_Utility jlib = new Java_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();

		File_Utility flib = new File_Utility();
		//String BROWSER = flib.getKeyAndValue("browser");
//		String URL = flib.getKeyAndValue("url");
//		String USERNAME = flib.getKeyAndValue("username");
//		String PASSWORD = flib.getKeyAndValue("password");

		wlib.waitElementsToLoad(driver);
		//driver.get(URL);
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.cssSelector("[alt=\"Create Product...\"]")).click();

		Java_Utility jib = new Java_Utility();
		int ranNum = jib.getRandomNum();
		
		String prdName = elib.getExcelData("Product", 0, 0)+ranNum;
		System.out.println(prdName);

		driver.findElement(By.name("productname")).sendKeys(prdName);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();

		if (actData.contains(prdName)) {
			System.out.println("Product Name is created");
		} else {
			System.out.println("Product Name is not created");
		}

		driver.findElement(By.linkText("Products")).click();
		//table[@class="lvt small"]//a[text()='Product Name']/../preceding-sibling::td//input[@type="checkbox"]
		driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='"+prdName+"']/../preceding-sibling::td//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("(//input[@value='Delete'])[1]")).click();
		
		driver.switchTo().alert().accept();
		
		List<WebElement> allNames = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));
		
		boolean flag=false;
		for (WebElement name : allNames)
		{
			String actPrd = name.getText();
			if(actPrd.equals(prdName))
			{
			flag=true;
			break;
		}
			}
		if(flag)
		{
			System.out.println("product name is deleted");
		}
		else
		{
			System.out.println("Product name is not deleted");
		}
		
	}

}