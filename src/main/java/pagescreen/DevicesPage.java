package pagescreen;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.BaseDriver;
import Base.Library;
import utility.ExcelUtility;

public class DevicesPage extends BaseDriver
{
	Library library;
	public DevicesPage()
	{
		super();
		library = new Library();
	}
	
	public void clickonAdd()
	{
		library.clickonwebelement(object.getProperty("adddevice_id"), "id");
		log.info("Adding device started");
	}
	
	public void selectDeviceType() throws IOException
	{
		String devicetype = (ExcelUtility.readexcel(config.getProperty("devicesdetails"), 0, 1, 0));
		System.out.println(devicetype);
		WebElement dtp= driver.findElement(By.xpath("//a[@id='SkinnedcmbType']"));
		dtp.click();
		driver.findElement(By.xpath("//li[contains(text(),'"+devicetype+"')]")).click();
	}
	public void selectCompany() throws IOException
	{
		String companydata = (ExcelUtility.readexcel(config.getProperty("devicesdetails"), 0, 1, 1));
		//System.out.println(companydata);
		WebElement cmpname= driver.findElement(By.xpath("//a[@id='SkinnedcmbCustomer']"));
		cmpname.click();
		driver.findElement(By.xpath(" //li[contains(text(),'"+companydata+"')]")).click();
	}
	public void enterDeviceName(String dname)
	{
		library.Entertext(object.getProperty("deviceName_xpath"), "xpath", dname);
	}
	public void enterIPAddress(String ipaddr)
	{
		library.Entertext(object.getProperty("deviceipaddress_xpath"), "xpath", ipaddr);
	}
	public void enterDescription(String ddesc)
	{
		library.Entertext(object.getProperty("devicedescription_xpath"), "xpath", ddesc);
	}
	public void enterLocation(String dloc) 
	{
		library.Entertext(object.getProperty("devicelocation_xpath"), "xpath", dloc);
	}
	public void enterCost(int dcost) 
	{
		library.Enternumerictext(object.getProperty("devicecost_xpath"), "xpath", dcost);
	}
	public void enterPurchaseDate(String pdate)
	{
		library.clearTextbox(object.getProperty("devicepurchasedate_xpath"), "xpath");
		library.Entertext(object.getProperty("devicepurchasedate_xpath"), "xpath", pdate);
	}
	public void enterInstalledDate(String idate)
	{
		library.clearTextbox(object.getProperty("deviceinstalleddate_xpath"), "xpath");
		library.Entertext(object.getProperty("deviceinstalleddate_xpath"), "xpath", idate);
	}
	public void enterComments(String pdate)
	{
		library.Entertext(object.getProperty("devicecomments_xpath"), "xpath", pdate);
	}
	public void enterDomain(String dom)
	{
		library.Entertext(object.getProperty("devicedomain_xpath"), "xpath", dom);
	}
	public void enterPort(String dport)
	{
		library.Entertext(object.getProperty("deviceport_xpath"), "xpath", dport);
	}
	public void enterUserName(String dna)
	{
		library.Entertext(object.getProperty("deviceusername_xpath"), "xpath", dna);
	}
	public void enterPassword(String dpwd)
	{
		library.Entertext(object.getProperty("devicepassword_xpath"), "xpath", dpwd);
	}
	
	public void clickOnSubmit()
	{
		library.clickonwebelement(object.getProperty("devicesubmit_xpath"), "xpath");
		log.info("Device add success");
	}
	public void clickOnCancel()
	{
		library.clickonwebelement(object.getProperty("devicecancel_xpath"), "xpath");
		log.info("Device is not added");
	}
	
	
}

