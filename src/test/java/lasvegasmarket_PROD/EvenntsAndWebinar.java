package lasvegasmarket_PROD;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
			allnoteslist, favlist, searchlinetypelist;

	@BeforeClass
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);

		// Navigate to Atlanta Market site
		driver.manage().window().maximize();
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

		// Click on All EVents
		atlevents.getAllEventsTab().click();

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

		//Verify Market name filter
		Assert.assertTrue(atlevents.getMarketFilter().isDisplayed());
		System.out.println("Market Name Filter is Present");		
		
		//Verify Event Type dropdown
		Assert.assertTrue(atlevents.getEventTypeDropdown().isDisplayed());
		System.out.println("Event Type drop down is Present");		
		
	}

	@Test(priority = 2) // groups="Non_MP"
	public void TS002_VerifyIMCEventsSearchbarTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T284: IMC Events: Search bar
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

		// Click on IMC Event Tab
		utl.scrollElementIntoMiddle(atlevents.getatlExhibitorsEventsTab());
		atlevents.getAllEventsTab().click();
		Thread.sleep(500);

		String eventName = atlevents.getatlEventName().getText();


		// Enter Events Name into Search field
		atlevents.getatlEventsSearchBar().sendKeys(eventName);
		// Click on Search Icon
		atlevents.getatlEventSearchIcon().click();
		Thread.sleep(5000);
		

		// Enter Events Name into Search field
		atlevents.getatlEventsSearchBar().sendKeys(eventName);
		

		// Enter Events Name into Search field
		atlevents.getatlEventsSearchBar().sendKeys(Keys.ENTER);
		
		// Verify Searched event dispayed as search result
		// Assert.assertEquals(atlevents.getatlEventName().getText(), eventName);
		utl.checkItemPresentInListorNot(atlevents.getatlListOfEventTitles(), eventName);

	}

	@Test(priority = 3) // groups="Non_MP"
	public void TS003_VerifyIMCEventsCalendarViewTest() throws InterruptedException, IOException {
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
		utl.scrollElementIntoMiddle(atlevents.getAllEventsTab());
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
		
		//Current date verification
		
		// Get the current system date
        LocalDate today = LocalDate.now();
        String formattedDate = today.format(DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy")); // Example: "Friday, April 04, 2025"
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
        nextButton.click();

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
        //Verify Next and Previous month
        Assert.assertTrue(backToOriginalText.equals(currentMonthText));
        System.out.println("Next and Previous month button working");
  
	}
	@Test(priority = 4)
	public void VerifySelectedCalendarEventDateAndSearchEventsTest() throws InterruptedException {
		//Verify Selected calendar date date and search events date are same.
		
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
		utl.scrollElementIntoMiddle(atlevents.getAllEventsTab());
		// Click on All EVents
		atlevents.getAllEventsTab().click();
		
		  String selectedDate = "";

          // Step 1: Try to find the highlighted button (current selected date in calendar)
          List<WebElement> highlighted = atlevents.getheightedEventDates();

          if (highlighted != null && !highlighted.isEmpty()) {
              // Highlighted date is visible in current calendar month
              WebElement button = highlighted.get(0);
              selectedDate = button.getAttribute("aria-label");
              System.out.println("Selected Date::" +selectedDate);
              Actions ac=new Actions(driver);
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
              WebElement dayButton = driver.findElement(By.xpath("//abbr[contains(@aria-label,'" + month + " " + Integer.parseInt(day) + ", " + year + "')]"));
              dayButton.click();
              selectedDate = month + " " + Integer.parseInt(day) + ", " + year;
              System.out.println("Selected date is::" +selectedDate);
          }

          // Step 2: Validate filtered events only match selected date
          List<WebElement> filteredEvents = atlevents.getallEventsDatesFromResults();
          boolean allMatch = true;
          for (WebElement event : filteredEvents) {
              String eventText = event.getText();
              if (eventText.contains(selectedDate)) {
                  allMatch = true;
                  //System.out.println("❌ Mismatched event: " + eventText);
              }
          }

          if (allMatch) {
              System.out.println("✅ All events match the selected calendar date: " + selectedDate);
          } else {
              System.out.println("❌ Some events do not match selected calendar date.");
          }
		
	}
	
	
	@Test(priority = 4) // groups="Non_MP"
	public void TS004_VerifyIMCEventsEventsListTest() throws InterruptedException, IOException {
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
		
		
		// 1. Get all event date blocks
        List<WebElement> eventDateBlocks = atlevents.getallEventsDatesFromResults();

        String previousDate = "";
        
        for (WebElement dateBlock : eventDateBlocks) {
            // Split the header into date and count
            String fullText = dateBlock.getText();
            String[] parts = fullText.split("\\|");
            String dateText = parts[0].trim(); // e.g. Tuesday, April 08, 2025
            String eventCountText = parts[1].trim(); // e.g. 2 Events

            // ✅ Verify date is in increasing order
            if (!previousDate.isEmpty()) {
                if (isDateBefore(dateText, previousDate)) {
                    System.out.println("❌ Dates are not in increasing order: " + dateText + " comes before " + previousDate);
                }
            }
            previousDate = dateText;

            // ✅ Extract and verify number of events
            int expectedEventCount = Integer.parseInt(eventCountText.split(" ")[0]);
            
            List<WebElement> events = driver.findElements(
            		By.xpath("//p[contains(text(),'"+fullText+"')]/../div"));
            if (events.size() != expectedEventCount) {
                System.out.println("❌ Event count mismatch for " + dateText);
            }

            // 2. Validate each event block under this date
            for (WebElement event : events) {
                // ✅ Event Name
                WebElement eventName = event.findElement(By.cssSelector(".event-title"));
                System.out.println("Event Name: " + eventName.getText());

                // ✅ Exhibitor Name and Link
                WebElement exhibitor = event.findElement(By.cssSelector(".event-exhibitor"));
                WebElement exhibitorLink = exhibitor.findElement(By.tagName("a"));
                System.out.println("Exhibitor Name: " + exhibitorLink.getText());
                System.out.println("Exhibitor Link: " + exhibitorLink.getAttribute("href"));

                // ✅ Date & Time
                WebElement dateTime = event.findElement(By.cssSelector(".event-date-time"));
                System.out.println("Date and Time: " + dateTime.getText());

                // ✅ Location
                WebElement location = event.findElement(By.cssSelector(".event-location"));
                System.out.println("Location: " + location.getText());

                // ✅ Learn More Link
                WebElement learnMore = event.findElement(By.linkText("Learn More"));
                System.out.println("Learn More Link: " + learnMore.getAttribute("href"));

                // ✅ Event Type (Top right)
                WebElement type = event.findElement(By.cssSelector(".event-type"));
                System.out.println("Event Type: " + type.getText());

                // ✅ Exhibitor Image
                WebElement image = event.findElement(By.cssSelector("img"));
                String imgSrc = image.getAttribute("src");
                if (imgSrc == null || imgSrc.isEmpty()) {
                    System.out.println("❌ Missing image for event: " + eventName.getText());
                } else {
                    System.out.println("Image found: " + imgSrc);
                }

                System.out.println("------------------------------");
            }
        }
    }

    // Helper to compare dates (format: Tuesday, April 08, 2025)
    private boolean isDateBefore(String current, String previous) {
        try {
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("EEEE, MMMM dd, yyyy");
            return sdf.parse(current).before(sdf.parse(previous));
        } catch (Exception e) {
            System.out.println("Error parsing dates: " + e.getMessage());
            return false;
        }
		
		
		
		
		
		
		
		

		//All Events Tab
		
		
		//Verify Calendar Title
		
		
		
		//Verify Event Name
		
		
		//Verify Exhibitor Name and is a link
		
		
		//Verify Date 
		
		
		//Verify Time
		
		
		//Verify Location
		
		
		//Verify Learn More Link
		
		
		//Verify Event type [Right top corner]
		
		
		//Verify Exhibitor image link
        // 1. Get all date headers and events in order as a flat list
        List<WebElement> allElements = driver.findElements(By.cssSelector(".date-or-event"));

        String previousDate = "";
        String currentDateText = "";
        int expectedCount = 0;
        List<WebElement> currentEventGroup = new ArrayList<>();

        for (WebElement el : allElements) {
            String className = el.getAttribute("class");

            if (className.contains("event-date-block")) {
                // ✅ We found a new date block – process previous if it exists
                if (!currentDateText.isEmpty()) {
                    validateEventGroup(currentDateText, expectedCount, currentEventGroup);
                    currentEventGroup.clear();
                }

                // Set new date block
                String[] parts = el.getText().split("\\|");
                currentDateText = parts[0].trim();
                expectedCount = Integer.parseInt(parts[1].trim().split(" ")[0]);

                // Check order
                if (!previousDate.isEmpty()) {
                    if (isDateBefore(currentDateText, previousDate)) {
                        System.out.println("❌ Dates not in increasing order: " + currentDateText + " before " + previousDate);
                    }
                }
                previousDate = currentDateText;

            } else if (className.contains("event-card")) {
                currentEventGroup.add(el);
            }
        }

        // Process last group
        if (!currentEventGroup.isEmpty()) {
            validateEventGroup(currentDateText, expectedCount, currentEventGroup);
        }
    }

    // Validate all events in one date group
    private void validateEventGroup(String dateText, int expectedCount, List<WebElement> eventCards) {
        System.out.println("📅 Validating Events on: " + dateText + " | Expected: " + expectedCount + " Events");

        if (eventCards.size() != expectedCount) {
            System.out.println("❌ Event count mismatch: Found " + eventCards.size() + " but expected " + expectedCount);
        }

        for (WebElement event : eventCards) {
            // ✅ Event Name
            String eventName = event.findElement(By.cssSelector(".event-title")).getText();
            System.out.println("Event Name: " + eventName);

            // ✅ Exhibitor Name and Link
            WebElement exhibitorLink = event.findElement(By.cssSelector(".event-exhibitor a"));
            System.out.println("Exhibitor: " + exhibitorLink.getText() + " | Link: " + exhibitorLink.getAttribute("href"));

            // ✅ Date and Time
            System.out.println("Date & Time: " + event.findElement(By.cssSelector(".event-date-time")).getText());

            // ✅ Location
            System.out.println("Location: " + event.findElement(By.cssSelector(".event-location")).getText());

            // ✅ Learn More link
            WebElement learnMore = event.findElement(By.linkText("Learn More"));
            System.out.println("Learn More: " + learnMore.getAttribute("href"));

            // ✅ Event Type
            System.out.println("Event Type: " + event.findElement(By.cssSelector(".event-type")).getText());

            // ✅ Image check
            WebElement image = event.findElement(By.cssSelector("img"));
            String imgSrc = image.getAttribute("src");
            System.out.println((imgSrc != null && !imgSrc.isEmpty()) ? "Image found ✅" : "❌ Image missing");

            System.out.println("------------------------------");
        }
    }

    // Date comparator
    private boolean isDateBefore(String current, String previous) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMMM dd, yyyy", Locale.ENGLISH);
            return sdf.parse(current).before(sdf.parse(previous));
        } catch (Exception e) {
            System.out.println("⚠️ Date parsing error: " + e.getMessage());
            return false;
        }	
		
		
		
		
		
		
/*		
		
		// Click on IMC Event Tab
		utl.scrollElementIntoMiddle(atlevents.getatlExhibitorsEventsTab());
		atlevents.getatlImcEventsTab().click();
		Thread.sleep(500);
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
		for (int i = 0; i < atlevents.getatlListOfEventTitles().size(); i++) {
			allEventSeeDetailsLinkCount1++;
			WebElement eventTitleLink = atlevents.getatlListOfEventTitles().get(i);
			String eventTitle = eventTitleLink.getText();
			Assert.assertTrue(eventTitleLink.isDisplayed());
			// eventSeeDetailsLink = atlevents.atlatlListOfAllEventsSeeDetailsLink().get(1);
			utl.scrollElementIntoMiddle(eventTitleLink);
			eventTitleLink.click();
			Thread.sleep(500);
			// Verify Event Details Page
			Assert.assertTrue(eventTitle.contains(atlevents.getatlEventNameOnDetailsPage().getText()));
			Thread.sleep(3000);
			driver.navigate().back();
			Thread.sleep(3000);
		}

		System.out.println(allEventSeeDetailsLinkCount + " Events Details Page displayed");
		Assert.assertEquals(allEventcount, allEventSeeDetailsLinkCount1);
*/
	}

	@Test(priority = 5) // groups="Non_MP"
	public void TS005_VerifyIMCEventsEventDetailstTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T295: IMC Events: Event Details
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp = new ATLFloorPlansPage(driver);
		atlevents = new ATLEventsAndWebinarPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		Thread.sleep(3000);
		utl.clickOnEventLinkOfChannel();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		String eventTitle = atlevents.getatlClickOnEvent().getText();
		Thread.sleep(5000);
		// Click on IMC Event Tab
		utl.scrollElementIntoMiddle(atlevents.getatlExhibitorsEventsTab());
		atlevents.getatlImcEventsTab().click();
		Thread.sleep(500);
		// Click on Any Event title
		utl.scrollElementIntoMiddle(atlevents.getatlClickOnEvent());
		atlevents.getatlClickOnEvent().click();
		Thread.sleep(500);
		Assert.assertTrue(eventTitle.contains(atlevents.getatlEventNameOnDetailsPage().getText()));

		// Verify Location Link
		Assert.assertTrue(atlevents.getatlEventLocationLinkLVMPROD().isDisplayed());
		System.out.println("Events Location link displayed");
		// Verify Event Type
		Assert.assertTrue(atlevents.getatlEventType().isDisplayed());
		System.out.println("Event Type displayed");

		// Verify Add to Calendar
		Assert.assertTrue(atlevents.getatlCalendarIcon().isDisplayed());
		System.out.println("Calendar displayed");

		driver.navigate().back();
		int allEventSeeDetailsLinkCount1 = 0;
		for (int i = 0; i < atlevents.getatlListOfEventTitles().size(); i++) {
			allEventSeeDetailsLinkCount1++;
			WebElement eventTitleLink = atlevents.getatlListOfEventTitles().get(i);
			utl.scrollElementIntoMiddle(eventTitleLink);
			Thread.sleep(500);
			eventTitleLink.click();
			// Verify Event Details Page

			Thread.sleep(2000);
			try {
				if (atlevents.getatlEventsTag().isDisplayed()) {
					String searchResultPageURL = atlevents.getatlEventsTag().getAttribute("href");
					atlevents.getatlEventsTag().click();
					Thread.sleep(500);
					Assert.assertTrue(searchResultPageURL.contains(driver.getCurrentUrl()));
					Assert.assertTrue(atlevents.getatlSearchResultsTitle().getText().contains("Search"));
					System.out.println("Search Results page opened");
					break;
				}

			} catch (Exception e) {
				e.printStackTrace();
				driver.navigate().back();
				Thread.sleep(2000);
				// Click on Exh Event Tab
				// atlevents.getatlExhibitorsEventsTab().click();
				/*
				 * System.out.println(i);
				 * System.out.println(atlevents.getatlListOfEventTitles().size());
				 */
				if (atlevents.getatlListOfEventTitles().size() == i + 1) {
					System.out.println("Tags are not present");
					// Assert.assertTrue(i== atlevents.getatlListOfEventTitles().size());
				}
			}

		}

	}

	@Test(priority = 6) // groups="Non_MP"
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

	@Test(priority = 7) // groups="Non_MP"
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

	@Test(priority = 8) // Previous priority = 11,groups="Non_MP"
	public void TS008_VerifyExhibitorEventsListTest() throws InterruptedException, IOException {
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

	@Test(priority = 9) // groups="Non_MP"
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
