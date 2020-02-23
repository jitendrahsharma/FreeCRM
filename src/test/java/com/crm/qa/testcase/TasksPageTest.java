package com.crm.qa.testcase;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.page.HomePage;
import com.crm.qa.page.LoginPage;
import com.crm.qa.page.TaskPage;
import com.crm.qa.util.TestUtil;

public class TasksPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	TaskPage taskPage;
	public TasksPageTest()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		initilization();
		loginPage=new LoginPage();
		testUtil=new TestUtil();
		homePage=loginPage.login(prop.getProperty("user"), prop.getProperty("password"));
		testUtil.switchToFrame();
		taskPage=homePage.clickOnTasksLinks();
	}
	@Test
	public void verifyTaskLabelTest()
	{
		Assert.assertTrue(taskPage.verifyTaskLabel());
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
