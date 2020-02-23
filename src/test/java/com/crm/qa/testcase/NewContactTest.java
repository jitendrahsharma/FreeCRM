package com.crm.qa.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.page.ContactsPage;
import com.crm.qa.page.HomePage;
import com.crm.qa.page.LoginPage;
import com.crm.qa.page.NewContactPage;
import com.crm.qa.util.TestUtil;

public class NewContactTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactPage;
	TestUtil testUtil;
	NewContactPage newContactPage;
	
	public NewContactTest()
	{
		super();
	}
	@BeforeMethod
	public void loginsetup()
	{
		initilization();
		loginPage=new LoginPage();
		contactPage=new ContactsPage();
		testUtil=new TestUtil();
	    newContactPage=new 	NewContactPage();
		homePage=loginPage.login(prop.getProperty("user"), prop.getProperty("password"));
		testUtil.switchToFrame();
		//contactPage=homePage.clickOnContactsLinks();
		}
	@Test
	public void newContactTest()
	{
		newContactPage.mouseOverContactPage();
		newContactPage.newContactClick();
		newContactPage.newContactPage();
		newContactPage.saveButton();
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
