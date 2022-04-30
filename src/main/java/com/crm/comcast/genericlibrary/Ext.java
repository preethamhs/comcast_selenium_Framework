package com.crm.comcast.genericlibrary;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Ext implements ITestListener{
     
	ExtentReports report;
	ExtentTest test;
	
	public void onStart(ITestContext context) {
		
		ExtentSparkReporter spark=new ExtentSparkReporter("./extRp.html");
		
		spark.config().setDocumentTitle("vtiger");
		
	    report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("name", "wind");
	}

	public void onTestStart(ITestResult result) {
	  
	  test = report.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+" is passed");
		
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP,result.getMethod().getMethodName()+" is skipped" );
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed");
		test.log(Status.FAIL, result.getThrowable());
	}
	
	
	
	
	
	
	
	
	
	

}
