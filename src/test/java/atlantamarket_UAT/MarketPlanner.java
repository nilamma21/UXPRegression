package atlantamarket_UAT;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertSame;
import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.AtlantaMarket.ATLExhDigiShowroomPage;
import pageObjects.AtlantaMarket.ATLExhLineProdActionsPage;
import pageObjects.AtlantaMarket.ATLGlobalSearchPage;
import pageObjects.AtlantaMarket.ATLLandingPage;
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

	@BeforeClass
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);

		// Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("atlmrkturl_uat"));
		lap.getIUnderstandBtn().click();
		Thread.sleep(8000);
		// lap.getCloseMarktAdBtn().click();
	}

	@Test(priority = 1)
	public void TS001_VerifyMarketPlannerLoginTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-001: To verify the Market Planner overview and it's functionality

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Login to Market Planner
		utl.verifyMPLoginFunctionality();

		Thread.sleep(6000);
		// lap.getCloseMarktAdBtn().click();

		// Verify that Market Planner Home page should be displayed
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
		utl.verifyMPLoginFunctionality();
		Thread.sleep(6000);
		// Click on Market Planner
		lap.getMPLinkText().click();
		Thread.sleep(6000);
		// Verify MP page
		Assert.assertTrue(driver.getTitle().contains("Market Planner"));

		Select selectAMC = new Select(atlmppge.getselectChannel());
		// Select AMC
		selectAMC.selectByVisibleText("AmericasMart");
		// verify AMC MP Page
		Assert.assertTrue(driver.getCurrentUrl().contains("https://uat-amc.imcmvdp.com/Market-Planner"));
		System.out.println("Select AMC");
		driver.get("https://uat-atlmkt.imcmvdp.com/Market-Planner");
		Thread.sleep(10000);

		// Select ATL APP
		Select selectATLApp = new Select(atlmppge.getselectChannel());
		selectATLApp.selectByVisibleText("Atlanta Apparel");
		// verify Atlanta App Page
		Assert.assertTrue(driver.getCurrentUrl().contains("https://uat-atlapp.imcmvdp.com/Market-Planner"));
		System.out.println("Select ATLAPP");

		driver.get("https://uat-atlmkt.imcmvdp.com/Market-Planner");
		Thread.sleep(5000);

		Select selectLVA = new Select(atlmppge.getselectChannel());
		selectLVA.selectByVisibleText("Las Vegas Apparel");
		// verify Atlanta Market Page
		Assert.assertTrue(driver.getCurrentUrl().contains("https://uat-lvapp.imcmvdp.com/Market-Planner"));
		System.out.println("Select Las Vegas Apparel");
		driver.get("https://uat-atlmkt.imcmvdp.com/Market-Planner");
		Thread.sleep(5000);

		Select selectLVM = new Select(atlmppge.getselectChannel());
		selectLVM.selectByVisibleText("Las Vegas Market");
		// verify Atlanta Market Page
		Assert.assertTrue(driver.getCurrentUrl().contains("https://uat-lvm.imcmvdp.com/Market-Planner"));
		System.out.println("Select Las Vegas Market");
		driver.get("https://uat-atlmkt.imcmvdp.com/Market-Planner");
		Thread.sleep(5000);

		Select selectLVV = new Select(atlmppge.getselectChannel());
		selectLVV.selectByVisibleText("Las Vegas VOW");
		// verify Atlanta Market Page
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.change.me/Market-Planner"));
		System.out.println("Select Las Vegas VOW");
		driver.get("https://uat-atlmkt.imcmvdp.com/Market-Planner");
		Thread.sleep(5000);

		Select selectATLM = new Select(atlmppge.getselectChannel());
		selectATLM.selectByVisibleText("Atlanta Market");
		// verify Atlanta Market Page
		Assert.assertTrue(driver.getCurrentUrl().contains("https://uat-atlmkt.imcmvdp.com/Market-Planner"));
		System.out.println("Select ATL Market");
		driver.get("https://uat-atlmkt.imcmvdp.com/Market-Planner");
		Thread.sleep(5000);
	}

	@Test(priority = 2)
	public void TS002_VerifyMarketPlannerInvalidLoginCredentialsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T221: Market Planner: Login: Login with invalid login credentials
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Invalid Password
		utl.verifyMPInvalidLoginFunctionality((prop.getProperty("username")), (prop.getProperty("invalidPassword")));
		// Verify incorrect password error msg
		Assert.assertTrue(
				atlmppge.getInvalidPasswordError().getText().contains(prop.getProperty("incorrectPasswordErrorMsg")));

		driver.get(prop.getProperty("atlmrkturl_uat"));

		// non-registered (Invalid) email address and Invalid password
		utl.verifyMPInvalidLoginFunctionality((prop.getProperty("invalidUsername")),
				(prop.getProperty("invalidPassword")));
		// Verify error msg
		Assert.assertTrue(
				atlmppge.getInvalidPasswordError().getText().contains(prop.getProperty("invalidUserIdErrorMsg")));

		driver.get(prop.getProperty("atlmrkturl_uat"));
		// without Email and Password
		lap.getLogin().click();
		lp.getSignInBtn().click();
		// Verify Enter email error msg
		Assert.assertTrue(atlmppge.getEnterEmailErrorMsg().getText().contains(prop.getProperty("EnterEmailErrorMsg")));
		// Verify Enter password error msg
		Assert.assertTrue(
				atlmppge.getEnterPasswordErrorMsg().getText().contains(prop.getProperty("EnterPasswordErrorMsg")));
	}

	@Test(priority = 13)
	public void TS013_VerifyAddExhibitorToFavUsingQuickAddInListsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T232: Market Planner: Lists- Favorites- Add an Exhibitor to Favorites using 'Quick Add'
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Login to Market Planner
		utl.verifyMPLoginFunctionality();
		Thread.sleep(6000);
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
		atlmppge.getMpQuickAdd().sendKeys("Test");
		// Click on 1st suggetion
		String s = atlmppge.getMpQuickAddAutosuggetion().getText();
		atlmppge.getMpQuickAddAutosuggetion().click();
		// Verify Selected exhibitor added or not
		Assert.assertTrue(s.contains(atlmppge.getMpQuickAddedExpName().getText()));

	}

	@Test(priority = 14)
	public void TS014_VerifyMarketPlannerSignOutTest() throws InterruptedException, IOException {
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
		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://uat-atlmkt.imcmvdp.com/"));
		System.out.println("Market Planner signed out successfully.");
	}

	@Test(priority = 7)
	public void TS007_VerifyArrangeBtnFunctionalityForListsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T234: Market Planner: Lists: Lists: Arrange button functionality test case

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Login to Market Planner
		utl.verifyMPLoginFunctionality();
		Thread.sleep(6000);
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
		System.out.println(atlmppge.getMpEditListoption().getLocation());
		Assert.assertTrue(atlmppge.getMpListSortBtn().isDisplayed());
		Actions action = new Actions(driver);
		action.clickAndHold(atlmppge.getMpListSortBtn()).build().perform();
		Thread.sleep(15000);
		System.out.println(atlmppge.getMpEditListoption().getLocation());
	}

	@Test(priority = 8)
	public void TS008_VerifyNewGroupBtnFunctionalityForListsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T238: Market Planner: Lists: Lists: New Group button functionality

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Login to Market Planner
		utl.verifyMPLoginFunctionality();
		Thread.sleep(6000);
		// Click on Market Planner
		lap.getMPLinkText().click();
		Thread.sleep(6000);
		// Click on List tab
		atlmppge.getMPHomeListsTab().click();
		Thread.sleep(10000);
		// Click on List from left Pannel
		atlmppge.getMpListLeftPannel().click();
		// click on New group btn
		atlmppge.getMpListNewGroupBtn().click();
		// verify New Group Popup header
		Assert.assertTrue(
				atlmppge.getMpListNewGroupPopupHeader().getText().contains(prop.getProperty("CreateGroupPopupHeader")));
		// Enter Group name
		String newGroupname = "Cyb" + genData.generateRandomString(5);
		atlmppge.getMpListNewGroupNameTxt().sendKeys(newGroupname);
		// Clickk on Create Btn
		atlmppge.getMpListNewGroupCreateBtn().click();

	}

	@Test(priority = 10)
	public void TS010_VerifyNewListBtnFunctionalityForListsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T235: Market Planner: Lists: Lists: New Test button functionality

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Login to Market Planner
		/*
		 * utl.verifyMPLoginFunctionality(); Thread.sleep(6000); // Click on Market
		 * Planner lap.getMPLinkText().click(); Thread.sleep(6000); // Click on List tab
		 * atlmppge.getMPHomeListsTab().click(); Thread.sleep(10000); // Click on List
		 * from left Pannel atlmppge.getMpListLeftPannel().click();
		 */
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
		selectGroup.selectByIndex(1);
		// Click on Create Btn
		atlmppge.getMpListNewCreateBtn().click();
		List<WebElement> allList = driver.findElements(By.xpath("//div[@class='imc-market-planner-list_row_title']"));
		boolean flag = false;
		for (WebElement list : allList) {

			if (list.getText().contains(newlistname)) {

				flag = true;
				break;
			}
		}
		Assert.assertTrue(flag = true);
	}

	@Test(priority = 9)
	public void TS009_VerifyCreateNewGroupFormValidationForListsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T239:- Market Planner: Lists: Lists: Validations at Create New List Group form

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Login to Market Planner
		utl.verifyMPLoginFunctionality();
		Thread.sleep(6000);
		// Click on Market Planner
		lap.getMPLinkText().click();
		Thread.sleep(6000);
		// Click on List tab
		atlmppge.getMPHomeListsTab().click();
		Thread.sleep(10000);
		// Click on List from left Pannel
		atlmppge.getMpListLeftPannel().click();
		// click on New Group btn
		atlmppge.getMpListNewGroupBtn().click();
		// verify New Group Popup header
		Assert.assertTrue(
				atlmppge.getMpListNewGroupPopupHeader().getText().contains(prop.getProperty("CreateGroupPopupHeader")));
		// Clickk on Create Btn
		atlmppge.getMpListNewGroupCreateBtn().click();
		// Validate Invalid Group Name Msg
		Assert.assertTrue(atlmppge.getMpInvalidGrNameMsg().getText().contains(prop.getProperty("InvalidGroupMsg")));
	}

	@Test(priority = 6)
	public void TS006_VerifyCreateNewListFormValidationTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T236: Market Planner: Lists: Lists: Validations at Create New List form

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Login to Market Planner
		utl.verifyMPLoginFunctionality();
		Thread.sleep(6000);
		// Click on Market Planner
		lap.getMPLinkText().click();
		Thread.sleep(6000);
		// Click on List tab
		atlmppge.getMPHomeListsTab().click();
		Thread.sleep(10000);
		// Click on List from left Pannel
		atlmppge.getMpListLeftPannel().click();
		// click on New list btn
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
		List<WebElement> allList = driver.findElements(By.xpath("//div[@class='imc-market-planner-list_row_title']"));
		boolean flag = false;
		for (WebElement list : allList) {

			if (list.getText().contains(newlistname)) {

				flag = true;
				break;
			}
		}
		Assert.assertTrue(flag = true);
	}

	@Test(priority = 4)
	public void TS004_VerifyMPDashboardOverviewTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-001: To verify the Market Planner overview and it's functionality

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		lap.getMPLinkText().click();
		Thread.sleep(6000);

		// Verify dash board for tabs options after login
		Assert.assertTrue(atlmppge.getselectChannel().isDisplayed());
		Assert.assertEquals(atlmppge.getmpdasboardtab().getText(),"Dashboard");
		Assert.assertEquals(atlmppge.getMPHomeListsTab().getText(),"Lists");
		Assert.assertEquals(atlmppge.getmpmyinfotab().getText(),"My Info");
		Assert.assertEquals(atlmppge.getmpregistrationtab().getText(),"Registrations");
		Assert.assertEquals(atlmppge.getmpsavedsearchestab().getText(),"Saved Searches");

		System.out.println("Market Planner tabs are displayed properly.");

		// Verify Dashboard Cards
		Assert.assertTrue(atlmppge.getmpregistrationcard().isDisplayed());
		Assert.assertTrue(atlmppge.getmplistscard().getText().contains("Lists"));
		Assert.assertTrue(atlmppge.getmpbookmyhotelcard().getText().contains("Hotel"));

		System.out.println("Market Planner Cards are displayed properly.");

		// Verify Book a Hotel card options
		Assert.assertEquals(atlmppge.getmpbookmyhotelsection().getText(), "Book a Hotel");
		Assert.assertEquals(atlmppge.getmpfloorplanssection().getText(), "Floor Plans");
		Assert.assertEquals(atlmppge.getmpexhibitorsectionsection().getText(), "Exhibitor Directory");
		Assert.assertEquals(atlmppge.getmpsavedsearchessection().getText(), "Saved Searches");
		Assert.assertEquals(atlmppge.getmpmyinfosection().getText(), "My Info");

		System.out.println("Book a Hotel sub options are displayed properly.");

	}

	@Test(priority = 5)
	public void TS005_VerifyMPRegistrationCardOverviewTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-001: To verify the Market Planner overview and it's functionality

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		lap.getMPLinkText().click();
		Thread.sleep(6000);

		// Verify Registration Card details
		Assert.assertTrue(atlmppge.getmpmarketnameregcard().isDisplayed());
		Assert.assertTrue(atlmppge.getmpmarketdateregcard().isDisplayed());

		System.out.println("Market Name and Market Date are displayed at Registration Card properly.");

		Assert.assertTrue(atlmppge.getmpregistrationlink().isDisplayed());

		System.out.println("Registration Information link is displayed at Registration Card properly.");

		// Verify Online Registrations page
		atlmppge.getmpregistrationlink().click();
		Assert.assertTrue(atlmppge.getmpverifyregistrationinformationlink().isDisplayed());

		System.out.println("Registration section is displayed properly.");

	}

	@Test(priority = 11)
	public void TS011_VerifyAddProductToFavFunctionalityInFavListsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T237: Market Planner: Lists- Favorites- Add a Product to Favorites using 'Favorite' icon in Product actions

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();
		atlexhact = new ATLExhLineProdActionsPage(driver);

		atlgs = new ATLGlobalSearchPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Login to Market Planner
		utl.verifyMPLoginFunctionality();
		Thread.sleep(6000);
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
		Thread.sleep(8000);
		// Verify that the added product should be displayed in to Favorites list
		List<WebElement> favlist = driver.findElements(By.xpath(
				"//div[@class='imc-saved-exhibitors__contentItems__col2-1 imc-heading--h7 imc-heading--primary-medium imc-saved-exhibitors__name-title']"));
		boolean flag = false;
		for (WebElement list : favlist) {

			if (list.getText().contains(productNameOnSearchGrid)) {

				flag = true;
				break;
			}
		}
		Assert.assertTrue(flag = true);

	}

	@Test(priority = 12)
	public void TS012_VerifyAddExhibitorToFavInFavListsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T243: Market Planner: Lists- Favorites- Add an Exhibitor to Favorites using 'Favorite' icon in Exhibitor actions.

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();
		atlexhact = new ATLExhLineProdActionsPage(driver);


		atlgs = new ATLGlobalSearchPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Login to Market Planner
		utl.verifyMPLoginFunctionality();
		Thread.sleep(6000);
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
		Thread.sleep(8000);
		// Verify that the added product should be displayed in to Favorites list
		List<WebElement>favlist = driver.findElements(By.xpath("//li[@class='imc-list-edit--draggable']/div/div/div/a"));
		boolean flag = false;
		for (WebElement list : favlist) {

			if (list.getText().contains(exhname)) {
				System.out.println(list.getText());
				flag = true;
				break;
			}
		}
		Assert.assertTrue(flag = true);

	}


	@AfterClass
	public void tearDown() {
		// driver.quit();
	}

}
