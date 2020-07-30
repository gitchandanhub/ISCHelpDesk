package Regression;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Base.BaseDriver;
import Base.Library;

public class Practicetest 
{
	@Test
	public void practice() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://192.168.20.63:80/ISCHelpDesk/Login.aspx");
		
		driver.findElement(By.id("txtUserName")).sendKeys("sshiva");
		driver.findElement(By.id("txtPassword")).sendKeys("1");
		driver.findElement(By.id("btnLogin")).click();
		
//		driver.findElement(By.xpath("//a[text()='Scheduling']")).click();
//		Thread.sleep(1000);
//		WebElement elementlocator = driver.findElement(By.xpath("//div[contains(text(),'14')]"));
//		
//		Actions action = new Actions(driver);
//		action.contextClick(elementlocator).perform();
//		
//		List <WebElement> tickframe = driver.findElements(By.tagName("iframe"));
//		
//		driver.switchTo().frame(tickframe.get(0));
//		Thread.sleep(2000);
//		
//		//driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys("sfgfxgfxg");
//		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
//		try
//		{
//		System.out.println(driver.switchTo().alert().getText());
//		driver.switchTo().alert().accept();
//		}
//		catch(Exception e)
//		{
//			System.out.println("Event creation succesfull");
//		}
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("//a[contains(@href,'Logout') and @id='ctl00_Logout']")).click();
//		Actions actions = new Actions(driver);
//		actions.moveToElement(element).click().build().perform();
		
		WebElement ele = driver.findElement(By.xpath("//a[@id='ctl00_Logout']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		
	}
	
	
	
}
