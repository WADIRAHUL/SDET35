package com.crm.comcast.generic_utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.crm.comcast.pomrepo.HomePage;
import com.crm.comcast.pomrepo.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {
	
	public Property_Utility plib=new Property_Utility();
	public Excel_Utility elib=new Excel_Utility();
	public Java_Utility jlib = new Java_Utility();
	public Web_Driver_Utility wlib = new Web_Driver_Utility();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(groups = {"smokeTest", "regressionTest"})
	public void bs() {
		Reporter.log("DataBase is connected", true);
	}
	
	@BeforeTest(groups = {"smokeTest", "regressionTest"})
	public void bt() {
		Reporter.log("Batch Execution is Executing", true);
	}
	
	@Parameters("Browser")
	@BeforeClass(groups = {"smokeTest", "regressionTest"})
	public void launchBrowser(@Optional("chrome") String Browser) throws Exception {
//		String browser = plib.getPropertyValue("browser");
		
		if(Browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else {
			driver=new ChromeDriver();
		}
		driver.get(plib.getPropertyValue("url"));
		wlib.max(driver);
		wlib.implicitWait(driver);
		wlib.explicitWait(driver);
		sdriver = driver;
	}
	@BeforeMethod(groups = {"smokeTest", "regressionTest"})
	public void login() throws Exception  {
		LoginPage login = new LoginPage(driver);
		login.loginToApp(plib.getPropertyValue("un"), plib.getPropertyValue("pwd"));
	}
	@AfterMethod(groups = {"smokeTest", "regressionTest"})
	public void logout() {
		HomePage home = new HomePage(driver);
		home.logout();
	}
	@AfterClass(groups = {"smokeTest", "regressionTest"})
	public void quit() {
		driver.quit();
		Reporter.log("Browser Closed Successfully", true);
	}
	
	@AfterTest(groups = {"smokeTest", "regressionTest"})
	public void at() {
		Reporter.log("Batch Execution is Ended", true);
	}
	
	@AfterSuite(groups = {"smokeTest", "regressionTest"})
	public void as() {
		Reporter.log("DataBase is closed Successfully", true);
	}
}
