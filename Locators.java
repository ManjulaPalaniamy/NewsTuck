package components;

import org.openqa.selenium.By;

public class Locators {
	
		public By userName = By.xpath("//input[@formcontrolname='username']");
		 public By passWord = By.xpath("//input[@formcontrolname='password']");
		 public By loginButton = By.xpath("//input[@value='Login']");
		public By todayDate = By.xpath("(//div[@class='feed-details']//li)[1]");
		public By sourceSite = By.xpath("(//div[@class='feed-details']//li)[2]");
		public By newsUnread = By.xpath("//div[@role='button' and @title='Filter']");
		public By selectUnread = By.xpath("//li[@role='button']//input[@id='read']");
		public By selectSelected = By.xpath("//li[@role='button']//input[@id='select']");
		public By newsHeadline=By.xpath("(//div[@class='each-feed-container']//a[@style='cursor: pointer;'])[1]");	
		public By addTags=By.xpath("//div[@class='c-btn']");
		public By oneTag=By.xpath("(//li[@class='pure-checkbox']//input[@type='checkbox'])[3]");
		public By newsDimension=By.xpath("(//div[@class='selected'])[1]");
		public By addStar=By.xpath("(//div[@class='select-wrap']//ul//li)[4]");
		public By selectNews=By.xpath("//input[@id='defaultCheck1']");
		public By sliderNews=By.xpath("//label[@class='switch']//span[@class='slider']");
		public By sendToEditor=By.xpath("//a[@class='actionButton']");
	}
	


