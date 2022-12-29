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


	@Test(priority = 29)
	public void TS029_VerifyMarketPlannerListsElementMoreOoptionsOverviewTest()
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
		utl.addingExhProdLine(prop.getProperty("exhibitor1"));
		WebElement moreLink = driver.findElement(By.xpath("//a[text()='"+prop.getProperty("exhibitor1")+"']/../../../div[1]/div[4]"));
		Actions moreLinkHover = new Actions(driver);
		moreLinkHover.moveToElement(moreLink).build().perform();
		List<WebElement> allMoreOptions = driver
				.findElements(By.xpath("//a[text()='"+prop.getProperty("exhibitor1")+"']/../../../div[1]/div[4]/div[1]/div[1]/span/a"));

		utl.checkItemPresentInListorNot(allMoreOptions, "Copy");
		utl.checkItemPresentInListorNot(allMoreOptions, "Move");
		utl.checkItemPresentInListorNot(allMoreOptions, "Delete");
		utl.checkItemPresentInListorNot(allMoreOptions, "Add To Schedule");

	}

	@Test(priority = 30)
	public void TS030_VerifyMarketPlannerListsElementMoreOoptionsCopyeTest() throws InterruptedException, IOException {

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

		WebElement moreLink = driver.findElement(By.xpath(
				"//div[@class='imc-gallery imc-saved-exhibitors__outer-row imc-market-planner-list--mobile-overlays-left']/div[1]/div[1]/a[1]/../../div[4]"));
		Actions moreLinkHover = new Actions(driver);
		moreLinkHover.moveToElement(moreLink).build().perform();
		List<WebElement> allMoreOptions = driver.findElements(By.xpath(
				"//div[@class='imc-gallery imc-saved-exhibitors__outer-row imc-market-planner-list--mobile-overlays-left']/div[1]/div[1]/a[1]/../../div[4]/div[1]/div[1]/span/a"));
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

	@Test(priority = 31)
	public void TS031_VerifyMarketPlannerListsElementMoreOoptionsMoveTest() throws InterruptedException, IOException {

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

		/*
		 * WebElement moreLink = driver.findElement(By.xpath("//a[text()='" + exName +
		 * "']/../../../div[1]/div[4]")); Actions moreLinkHover = new Actions(driver);
		 * moreLinkHover.moveToElement(moreLink).build().perform(); List<WebElement>
		 * allMoreOptions = driver .findElements(By.xpath("//a[text()='" + exName +
		 * "']/../../../div[1]/div[4]/div[1]/div[1]/span/a"));
		 */
		WebElement moreLink = driver.findElement(By.xpath(
				"//div[@class='imc-gallery imc-saved-exhibitors__outer-row imc-market-planner-list--mobile-overlays-left']/div[1]/div[1]/a[1]/../../div[4]"));
		Actions moreLinkHover = new Actions(driver);
		moreLinkHover.moveToElement(moreLink).build().perform();
		List<WebElement> allMoreOptions = driver.findElements(By.xpath(
				"//div[@class='imc-gallery imc-saved-exhibitors__outer-row imc-market-planner-list--mobile-overlays-left']/div[1]/div[1]/a[1]/../../div[4]/div[1]/div[1]/span/a"));

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

	@Test(priority = 35)
	public void TS032_VerifyMarketPlannerListsElementMoreOoptionsDeleteTest() throws InterruptedException, IOException {

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
		/*
		 * WebElement moreLink = driver.findElement(By.xpath("//a[text()='" + exName +
		 * "']/../../../div[1]/div[4]")); Actions moreLinkHover = new Actions(driver);
		 * moreLinkHover.moveToElement(moreLink).build().perform(); List<WebElement>
		 * allMoreOptions = driver .findElements(By.xpath("//a[text()='" + exName +
		 * "']/../../../div[1]/div[4]/div[1]/div[1]/span/a"));
		 */
		WebElement moreLink = driver.findElement(By.xpath(
				"//div[@class='imc-gallery imc-saved-exhibitors__outer-row imc-market-planner-list--mobile-overlays-left']/div[1]/div[1]/a[1]/../../div[4]"));
		Actions moreLinkHover = new Actions(driver);
		moreLinkHover.moveToElement(moreLink).build().perform();
		List<WebElement> allMoreOptions = driver.findElements(By.xpath(
				"//div[@class='imc-gallery imc-saved-exhibitors__outer-row imc-market-planner-list--mobile-overlays-left']/div[1]/div[1]/a[1]/../../div[4]/div[1]/div[1]/span/a"));

		utl.selectFilters(allMoreOptions, "Delete");
		Thread.sleep(5000);
		utl.checkItemNotPresentInList(atlmppge.getlistOfAllExh(), exName);
	}

	@Test(priority = 33)
	public void TS033_VerifyMarketPlannerListManagementAddNoteTest() throws InterruptedException, IOException {

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
		atlexhact.getNoteContentTxtBx().sendKeys("TestprodNote" + genData.generateRandomString(6));
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
		driver.get(prop.getProperty("atlmrkturl_prod"));
	}

	@Test(priority = 34)
	public void TS034_VerifyMarketPlannerEditListCustomItemTest() throws InterruptedException, IOException {

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

	@Test(priority = 32)
	public void TS035_VerifyMarketPlannerEditListAddNoteTest() throws InterruptedException, IOException {

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
		atlexhact.getNoteContentTxtBx().sendKeys("TestprodNote" + genData.generateRandomString(6));
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
		atlexhact.getNoteContentTxtBx().sendKeys("TestprodNote" + genData.generateRandomString(6));
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

	@Test(priority = 36)
	public void TS036_VerifyMarketPlannerListsAllSavedExhibitorsTest() throws InterruptedException, IOException {
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

	@Test(priority = 37)
	public void TS037_VerifyMarketPlannerListsAllSavedproductsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T266: Market Planner: Lists- All Saved products

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
		/*
		 * String productNameOnSearchGrid =
		 * atlexhact.getExhProductNameOnSearchGrid().getText();
		 * System.out.println("Selected product Name: " + productNameOnSearchGrid);
		 */
		String exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		// utl.scrollToElement(atlexhact.getExhibitorproduct());

		// Hovering on product
		Actions actions = new Actions(driver);
		actions.moveToElement(atlmppge.getseeAllBtn()).perform();
		// To mouseover on See All btn
		// actions.moveToElement(atlexhact.getproductFevBtn()).perform();
		atlmppge.getFavIcone().click();

		// Click on Add To Favorite button
		// actions.click().perform();
		Thread.sleep(5000);

		// Click on Market Planner link
		lap.getMPLinkText().click();

		// Click on Lists tab on MP home page
		atlmppge.getMPHomeListsTab().click();
		atlmppge.getallSavedProductMenu().click();
		Thread.sleep(5000);

		utl.checkItemPresentInListorNot(atlmppge.getlistOfAllExh(), exhname);
	}

	@Test(priority = 52)
	public void TS038_VerifyMarketPlannerRegistrationsTabTest() throws InterruptedException, IOException {

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
		Thread.sleep(8000);
		// Click on Mp Reg tab
		atlmppge.getmpRegistrationTab().click();
		Thread.sleep(5000);
		String regiNowURL = atlmppge.getmpRegisterNowBtn().getAttribute("href");
		System.out.println(regiNowURL);
		atlmppge.getmpRegisterNowBtn().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains(regiNowURL));
		System.out.println("User is redirected to Market Registration page.");
		driver.get(prop.getProperty("atlmrkturl_prod"));
	}

	@Test(priority = 39)
	public void TS039_VerifyMarketSavedSearchesfunctionalityTest() throws InterruptedException, IOException {

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
		// atlmppge.getATLUseSavedSearchDropDown().click();
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

	@Test(priority = 40)
	public void TS040_VerifyMarketSavedSearchesDeletefunctionalityTest() throws InterruptedException, IOException {

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

		/*
		 * atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("saveSearchTerm")
		 * ); atlgs.getATLSearchButton().click(); // Click on Saved searches Icon
		 * atlmppge.getmpSavedSearchesIcon().click(); // Click on Save Search Btn to
		 * Save the Term atlmppge.getmpSaveSearcheBtn().click(); // Enter Search text
		 * into input field
		 * atlmppge.getmpSaveSearcheNameInput().sendKeys(prop.getProperty(
		 * "saveSearchTerm")); // Click on Save Btn
		 * atlmppge.getmpSaveSearcheInputBtn().click(); Thread.sleep(3000);
		 */
		lap.getMPLinkText().click();
		// Click on Mp Reg tab
		atlmppge.getmpsavedsearchestab().click();

		try {
			if (atlmppge.getnoSavedSearchesMsg().isDisplayed()) {
				TS039_VerifyMarketSavedSearchesfunctionalityTest();
				// Click on Market Planner
				lap.getMPLinkText().click();
				// Click on Mp Reg tab
				atlmppge.getmpsavedsearchestab().click();

				List<WebElement> deleteBtn = driver.findElements(
						By.xpath("//a[text()='" + prop.getProperty("saveSearchTerm") + "']/../../div[2]/span[2]"));

				// System.out.println(deleteBtn);
				for (WebElement webElement : deleteBtn) {
					webElement.click();
					atlmppge.getmpConfirmDeleteBtn().click();
					Thread.sleep(5000);
				}
				try {
					utl.checkItemNotPresentInList(atlmppge.getmplistOfAllSaveSearches(),
							prop.getProperty("saveSearchTerm"));
				} catch (Exception e) {
					System.out.println("Saved Search Term deleted succsfully ");
				}
			}
		} catch (TimeoutException ee) {

			// Click on Market Planner
			lap.getMPLinkText().click();
			// Click on Mp Reg tab
			atlmppge.getmpsavedsearchestab().click();

			List<WebElement> deleteBtn = driver.findElements(
					By.xpath("//a[text()='" + prop.getProperty("saveSearchTerm") + "']/../../div[2]/span[2]"));

			// System.out.println(deleteBtn);
			for (WebElement webElement : deleteBtn) {
				webElement.click();
				atlmppge.getmpConfirmDeleteBtn().click();
				Thread.sleep(5000);
			}
			try {
				utl.checkItemNotPresentInList(atlmppge.getmplistOfAllSaveSearches(),
						prop.getProperty("saveSearchTerm"));
			} catch (Exception e) {
				System.out.println("Saved Search Term deleted succsfully ");
			}
		}
	}

	@Test(priority = 41)
	public void TS041_VerifyMarketPlannerListSortByFunctionalityTest() throws IOException, InterruptedException {

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

		/*
		 * // Click on SortBy Dropdown atlmppge.getmpSortByDropdown().click();
		 * 
		 * // Verify All Filter By Options should available.
		 * utl.selectFilters(atlmppge.getfilterByList(), "Most Recent Added");
		 * Thread.sleep(5000); List<WebElement> favlist = driver .findElements(By.xpath(
		 * "//li[@class='imc-list-edit--draggable']/div/div/div/a")); boolean flag =
		 * false; for (WebElement list : favlist) {
		 * 
		 * if (list.getText().equals(exhname)) {
		 * 
		 * System.out.println("Equal"); flag = true; break; } } if (flag == true) {
		 * Assert.assertTrue(flag = true); } else { Assert.assertTrue(flag = false); }
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

	@Test(priority = 42)
	public void TS042_VerifyMarketPlannerListsElementMoreOoptionsAddToScheduleTest()
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

		// Click Edit List link for any list

		atlmppge.getEditListAtListTab().click();
		atlmppge.getMoreOptionPROD().click();
		atlmppge.getAddToSchedulePROD().click();

		/*
		 * atlmppge.getMpListNewListBtn().click(); // verify New List Popup header
		 * Assert.assertTrue(atlmppge.getMpListNewGroupPopupHeader().getText().contains(
		 * prop.getProperty( "CreateListPopupHeader"))); // Enter List name String
		 * newlistname = "Cyb" + genData.generateRandomString(5);
		 * atlmppge.getMpListNewGroupNameTxt().sendKeys(newlistname);
		 * System.out.println("list name :: " + newlistname); // Click on Create Btn
		 * atlmppge.getMpListNewCreateBtn().click(); Thread.sleep(10000);
		 * 
		 * utl.ClickOnEditBtnOfAnyList(atlmppge.getallList());
		 * 
		 * utl.addingExhProdLine(prop.getProperty("exhibitor1")); String
		 * exName=prop.getProperty("exhibitor1"); Thread.sleep(5000); WebElement
		 * moreLink=driver.findElement(By.xpath("//a[text()='"+exName+
		 * "']/../../../div[1]/div[4]")); Actions moreLinkHover=new Actions(driver);
		 * moreLinkHover.moveToElement(moreLink).build().perform();
		 * List<WebElement>allMoreOptions=driver.findElements(By.xpath("//a[text()='"+
		 * exName+"']/../../../div[1]/div[4]/div[1]/div[1]/span/a"));
		 * utl.selectFilters(allMoreOptions, "Add To Schedule");
		 */

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
		// Split Day from date
		String dayName = wDay.split(" ")[0].trim();
		// select Start Time
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

	@Test(priority = 43)
	public void TS043_VerifyAddToFavoriteFunctionalityUsingQuickAddForproductTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T230: Maket Planner: Lists- Favorites- Add a product to Favorites using
		// 'Quick Add'
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

		/*
		 * atlmppge.getMpQuickAdd().sendKeys("logic"); Thread.sleep(3000);
		 * atlmppge.getMpQuickAdd().sendKeys(Keys.ARROW_DOWN); Thread.sleep(3000);
		 * atlmppge.getMpQuickAdd().sendKeys(Keys.ENTER);
		 */

		utl.addingExhProdLine(prop.getProperty("line1"));
		utl.addingExhProdLine(prop.getProperty("product2"));

		Thread.sleep(3000);
		String autoSuggetion = atlmppge.getMpQuickAdd().getAttribute("value");
		// Verify Selected product added or not
		System.out.println("prod Name::" + autoSuggetion);
		utl.checkItemPresentInListorNot(atlmppge.getlistOfAllExh(), autoSuggetion);

	}

	@Test(priority = 44)
	public void TS044_VerifyAddToFavoriteFunctionalityUsingQuickAddForLinesTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T231: Maket Planner: Lists- Favorites- Add an line to Favorites using
		// 'Quick Add'
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

		/*
		 * atlmppge.getMpQuickAdd().sendKeys("Anju"); Thread.sleep(3000);
		 * atlmppge.getMpQuickAdd().sendKeys(Keys.ARROW_DOWN); Thread.sleep(3000);
		 * atlmppge.getMpQuickAdd().sendKeys(Keys.ARROW_DOWN);
		 * 
		 * atlmppge.getMpQuickAdd().sendKeys(Keys.ENTER);
		 */

		utl.addingExhProdLine(prop.getProperty("line1"));
		Thread.sleep(3000);
		String autoSuggetion = atlmppge.getMpQuickAdd().getAttribute("value");
		// Verify Selected product added or not
		System.out.println("prod Name::" + autoSuggetion);
		utl.checkItemPresentInListorNot(atlmppge.getlistOfAllExh(), autoSuggetion);

	}

	@Test(priority = 45)
	public void TS045_VerifyAddToListFunctionalityUsingQuickAddTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T257: Market Planner: Lists: Lists: Edit List: Quick Add
		// using 'Quick Add'

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		genData = new GenerateData();
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

		/*
		 * utl.ClickOnEditBtnOfAnyList(atlmppge.getallList(), "Favorites");
		 * 
		 * atlmppge.getMpQuickAdd().sendKeys("Anju"); Thread.sleep(3000);
		 * atlmppge.getMpQuickAdd().sendKeys(Keys.ARROW_DOWN); Thread.sleep(3000);
		 * atlmppge.getMpQuickAdd().sendKeys(Keys.ARROW_DOWN);
		 * 
		 * atlmppge.getMpQuickAdd().sendKeys(Keys.ENTER);
		 */
		Thread.sleep(3000);

		String autoSuggetion = atlmppge.getMpQuickAdd().getAttribute("value");
		// Verify Selected product added or not
		System.out.println("prod Name::" + autoSuggetion);
		utl.checkItemPresentInListorNot(atlmppge.getlistOfAllExh(), autoSuggetion);

	}

	@Test(priority = 46)
	public void TS046_VerifyMarketPlanneMyInfoEditProfile() throws InterruptedException, IOException {
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
		/*
		 * atlmppge.getmyinfonamepencil().click();
		 * atlmppge.getmyinfofirstname().sendKeys(genData.generateRandomString(8));
		 * String FirstName = atlmppge.getmyinfofirstname().getText();
		 * atlmppge.getmyinfolastname().sendKeys(genData.generateRandomString(8));
		 * String LastName = atlmppge.getmyinfolastname().getText();
		 * atlmppge.getmyinfodiscardbtn().click();
		 * Assert.assertFalse(atlmppge.getverifymyinfoname().getText().contains(
		 * FirstName+LastName)); System.out.println("Name is not updated.");
		 * 
		 * atlmppge.getmyinfonamepencil().click();
		 * atlmppge.getmyinfofirstname().sendKeys(genData.generateRandomString(8));
		 * String FirstName1 = atlmppge.getmyinfofirstname().getText();
		 * atlmppge.getmyinfolastname().sendKeys(genData.generateRandomString(8));
		 * String LastName1 = atlmppge.getmyinfolastname().getText();
		 * atlmppge.getmyinfosavebutton().click();
		 * Assert.assertFalse(atlmppge.getverifymyinfoname().getText().contains(
		 * FirstName1+LastName1)); System.out.println("Name is updated successfully.");
		 */

		// Change and Verify Email Address
		/*
		 * atlmppge.getmyinfoemail().click();
		 * atlmppge.getmyinfoemailcancelbtn().click();
		 * Assert.assertTrue(atlmppge.getmyinfoemail().isDisplayed());
		 * System.out.println("Email Form is closed successfully with Cancel button.");
		 * 
		 * atlmppge.getmyinfoemail().click(); atlmppge.getmyinfemailclosebtn().click();
		 * Assert.assertTrue(atlmppge.getmyinfoemail().isDisplayed());
		 * System.out.println("Email Form is closed successfully with X button.");
		 * 
		 * atlmppge.getmyinfoemail().click();
		 * atlmppge.getmyinfoemailtxtbox().sendKeys(genData.generateEmail(15));
		 * Thread.sleep(3000); String Email = atlmppge.getmyinfoemailtxtbox().getText();
		 * atlmppge.getmyinfoverifybtn().click();
		 * 
		 * Assert.assertTrue(atlmppge.getmyinfonewemail().getText().contains(Email));
		 * System.out.println("New email is properly added.");
		 * 
		 * // Change and Verify Email Address
		 */
		atlmppge.getmyinfocompanynamepencil().click();
		Thread.sleep(5000);
		atlmppge.getmyinfocompnametxt().clear();
		Thread.sleep(5000);
		atlmppge.getmyinfocompnametxt().sendKeys("TestCompName" + genData.generateRandomString(5));
		// atlmppge.getmyinfocompnametxt().sendKeys(genData.generateRandomString(10));
		String CompanyName = atlmppge.getmyinfocompnametxt().getText();
		atlmppge.getmyinfosave2btn().click();
		Assert.assertTrue(atlmppge.getmyinfoverifycompanyname().getText().contains(CompanyName));
		System.out.println("Company Name is updated successfully.");

		atlmppge.getmyinfocompanynamepencil().click();
		atlmppge.getmyinfocompnametxt().click();
		atlmppge.getmyinfocompnametxt().clear();
		atlmppge.getmyinfocompnametxt().sendKeys("TestCompName" + genData.generateRandomString(5));
		String CompanyName1 = atlmppge.getmyinfocompnametxt().getText();
		atlmppge.getmyinfodiscard2btn().click();
		Assert.assertTrue(atlmppge.getmyinfoverifycompanyname().getText().contains(CompanyName));
		System.out.println("Company Name is not updated with Discard button.");
	}

	@Test(priority = 47)
	public void TS047_VerifyMarketPlanneMyInfoOverview() throws InterruptedException, IOException {

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

	@Test(priority = 48)
	public void TS048_VerifyMarketPlanneMyInfoMyInquiriesTab() throws InterruptedException, IOException {

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

		// Click My inquiries tab and verify results
		atlmppge.getmyinfomyinquiriestab().click();
		Assert.assertTrue(atlmppge.getmyinfoverifymyinquiries().isDisplayed());
		System.out.println("My Inquiries page is displayed properly.");
	}

	@Test(priority = 49)
	public void TS049_VerifyTabsUnderListsSectionTest() throws InterruptedException, IOException {

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

		// Click Lists tab and verify tabs under it
		atlmppge.getMPHomeListsTab().click();
		Assert.assertTrue(atlmppge.getmplistsfavorites().isDisplayed());
		Assert.assertTrue(atlmppge.getListsPageListsMenu().isDisplayed());
		Assert.assertTrue(atlmppge.getmplistsallsavedproduts().isDisplayed());
		Assert.assertTrue(atlmppge.getmplistsallsavedexhibitors().isDisplayed());
		Assert.assertTrue(atlmppge.getmplistsenentsandseminars().isDisplayed());
		Assert.assertTrue(atlmppge.getmplistsmanagelist().isDisplayed());
		System.out.println("List tab details are displayed properly.");
	}

	@Test(priority = 50)
	public void TS050_VerifyListTabDetailsTest() throws InterruptedException, IOException {

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

		// Click Lists tab and verify tabs under it
		atlmppge.getMPHomeListsTab().click();
		Assert.assertTrue(atlmppge.getmplistsfavorites().isDisplayed());
		Assert.assertTrue(atlmppge.getListsPageListsMenu().isDisplayed());
		Assert.assertTrue(atlmppge.getmplistsallsavedproduts().isDisplayed());
		Assert.assertTrue(atlmppge.getmplistsallsavedexhibitors().isDisplayed());
		Assert.assertTrue(atlmppge.getmplistsenentsandseminars().isDisplayed());
		Assert.assertTrue(atlmppge.getmplistsmanagelist().isDisplayed());
		System.out.println("List tab options are displayed properly.");

		// Verify List Details on the page
		atlmppge.getListsPageListsMenu().click();
		Assert.assertTrue(atlmppge.getmplistsmanagelist().isDisplayed());
		Assert.assertTrue(atlmppge.getmpduplicatelistbtn().isDisplayed());
		Assert.assertTrue(atlmppge.getmpeditlistbtn().isDisplayed());
		Assert.assertTrue(atlmppge.getmparrangelistbtn().isDisplayed());
		Assert.assertTrue(atlmppge.getmpnewlistbtn().isDisplayed());
		Assert.assertTrue(atlmppge.getmpnewgrpbtn().isDisplayed());
		System.out.println("List details are displayed properly.");

	}

	@Test(priority = 51)
	public void TS051_VerifyMarketPlannerAddEventsToFav() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP-T233: Market Planner: Lists- Favorites- Add an Event to Favorites using
		// 'Favorite' icon in Event actions

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp = new ATLFloorPlansPage(driver);
		atlevents = new ATLEventsAndWebinarPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		atlgs = new ATLGlobalSearchPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/*
		 * atlmppge.getATLAttendTab().click();
		 * atlmppge.getATLAttendTabEventMenu().click();
		 * atlmppge.getATLAttendTabEventBtn().click();
		 * atlmppge.getATLExhibitorEvent().click(); atlmppge.getATLIMCEvent().click();
		 */
		// utl.verifyMPLoginFunctionality();

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
		// Assert.assertTrue(atlmppge.getATLSavedExhNameInList().getText().contains(eventTitle));
		utl.checkItemPresentInListorNot(atlmppge.getlistOfAllSavedAllEventsWebinar(), eventTitle);
		// Delete that favorites exhibitor from list
		atlmppge.getATLEditListItemMoreBtn().click();
		atlmppge.getATLEditListItemDeleteOptn().click();
		Thread.sleep(6000);

		// Verify that the added favorites exhibitor should be removed from Favorites
		// list
		Assert.assertFalse(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));

	}

	@Test(priority = 38)
	public void TS052_VerifyMarketPlannerAllSavedEventsAndSemninar() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP-T268: Market Planner: Lists- All Saved Events and Seminars
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp = new ATLFloorPlansPage(driver);
		atlevents = new ATLEventsAndWebinarPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		atlgs = new ATLGlobalSearchPage(driver);

		/*
		 * atlmppge.getATLAttendTab().click();
		 * atlmppge.getATLAttendTabEventMenu().click();
		 * atlmppge.getATLAttendTabEventBtn().click();
		 * atlmppge.getATLExhibitorEvent().click(); atlmppge.getATLIMCEvent().click();
		 */
		utl.clickOnEventLinkOfChannel();

		// Click on IMC Event Tab
		atlevents.getatlImcEventsTab().click();
		// Click on Any Event title
		String eventTitle = atlevents.getatlClickOnEvent().getText();
		atlevents.getatlClickOnEvent().click();

		Assert.assertTrue(eventTitle.contains(atlevents.getatlEventNameOnDetailsPage().getText()));

		// Click on Fav Icon

		atlevents.getatlFavIcon().click();

		// Click on Market Planner link
		lap.getMPLinkText().click();

		// Click on Lists tab on MP home page
		atlmppge.getMPHomeListsTab().click();
		atlmppge.getsavedAllEventsWebinar().click();

		// Verify that the added favorites event should be displayed in to Favorites
		// list
		// Assert.assertTrue(atlmppge.getATLSavedExhNameInList().getText().contains(eventTitle));
		utl.checkItemPresentInListorNot(atlmppge.getlistOfAllSavedAllEventsWebinar(), eventTitle);

		// Delete that favorites exhibitor from list
		atlmppge.getATLEditListItemMoreBtn().click();
		atlmppge.getATLEditListItemDeleteOptn().click();
		Thread.sleep(6000);

		// Verify that the added favorites exhibitor should be removed from Favorites
		// list
		Assert.assertFalse(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));

	}

	@AfterClass
	public void tearDown() {
		// driver.quit();

	}

}
