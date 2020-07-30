package pagescreen;

import Base.BaseDriver;
import Base.Library;

public class TicketsPage extends BaseDriver
{
	Library library;
	public TicketsPage() 
	{
		super();
		library = new Library();
	}
	
	public void clickonaddbtntkt()
	{
		library.clickonwebelement(object.getProperty("addtktbtn_xpath"), "xpath");
	}
}
