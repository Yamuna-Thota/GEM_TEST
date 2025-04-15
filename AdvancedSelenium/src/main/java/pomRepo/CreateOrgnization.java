package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgnization {

	public CreateOrgnization(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "accountname")
	private WebElement orgName;

	@FindBy(id = "phone")
	private WebElement phnNum;

	@FindBy(id = "email1")
	private WebElement emailId;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getPhnNum() {
		return phnNum;
	}

	public WebElement getEmailId() {
		return emailId;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	/**
	 * This is the business Logic to enter the org details
	 * 
	 * @author Sasi
	 */

	public void enterOrgDetails(String Name, String Num, String Id) {
		orgName.sendKeys(Name);
		phnNum.sendKeys(Num);
		emailId.sendKeys(Id);

	}

	public void saveOnClick() {
		saveButton.click();
	}

}
