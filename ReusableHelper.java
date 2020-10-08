package components;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.commons.io.FileUtils;

import components.ApplicationFlow;

public class ReusableHelper {
	public static WebDriver _driver;
	public static String _dateTimeNow=currentDateTime();

	public static void EnterText (By elementpath,String strValue, String strName)
	{
		WebElement element = _driver.findElement(elementpath);
		element.sendKeys(strValue);	
	}
	public static void SelectValue (By elementpath,String strValue, String strName)
	{
		WebElement element = _driver.findElement(elementpath);
		List<WebElement> values = element.findElements(By.tagName("option"));
		for(WebElement value:values)
		{
			if(value.equals(strValue)) {
				element.click();
				break;
			}
		}	
	}
	public static void SetCheckbox (By elementpath, String strName)
	{
		WebElement element = _driver.findElement(elementpath);
		element.click();	
	}
	public static void tabSwitch (int tabNumber) {	
		Set<String> listWindows=_driver.getWindowHandles();
		String str=(String) listWindows.toArray()[tabNumber-1];
		_driver.switchTo().window(str);	
	}
	public static void takeScreenshot (WebDriver driverobj) {	
		String dateNow =currentDateTime();
		String filePath="C:\\Users\\Manju\\eclipse-workspace\\NewsTuck\\Screenshots\\"+_dateTimeNow+"\\doc"+dateNow+".png";
		TakesScreenshot scrshot = ((TakesScreenshot)driverobj);
		File srcfile = scrshot.getScreenshotAs(OutputType.FILE);
		File destfile =new File(filePath);
		try {
			FileUtils.copyFile(srcfile, destfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static String currentDateTime () {
	DateFormat objDF= new SimpleDateFormat("yyyy MMM dd HH_mm_ss");
	Date objDate = new Date();
	String sysDate=objDF.format(objDate);
	return sysDate;
	}
	
	


}
