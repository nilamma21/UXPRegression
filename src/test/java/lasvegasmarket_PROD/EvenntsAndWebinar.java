package lasvegasmarket_PROD;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
import pageObjects.LasVegasMarket.LVMEventsAndWebinarPage;
import pageObjects.LasVegasMarket.LVMFloorPlansPage;
import pageObjects.LasVegasMarket.LVMGlobalSearchPage;
import pageObjects.LasVegasMarket.LVMLandingPage;
import pageObjects.LasVegasMarket.LVMLoginPage;
import pageObjects.LasVegasMarket.LVMMarketPlannerPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

public class EvenntsAndWebinar extends base {

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
	List<WebElement> exhlist, linelist, prodlist, searchexhtypelist, searchproducttypelist, mplists, mpeditlistoptns,
			allnoteslist, favlist, searchlinetypelist, exhibitors;

	@BeforeClass
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);

		// Navigate to Atlanta Market site
		//driver.manage().window().maximize();
		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		try {
			lap.getIUnderstandBtn().click();
			Thread.sleep(7000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		// lap.getCloseMarktAdBtn().click();
	}

	@Test(priority = 1) // groups="Non_MP"
	public void TS001_VerifyEventsAndWebinarsOverviewTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T283: Events and Webinars Overview

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp = new ATLFloorPlansPage(driver);
		atlevents = new ATLEventsAndWebinarPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);
		// driver.get(prop.getProperty("lvmurl_prod"));
		// utl.loginCheckATL();
		utl.clickOnEventLinkOfChannel();
		Thread.sleep(2000);

		// Verify All Events tab
		Assert.assertTrue(atlevents.getAllEventsTab().getText().equals("All Events"));
		System.out.println("All Event Tab is Present");
		// Verify Market Events tab
		Assert.assertTrue(atlevents.getMarketEventsTab().getText().equals("Market Events"));
		System.out.println("Market Event Tab is Present");
		// Verify Exhibitors Events tab
		Assert.assertTrue(atlevents.getatlExhibitorsEventsTab().getText().equals("Exhibitor Events"));
		System.out.println("Exhibitor Event Tab is Present");

		//utl.scrollElementIntoMiddle(atlevents.getAllEventText());
		// Click on All EVents
		Actions ac=new Actions(driver);
		ac.moveToElement(atlevents.getAllEventsTab()).click().perform();
		//atlevents.getAllEventsTab().click();

		// Verify Events List
		try {
			Assert.assertTrue(!atlevents.getatlListOfAllEvents().isEmpty());
			System.out.println("All Events list displayed");
		} catch (Exception e) {
			System.out.println("All Events list not displayed");

		}

		// Click on Market event
		atlevents.getMarketEventsTab().click();

		// Verify Events List
		try {
			Assert.assertTrue(!atlevents.getatlListOfAllEvents().isEmpty());
			System.out.println("MArket Events list displayed");
		} catch (Exception e) {
			System.out.println("Market Events list not displayed");

		}
		// Click on Exhibitor event tab
		atlevents.getatlExhibitorsEventsTab().click();
		// Verify Events List
		try {
			Assert.assertTrue(!atlevents.getatlListOfAllEvents().isEmpty());
			System.out.println("Exhibitor Events list displayed");
		} catch (Exception e) {
			System.out.println("Exhibitor Events list not displayed");

		}
		// Verify Events Search Bar
		Assert.assertTrue(atlevents.getatlEventsSearchBar().isDisplayed());
		System.out.println("Events Search bar is Present");

		// Verify Calendar is displayed or not
		Assert.assertTrue(atlevents.getatlEventsCalendar().isDisplayed());
		System.out.println("Calendar is Present");

		// Verify Select Events Date
		Assert.assertTrue(atlevents.getSelectEventDate().isDisplayed());
		System.out.println("Select Event date is Present");

		// Verify Market name filter
		Assert.assertTrue(atlevents.getMarketFilter().isDisplayed());
		System.out.println("Market Name Filter is Present");

		// Verify Event Type dropdown
		Assert.assertTrue(atlevents.getEventTypeDropdown().isDisplayed());
		System.out.println("Event Type drop down is Present");

	}

	@Test(priority = 2) // groups="Non_MP"
	public void TS002_VerifyAllEventsSearchbarTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T284: All Events: Search bar
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp = new ATLFloorPlansPage(driver);
		atlevents = new ATLEventsAndWebinarPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);
		utl.clickOnEventLinkOfChannel();

		// Click on All Events Event Tab
		Actions ac=new Actions(driver);
		ac.moveToElement(atlevents.getAllEventsTab()).click().perform();
		
		Thread.sleep(3000);
		// check events are available
		WebElement eventDateElement = atlevents.getatlEventDateAndMonth();
		eventDateElement.isDisplayed();

		EventsSearchFuntionality(atlevents.getAllEventsTab());
	}

	@Test(priority = 3) // groups="Non_MP"
	public void TS003_VerifyMarketEventsSearchbarTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T284: Market Events: Search bar
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp = new ATLFloorPlansPage(driver);
		atlevents = new ATLEventsAndWebinarPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Thread.sleep(5000);
		utl.clickOnEventLinkOfChannel();
		
		Actions ac=new Actions(driver);
		ac.moveToElement(atlevents.getMarketEventsTab()).click().perform();
		
		//atlevents.getMarketEventsTab().click();
		Thread.sleep(3000);
		// check events are available
		WebElement eventDateElement = atlevents.getatlEventDateAndMonth();
		eventDateElement.isDisplayed();

		EventsSearchFuntionality(atlevents.getMarketEventsTab());

	}

	@Test(priority = 4) // groups="Non_MP"
	public void TS004_VerifyExhibitorsEventsSearchbarTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T284: Exhibitor Events: Search bar

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp = new ATLFloorPlansPage(driver);
		atlevents = new ATLEventsAndWebinarPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);
		utl.clickOnEventLinkOfChannel();
		Actions ac=new Actions(driver);
		ac.moveToElement(atlevents.getatlExhibitorsEventsTab()).click().perform();
		
		//atlevents.getatlExhibitorsEventsTab().click();
		Thread.sleep(3000);
		// check events are available
		WebElement eventDateElement = atlevents.getatlEventDateAndMonth();
		eventDateElement.isDisplayed();

		EventsSearchFuntionality(atlevents.getatlExhibitorsEventsTab());

	}

	private void EventsSearchFuntionality(WebElement TabName) throws IOException, InterruptedException {

		TabName.click();
		Thread.sleep(5000);

		atlevents.getatlEventsSearchBar().sendKeys(Keys.CONTROL + "a");
		atlevents.getatlEventsSearchBar().sendKeys(Keys.DELETE);
		String eventName = atlevents.getatlEventName().getText();

		// Enter Events Name into Search field
		atlevents.getatlEventsSearchBar().sendKeys(eventName);
		// Click on Search Icon
		atlevents.getatlEventSearchIcon().click();
		Thread.sleep(5000);

		// Verify Searched event dispayed as search result
		// Assert.assertEquals(atlevents.getatlEventName().getText(), eventName);
		utl.checkItemPresentInListorNot(atlevents.getatlListOfEventTitles(), eventName);
		System.out.println("The Event " + eventName + " From " + TabName.getText() + " tab is present");

	}

	@Test(priority = 5) // groups="Non_MP"
	public void TS005_VerifyIMCEventsCalendarViewTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T288: IMC Events: Calendar View
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp = new ATLFloorPlansPage(driver);
		atlevents = new ATLEventsAndWebinarPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		Thread.sleep(5000);

		utl.clickOnEventLinkOfChannel();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Click on IMC Event Tab
		Actions ac=new Actions(driver);
		ac.moveToElement(atlevents.getAllEventsTab()).click().perform();
		// Click on All EVents
		atlevents.getAllEventsTab().click();

		Thread.sleep(2000);
		// Event Month and Year
		String dateText = atlevents.getatlEventDateAndMonth().getText();

		// Regular expression to extract date components
		Pattern pattern = Pattern.compile("(\\w+),\\s(\\w+)\\s(\\d+),\\s(\\d{4})");
		Matcher matcher = pattern.matcher(dateText);

		if (matcher.find()) {
			String month = matcher.group(2);
			String day = matcher.group(3);
			String year = matcher.group(4);

			// Print the separated values
			System.out.println("Date: " + day);
			System.out.println("Month: " + month);
			System.out.println("Year: " + year);
		} else {
			System.out.println("Date format not found!");
		}

		// Current date verification

		// Get the current system date
		LocalDate today = LocalDate.now();
		String formattedDate = today.format(DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy")); // Example: "Friday,
																									// April 04, 2025"
		String dayOfMonth = String.valueOf(today.getDayOfMonth()); // Extract the day (e.g., "4")

		// Locate the current date element (header)
		WebElement dateElement = atlevents.getcurrentDate();
		System.out.println("Current Date on Page: " + dateElement.getText());

		// Locate the highlighted date in the calendar
		WebElement highlightedDate = atlevents.getcurrentDate();

		// Get the text inside the highlighted date
		String highlightedDateText = highlightedDate.getText();

		if (highlightedDateText.equals(dayOfMonth)) {
			System.out.println("The current date (" + dayOfMonth + ") is highlighted in the calendar.");
		} else {
			System.out.println("The current date is NOT highlighted.");
		}

		// Click on Calendar Previous and Next Btn

		// Get the current month-year text (e.g., "April 2025")
		WebElement currentMonthElement = atlevents.getcurrentMonth();
		String currentMonthText = currentMonthElement.getText();
		System.out.println("Current Month: " + currentMonthText);

		// Click the NEXT month button
		WebElement nextButton = atlevents.getatlCalendarNextMonthBtn();
		Thread.sleep(5000);
		//Actions ac=new Actions(driver);
		ac.moveToElement(nextButton).click().perform();
		//nextButton.click();

		Thread.sleep(1000); // wait for calendar to update

		// Get updated month-year
		String nextMonthText = currentMonthElement.getText();
		System.out.println("After clicking Next: " + nextMonthText);

		// Click the PREVIOUS month button
		WebElement prevButton = atlevents.getatlCalendarPrevMonth();
		prevButton.click();

		Thread.sleep(1000); // wait again

		// Get month again after going back
		String backToOriginalText = currentMonthElement.getText();
		System.out.println("After clicking Previous: " + backToOriginalText);
		// Verify Next and Previous month
		Assert.assertTrue(backToOriginalText.equals(currentMonthText));
		System.out.println("Next and Previous month button working");

	}

	@Test(priority = 6)
	public void TS006_VerifySelectedCalendarEventDateAndSearchEventsTest() throws InterruptedException {
		// Verify Selected calendar date date and search events date are same.

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp = new ATLFloorPlansPage(driver);
		atlevents = new ATLEventsAndWebinarPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		Thread.sleep(5000);

		utl.clickOnEventLinkOfChannel();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Click on IMC Event Tab
		Actions ac=new Actions(driver);
		ac.moveToElement(atlevents.getAllEventsTab()).click().perform();
		// Click on All EVents
		atlevents.getAllEventsTab().click();

		String selectedDate = "";

		// Step 1: Try to find the highlighted button (current selected date in
		// calendar)
		
		List<WebElement> highlighted = null;
		try {
		highlighted = atlevents.getheightedEventDates();
		}
		catch (Exception e) {
			WebElement nextButton = atlevents.getatlCalendarNextMonthBtn();
			ac.moveToElement(nextButton).click().perform();
		}

		if (highlighted != null && !highlighted.isEmpty()) {
			// Highlighted date is visible in current calendar month
			WebElement button = highlighted.get(0);
			selectedDate = button.getAttribute("aria-label");
			System.out.println("Selected Date::" + selectedDate);
			
			ac.moveToElement(button).doubleClick().click().perform();

		} else {
			// If no highlighted date, extract date from first event result
			WebElement eventDateElement = atlevents.getatlEventDateAndMonth();

			String dateText = eventDateElement.getText();
			String fullDate = dateText.split(" - ")[0].replaceAll("^[A-Za-z]+, ", "").trim();
			String[] dateParts = fullDate.split(" "); // Format: April 08 2025
			String month = dateParts[0];
			String day = dateParts[1];
			String year = dateParts[2];

			// Navigate calendar to the correct month and year
			while (true) {
				WebElement calendarLabel = atlevents.getcurrentMonth();
				if (calendarLabel.getText().trim().equals(month + " " + year)) {
					break;
				} else {
					atlevents.getatlCalendarNextMonthBtn().click();
					Thread.sleep(1000);
				}
			}

			// Click the date in calendar
			WebElement dayButton = driver.findElement(By.xpath(
					"//abbr[contains(@aria-label,'" + month + " " + Integer.parseInt(day) + ", " + year + "')]"));
			dayButton.click();
			selectedDate = month + " " + Integer.parseInt(day) + ", " + year;
			System.out.println("Selected date is::" + selectedDate);
		}

		// Step 2: Validate filtered events only match selected date
		List<WebElement> filteredEvents = atlevents.getallEventsDatesFromResults();
		boolean allMatch = true;
		for (WebElement event : filteredEvents) {
			String eventText = event.getText();
			if (eventText.contains(selectedDate)) {
				allMatch = true;
				// System.out.println("❌ Mismatched event: " + eventText);
			}
		}

		if (allMatch) {
			System.out.println("✅ All events match the selected calendar date: " + selectedDate);
		} else {
			System.out.println("❌ Some events do not match selected calendar date.");
		}

	}

	@Test(priority = 7)
	public void TS007_VerifyIMCEventsEventsListTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T292: IMC Events: Events List

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp = new ATLFloorPlansPage(driver);
		atlevents = new ATLEventsAndWebinarPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		Thread.sleep(5000);

		utl.clickOnEventLinkOfChannel();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Click on IMC Event Tab
		//utl.scrollElementIntoMiddle(atlevents.getAllEventText());
		Actions ac=new Actions(driver);
		ac.moveToElement(atlevents.getAllEventsTab()).click().perform();
		//atlevents.getAllEventsTab().click();
		// public List<WebElement> exhibitors;
		// Fetch all date block headers like "Friday, April 11, 2025 | 2 Events"
		List<WebElement> dateBlocks = atlevents.getallEventsDatesFromResults();

		// Get all event details using your provided XPaths
		List<WebElement> eventNames = atlevents.getlistOfAllEventNames();
		try {
			exhibitors = atlevents.getlistOfAllExhibtorNamesUnserEvents();
		} catch (Exception e) {
			System.out.println("Exhibitor not present");
		}
		List<WebElement> dateAndTime = atlevents.getlistOfAllDay();
		List<WebElement> locations = atlevents.getListOfAllLocations();
		List<WebElement> learnMoreLinks = atlevents.getListOfAllLearnMoreLinks();
		List<WebElement> eventTypes = atlevents.getListOfAllEventTypes();

		int totalEvents = eventNames.size();

		if (totalEvents != dateAndTime.size() || totalEvents != locations.size() || totalEvents != learnMoreLinks.size()
				) {
			System.out.println("❌ Mismatch in number of elements across event fields. Check your page structure.");
			Assert.assertTrue(false);
			// driver.quit();
			return;
		}

		int currentIndex = 0;

		for (WebElement block : dateBlocks) {
			String blockTitle = block.getText().trim();

			if (!blockTitle.contains("|") || !blockTitle.contains(",")) {
				continue;
			}

			String[] parts = blockTitle.split("\\|");
			String datePart = parts[0].trim(); // e.g., "Friday, April 11, 2025"
			String countPart = parts[1].trim(); // e.g., "2 Events"

			int expectedCount = Integer.parseInt(countPart.split(" ")[0]);

			System.out.println("\n✅ Verifying block: " + blockTitle);

			for (int i = 0; i < expectedCount; i++) {
				try {
					System.out.println("\n🔍 Verifying Event #" + (currentIndex + 1));

					String name = eventNames.get(currentIndex).getText().trim();
					assertNotEmpty(name, "Event Name");
					System.out.println("✅ Event Name is present: " + name);

					String exhibitor = exhibitors.get(currentIndex).getText().trim();
					assertNotEmpty(exhibitor, "Exhibitor");
					System.out.println("✅ Exhibitor is present: " + exhibitor);

					assert dateAndTime.get(currentIndex).isDisplayed() : "Date & Time section is not visible.";
					String dateTimeText = dateAndTime.get(currentIndex).getText().trim();
					System.out.println("✅ Date & Time section is present: " + dateTimeText);

					String[] partsDT = dateTimeText.split(" - ");
					String start = partsDT[0].trim();
					String end = (partsDT.length > 1) ? partsDT[1].trim() : "End time not available";

					String dateOnly = start.replaceAll(",.*", "").trim();
					String timeOnly = end.replaceAll(".*\\d{4}, ", "").trim();

					System.out.println("📅 Date: " + dateOnly);
					System.out.println("⏰ Time: " + timeOnly);

					assert locations.get(currentIndex).isDisplayed() : "Location icon not visible.";
					System.out.println("✅ Location icon is visible");

					String link = learnMoreLinks.get(currentIndex).getAttribute("href");
					assertNotEmpty(link, "Learn More link");
					System.out.println("✅ Learn More link is present: " + link);

					String type = eventTypes.get(currentIndex).getText().trim();
					assertNotEmpty(type, "Event Type");
					System.out.println("✅ Event Type is present: " + type);

				} catch (Exception e) {
					System.out.println("❌ Error verifying event #" + (currentIndex + 1) + ": " + e.getMessage());
				}

				currentIndex++;
			}
		}

		// ✅ Additional: Verify Event Details Page
		System.out.println("\n🎯 Navigating to event detail page for verification...");
		int eventToVerifyIndex = 0; // You can randomize or change this index

		String expectedEventName = eventNames.get(eventToVerifyIndex).getText().trim();
		String expectedExhibitor = exhibitors.get(eventToVerifyIndex).getText().trim();
		String expectedDateTime = dateAndTime.get(eventToVerifyIndex).getText().trim();
		String expectedLocation = locations.get(eventToVerifyIndex).getText().trim();
		String expectedEventType = eventTypes.get(eventToVerifyIndex).getText().trim();

		// Click on event title
		ac.moveToElement(eventNames.get(eventToVerifyIndex)).click().perform();
		//eventNames.get(eventToVerifyIndex).click();
		Thread.sleep(3000); // Use WebDriverWait in actual framework

		// On Event Details Page
		String actualEventName = atlevents.getEventDetailEventTitle().getText().trim();
		//String actualExhibitor = atlevents.getEventDetailExhibitor().getText().trim();
		String actualDateTime = atlevents.getEventDetailDateTime().getText().trim();
		// String actualLocation = atlevents.getEventDetailLocation();
		String actualEventType = atlevents.getEventDetailEventType().getText().trim();

		// Compare
		assert expectedEventName.equals(actualEventName) : "❌ Event Name mismatch!";
		System.out.println("Event Name/ title displayed");
		//assert expectedExhibitor.equals(actualExhibitor) : "❌ Exhibitor mismatch!";
		System.out.println("Exhibitor Name displayed");
		assert actualDateTime.contains(expectedDateTime.split("-")[0].trim()) : "❌ Date/Time mismatch!";
		System.out.println("Date time displayed");
		//atlevents.getEventDetailLocation().isDisplayed();
		//System.out.println("Location  displayed");
		// assert expectedLocation.equals(actualLocation) : "❌ Location mismatch!";
		//assert expectedEventType.equals(actualEventType) : "❌ Event Type mismatch!";
		//System.out.println("Event type displayed");

		System.out.println("✅ Event detail page matches list page data.");
	}

	// ========== Utility Method ==========

	private static void assertNotEmpty(String value, String fieldName) {
		if (value == null || value.trim().isEmpty()) {
			throw new AssertionError(fieldName + " is missing or empty!");
		}
	}

	@Test(priority = 8)
	public void TS008_VerifyExhibitorEventsListTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T292: Exhibitor Events: Events List and Event Details

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp = new ATLFloorPlansPage(driver);
		atlevents = new ATLEventsAndWebinarPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		Thread.sleep(5000);

		utl.clickOnEventLinkOfChannel();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Click on IMC Event Tab
		//utl.scrollElementIntoMiddle(atlevents.getAllEventText());
		Actions ac=new Actions(driver);
		ac.moveToElement(atlevents.getatlExhibitorsEventsTab()).click().perform();
		//.getatlExhibitorsEventsTab().click();

		// Fetch all date block headers like "Friday, April 11, 2025 | 2 Events"
		List<WebElement> dateBlocks = atlevents.getallEventsDatesFromResults();

		// Get all event details using your provided XPaths
		List<WebElement> eventNames = atlevents.getlistOfAllEventNames();
		List<WebElement> exhibitors = atlevents.getlistOfAllExhibtorNamesUnserEvents();
		List<WebElement> dateAndTime = atlevents.getlistOfAllDay();
		List<WebElement> locations = atlevents.getListOfAllLocations();
		List<WebElement> learnMoreLinks = atlevents.getListOfAllLearnMoreLinks();
		List<WebElement> eventTypes = atlevents.getListOfAllEventTypes();

		int totalEvents = eventNames.size();
		

		if (totalEvents != dateAndTime.size() || totalEvents != locations.size() || totalEvents != learnMoreLinks.size()
				) {
					/*
					 * if (totalEvents != exhibitors.size() || totalEvents != dateAndTime.size() ||
					 * totalEvents != locations.size() || totalEvents != learnMoreLinks.size() ||
					 * totalEvents != eventTypes.size()) {
					 */
			System.out.println("❌ Mismatch in number of elements across event fields. Check your page structure.");
			driver.quit();
			return;
		}

		int currentIndex = 0;

		for (WebElement block : dateBlocks) {
			String blockTitle = block.getText().trim();

			if (!blockTitle.contains("|") || !blockTitle.contains(",")) {
				continue;
			}

			String[] parts = blockTitle.split("\\|");
			String datePart = parts[0].trim(); // e.g., "Friday, April 11, 2025"
			String countPart = parts[1].trim(); // e.g., "2 Events"

			int expectedCount = Integer.parseInt(countPart.split(" ")[0]);

			System.out.println("\n✅ Verifying block: " + blockTitle);

			for (int i = 0; i < expectedCount; i++) {
				try {
					System.out.println("\n🔍 Verifying Event #" + (currentIndex + 1));

					String name = eventNames.get(currentIndex).getText().trim();
					assertNotEmpty(name, "Event Name");
					System.out.println("✅ Event Name is present: " + name);

					String exhibitor = exhibitors.get(currentIndex).getText().trim();
					assertNotEmpty(exhibitor, "Exhibitor");
					System.out.println("✅ Exhibitor is present: " + exhibitor);

					assert dateAndTime.get(currentIndex).isDisplayed() : "Date & Time section is not visible.";
					String dateTimeText = dateAndTime.get(currentIndex).getText().trim();
					System.out.println("✅ Date & Time section is present: " + dateTimeText);

					String[] partsDT = dateTimeText.split(" - ");
					String start = partsDT[0].trim();
					String end = (partsDT.length > 1) ? partsDT[1].trim() : "End time not available";

					String dateOnly = start.replaceAll(",.*", "").trim();
					String timeOnly = end.replaceAll(".*\\d{4}, ", "").trim();

					System.out.println("📅 Date: " + dateOnly);
					System.out.println("⏰ Time: " + timeOnly);

					assert locations.get(currentIndex).isDisplayed() : "Location icon not visible.";
					System.out.println("✅ Location icon is visible");

					String link = learnMoreLinks.get(currentIndex).getAttribute("href");
					assertNotEmpty(link, "Learn More link");
					System.out.println("✅ Learn More link is present: " + link);

					String type = eventTypes.get(currentIndex).getText().trim();
					assertNotEmpty(type, "Event Type");
					System.out.println("✅ Event Type is present: " + type);

				} catch (Exception e) {
					System.out.println("❌ Error verifying event #" + (currentIndex + 1) + ": " + e.getMessage());
				}

				currentIndex++;
			}
		}

		// ✅ Additional: Verify Event Details Page
		System.out.println("\n🎯 Navigating to event detail page for verification...");
		int eventToVerifyIndex = 0; // You can randomize or change this index

		String expectedEventName = eventNames.get(eventToVerifyIndex).getText().trim();
		String expectedExhibitor = exhibitors.get(eventToVerifyIndex).getText().trim();
		String expectedDateTime = dateAndTime.get(eventToVerifyIndex).getText().trim();
		String expectedLocation = locations.get(eventToVerifyIndex).getText().trim();
		String expectedEventType = eventTypes.get(eventToVerifyIndex).getText().trim();

		// Click on event title
		eventNames.get(eventToVerifyIndex).click();
		Thread.sleep(3000); // Use WebDriverWait in actual framework

		// On Event Details Page
		String actualEventName = atlevents.getEventDetailEventTitle().getText().trim();
		String actualExhibitor = atlevents.getEventDetailExhibitor().getText().trim();
		String actualDateTime = atlevents.getEventDetailDateTime().getText().trim();
		// String actualLocation = atlevents.getEventDetailLocation();
		String actualEventType = atlevents.getEventDetailEventType().getText().trim();

		// Compare
		assert expectedEventName.equals(actualEventName) : "❌ Event Name mismatch!";
		System.out.println("Event Name/ title displayed");
		assert expectedExhibitor.equals(actualExhibitor) : "❌ Exhibitor mismatch!";
		System.out.println("Exhibitor Name displayed");
		assert actualDateTime.contains(expectedDateTime.split("-")[0].trim()) : "❌ Date/Time mismatch!";
		System.out.println("Date time displayed");
		atlevents.getEventDetailLocation().isDisplayed();
		System.out.println("Location  displayed");
		// assert expectedLocation.equals(actualLocation) : "❌ Location mismatch!";
		assert expectedEventType.equals(actualEventType) : "❌ Event Type mismatch!";
		System.out.println("Event type displayed");

		System.out.println("✅ Event detail page matches list page data.");
	}

	@Test(priority = 9)
	public void TS009_VerifyEventTypeDropdownTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T292: IMC Events: Reset button

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp = new ATLFloorPlansPage(driver);
		atlevents = new ATLEventsAndWebinarPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		Thread.sleep(5000);

		utl.clickOnEventLinkOfChannel();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Click on IMC Event Tab
		utl.scrollElementIntoMiddle(atlevents.getAllEventText());
		// Click on All EVents
		
		Actions ac=new Actions(driver);
		ac.moveToElement(atlevents.getAllEventsTab()).click().perform();
		//atlevents.getAllEventsTab().click();

		// Locate the dropdown
		WebElement dropdown = atlevents.getEventTypeDropwdown();

		Select select = new Select(dropdown);

		// Get all options except the first (usually placeholder like "Event Type")
		List<WebElement> allOptions = select.getOptions();
		for (int i = 1; i < allOptions.size(); i++) {
			String eventTypeToSelect = allOptions.get(i).getText().trim();
			System.out.println("\n🔄 Selecting Event Type: " + eventTypeToSelect);

			// Select from dropdown
			select.selectByVisibleText(eventTypeToSelect);

			// Wait for filtered results to load
			Thread.sleep(2000); // Or use explicit wait on event container

			// Locate all event type labels from the filtered results
			List<WebElement> filteredTypes = atlevents.getListOfAllEventTypes();
			if (filteredTypes.isEmpty()) {
				System.out.println("⚠️ No events found for Event Type: " + eventTypeToSelect);
				continue;
			}

			boolean allMatch = true;

			for (WebElement type : filteredTypes) {
				String resultType = type.getText().trim();
				System.out.println("🔍 Found Event Type: " + resultType);

				if (!resultType.equalsIgnoreCase(eventTypeToSelect)) {
					System.out.println("❌ Mismatch found! Expected: " + eventTypeToSelect + " but got: " + resultType);
					allMatch = false;
				}
			}

			Assert.assertTrue(allMatch, "❌ Some events do not match selected Event Type: " + eventTypeToSelect);
			System.out.println("✅ All results match the selected type: " + eventTypeToSelect);
		}

	}

	@Test(priority = 10)
	public void TS0010_VerifyEventDateRangeSearchBoxTest() throws InterruptedException, IOException, ParseException {
		// The purpose of this test case to verify:
		// UXP-T292: All Events :Event range date box

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp = new ATLFloorPlansPage(driver);
		atlevents = new ATLEventsAndWebinarPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		Thread.sleep(5000);

		utl.clickOnEventLinkOfChannel();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Click on IMC Event Tab
		//utl.scrollElementIntoMiddle(atlevents.getAllEventText());
Actions ac=new Actions(driver);
ac.moveToElement(atlevents.getAllEventsTab()).click().perform();
		//atlevents.getAllEventsTab().click();
		WebElement eventDateElement = atlevents.getatlEventDateAndMonth();
		eventDateElement.isDisplayed();
		DateRangeBoxFunction();
	}

	@Test(priority = 11)
	public void TS0011_VerifyMarketEventDateRangeSearchBoxTest()
			throws InterruptedException, IOException, ParseException {
		// The purpose of this test case to verify:
		// UXP-T292: Market Events :Event range date box

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp = new ATLFloorPlansPage(driver);
		atlevents = new ATLEventsAndWebinarPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		Thread.sleep(5000);

		utl.clickOnEventLinkOfChannel();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Click on IMC Event Tab
		utl.scrollElementIntoMiddle(atlevents.getAllEventText());
		Actions ac=new Actions(driver);
		ac.moveToElement(atlevents.getMarketEventsTab()).build().perform();
		//atlevents.getMarketEventsTab().click();
		WebElement eventDateElement = atlevents.getatlEventDateAndMonth();
		eventDateElement.isDisplayed();
		DateRangeBoxFunction();
	}

	@Test(priority = 12)
	public void TS0012_VerifyExhibitorEventDateRangeSearchBoxTest()
			throws InterruptedException, IOException, ParseException {
		// The purpose of this test case to verify:
		// UXP-T292: Exhibitor Events :Event range date box

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp = new ATLFloorPlansPage(driver);
		atlevents = new ATLEventsAndWebinarPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		Thread.sleep(5000);

		utl.clickOnEventLinkOfChannel();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Click on IMC Event Tab
		//utl.scrollElementIntoMiddle(atlevents.getAllEventText());
		Actions ac=new Actions(driver);
		ac.moveToElement(atlevents.getatlExhibitorsEventsTab()).click().perform();
		//atlevents.getatlExhibitorsEventsTab().click();
		WebElement eventDateElement = atlevents.getatlEventDateAndMonth();
		eventDateElement.isDisplayed();

		DateRangeBoxFunction();

	}

	public void DateRangeBoxFunction() throws InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp = new ATLFloorPlansPage(driver);
		atlevents = new ATLEventsAndWebinarPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		// === 1. Dynamically get today's and future date ===
		LocalDate today = LocalDate.now();
		LocalDate futureDate = today.plusDays(15);
		LocalDate futureDate1 = today.plusDays(1);

		// Format for aria-labels in calendar (e.g., April 15, 2025)
		DateTimeFormatter ariaFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
		String startLabel = today.format(ariaFormatter);
		String endLabel = futureDate.format(ariaFormatter);
		String endLabel1 = futureDate1.format(ariaFormatter);

		// Format for date input field (e.g., 4/15/2025)
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
		String expectedStart = today.format(inputFormatter);
		String expectedEnd = futureDate.format(inputFormatter);
		String expectedEnd1 = futureDate1.format(inputFormatter);

		System.out.println("Start Date:: " + expectedStart);
		System.out.println("End Date:: " + expectedEnd);
		System.out.println("End Date:: " + expectedEnd1);

		// === 2. Select the start and end dates dynamically ===
		WebElement startDate = driver.findElement(By.xpath("//abbr[@aria-label='" + startLabel + "']"));
		utl.scrollElementIntoMiddle(startDate);
		startDate.click();

		try{WebElement endDate = driver.findElement(By.xpath("//abbr[@aria-label='" + endLabel + "']"));
		endDate.click();
		Thread.sleep(3000);
		}catch (Exception e) {
			WebElement endDate = driver.findElement(By.xpath("//abbr[@aria-label='" + endLabel1 + "']"));
			endDate.click();
			Thread.sleep(3000);
		}

		// === 3. Verify the selected date range in input field ===
		List<WebElement> dateInputs = driver.findElements(By.cssSelector(".react-daterange-picker__inputGroup input"));
		Assert.assertTrue(dateInputs.size() >= 6,
				"❌ Could not locate all 6 date inputs (month/day/year for both fields).");

		// Extract start date
		String actualStartMonth = dateInputs.get(1).getAttribute("value");
		String actualStartDay = dateInputs.get(2).getAttribute("value");
		String actualStartYear = dateInputs.get(3).getAttribute("value");

		// Extract end date
		String actualEndMonth = dateInputs.get(5).getAttribute("value");
		String actualEndDay = dateInputs.get(6).getAttribute("value");
		String actualEndYear = dateInputs.get(3).getAttribute("value");

		String actualStart = actualStartMonth + "/" + actualStartDay + "/" + actualStartYear;
		String actualEnd = actualEndMonth + "/" + actualEndDay + "/" + actualEndYear;

		System.out.println("Expected start: " + expectedStart + " | Actual start: " + actualStart);
		System.out.println("Expected end: " + expectedEnd + " | Actual end: " + actualEnd);
		System.out.println("Expected end: " + expectedEnd1 + " | Actual end: " + actualEnd);

		Assert.assertEquals(actualStart, expectedStart, "❌ Start date in input field does not match expected.");
		try {
		if(actualEnd.contains(expectedEnd)) {
			Assert.assertEquals(actualEnd, expectedEnd, "❌ End date in input field does not match expected.");
		}
		
		
		}catch (Exception e) {
			Assert.assertEquals(actualEnd, expectedEnd1, "❌ End date in input field does not match expected.");
		}
		
		try {
		// === 4. Generate list of date numbers (only days) in the selected range ===
		List<String> dateOnlyList = new ArrayList<>();
		LocalDate pointer = today;
		while (!pointer.isAfter(futureDate)) {
			String dayOnly = String.valueOf(pointer.getDayOfMonth());
			dateOnlyList.add(dayOnly);
			pointer = pointer.plusDays(1);
		}
		System.out.println("Date range (day only): " + dateOnlyList);

		WebElement eventDateElement = atlevents.getatlEventDateAndMonth();

		String dateText = eventDateElement.getText();
		String fullDate = dateText.split(" - ")[0].replaceAll("^[A-Za-z]+, ", "").trim();
		String[] dateParts = fullDate.split(" "); // Format: April 08 2025
		String month = dateParts[0];
		String day = dateParts[1];
		String year = dateParts[2];

		// === 5. Check if extracted day is present in the selected date range list ===
		String eventDay = day.replace(",", "").trim(); // e.g., "07"
		eventDay = eventDay.replaceFirst("^0+", ""); // Removes leading zeros, e.g., "7"
		System.out.println("🎯 Event day from title: " + eventDay);

		if (dateOnlyList.contains(eventDay)) {
			System.out.println("✅ Event date is within the selected date range.");
		} else {
			Assert.fail("❌ Event date " + eventDay + " is NOT within the selected date range: " + dateOnlyList);
		}
		}catch (Exception e) {
			System.out.println("No Events are available in selected range");
		}

	}

	@Test(priority = 13)
	public void TS0013_VerifyEventCalendarResetButtonTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T292: IMC Events: Reset button

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp = new ATLFloorPlansPage(driver);
		atlevents = new ATLEventsAndWebinarPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		Thread.sleep(5000);

		utl.clickOnEventLinkOfChannel();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Click on IMC Event Tab
		//utl.scrollElementIntoMiddle(atlevents.getAllEventText());
		Actions ac=new Actions(driver);
		ac.moveToElement(atlevents.getAllEventsTab()).click().perform();
		// Click on All EVents
		atlevents.getAllEventsTab().click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Step 1: Capture today's month (before doing anything)
		String currentMonth = atlevents.getcurrentMonth().getText().trim();
		System.out.println("📅 Current month: " + currentMonth);

		// Step 2: Go to next month
		ac.moveToElement(atlevents.getatlCalendarNextMonthBtn()).click().perform();
		//atlevents.getatlCalendarNextMonthBtn().click();
		Thread.sleep(1000); // use explicit wait if needed
		String newMonth = atlevents.getcurrentMonth().getText().trim();
		assert !newMonth.equals(currentMonth) : "Failed to navigate to next month";

		System.out.println("➡️ Navigated to: " + newMonth);

		// Step 3: Select any date
		WebElement date = atlevents.getselectAnyDateFromCalendar();
		String selectedDateText = date.getText();
		
		ac.doubleClick(date).perform();
		// date.click();
		Thread.sleep(500);
		// assert driver.findElement(selectedDate).isDisplayed() : "Date not selected!";
		System.out.println("📌 Selected date: " + selectedDateText);

		// Step 4: Click Reset
		atlevents.getatlResetBtn().click();
		Thread.sleep(1000); // wait for reset to take effect

		// Step 5: Verify calendar reset to current month
		String resetMonth = atlevents.getcurrentMonth().getText().trim();
		assert resetMonth.equals(currentMonth) : "Reset failed to return to current month";
		System.out.println("✅ Calendar reset to: " + resetMonth);

	}

//old code starts		

	// @Test(priority = 6) // groups="Non_MP"
	public void TS006_VerifyExhibitorEventsSearchbarTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T304: Exhibitor Events: Search bar
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp = new ATLFloorPlansPage(driver);
		atlevents = new ATLEventsAndWebinarPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		Thread.sleep(5000);
		utl.clickOnEventLinkOfChannel();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		/*
		 * // Click on Attend Tab atlevents.getatlAttendTab().click();
		 * Thread.sleep(2000); //click on Events Link
		 * atlevents.getatlEventsLink().click(); Thread.sleep(3000);
		 */
		// Click on Exh Event Tab
		utl.scrollElementIntoMiddle(atlevents.getatlExhibitorsEventsTab());
		atlevents.getatlExhibitorsEventsTab().click();
		Thread.sleep(500);
		// Click on Search Bar of IMC Events
		atlevents.getatlEventsSearchBar().click();
		Thread.sleep(500);
		String eventName = atlevents.getatlEventName().getText();
		// Enter Events Name into Search field
		atlevents.getatlEventsSearchBar().sendKeys(eventName);
		// Click on Search Icon
		atlevents.getatlEventSearchIcon().click();
		Thread.sleep(5000);
		// Verify Searched event dispayed as search result
		// Assert.assertEquals(atlevents.getatlEventName().getText(), eventName);
		utl.checkItemPresentInListorNot(atlevents.getatlListOfEventTitles(), eventName);
	}

	// @Test(priority = 7) // groups="Non_MP"
	public void TS007_VerifyExhibitorEventsCalendarViewTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T305: Exhibitor Events: Calendar View
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp = new ATLFloorPlansPage(driver);
		atlevents = new ATLEventsAndWebinarPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);
		utl.clickOnEventLinkOfChannel();

		// Click on Exh Event Tab
		utl.scrollElementIntoMiddle(atlevents.getatlExhibitorsEventsTab());
		atlevents.getatlExhibitorsEventsTab().click();

		Thread.sleep(2000);
		// Event Month and Year
		String eventDateAndMonth = atlevents.getatlEventDateAndMonth().getText();
		String trimDate = eventDateAndMonth.split(" ")[2].trim();
		// System.out.println(trimDate);
		Thread.sleep(2000);
		String date = trimDate.replaceAll("[,]", "");
		String trimOnlyDate = date.split(" ")[0].trim();
		String replaceDate = trimOnlyDate.replaceFirst("^0+(?!$)", "");
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
			System.out.println("Current Date " + atlevents.getatlTodaysDate().getText() + " is Heighlighted");
		} catch (Exception e) {
			Assert.assertTrue(d.contains(atlevents.getatlTodaysDatePROD().getText()));
			System.out.println("Current Date " + atlevents.getatlTodaysDatePROD().getText() + " is Heighlighted");
		}
		// Current Month
		DateTimeFormatter month = DateTimeFormatter.ofPattern("MMM");
		LocalDate localMonth = LocalDate.now();
		LocalDate prevMonth = localMonth.minusMonths(1);

		String m = month.format(localMonth);// current month
		String mm = month.format(prevMonth);// previous month

		System.out.println("Current Month ::" + m);
		System.out.println("Previous Month ::" + mm);

		// Click on Calendar Prev Btn
		utl.scrollElementIntoMiddle(atlevents.getatlCalendarPrevMonth());
		Thread.sleep(200);
		atlevents.getatlCalendarPrevMonth().click();
		Thread.sleep(500);
		System.out.println("Previous Month From Calendar ::" + atlevents.getatlSelectMonth().getText());
		Assert.assertTrue(atlevents.getatlSelectMonth().getText().contains(mm));
		System.out.println("Previous Month " + atlevents.getatlSelectMonth().getText() + " is selected");
		// utl.selectFilters(atlevents.getatlListOfatlSelectAnyDate(), replaceDate);

		utl.scrollElementIntoMiddle(atlevents.getatlCalendarNextMonthBtn());
		Thread.sleep(200);
		atlevents.getatlCalendarNextMonthBtn().click();
		Thread.sleep(5000);

		if (atlevents.getatlSelectMonth().getText().contains(EventmonthAndYear)) {
			try {
				Assert.assertTrue(atlevents.getatlTodaysDatePROD().isDisplayed());
				atlevents.getatlTodaysDatePROD().click();
				Thread.sleep(500);
			} catch (Exception e) {
				utl.selectFilters(atlevents.getatlListOfEventDate(), replaceDate);
			}
		}
		// Verify Event is selected by datepicker
		Assert.assertTrue(atlevents.getatlEventDateAndMonth().isDisplayed());
		System.out.println("Event is selected by Date");

		// Click on Reset Btn
		utl.scrollElementIntoMiddle(atlevents.getatlResetBtn());
		Thread.sleep(200);
		atlevents.getatlResetBtn().click();
		Thread.sleep(500);
		// Verify Current date and month should selected by default
		try {
			Assert.assertTrue(d.contains(atlevents.getatlTodaysDate().getText()));
			System.out.println("By Default " + d + " today's date is selected.");
		} catch (Exception e) {
			Assert.assertTrue(d.contains(atlevents.getatlTodaysDatePROD().getText()));
			System.out.println("By Default " + d + " today's date is selected.");
		}
		Thread.sleep(5000);
	}

	// @Test(priority = 8) // Previous priority = 11,groups="Non_MP"
	public void TS008_VerifyExhibitorEventsListTestOld() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T306: Exhibitor Events: Events List
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp = new ATLFloorPlansPage(driver);
		atlevents = new ATLEventsAndWebinarPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.clickOnEventLinkOfChannel();

		// Click on Exh Event Tab
		Thread.sleep(15000);
		utl.scrollElementIntoMiddle(atlevents.getatlExhibitorsEventsTab());
		atlevents.getatlExhibitorsEventsTab().click();
		Thread.sleep(3000);

		// Verify Event Calendar title
		Assert.assertTrue(atlevents.getatlEventDateAndMonth().isDisplayed());
		System.out.println("Event Calendar title is displayed");

		int allEventcount = 0;
		for (WebElement allEvents : atlevents.getatlListOfAllEvents()) {
			allEventcount++;
			allEvents.isDisplayed();
		}
		System.out.println(allEventcount + " Events Present");

		// Verify Events Titles
		int allEventTitlesCount = 0;
		for (WebElement eventTitles : atlevents.getatlListOfEventTitles()) {
			allEventTitlesCount++;
			Assert.assertTrue(eventTitles.isDisplayed());
			String title = eventTitles.getText();
			List<WebElement> SeeAllLinks = driver.findElements(By.linkText(title));
			// Verify See Details HyperLinks
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
		// driver.navigate().refresh();

		// Click on Event Title page
		int allEventSeeDetailsLinkCount1 = 0;
		for (int i = 0; i < atlevents.getatlListOfEventTitles().size(); i++) {
			allEventSeeDetailsLinkCount1++;
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			// Thread.sleep(5000);
			WebElement eventTitleLink = atlevents.getatlListOfEventTitles().get(i);
			String eventTitle = eventTitleLink.getText();
			Assert.assertTrue(eventTitleLink.isDisplayed());
			// eventSeeDetailsLink = atlevents.atlatlListOfAllEventsSeeDetailsLink().get(1);
			// WebDriverWait wait = new WebDriverWait(driver,30);//new added
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("eventTitleLink")));
			utl.scrollElementIntoMiddle(eventTitleLink);
			Thread.sleep(2000);
			eventTitleLink.click();

			Thread.sleep(15000);
			driver.navigate().refresh();
			// Verify Event Details Page
			Assert.assertTrue(eventTitle.contains(atlevents.getatlEventNameOnDetailsPage().getText()));
			driver.navigate().back();

			Thread.sleep(500);
			// Click on Exh Event Tab
			utl.scrollElementIntoMiddle(atlevents.getatlExhibitorsEventsTab());
			Thread.sleep(500);
			atlevents.getatlExhibitorsEventsTab().click();
			Thread.sleep(2000);
			// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}

		System.out.println(allEventSeeDetailsLinkCount + " Events Details Page displayed");
		Assert.assertEquals(allEventcount, allEventSeeDetailsLinkCount1);
	}

	// @Test(priority = 9) // groups="Non_MP"
	public void TS009_VerifyExhibitorEventsDetailstTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T307: Exhibitor Events: Event Details
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp = new ATLFloorPlansPage(driver);
		atlevents = new ATLEventsAndWebinarPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);
		utl.clickOnEventLinkOfChannel();
		Thread.sleep(2000);

		// Click on Exh Event Tab
		utl.scrollElementIntoMiddle(atlevents.getatlExhibitorsEventsTab());
		Thread.sleep(200);
		atlevents.getatlExhibitorsEventsTab().click();
		Thread.sleep(1000);

		// Click on IMC Event Tab
		// atlevents.getatlImcEventsTab().click();
		String eventTitle = atlevents.getatlClickOnEvent().getText();
		System.out.println("Title of Event card: " + eventTitle);

		utl.scrollElementIntoMiddle(atlevents.getatlClickOnEvent());
		Thread.sleep(200);
		atlevents.getatlClickOnEvent().click();
		Thread.sleep(2000);
		String titleOfEvent = atlevents.getatlEventNameOnDetailsPage().getText();
		System.out.println("Title of Event Details: " + titleOfEvent);
		Assert.assertTrue(eventTitle.contains(titleOfEvent));

		// Verify Location Link
		utl.scrollElementIntoMiddle(atlevents.getatlEventLocationLink());
		Thread.sleep(200);
		Assert.assertTrue(atlevents.getatlEventLocationLink().isDisplayed());
		System.out.println("Events Location link displayed");

		// Verify Event Type
		Assert.assertTrue(atlevents.getatlEventType().isDisplayed());
		System.out.println("Event Type displayed");

		// Verify Add Fav Icon
		/*
		 * Assert.assertTrue(atlevents.getatlFavIcon().isDisplayed());
		 * System.out.println("Add Fav Icon displayed"); //Verify Add Fav Icon
		 * Assert.assertTrue(atlevents.getatlListIcon().isDisplayed());
		 * System.out.println("Add List Icon displayed"); //Verify Add Fav Icon
		 * Assert.assertTrue(atlevents.getatlNoteIcon().isDisplayed());
		 * System.out.println("Add Note Icon displayed");
		 */
		// Verify Add Fav Icon
		/*
		 * Assert.assertTrue(atlevents.getatlCalendarIcon().isDisplayed());
		 * System.out.println("Calendar displayed");
		 */
		// Verify Add Fav Icon
		/*
		 * Assert.assertTrue(atlevents.getatlTagIcon().isDisplayed());
		 * System.out.println("Tag displayed");
		 */
		Thread.sleep(1000);

		// Click on Location link
		utl.scrollElementIntoMiddle(atlevents.getatlEventLocationLink());
		Thread.sleep(200);
		String locationURL = atlevents.getatlEventLocationLink().getAttribute("href");
		System.out.println("Location URL: " + locationURL);
		atlevents.getatlEventLocationLink().click();
		// Verify Location floor plan page
		System.out.println("Current URL: " + driver.getCurrentUrl());
		// Assert.assertTrue(driver.getCurrentUrl().contains(locationURL));

		/*
		 * //Click on Tags String
		 * searchResultPageURL=atlevents.getatlEventsTag().getAttribute("href");
		 * atlevents.getatlEventsTag().click();
		 * Assert.assertTrue(searchResultPageURL.contains(driver.getCurrentUrl()));
		 * Assert.assertTrue(atlevents.getatlSearchResultsTitle().getText().
		 * contains("Search Results"));
		 * System.out.println("Search Results page opened");
		 */

		// Click on Event Title page

		// driver.navigate().back();
		// Click on Exh Event Tab
		// atlevents.getatlExhibitorsEventsTab().click();
		/*
		 * int allEventSeeDetailsLinkCount1 = 0; for (int i = 0; i <
		 * atlevents.getatlListOfEventTitles().size(); i++) {
		 * allEventSeeDetailsLinkCount1++; WebElement eventTitleLink =
		 * atlevents.getatlListOfEventTitles().get(i);
		 * 
		 * // eventSeeDetailsLink =
		 * atlevents.atlatlListOfAllEventsSeeDetailsLink().get(1);
		 * eventTitleLink.click(); // Verify Event Details Page
		 * //Assert.assertTrue(eventTitle.contains(atlevents.
		 * getatlEventNameOnDetailsPage().getText())); Thread.sleep(2000); try {
		 * if(atlevents.getatlEventsTag().isDisplayed()) { String
		 * searchResultPageURL=atlevents.getatlEventsTag().getAttribute("href");
		 * atlevents.getatlEventsTag().click();
		 * Assert.assertTrue(searchResultPageURL.contains(driver.getCurrentUrl()));
		 * Assert.assertTrue(atlevents.getatlSearchResultsTitle().getText().
		 * contains("Search Results"));
		 * System.out.println("Search Results page opened"); break; }
		 * 
		 * }catch(Exception e) { e.printStackTrace(); driver.navigate().back();
		 * Thread.sleep(2000); //Click on Exh Event Tab
		 * //atlevents.getatlExhibitorsEventsTab().click(); System.out.println(i);
		 * System.out.println(atlevents.getatlListOfEventTitles().size());
		 * if(atlevents.getatlListOfEventTitles().size() == i+1) {
		 * System.out.println("Tags are not present"); Assert.assertTrue(i==
		 * atlevents.getatlListOfEventTitles().size()); } } }
		 */
	}

	@Test(enabled = false)
	public void verifyMPLoginFunctionality() throws IOException, InterruptedException {

		// The purpose of this test case to verify:-
		// TS1- Login to Market Planner

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);

		// Click on Login button from Landing Page
		lap.getLogin().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Enter the credentials on Login Page and click
		lp.getEmailAddress().sendKeys((prop.getProperty("username")));

		lp.getPassword().sendKeys((prop.getProperty("passwordW")));

		Thread.sleep(1000);
		// lp.getPassword().sendKeys((prop.getProperty("password")));
		Thread.sleep(1000);

		lp.getSignInBtn().click();
		Thread.sleep(15000);
		Assert.assertTrue(driver.getTitle().contains("Atlanta Market at AmericasMart"));
	}

	@Test(enabled = false) // priority = 6,groups= "MP_Group",dependsOnMethods=
							// "verifyMPLoginFunctionality"
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

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Login to MP
		//// utl.verifyMPLoginFunctionality();
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

	@Test(enabled = false) // priority = 8,groups= "MP_Group",dependsOnMethods=
							// "verifyMPLoginFunctionality"
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
		 * // Login to MP
		 * 
		 * //utl.verifyMPLoginFunctionality(); Thread.sleep(5000);
		 */

		utl.clickOnEventLinkOfChannel();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);
		String eventTitle = atlevents.getatlClickOnEvent().getText();

		// Click on IMC Event Tab
		atlevents.getatlImcEventsTab().click();
		// Click on Any Event title

		atlevents.getatlClickOnEvent().click();

		Assert.assertTrue(eventTitle.contains(atlevents.getatlEventNameOnDetailsPage().getText()));

		// Click on Add to List Icon

		atlevents.getatlNoteIcon().click();

		/*
		 * Thread.sleep(5000);
		 * lp.getEmailAddress().sendKeys((prop.getProperty("username")));
		 * lp.getPassword().sendKeys((prop.getProperty("password")));
		 * 
		 * lp.getSignInBtn().click(); atlevents.getatlNoteIcon().click();
		 */
		// Store the new note name
		String newnotetitle = "CybNote" + genData.generateRandomString(3);
		System.out.println("Newly added Note is: " + newnotetitle);

		// Enter Note title
		WebElement noteTitleTxt = atlexhact.getNoteTitleTxtBx();
		noteTitleTxt.sendKeys(newnotetitle);
		Thread.sleep(5000);
		// Enter Note Content
		String noteContent = "TestProdNote" + genData.generateRandomString(6);
		WebElement noteContentTxt = atlexhact.getNoteContentTxtBx();
		noteContentTxt.sendKeys(noteContent);
		Thread.sleep(5000);
		noteTitleTxt.sendKeys(newnotetitle);
		Thread.sleep(5000);
		// atlexhact.getNoteTitleTxtBx().sendKeys(newnotetitle);
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

		// Verify that recently added note should be appear on 'All Notes For Exhibitor'
		// modal
		for (int i = 0; i < allnoteslist.size(); i++) {
			// System.out.println(allnoteslist.get(i).getText());
			if (allnoteslist.get(i).getText().equals(newnotetitle)) {
				allnoteslist.get(i).click();

				break;
			}
		}

		// Delete the saved note
		atlexhact.getDeleteNoteBtn().click();
	}

	@Test(enabled = false) // priority = 13,groups= "MP_Group",dependsOnMethods=
							// "verifyMPLoginFunctionality"
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

		// Login to MP
		//// utl.verifyMPLoginFunctionality();

		utl.clickOnEventLinkOfChannel();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String eventTitle = atlevents.getatlClickOnEvent().getText();

		/*
		 * // Click on IMC Event Tab atlevents.getatlImcEventsTab().click();
		 */
		// Click on Exh Event Tab
		atlevents.getatlExhibitorsEventsTab().click();
		// Click on Any Event title

		atlevents.getatlClickOnEvent().click();

		// Assert.assertTrue(eventTitle.contains(atlevents.getatlEventNameOnDetailsPage().getText()));

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

	@Test(enabled = false) // priority = 14,groups= "MP_Group",dependsOnMethods=
							// "verifyMPLoginFunctionality"
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
		//// utl.verifyMPLoginFunctionality();
		Thread.sleep(5000);

		utl.clickOnEventLinkOfChannel();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String eventTitle = atlevents.getatlClickOnEvent().getText();
		// Click on Exh Event Tab
		atlevents.getatlExhibitorsEventsTab().click();
		/*
		 * // Click on IMC Event Tab atlevents.getatlImcEventsTab().click();
		 */
		// Click on Any Event title

		atlevents.getatlClickOnEvent().click();

		// Assert.assertTrue(eventTitle.contains(atlevents.getatlEventNameOnDetailsPage().getText()));

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
		// atlmppge.getATLMPAddToSelectedBtn().click();
		Thread.sleep(2000);
		// Click on Go to Market Planner button
		atlmppge.getGoToMarketPlannerBtn().click();

		// Click on Lists tab on MP home page
		atlmppge.getMPHomeListsTab().click();
		atlmppge.getListsPageListsMenu().click();

		mplists = atlmppge.getATLMPListsNames();
		mpeditlistoptns = atlmppge.getATLMPEditListOptns();

		for (int i = 0; i < mplists.size(); i++) {
			// System.out.println(mplists.get(i).getText());
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

	@Test(enabled = false) // priority = 15,groups= "MP_Group",dependsOnMethods=
							// "verifyMPLoginFunctionality"
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

		// //utl.verifyMPLoginFunctionality(); Thread.sleep(5000);
		Thread.sleep(5000);
		utl.clickOnEventLinkOfChannel();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// String eventTitle = atlevents.getatlClickOnEvent().getText();

		// Click on Exh Event Tab
		atlevents.getatlExhibitorsEventsTab().click();
		String eventTitle = atlevents.getatlClickOnEvent().getText();
		/*
		 * // Click on IMC Event Tab atlevents.getatlImcEventsTab().click();
		 */
		// Click on Any Event title

		atlevents.getatlClickOnEvent().click();

		// Assert.assertTrue(eventTitle.contains(atlevents.getatlEventNameOnDetailsPage().getText()));

		// Click on Add to List Icon

		atlevents.getatlNoteIcon().click();

		/*
		 * Thread.sleep(5000);
		 * lp.getEmailAddress().sendKeys((prop.getProperty("username")));
		 * lp.getPassword().sendKeys((prop.getProperty("password")));
		 * 
		 * lp.getSignInBtn().click(); atlevents.getatlNoteIcon().click();
		 */
		// Store the new note name
		String newnotetitle = "CybNote" + genData.generateRandomString(3);
		System.out.println("Newly added Note is: " + newnotetitle);

		// Enter Note title
		WebElement noteTitleTxt = atlexhact.getNoteTitleTxtBx();
		noteTitleTxt.sendKeys(newnotetitle);
		Thread.sleep(5000);
		// Enter Note Content
		String noteContent = "TestProdNote" + genData.generateRandomString(6);
		WebElement noteContentTxt = atlexhact.getNoteContentTxtBx();
		noteContentTxt.sendKeys(noteContent);
		Thread.sleep(5000);
		noteTitleTxt.sendKeys(newnotetitle);
		Thread.sleep(5000);
		// atlexhact.getNoteTitleTxtBx().sendKeys(newnotetitle);
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

		// Verify that recently added note should be appear on 'All Notes For Exhibitor'
		// modal
		for (int i = 0; i < allnoteslist.size(); i++) {
			// System.out.println(allnoteslist.get(i).getText());
			if (allnoteslist.get(i).getText().equals(newnotetitle)) {
				allnoteslist.get(i).click();

				break;
			}
		}

		// Delete the saved note
		atlexhact.getDeleteNoteBtn().click();
	}

	@Test(enabled = false) // priority = 16,groups= "MP_Group",dependsOnMethods=
							// "verifyMPLoginFunctionality"
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
		/*
		 * //utl.verifyMPLoginFunctionality(); Thread.sleep(5000);
		 */
		utl.clickOnEventLinkOfChannel();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		String eventTitle = atlevents.getatlClickOnEvent().getText();
		System.out.println("Event Name :: " + eventTitle);

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
		// atlmppge.getATLMPAddToSelectedBtn().click();
		Thread.sleep(2000);
		// Click on Go to Market Planner button
		// utl.clickOnEventLinkOfChannel();

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

		/*
		 * // Delete that added line from list
		 * atlmppge.getATLEditListItemMoreBtn().click();
		 * atlmppge.getATLEditListItemDeleteOptn().click(); Thread.sleep(8000);
		 */
		// Delete that added exhibitor from list
		atlmppge.getmoreOptionUAT_LVM().click();
		atlmppge.getmoreEventOptionDeleteBtnUAT_LVM().click();
		Thread.sleep(8000);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		// driver.quit();
	}

}
