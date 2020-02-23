package com.crm.qa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
//import  com.crm.qa.base.*;
import com.crm.qa.base.TestBase;

import WrapperClass.DateClass;

public class DealsPage extends TestBase
{
	
	@FindBy(xpath="//td[contains(text(),'Deals')]")
	WebElement dealsLabel;
	@FindBy(id="title")
	WebElement title;
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement company;
	@FindBy(xpath="//input[@name='contact_lookup']")
	WebElement primary_Contact;
	@FindBy(id="amount")
	WebElement totalAmount;
	@FindBy(xpath="//input[@id='probability']")
	WebElement probabilityPer;
	@FindBy(xpath="//input[@id='commission']")
	WebElement commissionPer;
	@FindBy(xpath="	//input[@name='identifier']")
	WebElement identifierKey;
	@FindBy(id="tags")
	WebElement tag;
	@FindBy(id="description")
	WebElement descriptions;
	@FindBy(id="next_step")
	WebElement nextSteps;
	@FindBy(xpath="//input[@value='New Product']")
	WebElement addNewProduct;
	@FindBy(xpath="//select[@name='product_group']")
	WebElement product_group;
	@FindBy(xpath="//input[@id='name']")
	WebElement productName;
	@FindBy(xpath="//input[@id='cost']")
	WebElement cost;
	@FindBy(xpath="//input[@id='retail_value']")
	WebElement retail_value;
	@FindBy(xpath="//input[@id='wholesale']")
	WebElement  wholesale;
	@FindBy(xpath="//a[contains(text(),'Add')]")
	WebElement productGroupAdd;
	@FindBy(id="sku")
	WebElement sku;
	@FindBy(id="inventory_amount")
	WebElement inventoryAmount;
	@FindBy(xpath="//textarea[@name='description']")
	WebElement proDescription;
	@FindBy(xpath="//form[@id='productForm']/table/tbody/tr/td/input")
	WebElement saveProduct;
	@FindBy(xpath="//input[@name='client_lookup']//following-sibling::input[@value='Lookup']")
	WebElement lookup;
	@FindBy(xpath="//input[@id='search']")
	WebElement search;
	@FindBy(xpath="//input[@value='Search']")
	WebElement submitSearch;
	@FindBy(xpath="//select[@id='product_id']")
	WebElement product;
	@FindBy(xpath="//input[@id='quantity']")
	WebElement quantity;
	@FindBy(xpath="//*[@id='prospectForm']/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td[2]/select")
	WebElement type;
	@FindBy(xpath="//select[@name='source' and @class='select']")
	WebElement source;
	@FindBy(xpath="//select[@name='stage']")
	WebElement stage;
@FindBy(xpath="//input[@id='fieldId_close_date']")
WebElement predicteddate;
@FindBy(xpath="//input[@id='fieldId_actual_close_date']")
WebElement actualdate;
@FindBy(xpath="//*[@id='prospectForm']/table/tbody/tr[1]/td/input[1]")
WebElement save;
	public DealsPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyDealsLabel()
	{
		return dealsLabel.isDisplayed();
		
	}
	public void clickOnNewProduct()
	{
		addNewProduct.click();
	}
public void createNewProduct()
{
	
	productName.sendKeys("Creditcard");
	cost.clear();
	cost.sendKeys("2000");
	retail_value.clear();
	retail_value.sendKeys("3000");
	wholesale.clear();
	wholesale.sendKeys("1500");
	Select pGroup=new Select(product_group);
	pGroup.selectByVisibleText("Test Deals");
	sku.sendKeys("1234");
	inventoryAmount.clear();
	inventoryAmount.sendKeys("1000");
	proDescription.sendKeys("This is test product");
	saveProduct.click();
}
	public void createNewDeals(String dealsTitle,String companyName,String amount,String commission,String Identifier,String tags, String cDescription,String next_steps)
	{
		String predictdate="14-Jul-2019";
		String actualdate1="14-Jul-2019";
		title.sendKeys(dealsTitle);
		company.sendKeys(companyName);
		primary_Contact.sendKeys("8983290695");
		totalAmount.sendKeys(amount);
		probabilityPer.sendKeys("10");
		commissionPer.sendKeys(commission);
		identifierKey.sendKeys(Identifier);
		tag.sendKeys(tags);
		descriptions.sendKeys(cDescription);
		nextSteps.sendKeys(next_steps);
		Select selectProduct=new Select(product);
		selectProduct.selectByVisibleText("Creditcard");
		quantity.sendKeys("1");
		Select typeOfProduct=new Select(type);
		typeOfProduct.selectByVisibleText("New");
		Select sourceOfProduct=new Select(source);
		sourceOfProduct.selectByVisibleText("Referral");
		Select stageSelect=new Select(stage);
		stageSelect.selectByVisibleText("New Stage");
		DateClass.selectDateByJs(driver, predicteddate, predictdate);
		DateClass.selectDateByJs(driver, actualdate, actualdate1);
		save.submit();
		}
	public String  verifyNewDeals(String dealsName)
	{
		String getDeals = null;
		String dealsname="//td[@class='tabs_header' and contains(text(),'"+dealsName+"')]";
		for(int i=0; i<=dealsname.length();i++)
		{
			getDeals= driver.findElement(By.xpath(dealsname)).getText();
			System.out.println("Added Contact Name :"+getDeals);
		}
		return getDeals;
	}
}
