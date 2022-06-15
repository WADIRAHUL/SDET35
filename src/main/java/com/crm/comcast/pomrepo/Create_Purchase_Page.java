package com.crm.comcast.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.generic_utilities.Web_Driver_Utility;

public class Create_Purchase_Page extends Web_Driver_Utility {

	private WebDriver driver;
	public Create_Purchase_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "subject")
	private WebElement sub;
	
	@FindBy(css = "img[src=\"themes/softed/images/select.gif\"]")
	private WebElement plusVendor;
	
	@FindBy(id = "search_txt")
	private WebElement searchField;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	@FindBy(id = "1")
	private WebElement purList;
	
	@FindBy(css = "input[title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name = "bill_street")
	private WebElement billAdd;
	
	@FindBy(xpath = "//b[text()='Copy Billing address']/..//input[@name='cpy']")
	private WebElement radioBtn;
	
	@FindBy(id = "searchIcon1")
	private WebElement searchItem;
	
	@FindBy(xpath = "//a[contains(@vt_prod_arr,'\"rowid\":\"1\"')]")
	private WebElement proList;
	
	@FindBy(id = "qty1")
	private WebElement qty;

	public WebElement getSub() {
		return sub;
	}

	public WebElement getPlusVendor() {
		return plusVendor;
	}

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getPurList() {
		return purList;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getBillAdd() {
		return billAdd;
	}

	public WebElement getRadioBtn() {
		return radioBtn;
	}

	public WebElement getSearchItem() {
		return searchItem;
	}

	public WebElement getProList() {
		return proList;
	}

	public WebElement getQty() {
		return qty;
	}

	public void enterPurchase(String subj, String purName) {
		sub.sendKeys(subj);
		plusVendor.click();
		swithToWindow(driver, "Vendors&action");
		searchField.sendKeys(purName);
		searchBtn.click();
		purList.click();
		swithToWindow(driver, "PurchaseOrder&action");
	}
	
	public void enterProduct(String add, String prName, String quantity) {
		billAdd.sendKeys(add);
		radioBtn.click();
		searchItem.click();
		swithToWindow(driver, "Products&action");
		searchField.sendKeys(prName);
		searchBtn.click();
		proList.click();
		swithToWindow(driver, "PurchaseOrder&action");
		qty.sendKeys(quantity);
		saveBtn.click();
	}
}
