package json_OtherProg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Broken_Image {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.flipkart.com/");
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println("Total Images Present are "+ images.size());
		
		for (WebElement ele : images) {
			Dimension img = ele.getSize();
			if (img.getHeight()<=24 && img.getWidth()<=24) {
				System.out.println("Image is broken");
			} else {
				System.out.println("Image is not broken");
			}
		}
		driver.quit();
	}
}
