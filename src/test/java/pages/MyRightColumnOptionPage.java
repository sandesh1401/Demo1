package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyRightColumnOptionPage {
	WebDriver driver;

	public MyRightColumnOptionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='list-group-item'][text()='Logout']")
	private WebElement logout;

	public boolean isUserLogIn() {
		return logout.isDisplayed();

	}

	public AccountSuccessPage getAccountSuccessPage() {
		return new AccountSuccessPage(driver);
	}

	public MyAccountPage getMyAccountPage() {
		return new MyAccountPage(driver);
	}

}