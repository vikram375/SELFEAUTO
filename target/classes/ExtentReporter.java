package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter

{
	public static ExtentReports extent;
	
	public static ExtentReports getReportObject()    //return type of class name of ExtentReports and making it static to call it directly
	{
			
			String path =System.getProperty("user.dir")+"\\Reports\\index.html";     // creating report path
	
			ExtentSparkReporter reporter= new ExtentSparkReporter(path);             //creating object of helper class to set config.
			reporter.config().setReportName("CART ITEMS");
			reporter.config().setDocumentTitle("Test results");
			
			extent= new ExtentReports();		                             //to attach the report
			extent.attachReporter(reporter);
			extent.setSystemInfo("REPORT","LAPTOPS");
		
			return extent;
	}
	


}
