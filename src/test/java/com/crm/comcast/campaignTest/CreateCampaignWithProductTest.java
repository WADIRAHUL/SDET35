package com.crm.comcast.campaignTest;

import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.comcast.generic_utilities.Base_Class;
import com.crm.comcast.pomrepo.CampaignPage;
import com.crm.comcast.pomrepo.CreateCampaignPage;
import com.crm.comcast.pomrepo.Create_Products_Page;
import com.crm.comcast.pomrepo.HomePage;
import com.crm.comcast.pomrepo.Products_Info_Page;
import com.crm.comcast.pomrepo.Products_Page;

public class CreateCampaignWithProductTest extends Base_Class {
	
	@Test(groups = "regressionTest")
	public void createCampPro() throws Exception {
			
		int ranNum = jlib.getRanNum();
		HomePage home = new HomePage(driver); 
		home.getProLink().click();
		Products_Page pro = new Products_Page(driver);
		pro.getPlusIcon().click();
		
		String proName = elib.excelData("Sheet1", 1, 4)+ranNum;
		Create_Products_Page createPro = new Create_Products_Page(driver);
		createPro.enterData(proName);
		
		Products_Info_Page proInfo = new Products_Info_Page(driver);
		String actualText = proInfo.getProText().getText();
		assertTrue(actualText.contains(proName), "The Product Is Not Created");
		Reporter.log("The Product Is Succesfully Created", true);
		home.navigateToCampaign();
		
		CampaignPage camp = new CampaignPage(driver);
		camp.getPlusIcon().click();
		
		String campName = elib.excelData("Sheet1", 1, 5)+ranNum;
		CreateCampaignPage createCamp = new CreateCampaignPage(driver);
		createCamp.enterProduct(campName, proName);
	}
}


