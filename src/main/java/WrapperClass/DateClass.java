package WrapperClass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.crm.qa.base.TestBase;

public class DateClass extends TestBase
{
String date="14-Jul-1992";
String dateArr[]=date.split("-");
String day=dateArr[0];
String month=dateArr[1];
String year=dateArr[2];

public static void selectDateByJs(WebDriver driver,WebElement element, String dateVal)
{
	JavascriptExecutor js=((JavascriptExecutor)driver);
	js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);
	
}

}
