package lasvegasmarket_PROD;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.LasVegasMarket.LVMExhDigiShowroomPage;
import pageObjects.LasVegasMarket.LVMExhLineProdActionsPage;
import pageObjects.LasVegasMarket.LVMGlobalSearchPage;
import pageObjects.LasVegasMarket.LVMLandingPage;
import pageObjects.LasVegasMarket.LVMLeftPaneFilters;
import pageObjects.LasVegasMarket.LVMLoginPage;
import pageObjects.LasVegasMarket.LVMMarketPlannerPage;
import pageObjects.LasVegasMarket.LVMProductDetailsPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

public class GlobalSearch_MatchingResults extends base {
	
	public WebDriverWait wait;
	public GenerateData genData;
	public Utility utl;
	public String exhname;
	LVMLoginPage lp;
	LVMLandingPage lap;
	LVMGlobalSearchPage lvmgs;
	LVMExhDigiShowroomPage lvmds;
	LVMProductDetailsPage lvmproddet;
	LVMExhLineProdActionsPage lvmexhact;
	LVMMarketPlannerPage lvmmpp;
	LVMLeftPaneFilters lvmleftpane;

	@BeforeClass
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		// chromeVersion();
		utl = new Utility(driver);
		lap = new LVMLandingPage(driver);
		lvmgs=new LVMGlobalSearchPage(driver);
		
		// Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		lap.getIUnderstandBtn().click();
		Thread.sleep(5000);
		utl.CloseATLPopup();
		Thread.sleep(2000);
/*		utl.verifyMPLoginFunctionality();
		Thread.sleep(5000);
		utl.loginCheckLVM();*/
		//lap.getCloseMarktAdBtn().click();
	}
	
	@Test(priority = 1)
	public void TS001_VerifyGlobalSearchContainsAndStartsWithTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T814: Verify Global Search: Contains and Starts With
		//Blocked- Unclear about the acceptance criteria
		
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("exhibitor5"));//containsStartWithInput
		Thread.sleep(1000);
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(4000);
		
		Assert.assertTrue(lvmgs.getLVMSearchResult().getText().contains(prop.getProperty("exhibitor5")));
		System.out.println("Displayed All Products Name Start with :: " + prop.getProperty("exhibitor5"));
		driver.get(prop.getProperty("lvmurl_prod"));
	}
	
	@Test(priority = 2)
	public void TS002_VerifyGlobalSearchMatchingResultsSortWithinTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T673: Global Search: Matching results- Sort- Search Within

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	/*	if(!lvmgs.getLVMGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			lvmgs.getlvmGlobalSearchClearTxt().click();
		}*/
		Thread.sleep(5000);
		lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("exhibitor5"));//filtersglobalsearchinput
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(5000);
		// Click on Sort Btn
		lvmgs.getlvmGlobalSearchSortBtn().click();
		
		// Select Exhibitor Info Only
		Select selectAMC = new Select(lvmgs.getlvmGlobalSearch_SearchWithinDropdwn());
		selectAMC.selectByVisibleText("Exhibitor Info Only");
		Thread.sleep(8000);
		
		// Verify All Exhibitor Titles
		for (WebElement allExhDisply : lvmgs.getlvmListOfAllExh()) {
			Assert.assertTrue(allExhDisply.isDisplayed());
		}
		System.out.println("Displayed All Exhibitors Title");

		// Verify All Exhibitors Total Product Section
		for (WebElement allExhTotalProdDisplay : lvmgs.getlvmListOfAllExhTotalProductLink()) {
			Assert.assertTrue(allExhTotalProdDisplay.isDisplayed());
		}
		System.out.println("Displayed All Exhibitors Total Product Section");

		// Verify All Exhibitors Location Links
		for (WebElement allExhLocationLinksDisplay : lvmgs.getlvmListOfAllExhLocation()) {
			Assert.assertTrue(allExhLocationLinksDisplay.isDisplayed());
		}
		System.out.println("Displayed All Exhibitors Location Links");

		// Select Exhibitor and Product Info
		selectAMC.selectByVisibleText("Exhibitor and Product Info");
		Thread.sleep(8000);
		
		// Verify All Exhibitor Titles
		for (WebElement allExhDisply : lvmgs.getlvmListOfAllExh()) {
			Assert.assertTrue(allExhDisply.isDisplayed());
		}
		System.out.println("Displayed All Exhibitors Title");

		// Verify All Exhibitors Total Product Section
		for (WebElement allExhTotalProdDisplay : lvmgs.getlvmListOfAllExhTotalProductLink()) {
			Assert.assertTrue(allExhTotalProdDisplay.isDisplayed());
		}
		System.out.println("Displayed All Exhibitors Total Product Section");

		// Verify All Exhibitors Matching Product Section
		for (WebElement allExhMatchingProdDisplay : lvmgs.getlvmListOfAllExhMatchingProductLink()) {
			Assert.assertTrue(allExhMatchingProdDisplay.isDisplayed());
		}
		System.out.println("Displayed All Exhibitors Total Product Section");

		// Verify All Exhibitors Location Links
		for (WebElement allExhLocationLinksDisplay : lvmgs.getlvmListOfAllExhLocation()) {
			Assert.assertTrue(allExhLocationLinksDisplay.isDisplayed());
		}
		System.out.println("Displayed All Exhibitors Location Links");
		
		// Verify All Exhibitors Location Links
		for (WebElement allProductDisplay : lvmgs.getlvmListOfAllProducts()) {
			Assert.assertTrue(allProductDisplay.isDisplayed());
		}
		System.out.println("Displayed All Products");

		// Select Product Info Only
		selectAMC.selectByVisibleText("Product Info Only");
		Thread.sleep(8000);
		
		// Verify All Exhibitor Titles
		for (WebElement allExhDisply : lvmgs.getlvmListOfAllExh()) {
			Assert.assertTrue(allExhDisply.isDisplayed());
		}
		System.out.println("Displayed All Exhibitors Title");

		// Verify All Exhibitors Total Product Section
		for (WebElement allExhTotalProdDisplay : lvmgs.getlvmListOfAllExhTotalProductLink()) {
			Assert.assertTrue(allExhTotalProdDisplay.isDisplayed());
		}
		System.out.println("Displayed All Exhibitors Total Product Section");

		// Verify All Exhibitors Matching Product Section
		for (WebElement allExhMatchingProdDisplay : lvmgs.getlvmListOfAllExhMatchingProductLink()) {
			Assert.assertTrue(allExhMatchingProdDisplay.isDisplayed());
		}
		System.out.println("Displayed All Exhibitors Total Product Section");

		// Verify All Exhibitors Location Links
		for (WebElement allExhLocationLinksDisplay : lvmgs.getlvmListOfAllExhLocation()) {
			Assert.assertTrue(allExhLocationLinksDisplay.isDisplayed());
		}
		System.out.println("Displayed All Exhibitors Location Links");
		
		// Verify All Exhibitors Location Links
		for (WebElement allProductDisplay : lvmgs.getlvmListOfAllProducts()) {
			Assert.assertTrue(allProductDisplay.isDisplayed());
		}
		System.out.println("Displayed All Products");
		driver.get(prop.getProperty("lvmurl_prod"));
	}
	
	@Test(priority = 3)
	public void TS003_VerifyGlobalSearchMatchingResultsSortSortByTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T676: Global Search: Matching results-Sort- Sort By
		//Open bug- UXP-1991

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		if(!lvmgs.getLVMGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			lvmgs.getlvmGlobalSearchClearTxt().click();
		}
		lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("exhibitor5"));//sortByInput
		Thread.sleep(2000);
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(5000);
		// Click on Sort Btn
		lvmgs.getlvmGlobalSearchSortBtn().click();

		// Select Exhibitor Sort By Relevance
		Select selectAMC = new Select(lvmgs.getlvmGlobalSearch_SearchSortByDropdwn());
		selectAMC.selectByVisibleText("Sort By Relevance");
		Thread.sleep(8000);
		// Verify All Exhibitor Titles
		System.out.println("Displayed All Relevance ");
		Thread.sleep(7000);
		//Location Filters
		/*utl.Sorting(lvmgs.getlvmGlobalSearchExhLocationList(), lvmgs.getlvmGlobalSearch_SearchSortByDropdwn(),
				"Sort by Name Ascending");
		utl.Sorting(lvmgs.getlvmGlobalSearchExhLocationList(), lvmgs.getlvmGlobalSearch_SearchSortByDropdwn(),
				"Sort by Name Descending");*/
		///Select filter Sort by Name Descending
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 //Select filter Sort by Name Ascending
		 utl.Sorting(lvmgs.getlvmExhNames(),lvmgs.getlvmGlobalSearch_SearchSortByDropdwn(),"Sort by Name Ascending");
		 Thread.sleep(2000);
		 utl.Sorting(lvmgs.getlvmExhNames(),lvmgs.getlvmGlobalSearch_SearchSortByDropdwn(),"Sort by Name Descending");
		
		//Select filter Sort by Matching Product Count Descending
		utl.Sorting(lvmgs.getlvmMachingProductCount(), lvmgs.getlvmGlobalSearch_SearchSortByDropdwn(),
				"Sort By Matching Product Count Descending");
		driver.get(prop.getProperty("lvmurl_prod"));
	}
	
	@Test(priority = 4)
	public void TS004_VerifyGlobalSearchMatchingResultsSortFilterByNameTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T677: Global Search: Matching results- Sort- Filter By Name

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if(!lvmgs.getLVMGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			lvmgs.getlvmGlobalSearchClearTxt().click();
		}
		lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("exhibitor5"));//filterByInput
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(5000);
		// Click on Sort Btn
		lvmgs.getlvmGlobalSearchSortBtn().click();

		// Select Character from Sort By Filter Name
		Select selectLetter = new Select(lvmgs.getlvmFilterByNameDropDown());
		selectLetter.selectByVisibleText("P");
		Thread.sleep(8000);
		for (WebElement filterExhNames : lvmgs.getlvmExhiNameForFilterByNameNew()) {
			//Assert.assertTrue(filterExhNames.isDisplayed());
			
			String expName=filterExhNames.getText();
			System.out.println(expName);
			boolean flag=false;
			char fChar=expName.charAt(0);
			String s=""+fChar;
			System.out.println(s);
			Assert.assertTrue(s.contains("P"));
		}
		System.out.println("Displayed All Relevance ");
		driver.get(prop.getProperty("lvmurl_prod"));
	}
	
	@Test(enabled=false)//priority = 5
	public void TS005_VerifyGlobalSearchMatchingResultsSelectAddToFavoritesTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T330: Global Search: Matching results- Select- Add to Favorites

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lap = new LVMLandingPage(driver);
		lp = new LVMLoginPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if(!lvmgs.getLVMGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			lvmgs.getlvmGlobalSearchClearTxt().click();
		}
		//utl.verifyMPLoginFunctionality();
		utl.CloseATLPopup();
		lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("exhibitor5"));//filtersglobalsearchinput
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(5000);
		// Click on Select Btn
		lvmgs.getlvmGlobalSearchSelectBtn().click();
		// Select 1st checkbox from searched result
		lvmgs.getlvmGlobalSearchExhCheckbox().click();
		String exhName = lvmgs.getlvm1STExhiName().getText();
		System.out.println(exhName);
		// Click on Add to fav Btn
		lvmgs.getlvmGlobalSearchAddToFavBtn().click();

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
		lvmmpp.getMPHomeListsTab().click();
		Thread.sleep(10000);
		// Verify Exhibitor present or not into MP Fav
		utl.checkItemPresentInListorNot(lvmmpp.getlistOfAllExh(), exhName);
		driver.get(prop.getProperty("lvmurl_prod"));
	}
	
	@Test(enabled=false)//priority = 6
	public void TS006_VerifyGlobalSearchMatchingResultsSelectAddToExistingListTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T331: Global Search: Matching results- Select- Add to Existing List

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lap = new LVMLandingPage(driver);
		lp = new LVMLoginPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//utl.verifyMPLoginFunctionality();
		utl.CloseATLPopup();
		//lvmgs.getlvmGlobalSearchClearTxt().click();
		if(!lvmgs.getLVMGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			lvmgs.getlvmGlobalSearchClearTxt().click();
		}
		lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));//filtersglobalsearchinput
		Thread.sleep(5000);
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(5000);
		// Click on Select Btn
		lvmgs.getlvmGlobalSearchSelectBtn().click();
		// Select 1st checkbox from searched result
		lvmgs.getlvmGlobalSearchExhCheckbox().click();
		String exhName = lvmgs.getlvm1STExhiName().getText();
		System.out.println(exhName);
		// Click on Add to Selected List Btn
		lvmgs.getlvmAddToExistingList().click();
		// Select Exiting List
		String exList = lvmgs.getlvmExistingList().getText();
		System.out.println(exList);
		lvmgs.getlvmExistingList().click();
		// Click Add to List Btn
		lvmgs.getlvmAddToSelectBtn().click();
		// CLick on Go To MP Btn
		lvmgs.getlvmGoToMPBtn().click();

		// Click on Market Planner
		lap.getMPLinkText().click();
		Thread.sleep(6000);

		// Click on List tab
		lvmmpp.getMPHomeListsTab().click();
		Thread.sleep(10000);
		// Click on List from left Panel
		lvmmpp.getMpListLeftPannel().click();
		// Open selected list
		utl.ClickOnEditBtnOfAnyList(lvmmpp.getallList(), exList);
		// Verify exhibitor present into selected list or not
		utl.checkItemPresentInListorNot(lvmmpp.getlistOfAllExh(), exhName);
		driver.get(prop.getProperty("lvmurl_prod"));
	}
	
	@Test(enabled=false)//priority = 7
	public void TS007_VerifyGlobalSearchMatchingResultsSelectAddToNewlyCreatedListTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T424: Global Search: Matching results- Select- Add to newly created list

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lap = new LVMLandingPage(driver);
		lp = new LVMLoginPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//utl.verifyMPLoginFunctionality();
		utl.CloseATLPopup();
		if(!lvmgs.getLVMGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			lvmgs.getlvmGlobalSearchClearTxt().click();
		}
		Thread.sleep(5000);
		lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("exhibitor5"));//filtersglobalsearchinput
		Thread.sleep(5000);
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(5000);
		String exhName = lvmgs.getlvm1STExhiName().getText();
		System.out.println(exhName);
		// Click on Select Btn
		lvmgs.getlvmGlobalSearchSelectBtn().click();
		// Select 1st checkbox from searched result
		lvmgs.getlvmGlobalSearchExhCheckbox().click();
		
		// Click on Add to Selected List Btn
		lvmgs.getlvmAddToExistingList().click();
		String lName = genData.generateRandomString(10);
		lvmmpp.getCreateNewListNameTxtbx().sendKeys(lName);
		// lvmmppge.getCreateNewListNameTxtbx().sendKeys();
		lvmmpp.getCreateAndAddListBtn().click();
		Thread.sleep(2000);
		// CLick on Go To MP Btn
		lvmgs.getlvmGoToMPBtn().click();

		// Click on Market Planner
		lap.getMPLinkText().click();
		Thread.sleep(6000);

		// Click on List tab
		lvmmpp.getMPHomeListsTab().click();
		Thread.sleep(10000);
		// Click on List from left Panel
		lvmmpp.getMpListLeftPannel().click();
		// Open selected list
		utl.ClickOnEditBtnOfAnyList(lvmmpp.getallList(), lName);
		// Verify exhibitor present into selected list or not
		Thread.sleep(7000);
		utl.checkItemPresentInListorNot(lvmmpp.getlistOfAllExh(), exhName);
		driver.get(prop.getProperty("lvmurl_prod"));
	}
	
	@Test(enabled=false)
	public void TS008_VerifyGlobalSearchMatchingResultsUsePreviousSavedSearchTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T329: Global Search: Matching results- Use previous saved Search

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		if(!lvmgs.getLVMGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			lvmgs.getlvmGlobalSearchClearTxt().click();
		}
		//utl.verifyMPLoginFunctionality();
		utl.CloseATLPopup();
	
		try {
			lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("savedSearchesInput"));
			Thread.sleep(3000);
			lvmgs.getLVMSearchButton().click();
			Thread.sleep(5000);
			// Click on Save Searches Btn
			lvmgs.getlvmSavedSearchesIcon().click();
			Select selectSavedSearched = new Select(lvmgs.getlvmSavedSearchesDropdown());
			selectSavedSearched.selectByIndex(1);
			String optin = selectSavedSearched.getOptions().get(1).getText();
			System.out.println(optin);
		//	Assert.assertTrue(lvmgs.getLVMInfosearchtxtbx().getAttribute("value").contains(optin));
			Thread.sleep(5000);
			Assert.assertTrue(lvmgs.getLVMVerifyGlobalSeacrh().getText().contains(optin));
			
		} catch (Exception e) {
			
			if(!lvmgs.getLVMGlobalSearchTextBox().getAttribute("value").isEmpty()) {
				lvmgs.getlvmGlobalSearchClearTxt().click();
			}
			lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("savedSearchesInput"));
			Thread.sleep(3000);
			lvmgs.getLVMSearchButton().click();
			Thread.sleep(5000);
			// Click on Save Searches Btn
			lvmgs.getlvmSavedSearchesIcon().click();
			//Click on Save Seach btn
			lvmgs.getlvmSavedSearchesBtn().click();
			
			String savedSearchesInput=prop.getProperty("savedSearchesInput");
			//Enter Search name into input box
			lvmgs.getlvmSavedSearchesInputBox().sendKeys(savedSearchesInput);
			//Click on Save Search Btn 
			lvmgs.getlvmSavedSearchesBtnForNewSaved().click();
			//Goto Home page
			driver.get(prop.getProperty("atlmrkturl_prod"));
			//Click on saved Searches btn
			lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));
			Thread.sleep(5000);
			lvmgs.getLVMSearchButton().click();
			lvmgs.getlvmSavedSearchesIcon().click();
			//Select Saved Search from List
			Select selectSavedSearched = new Select(lvmgs.getlvmSavedSearchesDropdown());
			selectSavedSearched.selectByVisibleText(savedSearchesInput);
			//Vrfify Saved Searches output resultss
			Assert.assertTrue(lvmgs.getLVMInfosearchtxtbx().getAttribute("value").contains(prop.getProperty("savedSearchesInput")));
			Thread.sleep(5000);
			Assert.assertTrue(lvmgs.getLVMVerifyGlobalSeacrh().getText().contains(prop.getProperty("savedSearchesInput")));
		}

	}
	@Test(enabled=false)//priority = 9
	public void TS009_VerifyGlobalSearchMatchingResultsSavedSearchesTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T355: Global Search: Matching results -Saved Searches

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lap = new LVMLandingPage(driver);
		lp = new LVMLoginPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		if(!lvmgs.getLVMGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			lvmgs.getlvmGlobalSearchClearTxt().click();
		}
		//utl.verifyMPLoginFunctionality();
		utl.CloseATLPopup();
		lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("exhibitor5"));//savedSearchesInput
		Thread.sleep(3000);
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(5000);
		// Click on Save Searches Btn
		lvmgs.getlvmSavedSearchesIcon().click();
		//Click on Save Seach btn
		lvmgs.getlvmSavedSearchesBtn().click();
		
		String savedSearchesInput=prop.getProperty("savedSearchesInput");
		//Enter Search name into input box
		lvmgs.getlvmSavedSearchesInputBox().sendKeys(savedSearchesInput);
		//Click on Save Search Btn 
		lvmgs.getlvmSavedSearchesBtnForNewSaved().click();
		lvmgs.getlvmSelectList().click();
		
		utl.checkItemPresentInListorNot(lvmgs.getlvmListOfAllSavedSearches(),savedSearchesInput);
		driver.get(prop.getProperty("lvmurl_prod"));
	}
	
	@AfterClass
	public void quit() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
	}
	
}
