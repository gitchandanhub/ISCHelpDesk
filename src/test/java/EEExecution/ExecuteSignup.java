package EEExecution;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseDriver;
import Base.Library;
import pagescreen.Loginpage;
import pagescreen.SignUpPage;
import utility.ExcelUtility;

public class ExecuteSignup extends BaseDriver
{
	Loginpage lpobj;  
	public ExecuteSignup()
	{
		super();
		lpobj =  new Loginpage();  
		
	}
	
	@Test
	public void signupuser() throws IOException, InterruptedException
	{
		System.out.println("User SignUp Started");
		lpobj.clicksignup();
		
		SignUpPage spobj = new SignUpPage();
		
		spobj.enterCompany(ExcelUtility.readexcel(config.getProperty("signupuserdetails"), 0, 1, 0));
		log.info("CompanyName entered");
		
		spobj.enterFirstname(ExcelUtility.readexcel(config.getProperty("signupuserdetails"), 0, 1, 1));
		log.info("First entered");
		spobj.enterLastname(ExcelUtility.readexcel(config.getProperty("signupuserdetails"), 0, 1, 2));
		log.info("Last entered");	
		spobj.enterAddress(ExcelUtility.readexcel(config.getProperty("signupuserdetails"), 0, 1, 3));
		log.info("Address Entered");
		spobj.enterCity(ExcelUtility.readexcel(config.getProperty("signupuserdetails"), 0, 1, 4));
		log.info("City entered");	
		spobj.selectState();
		log.info("State selected");
//		spobj.Enterzip(ExcelUtility.numreadexcel(config.getProperty("signupuserdetails"), 0, 1, 6));
//		log.info(" Zip Entered ");
//		spobj.enterPhone(ExcelUtility.numreadexcel(config.getProperty("signupuserdetails"), 0, 1, 7));
		spobj.enterUsername(ExcelUtility.readexcel(config.getProperty("signupuserdetails"), 0, 1, 8));
		spobj.enterPassword(ExcelUtility.readexcel(config.getProperty("signupuserdetails"), 0, 1, 9));
		spobj.enterEmailAddress(ExcelUtility.readexcel(config.getProperty("signupuserdetails"), 0, 1, 10));
		spobj.selectTndCCheckbox();
		spobj.clickSubmitbutton();
		WebElement msg = driver.findElement(By.xpath("//span[@id='lbl_error']"));
		System.out.println(msg.getText());
	}
}
