package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {

	WebDriver driver;

	public AccountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Success")
	private WebElement successPage;
	
	@FindBy(linkText="Continue")
	private WebElement continueButton;
	
	public boolean didWeSawBreadCrumbOption() {
		return successPage.isDisplayed();
	}
	
	public MyAccountPage continueOption() {
		continueButton.click();
		return new MyAccountPage(driver);
	}
	
	public MyRightColumnOptionPage getRightOption() {
		return new MyRightColumnOptionPage(driver);
	}
}
