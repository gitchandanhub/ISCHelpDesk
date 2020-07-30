package utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Base.BaseDriver;

public class ScreenShot extends BaseDriver
{
	public static TakesScreenshot tss = null;
	public static File src;
	public static File outputfile;
    public static void Takescreenshot(String name) 
    {
    	String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    	tss = (TakesScreenshot)driver;
    	src = tss.getScreenshotAs(OutputType.FILE);
    	outputfile = new File(config.getProperty("Screenshotpath")+name+timestamp);
    	try
    	{
    	FileUtils.copyFile(src, outputfile); //move screen shot file from buffer to local machine
    	}
    	catch(Exception e)
    	{
    	System.out.println(e.getMessage());
    	}
    }
}
