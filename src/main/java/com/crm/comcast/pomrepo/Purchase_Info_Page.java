package com.crm.comcast.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Purchase_Info_Page {

	private WebDriver driver;
	public Purchase_Info_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "lvtHeaderText")
	private WebElement purText;
	
	@FindBy(name = "Duplicate")
	private WebElement duplctBtn;
	
	public WebElement getPurText() {
		return purText;
	}

	public WebElement getDuplctBtn() {
		return duplctBtn;
	}

	public void setDuplctBtn(WebElement duplctBtn) {
		this.duplctBtn = duplctBtn;
	}
}
