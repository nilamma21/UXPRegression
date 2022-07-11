package atlantamarket_PROD;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertSame;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
		Thread.sleep(10000);
		lap.getCloseMarktAdBtn().click();
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
		lap.getCloseMarktAdBtn().click();

		// Verify that Market Planner Home page should be displayed
		Assert.assertTrue(lap.getMPLinkText().isDisplayed());	
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
