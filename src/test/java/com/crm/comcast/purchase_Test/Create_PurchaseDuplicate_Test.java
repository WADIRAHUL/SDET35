package com.crm.comcast.purchase_Test;

import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.comcast.generic_utilities.Base_Class;
import com.crm.comcast.pomrepo.Create_Products_Page;
import com.crm.comcast.pomrepo.Create_Purchase_Page;
import com.crm.comcast.pomrepo.Create_Vendors_Page;
import com.crm.comcast.pomrepo.HomePage;
import com.crm.comcast.pomrepo.Products_Page;
import com.crm.comcast.pomrepo.Purchase_Duplicate_Page;
import com.crm.comcast.pomrepo.Purchase_Info_Page;
import com.crm.comcast.pomrepo.Purchase_Page;
import com.crm.comcast.pomrepo.Vendors_Page;

public class Create_PurchaseDuplicate_Test extends Base_Class {
	
		@Test(groups = "smokeTest")
		public void createPurDupl() throws Exception {
	
		int ranNum = jlib.getRanNum();
		HomePage home = new HomePage(driver);
		home.navigateToVendors();
		
		Vendors_Page vendor = new Vendors_Page(driver);
		vendor.getPlusIcon().click();
		
		String vendorName = elib.excelData("Sheet1", 3, 0)+ranNum;
		Create_Vendors_Page createVen = new Create_Vendors_Page(driver);
		createVen.enterData(vendorName);
				
		home.getProLink().click();
		Products_Page pro = new Products_Page(driver);
		pro.getPlusIcon().click();		
				
		String proName = elib.excelData("Sheet1", 1, 4)+ranNum;
		Create_Products_Page createPro = new Create_Products_Page(driver);
		createPro.enterData(proName);
		
		home.navigateToPurchase();
		
		Purchase_Page purc = new Purchase_Page(driver);
		purc.getPlusIcon().click();
		
		String sub = elib.excelData("Sheet1", 3, 1)+ranNum;
		Create_Purchase_Page createPur = new Create_Purchase_Page(driver);
		createPur.enterPurchase(sub, vendorName);
		
		String billAdd = elib.excelData("Sheet1", 3, 2);
		double qty = elib.excelIntData("Sheet1", 3, 3);
		createPur.enterProduct(billAdd, proName, String.valueOf(qty));

		Purchase_Info_Page purInfo = new Purchase_Info_Page(driver);
		String actualText = purInfo.getPurText().getText();		
		assertTrue(actualText.contains(sub), "The Purchase Order Is Not Created");
		Reporter.log("The Purchase Order Is Succesfully Created", true);
		purInfo.getDuplctBtn().click();
		
		String city = elib.excelData("Sheet1", 3, 4);
		Purchase_Duplicate_Page purDuplct = new Purchase_Duplicate_Page(driver);
		purDuplct.enterData(city);
	}

}
