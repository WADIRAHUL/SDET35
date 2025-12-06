package com.crm.comcast.contactTest;

import org.testng.annotations.Test;

import com.crm.comcast.generic_utilities.Base_Class;
import com.crm.comcast.pom_utilities.ContactPage;
import com.crm.comcast.pom_utilities.CreateContactPage;
import com.crm.comcast.pom_utilities.HomePage;

public class Create_Contact_WithoutMandatory extends Base_Class{
	
	@Test
	public void withoutMandatory() {
		
		HomePage home = new HomePage(driver);
		home.getConLink().click();
		
		ContactPage con = new ContactPage(driver);
		con.getPlusIcon().click();
		
		CreateContactPage create = new CreateContactPage(driver);
		create.clickOnAlert();
	}
}
