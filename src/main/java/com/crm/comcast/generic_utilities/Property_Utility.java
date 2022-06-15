package com.crm.comcast.generic_utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class Property_Utility {
	
	public String getPropertyValue(String key) throws Exception {
		
		FileInputStream fis = new FileInputStream(Constants.PROPERTYPATH);
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
	}

	
}
