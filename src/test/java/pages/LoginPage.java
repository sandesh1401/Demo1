package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "input-email")
	private WebElement userName;

	@FindBy(id = "input-password")
	private WebElement passWord;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement login;

	public MyAccountPage performLogin() {
		login.click();
		return new MyAccountPage(driver);
	}

	public void enterPassword(String passwordText) {
		passWord.sendKeys(passwordText);
	}

	public void enterUserName(String emailText) {
		userName.sendKeys(emailText);
	}

}
