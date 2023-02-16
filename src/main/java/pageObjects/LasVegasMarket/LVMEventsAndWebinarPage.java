package pageObjects.LasVegasMarket;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LVMEventsAndWebinarPage {
	public WebDriver driver;
	public WebDriverWait wait;
	
	By lvmAttendTab = By.xpath("//a[contains(text(),'Attend')]"); // Locator for Exhibitor And Product tab 
	By lvmExploreMarketTab = By.xpath("(//a[contains(text(),'Explore Market')])[1]"); // Locator for Exhibitor And Product tab 
	By lvmEventsLink = By.xpath("(//a[contains(text(),'Events')])[1]"); //Locator for floor plans Link
	By lvmImcEventsTab = By.xpath("//div[@class='event-card--tab']/p[1]"); //Locator for IMC Events tab
	By lvmExhibitorsEventsTab = By.xpath("//div[@class='event-card--tab']/p[2]"); //Locator for Exhibitors Events tab
	By lvmEventsCalendar = By.xpath("//div[@class='calendar-container']"); //Locator for Calendar
	By lvmEventsSearchBar = By.xpath("//div[@class='event-card--cal-btn-container']/div[1]/input[1]"); //Locator for Events Search bar
	By lvmEventName = By.xpath("//div[@class='event-card--info']/div[1]/div[1]/a[1]/p[1]"); //Locator for 1st Event Name
	By lvmClickOnEvent = By.xpath("(//div[@class='event-card--info']/div[1]/div[1]/a[1]/p[1])[1]"); //Locator for 1st Event Name
	
	By lvmEventSearchIcon = By.xpath("//div[@class='event-card--cal-btn-container']/div[1]/button[2]"); //Locator for Search btn
	By lvmEventDateAndMonth = By.xpath("//div[@class='event-date--container']/p[1]"); //Locator for Events date and month
	By lvmCalendarNextMonthBtn = By.xpath("//div[@class='calendar-container']/div[2]/div[1]/button[4]"); //Locator for Calendar nxt month btn
	By lvmListOfEventDate = By.xpath("//button[@class='react-calendar__tile react-calendar__month-view__days__day']/abbr[1]"); //List for Event Date
	By lvmSelectMonth = By.xpath("//button[@class='react-calendar__navigation__label']/span[1]"); //List for Month
	By lvmTodaysDate = By.xpath("//button[@class='react-calendar__tile react-calendar__tile--now react-calendar__month-view__days__day react-calendar--no-event']/abbr[1]"); //Locator for Todays Date
	By lvmCalendarPrevMonth = By.xpath("//div[@class='calendar-container']/div[2]/div[1]/button[2]"); //Locator for Calendar Prev month btn 
	By lvmSelectAnyDate = By.xpath("//button[@class='react-calendar__tile react-calendar__month-view__days__day react-calendar--no-event']/abbr[1]"); //Locator for Any Date
	By lvmResetBtn = By.xpath("//div[@class='calendar-container']/div[1]/p[2]"); //Locator for Reset Btn
	By lvmListOfEventTitles = By.xpath("//p[@class='event-card--title']"); //Locator for list of all Events Title
	By lvmListOfAllEvents = By.xpath("//div[@class='event-card--multi-card-container']/div"); //Locator for list of all Events 
	By lvmListOfAllEventsType = By.xpath("//p[@class='event-card--event-type']"); //Locator for list of all Events
	By lvmListOfAllEventsTime = By.xpath("//div[@class='event-card--info']/div[2]/p"); //Locator for list of all Events
	By lvmListOfAllEventsLocations = By.xpath("//div[@class='event-card--info']/div[3]/p[1]/span"); //Locator for list of all Events
	By lvmListOfAllEventsImages = By.xpath("//div[@class='event-card--multi-card-container']/div/img"); //Locator for list of all Events
	By lvmListOfAllEventsSeeDetailsLink = By.xpath("//a[@class='imc-link--caret-after imc-type--body-1-link']"); //Locator for list of all Events
	By lvmEventNameOnDetailsPage = By.xpath("//div[@class='imc-static-hero imc-section imc-section--full-width imc-content--center']/../section[1]/h1[1]"); //Locator for list of all Events
	By lvmEventLocationLink = By.xpath("//div[@class='imc-eventdetail--margin-bottom']/a[1]"); //Locator for Event location link
	By lvmEventType = By.xpath("//div[@class='imc-eventdetail--margin-bottom']/span[2]"); //Locator for Event Type
	By lvmFavIcon = By.xpath("//ul[@class='imc-eventcard--add--links']/li[1]/div[1]/button[1]/label[1]"); //Locator for Fav Icon
	By lvmListIcon = By.xpath("//ul[@class='imc-eventcard--add--links']/li[2]/button[1]"); //Locator for List Icon
	By lvmNoteIcon = By.xpath("//ul[@class='imc-eventcard--add--links']/li[3]/div[1]/div[1]/div[1]/button[1]"); //Locator for Note Icon
	By lvmCalendarIcon = By.xpath("//div[@class='imc-section--alt-gray-light imc-eventdetail__box imc-eventdetail__box--eventpadding imc-content--primary-desktop']/a[1]"); //Locator for Calendar Icon
	By lvmTagIcon = By.xpath("//div[@class='imc-section--alt-gray-light imc-eventdetail__box imc-eventdetail__box--eventpadding imc-content--primary-desktop']/../../section[3]/div[1]/div[1]/span[1]"); //Locator for Tag Icon
	By lvmEventsTag = By.xpath("//div[@class='imc-section--alt-gray-light imc-eventdetail__box imc-eventdetail__box--eventpadding imc-content--primary-desktop']/../../section[3]/div[1]/div[2]/div[1]/a[1]"); //Locator for Tag Icon
	By lvmSearchResultsTitle = By.xpath("//div[@class='imc-gallery imc-gallery--65-35 breadcrumbs__round']/div[1]/ul[1]/li[2]/a[1]"); //Locator for Tag Icon
	By lvmaddtoseselectedbtn = By.xpath("//input[@data-xpath='quickAdd.saveList']"); //Locator for Add to Selected button
	
	By lvmEventNameOnDetailsPageUAT = By.xpath("//div[@class='imc-eventdetail--root-container']/div[1]/h1[1]"); //Locator for list of all Events
	By lvmEventLocationLinkUAT = By.xpath("//div[@class='imc-eventdetail--location']/a[1]"); //Locator for Event location link
	
	By lvmEventTypeUAT = By.xpath("//div[@class='imc-eventdetail--text-container']/span[3]"); //Locator for Event Type
	By lvmCalendarIconUAT = By.xpath("//div[@class='imc-eventdetail--text-container']//span[2]/a[1]"); //Locator for Calendar Icon
	
	
	public LVMEventsAndWebinarPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	}
	public WebElement getlvmCalendarIconUAT() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmCalendarIconUAT));
		return driver.findElement(lvmCalendarIconUAT);
	}
	public WebElement getlvmEventTypeUAT() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmEventTypeUAT));
		return driver.findElement(lvmEventTypeUAT);
	}
	public WebElement getlvmEventLocationLinkUAT() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmEventLocationLinkUAT));
		return driver.findElement(lvmEventLocationLinkUAT);
	}
	public WebElement getlvmEventNameOnDetailsPageUAT() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmEventNameOnDetailsPageUAT));
		return driver.findElement(lvmEventNameOnDetailsPageUAT);
	}
	public WebElement getlvmaddtoseselectedbtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmaddtoseselectedbtn));
		return driver.findElement(lvmaddtoseselectedbtn);
	}
	public WebElement getlvmClickOnEvent() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmClickOnEvent));
		return driver.findElement(lvmClickOnEvent);
	}
	public WebElement getlvmSearchResultsTitle() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmSearchResultsTitle));
		return driver.findElement(lvmSearchResultsTitle);
	}
	public WebElement getlvmEventsTag() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmEventsTag));
		return driver.findElement(lvmEventsTag);
	}
	public WebElement getlvmTagIcon() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmTagIcon));
		return driver.findElement(lvmTagIcon);
	}
	public WebElement getlvmCalendarIcon() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmCalendarIcon));
		return driver.findElement(lvmCalendarIcon);
	}
	public WebElement getlvmNoteIcon() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmNoteIcon));
		return driver.findElement(lvmNoteIcon);
	}
	public WebElement getlvmListIcon() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmListIcon));
		return driver.findElement(lvmListIcon);
	}
	public WebElement getlvmFavIcon() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmFavIcon));
		return driver.findElement(lvmFavIcon);
	}
	public WebElement getlvmEventType() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmEventType));
		return driver.findElement(lvmEventType);
	}
	public WebElement getlvmEventLocationLink() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmEventLocationLink));
		return driver.findElement(lvmEventLocationLink);
	}
	public WebElement getlvmEventNameOnDetailsPage() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmEventNameOnDetailsPage));
		return driver.findElement(lvmEventNameOnDetailsPage);
	}
	public List <WebElement> lvmlvmListOfAllEventsSeeDetailsLink() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmListOfAllEventsSeeDetailsLink));
		return driver.findElements(lvmListOfAllEventsSeeDetailsLink);
	}
	public List <WebElement> lvmListOfAllEventsImages() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmListOfAllEventsImages));
		return driver.findElements(lvmListOfAllEventsImages);
	}
	public List <WebElement> getlvmListOfAllEventsLocations() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmListOfAllEventsLocations));
		return driver.findElements(lvmListOfAllEventsLocations);
	}
	public List <WebElement> getlvmListOfAllEventsTime() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmListOfAllEventsTime));
		return driver.findElements(lvmListOfAllEventsTime);
	}
	public List <WebElement> getlvmListOfAllEventsType() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmListOfAllEventsType));
		return driver.findElements(lvmListOfAllEventsType);
	}
	public List <WebElement> getlvmListOfAllEvents() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmListOfAllEvents));
		return driver.findElements(lvmListOfAllEvents);
	}
	public List <WebElement> getlvmListOfEventTitles() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmListOfEventTitles));
		return driver.findElements(lvmListOfEventTitles);
	}
	public WebElement getlvmExploreMarketTab() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmExploreMarketTab));
		return driver.findElement(lvmExploreMarketTab);
	}
	public WebElement getlvmResetBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmResetBtn));
		return driver.findElement(lvmResetBtn);
	}
	public List <WebElement> getlvmListOflvmSelectAnyDate() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmSelectAnyDate));
		return driver.findElements(lvmSelectAnyDate);
	}
	public WebElement getlvmCalendarPrevMonth() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmCalendarPrevMonth));
		return driver.findElement(lvmCalendarPrevMonth);
	}
	public WebElement getlvmTodaysDate() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmTodaysDate));
		return driver.findElement(lvmTodaysDate);
	}
	public WebElement getlvmSelectMonth() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmSelectMonth));
		return driver.findElement(lvmSelectMonth);
	}
	public List <WebElement> getlvmListOfEventDate() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmListOfEventDate));
		return driver.findElements(lvmListOfEventDate);
	}
	public WebElement getlvmCalendarNextMonthBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmCalendarNextMonthBtn));
		return driver.findElement(lvmCalendarNextMonthBtn);
	}
	public WebElement getlvmEventDateAndMonth() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmEventDateAndMonth));
		return driver.findElement(lvmEventDateAndMonth);
	}
	public WebElement getlvmEventSearchIcon() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmEventSearchIcon));
		return driver.findElement(lvmEventSearchIcon);
	}
	public WebElement getlvmEventName() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmEventName));
		return driver.findElement(lvmEventName);
	}
	public WebElement getlvmEventsSearchBar() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmEventsSearchBar));
		return driver.findElement(lvmEventsSearchBar);
	}
	public WebElement getlvmEventsCalendar() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmEventsCalendar));
		return driver.findElement(lvmEventsCalendar);
	}
	public WebElement getlvmImcEventsTab() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmImcEventsTab));
		return driver.findElement(lvmImcEventsTab);
	}

	public WebElement getlvmExhibitorsEventsTab() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(lvmExhibitorsEventsTab));
		return driver.findElement(lvmExhibitorsEventsTab);
	}
	public WebElement getlvmAttendTab() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmAttendTab));
		return driver.findElement(lvmAttendTab);
	}

	public WebElement getlvmEventsLink() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(lvmEventsLink));
		return driver.findElement(lvmEventsLink);
	}
	
	
}
