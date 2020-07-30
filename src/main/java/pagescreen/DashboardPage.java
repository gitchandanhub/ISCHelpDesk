package pagescreen;

import Base.BaseDriver;
import Base.Library;

public class DashboardPage extends BaseDriver
{
	Library library;
	public DashboardPage()
	{
		super();
		library = new Library();
	}
	public void clickonDashBoard()
	{
		library.clickonwebelement(object.getProperty("dashboardtab_xpath"), "xpath");
		log.info("DashBoard Tab Clicked");
	}
	public void clickonScheduling()
	{
		library.clickonwebelement(object.getProperty("schedulingtab_xpath"), "xpath");
		log.info("Scheduling Tab Clicked");
	}
	public void clickonTickects()
	{
		library.clickonwebelement(object.getProperty("ticketstab_xpath"), "xpath");
		log.info("Tickets Tab Clicked");
	}
	public void clickonBilling()
	{
		library.clickonwebelement(object.getProperty("billingtab_xpath"), "xpath");
		log.info("Billing Tab Clicked");
	}
	public void clickonDivices()
	{
		library.clickonwebelement(object.getProperty("devicestab_id"), "id");
		log.info("Devices Tab Clicked");
	}
	public void clickonPasswords()
	{
		library.clickonwebelement(object.getProperty("passwordstab_xpath"), "xpath");
		log.info("passwords Tab Clicked");
	}
	public void clickonPurchases()
	{
		library.clickonwebelement(object.getProperty("purchasestab_xpath"), "xpath");
		log.info("Purchases Tab Clicked");
	}
	public void clickonContacts()
	{
		library.clickonwebelement(object.getProperty("contactstabs_xpath"), "xpath");
		log.info("Contacts Tab Clicked");
	}
	public void clickonReports()
	{
		library.clickonwebelement(object.getProperty("reportstabs_xpath"), "xpath");
		log.info("Reports Tab Clicked");
	}
	public void clickonSystems()
	{
		library.clickonwebelement(object.getProperty("systemtab_xpath"), "xpath");
		log.info("Systems Tab Clicked");
	}
	public void clickonNewServiceTicket()
	{
		library.clickonwebelement(object.getProperty("newserviceticket"), "id");
		log.info("Clicked on New for Service Ticket");
	}
	public void clickonGoButton()
	{
		library.clickonwebelement(object.getProperty("gobutton_id"), "id");
		log.info("Go Button Clicked");
	}
	public void clickonNewEvent()
	{
		library.clickonwebelement(object.getProperty("neweventsetup"), "id");
		log.info("Clicked on New for Event");
	}
}
