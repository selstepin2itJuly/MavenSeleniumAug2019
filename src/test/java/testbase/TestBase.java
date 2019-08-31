package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

	protected static WebDriver driver;
	public static Properties prop;
	public static String username;
	public static String password;
	private static final Logger logger = Logger.getLogger(TestBase.class);
	
	public static WebDriver getInstance() throws IOException {
		
		String cofingFile="src/main/java/config/config.properties";
		FileInputStream file=new FileInputStream(new File(cofingFile));
		
		prop=new Properties();
		prop.load(file);
		
		username=prop.getProperty("username");
		password=prop.getProperty("password");
		
		String str=prop.getProperty("browser");
		/*Proxy pr= new Proxy();
		pr.setHttpProxy("");
		pr.setSocksUsername("sdfad");
		pr.setSocksPassword("svsdfa");*/
		logger.info("Starting Browser:"+str);
		
		if(str.equalsIgnoreCase("chrome")) 
		{
			String key="webdriver.chrome.driver";
			String value="drivers/chromedriver.exe";
			System.setProperty(key, value);
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability("--disable-infobars", false);
			
			ChromeOptions opt=new ChromeOptions();
			//opt.setCapability("disable-infobars", true);
			opt.addArguments("disable-infobars");
			//opt.setCapability("disable-notifications", true);
			//opt.addArguments("--disable-notifications");
			//opt.addArguments("--incognito");
			//opt.addArguments("--headless");
			//opt.setProxy(pr);
			opt.merge(cap);
			driver=new ChromeDriver(opt);
		} else if(str.equalsIgnoreCase("firefox")) {
			String key="webdriver.gecko.driver";
			String value="drivers/geckodriver.exe";
			System.setProperty(key, value);
			driver=new FirefoxDriver();	
		}
		driver.manage().window().maximize();
		/*WebListernersClass web=new WebListernersClass();
		edriver=(WebDriver) web;*/
		logger.info("Started Browser:"+str);
		driver.get(prop.getProperty("url"));
		logger.info("Started URL:"+prop.getProperty("url"));
		return driver;
	}
	/*public static WebDriver getInstanceChrome() {
		String key="webdriver.chrome.driver";
		String value="drivers/chromedriver.exe";
		System.setProperty(key, value);
		driver=new ChromeDriver();
		return driver;
	}
	public static WebDriver getInstanceFirefox() {
		String key="webdriver.gecko.driver";
		String value="drivers/geckodriver.exe";
		System.setProperty(key, value);
		driver=new FirefoxDriver();
		return driver;
	}*/

}
