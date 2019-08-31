package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver local;
	
	public LoginPage(WebDriver driver) {
		this.local=driver;
		PageFactory.initElements(local, this);
	}
	
	@FindBy(css="[name='txtUsername']")
	WebElement user;
	
	@FindBy(css="[name='txtPassword']")
	WebElement pass;
	
	@FindBy(css="[name='Submit']")
	WebElement loginButton;
	
	@FindBy(xpath="//*[@id='welcome']")
	WebElement welcomeMsg;
	
	public void loginToApplication(String username, String password) {
		user.sendKeys(username);
		pass.sendKeys(password);
		loginButton.click();
	}
	
	public boolean CheckLogin() {
		boolean b=false;
		try {
			b=welcomeMsg.isDisplayed();
		}catch(Exception e) {}
		return b;
	}
	
}
