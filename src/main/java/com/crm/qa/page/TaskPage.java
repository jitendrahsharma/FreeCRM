package com.crm.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class TaskPage extends TestBase
{
	@FindBy(xpath="//td[contains(text(),'Tasks')]")
	WebElement tasksLabel;
	public TaskPage()
	{
		PageFactory.initElements(driver,this);
	}

	public boolean verifyTaskLabel()
	{
		return tasksLabel.isDisplayed();
	}
}
