package atlantamarket_PROD;

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

import pageObjects.AtlantaMarket.ATLEventsAndWebinarPage;
import pageObjects.AtlantaMarket.ATLExhLineProdActionsPage;
import pageObjects.AtlantaMarket.ATLFloorPlansPage;
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
	ATLFloorPlansPage atlflpp;
	ATLEventsAndWebinarPage atlevents;
	ATLLeftPaneFilters atlleftpane;
	List<WebElement> mplists, mpduplicatelistoptns;

	@BeforeClass
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);

		// Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("atlmrkturl_prod"));
		utl.verifyMPLoginFunctionality();
		Thread.sleep(8000);

		lap.getIUnderstandBtn().click();
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

		/*
		 * try { // Click Welcome Text atlmppge.getwelcometext().click(); // Click Sign
		 * out link atlmppge.getsignout().click(); lap.getLogin().click();
		 * 
		 * } catch (Exception e) { System.out.println(e); lap.getLogin().click(); }
		 */

		// Click Welcome Text
		atlmppge.getwelcometext().click();
		// Click Sign out link
		atlmppge.getsignout().click();
		lap.getLogin().click();

		// Enter the credentials on Login Page and click
		lp.getEmailAddress().sendKeys((prop.getProperty("username")));
		lp.getPassword().sendKeys((prop.getProperty("invalidPassword")));
		lp.getSignInBtn().click();
		Thread.sleep(15000);

		// Verify incorrect password error msg
		Assert.assertTrue(
				atlmppge.getInvalidPasswordError().getText().contains(prop.getProperty("incorrectPasswordErrorMsg")));

		driver.get(prop.getProperty("atlmrkturl_prod"));

		// without Email and Password
		lap.getLogin().click();
		lp.getSignInBtn().click();
		// Verify Enter email error msg
		Assert.assertTrue(atlmppge.getEnterEmailErrorMsg().getText().contains(prop.getProperty("EnterEmailErrorMsg")));
		// Verify Enter password error msg
		Assert.assertTrue(
				atlmppge.getEnterPasswordErrorMsg().getText().contains(prop.getProperty("EnterPasswordErrorMsg")));

		driver.get(prop.getProperty("atlmrkturl_prod"));
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
		utl.selectDropdown(prop.getProperty("channelNameAMC"), prop.getProperty("ammarturl_prod"));
		driver.get(prop.getProperty("atlmrkturl_prod") + "Market-Planner");
		Thread.sleep(5000);
		// Select ATLApp from dropdown
		utl.selectDropdown(prop.getProperty("channelNameATLApp"), prop.getProperty("atlappurl_prod"));
		driver.get(prop.getProperty("atlmrkturl_prod") + "Market-Planner");
		Thread.sleep(5000);
		// Select ATLM from dropdown
		utl.selectDropdown(prop.getProperty("channelNameATLM"), prop.getProperty("atlmrkturl_prod"));
		driver.get(prop.getProperty("atlmrkturl_prod") + "Market-Planner");
		Thread.sleep(5000);
		// Select LVA from dropdown
		utl.selectDropdown(prop.getProperty("channelNameLVA"), prop.getProperty("lvaappurl_prod"));
		driver.get(prop.getProperty("atlmrkturl_prod") + "Market-Planner");
		Thread.sleep(5000);
		// Select LVM from dropdown
		utl.selectDropdown(prop.getProperty("channelNameLVM"), prop.getProperty("lvmurl_prod"));
		driver.get(prop.getProperty("atlmrkturl_prod") + "Market-Planner");
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
		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase(prop.getProperty("atlmrkturl_prod")));

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
		// UXP-224: To verify the Market Planner Dashboard overview and it's
		// functionality

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
		// UXP-225: To verify the Market Planner-Registration Card overview and it's
		// functionality

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		lap.getMPLinkText().click();
		Thread.sleep(5000);
		// Verify Registration Card details
		Assert.assertTrue(atlmppge.getmpmarketnameregcard().isDisplayed());
		Assert.assertTrue(atlmppge.getmpmarketdateregcard().isDisplayed());
		Assert.assertTrue(atlmppge.getmpregistrationlink().isDisplayed());

		// Verify Online Registrations page
		atlmppge.getmpregistrationlink().click();
		// Assert.assertTrue(atlmppge.getmpverifyregistrationinformationlink().isDisplayed());
		String rURL = driver.getCurrentUrl();
		Assert.assertTrue(rURL.contains(prop.getProperty("atlmrkturl_prod") + "Attend/Registration"));
	}

	@Test(priority = 13)
	public void TS013_VerifyAddToFavoriteFunctionalityForProductTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP-T237: Market Planner: Lists- Favorites- Add a product to Favorites using
		// 'Favorite' icon in product actions

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
		// Store the 1st product name of Exhibitor
		String productNameOnSearchGrid = atlexhact.getExhProductNameOnSearchGrid().getText();
		System.out.println("Selected product Name: " + productNameOnSearchGrid);

		utl.scrollToElement(atlexhact.getExhibitorProduct());

		// Hovering on product
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
	public void TS014_VerifyManageListOptionsOverviewTest() throws InterruptedException, IOException {

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

	@Test(priority = 15)
	public void TS015_VerifyEditListFunctionalityForManageListTest() throws InterruptedException, IOException {

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

		utl.addingExhProdLine(prop.getProperty("line1"));
		utl.addingExhProdLine(prop.getProperty("line2"));
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
		List<WebElement> cclist = driver.findElements(
				By.xpath("//div[@class='imc-formfield imc-content imc-saved-exhibitors__chk-container']/label[1]"));

		for (WebElement allCheckbox : cclist) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Assert.assertTrue(js.executeScript("arguments[0].checked", allCheckbox) == null);
		}
		System.out.println("All Checkbox checked");
		atlmppge.getMpManageEditListSelectAllBtn().click();
		Thread.sleep(2000);
		List<WebElement> cclist1 = driver.findElements(
				By.xpath("//div[@class='imc-formfield imc-content imc-saved-exhibitors__chk-container']/label[1]"));

		for (WebElement allCheckbox : cclist1) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Assert.assertFalse(js.executeScript("arguments[0].checked", allCheckbox) != null);
		}
		System.out.println("All Checkbox Unchecked");
		Thread.sleep(5000);
		WebElement cc = driver.findElement(By
				.xpath("(//div[@class='imc-formfield imc-content imc-saved-exhibitors__chk-container']/label[1])[1]"));
		// click on 1st checkbox
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", cc);
		String fExhpName = atlmppge.getfirstExhName().getText();

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
		String fiExhpName = atlmppge.getfirstExhName().getText();
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

		utl.checkItemPresentInListorNot(atlmppge.getlistOfAllExh(), fiExhpName);
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

	@Test(priority = 16)
	public void TS016_VerifyDuplicateLinkFunctionalityForListTest() throws InterruptedException, IOException {
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

		/*
		 * // Manual bug Set<WebElement> hSet = new HashSet<WebElement>(mplists); for
		 * (WebElement x : mplists) hSet.add(x);
		 * 
		 * System.out.println("Created HashSet is"); for (WebElement x : hSet)
		 * System.out.println("New set is: " + x);
		 */
	}

	@Test(priority = 17)
	public void TS017_VerifyRenameFunctionalityForListTest() throws InterruptedException, IOException {
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

	@Test(priority = 18)
	public void TS018_VerifyAddToFavoriteFunctionalityForLineTest() throws InterruptedException, IOException {

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

	@Test(priority = 19)
	public void TS019_VerifyAddToFavoriteFunctionalityForExhibitorTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP-T243: Market Planner: Lists- Favorites- Add an Exhibitor to Favorites
		// using 'Favorite' icon in Exhibitor actions.

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

	@Test(priority = 20)
	public void TS020_VerifyMPListsCardOverviewTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP-T226: To verify the Market Planner-Lists Card overview and it's
		// functionality

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
		Assert.assertTrue(
				driver.getCurrentUrl().contains(prop.getProperty("atlmrkturl_prod") + "Market-Planner/Lists"));

		// Click Lists tab
		atlmppge.getmplisttab().click();
		// Click New Lists button
		atlmppge.getmpnewlistbutton().click();
		// Add list name and click create button
		atlmppge.getCreateNewListNameTxtbx().sendKeys(genData.generateRandomString(10));
		// atlmppge.getCreateNewListNameTxtbx().sendKeys();
		atlmppge.getAddListCreateBtn().click();

		// Click Dashboard tab
		atlmppge.getmpdasboardtab().click();
		// Verify if new list is displayed at List Card and old list is removed
		Assert.assertFalse(atlmppge.getmpexistinglists().getText().equalsIgnoreCase(SavedLists));
	}

	@Test(priority = 21)
	public void TS021_VerifyMPActivitiesCardOverviewTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP-T227: To verify the Market Planner-Activities overview and it's
		// functionality

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
		Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("atlmrkturl_prod") + "Attend/Hotels"));
		driver.navigate().back();

		atlmppge.getmpfloorplans().click();
		Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("atlmrkturl_prod") + "Market-Map"));
		driver.navigate().back();

		atlmppge.getmpexpdirectory().click();
		driver.navigate().back();

		atlmppge.getmpsavedsearches().click();
		Assert.assertTrue(
				driver.getCurrentUrl().contains(prop.getProperty("atlmrkturl_prod") + "Market-Planner/Saved-Searches"));
		driver.navigate().back();

		atlmppge.getmpmyinfo().click();
		Assert.assertTrue(
				driver.getCurrentUrl().contains(prop.getProperty("atlmrkturl_prod") + "Market-Planner/My-Info"));
		driver.navigate().back();
	}

	@Test(priority = 22)
	public void TS022_VerifyFilterByOptionsOverviewForListTest() throws InterruptedException, IOException {

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

	@Test(priority = 23)
	public void TS023_VerifyFilterByOptionsFunctionalityForListTest() throws InterruptedException, IOException {

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

		// lap.getIUnderstandBtn().click();
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
		// Verify Line And product should not displayed
		utl.checkItemNotPresentInList(atlmppge.getnameofElement(), "Line");
		utl.checkItemNotPresentInList(atlmppge.getnameofElement(), "product");
		utl.checkItemNotPresentInList(atlmppge.getnameofElement(), "Events and Seminars");
		utl.checkItemNotPresentInList(atlmppge.getnameofElement(), "Custom");

		// Click on Line And verify Lines should displayed or not
		atlmppge.getmpFilterByDropdown().click();
		Thread.sleep(5000);
		utl.selectFilters(atlmppge.getfilterByList(), "Line");
		utl.checkItemPresentInListorNot(atlmppge.getnameofElement(), "Line");
		// Verify Exhibitor And product should not displayed
		utl.checkItemNotPresentInList(atlmppge.getnameofElement(), "Exhibitor");
		utl.checkItemNotPresentInList(atlmppge.getnameofElement(), "product");
		utl.checkItemNotPresentInList(atlmppge.getnameofElement(), "Events and Seminars");
		utl.checkItemNotPresentInList(atlmppge.getnameofElement(), "Custom");

		// Click on product And verify products should displayed or not

		atlmppge.getmpFilterByDropdown().click();
		Thread.sleep(5000);
		utl.selectFilters(atlmppge.getfilterByList(), "Product");
		utl.checkItemPresentInListorNot(atlmppge.getmpListOfAllProds(), "Product");
		// Verify Lines And Exhibitors should not displayed
		utl.checkItemNotPresentInList(atlmppge.getnameofElement(), "Line");
		utl.checkItemNotPresentInList(atlmppge.getnameofElement(), "Exhibitor");
		utl.checkItemNotPresentInList(atlmppge.getnameofElement(), "Events and Seminars");
		utl.checkItemNotPresentInList(atlmppge.getnameofElement(), "Custom");
		/*
		 * // Click on Events and Seminars And verify it should displayed or not
		 * atlmppge.getmpFilterByDropdown().click(); Thread.sleep(5000);
		 * utl.selectFilters(atlmppge.getfilterByList(), "Events and Seminars");
		 * utl.checkItemPresentInListorNot(atlmppge.getnameofElement()
		 * ,"Events and Seminars"); // Verify Lines And Exhibitors should not displayed
		 * utl.checkItemNotPresentInList(atlmppge.getnameofElement(),"Line");
		 * utl.checkItemNotPresentInList(atlmppge.getnameofElement(),"Exhibitor");
		 * utl.checkItemNotPresentInList(atlmppge.getnameofElement(),"product");
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

	@Test(priority = 24)
	public void TS024_VerifyMarketPlannerListSortByTest() throws InterruptedException, IOException {

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

	@Test(priority = 25)
	public void TS025_VerifyDuplicateLinkFunctionalityForListTest() throws InterruptedException, IOException {
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

		WebElement duplicateLink = driver
				.findElement(By.xpath("//div[text()='" + newlistname + "']/../div[2]/span[1])"));
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

	@Test(priority = 26)
	public void TS026_VerifyListDisplayControlsTest() throws InterruptedException, IOException {

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

	@Test(priority = 27)
	public void TS027_VerifyListDisplayControlsFunctionalityTest() throws InterruptedException, IOException {

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

		utl.addingExhProdLine(prop.getProperty("line1"));
		utl.addingExhProdLine(prop.getProperty("line2"));
		utl.addingExhProdLine(prop.getProperty("exhibitor1"));
		utl.addingExhProdLine(prop.getProperty("exhibitor3"));
		utl.addingExhProdLine(prop.getProperty("product1"));
		utl.addingExhProdLine(prop.getProperty("product2"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Click on Group By checkbox
		js.executeScript("document.getElementsByClassName('imc-checkbox--label')[1].click();");
		// Verify if checkbox is uncheck all the products,lines,exhibitos are displayed
		// or not.
		utl.checkItemPresentInListorNot(atlmppge.getnameofElement(), "Product");
		utl.checkItemPresentInListorNot(atlmppge.getnameofElement(), "Line");
		utl.checkItemPresentInListorNot(atlmppge.getnameofElement(), "Exhibitor");

		// Click on Group By checkbox
		js.executeScript("document.getElementsByClassName('imc-checkbox--label')[1].click();");
		Thread.sleep(3000);
		// Verify if checkbox is checked then exhibitors and its sub product displayed
		// or not
		// Verify Exhibitor Present or not
		utl.checkItemPresentInListorNot(atlmppge.getlistOfAllExh(), prop.getProperty("exhibitor3"));
		// Verify Exhibitor and its sub product present or not
		utl.checkItemPresentInListorNot(atlmppge.getmpListOfAllProds(), prop.getProperty("product2"));

		atlmppge.getatlmpListView().click();
		Assert.assertTrue(atlmppge.getATLmpVerifyGridView().isDisplayed());
		atlmppge.getatlmpGridView().click();
		Assert.assertTrue(atlmppge.getATLmpVerifyListView().isDisplayed());

	}

	@Test(priority = 28)
	public void TS028_VerifyMarketPlannerListElementLocationLinkTest() throws InterruptedException, IOException {

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

		utl.addingExhProdLine(prop.getProperty("exhibitor3"));

		atlmppge.atlmpVerifyLocationLink();

		utl.checkLocationLink(atlmppge.getlistOfAllExh(), prop.getProperty("exhibitor3"));
		System.out.println("Verify location Links are Present");
		utl.clickOnLocationLink(atlmppge.getlistOfAllExh(), prop.getProperty("exhibitor3"));

		System.out.println("Verify respected location details page opend");
	}


	@AfterClass
	public void tearDown() {
		// driver.quit();

	}

}
