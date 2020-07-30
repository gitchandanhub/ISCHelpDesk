package pagescreen;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.BaseDriver;
import Base.Library;
import utility.ExcelUtility;

public class NewTicket extends BaseDriver
{
	Library library;
	public NewTicket()
	{
		super();
		library = new Library();
	}
	
	public void enterMessage(String smsg)
	{
		library.clearTextbox(object.getProperty("servicemessage_id"), "id");
		library.Entertext(object.getProperty("servicemessage_id"), "id", smsg);
		log.info("message entered");
	}
	public void enterTechnicalNotes(String notes) 
	{
		library.clearTextbox(object.getProperty("servicenote_id"), "id");
		library.Entertext(object.getProperty("servicenote_id"), "id", notes);
		log.info("message entered");
	}
	public void clickonSubmit()
	{
		library.clickonwebelement(object.getProperty("servicesubbtn_id"), "id");
		log.info("Clicked on Submit");
	}
	public void clickonCancel()
	{
		library.clickonwebelement(object.getProperty("servicecaclbtn_id"), "id");
		log.info("Clicked on Cancel");
	}
	public void selectUser() throws IOException
	{
		String username = ExcelUtility.readexcel(config.getProperty("serviceticket"), 0, 1, 4);
		//System.out.println(username);
		WebElement und = driver.findElement(By.xpath("//a[@id='SkinnedUser_ID']"));
		und.click();
		driver.findElement(By.xpath("//div[@class='rfdSelectBox rfdSelectBox_Office2007']//li[contains(text(),'"+username+"')]")).click();
		log.info("User Selected");

	}
	public void selectCompany() throws IOException
	{
		String companyname = ExcelUtility.readexcel(config.getProperty("serviceticket"), 0, 1, 3);
		//System.out.println(companyname);
		WebElement cnd = driver.findElement(By.xpath("//a[@id='SkinnedCustomer_ID']"));
		cnd.click();
		driver.findElement(By.xpath("//li[contains(text(),'"+companyname+"')]")).click();
		log.info("Company Selected");
	}
	public void selectServiceType() throws IOException
	{
		String stypedata = ExcelUtility.readexcel(config.getProperty("serviceticket"), 0, 1, 5);
		//System.out.println(stypedata);
		WebElement std = driver.findElement(By.xpath("//a[@id='SkinnedServiceType_ID']"));
		std.click();
		driver.findElement(By.xpath("//li[contains(text(),'"+stypedata+"')]")).click();
		log.info("Service Selected");
	}
	public void selectPriority() throws IOException 
	{
		String prioritydata = ExcelUtility.readexcel(config.getProperty("serviceticket"), 0, 1, 6);
		//System.out.println(prioritydata);
		WebElement prtd = driver.findElement(By.xpath("//a[@id='SkinnedPriority_ID']"));
		prtd.click();
		driver.findElement(By.xpath("//li[contains(text(),'"+prioritydata+"')]")).click();
		log.info("Priority Selected");
	}
	
}
