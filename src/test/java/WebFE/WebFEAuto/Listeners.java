package WebFE.WebFEAuto;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.ExtentReporter;

public class Listeners implements ITestListener  {

	
	public ExtentTest test;								     //declaring it globally for other methods to use
	ExtentReports extent= ExtentReporter.getReportObject();  //calling the static method getReportObject from its class by creating object
	
	public void onFinish(ITestContext result) 
	{
			extent.flush(); 								// to create the extent report after execution of each test.			
	}
	
	public void onStart(ITestContext result) 
	
	{	
	}
	
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
	public void onTestFailure(ITestResult result) 
	
	{	
		test.fail(result.getThrowable());
		test.log(Status.FAIL,"TEST FAILED");
		
	} 
	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
	public void onTestStart(ITestResult result)
	{
		test= extent.createTest(result.getMethod().getMethodName());
	}
	
	public void onTestSuccess(ITestResult result) 
	
	{
		test.log(Status.PASS, "TEST PASSED");            //using the extent report object to log message 'TEST PASSES' if any test passes.
		
	}

}
