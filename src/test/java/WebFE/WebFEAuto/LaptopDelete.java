package WebFE.WebFEAuto;


import java.util.List;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import PageObjects.LaptopItemsPageOBjects;
import Resources.BaseClass;



public class LaptopDelete extends BaseClass
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
	

		@Test
		public void RemoveLaptop() throws InterruptedException
		{
		LaptopItemsPageOBjects lipo = new LaptopItemsPageOBjects(driver);	
		lipo.CartButton().click();
		Thread.sleep(5000);
		
		List<WebElement> Laps = lipo.RemoveLaps();
		List<WebElement> DeleteButton = lipo.DeletButton();
		
		for (int a=0;a<Laps.size();a++)
			{
			String LapnametoDelete=Laps.get(a).getText();
			
					
					if(Laps.get(0).getText().equalsIgnoreCase(prop.getProperty("DellLaptop")))
						{	
							for (int z=0;z<DeleteButton.size();z++)
							{	
								DeleteButton.get(0).click();
								break;
							}
						}
					 if(Laps.get(1).getText().equalsIgnoreCase(prop.getProperty("DellLaptop")))
						{
						   for (int z=0;z<DeleteButton.size();z++)
							{	
								DeleteButton.get(1).click();
								break;
							}
						}
					if(Laps.get(2).getText().equalsIgnoreCase(prop.getProperty("DellLaptop")))
						{	
							
							for (int z=0;z<DeleteButton.size();z++)
							{	
								DeleteButton.get(2).click();
								break;
							}
						}	
					
				}				
			}
		
}		


