package atlantamarket_PROD;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AtlantaMarket.ATLEventsAndWebinarPage;
import pageObjects.AtlantaMarket.ATLExhDigiShowroomPage;
import pageObjects.AtlantaMarket.ATLExhLineProdActionsPage;
import pageObjects.AtlantaMarket.ATLFloorPlansPage;
import pageObjects.AtlantaMarket.ATLGlobalSearchPage;
import pageObjects.AtlantaMarket.ATLLandingPage;
import pageObjects.AtlantaMarket.ATLLoginPage;
import pageObjects.AtlantaMarket.ATLMarketPlannerPage;
import pageObjects.AtlantaMarket.ATLProductDetailsPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

public class EvenntsAndWebinar extends base{
	
	public WebDriverWait wait;
	public GenerateData genData;
	public Utility utl;
	public String exhname;
	ATLLoginPage lp;
	ATLLandingPage lap;
	ATLGlobalSearchPage atlgs;
	ATLExhDigiShowroomPage atlexhdgshw;
	ATLProductDetailsPage atlproddet;
	ATLExhLineProdActionsPage atlexhact;
	ATLMarketPlannerPage atlmppge;
	ATLFloorPlansPage atlflpp;
	ATLEventsAndWebinarPage atlevents;
	List<WebElement> exhlist, linelist, prodlist, searchexhtypelist, searchproducttypelist, mplists, mpeditlistoptns, allnoteslist,favlist, searchlinetypelist;


	@BeforeClass(alwaysRun=true)
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);

		// Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("atlmrkturl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		lap.getIUnderstandBtn().click();
		Thread.sleep(7000);

		//		lap.getCloseMarktAdBtn().click();
	}


	@Test(priority = 1)//groups="Non_MP"
	public void TS001_VerifyEventsAndWebinarsOverviewTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T283: Events and Webinars Overview
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp=new ATLFloorPlansPage(driver);
		atlevents=new ATLEventsAndWebinarPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
		//driver.get(prop.getProperty("atlmrkturl_prod"));
		//utl.loginCheckATL();
		utl.clickOnEventLinkOfChannel();
		Thread.sleep(2000);
		/*// Click on Attend Tab
		atlevents.getatlAttendTab().click();
		Thread.sleep(2000);
		//click on Events Link
		atlevents.getatlEventsLink().click();
		Thread.sleep(3000);*/
		//Verify ATL events page title
		Assert.assertTrue(atlgs.getatlShowSpecialsTitle().getText().contains("Events"));
		// Verify IMC tab
		Assert.assertTrue(atlevents.getatlImcEventsTab().getText().equals("Events"));
		
		
		System.out.println("IMC Event Tab is Present");
		// Verify Exhibitors Events tab
		Assert.assertTrue(atlevents.getatlExhibitorsEventsTab().getText().equals("Exhibitor Events"));
		System.out.println("Exhibitor Event Tab is Present");
		//Verify Events List
		try {
		Assert.assertTrue(!atlevents.getatlListOfAllEvents().isEmpty());
		System.out.println("Events list displayed");
		}
		catch(Exception e) {
			System.out.println("Events list not displayed");
			Assert.assertTrue(atlevents.getatlListOfAllEvents().isEmpty());
			
		}
		//Verify Calendar is displayed or not
		Assert.assertTrue(atlevents.getatlEventsCalendar().isDisplayed());
		System.out.println("Calendar is Present");
		//Verify Events Search Bar
		Assert.assertTrue(atlevents.getatlEventsSearchBar().isDisplayed());
		System.out.println("Events Search bar is Present");	
	}

	@Test(priority = 2)//groups="Non_MP"
	public void TS002_VerifyIMCEventsSearchbarTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T284: IMC Events: Search bar
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp=new ATLFloorPlansPage(driver);
		atlevents=new ATLEventsAndWebinarPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);

		driver.get(prop.getProperty("atlmrkturl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
		utl.clickOnEventLinkOfChannel();
		/*// Click on Attend Tab
		atlevents.getatlAttendTab().click();
		Thread.sleep(2000);
		//click on Events Link
		atlevents.getatlEventsLink().click();
		Thread.sleep(3000);*/
		//Click on IMC Event Tab
		utl.scrollToElement(atlevents.getatlExhibitorsEventsTab());
		atlevents.getatlImcEventsTab().click();
		Thread.sleep(500);
		//Click on Search Bar of IMC Events
		atlevents.getatlEventsSearchBar().click();
		Thread.sleep(500);
		String eventName=atlevents.getatlEventName().getText();
		//Enter Events Name into Search field
		atlevents.getatlEventsSearchBar().sendKeys(eventName);
		//Click on Search Icon
		atlevents.getatlEventSearchIcon().click();
		Thread.sleep(5000);
		//Verify Searched event dispayed as search result
		//Assert.assertEquals(atlevents.getatlEventName().getText(), eventName);
		utl.checkItemPresentInListorNot(atlevents.getatlListOfEventTitles(), eventName);
		
	}
	@Test(priority = 3)//groups="Non_MP"
	public void TS003_VerifyIMCEventsCalendarViewTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T288: IMC Events: Calendar View
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp=new ATLFloorPlansPage(driver);
		atlevents=new ATLEventsAndWebinarPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.get(prop.getProperty("atlmrkturl_prod"));
		Thread.sleep(5000);
        utl.clickOnEventLinkOfChannel();    
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on IMC Event Tab
		utl.scrollToElement(atlevents.getatlExhibitorsEventsTab());
		atlevents.getatlImcEventsTab().click();
		
		Thread.sleep(2000);
		//Event Month and Year
		String eventDateAndMonth=atlevents.getatlEventDateAndMonth().getText();
		String trimDate=eventDateAndMonth.split(" ")[2].trim();
		//System.out.println(trimDate);
		Thread.sleep(2000);
		String date=trimDate.replaceAll("[,]", "");
		String trimOnlyDate=date.split(" ")[0].trim();
		String replaceDate=trimOnlyDate.replaceFirst("^0+(?!$)", "");
		System.out.println(replaceDate);

		String trimMonth = eventDateAndMonth.split(" ")[1].trim();
		// System.out.println(trimMonth);
		String trimYear = eventDateAndMonth.split(" ")[3].trim();
		// System.out.println(trimYear);
		String EventmonthAndYear = trimMonth.concat(" ").concat(trimYear);
		// System.out.println("Concat Month And Year :: "+EventmonthAndYear);

		// Verify Current Date is Heighlighetd or not
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM");
		LocalDate localDate = LocalDate.now();
		String d = dtf.format(localDate);
		System.out.println("Current Date ::" + dtf.format(localDate));
		
		try {
		Assert.assertTrue(d.contains(atlevents.getatlTodaysDate().getText()));
		System.out.println("Current Date "+atlevents.getatlTodaysDate().getText()+" is Heighlighted");
		}catch (Exception e) {
			Assert.assertTrue(d.contains(atlevents.getatlTodaysDatePROD().getText()));
			System.out.println("Current Date "+atlevents.getatlTodaysDatePROD().getText()+" is Heighlighted");
		}
		
		//Current Month
		DateTimeFormatter month = DateTimeFormatter.ofPattern("MMM");
		LocalDate localMonth = LocalDate.now();
		LocalDate prevMonth= localMonth.minusMonths(1);		
				
		String m = month.format(localMonth);//current month
		String mm = month.format(prevMonth);//previous month

		System.out.println("Current Month ::" +m );
		System.out.println("Previous Month ::" +mm );
		
		//Click on Calendar Prev Btn
		atlevents.getatlCalendarPrevMonth().click();
		Thread.sleep(500);
		System.out.println("Previous Month From Calendar ::"+atlevents.getatlSelectMonth().getText());
		Assert.assertTrue(atlevents.getatlSelectMonth().getText().contains(mm));
		System.out.println("Previous Month "+atlevents.getatlSelectMonth().getText()+" is selected");
		//utl.selectFilters(atlevents.getatlListOfatlSelectAnyDate(), replaceDate);
		
			atlevents.getatlCalendarNextMonthBtn().click();
			Thread.sleep(5000);
		
			 if(atlevents.getatlSelectMonth().getText().contains(EventmonthAndYear))
			{
				 try {
					 	Assert.assertTrue(atlevents.getatlTodaysDatePROD().isDisplayed());
						atlevents.getatlTodaysDatePROD().click();
						Thread.sleep(500);
						}catch (Exception e) {
							utl.selectFilters(atlevents.getatlListOfEventDate(), replaceDate);
						
						}			 
			}
		
		// Verify Event is selected by datepicker
		Assert.assertTrue(atlevents.getatlEventDateAndMonth().isDisplayed());
		System.out.println("Event is selected by Date");

		//Click on Reset Btn
		atlevents.getatlResetBtn().click();
		Thread.sleep(500);
		//Verify Current date and month should selected by default
		try {
		Assert.assertTrue(d.contains(atlevents.getatlTodaysDate().getText()));
		System.out.println("By Default "+d +" today's date is selected.");
		}catch (Exception e) {
			Assert.assertTrue(d.contains(atlevents.getatlTodaysDatePROD().getText()));
			System.out.println("By Default "+d +" today's date is selected.");
		}
	}
	@Test(priority = 4)//groups="Non_MP"
	public void TS004_VerifyIMCEventsEventsListTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T292: IMC Events: Events List
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp=new ATLFloorPlansPage(driver);
		atlevents=new ATLEventsAndWebinarPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.get(prop.getProperty("atlmrkturl_prod"));
		Thread.sleep(5000);
		utl.clickOnEventLinkOfChannel();	
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on IMC Event Tab
        utl.scrollToElement(atlevents.getatlExhibitorsEventsTab());
		atlevents.getatlImcEventsTab().click();
		Thread.sleep(500);
		//Verify Event Calendar title
		Assert.assertTrue(atlevents.getatlEventDateAndMonth().isDisplayed());
		System.out.println("Event Calendar title is displayed");
		
		int allEventcount=0;
		for (WebElement allEvents : atlevents.getatlListOfAllEvents()) {
			allEventcount++;
			allEvents.isDisplayed();
		}
		System.out.println(allEventcount+ " Events Present");
		
		//Verify Events Titles
		int allEventTitlesCount=0;
		for (WebElement eventTitles : atlevents.getatlListOfEventTitles()) {
			allEventTitlesCount++;
			Assert.assertTrue(eventTitles.isDisplayed());
			String title=eventTitles.getText();
			List<WebElement>SeeAllLinks=driver.findElements(By.linkText(title));
			//Verify See Details HyperLinks
			utl.checkItemPresentInListorNot(SeeAllLinks, title);
		}
		System.out.println(allEventTitlesCount + " Titles displayed");
		Assert.assertEquals(allEventcount, allEventTitlesCount);
		
		// Verify Events Type
		int allEventTypeCount = 0;
		for (WebElement eventType : atlevents.getatlListOfAllEventsType()) {
			allEventTypeCount++;
			Assert.assertTrue(eventType.isDisplayed());
			System.out.println(allEventTypeCount + " Types displayed");
		}
		System.out.println(allEventTypeCount + " Types displayed");
		Assert.assertEquals(allEventcount, allEventTypeCount);

		// Verify Events Time
		int allEventTimeCount = 0;
		for (WebElement eventTime : atlevents.getatlListOfAllEventsTime()) {
			allEventTimeCount++;
			Assert.assertTrue(eventTime.isDisplayed());
		} 
		System.out.println(allEventTimeCount + " Time displayed");
		Assert.assertEquals(allEventcount, allEventTimeCount);

		// Verify Events Location
		int allEventLocationCount = 0;
		for (WebElement eventLocation : atlevents.getatlListOfAllEventsLocations()) {
			
			allEventLocationCount++;
			Assert.assertTrue(eventLocation.isDisplayed());
		}
		System.out.println(allEventLocationCount + " Location displayed");
		
		Assert.assertEquals(allEventcount, allEventLocationCount);
	
		// Verify Events Image
		int allEventImageCount = 0;
		for (WebElement eventImage : atlevents.atlListOfAllEventsImages()) {
			allEventImageCount++;
			Assert.assertTrue(eventImage.isDisplayed());
		}
		System.out.println(allEventImageCount + "  Images displayed");
		Assert.assertEquals(allEventcount, allEventImageCount);

		// Verify Events See Details Link
		int allEventSeeDetailsLinkCount = 0;
		for (WebElement eventSeeDetailsLink : atlevents.atlatlListOfAllEventsSeeDetailsLink()) {
			allEventSeeDetailsLinkCount++;
			Assert.assertTrue(eventSeeDetailsLink.isDisplayed());
		}
		System.out.println(allEventSeeDetailsLinkCount + " See Details Link displayed");
		Assert.assertEquals(allEventcount, allEventSeeDetailsLinkCount);

		// Click on Event Title page
		int allEventSeeDetailsLinkCount1 = 0;
		for( int i=0;i < atlevents.getatlListOfEventTitles().size(); i++) {
			allEventSeeDetailsLinkCount1++;
			WebElement eventTitleLink = atlevents.getatlListOfEventTitles().get(i);
			String eventTitle=eventTitleLink.getText();
			Assert.assertTrue(eventTitleLink.isDisplayed());
			//eventSeeDetailsLink = atlevents.atlatlListOfAllEventsSeeDetailsLink().get(1);
			utl.scrollToElement(eventTitleLink);
			eventTitleLink.click();
			Thread.sleep(500);
			//Verify Event Details Page
			Assert.assertTrue(eventTitle.contains(atlevents.getatlEventNameOnDetailsPage().getText()));
			Thread.sleep(3000);
			driver.navigate().back();
			Thread.sleep(3000);
		}
		
		System.out.println(allEventSeeDetailsLinkCount + " Events Details Page displayed");
		Assert.assertEquals(allEventcount, allEventSeeDetailsLinkCount1);
		

	}
	@Test(priority = 5)//groups="Non_MP"
	public void TS005_VerifyIMCEventsEventDetailstTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T295: IMC Events: Event Details
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp=new ATLFloorPlansPage(driver);
		atlevents=new ATLEventsAndWebinarPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.get(prop.getProperty("atlmrkturl_prod"));
		Thread.sleep(3000);
		utl.clickOnEventLinkOfChannel();	
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String eventTitle=atlevents.getatlClickOnEvent().getText();
		Thread.sleep(5000);
		//Click on IMC Event Tab
		utl.scrollToElement(atlevents.getatlExhibitorsEventsTab());
		atlevents.getatlImcEventsTab().click();
		Thread.sleep(500);
		//Click on Any Event title
		utl.scrollToElement(atlevents.getatlClickOnEvent());
		atlevents.getatlClickOnEvent().click();
		Thread.sleep(500);
		Assert.assertTrue(eventTitle.contains(atlevents.getatlEventNameOnDetailsPage().getText()));
		
		//Verify Location Link
		Assert.assertTrue(atlevents.getatlEventLocationLink().isDisplayed());
		System.out.println("Events Location link displayed");
		//Verify Event Type
		Assert.assertTrue(atlevents.getatlEventType().isDisplayed());
		System.out.println("Event Type displayed");
		//Verify Add Fav Icon
		/*Assert.assertTrue(atlevents.getatlFavIcon().isDisplayed());
		System.out.println("Add Fav Icon displayed");*/
		//Verify Add Fav Icon
		/*Assert.assertTrue(atlevents.getatlListIcon().isDisplayed());
		System.out.println("Add List Icon displayed");*/
		//Verify Add Fav Icon
		/*Assert.assertTrue(atlevents.getatlNoteIcon().isDisplayed());
		System.out.println("Add Note Icon displayed");*/
		//Verify Add to Calendar
		Assert.assertTrue(atlevents.getatlCalendarIcon().isDisplayed());
		System.out.println("Calendar displayed");
		//Verify Add Fav Icon
/*		Assert.assertTrue(atlevents.getatlTagIcon().isDisplayed());
		System.out.println("Tag displayed");*/
		
		//Click on Location link
		String locationURL=atlevents.getatlEventLocationLink().getAttribute("href");
		
		String currentWindowID=driver.getWindowHandle();
		atlevents.getatlEventLocationLink().click();
		Thread.sleep(500);
		for (String windowHandleID : driver.getWindowHandles()) {
			driver.switchTo().window(windowHandleID);
		}
		Thread.sleep(5000);
		//Verify Location floor plan page
		Assert.assertTrue(driver.getCurrentUrl().contains(locationURL));
		driver.close();
		driver.switchTo().window(currentWindowID);
		//driver.navigate().back();
		
		//Click on Tags
	/*	String searchResultPageURL=atlevents.getatlEventsTag().getAttribute("href");
		atlevents.getatlEventsTag().click();
		Assert.assertTrue(searchResultPageURL.contains(driver.getCurrentUrl()));
		Assert.assertTrue(atlevents.getatlSearchResultsTitle().getText().contains("Search Results"));
		System.out.println("Search Results page opened");*/
		driver.navigate().back();
		int allEventSeeDetailsLinkCount1 = 0;
		for (int i = 0; i < atlevents.getatlListOfEventTitles().size(); i++) {
			allEventSeeDetailsLinkCount1++;
			WebElement eventTitleLink = atlevents.getatlListOfEventTitles().get(i);
			utl.scrollToElement(eventTitleLink);
			eventTitleLink.click();
			// Verify Event Details Page
			
			Thread.sleep(2000);
			try {
				if(atlevents.getatlEventsTag().isDisplayed())
				{
					String searchResultPageURL=atlevents.getatlEventsTag().getAttribute("href");
					  atlevents.getatlEventsTag().click();
					  Thread.sleep(500);
					  Assert.assertTrue(searchResultPageURL.contains(driver.getCurrentUrl()));
					  Assert.assertTrue(atlevents.getatlSearchResultsTitle().getText().contains("Search"));
					  System.out.println("Search Results page opened");
					  break;
				}
				
			}catch(Exception e) {
				e.printStackTrace();
				driver.navigate().back();
				Thread.sleep(2000);
				//Click on Exh Event Tab
				//atlevents.getatlExhibitorsEventsTab().click();
				/*System.out.println(i);
				System.out.println(atlevents.getatlListOfEventTitles().size());*/
				if(atlevents.getatlListOfEventTitles().size() == i+1)
				{
					System.out.println("Tags are not present");
					//Assert.assertTrue(i== atlevents.getatlListOfEventTitles().size());
				}
			}
			
		}
		
	}




	@Test(priority = 6)//groups="Non_MP"
	public void TS006_VerifyExhibitorEventsSearchbarTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T304: Exhibitor Events: Search bar
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp=new ATLFloorPlansPage(driver);
		atlevents=new ATLEventsAndWebinarPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);

		driver.get(prop.getProperty("atlmrkturl_prod"));
        Thread.sleep(5000);
		utl.clickOnEventLinkOfChannel();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		/*// Click on Attend Tab
		atlevents.getatlAttendTab().click();
		Thread.sleep(2000);
		//click on Events Link
		atlevents.getatlEventsLink().click();
		Thread.sleep(3000);*/
		//Click on Exh Event Tab
        utl.scrollToElement(atlevents.getatlExhibitorsEventsTab());
		atlevents.getatlExhibitorsEventsTab().click();
		Thread.sleep(500);
		//Click on Search Bar of IMC Events
		atlevents.getatlEventsSearchBar().click();
		Thread.sleep(500);
		String eventName=atlevents.getatlEventName().getText();
		//Enter Events Name into Search field
		atlevents.getatlEventsSearchBar().sendKeys(eventName);
		//Click on Search Icon
		atlevents.getatlEventSearchIcon().click();
		Thread.sleep(5000);
		//Verify Searched event dispayed as search result
		//Assert.assertEquals(atlevents.getatlEventName().getText(), eventName);
		utl.checkItemPresentInListorNot(atlevents.getatlListOfEventTitles(), eventName);
}
	@Test(priority = 7)//groups="Non_MP"
	public void TS007_VerifyExhibitorEventsCalendarViewTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T305: Exhibitor Events: Calendar View
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp=new ATLFloorPlansPage(driver);
		atlevents=new ATLEventsAndWebinarPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.get(prop.getProperty("atlmrkturl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
		utl.clickOnEventLinkOfChannel();  
		
		//Click on Exh Event Tab
		utl.scrollToElement(atlevents.getatlExhibitorsEventsTab());
		atlevents.getatlExhibitorsEventsTab().click();
		
		Thread.sleep(2000);
		//Event Month and Year
		String eventDateAndMonth=atlevents.getatlEventDateAndMonth().getText();
		String trimDate=eventDateAndMonth.split(" ")[2].trim();
		//System.out.println(trimDate);
		Thread.sleep(2000);
		String date=trimDate.replaceAll("[,]", "");
		String trimOnlyDate=date.split(" ")[0].trim();
		String replaceDate=trimOnlyDate.replaceFirst("^0+(?!$)", "");
		System.out.println(replaceDate);

		String trimMonth = eventDateAndMonth.split(" ")[1].trim();
		// System.out.println(trimMonth);
		String trimYear = eventDateAndMonth.split(" ")[3].trim();
		// System.out.println(trimYear);
		String EventmonthAndYear = trimMonth.concat(" ").concat(trimYear);
		// System.out.println("Concat Month And Year :: "+EventmonthAndYear);

		// Verify Current Date is Heighlighetd or not
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM");
		LocalDate localDate = LocalDate.now();
		String d = dtf.format(localDate);
		System.out.println("Current Date ::" + dtf.format(localDate));
		try {
			Assert.assertTrue(d.contains(atlevents.getatlTodaysDate().getText()));
			System.out.println("Current Date "+atlevents.getatlTodaysDate().getText()+" is Heighlighted");
			}catch (Exception e) {
				Assert.assertTrue(d.contains(atlevents.getatlTodaysDatePROD().getText()));
				System.out.println("Current Date "+atlevents.getatlTodaysDatePROD().getText()+" is Heighlighted");
			}
		//Current Month
		DateTimeFormatter month = DateTimeFormatter.ofPattern("MMM");
		LocalDate localMonth = LocalDate.now();
		LocalDate prevMonth= localMonth.minusMonths(1);		
				
		String m = month.format(localMonth);//current month
		String mm = month.format(prevMonth);//previous month
		
	
		System.out.println("Current Month ::" +m );
		System.out.println("Previous Month ::" +mm );
		
		//Click on Calendar Prev Btn
		atlevents.getatlCalendarPrevMonth().click();
		Thread.sleep(500);
		System.out.println("Previous Month From Calendar ::"+atlevents.getatlSelectMonth().getText());
		Assert.assertTrue(atlevents.getatlSelectMonth().getText().contains(mm));
		System.out.println("Previous Month "+atlevents.getatlSelectMonth().getText()+" is selected");
		//utl.selectFilters(atlevents.getatlListOfatlSelectAnyDate(), replaceDate);
		
		
		atlevents.getatlCalendarNextMonthBtn().click();
		Thread.sleep(5000);
	
		 if(atlevents.getatlSelectMonth().getText().contains(EventmonthAndYear))
		{
			 try {
				 	Assert.assertTrue(atlevents.getatlTodaysDatePROD().isDisplayed());
					atlevents.getatlTodaysDatePROD().click();
					Thread.sleep(500);
					}catch (Exception e) {
						utl.selectFilters(atlevents.getatlListOfEventDate(), replaceDate);
					
					}			 
		}
		// Verify Event is selected by datepicker
		Assert.assertTrue(atlevents.getatlEventDateAndMonth().isDisplayed());
		System.out.println("Event is selected by Date");

		//Click on Reset Btn
		atlevents.getatlResetBtn().click();
		Thread.sleep(500);
		//Verify Current date and month should selected by default
		try {
			Assert.assertTrue(d.contains(atlevents.getatlTodaysDate().getText()));
			System.out.println("By Default "+d +" today's date is selected.");
			}catch (Exception e) {
				Assert.assertTrue(d.contains(atlevents.getatlTodaysDatePROD().getText()));
				System.out.println("By Default "+d +" today's date is selected.");
			}
		Thread.sleep(5000);
	}
	
	@Test(priority = 8)//Previous priority = 11,groups="Non_MP"
	public void TS008_VerifyExhibitorEventsListTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T306: Exhibitor Events: Events List
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp=new ATLFloorPlansPage(driver);
		atlevents=new ATLEventsAndWebinarPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.get(prop.getProperty("atlmrkturl_prod"));
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		utl.clickOnEventLinkOfChannel();  
		
		//Click on Exh Event Tab
		Thread.sleep(15000);
		utl.scrollToElement(atlevents.getatlExhibitorsEventsTab());
		atlevents.getatlExhibitorsEventsTab().click();
		Thread.sleep(3000);
		
		//Verify Event Calendar title
		Assert.assertTrue(atlevents.getatlEventDateAndMonth().isDisplayed());
		System.out.println("Event Calendar title is displayed");
		
		int allEventcount=0;
		for (WebElement allEvents : atlevents.getatlListOfAllEvents()) {
			allEventcount++;
			allEvents.isDisplayed();
		}
		System.out.println(allEventcount+ " Events Present");
		
		//Verify Events Titles
		int allEventTitlesCount=0;
		for (WebElement eventTitles : atlevents.getatlListOfEventTitles()) {
			allEventTitlesCount++;
			Assert.assertTrue(eventTitles.isDisplayed());
			String title=eventTitles.getText();
			List<WebElement>SeeAllLinks=driver.findElements(By.linkText(title));
			//Verify See Details HyperLinks
			utl.checkItemPresentInListorNot(SeeAllLinks, title);
		}
		System.out.println(allEventTitlesCount + " Titles displayed");
		Assert.assertEquals(allEventcount, allEventTitlesCount);
		

		// Verify Events Type
		int allEventTypeCount = 0;
		for (WebElement eventType : atlevents.getatlListOfAllEventsType()) {
			allEventTypeCount++;
			Assert.assertTrue(eventType.isDisplayed());
		}
		System.out.println(allEventTypeCount + " Types displayed");
		Assert.assertEquals(allEventcount, allEventTypeCount);

		// Verify Events Time
		int allEventTimeCount = 0;
		for (WebElement eventTime : atlevents.getatlListOfAllEventsTime()) {
			allEventTimeCount++;
			Assert.assertTrue(eventTime.isDisplayed());
		} 
		System.out.println(allEventTimeCount + " Time displayed");
		Assert.assertEquals(allEventcount, allEventTimeCount);

		// Verify Events Location
		int allEventLocationCount = 0;
		for (WebElement eventLocation : atlevents.getatlListOfAllEventsLocations()) {
			allEventLocationCount++;
			Assert.assertTrue(eventLocation.isDisplayed());
		}
		System.out.println(allEventLocationCount + " Location displayed");
		Assert.assertEquals(allEventcount, allEventLocationCount);
	
		// Verify Events Image
		int allEventImageCount = 0;
		for (WebElement eventImage : atlevents.atlListOfAllEventsImages()) {
			allEventImageCount++;
			Assert.assertTrue(eventImage.isDisplayed());
		}
		System.out.println(allEventImageCount + "  Images displayed");
		Assert.assertEquals(allEventcount, allEventImageCount);

		// Verify Events See Details Link
		int allEventSeeDetailsLinkCount = 0;
		for (WebElement eventSeeDetailsLink : atlevents.atlatlListOfAllEventsSeeDetailsLink()) {
			allEventSeeDetailsLinkCount++;
			Assert.assertTrue(eventSeeDetailsLink.isDisplayed());
		}
		System.out.println(allEventSeeDetailsLinkCount + " See Details Link displayed");
		Assert.assertEquals(allEventcount, allEventSeeDetailsLinkCount);
		Thread.sleep(5000);
		//driver.navigate().refresh();

		// Click on Event Title page
		int allEventSeeDetailsLinkCount1 = 0;
		for( int i=0;i < atlevents.getatlListOfEventTitles().size(); i++) {
			allEventSeeDetailsLinkCount1++;
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//Thread.sleep(5000);
			WebElement eventTitleLink = atlevents.getatlListOfEventTitles().get(i);
			String eventTitle=eventTitleLink.getText();
			Assert.assertTrue(eventTitleLink.isDisplayed());
			//eventSeeDetailsLink = atlevents.atlatlListOfAllEventsSeeDetailsLink().get(1);
			//WebDriverWait wait = new WebDriverWait(driver,30);//new added
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("eventTitleLink")));
			utl.scrollToElement(eventTitleLink);
			eventTitleLink.click();
			
			Thread.sleep(15000);
			driver.navigate().refresh();
			//Verify Event Details Page
			Assert.assertTrue(eventTitle.contains(atlevents.getatlEventNameOnDetailsPage().getText()));
			driver.navigate().back();
			
			//Thread.sleep(5000);
			//Click on Exh Event Tab
			utl.scrollToElement(atlevents.getatlExhibitorsEventsTab());
			atlevents.getatlExhibitorsEventsTab().click();
			Thread.sleep(2000);
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		System.out.println(allEventSeeDetailsLinkCount + " Events Details Page displayed");
		Assert.assertEquals(allEventcount, allEventSeeDetailsLinkCount1);
}
	@Test(priority = 9)//groups="Non_MP"
	public void TS009_VerifyExhibitorEventsDetailstTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T307: Exhibitor Events: Event Details
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp=new ATLFloorPlansPage(driver);
		atlevents=new ATLEventsAndWebinarPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.get(prop.getProperty("atlmrkturl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
		utl.clickOnEventLinkOfChannel();  
		Thread.sleep(2000);
		
		//Click on Exh Event Tab
		utl.scrollToElement(atlevents.getatlExhibitorsEventsTab());
		atlevents.getatlExhibitorsEventsTab().click();
		Thread.sleep(500);
		//Click on IMC Event Tab
		//atlevents.getatlImcEventsTab().click();
		String eventTitle=atlevents.getatlClickOnEvent().getText();
		utl.scrollToElement(atlevents.getatlClickOnEvent());
		atlevents.getatlClickOnEvent().click();
		Thread.sleep(500);
		Assert.assertTrue(eventTitle.contains(atlevents.getatlEventNameOnDetailsPage().getText()));
		
		//Verify Location Link
		Assert.assertTrue(atlevents.getatlEventLocationLink().isDisplayed());
		System.out.println("Events Location link displayed");
		//Verify Event Type
		Assert.assertTrue(atlevents.getatlEventType().isDisplayed());
		System.out.println("Event Type displayed");
		//Verify Add Fav Icon
/*		Assert.assertTrue(atlevents.getatlFavIcon().isDisplayed());
		System.out.println("Add Fav Icon displayed");
		//Verify Add Fav Icon
		Assert.assertTrue(atlevents.getatlListIcon().isDisplayed());
		System.out.println("Add List Icon displayed");
		//Verify Add Fav Icon
		Assert.assertTrue(atlevents.getatlNoteIcon().isDisplayed());
		System.out.println("Add Note Icon displayed");*/
		//Verify Add Fav Icon
		/*Assert.assertTrue(atlevents.getatlCalendarIcon().isDisplayed());
		System.out.println("Calendar displayed");*/
		//Verify Add Fav Icon
		/*Assert.assertTrue(atlevents.getatlTagIcon().isDisplayed());
		System.out.println("Tag displayed");*/
		
		//Click on Location link
		String locationURL=atlevents.getatlEventLocationLink().getAttribute("href");
		
		String currentWindowID = driver.getWindowHandle();
		atlevents.getatlEventLocationLink().click();
		for (String windowHandleID : driver.getWindowHandles()) {
			driver.switchTo().window(windowHandleID);
		}
		Thread.sleep(5000);
		// Verify Location floor plan page
		Assert.assertTrue(driver.getCurrentUrl().contains(locationURL));
		driver.close();
		driver.switchTo().window(currentWindowID);
		driver.navigate().back();

		
/*		  //Click on Tags String
		  searchResultPageURL=atlevents.getatlEventsTag().getAttribute("href");
		  atlevents.getatlEventsTag().click();
		  Assert.assertTrue(searchResultPageURL.contains(driver.getCurrentUrl()));
		  Assert.assertTrue(atlevents.getatlSearchResultsTitle().getText().
		  contains("Search Results"));
		  System.out.println("Search Results page opened");
		 */

		// Click on Event Title page
		
		//driver.navigate().back();
		//Click on Exh Event Tab
		//atlevents.getatlExhibitorsEventsTab().click();
	/*	
		int allEventSeeDetailsLinkCount1 = 0;
		for (int i = 0; i < atlevents.getatlListOfEventTitles().size(); i++) {
			allEventSeeDetailsLinkCount1++;
			WebElement eventTitleLink = atlevents.getatlListOfEventTitles().get(i);
		
			// eventSeeDetailsLink = atlevents.atlatlListOfAllEventsSeeDetailsLink().get(1);
			eventTitleLink.click();
			// Verify Event Details Page
			//Assert.assertTrue(eventTitle.contains(atlevents.getatlEventNameOnDetailsPage().getText()));
			Thread.sleep(2000);
			try {
				if(atlevents.getatlEventsTag().isDisplayed())
				{
					String searchResultPageURL=atlevents.getatlEventsTag().getAttribute("href");
					  atlevents.getatlEventsTag().click();
					  Assert.assertTrue(searchResultPageURL.contains(driver.getCurrentUrl()));
					  Assert.assertTrue(atlevents.getatlSearchResultsTitle().getText().contains("Search Results"));
					  System.out.println("Search Results page opened");
					  break;
				}
				
			}catch(Exception e) {
				e.printStackTrace();
				driver.navigate().back();
				Thread.sleep(2000);
				//Click on Exh Event Tab
				//atlevents.getatlExhibitorsEventsTab().click();
				System.out.println(i);
				System.out.println(atlevents.getatlListOfEventTitles().size());
				if(atlevents.getatlListOfEventTitles().size() == i+1)
				{
					System.out.println("Tags are not present");
					Assert.assertTrue(i== atlevents.getatlListOfEventTitles().size());
				}
			}
			
		}*/
		
	}	

    @Test(enabled=false)
    public void verifyMPLoginFunctionality() throws IOException, InterruptedException {

        // The purpose of this test case to verify:-
        // TS1- Login to Market Planner

        lap = new ATLLandingPage(driver);
        lp = new ATLLoginPage(driver);

        // Click on Login button from Landing Page
        lap.getLogin().click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // Enter the credentials on Login Page and click
        lp.getEmailAddress().sendKeys((prop.getProperty("username")));

        lp.getPassword().sendKeys((prop.getProperty("passwordW")));


        Thread.sleep(1000);
    //  lp.getPassword().sendKeys((prop.getProperty("password")));
        Thread.sleep(1000);

        lp.getSignInBtn().click();
        Thread.sleep(15000);
        Assert.assertTrue(driver.getTitle().contains("Atlanta Market at AmericasMart"));
    }

    @Test(enabled=false)//priority = 6,groups= "MP_Group",dependsOnMethods= "verifyMPLoginFunctionality"
    public void TS010_VerifyIMCEventsAddToFavoriteTest() throws InterruptedException, IOException {
        // The purpose of this test case to verify:-
        // UXP-T296: IMC Events: Event Details- Add To Favorite
        lap = new ATLLandingPage(driver);
        lp = new ATLLoginPage(driver);
        utl = new Utility(driver);
        atlflpp = new ATLFloorPlansPage(driver);
        atlevents = new ATLEventsAndWebinarPage(driver);
        atlgs = new ATLGlobalSearchPage(driver);
        atlmppge = new ATLMarketPlannerPage(driver);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Login to MP
        ////utl.verifyMPLoginFunctionality();
        utl.loginCheckATL();
        
        utl.clickOnEventLinkOfChannel();

        String eventTitle = atlevents.getatlClickOnEvent().getText();

        // Click on IMC Event Tab
        atlevents.getatlImcEventsTab().click();
        // Click on Any Event title

        atlevents.getatlClickOnEvent().click();

        Assert.assertTrue(eventTitle.contains(atlevents.getatlEventNameOnDetailsPage().getText()));

        // Click on Fav Icon

        atlevents.getatlFavIcon().click();

        // Click on Market Planner link
        lap.getMPLinkText().click();

        // Click on Lists tab on MP home page
        atlmppge.getMPHomeListsTab().click();
        atlmppge.getATLMPListsPageFavoritesMenu().click();

        // Verify that the added favorites event should be displayed in to Favorites
        // list
        Assert.assertTrue(atlmppge.getATLSavedExhNameInList().getText().contains(eventTitle));

        // Delete that favorites exhibitor from list
        atlmppge.getATLEditListItemMoreBtn().click();
        atlmppge.getATLEditListItemDeleteOptn().click();
        Thread.sleep(6000);

        // Verify that the added favorites exhibitor should be removed from Favorites
        // list
        Assert.assertFalse(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));

    }

    @Test(enabled=false)//priority = 8,groups= "MP_Group",dependsOnMethods= "verifyMPLoginFunctionality"
    public void TS011_VerifyIMCEventsAddNoteTest() throws InterruptedException, IOException {
        // The purpose of this test case to verify:-
        // UXP-T299: IMC Events: Event Details- Add Note
        lap = new ATLLandingPage(driver);
        lp = new ATLLoginPage(driver);
        utl = new Utility(driver);
        atlflpp = new ATLFloorPlansPage(driver);
        atlevents = new ATLEventsAndWebinarPage(driver);
        atlgs = new ATLGlobalSearchPage(driver);
        atlmppge = new ATLMarketPlannerPage(driver);
        genData = new GenerateData();
        atlexhact = new ATLExhLineProdActionsPage(driver);
        atlproddet = new ATLProductDetailsPage(driver);
/*
        // Login to MP
        
         //utl.verifyMPLoginFunctionality(); Thread.sleep(5000);*/
         
        utl.clickOnEventLinkOfChannel();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
        String eventTitle = atlevents.getatlClickOnEvent().getText();

        // Click on IMC Event Tab
        atlevents.getatlImcEventsTab().click();
        // Click on Any Event title

        atlevents.getatlClickOnEvent().click();

        Assert.assertTrue(eventTitle.contains(atlevents.getatlEventNameOnDetailsPage().getText()));

        // Click on Add to List Icon

        atlevents.getatlNoteIcon().click();
        
        /*Thread.sleep(5000);
        lp.getEmailAddress().sendKeys((prop.getProperty("username")));
        lp.getPassword().sendKeys((prop.getProperty("password")));

        lp.getSignInBtn().click();
        atlevents.getatlNoteIcon().click();*/
        // Store the new note name
        String newnotetitle = "CybNote" + genData.generateRandomString(3);
        System.out.println("Newly added Note is: " + newnotetitle);

        // Enter Note title
        WebElement noteTitleTxt=atlexhact.getNoteTitleTxtBx();
        noteTitleTxt.sendKeys(newnotetitle);
        Thread.sleep(5000);
        // Enter Note Content
        String noteContent="TestProdNote" + genData.generateRandomString(6);
        WebElement noteContentTxt=atlexhact.getNoteContentTxtBx();
        noteContentTxt.sendKeys(noteContent);
        Thread.sleep(5000);
        noteTitleTxt.sendKeys(newnotetitle);
        Thread.sleep(5000);
        //atlexhact.getNoteTitleTxtBx().sendKeys(newnotetitle);
        // Click on 'Save' button
        atlexhact.getNoteSaveBtn().click();
        Thread.sleep(5000);

        // Click on 'Add Note' icon for the same exhibitor
        atlproddet.getProductAddNoteIcon().click();
        Thread.sleep(4000);

        // Click on 'View all Notes for an Exhibitor' link on Add Notes pop-up
        atlexhact.getViewAllNotesLink().click();
        Thread.sleep(5000);

        allnoteslist = atlexhact.getSavedNoteNameInAllNotesList();

        // Verify that recently added note should be appear on 'All Notes For Exhibitor' modal
        for (int i = 0; i < allnoteslist.size(); i++) {
            //System.out.println(allnoteslist.get(i).getText());
            if (allnoteslist.get(i).getText().equals(newnotetitle)) {
                allnoteslist.get(i).click();

                break;
            }
        }

        // Delete the saved note
        atlexhact.getDeleteNoteBtn().click();
    }
 
    @Test(enabled=false)//priority = 13,groups= "MP_Group",dependsOnMethods= "verifyMPLoginFunctionality"
    public void TS012_VerifyExhibitorEventsAddToFavoriteTest() throws InterruptedException, IOException {
        // The purpose of this test case to verify:-
        // UXP-T308: Exhibitor Events: Event Details- Add To Favorite
        lap = new ATLLandingPage(driver);
        lp = new ATLLoginPage(driver);
        utl = new Utility(driver);
        atlflpp = new ATLFloorPlansPage(driver);
        atlevents = new ATLEventsAndWebinarPage(driver);
        atlgs = new ATLGlobalSearchPage(driver);
        atlmppge = new ATLMarketPlannerPage(driver);

        
        //Login to MP
        ////utl.verifyMPLoginFunctionality();
        
        utl.clickOnEventLinkOfChannel();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String eventTitle = atlevents.getatlClickOnEvent().getText();

        /*// Click on IMC Event Tab
        atlevents.getatlImcEventsTab().click();*/
        //Click on Exh Event Tab
                atlevents.getatlExhibitorsEventsTab().click();
        // Click on Any Event title

        atlevents.getatlClickOnEvent().click();

        //Assert.assertTrue(eventTitle.contains(atlevents.getatlEventNameOnDetailsPage().getText()));

        // Click on Fav Icon

        atlevents.getatlFavIcon().click();

        // Click on Market Planner link
        lap.getMPLinkText().click();

        // Click on Lists tab on MP home page
        atlmppge.getMPHomeListsTab().click();
        atlmppge.getATLMPListsPageFavoritesMenu().click();

        // Verify that the added favorites event should be displayed in to Favorites
        // list
        Assert.assertTrue(atlmppge.getATLSavedExhNameInList().getText().contains(eventTitle));

        // Delete that favorites exhibitor from list
        atlmppge.getATLEditListItemMoreBtn().click();
        atlmppge.getATLEditListItemDeleteOptn().click();
        Thread.sleep(6000);

        // Verify that the added favorites exhibitor should be removed from Favorites
        // list
        Assert.assertFalse(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));

    }

    @Test(enabled=false)//priority = 14,groups= "MP_Group",dependsOnMethods= "verifyMPLoginFunctionality"
    public void TS013_VerifyExhibitorEventsAddToListTest() throws InterruptedException, IOException {
        // The purpose of this test case to verify:-
        // UXP-T309: Exhibitor Events: Event Details- Add To List
        lap = new ATLLandingPage(driver);
        lp = new ATLLoginPage(driver);
        utl = new Utility(driver);
        atlflpp = new ATLFloorPlansPage(driver);
        atlevents = new ATLEventsAndWebinarPage(driver);
        atlgs = new ATLGlobalSearchPage(driver);
        atlmppge = new ATLMarketPlannerPage(driver);


        // Login to MP
        ////utl.verifyMPLoginFunctionality();
        Thread.sleep(5000);
    
        
        utl.clickOnEventLinkOfChannel();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String eventTitle = atlevents.getatlClickOnEvent().getText();
        //Click on Exh Event Tab
        atlevents.getatlExhibitorsEventsTab().click();
        /*// Click on IMC Event Tab
        atlevents.getatlImcEventsTab().click();*/
        // Click on Any Event title

        atlevents.getatlClickOnEvent().click();

        //Assert.assertTrue(eventTitle.contains(atlevents.getatlEventNameOnDetailsPage().getText()));

        // Click on Add to List Icon

        atlevents.getatlListIcon().click();
        Thread.sleep(5000);
        lp.getEmailAddress().sendKeys((prop.getProperty("usernameSwapnil")));
        lp.getPassword().sendKeys((prop.getProperty("passwordSwapnil")));

        lp.getSignInBtn().click();
        atlevents.getatlListIcon().click();
        // Store the existing list name
        String existinglistname = atlmppge.getATLMPExistingListName().getText();
        System.out.println("Existing list name: " + existinglistname);

        // Select Existing list name
        atlmppge.getATLMPExistingListName().click();
        Thread.sleep(2000);

        // Scroll till Add to Selected button
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                atlevents.getatladdtoseselectedbtn());
        Thread.sleep(2000);
        atlevents.getatladdtoseselectedbtn().click();
        //atlmppge.getATLMPAddToSelectedBtn().click();
        Thread.sleep(2000);
        // Click on Go to Market Planner button
        atlmppge.getGoToMarketPlannerBtn().click();

        // Click on Lists tab on MP home page
        atlmppge.getMPHomeListsTab().click();
        atlmppge.getListsPageListsMenu().click();

        mplists = atlmppge.getATLMPListsNames();
        mpeditlistoptns = atlmppge.getATLMPEditListOptns();

        for (int i = 0; i < mplists.size(); i++) {
            //System.out.println(mplists.get(i).getText());
            // System.out.println(mpeditlistoptns.get(i).getText());
            if (mplists.get(i).getText().equals(existinglistname)) {
                mpeditlistoptns.get(i).click();
                break;
            }
        }
        Thread.sleep(5000);
        Assert.assertTrue(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));

        // Delete that added line from list
        atlmppge.getATLEditListItemMoreBtn().click();
        atlmppge.getATLEditListItemDeleteOptn().click();
        Thread.sleep(8000);

    }

    @Test(enabled=false)//priority = 15,groups= "MP_Group",dependsOnMethods= "verifyMPLoginFunctionality"
    public void TS014_VerifyExhibitorEventsAddNoteTest() throws InterruptedException, IOException {
        // The purpose of this test case to verify:-
        // UXP-T310: Exhibitor Events: Event Details- Add Note
        lap = new ATLLandingPage(driver);
        lp = new ATLLoginPage(driver);
        utl = new Utility(driver);
        atlflpp = new ATLFloorPlansPage(driver);
        atlevents = new ATLEventsAndWebinarPage(driver);
        atlgs = new ATLGlobalSearchPage(driver);
        atlmppge = new ATLMarketPlannerPage(driver);
        genData = new GenerateData();
        atlexhact = new ATLExhLineProdActionsPage(driver);
        atlproddet = new ATLProductDetailsPage(driver);

        // Login to MP
        
    //  //utl.verifyMPLoginFunctionality(); Thread.sleep(5000);
        Thread.sleep(5000); 
        utl.clickOnEventLinkOfChannel();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //String eventTitle = atlevents.getatlClickOnEvent().getText();

        //Click on Exh Event Tab
                atlevents.getatlExhibitorsEventsTab().click();
                String eventTitle = atlevents.getatlClickOnEvent().getText();
        /*// Click on IMC Event Tab
        atlevents.getatlImcEventsTab().click();*/
        // Click on Any Event title

        atlevents.getatlClickOnEvent().click();

        //Assert.assertTrue(eventTitle.contains(atlevents.getatlEventNameOnDetailsPage().getText()));

        // Click on Add to List Icon

        atlevents.getatlNoteIcon().click();
        
        /*Thread.sleep(5000);
        lp.getEmailAddress().sendKeys((prop.getProperty("username")));
        lp.getPassword().sendKeys((prop.getProperty("password")));

        lp.getSignInBtn().click();
        atlevents.getatlNoteIcon().click();*/
        // Store the new note name
        String newnotetitle = "CybNote" + genData.generateRandomString(3);
        System.out.println("Newly added Note is: " + newnotetitle);

        // Enter Note title
        WebElement noteTitleTxt=atlexhact.getNoteTitleTxtBx();
        noteTitleTxt.sendKeys(newnotetitle);
        Thread.sleep(5000);
        // Enter Note Content
        String noteContent="TestProdNote" + genData.generateRandomString(6);
        WebElement noteContentTxt=atlexhact.getNoteContentTxtBx();
        noteContentTxt.sendKeys(noteContent);
        Thread.sleep(5000);
        noteTitleTxt.sendKeys(newnotetitle);
        Thread.sleep(5000);
        //atlexhact.getNoteTitleTxtBx().sendKeys(newnotetitle);
        // Click on 'Save' button
        atlexhact.getNoteSaveBtn().click();
        Thread.sleep(5000);

        // Click on 'Add Note' icon for the same exhibitor
        atlproddet.getProductAddNoteIcon().click();
        Thread.sleep(4000);

        // Click on 'View all Notes for an Exhibitor' link on Add Notes pop-up
        atlexhact.getViewAllNotesLink().click();
        Thread.sleep(5000);

        allnoteslist = atlexhact.getSavedNoteNameInAllNotesList();

        // Verify that recently added note should be appear on 'All Notes For Exhibitor' modal
        for (int i = 0; i < allnoteslist.size(); i++) {
            //System.out.println(allnoteslist.get(i).getText());
            if (allnoteslist.get(i).getText().equals(newnotetitle)) {
                allnoteslist.get(i).click();

                break;
            }
        }

        // Delete the saved note
        atlexhact.getDeleteNoteBtn().click();
    }

    @Test(enabled=false)//priority = 16,groups= "MP_Group",dependsOnMethods= "verifyMPLoginFunctionality"
    public void TS015_VerifyIMCEventsAddToListTest() throws InterruptedException, IOException {
        // The purpose of this test case to verify:-
        // UXP-T298: IMC Events: Event Details- Add To List
        lap = new ATLLandingPage(driver);
        lp = new ATLLoginPage(driver);
        utl = new Utility(driver);
        atlflpp = new ATLFloorPlansPage(driver);
        atlevents = new ATLEventsAndWebinarPage(driver);
        atlgs = new ATLGlobalSearchPage(driver);
        atlmppge = new ATLMarketPlannerPage(driver);

        // Login to MP
        /*      //utl.verifyMPLoginFunctionality();
                Thread.sleep(5000);*/
        utl.clickOnEventLinkOfChannel();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        String eventTitle = atlevents.getatlClickOnEvent().getText();
        System.out.println("Event Name :: "+eventTitle);

        // Click on IMC Event Tab
        atlevents.getatlImcEventsTab().click();
        // Click on Any Event title

        atlevents.getatlClickOnEvent().click();
        Assert.assertTrue(eventTitle.contains(atlevents.getatlEventNameOnDetailsPage().getText()));

        // Click on Add to List Icon

        atlevents.getatlListIcon().click();
        // Store the existing list name
        String existinglistname = atlmppge.getATLMPExistingListName().getText();
        System.out.println("Existing list name: " + existinglistname);

        // Select Existing list name
        atlmppge.getATLMPExistingListName().click();
        Thread.sleep(2000);

        // Scroll till Add to Selected button
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                atlevents.getatladdtoseselectedbtn());
        Thread.sleep(2000);
        atlevents.getatladdtoseselectedbtn().click();
        //atlmppge.getATLMPAddToSelectedBtn().click();
        Thread.sleep(2000);
        // Click on Go to Market Planner button
        //utl.clickOnEventLinkOfChannel();

        // Click on Go to Market Planner button
        atlmppge.getGoToMarketPlannerBtn().click();
        // Click on Lists tab on MP home page
        atlmppge.getMPHomeListsTab().click();
        atlmppge.getListsPageListsMenu().click();
        mplists = atlmppge.getATLMPListsNames();
        mpeditlistoptns = atlmppge.getATLMPEditListOptns();

        for (int i = 0; i < mplists.size(); i++) {
            System.out.println(mplists.get(i).getText());
            // System.out.println(mpeditlistoptns.get(i).getText());
            if (mplists.get(i).getText().equals(existinglistname)) {
                mpeditlistoptns.get(i).click();
                break;
            }
        }
        Thread.sleep(8000);
        
        Assert.assertTrue(atlmppge.getATLSavedExhNameInList().getText().contains(eventTitle));

/*      // Delete that added line from list
        atlmppge.getATLEditListItemMoreBtn().click();
        atlmppge.getATLEditListItemDeleteOptn().click();
        Thread.sleep(8000);*/
        // Delete that added exhibitor from list
                atlmppge.getmoreOptionUAT_LVM().click();
                atlmppge.getmoreEventOptionDeleteBtnUAT_LVM().click();
                Thread.sleep(8000);
    }

      @AfterClass(alwaysRun=true)
      public void tearDown(){
      	   // driver.quit();
      }

}
