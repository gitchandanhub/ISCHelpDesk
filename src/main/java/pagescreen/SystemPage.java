package pagescreen;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.BaseDriver;
import Base.Library;
import utility.ExcelUtility;

public class SystemPage extends BaseDriver
{
	Library library;
	public SystemPage()
	{
		super();
		library = new Library();
	}
	
	public void  clickonCompany()
	{
		library.clickonwebelement(object.getProperty("syscompany_xpath"), "xpath");
	}
	//********************************Company transactions**********************//
		public void  clickoncompAddbtn()
		{
		library.clickonwebelement(object.getProperty("sysaddcompanybtn_xpath"), "xpath");
		}
			public void enterCustmerID(int cid)
			{
			library.Enternumerictext(object.getProperty("syscompanycustmerid_xpath"), "xpath", cid);
			}
			public void enterCustmername(String cname)
			{
			library.Entertext(object.getProperty("syscompanyname_xpath"), "xpath", cname);
			}
			public void enterCustmerContact(int cnum)
			{
			library.Enternumerictext(object.getProperty("syscompanycontact_xpath"), "xpath", cnum);
			}
			public void  clickoncompSubmitbtn()
			{
			library.clickonwebelement(object.getProperty("syscompanysubmit_xpath"), "xpath");
			}
			public void  clickoncompCancelbtn()
			{
			library.clickonwebelement(object.getProperty("syscompanycancel_xpath"), "xpath");
			}
	

	public void  clickonUsers()
	{
		library.clickonwebelement(object.getProperty("sysusers_xpath"), "xpath");
	}
	//********************************Users transactions**********************//

		public void clickonuserAddbtn()
		{
		library.clickonwebelement(object.getProperty("sysuseraddbtn_xpath"), "xpath");
		}
			public void selectCustmername() throws IOException
			{
			String companydata = (ExcelUtility.readexcel(config.getProperty("systemtabs"), 1, 1, 0));
			//System.out.println(companydata);
			WebElement cmpname= driver.findElement(By.xpath("//a[@id='SkinnedcmbCompany']"));
			cmpname.click();
			driver.findElement(By.xpath("//li[contains(text(),'"+companydata+"')]")).click();	
			}
			public void enterFirstname(String fnm)
			{
			library.Entertext(object.getProperty("sysuserfirstname_xpath"), "xpath", fnm);
			}
			public void enterUsername(String uname)
			{
			library.Entertext(object.getProperty("sysuserusername_xpath"), "xpath", uname);
			}
			public void enterEmailaddress(String email)
			{
			library.Entertext(object.getProperty("sysuseremailaddress_xpath"), "xpath", email);
			}
			public void enterPassword(String pwd)
			{
			library.Entertext(object.getProperty("sysuserpassword_xpath"), "xpath", pwd);
			}
			public void clickonsubmitUser()
			{
			library.clickonwebelement(object.getProperty("sysusersubmitbtn_xpath"), "xpath");
			}
			public void clickonCancelUser()
			{
			library.clickonwebelement(object.getProperty("sysusercancelbtn_xpath"), "xpath");
			}
			   //********************************Service Type*****************************************//
	
	public void  clickonServiceType()
	{
		library.clickonwebelement(object.getProperty("sysservicetype_xpath"), "xpath");
	}
		public void clickonaddservicebtn()
		{
			library.clickonwebelement(object.getProperty("sysstservicetypeaddbtn_xpath"), "xpath");

		}
			public void enterServiceType(String stype) 
			{
				library.Entertext(object.getProperty("sysstservicetype_xpath"), "xpath", stype);
			}
			public void enterServicedescription(String sdesc)
			{
				library.Entertext(object.getProperty("sysstservicetypedescription_xpath"), "xpath", sdesc);

			}
			public void enterContracterrate(int crate)
			{
				library.Enternumerictext(object.getProperty("sysstservicetypeCR_xpath"), "xpath", crate);
			}
			public void enterNonContracterrate(int ncrate)
			{
				library.Enternumerictext(object.getProperty("sysstservicetypeNCR_xpath"), "xpath", ncrate);
			}
			public void clickonsubmitServiceType()
			{
			library.clickonwebelement(object.getProperty("sysstservicetypesubbtn_xpath"), "xpath");
			}
			public void clickoncancelServiceTyper()
			{
			library.clickonwebelement(object.getProperty("sysstservicetypecanclbtn_xpath"), "xpath");
			}
	
	
	   //********************************Software Type*****************************************//

	public void  clickonSoftwareType()
	{
		library.clickonwebelement(object.getProperty("syssoftwaretype_xpath"), "xpath");
	}
	public void clickonsofttypeAddbtn()
	{
	library.clickonwebelement(object.getProperty("syssofttypeaddbtn_xpath"), "xpath");
	}
		public void enterSofteType(String stype) 
		{
			library.Entertext(object.getProperty("syssofttype_xpath"), "xpath", stype);
		}
		public void enterSoftdescription(String sdesc)
		{
			library.Entertext(object.getProperty("syssofttypedesc_xpath"), "xpath", sdesc);
	
		}
		public void clickonsubmitSoftType()
		{
		library.clickonwebelement(object.getProperty("syssofttypesubmitbtn_xpath"), "xpath");
		}
		public void clickoncancelSoftType()
		{
		library.clickonwebelement(object.getProperty("syssofttypecancelbtn_xpath"), "xpath");
		}
		
		   //********************************Hardware Type*****************************************//

		public void  clickonHardType()
		{
			library.clickonwebelement(object.getProperty("syshardwaretype_xpath"), "xpath");
		}
			public void clickonHardtypeAddbtn()
			{
			library.clickonwebelement(object.getProperty("syshardtypeaddbtn_xpath"), "xpath");
			}
				public void enterHardType(String stype) 
				{
					library.Entertext(object.getProperty("syshardtype_xpath"), "xpath", stype);
				}
				public void enterHarddescription(String sdesc)
				{
					library.Entertext(object.getProperty("syshardtypedesc_xpath"), "xpath", sdesc);
			
				}
				public void clickonsubmitHardType()
				{
				library.clickonwebelement(object.getProperty("syshardtypesubmitbtn_xpath"), "xpath");
				}
				public void clickoncancelHardType()
				{
				library.clickonwebelement(object.getProperty("syshardtypecancelbtn_xpath"), "xpath");
				}
		
		   //********************************Priority Type*****************************************//

	public void  clickonPriorityType()
	{
		library.clickonwebelement(object.getProperty("syspriority_xpath"), "xpath");
	}
		public void clickonPrtyTypeAddbtn()
		{
		library.clickonwebelement(object.getProperty("sysprtytypeaddbtn_xpath"), "xpath");
		}
			public void enterPrtyType(String stype) 
			{
				library.Entertext(object.getProperty("sysprtytype_xpath"), "xpath", stype);
			}
			public void enterPrtydescription(String sdesc)
			{
				library.Entertext(object.getProperty("sysprtytypedesc_xpath"), "xpath", sdesc);
		
			}
			public void clickonsubmitPrtyType()
			{
			library.clickonwebelement(object.getProperty("sysprtytypesubmitbtn_xpath"), "xpath");
			}
			public void clickoncancelPrtyType()
			{
			library.clickonwebelement(object.getProperty("sysprtytypecancelbtn_xpath"), "xpath");
			}
	public void  clickonTermsandconditions()
	{
		library.clickonwebelement(object.getProperty("systnc_xpath"), "xpath");
	}
	public void  clickonPrivacypolicy()
	{
		library.clickonwebelement(object.getProperty("syspp_xpath"), "xpath");
	}
	public void  clickonSqlbackups()
	{
		library.clickonwebelement(object.getProperty("syssql_xpath"), "xpath");
	}
	public void  clickonDownloads()
	{
		library.clickonwebelement(object.getProperty("sysdownloads_xpath"), "xpath");
	}
	
}
