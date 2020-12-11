package WebFE.WebFEAuto;


import java.util.List;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import PageObjects.PlaceOrderPageOBjects;
import Resources.BaseClass;



public class LaptopSetCompare extends BaseClass
{
	
 //Variables//
	public String text;
	public  int finallapsCostToDel,SumoffinallapsCostToDel=0;
	public String[] amounttoget; 
	public String laptopamount="";
	public int i=0,j=0,k=0;
	public char ch=' ';
	public String OrderAmount="";
	public static Logger log =LogManager.getLogger(BaseClass.class.getName());  
	
	@Test
	public void PlaceOrder() throws InterruptedException
	{
	PlaceOrderPageOBjects ppo= new PlaceOrderPageOBjects(driver);
	
	Thread.sleep(3000);

	List<WebElement> LapListToDel = driver.findElements(By.xpath("//tr[@class='success']/td[3]"));
	
	for (k=0;k<LapListToDel.size();k++)
	{
		String lapsCostToDel= LapListToDel.get(k).getText();
		
		 int finallapsCostToDel=Integer.parseInt(lapsCostToDel);  
		 
		 SumoffinallapsCostToDel = SumoffinallapsCostToDel + finallapsCostToDel;
		
	}
	
	ppo.PlaceOrder().click();		
	ppo.FormName().sendKeys(prop.getProperty("FormName"));
	ppo.FormCountry().sendKeys(prop.getProperty("FormCountry"));
	ppo.FormCity().sendKeys(prop.getProperty("FormCity"));
	ppo.FormCard().sendKeys(prop.getProperty("FormCard"));
	ppo.FormMonth().sendKeys(prop.getProperty("FormMonth"));
	ppo.FormYear().sendKeys(prop.getProperty("FormYear"));
	Thread.sleep(3000);
	ppo.FormPurchaseOrder().click();
	
	Thread.sleep(2000);
	
	text=ppo.OrderDetailsView().getText();
	
	log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	log.info("Order details are as follows -->");
	log.info(text);
	log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	
	}
	
	@Test
	public void compare()
	{	
		
		amounttoget =text.split(":");
		
		for (i=0;i<amounttoget.length;i++)
		{	
			laptopamount=amounttoget[2];
		}
		for (j=0;j<laptopamount.length();j++)
		{
			ch=laptopamount.charAt(j);
		if (Character.isDigit(ch))
		{
			OrderAmount=OrderAmount+ch;
		}
		}
		
		log.info("The expected amount for the laptop is-->"+SumoffinallapsCostToDel+" USD");
		log.info("The purchase amount for the laptop is-->"+OrderAmount+" USD");
		
	}
	
	@AfterTest
	public void closebrowser()
	
	{
		driver.quit();
		driver=null;                                                                       
	}
	

}
