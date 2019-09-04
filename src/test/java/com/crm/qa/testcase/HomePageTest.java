package com.crm.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.page.ContactsPage;
import com.crm.qa.page.DealsPage;
import com.crm.qa.page.HomePage;
import com.crm.qa.page.LoginPage;
import com.crm.qa.page.TaskPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase 
{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactPage;
	TestUtil testUtil;
	DealsPage dealsPage;
	TaskPage taskPage;
	public HomePageTest()
	{
		super();
	}
	//test cases should be separated --- independent with each other
	//before each test case --- launch the browser and Login
	//@Test ---- excute the test case
	//after each test case ---close the browser.
	@BeforeMethod
	public void loginsetup()
	{
		initilization();
		loginPage=new LoginPage();
		testUtil =new TestUtil();
		homePage=loginPage.login(prop.getProperty("user"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomepageTitleTest()
	{
		String homepagetitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle, "CRMPRO","Home page titile is not matchedS");
		
	}
	@Test(priority=2)
	public void verifyUserName()
	{
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	@Test(priority=3)
	public void clickOnContactTest()
	{
		testUtil.switchToFrame();
		contactPage=homePage.clickOnContactsLinks();
	}
	@Test(priority=4)
	public void clickOnDealsTest()
	{
		testUtil.switchToFrame();
		dealsPage=homePage.clickOnDealsLinks();
	}
	
	@Test(priority=5)
	public void clickOnTaskTest()
	{
		testUtil.switchToFrame();
		taskPage=homePage.clickOnTasksLinks();
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
