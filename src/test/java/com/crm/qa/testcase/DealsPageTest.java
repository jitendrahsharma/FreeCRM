package com.crm.qa.testcase;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.page.DealsPage;
import com.crm.qa.page.HomePage;
import com.crm.qa.page.LoginPage;
import com.crm.qa.util.TestUtil;

public class DealsPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	DealsPage dealsPage;
	public DealsPageTest ()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
	initilization();
	loginPage=new LoginPage();
	testUtil=new TestUtil();
	homePage=loginPage.login(prop.getProperty("user"), prop.getProperty("password"));
	testUtil.switchToFrame();
	dealsPage=homePage.clickOnDealsLinks();
		
	}
	@Test
	public void verifyDealsLabelTest()
	{
		Assert.assertTrue(dealsPage.verifyDealsLabel());
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
