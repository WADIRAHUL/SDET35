package com.crm.comcast.generic_utilities;

import java.time.LocalDateTime;
import java.util.Random;

public class Java_Utility {
	public int getRanNum() {
		Random ran = new Random();
		int ranNum = ran.nextInt(10000);
		return ranNum;
	}
	
	public String getSystemDate() {
		String timeStamp = LocalDateTime.now().toString().replace(':', '-');
		return timeStamp;
	}
}
