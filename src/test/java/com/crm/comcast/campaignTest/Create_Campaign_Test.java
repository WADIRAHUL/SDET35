
package com.crm.comcast.campaignTest;

import org.testng.Assert;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.generic_utilities.Base_Class;
import com.crm.comcast.pomrepo.CampaignPage;
import com.crm.comcast.pomrepo.Campaign_Info_Page;
import com.crm.comcast.pomrepo.CreateCampaignPage;
import com.crm.comcast.pomrepo.HomePage;

@Listeners(com.crm.comcast.generic_utilities.ListenerImpClass.class)
public class Create_Campaign_Test extends Base_Class {

	@Test(groups = "smokeTest")
	public void createCamp() throws Exception {

		int ranNum = jlib.getRanNum();
		HomePage home = new HomePage(driver);
		home.navigateToCampaign();
		
		CampaignPage camp = new CampaignPage(driver);
		camp.getPlusIcon().click();

		String campName = elib.excelData("Sheet1", 1, 5)+ranNum; 

		CreateCampaignPage createCamp = new CreateCampaignPage(driver);
		createCamp.enterData(campName);

		Campaign_Info_Page campInfo = new Campaign_Info_Page(driver);
		String actualText = campInfo.getCampText().getText();
		
		Assert.assertTrue(actualText.contains(campName), "The Campaign is not created");
		Assert.assertEquals(actualText.contains(campName), true, "The Campaign is not created");
		Reporter.log("The Campaign Is Succesfully Created", true);
	}
}
	




	
