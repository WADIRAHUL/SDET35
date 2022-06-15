package com.crm.comcast.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.generic_utilities.Web_Driver_Utility;

public class CreateContactPage extends Web_Driver_Utility {

	private WebDriver driver;
	public CreateContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastNameText;
	
	@FindBy(css = "input[title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getLastNameText() {
		return lastNameText;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void enterData(String lastName) {
		lastNameText.sendKeys(lastName);
		saveBtn.click();
	}
	
	public void clickOnAlert() {
		saveBtn.click();
		switchToAlertWindowAndAccpect(driver, "Last Name cannot be empty");
	}
}
