package jdbc;

import java.sql.ResultSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Actitime {

	public static void main(String[] args) throws Throwable {
		DataBaseLibrary db = new DataBaseLibrary("details");
		ResultSet rs = db.getData("select * from d1;");

		while (rs.next()) {
			 System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
			 WebDriver driver = new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 driver.get("https://demo.actitime.com/login.do");
			 driver.findElement(By.id("username")).sendKeys(rs.getString(1));
			 driver.findElement(By.name("pwd")).sendKeys(rs.getString(2));
		}
	}

}
