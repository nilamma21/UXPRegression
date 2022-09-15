package atlantamarket_UAT;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.gargoylesoftware.htmlunit.javascript.host.dom.Document;
import com.sun.mail.iap.Argument;

import pageObjects.AtlantaMarket.ATLExhLineProdActionsPage;
import pageObjects.AtlantaMarket.ATLGlobalSearchPage;
import pageObjects.AtlantaMarket.ATLLandingPage;
import pageObjects.AtlantaMarket.ATLLeftPaneFilters;
import pageObjects.AtlantaMarket.ATLLoginPage;
import pageObjects.AtlantaMarket.ATLMarketPlannerPage;
import pageObjects.AtlantaMarket.ATLProductDetailsPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

@Listeners({ TestListeners.class })
public class MarketPlanner extends base {

	public WebDriverWait wait;
	public GenerateData genData;
	public Utility utl;
	public String exhname;
	ATLLoginPage lp;
	ATLLandingPage lap;
	ATLMarketPlannerPage atlmppge;
	ATLExhLineProdActionsPage atlexhact;
	ATLGlobalSearchPage atlgs;
	MarketPlanner mp;
	ATLLeftPaneFilters atlleftpane;
	List<WebElement> mplists, mpduplicatelistoptns;

	@BeforeClass
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);

		// Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("atlmrkturl_uat"));

		// lap.getIUnderstandBtn().click();
		utl.verifyMPLoginFunctionality();
		Thread.sleep(8000);

		// lap.getIUnderstandBtn().click();
		Thread.sleep(8000);
	}

	@Test(priority = 1)
	public void TS001_VerifyMarketPlannerInvalidLoginCredentialsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T221: Market Planner: Login: Login with invalid login credentials
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		mp = new MarketPlanner();
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		try {
			// Click Welcome Text
			atlmppge.getwelcometext().click();
			// Click Sign out link
			atlmppge.getsignout().click();
			lap.getLogin().click();

		} catch (Exception e) {
			System.out.println(e);
			lap.getLogin().click();
		}

		// Enter the credentials on Login Page and click
		lp.getEmailAddress().sendKeys((prop.getProperty("username")));
		lp.getPassword().sendKeys((prop.getProperty("invalidPassword")));
		lp.getSignInBtn().click();
		Thread.sleep(15000);
	

		// Verify incorrect password error msg
		Assert.assertTrue(atlmppge.getInvalidPasswordError().getText().contains(prop.getProperty("incorrectPasswordErrorMsg")));

		driver.get(prop.getProperty("atlmrkturl_uat"));

		// without Email and Password
		lap.getLogin().click();
		lp.getSignInBtn().click();
		// Verify Enter email error msg
		Assert.assertTrue(atlmppge.getEnterEmailErrorMsg().getText().contains(prop.getProperty("EnterEmailErrorMsg")));
		// Verify Enter password error msg
		Assert.assertTrue(
				atlmppge.getEnterPasswordErrorMsg().getText().contains(prop.getProperty("EnterPasswordErrorMsg")));

		driver.get(prop.getProperty("atlmrkturl_uat"));
	}

	@Test(priority = 2)
	public void TS002_VerifyMarketPlannerLoginTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T47: Market Planner: Login: Login already exists

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Login to Market Planner

		utl.verifyMPLoginFunctionality();

		// lap.getCloseMarktAdBtn().click();

		Thread.sleep(5000);

		System.out.println("Login");
		// Verify that Market Planner Home page should be displayed
		// Assert.assertTrue(lap.getmarketplannerlinktext1().isDisplayed());
		Assert.assertTrue(lap.getMPLinkText().isDisplayed());
	}

	@Test(priority = 3)
	public void TS003_VerifyMarketPlannerChannelSelectorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T48: Market Planner: Channel Selector
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Login to Market Planner
		// utl.verifyMPLoginFunctionality();
		// Thread.sleep(6000);

		// Click on Market Planner
		lap.getMPLinkText().click();
		Thread.sleep(6000);
		// Verify MP page
		Assert.assertTrue(driver.getTitle().contains("Market Planner"));

		// Select AMC from dropdown
		utl.selectDropdown(prop.getProperty("channelNameAMC"), prop.getProperty("ammarturl_uat"));
		driver.get(prop.getProperty("atlmrkturl_uat") + "Market-Planner");
		Thread.sleep(5000);
		// Select ATLApp from dropdown
		utl.selectDropdown(prop.getProperty("channelNameATLApp"), prop.getProperty("atlappurl_uat"));
		driver.get(prop.getProperty("atlmrkturl_uat") + "Market-Planner");
		Thread.sleep(5000);
		// Select ATLM from dropdown
		utl.selectDropdown(prop.getProperty("channelNameATLM"), prop.getProperty("atlmrkturl_uat"));
		driver.get(prop.getProperty("atlmrkturl_uat") + "Market-Planner");
		Thread.sleep(5000);
		// Select LVA from dropdown
		utl.selectDropdown(prop.getProperty("channelNameLVA"), prop.getProperty("lvaappurl_uat"));
		driver.get(prop.getProperty("atlmrkturl_uat") + "Market-Planner");
		Thread.sleep(5000);
		// Select LVM from dropdown
		utl.selectDropdown(prop.getProperty("channelNameLVM"), prop.getProperty("lvmurl_uat"));
		driver.get(prop.getProperty("atlmrkturl_uat") + "Market-Planner");
		Thread.sleep(5000);

	}

	@Test(priority = 04)
	public void TS004_VerifyAddToFavoriteFunctionalityUsingQuickAddForExhibitorTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T232: Market Planner: Lists- Favorites- Add an Exhibitor to Favorites
		// using 'Quick Add'

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Market Planner
		lap.getMPLinkText().click();
		Thread.sleep(6000);
		// Click on List tab
		atlmppge.getMPHomeListsTab().click();
		Thread.sleep(10000);
		// Click on List from left Pannel
		atlmppge.getMpListLeftPannel().click();
		// Click on Edit list option in front of fev
		atlmppge.getMpEditListoption().click();
		// Enter search term
		/*
		 * atlmppge.getMpQuickAdd().sendKeys("Test"); // Click on 1st suggetion String s
		 * = atlmppge.getMpQuickAddAutosuggetion().getText();
		 * atlmppge.getMpQuickAddAutosuggetion().click();
		 */

		atlmppge.getMpQuickAdd().sendKeys("Test");
		Thread.sleep(5000);
		atlmppge.getMpQuickAdd().sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(5000);
		// String autoSuggetion = atlmppge.getMpQuickAddAutosuggetion().getText();
		atlmppge.getMpQuickAdd().sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		// Verify Selected exhibitor added or not
		boolean flag5 = false;
		List<WebElement> listOfAllExh = driver.findElements(By.xpath("//a[@class='imc-link--alt-darkred']"));
		for (WebElement selectExh : listOfAllExh) {
			if (selectExh.getText().equals(atlmppge.getMpQuickAddedExpName().getText())) {
				System.out.println("Exh is present in list");
				flag5 = true;
				break;
			}
		}
		if (flag5 == true) {
			Assert.assertTrue(flag5 = true);
		} else {
			Assert.assertTrue(flag5 = false);
		}
		// Verify Selected exhibitor added or not
		// Assert.assertTrue(autoSuggetion.contains(atlmppge.getMpQuickAddedExpName().getText()));

	}
	@Test(priority = 05)
	public void TS005_VerifyMarketPlannerSignOutTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-001: To verify the Market Planner sign out functionality

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click Welcome Text
		atlmppge.getwelcometext().click();

		// Click Sign out link
		atlmppge.getsignout().click();

		// Verify user signed out successfully
		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase(prop.getProperty("atlmrkturl_uat")));
		
		utl.verifyMPLoginFunctionality();
		Thread.sleep(8000);
		
	}

	@Test(priority = 06)
	public void TS006_VerifyArrangeBtnFunctionalityForListsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T234: Market Planner: Lists: Lists: Arrange button functionality test
		// case

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Market Planner
		lap.getMPLinkText().click();
		Thread.sleep(6000);
		// Click on List tab
		atlmppge.getMPHomeListsTab().click();
		Thread.sleep(10000);
		// Click on List from left Pannel
		atlmppge.getMpListLeftPannel().click();
		// Click on Arrange btn
		atlmppge.getMpArrangeBtn().click();
		// Verify sort btn
		Assert.assertTrue(atlmppge.getMpListSortBtn().isDisplayed());
		// Store List name
		String lName = atlmppge.getmpListName().getText();
		// Store Source Location
		Point sLocation = atlmppge.getmpListName().getLocation();
		// Drag from source location to Destination
		Actions action = new Actions(driver);
		action.dragAndDrop(atlmppge.getMpListSortBtn(), atlmppge.getmpDestinationLocationList()).build().perform();
		Thread.sleep(5000);

		// All present lists
		List<WebElement> allList = driver.findElements(By.xpath("//div[@class='imc-market-planner-list_row_title']"));
		boolean flag = false;
		for (WebElement list : allList) {
			if (list.getText().equals(lName)) {
				Point DestLocation = list.getLocation();

				if (DestLocation != sLocation) {
					if (list.getText().equals(lName)) {
						Point DestLocation1 = list.getLocation();
						System.out.println("In If :: " + sLocation + "And" + DestLocation1);
						if (DestLocation1 != sLocation) {
							flag = true;
							Assert.assertTrue(flag = true);
							break;
						} else {
							Assert.assertTrue(flag = false);
							break;
						}
					}

				}
			}
		}

	}

	@Test(priority = 07)
	public void TS007_VerifyNewGroupBtnFunctionalityForListsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T238: Market Planner: Lists: Lists: New Group button functionality

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Market Planner
		lap.getMPLinkText().click();

		// Click on List tab
		atlmppge.getMPHomeListsTab().click();

		// Click on List from left Panel
		atlmppge.getMpListLeftPannel().click();

		// click on New group btn
		atlmppge.getMpListNewGroupBtn().click();

		// verify New Group Popup header
		Assert.assertTrue(
				atlmppge.getMpListNewGroupPopupHeader().getText().contains(prop.getProperty("CreateGroupPopupHeader")));
		// Enter Group name
		String newGroupname = "Cyb" + genData.generateRandomString(5);
		atlmppge.getMpListNewGroupNameTxt().sendKeys(newGroupname);
		System.out.println(newGroupname);
		// Click on Create Btn
		atlmppge.getMpListNewGroupCreateBtn().click();
		Thread.sleep(5000);

		utl.checkItemPresentInListorNot(atlmppge.getAtlListOfAllGroups(), newGroupname);

	}

	@Test(priority = 8)
	public void TS008_VerifyNewListBtnFunctionalityForListsTest1() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T235: Market Planner: Lists: Lists: New Test button functionality

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Click on MarketPlanner
		lap.getMPLinkText().click();

		// Click on List tab
		atlmppge.getMPHomeListsTab().click();

		// Click on Lists from left Pannel
		atlmppge.getMpListLeftPannel().click();
		// click on New list btn
		atlmppge.getMpListNewListBtn().click();
		// verify New List Popup header
		Assert.assertTrue(
				atlmppge.getMpListNewGroupPopupHeader().getText().contains(prop.getProperty("CreateListPopupHeader")));
		// Enter List name
		String newlistname = "Cyb" + genData.generateRandomString(5);
		atlmppge.getMpListNewGroupNameTxt().sendKeys(newlistname);

		// Select Group from dropdown
		Select selectGroup = new Select(atlmppge.getmpListNewSelectGroupDropdown());
		Thread.sleep(5000);
		selectGroup.selectByIndex(3);
		// Click on Create Btn
		atlmppge.getMpListNewCreateBtn().click();
		Thread.sleep(10000);
		List<WebElement> allList = driver.findElements(By.xpath("//div[@class='imc-market-planner-list_row_title']"));
		boolean flag = false;
		for (WebElement list : allList) {
			if (list.getText().equals(newlistname)) {
				flag = true;
				break;
			}
		}
		if (flag == true) {
			Assert.assertTrue(flag = true);
		} else {
			Assert.assertTrue(flag = false);
		}

	}

	@Test(priority = 9)
	public void TS009_VerifyCreateNewGroupFormValidationForListsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T239:- Market Planner: Lists: Lists: Validations at Create New List Group
		// form

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Market Planner
		lap.getMPLinkText().click();

		// Click on List tab
		atlmppge.getMPHomeListsTab().click();

		// Click on List from left Panel
		atlmppge.getMpListLeftPannel().click();

		// click on New Group btn
		atlmppge.getMpListNewGroupBtn().click();

		// verify New Group Popup header
		Assert.assertTrue(
				atlmppge.getMpListNewGroupPopupHeader().getText().contains(prop.getProperty("CreateGroupPopupHeader")));

		// Click on Create Btn
		atlmppge.getMpListNewGroupCreateBtn().click();

		// Validate Invalid Group Name Msg
		Assert.assertTrue(atlmppge.getMpInvalidGrNameMsg().getText().contains(prop.getProperty("InvalidGroupMsg")));
		// Dismiss the Create New Group modal
		atlmppge.getCreateNewGrpPopupCloseBtn().click();
	}

	@Test(priority = 10)
	public void TS010_VerifyCreateNewListFormValidationTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T236: Market Planner: Lists: Lists: Validations at Create New List form

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Market Planner
		lap.getMPLinkText().click();

		// Click on List tab
		atlmppge.getMPHomeListsTab().click();

		// Click on List from left Pannel
		atlmppge.getMpListLeftPannel().click();
		// click on New list btn
		atlmppge.getMpListNewListBtn().click();
		// verify New List Popup header
		Assert.assertTrue(
				atlmppge.getMpListNewGroupPopupHeader().getText().contains(prop.getProperty("CreateListPopupHeader")));

		// Click Create button without entering List Name
		atlmppge.getMpListNewCreateBtn().click();
		
		Thread.sleep(10000);
		
		// Validate Invalid list name msg
		Assert.assertTrue(atlmppge.getMpInvalidGrNameMsg().getText().contains(prop.getProperty("InvalidListMsg")));

		// Click Create button by entering List Name but without selecting List Group
		String newlistname = "Cyb" + genData.generateRandomString(5);
		atlmppge.getMpListNameTxt().sendKeys(newlistname);

		// Click on Create Btn
		atlmppge.getMpListNewListCreateBtn().click();
		Thread.sleep(5000);

		List<WebElement> mplists = atlmppge.getATLMPListsNames();
		boolean flag = false;
		for (WebElement list : mplists) {

			if (list.getText().equals(newlistname)) {
				flag = true;
				break;
			}
		}
		if (flag == true) {
			Assert.assertTrue(flag = true);
		} else {
			Assert.assertTrue(flag = false);
		}
	}

	@Test(priority = 11)
	public void TS011_VerifyMPDashboardOverviewTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP-001: To verify the Market Planner overview and it's functionality

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		lap.getMPLinkText().click();

		// Verify dash board for tabs options after login
		Assert.assertTrue(atlmppge.getselectChannel().isDisplayed());

		Assert.assertEquals(atlmppge.getmpdasboardtab().getText(), "Dashboard");
		Assert.assertEquals(atlmppge.getMPHomeListsTab().getText(), "Lists");
		Assert.assertEquals(atlmppge.getmpmyinfotab().getText(), "My Info");
		Assert.assertEquals(atlmppge.getmpregistrationtab().getText(), "Registrations");
		Assert.assertEquals(atlmppge.getmpsavedsearchestab().getText(), "Saved Searches");

		Assert.assertEquals(atlmppge.getmpdasboardtab().getText(), "Dashboard");
		Assert.assertEquals(atlmppge.getMPHomeListsTab().getText(), "Lists");
		Assert.assertEquals(atlmppge.getmpmyinfotab().getText(), "My Info");
		Assert.assertEquals(atlmppge.getmpregistrationtab().getText(), "Registrations");
		Assert.assertEquals(atlmppge.getmpsavedsearchestab().getText(), "Saved Searches");

		// Verify Dashboard Cards
		Assert.assertTrue(atlmppge.getmpregistrationcard().isDisplayed());
		Assert.assertTrue(atlmppge.getmplistscard().getText().contains("Lists"));
		Assert.assertTrue(atlmppge.getmpbookmyhotelcard().getText().contains("Hotel"));

		// Verify Book a Hotel card options
		Assert.assertEquals(atlmppge.getmpbookmyhotelsection().getText(), "Book a Hotel");
		Assert.assertEquals(atlmppge.getmpfloorplanssection().getText(), "Floor Plans");
		Assert.assertEquals(atlmppge.getmpexhibitorsectionsection().getText(), "Exhibitor Directory");
		Assert.assertEquals(atlmppge.getmpsavedsearchessection().getText(), "Saved Searches");
		Assert.assertEquals(atlmppge.getmpmyinfosection().getText(), "My Info");
	}

	@Test(priority = 12)
	public void TS012_VerifyMPRegistrationCardOverviewTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP-001: To verify the Market Planner overview and it's functionality

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		lap.getMPLinkText().click();

		// Verify Registration Card details
		Assert.assertTrue(atlmppge.getmpmarketnameregcard().isDisplayed());
		Assert.assertTrue(atlmppge.getmpmarketdateregcard().isDisplayed());
		Assert.assertTrue(atlmppge.getmpregistrationlink().isDisplayed());

		// Verify Online Registrations page
		atlmppge.getmpregistrationlink().click();
		// Assert.assertTrue(atlmppge.getmpverifyregistrationinformationlink().isDisplayed());
		String rURL = driver.getCurrentUrl();
		Assert.assertTrue(rURL.contains(prop.getProperty("atlmrkturl_uat") + "Attend/Registration"));
	}

	@Test(priority = 13)
	public void TS013_VerifyAddToFavoriteFunctionalityForProductTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP-T237: Market Planner: Lists- Favorites- Add a Product to Favorites using
		// 'Favorite' icon in Product actions

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();
		atlexhact = new ATLExhLineProdActionsPage(driver);

		atlgs = new ATLGlobalSearchPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys("   ");
		atlgs.getATLSearchButton().click();
		Thread.sleep(15000);
		// Store the 1st Product name of Exhibitor
		String productNameOnSearchGrid = atlexhact.getExhProductNameOnSearchGrid().getText();
		System.out.println("Selected Product Name: " + productNameOnSearchGrid);

		// utl.scrollToElement(atlexhact.getExhibitorProduct());

		// Hovering on Product
		Actions actions = new Actions(driver);
		actions.moveToElement(atlexhact.getExhibitorProduct()).perform();
		// To mouseover on Add to Fav btn
		actions.moveToElement(atlexhact.getProductFevBtn()).perform();

		// Click on Add To Favorite button
		actions.click().perform();
		Thread.sleep(5000);

		// Click on Market Planner link
		lap.getMPLinkText().click();

		// Click on Lists tab on MP home page
		atlmppge.getMPHomeListsTab().click();
		atlmppge.getATLMPListsPageFavoritesMenu().click();

		Thread.sleep(5000);
		List<WebElement> favlist = driver.findElements(By.xpath(
				"//div[@class='imc-saved-exhibitors__contentItems__col2-1 imc-heading--h7 imc-heading--primary-medium imc-saved-exhibitors__name-title']"));
		boolean flag = false;
		for (WebElement list : favlist) {
			if (list.getText().equals(productNameOnSearchGrid)) {
				flag = true;
				break;
			}
		}
		if (flag == true) {
			Assert.assertTrue(flag = true);
		} else {
			Assert.assertTrue(flag = false);
		}
	}

	@Test(priority = 14)
	public void TS014_VerifyAddExhibitorToFavInFavListsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T243: Market Planner: Lists- Favorites- Add an Exhibitor to Favorites
		// using 'Favorite' icon in Exhibitor actions.

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();
		atlexhact = new ATLExhLineProdActionsPage(driver);

		atlgs = new ATLGlobalSearchPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Login to Market Planner
		/*
		 * utl.verifyMPLoginFunctionality(); Thread.sleep(6000);
		 */
		atlgs.getATLGlobalSearchTextBox().sendKeys("   ");
		atlgs.getATLSearchButton().click();
		Thread.sleep(15000);

		String exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		// Click on Favorite icon of 1st exhibitor
		atlexhact.getAddFavIcon().click();
		// Click on Market Planner link
		lap.getMPLinkText().click();

		// Click on Lists tab on MP home page
		atlmppge.getMPHomeListsTab().click();
		atlmppge.getATLMPListsPageFavoritesMenu().click();
		Thread.sleep(5000);
		List<WebElement> favlist = driver
				.findElements(By.xpath("//li[@class='imc-list-edit--draggable']/div/div/div/a"));
		boolean flag = false;
		for (WebElement list : favlist) {

			if (list.getText().equals(exhname)) {

				System.out.println("Equal");
				flag = true;
				break;
			}
		}
		if (flag == true) {
			Assert.assertTrue(flag = true);
		} else {
			Assert.assertTrue(flag = false);
		}

	}

	@Test(priority = 15)
	public void TS015_VerifyManageListOptionsOverviewTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP-T244: Market Planner: Lists- List Management- 'Manage List' Options.

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Market Planner
		lap.getMPLinkText().click();

		// Click on List tab
		atlmppge.getMPHomeListsTab().click();

		// Click on List from left Panel
		atlmppge.getMpListLeftPannel().click();

		// click on Edit list btn
		atlmppge.getATLMPEditListOptn().click();
		atlmppge.getMpManageDropdown().click();

		utl.checkItemPresentInListorNot(atlmppge.getlistOfmngDropdownElements(), "Edit");
		utl.checkItemPresentInListorNot(atlmppge.getlistOfmngDropdownElements(), "Email");
		utl.checkItemPresentInListorNot(atlmppge.getlistOfmngDropdownElements(), "Download");

	}

	@Test(priority = 16)
	public void TS016_VerifyEditListFunctionalityForManageListTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP-T245: Market Planner: Lists- List Management- Manage List- 'Edit' list
		// functionality
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Login to Market Planner
		/*
		 * utl.verifyMPLoginFunctionality(); Thread.sleep(6000);
		 */
		// Click on Market Planner
		lap.getMPLinkText().click();
		Thread.sleep(6000);
		atlmppge.getMPHomeListsTab().click();
		// Thread.sleep(10000);
		Thread.sleep(2000);
		// Click on List from left Pannel
		atlmppge.getMpListLeftPannel().click();
		// Thread.sleep(10000);
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
		Thread.sleep(10000);
		// Create new list for copy
		atlmppge.getMpListNewListBtn().click();
		// verify New ListPopup header
		Assert.assertTrue(
				atlmppge.getMpListNewGroupPopupHeader().getText().contains(prop.getProperty("CreateListPopupHeader")));
		// Enter List name
		String newlistnameforcopy = "Cyb" + genData.generateRandomString(5);
		atlmppge.getMpListNewGroupNameTxt().sendKeys(newlistnameforcopy);
		System.out.println("list name :: " + newlistnameforcopy);
		// Click on CreateBtn
		atlmppge.getMpListNewCreateBtn().click();
		Thread.sleep(10000);
		// Create new list for move
		atlmppge.getMpListNewListBtn().click();
		// verify New List Popup header
		Assert.assertTrue(
				atlmppge.getMpListNewGroupPopupHeader().getText().contains(prop.getProperty("CreateListPopupHeader")));
		// Enter List name
		String newlistnameforMove = "Cyb" + genData.generateRandomString(5);
		atlmppge.getMpListNewGroupNameTxt().sendKeys(newlistnameforMove);
		System.out.println("list name :: " + newlistnameforMove);
		// Click on Create Btn
		atlmppge.getMpListNewCreateBtn().click();
		Thread.sleep(10000);
		System.out.println("3 Lists are Created");
		// List<WebElement> allList =
		// driver.findElements(By.xpath("//div[@class='imc-market-planner-list_row_title']"));

		utl.ClickOnEditBtnOfAnyList(atlmppge.getallList(), newlistname);

		utl.addingExhProdLine(prop.getProperty("exhibitor1"));
		utl.addingExhProdLine(prop.getProperty("exhibitor2"));
		utl.addingExhProdLine(prop.getProperty("product1"));
		utl.addingExhProdLine(prop.getProperty("product2"));

		atlmppge.getMpManageDropdown().click();
		Thread.sleep(2000);

		// Select edit from dropdown

		utl.selectFilters(atlmppge.getlistOfmngDropdownElements(), "Edit");

		// click on Select All Btn
		atlmppge.getMpManageEditListSelectAllBtn().click();
		Thread.sleep(2000);
		List<WebElement> cclist=driver.findElements(By.xpath("//div[@class='imc-formfield imc-content imc-saved-exhibitors__chk-container']/label[1]"));
		
		for (WebElement allCheckbox : cclist) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			Assert.assertTrue(js.executeScript("arguments[0].checked", allCheckbox) == null);
		}
		System.out.println("All Checkbox checked");
		atlmppge.getMpManageEditListSelectAllBtn().click();
		Thread.sleep(2000);
		List<WebElement> cclist1=driver.findElements(By.xpath("//div[@class='imc-formfield imc-content imc-saved-exhibitors__chk-container']/label[1]"));
		
		for (WebElement allCheckbox : cclist1) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			Assert.assertFalse(js.executeScript("arguments[0].checked", allCheckbox) != null);
		}
		System.out.println("All Checkbox Unchecked");
		Thread.sleep(5000);
		WebElement cc = driver.findElement(By
				.xpath("(//div[@class='imc-formfield imc-content imc-saved-exhibitors__chk-container']/label[1])[1]"));
		// click on 1st checkbox
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", cc);
		String fExhpName =atlmppge.getfirstExhName().getText();
		
		// Click on Copy To Btn
		atlmppge.getMpManageEditListCopyToBtn().click();
		Thread.sleep(2000);
		Assert.assertTrue(atlmppge.getMpSelectListPopup().isDisplayed());
		Thread.sleep(5000);

		utl.ClickOnListSelectBtn(atlmppge.getallList(), newlistnameforcopy);

		// back to lists
		atlmppge.getmpBackToList().click();
		Thread.sleep(5000);
		// Find the list where we copy the exhibitor
		utl.ClickOnEditBtnOfAnyList(atlmppge.getallList(), newlistnameforcopy);
		Thread.sleep(5000);
		utl.checkItemPresentInListorNot(atlmppge.getlistOfAllExh(), fExhpName);
		System.out.println("Verified copied items are present into List");

		// Move List1 to List2 functinality
		// back to lists
		atlmppge.getmpBackToList().click();
		Thread.sleep(5000);

		utl.ClickOnEditBtnOfAnyList(atlmppge.getallList(), newlistname);

		atlmppge.getMpManageDropdown().click();
		Thread.sleep(2000);

		// Manage List DropDown : Select Edit
		utl.selectFilters(atlmppge.getlistOfmngDropdownElements(), "Edit");

	
		// click on 1st checkbox
		WebElement ccM = driver.findElement(By
				.xpath("(//div[@class='imc-formfield imc-content imc-saved-exhibitors__chk-container']/label[1])[1]"));
		JavascriptExecutor jsM = (JavascriptExecutor) driver;
		jsM.executeScript("arguments[0].click();", ccM);
		Thread.sleep(2000);
		String fiExhpName =atlmppge.getfirstExhName().getText();
		// Click on Move To Btn
		atlmppge.getmpManageEditListMoveBtn().click();
		Thread.sleep(2000);
		Assert.assertTrue(atlmppge.getMpSelectListPopup().isDisplayed());

		Thread.sleep(5000);
		// List from Select list window

		utl.ClickOnListSelectBtn(atlmppge.getallList(), newlistnameforMove);

		// *********Exhibitor disappired from the current list
		// code pending here *****

		// back to lists
		atlmppge.getmpBackToList().click();
		Thread.sleep(5000);

		utl.ClickOnEditBtnOfAnyList(atlmppge.getallList(), newlistnameforMove);

		utl.checkItemPresentInListorNot(atlmppge.getlistOfAllExh(),fiExhpName);
		System.out.println("Verified moved item is present");

		// Remove Exhibitors
		atlmppge.getMpManageDropdown().click();
		Thread.sleep(2000);

		// Manage List DropDown : Select Edit
		utl.selectFilters(atlmppge.getlistOfmngDropdownElements(), "Edit");

		// click on 1st checkbox
		WebElement ccD = driver.findElement(By
				.xpath("(//div[@class='imc-formfield imc-content imc-saved-exhibitors__chk-container']/label[1])[1]"));
		JavascriptExecutor jsD = (JavascriptExecutor) driver;
		jsD.executeScript("arguments[0].click();", ccD);
		Thread.sleep(2000);
		atlmppge.getmpManageEditListRemoveBtn().click();
		Thread.sleep(2000);

		// Assert.assertFalse(atlmppge.getlistOfAllExh().size()<1);
		System.out.println("Verified Items are removed from the list.");

		/*
		 * for (WebElement selectExhRR : atlmppge.getlistOfAllExh()) { //
		 * Thread.sleep(2000); // System.out.println(selectExhM.getText()); if
		 * (selectExhRR.getText().equals(prop.getProperty("exhibitor1"))) {
		 * System.out.println("Exh is present in list"); flag12 = true; break; } } if
		 * (flag12 == true) { System.out.println("Failed.. Present");
		 * Assert.assertTrue(flag12 = true); } else {
		 * System.out.println("Passed.. Not Present"); Assert.assertFalse(flag12 =
		 * false); }
		 */

	}

    @Test(priority = 17)
	public void TS017_VerifyDuplicateLinkFunctionalityForListTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T240: Market Planner: Lists: Lists: Duplicate Link functionality.

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Market Planner
		lap.getMPLinkText().click();

		// Click on List tab
		atlmppge.getMPHomeListsTab().click();

		// Click on List from left Panel
		atlmppge.getMpListLeftPannel().click();

		// click on New list btn
		atlmppge.getMpListNewListBtn().click();

		String newlistname = "Cyb" + genData.generateRandomString(5);
		atlmppge.getMpListNewGroupNameTxt().sendKeys(newlistname);

		// Click on Create Btn
		atlmppge.getMpListNewCreateBtn().click();

		Thread.sleep(10000);

		mplists = atlmppge.getATLMPListsNames();
		mpduplicatelistoptns = atlmppge.getATLMPDuplicateListOptns();

		for (int i = 0; i < mplists.size(); i++) {
			// System.out.println(mplists.get(i).getText());
			// System.out.println(mpeditlistoptns.get(i).getText());
			if (mplists.get(i).getText().equals(newlistname)) {
				mpduplicatelistoptns.get(i).click();
				break;
			}
		}
		// Enter Duplicate List name
		atlmppge.getMpDuplicateListInputBox().sendKeys(newlistname);
		atlmppge.getMpDuplicateBtn().click();
		Thread.sleep(4000);
		atlmppge.getCreateNewGrpPopupCloseBtn().click();

		/*// Manual bug
		Set<WebElement> hSet = new HashSet<WebElement>(mplists);
		for (WebElement x : mplists)
			hSet.add(x);

		System.out.println("Created HashSet is");
		for (WebElement x : hSet)
			System.out.println("New set is: " + x);
*/
	}

	@Test(priority = 18)
	public void TS018_VerifyRenameFunctionalityForListTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T241: Market Planner: Lists: Lists: Rename List functionality.

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Market Planner
		lap.getMPLinkText().click();

		// Click on List tab
		atlmppge.getMPHomeListsTab().click();

		// Click on List from left Panel
		atlmppge.getMpListLeftPannel().click();

		atlmppge.getMpListNewListBtn().click();
		// verify New List Popup header
		Assert.assertTrue(
				atlmppge.getMpListNewGroupPopupHeader().getText().contains(prop.getProperty("CreateListPopupHeader")));
		// Click on Create Btn
		atlmppge.getMpListNewCreateBtn().click();
		// Validate Invalid list name msg
		Assert.assertTrue(atlmppge.getMpInvalidGrNameMsg().getText().contains(prop.getProperty("InvalidListMsg")));

		String newlistname = "Cyb" + genData.generateRandomString(5);
		atlmppge.getMpListNameTxt().sendKeys(newlistname);
		// Click on Create Btn
		atlmppge.getMpListNewListCreateBtn().click();
		Thread.sleep(5000);
		// click on Edit list btn

		utl.ClickOnEditBtnOfAnyList(atlmppge.getallList(), newlistname);
		String currentListName = atlmppge.getmpCurrentListName().getText();
		Thread.sleep(5000);
		atlmppge.getmpRenameLink().click();
		String renameListName = "RenameList" + currentListName;
		atlmppge.getmpRenameInputField().clear();
		atlmppge.getmpRenameInputField().sendKeys(renameListName);
		atlmppge.getmpRenameInputSaveBtn().click();
		Thread.sleep(5000);
		// Verify Rename List Name
		Assert.assertTrue(atlmppge.getmpRenameListName().getText().equals(renameListName));
		// Back To List
		atlmppge.getmpBackToList().click();
		Thread.sleep(10000);

		utl.checkItemPresentInListorNot(atlmppge.getallList(), renameListName);
		System.out.println("Verified Rename list is present");
		utl.checkItemNotPresentInList(atlmppge.getallList(), currentListName);
		System.out.println("Verified Old list is not present");

	}

	@Test(priority = 19)
	public void TS019_VerifyAddToFavoriteFunctionalityForLineTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T242 : Market Planner: Lists- Favorites- Add an Line to Favorites using
		// 'Favorite' icon in Line actions

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		lap = new ATLLandingPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchlineinput")));
		atlgs.getATLSearchButton().click();
		Thread.sleep(15000);

		// Store the 1st Exhibitor name in String variable
		String exhname = atlexhact.getExhibitorName().getText();

		// Click on Favorite icon of 1st exhibitor
		atlexhact.getAddFavIcon().click();

		// Click on Market Planner link
		lap.getMPLinkText().click();

		// Click on Lists tab on MP home page
		atlmppge.getMPHomeListsTab().click();
		atlmppge.getATLMPListsPageFavoritesMenu().click();

		// Verify that the added favorites exhibitor should be displayed in to Favorites
		// list
		// Assert.assertTrue(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));
		Thread.sleep(8000);
		List<WebElement> favlist = driver
				.findElements(By.xpath("//li[@class='imc-list-edit--draggable']/div/div/div/a"));
		boolean flag = false;
		for (WebElement list : favlist) {
			// Thread.sleep(2000);

			if (list.getText().equals(exhname)) {

				System.out.println("Equal");
				flag = true;
				break;
			}
		}
		if (flag == true) {
			Assert.assertTrue(flag = true);
		} else {
			Assert.assertTrue(flag = false);
		}
		/*
		 * // Delete that favorites exhibitor from list
		 * atlmppge.getATLEditListItemMoreBtn().click();
		 * atlmppge.getATLEditListItemDeleteOptn().click(); Thread.sleep(6000);
		 * 
		 * // Verify that the added favorites exhibitor should be removed from Favorites
		 * list
		 * Assert.assertFalse(atlmppge.getATLSavedExhNameInList().getText().contains(
		 * exhname));
		 */
	}

	@Test(priority = 20)
	public void TS020_VerifyAddToFavoriteFunctionalityForExhibitorTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-

		// T243: The Add to Favorite functionality for an Exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		lap = new ATLLandingPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearch")));
		atlgs.getATLSearchButton().click();
		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		String exhname = atlexhact.getExhibitorName().getText();

		// Click on Favorite icon of 1st exhibitor
		atlexhact.getAddFavIcon().click();

		// Click on Market Planner link
		lap.getMPLinkText().click();

		// Click on Lists tab on MP home page
		atlmppge.getMPHomeListsTab().click();
		atlmppge.getATLMPListsPageFavoritesMenu().click();

		// Verify that the added favorites exhibitor should be displayed in to Favorites
		// list
		// Assert.assertTrue(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));

		Thread.sleep(5000);
		List<WebElement> favlist = driver
				.findElements(By.xpath("//li[@class='imc-list-edit--draggable']/div/div/div/a"));
		boolean flag = false;
		for (WebElement list : favlist) {
			// Thread.sleep(2000);

			if (list.getText().equals(exhname)) {

				System.out.println("Equal");
				flag = true;
				break;
			}
		}
		if (flag == true) {
			Assert.assertTrue(flag = true);
		} else {
			Assert.assertTrue(flag = false);
		}

		/*
		 * // Delete that favorites exhibitor from list
		 * atlmppge.getATLEditListItemMoreBtn().click();
		 * atlmppge.getATLEditListItemDeleteOptn().click(); Thread.sleep(6000);
		 * 
		 * favlist = driver.findElements(By.xpath(
		 * "//li[@class='imc-list-edit--draggable']/div/div/div/a"));
		 * 
		 * //Verify that the added favorites exhibitor should be removed from Favorites
		 * list for(int i=1; i< favlist.size(); i++) {
		 * //System.out.println(favlist.get(i).getText());
		 * Assert.assertFalse(favlist.get(i).getText().contains(exhname)); }
		 */
	}

	@Test(priority = 21)
	public void TS021_VerifyMPListsCardOverviewTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP-001: To verify the Market Planner overview and it's functionality

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		lap.getMPLinkText().click();
		Thread.sleep(6000);

		lap.getMPLinkText().click();

		// Verify dashboard page
		Assert.assertTrue(atlmppge.getmpregistrationcard().isDisplayed());
		Assert.assertTrue(atlmppge.getmplistscard().getText().contains("Lists"));
		Assert.assertTrue(atlmppge.getmpbookmyhotelcard().getText().contains("Hotel"));

		// Verify All Lists link is available at Lists card
		utl.scrollToElement(atlmppge.getmpalllists());
		Assert.assertTrue(atlmppge.getmpalllists().isDisplayed());

		// Save existing lists in List Card
		String SavedLists = atlmppge.getmpexistinglists().getText();

		// Click All Lists link and verify the result
		atlmppge.getmpalllists().click();
		Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("atlmrkturl_uat") + "Market-Planner/Lists"));

		// Click Lists tab
		atlmppge.getmplisttab().click();
		// Click New Lists button
		atlmppge.getmpnewlistbutton().click();
		// Add list name and click create button
		atlmppge.getCreateNewListNameTxtbx().sendKeys(genData.generateRandomString(10));
		atlmppge.getCreateNewListNameTxtbx().sendKeys();
		atlmppge.getAddListCreateBtn().click();
		// Click Dashboard tab
		atlmppge.getmpdasboardtab().click();
		// Verify if new list is displayed at List Card and old list is removed
		Assert.assertFalse(atlmppge.getmpexistinglists().getText().equalsIgnoreCase(SavedLists));
	}

	@Test(priority = 22)
	public void TS022_VerifyMPActivitiesCardOverviewTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP-001: To verify the Market Planner overview and it's functionality

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		lap.getMPLinkText().click();

		// Verify dashboard page
		Assert.assertTrue(atlmppge.getmpregistrationcard().isDisplayed());
		Assert.assertTrue(atlmppge.getmplistscard().getText().contains("Lists"));
		Assert.assertTrue(atlmppge.getmpbookmyhotelcard().getText().contains("Hotel"));

		// Verify all the tabs for Activities Card are properly displayed
		Assert.assertTrue(atlmppge.getmpbookhotel().getText().contains("Book a Hotel"));
		Assert.assertTrue(atlmppge.getmpfloorplans().getText().contains("Floor Plans"));
		Assert.assertTrue(atlmppge.getmpexpdirectory().getText().contains("Exhibitor Directory"));
		Assert.assertTrue(atlmppge.getmpsavedsearches().getText().contains("Saved Searches"));
		Assert.assertTrue(atlmppge.getmpmyinfo().getText().contains("My Info"));

		// Verify if all the tabs open up with proper pages
		atlmppge.getmpbookhotel().click();
		Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("atlmrkturl_uat") + "Attend/Hotels"));
		driver.navigate().back();

		atlmppge.getmpfloorplans().click();
		Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("atlmrkturl_uat") + "Market-Map"));
		driver.navigate().back();

		atlmppge.getmpexpdirectory().click();
		driver.navigate().back();

		atlmppge.getmpsavedsearches().click();
		Assert.assertTrue(
				driver.getCurrentUrl().contains(prop.getProperty("atlmrkturl_uat") + "Market-Planner/Saved-Searches"));
		driver.navigate().back();

		atlmppge.getmpmyinfo().click();
		Assert.assertTrue(
				driver.getCurrentUrl().contains(prop.getProperty("atlmrkturl_uat") + "Market-Planner/My-Info"));
		driver.navigate().back();
	}

	@Test(priority = 23)
	public void TS023_VerifyFilterByOptionsOverviewForListTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP-T249: Market Planner: Lists- List Management- 'Filter By' options

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Market Planner
		lap.getMPLinkText().click();

		atlmppge.getMPHomeListsTab().click();

		// Click on List from left Panel
		atlmppge.getMpListLeftPannel().click();

		// click on New list btn
		atlmppge.getMpListNewListBtn().click();
		// verify New List Popup header
		Assert.assertTrue(
				atlmppge.getMpListNewGroupPopupHeader().getText().contains(prop.getProperty("CreateListPopupHeader")));

		// Enter List name
		String newlistname = "Cyb" + genData.generateRandomString(5);
		atlmppge.getMpListNewGroupNameTxt().sendKeys(newlistname);

		// Click on Create Btn
		atlmppge.getMpListNewCreateBtn().click();
		Thread.sleep(10000);
		utl.ClickOnEditBtnOfAnyList(atlmppge.getallList(), newlistname);

		// Click on Filter By Dropdown
		atlmppge.getmpFilterByDropdown().click();
		// Verify All Filter By Options should available.
		utl.checkItemPresentInListorNot(atlmppge.getfilterByList(), "All");
		utl.checkItemPresentInListorNot(atlmppge.getfilterByList(), "Exhibitor");
		utl.checkItemPresentInListorNot(atlmppge.getfilterByList(), "Line");
		utl.checkItemPresentInListorNot(atlmppge.getfilterByList(), "Product");
		utl.checkItemPresentInListorNot(atlmppge.getfilterByList(), "Events and Seminars");
		utl.checkItemPresentInListorNot(atlmppge.getfilterByList(), "Custom");

	}


	@Test(priority = 24)
	public void TS024_VerifyFilterByOptionsFunctionalityForListTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP-T250: Market Planner: Lists- List Management- Filter By options
		// functionality

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Login to Market Planner
		/*
		 * utl.verifyMPLoginFunctionality(); Thread.sleep(6000);
		 */
		// Click on Market Planner
		lap.getMPLinkText().click();
		Thread.sleep(6000);
		atlmppge.getMPHomeListsTab().click();
		// Thread.sleep(10000);
		Thread.sleep(2000);
		// Click on List from left Pannel
		atlmppge.getMpListLeftPannel().click();

		Thread.sleep(2000);
		// atlmppge.getMpEditListoption().click();Thread.sleep(5000);
		// click on New list btn

		atlmppge.getMpListNewListBtn().click(); // verify New List Popup header
		Assert.assertTrue(
				atlmppge.getMpListNewGroupPopupHeader().getText().contains(prop.getProperty("CreateListPopupHeader")));
		// Enter List name
		String newlistname = "Cyb" + genData.generateRandomString(5);
		atlmppge.getMpListNewGroupNameTxt().sendKeys(newlistname);
		System.out.println("list name :: " + newlistname);
		// Click on Create Btn
		atlmppge.getMpListNewCreateBtn().click();
		// Add Exh using quick add
		Thread.sleep(10000);
		boolean flag1 = false;
		for (WebElement list1 : atlmppge.getallList()) {
			if (list1.getText().equals(newlistname)) {
				WebElement dListEditBtn1 = driver
						.findElement(By.xpath("//div[text()='" + newlistname + "']/../div[2]/span[2]"));
				utl.scrollToElement(dListEditBtn1);
				Thread.sleep(5000);
				dListEditBtn1.click();
				flag1 = true;
			}
		}
		if (flag1 == true) {
			Assert.assertTrue(flag1 = true);
		} else {
			Assert.assertTrue(flag1 = false);
		}

		utl.addingExhProdLine(prop.getProperty("exhibitor1"));
		utl.addingExhProdLine(prop.getProperty("exhibitor2"));
		utl.addingExhProdLine(prop.getProperty("product1"));
		utl.addingExhProdLine(prop.getProperty("product2"));
		utl.addingExhProdLine(prop.getProperty("line1"));
		utl.addingExhProdLine(prop.getProperty("line2"));
		utl.addingCutomItem();
		utl.addingCutomItem();

		atlmppge.getmpFilterByDropdown().click();
		Thread.sleep(2000);

		List<WebElement> filterByList = driver
				.findElements(By.xpath("//div[@class='react-select__menu-list css-11unzgr']/div"));
		boolean flagAll = false;
		for (WebElement listAll : filterByList) {
			// System.out.println(listAll.getText());
			if (listAll.getText().equals("All")) {
				// System.out.println(list.getText()); System.out.println("Equal");
				listAll.click();
				boolean flagExh = false;
				// List<WebElement> listOfAllExh =
				// driver.findElements(By.xpath("//a[@class='imc-link--alt-darkred']"));
				for (WebElement selectExh : atlmppge.getlistOfAllExh()) {
					// Thread.sleep(2000);
					System.out.println(selectExh.getText());
					Assert.assertTrue(selectExh.isDisplayed());
					flagExh = true;
				}
				if (flagExh == true) {
					Assert.assertTrue(flagExh = true);
				} else {
					Assert.assertTrue(flagExh = false);
				}
				flagAll = true;
				break;
			}
		}
		if (flagAll == true) {
			System.out.println("All Present");
			Assert.assertTrue(flagAll = true);
		} else {
			System.out.println("All Not Present");
			Assert.assertTrue(flagAll = false);
		}

		// Click on Exhibitor And verify only Exhibitors should displayed or not
		atlmppge.getmpFilterByDropdown().click();
		Thread.sleep(5000);
		utl.selectFilters(atlmppge.getfilterByList(), "Exhibitor");
		utl.checkItemPresentInListorNot(atlmppge.getnameofElement(), "Exhibitor");
		// Verify Line And Product should not displayed
		utl.checkItemNotPresentInList(atlmppge.getnameofElement(), "Line");
		utl.checkItemNotPresentInList(atlmppge.getnameofElement(), "Product");
		utl.checkItemNotPresentInList(atlmppge.getnameofElement(), "Events and Seminars");
		utl.checkItemNotPresentInList(atlmppge.getnameofElement(), "Custom");

		// Click on Line And verify Lines should displayed or not
		atlmppge.getmpFilterByDropdown().click();
		Thread.sleep(5000);
		utl.selectFilters(atlmppge.getfilterByList(), "Line");
		utl.checkItemPresentInListorNot(atlmppge.getnameofElement(), "Line");
		// Verify Exhibitor And Product should not displayed
		utl.checkItemNotPresentInList(atlmppge.getnameofElement(), "Exhibitor");
		utl.checkItemNotPresentInList(atlmppge.getnameofElement(), "Product");
		utl.checkItemNotPresentInList(atlmppge.getnameofElement(), "Events and Seminars");
		utl.checkItemNotPresentInList(atlmppge.getnameofElement(), "Custom");

		// Click on Product And verify Products should displayed or not
		
		  atlmppge.getmpFilterByDropdown().click(); Thread.sleep(5000);
		  utl.selectFilters(atlmppge.getfilterByList(), "Product");
		  utl.checkItemPresentInListorNot(atlmppge.getmpListOfAllProds(),"Product");
		  //Verify Lines And Exhibitors should not displayed
		  utl.checkItemNotPresentInList(atlmppge.getnameofElement(),"Line");
		  utl.checkItemNotPresentInList(atlmppge.getnameofElement(),"Exhibitor");
		  utl.checkItemNotPresentInList(atlmppge.getnameofElement(),"Events and Seminars");
		  utl.checkItemNotPresentInList(atlmppge.getnameofElement(),"Custom");
		  /*  
		 * // Click on Events and Seminars And verify it should displayed or not
		 * atlmppge.getmpFilterByDropdown().click(); Thread.sleep(5000);
		 * utl.selectFilters(atlmppge.getfilterByList(), "Events and Seminars");
		 * utl.checkItemPresentInListorNot(atlmppge.getnameofElement()
		 * ,"Events and Seminars"); // Verify Lines And Exhibitors should not displayed
		 * utl.checkItemNotPresentInList(atlmppge.getnameofElement(),"Line");
		 * utl.checkItemNotPresentInList(atlmppge.getnameofElement(),"Exhibitor");
		 * utl.checkItemNotPresentInList(atlmppge.getnameofElement(),"Product");
		 * utl.checkItemNotPresentInList(atlmppge.getnameofElement(),"Custom");
		 */

		// Click on Custom and Seminars And verify it should displayed or not
		atlmppge.getmpFilterByDropdown().click();
		Thread.sleep(5000);
		utl.selectFilters(atlmppge.getfilterByList(), "Custom");
		utl.checkItemPresentInListorNot(atlmppge.getnameofElement(), "Custom");
		// Verify Lines And Exhibitors should not displayed
		utl.checkItemNotPresentInList(atlmppge.getnameofElement(), "Line");
		utl.checkItemNotPresentInList(atlmppge.getnameofElement(), "Exhibitor");
		utl.checkItemNotPresentInList(atlmppge.getnameofElement(), "Product");
		utl.checkItemNotPresentInList(atlmppge.getnameofElement(), "Events and Seminars");

	}

	@Test(priority = 25)
	public void TS025_VerifyMarketPlannerListSortByTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP-T251: Market Planner: Lists- List Management- 'Sort By' options

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Login to Market Planner
		/*
		 * utl.verifyMPLoginFunctionality(); Thread.sleep(6000);
		 */
		// Click on Market Planner
		lap.getMPLinkText().click();
		Thread.sleep(6000);
		atlmppge.getMPHomeListsTab().click();
		// Thread.sleep(10000);
		Thread.sleep(2000);
		// Click on List from left Pannel
		atlmppge.getMpListLeftPannel().click();
		// Thread.sleep(10000);
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
		Thread.sleep(10000);

		utl.ClickOnEditBtnOfAnyList(atlmppge.getallList(), newlistname);
		atlmppge.getmpSortByDropdown().click();

		// Verify All Filter By Options should available.
		utl.checkItemPresentInListorNot(atlmppge.getfilterByList(), "Most Recent Added");
		utl.checkItemPresentInListorNot(atlmppge.getfilterByList(), "Location");
		utl.checkItemPresentInListorNot(atlmppge.getfilterByList(), "Time");
		utl.checkItemPresentInListorNot(atlmppge.getfilterByList(), "A-Z");
		utl.checkItemPresentInListorNot(atlmppge.getfilterByList(), "Custom");

	}

	@Test(priority = 26)
	public void TS026_VerifyDuplicateLinkFunctionalityForListTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T247: Market Planner: Lists: Lists: Validations for Duplicate Link
		// functionality

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Market Planner
		lap.getMPLinkText().click();

		// Click on List tab
		atlmppge.getMPHomeListsTab().click();

		// Click on List from left Panel
		atlmppge.getMpListLeftPannel().click();

		// click on New list btn
		atlmppge.getMpListNewListBtn().click();

		String newlistname = "Cyb" + genData.generateRandomString(5);
		atlmppge.getMpListNewGroupNameTxt().sendKeys(newlistname);
		atlmppge.getMpListNewCreateBtn().click();
		Thread.sleep(10000);

		WebElement duplicateLink = driver.findElement(By.xpath("//div[text()='" + newlistname + "']/../div[2]/span[1])"));
		duplicateLink.click();
		// Without entering List name
		atlmppge.getMpListNewCreateBtn().click();
		Thread.sleep(10000);
		// Verify Invalid list name error msg
		Assert.assertTrue(atlmppge.getDuplicateListErrorMsg().getText().contains(prop.getProperty("InvalidListMsg")));
		// Enter list name with special characters
		atlmppge.getMpListNewGroupNameTxt().sendKeys(prop.getProperty("listWithspecialChar"));
		atlmppge.getMpListNewCreateBtn().click();
		Thread.sleep(10000);
		// Verify list with special character duplicated or not
		utl.checkItemPresentInListorNot(atlmppge.getallList(), prop.getProperty("listWithspecialChar"));

	}

	@Test(priority = 27)
	public void TS027_VerifyListDisplayControlsTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP-T253: Market Planner: Lists- List Display Controls

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Market Planner
		lap.getMPLinkText().click();

		atlmppge.getMPHomeListsTab().click();

		// Click on List from left Panel
		atlmppge.getMpListLeftPannel().click();

		atlmppge.getMpEditListoption().click();

		Assert.assertTrue(atlmppge.getAtlmpGrByExhCheckbox().isDisplayed());
		Assert.assertTrue(atlmppge.getatlmpListView().isDisplayed());
		Assert.assertTrue(atlmppge.getatlmpGridView().isDisplayed());

	}

	@Test(priority = 28)
	public void TS028_VerifyListDisplayControlsFunctionalityTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP-T254: Market Planner: Lists- List Display Controls functionality

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Market Planner
		lap.getMPLinkText().click();

		atlmppge.getMPHomeListsTab().click();

		// Click on List from left Panel
		atlmppge.getMpListLeftPannel().click();

		
		// Create new list for copy
		atlmppge.getMpListNewListBtn().click();
		// verify New ListPopup header
		Assert.assertTrue(
				atlmppge.getMpListNewGroupPopupHeader().getText().contains(prop.getProperty("CreateListPopupHeader")));
		// Enter List name
		String newlistname = "Cyb" + genData.generateRandomString(5);
		atlmppge.getMpListNewGroupNameTxt().sendKeys(newlistname);
		System.out.println("list name :: " + newlistname);
		atlmppge.getMpListNewCreateBtn().click();
		Thread.sleep(10000);
		utl.ClickOnEditBtnOfAnyList(atlmppge.getallList(), newlistname);

		utl.addingExhProdLine(prop.getProperty("exhibitor1"));
		utl.addingExhProdLine(prop.getProperty("exhibitor3"));
		utl.addingExhProdLine(prop.getProperty("product1"));
		utl.addingExhProdLine(prop.getProperty("product2"));
		utl.addingExhProdLine(prop.getProperty("line1"));
		utl.addingExhProdLine(prop.getProperty("line2"));
	

		JavascriptExecutor js = (JavascriptExecutor)driver;
		//Click on Group By checkbox
		js.executeScript("document.getElementsByClassName('imc-checkbox--label')[1].click();");
		//Verify if checkbox is uncheck all the products,lines,exhibitos are displayed or not.
		 utl.checkItemPresentInListorNot(atlmppge.getnameofElement(),"Product");
		 utl.checkItemPresentInListorNot(atlmppge.getnameofElement(),"Line");
		 utl.checkItemPresentInListorNot(atlmppge.getnameofElement(),"Exhibitor");
		 
		 //Click on Group By checkbox
		 js.executeScript("document.getElementsByClassName('imc-checkbox--label')[1].click();");
		 Thread.sleep(3000);
		 //Verify if checkbox is checked then exhibitors and its sub product displayed or not
		 //Verify Exhibitor Present or not
		 utl.checkItemPresentInListorNot(atlmppge.getlistOfAllExh(),prop.getProperty("exhibitor3"));
		 //Verify Exhibitor and its sub product present or not
		 utl.checkItemPresentInListorNot(atlmppge.getmpListOfAllProds(),prop.getProperty("product2"));
		 
		
		atlmppge.getatlmpListView().click();
		Assert.assertTrue(atlmppge.getATLmpVerifyGridView().isDisplayed());
		atlmppge.getatlmpGridView().click();
		Assert.assertTrue(atlmppge.getATLmpVerifyListView().isDisplayed());

	}

	@Test(priority = 29)
	public void TS029_VerifyMarketPlannerListElementLocationLinkTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP:263-Market Planner: Lists- List Element - Location link

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Market Planner
		lap.getMPLinkText().click();

		atlmppge.getMPHomeListsTab().click();

		// Click on List from left Panel
		atlmppge.getMpListLeftPannel().click();

		utl.ClickOnEditBtnOfAnyList(atlmppge.getallList(), "RenameListRename_CybbDVeE");

		atlmppge.atlmpVerifyLocationLink();

		utl.checkLocationLink(atlmppge.getlistOfAllExh(), "OneCoast");
		System.out.println("Verify location Links are Present");
		utl.clickOnLocationLink(atlmppge.getlistOfAllExh(), "OneCoast");

		System.out.println("Verify respected location details page opend");
	}

	@Test(priority = 30)
	public void TS030_VerifyMarketPlannerListsElementMoreOoptionsOverviewTest()
			throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP:258-Market Planner: Lists- List Element Management- 'More' options
		// overview

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Market Planner
		lap.getMPLinkText().click();

		atlmppge.getMPHomeListsTab().click();

		// Click on List from left Panel
		atlmppge.getMpListLeftPannel().click();

		atlmppge.getMpEditListoption().click();
		utl.addingExhProdLine("IMC test company");
		WebElement moreLink = driver.findElement(By.xpath("//a[text()='IMC test company']/../../../div[1]/div[4]"));
		Actions moreLinkHover = new Actions(driver);
		moreLinkHover.moveToElement(moreLink).build().perform();
		List<WebElement> allMoreOptions = driver
				.findElements(By.xpath("//a[text()='IMC test company']/../../../div[1]/div[4]/div[1]/div[1]/span/a"));

		utl.checkItemPresentInListorNot(allMoreOptions, "Copy");
		utl.checkItemPresentInListorNot(allMoreOptions, "Move");
		utl.checkItemPresentInListorNot(allMoreOptions, "Delete");
		utl.checkItemPresentInListorNot(allMoreOptions, "Add To Schedule");

	}

	@Test(priority = 31)
	public void TS031_VerifyMarketPlannerListsElementMoreOoptionsCopyeTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP:259-Market Planner: Lists- List Element Management- More- 'Copy' option
		// functionality

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Market Planner
		lap.getMPLinkText().click();

		atlmppge.getMPHomeListsTab().click();

		// Click on List from left Panel
		atlmppge.getMpListLeftPannel().click();

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
		// Create new list for copy
		atlmppge.getMpListNewListBtn().click();
		// verify New ListPopup header
		Assert.assertTrue(
				atlmppge.getMpListNewGroupPopupHeader().getText().contains(prop.getProperty("CreateListPopupHeader")));
		// Enter List name
		String newlistnameforcopy = "Cyb" + genData.generateRandomString(5);
		atlmppge.getMpListNewGroupNameTxt().sendKeys(newlistnameforcopy);
		System.out.println("list name :: " + newlistnameforcopy);
		atlmppge.getMpListNewCreateBtn().click();
		Thread.sleep(10000);
		utl.ClickOnEditBtnOfAnyList(atlmppge.getallList(), newlistname);

		utl.addingExhProdLine(prop.getProperty("exhibitor2"));
		
		String exName = prop.getProperty("exhibitor2");

		WebElement moreLink = driver.findElement(By.xpath("//div[@class='imc-gallery imc-saved-exhibitors__outer-row imc-market-planner-list--mobile-overlays-left']/div[1]/div[1]/a[1]/../../div[4]"));
		Actions moreLinkHover = new Actions(driver);
		moreLinkHover.moveToElement(moreLink).build().perform();
		List<WebElement> allMoreOptions = driver
				.findElements(By.xpath("//div[@class='imc-gallery imc-saved-exhibitors__outer-row imc-market-planner-list--mobile-overlays-left']/div[1]/div[1]/a[1]/../../div[4]/div[1]/div[1]/span/a"));
		utl.selectFilters(allMoreOptions, "Copy");

		Thread.sleep(2000);
		Assert.assertTrue(atlmppge.getMpSelectListPopup().isDisplayed());
		Thread.sleep(5000);

		utl.ClickOnListSelectBtn(atlmppge.getallList(), newlistnameforcopy);

		atlmppge.getmpBackToList().click();
		Thread.sleep(5000);
		// Find the list where we copy the exhibitor
		utl.ClickOnEditBtnOfAnyList(atlmppge.getallList(), newlistnameforcopy);

		utl.checkItemPresentInListorNot(atlmppge.getlistOfAllExh(), prop.getProperty("exhibitor2"));
		System.out.println("Verified copied items are present into List");

	}

	@Test(priority = 32)
	public void TS032_VerifyMarketPlannerListsElementMoreOoptionsMoveTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP:260-Market Planner: Lists- List Element Management- More- 'Move' option
		// functionality

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Market Planner
		lap.getMPLinkText().click();

		atlmppge.getMPHomeListsTab().click();

		// Click on List from left Panel
		atlmppge.getMpListLeftPannel().click();

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
		// Create new list for copy
		atlmppge.getMpListNewListBtn().click();
		// verify New ListPopup header
		Assert.assertTrue(
				atlmppge.getMpListNewGroupPopupHeader().getText().contains(prop.getProperty("CreateListPopupHeader")));
		// Enter List name
		String newlistnameformove = "Cyb" + genData.generateRandomString(5);
		atlmppge.getMpListNewGroupNameTxt().sendKeys(newlistnameformove);
		System.out.println("list name :: " + newlistnameformove);
		atlmppge.getMpListNewCreateBtn().click();
		Thread.sleep(10000);
		utl.ClickOnEditBtnOfAnyList(atlmppge.getallList(), newlistname);

		utl.addingExhProdLine(prop.getProperty("exhibitor1"));
		String exName = prop.getProperty("exhibitor1");

/*		WebElement moreLink = driver.findElement(By.xpath("//a[text()='" + exName + "']/../../../div[1]/div[4]"));
		Actions moreLinkHover = new Actions(driver);
		moreLinkHover.moveToElement(moreLink).build().perform();
		List<WebElement> allMoreOptions = driver
				.findElements(By.xpath("//a[text()='" + exName + "']/../../../div[1]/div[4]/div[1]/div[1]/span/a"));
		*/
		WebElement moreLink = driver.findElement(By.xpath("//div[@class='imc-gallery imc-saved-exhibitors__outer-row imc-market-planner-list--mobile-overlays-left']/div[1]/div[1]/a[1]/../../div[4]"));
		Actions moreLinkHover = new Actions(driver);
		moreLinkHover.moveToElement(moreLink).build().perform();
		List<WebElement> allMoreOptions = driver
				.findElements(By.xpath("//div[@class='imc-gallery imc-saved-exhibitors__outer-row imc-market-planner-list--mobile-overlays-left']/div[1]/div[1]/a[1]/../../div[4]/div[1]/div[1]/span/a"));
		

		Thread.sleep(2000);
		utl.selectFilters(allMoreOptions, "Move");

		Thread.sleep(2000);
		Assert.assertTrue(atlmppge.getMpSelectListPopup().isDisplayed());
		Thread.sleep(5000);

		utl.ClickOnListSelectBtn(atlmppge.getallList(), newlistnameformove);

		/*****************************
		 * Move Item Removed from current list. Code Pending here
		 */

		atlmppge.getmpBackToList().click();
		Thread.sleep(5000);
		// Find the list where we copy the exhibitor
		utl.ClickOnEditBtnOfAnyList(atlmppge.getallList(), newlistnameformove);
Thread.sleep(5000);
		utl.checkItemPresentInListorNot(atlmppge.getlistOfAllExh(), prop.getProperty("exhibitor1"));
		System.out.println("Verified Moved items are present into List");

	}

	@Test(priority = 33)
	public void TS033_VerifyMarketPlannerListsElementMoreOoptionsDeleteTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP:261-Market Planner: Lists- List Element Management- More- 'Delete' option
		// functionality

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Market Planner
		lap.getMPLinkText().click();

		atlmppge.getMPHomeListsTab().click();

		// Click on List from left Panel
		atlmppge.getMpListLeftPannel().click();

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
		Thread.sleep(10000);
		utl.ClickOnEditBtnOfAnyList(atlmppge.getallList(), newlistname);

		utl.addingExhProdLine(prop.getProperty("exhibitor1"));
		utl.addingExhProdLine(prop.getProperty("exhibitor2"));
		String exName = prop.getProperty("exhibitor1");
		Thread.sleep(5000);
		/*WebElement moreLink = driver.findElement(By.xpath("//a[text()='" + exName + "']/../../../div[1]/div[4]"));
		Actions moreLinkHover = new Actions(driver);
		moreLinkHover.moveToElement(moreLink).build().perform();
		List<WebElement> allMoreOptions = driver
				.findElements(By.xpath("//a[text()='" + exName + "']/../../../div[1]/div[4]/div[1]/div[1]/span/a"));
		*/
		WebElement moreLink = driver.findElement(By.xpath("//div[@class='imc-gallery imc-saved-exhibitors__outer-row imc-market-planner-list--mobile-overlays-left']/div[1]/div[1]/a[1]/../../div[4]"));
		Actions moreLinkHover = new Actions(driver);
		moreLinkHover.moveToElement(moreLink).build().perform();
		List<WebElement> allMoreOptions = driver
				.findElements(By.xpath("//div[@class='imc-gallery imc-saved-exhibitors__outer-row imc-market-planner-list--mobile-overlays-left']/div[1]/div[1]/a[1]/../../div[4]/div[1]/div[1]/span/a"));
		
		utl.selectFilters(allMoreOptions, "Delete");
		Thread.sleep(5000);
		utl.checkItemNotPresentInList(atlmppge.getlistOfAllExh(), exName);
	}

	@Test(priority = 34)
	public void TS034_VerifyMarketPlannerListManagementAddNoteTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP:256-Market Planner: Lists- List Management- 'Add Note' functionality

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();
		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Market Planner
		lap.getMPLinkText().click();

		atlmppge.getMPHomeListsTab().click();

		// Click on List from left Panel
		atlmppge.getMpListLeftPannel().click();

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
		Thread.sleep(10000);
		utl.ClickOnEditBtnOfAnyList(atlmppge.getallList(), newlistname);

		utl.addingExhProdLine(prop.getProperty("exhibitor1"));
		String exName = prop.getProperty("exhibitor1");
		WebElement noteLink = driver.findElement(By.xpath("//a[text()='" + exName + "']/../../../div[1]/div[3]"));
		noteLink.click();
		// Store the new note name
		String newnotetitle = "CybNote" + genData.generateRandomString(3);
		// Enter Note title
		atlexhact.getNoteTitleTxtBx().sendKeys(newnotetitle);

		Thread.sleep(5000);
		// Enter Note Content
		atlexhact.getNoteContentTxtBx().sendKeys("TestProdNote" + genData.generateRandomString(6));
		Thread.sleep(5000);
		atlexhact.getNoteTitleTxtBx().sendKeys(newnotetitle);
		// Click on 'Save' button
		atlexhact.getNoteSaveBtn().click();
		Thread.sleep(5000);

		noteLink.click();
		Thread.sleep(2000);
		// Click on 'View all Notes for an Exhibitor' link on Add Notes pop-up
		atlexhact.getViewAllNotesLink().click();
		Thread.sleep(5000);

		List<WebElement> allnoteslist = atlexhact.getSavedNoteNameInAllNotesList();

		utl.checkItemPresentInListorNot(allnoteslist, newnotetitle);
		utl.selectFilters(allnoteslist, newnotetitle);

		Thread.sleep(2000);
		// Delete the saved note
		atlexhact.getDeleteNoteBtn().click();
		noteLink.click();
		Thread.sleep(2000);
		// Click on 'View all Notes for an Exhibitor' link on Add Notes pop-up
		atlexhact.getViewAllNotesLink().click();
		Thread.sleep(2000);
		// Verify Deleted Note not present
		// utl.checkItemNotPresentInList(atlexhact.getSavedNoteNameInAllNotesList(),
		// newnotetitle);
		try {
			utl.checkItemNotPresentInList(atlexhact.getSavedNoteNameInAllNotesList(), newnotetitle);
		} catch (Exception e) {
			System.out.println("Note Deleted successully");
			Thread.sleep(2000);
			atlmppge.getcloseNotePopup().click();
		}
		atlmppge.getcloseNotePopup().click();
		driver.get(prop.getProperty("atlmrkturl_uat"));
	}

	@Test(priority = 35)
	public void TS035_VerifyMarketPlannerEditListCustomItemTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP:264-Market Planner: Lists: Lists: Edit List: Add Custom Item
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();
		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Market Planner
		lap.getMPLinkText().click();

		atlmppge.getMPHomeListsTab().click();

		// Click on List from left Panel
		atlmppge.getMpListLeftPannel().click();

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
		utl.ClickOnEditBtnOfAnyList(atlmppge.getallList(), newlistname);
		// Click on Add Custom item Btn
		atlmppge.getAddCustomItem().click();
		// Verify Header of custom Item popup
		Assert.assertTrue(atlmppge.getcustomItemHeader().getText().contains(prop.getProperty("CustomItemHeader")));
		String newTitle = "Cyb" + genData.generateRandomString(5);
		// Enter Title
		atlmppge.getCustomTitle().sendKeys(newTitle);
		String newDesc = "Cyb" + genData.generateRandomString(20);
		// Enter Description
		atlmppge.getCustomDesc().sendKeys(newDesc);
		// click on Submit Btn
		atlmppge.getCustomItemsubmitBtn().click();
		utl.checkItemPresentInListorNot(atlmppge.getATLlistOfCustomItems(), newDesc);

		// Cancel Btn Test
		atlmppge.getAddCustomItem().click();
		// Verify Header of custom Item popup
		Assert.assertTrue(atlmppge.getcustomItemHeader().getText().contains(prop.getProperty("CustomItemHeader")));
		String newTitle1 = "Cyb" + genData.generateRandomString(5);
		// Enter Title
		atlmppge.getCustomTitle().sendKeys(newTitle1);
		String newDesc1 = "Cyb" + genData.generateRandomString(20);
		// Enter Description
		atlmppge.getCustomDesc().sendKeys(newDesc1);
		// click on Submit Btn
		atlmppge.getcancelBtnCustomItem().click();
		utl.checkItemNotPresentInList(atlmppge.getATLlistOfCustomItems(), newDesc1);

	}

	@Test(priority = 36)
	public void TS036_VerifyMarketPlannerEditListAddNoteTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP:265-Market Planner: Lists: Lists: Edit List: Add Note
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();
		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Market Planner
		lap.getMPLinkText().click();

		atlmppge.getMPHomeListsTab().click();

		// Click on List from left Panel
		atlmppge.getMpListLeftPannel().click();

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
		Thread.sleep(10000);
		utl.ClickOnEditBtnOfAnyList(atlmppge.getallList(), newlistname);
		// Click on Add Note Btn
		atlmppge.getaddNoteBtn().click();
		// Store the new note name
		String newnotetitle = "CybNote" + genData.generateRandomString(3);
		// Enter Note title
		atlexhact.getNoteTitleTxtBx().sendKeys(newnotetitle);
		Thread.sleep(5000);
		// Enter Note Content
		atlexhact.getNoteContentTxtBx().sendKeys("TestProdNote" + genData.generateRandomString(6));
		Thread.sleep(5000);
		atlexhact.getNoteTitleTxtBx().sendKeys(newnotetitle);
		// Click on 'Save' button
		atlexhact.getNoteSaveBtn().click();
		Thread.sleep(5000);
		// Verify Note is appeared below the Add note btn
		utl.checkItemPresentInListorNot(atlmppge.getlistOfAllNewAddedNotes(), newnotetitle);
		// Click on Add Note Btn
		atlmppge.getaddNoteBtn().click();
		Thread.sleep(2000);
		// Click on 'View all Notes for an Exhibitor' link on Add Notes pop-up
		atlexhact.getViewAllNotesLink().click();
		Thread.sleep(5000);

		List<WebElement> allnoteslist = atlexhact.getSavedNoteNameInAllNotesList();

		utl.checkItemPresentInListorNot(allnoteslist, newnotetitle);
		utl.selectFilters(allnoteslist, newnotetitle);

		Thread.sleep(2000);
		// Delete the saved note
		atlexhact.getDeleteNoteBtn().click();
		// Click on Add Note Btn
		atlmppge.getaddNoteBtn().click();
		Thread.sleep(2000);
		// Click on 'View all Notes for an Exhibitor' link on Add Notes pop-up
		atlexhact.getViewAllNotesLink().click();
		Thread.sleep(2000);
		// Verify Deleted Note not present
		try {
			utl.checkItemNotPresentInList(atlexhact.getSavedNoteNameInAllNotesList(), newnotetitle);
		} catch (Exception e) {
			System.out.println("Note Deleted successully");
			atlmppge.getcloseNotePopup().click();
		}
		// Close Note Popup
		// Click on Add Note Btn
		atlmppge.getaddNoteBtn().click();
		// Store the new note name
		String newnotetitle1 = "CybNote" + genData.generateRandomString(3);
		// Enter Note title
		atlexhact.getNoteTitleTxtBx().sendKeys(newnotetitle1);

		Thread.sleep(5000);
		// Enter Note Content
		atlexhact.getNoteContentTxtBx().sendKeys("TestProdNote" + genData.generateRandomString(6));
		Thread.sleep(5000);
		atlexhact.getNoteTitleTxtBx().sendKeys(newnotetitle1);
		// Click on 'Save' button
		atlmppge.getcloseNotePopup().click();
		// utl.checkItemNotPresentInList(atlexhact.getSavedNoteNameInAllNotesList(),
		// newnotetitle1);
		try {
			utl.checkItemNotPresentInList(atlexhact.getSavedNoteNameInAllNotesList(), newnotetitle1);
		} catch (Exception e) {
			System.out.println("Note Popup closed successully and New note not added");

		}
	}

	@Test(priority = 37)
	public void TS037_VerifyMarketPlannerListsAllSavedExhibitorsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T267: Market Planner: Lists- All Saved Exhibitors

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();
		atlexhact = new ATLExhLineProdActionsPage(driver);

		atlgs = new ATLGlobalSearchPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Login to Market Planner
		/*
		 * utl.verifyMPLoginFunctionality(); Thread.sleep(6000);
		 */
		atlgs.getATLGlobalSearchTextBox().sendKeys("   ");
		atlgs.getATLSearchButton().click();
		Thread.sleep(15000);

		String exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		// Click on Favorite icon of 1st exhibitor
		atlexhact.getAddFavIcon().click();
		// Click on Market Planner link
		lap.getMPLinkText().click();

		// Click on Lists tab on MP home page
		atlmppge.getMPHomeListsTab().click();
		atlmppge.getallSavedExhibiorMenu().click();
		Thread.sleep(8000);
		utl.checkItemPresentInListorNot(atlmppge.getlistOfAllExh(), exhname);

	}

	@Test(priority = 38)
	public void TS038_VerifyMarketPlannerListsAllSavedProductsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T266: Market Planner: Lists- All Saved Products

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();
		atlexhact = new ATLExhLineProdActionsPage(driver);

		atlgs = new ATLGlobalSearchPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys("   ");
		atlgs.getATLSearchButton().click();
		Thread.sleep(15000);
		// Store the 1st Product name of Exhibitor
		String productNameOnSearchGrid = atlexhact.getExhProductNameOnSearchGrid().getText();
		System.out.println("Selected Product Name: " + productNameOnSearchGrid);

		// utl.scrollToElement(atlexhact.getExhibitorProduct());

		// Hovering on Product
		Actions actions = new Actions(driver);
		actions.moveToElement(atlexhact.getExhibitorProduct()).perform();
		// To mouseover on Add to Fav btn
		//actions.moveToElement(atlexhact.getProductFevBtn()).perform();
		atlexhact.getProductFevBtn().click();
		
		// Click on Add To Favorite button
		//actions.click().perform();
		Thread.sleep(5000);

		// Click on Market Planner link
		lap.getMPLinkText().click();

		// Click on Lists tab on MP home page
		atlmppge.getMPHomeListsTab().click();
		atlmppge.getallSavedProductMenu().click();
		Thread.sleep(5000);
		
		utl.checkItemPresentInListorNot(atlmppge.getlistOfAllExh(), productNameOnSearchGrid);
	}

	@Test(priority = 39)
	public void TS039_VerifyMarketPlannerRegistrationsTabTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP:280-Market Planner: Registrations
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();
		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Market Planner
		lap.getMPLinkText().click();
		// Click on Mp Reg tab
		atlmppge.getmpRegistrationTab().click();
		atlmppge.getmpRegisterNowBtn().click();
		Assert.assertTrue(driver.getTitle().contains("Market Registration"));
		System.out.println("User is redirected to Market Registration page.");
	}

	@Test(priority = 40)
	public void TS040_VerifyMarketSavedSearchesfunctionalityTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP:T59-Market Planner: Saved Searches
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();
		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("saveSearchTerm"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);
		// Click on Saved searches Icon
		atlmppge.getmpSavedSearchesIcon().click();
		// Click on Save Search Btn to Save the Term
		atlmppge.getmpSaveSearcheBtn().click();
		// Enter Search text into input field
		atlmppge.getmpSaveSearcheNameInput().sendKeys(prop.getProperty("saveSearchTerm"));
		// Click on Save Btn
		atlmppge.getmpSaveSearcheInputBtn().click();
		Thread.sleep(3000);

		// Click on Market Planner
		lap.getMPLinkText().click();
		// Click on Mp Reg tab
		atlmppge.getmpsavedsearchestab().click();
		// click on Search Term
		utl.selectFilters(atlmppge.getmplistOfAllSaveSearches(), prop.getProperty("saveSearchTerm"));
		Thread.sleep(5000);
		String temp = atlmppge.getmplistSearcheAlert().getText();
		System.out.println(temp);
		// Assert.assertTrue(prop.getProperty("saveSearchTerm").contains(temp));
		// Verify save search
		Assert.assertTrue(temp.contains(prop.getProperty("saveSearchTerm")));

	}

	@Test(priority = 41)
	public void TS041_VerifyMarketSavedSearchesDeletefunctionalityTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP:281-Market Planner: Saved Searches- 'Delete' functionality
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();
		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/*atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("saveSearchTerm"));
		atlgs.getATLSearchButton().click();
		// Click on Saved searches Icon
		atlmppge.getmpSavedSearchesIcon().click();
		// Click on Save Search Btn to Save the Term
		atlmppge.getmpSaveSearcheBtn().click();
		// Enter Search text into input field
		atlmppge.getmpSaveSearcheNameInput().sendKeys(prop.getProperty("saveSearchTerm"));
		// Click on Save Btn
		atlmppge.getmpSaveSearcheInputBtn().click();
		Thread.sleep(3000);
*/
		lap.getMPLinkText().click();
		// Click on Mp Reg tab
		atlmppge.getmpsavedsearchestab().click();
		
		try{
			if(atlmppge.getnoSavedSearchesMsg().isDisplayed())
			{
			TS040_VerifyMarketSavedSearchesfunctionalityTest();	
			// Click on Market Planner
			lap.getMPLinkText().click();
			// Click on Mp Reg tab
			atlmppge.getmpsavedsearchestab().click();

			List<WebElement> deleteBtn = driver
					.findElements(By.xpath("//a[text()='"+ prop.getProperty("saveSearchTerm")+"']/../../div[2]/span[2]"));

			//System.out.println(deleteBtn);
			for (WebElement webElement : deleteBtn) {
				webElement.click();
				atlmppge.getmpConfirmDeleteBtn().click();
				Thread.sleep(5000);	
			}
			try {
				utl.checkItemNotPresentInList(atlmppge.getmplistOfAllSaveSearches(), prop.getProperty("saveSearchTerm"));
			} catch (Exception e) {
				System.out.println("Saved Search Term deleted succsfully ");
			}
			}
		}catch(TimeoutException ee){
		
		// Click on Market Planner
		lap.getMPLinkText().click();
		// Click on Mp Reg tab
		atlmppge.getmpsavedsearchestab().click();

		List<WebElement> deleteBtn = driver
				.findElements(By.xpath("//a[text()='"+ prop.getProperty("saveSearchTerm")+"']/../../div[2]/span[2]"));

		//System.out.println(deleteBtn);
		for (WebElement webElement : deleteBtn) {
			webElement.click();
			atlmppge.getmpConfirmDeleteBtn().click();
			Thread.sleep(5000);	
		}
		try {
			utl.checkItemNotPresentInList(atlmppge.getmplistOfAllSaveSearches(), prop.getProperty("saveSearchTerm"));
		} catch (Exception e) {
			System.out.println("Saved Search Term deleted succsfully ");
		}
		}
	}

	@Test(priority = 42)
	public void TS042_VerifyMarketPlannerListSortByFunctionalityTest() throws IOException, InterruptedException {

		// The purpose of this test case to verify:-
		// UXP-T252: Market Planner: Lists- List Management- Sort By options
		// functionality

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();
		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Login to Market Planner
		/*
		 * utl.verifyMPLoginFunctionality(); Thread.sleep(6000);
		 */
		// atlgs.getATLGlobalSearchTextBox().click();
		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("sortByFilterInput"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);
		String exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		// Click on Favorite icon of 1st exhibitor
		atlexhact.getAddFavIcon().click();
		Thread.sleep(2000);

		utl.addingExhForSorting("Baggallini");

		Thread.sleep(2000);
		String exhname1 = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname1);
		Thread.sleep(2000);
		// Click on Favorite icon of 1st exhibitor
		atlexhact.getAddFavIcon().click();
		Thread.sleep(2000);

		utl.addingExhForSorting("TWS Italian Paintings");
		Thread.sleep(5000);

		String exhname2 = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname2);

		// Click on Favorite icon of 1st exhibitor
		atlexhact.getAddFavIcon().click();

		lap.getMPLinkText().click();

		// Click on Lists tab on MP home page
		atlmppge.getMPHomeListsTab().click();
		atlmppge.getATLMPListsPageFavoritesMenu().click();
		Thread.sleep(5000);

		/*// Click on SortBy Dropdown
		atlmppge.getmpSortByDropdown().click();

		// Verify All Filter By Options should available.
		utl.selectFilters(atlmppge.getfilterByList(), "Most Recent Added");
		Thread.sleep(5000);
		List<WebElement> favlist = driver
				.findElements(By.xpath("//li[@class='imc-list-edit--draggable']/div/div/div/a"));
		boolean flag = false;
		for (WebElement list : favlist) {

			if (list.getText().equals(exhname)) {

				System.out.println("Equal");
				flag = true;
				break;
			}
		}
		if (flag == true) {
			Assert.assertTrue(flag = true);
		} else {
			Assert.assertTrue(flag = false);
		}
*/
		// Sort filter

		// Create current Exhibitor list without sort
		List<String> currentList = new ArrayList<String>();
		List<WebElement> elementList = driver
				.findElements(By.xpath("//li[@class='imc-list-edit--draggable']/div/div/div/a"));
		for (WebElement we : elementList) {
			currentList.add(we.getText().toLowerCase());
		}
		System.out.println("Current Exhibitor List : " + currentList);

		// Create sorted list
		List<String> sortedList = new ArrayList<String>();
		for (String s : currentList) {
			sortedList.add(s.toLowerCase());
		}
		Collections.sort(sortedList);
		// System.out.println("Sorted list : "+sortedList);

		atlmppge.getmpSortByDropdown().click();

		// Verify All Filter By Options should available.
		utl.selectFilters(atlmppge.getfilterByList(), "A-Z");
		Thread.sleep(5000);
		List<WebElement> favlist2 = driver
				.findElements(By.xpath("//li[@class='imc-list-edit--draggable']/div/div/div/a"));

		// Sorted list from filter Sort A-Z
		List<String> expectedSortedList = new ArrayList<String>();
		for (WebElement we : favlist2) {
			expectedSortedList.add(we.getText().toLowerCase());
		}
		// Thread.sleep(25000);
		System.out.println("Expected sorted Exhibitor List : " + expectedSortedList);
		// Verify Exhibitor List is Sorted or not
		Assert.assertEquals(sortedList, expectedSortedList, "Exhibitor List Should be sorted");

		// Location
		// Create current Exhibitor list without sort
		List<String> currentLocationList = new ArrayList<String>();
		List<WebElement> locationElementList = driver
				.findElements(By.xpath("//span[@class='imc-mp-location-numbers']"));
		for (WebElement we : locationElementList) {
			currentLocationList.add(we.getText().toLowerCase());
		}
		System.out.println("Current Location List : " + currentLocationList);

		// Create sorted list
		List<String> sortedLocationList = new ArrayList<String>();
		for (String s : currentLocationList) {
			sortedLocationList.add(s.toLowerCase());
		}
		Collections.sort(sortedLocationList);
		// System.out.println("Sorted list : "+sortedList);

		atlmppge.getmpSortByDropdown().click();

		// Verify All Filter By Options should available.
		utl.selectFilters(atlmppge.getfilterByList(), "Location");
		Thread.sleep(5000);
		List<WebElement> LocationList = driver.findElements(By.xpath("//span[@class='imc-mp-location-numbers']"));

		// Sorted list from filter Sort A-Z
		List<String> expectedLocationSortedList = new ArrayList<String>();
		for (WebElement we : LocationList) {
			expectedLocationSortedList.add(we.getText().toLowerCase());
		}
		// Thread.sleep(25000);
		System.out.println("Expected sorted Exhibitor List : " + expectedLocationSortedList);
		// Verify Exhibitor List is Sorted or not
		Assert.assertEquals(sortedLocationList, expectedLocationSortedList, "Exhibitor List Should be sorted");

	}

	@Test(priority = 43)
	public void TS043_VerifyMarketPlannerListsElementMoreOoptionsAddToScheduleTest()
			throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP:262-Market Planner: Lists- List Element Management- More- 'Add to
		// Schedule' option functionality

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Market Planner
		lap.getMPLinkText().click();

		atlmppge.getMPHomeListsTab().click();

		// Click on List from left Panel
		
		  atlmppge.getMpListLeftPannel().click();
		  
		  atlmppge.getMpListNewListBtn().click(); // verify New List Popup header
		  Assert.assertTrue(atlmppge.getMpListNewGroupPopupHeader().getText().contains(prop.getProperty( "CreateListPopupHeader"))); 
		  // Enter List  name
		  String newlistname = "Cyb" + genData.generateRandomString(5);
		  atlmppge.getMpListNewGroupNameTxt().sendKeys(newlistname);
		  System.out.println("list name :: " + newlistname); 
		  // Click on Create Btn
		  atlmppge.getMpListNewCreateBtn().click(); 
		  Thread.sleep(10000); 
		  
		  utl.ClickOnEditBtnOfAnyList(atlmppge.getallList(), newlistname);
		  
		  utl.addingExhProdLine(prop.getProperty("exhibitor1")); 
		  String exName=prop.getProperty("exhibitor1");
		  Thread.sleep(5000); 
		  WebElement moreLink=driver.findElement(By.xpath("//a[text()='"+exName+"']/../../../div[1]/div[4]")); 
		  Actions moreLinkHover=new Actions(driver);
		  moreLinkHover.moveToElement(moreLink).build().perform();
		  List<WebElement>allMoreOptions=driver.findElements(By.xpath("//a[text()='"+exName+"']/../../../div[1]/div[4]/div[1]/div[1]/span/a"));
		 utl.selectFilters(allMoreOptions, "Add To Schedule");

		 // Click on start Clendar
		atlmppge.getmpSelectStartDateCalendar().click();

		// Click on nxt month arrow
		atlmppge.getmpCalendarNextMonthArrow().click();
		// Print Month
		String startMonth = atlmppge.getmpmonthName().getText();

		// Select Date
		String wDay = null;
		for (WebElement SelectDate : atlmppge.getmpListOfAllCalendarDays()) {

			if (SelectDate.getText().contains("20")) {
				wDay = SelectDate.getAttribute("aria-label");
				SelectDate.click();
				break;
			}
		}
		//Split Day from date 
		String dayName = wDay.split(" ")[0].trim();
		//select Start Time
		Select selectStartTime = new Select(atlmppge.getmpSelectStartTime());
		selectStartTime.selectByIndex(5);
		Thread.sleep(2000);
		// Start Time
		String startTime = atlmppge.getmpSelectStartTime().getAttribute("value");

		String SelectedDateTime = 12 + startMonth + " " + startTime;
		System.out.println("Start Date and Time :: " + SelectedDateTime);

		// Click on End Date Of calendar
		atlmppge.getmpSelectEndDateCalendar().click();
		// Click on nxt month arrow
		atlmppge.getmpCalendarNextMonthArrow().click();
		// Click on nxt month arrow
		atlmppge.getmpCalendarNextMonthArrow().click();
		// Print End Month
		String endMonth = atlmppge.getmpmonthName().getText();
		// Select End Date
		utl.selectFilters(atlmppge.getmpListOfAllCalendarDays(), "12");
		// End Time

		Select selectEndTime = new Select(atlmppge.getmpSelectEndTime());
		selectEndTime.selectByIndex(4);
		Thread.sleep(2000);
		// End Date And Time
		String endTime = atlmppge.getmpSelectStartTime().getAttribute("value");

		String SelectedEndDateTime = 12 + endMonth + " " + endTime;
		System.out.println("End Date and Time :: " + SelectedEndDateTime);
		atlmppge.getmpAddToScheduledSaveBtn().click();
		Thread.sleep(2000);

		boolean flag = false;
		String displayTime = null;
		List<WebElement> listOfDateTime = driver.findElements(By.xpath("//div[@class='imc-type--title-5-ui']"));
		for (WebElement dateTime : listOfDateTime) {

			if (dateTime.getText().contains(dayName)) {
				
				displayTime = dateTime.getText().split(" ")[2].trim();
				// verify display time.
				Assert.assertTrue(displayTime.contains("@" + startTime));
				flag = true;
				break;
			}
		}
		if (flag == true) {
			System.out.println(dayName + " Present");
			Assert.assertTrue(flag = true);
		} else {
			System.out.println(dayName + " Not Present");
			Assert.assertTrue(flag = false);
		}

	}
	@Test(priority = 44)
	public void TS044_VerifyAddToFavoriteFunctionalityUsingQuickAddForProductTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T230: Maket Planner: Lists- Favorites- Add a Product to Favorites using 'Quick Add'
		// using 'Quick Add'

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Market Planner
		lap.getMPLinkText().click();
		Thread.sleep(6000);
		// Click on List tab
		atlmppge.getMPHomeListsTab().click();
		Thread.sleep(10000);
		// Click on List from left Pannel
		atlmppge.getMpListLeftPannel().click();
		
		utl.ClickOnEditBtnOfAnyList(atlmppge.getallList(), "Favorites");
		
		atlmppge.getMpQuickAdd().sendKeys("logic");
		Thread.sleep(3000);
		atlmppge.getMpQuickAdd().sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(3000);
		atlmppge.getMpQuickAdd().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		String autoSuggetion =atlmppge.getMpQuickAdd().getAttribute("value");
		// Verify Selected Product added or not
		System.out.println("Prod Name::"+autoSuggetion);
		utl.checkItemPresentInListorNot(atlmppge.getmpListOfAllProds(), autoSuggetion);
		
	
	}
	@Test(priority = 45)
	public void TS045_VerifyAddToFavoriteFunctionalityUsingQuickAddForLinesTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T231: Maket Planner: Lists- Favorites- Add an line to Favorites using 'Quick Add'
		// using 'Quick Add'

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Market Planner
		lap.getMPLinkText().click();
		Thread.sleep(6000);
		// Click on List tab
		atlmppge.getMPHomeListsTab().click();
		Thread.sleep(10000);
		// Click on List from left Pannel
		atlmppge.getMpListLeftPannel().click();
		
		utl.ClickOnEditBtnOfAnyList(atlmppge.getallList(), "Favorites");
		
		atlmppge.getMpQuickAdd().sendKeys("Anju");
		Thread.sleep(3000);
		atlmppge.getMpQuickAdd().sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(3000);
		atlmppge.getMpQuickAdd().sendKeys(Keys.ARROW_DOWN);
		
		atlmppge.getMpQuickAdd().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		String autoSuggetion =atlmppge.getMpQuickAdd().getAttribute("value");
		// Verify Selected Product added or not
		System.out.println("Prod Name::"+autoSuggetion);
		utl.checkItemPresentInListorNot(atlmppge.getlistOfAllExh(), autoSuggetion);
		
	
	}
	@Test(priority = 46)
	public void TS046_VerifyAddToListFunctionalityUsingQuickAddTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T257: Market Planner: Lists: Lists: Edit List: Quick Add
		// using 'Quick Add'

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Market Planner
		lap.getMPLinkText().click();
		Thread.sleep(6000);
		// Click on List tab
		atlmppge.getMPHomeListsTab().click();
		Thread.sleep(10000);
		// Click on List from left Pannel
		atlmppge.getMpListLeftPannel().click();
		
		utl.ClickOnEditBtnOfAnyList(atlmppge.getallList(), "Favorites");
		
		atlmppge.getMpQuickAdd().sendKeys("Anju");
		Thread.sleep(3000);
		atlmppge.getMpQuickAdd().sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(3000);
		atlmppge.getMpQuickAdd().sendKeys(Keys.ARROW_DOWN);
		
		atlmppge.getMpQuickAdd().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		String autoSuggetion =atlmppge.getMpQuickAdd().getAttribute("value");
		// Verify Selected Product added or not
		System.out.println("Prod Name::"+autoSuggetion);
		utl.checkItemPresentInListorNot(atlmppge.getlistOfAllExh(), autoSuggetion);
		
	

	}

	@Test(priority = 47)
	public void TS047_VerifyMarketPlanneMyInfoEditProfile() throws InterruptedException, IOException {


		// The purpose of this test case to verify:-
		// UXP-T270: Market Planner: My Info: Edit Profile
		

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();
		atlexhact = new ATLExhLineProdActionsPage(driver);

		atlgs = new ATLGlobalSearchPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		lap.getMPLinkText().click();
		atlmppge.getmyinfotab().click();
			
		// Change and Verify First Name and Last Name
		
		atlmppge.getmyinfoeditprofile().click();
		Assert.assertTrue(atlmppge.getmyinfoverifyeditprofile().isDisplayed());
		System.out.println("Edit Profile page is displayed successfully.");
		Thread.sleep(3000);
		/*atlmppge.getmyinfonamepencil().click();
		atlmppge.getmyinfofirstname().sendKeys(genData.generateRandomString(8));
		String FirstName = atlmppge.getmyinfofirstname().getText();
		atlmppge.getmyinfolastname().sendKeys(genData.generateRandomString(8));
		String LastName = atlmppge.getmyinfolastname().getText();
		atlmppge.getmyinfodiscardbtn().click();
		Assert.assertFalse(atlmppge.getverifymyinfoname().getText().contains(FirstName+LastName));
		System.out.println("Name is not updated.");
		
		atlmppge.getmyinfonamepencil().click();
		atlmppge.getmyinfofirstname().sendKeys(genData.generateRandomString(8));
		String FirstName1 = atlmppge.getmyinfofirstname().getText();
		atlmppge.getmyinfolastname().sendKeys(genData.generateRandomString(8));
		String LastName1 = atlmppge.getmyinfolastname().getText();
		atlmppge.getmyinfosavebutton().click();
		Assert.assertFalse(atlmppge.getverifymyinfoname().getText().contains(FirstName1+LastName1));
		System.out.println("Name is updated successfully.");*/
		
		// Change and Verify Email Address
		/*
		atlmppge.getmyinfoemail().click();
		atlmppge.getmyinfoemailcancelbtn().click();
		Assert.assertTrue(atlmppge.getmyinfoemail().isDisplayed());
		System.out.println("Email Form is closed successfully with Cancel button.");
		
		atlmppge.getmyinfoemail().click();
		atlmppge.getmyinfemailclosebtn().click();
		Assert.assertTrue(atlmppge.getmyinfoemail().isDisplayed());
		System.out.println("Email Form is closed successfully with X button.");
		
		atlmppge.getmyinfoemail().click();
		atlmppge.getmyinfoemailtxtbox().sendKeys(genData.generateEmail(15));
		Thread.sleep(3000);
		String Email = atlmppge.getmyinfoemailtxtbox().getText();
		atlmppge.getmyinfoverifybtn().click();
		
		Assert.assertTrue(atlmppge.getmyinfonewemail().getText().contains(Email));
		System.out.println("New email is properly added.");
		
		// Change and Verify Email Address
		*/
		atlmppge.getmyinfocompanynamepencil().click();
		Thread.sleep(5000);
		atlmppge.getmyinfocompnametxt().clear();
		Thread.sleep(5000);
		atlmppge.getmyinfocompnametxt().sendKeys("TestCompName"+genData.generateRandomString(5));
		//atlmppge.getmyinfocompnametxt().sendKeys(genData.generateRandomString(10));
		String CompanyName = atlmppge.getmyinfocompnametxt().getText();
		atlmppge.getmyinfosave2btn().click();
		Assert.assertTrue(atlmppge.getmyinfoverifycompanyname().getText().contains(CompanyName));
		System.out.println("Company Name is updated successfully.");	
		
		atlmppge.getmyinfocompanynamepencil().click();
		atlmppge.getmyinfocompnametxt().click();
		atlmppge.getmyinfocompnametxt().clear();
		atlmppge.getmyinfocompnametxt().sendKeys("TestCompName"+genData.generateRandomString(5));
		String CompanyName1 = atlmppge.getmyinfocompnametxt().getText();
		atlmppge.getmyinfodiscard2btn().click();
		Assert.assertTrue(atlmppge.getmyinfoverifycompanyname().getText().contains(CompanyName));
		System.out.println("Company Name is not updated with Discard button.");	
	}
	
	@Test(priority = 48)
	public void TS048_VerifyMarketPlanneMyInfoOverview() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP-T278:Market Planner: My Info overview
		

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();
		atlexhact = new ATLExhLineProdActionsPage(driver);

		atlgs = new ATLGlobalSearchPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		lap.getMPLinkText().click();
		atlmppge.getmyinfotab().click();
		Assert.assertTrue(atlmppge.getverifymyinfopage().isDisplayed());
		System.out.println("My Info page is displayed successfully.");
		
	}
	
	@Test(priority = 49)
	public void TS049_VerifyMarketPlanneMyInfoMyInquiriesTab() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP-T279: Market Planner: My Info- My Inquiries
		

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();
		atlexhact = new ATLExhLineProdActionsPage(driver);

		atlgs = new ATLGlobalSearchPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		lap.getMPLinkText().click();
		atlmppge.getmyinfotab().click();
		
		//Click My inquiries tab and verify results
		atlmppge.getmyinfomyinquiriestab().click();
		Assert.assertTrue(atlmppge.getmyinfoverifymyinquiries().isDisplayed());
		System.out.println("My Inquiries page is displayed properly.");
	}

	@Test(priority = 50)
	public void TS050_VerifyTabsUnderListsSectionTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP-T299: Maket Planner: Lists: Tabs under Lists section
		

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();
		atlexhact = new ATLExhLineProdActionsPage(driver);

		atlgs = new ATLGlobalSearchPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		lap.getMPLinkText().click();
		
		
		//Click Lists tab and verify tabs under it
		atlmppge.getMPHomeListsTab().click();
		Assert.assertTrue(atlmppge.getmplistsfavorites().isDisplayed());
		Assert.assertTrue(atlmppge.getListsPageListsMenu().isDisplayed());
		Assert.assertTrue(atlmppge.getmplistsallsavedproduts().isDisplayed());
		Assert.assertTrue(atlmppge.getmplistsallsavedexhibitors().isDisplayed());
		Assert.assertTrue(atlmppge.getmplistsenentsandseminars().isDisplayed());
		Assert.assertTrue(atlmppge.getmplistsmanagelist().isDisplayed());
		System.out.println("List tab details are displayed properly.");
	}

	@Test(priority = 51)
	public void TS051_VerifyListTabDetailsTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP-T228: Maket Planner: Lists: Lists tab details
		

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();
		atlexhact = new ATLExhLineProdActionsPage(driver);

		atlgs = new ATLGlobalSearchPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		lap.getMPLinkText().click();
		
		
		//Click Lists tab and verify tabs under it
		atlmppge.getMPHomeListsTab().click();
		Assert.assertTrue(atlmppge.getmplistsfavorites().isDisplayed());
		Assert.assertTrue(atlmppge.getListsPageListsMenu().isDisplayed());
		Assert.assertTrue(atlmppge.getmplistsallsavedproduts().isDisplayed());
		Assert.assertTrue(atlmppge.getmplistsallsavedexhibitors().isDisplayed());
		Assert.assertTrue(atlmppge.getmplistsenentsandseminars().isDisplayed());
		Assert.assertTrue(atlmppge.getmplistsmanagelist().isDisplayed());
		System.out.println("List tab options are displayed properly.");
		
		//Verify List Details on the page
		atlmppge.getListsPageListsMenu().click();
		Assert.assertTrue(atlmppge.getmplistsmanagelist().isDisplayed());
		Assert.assertTrue(atlmppge.getmpduplicatelistbtn().isDisplayed());
		Assert.assertTrue(atlmppge.getmpeditlistbtn().isDisplayed());
		Assert.assertTrue(atlmppge.getmparrangelistbtn().isDisplayed());
		Assert.assertTrue(atlmppge.getmpnewlistbtn().isDisplayed());
		Assert.assertTrue(atlmppge.getmpnewgrpbtn().isDisplayed());
		System.out.println("List details are displayed properly.");
		
	}
	
	@AfterClass
	public void tearDown() {
		// driver.quit();

	}

}
