package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriver_Utility;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "More")
	private WebElement moreLink;

	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLink;

	@FindBy(css = "[src='themes/softed/images/user.PNG']")
	private WebElement admLink;

	@FindBy(linkText = "Sign Out")
	private WebElement signOut;

	@FindBy(linkText = "Products")
	private WebElement prdLink;

	@FindBy(linkText = "Organizations")
	private WebElement orgLink;

	@FindBy(xpath = "//a[.='Contacts']")
	private WebElement contactsLink;

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getorgLink() {
		return orgLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getAdmLink() {
		return admLink;
	}

	public WebElement getSignOut() {
		return signOut;
	}

	public WebElement getPrdLink() {
		return prdLink;
	}

	/**
	 * This is used to click on CampaignLink
	 */
	public void ClickCampLink() {
		moreLink.click();
		campaignsLink.click();
	}

	public void logOut(WebDriver driver) {
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.mouseHoverToEle(driver, admLink);
		signOut.click();
	}

	public void signOut() {
		admLink.click();
		signOut.click();
	}

	public void clickPrdLink() {
		prdLink.click();
	}

	public void orgLink() {
		orgLink.click();
	}
	
	public void ContactLink() {
		contactsLink.click();
	}


	

}
