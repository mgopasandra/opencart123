package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistrationpage {

	WebDriver driver;
	
	public AccountRegistrationpage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//creat locators
	@FindBy(id="input-firstname")
	WebElement txtfirstname;
	
	@FindBy(id="input-lastname") 
	WebElement txtlastname;
	
	@FindBy(name="email")
	WebElement txtemail;
	
	@FindBy(id="input-telephone")
	WebElement txttelephone;
	
	@FindBy(id="input-password")
	WebElement txtpassword;
	
	@FindBy(name="confirm")
	WebElement txtconfirmpassword;
	
	@FindBy(xpath="//input[@name='agree']") 
	WebElement chkdpolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btncontinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgconfirmation;
	
	//creat action methods
	
	public void setfirstname(String fname)
	{
		txtfirstname.sendKeys(fname);
	}
	public void setlastname(String lname)
	{
		txtlastname.sendKeys(lname);
	}
	
	public void setemail(String email)
	{
		txtemail.sendKeys(email);
	}
	
	public void settelephone(String tel)
	{
		txttelephone.sendKeys(tel);
	}
	
	public void setpassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	public void setconfrimpwd(String confirmpwd)
	{
		txtconfirmpassword.sendKeys(confirmpwd);
	}
	
	public void setprivacypolicy()
	{
		chkdpolicy.click();
	}
	
	public void clickcontinue()
	{
		btncontinue.click();
	}
	
	public String getconfirmation()
	{
		try
		{
			return(msgconfirmation.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
}
