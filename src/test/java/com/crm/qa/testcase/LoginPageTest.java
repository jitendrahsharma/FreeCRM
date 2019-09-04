package com.crm.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.page.HomePage;
import com.crm.qa.page.LoginPage;

public class LoginPageTest extends TestBase
{
	HomePage homepPage;
	LoginPage loginPage;
	public LoginPageTest()
	{
		super();
	}
	@BeforeMethod
	public void setUp()
	{
		initilization();
		loginPage=new LoginPage();
	 }
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title,"CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest()
	{
		boolean flag=loginPage.validateCrmImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest()
	{
		homepPage=loginPage.login(prop.getProperty("user"), prop.getProperty("password"));
	}
	@AfterMethod
	public void teatDown()
	{
		driver.quit();
	}
	}

