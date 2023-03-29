package lasvegasmarket_PROD;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.AtlantaMarket.ATLExhDigiShowroomPage;
import pageObjects.AtlantaMarket.ATLExhLineProdActionsPage;
import pageObjects.AtlantaMarket.ATLGlobalSearchPage;
import pageObjects.AtlantaMarket.ATLMarketPlannerPage;
import pageObjects.AtlantaMarket.ATLProductDetailsPage;
import pageObjects.LasVegasMarket.LVMEventsAndWebinarPage;
import pageObjects.LasVegasMarket.LVMFloorPlansPage;
import pageObjects.LasVegasMarket.LVMGlobalSearchPage;
import pageObjects.LasVegasMarket.LVMLandingPage;
import pageObjects.LasVegasMarket.LVMLoginPage;
import pageObjects.LasVegasMarket.LVMMarketPlannerPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

public class EvenntsAndWebinar extends base{
	
	public WebDriverWait wait;
	public GenerateData genData;
	public Utility utl;
	public String exhname;
	LVMLoginPage lp;
	LVMLandingPage lap;
	LVMGlobalSearchPage lvmgs;
	ATLExhDigiShowroomPage atlexhdgshw;
	ATLProductDetailsPage atlproddet;
	ATLExhLineProdActionsPage atlexhact;
	LVMMarketPlannerPage lvmmpp;
	LVMFloorPlansPage lvmflpp;
	LVMEventsAndWebinarPage lvmevents;
	ATLMarketPlannerPage atlmppge;
	List<WebElement> exhlist, linelist, prodlist, searchexhtypelist, searchproducttypelist, mplists, mpeditlistoptns, allnoteslist,favlist, searchlinetypelist;

	@BeforeClass
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		utl = new Utility(driver);
		lap = new LVMLandingPage(driver);

		// Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("lvmurl_prod"));
		//driver.get(prop.getProperty("lvmurl_prod"));
		/*utl.verifyMPLoginFunctionality();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);*/
		lap.getIUnderstandBtn().click();
		Thread.sleep(2000);
		utl.verifyMPLoginFunctionality();
		Thread.sleep(8000);
		//lap.getCloseMarktAdBtn().click();
		//Login to Market Planner
		//driver.navigate().refresh();
		//Thread.sleep(8000);
		//lap.getCloseMarktAdBtn().click();
	}

	@Test(priority = 1)
	public void TS001_VerifyEventsAndWebinarsOverviewTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T283: Events and Webinars Overview
		lap = new LVMLandingPage(driver);
		lp = new LVMLoginPage(driver);
		utl = new Utility(driver);
		lvmflpp=new LVMFloorPlansPage(driver);
		lvmevents=new LVMEventsAndWebinarPage(driver);
		lvmgs = new LVMGlobalSearchPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		utl.clickOnEventLinkOfChannel();
		/*// Click on Attend Tab
		lvmevents.getatlAttendTab().click();
		Thread.sleep(2000);
		//click on Events Link
		lvmevents.getatlEventsLink().click();
		Thread.sleep(3000);*/
		//Verify ATL events page title
		Assert.assertTrue(lvmgs.getlvmShowSpecialsTitle().getText().contains("Events"));
		// Verify IMC tab
		Assert.assertTrue(lvmevents.getlvmImcEventsTab().getText().equals("IMC Events"));
		
		System.out.println("IMC Event Tab is Present");
		// Verify Exhibitors Events tab
		Assert.assertTrue(lvmevents.getlvmExhibitorsEventsTab().getText().equals("Exhibitor Events"));
		System.out.println("Exhibitor Event Tab is Present");
		//Verify Events List
		try {
		Assert.assertTrue(!lvmevents.getlvmListOfAllEvents().isEmpty());
		System.out.println("Events list displayed");
		}
		catch(Exception e) {
			System.out.println("Events list not displayed");
			Assert.assertTrue(lvmevents.getlvmListOfAllEvents().isEmpty());
			
		}
		//Verify Calendar is displayed or not
		Assert.assertTrue(lvmevents.getlvmEventsCalendar().isDisplayed());
		System.out.println("Calendar is Present");
		//Verify Events Search Bar
		Assert.assertTrue(lvmevents.getlvmEventsSearchBar().isDisplayed());
		System.out.println("Events Search bar is Present");
			
	}

	@Test(priority = 2)
	public void TS002_VerifyIMCEventsSearchbarTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T284: IMC Events: Search bar
		lap = new LVMLandingPage(driver);
		lp = new LVMLoginPage(driver);
		utl = new Utility(driver);
		lvmflpp=new LVMFloorPlansPage(driver);
		lvmevents=new LVMEventsAndWebinarPage(driver);
		lvmgs = new LVMGlobalSearchPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		utl.clickOnEventLinkOfChannel();
		/*// Click on Attend Tab
		lvmevents.getatlAttendTab().click();
		Thread.sleep(2000);
		//click on Events Link
		lvmevents.getatlEventsLink().click();
		Thread.sleep(3000);*/
		//Click on IMC Event Tab
		lvmevents.getlvmImcEventsTab().click();
		//Click on Search Bar of IMC Events
		lvmevents.getlvmEventsSearchBar().click();
		String eventName=lvmevents.getlvmEventName().getText();
		//Enter Events Name into Search field
		lvmevents.getlvmEventsSearchBar().sendKeys(eventName);
		//Click on Search Icon
		lvmevents.getlvmEventSearchIcon().click();
		Thread.sleep(5000);
		//Verify Searched event dispayed as search result
		//Assert.assertEquals(lvmevents.getlvmEventName().getText(), eventName);
		utl.checkItemPresentInListorNot(lvmevents.getlvmListOfEventTitles(), eventName);	
	}
	
	@Test(priority = 3)//enabled=false
	public void TS003_VerifyIMCEventsCalendarViewTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T288: IMC Events: Calendar View
		lap = new LVMLandingPage(driver);
		lp = new LVMLoginPage(driver);
		utl = new Utility(driver);
		lvmflpp=new LVMFloorPlansPage(driver);
		lvmevents=new LVMEventsAndWebinarPage(driver);
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		utl.clickOnEventLinkOfChannel();	
		
		//Click on IMC Event Tab
		lvmevents.getlvmImcEventsTab().click();
		Thread.sleep(2000);
		
		//Event Month and Year
		String eventDateAndMonth=lvmevents.getlvmEventDateAndMonth().getText();
		String trimDate=eventDateAndMonth.split(" ")[2].trim();
		//System.out.println(trimDate);
		Thread.sleep(2000);
		String date=trimDate.replaceAll("[,]", "");
		String trimOnlyDate=date.split(" ")[0].trim();
		String replaceDate=trimOnlyDate.replaceFirst("^0+(?!$)", "");
		System.out.println(replaceDate);
		String selectDate="15";

		String trimMonth = eventDateAndMonth.split(" ")[1].trim();
		 System.out.println(trimMonth);
		String trimYear = eventDateAndMonth.split(" ")[3].trim();
		 System.out.println(trimYear);
		String EventmonthAndYear = trimMonth.concat(" ").concat(trimYear);
		 System.out.println("Concat Month And Year :: "+EventmonthAndYear);

		// Verify Current Date is Heighlighetd or not
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM");
		LocalDate localDate = LocalDate.now();
		String d = dtf.format(localDate);
		System.out.println("Current Date ::" + dtf.format(localDate));
		
		Assert.assertTrue(d.contains(lvmevents.getlvmTodaysDate().getText()));
		System.out.println("Current Date "+lvmevents.getlvmTodaysDate().getText()+" is Heighlighted");
		
		//Current Month
		DateTimeFormatter month = DateTimeFormatter.ofPattern("MMM");
		LocalDate localMonth = LocalDate.now();
		LocalDate prevMonth= localMonth.minusMonths(1);		
				
		String m = month.format(localMonth);//current month
		String mm = month.format(prevMonth);//previous month
		
	
		System.out.println("Current Month ::" +m );
		System.out.println("Previous Month ::" +mm );
		
		//Click on Calendar Prev Btn
		lvmevents.getlvmCalendarPrevMonth().click();
		System.out.println("Previous Month From Calendar ::"+lvmevents.getlvmSelectMonth().getText());
		Assert.assertTrue(lvmevents.getlvmSelectMonth().getText().contains(mm));
		System.out.println("Previous Month "+lvmevents.getlvmSelectMonth().getText()+" is selected");
		utl.selectFilters(lvmevents.getlvmListOflvmSelectAnyDate(), selectDate);
		
		for(int i=0;i>=0;i++)
		{
			lvmevents.getlvmCalendarNextMonthBtn().click();
			System.out.println(lvmevents.getlvmSelectMonth().getText());
			if(lvmevents.getlvmSelectMonth().getText().contains(EventmonthAndYear))
			{
				utl.selectFilters(lvmevents.getlvmListOfEventDate(), replaceDate);
				break;
			}
		}
		// Verify Event is selected by datepicker
		Assert.assertTrue(lvmevents.getlvmEventDateAndMonth().isDisplayed());
		System.out.println("Event is selected by Date");

		//Click on Reset Btn
		lvmevents.getlvmResetBtn().click();
		//Verify Current date and month should selected by default
		Assert.assertTrue(d.contains(lvmevents.getlvmTodaysDate().getText()));
		System.out.println("By Default "+d +" today's date is selected.");
	}
	
	@Test(priority = 4)
	public void TS004_VerifyIMCEventsEventsListTest() throws InterruptedException, IOException {
		
		// The purpose of this test case to verify:-
				// UXP-T292: IMC Events: Events List
				lap = new LVMLandingPage(driver);
				lp = new LVMLoginPage(driver);
				utl = new Utility(driver);
				lvmflpp=new LVMFloorPlansPage(driver);
				lvmevents=new LVMEventsAndWebinarPage(driver);
				lvmgs = new LVMGlobalSearchPage(driver);
				lvmmpp = new LVMMarketPlannerPage(driver);
				
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				utl.clickOnEventLinkOfChannel();	
				
				//Click on IMC Event Tab
				lvmevents.getlvmImcEventsTab().click();
				
				//Verify Event Calendar title
				Assert.assertTrue(lvmevents.getlvmEventDateAndMonth().isDisplayed());
				System.out.println("Event Calendar title is displayed");
				
				int allEventcount=0;
				for (WebElement allEvents : lvmevents.getlvmListOfAllEvents()) {
					allEventcount++;
					allEvents.isDisplayed();
				}
				System.out.println(allEventcount+ " Events Present");
				
				//Verify Events Titles
				int allEventTitlesCount=0;
				for (WebElement eventTitles : lvmevents.getlvmListOfEventTitles()) {
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
				for (WebElement eventType : lvmevents.getlvmListOfAllEventsType()) {
					allEventTypeCount++;
					Assert.assertTrue(eventType.isDisplayed());
				}
				System.out.println(allEventTypeCount + " Types displayed");
				Assert.assertEquals(allEventcount, allEventTypeCount);

				// Verify Events Time
				int allEventTimeCount = 0;
				for (WebElement eventTime : lvmevents.getlvmListOfAllEventsTime()) {
					allEventTimeCount++;
					Assert.assertTrue(eventTime.isDisplayed());
				} 
				System.out.println(allEventTimeCount + " Time displayed");
				Assert.assertEquals(allEventcount, allEventTimeCount);

				// Verify Events Location
				int allEventLocationCount = 0;
				for (WebElement eventLocation : lvmevents.getlvmListOfAllEventsLocations()) {
					allEventLocationCount++;
					Assert.assertTrue(eventLocation.isDisplayed());
				}
				System.out.println(allEventLocationCount + " Location displayed");
				Assert.assertEquals(allEventcount, allEventLocationCount);
			
				// Verify Events Image
				int allEventImageCount = 0;
				for (WebElement eventImage : lvmevents.lvmListOfAllEventsImages()) {
					allEventImageCount++;
					Assert.assertTrue(eventImage.isDisplayed());
				}
				System.out.println(allEventImageCount + "  Images displayed");
				Assert.assertEquals(allEventcount, allEventImageCount);

				// Verify Events See Details Link
				int allEventSeeDetailsLinkCount = 0;
				for (WebElement eventSeeDetailsLink : lvmevents.lvmlvmListOfAllEventsSeeDetailsLink()) {
					allEventSeeDetailsLinkCount++;
					Assert.assertTrue(eventSeeDetailsLink.isDisplayed());
				}
				System.out.println(allEventSeeDetailsLinkCount + " See Details Link displayed");
				Assert.assertEquals(allEventcount, allEventSeeDetailsLinkCount);

				// Click on Event Title page
				int allEventSeeDetailsLinkCount1 = 0;
				for( int i=0;i < lvmevents.getlvmListOfEventTitles().size(); i++) {
					allEventSeeDetailsLinkCount1++;
					WebElement eventTitleLink = lvmevents.getlvmListOfEventTitles().get(i);
					String eventTitle=eventTitleLink.getText();
					Assert.assertTrue(eventTitleLink.isDisplayed());
					//eventSeeDetailsLink = lvmevents.lvmlvmListOfAllEventsSeeDetailsLink().get(1);
					eventTitleLink.click();
					//Verify Event Details Page
					Assert.assertTrue(eventTitle.contains(lvmevents.getlvmEventNameOnDetailsPageUAT().getText()));
					Thread.sleep(3000);
					driver.navigate().back();
					Thread.sleep(3000);
				}
				
				System.out.println(allEventSeeDetailsLinkCount + " Events Details Page displayed");
				Assert.assertEquals(allEventcount, allEventSeeDetailsLinkCount1);
		
	}
	
	@Test(priority = 5)
	public void TS005_VerifyIMCEventsEventDetailstTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T295: IMC Events: Event Details
		lap = new LVMLandingPage(driver);
		lp = new LVMLoginPage(driver);
		utl = new Utility(driver);
		lvmflpp=new LVMFloorPlansPage(driver);
		lvmevents=new LVMEventsAndWebinarPage(driver);
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);

		utl.clickOnEventLinkOfChannel();	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String eventTitle=lvmevents.getlvmClickOnEvent().getText();
		Thread.sleep(5000);
		
		//Click on IMC Event Tab
		lvmevents.getlvmImcEventsTab().click();
		
		//Click on Any Event title
		lvmevents.getlvmClickOnEvent().click();
		Assert.assertTrue(eventTitle.contains(lvmevents.getlvmEventNameOnDetailsPageUAT().getText()));
		
		//Verify Location Link
		Assert.assertTrue(lvmevents.getlvmEventLocationLinkUAT().isDisplayed());
		System.out.println("Events Location link displayed");
		//Verify Event Type
		Assert.assertTrue(lvmevents.getlvmEventTypeUAT().isDisplayed());
		System.out.println("Event Type displayed");
		//Verify Add Fav Icon
		Assert.assertTrue(lvmevents.getlvmFavIcon().isDisplayed());
		System.out.println("Add Fav Icon displayed");
		//Verify Add Fav Icon
		Assert.assertTrue(lvmevents.getlvmListIcon().isDisplayed());
		System.out.println("Add List Icon displayed");
		//Verify Add Fav Icon
		Assert.assertTrue(lvmevents.getlvmNoteIcon().isDisplayed());
		System.out.println("Add Note Icon displayed");
		//Verify Add Fav Icon
		//Assert.assertTrue(lvmevents.getlvmCalendarIconUAT().isDisplayed());
		System.out.println("Calendar displayed");
		//tags
	//	Assert.assertTrue(lvmevents.getlvmTagIcon().isDisplayed());
		System.out.println("Tag displayed");
		
		//Click on Location link
		String locationURL=lvmevents.getlvmEventLocationLinkUAT().getAttribute("href");
		
		String currentWindowID=driver.getWindowHandle();
		lvmevents.getlvmEventLocationLinkUAT().click();
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
	/*	String searchResultPageURL=lvmevents.getlvmEventsTag().getAttribute("href");
		lvmevents.getlvmEventsTag().click();
		Assert.assertTrue(searchResultPageURL.contains(driver.getCurrentUrl()));
		Assert.assertTrue(lvmevents.getlvmSearchResultsTitle().getText().contains("Search Results"));
		System.out.println("Search Results page opened");*/
		driver.navigate().back();
		int allEventSeeDetailsLinkCount1 = 0;
		for (int i = 0; i < lvmevents.getlvmListOfEventTitles().size(); i++) {
			allEventSeeDetailsLinkCount1++;
			WebElement eventTitleLink = lvmevents.getlvmListOfEventTitles().get(i);
		System.out.println(eventTitleLink);
			eventTitleLink.click();
			// Verify Event Details Page
			
			Thread.sleep(2000);
			try {
				if(lvmevents.getlvmEventsTag().isDisplayed())
				{
					String searchResultPageURL=lvmevents.getlvmEventsTag().getAttribute("href");
					  lvmevents.getlvmEventsTag().click();
					  Assert.assertTrue(searchResultPageURL.contains(driver.getCurrentUrl()));
					  Assert.assertTrue(lvmevents.getlvmSearchResultsTitle().getText().contains("Search"));
					  System.out.println("Search Results page opened");
					  break;
				}
				
			}catch(Exception e) {
				e.printStackTrace();
				driver.navigate().back();
				Thread.sleep(2000);
				//Click on Exh Event Tab
				//lvmevents.getlvmExhibitorsEventsTab().click();
				/*System.out.println(i);
				System.out.println(lvmevents.getlvmListOfEventTitles().size());*/
				if(lvmevents.getlvmListOfEventTitles().size() == i+1)
				{
					System.out.println("Tags are not present");
					Assert.assertTrue(i== lvmevents.getlvmListOfEventTitles().size());
				}
			}
			
		}
		
	}

	@Test(priority = 6)
	public void TS006_VerifyIMCEventsAddToFavoriteTest() throws InterruptedException, IOException {
	
		// The purpose of this test case to verify:-
		// UXP-T296: IMC Events: Event Details- Add To Favorite
		lap = new LVMLandingPage(driver);
		lp = new LVMLoginPage(driver);
		utl = new Utility(driver);
		lvmflpp = new LVMFloorPlansPage(driver);
		lvmevents = new LVMEventsAndWebinarPage(driver);
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Login to MP
		//utl.verifyMPLoginFunctionality();
		utl.clickOnEventLinkOfChannel();
		String eventTitle = lvmevents.getlvmClickOnEvent().getText();
		System.out.println(eventTitle);

		// Click on IMC Event Tab
		lvmevents.getlvmImcEventsTab().click();
		
		// Click on Any Event title
		lvmevents.getlvmClickOnEvent().click();
		Assert.assertTrue(eventTitle.contains(lvmevents.getlvmEventNameOnDetailsPageUAT().getText()));

		// Click on Fav Icon
		lvmevents.getlvmFavIcon().click();

		// Click on Market Planner link
		lap.getMPLinkText().click();

		// Click on Lists tab on MP home page
		lvmmpp.getMPHomeListsTab().click();
		lvmmpp.getLVMMPListsPageFavoritesMenu().click();

		// Verify that the added favorites event should be displayed in to Favorites
		// list
		Assert.assertTrue(lvmmpp.getLVMSavedExhNameInList().getText().contains(eventTitle));

		// Delete that favorites exhibitor from list
		//atlmppge.getmoreOptionUAT_LVM().click();
		
		Actions actions = new Actions(driver);
		actions.moveToElement(atlmppge.getmoreOptionUAT_LVM()).perform();
		
		//actions.click().perform();
		Thread.sleep(10000);
		atlmppge.getmoreOptionDeleteBtnUAT_LVM().click();
		Thread.sleep(6000);

		// Verify that the added favorites exhibitor should be removed from Favorites
		// list
		
		
		try {
			Assert.assertFalse(lvmmpp.getLVMSavedExhNameInList().getText().contains(eventTitle));
			}catch (Exception e) {
				System.out.println("IMC Event deleted");
			}
	}
	
	@Test(priority = 16)//Previous priority = 07
	public void TS007_VerifyIMCEventsAddToListTest() throws InterruptedException, IOException {
		/*// The purpose of this test case to verify:-
		// UXP-T298: IMC Events: Event Details- Add To List
		lap = new LVMLandingPage(driver);
		lp = new LVMLoginPage(driver);
		utl = new Utility(driver);
		lvmflpp = new LVMFloorPlansPage(driver);
		lvmevents = new LVMEventsAndWebinarPage(driver);
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);

		
		// Login to MP
				utl.verifyMPLoginFunctionality();
				Thread.sleep(5000);
		utl.clickOnEventLinkOfChannel();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String eventTitle = lvmevents.getlvmClickOnEvent().getText();

		// Click on IMC Event Tab
		lvmevents.getlvmImcEventsTab().click();
		
		// Click on Any Event title
		lvmevents.getlvmClickOnEvent().click();
		Assert.assertTrue(eventTitle.contains(lvmevents.getlvmEventNameOnDetailsPageUAT().getText()));

		// Click on Add to List Icon

		lvmevents.getlvmListIcon().click();
		Thread.sleep(5000);
		lp.getEmailAddress().sendKeys((prop.getProperty("username")));
		lp.getPassword().sendKeys((prop.getProperty("password")));

		lp.getSignInBtn().click();
		lvmevents.getlvmListIcon().click();
		// Store the existing list name
		String existinglistname = lvmmpp.getLVMMPExistingListName().getText();
		System.out.println("Existing list name: " + existinglistname);

		// Select Existing list name
		lvmmpp.getLVMMPExistingListName().click();
		Thread.sleep(2000);

		// Scroll till Add to Selected button
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				lvmevents.getlvmaddtoseselectedbtn());
		Thread.sleep(2000);
		lvmevents.getlvmaddtoseselectedbtn().click();
		//lvmmpp.getATLMPAddToSelectedBtn().click();
		Thread.sleep(4000);
		// Click on Go to Market Planner button
		utl.clickOnEventLinkOfChannelLVM();
		// Click on Lists tab on MP home page
		lvmmpp.getMPHomeListsTab().click();
		lvmmpp.getListsPageListsMenu().click();
		mplists = lvmmpp.getLVMMPListsNames();
		mpeditlistoptns = lvmmpp.getLVMMPEditListOptns();

		for (int i = 0; i < mplists.size(); i++) {
			System.out.println(mplists.get(i).getText());
			// System.out.println(mpeditlistoptns.get(i).getText());
			if (mplists.get(i).getText().equals(existinglistname)) {
				mpeditlistoptns.get(i).click();
				break;
			}
		}
		Thread.sleep(5000);
		Assert.assertTrue(lvmmpp.getLVMSavedExhNameInList().getText().contains(exhname));

		// Delete that added line from list
		lvmmpp.getLVMEditListItemMoreBtn().click();
		lvmmpp.getLVMEditListItemDeleteOptn().click();
		Thread.sleep(8000);	*/
		// The purpose of this test case to verify:-
				// UXP-T298: IMC Events: Event Details- Add To List
				lap = new LVMLandingPage(driver);
				lp = new LVMLoginPage(driver);
				utl = new Utility(driver);
				lvmflpp = new LVMFloorPlansPage(driver);
				lvmevents = new LVMEventsAndWebinarPage(driver);
				lvmgs = new LVMGlobalSearchPage(driver);
				lvmmpp = new LVMMarketPlannerPage(driver);
				atlmppge = new ATLMarketPlannerPage(driver);

				
				// Login to MP
				/*		utl.verifyMPLoginFunctionality();
						Thread.sleep(5000);*/
				driver.get(prop.getProperty("lvmurl_prod"));
				Thread.sleep(5000);
				utl.clickOnEventLinkOfChannel();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				String eventTitle = lvmevents.getlvmClickOnEvent().getText();

				// Click on IMC Event Tab
				lvmevents.getlvmImcEventsTab().click();
				
				// Click on Any Event title
				lvmevents.getlvmClickOnEvent().click();
				Assert.assertTrue(eventTitle.contains(lvmevents.getlvmEventNameOnDetailsPageUAT().getText()));

				// Click on Add to List Icon

			/*	lvmevents.getlvmListIcon().click();
				Thread.sleep(5000);
				lp.getEmailAddress().sendKeys((prop.getProperty("username")));
				lp.getPassword().sendKeys((prop.getProperty("password")));

				lp.getSignInBtn().click();*/
				lvmevents.getlvmListIcon().click();
				// Store the existing list name
				String existinglistname = lvmmpp.getLVMMPExistingListName().getText();
				System.out.println("Existing list name: " + existinglistname);

				// Select Existing list name
				lvmmpp.getLVMMPExistingListName().click();
				Thread.sleep(2000);

				// Scroll till Add to Selected button
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
						lvmevents.getlvmaddtoseselectedbtn());
				Thread.sleep(2000);
				lvmevents.getlvmaddtoseselectedbtn().click();
				//lvmmpp.getATLMPAddToSelectedBtn().click();
				
				// Click on Go to Market Planner button
			//	utl.clickOnEventLinkOfChannelLVM();
				Thread.sleep(2000);
				// Click on Go to Market Planner button
				lvmmpp.getGoToMarketPlannerBtn().click();
				// Click on Lists tab on MP home page
				lvmmpp.getMPHomeListsTab().click();
				lvmmpp.getListsPageListsMenu().click();
				mplists = lvmmpp.getLVMMPListsNames();
				mpeditlistoptns = lvmmpp.getLVMMPEditListOptns();

				for (int i = 0; i < mplists.size(); i++) {
					System.out.println(mplists.get(i).getText());
					// System.out.println(mpeditlistoptns.get(i).getText());
					if (mplists.get(i).getText().equals(existinglistname)) {
						mpeditlistoptns.get(i).click();
						break;
					}
				}
				Thread.sleep(5000);
				Assert.assertTrue(lvmmpp.getLVMSavedExhNameInList().getText().contains(eventTitle));

				/*// Delete that added line from list
				lvmmpp.getLVMEditListItemMoreBtn().click();
				lvmmpp.getLVMEditListItemDeleteOptn().click();
				Thread.sleep(8000);	*/
				Actions actions = new Actions(driver);
				actions.moveToElement(atlmppge.getmoreOptionUAT_LVM()).perform();
				
				//actions.click().perform();
				Thread.sleep(10000);
				atlmppge.getmoreEventOptionDeleteBtnUAT_LVM().click();
				Thread.sleep(6000);

				// Verify that the added favorites exhibitor should be removed from Favorites
				// list
				
				
				try {
					Assert.assertFalse(lvmmpp.getLVMSavedExhNameInList().getText().contains(eventTitle));
					}catch (Exception e) {
						System.out.println("IMC Event deleted");
					}
				Thread.sleep(8000);
	}
	
	@Test(priority = 8)
	public void TS008_VerifyIMCEventsAddNoteTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T299: IMC Events: Event Details- Add Note
		lap = new LVMLandingPage(driver);
		lp = new LVMLoginPage(driver);
		utl = new Utility(driver);
		lvmflpp = new LVMFloorPlansPage(driver);
		lvmevents = new LVMEventsAndWebinarPage(driver);
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		genData = new GenerateData();
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlproddet = new ATLProductDetailsPage(driver);

		// Login to MP
		/*
		 * utl.verifyMPLoginFunctionality(); Thread.sleep(5000);
		 */
		utl.clickOnEventLinkOfChannel();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
		String eventTitle = lvmevents.getlvmClickOnEvent().getText();

		// Click on IMC Event Tab
		lvmevents.getlvmImcEventsTab().click();
		
		// Click on Any Event title
		lvmevents.getlvmClickOnEvent().click();
		Assert.assertTrue(eventTitle.contains(lvmevents.getlvmEventNameOnDetailsPageUAT().getText()));

		// Click on Add to List Icon
		lvmevents.getlvmNoteIcon().click();
		/*Thread.sleep(5000);
		lp.getEmailAddress().sendKeys((prop.getProperty("username")));
		lp.getPassword().sendKeys((prop.getProperty("password")));

		lp.getSignInBtn().click();
		lvmevents.getlvmNoteIcon().click();*/
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
	
	@Test(priority = 9)
	public void TS009_VerifyExhibitorEventsSearchbarTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T304: Exhibitor Events: Search bar
		lap = new LVMLandingPage(driver);
		lp = new LVMLoginPage(driver);
		utl = new Utility(driver);
		lvmflpp=new LVMFloorPlansPage(driver);
		lvmevents=new LVMEventsAndWebinarPage(driver);
		lvmgs = new LVMGlobalSearchPage(driver);

		utl.clickOnEventLinkOfChannel();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		/*// Click on Attend Tab
		lvmevents.getatlAttendTab().click();
		Thread.sleep(2000);
		//click on Events Link
		lvmevents.getatlEventsLink().click();
		Thread.sleep(3000);*/
		//Click on Exh Event Tab
		lvmevents.getlvmExhibitorsEventsTab().click();
		//Click on Search Bar of IMC Events
		lvmevents.getlvmEventsSearchBar().click();
		String eventName=lvmevents.getlvmEventName().getText();
		//Enter Events Name into Search field
		lvmevents.getlvmEventsSearchBar().sendKeys(eventName);
		//Click on Search Icon
		lvmevents.getlvmEventSearchIcon().click();
		Thread.sleep(5000);
		//Verify Searched event dispayed as search result
		//Assert.assertEquals(lvmevents.getlvmEventName().getText(), eventName);
		utl.checkItemPresentInListorNot(lvmevents.getlvmListOfEventTitles(), eventName);
}
	
	@Test(priority = 10)
	public void TS010_VerifyExhibitorEventsCalendarViewTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T305: Exhibitor Events: Calendar View
		lap = new LVMLandingPage(driver);
		lp = new LVMLoginPage(driver);
		utl = new Utility(driver);
		lvmflpp=new LVMFloorPlansPage(driver);
		lvmevents=new LVMEventsAndWebinarPage(driver);
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		utl.clickOnEventLinkOfChannel();
		//Click on Exh Event Tab
		lvmevents.getlvmExhibitorsEventsTab().click();
		
		Thread.sleep(2000);
		//Event Month and Year
		String eventDateAndMonth=lvmevents.getlvmEventDateAndMonth().getText();
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
		 System.out.println("Concat Month And Year :: "+EventmonthAndYear);

		// Verify Current Date is Heighlighetd or not
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM");
		LocalDate localDate = LocalDate.now();
		String d = dtf.format(localDate);
		System.out.println("Current Date ::" + dtf.format(localDate));
		String exactDate="";
		
		try {
			Assert.assertTrue(d.contains(lvmevents.getlvmTodaysDate().getText()));
			System.out.println("Current Date "+lvmevents.getlvmTodaysDate().getText()+" is Heighlighted");
			
		}catch (Exception e) {
			// TODO: handle exception
		
		
		String Cdate = d.split("")[0].trim();
		String Cdate2 = d.split("")[1].trim();
		
		exactDate=Cdate.concat(Cdate2);
		
		try {
		Assert.assertTrue(exactDate.contains(lvmevents.getlvmTodaysDate().getText()));
		System.out.println("Current Date "+lvmevents.getlvmTodaysDate().getText()+" is Heighlighted");
		}catch (Exception ex) {
			// TODO: handle exception
			Assert.assertTrue(exactDate.contains(lvmevents.getlvmListOfAllEventsDay().getText()));
			System.out.println("Current Date "+lvmevents.getlvmListOfAllEventsDay().getText()+" is Heighlighted");
		}
		
		}
		
		//Current Month
		DateTimeFormatter month = DateTimeFormatter.ofPattern("MMM");
		LocalDate localMonth = LocalDate.now();
		LocalDate prevMonth= localMonth.minusMonths(2);		
				
		String m = month.format(localMonth);//current month
		String mm = month.format(prevMonth);//previous month
		
		System.out.println("Current Month ::" +m );
		System.out.println("Previous Month ::" +mm );
		
		//Click on Calendar Prev Btn
		lvmevents.getlvmCalendarPrevMonth().click();
		lvmevents.getlvmCalendarPrevMonth().click();
		System.out.println("Previous Month From Calendar ::"+lvmevents.getlvmSelectMonth().getText());
		Assert.assertTrue(lvmevents.getlvmSelectMonth().getText().contains(mm));
		System.out.println("Previous Month "+lvmevents.getlvmSelectMonth().getText()+" is selected");
		utl.selectFilters(lvmevents.getlvmListOflvmSelectAnyDate(), "2");
		
		for(int i=0;i>=0;i++)
		{
			lvmevents.getlvmCalendarNextMonthBtn().click();
			
			if(lvmevents.getlvmSelectMonth().getText().contains(EventmonthAndYear))
			{
				try {
				utl.selectFilters(lvmevents.getlvmListOfEventDate(), replaceDate);
				break;
				}catch (Exception e) {
					// TODO: handle exception
				utl.selectFilters(lvmevents.getlvmListOfAllEventsDays(), replaceDate);
					break;
				}
			}
		}
		// Verify Event is selected by datepicker
		Assert.assertTrue(lvmevents.getlvmEventDateAndMonth().isDisplayed());
		System.out.println("Event is selected by Date");

		//Click on Reset Btn
		lvmevents.getlvmResetBtn().click();
		//Verify Current date and month should selected by default
		//Assert.assertTrue(d.contains(lvmevents.getlvmTodaysDate().getText()));
		try {
			Assert.assertTrue(d.contains(lvmevents.getlvmTodaysDate().getText()));
			System.out.println("Current Date "+lvmevents.getlvmTodaysDate().getText()+" is Heighlighted");
			
		}catch (Exception e) {
			// TODO: handle exception
		
		
		try {
			Assert.assertTrue(exactDate.contains(lvmevents.getlvmTodaysDate().getText()));
			System.out.println("Current Date "+lvmevents.getlvmTodaysDate().getText()+" is Heighlighted");
			}catch (Exception ex) {
				// TODO: handle exception
				Assert.assertTrue(exactDate.contains(lvmevents.getlvmListOfAllEventsDay().getText()));
				System.out.println("Current Date "+lvmevents.getlvmListOfAllEventsDay().getText()+" is Heighlighted");
			}
		
		
		}
		
		
		System.out.println("By Default "+d +" today's date is selected.");
		Thread.sleep(4000);
	}
	
	@Test(priority = 0)//Previous priority = 11
	public void TS011_VerifyExhibitorEventsListTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T306: Exhibitor Events: Events List
		lap = new LVMLandingPage(driver);
		lp = new LVMLoginPage(driver);
		utl = new Utility(driver);
		lvmflpp=new LVMFloorPlansPage(driver);
		lvmevents=new LVMEventsAndWebinarPage(driver);
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);

		driver.navigate().refresh();
		Thread.sleep(5000);
		utl.clickOnEventLinkOfChannel();	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Click on Exh Event Tab
		lvmevents.getlvmExhibitorsEventsTab().click();
		
		//Verify Event Calendar title
		Assert.assertTrue(lvmevents.getlvmEventDateAndMonth().isDisplayed());
		System.out.println("Event Calendar title is displayed");
		
		int allEventcount=0;
		for (WebElement allEvents : lvmevents.getlvmListOfAllEvents()) {
			allEventcount++;
			allEvents.isDisplayed();
		}
		System.out.println(allEventcount+ " Events Present");
		
		//Verify Events Titles
		int allEventTitlesCount=0;
		for (WebElement eventTitles : lvmevents.getlvmListOfEventTitles()) {
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
		for (WebElement eventType : lvmevents.getlvmListOfAllEventsType()) {
			allEventTypeCount++;
			Assert.assertTrue(eventType.isDisplayed());
		}
		System.out.println(allEventTypeCount + " Types displayed");
		Assert.assertEquals(allEventcount, allEventTypeCount);

		// Verify Events Time
		int allEventTimeCount = 0;
		for (WebElement eventTime : lvmevents.getlvmListOfAllEventsTime()) {
			allEventTimeCount++;
			Assert.assertTrue(eventTime.isDisplayed());
		} 
		System.out.println(allEventTimeCount + " Time displayed");
		Assert.assertEquals(allEventcount, allEventTimeCount);

		// Verify Events Location
		int allEventLocationCount = 0;
		for (WebElement eventLocation : lvmevents.getlvmListOfAllEventsLocations()) {
			allEventLocationCount++;
			Assert.assertTrue(eventLocation.isDisplayed());
		}
		System.out.println(allEventLocationCount + " Location displayed");
		Assert.assertEquals(allEventcount, allEventLocationCount);
	
		// Verify Events Image
		int allEventImageCount = 0;
		for (WebElement eventImage : lvmevents.lvmListOfAllEventsImages()) {
			allEventImageCount++;
			Assert.assertTrue(eventImage.isDisplayed());
		}
		System.out.println(allEventImageCount + "  Images displayed");
		Assert.assertEquals(allEventcount, allEventImageCount);

		// Verify Events See Details Link
		int allEventSeeDetailsLinkCount = 0;
		for (WebElement eventSeeDetailsLink : lvmevents.lvmlvmListOfAllEventsSeeDetailsLink()) {
			allEventSeeDetailsLinkCount++;
			Assert.assertTrue(eventSeeDetailsLink.isDisplayed());
		}
		System.out.println(allEventSeeDetailsLinkCount + " See Details Link displayed");
		Assert.assertEquals(allEventcount, allEventSeeDetailsLinkCount);
		Thread.sleep(5000);

		// Click on Event Title page
		int allEventSeeDetailsLinkCount1 = 0;
		for( int i=0;i < lvmevents.getlvmListOfEventTitles().size(); i++) {
			allEventSeeDetailsLinkCount1++;
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//Thread.sleep(5000);
			WebElement eventTitleLink = lvmevents.getlvmListOfEventTitles().get(i);
			String eventTitle=eventTitleLink.getText();
			Assert.assertTrue(eventTitleLink.isDisplayed());
			//eventSeeDetailsLink = lvmevents.lvmlvmListOfAllEventsSeeDetailsLink().get(1);
			//WebDriverWait wait = new WebDriverWait(driver,30);//new added
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("eventTitleLink")));
			eventTitleLink.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//Thread.sleep(4000);
			//Verify Event Details Page
			Assert.assertTrue(eventTitle.contains(lvmevents.getlvmEventNameOnDetailsPageUAT().getText()));
			driver.navigate().back();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//Thread.sleep(5000);
			//Click on Exh Event Tab
			lvmevents.getlvmExhibitorsEventsTab().click();
			Thread.sleep(2000);
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		System.out.println(allEventSeeDetailsLinkCount + " Events Details Page displayed");
		Assert.assertEquals(allEventcount, allEventSeeDetailsLinkCount1);
}
	
	@Test(priority = 12)
	public void TS012_VerifyExhibitorEventsDetailstTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T307: Exhibitor Events: Event Details
		lap = new LVMLandingPage(driver);
		lp = new LVMLoginPage(driver);
		utl = new Utility(driver);
		lvmflpp=new LVMFloorPlansPage(driver);
		lvmevents=new LVMEventsAndWebinarPage(driver);
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);

		//utl.clickOnEventLinkOfChannelLVM();	
		
		utl.clickOnEventLinkOfChannel();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on Exh Event Tab
		lvmevents.getlvmExhibitorsEventsTab().click();
		//Click on IMC Event Tab
		//lvmevents.getlvmImcEventsTab().click();
		String eventTitle=lvmevents.getlvmClickOnEvent().getText();
		lvmevents.getlvmClickOnEvent().click();
		Assert.assertTrue(eventTitle.contains(lvmevents.getlvmEventNameOnDetailsPageUAT().getText()));
		
		//Verify Location Link
		Assert.assertTrue(lvmevents.getlvmEventLocationLinkUAT().isDisplayed());
		System.out.println("Events Location link displayed");
		//Verify Event Type
		Assert.assertTrue(lvmevents.getlvmEventTypeUAT().isDisplayed());
		System.out.println("Event Type displayed");
		//Verify Add Fav Icon
		Assert.assertTrue(lvmevents.getlvmFavIcon().isDisplayed());
		System.out.println("Add Fav Icon displayed");
		//Verify Add Fav Icon
		Assert.assertTrue(lvmevents.getlvmListIcon().isDisplayed());
		System.out.println("Add List Icon displayed");
		//Verify Add Fav Icon
		Assert.assertTrue(lvmevents.getlvmNoteIcon().isDisplayed());
		System.out.println("Add Note Icon displayed");
		//Verify Add Fav Icon
		Assert.assertTrue(lvmevents.getlvmCalendarIconUAT().isDisplayed());
		System.out.println("Calendar displayed");
		//Verify Add Fav Icon
		Assert.assertTrue(lvmevents.getlvmTagIcon().isDisplayed());
		System.out.println("Tag displayed");
		
		//Click on Location link
		String locationURL=lvmevents.getlvmEventLocationLinkUAT().getAttribute("href");
		
		String currentWindowID = driver.getWindowHandle();
		lvmevents.getlvmEventLocationLinkUAT().click();
		for (String windowHandleID : driver.getWindowHandles()) {
			driver.switchTo().window(windowHandleID);
		}
		Thread.sleep(5000);
		// Verify Location floor plan page
		Assert.assertTrue(driver.getCurrentUrl().contains(locationURL));
		driver.close();
		driver.switchTo().window(currentWindowID);
		// driver.navigate().back();

		
/*		  //Click on Tags String
		  searchResultPageURL=lvmevents.getlvmEventsTag().getAttribute("href");
		  lvmevents.getlvmEventsTag().click();
		  Assert.assertTrue(searchResultPageURL.contains(driver.getCurrentUrl()));
		  Assert.assertTrue(lvmevents.getlvmSearchResultsTitle().getText().
		  contains("Search Results"));
		  System.out.println("Search Results page opened");
		 */

		// Click on Event Title page
		
		driver.navigate().back();
		//Click on Exh Event Tab
		lvmevents.getlvmExhibitorsEventsTab().click();
	/*	
		int allEventSeeDetailsLinkCount1 = 0;
		for (int i = 0; i < lvmevents.getlvmListOfEventTitles().size(); i++) {
			allEventSeeDetailsLinkCount1++;
			WebElement eventTitleLink = lvmevents.getlvmListOfEventTitles().get(i);
		
			// eventSeeDetailsLink = lvmevents.lvmlvmListOfAllEventsSeeDetailsLink().get(1);
			eventTitleLink.click();
			// Verify Event Details Page
			//Assert.assertTrue(eventTitle.contains(lvmevents.getlvmEventNameOnDetailsPageUATUAT().getText()));
			Thread.sleep(2000);
			try {
				if(lvmevents.getlvmEventsTag().isDisplayed())
				{
					String searchResultPageURL=lvmevents.getlvmEventsTag().getAttribute("href");
					  lvmevents.getlvmEventsTag().click();
					  Assert.assertTrue(searchResultPageURL.contains(driver.getCurrentUrl()));
					  Assert.assertTrue(lvmevents.getlvmSearchResultsTitle().getText().contains("Search Results"));
					  System.out.println("Search Results page opened");
					  break;
				}
				
			}catch(Exception e) {
				e.printStackTrace();
				driver.navigate().back();
				Thread.sleep(2000);
				//Click on Exh Event Tab
				//lvmevents.getlvmExhibitorsEventsTab().click();
				System.out.println(i);
				System.out.println(lvmevents.getlvmListOfEventTitles().size());
				if(lvmevents.getlvmListOfEventTitles().size() == i+1)
				{
					System.out.println("Tags are not present");
					Assert.assertTrue(i== lvmevents.getlvmListOfEventTitles().size());
				}
			}
			
		}*/
		
	}	

	@Test(priority = 13)
	public void TS013_VerifyExhibitorEventsAddToFavoriteTest() throws InterruptedException, IOException {
		
		// The purpose of this test case to verify:-
				// UXP-T308: Exhibitor Events: Event Details- Add To Favorite
				lap = new LVMLandingPage(driver);
				lp = new LVMLoginPage(driver);
				utl = new Utility(driver);
				lvmflpp = new LVMFloorPlansPage(driver);
				lvmevents = new LVMEventsAndWebinarPage(driver);
				lvmgs = new LVMGlobalSearchPage(driver);
				lvmmpp = new LVMMarketPlannerPage(driver);
				atlmppge = new ATLMarketPlannerPage(driver);

				//Login to MP
				//utl.verifyMPLoginFunctionality();
				utl.clickOnEventLinkOfChannel();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				

				/*// Click on IMC Event Tab
				lvmevents.getlvmImcEventsTab().click();*/
				//Click on Exh Event Tab
				lvmevents.getlvmExhibitorsEventsTab().click();
				String eventTitle = lvmevents.getlvmClickOnEvent().getText();
				// Click on Any Event title
				lvmevents.getlvmClickOnEvent().click();

				//Assert.assertTrue(eventTitle.contains(lvmevents.getlvmEventNameOnDetailsPageUATUAT().getText()));
				// Click on Fav Icon
				lvmevents.getlvmFavIcon().click();

				// Click on Market Planner link
				lap.getMPLinkText().click();

				// Click on Lists tab on MP home page
				lvmmpp.getMPHomeListsTab().click();
				lvmmpp.getLVMMPListsPageFavoritesMenu().click();

				// Verify that the added favorites event should be displayed in to Favorites
				// list
				//Assert.assertTrue(lvmmpp.getlistOfAllEventsInMPList().getText().contains(eventTitle));
				utl.checkItemPresentInListorNot(lvmmpp.getlistOfAllEventsInMPList(), eventTitle);
				WebElement ename=driver.findElement(By.xpath("//div[@class='imc-saved-exhibitors__contentItems__col1']/div[2]/a[contains(text(),'"+eventTitle+"')]"));
				// Delete that favorites exhibitor from list
				Actions actions = new Actions(driver);
				actions.moveToElement(atlmppge.getMoreBtnDeleteOptnExistingList_ATLPROD()).perform();
				
				//actions.click().perform();
				Thread.sleep(10000);
				atlmppge.getATLEditListItemDeleteOptn().click();
				Thread.sleep(6000);

				// Verify that the added favorites exhibitor should be removed from Favorites
				// list
				try {
				Assert.assertFalse(lvmmpp.getEventsInMPList().getText().contains(ename.getText()));
				}catch (Exception e) {
					System.out.println("Exhibitor Event deleted");
				}
	}
	
	@Test(priority = 14)
	public void TS014_VerifyExhibitorEventsAddToListTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T309: Exhibitor Events: Event Details- Add To List
		lap = new LVMLandingPage(driver);
		lp = new LVMLoginPage(driver);
		utl = new Utility(driver);
		lvmflpp = new LVMFloorPlansPage(driver);
		lvmevents = new LVMEventsAndWebinarPage(driver);
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
	
		atlmppge = new ATLMarketPlannerPage(driver);

		// Login to MP
		//utl.verifyMPLoginFunctionality();
		Thread.sleep(5000);
	
		utl.clickOnEventLinkOfChannel();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Click on Exh Event Tab
		lvmevents.getlvmExhibitorsEventsTab().click();
		/*// Click on IMC Event Tab
		lvmevents.getlvmImcEventsTab().click();*/
		String eventTitle = lvmevents.getlvmClickOnEvent().getText();
		// Click on Any Event title
		lvmevents.getlvmClickOnEvent().click();

		//Assert.assertTrue(eventTitle.contains(lvmevents.getlvmEventNameOnDetailsPageUATUAT().getText()));
		// Click on Add to List Icon

	/*	lvmevents.getlvmListIcon().click();
		Thread.sleep(5000);
		lp.getEmailAddress().sendKeys((prop.getProperty("username")));
		lp.getPassword().sendKeys((prop.getProperty("password")));

		lp.getSignInBtn().click();*/
		lvmevents.getlvmListIcon().click();
		// Store the existing list name
		String existinglistname = lvmmpp.getLVMMPExistingListName().getText();
		System.out.println("Existing list name: " + existinglistname);

		// Select Existing list name
		lvmmpp.getLVMMPExistingListName().click();
		Thread.sleep(2000);

		// Scroll till Add to Selected button
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				lvmevents.getlvmaddtoseselectedbtn());
		Thread.sleep(2000);
		lvmevents.getlvmaddtoseselectedbtn().click();
		//lvmmpp.getATLMPAddToSelectedBtn().click();
		Thread.sleep(2000);
		// Click on Go to Market Planner button
		lvmmpp.getGoToMarketPlannerBtn().click();

		// Click on Lists tab on MP home page
		lvmmpp.getMPHomeListsTab().click();
		lvmmpp.getListsPageListsMenu().click();

		mplists = lvmmpp.getLVMMPListsNames();
		mpeditlistoptns = lvmmpp.getLVMMPEditListOptns();

		for (int i = 0; i < mplists.size(); i++) {
			//System.out.println(mplists.get(i).getText());
			// System.out.println(mpeditlistoptns.get(i).getText());
			if (mplists.get(i).getText().equals(existinglistname)) {
				mpeditlistoptns.get(i).click();
				break;
			}
		}
		Thread.sleep(5000);
		//Assert.assertTrue(lvmmpp.getLVMSavedExhNameInList().getText().contains(exhname));
		utl.checkItemPresentInListorNot(lvmmpp.getlistOfAllEventsInMPList(), eventTitle);

		// Delete that added line from list
		/*lvmmpp.getLVMEditListItemMoreBtn().click();
		lvmmpp.getLVMEditListItemDeleteOptn().click();
		Thread.sleep(8000);*/
		//atlmppge.getATLEditListItemMoreBtn().click(); //Old btn not working
		atlmppge.getATLEditListItemMoreBtnNew().click(); // new btn
		atlmppge.getATLEditListItemDeleteOptn().click();
		Thread.sleep(8000);

	}
	
	@Test(priority = 15)
	public void TS015_VerifyExhibitorEventsAddNoteTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T310: Exhibitor Events: Event Details- Add Note
		lap = new LVMLandingPage(driver);
		lp = new LVMLoginPage(driver);
		utl = new Utility(driver);
		lvmflpp = new LVMFloorPlansPage(driver);
		lvmevents = new LVMEventsAndWebinarPage(driver);
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		genData = new GenerateData();
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlproddet = new ATLProductDetailsPage(driver);

		// Login to MP
		
		//utl.verifyMPLoginFunctionality(); Thread.sleep(5000);
		Thread.sleep(5000); 
		utl.clickOnEventLinkOfChannel();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String eventTitle = lvmevents.getlvmClickOnEvent().getText();

		//Click on Exh Event Tab
				lvmevents.getlvmExhibitorsEventsTab().click();
		/*// Click on IMC Event Tab
		lvmevents.getlvmImcEventsTab().click();*/
		// Click on Any Event title
		lvmevents.getlvmClickOnEvent().click();

		//Assert.assertTrue(eventTitle.contains(lvmevents.getlvmEventNameOnDetailsPageUATUAT().getText()));
		// Click on Add to List Icon

		lvmevents.getlvmNoteIcon().click();
		
		/*Thread.sleep(5000);
		lp.getEmailAddress().sendKeys((prop.getProperty("username")));
		lp.getPassword().sendKeys((prop.getProperty("password")));

		lp.getSignInBtn().click();
		lvmevents.getlvmNoteIcon().click();*/
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
	
	@AfterClass
	public void tearDown()
	{
		//driver.quit();
	}

}



