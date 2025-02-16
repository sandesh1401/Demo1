package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderOptions {

	WebDriver driver;

	public HeaderOptions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDrop;

	@FindBy(linkText = "Register")
	private WebElement myRegister;
	
	@FindBy(xpath="//li[@class='dropdown open']//a[text()='Login']")
	private WebElement myLogin;
	
	public LoginPage getLogin() {
	myLogin.click();
	return new LoginPage(driver);
	}

	public RegisterAccountPage selectRegister() {
		myRegister.click();
		return new RegisterAccountPage(driver);
	}

	public void dropDown() {
		myAccountDrop.click();
	}

}
