package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {

	private WebDriver local;
	
	public Dashboard(WebDriver driver) {
		this.local=driver;
		PageFactory.initElements(local, this);
	}
	@FindBy(xpath="//*[@id='content']/descendant::*[text()='Dashboard']")
	WebElement msgDashboard;
	
	@FindBy(xpath="//*[@class='quickLaunge']")
	List<WebElement> quickLaunch;
	
	public boolean checkDashboardMsg() {
		boolean b=false;
		try {
			b=msgDashboard.isDisplayed();
		}catch(Exception e) {}
		return b;
	}
	
	public int quickLaunchCount() {
		int a=0;
		a=quickLaunch.size();
		return a;
	}
	public List<String> getQuickLaunchStrings(){
		List<String> str= new ArrayList<String>();
		for(WebElement e:quickLaunch) {
			str.add(e.getText());
		}
		return str;
	}
}
