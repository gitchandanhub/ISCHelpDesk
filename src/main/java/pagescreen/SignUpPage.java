package pagescreen;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.BaseDriver;
import Base.Library;
import utility.ExcelUtility;

public class SignUpPage  extends BaseDriver
{
	Library library;
	public SignUpPage()
	{
		super();
	library  = new Library();	
	}
	
	public void enterCompany(String cmp)
	{
		library.clearTextbox(object.getProperty("scompanyname_xpath"), "xpath");
		library.Entertext(object.getProperty("scompanyname_xpath"), "xpath", cmp);
		log.info("Companeyname Entered");
	}
	public void enterFirstname(String fname) throws InterruptedException
	{
		library.clickonwebelement(object.getProperty("sfirstname_xpath"), "xpath");
		Thread.sleep(1000);
		library.clearTextbox(object.getProperty("sfirstname_xpath"), "xpath");
		library.Entertext(object.getProperty("sfirstname_xpath"), "xpath", fname);
		log.info("Firstname Entered");
	}
	public void enterLastname(String lname)
	{
		library.clearTextbox(object.getProperty("slastname_xpath"), "xpath");
		library.Entertext(object.getProperty("slastname_xpath"), "xpath", lname);
		log.info("Lasttname Entered");
	}
	public void enterAddress(String addr)
	{
		library.clearTextbox(object.getProperty("saddress_xpath"), "xpath");
		library.Entertext(object.getProperty("saddress_xpath"), "xpath", addr);
		log.info("Address Entered");
	}
	public void enterCity(String ct)
	{
		library.clearTextbox(object.getProperty("scity_xpath"), "xpath");
		library.Entertext(object.getProperty("scity_xpath"), "xpath", ct);
		log.info("City Entered");
	}
	public void selectState() throws IOException
	{
		String state = (ExcelUtility.readexcel(config.getProperty("signupuserdetails"), 0, 1, 5));
		System.out.println(state);
		WebElement states= driver.findElement(By.xpath("//a[@id='SkinnedcmbState']"));
		states.click();
		driver.findElement(By.xpath("//li[contains(text(),'"+state+"')]")).click();
	}
	public void Enterzip(int zipc )
	{
		library.clearTextbox(object.getProperty("szip_xpath"), "xpath");
		library.Enternumerictext(object.getProperty("szip_xpath"), "xpath", zipc);
		log.info("zip Entered");
	}
	public void enterPhone(int phn)
	{
		library.clearTextbox(object.getProperty("sphone_xpath"), "xpath");
		library.Enternumerictext(object.getProperty("sphone_xpath"), "xpath", phn);
		log.info("Phone Number Entered");
	}
	public void enterUsername(String uname)
	{
		library.clearTextbox(object.getProperty("susername_xpath"), "xpath");
		library.Entertext(object.getProperty("susername_xpath"), "xpath", uname);
		log.info("UserName Entered");
	}
	public void enterPassword(String upwd)
	{
		library.clearTextbox(object.getProperty("spassword_xpath"), "xpath");
		library.Entertext(object.getProperty("spassword_xpath"), "xpath", upwd);
		log.info("Password Entered");
	}
	public void enterEmailAddress(String uemail)
	{
		library.clearTextbox(object.getProperty("semailaddress_xpath"), "xpath");
		library.Entertext(object.getProperty("semailaddress_xpath"), "xpath", uemail);
		log.info("User EmailAddress Entered");
	}
	public void selectTndCCheckbox()
	{
		library.selectCheckbox(object.getProperty("stnccheckbox_xpath"), "xpath");
	}
	public void clickSubmitbutton() 
	{
		library.clickonwebelement(object.getProperty("ssubmitbutton_xpath"), "xpath");
		log.info("Submit button Clicked ");
	}
	
	public void clickNewbutton() 
	{
		library.clickonwebelement(object.getProperty("snewbutton_xpath"), "xpath");
		log.info("New button Clicked ");
	}
	public void clickLoginbutton() 
	{
		library.clickonwebelement(object.getProperty("sloginbutton_xpath"), "xpath");
		log.info("Login button Clicked ");
	}
	
}
