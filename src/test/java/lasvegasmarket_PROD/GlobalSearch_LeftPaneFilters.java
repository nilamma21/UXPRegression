package lasvegasmarket_PROD;



import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
import pageObjects.ExhibitorPortal.EXPMarketsPage;
import pageObjects.LasVegasMarket.LVMExhDigiShowroomPage;
import pageObjects.LasVegasMarket.LVMExhLineProdActionsPage;
import pageObjects.LasVegasMarket.LVMGlobalSearchPage;
import pageObjects.LasVegasMarket.LVMLandingPage;
import pageObjects.LasVegasMarket.LVMLeftPaneFilters;
import pageObjects.LasVegasMarket.LVMLoginPage;
import pageObjects.LasVegasMarket.LVMMarketPlannerPage;
import pageObjects.LasVegasMarket.LVMProductDetailsPage;
import pageObjects.Sitecore.SCDashboard;
import pageObjects.Sitecore.SCDigitalAdminPanelPage;
import pageObjects.Sitecore.SCDigitalAdminPanelUserProfilePage;
import pageObjects.Sitecore.SCLoginPage;
import pageObjects.Sitecore.SCShowSpecials;
import resources.GenerateData;
import resources.Utility;
import resources.base;


@Listeners({ TestListeners.class })
public class GlobalSearch_LeftPaneFilters extends base {

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
	ATLLeftPaneFilters atlleftpane;
	SCDigitalAdminPanelPage digiAdmin;
	SCDigitalAdminPanelUserProfilePage digiAdminUserProf;


	List<WebElement> exhproductlist,prodcatgitemlist,HolidayAndSeasonialFilterOptions,ListLFsubMenus,NeweListLFsubMenus,xhlist, linelist, prodlist, searchexhtypelist, searchproducttypelist, mplists, mpeditlistoptns, allnoteslist,favlist, searchlinetypelist;

	
	@BeforeClass
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		utl = new Utility(driver);
		lap = new LVMLandingPage(driver);

		// Navigate to Las Vegas Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(4000);
		try {
			lap.getIUnderstandBtn().click();
			}catch (Exception e) {
				// TODO: handle exception
			}
		Thread.sleep(7000);
		driver.navigate().refresh();
	}
	 public void verifyProductCategorySelection(String searchInput, WebElement productCategoryElement) throws InterruptedException {
		   
		   lvmleftpane = new LVMLeftPaneFilters(driver);
	       
		   
	        Thread.sleep(8000);
	        
	        lvmgs.getGlobalSearchTextBoxNew().click();
	        lvmgs.getGlobalSearchEnterText().sendKeys(prop.getProperty(searchInput));
	        lvmgs.getSearchButtonNew().click();
	        Thread.sleep(20000);
	        
	        lvmleftpane.getLVMProdCatgExpandBtn().click();
	        Thread.sleep(8000);
	        
	        utl.scrollElementIntoMiddle(productCategoryElement);
	        String expectedprodcatg = productCategoryElement.getText();
	        productCategoryElement.click();
	        Thread.sleep(8000);
	        
	        String exhname = lvmds.getExhibitorNameNew().getText();
	        lvmds.getExhibitorNameNew().click();
	        Thread.sleep(10000);
	        
	        List<WebElement> prodcatgitemlist = lvmds.getLVMProductCategItemList();
	        for (WebElement item : prodcatgitemlist) {
	            if (lvmds.getLVMProductCategTable().isDisplayed()) {
	                Assert.assertTrue(item.getText().contains(expectedprodcatg));
	                break;
	            }
	        }
	    }


	 
	@Test(priority = 1)
	public void TS001_VerifySelectionOfApparelVintageProdCatgFromLeftPaneFiltersTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T404: Selection Of Apparel, Vintage Prod Catg From Left Pane Filters

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		lvmleftpane = new LVMLeftPaneFilters(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(3000);

		//Global Search input
		utl.globleSearchInput((prop.getProperty("globalsearch_input")));
		//Product Category Expand
		utl.commonMethodLeftPaneFilterExpandButton(lvmleftpane.getLVMProdCatgExpandBtn());
		//Click on Apparel vintage category
		utl.clickOnLeftPaneFilter(lvmleftpane.getLVMApparelVintProdCatg());

		driver.get(prop.getProperty("lvmurl_prod"));


	}	
	

	@Test(priority = 2)
	public void TS002_VerifySelectionOfAntiqueVintageProdCatgFromLeftPaneFiltersTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T404: Selection Of Antique/Vintage Prod Catg From Left Pane Filters

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		lvmleftpane = new LVMLeftPaneFilters(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(3000);

		//Global Search input
		utl.globleSearchInput((prop.getProperty("globalsearch_input")));
		//Product Category Expand
		utl.commonMethodLeftPaneFilterExpandButton(lvmleftpane.getLVMProdCatgExpandBtn());
		
		utl.clickOnLeftPaneFilter(lvmleftpane.getLVMAntiqueVintProdCatg());
		utl.commomMethodForFindoutProductCategory();


		driver.get(prop.getProperty("lvmurl_prod"));
	}

@Test(priority = 3)
public void TS003_VerifyCombinationWithinProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException {
	// The purpose of this test case to verify:-
	// T405: Combination within Prod Catgs From Left Pane Filters

	lvmgs = new LVMGlobalSearchPage(driver);
	lvmds = new LVMExhDigiShowroomPage(driver);
	lvmmpp = new LVMMarketPlannerPage(driver);
	lvmleftpane = new LVMLeftPaneFilters(driver);
	lvmexhact = new LVMExhLineProdActionsPage(driver);
	utl = new Utility(driver);

	//Global Search input
	utl.globleSearchInput((prop.getProperty("globalsearch_input")));
	//Product Category Expand
	utl.commonMethodLeftPaneFilterExpandButton(lvmleftpane.getLVMProdCatgExpandBtn());
	

	//Select 'Antique/Vintage' prod category
	utl.scrollElementIntoMiddle(lvmleftpane.getLVMAntiqueVintProdCatg());
	Thread.sleep(200);
	String expectedprodcatg1 = lvmleftpane.getLVMAntiqueVintProdCatg().getText();
	lvmleftpane.getLVMAntiqueVintProdCatg().click();
	Thread.sleep(6000);
	
	//Select 'Apparel, Vintage' prod category
	utl.scrollElementIntoMiddle(lvmleftpane.getLVMApparelVintProdCatg());
	Thread.sleep(200);
	String expectedprodcatg2 = lvmleftpane.getLVMApparelVintProdCatg().getText();
	lvmleftpane.getLVMApparelVintProdCatg().click();
	Thread.sleep(8000);

	//Verify the selected Product Categories on Exhibitor Digital Showroom page
	utl.scrollToTop();
	exhname = lvmds.getExhibitorNameNew().getText();
	lvmds.getExhibitorNameNew().click();
	Thread.sleep(10000);
	//Scroll till Product Categories section
	prodcatgitemlist = lvmds.getLVMProductCategItemList();

	boolean isCategory1Present = false;
	boolean isCategory2Present = false;

	for (WebElement category : prodcatgitemlist) {
		String categoryText = category.getText();
		if (categoryText.contains(expectedprodcatg1)) {
			isCategory1Present = true;
		}
		if (categoryText.contains(expectedprodcatg2)) {
			isCategory2Present = true;
		}
		if (isCategory1Present && isCategory2Present) {
			break;
		}
	}

	Assert.assertTrue(isCategory1Present || isCategory2Present, "Neither of the selected categories were found.");
	driver.get(prop.getProperty("lvmurl_prod"));
}


	@Test(priority = 4)
	public void TS004_VerifyCombinationOfProdCatgWithStylesFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T406: Combination of Prod Catgs with Styles From Left Pane Filters

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmleftpane = new LVMLeftPaneFilters(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lp = new LVMLoginPage(driver);
		 atlleftpane = new ATLLeftPaneFilters(driver);

		utl.globleSearchInput((prop.getProperty("globalsearch_input")));
		utl.commonMethodLeftPaneFilterExpandButton(lvmleftpane.getLVMProdCatgExpandBtn());
	

		// Select 'Antique/Vintage' product category
		utl.clickOnLeftPaneFilter(lvmleftpane.getLVMAntiqueVintProdCatg());

		// Expand Styles
		utl.scrollElementIntoMiddle(lvmleftpane.getLVMStylesExpandBtn());
		Thread.sleep(200);
		//Click on Styles Expand button
		utl.commonMethodLeftPaneFilterExpandButton(lvmleftpane.getLVMStylesExpandBtn());
		
		Thread.sleep(3000);

		// Select 'Coastal' style
		utl.clickOnLeftPaneStyleFilter(lvmleftpane.getLVMCoastalStyle());
		utl.scrollElementIntoMiddle(lvmleftpane.getLVMCoastalStyle());
		Thread.sleep(10000);
		
		//check 3exhibitors for prod category
		
		
		utl.commomMethodForFindoutProductCategory();
		String exName=utl.exhibitorNameText;
		

	    // Open Exhibitor Portal in new tab
	    driver.get(prop.getProperty("expurl_prod"));
	    Thread.sleep(5000);

	    // Login to EXP
	    lp.getEmailAddress().sendKeys(prop.getProperty("usernameSwapnil"));
	    lp.getPassword().sendKeys(prop.getProperty("passwordSwapnil"));
	    lp.getSignInBtn().click();
	    Thread.sleep(30000);

	    // Click on Exhibitor association drop down
	   

	    boolean isExhibitorFound = utl.checkAndSelectExhibitor();
	    
	    if (!isExhibitorFound) {
	        utl.addExhibitorFromSiteCore();
	        
	        // Refresh and check again
	        driver.navigate().refresh();
	        Thread.sleep(15000);
	        atlleftpane.getEXPExhDropDown().click();
	        isExhibitorFound = utl.checkAndSelectExhibitor();
	    }

	    // If exhibitor is now found, proceed to check style properties
	    if (isExhibitorFound) {
	        utl.checkStyleProperties();
	    } else {
	        Assert.fail("Exhibitor not found in EXP even after adding from Sitecore");
	    }
	}
		
		
		

		/*
		 * // Click on the second exhibitor from search result. utl.scrollToTop();
		 * exhname = lvmds.getExhibitorNameNew().getText();
		 * lvmds.getExhibitorNameNew().click(); Thread.sleep(10000);
		 * 
		 * // Verify Product Categories section prodcatgitemlist =
		 * lvmds.getLVMProductCategItemList(); boolean isCategoryFound = false;
		 * 
		 * for (WebElement item : prodcatgitemlist) { if
		 * (lvmds.getLVMProductCategTable().isDisplayed() &&
		 * item.getText().contains(expectedprodcatg)) { isCategoryFound = true; break; }
		 * }
		 * 
		 * Assert.assertTrue(isCategoryFound, "Expected product category not found.");
		 * driver.get(prop.getProperty("lvmurl_prod"));
		 */
	
	
	//@Test(priority = 5)
	public void LoginExp() throws InterruptedException {
	    lap = new LVMLandingPage(driver);
	    lp = new LVMLoginPage(driver);
	    atlleftpane = new ATLLeftPaneFilters(driver);
	    genData = new GenerateData();
	    digiAdmin = new SCDigitalAdminPanelPage(driver);
	    digiAdminUserProf = new SCDigitalAdminPanelUserProfilePage(driver);

	    // Open Exhibitor Portal in new tab
	    driver.get(prop.getProperty("expurl_prod"));
	    Thread.sleep(5000);

	    // Login to EXP
	    lp.getEmailAddress().sendKeys(prop.getProperty("usernameSwapnil"));
	    lp.getPassword().sendKeys(prop.getProperty("passwordSwapnil"));
	    lp.getSignInBtn().click();
	    Thread.sleep(30000);

	    // Click on Exhibitor association drop down
	    atlleftpane.getEXPExhDropDown().click();

	    boolean isExhibitorFound = utl.checkAndSelectExhibitor();
	    
	    if (!isExhibitorFound) {
	        utl.addExhibitorFromSiteCore();
	        
	        // Refresh and check again
	        driver.navigate().refresh();
	        Thread.sleep(10000);
	        atlleftpane.getEXPExhDropDown().click();
	        isExhibitorFound = utl.checkAndSelectExhibitor();
	    }

	    // If exhibitor is now found, proceed to check style properties
	    if (isExhibitorFound) {
	        utl.checkStyleProperties();
	    } else {
	        Assert.fail("Exhibitor not found in EXP even after adding from Sitecore");
	    }
	}



	

	

	
	
	@Test(priority = 5)
	public void TS005_VerifySelectionOfAccentFurnitureProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T404: Selection Of Accent Furniture Prod Catg From Left Pane Filters

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		lvmleftpane = new LVMLeftPaneFilters(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
		Thread.sleep(6000);
		lvmgs.getGlobalSearchTextBoxNew().click();
		lvmgs.getGlobalSearchEnterText().sendKeys("   ");
		lvmgs.getSearchButtonNew().click();
		Thread.sleep(20000);
		
		
		//Click on Product Categories expand btn
		utl.scrollElementIntoMiddle(lvmleftpane.getLVMProdCatgExpandBtn());
		Thread.sleep(200);
		lvmleftpane.getLVMProdCatgExpandBtn().click();

		//Select Accent Furniture prod category
		utl.scrollElementIntoMiddle(lvmleftpane.getLVMAccentFurnitureProdCatg());
		Thread.sleep(200);
		String expectedprodcatg = lvmleftpane.getLVMAccentFurnitureProdCatg().getText();
		lvmleftpane.getLVMAccentFurnitureProdCatg().click();
		Thread.sleep(8000);
		utl.commomMethodForFindoutProductCategory();


		driver.get(prop.getProperty("lvmurl_prod"));
	}

	@Test(priority = 6)
	public void TS006_VerifySelectionOfHolidayProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException, AWTException {
	    // The purpose of this test case to verify:
	    // T404: Selection Of Holiday/Seasonal Prod Catg From Left Pane Filters

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		lvmleftpane = new LVMLeftPaneFilters(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		//global search input
		utl.globleSearchInput((prop.getProperty("globalsearch_input")));
		//Click on Prod cate expand button
		utl.commonMethodLeftPaneFilterExpandButton(lvmleftpane.getLVMProdCatgExpandBtn());
		

		// Select Holiday/Seasonal product category
		//Click on Holiday/seasonal prod cate
		utl.clickOnLeftPaneFilter(lvmleftpane.getLVMHolidayProdCatg());
		//Click on Plus button for sub filters
//		utl.ClickOnSubFilterPlusButton("Holiday/Seasonal");
		//verify sub categs are present in exh prod categ
		utl.subFilterCategories(lvmleftpane.getlistOfAllHolidayAndSeasonialFilterOptions());
	
		driver.get(prop.getProperty("lvmurl_prod"));

	}



	@Test(priority =7)
	public void TS007_VerifySelectionOfDecorativeAccessProdCatgFromLeftPaneFiltersTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T404: Selection Of Decorative Accessories Prod Catg From Left Pane Filters

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		lvmleftpane = new LVMLeftPaneFilters(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);

		utl.globleSearchInput((prop.getProperty("globalsearch_input")));
		utl.commonMethodLeftPaneFilterExpandButton(lvmleftpane.getLVMProdCatgExpandBtn());

		// Select Decorative Acc product category
		utl.clickOnLeftPaneFilter(lvmleftpane.getLVMDecorativeAccProdCatg());

		//Click on Plus button for sub filters
		//utl.ClickOnSubFilterPlusButton("Decorative Accessories");
		//verify sub categs are present in exh prod categ
		utl.subFilterCategories(lvmleftpane.getlistOfAllDecorativeAccessoriesFilterOptions());

		driver.get(prop.getProperty("lvmurl_prod"));

	}

	@Test(priority =8)
	public void TS008_VerifySelectionOfGeneralGiftProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T404: Selection Of General Gift Prod Catg From Left Pane Filters
		
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		lvmleftpane = new LVMLeftPaneFilters(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);

		utl.globleSearchInput((prop.getProperty("globalsearch_input")));
		utl.commonMethodLeftPaneFilterExpandButton(lvmleftpane.getLVMProdCatgExpandBtn());

		// Select General Gift product category
		utl.clickOnLeftPaneFilter(lvmleftpane.getLVMGeneralGiftProdCatg());

		//Click on Plus button for sub filters
		//utl.ClickOnSubFilterPlusButton("General Gift");
		//verify sub categs are present in exh prod categ
		utl.subFilterCategories(lvmleftpane.getlistOfAllGeneralGiftFilterOptions());

		driver.get(prop.getProperty("lvmurl_prod"));

	}

	@Test(priority = 9)
	public void TS009_VerifySelectionOfFashionAccProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T404: Selection Of Fashion Accessories/Jewelry Prod Catg From Left Pane Filters

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		lvmleftpane = new LVMLeftPaneFilters(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);

		utl.globleSearchInput((prop.getProperty("globalsearch_input")));
		utl.commonMethodLeftPaneFilterExpandButton(lvmleftpane.getLVMProdCatgExpandBtn());
		
		
		utl.clickOnLeftPaneFilter(lvmleftpane.getLVMFashionAccProdCatg());
	    utl.scrollElementIntoMiddle(lvmleftpane.getLVMFashionAccProdCatg());
	    
		//Click on Plus button for sub filters
	   // utl.ClickOnSubFilterPlusButton("Fashion Accessories/Jewelry");
		//verify sub categs are present in exh prod categ
		utl.subFilterCategories(lvmleftpane.getlistOfAllFashionAccessoriesJewelryFilterOptions());

		driver.get(prop.getProperty("lvmurl_prod"));

	}

	@Test(priority =10)
	public void TS010_VerifySelectionOfFloralBotanicalsProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T404: Selection Of Floral / Botanicals Prod Catg From Left Pane Filters

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		lvmleftpane = new LVMLeftPaneFilters(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);

	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    Thread.sleep(2000);

		utl.globleSearchInput((prop.getProperty("globalsearch_input")));
		utl.commonMethodLeftPaneFilterExpandButton(lvmleftpane.getLVMProdCatgExpandBtn());

		utl.clickOnLeftPaneFilter(lvmleftpane.getLVMFloralBotanicalsProdCatg());
		utl.scrollElementIntoMiddle(lvmleftpane.getLVMFashionAccProdCatg());

		// Click on Plus button for sub filters
		//utl.ClickOnSubFilterPlusButton("Floral / Botanicals");
		// verify sub categs are present in exh prod categ
		utl.subFilterCategories(lvmleftpane.getlistOfAllFloralBotanicalsFilterOptions());

		driver.get(prop.getProperty("lvmurl_prod"));
	}

	@Test(priority =11)
	public void TS011_VerifySelectionOfHomeTextilesProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException {
	    // Initialize page objects
	    lvmgs = new LVMGlobalSearchPage(driver);
	    lvmds = new LVMExhDigiShowroomPage(driver);
	    lvmmpp = new LVMMarketPlannerPage(driver);
	    lvmleftpane = new LVMLeftPaneFilters(driver);
	    lvmexhact = new LVMExhLineProdActionsPage(driver);
	    utl = new Utility(driver);

	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    Thread.sleep(2000);

		utl.globleSearchInput((prop.getProperty("globalsearch_input")));
		utl.commonMethodLeftPaneFilterExpandButton(lvmleftpane.getLVMProdCatgExpandBtn());

		utl.clickOnLeftPaneFilter(lvmleftpane.getLVMHomeTextilesProdCatg());
		utl.scrollElementIntoMiddle(lvmleftpane.getLVMHomeTextilesProdCatg());

		// Click on Plus button for sub filters
		//utl.ClickOnSubFilterPlusButton("Home Textiles");
		// verify sub categs are present in exh prod categ
		utl.subFilterCategories(lvmleftpane.getlistOfAllHomeTextilesFilterOptions());

		driver.get(prop.getProperty("lvmurl_prod"));

	 
	}
	@Test(priority =12)
	public void TS012_VerifyNewExhibitorButtonFromLeftPaneFiltersTest() throws InterruptedException, IOException {
	    // Initialize page objects
	    lvmgs = new LVMGlobalSearchPage(driver);
	    lvmds = new LVMExhDigiShowroomPage(driver);
	    lvmmpp = new LVMMarketPlannerPage(driver);
	    lvmleftpane = new LVMLeftPaneFilters(driver);
	    lvmexhact = new LVMExhLineProdActionsPage(driver);
	    utl = new Utility(driver);

	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);

		utl.globleSearchInput((prop.getProperty("globalsearch_input")));
		//Click on New Button
	    lvmleftpane.getleftPaneFilterNewExhibitor().click();
		Thread.sleep(5000);
		
		
		// Get all exhibitor elements from the list
				List<WebElement> allExhibitors = lvmleftpane.getlistOfExhibitors();

				// Flag to track test status
				boolean allHaveShowSpecials = true;

				// Iterate through each exhibitor
				for (WebElement exhibitor : allExhibitors) {
					try {
						String exName = exhibitor.getText();
						System.out.println("Exhibitor Name::" + exName);
						// Check if "Show Specials" tag is present for the exhibitor
						WebElement NewTag = exhibitor.findElement(By.xpath(
								"//div[@class='imc-content--full-width']/div/div[2]/div/span/../../../div/div/a/h2[contains(text(),'" + exName + "')]"));
						

						// If tag is found, print success message
						System.out.println("New  found for exhibitor: " + exhibitor.getText());
					} catch (NoSuchElementException e) {
						// If no "Show Specials" tag found, test fails
						System.out.println("Test Failed: New tag missing for exhibitor: " + exhibitor.getText());
						allHaveShowSpecials = false;
					}
				}

				// Final assertion
				Assert.assertTrue(allHaveShowSpecials, "Test Failed: Not all exhibitors have New tag.");
				System.out.println("Test Passed: All exhibitors have New tag.");

				driver.get(prop.getProperty("lvmurl_prod"));
	
	}
	@Test(priority =13)
	public void TS013_VerifyHasShowSpecialsFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// Initialize page objects
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		lvmleftpane = new LVMLeftPaneFilters(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);

		utl.globleSearchInput((prop.getProperty("globalsearch_input")));
		// Click on Has show Special button
		 lvmleftpane.getleftPaneFilterHasShowSpecials().click();
		Thread.sleep(5000);
		// verify has show specials tag is present or not
		// get all the exhibitors

		// Get all exhibitor elements from the list
		List<WebElement> allExhibitors = lvmleftpane.getlistOfExhibitors();

		// Flag to track test status
		boolean allHaveShowSpecials = true;

		// Iterate through each exhibitor
		for (WebElement exhibitor : allExhibitors) {
			try {
				String exName = exhibitor.getText();
				System.out.println("Exhibitor Name::" + exName);
				// Check if "Show Specials" tag is present for the exhibitor
				WebElement showSpecialTag = exhibitor.findElement(By.xpath(
						"//div[@class='imc-content--full-width']/div/div/a/span[2]/../../../div/div/a/h2[contains(text(),'" + exName + "')"));

				// If tag is found, print success message
				System.out.println("Show Specials tag found for exhibitor: " + exhibitor.getText());
			} catch (NoSuchElementException e) {
				// If no "Show Specials" tag found, test fails
				System.out.println("Test Failed: Show Specials tag missing for exhibitor: " + exhibitor.getText());
				allHaveShowSpecials = false;
			}
		}

		// Final assertion
		Assert.assertTrue(allHaveShowSpecials, "Test Failed: Not all exhibitors have Show Specials tag.");
		System.out.println("Test Passed: All exhibitors have Show Specials tag.");

		driver.get(prop.getProperty("lvmurl_prod"));

	}
	@Test(priority =14)
	public void TS014_VerifyTemporaryButtonFromLeftPaneFiltersTest() throws InterruptedException, IOException {
	    // Initialize page objects
	    lvmgs = new LVMGlobalSearchPage(driver);
	    lvmds = new LVMExhDigiShowroomPage(driver);
	    lvmmpp = new LVMMarketPlannerPage(driver);
	    lvmleftpane = new LVMLeftPaneFilters(driver);
	    lvmexhact = new LVMExhLineProdActionsPage(driver);
	    utl = new Utility(driver);

	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    Thread.sleep(2000);

		utl.globleSearchInput((prop.getProperty("globalsearch_input")));
	
	}
	@AfterClass
	public void tearDown()
	{
		//driver.quit();
	}
	 
}
