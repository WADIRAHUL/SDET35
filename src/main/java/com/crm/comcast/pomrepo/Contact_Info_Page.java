package com.crm.comcast.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.generic_utilities.Web_Driver_Utility;

public class Contact_Info_Page extends Web_Driver_Utility {

	private WebDriver driver;
	public Contact_Info_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "dvHeaderText")
	private WebElement contactText;
	
	@FindBy(name = "Delete")
	private WebElement deleteBtn;
	
	public WebElement getContactText() {
		return contactText;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}
	
	public void deleteContact() {
		deleteBtn.click();
		switchToAlertWindowAndAccpect(driver, "Are you sure you want to delete this record?");
	}
}
