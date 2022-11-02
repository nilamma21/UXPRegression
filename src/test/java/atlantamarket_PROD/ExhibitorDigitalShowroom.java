package atlantamarket_PROD;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.AtlantaMarket.ATLExhDigiShowroomPage;
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

@Test
@Listeners({ TestListeners.class })
public class ExhibitorDigitalShowroom extends base {

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
	ATLLeftPaneFilters atlleftpane;

	List<WebElement> exhlist, linelist, prodlist, searchexhtypelist, searchproducttypelist, mplists, mpeditlistoptns,
	allnoteslist, favlist, searchlinetypelist, tagBlogPost, taglist, infoFilterList;

	@BeforeClass
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		// chromeVersion();
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);

		// Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("atlmrkturl_prod"));
		lap.getIUnderstandBtn().click();
		lap.getCloseMarktAdBtn().click();
		//Thread.sleep(5000);
		
	}
	@Test(priority = 1)
	public void TS001_VerifyAddToFavoritesTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T294: Add To Favorites - Need to recheck

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		lap = new ATLLandingPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Search Exhibitor in global search option
		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("exhibitor1"));
		atlgs.getATLSearchButton().click();
		

		// Click on Exhibitor name and login to market planner
		atlexhdgshw.getSearchedExhibitor().click();
		utl.verifyMPLoginFunctionality();
		lap.getCloseMarktAdBtn().click();
		
		//Click Market Planner's Name and go to favorites under Lists tab and verify results
		lap.getMPLinkText().click();
		atlmppge.getMPHomeListsTab().click();
		//atlmppge.getATLMPListsPageFavoritesMenu().click();
		utl.scrollToElement(atlmppge.getmplistsenentsandseminars());
		Thread.sleep(5000);
		Assert.assertTrue(atlexhdgshw.getVerifyExhibitorInFavoritesLists().getText().contains("exhibitor1"));
		System.out.println("Exhibitor is properly displayed at Favorites tab.");
	
	}

}
