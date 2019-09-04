package com.crm.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase
{
	@FindBy(xpath="//td[contains(text(),'User: Jitendra Sharma ')]")
	WebElement userNameLable;
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLinks;
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContact;
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLinks;
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement taskLinks;
	@FindBy(xpath="//a[contains(text(),'Calendar')]")
	WebElement calendarLinks;
  @FindBy(xpath=" //a[@title='Companies']")
	WebElement compeniesLinks;
	@FindBy(xpath=" //a[@title='Cases']")
	WebElement casesLinks;
	@FindBy(xpath=" //a[@title='Call']")
	WebElement callLinks;
	@FindBy(xpath=" //a[@title='Email']")
	WebElement emailLinks;
	@FindBy(xpath=" //a[@title='Text/SMS']")
	WebElement testsmsLinks;
	@FindBy(xpath=" //a[@title='Print']")
	WebElement printLinks;
	@FindBy(xpath=" //a[@title='Campaigns']")
	WebElement campaignsLinks;
	@FindBy(xpath="//a[@title='Docs']")
	WebElement docsLinks;
	@FindBy(xpath="//a[@title='Forms']")
	WebElement fromsLinks;
	@FindBy(xpath="//a[@title='Reports']")
	WebElement reportsLinks;
	public HomePage()
	{
		PageFactory.initElements(driver,this);
	}
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	public boolean  verifyCorrectUserName()
	{
		return userNameLable.isDisplayed();
	}
	public ContactsPage clickOnContactsLinks()
	{
		contactsLinks.click();
		return new ContactsPage();
	}
	public DealsPage clickOnDealsLinks()
	{
		dealsLinks.click();
		return new DealsPage();
	}
	public CasePage clickOnCaseLinks()
	{
		casesLinks.click();
		return new CasePage();
	}
	public CalendarPage clickOnCalendarLink()
	{
		calendarLinks.click();
		return new CalendarPage();
	}
	public CompeniesPage clickOnCompeniesLink()
	{
		compeniesLinks.click();
		return new CompeniesPage();
	}
	public CallPage clickOnCallsPage()
	{
		callLinks.click();
		return new CallPage();
	}
	public CampaignsPage clickOnCampaignsLinks()
	{
		campaignsLinks.click();
		return new CampaignsPage();
	}
	public DocsPage clickOnDocsLinks()
	{
		docsLinks.click();
		return new DocsPage();
	}
	public FormsPage ClickOnFormsLink()
	{
		fromsLinks.click();
		return new FormsPage();
	}
	public ReportsPage ClickOnReportsLinks()
	{
		reportsLinks.click();
		return new ReportsPage();
	}
	
	//if we click on task links , it is always return next landing page of Tasks page because
	//when click on link it is next landing page object, hence we return task page class.
	//when we click on any button or link it always return next landing page.
	public TaskPage clickOnTasksLinks()
	{
		taskLinks.click();
		return new TaskPage();
	}
	public void clickOnNewContactLink()
	{
		Actions action=new Actions(driver);
		action.moveToElement(contactsLinks).build().perform();
		newContact.click();
		
	}
}
