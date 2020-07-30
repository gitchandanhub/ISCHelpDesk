package EEExecution;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.BaseDriver;
import pagescreen.BillingPage;
import pagescreen.ContactsPage;
import pagescreen.DashboardPage;
import pagescreen.DevicesPage;
import pagescreen.Loginpage;
import pagescreen.NewEvent;
import pagescreen.NewTicket;
import pagescreen.PasswordsPage;
import pagescreen.PurchasePage;
import pagescreen.ReportsPage;
import pagescreen.SystemPage;
import pagescreen.TicketsPage;
import utility.ExcelUtility;
@Listeners(Listen.TestNG_Listeners.class)
public class ExecuteCases  extends BaseDriver
   {
	Loginpage lpobj;  
	public ExecuteCases()
	{
		super();
		lpobj =  new Loginpage();  
		
	}
	@Test(priority = 0)
	public void ValidateLogin() throws InterruptedException
	{
		lpobj.EnterUsername(config.getProperty("username"));
		lpobj.EnterPassword(config.getProperty("password"));
		lpobj.clickloginbutton();
		Thread.sleep(1000);
		try {
		if(object.getProperty("Question_id").contains("ddlQuestion"))
		{
			lpobj.selectquuestion(2);
			Thread.sleep(1000);
			lpobj.EnterAnswer("1");
			lpobj.clicksubmit();
		}	
		}
		catch(Exception e)
		{
			System.out.println("User LoggedIn without Security Answer");
		}
		System.out.println("UserLoggedIn as : "+config.getProperty("username"));
		Thread.sleep(3000);
	}

	//******************************************* To Create newEvent***************************************
	@Test(priority = 1)
	public void newEvent() throws InterruptedException, IOException
	{
		System.out.println("Event Creation start from Dashboard");
		DashboardPage dbpobj = new DashboardPage();
		NewEvent event = new NewEvent();
		
		dbpobj.clickonNewEvent();
		Thread.sleep(1000);
		List <WebElement> allframes = driver.findElements(By.tagName("iframe"));
		//allframes.get(0);
		
		driver.switchTo().frame(allframes.get(0));
		Thread.sleep(1000);
		
		event.enterSubject(ExcelUtility.readexcel(config.getProperty("neweventsetup"), 0, 1, 0));
		
		event.enterDescription(ExcelUtility.readexcel(config.getProperty("neweventsetup"), 0, 1, 1));
		
		event.selectCompany();
		
		event.selectAssignAdmin();
		event.enterLocation(ExcelUtility.readexcel(config.getProperty("neweventsetup"), 0, 1, 4));
		
		event.enterScheduleDate(ExcelUtility.getATdata(config.getProperty("neweventsetup"), 0, 1, 5));
		
		event.enterScheduleTime(ExcelUtility.getATdata(config.getProperty("neweventsetup"), 0, 1, 6));
		
		event.enterEndDate(ExcelUtility.getATdata(config.getProperty("neweventsetup"), 0, 1, 7));
		
		event.enterScheduleTime(ExcelUtility.getATdata(config.getProperty("neweventsetup"), 0, 1, 8));
		
		event.clickSave();
		
		driver.switchTo().defaultContent();
        Thread.sleep(2000);
		WebElement ok = driver.findElement(By.xpath("//*[starts-with(@id, 'alert')]/div/div[2]/a/span/span"));
        driver.switchTo().activeElement();
        Thread.sleep(1000);
        ok.click();
	}
	
	//**************************************To create New Tickect***********************************************
	@Test(priority = 2)
	public void newTicket() throws InterruptedException, IOException
	{
		System.out.println("new Event creation started from DashBoard");
		DashboardPage dp = new DashboardPage();
		NewTicket ticket = new NewTicket();
		dp.clickonNewServiceTicket();
		Thread.sleep(2000);
		
		List <WebElement> tickframe = driver.findElements(By.tagName("iframe"));
		
		driver.switchTo().frame(tickframe.get(0));
		Thread.sleep(2000);
		
		ticket.enterMessage(ExcelUtility.readexcel(config.getProperty("serviceticket"), 0, 1, 0));
		
		ticket.enterTechnicalNotes(ExcelUtility.readexcel(config.getProperty("serviceticket"), 0, 1, 1));
		
		Thread.sleep(1000);
		ticket.selectCompany();
		
		ticket.selectUser();
		
		ticket.selectServiceType();
		
		ticket.selectPriority();
		
		String ticketno = driver.findElement(By.xpath("//input[@id='Ticket_Number']")).getAttribute("value");
		System.out.println("Ticket No : "+ticketno);
		
		ticket.clickonSubmit();
		Thread.sleep(3000);

		driver.switchTo().defaultContent();
        Thread.sleep(1000);
		WebElement ok = driver.findElement(By.xpath("//*[starts-with(@id, 'alert')]/div/div[2]/a/span/span"));
        driver.switchTo().activeElement();
        Thread.sleep(1000);
        ok.click();		
	}
	
	//*********************************Creating event from scheduling tab************************//
	
	@Test(priority = 3)
	public void scheduling() throws InterruptedException, IOException
	{
		System.out.println("New Event creation started from Scheduling");
		DashboardPage sdpobj = new DashboardPage();
		NewEvent nevt = new NewEvent();
		sdpobj.clickonScheduling();
		
		Thread.sleep(3000);
		
		WebElement elementlocator = driver.findElement(By.xpath("//div[contains(text(),'14')]"));
		
		Actions action = new Actions(driver);
		action.contextClick(elementlocator).perform();
		Thread.sleep(3000);

		List <WebElement> evtframe = driver.findElements(By.tagName("iframe"));
		
		driver.switchTo().frame(evtframe.get(0));
		Thread.sleep(2000);
		
		nevt.enterSubject(ExcelUtility.readexcel(config.getProperty("neweventsetup"), 0, 2, 0));
		
		nevt.enterDescription(ExcelUtility.readexcel(config.getProperty("neweventsetup"), 0, 2, 1));
		
		nevt.selectCompany();
		
		nevt.selectAssignAdmin();
		
		nevt.enterLocation(ExcelUtility.readexcel(config.getProperty("neweventsetup"), 0, 2, 4));
		
		nevt.enterScheduleDate(ExcelUtility.getATdata(config.getProperty("neweventsetup"), 0, 2, 5));
		
		nevt.enterScheduleTime(ExcelUtility.getATdata(config.getProperty("neweventsetup"), 0, 2, 6));
		
		nevt.enterEndDate(ExcelUtility.getATdata(config.getProperty("neweventsetup"), 0, 2, 7));
		
		nevt.enterScheduleTime(ExcelUtility.getATdata(config.getProperty("neweventsetup"), 0, 2, 8));
		
		nevt.clickSave();
		
		driver.switchTo().defaultContent();
        Thread.sleep(1000);
		WebElement ok = driver.findElement(By.xpath("//*[starts-with(@id, 'alert')]/div/div[2]/a/span/span"));
        driver.switchTo().activeElement();
        Thread.sleep(1000);
        ok.click();
		
	}
	
	@Test(priority = 4)
	public void createTicketFromTickettab() throws InterruptedException, IOException 
	{
		System.out.println("New Ticket ceating from Ticket Tab");
		DashboardPage tdpobj = new DashboardPage();
		tdpobj.clickonTickects();
		
		TicketsPage tpobj = new TicketsPage();
		tpobj.clickonaddbtntkt();
		NewTicket tntobj = new NewTicket();
		Thread.sleep(2000);
		
		List <WebElement> newtickframe = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(newtickframe.get(0));
		Thread.sleep(2000);
		
		
		tntobj.enterMessage(ExcelUtility.readexcel(config.getProperty("serviceticket"), 0, 2, 0));
		
		tntobj.enterTechnicalNotes(ExcelUtility.readexcel(config.getProperty("serviceticket"), 0, 2, 1));
		
		tntobj.selectCompany();
		
		tntobj.selectUser();
		
		tntobj.selectServiceType();
		
		tntobj.selectPriority();
		
		String ticketno = driver.findElement(By.xpath("//input[@id='Ticket_Number']")).getAttribute("value");
		System.out.println("Ticket No : "+ticketno);
		
		tntobj.clickonSubmit();
		Thread.sleep(3000);

		
		driver.switchTo().defaultContent();
        Thread.sleep(1000);
		WebElement ok = driver.findElement(By.xpath("//*[starts-with(@id, 'alert')]/div/div[2]/a/span/span"));
        driver.switchTo().activeElement();
        Thread.sleep(1000);
        ok.click();
	}
	
	@Test(priority = 5)
	public void createBilling() throws InterruptedException, IOException
	{
		System.out.println("Billing started");
		DashboardPage bdbobj = new DashboardPage();
		bdbobj.clickonBilling();
		Thread.sleep(1000);
		
		BillingPage bpobj = new BillingPage();
		bpobj.clickOnAddbilling();
		Thread.sleep(1000);
		
		//*****************TO Switch Into Frame******************
		List <WebElement> contframe = driver.findElements(By.tagName("iframe"));	
		driver.switchTo().frame(contframe.get(0));
		Thread.sleep(2000);
		
		bpobj.enterDate(ExcelUtility.getATdata(config.getProperty("billingtab"), 0, 1, 1));
		bpobj.selectCompanyname();
		bpobj.selectUsername();
		bpobj.enterComments(ExcelUtility.readexcel(config.getProperty("billingtab"), 0, 1, 4));
		bpobj.clickOnSubmit();
		Thread.sleep(2000);
		bpobj.clickonSendNow();
		System.out.println("Billing created for SendNow");
		Thread.sleep(3000);
		
		String billno = driver.findElement(By.xpath("//input[@id='Billing_Number']")).getAttribute("value");
		System.out.println("Bill No : "+billno);
		
//		bpobj.clickonSendLatter();
//		System.out.println("Billing created for SendNow");
		
		driver.switchTo().defaultContent();
        Thread.sleep(1000);
		WebElement ok = driver.findElement(By.xpath("//*[starts-with(@id, 'alert')]/div/div[2]/a/span/span"));
        driver.switchTo().activeElement();
        Thread.sleep(1000);
        ok.click();
		
	}
	
	
	@Test(priority = 6)
	public void addDevices() throws IOException, InterruptedException 
	{
		System.out.println("Device adding started for: ");
		DashboardPage ddpobj = new DashboardPage();
		ddpobj.clickonDivices();
		
		DevicesPage dpobj = new DevicesPage();
		dpobj.clickonAdd();
		//*****************TO Switch Into Frame******************
				List <WebElement> contframe = driver.findElements(By.tagName("iframe"));	
				driver.switchTo().frame(contframe.get(0));
				Thread.sleep(2000);
		
		dpobj.selectDeviceType();
		dpobj.selectCompany();
		dpobj.enterDeviceName(ExcelUtility.readexcel(config.getProperty("devicesdetails"), 0, 1, 2));
		dpobj.enterIPAddress(ExcelUtility.getATdata(config.getProperty("devicesdetails"), 0, 1, 3));
		dpobj.enterDescription(ExcelUtility.readexcel(config.getProperty("devicesdetails"), 0, 1, 4));
		dpobj.enterLocation(ExcelUtility.readexcel(config.getProperty("devicesdetails"), 0, 1, 5));
		dpobj.enterCost(ExcelUtility.numreadexcel(config.getProperty("devicesdetails"), 0, 1, 6));
		dpobj.enterPurchaseDate(ExcelUtility.getATdata(config.getProperty("devicesdetails"), 0, 1, 7));
		dpobj.enterInstalledDate(ExcelUtility.getATdata(config.getProperty("devicesdetails"), 0, 1, 8));
		dpobj.enterComments(ExcelUtility.readexcel(config.getProperty("devicesdetails"), 0, 1, 9));
		dpobj.enterDomain(ExcelUtility.readexcel(config.getProperty("devicesdetails"), 0, 1, 10));
		dpobj.enterPort(ExcelUtility.readexcel(config.getProperty("devicesdetails"), 0, 1, 11));
		dpobj.enterUserName(ExcelUtility.readexcel(config.getProperty("devicesdetails"), 0, 1, 12));
		dpobj.enterPassword(ExcelUtility.readexcel(config.getProperty("devicesdetails"), 0, 1, 13));
		
		dpobj.clickOnSubmit();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		
		ddpobj.clickonDashBoard();
		Thread.sleep(2000);
	}
	@Test(priority = 7)
	public void createPassword() throws InterruptedException, IOException
	{
		System.out.println("Creating user passwords started");
		DashboardPage pdpobj = new DashboardPage();
		PasswordsPage pobj = new PasswordsPage();
		
		pdpobj.clickonPasswords();
		Thread.sleep(1000);
		
		pobj.createPasswords();
		
		
		//*****************TO Switch Into Frame******************
				List <WebElement> contframe = driver.findElements(By.tagName("iframe"));	
				driver.switchTo().frame(contframe.get(0));
				Thread.sleep(2000);		
				
				//*********************Selecting company name*****************
				WebElement cpn = driver.findElement(By.xpath("//input[@id='cmbCompany_Input']"));
				cpn.click();
				Thread.sleep(1000);
				String passcompnam = ExcelUtility.readexcel(config.getProperty("passwordstab"), 0, 1, 0);
				driver.findElement(By.xpath("//li[contains(text(),'"+passcompnam+"')]")).click();
				
				//************************Entering Details from Excel**********************
				
				pobj.enterUserName(ExcelUtility.readexcel(config.getProperty("passwordstab"), 0, 1, 1));
				
				pobj.enterPassword(ExcelUtility.readexcel(config.getProperty("passwordstab"), 0, 1, 2));
				
				pobj.enterDescription(ExcelUtility.readexcel(config.getProperty("passwordstab"), 0, 1, 3));
				
				pobj.enterReference(ExcelUtility.readexcel(config.getProperty("passwordstab"), 0, 1, 4));
				
				pobj.clikOnSubmit();
				Thread.sleep(2000);
	}

	
	@Test(priority = 8)
	public void createPurchaseOrder() throws InterruptedException, IOException
	{
		System.out.println("Purchase Order started");
		DashboardPage podpobj = new DashboardPage();
		podpobj.clickonPurchases();
		Thread.sleep(1000);
		
		PurchasePage ppojj = new PurchasePage();
		ppojj.clickOnAddbtn();
		Thread.sleep(1000);
		
	//*****************TO Switch Into Frame******************
				List <WebElement> contframe = driver.findElements(By.tagName("iframe"));	
				driver.switchTo().frame(contframe.get(0));
				Thread.sleep(2000);	
				
		ppojj.enterDate(ExcelUtility.getATdata(config.getProperty("purchaseorders"), 0, 1, 1));
		
		ppojj.selectCompanyname();
		ppojj.selectUsername();
		
		ppojj.enterReferenceNum(ExcelUtility.numreadexcel(config.getProperty("purchaseorders"), 0, 1, 4));
		
		ppojj.enterDateReq(ExcelUtility.getATdata(config.getProperty("purchaseorders"), 0, 1, 5));
		ppojj.enterComment(ExcelUtility.readexcel(config.getProperty("purchaseorders"), 0, 1, 6));
		ppojj.enterQty1(ExcelUtility.numreadexcel(config.getProperty("purchaseorders"), 0, 1, 7));
		ppojj.enter1Description(ExcelUtility.readexcel(config.getProperty("purchaseorders"), 0, 1, 8));
		ppojj.enterUnitPrice1(ExcelUtility.numreadexcel(config.getProperty("purchaseorders"), 0, 1, 9));
		ppojj.enterQty2(ExcelUtility.numreadexcel(config.getProperty("purchaseorders"), 0, 2, 7));
		ppojj.enter2Description(ExcelUtility.readexcel(config.getProperty("purchaseorders"), 0, 2, 8));
		ppojj.enterUnitPrice2(ExcelUtility.numreadexcel(config.getProperty("purchaseorders"), 0, 2, 9));
		ppojj.enterApproveDate(ExcelUtility.getATdata(config.getProperty("purchaseorders"), 0, 1, 10));
		ppojj.enterApprover(ExcelUtility.readexcel(config.getProperty("purchaseorders"), 0, 1, 11));
		ppojj.clickOnSubmit();
		
		String pono = driver.findElement(By.xpath("//input[@id='txtPurchaseOrderNumber']")).getAttribute("value");
		System.out.println("Purchase Order No : "+pono);
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		
		podpobj.clickonDashBoard();
		Thread.sleep(2000);
	}
	
	//*************************************To Add Contacts***********************************************

	@Test(priority = 9)
	public void addNewcontact() throws InterruptedException, IOException
	{
		System.out.println("Started creating new contact");
		DashboardPage cdpobj = new DashboardPage();
		ContactsPage cpobj = new ContactsPage();
		
		cdpobj.clickonContacts();
		Thread.sleep(1000);
		
		cpobj.clickOnAdd();
		Thread.sleep(1000);
		
		//*****************TO Switch Into Frame******************
		List <WebElement> contframe = driver.findElements(By.tagName("iframe"));	
		driver.switchTo().frame(contframe.get(0));
		Thread.sleep(2000);		
		
		//*********************Selecting company name*****************
		WebElement cpn = driver.findElement(By.xpath("//a[@id='SkinnedddlCompany']"));
		cpn.click();
		Thread.sleep(1000);
		String compnam = ExcelUtility.readexcel(config.getProperty("contactstab"), 0, 1, 0);
		//System.out.println(compnam);
		driver.findElement(By.xpath("//li[contains(text(),'"+compnam+"')]")).click();
		
		//************************Entering Details from Excel**********************
		cpobj.enterFullName(ExcelUtility.readexcel(config.getProperty("contactstab"), 0, 1, 1));
		
		cpobj.enterBusinessName(ExcelUtility.readexcel(config.getProperty("contactstab"), 0, 1, 2));
		
		cpobj.enterJobTitle(ExcelUtility.readexcel(config.getProperty("contactstab"), 0, 1, 3));
		
		cpobj.enterEmail(ExcelUtility.readexcel(config.getProperty("contactstab"), 0, 1, 4));
		
		cpobj.enterDisplayas(ExcelUtility.readexcel(config.getProperty("contactstab"), 0, 1, 5));
		
		cpobj.enterWebPageaddress(ExcelUtility.readexcel(config.getProperty("contactstab"), 0, 1, 6));
		
		cpobj.enterIMAddress(ExcelUtility.readexcel(config.getProperty("contactstab"), 0, 1, 7));
		
		cpobj.enterBusinessnum(ExcelUtility.numreadexcel(config.getProperty("contactstab"), 0, 1, 8));
		
		cpobj.enterHomenum(ExcelUtility.numreadexcel(config.getProperty("contactstab"), 0, 1, 9));
		
		cpobj.enterFaxnum(ExcelUtility.numreadexcel(config.getProperty("contactstab"), 0, 1, 10));
		
		cpobj.enterMobilenum(ExcelUtility.numreadexcel(config.getProperty("contactstab"), 0, 1, 11));
		
		cpobj.enterBusinessAddress(ExcelUtility.readexcel(config.getProperty("contactstab"), 0, 1, 12));
		
		cpobj.enterNotes(ExcelUtility.readexcel(config.getProperty("contactstab"), 0, 1, 13));
		
		cpobj.clickOnSubmit();
		
		driver.switchTo().defaultContent();
        Thread.sleep(1000);
		WebElement ok = driver.findElement(By.xpath("//*[starts-with(@id, 'alert')]/div/div[2]/a/span/span"));
        driver.switchTo().activeElement();
        Thread.sleep(1000);
        ok.click();	
		Thread.sleep(2000);
		
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		cdpobj.clickonDashBoard();
		Thread.sleep(2000);
		
	}
	
	//*************************************To Generate Reports***********************************************//
	
	@Test(priority = 10)
	public void generateReport() throws InterruptedException, IOException
	{
		System.out.println("Report creating started");
		DashboardPage rdpobj = new DashboardPage();
		ReportsPage report = new ReportsPage();
		
		rdpobj.clickonReports();
		Thread.sleep(2000);
		
		String reportsdata = ExcelUtility.readexcel(config.getProperty("reportstab"), 0, 1, 0);
		//System.out.println(reportsdata);
		
		WebElement rptfor = driver.findElement(By.xpath("//a[@id='Skinnedctl00_MainContent_cmbReportfor']/span"));
		rptfor.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[contains(text(),'"+reportsdata+"')]")).click();
		
		String cpmpanydata = ExcelUtility.readexcel(config.getProperty("reportstab"), 0, 1, 1);
		//System.out.println(cpmpanydata);
		
		WebElement compnm = driver.findElement(By.xpath("//a[@id='Skinnedctl00_MainContent_cmbCompanyReport']/span"));
		compnm.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='rfdSelectBox rfdSelectBox_Office2007']//li[contains(text(),'"+cpmpanydata+"')]")).click();
		
		report.clickOnReportAddbtn();
		Thread.sleep(2000);
		
	}
	
  
   @Test(priority = 11)
   public void executeSystem() throws InterruptedException, IOException
   {
	   System.out.println("Creating system requirements started");
	   SystemPage spobj = new SystemPage();
	   DashboardPage sdpobj = new DashboardPage();
	   sdpobj.clickonSystems();
	   Thread.sleep(2000);
	   //********************************Company*****************************************//
	   System.out.println("company Details");
	   spobj.clickoncompAddbtn();
	   Thread.sleep(3000);
	   List <WebElement> compframe = driver.findElements(By.tagName("iframe"));	
	   driver.switchTo().frame(compframe.get(0));
	   Thread.sleep(3000);
	   //spobj.enterCustmerID(ExcelUtility.numreadexcel(config.getProperty("systemtabs"), 0, 1, 0));
	   spobj.enterCustmername(ExcelUtility.readexcel(config.getProperty("systemtabs"), 0, 1, 1));
	   spobj.enterCustmerContact(ExcelUtility.numreadexcel(config.getProperty("systemtabs"), 0, 1, 2));
	   spobj.clickoncompSubmitbtn();
	   //spobj.clickoncompCancelbtn();
	   
	   //********************************Users*****************************************//
	   System.out.println("User Details");
	   Thread.sleep(3000);
	   spobj.clickonUsers();
	   Thread.sleep(3000);
	   spobj.clickonuserAddbtn();
	   Thread.sleep(3000);
	   List <WebElement> usersframe = driver.findElements(By.tagName("iframe"));	
	   driver.switchTo().frame(usersframe.get(0));
	   Thread.sleep(2000);	
	   spobj.selectCustmername();
	   spobj.enterFirstname(ExcelUtility.readexcel(config.getProperty("systemtabs"), 1, 1, 1));
	   spobj.enterUsername(ExcelUtility.readexcel(config.getProperty("systemtabs"), 1, 1, 4));
	   spobj.enterEmailaddress(ExcelUtility.readexcel(config.getProperty("systemtabs"), 1, 1, 9));
	   spobj.enterPassword(ExcelUtility.readexcel(config.getProperty("systemtabs"), 1, 1, 10));
	   spobj.clickonsubmitUser();
	   //spobj.clickonCancelUser();
	   try {
	   driver.switchTo().defaultContent();
       Thread.sleep(1000);
		WebElement ok = driver.findElement(By.xpath("//*[starts-with(@id, 'alert')]/div/div[2]/a/span/span"));
       driver.switchTo().activeElement();
       Thread.sleep(1000);
       ok.click();
	   }
	   catch(Exception e)
	   {
		   System.out.println("User is already exists  ");
	   }
	   
	   //********************************Service Type*****************************************//
	   System.out.println("Service Type Details");
	   Thread.sleep(2000);
	   spobj.clickonServiceType();
	   Thread.sleep(3000);
	   spobj.clickonaddservicebtn();
	   Thread.sleep(3000);
	   List <WebElement> serviceframe = driver.findElements(By.tagName("iframe"));	
	   driver.switchTo().frame(serviceframe.get(0));
	   Thread.sleep(2000);
	   spobj.enterServiceType(ExcelUtility.readexcel(config.getProperty("systemtabs"), 2, 1, 0));
	   spobj.enterServicedescription(ExcelUtility.readexcel(config.getProperty("systemtabs"), 2, 1, 1));
	   spobj.enterContracterrate(ExcelUtility.numreadexcel(config.getProperty("systemtabs"), 2, 1, 2));
	   spobj.enterNonContracterrate(ExcelUtility.numreadexcel(config.getProperty("systemtabs"), 2, 1, 2));
	   spobj.clickonsubmitServiceType();
	   
	   //********************************Software Type*****************************************//
	   System.out.println("Software Type Details");
	   Thread.sleep(2000);
	   spobj.clickonSoftwareType();
	   Thread.sleep(3000);
	   spobj.clickonsofttypeAddbtn();
	   Thread.sleep(3000);
	   List <WebElement> softwareframe = driver.findElements(By.tagName("iframe"));	
	   driver.switchTo().frame(softwareframe.get(0));
	   Thread.sleep(2000);
	   spobj.enterSofteType(ExcelUtility.readexcel(config.getProperty("systemtabs"), 3, 1, 0));
	   spobj.enterSoftdescription(ExcelUtility.readexcel(config.getProperty("systemtabs"), 3, 1, 1));
	   spobj.clickonsubmitSoftType();
	   
	   //********************************Hardware Type*****************************************//
	   System.out.println("Hardware Type Details");
	   Thread.sleep(2000);
	   spobj.clickonHardType();
	   Thread.sleep(3000);
	   spobj.clickonHardtypeAddbtn();
	   Thread.sleep(3000);
	   List <WebElement> hardwareframe = driver.findElements(By.tagName("iframe"));	
	   driver.switchTo().frame(hardwareframe.get(0));
	   Thread.sleep(2000);
	   spobj.enterHardType(ExcelUtility.readexcel(config.getProperty("systemtabs"), 4, 1, 0));
	   spobj.enterHarddescription(ExcelUtility.readexcel(config.getProperty("systemtabs"), 4, 1, 1));
	   spobj.clickonsubmitHardType();
	   
	   //********************************Priority Type*****************************************//
	   System.out.println("Priority Details");
	   Thread.sleep(2000);
	   spobj.clickonPriorityType();
	   Thread.sleep(3000);
	   spobj.clickonPrtyTypeAddbtn();
	   Thread.sleep(3000);
	   List <WebElement> priorityframe = driver.findElements(By.tagName("iframe"));	
	   driver.switchTo().frame(priorityframe.get(0));
	   Thread.sleep(2000);
	   spobj.enterPrtyType(ExcelUtility.readexcel(config.getProperty("systemtabs"), 5, 1, 0));
	   spobj.enterPrtydescription(ExcelUtility.readexcel(config.getProperty("systemtabs"), 5, 1, 1));
	   spobj.clickonsubmitPrtyType();
	   
	   driver.switchTo().defaultContent();
		Thread.sleep(2000);
		
		sdpobj.clickonDashBoard();
		Thread.sleep(2000);
   }
   
   @Test(priority = 13)
   public void logout()
   {
	   WebElement ele = driver.findElement(By.xpath("//a[@id='ctl00_Logout']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		System.out.println("Logout successfully");
   }
  
   }
