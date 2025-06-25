package Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners implements ITestListener {
	ExtentTest test;
	
	ExtentReports extent = ExtentReporterNG.getReportObject("//Reports\\SAuceProjectReport1.html");
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName()); 
	  }

	  
	  public void onTestSuccess(ITestResult result) {
	    test.log(Status.PASS, "Test is PASS");
	  }

	  
	  public void onTestFailure(ITestResult result) {
		  test.log(Status.FAIL, "Test is FAILED");
	    
	  }

	  
	  public void onTestSkipped(ITestResult result) {
	    
	  }
	  
	  public void onFinish(ITestContext context) {
		    extent.flush();
		  }

	 

}
