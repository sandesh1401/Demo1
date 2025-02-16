package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.AccountSuccessPage;
import pages.HeaderOptions;
import pages.MyAccountPage;
import pages.MyRightColumnOptionPage;
import pages.RegisterAccountPage;
import utils.CommonUtils;

public class RegisterFTest extends Base {
	public WebDriver driver;
	Properties pro;
	HeaderOptions headerOptions;
	RegisterAccountPage registerPage;
	AccountSuccessPage accountSuccessPage;
	MyAccountPage accountPage;
	MyRightColumnOptionPage rightColumnOption;

	@BeforeMethod
	public void setUpMethod() throws IOException {

		pro = CommonUtils.loadingProperties();
		driver = openApplication();
		headerOptions = new HeaderOptions(driver);
		headerOptions.dropDown();
		registerPage = headerOptions.selectRegister();

	}

	@AfterMethod
	public void tearDown() {
		closeWindow(driver);

	}

	@Test(priority = 1)
	public void verifyRegisteringanAccountbyProvidingOnlytheMandatoryFields() {

		registerPage.enterFName(pro.getProperty("firstName"));
		registerPage.enterLName(pro.getProperty("lastName"));
		registerPage.enterEmail(CommonUtils.generateNewEmail());
		registerPage.enterTNumber(pro.getProperty("telephoneNumber"));
		registerPage.enterPassword(pro.getProperty("validPassword"));
		registerPage.enterCPassword(pro.getProperty("validPassword"));
		registerPage.selectPrivacy();
		accountSuccessPage = registerPage.selectContinue();
		rightColumnOption = accountSuccessPage.getRightOption();
		assertTrue(rightColumnOption.isUserLogIn());
		accountSuccessPage = rightColumnOption.getAccountSuccessPage();
		assertTrue(accountSuccessPage.didWeSawBreadCrumbOption());
		accountPage = accountSuccessPage.continueOption();
		assertTrue(accountPage.editOption());

//		rightColumnOption=accountSuccessPage.getRightOption();
//		assertTrue(rightColumnOption.isUserLogIn());
//	 	accountSuccessPage=rightColumnOption.getAccountSuccessPage();
//		assertTrue(accountSuccessPage.didWeSawBreadCrumbOption());
//		accountPage=accountSuccessPage.continueOption();
//		assertTrue(accountPage.editOption());
//		
	}

	@Test(priority = 2)
	public void verifyRegisteringanAccountbyProvidingalltheFields() {

		registerPage.enterFName(pro.getProperty("firstName"));
		registerPage.enterLName(pro.getProperty("lastName"));
		registerPage.enterEmail(CommonUtils.generateNewEmail());
		registerPage.enterTNumber(pro.getProperty("telephoneNumber"));
		registerPage.enterPassword(pro.getProperty("validPassword"));
		registerPage.enterCPassword(pro.getProperty("validPassword"));
		registerPage.selectYesOption();
		registerPage.selectPrivacy();
		accountSuccessPage = registerPage.selectContinue();
		rightColumnOption = accountSuccessPage.getRightOption();
		assertTrue(rightColumnOption.isUserLogIn());
		accountSuccessPage = rightColumnOption.getAccountSuccessPage();
		assertTrue(accountSuccessPage.didWeSawBreadCrumbOption());
		accountPage = accountSuccessPage.continueOption();
		assertTrue(accountPage.editOption());

	}
}
