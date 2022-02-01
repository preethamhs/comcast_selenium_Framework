package com.crm.comcast.genericlibrary;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImp implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	
     public void onTestStart(ITestResult result) {
    	  test = report.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,result.getMethod().getMethodName()+"is passed");
		
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP,result.getMethod().getMethodName()+"is skipped");
		test.log(Status.SKIP,result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter spark=new ExtentSparkReporter("./extentReport.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Vtiger automation");
		spark.config().setReportName("Excecution report");
		
	    report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS","Windows 10");
		report.setSystemInfo("Platform","Windows 10");
		report.setSystemInfo("Reporter","Preetham H S");
		
	}

	public void onFinish(ITestContext context) {
		report.flush();
		
	}

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
    	test.log(Status.FAIL,result.getMethod().getMethodName()+"is failed");
    	test.log(Status.FAIL,result.getThrowable());
    	test.addScreenCaptureFromPath(dest.getAbsolutePath());
    }
}
