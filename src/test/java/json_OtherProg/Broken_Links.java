package json_OtherProg;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Broken_Links {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();

		driver.get("https://www.flipkart.com/");
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		System.out.println("Total Images Present are "+ links.size());

		for (WebElement ele : links) {
			String url = ele.getAttribute("href");
			verifyLinks(url);
		}
		driver.quit();
	}

	private static void verifyLinks(String linkUrl) {
		try {
			URL url = new URL(linkUrl);

			HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();
			urlConnect.connect();

			if (urlConnect.getResponseCode()<300) {
				System.out.println(linkUrl+" - link is OK");
			}
		} catch (Exception e) {
			System.out.println(linkUrl+" - "+"is a broken link");
		}


	}
}
