package pagescreen;

import Base.BaseDriver;
import Base.Library;

public class ReportsPage extends BaseDriver
{
	Library library;
	public ReportsPage()
	{
		super();
		library = new Library();
	}
	
	public void clickOnReportAddbtn()
	{
		library.clickonwebelement(object.getProperty("reportbtn_id"), "id");
		log.info("Reports ");
	}
}
