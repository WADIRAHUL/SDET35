package com.crm.comcast.organizationsTest;

import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.comcast.generic_utilities.Base_Class;
import com.crm.comcast.pomrepo.Create_Organization_Page;
import com.crm.comcast.pomrepo.HomePage;
import com.crm.comcast.pomrepo.Organization_Info_Page;
import com.crm.comcast.pomrepo.Organization_Page;

public class Create_Organization_Test extends Base_Class {
	
	@Test(groups = "smokeTest")
	public void createOrg() throws Exception {
	
		int ranNum = jlib.getRanNum();
		HomePage home = new HomePage(driver);
		home.getOrgLink().click();
		
		Organization_Page org = new Organization_Page(driver);
		org.getPlusIcon().click();
		
		String orgName = elib.excelData("Sheet1", 1, 3)+ranNum;
		Create_Organization_Page createOrg = new Create_Organization_Page(driver);
		createOrg.enterData(orgName);
		
		Organization_Info_Page orgInfo = new Organization_Info_Page(driver);
		String actualText = orgInfo.getOrgText().getText();
		assertTrue(actualText.contains(orgName), "The Organization Is Not Created");
		Reporter.log("The Organization Is Succesfully Created", true);
	}
}
