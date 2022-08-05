package atlantamarket_UAT;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertSame;

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
	@Test(priority = 3)

	public void TS003_VerifyMarketPlannerChannelSelectorTest() throws InterruptedException, IOException {
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
		//Click on List tab
		atlmppge.getMPHomeListsTab().click();
		Thread.sleep(10000);
		//Click on List from left Pannel
		atlmppge.getMpListLeftPannel().click();
		//Click on Edit list option in front of fev
		atlmppge.getMpEditListoption().click();
		//Enter search term
		atlmppge.getMpQuickAdd().sendKeys("Test");
		//Click on 1st suggetion
		String s=atlmppge.getMpQuickAddAutosuggetion().getText();
		atlmppge.getMpQuickAddAutosuggetion().click();
		//Verify Selected exhibitor added or not
		Assert.assertTrue(s.contains(atlmppge.getMpQuickAddedExpName().getText()));
		
	}
		
		

	@Test(priority = 4)
	public void TS004_VerifyMarketPlannerSignOutTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-001: To verify the Market Planner sign out functionality

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click Welcome Text
		atlmppge.getwelcometext().click();
		
		//Click Sign out link 
		atlmppge.getsignout().click();
		
		//Verify user signed out successfully
		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://uat-atlmkt.imcmvdp.com/"));
		System.out.println("Market Planner signed out successfully.");
	}
	
	@AfterClass
	public void tearDown() {
		// driver.quit();
	}

}
