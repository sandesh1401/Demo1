package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import pages.HeaderOptions;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.MyRightColumnOptionPage;
import utils.CommonUtils;
import utils.MyXLSReader;

public class LoginFTest extends Base {

	Properties pro;
	public WebDriver driver;
	HeaderOptions headerOptions;
	LoginPage loginPage;
	MyAccountPage accountPage;
	MyRightColumnOptionPage rightPage;

	@BeforeMethod
	public void setUp() throws IOException {

		pro = CommonUtils.loadingProperties();
		driver = openApplication();
		headerOptions = new HeaderOptions(driver);
		headerOptions.dropDown();
		loginPage = headerOptions.getLogin();

	}

	@AfterMethod
	public void tearDown() {
		closeWindow(driver);
	}

	@Test(priority = 1)
	public void verifyLoggingintotheApplicationusingValidcredentials() {

		loginPage.enterUserName(pro.getProperty("existingEmail"));
		loginPage.enterPassword(pro.getProperty("validPassword"));
		accountPage = loginPage.performLogin();
		rightPage = accountPage.getRightOption();
		assertTrue(rightPage.isUserLogIn());
		accountPage = rightPage.getMyAccountPage();
		assertTrue(accountPage.editOption());
	}

	@Test(priority = 2, dataProvider = "validCredentialsSupplier")
	public void verifyLoggingintotheApplicationusingDifferentValidcredentials(HashMap<String, String> map) {

		loginPage.enterUserName(map.get("Email"));
		loginPage.enterPassword(map.get("Password"));
		accountPage = loginPage.performLogin();
		rightPage = accountPage.getRightOption();
		assertTrue(rightPage.isUserLogIn());
		accountPage = rightPage.getMyAccountPage();
		assertTrue(accountPage.editOption());

	}

	@DataProvider(name = "validCredentialsSupplier")
	public Object[][] dataForLogin() {
		MyXLSReader myXLSReader = new MyXLSReader("//src//test//resources//TutorialNinja.xlsx");
		Object[][] data = CommonUtils.getTestData(myXLSReader, "loginWithValidCredentials", "login");
		return data;
	}

}
