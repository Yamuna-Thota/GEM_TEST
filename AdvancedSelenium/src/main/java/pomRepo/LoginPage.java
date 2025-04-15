package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
	

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="user_name")
	private WebElement UserTextField;
	
	@FindBy(name="user_password")
	private	 WebElement PasswordTextField;
	
	@FindBy(id ="submitButton")
	private WebElement LoginButton;

	public WebElement getUserTextField() {
		return UserTextField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}
/**
 * This method is used to login the Application
 * @param userName
 * @param passWord
 */

	public void loginIntoApp(String userName, String passWord) {
		UserTextField.sendKeys(userName);
		PasswordTextField.sendKeys(passWord);
		LoginButton.click();
	
		
	}
	

	}

