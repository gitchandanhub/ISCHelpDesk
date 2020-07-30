package pagescreen;

import Base.BaseDriver;
import Base.Library;

public class PasswordsPage extends BaseDriver
{
	Library library;
	public PasswordsPage()
	{
		super();
		library = new Library();
	}
	public void createPasswords()
	{
		library.clickonwebelement(object.getProperty("addbtn_xpath"), "xpath");
	}
	
	public void enterUserName(String puname)
	{
		library.Entertext(object.getProperty("username_xpath"), "xpath", puname);
	}
	public void enterPassword(String ppass)
	{
		library.Entertext(object.getProperty("password_xpath"), "xpath", ppass);
	}
	public void enterDescription(String pdesc)
	{
		library.Entertext(object.getProperty("description_xpath"), "xpath", pdesc);
	}
	public void enterReference(String pref)
	{
		library.Entertext(object.getProperty("reference_xpath"), "xpath", pref);
	}
	public void checkPrivate()
	{
		library.clickonwebelement(object.getProperty("privatecheckbx_xpath"), "xpath");
	}
	
	public void clikOnSubmit()
	{
		library.clickonwebelement(object.getProperty("passsubmit_xpath"), "xpath");
	}
	public void clikOnCancel()
	{
		library.clickonwebelement(object.getProperty("passcancel_xpath"), "xpath");
	}
}
