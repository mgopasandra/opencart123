package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.Loginpage;
import testbase.Baseclass;

public class TC_002_Login extends Baseclass
{
   @Test(groups={"sanity","master"})
   public void test_login()
   {
	   logger.info("starting TC_002_Login ");
	   
	   try
	   {
		   driver.get(rd.getString("appURL"));
		   logger.info("Home page is dispalyed");
		   
		   driver.manage().window().maximize();
		   logger.info("window is maximised");
		   
		   Homepage hp=new Homepage(driver);
			hp.clickmyaccount();
			logger.info("Clicked on Myaccount");
			
			hp.clicklogin();
			logger.info("Clicked on Login");
			
			Loginpage lp=new Loginpage(driver);
			lp.setemail(rd.getString("email"));
			 logger.info("email enterd ");
			 
			lp.setpassword(rd.getString("password"));
			 logger.info("provided password ");
			 
			lp.btnclick();
			 logger.info("clciked on login");
			 
			 boolean targetpage=lp.ismyaccountpageexists();
			 if(targetpage)
			 {
				 logger.info("login successful");
				 Assert.assertTrue(true);
			 }
			 else
			 {
				 logger.error("Login failed");
				 captureScreen(driver , "TC_002_Login");
				 Assert.assertTrue(false);
			 }
			
	   }
	   catch(Exception e)
	   {
		   logger.fatal("login failed");
		   Assert.fail();
	   }
	   
	   logger.info("Finished TC_002_Login");
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
