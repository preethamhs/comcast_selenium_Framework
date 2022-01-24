package com.crm.comcast.genericlibrary;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImp implements ITestListener {
	
     public void onTestFailure(ITestResult result) {
    	String testName = result.getMethod().getMethodName();
    	String sysdate = new Date().toString().replace(":","_").replace(" ","-");
    	EventFiringWebDriver eDriver=new EventFiringWebDriver(BaseClass.sdriver);
    	File src = eDriver.getScreenshotAs(OutputType.FILE);
    	File dest=new File("./screenshot/"+testName+" "+sysdate+".png");
    	try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			
		}
    }
}
