package com.crm.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.page.CasePage;
import com.crm.qa.page.HomePage;
import com.crm.qa.page.LoginPage;
import com.crm.qa.util.TestUtil;

public class CasePageTest extends TestBase
{
	HomePage homePage;
	TestUtil testUtil;
	CasePage casePage;
	LoginPage loginPage;
	
	public CasePageTest()
	{
		super();
	}
	@BeforeMethod
	public void Setup()
	{
		initilization();
		loginPage=new LoginPage();
	   testUtil=new TestUtil();
		homePage=loginPage.login(prop.getProperty("user"), prop.getProperty("password"));
		testUtil.switchToFrame();
		casePage=homePage.clickOnCaseLinks();
	}
	
	@Test
	public void verifyCasePageTest()
	{
		Assert.assertTrue(casePage.verifyCaseLabel(),"Support Cases  label missing on the page");
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
