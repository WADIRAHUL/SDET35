package property;

 import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actitime_Property {
	public static void main(String[] args) throws IOException {
		String path = "./src/test/resources/Data.properties";
		FileInputStream fis = new FileInputStream(path);
		Properties pro = new Properties();
		pro.load(fis);
		String browser = pro.getProperty("browser");
		System.out.println(browser);
		WebDriver driver = null;
		if(browser.equalsIgnoreCase("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		
		}
		//System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(pro.getProperty("url1"));
		driver.findElement(By.id("username")).sendKeys(pro.getProperty("un1"));
		driver.findElement(By.name("pwd")).sendKeys(pro.getProperty("pwd1"));
		driver.findElement(By.id("loginButton")).click();
		driver.quit();
	}
}
