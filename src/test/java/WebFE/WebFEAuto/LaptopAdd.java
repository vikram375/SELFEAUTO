package WebFE.WebFEAuto;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import PageObjects.HomePageOBjects;
import PageObjects.LaptopItemsPageOBjects;
import Resources.BaseClass;


public class LaptopAdd extends BaseClass
{
	
 //Variables//
	public String text;
	public String LaptopPrice;
	public String[] amounttoget; 
	public String laptopamount="";
	public int i=0,j=0,l=0;
	public char ch=' ';
	public String OrderAmount="";
	public static Logger log =LogManager.getLogger(BaseClass.class.getName());  
	//JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@BeforeTest
	public void driver() throws IOException
	
	{
		driver=initializedriver();		
		driver.get(prop.getProperty("url"));                                
		driver.manage().window().maximize();                                 
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);  
	
	}
	
	@Test(dataProvider="laptopname")
	public void AddLaptop(String laptop, String laptopname) throws InterruptedException, AWTException 
	
	{ 	HomePageOBjects lpb = new HomePageOBjects(driver);
		LaptopItemsPageOBjects lipo = new LaptopItemsPageOBjects(driver);
		
		Thread.sleep(2000);
		driver.get(prop.getProperty("url")); 
		lpb.laptoplinkclick().click();
		Robot r = new Robot();
		
		Thread.sleep(2000);
		
		List<WebElement> Lapsall = lipo.AllLaptops();
	
		for (i=0;i<Lapsall.size();i++)
		{			
			String lapname= Lapsall.get(i).getText();
			if(lapname.contains(laptop.trim()))
			{ 	
				Lapsall.get(i).click();
				lipo.AddtoCartButton().click();
				Thread.sleep(3000);
				r.keyPress(KeyEvent.VK_ESCAPE);
				break;
			}
		}
		
	}
		
}		


