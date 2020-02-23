package com.crm.qa.page;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

import WrapperClass.DateClass;

public class NewContactPage extends TestBase
{
	@FindBy(xpath="//div[@id='navmenu']//ul[@class='mlddm']//a[@title='Contacts']")
	WebElement contactLable;
	@FindBy(xpath="//div[@id='navmenu']//ul[@class='mlddm']//a[@title='New Contact']")
	WebElement newContact;
	@FindBy(xpath="//select[@name='title']")
	WebElement titleName;
	@FindBy(xpath="//input[@id='first_name']")
	WebElement first_name;
	@FindBy(xpath="//input[@id='middle_initial']")
	WebElement middle_initial;
	@FindBy(xpath="//input[@id='surname']")
	WebElement lastName;
	@FindBy(xpath="//select[@name='suffix']")
	WebElement suffixName;
	@FindBy(xpath="//input[@name='nickname']")
	WebElement nickName;
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement clientName;
	@FindBy(id="company_position")
	WebElement company_position;
	@FindBy(id="department")
	WebElement department;
	@FindBy(xpath="//input[@name='contact_lookup_sup']")
	WebElement supervisor;
	@FindBy(xpath="//input[@name='contact_lookup_ass']")
	WebElement assistant;
	@FindBy(xpath="//input[@name='contact_lookup_ref']")
	WebElement refferredBy;
	@FindBy(xpath="//select[@name='category']")
	WebElement category;
	@FindBy(xpath="//select[@name='status']")
	WebElement status;
	@FindBy(xpath="//input[@id='phone']")
	WebElement phone;
	@FindBy(xpath="//input[@id='mobile']")
	WebElement mobile;
	@FindBy(xpath="//input[@id='home_phone']")
	WebElement home_phone;
	@FindBy(xpath="//input[@id='fax']")
	WebElement fax;
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	@FindBy(xpath="//input[@id='email_alt']")
	WebElement email_alt;
	@FindBy(xpath="//input[@name='receive_email' and @value='Y']")
	WebElement received_email;
	@FindBy(xpath="//input[@name='receive_sms' and @value='Y']")
	WebElement received_sms;
	@FindBy(xpath="//input[@name='allows_call' and @value='Y']")
	WebElement allows_call;
	@FindBy(id="im_id")
	WebElement messengerID;
	@FindBy(xpath="//select[@name='im_netowrk']")
	WebElement MessengerNtwork;
	@FindBy(id="skype_id")
	WebElement skype_ID;
	@FindBy(xpath="//select[@name='source']")
	WebElement source;
	@FindBy(xpath="//img[@id='f_trigger_c_birthday']")
	WebElement clickCalendar;
	@FindBy(xpath="//input[@id='fieldId_birthday']")
	WebElement date;
	@FindBy(xpath="//input[@name='identifier']")
	WebElement identifier;
	@FindBy(xpath="//input[@name='address_title']")
	WebElement addressTitle;
	@FindBy(xpath="//select[@onchange='setAddress(this);']")
	WebElement setAddress;
	@FindBy(xpath="//textarea[@name='address']")
	WebElement address;
	@FindBy(xpath="//input[@name='city']")
	WebElement city;
	@FindBy(xpath="//input[@name='state']")
	WebElement state;
	@FindBy(xpath="//input[@name='postcode']")
	WebElement postCode;
	@FindBy(xpath="//input[@name='country']")
	WebElement country;
	@FindBy(xpath="//input[@name='tags']")
	WebElement tags;
	@FindBy(xpath="//textarea[@name='description']")
	WebElement description;
	@FindBy(xpath="//select[@name='country']")
	WebElement timeZoneByCountry;
	@FindBy(xpath="//select[@name='time_zone']")
	WebElement timeZone;
	@FindBy(xpath="//form[@id='contactForm']//td//input[@value='Save']")
	WebElement save;
	public NewContactPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void mouseOverContactPage()
	{
		WebElement contact=contactLable;
		Actions action=new Actions(driver);
		action.moveToElement(contact).build().perform();
	}
	public void newContactClick()
	{
		newContact.click();
	}

	public void newContactPage()
	{
		String value="14-Jul-1974";
		Select title=new Select(titleName);
		title.selectByValue("Mr.");
		first_name.sendKeys("Aman");
		middle_initial.sendKeys("Naveen");
		lastName.sendKeys("Sharma");
		Select suffix=new Select(suffixName);
		suffix.selectByValue("Sr.");
		nickName.sendKeys("Aman");
		clientName.sendKeys("ECM");
		company_position.sendKeys("Software Tester");
		department.sendKeys("Product Management");
		supervisor.sendKeys("AmarDeep");
		assistant.sendKeys("Dinesh");
		refferredBy.sendKeys("Dipak");
		Select categoryOption=new Select(category);
		categoryOption.selectByValue("Friend");
		Select statusOption=new Select(status);
		statusOption.selectByValue("Active");
		phone.sendKeys("332255666");
		mobile.sendKeys("8983290695");
		home_phone.sendKeys("334354545");
		fax.sendKeys("4756475647564765");
		email.sendKeys("Amansharma@gmail.com");
		email_alt.sendKeys("Amansharma1152@gmail.com");
		received_email.isSelected();
		received_sms.isSelected();
		allows_call.isSelected();
		messengerID.sendKeys("Aman2434");
		Select im_Netwwork=new Select(MessengerNtwork);
		im_Netwwork.selectByValue("MSN Messenger");
		skype_ID.sendKeys("skypaman123344");
		Select sourceinfo=new Select(source);
		sourceinfo.selectByValue("Internet");
		//clickCalendar.click();
		DateClass.selectDateByJs(driver,date,value);
		identifier.sendKeys("am23333");
		addressTitle.sendKeys("Mumbai");
		Select setAddressS=new Select(setAddress);
		setAddressS.selectByVisibleText("Shipping Address");
		address.sendKeys("Chandival road boomerang");
		city.sendKeys("Mumbai");
		state.sendKeys("Maharashtra");
		postCode.sendKeys("400072");
		country.sendKeys("India");
	   tags.sendKeys("JAVA , Selenium");
	   description.sendKeys("This is free CRM test data for the learining perpose do not misuse any one");
	   Select countryTimeZone=new Select(timeZoneByCountry);
	   countryTimeZone.selectByVisibleText("India");
	   Select timezone=new Select(timeZone);
	   timezone.selectByVisibleText("IST - India Standard Time");
	}
	public void saveButton()
	{
		save.submit();
	}

}
