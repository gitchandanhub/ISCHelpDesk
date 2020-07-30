package Base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Base.BaseDriver;
import Base.Library;

public class Practicepage extends BaseDriver
{
Library library;

    public Practicepage()
    {
    	super();
    	library = new Library();
    }
    public void Enterfirstname(String name)
    {
    	library.clearTextbox(object.getProperty("firstname_xpath"), "xpath");
    	library.Entertext(object.getProperty("firstname_xpath"), "xpath", name);
    	/*WebElement fname = library.getWebElement(object.getProperty("firstname_xpath"), "xpath");
        fname.clear();
        fname.sendKeys(name);*/
    }
    public void Enterlastname(String name)
    {
    	library.clearTextbox(object.getProperty("lastname_xpath"), "xpath");
    	library.Entertext(object.getProperty("lastname_xpath"), "xpath", name);
    	/*WebElement lname = library.getWebElement(object.getProperty("lastname_xpath"), "xpath");
        lname.clear();
        lname.sendKeys(name);*/
    }
    public void clicksubmit()
    {
    	library.clickonwebelement(object.getProperty("submitbutton_xpath"), "xpath");
    	System.out.println("Submit button pressed");
    }
}
