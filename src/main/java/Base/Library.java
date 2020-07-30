package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Library extends BaseDriver
{
	WebElement webelement = null;
    public WebElement  getWebElement(String locator, String locator_type)
    {
    	if(locator_type.equalsIgnoreCase("xpath"))
    	{
    		webelement = driver.findElement(By.xpath(locator));    		
    	}
    	else if(locator_type.equalsIgnoreCase("id"))
    	{
    		webelement = driver.findElement(By.id(locator));    		
    	}
    	else if(locator_type.equalsIgnoreCase("name"))
    	{
    		webelement = driver.findElement(By.name(locator));    		
    	}
    	else if(locator_type.equalsIgnoreCase("className"))
    	{
    		webelement = driver.findElement(By.className(locator));    	
    	}
    	else if(locator_type.equalsIgnoreCase("cssSelector"))
    	{
    		webelement = driver.findElement(By.cssSelector(locator));    		
    	}
    	else if(locator_type.equalsIgnoreCase("linkText"))
    	{
    		webelement = driver.findElement(By.linkText(locator));    		
    	}
    	else if(locator_type.equalsIgnoreCase("partialLinkText"))
    	{
    		webelement = driver.findElement(By.partialLinkText(locator));    		
    	}
    	else if(locator_type.equalsIgnoreCase("tagName"))
    	{
    		webelement = driver.findElement(By.tagName(locator));    		
    	}
    	return webelement;
    }
    
    public void clickonwebelement(String locator, String locator_type)
    {
    	webelement = getWebElement(locator, locator_type);
    	if(webelement.isDisplayed())
    	{
    		webelement.click();
    	}
    	else if(webelement.isEnabled())
    	{
    		webelement.click();
    	}
    	else
    	{
    		JavascriptExecutor jse = (JavascriptExecutor)driver;
    		jse.executeScript("arguments[0].scrollIntoView()", webelement);
    		webelement.click();
    	}
    }
    public void clearTextbox(String locator, String locator_type)
    {
    	webelement = getWebElement(locator, locator_type);
    	webelement.clear();
    }
     
    public void Entertext(String locator, String locator_type, String text)
    {
    	webelement = getWebElement(locator, locator_type);
    	webelement.sendKeys(text);
    }
    public void Enternumerictext(String locator, String locator_type, int text)
    {
    	webelement = getWebElement(locator, locator_type);
    	webelement.sendKeys(String.valueOf(text));
    }
    public String getText(String locator, String locator_type)
    {
    	webelement = getWebElement(locator, locator_type);
    	return webelement.getText();
    }
    
    public void selectIndex(String  locator, String locator_type, int adm)
    {
    	webelement = getWebElement(locator, locator_type);
    	Select slt = new Select(webelement);
    	slt.selectByIndex(adm);
    	
    }
    public void selectvalue(String  locator, String locator_type, String value)
    {
    	webelement = getWebElement(locator, locator_type);
    	Select slt = new Select(webelement);
    	slt.selectByValue(value);
    	
    }
    
    
    
    
    public void selectCheckbox(String locator, String locator_type)
    {
    	webelement = getWebElement(locator, locator_type);
    	webelement.click();
    }
}
