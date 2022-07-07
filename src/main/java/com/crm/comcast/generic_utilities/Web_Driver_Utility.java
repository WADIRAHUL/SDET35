package com.crm.comcast.generic_utilities;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Web_Driver_Utility {

	public void max(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICITWAIT, TimeUnit.SECONDS);
	}

	public void explicitWait(WebDriver driver) {
		@SuppressWarnings("unused")
		WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICICTWAIT);
	}

	public void swithToWindow(WebDriver driver , String partialWindowUrl) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String wID = it.next();
			driver.switchTo().window(wID);
			String url = driver.getCurrentUrl();
			if(url.contains(partialWindowUrl)) {
				break;
			}
		}
	}

	public void moveElement(WebDriver driver, WebElement ele) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();	
	}

	public void switchToAlertWindowAndAccpect(WebDriver driver ,String expectedMsg) {
		Alert alt = driver.switchTo().alert();
		if(alt.getText().trim().equalsIgnoreCase(expectedMsg.trim())) {
			System.out.println("Alert Text is Correct");
		}else {
			System.out.println("Alert Text is not Correct");
		}
		alt.accept();
	}

}





