package com.crm.comcast.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.generic_utilities.Web_Driver_Utility;

public class HomePage extends Web_Driver_Utility {

	public WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement conLink;
	
	@FindBy(linkText = "Products")
	private WebElement proLink;
	
	@FindBy(linkText = "Vendors")
	private WebElement venLink;
	
	@FindBy(linkText = "Purchase Order")
	private WebElement purLink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campLink;
	
	@FindBy(linkText = "Sign Out")
	private WebElement logLink;
	
	@FindBy(linkText = "Leads")
	private WebElement leadLink;
	
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(css = "img[src=\"themes/softed/images/user.PNG\"]")
	private WebElement administrator;

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getConLink() {
		return conLink;
	}

	public WebElement getProLink() {
		return proLink;
	}

	public WebElement getVenLink() {
		return venLink;
	}

	public WebElement getPurLink() {
		return purLink;
	}

	public WebElement getCampLink() {
		return campLink;
	}

	public WebElement getLogLink() {
		return logLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}
	
	public WebElement getLeadLink() {
		return leadLink;
	}

	public WebElement getAdministrator() {
		return administrator;
	}
	
	public void logout() {
		moveElement(driver, administrator);
		logLink.click();
		System.out.println("You Have Successfully Logged Out");
	}
	
	public void navigateToCampaign() {
		moveElement(driver, moreLink);
		campLink.click();	
	}
	
	public void navigateToVendors() {
		moveElement(driver, moreLink);
		venLink.click();	
	}
	
	public void navigateToPurchase() {
		moveElement(driver, moreLink);
		purLink.click();	
	}
	
	public void navigateToLead() {
		moveElement(driver, leadLink);
		leadLink.click();	
	}
}
