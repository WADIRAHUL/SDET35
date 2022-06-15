package excel;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo_Excel {
	public static void main(String[] args) throws Exception {
		String path = "./src/test/resources/TestData.xlsx";
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		String sheetName = "Sheet1";
		String url = wb.getSheet(sheetName).getRow(1).getCell(0).getStringCellValue();
		String un = wb.getSheet(sheetName).getRow(1).getCell(1).getStringCellValue();
		String pwd = wb.getSheet(sheetName).getRow(1).getCell(2).getStringCellValue();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.name("pwd")).sendKeys(pwd);
		driver.findElement(By.id("loginButton")).click();
		wb.close();
	}
}
