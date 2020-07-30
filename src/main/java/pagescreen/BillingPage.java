package pagescreen;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.BaseDriver;
import Base.Library;
import utility.ExcelUtility;

public class BillingPage extends BaseDriver
{
	Library library;
	public BillingPage()
	{
		super();
		library = new Library();
	}
	public void clickOnAddbilling()
	{
		library.clickonwebelement(object.getProperty("addbillingbutton_xpath"), "xpath");
		log.info("Clciked on Add button");
	}
	
	public void enterDate(String bdate)
	{
		library.clearTextbox(object.getProperty("billdate_id"), "id");
		library.Entertext(object.getProperty("billdate_id"), "id", bdate);
		log.info("date entered");
	}
	public void selectCompanyname() throws IOException
	{
		String companydata = (ExcelUtility.readexcel(config.getProperty("billingtab"), 0, 1, 2));
		//System.out.println(companydata);
		WebElement cmpname= driver.findElement(By.xpath("//a[@id='SkinnedCustomer_ID']"));
		cmpname.click();
		driver.findElement(By.xpath("//li[contains(text(),'"+companydata+"')]")).click();
		log.info("companyname selected");
	}
	public void selectUsername() throws IOException
	{
		String username = (ExcelUtility.readexcel(config.getProperty("billingtab"), 0, 1, 3));
		//System.out.println(username);
		WebElement cmpname= driver.findElement(By.xpath("//a[@id='SkinnedUser_ID']"));
		cmpname.click();
		driver.findElement(By.xpath("//li[contains(text(),'"+username+"')]")).click();
		log.info("Username selected");
	}
	
	public void enterComments(String billcmnts)
	{
		library.Entertext(object.getProperty("billcomments_xpath"), "xpath", billcmnts);
		log.info("Comments Entered");
	}
	public void clickOnSubmit()
	{
		library.clickonwebelement(object.getProperty("billsubmit_xpath"), "xpath");
		log.info("Clicked on Submit");
	}
	public void clickOnCancel()
	{
		library.clickonwebelement(object.getProperty("billcancel_xpath"), "xpath");
		log.info("Clicked on Cancel");
	}
	public void clickonSendNow()
	{
		library.clickonwebelement(object.getProperty("billingsendoutsendsendnow_xpath"), "xpath");
		log.info("Clicked on SendNow");
	}
	public void clickonSendLatter()
	{
		library.clickonwebelement(object.getProperty("billingsendoutsendsendlatter_xpath"), "xpath");
		log.info("Clicked on SendLater");
	}
	public void billsuccessOk()
	{
		library.clickonwebelement(object.getProperty("billsuccessokbtn_css"), "cssSelector");
	}
}
