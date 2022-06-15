package com.crm.comcast.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Vendors_Page {
	
	private WebDriver driver;
	public Create_Vendors_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "vendorname")
	private WebElement venName;
	
	@FindBy(css = "input[title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getVenName() {
		return venName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void enterData(String name) {
		venName.sendKeys(name);
		saveBtn.click();
	}
}
