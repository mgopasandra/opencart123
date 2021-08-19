package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.AccountRegistrationpage;
import pageobjects.Homepage;
import testbase.Baseclass;

public class TC_001_AccountRegistration extends Baseclass{
	
	@Test(groups={"regression","master"})
	public void test_account_registration ()
	{
		logger.info("Starting TC_001_AccountRegistration");
		try
		{
		driver.get(rd.getString("appURL"));
		logger.info("Home page displayed");
		
		driver.manage().window().maximize();
		logger.info("window maximised");
		
		Homepage hp=new Homepage(driver);
		hp.clickmyaccount();
		logger.info("Clicked on Myaccount");
		
		hp.clickregister();
		logger.info("Clicked on register");
		
		AccountRegistrationpage repage=new AccountRegistrationpage(driver);
		
		repage.setfirstname("manu");
		logger.info("Provided firstname");
		
		repage.setlastname("gowda");
		logger.info("provided lastname");
		
		repage.setemail(randomstring()+"@gmail.com");
		logger.info("provided email");
		
		repage.settelephone("11011993");
		logger.info("provided phonenumber");
		
		repage.setpassword("abcde");
		logger.info("provided password");
		
		repage.setconfrimpwd("abcde");
		logger.info("provided confirmpassword");
		
		repage.setprivacypolicy();
		logger.info("provided setprivacy policy");
		
		repage.clickcontinue();
		logger.info("click on continue");
		
		String confirmmsg=repage.getconfirmation();
		
		if(confirmmsg.equals("Your Account Has Been Created!"))
		{
			logger.info("Account registeration succesful");
			Assert.assertTrue(true);
		}
		
		else
		{
			captureScreen(driver,"TC_001_AccountRegistration");
			logger.error("Account regsitered failed");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			logger.fatal("Account regsitration failed");
			Assert.fail();
		}
		logger.info("finished TC_001_AccountRegistration");
	}
	
	
}
