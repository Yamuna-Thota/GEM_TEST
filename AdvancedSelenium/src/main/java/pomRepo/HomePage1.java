package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriver_Utility;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBys;
public class HomePage1 {
	public HomePage1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindAll({@FindBy(css = "[href='index.php?module=Products&action=index']"),@FindBy(xpath = "//a[text()='Products']")})
	private WebElement prdLink;
	
	@FindBys({@FindBy(css = "[alt='Create Product...']"),@FindBy(xpath = "//img[@title='Create Product...']")})
	private WebElement lookUp;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOut;
	
	

	public WebElement clickPrdLink() {
		return prdLink;
	}

	public WebElement getLookUp() {
		return lookUp;
	}
	public WebElement getSignOut() {
		return signOut;
	}

	public void logOut(WebDriver driver) {
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.mouseHoverToEle(driver, prdLink);
		signOut.click();
	}

	
	

	

	}

	


	


