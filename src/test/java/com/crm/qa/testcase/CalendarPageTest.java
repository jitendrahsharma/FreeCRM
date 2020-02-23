package com.crm.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.page.CalendarPage;
import com.crm.qa.page.HomePage;
import com.crm.qa.page.LoginPage;
import com.crm.qa.util.TestUtil;

public class CalendarPageTest extends TestBase
{
	HomePage homePage;
	TestUtil testUtil;
	CalendarPage calendarpage;
	LoginPage loginPage;
	
	public CalendarPageTest()
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
		calendarpage=homePage.clickOnCalendarLink();
	}
	
	@Test
	public void verifyCalendarPageTest()
	{
		Assert.assertTrue(calendarpage.verifyCalendarLabel(),"Calendar label missing on the page");
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
