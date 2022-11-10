package atlantamarket_PROD;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
import java.time.LocalDate;

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

	@BeforeClass
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);

		// Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("atlmrkturl_prod"));
		lap.getIUnderstandBtn().click();
		Thread.sleep(7000);
		//lap.getCloseMarktAdBtn().click();

		//Login to Market Planner
		//utl.verifyMPLoginFunctionality();
		//driver.navigate().refresh();
		Thread.sleep(8000);
		//		lap.getCloseMarktAdBtn().click();
	}

	@Test(priority = 1)
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

		// Click on Attend Tab
		atlevents.getatlAttendTab().click();
		Thread.sleep(2000);
		//click on Events Link
		atlevents.getatlEventsLink().click();
		Thread.sleep(3000);
		//Verify ATL events page title
		Assert.assertTrue(atlgs.getatlShowSpecialsTitle().getText().equals("Events"));
		// Verify IMC tab
		Assert.assertTrue(atlevents.getatlImcEventsTab().getText().equals("IMC Events"));
		System.out.println("IMC Event Tab is Present");
		// Verify Exhibitors Events tab
		Assert.assertTrue(atlevents.getatlExhibitorsEventsTab().getText().equals("Exhibitor Events"));
		System.out.println("Exhibitor Event Tab is Present");
		//Verify Events List
		//-----*Code pending here-----*
		
		
		
		//Verify Calendar is displayed or not
		Assert.assertTrue(atlevents.getatlEventsCalendar().isDisplayed());
		System.out.println("Calendar is Present");
		//Verify Events Search Bar
		Assert.assertTrue(atlevents.getatlEventsSearchBar().isDisplayed());
		System.out.println("Events Search bar is Present");
		
		

		
	}

	@Test(priority = 2)
	public void TS002_VerifyIMCEventsSearchbarTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T284: IMC Events: Search bar
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp=new ATLFloorPlansPage(driver);
		atlevents=new ATLEventsAndWebinarPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Attend Tab
		atlevents.getatlAttendTab().click();
		Thread.sleep(2000);
		//click on Events Link
		atlevents.getatlEventsLink().click();
		Thread.sleep(3000);
		//Click on IMC Event Tab
		atlevents.getatlImcEventsTab().click();
		//Click on Search Bar of IMC Events
		atlevents.getatlEventsSearchBar().click();
		String eventName=atlevents.getatlEventName().getText();
		//Enter Events Name into Search field
		atlevents.getatlEventsSearchBar().sendKeys(eventName);
		//Click on Search Icon
		atlevents.getatlEventSearchIcon().click();
		Thread.sleep(5000);
		//Verify Searched event dispayed as search result
		Assert.assertEquals(atlevents.getatlEventName().getText(), eventName);
		
		

		
	}
	@Test(priority = 3)
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

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			// Click on Attend Tab
		atlevents.getatlAttendTab().click();
		Thread.sleep(2000);
		//click on Events Link
		atlevents.getatlEventsLink().click();
		Thread.sleep(3000);
		//Click on IMC Event Tab
		atlevents.getatlImcEventsTab().click();
		Thread.sleep(2000);
		//Event Month and Year
		String eventDateAndMonth=atlevents.getatlEventDateAndMonth().getText();
		String trimDate=eventDateAndMonth.split(" ")[2].trim();
		//System.out.println(trimDate);
		Thread.sleep(2000);
		String date=trimDate.replaceAll("[,]", "");
		String trimOnlyDate=date.split(" ")[0].trim();
		//System.out.println(trimOnlyDate);

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
		
		Assert.assertTrue(d.contains(atlevents.getatlTodaysDate().getText()));
		System.out.println("Current Date "+atlevents.getatlTodaysDate().getText()+" is Heighlighted");
		
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
		System.out.println("Previous Month From Calendar ::"+atlevents.getatlSelectMonth().getText());
		Assert.assertTrue(atlevents.getatlSelectMonth().getText().contains(mm));
		System.out.println("Previous Month "+atlevents.getatlSelectMonth().getText()+" is selected");
		utl.selectFilters(atlevents.getatlListOfatlSelectAnyDate(), trimOnlyDate);
		
		for(int i=0;i>=0;i++)
		{
			atlevents.getatlCalendarNextMonthBtn().click();
			
			if(atlevents.getatlSelectMonth().getText().contains(EventmonthAndYear))
			{
				utl.selectFilters(atlevents.getatlListOfEventDate(), trimOnlyDate);
				break;
			}
		}
		// Verify Event is selected by datepicker
		Assert.assertTrue(atlevents.getatlEventDateAndMonth().isDisplayed());
		System.out.println("Event is selected by Date");

		//Click on Reset Btn
		atlevents.getatlResetBtn().click();
		//Verify Current date and month should selected by default
		Assert.assertTrue(d.contains(atlevents.getatlTodaysDate().getText()));
		System.out.println("By Default "+d +" todya's date is selected.");
		
		
	}
}
/*@AfterClass
public void tearDown()
{
	driver.quit();
}*/

