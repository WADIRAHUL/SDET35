package com.crm.comcast.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="user_name")
	private WebElement unTextField;
	
	@FindBy(name="user_password")
	private WebElement pwdTextField;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
		
	public WebElement getUnTextField() {
		return unTextField;
	}

	public WebElement getPwdTextField() {
		return pwdTextField;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void loginToApp(String userName, String password) {
		unTextField.sendKeys(userName);
		pwdTextField.sendKeys(password);
		loginBtn.click();
	}
}
