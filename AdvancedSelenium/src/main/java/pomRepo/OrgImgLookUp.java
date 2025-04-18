package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgImgLookUp {

	public OrgImgLookUp(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//img[@title=\"Create Organization...\"]")

	private WebElement orgImgLookUp;

	public WebElement orgImgLookUp() {
		return orgImgLookUp;
	}

	public void orgImgClick() {
		orgImgLookUp.click();
	}

}
