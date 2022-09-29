package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest1() throws IOException
	{
	
	log.info("url is opened");
	LoginPage lp=new LoginPage(driver);
	lp.setUserName (username) ;
	log.info("username entered");
	lp.setPassword(password);
	log.info("password entered");
	lp.clickSubmit();
	log.info("clicked on submit");
	
	Assert.assertEquals("Guru99 Bank Manager HomePage", driver.getTitle());
	
	
	/*if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))// this alternate approach to validate TC and taking Screenshot
	{
		Assert.assertTrue(true);
		log.info("Test case passed");
	}
	else
	{
		captureScreen(driver,"loginTest1");
		Assert.assertTrue(false);
		
		log.info("Test case failed");
	}*/
	}
}
