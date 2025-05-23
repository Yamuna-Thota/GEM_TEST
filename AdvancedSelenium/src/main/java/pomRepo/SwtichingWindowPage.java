package pomRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwtichingWindowPage {

	public SwtichingWindowPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "search_text")
	private WebElement searchPrd;

	@FindBy(css = "[name=\"search\"]")
	private WebElement searchBar;

	public void searchPrdName(String name) {
		searchPrd.sendKeys(name);
		searchBar.click();
	}

	public void dynamicXpath(WebDriver driver, String productName) {
		driver.findElement(By.xpath("//a[text()='" + productName + "']")).click();

	}
}
