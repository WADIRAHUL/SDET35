package com.crm.comcast.contactTest;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.comcast.generic_utilities.Base_Class;
import com.crm.comcast.pomrepo.ContactPage;
import com.crm.comcast.pomrepo.Contact_Info_Page;
import com.crm.comcast.pomrepo.CreateContactPage;
import com.crm.comcast.pomrepo.HomePage;

public class Delete_Contact_Test extends Base_Class {

	@Test(groups = "regressionTest")
	public void deleteContact() throws Exception {
 
		int ranNum = jlib.getRanNum();
		HomePage home = new HomePage(driver);
		home.getConLink().click();
		ContactPage con = new ContactPage(driver);
		con.getPlusIcon().click();

		String conName = elib.excelData("Sheet1", 1, 6)+ranNum;
		CreateContactPage create = new CreateContactPage(driver);
		create.enterData(conName);

		Contact_Info_Page info = new Contact_Info_Page(driver);
		info.deleteContact();
		Reporter.log("The Contact Is Succesfully Deleted", true);
	}
}
