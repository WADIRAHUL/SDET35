package com.crm.comcast.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Vendors_Page {

	private WebDriver driver;
	public Vendors_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "img[title='Create Vendor...']")
	private WebElement plusIcon;
	
	public WebElement getPlusIcon() {
		return plusIcon;
	}
}
