package com.crm.comcast.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Organization_Page {

	private WebDriver driver;
	public Create_Organization_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "accountname")
	private WebElement orgName;
	
	@FindBy(css = "input[title='Save [Alt+S]']")
	private WebElement saveBtn;
			
	public WebElement getOrgName() {
		return orgName;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void enterData(String name) {
		orgName.sendKeys(name);
		saveBtn.click();
	}
}
