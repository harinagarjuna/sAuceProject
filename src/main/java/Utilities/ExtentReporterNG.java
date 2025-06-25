package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports getReportObject(String pathname) {
		String path = System.getProperty("user.dir")+pathname;
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("SAuceProjectReport1");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Hari Nagarjuna");
		return extent;
		
				
	}

}
