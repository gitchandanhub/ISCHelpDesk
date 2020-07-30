package pagescreen;

import Base.BaseDriver;
import Base.Library;

public class ForgotPasswordPage extends BaseDriver
{
	Library library;
	public ForgotPasswordPage()
	{
		super();
	library  = new Library();	
	}
	
	public void enterUserName(String un)
	{
		library.clearTextbox(object.getProperty("fusername_id"), "id");
		library.Entertext(object.getProperty("fusername_id"), "id", un);
		log.info("UserName Entered");
	}
	public void enterEmailAddress(String email)
	{
		library.clearTextbox(object.getProperty("femail_id"), "id");
		library.Entertext(object.getProperty("femail_id"), "id", email);
		log.info("Email Address Entered");
	}
	public void clickonSubmit()
	{
		library.clickonwebelement(object.getProperty("fsubmitbutton_id"), "id");
		log.info("Clicked on Submit button");
		
	}
	public void clickonClear()
	{
		library.clickonwebelement(object.getProperty("fclearbutton_id"), "id");
		log.info("Clicked on clear button");
		
	}
	public void clickonLogin()
	{
		library.clickonwebelement(object.getProperty("floginbutton_id"), "id");
		log.info("Clicked on Login button");
		
	}
	
}

