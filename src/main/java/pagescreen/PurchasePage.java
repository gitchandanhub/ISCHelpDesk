package pagescreen;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.BaseDriver;
import Base.Library;
import utility.ExcelUtility;

public class PurchasePage extends BaseDriver
{
	Library library;
	public PurchasePage()
	{
		super();
		library = new Library();
	}
	public void clickOnAddbtn()
	{
		library.clickonwebelement(object.getProperty("purchaseaddbtn"), "xpath");
	}
	public void enterDate(String dt)
	{
		library.clearTextbox(object.getProperty("purchasedate_xpath"), "xpath");
		library.Entertext(object.getProperty("purchasedate_xpath"), "xpath", dt);
	}
	public void selectCompanyname() throws IOException
	{
		String companydata = (ExcelUtility.readexcel(config.getProperty("purchaseorders"), 0, 1, 2));
		//System.out.println(companydata);
		WebElement cmpname= driver.findElement(By.xpath("//a[@id='SkinnedddlCompanyName']"));
		cmpname.click();
		driver.findElement(By.xpath("//li[contains(text(),'"+companydata+"')]")).click();
	}
	public void selectUsername() throws IOException
	{
		String username = (ExcelUtility.readexcel(config.getProperty("purchaseorders"), 0, 1, 3));
		//System.out.println(username);
		WebElement cmpname= driver.findElement(By.xpath("//a[@id='SkinnedddlUserName']"));
		cmpname.click();
		driver.findElement(By.xpath("//li[contains(text(),'"+username+"')]")).click();
	}
	public void enterReferenceNum(int refnum)
	{
		library.Enternumerictext(object.getProperty("purchasereference_id"), "id", refnum);
	}
	public void enterDateReq(String dtreq)
	{
		library.clearTextbox(object.getProperty("purchasedatereq_xpath"), "xpath");
		library.Entertext(object.getProperty("purchasedatereq_xpath"), "xpath", dtreq);
	}
	
	public void enterComment(String cmnts)
	{
		library.Entertext(object.getProperty("purchasecomments_xpath"), "xpath", cmnts);
	}
	public void enterQty1(int qty1)
	{
		library.Enternumerictext(object.getProperty("1qty_id"), "id", qty1);
	}
	public void enter1Description(String desc1)
	{
		library.Entertext(object.getProperty("1description_id"), "id", desc1);
	}
	public void enterUnitPrice1(int up1)
	{
		library.Enternumerictext(object.getProperty("1unitprice_id"), "id", up1);
	}
	public void enterQty2(int qty2)
	{
		library.Enternumerictext(object.getProperty("2qty_id"), "id", qty2);
	}
	public void enter2Description(String desc2)
	{
		library.Entertext(object.getProperty("2description_id"), "id", desc2);
	}
	public void enterUnitPrice2(int up2)
	{
		library.Enternumerictext(object.getProperty("2unitprice_id"), "id", up2);
	}
	public void enterApproveDate(String apdate)
	{
		library.clearTextbox(object.getProperty("purchaseapprovedate_xpath"), "xpath");
		library.Entertext(object.getProperty("purchaseapprovedate_xpath"), "xpath", apdate);
	}
	public void checkApprove()
	{
		library.clickonwebelement(object.getProperty("purchaseapprovecheckbx_xpath"), "xpath");
	}
	public void enterApprover(String appname)
	{
		library.clearTextbox(object.getProperty("approvername_id"), "id");
		library.Entertext(object.getProperty("approvername_id"), "id", appname);
	}
	
	public void clickOnSubmit()
	{
		library.clickonwebelement(object.getProperty("purchasesubbtn_xpath"), "xpath");
	}
	
	public void clickOnCancel()
	{
		library.clickonwebelement(object.getProperty("purchasesubbtn_xpath"), "xpath");
	}
	

}
