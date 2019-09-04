package com.crm.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.page.ContactsPage;
import com.crm.qa.page.HomePage;
import com.crm.qa.page.LoginPage;
import com.crm.qa.util.TestUtil;


public class ContactPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactPage;
	TestUtil testUtil;
	String sheetName="Contact";
	
	public ContactPageTest()
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
		homePage=loginPage.login(prop.getProperty("user"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactPage=homePage.clickOnContactsLinks();
	}
	@Test(priority=1)
	public void verifyContactPageTest()
	{
		contactPage.verifyContactLabel();
		Assert.assertTrue(contactPage.verifyContactLabel(), "Contact label missing on the page");
	}
	@Test(priority=3, dependsOnMethods={"validateCreateNewContact"})
	public void selectContactCheckboxTest()
	{
		contactPage.verifyContactName("Dipak Kumar");
	}
	@DataProvider
	public Object[][] getCRMTContactData()
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority=2, dataProvider="getCRMContactData")
	public void validateCreateNewContact(String title,String firstName,String middleName,String last_name,String suffix_Name,String nick_Name, String company_Name,String position)
	{
		homePage.clickOnNewContactLink();
		//contactPage.createNewContact("Mr.","Dipak","abhi","Kumar","Sr.","Dip","Google");
		contactPage.createNewContact(title, firstName, middleName, last_name, suffix_Name, nick_Name, company_Name,position);
		contactPage=homePage.clickOnContactsLinks();
		String contactName=contactPage.verifyNewContactName("Dipak Kumar");
		Assert.assertEquals(contactName, "Dipak Kumar  ");
		System.out.println("New Contact Add successfully in the contact List");
	 }
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
