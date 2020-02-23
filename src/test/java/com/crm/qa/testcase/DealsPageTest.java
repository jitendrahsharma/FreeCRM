package com.crm.qa.testcase;

import org.junit.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.page.DealsPage;
import com.crm.qa.page.HomePage;
import com.crm.qa.page.LoginPage;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WriteTestResult;

public class DealsPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	DealsPage dealsPage;
	String sheetName="Deals";
	String colName="Result";
	WriteTestResult write;
	public DealsPageTest ()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
	initilization();
	loginPage=new LoginPage();
	 dealsPage=new DealsPage();
	testUtil=new TestUtil();
	homePage=loginPage.login(prop.getProperty("user"), prop.getProperty("password"));
	testUtil.switchToFrame();
	
		
	}
	@Test(priority=1)
	public void verifyDealsLabelTest()
	{
		dealsPage=homePage.clickOnDealsLinks();
		Assert.assertTrue(dealsPage.verifyDealsLabel());
	}
	@Test(priority=2)
	public void validateCreatedNewProduct() throws InterruptedException
	{
		homePage.clickOnNewProductLink();
		dealsPage.clickOnNewProduct();
		dealsPage.createNewProduct();
	}
	
	@DataProvider
	public Object[][] getCRMDealsData()
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority=3,dataProvider="getCRMDealsData")
	public void validateCreatedNewDeals(String dealsTitle,String companyName,String Amount,String commission,String Identifier,String tags, String cDescription,String next_steps) throws InterruptedException
	{
		homePage.clickOnNewDealsLink();
		dealsPage.createNewDeals(dealsTitle,companyName,Amount,commission,Identifier,tags,cDescription,next_steps);
		String dealsTitle1=dealsPage.verifyNewDeals("Citi Card Deals");
		Assert.assertEquals(dealsTitle1, "Citi Card Deals");
		System.out.println("New Deals Add successfully in the Deals List");
	
	}
	/*@AfterMethod
	public void testResult(ITestResult result)
	{
		if(ITestResult.SUCCESS==result.getStatus())
		{
			write.setCellData(sheetName,colName,2,"Pass");
		}
		else if(ITestResult.FAILURE==result.getStatus())
		{
			write.setCellData(sheetName,colName,2,"Fail");
		}
		}*/
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
