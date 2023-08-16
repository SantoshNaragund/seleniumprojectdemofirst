package tests;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.AccountPage;
import PageObjects.LandingPage;
import PageObjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {

	WebDriver driver;
	Logger log;

	@BeforeMethod
	public void loginApplication() throws IOException {

		log = LogManager.getLogger(LoginTest.class.getName());
		driver = initialiseDriver();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");
	}

	@Test(dataProvider = "getLoginData")
	public void login(String email, String password, String expectedStatus) throws IOException, InterruptedException {

		LandingPage langingPage = new LandingPage(driver);
		langingPage.myAccountPage().click();
		log.debug("Clicked on My Account dropdown");
		langingPage.loginOption().click();
		log.debug("Clicked on login option");

		Thread.sleep(3000);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailAddressField().sendKeys(email);
		log.debug("Email addressed got entered");
		loginPage.passwordField().sendKeys(password);
		log.debug("Password got entered");
		loginPage.loginButton().click();
		log.debug("Clicked on Login Button");

		AccountPage accountPage = new AccountPage(driver);
		String actualStatus = null;
		try {
			if (accountPage.editAccountInformationOption().isDisplayed()) {
				log.debug("User got logged in");
				actualStatus = "Succusfully";
			}
		} catch (Exception e) {
			log.debug("User didn't log in");
			actualStatus = "Failure";
		}
		Assert.assertEquals(actualStatus, expectedStatus);
		log.info("Login Test got passed");
	}

	@AfterMethod
	public void closer() {
		driver.close();
		log.debug("Browser got closed");
	}

	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data = { { "santoshnaragund98@gmail.com", "Santu@1234", "Succusfully" } };
		return data;
	}

}



