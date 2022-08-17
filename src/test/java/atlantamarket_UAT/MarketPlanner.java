package atlantamarket_UAT;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertSame;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.mail.Flags.Flag;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
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

	@Test(priority = 2)
	public void TS002_VerifyMarketPlannerChannelSelectorTest() throws InterruptedException, IOException {
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

	@Test(priority = 3)
	public void TS003_VerifyMarketPlannerInvalidLoginCredentialsTest() throws InterruptedException, IOException {
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

	@Test(priority = 4)
	public void TS004_VerifyAddExhibitorToFavUsingQuickAddInListsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T232: Market Planner: Lists- Favorites- Add an Exhibitor to Favorites
		// using 'Quick Add'
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

	@Test(priority = 5)
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
		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://uat-atlmkt.imcmvdp.com/"));
		System.out.println("Market Planner signed out successfully.");
	}

	@Test(priority = 6)
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
		Assert.assertTrue(atlmppge.getMpListSortBtn().isDisplayed());
		//Store List name
		String lName=atlmppge.getmpListName().getText();
		//Store Source Location 
		Point sLocation=atlmppge.getmpListName().getLocation();
		//Drag from source location to Destination
		Actions action = new Actions(driver);
		action.dragAndDrop(atlmppge.getMpListSortBtn(), atlmppge.getmpDestinationLocationList()).build().perform();;
		Thread.sleep(5000);
		//All present lists
		List<WebElement> allList = driver.findElements(By.xpath("//div[@class='imc-market-planner-list_row_title']"));
		boolean flag = false;
		for (WebElement list : allList) {
			Thread.sleep(5000);
			
			if(list.getText().equals(lName)) {
				Point DestLocation=list.getLocation();
				System.out.println("In If :: "+sLocation +"And" +DestLocation);
				if(DestLocation!=sLocation)
				{
					flag = true;
					Assert.assertTrue(flag=true);
					break;
				}
				else
				{
					Assert.assertTrue(flag=false);
					break;
				}
				
			}
		}
		
	}

	@Test(priority = 7)
	public void TS007_VerifyNewGroupBtnFunctionalityForListsTest() throws InterruptedException, IOException {
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
		// Login to Market Planner
		
		  utl.verifyMPLoginFunctionality(); Thread.sleep(6000); // Click on MarketPlanner 
		  lap.getMPLinkText().click(); Thread.sleep(6000); // Click on List tab
		  atlmppge.getMPHomeListsTab().click(); Thread.sleep(10000); // Click on Listfrom left Pannel 
		  atlmppge.getMpListLeftPannel().click();
		 
		// click on New list btn
		atlmppge.getMpListNewListBtn().click();
		// verify New List Popup header
		Assert.assertTrue(
				atlmppge.getMpListNewGroupPopupHeader().getText().contains(prop.getProperty("CreateListPopupHeader")));
		// Enter List name
		String newlistname = "Cyb" + genData.generateRandomString(5);
		atlmppge.getMpListNewGroupNameTxt().sendKeys(newlistname);
		System.out.println("list name :: "+newlistname);
		// Select Group from dropdown
		Select selectGroup = new Select(atlmppge.getmpListNewSelectGroupDropdown());
		Thread.sleep(5000);
		selectGroup.selectByIndex(3);
		// Click on Create Btn
		atlmppge.getMpListNewCreateBtn().click();
		Thread.sleep(5000);
		List<WebElement> allList = driver.findElements(By.xpath("//div[@class='imc-market-planner-list_row_title']"));
		boolean flag = false;
			for (WebElement list : allList) {
			//Thread.sleep(2000);
	//System.out.println(list.getText());
			if (list.getText().equals(newlistname)) {
				//System.out.println(list.getText());
				System.out.println("Equal");
				flag = true;
				break;
			}
		}
		if(flag==true)
		{
			Assert.assertTrue(flag = true);
		}else {
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
		
		/*List<WebElement> allList = driver.findElements(By.xpath("//div[@class='imc-market-planner-list_row_title']"));
		boolean flag = false;
		for (WebElement list : allList) {
			System.out.println(list.getText());
			if (list.getText().contains(newlistname)) {

				flag = true;
				Assert.assertTrue(flag = true);
				break;
			}
			
		}*/
		Thread.sleep(5000);
		List<WebElement> allList = driver.findElements(By.xpath("//div[@class='imc-market-planner-list_row_title']"));
		boolean flag = false;
			for (WebElement list : allList) {
			//Thread.sleep(2000);
			System.out.println(list.getText());
			if (list.getText().equals(newlistname)) {
				//System.out.println(list.getText());
				System.out.println("Equal");
				flag = true;
				break;
			}
		}
		if(flag==true)
		{
			Assert.assertTrue(flag = true);
		}else {
			Assert.assertTrue(flag = false);
		}
	}



	@Test(priority = 11)
	public void TS011_VerifyMPDashboardOverviewTest() throws InterruptedException, IOException {

	

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



	@Test(priority = 12)
	public void TS012_VerifyMPRegistrationCardOverviewTest() throws InterruptedException, IOException {

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



	@Test(priority = 13)
	public void TS013_VerifyAddProductToFavFunctionalityInFavListsTest() throws InterruptedException, IOException {

	

	@Test(priority = 11)
	public void TS011_VerifyAddProductToFavFunctionalityInFavListsTest() throws InterruptedException, IOException {



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
		
		Thread.sleep(5000);
		List<WebElement> favlist = driver.findElements(By.xpath(
				"//div[@class='imc-saved-exhibitors__contentItems__col2-1 imc-heading--h7 imc-heading--primary-medium imc-saved-exhibitors__name-title']"));
		boolean flag = false;
			for (WebElement list : favlist) {
			
			if (list.getText().equals(productNameOnSearchGrid)) {
				
				System.out.println("Equal");
				flag = true;
				break;
			}
		}
		if(flag==true)
		{
			Assert.assertTrue(flag = true);
		}else {
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
		Thread.sleep(5000);
		List<WebElement> favlist = driver.findElements(By.xpath("//li[@class='imc-list-edit--draggable']/div/div/div/a"));
		boolean flag = false;
			for (WebElement list : favlist) {
			//Thread.sleep(2000);
			
			if (list.getText().equals(exhname)) {
				
				System.out.println("Equal");
				flag = true;
				break;
			}
		}
		if(flag==true)
		{
			Assert.assertTrue(flag = true);
		}else {
			Assert.assertTrue(flag = false);
		}

	}

	@Test(priority = 15)
	public void TS015_VerifyMarketPlannerListManageListTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T244: Market Planner: Lists- List Management- 'Manage List' Options.

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
		Thread.sleep(10000);
		// click on Edit list btn
		atlmppge.getATLMPEditListOptn().click();
		atlmppge.getMpManageDropdown().click();

		//Verify Edit
		Thread.sleep(5000);
		List<WebElement> manageList = driver.findElements(By.xpath("//div[@class='react-select__menu-list css-11unzgr']/div"));
		boolean flag = false;
			for (WebElement list : manageList) {
			//Thread.sleep(2000);
			//System.out.println(list.getText());
			if (list.getText().equals("Edit")) {
				//System.out.println(list.getText());
				System.out.println("Equal");
				flag = true;
				break;
			}
		}
		if(flag==true)
		{
			System.out.println("Edit Present");
			Assert.assertTrue(flag = true);
		}else {
			System.out.println("Edit Not Present");
			Assert.assertTrue(flag = false);
		}
		//Verify Email Present or not
		boolean flag1 = false;
			for (WebElement list : manageList) {
			//Thread.sleep(2000);
			
			if (list.getText().equals("Email")) {
				//System.out.println(list.getText());
				System.out.println("Equal");
				flag1 = true;
				break;
			}
		}
		if(flag1==true)
		{
			System.out.println("Email Present");
			Assert.assertTrue(flag1 = true);
		}else {
			System.out.println("Email Not Present");
			Assert.assertTrue(flag1 = false);
		}
	//Verify Download is present or not
		boolean flag2 = false;
			for (WebElement list : manageList) {
			if (list.getText().equals("Download")) {
				System.out.println("Equal");
				flag2 = true;
				break;
			}
		}
		if(flag2==true)
		{System.out.println("Download Present");
			Assert.assertTrue(flag2 = true);
		}else {
			System.out.println("Download not Present");
			Assert.assertTrue(flag2 = false);
		}

	}

	@Test(priority = 16)
	public void TS016_VerifyMarketPlannerListManageListEditOptTest() throws InterruptedException, IOException {
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
		Thread.sleep(10000);
		// click on Edit list btn
		atlmppge.getATLMPEditListOptn().click();
		Thread.sleep(1000);
		atlmppge.getMpManageDropdown().click();
		Thread.sleep(5000);
		List<WebElement> manageList = driver
				.findElements(By.xpath("//div[@class='react-select__menu-list css-11unzgr']/div"));
		List<WebElement> editList = driver.findElements(By.xpath("//li[@class='imc-list-edit--draggable']"));

		boolean flag = false;
		for (WebElement list : manageList) {
			// System.out.println(list.getText());

			if (list.getText().contains("Edit")) {
				System.out.println(list.getText());

				list.click();

				if (atlmppge.getMpManageEditList().isDisplayed()) {
					// click on Select All Btn
					atlmppge.getMpManageEditListSelectAllBtn().click();
					atlmppge.getMpManageEditListSelectAllBtn().click();
					// Click on Copy To Btn
					atlmppge.getMpManageEditListCopyToBtn().click();
					Assert.assertTrue(atlmppge.getMpSelectListPopup().isDisplayed());
					String fevList = atlmppge.getMpFevList().getText();

				}

			}
		}
	}

	@Test(priority = 17)
	public void TS0017_VerifyMarketPlannerListDuplicateListTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T240: Market Planner: Lists: Lists: Duplicate Link functionality.

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
		Thread.sleep(10000);

		/*atlmppge.getMpListNewListBtn().click();
		// verify New List Popup header
		Assert.assertTrue(
				atlmppge.getMpListNewGroupPopupHeader().getText().contains(prop.getProperty("CreateListPopupHeader")));
		// Click on Create Btn
		atlmppge.getMpListNewCreateBtn().click();
		// Validate Invalid list name msg
		Assert.assertTrue(atlmppge.getMpInvalidGrNameMsg().getText().contains(prop.getProperty("InvalidListMsg")));

		String newlistname = "Cyb" + genData.generateRandomString(5);
		atlmppge.getMpListNameTxt().sendKeys(newlistname);
		System.out.println("List Name::"+newlistname);
		// Click on Create Btn
		atlmppge.getMpListNewListCreateBtn().click();
		Thread.sleep(10000);

		// click on duplicate
		atlmppge.getMpDuplicateList().click();
		atlmppge.getMpDuplicateListInputBox().sendKeys(newlistname);
		atlmppge.getMpDuplicateBtn().click();
		Thread.sleep(10000);*/
		List<WebElement> allList = driver.findElements(By.xpath("//div[@class='imc-market-planner-list_row_title']"));
		boolean flag = false;
		/*for (WebElement list : allList) {

			if (list.getText().contains(newlistname)) {
				System.out.println(list);
				flag = true;
				break;
			}

		}
		Assert.assertTrue(flag = true);*/
		int count=0;
		for (WebElement list : allList) {
			if (list.getText().equals("CybTestList")) {
				count++;
			}
			
		}
		System.out.println("Total :: "+count);
		
		
		/*for (WebElement list : allList) {
		
		System.out.println(list.getText());
		if (list.getText().equals(newlistname)) {
			//System.out.println(list.getText());
			System.out.println("Equal");
			flag = true;
			break;
		}
	}
	if(flag==true)
	{
		System.out.println("Duplicate List Present");
		Assert.assertTrue(flag = true);
	}else {
		System.out.println("Duplicate List Not Present");
		Assert.assertTrue(flag = false);
	}*/

	}

	@Test(priority = 18)
	public void TS0018_VerifyMarketPlannerListRenameListTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T241: Market Planner: Lists: Lists: Rename List functionality.

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
		Thread.sleep(10000);

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
		atlmppge.getATLMPEditListOptn().click();
		Thread.sleep(5000);

		String currentListName = atlmppge.getmpCurrentListName().getText();
		System.out.println();
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
		// Verify Rename List is Present
		List<WebElement> allList = driver.findElements(By.xpath("//div[@class='imc-market-planner-list_row_title']"));
		
		
		boolean flag = false;
		for (WebElement list : allList) {
			
			if (list.getText().equals(renameListName)) {
				
				System.out.println("Equal");
				flag = true;
				break;
			}
		}
		if(flag==true)
		{
			//Assert.assertTrue(flag = true);
			System.out.println("Rename List Present");
			Assert.assertTrue(flag=true, "Present");
		}else {
			
			Assert.assertTrue(flag=false, "Not Present");
		}

		// Verify Old List is Not Present
		
		boolean flag1 = false;
		for (WebElement list : allList) {
			//Thread.sleep(2000);
			//System.out.println(list.getText());
			if (list.getText().equals(currentListName)) {
				//System.out.println(list.getText());
				System.out.println("NotEqual");
				flag1 = true;
				break;
			}
		}
		if(flag1==true)
		{
			System.out.println("Old List Present Failed");
			Assert.assertTrue(flag1=false, "Present");
		}else {
			
			System.out.println("Old List Not Present");
			Assert.assertFalse(flag1 = false);
		}
	}
	@Test(priority =19 )
	public void TS019_VerifyAddToFavoriteForLineTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T242 : Market Planner: Lists- Favorites- Add an Line to Favorites using 'Favorite' icon in Line actions

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		lap = new ATLLandingPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Login to Market Planner
		utl.verifyMPLoginFunctionality();
		Thread.sleep(6000);
		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchlineinput")));
		Thread.sleep(2000);
		atlgs.getATLSearchButton().click();
		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		String exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		// Click on Favorite icon of 1st exhibitor
		atlexhact.getAddFavIcon().click();

		// Click on Market Planner link
		lap.getMPLinkText().click();

		// Click on Lists tab on MP home page
		atlmppge.getMPHomeListsTab().click();
		atlmppge.getATLMPListsPageFavoritesMenu().click();

		// Verify that the added favorites exhibitor should be displayed in to Favorites list
		Assert.assertTrue(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));

		/*// Delete that favorites exhibitor from list
		atlmppge.getATLEditListItemMoreBtn().click();
		atlmppge.getATLEditListItemDeleteOptn().click();
		Thread.sleep(6000);

		// Verify that the added favorites exhibitor should be removed from Favorites list
		Assert.assertFalse(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));*/
	}
	@Test(priority =19 )


	public void TS020_VerifyAddToFavoriteForExhibitorTest1() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T243: The Add to Favorite functionality for an Exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		lap = new ATLLandingPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Login to Market Planner
		utl.verifyMPLoginFunctionality();
		Thread.sleep(6000);
		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();
		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		String exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		// Click on Favorite icon of 1st exhibitor
		atlexhact.getAddFavIcon().click();

		// Click on Market Planner link
		lap.getMPLinkText().click();

		// Click on Lists tab on MP home page
		atlmppge.getMPHomeListsTab().click();
		atlmppge.getATLMPListsPageFavoritesMenu().click();

		// Verify that the added favorites exhibitor should be displayed in to Favorites list
	//	Assert.assertTrue(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));
		Thread.sleep(5000);
		List<WebElement> favlist = driver.findElements(By.xpath("//li[@class='imc-list-edit--draggable']/div/div/div/a"));
		boolean flag = false;
			for (WebElement list : favlist) {
			//Thread.sleep(2000);
			
			if (list.getText().equals(exhname)) {
				
				System.out.println("Equal");
				flag = true;
				break;
			}
		}
		if(flag==true)
		{
			Assert.assertTrue(flag = true);
		}else {
			Assert.assertTrue(flag = false);
		}


	/*	// Delete that favorites exhibitor from list
		atlmppge.getATLEditListItemMoreBtn().click();
		atlmppge.getATLEditListItemDeleteOptn().click();
		Thread.sleep(6000);

		favlist = driver.findElements(By.xpath("//li[@class='imc-list-edit--draggable']/div/div/div/a"));

		//Verify that the added favorites exhibitor should be removed from Favorites list
		for(int i=1; i< favlist.size(); i++)
		{			
			//System.out.println(favlist.get(i).getText());
			Assert.assertFalse(favlist.get(i).getText().contains(exhname)); 
		}*/
	}

	@Test(priority = 17)
	public void TS017_VerifyMPListsCardOverviewTest() throws InterruptedException, IOException {
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

		// Verify dashboard page
		Assert.assertTrue(atlmppge.getmpregistrationcard().isDisplayed());
		Assert.assertTrue(atlmppge.getmplistscard().getText().contains("Lists"));
		Assert.assertTrue(atlmppge.getmpbookmyhotelcard().getText().contains("Hotel"));

		System.out.println("Dashboard Cards are displayed properly.");

		// Verify All Lists link is available at Lists card
		utl.scrollToElement(atlmppge.getmpalllists());
		Assert.assertTrue(atlmppge.getmpalllists().isDisplayed());
		System.out.println("All Lists link is displayed properly.");
		
		//Save existing lists in List Card
		String SavedLists = atlmppge.getmpexistinglists().getText();
		
		//Click All Lists link and verify the result
		atlmppge.getmpalllists().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://uat-atlmkt.imcmvdp.com/Market-Planner/Lists"));
		System.out.println("Lists page is displayed properly.");
				
		//Add a new list
		//Click Lists tab
		atlmppge.getmplisttab().click();
		//Click New Lists button
		atlmppge.getmpnewlistbutton().click();
		//Add list name and click create button
		atlmppge.getCreateNewListNameTxtbx().sendKeys(genData.generateRandomString(10));
		atlmppge.getCreateNewListNameTxtbx().sendKeys();
		atlmppge.getAddListCreateBtn().click();
		//Click Dashboard tab
		atlmppge.getmpdasboardtab().click();
		//Verify if new list is displayed at List Card and old list is removed
		Assert.assertFalse(atlmppge.getmpexistinglists().getText().equalsIgnoreCase(SavedLists));
		System.out.println("Recent lists are displayed at List Card.");
		
	}
	
	

	
	@AfterClass
	public void tearDown() {
		// driver.quit();
	}

}
