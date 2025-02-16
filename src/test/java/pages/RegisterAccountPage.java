package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterAccountPage {

	WebDriver driver;

	public RegisterAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordField;

	@FindBy(name = "agree")
	private WebElement privacyField;
	
	@FindBy(xpath="//label[@class='radio-inline' ]//input[@value='1']")
	private WebElement newsLetterField;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueField;

	public AccountSuccessPage selectContinue() {
		continueField.click();
		return new AccountSuccessPage(driver);
	}

	public void selectYesOption() {
		newsLetterField.click();
		
	}
	public void selectPrivacy() {
		privacyField.click();

	}

	public void enterCPassword(String enterConfirmPassword) {
		confirmPasswordField.sendKeys(enterConfirmPassword);
	}

	public void enterPassword(String enterPassword) {
		passwordField.sendKeys(enterPassword);
	}

	public void enterTNumber(String enterTelephoneNumber) {
		telephoneField.sendKeys(enterTelephoneNumber);
	}

	public void enterEmail(String enterEmail) {
		emailField.sendKeys(enterEmail);
	}

	public void enterLName(String enterLastName) {
		lastNameField.sendKeys(enterLastName);
	}

	public void enterFName(String enterFirstName) {
		firstNameField.sendKeys(enterFirstName);
	}

}
