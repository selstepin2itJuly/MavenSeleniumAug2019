package testcases;

import org.testng.annotations.Test;

import pages.Dashboard;
import pages.LoginPage;
import testbase.TestBase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

/**
 * 
 * 
 * @author fakhr
 *
 */

public class LoginFeature {
	private	WebDriver driver;
	LoginPage lp;
	Dashboard db;
  @Test(priority=001,description="To Verify Login Successful")
  public void verifyLoginSuccess() {
	  System.out.println("F1");  
	  lp.loginToApplication(TestBase.username, TestBase.password);
	  boolean condition = lp.CheckLogin();
	  Assert.assertTrue(condition);
  }
  @Test(priority=002,enabled=true,description="To Verify Login Unsuccessful")
  public void verifyLoginFailure() {
	  System.out.println("F2");
	  lp.loginToApplication("Username", "Password");
	  boolean condition = lp.CheckLogin();
	  Assert.assertTrue(condition);
  }
  @Test(priority=003,enabled=true,timeOut=2000,description="To Verify count on Quick Launch")
  public void verifyQuickLunchCount() throws InterruptedException {
	  System.out.println("F3");
	  Thread.sleep(1000);
	  lp.loginToApplication(TestBase.username, TestBase.password);
	  Assert.assertEquals(db.quickLaunchCount(),3);
  }
  
  @Test(priority=004,dependsOnMethods="verifyQuickLunchCount",description="To Verify Text on Quick Launch")
  public void verifyQuickLaunchText() {
	  System.out.println("F3");
	  lp.loginToApplication(TestBase.username, TestBase.password);
	  List<String> str = db.getQuickLaunchStrings();
	  Assert.assertEquals(str.get(0), "Assign Leave");
	  Assert.assertEquals(str.get(1), "Leave List");
	  Assert.assertEquals(str.get(2), "Timesheets");
  }
  @BeforeMethod(alwaysRun=true)
  public void beforeMethod() throws IOException {
	  System.out.println("Before Method");
	  driver=TestBase.getInstance();
	  lp=new LoginPage(driver);
	  db=new Dashboard(driver);
  }

  @AfterMethod(alwaysRun=true)
  public void afterMethod() {
	  System.out.println("After Method");
	  driver.quit();
  }

  @BeforeClass
  public void beforeClass() throws IOException {
	  System.out.println("Before Class");
	/*  driver=TestBase.getInstance();
	  lp=new LoginPage(driver);
	  db=new Dashboard(driver);*/
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("After Class");
	  //driver.quit();
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Before Test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("After Test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Before Suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("After Suite");
  }

}
