package com.crm.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase
{
	@FindBy(xpath="//td[contains(text(),'Deals')]")
	WebElement dealsLabel;
	@FindBy(id="title")
	WebElement title;
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement company;
	@FindBy(xpath="//input[@name='contact_lookup']")
	WebElement primaryContact;
	@FindBy(id="amount")
	WebElement amount;
	@FindBy(xpath="//input[@id='probability']")
	WebElement probability;
	@FindBy(xpath="//input[@id='commission']")
	WebElement commission;
	@FindBy(xpath="	//input[@name='identifier']")
	WebElement identifier;
	@FindBy(xpath="//a[contains(text(),'Add one here')]")
	WebElement addNewProduct;

	public DealsPage()
	{
		PageFactory.initElements(driver,this);
	}

	public boolean verifyDealsLabel()
	{
		return dealsLabel.isDisplayed();
	}

	public void createNewDeals()
	{
		
	}
}
