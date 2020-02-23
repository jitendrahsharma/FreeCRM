package com.crm.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CalendarPage extends TestBase
{
	@FindBy(xpath="//input[@value='<= Show Calendar for Selected User']")
	WebElement CalendarPage;
	public CalendarPage()
	{
		PageFactory.initElements(driver,this);
	}
	public boolean verifyCalendarLabel()
	{
		return CalendarPage.isDisplayed();
	}
}
