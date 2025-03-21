package atlantamarket_UAT;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
import pageObjects.LasVegasMarket.LVMGlobalSearchPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

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
	LVMGlobalSearchPage lvmgs;

	List<WebElement> exhlist, linelist, prodlist, searchexhtypelist, searchproducttypelist, mplists, mpeditlistoptns,
			allnoteslist, favlist, searchlinetypelist, tagBlogPost, taglist, infoFilterList;

	@BeforeClass(alwaysRun=true)
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		// chromeVersion();
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);
		atlgs=new ATLGlobalSearchPage(driver);
		
		// Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("atlmrkturl_uat"));
		
		lap.getIUnderstandBtn().click();
		Thread.sleep(5000);
		utl.CloseATLPopup();
		
		//lap.getCloseMarktAdBtn().click();
		
	}

	@Test(priority = 1)//groups="Non_MP"
	public void TS001_VerifyGlobalSearchContainsAndStartsWithTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T436: Verify Global Search: Contains and Starts With
		//Blocked- Unclear about the acceptance criteria
		
		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//driver.get(prop.getProperty("atlmrkturl_uat"));
		//utl.loginCheckATL();
		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("containsStartWithInput"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);

		
		
		Assert.assertTrue(atlgs.getATLSearchResult().getText().contains(prop.getProperty("containsStartWithInput")));
		
		System.out.println("Displayed All Products Name Start with :: " + prop.getProperty("containsStartWithInput"));
		
	}

	@Test(priority = 2)//groups="Non_MP"
	public void TS002_VerifyGlobalSearchMatchingResultsSortWithinTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T673: Global Search: Matching results- Sort- Search Within

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		driver.get(prop.getProperty("atlmrkturl_uat"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		if(!atlgs.getATLGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			atlgs.getatlGlobalSearchClearTxt().click();
		}
	
		Thread.sleep(5000);
		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);
		// Click on Sort Btn
		atlgs.getatlGlobalSearchSortBtnNew().click();

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

	@Test(priority = 3)//groups="Non_MP"
	public void TS003_VerifyGlobalSearchMatchingResultsSortSortByTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T335: Global Search: Matching results-Sort- Sort By
		//Open bug- UXP-1991
	  
		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lvmgs = new LVMGlobalSearchPage(driver);
		utl = new Utility(driver);

		driver.get(prop.getProperty("atlmrkturl_uat"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		if(!atlgs.getATLGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			atlgs.getatlGlobalSearchClearTxt().click();
		}

		Thread.sleep(5000);
		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("globalsearch_input"));
		Thread.sleep(5000);

		atlgs.getATLSearchButton().click();
		Thread.sleep(7000);
		// Click on Sort Btn
		atlgs.getatlGlobalSearchSortBtnNewUAT().click();

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
		 utl.Sorting(atlgs.getatlExhNames(),atlgs.getatlGlobalSearch_SearchSortByDropdwn(),"Sort by Name Ascending");
		 ///Select filter Sort by Name Descending
		 utl.Sorting(atlgs.getatlExhNames(),atlgs.getatlGlobalSearch_SearchSortByDropdwn(),"Sort by Name Descending");
		//Select filter Sort by Matching Product Count Ascending
		
			selectAMC.selectByVisibleText("Sort By Relevance");
		 Thread.sleep(5000);
		 System.out.println("----Sort By Matching Product Count Ascending--");
		 utl.Sorting(atlgs.getatlMachingProductCount(), atlgs.getatlGlobalSearch_SearchSortByDropdwn(),
					"Sort By Matching Product Count Ascending");
		 System.out.println("----Sort By Matching Product Count Descending--");
		 Thread.sleep(3000);
		 utl.Sorting(atlgs.getatlMachingProductCount(), atlgs.getatlGlobalSearch_SearchSortByDropdwn(),
					"Sort By Matching Product Count Descending");

	}

	@Test(priority = 4)//groups=\"Non_MP"
	public void TS004_VerifyGlobalSearchMatchingResultsSortFilterByNameTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T336: Global Search: Matching results- Sort- Filter By Name

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.get(prop.getProperty("atlmrkturl_uat"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		if(!atlgs.getATLGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			atlgs.getatlGlobalSearchClearTxt().click();
		}
		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);
		// Click on Sort Btn
		atlgs.getatlGlobalSearchSortBtnNew().click();
		Thread.sleep(1000);
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
			Assert.assertTrue(s.contains("P"));
			
		}

		System.out.println("Displayed All Relevance ");

	}
	   @Test(enabled=false)
	    public void verifyMPLoginFunctionality() throws IOException, InterruptedException {

	        // The purpose of this test case to verify:-
	        // TS1- Login to Market Planner

	        lap = new ATLLandingPage(driver);
	        lp = new ATLLoginPage(driver);

	        // Click on Login button from Landing Page
	        lap.getLogin().click();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        // Enter the credentials on Login Page and click
	        lp.getEmailAddress().sendKeys((prop.getProperty("username")));

	        lp.getPassword().sendKeys((prop.getProperty("passwordW")));


	        Thread.sleep(1000);
	    //  lp.getPassword().sendKeys((prop.getProperty("password")));
	        Thread.sleep(1000);

	        lp.getSignInBtn().click();
	        Thread.sleep(15000);
	        Assert.assertTrue(driver.getTitle().contains("Atlanta Market at AmericasMart"));
	    }

	@Test(enabled=false)//priority = 5,groups= "MP_Group",dependsOnMethods= "verifyMPLoginFunctionality"
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

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		if(!atlgs.getATLGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			atlgs.getatlGlobalSearchClearTxt().click();
		}
		////utl.verifyMPLoginFunctionality();
		utl.loginCheckATL();
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
		lp.getEmailAddress().sendKeys((prop.getProperty("username")));
		lp.getPassword().sendKeys((prop.getProperty("password")));

		lp.getSignInBtn().click();
		Thread.sleep(15000);*/
		// Click on Market Planner
		lap.getMPLinkText().click();
		Thread.sleep(6000);

		// Click on List tab
		atlmppge.getMPHomeListsTab().click();
		Thread.sleep(10000);
		// Verify Exhibitor present or not into MP Fav
		utl.checkItemPresentInListorNot(atlmppge.getlistOfAllExh(), exhName);

	}

	@Test(enabled=false)//priority = 6,groups= "MP_Group",dependsOnMethods= "verifyMPLoginFunctionality"
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

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//utl.verifyMPLoginFunctionality();
		utl.loginCheckATL();
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

	@Test(enabled=false)//priority = 7,groups= "MP_Group",dependsOnMethods= "verifyMPLoginFunctionality"
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

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	//	//utl.verifyMPLoginFunctionality();
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
		try {
		utl.checkItemPresentInListorNot(atlmppge.getlistOfAllExh(), exhName);
		}catch (Exception e) {
			// TODO: handle exception
		utl.checkItemPresentInListorNot(atlmppge.getlistOfAllExhPROD(), exhName);
		
		}
	}

	@Test(enabled=false)//priority = 8,groups="Non_MP"
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

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		
		if(!atlgs.getATLGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			atlgs.getatlGlobalSearchClearTxt().click();
		}
		////utl.verifyMPLoginFunctionality();
		
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
			driver.get(prop.getProperty("atlmrkturl_uat"));
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

	@Test(enabled=false)//priority = 9,groups="Non_MP"
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

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		if(!atlgs.getATLGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			atlgs.getatlGlobalSearchClearTxt().click();
		}
		////utl.verifyMPLoginFunctionality();
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
	@AfterClass(alwaysRun=true)
	public void tearDown()
	{
		//driver.quit();
	}

}