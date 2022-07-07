package com.crm.comcast.generic_utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImpClass implements ITestListener{

	public void onTestFailure(ITestResult result) {
		Java_Utility jlib = new Java_Utility();

		String testName = result.getMethod().getMethodName();
		EventFiringWebDriver edriver = new EventFiringWebDriver(Base_Class.sdriver);

		File srcFile = edriver.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./src/test/resources/errorsots/" + jlib.getSystemDate() + " "+testName+ ".png");

		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
