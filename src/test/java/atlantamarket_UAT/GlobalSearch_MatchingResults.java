package atlantamarket_UAT;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
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
public class GlobalSearch_MatchingResults extends base {

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
		driver.get(prop.getProperty("atlmrkturl_uat"));
		// lap.getIUnderstandBtn().click();
		Thread.sleep(5000);
		// lap.getCloseMarktAdBtn().click();
	}

	@Test(priority = 1)
	public void TS001_VerifyGlobalSearchContainsAndStartsWithTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T436: Verify Global Search: Contains and Starts With

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("containsStartWithInput"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);

		Assert.assertTrue(atlgs.getATLSearchResult().getText().contains(prop.getProperty("containsStartWithInput")));

		// Verify All Exhibitors Location Links
		for (WebElement allProductsName : atlgs.getatlListOfAllProductsName()) {

			String prodName = allProductsName.getText().toLowerCase();
			Assert.assertTrue(prodName.contains(prop.getProperty("containsStartWithInput")));

		}
		System.out.println("Displayed All Products Name Start with :: " + prop.getProperty("containsStartWithInput"));

	}

	@Test(priority = 2)
	public void TS002_VerifyGlobalSearchMatchingResultsSortWithinTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T332: Global Search: Matching results- Sort- Search Within

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);
		// Click on Sort Btn
		atlgs.getatlGlobalSearchSortBtn().click();

		// Select Exhibitor Info Only
		Select selectAMC = new Select(atlgs.getatlGlobalSearch_SearchWithinDropdwn());
		selectAMC.selectByVisibleText("Exhibitor Info Only");
		Thread.sleep(8000);
		// Verify All Exhibitor Titles
		for (WebElement allExhDisply : atlgs.getatlListOfAllExh()) {
			Assert.assertTrue(allExhDisply.isDisplayed());
		}
		System.out.println("Displayed All Exhibitors Title");

		// Verify All Exhibitors Total Product Section
		for (WebElement allExhTotalProdDisplay : atlgs.getatlListOfAllExhTotalProductLink()) {
			Assert.assertTrue(allExhTotalProdDisplay.isDisplayed());
		}
		System.out.println("Displayed All Exhibitors Total Product Section");

		// Verify All Exhibitors Location Links
		for (WebElement allExhLocationLinksDisplay : atlgs.getatlListOfAllExhLocation()) {
			Assert.assertTrue(allExhLocationLinksDisplay.isDisplayed());
		}
		System.out.println("Displayed All Exhibitors Location Links");

		// Select Exhibitor and Product Info
		selectAMC.selectByVisibleText("Exhibitor and Product Info");
		Thread.sleep(8000);
		// Verify All Exhibitor Titles
		for (WebElement allExhDisply : atlgs.getatlListOfAllExh()) {
			Assert.assertTrue(allExhDisply.isDisplayed());
		}
		System.out.println("Displayed All Exhibitors Title");

		// Verify All Exhibitors Total Product Section
		for (WebElement allExhTotalProdDisplay : atlgs.getatlListOfAllExhTotalProductLink()) {
			Assert.assertTrue(allExhTotalProdDisplay.isDisplayed());
		}
		System.out.println("Displayed All Exhibitors Total Product Section");

		// Verify All Exhibitors Matching Product Section
		for (WebElement allExhMatchingProdDisplay : atlgs.getatlListOfAllExhMatchingProductLink()) {
			Assert.assertTrue(allExhMatchingProdDisplay.isDisplayed());
		}
		System.out.println("Displayed All Exhibitors Total Product Section");

		// Verify All Exhibitors Location Links
		for (WebElement allExhLocationLinksDisplay : atlgs.getatlListOfAllExhLocation()) {
			Assert.assertTrue(allExhLocationLinksDisplay.isDisplayed());
		}
		System.out.println("Displayed All Exhibitors Location Links");
		// Verify All Exhibitors Location Links
		for (WebElement allProductDisplay : atlgs.getatlListOfAllProducts()) {
			Assert.assertTrue(allProductDisplay.isDisplayed());
		}
		System.out.println("Displayed All Products");

		// Select Product Info Only
		selectAMC.selectByVisibleText("Product Info Only");
		Thread.sleep(8000);
		// Verify All Exhibitor Titles
		for (WebElement allExhDisply : atlgs.getatlListOfAllExh()) {
			Assert.assertTrue(allExhDisply.isDisplayed());
		}
		System.out.println("Displayed All Exhibitors Title");

		// Verify All Exhibitors Total Product Section
		for (WebElement allExhTotalProdDisplay : atlgs.getatlListOfAllExhTotalProductLink()) {
			Assert.assertTrue(allExhTotalProdDisplay.isDisplayed());
		}
		System.out.println("Displayed All Exhibitors Total Product Section");

		// Verify All Exhibitors Matching Product Section
		for (WebElement allExhMatchingProdDisplay : atlgs.getatlListOfAllExhMatchingProductLink()) {
			Assert.assertTrue(allExhMatchingProdDisplay.isDisplayed());
		}
		System.out.println("Displayed All Exhibitors Total Product Section");

		// Verify All Exhibitors Location Links
		for (WebElement allExhLocationLinksDisplay : atlgs.getatlListOfAllExhLocation()) {
			Assert.assertTrue(allExhLocationLinksDisplay.isDisplayed());
		}
		System.out.println("Displayed All Exhibitors Location Links");
		// Verify All Exhibitors Location Links
		for (WebElement allProductDisplay : atlgs.getatlListOfAllProducts()) {
			Assert.assertTrue(allProductDisplay.isDisplayed());
		}
		System.out.println("Displayed All Products");

	}

	@Test(priority = 3)
	public void TS003_VerifyGlobalSearchMatchingResultsSortSortByTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T335: Global Search: Matching results-Sort- Sort By

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("sortByInput"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);
		// Click on Sort Btn
		atlgs.getatlGlobalSearchSortBtn().click();

		// Select Exhibitor Sort By Relevance
		Select selectAMC = new Select(atlgs.getatlGlobalSearch_SearchSortByDropdwn());
		selectAMC.selectByVisibleText("Sort By Relevance");
		Thread.sleep(8000);
		// Verify All Exhibitor Titles
		/*
		 * for (WebElement allExhDisply : atlgs.getatlListOfAllExh()) {
		 * Assert.assertTrue(allExhDisply.isDisplayed()); }
		 */
		System.out.println("Displayed All Relevance ");

		utl.Sorting(atlgs.getatlGlobalSearchExhLocationList(), atlgs.getatlGlobalSearch_SearchSortByDropdwn(),
				"Sort by Location Ascending");
		utl.Sorting(atlgs.getatlGlobalSearchExhLocationList(), atlgs.getatlGlobalSearch_SearchSortByDropdwn(),
				"Sort by Location Descending");
		// utl.Sorting(atlgs.getatlExhNames(),atlgs.getatlGlobalSearch_SearchSortByDropdwn(),"Sort
		// by Name Ascending");
		// utl.Sorting(atlgs.getatlExhNames(),atlgs.getatlGlobalSearch_SearchSortByDropdwn(),"Sort
		// by Name Descending");
		utl.Sorting(atlgs.getatlMachingProductCount(), atlgs.getatlGlobalSearch_SearchSortByDropdwn(),
				"Sort By Matching Product Count Descending");

	}

	@Test(priority = 4)
	public void TS004_VerifyGlobalSearchMatchingResultsSortFilterByNameTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T336: Global Search: Matching results- Sort- Filter By Name

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("sortByInput"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);
		// Click on Sort Btn
		atlgs.getatlGlobalSearchSortBtn().click();

		// Select Exhibitor Sort By Relevance

		Select selectLetter = new Select(atlgs.getatlFilterByNameDropDown());
		selectLetter.selectByVisibleText("R");
		Thread.sleep(8000);
		for (WebElement filterExhNames : atlgs.getatlExhiNameForFilterByName()) {
			Assert.assertTrue(filterExhNames.isDisplayed());
		}

		System.out.println("Displayed All Relevance ");

	}

	@Test(priority = 5)
	public void TS005_VerifyGlobalSearchMatchingResultsSelectAddToFavoritesTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T330: Global Search: Matching results- Select- Add to Favorites

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);
		// Click on Select Btn
		atlgs.getatlGlobalSearchSelectBtn().click();
		// Select 1st checkbox from searched result
		atlgs.getatlGlobalSearchExhCheckbox().click();
		String exhName = atlgs.getatl1STExhiName().getText();
		System.out.println(exhName);
		// Click on Add to fav Btn
		atlgs.getatlGlobalSearchAddToFavBtn().click();

		// Sign In to MP
		// Enter the credentials on Login Page and click
		lp.getEmailAddress().sendKeys((prop.getProperty("username")));
		lp.getPassword().sendKeys((prop.getProperty("password")));

		lp.getSignInBtn().click();
		Thread.sleep(15000);
		// Click on Market Planner
		lap.getMPLinkText().click();
		Thread.sleep(6000);

		// Click on List tab
		atlmppge.getMPHomeListsTab().click();
		Thread.sleep(10000);
		// Verify Exhibitor present or not into MP Fav
		utl.checkItemPresentInListorNot(atlmppge.getlistOfAllExh(), exhName);

	}

	@Test(priority = 6)
	public void TS006_VerifyGlobalSearchMatchingResultsSelectAddToExistingListTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T331: Global Search: Matching results- Select- Add to Existing List

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		utl.verifyMPLoginFunctionality();
		Thread.sleep(5000);
		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));
		Thread.sleep(5000);
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);
		// Click on Select Btn
		atlgs.getatlGlobalSearchSelectBtn().click();
		// Select 1st checkbox from searched result
		atlgs.getatlGlobalSearchExhCheckbox().click();
		String exhName = atlgs.getatl1STExhiName().getText();
		System.out.println(exhName);
		// Click on Add to Selected List Btn
		atlgs.getatlAddToExistingList().click();
		// Select Exiting List
		atlgs.getatlExistingList().click();
		// Click Add to List Btn
		atlgs.getatlAddToSelectBtn().click();
		// CLick on Go To MP Btn
		atlgs.getatlGoToMPBtn().click();

		// Click on Market Planner
		lap.getMPLinkText().click();
		Thread.sleep(6000);

		// Click on List tab
		atlmppge.getMPHomeListsTab().click();
		Thread.sleep(10000);
		// Click on List from left Panel
		atlmppge.getMpListLeftPannel().click();
		// Verify Exhibitor present or not into MP Fav
		utl.checkItemPresentInListorNot(atlmppge.getlistOfAllExh(), exhName);

		/*
		 * // Sign In to MP // Enter the credentials on Login Page and click
		 * lp.getEmailAddress().sendKeys((prop.getProperty("username")));
		 * lp.getPassword().sendKeys((prop.getProperty("password")));
		 * 
		 * lp.getSignInBtn().click(); Thread.sleep(15000); // Click on Market Planner
		 * lap.getMPLinkText().click(); Thread.sleep(6000);
		 * 
		 * // Click on List tab atlmppge.getMPHomeListsTab().click();
		 * Thread.sleep(10000); //Verify Exhibitor present or not into MP Fav
		 * utl.checkItemPresentInListorNot(atlmppge.getlistOfAllExh(),exhName );
		 */
	}

	@AfterClass
	public void tearDown() {
		// driver.quit();
	}
}
