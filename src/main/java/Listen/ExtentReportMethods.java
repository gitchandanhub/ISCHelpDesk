package Listen;

import java.lang.reflect.Method;

import org.testng.ITestNGMethod;

import com.aventstack.extentreports.Status;

import Base.BaseDriver;


public class ExtentReportMethods extends BaseDriver
{
	 public static void testpass(ITestNGMethod iTestNGMethod)
     {
		String name =  iTestNGMethod.getMethodName();
     extenttest = extentreport.createTest(name);
     extenttest.log(Status.PASS, "Test passed");
     }
     
     public static void testfail(ITestNGMethod iTestNGMethod)
     {
    	 String name =  iTestNGMethod.getMethodName();
     extenttest = extentreport.createTest(name);
     extenttest.log(Status.FAIL, "Test Failed");
     }
     
     public static void testskip(ITestNGMethod iTestNGMethod)
     {
    	 String name =  iTestNGMethod.getMethodName();
     extenttest = extentreport.createTest(name);
     extenttest.log(Status.SKIP, "Test skipped");
     }
}
