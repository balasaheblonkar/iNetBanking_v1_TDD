package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;



public class TC_AddCustomerTest_003 extends BaseClass{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName (username) ;
		log.info("UserName is Provided");
		lp. setPassword (password) ;
		log.info("Password is Provided");
		lp.clickSubmit();

		SoftAssert as=new SoftAssert();
		
		

		AddCustomerPage addcust=new AddCustomerPage (driver);
		
		log.info("Providing Customer details....");

		addcust.clickAddNewCustomer();
		Thread.sleep(5000);
		addcust.clickGoogleAlert();
		addcust.custName ( "Pavan" );
		addcust.custgender("male");
		addcust.custdob("10","15","1985");
		Thread.sleep (3000);
		addcust.custaddress ("INDIA" );
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");

		String Email=randomeString()+"@gmail.com";

		addcust.custemailid(Email);

		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		
		Thread.sleep(3000);
		
		log.info("Validation Started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			log.info("Test case Passed....");
		}
		else
		{
			log.info("Test case Failed....");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
		
	}
	

}
