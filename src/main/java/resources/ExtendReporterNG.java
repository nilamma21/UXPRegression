package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReporterNG {
	static ExtentReports extent;
	
	public static ExtentReports getReportObject() {
		String path= System.getProperty("user.dir")+"/reports/RegressionTestResults.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("Regression Automation Test Results");
		reporter.config().setDocumentTitle("Test Results");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Cybage");
		return extent;
		
	}

}
