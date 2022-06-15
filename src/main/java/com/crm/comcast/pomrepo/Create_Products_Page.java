package com.crm.comcast.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Products_Page {
	
	private WebDriver driver;
	public Create_Products_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "productname")
	private WebElement proName;
	
	@FindBy(css = "input[title='Save [Alt+S]']")
	private WebElement saveBtn;
		
	public WebElement getProName() {
		return proName;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void enterData(String name) {
		proName.sendKeys(name);
		saveBtn.click();
	}
}
