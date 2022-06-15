package com.crm.comcast.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLeadsPage {

	public WebDriver driver;
	public CreateLeadsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "lastname")
	private WebElement laName;
	
	@FindBy(name = "company")
	private WebElement compName;
	
	@FindBy(css = "input[title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getLaName() {
		return laName;
	}

	public WebElement getCompName() {
		return compName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void enterData(String lName, String cName) {
		laName.sendKeys(lName);
		compName.sendKeys(cName);
		saveBtn.click();
	}
}
