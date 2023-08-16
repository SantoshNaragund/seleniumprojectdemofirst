package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	WebDriver drievr;

	public AccountPage(WebDriver driver) {
		this.drievr = driver;
		PageFactory.initElements(driver, this);
		}
	@FindBy(linkText="Edit your account information")
	private WebElement editAccountInformationOption;
    
	public WebElement editAccountInformationOption() {
		return editAccountInformationOption;
	}
}
