package components;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ApplicationFlow extends ReusableHelper{

	Locators objLocators=new Locators();
	
	
	@BeforeTest
	public void Login() throws Exception
	{
		File objFile = new File ("C:\\Users\\Manju\\eclipse-workspace\\NewsTuck\\Screenshots\\"+_dateTimeNow);
		objFile.mkdir();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Manju\\eclipse-workspace\\NewsTuck\\chromedriver.exe");
		_driver = new ChromeDriver();
		String strURL="http://stage-newstuck.onemindindia.com";
		String userName ="StageCurator";
		String passWord ="$tageN3w5tuckCu6ato6";
		//launch URL
		_driver.get(strURL);
		_driver.manage().window().maximize();
		takeScreenshot(_driver);
		Thread.sleep(10000);
		
		//login window, entering credentials
		EnterText(objLocators.userName, userName, "UserName");
		EnterText(objLocators.passWord, passWord, "Password");
		takeScreenshot(_driver);
		SetCheckbox(objLocators.loginButton, "Login button");
		Thread.sleep(5000);
	}
	
		//to show unread news only, unselected read category
	@Test (priority =1)
	public void UnreadNews() throws Exception
	{
		_driver.findElement(objLocators.newsUnread).click();
		takeScreenshot(_driver);
		_driver.findElement(objLocators.selectUnread).click();
		_driver.findElement(objLocators.newsUnread).click();
		Thread.sleep(5000);
		_driver.findElement(objLocators.newsUnread).click();
		_driver.findElement(objLocators.selectSelected).click();
		takeScreenshot(_driver);
		_driver.findElement(objLocators.newsUnread).click();
		Thread.sleep(5000);
		}

		//landed into application
		//today's date and news source
	@Test (priority =2)
	public void TodaysDate() throws Exception
	{
		_driver.findElement(objLocators.todayDate).isDisplayed();
		String strTodayDate = _driver.findElement(objLocators.todayDate).getText();
		String strNewsSource = _driver.findElement(objLocators.sourceSite).getText();
		DateFormat objDF= new SimpleDateFormat("E MMM dd yyyy");
		Date objDate = new Date();
		String sysDate=objDF.format(objDate);
		strTodayDate=strTodayDate.substring(0, 15);
		//comapring system date with date fetched from UI
		Assert.assertEquals(sysDate, strTodayDate);
		System.out.println(strNewsSource);
	}

		//clicking news and opening in new tab
	@Test (priority =3)
	public void NewsOpensNewTab() throws Exception
	{
		_driver.findElement(objLocators.newsHeadline).click();
		tabSwitch(2);
		takeScreenshot(_driver);
		_driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.MILLISECONDS);
		tabSwitch(1);
		takeScreenshot(_driver);
		}
	//to add rank
	@Test (priority =4)
	public void AddingRank() throws Exception
	{
		//****this is to select news category like politics eduaction, tamilnadu
		_driver.findElement(objLocators.addTags).click();	
		// _driver.findElement(objLocators.oneTag).click(); ****unable to select checkbox right now
		_driver.findElement(objLocators.addTags).click();
		//***adding rank here
		_driver.findElement(objLocators.newsDimension).click();
		takeScreenshot(_driver);
		_driver.findElement(objLocators.addStar).click();
		takeScreenshot(_driver);
	}
	
	//to select news and send to Editor
	@Test (priority =5)
	public void SelectSendEditor() throws Exception
	{
		//***selecting news
		SetCheckbox(objLocators.selectNews, "Select news to send to Editor");
		takeScreenshot(_driver);
		//***Move news to selected items
		_driver.findElement(objLocators.sliderNews).click();
		takeScreenshot(_driver);
		Thread.sleep(3000);
		//***Sending to Editor
		_driver.findElement(objLocators.sendToEditor).click();
		takeScreenshot(_driver);
	}
	@AfterTest
	public void ClosingBrowser() throws Exception
	{
		_driver.quit();

	}

}
