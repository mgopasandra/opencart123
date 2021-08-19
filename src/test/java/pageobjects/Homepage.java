package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
   WebDriver driver;
   
   public Homepage(WebDriver driver)
   {
	  this.driver=driver;
	  PageFactory.initElements(driver, this);
   }
    //locators
   @FindBy(xpath="//i[@class='fa fa-user']") 
   WebElement lnkaccount;
   
   @FindBy(xpath="//a[normalize-space()='Register']") 
   WebElement lnkregister;
   
   @FindBy(xpath="//a[normalize-space()='Login']") 
   WebElement lnklogin;
   
   
   public void clickmyaccount()
   {
	   lnkaccount.click();
   }
   
   public void clickregister()
   {
	   lnkregister.click();
   }
   
   public void clicklogin()
   {
	   lnklogin.click();
   }
   
}
