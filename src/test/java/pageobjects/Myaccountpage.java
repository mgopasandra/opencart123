package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Myaccountpage 
{
	WebDriver driver;
	
	public Myaccountpage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
     WebElement lnklogout;
	
	public void clicklogout()
	{
		lnklogout.click();
	}
	
}
