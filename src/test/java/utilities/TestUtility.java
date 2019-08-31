package utilities;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import testbase.TestBase;

public class TestUtility extends TestBase{

	static JavascriptExecutor j;
	
	public static void scrollToElement(WebElement ele) throws InterruptedException {
		j=(JavascriptExecutor) driver;
		Thread.sleep(2000);	
		j.executeScript("arguments[0].scrollIntoView(false);", ele);
		j.executeScript("window.scrollBy(0,400)", "");
	}
	
	public static void clickOnElement(WebElement ele) throws InterruptedException {
		j=(JavascriptExecutor) driver;
		j.executeScript("arguments[0].click();", ele);
		
	}
	public static void sendKeysToElement(WebElement ele, String s) throws InterruptedException {
		j=(JavascriptExecutor) driver;
		j.executeScript("arguments[0].value='"+s+"'", ele);
		
	}
	
	public static void captureScreen() throws IOException {
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(f, new File("image_"+getTime()+"_.jpg"));
	}
	
	static String getTime() {
		Date date= new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY_MM_dd_HH_mm_ss");
		String str = sdf.format(date);
		System.out.println(str);
		return str;
		
	}
}
