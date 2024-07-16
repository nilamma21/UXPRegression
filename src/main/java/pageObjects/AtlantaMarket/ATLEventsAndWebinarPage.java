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
	By atlExploreMarketTab = By.xpath("(//a[contains(text(),'Explore Market')])[1]"); // Locator for Exhibitor And Product tab 
	By atlEventsLink = By.xpath("(//a[contains(text(),'Events')])[1]"); //Locator for floor plans Link
	By atlImcEventsTab = By.xpath("//div[@class='event-card--tab']/p[1]"); //Locator for IMC Events tab
	By atlExhibitorsEventsTab = By.xpath("//div[@class='event-card--tab']/p[2]"); //Locator for Exhibitors Events tab
	By atlEventsCalendar = By.xpath("//div[@class='calendar-container']"); //Locator for Calendar
	By atlEventsSearchBar = By.xpath("//div[@class='event-card--cal-btn-container']/div[1]/input[1]"); //Locator for Events Search bar
	By atlEventName = By.xpath("//div[@class='event-card--info']/div[1]/div[1]/a[1]/p[1]"); //Locator for 1st Event Name
	By atlClickOnEvent = By.xpath("(//div[@class='event-card--info']/div[1]/div[1]/a[1]/p[1])[1]"); //Locator for 1st Event Name
	
	By atlEventSearchIcon = By.xpath("//div[@class='event-card--cal-btn-container']/div[1]/button[1]"); //Locator for Search btn
	By atlEventSearchIconUAT = By.xpath("//div[@class='event-card--cal-btn-container']/div[1]/button[1]"); //Locator for Search btn
	By atlEventDateAndMonth = By.xpath("//div[@class='event-date--container']/p[1]"); //Locator for Events date and month
	By atlCalendarNextMonthBtn = By.xpath("//div[@class='calendar-container']/div[2]/div[1]/button[4]"); //Locator for Calendar nxt month btn
	By atlListOfEventDate = By.xpath("//div[@class='react-calendar__month-view__days']/button/abbr[1]"); //List for Event Date
	By atlSelectMonth = By.xpath("//button[@class='react-calendar__navigation__label']/span[1]"); //List for Month
	By atlTodaysDate = By.xpath("//button[@class='react-calendar__tile react-calendar__tile--now react-calendar__month-view__days__day react-calendar--no-event']/abbr[1]");//Locator for Todays Date
	By atlTodaysDatePROD = By.xpath("//button[@class='react-calendar__tile react-calendar__tile--now react-calendar__month-view__days__day']/abbr");//Locator for Todays Date
	
	By atlCalendarPrevMonth = By.xpath("//div[@class='calendar-container']/div[2]/div[1]/button[2]"); //Locator for Calendar Prev month btn 
	By atlSelectAnyDate = By.xpath("//button[@class='react-calendar__tile react-calendar__month-view__days__day react-calendar--no-event']/abbr[1]"); //Locator for Any Date
	By atlResetBtn = By.xpath("//div[@class='calendar-container']/div[1]/p[2]"); //Locator for Reset Btn
	By atlListOfEventTitles = By.xpath("//p[@class='event-card--title']"); //Locator for list of all Events Title
	By atlListOfAllEvents = By.xpath("//div[@class='event-card--multi-card-container']/div"); //Locator for list of all Events 
	By atlListOfAllEventsType = By.xpath("//p[@class='event-card--event-type']"); //Locator for list of all Events
	By atlListOfAllEventsTime = By.xpath("//div[@class='event-card--info']/div[2]/p"); //Locator for list of all Events
	By atlListOfAllEventsLocations = By.xpath("//div[@class='event-card--info']/div[3]/p[1]/span"); //Locator for list of all Events
	By atlListOfAllEventsImages = By.xpath("//div[@class='event-card--multi-card-container']/div/img"); //Locator for list of all Events
	By atlListOfAllEventsSeeDetailsLink = By.xpath("//a[@class='imc-link--caret-after imc-type--body-1-link']"); //Locator for list of all Events
	By atlEventNameOnDetailsPage = By.xpath("//div[contains(@class,'imc-eventdetail--header')]/h1"); //Locator for list of all Events
	By atlEventLocationLink = By.xpath("//div[@class='imc-eventdetail--location']/a/span"); //Locator for Event location link
	By atlEventLocationLinkLVMPROD = By.xpath("//div[@class='imc-eventdetail--location']/p/span[1]"); //Locator for Event location link
	
	By atlEventType = By.xpath("//p[@class='imc-eventdetail--event-type']"); //Locator for Event Type
	By atlFavIcon = By.xpath("//div[@class='imc-eventdetail--actions-bar']//ul/li/div/button"); //Locator for Fav Icon
	By atlListIcon = By.xpath("//ul[@class='imc-eventcard--add--links']/li[2]/button[1]"); //Locator for List Icon
	By atlNoteIcon = By.xpath("//ul[@class='imc-eventcard--add--links']/li[3]/div[1]/div[1]/div[1]/button[1]"); //Locator for Note Icon
	By atlCalendarIcon = By.xpath("//span[@class='imc-eventdetail--calendar']/a"); //Locator for Calendar Icon
	By atlTagIcon = By.xpath("//div[@class='imc-section--alt-gray-light imc-eventdetail__box imc-eventdetail__box--eventpadding imc-content--primary-desktop']/../../section[3]/div[1]/div[1]/span[1]"); //Locator for Tag Icon
	By atlEventsTag = By.xpath("//div[@class='imc-section--alt-gray-light imc-eventdetail__box imc-eventdetail__box--eventpadding imc-content--primary-desktop']/../../section[3]/div[1]/div[2]/div[1]/a[1]"); //Locator for Tag Icon
	By atlSearchResultsTitle = By.xpath("//div[@class='imc-gallery imc-gallery--65-35 breadcrumbs__round']/div[1]/ul[1]/li[2]/a[1]"); //Locator for Tag Icon
	By atladdtoseselectedbtn = By.xpath("//input[@data-xpath='quickAdd.saveList']"); //Locator for Add to Selected button
	
	public ATLEventsAndWebinarPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	}
	public WebElement getatlEventLocationLinkLVMPROD() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlEventLocationLinkLVMPROD));
		
		return driver.findElement(atlEventLocationLinkLVMPROD);
		
	}
	public WebElement getatlEventSearchIconUAT() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlEventSearchIconUAT));
		
		return driver.findElement(atlEventSearchIconUAT);
		
	}
	public WebElement getatlTodaysDatePROD() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlTodaysDatePROD));
		
		return driver.findElement(atlTodaysDatePROD);
		
	}
	public WebElement getatladdtoseselectedbtn() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atladdtoseselectedbtn));
		
		return driver.findElement(atladdtoseselectedbtn);
		
	}
	public WebElement getatlClickOnEvent() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlClickOnEvent));
		return driver.findElement(atlClickOnEvent);
	}
	public WebElement getatlSearchResultsTitle() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlSearchResultsTitle));
		return driver.findElement(atlSearchResultsTitle);
	}
	public WebElement getatlEventsTag() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlEventsTag));
		return driver.findElement(atlEventsTag);
	}
	public WebElement getatlTagIcon() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlTagIcon));
		return driver.findElement(atlTagIcon);
	}
	public WebElement getatlCalendarIcon() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlCalendarIcon));
		return driver.findElement(atlCalendarIcon);
	}
	public WebElement getatlNoteIcon() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlNoteIcon));
		return driver.findElement(atlNoteIcon);
	}
	public WebElement getatlListIcon() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlListIcon));
		return driver.findElement(atlListIcon);
	}
	public WebElement getatlFavIcon() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlFavIcon));
		return driver.findElement(atlFavIcon);
	}
	public WebElement getatlEventType() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlEventType));
		return driver.findElement(atlEventType);
	}
	public WebElement getatlEventLocationLink() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlEventLocationLink));
		return driver.findElement(atlEventLocationLink);
	}
	public WebElement getatlEventNameOnDetailsPage() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlEventNameOnDetailsPage));
		return driver.findElement(atlEventNameOnDetailsPage);
	}
	public List <WebElement> atlatlListOfAllEventsSeeDetailsLink() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlListOfAllEventsSeeDetailsLink));
		return driver.findElements(atlListOfAllEventsSeeDetailsLink);
	}
	public List <WebElement> atlListOfAllEventsImages() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlListOfAllEventsImages));
		return driver.findElements(atlListOfAllEventsImages);
	}
	public List <WebElement> getatlListOfAllEventsLocations() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlListOfAllEventsLocations));
		return driver.findElements(atlListOfAllEventsLocations);
	}
	public List <WebElement> getatlListOfAllEventsTime() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlListOfAllEventsTime));
		return driver.findElements(atlListOfAllEventsTime);
	}
	public List <WebElement> getatlListOfAllEventsType() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlListOfAllEventsType));
		return driver.findElements(atlListOfAllEventsType);
	}
	public List <WebElement> getatlListOfAllEvents() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlListOfAllEvents));
		return driver.findElements(atlListOfAllEvents);
	}
	public List <WebElement> getatlListOfEventTitles() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlListOfEventTitles));
		return driver.findElements(atlListOfEventTitles);
	}
	public WebElement getatlExploreMarketTab() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlExploreMarketTab));
		return driver.findElement(atlExploreMarketTab);
	}
	public WebElement getatlResetBtn() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlResetBtn));
		return driver.findElement(atlResetBtn);
	}
	public List <WebElement> getatlListOfatlSelectAnyDate() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlSelectAnyDate));
		return driver.findElements(atlSelectAnyDate);
	}
	public WebElement getatlCalendarPrevMonth() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlCalendarPrevMonth));
		return driver.findElement(atlCalendarPrevMonth);
	}
	public WebElement getatlTodaysDate() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlTodaysDate));
		return driver.findElement(atlTodaysDate);
	}
	public WebElement getatlSelectMonth() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlSelectMonth));
		return driver.findElement(atlSelectMonth);
	}
	public List <WebElement> getatlListOfEventDate() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlListOfEventDate));
		return driver.findElements(atlListOfEventDate);
	}
	public WebElement getatlCalendarNextMonthBtn() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlCalendarNextMonthBtn));
		return driver.findElement(atlCalendarNextMonthBtn);
	}
	public WebElement getatlEventDateAndMonth() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlEventDateAndMonth));
		return driver.findElement(atlEventDateAndMonth);
	}
	public WebElement getatlEventSearchIcon() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlEventSearchIcon));
		return driver.findElement(atlEventSearchIcon);
	}
	public WebElement getatlEventName() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlEventName));
		return driver.findElement(atlEventName);
	}
	public WebElement getatlEventsSearchBar() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlEventsSearchBar));
		return driver.findElement(atlEventsSearchBar);
	}
	public WebElement getatlEventsCalendar() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlEventsCalendar));
		return driver.findElement(atlEventsCalendar);
	}
	public WebElement getatlImcEventsTab() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlImcEventsTab));
		return driver.findElement(atlImcEventsTab);
	}

	public WebElement getatlExhibitorsEventsTab() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(atlExhibitorsEventsTab));
		return driver.findElement(atlExhibitorsEventsTab);
	}
	public WebElement getatlAttendTab() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlAttendTab));
		return driver.findElement(atlAttendTab);
	}

	public WebElement getatlEventsLink() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(atlEventsLink));
		return driver.findElement(atlEventsLink);
	}
}
