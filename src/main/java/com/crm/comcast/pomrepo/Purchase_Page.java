package com.crm.comcast.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Purchase_Page {

	private WebDriver driver;
	public Purchase_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "img[title='Create Purchase Order...']")
	private WebElement plusIcon;
	
	public WebElement getPlusIcon() {
		return plusIcon;
	}
}
