package Base;

import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utility.AllWaits;

public class BaseDriver 
{
	public static WebDriver driver = null;
	public static Properties config = new Properties();
	public static Properties object = new Properties();
	public static Logger log=Logger.getLogger("devpinoyLogger");
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports extentreport;
	public static ExtentTest extenttest; 
	@BeforeTest
	public void Initialize() throws Exception {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		String x = dtf.format(now);
		htmlreporter = new ExtentHtmlReporter("C:\\Users\\bvikram\\Downloads\\ISC_helpdesk-master\\ISC_helpdesk-master\\Report\\iscresult.html");
		//htmlreporter = new ExtentHtmlReporter(config.getProperty("ExtentReport_path")+"Steriaresult"+dtf.format(now)+".html");

		htmlreporter.config().setEncoding("utf-8");
		htmlreporter.config().setDocumentTitle("Automation Test");
		htmlreporter.config().setReportName("Automation result");
		htmlreporter.config().setTheme(Theme.STANDARD);      
		extentreport = new ExtentReports();
		extentreport.setSystemInfo("Organization", "way2testing");    
		extentreport.attachReporter(htmlreporter);   	 
		FileInputStream fis = new FileInputStream("C:\\Users\\bvikram\\Downloads\\ISC_helpdesk-master\\ISC_helpdesk-master\\src\\main\\java\\properties\\config.properties");
		config.load(fis);
		FileInputStream objectfis = new FileInputStream("C:\\Users\\bvikram\\Downloads\\ISC_helpdesk-master\\ISC_helpdesk-master\\src\\main\\java\\properties\\object.properties");
		object.load(objectfis);
		if(config.getProperty("Browser").equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", config.getProperty("Chromepath"));
			System.setProperty("webdriver.chrome.silentOutput", "true");
			driver = new ChromeDriver();
		}
		else  if(config.getProperty("Browser").equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", config.getProperty("Firefoxpath"));
			driver = new FirefoxDriver();
		}
		else  if(config.getProperty("Browser").equalsIgnoreCase("InternetExplorer"))
		{
			System.setProperty("webdriver.internetExplorer.driver", config.getProperty("InternetExplorerpath"));
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(AllWaits.Implicitwait, TimeUnit.SECONDS);
		driver.navigate().to(config.getProperty("Url"));
	}

	@AfterTest
	public void closeApp()
	{
		extentreport.flush();
		//  driver.close();
	}

}
