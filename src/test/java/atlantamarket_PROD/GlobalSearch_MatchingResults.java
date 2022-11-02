package atlantamarket_PROD;

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
import org.testng.xml.LaunchSuite.ExistingSuite;

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
		atlgs=new ATLGlobalSearchPage(driver);
		
		// Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("atlmrkturl_prod"));
		
		lap.getIUnderstandBtn().click();
		Thread.sleep(5000);
		utl.CloseATLPopup();
		
		//lap.getCloseMarktAdBtn().click();
		
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
		
		if(!atlgs.getATLGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			atlgs.getatlGlobalSearchClearTxt().click();
		}
	
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
		
		if(!atlgs.getATLGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			atlgs.getatlGlobalSearchClearTxt().click();
		}
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
		System.out.println("Displayed All Relevance ");

		//Location Filters
		/*utl.Sorting(atlgs.getatlGlobalSearchExhLocationList(), atlgs.getatlGlobalSearch_SearchSortByDropdwn(),
				"Sort by Name Ascending");
		utl.Sorting(atlgs.getatlGlobalSearchExhLocationList(), atlgs.getatlGlobalSearch_SearchSortByDropdwn(),
				"Sort by Name Descending");*/
		
		 //Select filter Sort by Name Ascending
		 /*utl.Sorting(atlgs.getatlExhNames(),atlgs.getatlGlobalSearch_SearchSortByDropdwn(),"Sort by Name Ascending");
		  //Select filter Sort by Name Descending
		 utl.Sorting(atlgs.getatlExhNames(),atlgs.getatlGlobalSearch_SearchSortByDropdwn(),"Sort by Name Descending");*/
		
		//Select filter Sort by Matching Product Count Descending
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
		if(!atlgs.getATLGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			atlgs.getatlGlobalSearchClearTxt().click();
		}
		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("filterByInput"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);
		// Click on Sort Btn
		atlgs.getatlGlobalSearchSortBtn().click();

		// Select Character from Sort By Filter Name
		
		Select selectLetter = new Select(atlgs.getatlFilterByNameDropDown());
		selectLetter.selectByVisibleText("P");
		Thread.sleep(8000);
		for (WebElement filterExhNames : atlgs.getatlExhiNameForFilterByName()) {
			//Assert.assertTrue(filterExhNames.isDisplayed());
			
			String expName=filterExhNames.getText();
			boolean flag=false;
			char fChar=expName.charAt(0);
			String s=""+fChar;
			System.out.println(fChar);
			
				System.out.println("String "+s);
				Assert.assertTrue(s.contains("P"));
			
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
		utl.verifyMPLoginFunctionality();
		utl.CloseATLPopup();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if(!atlgs.getATLGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			atlgs.getatlGlobalSearchClearTxt().click();
		}
		utl.verifyMPLoginFunctionality();
		utl.CloseATLPopup();
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

		/*// Sign In to MP
		// Enter the credentials on Login Page and click
<<<<<<< HEAD
		lp.getEmailAddress().sendKeys((prop.getProperty("username")));
		lp.getPassword().sendKeys((prop.getProperty("password")));

		lp.getSignInBtn().click();
		Thread.sleep(15000);*/
=======
		//lp.getEmailAddress().sendKeys((prop.getProperty("username")));
		//lp.getPassword().sendKeys((prop.getProperty("password")));
		//lp.getSignInBtn().click();
		//Thread.sleep(15000);
		Thread.sleep(5000);
>>>>>>> 4416732d66161525947da42761bcfffa9ea0a294
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

		//utl.verifyMPLoginFunctionality();
		utl.CloseATLPopup();
		//atlgs.getatlGlobalSearchClearTxt().click();
		if(!atlgs.getATLGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			atlgs.getatlGlobalSearchClearTxt().click();
		}
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
		String exList = atlgs.getatlExistingList().getText();
		System.out.println(exList);
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
		// Open selected list
		utl.ClickOnEditBtnOfAnyList(atlmppge.getallList(), exList);
		// Verify exhibitor present into selected list or not
		utl.checkItemPresentInListorNot(atlmppge.getlistOfAllExh(), exhName);

	}

	@Test(priority = 7)
	public void TS007_VerifyGlobalSearchMatchingResultsSelectAddToNewlyCreatedListTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T424: Global Search: Matching results- Select- Add to newly created list

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//utl.verifyMPLoginFunctionality();
		utl.CloseATLPopup();
		if(!atlgs.getATLGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			atlgs.getatlGlobalSearchClearTxt().click();
		}
		Thread.sleep(5000);
		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));
		Thread.sleep(5000);
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);
		String exhName = atlgs.getatl1STExhiName().getText();
		System.out.println(exhName);
		// Click on Select Btn
		atlgs.getatlGlobalSearchSelectBtn().click();
		// Select 1st checkbox from searched result
		atlgs.getatlGlobalSearchExhCheckbox().click();
		
		// Click on Add to Selected List Btn
		atlgs.getatlAddToExistingList().click();
		String lName = genData.generateRandomString(10);
		atlmppge.getCreateNewListNameTxtbx().sendKeys(lName);
		// atlmppge.getCreateNewListNameTxtbx().sendKeys();
		atlmppge.getNewListModalCreateBtn().click();
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
		// Open selected list
		utl.ClickOnEditBtnOfAnyList(atlmppge.getallList(), lName);
		// Verify exhibitor present into selected list or not
		Thread.sleep(6000);
		utl.checkItemPresentInListorNot(atlmppge.getlistOfAllExh(), exhName);

	}

	@Test(priority = 8)
	public void TS008_VerifyGlobalSearchMatchingResultsUsePreviousSavedSearchTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T329: Global Search: Matching results- Use previous saved Search

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		
		if(!atlgs.getATLGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			atlgs.getatlGlobalSearchClearTxt().click();
		}
		//utl.verifyMPLoginFunctionality();
		
		utl.CloseATLPopup();
		
		
		try {
			atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("savedSearchesInput"));
			Thread.sleep(3000);
			atlgs.getATLSearchButton().click();
			Thread.sleep(5000);
			// Click on Save Searches Btn
			atlgs.getatlSavedSearchesIcon().click();
			Select selectSavedSearched = new Select(atlgs.getatlSavedSearchesDropdown());
			selectSavedSearched.selectByIndex(1);
			String optin = selectSavedSearched.getOptions().get(1).getText();
			System.out.println(optin);
		//	Assert.assertTrue(atlgs.getATLInfosearchtxtbx().getAttribute("value").contains(optin));
			Thread.sleep(5000);
			Assert.assertTrue(atlgs.getATLVerifyGlobalSeacrh().getText().contains(optin));
			
		} catch (Exception e) {
			
			if(!atlgs.getATLGlobalSearchTextBox().getAttribute("value").isEmpty()) {
				atlgs.getatlGlobalSearchClearTxt().click();
			}
			atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("savedSearchesInput"));
			Thread.sleep(3000);
			atlgs.getATLSearchButton().click();
			Thread.sleep(5000);
			// Click on Save Searches Btn
			atlgs.getatlSavedSearchesIcon().click();
			//Click on Save Seach btn
			atlgs.getatlSavedSearchesBtn().click();
			
			String savedSearchesInput=prop.getProperty("savedSearchesInput");
			//Enter Search name into input box
			atlgs.getatlSavedSearchesInputBox().sendKeys(savedSearchesInput);
			//Click on Save Search Btn 
			atlgs.getatlSavedSearchesBtnForNewSaved().click();
			//Goto Home page
			driver.get(prop.getProperty("atlmrkturl_prod"));
			//Click on saved Searches btn
			atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));
			Thread.sleep(5000);
			atlgs.getATLSearchButton().click();
			atlgs.getatlSavedSearchesIcon().click();
			//Select Saved Search from List
			Select selectSavedSearched = new Select(atlgs.getatlSavedSearchesDropdown());
			selectSavedSearched.selectByVisibleText(savedSearchesInput);
			//Vrfify Saved Searches output resultss
			Assert.assertTrue(atlgs.getATLInfosearchtxtbx().getAttribute("value").contains(prop.getProperty("savedSearchesInput")));
			Thread.sleep(5000);
			Assert.assertTrue(atlgs.getATLVerifyGlobalSeacrh().getText().contains(prop.getProperty("savedSearchesInput")));
		}

	}

	@Test(priority = 9)
	public void TS009_VerifyGlobalSearchMatchingResultsSavedSearchesTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T355: Global Search: Matching results -Saved Searches

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		if(!atlgs.getATLGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			atlgs.getatlGlobalSearchClearTxt().click();
		}
		//utl.verifyMPLoginFunctionality();
		utl.CloseATLPopup();
		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("savedSearchesInput"));
		Thread.sleep(3000);
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);
		// Click on Save Searches Btn
		atlgs.getatlSavedSearchesIcon().click();
		//Click on Save Seach btn
		atlgs.getatlSavedSearchesBtn().click();
		
		String savedSearchesInput=prop.getProperty("savedSearchesInput");
		//Enter Search name into input box
		atlgs.getatlSavedSearchesInputBox().sendKeys(savedSearchesInput);
		//Click on Save Search Btn 
		atlgs.getatlSavedSearchesBtnForNewSaved().click();
		atlgs.getatlSelectList().click();
		
		utl.checkItemPresentInListorNot(atlgs.getatlListOfAllSavedSearches(),savedSearchesInput);
		
	}

}
