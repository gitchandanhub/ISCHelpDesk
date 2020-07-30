package EEExecution;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.externalconfig.model.Config;

import Base.BaseDriver;
import pagescreen.ForgotPasswordPage;
import pagescreen.Loginpage;
import utility.ExcelUtility;

public class ExecuteForgotPassword  extends BaseDriver
{
	Loginpage lpobj;  
	public ExecuteForgotPassword()
	{
		super();
		lpobj =  new Loginpage();  
		
	}
	@Test
	public void exeforgotpwd() throws IOException, InterruptedException
	{
		lpobj.clickforgotpassword();
		
		ForgotPasswordPage fppobj = new ForgotPasswordPage();
		fppobj.enterUserName(ExcelUtility.readexcel(config.getProperty("forgotpwd"), 0, 1, 0));
		Thread.sleep(1000);
		log.info("UserName Entered");
		fppobj.enterEmailAddress(ExcelUtility.readexcel(config.getProperty("forgotpwd"), 0, 1, 1));
		Thread.sleep(1000);
		log.info("EmailAddress Entered");
		//fppobj.clickonClear();
		fppobj.clickonSubmit();
		Thread.sleep(2000);
		String alerttext = driver.switchTo().alert().getText();
		System.out.println(alerttext);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);

	}
}
