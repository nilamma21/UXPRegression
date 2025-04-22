
package resources;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import pageObjects.AtlantaMarket.ATLEventsAndWebinarPage;
import pageObjects.AtlantaMarket.ATLExhDigiShowroomPage;
import pageObjects.AtlantaMarket.ATLExhLineProdActionsPage;
import pageObjects.AtlantaMarket.ATLGlobalSearchPage;
import pageObjects.AtlantaMarket.ATLLandingPage;
import pageObjects.AtlantaMarket.ATLLeftPaneFilters;
import pageObjects.AtlantaMarket.ATLLoginPage;
import pageObjects.AtlantaMarket.ATLMarketPlannerPage;
import pageObjects.AtlantaMarket.ATLProductDetailsPage;
import pageObjects.ExhibitorPortal.EXPMarketsPage;
import pageObjects.LasVegasMarket.LVMEventsAndWebinarPage;
import pageObjects.LasVegasMarket.LVMExhDigiShowroomPage;
import pageObjects.LasVegasMarket.LVMExhLineProdActionsPage;
import pageObjects.LasVegasMarket.LVMGlobalSearchPage;
import pageObjects.LasVegasMarket.LVMLandingPage;
import pageObjects.LasVegasMarket.LVMLeftPaneFilters;
import pageObjects.LasVegasMarket.LVMLineDigitalShowroomPage;
import pageObjects.LasVegasMarket.LVMLoginPage;
import pageObjects.LasVegasMarket.LVMMarketPlannerPage;
import pageObjects.Sitecore.SCDashboard;
import pageObjects.Sitecore.SCDigitalAdminPanelPage;
import pageObjects.Sitecore.SCDigitalAdminPanelUserProfilePage;
import pageObjects.Sitecore.SCLoginPage;
import pageObjects.Sitecore.SCShowSpecials;

public class Utility extends base {

	public String neweventname = "";
	// public WebDriver driver;
	ATLLandingPage lap;
	ATLLoginPage lp;
	ATLExhLineProdActionsPage atlexhact;
	ATLMarketPlannerPage atlmppge;
	ATLGlobalSearchPage atlgs;
	ATLEventsAndWebinarPage atlevents;
	GenerateData genData;
	LVMMarketPlannerPage lvmmpp;
	LVMEventsAndWebinarPage lvmevents;
	ATLExhDigiShowroomPage atlexhdgshw;
	ATLProductDetailsPage atlproddet;
	ATLLeftPaneFilters atlleftpane;
	EXPMarketsPage expmrkttab;
	SCLoginPage sclogin;
	SCDashboard scdash;
	SCShowSpecials scshow;
	SCDigitalAdminPanelPage digiAdmin;
	LVMGlobalSearchPage lvmgs;
	LVMLineDigitalShowroomPage lvmdigish;
	LVMExhDigiShowroomPage lvmds;
	ArrayList<String> tabs;
	LVMLeftPaneFilters lvmleftpane;
	LVMLoginPage lpp;
	LVMLandingPage lapp;
	SCDigitalAdminPanelUserProfilePage digiAdminUserProf;
	LVMExhLineProdActionsPage lvmexhact;

	List<WebElement> showspecialslist, exheventslist, exheventnameslist, exheventdeletebtnlist, infoFilterList;

	public String seeMoreBtnURL;
	public String exhname;

	@SuppressWarnings("static-access")
	public Utility(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement scrollToElement(WebElement element) throws InterruptedException {
		WebElement scrollText = element;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", scrollText);
		Thread.sleep(4000);
		return element;
	}

	public void scrollToTop() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		Thread.sleep(4000);
	}

	public void scrollIntoView(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	}

	public void scrollElementIntoMiddle(WebElement element) throws InterruptedException {
		String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
				+ "var elementTop = arguments[0].getBoundingClientRect().top;"
				+ "window.scrollBy(0, elementTop-(viewPortHeight/2));";
		((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(200);
	}

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
		lp.getPassword().sendKeys((prop.getProperty("password")));
		Thread.sleep(1000);

		lp.getSignInBtn().click();
		Thread.sleep(15000);
	}

	public String[] verifyMPLoginFunctionality_Test() throws IOException, InterruptedException {

		// The purpose of this test case to verify:-
		// TS1- Login to Market Planner

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);

		// Click on Login button from Landing Page
		try {
			lap.getLogin().click();
		} catch (Exception e) {
			// TODO: handle exception

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			// Enter the credentials on Login Page and click
			lp.getEmailAddress().sendKeys((prop.getProperty("username")));

			lp.getPassword().sendKeys((prop.getProperty("password")));

			Thread.sleep(1000);
			/*
			 * lp.getPassword().sendKeys((prop.getProperty("password")));
			 * Thread.sleep(1000);
			 */

			lp.getSignInBtn().click();
			Thread.sleep(15000);
		}
		return null;

	}

	public void selectDropdown(String itemName, String channelURL) throws InterruptedException {
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		Select selectAMC = new Select(atlmppge.getselectChannel());
		selectAMC.selectByVisibleText(itemName);
		Thread.sleep(8000);
		Assert.assertTrue(driver.getCurrentUrl().contains(channelURL + "Market-Planner"));
		System.out.println("Verified " + itemName + "channel page");

	}

	public void mouseHover(WebElement mainMenu, WebElement subMenu) throws IOException, InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		// Instantiating Actions class
		Actions actions = new Actions(driver);
		// Hovering on main menu
		actions.moveToElement(mainMenu);
		// To mouseover on sub menu
		actions.moveToElement(subMenu);
		// build()- used to compile all the actions into a single step
		actions.click().build().perform();

	}

	public void addingExhProdLine(String name) throws IOException, InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		// Clear All
		atlmppge.getMpQuickAdd().sendKeys(Keys.CONTROL + "a");
		atlmppge.getMpQuickAdd().sendKeys(Keys.DELETE);

		// Enter New Exh
		Thread.sleep(5000);
		atlmppge.getMpQuickAdd().sendKeys(name);
		Thread.sleep(5000);
		atlmppge.getMpQuickAdd().sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		atlmppge.getMpQuickAdd().sendKeys(Keys.ENTER);
		Thread.sleep(5000);

	}

	public void addingExhForSorting(String name) throws IOException, InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);

		// Clear All
		atlgs.getATLGlobalSearchTextBox().sendKeys(Keys.CONTROL + "a");
		atlgs.getATLGlobalSearchTextBox().sendKeys(Keys.DELETE);

		// Enter New Exh
		Thread.sleep(2000);
		atlgs.getATLGlobalSearchTextBox().sendKeys(name);

		Thread.sleep(2000);
		atlgs.getATLGlobalSearchTextBox().sendKeys(Keys.ENTER);
		Thread.sleep(5000);

	}

	public void checkItemPresentInListorNot(List<WebElement> listOfProd, String filterName)
			throws IOException, InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		boolean flagLines = false;
		for (WebElement selectL : listOfProd) {
			if (selectL.getText().equals(filterName)) {
				flagLines = true;
				break;
			}
		}
		if (flagLines == true) {
			System.out.println(filterName + " Present");
			Assert.assertTrue(flagLines = true);
		} else {
			System.out.println(filterName + "s Not Present");
			Assert.assertTrue(flagLines = false);
		}
	}

	public void checkItemNotPresentInList(List<WebElement> listOfProd, String filterName)
			throws IOException, InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		boolean flagLines = false;
		for (WebElement selectL : listOfProd) {
			if (selectL.getText().equals(filterName)) {
				flagLines = true;
				break;
			}
		}
		if (flagLines == true) {
			System.out.println(filterName + "s Present");
			Assert.assertFalse(flagLines = true);
		} else {
			System.out.println(filterName + "s Not Present");
			Assert.assertTrue(flagLines = true);
		}
	}

	// Click on FilterBy Options(All , Exhibitor, Line , Product , etc)
	public void selectFilters(List<WebElement> list, String filterName) throws InterruptedException {

		boolean flag = false;
		for (WebElement listExhibitor : list) {
			if (listExhibitor.getText().equals(filterName)) {
				Thread.sleep(5000);
				listExhibitor.click();

				// listExhibitor.click();
				flag = true;
				break;
			}
		}
		if (flag == true) {
			System.out.println(filterName + " Selected");
			Assert.assertTrue(flag = true);

		} else {
			System.out.println(filterName + " Not Selected");
			Assert.assertTrue(flag = false);
		}
	}

	public void createNewList() throws InterruptedException {
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		// click on New list btn
		atlmppge.getMpListNewListBtn().click();
		// verify New List Popup header
		Assert.assertTrue(
				atlmppge.getMpListNewGroupPopupHeader().getText().contains(prop.getProperty("CreateListPopupHeader")));
		// Enter List name
		String newlistname = "Cyb" + genData.generateRandomString(5);
		atlmppge.getMpListNewGroupNameTxt().sendKeys(newlistname);
		System.out.println("list name :: " + newlistname);
		// Click on Create Btn
		atlmppge.getMpListNewCreateBtn().click();
		Thread.sleep(5000);
	}

	public void addingCutomItem() throws IOException, InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		// Click on Add Custom item Btn
		atlmppge.getAddCustomItem().click();
		String newTitle = "Cyb" + genData.generateRandomString(5);
		atlmppge.getCustomTitle().sendKeys(newTitle);
		String newDesc = "Cyb" + genData.generateRandomString(20);
		atlmppge.getCustomDesc().sendKeys(newDesc);
		atlmppge.getCustomItemsubmitBtn().click();
	}

	public void ClickOnEditBtnOfAnyList(List<WebElement> list, String listName)
			throws IOException, InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		boolean flag = false;
		for (WebElement selectListName : list) {
			if (selectListName.getText().equals(listName)) {
				scrollToElement(selectListName);
				WebElement editBtn = driver.findElement(By.xpath("//div[text()='" + listName + "']/../div[2]/span[2]"));
				// click on Edit btn
				editBtn.click();
				Thread.sleep(5000);
				flag = true;
				break;
			}
		}
		if (flag == true) {
			System.out.println("List " + listName + " selected");
			Assert.assertTrue(flag = true);
		} else {
			Assert.assertTrue(flag = false);
		}

	}

	public void ClickOnSeeMoreBtnAnyName(List<WebElement> list, String InfoName)
			throws IOException, InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		boolean flag = false;
		for (WebElement selectListName : list) {
			if (selectListName.getText().equals(InfoName)) {
				scrollToElement(selectListName);
				WebElement seeMoreDetailsBtn = driver
						.findElement(By.xpath("//h2[text()='" + InfoName + "']/../div/div[1]/div[1]/a[1]"));
				// click on Edit btn
				Thread.sleep(2000);
				seeMoreBtnURL = seeMoreDetailsBtn.getAttribute("href");
				seeMoreDetailsBtn.click();
				System.out.println("Click on See More Btn");
				Thread.sleep(5000);
				flag = true;
				break;
			}
		}
		if (flag == true) {
			System.out.println("List " + InfoName + " selected");
			Assert.assertTrue(flag = true);
		} else {
			Assert.assertTrue(flag = false);
		}

	}

	public void ClickOnListSelectBtn(List<WebElement> list, String listName) throws IOException, InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		boolean flag = false;
		for (WebElement selectListName : list) {
			if (selectListName.getText().equals(listName)) {
				scrollToElement(selectListName);
				WebElement seeMoreBtn = driver.findElement(By.xpath("//h2[text()='" + listName + "']/../div/div[1]"));
				// click on Edit btn
				seeMoreBtn.click();
				Thread.sleep(5000);
				flag = true;
				break;
			}
		}
		if (flag == true) {
			System.out.println("List " + listName + "selected");
			Assert.assertTrue(flag = true);
		} else {
			Assert.assertTrue(flag = false);
		}

	}

	// Check Exhibitor Location
	public void checkLocationLink(List<WebElement> list, String exhName) throws IOException, InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		boolean flag = false;
		for (WebElement selectListName : list) {
			if (selectListName.getText().equals(exhName)) {
				// scrollToElement(selectListName);
				WebElement locationLink = driver.findElement(
						By.xpath("//a[text()='" + exhName + "']/../../../div[2]/div[1]/div[2]/a[1]/div/span[2]"));
				// click on Edit btn
				String locationText = locationLink.getText();
				System.out.println("Location ::" + locationText);

				Thread.sleep(5000);
				flag = true;
				break;
			}
		}
		if (flag == true) {
			System.out.println("Exhibitor " + exhName + "Location Link Present");
			Assert.assertTrue(flag = true);
		} else {
			Assert.assertTrue(flag = false);
		}

	}

	// Click on Exhibitor Location
	public void clickOnLocationLink(List<WebElement> list, String exhName) throws IOException, InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		boolean flag = false;
		for (WebElement selectListName : list) {
			if (selectListName.getText().equals(exhName)) {
				// scrollToElement(selectListName);
				WebElement locationLink = driver.findElement(
						By.xpath("//a[text()='" + exhName + "']/../../../div[2]/div[1]/div[2]/a[1]/div[1]"));
				// click on Edit btn
				String locationText = locationLink.getText();
				System.out.println("Location ::" + locationText);
				locationLink.click();
				Thread.sleep(5000);
				System.out.println(driver.getTitle());
				// Assert.assertTrue(locationText.contains(driver.getTitle()));
				flag = true;
				break;
			}
		}
		if (flag == true) {
			System.out.println("Click on " + exhName + "location Link");
			Assert.assertTrue(flag = true);
		} else {
			Assert.assertTrue(flag = false);
		}

	}

	public void Sorting(List<WebElement> list, WebElement dropdown, String filterName)
			throws IOException, InterruptedException {

		// Store Current location list
		List<String> currentList = new ArrayList<String>();

		for (WebElement currentElement : list) {

			currentList.add(currentElement.getText().toLowerCase());
		}
		System.out.println("Current List : " + currentList);

		// Create sorted list
		List<String> sortedList = new ArrayList<String>();
		for (String s : currentList) {
			sortedList.add(s.toLowerCase());
		}
		if (filterName.contains("Ascending")) {
			Collections.sort(sortedList);
		} else {
			Collections.sort(sortedList, Collections.reverseOrder());
		}
		// Select Sort by Location Ascending Filter
		Select selectOption = new Select(dropdown);
		selectOption.selectByVisibleText(filterName);
		Thread.sleep(8000);

		List<String> expectedSortedList = new ArrayList<String>();
		for (WebElement ascLocationList : list) {
			expectedSortedList.add(ascLocationList.getText().toLowerCase());
		}
		// Thread.sleep(25000);
		System.out.println("Expected sorted Exhibitor List : " + expectedSortedList);
		// Verify Exhibitor List is Sorted or not
		// Assert.assertEquals(sortedList, expectedSortedList, " List Should be
		// sorted");

		System.out.println("Displayed " + filterName);

	}

	public void SortByDigitalIdentity(List<WebElement> listOfSearchResults, List<WebElement> sortByOptions,
			String optionName) throws IOException, InterruptedException {

		// Store Current list
		List<String> currentList = new ArrayList<String>();
		for (WebElement currentElement : listOfSearchResults) {
			currentList.add(currentElement.getText().toLowerCase());
		}
		System.out.println("Current List : " + currentList);
		// Create sorted list
		List<String> sortedList = new ArrayList<String>();
		for (String s : currentList) {
			sortedList.add(s.toLowerCase());
		}
		// Sorting the list
		Collections.sort(sortedList);
		System.out.println("Sorted List : " + sortedList);
		// Click on Option
		selectFilters(sortByOptions, optionName);
		Thread.sleep(5000);
		// Verify sorted list
		List<String> expectedSortedList = new ArrayList<String>();
		List<WebElement> listOfSearchResults1 = driver
				.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[2]"));
		for (WebElement sortedListAfterClickOnOptions : listOfSearchResults1) {
			expectedSortedList.add(sortedListAfterClickOnOptions.getText().toLowerCase());
		}
		System.out.println("Expected sorted Exhibitor List : " + expectedSortedList);
		System.out.println("Current List : " + currentList);
		// Verify List is Sorted or not
		Assert.assertEquals(sortedList, expectedSortedList, " List Should be sorted");

	}

	public void SortByLastName(List<WebElement> listOfSearchResults, List<WebElement> sortByOptions, String optionName)
			throws IOException, InterruptedException {

		// Store Current list
		List<String> currentList = new ArrayList<String>();
		for (WebElement currentElement : listOfSearchResults) {
			currentList.add(currentElement.getText().toLowerCase());
		}
		System.out.println("Current List : " + currentList);
		// Create sorted list
		List<String> sortedList = new ArrayList<String>();
		for (String s : currentList) {
			sortedList.add(s.toLowerCase());
		}
		// Sorting the list
		Collections.sort(sortedList);
		System.out.println("Sorted List : " + sortedList);
		// Click on Option
		selectFilters(sortByOptions, optionName);
		Thread.sleep(5000);
		// Verify sorted list
		List<String> expectedSortedList = new ArrayList<String>();
		List<WebElement> listOfSearchResults1 = driver
				.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[4]"));
		for (WebElement sortedListAfterClickOnOptions : listOfSearchResults1) {
			expectedSortedList.add(sortedListAfterClickOnOptions.getText().toLowerCase());
		}
		System.out.println("Expected sorted Exhibitor List : " + expectedSortedList);
		System.out.println("Current List : " + currentList);
		// Verify List is Sorted or not
		Assert.assertEquals(sortedList, expectedSortedList, " List Should be sorted");

	}

	public void ClearGlobalSearch() throws IOException, InterruptedException {
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		if (!atlgs.getATLGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			Thread.sleep(1000);
			atlgs.getatlGlobalSearchClearTxt().click();
		}
	}

	public void CloseATLPopup() throws IOException, InterruptedException {
		lap = new ATLLandingPage(driver);

		try {
			Thread.sleep(1000);
			lap.getCloseMarktAdBtn().click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void clickOnEventLinkOfChannel() throws InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		atlevents = new ATLEventsAndWebinarPage(driver);
		lvmgs = new LVMGlobalSearchPage(driver);

		Actions ac = new Actions(driver);
		ac.moveToElement(lvmgs.getLvmDiscoverTab()).click().perform();

		// Click on Show Specials
		lvmgs.getEventsLink().click();
		Thread.sleep(5000);

	}

	public void clickOnEventLinkOfChannel_Old() throws InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		atlevents = new ATLEventsAndWebinarPage(driver);

		if (driver.getCurrentUrl().contains(prop.getProperty("atlmrkturl_prod"))
				|| driver.getCurrentUrl().contains(prop.getProperty("atlmrkturl_uat"))) {

			// Click on Attend Tab
			Thread.sleep(2000);
			atlevents.getatlAttendTab().click();
			Thread.sleep(2000);
			// click on Events Link
			atlevents.getatlEventsLink().click();
			Thread.sleep(5000);
		} else {

			Thread.sleep(2000);
			atlevents.getatlExploreMarketTab().click(); // For LVM Events
			Thread.sleep(2000);
			// click on Events Link
			atlevents.getatlEventsLink().click();
			Thread.sleep(5000);
		}

	}

	public void clickOnEventLinkOfChannelLVM() throws InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);

		lvmmpp = new LVMMarketPlannerPage(driver);
		lvmevents = new LVMEventsAndWebinarPage(driver);

		if (driver.getCurrentUrl().contains(prop.getProperty("lvmurl_prod"))) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			// Click on Attend Tab
			Thread.sleep(3000);
			lvmevents.getlvmExploreMarketTab().click();
			Thread.sleep(2000);
			// click on Events Link
			lvmevents.getlvmEventsLink().click();
			Thread.sleep(1000);
		} else {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Thread.sleep(1000);
			lvmevents.getlvmAttendTab().click(); // For LVM Events
			Thread.sleep(3000);
			// click on Events Link
			lvmevents.getlvmEventsLink().click();

			atlevents.getatlExploreMarketTab().click(); // For LVM Events
			Thread.sleep(2000);
			// click on Events Link
			atlevents.getatlEventsLink().click();

			Thread.sleep(3000);
		}
	}

	public void clickOnEventLinkOfChannel_UAT() throws InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);

		lvmmpp = new LVMMarketPlannerPage(driver);
		lvmevents = new LVMEventsAndWebinarPage(driver);

		if (driver.getCurrentUrl().contains(prop.getProperty("lvmurl_uat"))) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			// Click on Attend Tab
			Thread.sleep(2000);
			lvmevents.getlvmExploreMarketTab().click();
			Thread.sleep(2000);
			// click on Events Link
			lvmevents.getlvmEventsLink().click();

			atlmppge = new ATLMarketPlannerPage(driver);
			atlevents = new ATLEventsAndWebinarPage(driver);

			if (driver.getCurrentUrl().contains(prop.getProperty("atlmrkturl_uat"))) {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				// Click on Attend Tab
				atlevents.getatlAttendTab().click();
				Thread.sleep(2000);
				// click on Events Link
				atlevents.getatlEventsLink().click();

				Thread.sleep(3000);
			} else {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

				lvmevents.getlvmAttendTab().click(); // For LVM Events
				Thread.sleep(2000);
				// click on Events Link
				lvmevents.getlvmEventsLink().click();

				atlevents.getatlExploreMarketTab().click(); // For LVM Events
				Thread.sleep(2000);
				// click on Events Link
				atlevents.getatlEventsLink().click();

				Thread.sleep(3000);
			}
		}
	}

	public void addNewShowSpecialFrmExp_UAT() throws InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlleftpane = new ATLLeftPaneFilters(driver);
		expmrkttab = new EXPMarketsPage(driver);
		sclogin = new SCLoginPage(driver);
		scdash = new SCDashboard(driver);
		scshow = new SCShowSpecials(driver);
		genData = new GenerateData();

		// Open Exhibitor Portal in new tab
		driver.get(prop.getProperty("expurl_uat"));
		Thread.sleep(5000);

		// Login to EXP
		lp.getEmailAddress().sendKeys((prop.getProperty("usernameSwapnil")));
		lp.getPassword().sendKeys((prop.getProperty("passwordSwapnil")));

		lp.getSignInBtn().click();
		Thread.sleep(15000);

		lap.getIUnderstandBtn().click();
		Thread.sleep(5000);

		// In EXP click on Exhibitor association drop down
		atlleftpane.getEXPExhDropDown().click();

		// Select IMC Test Company exhibitor
		atlleftpane.getIMCExhNameInEXP().click();

		// Click on Markets tab
		expmrkttab.getEXPMarketTab().click();

		if (expmrkttab.getATLMarket().getText().contains("Atlanta Market")) {
			expmrkttab.getATLWinterMarket().click();
		}

		// Click on Add show specials menu
		expmrkttab.getAddShowSpecialMenu().click();

		// Click on Add show special btn
		expmrkttab.getAddShowSpecialBtn().click();

		String showspecialname = "CybShowSpecial_" + genData.generateRandomString(3);
		// Enter show special name
		expmrkttab.getShowSpecialTxtBx().sendKeys(showspecialname);

		// Click on Submit btn
		expmrkttab.getShowSpecialSubmitBtn().click();

		Thread.sleep(4000);
		System.out.println(expmrkttab.getShowSpecialSuccessMsg().getText());
		Assert.assertTrue(expmrkttab.getShowSpecialSuccessMsg().getText().contains(showspecialname));

		// Dismiss the pop-up by click on Okay btn
		expmrkttab.getDismissSuccessModal().click();
		Thread.sleep(6000);
		showspecialslist = driver.findElements(By.xpath("//div[@col-id='showSpecial']"));

		for (int i = 1; i < showspecialslist.size(); i++) {
			Assert.assertTrue(showspecialslist.get(i).getText().contains(showspecialname));
			break;
		}

		// Open Sitecore in new tab
		((JavascriptExecutor) driver).executeScript("window.open()");
		tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get(prop.getProperty("sitecoreurl_uat"));
		Thread.sleep(5000);

		// Login to Sitecore
		sclogin.getSCUsername().sendKeys(prop.getProperty("scusername_uat"));
		sclogin.getSCPassword().sendKeys(prop.getProperty("scpassword_uat"));
		sclogin.getSCLoginbtn().click();

		// Click on Show special Approvals menu
		scdash.getShowSpecialApprovals().click();

		// Select Sort By dropdown
		scshow.getSSSortByOptn().click();

		// Click on Date added Desc optn
		scshow.getDateAddedDesc().click();

		Thread.sleep(6000);
		WebElement approvebtn = driver
				.findElement(By.xpath("//a[@data-special='" + showspecialname + "' and text()='Approve']"));

		// Click on Approve btn
		approvebtn.click();
		Thread.sleep(6000);
	}

	public void addNewShowSpecialFrmExp_PROD() throws InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlleftpane = new ATLLeftPaneFilters(driver);
		expmrkttab = new EXPMarketsPage(driver);
		sclogin = new SCLoginPage(driver);
		scdash = new SCDashboard(driver);
		scshow = new SCShowSpecials(driver);
		genData = new GenerateData();

		// Open Exhibitor Portal in new tab
		driver.get(prop.getProperty("expurl_prod"));
		Thread.sleep(5000);

		// Login to EXP
		lp.getEmailAddress().sendKeys((prop.getProperty("usernameSwapnil")));
		lp.getPassword().sendKeys((prop.getProperty("passwordSwapnil")));

		lp.getSignInBtn().click();
		Thread.sleep(15000);

		lap.getIUnderstandBtn().click();
		Thread.sleep(5000);

		// In EXP click on Exhibitor association drop down
		atlleftpane.getEXPExhDropDown().click();

		// Select IMC Test Company exhibitor
		atlleftpane.getIMCExhNameInEXP().click();

		// Click on Markets tab
		expmrkttab.getEXPMarketTab().click();

		if (expmrkttab.getATLMarket().getText().contains("Atlanta Market")) {
			expmrkttab.getATLWinterMarket().click();
		}

		// Click on Manage show specials menu
		expmrkttab.getManageShowSpecialMenu().click();

		// Click on Add show special btn
		expmrkttab.getAddShowSpecialBtn().click();

		String showspecialname = "CybShowSpecial_" + genData.generateRandomString(3);
		// Enter show special name
		expmrkttab.getShowSpecialTxtBx().sendKeys(showspecialname);

		// Click on Submit btn
		expmrkttab.getShowSpecialSubmitBtn().click();

		Thread.sleep(4000);
		System.out.println(expmrkttab.getShowSpecialSuccessMsg().getText());
		Assert.assertTrue(expmrkttab.getShowSpecialSuccessMsg().getText().contains(showspecialname));

		// Dismiss the pop-up by click on Okay btn
		expmrkttab.getDismissSuccessModal().click();
		Thread.sleep(6000);
		showspecialslist = driver.findElements(By.xpath("//div[@col-id='showSpecial']"));

		for (int i = 1; i < showspecialslist.size(); i++) {
			Assert.assertTrue(showspecialslist.get(i).getText().contains(showspecialname));
			break;
		}

		// Open Sitecore in new tab
		((JavascriptExecutor) driver).executeScript("window.open()");
		tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get(prop.getProperty("sitecoreurl_prod"));
		Thread.sleep(5000);

		// Login to Sitecore
		sclogin.getSCUsername().sendKeys(prop.getProperty("scusername_prod"));
		sclogin.getSCPassword().sendKeys(prop.getProperty("scpassword_prod"));
		sclogin.getSCLoginbtn().click();
		Thread.sleep(5000);
		driver.get(prop.getProperty("sitecoreurl_prod"));

		// Click on Show special Approvals menu
		scdash.getShowSpecialApprovals().click();

		// Select Sort By dropdown
		Thread.sleep(4000);
		scshow.getSSSortByOptn().click();

		// Click on Date added Desc optn
		scshow.getDateAddedDesc().click();

		Thread.sleep(6000);
		WebElement approvebtn = driver
				.findElement(By.xpath("//a[@data-special='" + showspecialname + "' and text()='Approve']"));

		// Click on Approve btn
		approvebtn.click();
		Thread.sleep(6000);
	}

	public void deleteShowSpecialFrmExp() throws InterruptedException {

		expmrkttab = new EXPMarketsPage(driver);

		((JavascriptExecutor) driver).executeScript("window.open()");
		tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));

		// Delete newly created Show special
		expmrkttab.getDeleteShowSpecialBtn().click();
		Thread.sleep(5000);
	}

	public void addNewExhibitorEventsFrmExp_UAT() throws InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlleftpane = new ATLLeftPaneFilters(driver);
		expmrkttab = new EXPMarketsPage(driver);
		sclogin = new SCLoginPage(driver);
		scdash = new SCDashboard(driver);
		scshow = new SCShowSpecials(driver);
		genData = new GenerateData();

		// Open Exhibitor Portal in new tab
		driver.get(prop.getProperty("expurl_uat"));
		Thread.sleep(5000);

		// Login to EXP
		lp.getEmailAddress().sendKeys((prop.getProperty("usernameSwapnil")));
		lp.getPassword().sendKeys((prop.getProperty("passwordSwapnil")));

		lp.getSignInBtn().click();
		Thread.sleep(15000);

		lap.getIUnderstandBtn().click();
		Thread.sleep(5000);

		// In EXP click on Exhibitor association drop down
		atlleftpane.getEXPExhDropDown().click();

		// Select IMC Test Company exhibitor
		atlleftpane.getIMCExhNameInEXP().click();

		// Click on Markets tab
		expmrkttab.getEXPMarketTab().click();

		if (expmrkttab.getATLMarket().getText().contains("Atlanta Market")) {
			expmrkttab.getATLWinterMarket().click();
		}

		// Click on Add Event btn
		expmrkttab.getAddEventsBtn().click();

		// Click on Add Event btn on Events page
		expmrkttab.getAddEventsBtn().click();

		// On Add Event form, fill all the required details
		// Click on Event Type drop down
		expmrkttab.getEventTypeDD().click();

		// Select 'Demo' Event type
		expmrkttab.getDemoEventType().click();

		neweventname = "CybEvent_" + genData.generateRandomString(3);
		// Enter the Event name
		expmrkttab.getEventNameTxtBox().sendKeys(neweventname);

		// Enter the event description
		expmrkttab.getEventDescptnTxtBox().sendKeys("Events testing");

		// Click on Choose location drop down
		expmrkttab.getChooseLocationDD().click();

		// Select any location
		expmrkttab.getLocationValue().click();

		// Click on Event Start Date text field
		expmrkttab.getEventStartDateTxtBx().click();

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String date1 = dateFormat.format(date);

		// Print the Date
		System.out.println("Current date is " + date1);

		// Enter Event Start date
		expmrkttab.getEventStartDateTxtBx().sendKeys(date1);

		// Click on Event End Date text field
		expmrkttab.getEventEndDateTxtBx().click();

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 10);
		String futureDate = dateFormat.format(calendar.getTime());
		System.out.println("Future date: " + futureDate);

		// Enter Event End date
		expmrkttab.getEventEndDateTxtBx().sendKeys(futureDate);

		// Click on Event Start time Drop down
		expmrkttab.getEventStartTimeDD().click();

		// Select Event Start time
		expmrkttab.getEventStartTimeValue().click();

		// Click on Event End time Drop down
		expmrkttab.getEventEndTimeDD().click();

		// Select Event End time
		expmrkttab.getEventEndTimeValue().click();

		// Select Open to Everyone Checkbox
		expmrkttab.getOpenToEveryoneChckBx().click();

		// Click on Save button
		expmrkttab.getEventSaveBtn().click();
		Thread.sleep(4000);

		// Verify that Success msg should appeared
		Assert.assertTrue(expmrkttab.getShowSpecialSuccessMsg().isDisplayed());

		// Dismiss the pop-up by click on Okay btn
		expmrkttab.getDismissSuccessModal().click();
		Thread.sleep(6000);
		int i = 0;
		exheventslist = driver.findElements(
				By.xpath("//ul[contains(@class,'EPManageEventsForMarket_eventsList')]/li[" + i + "]/span[1]"));

		for (i = 1; i < exheventslist.size(); i++) {
			Assert.assertTrue(exheventslist.get(i).getText().contains(neweventname));
			break;
		}

		// Open Sitecore in new tab
		((JavascriptExecutor) driver).executeScript("window.open()");
		tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get(prop.getProperty("sitecoreurl_uat"));
		Thread.sleep(5000);

		// Login to Sitecore
		sclogin.getSCUsername().sendKeys(prop.getProperty("scusername_uat"));
		sclogin.getSCPassword().sendKeys(prop.getProperty("scpassword_uat"));
		sclogin.getSCLoginbtn().click();

		// Click on Exhibitor Events Approvals menu
		scdash.getExhEventsApprovals().click();

		// Select Sort By dropdown
		scshow.getSSSortByOptn().click();

		// Click on Date added Desc optn
		scshow.getDateAddedDesc().click();

		Thread.sleep(6000);
		WebElement approvebtn = driver
				.findElement(By.xpath("//a[@data-eventname='" + neweventname + "' and text()='Approve']"));

		// Click on Approve btn
		approvebtn.click();
		Thread.sleep(6000);
	}

	public void deleteExhEventFrmExp() throws InterruptedException {

		expmrkttab = new EXPMarketsPage(driver);

		System.out.println("In delete Exh event function");

		((JavascriptExecutor) driver).executeScript("window.open()");
		tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));

		System.out.println(neweventname);

		// Delete newly created Exhibitor Event
		int i = 0;
		exheventnameslist = driver.findElements(
				By.xpath("//li[contains(@class,'EPManageEventsForMarket_eventItem')][" + i + "]/span[1]"));
		exheventdeletebtnlist = driver.findElements(
				By.xpath("//li[contains(@class,'EPManageEventsForMarket_eventItem')][" + i + "]/div[3]/div[3]/span"));

		for (i = 1; i < exheventnameslist.size(); i++) {

			scrollToElement(exheventnameslist.get(i));

			System.out.println(exheventnameslist.get(i).getText());
			if (exheventnameslist.get(i).getText().contains(neweventname)) {
				exheventdeletebtnlist.get(i).click();
				break;
			}
		}
	}

	public void loginCheckATL() throws IOException, InterruptedException {
		String currentURL = driver.getCurrentUrl();
		String expectedURL = "https://www.atlantamarket.com/";
		if (currentURL.equals(expectedURL)) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		} else {
			driver.get(prop.getProperty("atlmrkturl_prod"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
	}

	public void loginCheckLVM() throws IOException, InterruptedException {
		String currentURL = driver.getCurrentUrl();
		String expectedURL = "https://www.lasvegasmarket.com/";
		if (currentURL.equals(expectedURL)) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		} else {
			driver.get(prop.getProperty("lvmurl_prod"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
	}

	public String LVMExhibitorWithEvent() throws InterruptedException, IOException {
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		sclogin = new SCLoginPage(driver);
		scdash = new SCDashboard(driver);
		scshow = new SCShowSpecials(driver);

		lvmmpp = new LVMMarketPlannerPage(driver);
		lvmevents = new LVMEventsAndWebinarPage(driver);

		if (driver.getCurrentUrl().contains(prop.getProperty("lvmurl_prod"))) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			// Click on Attend Tab
			Thread.sleep(2000);
			lvmevents.getlvmExploreMarketTab().click();
			Thread.sleep(2000);
			// click on Events Link
			lvmevents.getlvmEventsLink().click();
		} else {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			lvmevents.getlvmAttendTab().click(); // For LVM Events
			Thread.sleep(2000);
			// click on Events Link
			lvmevents.getlvmEventsLink().click();
			atlevents.getatlExploreMarketTab().click(); // For LVM Events
			Thread.sleep(2000);
			// click on Events Link
			atlevents.getatlEventsLink().click();
			Thread.sleep(3000);
		}
		// Click on Exh Event Tab
		lvmevents.getlvmExhibitorsEventsTab().click();
		/*
		 * try { scrollToElement(lvmevents.getlvmEventCardFirstExhName()); //Get
		 * Exhibitor name fron from first event card. String exhName =
		 * lvmevents.getlvmEventCardFirstExhName().getText(); return exhName; }catch
		 * (Exception e) {
		 * 
		 * siteCoreLoginUAT();//login to siteCore scdash.getSC_DashboardCTA().click();
		 * //Click on Dashboard scdash.getSC_ContentEditor().click(); //CLick on COntent
		 * Editor scdash.getSC_ContentEditorIMCDropdown().click();//Click on IMC
		 * scdash.getSC_ContentEditorIMCLVM().click();//Click on LVM
		 * scdash.getSC_ContentEditorIMCLVMHome().click();//Click on Home
		 * scdash.getSC_ContentEditorIMCLVMHomeEvents().click();//Click on LVM
		 * scdash.getSC_ContentEditorIMCLVMHomeEventYearFolder().click();//click on
		 * Event folder
		 * scdash.getSC_ContentEditorIMCLVMHomeEventsFirstFolder().click();//click on
		 * Event folder
		 * scdash.getSC_ContentEditorIMCLVMHomeEventsFirstFolderSubFolder().click();//
		 * click on Event Sub folder
		 * scdash.getSC_ContentEditorIMCLVMHomeEventsFirstFolderSubFolder1().click();//
		 * click on Event Sub folder
		 * scdash.getSC_ContentEditorIMCLVMHomeEventsFirstFolderSubFolder2().click();//
		 * click on Event Sub folder
		 * scdash.getSC_ContentEditorIMCLVMHomeEventsLastPage().click();//click on Event
		 * Sub folder
		 * 
		 * }
		 */
		return neweventname;
	}

	public void SC_selectAnyDropdown(String dropDownName) throws IOException, InterruptedException {
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		By.xpath("//span[contains(text(),'" + dropDownName + "')]/../../img");
		Thread.sleep(3000);

	}

	public void siteCoreLogin() throws InterruptedException {

		sclogin = new SCLoginPage(driver);
		scdash = new SCDashboard(driver);
		scshow = new SCShowSpecials(driver);

		driver.get(prop.getProperty("sitecoreurl_prod"));
		Thread.sleep(5000);
		// Login to Sitecore
		sclogin.getSCUsername().sendKeys(prop.getProperty("scusername_prod"));
		sclogin.getSCPassword().sendKeys(prop.getProperty("scpassword_prod"));
		sclogin.getSCLoginbtn().click();

	}

	public void siteCoreLoginUAT() throws InterruptedException {

		sclogin = new SCLoginPage(driver);
		scdash = new SCDashboard(driver);
		scshow = new SCShowSpecials(driver);

		driver.get(prop.getProperty("sitecoreurl_uat"));
		Thread.sleep(5000);
		// Login to Sitecore
		sclogin.getSCUsername().sendKeys(prop.getProperty("sitecoreusername"));
		sclogin.getSCPassword().sendKeys(prop.getProperty("sitecorepassword"));
		sclogin.getSCLoginbtn().click();

	}

	public void siteCoreFiterByNoAssociation(List<WebElement> associationColList) {

		boolean flag = true;
		List<String> allNotAssociated = new ArrayList<>();
		for (WebElement notAss : associationColList) {
			String text = notAss.getText().toLowerCase();
			if (!text.trim().isEmpty()) { // Ignore elements that are empty or contain only whitespace
				allNotAssociated.add(text);
				flag = true;
			}
		}
		System.out.println(allNotAssociated);
		if (allNotAssociated.isEmpty()) {
			System.out.println("No Associations is working as expeced");
			Assert.assertTrue(flag = true);

		} else {
			System.out.println("No Associations is not working as expeced");
			Assert.assertTrue(flag = false);
		}
	}

	public void siteCoreFiterByExhibitor(List<WebElement> associationColList) {

		boolean flag = true;
		List<String> allNotAssociated = new ArrayList<>();
		for (WebElement notAss : associationColList) {
			String text = notAss.getText().toLowerCase();
			if (!text.trim().isEmpty()) { // Ignore elements that are empty or contain only whitespace
				allNotAssociated.add(text);
				flag = true;
			}
		}
		System.out.println(allNotAssociated);
		if (!allNotAssociated.isEmpty()) {
			System.out.println("Exhibitor is working as expeced");
			Assert.assertTrue(flag = true);

		} else {
			System.out.println("Exhibitor is not working as expeced");
			Assert.assertTrue(flag = false);
		}
	}

	public void checkSiteCoreFilterByAssociation(List<WebElement> associationColList, boolean expectAssociations) {
		List<String> allAssociations = new ArrayList<>();
		for (WebElement element : associationColList) {
			String text = element.getText().toLowerCase().trim();
			if (!text.isEmpty()) { // Ignore elements that are empty or contain only whitespace
				allAssociations.add(text);
			}
		}
		System.out.println(allAssociations);
		// Check the condition based on the expectation
		if (expectAssociations) {
			// Expecting associations
			if (!allAssociations.isEmpty()) {
				System.out.println("Filter by Exhibitor is working as expected");
				Assert.assertTrue(true);
			} else {
				System.out.println("Filter by Exhibitor is not working as expected");
				Assert.assertTrue(false);
			}
		} else {
			// Not expecting associations
			if (allAssociations.isEmpty()) {
				System.out.println("Filter by No Association is working as expected");
				Assert.assertTrue(true);
			} else {
				System.out.println("Filter by No Association is not working as expected");
				Assert.assertTrue(false);
			}
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	public void handleFilterSelection(WebElement filterName) throws InterruptedException {
		lvmgs = new LVMGlobalSearchPage(driver);

		infoFilterList = driver.findElements(By.xpath("//div[@class='imc-filteritem__option']"));

		if (infoFilterList.equals(filterName.getText())) {
			// Click on the checkbox
			filterName.click();

			// Wait for results to load
			Thread.sleep(5000);

			// Get the first article name
			String articleName = lvmgs.getarticleName1st().getText();

			// Click on the "Learn More" link for the first article
			lvmgs.getlearnMoreLinkArticle().click();

			// Wait for the new page to load
			Thread.sleep(15000);
			String pageTitle = driver.getTitle();

			// Verify if the article name is part of the page title
			Assert.assertTrue(articleName.contains(pageTitle), "The article name does not match the page title.");

			// Validate if the selected filter name is present in the tags
			boolean isFilterNamePresent = lvmgs.getlistOfAllTags().stream()
					.anyMatch(tag -> tag.getText().contains(filterName.getText()));

			// Assert if the filter name is found in the tags
			Assert.assertTrue(isFilterNamePresent, "The selected filter name is not present in the tags.");

			// Navigate back to the filter list
			driver.navigate().back();
			Thread.sleep(8000);

			// Re-locate the checkbox before clicking it again
			List<WebElement> infoFilterListNew = driver
					.findElements(By.xpath("//div[@class='imc-filteritem__option']"));

			for (WebElement filter : infoFilterListNew) {
				if (filter.getText().contains(filterName.getText())) {
					filter.click();
					break;
				}
			}

			// Wait for the page to load before continuing
			Thread.sleep(5000);

		}
	}

	public void commonMethodForLineDGShowroom(String globalsearch_input) throws InterruptedException {

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmdigish = new LVMLineDigitalShowroomPage(driver);

		Thread.sleep(8000);
		lvmgs.getGlobalSearchTextBoxNew().click(); // Click on the global search field
		lvmgs.getGlobalSearchEnterText().sendKeys(globalsearch_input); // Enter search text "Anne"
		lvmgs.getSearchButtonNew().click(); // Click on search button
		String exhName = null;
		// Shown By text
		List<WebElement> exhibitors = lvmds.getlistOfShownByText();

		for (WebElement webElement : exhibitors) {
			exhName = webElement.getText();
			System.out.println(exhName);
			// scrollIntoView(webElement);
			Thread.sleep(5000);
			Actions ac = new Actions(driver);
			ac.moveToElement(webElement).click().perform();
			// webElement.click();
			break;
		}

		Assert.assertTrue(lvmdigish.getLVMLineDigiShowroomPageTitle().getText().contains(exhName),
				"Digital Showroom Page Title mismatch"); // Verify page title contains exhibitor name

	}

	private String exhName; // Declare as an instance variable

	public void commonMethodForExhibotrDGShowroomm(String globalsearch_input) throws InterruptedException {
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmdigish = new LVMLineDigitalShowroomPage(driver);

		Thread.sleep(8000);
		lvmgs.getGlobalSearchTextBoxNew().click();
		lvmgs.getGlobalSearchEnterText().sendKeys(globalsearch_input);
		lvmgs.getSearchButtonNew().click();
		Thread.sleep(8000);

		List<WebElement> exhibitors = lvmds.getlistOfAllExhibitors();

		for (WebElement webElement : exhibitors) {
			exhName = webElement.getText(); // Assign exhibitor name
			System.out.println(exhName);
			webElement.click();
			break;
		}
	}

	// Getter method to access exhName in other classes
	public String getExhName() {
		return exhName;
	}

	public void verifyProductCategorySelection(String searchInput, WebElement productCategoryElement)
			throws InterruptedException {

		lvmleftpane = new LVMLeftPaneFilters(driver);

		Thread.sleep(8000);

		lvmleftpane.getLVMProdCatgExpandBtn().click();
		Thread.sleep(8000);

		scrollElementIntoMiddle(productCategoryElement);
		String expectedprodcatg = productCategoryElement.getText();
		productCategoryElement.click();
		Thread.sleep(8000);

		String exhname = lvmds.getExhibitorNameNew().getText();
		lvmds.getExhibitorNameNew().click();
		Thread.sleep(10000);

		List<WebElement> prodcatgitemlist = lvmds.getLVMProductCategItemList();
		for (WebElement item : prodcatgitemlist) {
			if (lvmds.getLVMProductCategTable().isDisplayed()) {
				Assert.assertTrue(item.getText().contains(expectedprodcatg));
				break;
			}
		}
	}

	public void globleSearchInput(String input) throws InterruptedException {
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmdigish = new LVMLineDigitalShowroomPage(driver);
		Thread.sleep(8000);
		lvmgs.getGlobalSearchTextBoxNew().click();
		lvmgs.getGlobalSearchEnterText().sendKeys(input);
		lvmgs.getSearchButtonNew().click();
		Thread.sleep(20000);

	}

	public void commonMethodLeftPaneFilterExpandButton(WebElement expandButton) throws InterruptedException {
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmleftpane = new LVMLeftPaneFilters(driver);

		// Click on Product Categories expand btn
		expandButton.click();
		Thread.sleep(2000);

	}

	String expectedStylecatg = null;

	public void clickOnLeftPaneStyleFilter(WebElement filterName) throws InterruptedException {

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		lvmleftpane = new LVMLeftPaneFilters(driver);

		scrollElementIntoMiddle(filterName);

		expectedStylecatg = filterName.getText();

		Thread.sleep(8000);
		System.out.println("Product category name::" + expectedStylecatg);
		filterName.click();
		Thread.sleep(8000);

	}

	String expectedprodcatg = " ";

	public void clickOnLeftPaneFilter(WebElement filterName) throws InterruptedException {

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		lvmleftpane = new LVMLeftPaneFilters(driver);

		scrollElementIntoMiddle(filterName);

		expectedprodcatg = filterName.getText();

		Thread.sleep(8000);
		System.out.println("Product category name::" + expectedprodcatg);
		filterName.click();
		Thread.sleep(8000);

	}

	public String exhibitorNameText = null;

	public void commomMethodForFindoutProductCategory() throws InterruptedException {

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		lvmleftpane = new LVMLeftPaneFilters(driver);

		// Store the exhibitor list
		List<WebElement> listOfExhibitors = lvmleftpane.getlistOfAllExhibitors();
		int checkedExhibitors = 0;

		Actions actions = new Actions(driver);

		boolean isExhibitorFound = false; // Track if exhibitor is found

		outer: for (int i = 0; i < listOfExhibitors.size(); i++) {
			if (checkedExhibitors >= 3) {
				break; // Stop after checking 3 exhibitors
			}

			// Re-fetch the exhibitor list to avoid stale elements
			listOfExhibitors = lvmleftpane.getlistOfAllExhibitors();

			WebElement exhibitorName = listOfExhibitors.get(i);
			exhibitorNameText = exhibitorName.getText();
			System.out.println("Checking for Exhibitor: " + exhibitorNameText);
			Thread.sleep(5000);
			scrollToTop();
			scrollElementIntoMiddle(exhibitorName);
			actions.moveToElement(exhibitorName).perform();
			exhibitorName.click();
			Thread.sleep(10000);
			checkedExhibitors++; // Increment counter
			try {
				if (lvmleftpane.getisProductCategorySectionNotAvailable().isDisplayed()) {
					System.out.println("in If/Try block");
					System.out.println("Product Categories list not available, going back to exhibitor list...");
					driver.navigate().back();
					Thread.sleep(5000);
					continue; // Continue with the next iteration
				}
			} catch (Exception e) {
				System.out.println("in catch block");
				scrollToElement(lvmds.getproductCateShownText());
				Thread.sleep(5000);
				List<WebElement> prodcatgitemlist = lvmds.getLVMProductCategItemList();
				Thread.sleep(5000);
				for (int j = 0; j < prodcatgitemlist.size(); j++) {
					String proCatName = prodcatgitemlist.get(j).getText();
					System.out.println(proCatName);
					System.out.println("Comparing: '" + proCatName + "' with '" + expectedprodcatg + "'");

					if (proCatName.toLowerCase().contains(expectedprodcatg.toLowerCase())) {
						Assert.assertTrue(true, "Product category name found in category list.");
						isExhibitorFound = true;
						System.out.println("Product category found in: " + exhibitorNameText);
						break; // Exit loop when found
					}
				}

				// If exhibitor is found, exit all loops
				if (isExhibitorFound) {
					break outer;
				} else {
					driver.navigate().back();
					Thread.sleep(5000);
				}
			}
		}

	}

	public boolean checkAndSelectExhibitor() throws InterruptedException {
		lapp = new LVMLandingPage(driver);
		lpp = new LVMLoginPage(driver);
		atlleftpane = new ATLLeftPaneFilters(driver);
		genData = new GenerateData();
		digiAdmin = new SCDigitalAdminPanelPage(driver);
		digiAdminUserProf = new SCDigitalAdminPanelUserProfilePage(driver);

		Thread.sleep(8000);
		atlleftpane.getEXPExhDropDown().click();
		Thread.sleep(3000);
		List<WebElement> allDropDownExhibitos = lpp.getlistOfAllExhibitors();
		for (WebElement exhibitor : allDropDownExhibitos) {
			String ex = exhibitor.getText().replaceAll("[^a-zA-Z ]", "").trim();
			if (ex.contains(exhibitorNameText.replaceAll("[^a-zA-Z ]", "").trim())
					|| exhibitorNameText.replaceAll("[^a-zA-Z ]", "").trim().contains(ex)) {
				exhibitor.click();
				Thread.sleep(8000);
				return true;
			}
		}
		return false;
	}

	public void addExhibitorFromSiteCore() throws InterruptedException {

		lapp = new LVMLandingPage(driver);
		lpp = new LVMLoginPage(driver);
		atlleftpane = new ATLLeftPaneFilters(driver);
		genData = new GenerateData();
		digiAdmin = new SCDigitalAdminPanelPage(driver);
		digiAdminUserProf = new SCDigitalAdminPanelUserProfilePage(driver);

		// Open a new tab using JavaScript
		((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");

		// Switch to the new tab
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		// Perform login and actions in the new tab
		siteCoreLogin();

		// Click on Digital Admin Panel
		lpp.getSCDigitalAdminPanel().click();
		Thread.sleep(10000);
		lpp.getSCDigitalAdminPanelSearchField().sendKeys("swapnili@cybage.com");
		lpp.getSCDigitalAdminPanelSearchButton().click();
		Thread.sleep(10000);

		// Perform double-click action
		Actions actions = new Actions(driver);
		actions.doubleClick(lpp.getSCDigitalAdminPanelOpenUserProf()).perform();
		Thread.sleep(5000);

		scrollToElement(lpp.getSCDigitalAdminPanelUserProfAddButton());
		lpp.getSCDigitalAdminPanelUserProfAddButton().click();

		// Enter exhibitor into text field
		digiAdminUserProf.getdigitalAdminPanelAddPopupExhibitoName().sendKeys(exhibitorNameText);
		Thread.sleep(3000);

		// Select 1st exhibitor from suggestion list
		digiAdminUserProf.getdigitalAdminPanelAddPopupSelectExhibitoName().click();

		// Click on Admin Radio Button
		digiAdminUserProf.getdigitalAdminPanelAddPopupSelectAdminRadio().click();

		// Click on Add CTA
		digiAdminUserProf.getdigitalAdminPanelAddPopupAdd().click();
		Thread.sleep(10000);

		// Close the new tab and switch back to the original tab
		driver.close();
		driver.switchTo().window(tabs.get(0)); // Switch back to the first tab
	}

	public void checkStyleProperties() throws InterruptedException {
		lapp = new LVMLandingPage(driver);
		lpp = new LVMLoginPage(driver);
		atlleftpane = new ATLLeftPaneFilters(driver);
		genData = new GenerateData();
		digiAdmin = new SCDigitalAdminPanelPage(driver);
		digiAdminUserProf = new SCDigitalAdminPanelUserProfilePage(driver);
		// Click on Your DG showroom tab
		lpp.getEXPYourDigiShowroom().click();

		// Click on Exhibitor profile info link
		lpp.getEXPProfileInfo().click();

		List<WebElement> StyleProperty = lpp.getEXPProfileInfoStyleElement();
		boolean styleMatched = false;
		for (WebElement style : StyleProperty) {
			if (style.getText().contains("Coastal")) {
				styleMatched = true;
				break;
			}
		}
		Assert.assertTrue(styleMatched, "Failed - Properties not match in Style");
	}

	public void ClickOnSubFilterPlusButton(String filterName) throws InterruptedException {

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		lvmleftpane = new LVMLeftPaneFilters(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);

		WebElement parentElement = driver.findElement(By.xpath("//label[contains(text(),'" + filterName
				+ "')]/../../../../../../div[@class='imc-expand-collapse__heading imc-filteritem__parent imc-filteritem__parent--tier2 ']"));

		// Move & Click using Actions
		Actions actions = new Actions(driver);

		// Hover over the parent element Actions actions = new Actions(driver);
		actions.moveToElement(parentElement, 10, 10).click().perform();
	}

	public void subFilterCategories(List<WebElement> listOfSubCategories) throws InterruptedException {
		// Fetching Filtered Options (List 1)
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		lvmleftpane = new LVMLeftPaneFilters(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);

		List<WebElement> holidayAndSeasonalFilterOptions = listOfSubCategories;
		List<String> filterList1 = new ArrayList<>();

		for (WebElement item : holidayAndSeasonalFilterOptions) {
			String text = item.getText().trim();
			filterList1.add(text);
			System.out.println("List 1 Item: " + text);
		}

		// Move to the next page
		scrollToTop();
		exhname = lvmds.getExhibitorNameNew().getText();
		lvmds.getExhibitorNameNew().click();
		Thread.sleep(10000);

		// Fetch Product Categories on the new page (List 2)
		List<WebElement> prodCatgItemList = lvmds.getLVMProductCategItemList();
		List<String> filterList2 = new ArrayList<>();

		for (WebElement item : prodCatgItemList) {
			String text = item.getText().trim();
			filterList2.add(text);
			System.out.println("List 2 Item: " + text);
		}

		// Verify that at least one element from List 1 exists in List 2
		boolean atLeastOneMatch = false;

		for (String option : filterList1) {
			if (filterList2.contains(option)) {
				System.out.println("Match found: " + option);
				atLeastOneMatch = true;
				break; // Exit loop once a match is found
			}
		}

		// Assert that at least one List 1 element exists in List 2
		Assert.assertTrue(atLeastOneMatch, "No matching elements found between List 1 and List 2.");
		driver.get(prop.getProperty("lvmurl_prod"));
	}
}