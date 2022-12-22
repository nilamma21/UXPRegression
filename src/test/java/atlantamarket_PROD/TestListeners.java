package atlantamarket_PROD;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtendReporterNG;
import resources.base;

public class TestListeners extends base implements ITestListener {
	
	ExtentTest test;
	ExtentReports extent = ExtendReporterNG.getReportObject();
	
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		extent.flush();
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		String testMethodName = arg0.getName().toString().trim();
		Log.info(testMethodName +" Started");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		//try {
			String testMethodName = arg0.getName().toString().trim();
			//test.addScreenCaptureFromPath(capture(driver, testMethodName));
			test.fail(arg0.getThrowable());
			Log.info("FAILED- "+testMethodName);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		String testMethodName = arg0.getName().toString().trim();
		Log.info("SKIPPED- "+testMethodName);
		test.log(Status.SKIP, "Test Skipped");
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		test = extent.createTest(arg0.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		String testMethodName = arg0.getName().toString().trim();
		System.out.println("PASSED- "+testMethodName);
		test.log(Status.PASS, "Test Passed");
	}

}
