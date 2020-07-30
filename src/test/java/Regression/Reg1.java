package Regression;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.BaseDriver;
import pagescreen.Loginpage;
@Listeners(Listen.TestNG_Listeners.class)
public class Reg1 extends BaseDriver
{
	Loginpage lpobj;  
	public Reg1()
	{
		super();
		lpobj =  new Loginpage();  
		
	}
	@Test(priority = 0)
	public void ValidateLogin()
	{
		System.out.println(config.getProperty("username"));
		lpobj.EnterUsername(config.getProperty("username"));
		lpobj.EnterPassword(config.getProperty("password"));
		lpobj.clickloginbutton();
	}

}
