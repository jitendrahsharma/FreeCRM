package com.crm.qa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

import WrapperClass.DateClass;

public class ContactsPage extends TestBase
{
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactLabel;
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
	
	public ContactsPage()
	{
		PageFactory.initElements(driver,this);
	}
	public boolean verifyContactLabel()
	{
		return contactLabel.isDisplayed();
	}
public void verifyContactName(String name)
{
	driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow'] "
                                     +"//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();;
}

public String  verifyNewContactName(String contactName)
{
	String getName = null;
	String cName="//a[text()='"+contactName+"']//parent::td[@class='datalistrow'] ";
	for(int i=0; i<=cName.length();i++)
	{
		getName= driver.findElement(By.xpath(cName)).getText();
		System.out.println("Added Contact Name :"+getName);
	}
	return getName;
	
}

public void createNewContact(String title,String firstName,String middleName,String last_name,String suffix_Name,String nick_Name, String company_Name, String position
)
{
	String value="14-Jul-1974";
	Select titlen=new Select(titleName);
	titlen.selectByVisibleText(title);
	first_name.sendKeys(firstName);
	middle_initial.sendKeys(middleName);
	lastName.sendKeys(last_name);
	Select suffix=new Select(suffixName);
	suffix.selectByVisibleText(suffix_Name);
	nickName.sendKeys(nick_Name);
	clientName.sendKeys(company_Name);
	company_position.sendKeys(position);
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
   save.submit();
}
	
}
