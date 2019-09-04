package com.crm.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase
{
	//PageFactory or OR (Object Repository)
		@FindBy(name="username")
		WebElement username;
		@FindBy(name="password")
		WebElement password;
		@FindBy(xpath="//input[@type='submit']")
		WebElement loginBtn;
		@FindBy(xpath="//a[contains(text(),'Sign Up')]")
		WebElement signUpbtn;
		@FindBy(xpath="//a[@class='navbar-brand']//img[contains(@class,'img-responsive')]")
		WebElement crmLogo;
		
		//initialization the page object 
		public LoginPage()
		{
			PageFactory.initElements(driver, this);
		}
		
		//Action
		public String  validateLoginPageTitle()
		{
			return driver.getTitle();
		}
		public boolean  validateCrmImage()
		{
			return crmLogo.isDisplayed();
		}
		public HomePage login(String un,String pwd)
		{
			username.sendKeys(un);
			password.sendKeys(pwd);
			loginBtn.submit();
			return new HomePage();
		}
		public void signuppage()
		{
			signUpbtn.click();
		}


	 

}
