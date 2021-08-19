package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	WebDriver driver;
	   
	   public Loginpage (WebDriver driver)
	   {
		  this.driver=driver;
		  PageFactory.initElements(driver, this);
	   }
	   
	   
	   @FindBy(xpath="//input[@id='input-email']")
	   WebElement txtemailaddress;
	   
	   @FindBy(xpath="//input[@id='input-password']")
	   WebElement txtpassword;
	   
	   @FindBy(xpath="//input[@value='Login']")
	   WebElement clicklogin;
	   
	   @FindBy(xpath="//h2[normalize-space()='My Account']")
	   WebElement msgheading;
	   
	   
	   public  void setemail(String email)
	   {
		   txtemailaddress.sendKeys(email);
	   }
	   
	   public void setpassword(String pwd)
	   {
		   txtpassword.sendKeys(pwd);
	   }
	   
	   public void btnclick()
	   {
		   clicklogin.click();
	   }
	   
	   public boolean ismyaccountpageexists()
	   {
		   try
		   {
			   return(msgheading.isDisplayed());
		   }
		   catch(Exception e)
		   {
			   return(false);
		   }
	   }	   
	   
}
