package com.crm.comcast.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Purchase_Duplicate_Page {

	private WebDriver driver;
	public Purchase_Duplicate_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "bill_city")
	private WebElement billCity;
	
	@FindBy(css = "input[title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getBillCity() {
		return billCity;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void enterData(String cityName) {
		billCity.sendKeys(cityName);
		saveBtn.click();
	}
}
