package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver drievr;
	
	public LandingPage(WebDriver driver) {
		this.drievr = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath="//a[@title=\"My Account\"]")
	private WebElement myAccountPage;
	@FindBy(xpath="//*[text()='Login']")
	private WebElement loginOption;

	public WebElement myAccountPage() {
		
		return myAccountPage;
	}
	
	public WebElement loginOption() {
		return loginOption;
	}
	
	 
	 

}
