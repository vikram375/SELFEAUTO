package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;





public class BaseClass 

{
	
	public static  WebDriver driver;  
	public static  Properties prop;

	
	
	
	public static WebDriver initializedriver() throws IOException  
	
	{
	 prop = new Properties();
	
	FileInputStream fis = new FileInputStream("configs//Data.Properties");
	
	prop.load(fis);
	
	prop.getProperty("browser");
	
	String browsername=prop.getProperty("browser");
	
		if (browsername.equals("chrome"))
				
			{
				
				System.setProperty("webdriver.chrome.driver", "BrowserConfigs//chromedriver.exe");
				
				driver= new ChromeDriver();
					
			}
			
		
		else if (browsername.equals("firefox"))
				
			{
				System.setProperty("webdriver.gecko.driver", "BrowserConfigs//geckodriver.exe");
				
				 driver= new FirefoxDriver();
				
			}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		return driver;
	
	}
	
	@DataProvider(name="laptopname")
	public static Object[][] laptopname()
	{	
		Object data [][] = new Object[3][2];
			
			data [0][0]= prop.getProperty("SonyLaptop");
			data [0][1]= prop.getProperty(" ");
			data [1][0]= prop.getProperty("DellLaptop");
			data [1][1]= prop.getProperty(" ");
			data [2][0]= prop.getProperty("Macbook");
			data [2][1]= prop.getProperty(" ");

					
			return data;
	
	}
		
}	

