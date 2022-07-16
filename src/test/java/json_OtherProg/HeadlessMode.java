package json_OtherProg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HeadlessMode {

	public static void main(String[] args) {
		WebDriver driver = new HtmlUnitDriver();
		driver.get("https://www.flipkart.com/");
		driver.getTitle();
	}
	
}
