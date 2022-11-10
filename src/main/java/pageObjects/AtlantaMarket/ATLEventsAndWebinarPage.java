package pageObjects.AtlantaMarket;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLEventsAndWebinarPage {
	public WebDriver driver;
	public WebDriverWait wait;

	By atlAttendTab = By.xpath("//a[contains(text(),'Attend')]"); // Locator for Exhibitor And Product tab 
	By atlEventsLink = By.xpath("//div[@class='imc-navigation__tier1Item-inner imc-navigation__tier1Item-inner--active tier1']/../div[2]/div[2]/div[2]/a[1]"); //Locator for floor plans Link
	By atlImcEventsTab = By.xpath("//div[@class='event-card--tab']/p[1]"); //Locator for IMC Events tab
	By atlExhibitorsEventsTab = By.xpath("//div[@class='event-card--tab']/p[2]"); //Locator for Exhibitors Events tab
	By atlEventsCalendar = By.xpath("//div[@class='calendar-container']"); //Locator for Calendar
	By atlEventsSearchBar = By.xpath("//div[@class='event-card--cal-btn-container']/div[1]/input[1]"); //Locator for Events Search bar
	By atlEventName = By.xpath("//div[@class='event-card--info']/div[1]/div[1]/a[1]/p[1]"); //Locator for 1st Event Name
	By atlEventSearchIcon = By.xpath("//div[@class='event-card--cal-btn-container']/div[1]/button[2]"); //Locator for Search btn
	By atlEventDateAndMonth = By.xpath("//div[@class='event-date--container']/p[1]"); //Locator for Events date and month
	By atlCalendarNextMonthBtn = By.xpath("//div[@class='calendar-container']/div[2]/div[1]/button[4]"); //Locator for Calendar nxt month btn
	By atlListOfEventDate = By.xpath("//button[@class='react-calendar__tile react-calendar__month-view__days__day']/abbr[1]"); //List for Event Date
	By atlSelectMonth = By.xpath("//button[@class='react-calendar__navigation__label']/span[1]"); //List for Month
	By atlTodaysDate = By.xpath("//button[@class='react-calendar__tile react-calendar__tile--now react-calendar__month-view__days__day react-calendar--no-event']/abbr[1]"); //Locator for Todays Date
	By atlCalendarPrevMonth = By.xpath("//div[@class='calendar-container']/div[2]/div[1]/button[2]"); //Locator for Calendar Prev month btn 
	By atlSelectAnyDate = By.xpath("//button[@class='react-calendar__tile react-calendar__month-view__days__day react-calendar--no-event']/abbr[1]"); //Locator for Any Date
	By atlResetBtn = By.xpath("//div[@class='calendar-container']/div[1]/p[2]"); //Locator for Reset Btn
	
	public ATLEventsAndWebinarPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	}
	public WebElement getatlResetBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlResetBtn));
		return driver.findElement(atlResetBtn);
	}
	public List <WebElement> getatlListOfatlSelectAnyDate() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlSelectAnyDate));
		return driver.findElements(atlSelectAnyDate);
	}
	public WebElement getatlCalendarPrevMonth() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlCalendarPrevMonth));
		return driver.findElement(atlCalendarPrevMonth);
	}
	public WebElement getatlTodaysDate() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlTodaysDate));
		return driver.findElement(atlTodaysDate);
	}
	public WebElement getatlSelectMonth() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlSelectMonth));
		return driver.findElement(atlSelectMonth);
	}
	public List <WebElement> getatlListOfEventDate() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlListOfEventDate));
		return driver.findElements(atlListOfEventDate);
	}
	public WebElement getatlCalendarNextMonthBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlCalendarNextMonthBtn));
		return driver.findElement(atlCalendarNextMonthBtn);
	}
	public WebElement getatlEventDateAndMonth() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlEventDateAndMonth));
		return driver.findElement(atlEventDateAndMonth);
	}
	public WebElement getatlEventSearchIcon() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlEventSearchIcon));
		return driver.findElement(atlEventSearchIcon);
	}
	public WebElement getatlEventName() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlEventName));
		return driver.findElement(atlEventName);
	}
	public WebElement getatlEventsSearchBar() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlEventsSearchBar));
		return driver.findElement(atlEventsSearchBar);
	}
	public WebElement getatlEventsCalendar() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlEventsCalendar));
		return driver.findElement(atlEventsCalendar);
	}
	public WebElement getatlImcEventsTab() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlImcEventsTab));
		return driver.findElement(atlImcEventsTab);
	}

	public WebElement getatlExhibitorsEventsTab() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlExhibitorsEventsTab));
		return driver.findElement(atlExhibitorsEventsTab);
	}
	public WebElement getatlAttendTab() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlAttendTab));
		return driver.findElement(atlAttendTab);
	}

	public WebElement getatlEventsLink() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlEventsLink));
		return driver.findElement(atlEventsLink);
	}
}
