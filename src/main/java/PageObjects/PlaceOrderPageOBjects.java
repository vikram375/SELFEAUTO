package PageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlaceOrderPageOBjects
{

	public WebDriver driver=null;
	
	By PlaceOrderButton=By.cssSelector("button[data-target='#orderModal']");		
	By FormNameField= By.id("name");
	By FormCountryField= By.id("country");
	By FormCityField= By.id("city");
	By FormCardField= By.id("card");
	By FormMonthField= By.id("month");
	By FormYearField= By.id("year");
	By FormPurchaseOrderButton= By.xpath("//button[@onClick='purchaseOrder()']");
	By OrderDetails=By.xpath("/html/body/div[10]/p");
	

	public PlaceOrderPageOBjects(WebDriver driver)
	
	{
		this.driver=driver;
	}
	
	public WebElement PlaceOrder()
	
	{
		return driver.findElement(PlaceOrderButton);
	
	}

	public WebElement FormName()
	
	{
		return driver.findElement(FormNameField);
	
	}
	public WebElement FormCountry()
		
		{
			return driver.findElement(FormCountryField);
		
		}
	
	public WebElement FormCity()
	
	{
		return driver.findElement(FormCityField);
	
	}
	
	public WebElement FormCard()
	
	{
		return driver.findElement(FormCardField);
	
	}
	
	public WebElement FormMonth()
	
	{
		return driver.findElement(FormMonthField);
	
	}
	
	public WebElement FormYear()
	
	{
		return driver.findElement(FormYearField);
	
	}
	public WebElement FormPurchaseOrder()
	
	{
		return driver.findElement(FormPurchaseOrderButton);
	
	}
	public WebElement OrderDetailsView()
	
	{
		return driver.findElement(OrderDetails);
	
	}



	
	

}
