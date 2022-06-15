package com.crm.comcast.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization_Page {

	private WebDriver driver;
	public Organization_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "img[title='Create Organization...']")
	private WebElement plusIcon;
	
	public WebElement getPlusIcon() {
		return plusIcon;
	}
}
