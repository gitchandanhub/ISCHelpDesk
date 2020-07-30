package pagescreen;

import Base.BaseDriver;
import Base.Library;

public class ContactsPage extends BaseDriver
{
	Library library;
	public ContactsPage() 
	{
		super();
		library = new Library();
	}
	public void clickOnAdd()
	{
		library.clickonwebelement(object.getProperty("contactaddbutton_xpath"), "xpath");
		log.info("Adding contact started");
	}
	
	public void enterFullName(String fname)
	{
		library.Entertext(object.getProperty("contactfullname_xpath"), "xpath", fname);
	}
	public void enterBusinessName(String bname)
	{
		library.Entertext(object.getProperty("contactbusinessname_id"), "id", bname);
	}
	public void enterJobTitle(String jtitle)
	{
		library.Entertext(object.getProperty("contactjobtitle_id"), "id", jtitle);
	}
	public void enterEmail(String em)
	{
		library.Entertext(object.getProperty("contactemail_id"), "id", em);
	}
	public void enterDisplayas(String disp)
	{
		library.Entertext(object.getProperty("contcatdisplayas_id"), "id", disp);
	}
	public void enterWebPageaddress(String wpadd)
	{
		library.Entertext(object.getProperty("contctwebpageaddress_id"), "id", wpadd);
	}
	public void enterIMAddress(String imadd)
	{
		library.Entertext(object.getProperty("contactimaddress_id"), "id", imadd);
	}
	public void enterBusinessnum(int bnum)
	{
		library.Enternumerictext(object.getProperty("contactbusinessnum_id"), "id", bnum);
	}
	public void enterHomenum(int hnum)
	{
		library.Enternumerictext(object.getProperty("contacthomenum_id"), "id", hnum);
	}
	public void enterFaxnum(int fnum)
	{
		library.Enternumerictext(object.getProperty("contactbusinessfaxnum_id"), "id", fnum);
	}
	public void enterMobilenum(int mnum)
	{
		library.Enternumerictext(object.getProperty("contactmobilenum_id"), "id", mnum);
	}
	public void enterBusinessAddress(String badd)
	{
		library.Entertext(object.getProperty("contactbusinessaddress_id"), "id", badd);
	}
	public void enterNotes(String note)
	{
		library.Entertext(object.getProperty("contactnotes_id"), "id", note);
	}
	public void clickOnSubmit()
	{
		library.clickonwebelement(object.getProperty("submit_id"), "id");
	}
	public void clickOnCancel()
	{
		library.clickonwebelement(object.getProperty("cancel_id"), "id");
	}
	
}
