package PageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageOBjects
{
	
	

	public WebDriver driver=null;
	
	By laptophyperlink= By.linkText("Laptops"); 		//To click popup on page load and select NOT NOW.
	

	public HomePageOBjects(WebDriver driver)
	
	{
		this.driver=driver;
	}
	

	public WebElement laptoplinkclick()
	
	{
		return driver.findElement(laptophyperlink);
	
	}


	
	

}
