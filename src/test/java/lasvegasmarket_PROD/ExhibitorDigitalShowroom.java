package lasvegasmarket_PROD;

import java.awt.RenderingHints.Key;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import atlantamarket_PROD.TestListeners;
import pageObjects.LasVegasMarket.LVMEventsAndWebinarPage;
import pageObjects.LasVegasMarket.LVMExhDigiShowroomPage;
import pageObjects.LasVegasMarket.LVMExhLineProdActionsPage;
import pageObjects.LasVegasMarket.LVMGlobalSearchPage;
import pageObjects.LasVegasMarket.LVMLandingPage;
import pageObjects.LasVegasMarket.LVMLoginPage;
import pageObjects.LasVegasMarket.LVMMarketPlannerPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

@Listeners({ TestListeners.class })
public class ExhibitorDigitalShowroom extends base {

	public Utility utl;
	public String exhname;
	LVMLandingPage lap;
	LVMExhDigiShowroomPage lvmds;
	LVMGlobalSearchPage lvmgs;
	LVMMarketPlannerPage lvmmpp;
	LVMExhLineProdActionsPage lvmexhact;
	LVMEventsAndWebinarPage lvmevents;
	LVMLoginPage lp;
	GenerateData genData;

	List<WebElement> favexhlist, favlist, mplists, mpeditlistoptns;

	@BeforeClass
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver();
		utl = new Utility(driver);
		lap = new LVMLandingPage(driver);

		//driver.manage().window().maximize();
		driver.get(prop.getProperty("lvmurl_prod"));
		System.out.println("Las Vegas Market site is started");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		try {
			lap.getIUnderstandBtn().click();
			}catch (Exception e) {
				// TODO: handle exception
			}
		/*
		 * Thread.sleep(2000); utl.verifyMPLoginFunctionality(); //Login
		 * Thread.sleep(3000); utl.loginCheckLVM();
		 */
	}
	public void setup() {
	    driver.get(prop.getProperty("lvmurl_prod")); // Always start fresh
	}
	@Test(priority = 1)
	public void TS001_VerifyClickOnLocationLinksForExhibitorDigitalShowroomTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T643: The click on 'Location Links' functionality for an Exhibitor
try {
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		lap = new LVMLandingPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);

		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		utl.commonMethodForExhibotrDGShowroomm((prop.getProperty("globalsearchinput")));
		
		
		String locationlink = lvmds.getlocationLinkNew().getAttribute("href");
		System.out.println("Location link is: " + locationlink);
		lvmds.getlocationLinkNew().click();
		System.out.println("Clicked on locatoin link");
		Thread.sleep(10000);
	
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(locationlink.equals(driver.getCurrentUrl()));
		System.out.println("Locations page is displayed properly.");
} catch (Exception e) {
    System.out.println("Test Case Failed: " + e.getMessage());
} finally {
    // Reset to base URL so the next test starts cleanly
    driver.get(prop.getProperty("lvmurl_prod"));
}

	}

	@Test(priority = 2)
	public void TS002_VerifyClickOnTotalLinesSeeAllLinesForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T: The click on 'Total lines-See All' functionality for an Exhibitor Digital
		// Show room
try {
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		lap = new LVMLandingPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);


		Thread.sleep(8000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.commonMethodForExhibotrDGShowroomm((prop.getProperty("globalsearchinput")));
		
		utl.scrollToElement(lvmds.getLinesSection());
		String temp = lvmds.getLinesSection().getText();
		String totallinescountonsearchgrid = temp.replaceAll("[^0-9]", "");
		
		System.out.println("Total Products Count on Search Results grid is: " + totallinescountonsearchgrid);
		Assert.assertTrue(lvmds.getTotalLinesButton().getText().contains(totallinescountonsearchgrid));
		
		System.out.println("Total Lines count is same at Lines section title and See All button.");
		Thread.sleep(8000);
		
		utl.scrollToElement(lvmds.getAllProductsButton());
		// Click on Total Lines-See All link for 1st Exhibitor
		lvmds.getTotalLinesButton().click();
		Thread.sleep(6000);

		// Verify that user should redirect to the Lines page
		Assert.assertTrue(lvmds.getValidateLinesPage().getText().contains("Lines"));
		System.out.println("All Lines page is displayed properly.");
		Thread.sleep(6000);

		// Get the Total Products count on Products page
		String linestabtitle = lvmds.getLinesCountAtLinesPage().getText();
		String totallinescountonprodpage = linestabtitle.replaceAll("[^0-9]", "");
		System.out.println("Total Lines Count on Products page is: " + totallinescountonprodpage);

		// Get back to Exhibitor Showroom page and click any one Line and verify if Line
		// details
		// are displayed properly
		//lvmds.getProductsPageBackButton().click();
		driver.navigate().back();
		utl.scrollToElement(lvmds.getAllProductsButton());

		String linetext = lvmds.getLinesOptionText().getText();
		Thread.sleep(5000);
		lvmds.getLinesOptionPROD().click();
		Thread.sleep(5000);
		Assert.assertTrue(lvmds.getValidateLinesPage().getText().contains(linetext));
		System.out.println("Line Details are displayed properly.");
} catch (Exception e) {
    System.out.println("Test Case Failed: " + e.getMessage());
} finally {
    // Reset to base URL so the next test starts cleanly
    driver.get(prop.getProperty("lvmurl_prod"));
}
	}

	@Test(priority = 3)
	public void TS003_VerifyClickOnProductShownLinkForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T311: The click on 'Product Shown-See All' functionality for an Exhibitor
		// Digital Showroom
try {
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		lap = new LVMLandingPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		
		Thread.sleep(8000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.commonMethodForExhibotrDGShowroomm((prop.getProperty("globalsearchinput")));
		utl.scrollToElement(lvmds.getProductSection());
		String temp = lvmds.getProductSection().getText();
		String totalprodcountonsearchgrid = temp.replaceAll("[^0-9]", "");
		System.out.println("Total Products Count on Search Results grid is: " + totalprodcountonsearchgrid);
		Assert.assertTrue(lvmds.getAllProductsButton().getText().contains(totalprodcountonsearchgrid));
		System.out.println("Total Products count is same at Products section title and See All button.");

		// Click on Total Products-See All link for 1st Exhibitor
		lvmds.getAllProductsButton().click();
		Thread.sleep(6000);

		// Verify that user should redirect to the Lines page
		Assert.assertTrue(lvmds.getValidateLinesPage().getText().contains("Products"));
		System.out.println("All Products page is displayed properly.");
		Thread.sleep(6000);

		// Get the Total Products count on Products page
		String productstabtitle = lvmexhact.getValidateProductsPage().getText();
		String totalproductscountonprodpage = productstabtitle.replaceAll("[^0-9]", "");
		System.out.println("Total Products Count on Products page is: " + totalproductscountonprodpage);

		// Get back to Exhibitor Showroom page and click any one product and verify if
		// product details
		// are displayed properly
		//lvmds.getProductsPageBackButton().click();
		driver.navigate().back();
		utl.scrollToElement(lvmds.getProductSection());
		String producttext = lvmds.getProductText().getText();
		System.out.println(producttext);
		lvmds.getProductsList().click();
		Thread.sleep(5000);
		Assert.assertTrue(producttext.contains(lvmds.getValidateLinesPage().getText()));
		System.out.println("Product Details are displayed properly.");
} catch (Exception e) {
    System.out.println("Test Case Failed: " + e.getMessage());
} finally {
    // Reset to base URL so the next test starts cleanly
    driver.get(prop.getProperty("lvmurl_prod"));
}
	
	}
	@Test(priority = 4)
	public void TS004_VerifyClickOnLineFiltersForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T315: The click on Line Filters functionality for an Exhibitor Digital Show
		// room

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		lap = new LVMLandingPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);

		Thread.sleep(8000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		utl.commonMethodForExhibotrDGShowroomm((prop.getProperty("globalsearchinput")));
		utl.scrollToElement(lvmds.getProductSection());

		Thread.sleep(8000);
		// Verify A-Z sorting
		//lvmds.getAlphabeticSorting().click();
		Actions action=new Actions(driver);
		action.moveToElement(lvmds.getAlphabeticSorting()).click().perform();
		Assert.assertTrue(lvmds.getLinesOptionText().getText().startsWith("A"));
		driver.get(prop.getProperty("lvmurl_prod"));
}
	

	@Test(priority = 5)
	public void TS005_VerifyClickOnLineSearchForExhibitorTest() throws InterruptedException, IOException {
	    // The purpose of this test case to verify:-
	    // T317: The click on Line Filters functionality for an Exhibitor Digital Showroom

	    // Initialize necessary page objects
	    lvmgs = new LVMGlobalSearchPage(driver);
	    lvmexhact = new LVMExhLineProdActionsPage(driver);
	    lap = new LVMLandingPage(driver);
	    lvmds = new LVMExhDigiShowroomPage(driver);

		Thread.sleep(8000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    
	    utl.commonMethodForExhibotrDGShowroomm((prop.getProperty("globalsearchinput")));

	    // Scroll to the product section
	    utl.scrollToElement(lvmds.getProductSection());

	    // Store the first line name
	    String lineName = lvmds.getVerifyLineSearchNew().getText();
	    System.out.println("Searching for Line: " + lineName);

	    try {
	        // Verify Line Search functionality
	        lvmds.getLineSearch().click();
	        lvmds.getLineSearch().sendKeys(lineName);
	        lvmds.getSearchBtnNew().click();
	        Thread.sleep(5000);
	        utl.scrollToElement(lvmds.getProductSection());

	        // Validate the searched line name is present
	        Assert.assertTrue(lvmds.getVerifyLineSearchNew().getText().contains(lineName));
	        System.out.println("Line Search functionality verified successfully.");

	    } catch (Exception e1) {
	        System.out.println("Exception encountered, attempting fallback method.");

	        // Handle fallback case: Clear search field and try with a second line name
	        utl.scrollToElement(lvmds.getProductSection());
	        Thread.sleep(9000);
	        //lvmds.getLineSearch().click();
	        Thread.sleep(8000);
	        lvmds.getLineSearch().sendKeys(Keys.CONTROL + "a");
	        Thread.sleep(8000);
	        lvmds.getLineSearch().sendKeys(Keys.DELETE);
	        Thread.sleep(5000);
	        lvmds.getLineSearch().sendKeys(Keys.ENTER);
	        Thread.sleep(8000);

	        // Get the second line name and perform search
	        String lineName2 = lvmds.getVerify2ndLineSearchNew().getText();
	        System.out.println("Searching for alternative Line: " + lineName2);
	        
	        lvmds.getLineSearch().sendKeys(lineName2);
	        lvmds.getLineSearch().sendKeys(Keys.ENTER);
	        
	        Thread.sleep(5000);
	        utl.scrollToElement(lvmds.getProductSection());

	        // Validate the second searched line name is present
	        Assert.assertTrue(lvmds.getVerifyLineSearchNew().getText().contains(lineName2));
	        System.out.println("Alternative Line Search verified successfully.");
	    }

	    // Return to home page after execution
	    //driver.get(prop.getProperty("lvmurl_prod"));
	    
	}


	@Test(priority = 8)
	public void TS006_VerifyExhibitorDigitalShowroomLinesComponentSeeAllLinesTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T350: Exhibitor Digital Showroom: Lines Component: See All Lines

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		lap = new LVMLandingPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);

		Thread.sleep(8000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		utl.commonMethodForExhibotrDGShowroomm((prop.getProperty("globalsearchinput")));
		// Scroll to Line Section
		//utl.scrollToElement(lvmds.getTotalLinesButton());
		// Click on See All Lines Btn
		//lvmds.getTotalLinesButton().click();
		Actions action=new Actions(driver);
		action.moveToElement(lvmds.getTotalLinesButton()).click().perform();

		Assert.assertTrue(lvmds.getLVMVerifyLinePageTitle().getText().contains("Lines"));
		System.out.println("Lines Component: See All Lines Btn functionality is working properly.");
		//driver.get(prop.getProperty("lvmurl_prod"));
	}

	@Test(priority = 7)
	public void TS007_VerifyExhibitorDigitalShowroomProductsComponentSeeAllProductsTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T348: Exhibitor Digital showroom: Products Component: See All Products

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		lap = new LVMLandingPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);

		Thread.sleep(8000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		utl.commonMethodForExhibotrDGShowroomm((prop.getProperty("globalsearchinput")));

		// Scroll to Product Section
		utl.scrollToElement(lvmds.getProductSection());
		// Click on All Product Btn Btn
		lvmds.getAllProductsButton().click();
		Assert.assertTrue(lvmds.getLVMVerifyLinePageTitle().getText().contains("Products"));
		System.out.println("Products Component: See All Products Btn functionality is working properly.");
		//lkdriver.get(prop.getProperty("lvmurl_prod"));
	}

	@Test(priority = 6) 
	public void TS008_VerifySeeInOtherMarketsForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T333: The See in Other Markets functionality for an Exhibitor Digital Show
		// room
try {
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		lap = new LVMLandingPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);

		Thread.sleep(8000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//utl.commonMethodForExhibotrDGShowroomm((prop.getProperty("globalsearchinput")));	
		utl.commonMethodForExhibotrDGShowroomm("HiEnd Accents");
		// Click See in Other Market button and verify if the page opens
		// utl.scrollToElement( lvmds.getSeeInOtherMarket());
		lvmds.getSeeInOtherMarket().click();
		Assert.assertTrue(lvmds.getVerifyOtherMarketsPage().isDisplayed());
		System.out.println("See In Other Markets page is displayed properly.");

		// Verify Go To Showroom functionality
		String winHandleBefore = driver.getWindowHandle();
		String showroomURL=lvmds.getClickShowroom().getAttribute("href");
		
		// Remove the protocol (http:// or https://)
        String cleanUrl1 = showroomURL.replaceFirst("^(http://|https://)", "");
        
		System.out.println("URL1::"+cleanUrl1);
		lvmds.getClickShowroom().click();
		Thread.sleep(5000);

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		// lap.getIUnderstandBtn().click();
		String currentPageURL=driver.getCurrentUrl();
		
		
		String cleanUrl2 = currentPageURL.replaceFirst("^(http://|https://)", "");
		System.out.println("URL2::"+cleanUrl2);
		Assert.assertTrue(cleanUrl2.contains(cleanUrl1));
		System.out.println("Showroom page is displayed properly.");
		driver.close();
		driver.switchTo().window(winHandleBefore);

		// Verify Contact Exhibitor
		lvmds.getContactExhibitorInOtherMarket().click();
		Thread.sleep(5000);
		Assert.assertTrue(lvmds.getVerifyContactExhibitorPage().isDisplayed());
		System.out.println("Contact Exhibitor page is displayed properly.");
		// lvmds.getContactExhibitorCloseButton().click();
		//driver.get(prop.getProperty("lvmurl_prod"));
	} catch (Exception e) {
        System.out.println("Test Case Failed: " + e.getMessage());
    } finally {
        // Reset to base URL so the next test starts cleanly
        driver.get(prop.getProperty("lvmurl_prod"));
    }
	}

	@Test(priority = 9)
	public void TS009_VerifyExhibitorDigitalShowroomCatalogsComponentSeeAllCatalogsTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T351: Exhibitor Digital Showroom: Catalogs Component: See All Catalogs

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		lap = new LVMLandingPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);

		Thread.sleep(8000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//driver.get(prop.getProperty("lvmurl_prod"));
Thread.sleep(5000);
		lvmgs.getGlobalSearchTextBoxNew().click();
		
		 lvmgs.getGlobalSearchEnterText().sendKeys("   "); // Enter search text "Anne"
	    lvmgs.getSearchButtonNew().click(); // Click on search button
		Thread.sleep(20000);

		
		//utl.scrollToElement(lvmexhact.getdigiShowroomFilterLVMNew());
		
		//lvmexhact.getdigiShowroomFilterLVMNew().click();
		
		Actions action=new Actions(driver);
		
		action.moveToElement(lvmexhact.getdigiShowroomFilterLVMNew()).click().perform();
		
		Thread.sleep(10000);		
		
		action.moveToElement(lvmexhact.getleftPaneFilterDGShowroomCatalogNew()).click().perform();
		
		//lvmexhact.getleftPaneFilterDGShowroomCatalogNew().click();
		Thread.sleep(15000);

		exhname = lvmds.getExhibitorNameNew().getText();
		System.out.println("Exhibitor name: " + exhname);
		
		// Get the Total Lines count on Search grid
		lvmds.getExhibitorNameNew().click();
		Thread.sleep(8000);


		// Scroll to Catalog Section
		// utl.scrollToElement(lvmds.getLVMCatalogSection());
		utl.scrollToElement(lvmds.getCatalogsSection());
		// Click on All Catalog Btn Btn
		lvmds.getLVMCatalogSeeAllBtn().click();

		Assert.assertTrue(lvmds.getLVMVerifyLinePageTitle().getText().contains("Catalogs"));
		System.out.println("Catalogs Component: See All Catalogs Btn functionality is working properly.");
		
	}
	

	@Test(priority = 12)
	public void TS010_VerifyExhibitorDigitalShowroomHeroComponentVisitExhibitorsiteTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T347: Exhibitor Digital showroom: Hero component: Visit <Exhibitor site>
try {
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		lap = new LVMLandingPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);

		Thread.sleep(8000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//driver.get(prop.getProperty("lvmurl_prod"));
		utl.commonMethodForExhibotrDGShowroomm((prop.getProperty("globalsearchinput")));
		
		String visitURL = lvmds.getHeroComponentVisitPROD().getAttribute("href");
		String newURL;
		if (visitURL.contains("http://")) {
			String regex = "http://";
			newURL = visitURL.replaceAll(regex, "");
		} else {
			newURL = visitURL;
		}
		System.out.println("1st URL: " + newURL);
		Thread.sleep(10000);		
		// Click on Hero Component Visit
		String currentWindowID = driver.getWindowHandle();
		lvmds.getHeroComponentVisitPROD().click();
		for (String winddowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winddowHandle);
		}

		Thread.sleep(7000);
		String URL = driver.getCurrentUrl();
		System.out.println("Current URL: " + URL);
		Thread.sleep(5000);
		Assert.assertTrue(URL.contains(newURL));
		driver.close();
		driver.switchTo().window(currentWindowID);
		System.out.println("Hero component: Visit <Exhibitor site> Btn functionality is working properly.");
		//driver.get(prop.getProperty("lvmurl_prod"));
	} catch (Exception e) {
        System.out.println("Test Case Failed: " + e.getMessage());
    } finally {
        // Reset to base URL so the next test starts cleanly
        driver.get(prop.getProperty("lvmurl_prod"));
    }
	}
	

	@Test(priority = 11)
	public void TS011_VerifyExhibitorDigitalShowroomHeroComponentView3DShowroomTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T345: Exhibitor Digital showroom: Hero component: View 3D Showroom
try {
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		lap = new LVMLandingPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);

		
		Thread.sleep(8000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//driver.get(prop.getProperty("lvmurl_prod"));
		utl.commonMethodForExhibotrDGShowroomm((prop.getProperty("exhibitor11")));	
		

		// Click on Hero Component Visit
		lvmds.getView3DshowroomBtn().click();
		Thread.sleep(5000);
		String header3Dshowroom = lvmds.getshowroomHeader3D().getText();
		System.out.println((prop.getProperty("exhibitor11")) + " 3D Showroom");
		Assert.assertTrue(header3Dshowroom.contains((prop.getProperty("exhibitor11")) + " 3D Showroom"));

		System.out.println("Hero component: View 3D Showroom Btn functionality is working properly.");
		lvmds.getView3DshowroomClose().click();
	} catch (Exception e) {
        System.out.println("Test Case Failed: " + e.getMessage());
    } finally {
        // Reset to base URL so the next test starts cleanly
        driver.get(prop.getProperty("lvmurl_prod"));
    }
	}
	
	@Test(priority = 10) //upgradation pending deu to data issue
	public void TS012_VerifyExhibitorDigitalEventsComponentTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T334: Exhibitor Digital showroom: Events Component

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		lap = new LVMLandingPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmevents = new LVMEventsAndWebinarPage(driver);
		
		//driver.get(prop.getProperty("lvmurl_prod"));
		Thread.sleep(8000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		try {
			lap.getIUnderstandBtn().click(); // Click on understand button

			Thread.sleep(8000);
			}catch (Exception e) {
		Thread.sleep(10000);
		//click on Discover tab
		Actions ac=new Actions(driver);
		ac.moveToElement(lvmgs.getLvmDiscoverTab()).click().perform();
	Thread.sleep(3000);
		//Click on Events menu
		ac.moveToElement(lvmgs.getLvmEventsMenu()).click().perform();
		
		Thread.sleep(10000);		
		//Click on Exhibitor events
		lvmgs.getLvmExhibitorEvents().click();
		Thread.sleep(3000);
		//copy exhibitor name
		String exhbName=lvmgs.getLvmEventExhibitorName().getText();
		
		Thread.sleep(3000);
	    lvmgs.getGlobalSearchTextBoxNew().click();
	    lvmgs.getGlobalSearchEnterText().sendKeys(exhbName);
	    lvmgs.getSearchButtonNew().click();
		Thread.sleep(20000);
		
		exhname = lvmds.getExhibitorNameNew().getText();
		System.out.println("Exhibitor name: " + exhname);
		
		lvmds.getExhibitorNameNew().click();
		Thread.sleep(10000);
		
		Thread.sleep(8000);
		
		ac.moveToElement(lvmds.getseeAllEventButton()).click().perform();
	
		//lvmds.getseeAllEventButton().click();
		Thread.sleep(2000);
		
		String eventName = lvmds.getEventNameNew().getText();
		System.out.println("Event Name : " + eventName);
		
		lvmds.getEventNamePROD().click(); // New
		Thread.sleep(3000);
		Assert.assertTrue(lvmevents.getlvmEventNameOnDetailsPageUAT().getText().contains(eventName));
		System.out.println("Events Component functionality is working properly.");
	}
	}

	@Test(priority = 14)
	public void TS013_VerifyCatalogsSectionForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T318: Exhibitor Digital showroom: Catalogs Component
try {
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		lap = new LVMLandingPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmevents = new LVMEventsAndWebinarPage(driver);

		//driver.get(prop.getProperty("lvmurl_prod"));
		Thread.sleep(8000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Thread.sleep(3000);
	    lvmgs.getGlobalSearchTextBoxNew().click();
	    lvmgs.getGlobalSearchEnterText().sendKeys("   ");
		Thread.sleep(1000);
		lvmgs.getSearchButtonNew().click();
		Thread.sleep(10000);		
		/*
		 * Thread.sleep(15000); Thread.sleep(3000);
		 */
		Actions action=new Actions(driver);
		
		action.moveToElement(lvmexhact.getdigiShowroomFilterLVMNew()).click().perform();
		
		Thread.sleep(10000);		
		
		action.moveToElement(lvmexhact.getleftPaneFilterDGShowroomCatalogNew()).click().perform();
		
		//lvmexhact.getleftPaneFilterDGShowroomCatalogNew().click();
		Thread.sleep(15000);
		
	    exhname = lvmds.getExhibitorNameNew().getText();
		System.out.println("Exhibitor name: " + exhname);
		
		lvmds.getExhibitorNameNew().click();
		Thread.sleep(10000);
		
		// Verify Catalogs section for Exhibitor
		utl.scrollToElement(lvmds.getCatalogsSection());
		lvmds.getSeeAllCatalogsButtonUAT().click();
		Assert.assertTrue(lvmds.getValidateLinesPage().getText().contains("Catalogs"));
		System.out.println("See All Catalogs is working properly.");
		//lvmds.getProductsPageBackButton().click();
		driver.navigate().back();
		utl.scrollToElement(lvmds.getCatalogsSection());
		String CatalogName = lvmds.getSelectCatalogProd().getText();
		System.out.println("Catalog Name : " + CatalogName);
		lvmds.getSelectCatalogProd().click();
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Assert.assertTrue(lvmds.getCatalogHeaderTxtT().getText().contains(CatalogName));
		System.out.println("Catalog is displayed properly.");
		/*
		 * driver.close(); driver.switchTo().window(winHandleBefore);
		 */
		
} catch (Exception e) {
    System.out.println("Test Case Failed: " + e.getMessage());
} finally {
    // Reset to base URL so the next test starts cleanly
    driver.get(prop.getProperty("lvmurl_prod"));
}
	}
	

	@Test(priority = 13)// show specials data issue link not available
	public void TS014_VerifyExhibitorDigitalShowroomShowSpecialsTest() throws InterruptedException, IOException {
	    // The purpose of this test case to verify:- 
	    // T319: Exhibitor Digital showroom: Show Specials
try{
	    lvmgs = new LVMGlobalSearchPage(driver);
	    lvmexhact = new LVMExhLineProdActionsPage(driver);
	    lap = new LVMLandingPage(driver);
	    lvmds = new LVMExhDigiShowroomPage(driver);
	    lvmevents = new LVMEventsAndWebinarPage(driver);

	   
	    Thread.sleep(8000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	    Thread.sleep(9000);
	    // Click on Discover tab
	    Actions ac=new Actions(driver);
	    ac.moveToElement(lvmgs.getLvmDiscoverTab()).click().build().perform();
	   // lvmgs.getLvmDiscoverTab().click();
	    Thread.sleep(3000);

	    // Click on Show Specials
	    lvmgs.getlvmShowSpecialsLink().click();
	    Thread.sleep(5000);

	    // Store the name of Show Special Exhibitor
	    String ename = lvmgs.getFirstShowSpecialName().getText();
	    System.out.println(ename);

	    // Check if "Shown By" is present in the exhibitor name
	    String abc;
	    if (ename.contains("Shown By")) {
	        abc = ename.replace("Shown By ", "");
	    } else {
	        abc = ename; // Take the full name if "Shown By" is not present
	    }
	    System.out.println("Exhibitor Name for Search: " + abc);

	    String ShowSpecialDetails = lvmgs.getshowSpecialsDetailsFromShowSpecialsPage().getText();
	    System.out.println("Show Specials Page Details: " + ShowSpecialDetails);

	    // Perform search with the exhibitor name

	    
	    utl.commonMethodForExhibotrDGShowroomm(abc);	

	    // Verify Show Special section for Exhibitor
	    utl.scrollToElement(lvmds.getshowSpecialSection());

	 // Verify both counts
	    String showSpecialCount = lvmds.getShowSpecialCount().getText().trim();
	    String seeAllBtnCount = lvmds.getseeShowSpecials().getText().trim();

	    // Extracting numeric values using regex
	    String splitShowSpecialCount = showSpecialCount.replaceAll("[^0-9]", ""); 
	    String splitSeeAllBtnCount = seeAllBtnCount.replaceAll("[^0-9]", ""); 

	    System.out.println("Show Special Count: " + splitShowSpecialCount);
	    System.out.println("See All Button Count: " + splitSeeAllBtnCount);

	    // Assert both counts are the same
	    Assert.assertEquals(splitShowSpecialCount, splitSeeAllBtnCount);
	    System.out.println("Both counts are the same");
	    //utl.scrollToElement(lvmds.getseeShowSpecials());
	    // Click on See All Show Special
	    lvmds.getseeShowSpecials().click();
	    Assert.assertTrue(lvmds.getValidateLinesPage().getText().contains("Special"));
	    System.out.println("See All Show Specials Btn is working properly.");

	    driver.navigate().back();
	    utl.scrollToElement(lvmds.getshowSpecialSection());

	    // Verify Show Special details on Digital Showroom page
	    String SSDetails = lvmds.getShowSpecialDetailsLVMPROD().getText();
	    System.out.println("DG page Show Special Details: " + SSDetails);
	    Assert.assertTrue(SSDetails.contains(ShowSpecialDetails));
} catch (Exception e) {
    System.out.println("Test Case Failed: " + e.getMessage());
} finally {
    // Reset to base URL so the next test starts cleanly
    driver.get(prop.getProperty("lvmurl_prod"));
}
	}
	

	@Test(priority = 15)
	public void TS015_VerifyExhibitorDigitalShowroomHeroComponentContactExhibitorTest() 
	        throws InterruptedException, IOException {
	    try {
	        lvmgs = new LVMGlobalSearchPage(driver);
	        lvmexhact = new LVMExhLineProdActionsPage(driver);
	        lap = new LVMLandingPage(driver);
	        lvmds = new LVMExhDigiShowroomPage(driver);
	        
	        Thread.sleep(8000);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	        
	        // Call the method that retrieves exhibitor name
	        utl.commonMethodForExhibotrDGShowroomm(prop.getProperty("globalsearchinput"));

	        // Fetch exhibitor name from UtilityClass
	        String exhibitorName = utl.getExhName();
	        
	        // Click on Hero component Contact Exhibitor
	        lvmds.getContactExhibitorHero().click();
	        Thread.sleep(2000);
	        String header3Dshowroom = lvmds.getContactPopUp().getText();
	        
	        System.out.println(exhibitorName + " Contact Exhibitor btn");
	        
	        Assert.assertTrue(header3Dshowroom.contains("Contact " + exhibitorName));
	        System.out.println("Hero component: View Contact Exhibitor Btn functionality is working properly.");
	        
	        lvmds.getContactPopUpClose().click();
	    } catch (Exception e) {
	        System.out.println("Test Case Failed: " + e.getMessage());
	    } finally {
	        driver.get(prop.getProperty("lvmurl_prod"));
	    }
	}

	
	@Test(enabled = false)
	public void TS016_VerifyExhibitorDigitalShowroomHeroComponentOrderOnJuniperMarketTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T303: Exhibitor Digital showroom: Hero component: Order on Juniper Market

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		lap = new LVMLandingPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmevents = new LVMEventsAndWebinarPage(driver);

		//driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);

		lvmgs.getLVMGlobalSearchTextBox().sendKeys((prop.getProperty("exhibitor6")));// globalsearchinputforShowSpecials
		Thread.sleep(5000);
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		exhname = lvmexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		// Get the Total Lines count on Search grid
		lvmds.getExhibitorName().click();
		Thread.sleep(5000);
		String orderOnJuniperURL = lvmds.getheroComponentOrderOnJunperBtn().getAttribute("href");
		// Click on Juniper Market Btn

		String currnetWindowHanldeID = driver.getWindowHandle();
		lvmds.getheroComponentOrderOnJunperBtn().click();
		for (String winddowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winddowHandle);
		}
		Thread.sleep(7000);
		String URL = driver.getCurrentUrl();
		System.out.println(URL);
		Assert.assertTrue(URL.contains(orderOnJuniperURL));
		driver.close();
		driver.switchTo().window(currnetWindowHanldeID);
		System.out.println("Hero component: Order on Juniper Market Btn functionality is working properly.");
	}

	@Test(enabled = false)
	public void TS017_VerifyAddToFavoritesTest() throws InterruptedException {
		// T294: Add To Favorites
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmgs = new LVMGlobalSearchPage(driver);
		lap = new LVMLandingPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("exhibitor4")); // "Anne McGilvray &
																					// Company"
																					// Exhibitor
		// Thread.sleep(5000);
		lvmgs.getLVMSearchButton().click();
		String exhname = lvmds.getSearchedExhibitor().getText(); // Store the 1st Exhibitor name in
																	// String variable
		System.out.println("Exhibitor name: " + exhname);
		lvmds.getExhibitorName().click();
		lvmds.getFavoriteIcon().click(); // Click on add to favorite
		Thread.sleep(1000);
		lap.getMPLinkText().click();// Click on Market Planner link
		lvmmpp.getMPHomeListsTab().click();
		lvmmpp.getLVMMPListsPageFavoritesMenu().click();
		favexhlist = lvmmpp.getFavoriteExhibitorNames();
		for (int i = 0; i < favexhlist.size(); i++) {
			// System.out.println(favexhlist.get(i).getText());
			if (favexhlist.get(i).getText().equals(exhname)) {
				utl.scrollToElement(favexhlist.get(i));
				break;
			}
		}
		lvmmpp.getMoreBtnDeleteOptnExistingList_LVMPROD().click();
		lvmmpp.getLVMEditListItemDeleteOptn().click();
		favlist = driver.findElements(By.xpath("//li[@class='imc-list-edit--draggable']/div/div/div/a"));
		// Verify that the added favorites exhibitor should be removed from Favorites
		// list
		for (int i = 1; i < favlist.size(); i++) {
			// System.out.println(favlist.get(i).getText());
			Assert.assertFalse(favlist.get(i).getText().contains(exhname));
		}
	}

	@Test(enabled = false)
	public void TS018_VerifyAddToExistingListWithPlusIconTest() throws InterruptedException {
		// T297: The Add to existing list functionality for an Exhibitor using Plus icon
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		lvmgs = new LVMGlobalSearchPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("exhibitor4")); // "Anne McGilvray &
																					// Company"
																					// Exhibitor
		Thread.sleep(5000);
		lvmgs.getLVMSearchButton().click();
		String exhname = lvmds.getSearchedExhibitor().getText(); // Store the 1st Exhibitor name in
																	// String variable
		System.out.println("Exhibitor name: " + exhname);
		lvmds.getExhibitorName().click();
		lvmds.getListButtonPlusIcon().click();
		lvmmpp.getLVMMPExistingListName().click();

		// Store the existing list name
		String existinglistname = lvmmpp.getLVMMPExistingListName().getText();
		System.out.println("Existing list name: " + existinglistname);

		// Scroll till Add to Selected button
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				lvmmpp.getLVMMPAddToSelectedBtn());
		lvmmpp.getLVMMPAddToSelectedBtn().click();

		// Click on Go to Market Planner button
		lvmmpp.getGoToMarketPlannerBtn().click();

		// Click on Lists tab on MP home page
		lvmmpp.getMPHomeListsTab().click();
		lvmmpp.getListsPageListsMenu().click();

		mplists = lvmmpp.getLVMMPListsNames();
		mpeditlistoptns = lvmmpp.getLVMMPEditListOptns();

		for (int i = 0; i < mplists.size(); i++) {
			// System.out.println(mplists.get(i).getText());
			// System.out.println(mpeditlistoptns.get(i).getText());
			if (mplists.get(i).getText().equals(existinglistname)) {
				mpeditlistoptns.get(i).click();
				break;
			}
		}
		Thread.sleep(5000);
		Assert.assertTrue(lvmmpp.getLVMSavedExhNameInList().getText().contains(exhname));

		// Delete that added exhibitor from list
		// lvmmpp.getMoreBtnDeleteOptnExistingList_LVMPROD().click();//old
		// lvmmpp.getLVMEditListItemDeleteOptn().click();//old
		lvmmpp.getMoreBtnDeleteOptn_lvmUAT().click();// new
		lvmmpp.getATLEditListItemDeleteOptnNew().click();// new
		Thread.sleep(8000);

		favlist = driver.findElements(By.xpath("//li[@class='imc-list-edit--draggable']/div/div/div/a"));

		// Verify that the added exhibitor should be removed from Existing list
		for (int i = 1; i < favlist.size(); i++) {
			// System.out.println(favlist.get(i).getText());
			Assert.assertFalse(favlist.get(i).getText().contains(exhname));
		}
	}

	@Test(enabled = false)
	public void TS019_VerifyAddNoteListWithPlusIconTest() throws InterruptedException {
		// T300: Add Note for an exhibitor
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		lap = new LVMLandingPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lp = new LVMLoginPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(10000);
		lvmgs.getLVMGlobalSearchTextBox().sendKeys((prop.getProperty("exhibitor4")));
		Thread.sleep(5000);
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(15000);

		// Click Exhibitor Name and click Plus icon
		lvmds.getExhibitorName().click();
		Thread.sleep(10000);
		lvmds.getNoteOptn().click();

		// Add Note and verify Functionality for X (Close button)
		lvmds.getNoteCloseBtn().click();
		Assert.assertTrue(lvmds.getLVMExhDigiShowPage().isDisplayed());
		System.out.println("Close button at Note form works properly.");

		// Verify save note option works properly
		lvmds.getNoteOptn().click();
		Thread.sleep(3000);
		lvmexhact.getNoteTitleTxtBx().sendKeys(genData.generateRandomString(6));
		Thread.sleep(3000);
		// Enter Note Content
		lvmexhact.getNoteContentTxtBx().sendKeys("TestNote" + genData.generateRandomString(15));
		Thread.sleep(3000);
		String NoteTitle = lvmexhact.getNoteTitleTxtBx().getText();
		// Click on 'Save' button
		lvmexhact.getNoteSaveBtn().click();
		Thread.sleep(10000);
		lvmds.getNoteOptn().click();
		Thread.sleep(3000);
		lvmds.getViewAllNotes().click();
		Assert.assertTrue(lvmds.getVerifyAddedNote().getText().contains(NoteTitle));
		System.out.println("Note is added successfully.");
		lvmds.getNoteCloseBtn().click();
	}

	@Test(enabled = false)
	public void TS020_VerifyExhibitorDigitalShowroomProductsComponentOrderOnJuniperMarketTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T349: Exhibitor Digital showroom: Products Component: Order on JuniperMarket

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		lap = new LVMLandingPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		lvmgs.getLVMGlobalSearchTextBox().sendKeys((prop.getProperty("searchjuniperline_lvmuat")));
		Thread.sleep(5000);
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(10000);

		// Store the 1st Exhibitor name in String variable
		exhname = lvmexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);
		lvmds.getExhibitorName().click();
		Thread.sleep(10000);

		// Scroll to Line Section
		utl.scrollToElement(lvmds.getProductSection());
		// Click on Order On Juniper Market Btn
		String OrderOnJuniperMarktURL = lvmds.getOrderOnJuniperMarktBtnCatalog().getAttribute("href");
		String winHandleBefore = driver.getWindowHandle();
		lvmds.getOrderOnJuniperMarktBtnCatalog().click();

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains(OrderOnJuniperMarktURL));
		driver.close();
		driver.switchTo().window(winHandleBefore);
		System.out.println(" Products Component: Order on JuniperMarket Btn functionality is working properly.");
	}

	@Test(enabled = false)
	public void TS021_VerifyExhibitorDigitalShowroomCatalogsComponentOrderOnJuniperMarketTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T352: Exhibitor Digital Sowroom: Catalogs Component: Order on JuniperMarket

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		lap = new LVMLandingPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		lvmgs.getLVMGlobalSearchTextBox().sendKeys((prop.getProperty("exhibitor12")));
		// Thread.sleep(5000);
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(15000);

		// Store the 1st Exhibitor name in String variable
		exhname = lvmexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);
		lvmds.getExhibitorName().click();
		Thread.sleep(5000);

		// Scroll to Line Section
		utl.scrollToElement(lvmds.getLVMCatalogSection());

		// Click on Order On Juniper Market Btn
		String OrderOnJuniperMarktURL = lvmds.getOrderOnJuniperMarktBtnCatalog().getAttribute("href");
		System.out.println(OrderOnJuniperMarktURL);
		lvmds.getOrderOnJuniperMarktBtnCatalog().click();
		Thread.sleep(4000);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Assert.assertTrue(driver.getCurrentUrl().contains(OrderOnJuniperMarktURL));
		driver.close();
		driver.switchTo().window(tabs.get(0));
		System.out.println(" Catalogs Component: Order on JuniperMarket Btn functionality is working properly.");
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		// driver.quit();
	}

}
