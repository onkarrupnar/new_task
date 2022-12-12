package com.Utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class Listeners extends BaseClass implements ITestListener {


	ExtentReports extent=ExtentReportGenerator.get_Report();
	ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		Library.test=extent.createTest(result.getTestClass().getName()+"="+result.getMethod().getMethodName());
	    test.set(Library.test);
	}

	public void onTestSuccess(ITestResult result) {
		test.get().log(Status.PASS,"Test Case Successfully completed");
		
	}

	public void onTestFailure(ITestResult result) {
		test.get().log(Status.FAIL,"Test Case Failed");
		test.get().addScreenCaptureFromBase64String(getScreenShot());
		
	}

	public void onTestSkipped(ITestResult result) {
		test.get().log(Status.SKIP,"Test case Skipped");
	}

	public void onFinish(ITestContext context) {
		 extent.flush();
	}

	
	public static String  getScreenShot() {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		return ts.getScreenshotAs(OutputType.BASE64);
		
	}
	
}
