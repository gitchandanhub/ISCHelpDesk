package pagescreen;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.BaseDriver;
import Base.Library;
import utility.ExcelUtility;

public class NewEvent extends BaseDriver
{
	Library library;
	public NewEvent()
	{
		super();
		library = new Library();
	}
	
	public void enterSubject(String sub)
	{	
		//library.clearTextbox(object.getProperty("eventsubject_id"), "id");
		library.Entertext(object.getProperty("eventsubject_xpath"), "xpath", sub);
		log.info("Subject Entered");
		
	}
	
	public void enterDescription(String desc)
	{
		//library.clearTextbox(object.getProperty("eventdescription_id"), "id");
		library.Entertext(object.getProperty("eventdescription_xpath"), "xpath", desc);
		log.info("Description Entered");
	}
	
	public void selectCompany(int cmpny)
	{
		library.selectIndex(object.getProperty("eventcompany_xpath"), "xpath", cmpny);
		log.info("Value "+cmpny+" selected");
	}
	public void selectCompany() throws IOException
	{
		String companydata = (ExcelUtility.readexcel(config.getProperty("neweventsetup"), 0, 1, 2));
		//System.out.println(companydata);
		WebElement cmpname= driver.findElement(By.xpath("//a[@id='SkinnedCustomer_ID']"));
		cmpname.click();
		driver.findElement(By.xpath("//li[contains(text(),'"+companydata+"')]")).click();
	}
	
	public void selectAssignAdmin() throws IOException
	{
		String assignnamedata = (ExcelUtility.readexcel(config.getProperty("neweventsetup"), 0, 1, 3));
		//System.out.println(assignnamedata);
		WebElement username= driver.findElement(By.xpath("//a[@id='SkinnedUser_ID']"));
		username.click();
		driver.findElement(By.xpath("//li[contains(text(),'"+assignnamedata+"')]")).click();
	}
	public void selectAssignAdmin(int adm)
	{
		library.selectIndex(object.getProperty("eventassignadmin_xpath"), "xpath", adm);
		log.info("value "+adm+ " Selected");
	}
	
	public void enterLocation(String loc)
	{
		library.clearTextbox(object.getProperty("eventlocation_xpath"), "xpath");
		library.Entertext(object.getProperty("eventlocation_xpath"), "xpath", loc);
		log.info("Location entered is"+loc);
	}
	public void enterScheduleDate(String sdate)
	{
		library.clearTextbox(object.getProperty("eventscheduledate_xpath"), "xpath");
		library.Entertext(object.getProperty("eventscheduledate_xpath"), "xpath", sdate);
		log.info("Location entered is"+sdate);
	}
	public void enterScheduleTime(String stime)
	{
		library.clearTextbox(object.getProperty("eventscheduletime_xpath"), "xpath");
		library.Entertext(object.getProperty("eventscheduletime_xpath"), "xpath", stime);
		log.info("Location entered is"+stime);
	}
	public void enterEndDate(String edate)
	{
		library.clearTextbox(object.getProperty("eventenddate_xpath"), "xpath");
		library.Entertext(object.getProperty("eventenddate_xpath"), "xpath", edate);
		log.info("Location entered is"+edate);
	}
	public void enterEndTime(String etime)
	{
		library.clearTextbox(object.getProperty("eventendtime_xpath"), "xpath");
		library.Entertext(object.getProperty("eventendtime_xpath"), "xpath", etime);
		log.info("Location entered is"+etime);
	}
	public void clickSave()
	{
		library.clickonwebelement(object.getProperty("eventsave_xpath"), "xpath");
	}
	public void clickCancel()
	{
		library.clickonwebelement(object.getProperty("eventcancel_xpath"), "xpath");
	}
}
