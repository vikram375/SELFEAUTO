package PageObjects;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LaptopItemsPageOBjects
{


	public WebDriver driver=null;
	
	By AddToCart= By.linkText("Add to cart"); 	
	By Cart= By.linkText("Cart"); 
	By AllLaptopnames =By.cssSelector("h4[class='card-title'] a");
	By LaptopsToRemove =By.cssSelector("tbody[id='tbodyid'] td:nth-child(2)");
	By AllDeleteButtons = By.cssSelector("tbody[id='tbodyid'] td:nth-child(4) a");
	

	public LaptopItemsPageOBjects(WebDriver driver)
	
	{
		this.driver=driver;
	}
	

	
	public WebElement AddtoCartButton()
	
	{
		return driver.findElement(AddToCart);
	
	}
	
	public WebElement CartButton()
	
	{
		return driver.findElement(Cart);
	
	}
	
	public List<WebElement> AllLaptops()
	
	{
		return driver.findElements(AllLaptopnames);
	
	}
	
	public List<WebElement> RemoveLaps()
	
	{
		return driver.findElements(LaptopsToRemove);
	
	}
	public List<WebElement> DeletButton()
	
	{
		return driver.findElements(AllDeleteButtons);
	
	}


	
	

}
