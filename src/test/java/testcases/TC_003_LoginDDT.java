package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.Loginpage;
import pageobjects.Myaccountpage;
import testbase.Baseclass;
import utilities.XLUtility;

public class TC_003_LoginDDT extends Baseclass
{
	 @Test(dataProvider="LoginData")
	   public void test_loginDDT(String email,String password, String exp)
	   {
		   logger.info("starting TC_003_LoginDDT ");
		   
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
				lp.setemail("email");
				 logger.info("email enterd ");
				 
				lp.setpassword("password");
				 logger.info("provided password ");
				 
				lp.btnclick();
				 logger.info("clciked on login");
				 
				 boolean targetpage=lp.ismyaccountpageexists();
				 if(exp.equals("valid"))
				 {
					 if(targetpage==true)
					 {
					 logger.info("login successful");
					 Myaccountpage myaccpage=new Myaccountpage(driver);
					 Assert.assertTrue(true);
				 }
				 else
				 {
					 logger.error("Login failed"); //will handle negative cases
					 Assert.assertTrue(false);
				 }
				
		   }
			if(exp.equals("Invalid"))
			{
				if(targetpage==true)
				{
					Myaccountpage myaccpage=new Myaccountpage(driver);
					myaccpage.clicklogout();
					Assert.assertTrue(false);
				}
				else
				{
					logger.error("Login failed");
					Assert.assertTrue(true);
				}
			}
		   }
		   catch(Exception e)
		   {
			   logger.fatal("login failed");
			   Assert.fail();
		   }
		 
		   logger.info("finished TC_003_LoginDDT ");
	   }
	 
@DataProvider(name="LoginData")
public String [][] getData() throws IOException
{
	String path=".\\testdata\\Opencart_LoginData.xlsx";
	
	XLUtility xlutil=new XLUtility(path);
	
	int totalrows=xlutil.getRowCount("Sheet1");	
	int totalcols=xlutil.getCellCount("Sheet1",1);
			
	String logindata[][]=new String[totalrows][totalcols];
	
	for(int i=1;i<=totalrows;i++)  //1
	{		
		for(int j=0;j<totalcols;j++)  //0
		{
			logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
		}
	}
return logindata;
			
}
}


