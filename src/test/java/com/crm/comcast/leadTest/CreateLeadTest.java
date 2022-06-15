package com.crm.comcast.leadTest;

import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.comcast.generic_utilities.Base_Class;
import com.crm.comcast.pomrepo.CreateLeadsPage;
import com.crm.comcast.pomrepo.HomePage;
import com.crm.comcast.pomrepo.LeadInfoPage;
import com.crm.comcast.pomrepo.LeadsPage;

public class CreateLeadTest extends Base_Class{

	@Test
	public void createLead() throws Exception {
		int ranNum = jlib.getRanNum();
		HomePage home = new HomePage(driver);
		home.navigateToLead();
		
		LeadsPage lead = new LeadsPage(driver);
		lead.getPlusIcon().click();

		String lName = elib.excelData("Sheet1", 6, 0)+ranNum;
		String compName = elib.excelData("Sheet1", 6, 1);
		CreateLeadsPage creLead = new CreateLeadsPage(driver);
		creLead.enterData(lName, compName);
		
		LeadInfoPage info = new LeadInfoPage(driver);
		String actualText = info.getLeadText().getText();
		
		Assert.assertTrue("The Lead Is Not Created", actualText.contains(lName));
		Reporter.log("The Lead is Successfully Created", true);
	}
}
