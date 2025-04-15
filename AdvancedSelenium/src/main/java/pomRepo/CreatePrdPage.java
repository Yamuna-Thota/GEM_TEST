package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePrdPage {

	public CreatePrdPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "productname")
	private WebElement prdName;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public void enterPrdDetails(String name) {
		prdName.sendKeys(name);
		saveButton.click();
	}
}