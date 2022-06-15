package com.crm.comcast.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.generic_utilities.Web_Driver_Utility;

public class CreateCampaignPage extends Web_Driver_Utility {
	
	private WebDriver driver;
	public CreateCampaignPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "campaignname")
	private WebElement campName;
	
	@FindBy(css = "input[title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(css = "img[title='Select']")
	private WebElement plusProduct;
	
	@FindBy(id = "search_txt")
	private WebElement searchField;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	@FindBy(id = "1")
	private WebElement proList;
	
	public WebElement getCampName() {
		return campName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
		
	public WebElement getPlusProduct() {
		return plusProduct;
	}

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	public WebElement getProList() {
		return proList;
	}

	public void enterData(String name) {
		campName.sendKeys(name);
		saveBtn.click();
	}
	public void enterProduct(String camname, String prName) {
		campName.sendKeys(camname);
		plusProduct.click();
		swithToWindow(driver, "Products&action");
		searchField.sendKeys(prName);
		searchBtn.click();
		proList.click();
		swithToWindow(driver, "Campaigns&action");
		saveBtn.click();
	}
}
