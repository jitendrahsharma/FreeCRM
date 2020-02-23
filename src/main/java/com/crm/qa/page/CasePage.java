package com.crm.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CasePage extends TestBase
{
	@FindBy(xpath="//td[contains(text(),'Support Cases')]")
	WebElement caseLable;
	public CasePage()
	{
		PageFactory.initElements(driver,this);
	}
	public boolean verifyCaseLabel()
	{
		return caseLable.isDisplayed();
	}
	
}
