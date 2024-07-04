package atlantamarket_PROD;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.AtlantaMarket.ATLEventsAndWebinarPage;
import pageObjects.AtlantaMarket.ATLExhDigiShowroomPage;
import pageObjects.AtlantaMarket.ATLExhLineProdActionsPage;
import pageObjects.AtlantaMarket.ATLGlobalSearchPage;
import pageObjects.AtlantaMarket.ATLLandingPage;
import pageObjects.AtlantaMarket.ATLLeftPaneFilters;
import pageObjects.AtlantaMarket.ATLLoginPage;
import pageObjects.AtlantaMarket.ATLMarketPlannerPage;
import pageObjects.AtlantaMarket.ATLProductDetailsPage;
import pageObjects.LasVegasMarket.LVMExhDigiShowroomPage;
import pageObjects.LasVegasMarket.LVMExhLineProdActionsPage;
import pageObjects.LasVegasMarket.LVMGlobalSearchPage;
import pageObjects.LasVegasMarket.LVMLandingPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

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
	ATLEventsAndWebinarPage atlevents;

	List<WebElement> exhlist, linelist, prodlist, searchexhtypelist, searchproducttypelist, mplists, mpeditlistoptns,
	allnoteslist, favlist, searchlinetypelist, tagBlogPost, taglist, infoFilterList,favexhlist;

	@BeforeClass(alwaysRun=true)
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		// chromeVersion();
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);

		// Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("atlmrkturl_prod"));
		lap.getIUnderstandBtn().click();
		Thread.sleep(3000);

		//utl.verifyMPLoginFunctionality();
/*		Thread.sleep(2000);
		driver.get(prop.getProperty("atlmrkturl_prod"));;
		driver.navigate().refresh();
		Thread.sleep(5000);*/
		//utl.CloseATLPopup();
	}

	@Test(priority = 1)//groups="Non_MP"
	public void TS001_VerifyClickOnLocationLinksForExhibitorDigitalShowroomTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T301: The click on 'Location Links' functionality for an Exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		
		driver.get(prop.getProperty("atlmrkturl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();
		Thread.sleep(7000); 
		
		// Click on any of the Location link present in Exhibitor card and verify result
		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(5000);
		String locationlink = atlexhdgshw.getLocation().getAttribute("href");
		atlexhdgshw.getLocation().click();
		Thread.sleep(10000);
/*		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}*/
		Assert.assertTrue(locationlink.equals(driver.getCurrentUrl()));
		System.out.println("Locations page is displayed properly.");
/*		driver.close();
		driver.switchTo().window(winHandleBefore);*/
	}

	@Test(priority = 2)//groups="Non_MP"
	public void TS002_VerifyClickOnTotalLinesSeeAllLinkForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T312: The click on 'Total lines-See All' functionality for an Exhibitor Digital Show room

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		driver.get(prop.getProperty("atlmrkturl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(6000);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		Thread.sleep(500);
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);
		
		// Get the Total Lines count on Search grid
		String temp = atlexhdgshw.getLinesShownTxtOnSearchGrid().getText();
		String totallinescountonsearchgrid = temp.replaceAll("[^0-9]", "");
		System.out.println("Total Lines Count on Search Results grid is: " + totallinescountonsearchgrid);

		// Store the 1st Exhibitor name in String variable
		exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		// Get the Total Lines count on Search grid
		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(5000);
		String temp1 = atlexhdgshw.getTotalLinesButton().getText();
		String totallinescountondgtab = temp1.replaceAll("[^0-9]", "");
		System.out.println("Lines count on Lines section:"+totallinescountondgtab);
		Assert.assertTrue(totallinescountondgtab.contains(totallinescountonsearchgrid));
		Thread.sleep(4000);
		// Click on Total Lines-See All link for 1st Exhibitor
		utl.scrollElementIntoMiddle(atlexhdgshw.getTotalLinesButton());
		Thread.sleep(500);
		atlexhdgshw.getTotalLinesButton().click();
		Thread.sleep(6000);

		// Verify that user should redirect to the Lines page
		Assert.assertTrue(atlexhdgshw.getValidateLinesPage().getText().contains("Lines"));
		Thread.sleep(8000);
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains(exhname+" Lines"));

		// Get the Total Lines count on Lines page
		String linestabtitle = atlexhdgshw.getLinesCountAtLinesPage().getText();
		String totallinescountonlinespage = linestabtitle.replaceAll("[^0-9]", "");
		System.out.println("Total Lines Count on Lines page is: " + totallinescountonlinespage);
		Assert.assertTrue(totallinescountonlinespage.contains(totallinescountondgtab));
	}

	@Test(priority = 3)//groups="Non_MP"
	public void TS003_VerifyClickOnProductShownLinkForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T311: The click on 'Product Shown-See All' functionality for an Exhibitor Digital Showroom

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		driver.get(prop.getProperty("atlmrkturl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(6000);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput"))); 
		atlgs.getATLSearchButton().click();
		Thread.sleep(15000);
		
		// Store the 1st Exhibitor name in String variable
		exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		// Get the Total Products count on Exh DG Showroom
		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(7000);
		utl.scrollElementIntoMiddle(atlexhdgshw.getProductSection());
		Thread.sleep(200);
		String temp = atlexhdgshw.getProductSection().getText();
		String totalprodcountonexhdgshowroom = temp.replaceAll("[^0-9]", "");
		System.out.println("Total Products Count on Exh DG Showroom is: " + totalprodcountonexhdgshowroom);
		Assert.assertTrue(atlexhdgshw.getAllProductsButton().getText().contains(totalprodcountonexhdgshowroom));

		// Click on Total Products-See All link for 1st Exhibitor
		atlexhdgshw.getAllProductsButton().click();
		Thread.sleep(6000);

		// Verify that user should redirect to the Products page
		Assert.assertTrue(atlexhdgshw.getValidateLinesPage().getText().contains("Products"));
		Thread.sleep(9000);

		// Get the Total Products count on Products page
		String productstabtitle =atlexhact.getValidateProductsPage().getText();
		String totalproductscountonprodpage = productstabtitle.replaceAll("[^0-9]", "");
		System.out.println("Total Products Count on Products page is: " + totalproductscountonprodpage);
		Assert.assertTrue(totalprodcountonexhdgshowroom.equals(totalproductscountonprodpage));
		
		/*//Get back to Exhibitor Showroom page and click any one product and verify if product details are displayed properly
		atlexhdgshw.getProductsPageBackButton().click();
		utl.scrollElementIntoMiddle(atlexhdgshw.getProductSection());
		String producttext = atlexhdgshw.getProductText().getText();
		System.out.println(producttext);
		atlexhdgshw.getProductsList().click();
		Thread.sleep(5000);

		String lName=atlexhdgshw.getValidateLinesPage().getText();
		String lineName=lName.split(" ")[0].trim();
		Assert.assertTrue(producttext.contains(lineName));

		Assert.assertTrue(producttext.contains(atlexhdgshw.getValidateLinesPage().getText()));*/
	}

	@Test(priority = 4)//groups="Non_MP"
	public void TS004_VerifyClickOnLineFiltersForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T315: The click on Line Filters functionality for an Exhibitor Digital Show room

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		driver.get(prop.getProperty("atlmrkturl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(6000);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		Thread.sleep(500);
		atlgs.getATLSearchButton().click();

		Thread.sleep(5000);
		// Store the 1st Exhibitor name in String variable
		exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		// Get the Total Lines count on Search grid
		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(5000);
		utl.scrollElementIntoMiddle(atlexhdgshw.getAlphabeticSorting());
		Thread.sleep(500);
		//Verify A-Z sorting
		atlexhdgshw.getAlphabeticSorting().click();
		Thread.sleep(2000);
		Assert.assertTrue(atlexhdgshw.getLinesOptionText().getText().startsWith("A"));
	}

	@Test(priority = 5)//groups="Non_MP"
	public void TS005_VerifyClickOnLineSearchForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T659: The click on Line Filters functionality for an Exhibitor Digital Show room

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		
		driver.get(prop.getProperty("atlmrkturl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("exhibitor14")));
		atlgs.getATLSearchButton().click();
		Thread.sleep(8000);

		//Click on the 1st Exhibitor name
		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(3000);
		utl.scrollElementIntoMiddle(atlexhdgshw.getLinesSection());
		Thread.sleep(500);
		//Verify Line Search functionality
		atlexhdgshw.getLineSearch().click();
		atlexhdgshw.getLineSearch().sendKeys(prop.getProperty("line3"));
		utl.scrollElementIntoMiddle(atlexhdgshw.getLineSearchButton());
		Thread.sleep(200);
		atlexhdgshw.getLineSearchButton().click();
		Thread.sleep(5000);
		Assert.assertTrue(prop.getProperty("line3").contains(atlexhdgshw.getVerifyLineSearch().getText()));	
	}
	
	@Test(priority = 6)//groups="Non_MP"
	public void TS006_VerifyExhibitorDigitalShowroomLinesComponentSeeAllLinesTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T691: Exhibitor Digital Showroom: Lines Component: See All Lines

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		driver.get(prop.getProperty("atlmrkturl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
		
		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		// Get the Total Lines count on Search grid
		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(5000);
		//Scroll to Line Section
		utl.scrollElementIntoMiddle(atlexhdgshw.getLinesSection());
		Thread.sleep(500);
		//Click on See All Lines Btn
		atlexhdgshw.getTotalLinesButton().click();
		Thread.sleep(2000);
		Assert.assertTrue(atlexhdgshw.getATLVerifyLinePageTitle().getText().contains("Lines"));
		System.out.println("Lines Component: See All Lines Btn functionality is working properly.");
	}

	@Test(priority = 7)//groups="Non_MP"
	public void TS007_VerifyExhibitorDigitalShowroomProductsComponentSeeAllProductsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T348: Exhibitor Digital showroom: Products Component: See All Products

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		driver.get(prop.getProperty("atlmrkturl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(8000);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(8000);
		//Scroll to Product Section
		utl.scrollElementIntoMiddle(atlexhdgshw.getAllProductsButton());
		Thread.sleep(500);
		//Click on All Product Btn Btn
		atlexhdgshw.getAllProductsButton().click();
		Thread.sleep(2000);
		Assert.assertTrue(atlexhdgshw.getATLVerifyLinePageTitle().getText().contains("Products"));
		System.out.println("Products Component: See All Products Btn functionality is working properly.");
	}

	@Test(priority = 8)//groups="Non_MP"
	public void TS008_VerifySeeInOtherMarketsForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T333: The See in Other Markets functionality for an Exhibitor Digital Show room

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		driver.get(prop.getProperty("atlmrkturl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(6000);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		// Get the Total Lines count on Search grid
		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(5000);

		//Click See in Other Market button and verify if the page opens
		atlexhdgshw.getSeeInOtherMarket().click();
		Thread.sleep(2000);
		Assert.assertTrue(atlexhdgshw.getVerifyOtherMarketsPage().isDisplayed());
		System.out.println("See In Other Markets page is displayed properly.");

		//Verify Go To Showroom functionality
		String winHandleBefore = driver.getWindowHandle();
		atlexhdgshw.getClickShowroom().click();
		Thread.sleep(5000);

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		lap.getIUnderstandBtn().click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.americasmart.com/exhibitor/"));
		System.out.println("Showroom page is displayed properly.");
		driver.close();
		driver.switchTo().window(winHandleBefore);

		//Verify Contact Exhibitor
		atlexhdgshw.getContactExhibitorInOtherMarket().click();
		Thread.sleep(5000);
		Assert.assertTrue(atlexhdgshw.getVerifyContactExhibitorPage().isDisplayed());
		System.out.println("Contact Exhibitor page is displayed properly.");
		//atlexhdgshw.getContactExhibitorCloseButton().click();
	}
	
	@Test(priority = 9)//groups="Non_MP"
	public void TS009_VerifyExhibitorDigitalShowroomCatalogsComponentSeeAllCatalogsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T351: Exhibitor Digital Showroom: Catalogs Component: See All Catalogs

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		
		driver.get(prop.getProperty("atlmrkturl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
		
        atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("exhibitor11")));//globalsearchinputforInformation
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(7000);
		//Scroll to Catalog Section
		utl.scrollElementIntoMiddle(atlexhdgshw.getATLCatalogSeeAllBtn());
		Thread.sleep(500);
		//Click on All Catalog Btn Btn
		atlexhdgshw.getATLCatalogSeeAllBtn().click();
		Thread.sleep(2000);
		Assert.assertTrue(atlexhdgshw.getATLVerifyLinePageTitle().getText().contains("Catalogs"));
		System.out.println("Catalogs Component: See All Catalogs Btn functionality is working properly.");
	}

	@Test(priority = 10)//groups="Non_MP"
	public void TS010_VerifyExhibitorDigitalShowroomHeroComponentVisitExhibitorsiteTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T347: Exhibitor Digital showroom: Hero component: Visit <Exhibitor site>

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		driver.get(prop.getProperty("atlmrkturl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();
		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(5000);
		utl.scrollElementIntoMiddle(atlexhdgshw.getHeroComponentVisit());
		Thread.sleep(200);
		String visitURL=atlexhdgshw.getHeroComponentVisit().getAttribute("href");
		System.out.println(visitURL);
		//Click on Hero Component Visit
		String currentWindowID=driver.getWindowHandle();
		atlexhdgshw.getHeroComponentVisit().click();
		for (String winddowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winddowHandle);
		}
		Thread.sleep(7000);
		String URL =driver.getCurrentUrl();
		System.out.println(URL);
		Assert.assertTrue(URL.contains(visitURL));
		driver.close();
		driver.switchTo().window(currentWindowID);
		System.out.println("Hero component: Visit <Exhibitor site> Btn functionality is working properly.");
	}
	
	@Test(priority = 11)//groups="Non_MP"
	public void TS011_VerifyExhibitorDigitalShowroomHeroComponentView3DShowroomTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T345: Exhibitor Digital showroom: Hero component: View 3D Showroom

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		driver.get(prop.getProperty("atlmrkturl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("searchexhwithlinesinput")));
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(5000);

		//Click on Hero Component Visit
		atlexhdgshw.getView3DshowroomBtn().click();
		Thread.sleep(5000);
		String header3Dshowroom=atlexhdgshw.getshowroomHeader3D().getText();
		System.out.println(exhname +" 3D Showroom");
		Assert.assertTrue(header3Dshowroom.contains(exhname +" 3D Showroom"));

		System.out.println("Hero component: View 3D Showroom Btn functionality is working properly.");
		atlexhdgshw.getView3DshowroomClose().click();
	}
	
	@Test(priority = 12)//groups="Non_MP"
	public void TS012_VerifyExhibitorDigitalEventsComponentTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T334: Exhibitor Digital showroom: Events Component

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlevents=new ATLEventsAndWebinarPage(driver);
		
		driver.get(prop.getProperty("atlmrkturl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinputforShowSpecials4")));
		atlgs.getATLSearchButton().click();

		Thread.sleep(7000);
		// Store the 1st Exhibitor name in String variable
		exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(9000);
		// Scroll to Line Section
		utl.scrollElementIntoMiddle(atlexhdgshw.getSeeAllEventsBtn());
		// Click on See All Events Btn
		Thread.sleep(2000);
		atlexhdgshw.getSeeAllEventsBtn().click();
		Thread.sleep(4000);
		/*Assert.assertTrue(atlexhdgshw.getATLVerifyLinePageTitle().getText().contains("Events"));
		driver.navigate().back();
		utl.scrollElementIntoMiddle(atlexhdgshw.getEventsSection());*/
		utl.scrollElementIntoMiddle(atlexhdgshw.getEventNamePROD());
		Thread.sleep(300);
		String eventName=atlexhdgshw.getEventNamePROD().getText();
		atlexhdgshw.getEventNamePROD().click();
		Thread.sleep(2000);
		Assert.assertTrue(atlevents.getatlEventNameOnDetailsPage().getText().contains(eventName));
		System.out.println("Events Component functionality is working properly.");	
	}

	@Test(priority = 13)//groups="Non_MP"
	public void TS013_VerifyCatalogsSectionForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T318: Exhibitor Digital showroom: Catalogs Component

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlevents=new ATLEventsAndWebinarPage(driver);
		
		driver.get(prop.getProperty("atlmrkturl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("exhibitor11")));//searchforCatalogsInputUAT
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		//Store the 1st Exhibitor name in String variable
		exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		//Get the Total Lines count on Search grid
		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(7000);

		//Verify Catalogs section for Exhibitor
		utl.scrollElementIntoMiddle(atlexhdgshw.getSeeAllCatalogsButton());
		Thread.sleep(500);
		atlexhdgshw.getSeeAllCatalogsButton().click();
		Thread.sleep(2000);
		Assert.assertTrue(atlexhdgshw.getValidateLinesPage().getText().contains("Catalogs"));
		System.out.println("See All Catalogs is working properly.");
		
		atlexhdgshw.getProductsPageBackButton().click();
		Thread.sleep(2000);
		utl.scrollElementIntoMiddle(atlexhdgshw.getCatalogsSection());
		Thread.sleep(200);
		String CatalogName = atlexhdgshw.getSelectCatalog().getText();
		System.out.println("Catalog Name : "+CatalogName);
		
		utl.scrollElementIntoMiddle(atlexhdgshw.getSelectCatalog());
		Thread.sleep(200);
		atlexhdgshw.getSelectCatalog().click();
		Thread.sleep(2000);
		/*String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}*/
		Assert.assertTrue(atlexhdgshw.getValidateLinesPage().getText().contains("pdfview"));
		System.out.println("Catalog is displayed properly.");
		//driver.close();
		//driver.switchTo().window(winHandleBefore);
	}
	
	@Test(priority = 14)//groups="Non_MP"
	public void TS014_VerifyExhibitorDigitalShowroomShowSpecialsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T319: Exhibitor Digital showroom: Show Specials

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlevents=new ATLEventsAndWebinarPage(driver);
		
		driver.get(prop.getProperty("atlmrkturl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinputforShowSpecials4")));//globalsearchinputforShowSpecials
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		//Store the 1st Exhibitor name in String variable
		exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		//Get the Total Lines count on Search grid
		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(5000);

		//Verify Show Special section for Exhibitor
		utl.scrollElementIntoMiddle(atlexhdgshw.getshowSpecialSection());
		Thread.sleep(200);
		//Verify both count
		String shwoSpecialCount=atlexhdgshw.getShowSpecialCount().getText();
		String splitShwSpecialCount= shwoSpecialCount.split(" ")[0].trim();
		String SeeAllBtnCount=atlexhdgshw.getSeeAllshowSpecialBtn().getText();
		String splitSeeAllBtnCount=SeeAllBtnCount.split(" ")[2].trim();

		Assert.assertTrue(splitShwSpecialCount.contains(splitSeeAllBtnCount));
		System.out.println("Both counts are same");
		//Click on See All Show Special
		utl.scrollElementIntoMiddle(atlexhdgshw.getSeeAllshowSpecialBtn());
		Thread.sleep(500);
		atlexhdgshw.getSeeAllshowSpecialBtn().click();
		Thread.sleep(2000);
		Assert.assertTrue(atlexhdgshw.getValidateLinesPage().getText().contains("Specials"));
		System.out.println("See All Show Specials Btn is working properly.");
		atlexhdgshw.getProductsPageBackButton().click();
		Thread.sleep(2000);
		utl.scrollElementIntoMiddle(atlexhdgshw.getshowSpecialSection());
		Thread.sleep(200);
		String ShowSpecialName = atlexhdgshw.getShowSpecialName().getText();
		System.out.println("Show Special Name : "+ShowSpecialName);
	}
	
	  @Test(priority = 15)
	  public void TS015_VerifyExhibitorDigitalShowroomHeroComponentContactExhibitorTest()
	      throws InterruptedException, IOException {
	    // The purpose of this test case to verify:-
	    // T644: Exhibitor Digital showroom: Hero component: Contact Exhibitor

	    atlgs = new ATLGlobalSearchPage(driver);
	    atlexhact = new ATLExhLineProdActionsPage(driver);
	    lap = new ATLLandingPage(driver);
	    atlexhdgshw = new ATLExhDigiShowroomPage(driver);

	    driver.get(prop.getProperty("lvmurl_prod"));
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    Thread.sleep(2000);
	    atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
	    Thread.sleep(2000);
	    atlgs.getATLSearchButton().click();
	    Thread.sleep(10000);

	    // Store the 1st Exhibitor name in String variable
	    exhname = atlexhact.getExhibitorName().getText();
	    System.out.println("Exhibitor name: " + exhname);

	    atlexhdgshw.getExhibitorName().click();
	    Thread.sleep(2000);

	    // Click on Hero component Contact Exhibitor
	    atlexhdgshw.getContactExhibitorHero().click();
	    Thread.sleep(2000);
	    String header3Dshowroom = atlexhdgshw.getContactPopUp().getText();
	    System.out.println(exhname + "Contact Exhibitor btn");
	    Assert.assertTrue(header3Dshowroom.contains("Contact " + exhname));
	    System.out.println("Hero component: View Contact Exhibitor Btn functionality is working properly.");
	    atlexhdgshw.getContactPopUpClose().click();
	  }
	
	   @Test(enabled=false)
	    public void verifyMPLoginFunctionality() throws InterruptedException  {

	        // The purpose of this test case to verify:-
	        // TS1- Login to Market Planner

	        lap = new ATLLandingPage(driver);
	        lp = new ATLLoginPage(driver);

	        // Click on Login button from Landing Page
	        lap.getLogin().click();
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
	    
	    @Test(enabled=false)//priority = 1,groups= "MP_Group",dependsOnMethods= "verifyMPLoginFunctionality"
	    
	    public void TS016_VerifyAddToFavoritesTest() throws InterruptedException, IOException {

	        // The purpose of this test case to verify:-
	        // T294: Add To Favorites

	        atlgs = new ATLGlobalSearchPage(driver);
	        atlexhdgshw = new ATLExhDigiShowroomPage(driver);
	        lap = new ATLLandingPage(driver);
	        atlmppge = new ATLMarketPlannerPage(driver);
	        atlexhact = new ATLExhLineProdActionsPage(driver);

	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        //driver.get(prop.getProperty("atlmrkturl_prod"));
	        utl.loginCheckATL();
	        //Search Exhibitor in global search option
	        atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("exhibitor1"));
	        atlgs.getATLSearchButton().click();

	        // Store the 1st Exhibitor name in String variable
	        String exhname = atlexhact.getExhibitorName().getText();
	        System.out.println("Exhibitor name: " + exhname);

	        // Click on Exhibitor name and login to market planner
	        atlexhdgshw.getSearchedExhibitor().click();
	        //      utl.verifyMPLoginFunctionality();
	        //      lap.getCloseMarktAdBtn().click();

	        //Click Market Planner's Name and go to favorites under Lists tab and verify results
	        //      lap.getMPLinkText().click();
	        //      atlmppge.getMPHomeListsTab().click();
	        //      //atlmppge.getATLMPListsPageFavoritesMenu().click();
	        //      utl.scrollElementIntoMiddle(atlmppge.getmplistsenentsandseminars());
	        //      Thread.sleep(5000);
	        //      Assert.assertTrue(atlexhdgshw.getVerifyExhibitorInFavoritesLists().getText().contains("exhibitor1"));
	        //      System.out.println("Exhibitor is properly displayed at Favorites tab.");

	        atlexhdgshw.getFavoriteIcon().click();

	        // Click on Market Planner link
	        lap.getMPLinkText().click();

	        // Click on Lists tab on MP home page
	        atlmppge.getMPHomeListsTab().click();
	        atlmppge.getATLMPListsPageFavoritesMenu().click();
	        Thread.sleep(4000);

	        // Verify that the added favorites exhibitor should be displayed in to Favorites list
	        //Assert.assertTrue(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));

	        favexhlist = atlmppge.getFavoriteExhibitorNames();

	        for (int i = 0; i < favexhlist.size(); i++) {
	            //System.out.println(favexhlist.get(i).getText());
	            if (favexhlist.get(i).getText().equals(exhname)) {
	                utl.scrollElementIntoMiddle(favexhlist.get(i));
	                break;
	            }
	        }


	        // Delete that favorites exhibitor from list
	        atlmppge.getMoreBtnDeleteOptnExistingList_ATLPROD().click();
	        atlmppge.getATLEditListItemDeleteOptn().click();
	        Thread.sleep(6000);

	        favlist = driver.findElements(By.xpath("//li[@class='imc-list-edit--draggable']/div/div/div/a"));

	        //Verify that the added favorites exhibitor should be removed from Favorites list
	        for(int i=1; i< favlist.size(); i++)
	        {           
	            //System.out.println(favlist.get(i).getText());
	            Assert.assertFalse(favlist.get(i).getText().contains(exhname)); 
	        }
	    }

	    @Test(enabled=false)//priority = 2,groups= "MP_Group",dependsOnMethods= "verifyMPLoginFunctionality"
	    public void TS017_VerifyAddToExistingListWithPlusIconTest() throws InterruptedException, IOException {
	        // The purpose of this test case to verify:-
	        // T297: The Add to existing list functionality for an Exhibitor using Plus icon

	        atlgs = new ATLGlobalSearchPage(driver);
	        atlexhact = new ATLExhLineProdActionsPage(driver);
	        atlmppge = new ATLMarketPlannerPage(driver);
	        lap = new ATLLandingPage(driver);
	        atlexhdgshw = new ATLExhDigiShowroomPage(driver);

	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	        atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("exhibitor1")));
	        atlgs.getATLSearchButton().click();

	        Thread.sleep(15000);
	        // Store the 1st Exhibitor name in String variable
	        String exhname = atlexhact.getExhibitorName().getText();
	        System.out.println("Exhibitor name: " + exhname);

	        // Click Exhibitor Name and click Plus icon
	        atlexhdgshw.getExhibitorName().click();
	        Thread.sleep(4000);
	        atlexhdgshw.getListButtonPlusIcon().click();

	        // Select Existing list name
	        atlmppge.getATLMPExistingListName().click();

	        // Store the existing list name
	        String existinglistname = atlmppge.getATLMPExistingListName().getText();
	        System.out.println("Existing list name: " + existinglistname);

	        // Scroll till Add to Selected button
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollElementIntoMiddle(true);",
	                atlmppge.getATLMPAddToSelectedBtn());
	        atlmppge.getATLMPAddToSelectedBtn().click();

	        // Click on Go to Market Planner button
	        atlmppge.getGoToMarketPlannerBtn().click();

	        // Click on Lists tab on MP home page
	        atlmppge.getMPHomeListsTab().click();
	        atlmppge.getListsPageListsMenu().click();

	        mplists = atlmppge.getATLMPListsNames();
	        mpeditlistoptns = atlmppge.getATLMPEditListOptns();

	        for (int i = 0; i < mplists.size(); i++) {
	            // System.out.println(mplists.get(i).getText());
	            // System.out.println(mpeditlistoptns.get(i).getText());
	            if (mplists.get(i).getText().equals(existinglistname)) {
	                mpeditlistoptns.get(i).click();
	                break;
	            }
	        }
	        
	        Thread.sleep(5000);
	        Assert.assertTrue(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));

	        // Delete that added exhibitor from list
	        atlmppge.getMoreBtnDeleteOptnExistingList_ATLPROD().click();
	        atlmppge.getATLEditListItemDeleteOptn().click();
	        Thread.sleep(8000);

	        favlist = driver.findElements(By.xpath("//li[@class='imc-list-edit--draggable']/div/div/div/a"));

	        //Verify that the added exhibitor should be removed from Existing list
	        for(int i=1; i< favlist.size(); i++)
	        {           
	            //System.out.println(favlist.get(i).getText());
	            Assert.assertFalse(favlist.get(i).getText().contains(exhname)); 
	        }
	    }

	    @Test(enabled=false)//priority = 3,groups= "MP_Group",dependsOnMethods= "verifyMPLoginFunctionality"
	    public void TS018_VerifyAddNoteListWithPlusIconTest() throws InterruptedException, IOException {
	        // The purpose of this test case to verify:-
	        // T300: Add Note for an exhibitor

	        atlgs = new ATLGlobalSearchPage(driver);
	        atlexhact = new ATLExhLineProdActionsPage(driver);
	        atlmppge = new ATLMarketPlannerPage(driver);
	        lap = new ATLLandingPage(driver);
	        atlexhdgshw = new ATLExhDigiShowroomPage(driver);
	        lp = new ATLLoginPage(driver);
	        genData = new GenerateData();

	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        //lap.getIUnderstandBtn().click();
	        Thread.sleep(10000);
	        atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("exhibitor1")));
	        atlgs.getATLSearchButton().click();

	        Thread.sleep(15000);

	        // Click Exhibitor Name and click Plus icon
	        atlexhdgshw.getExhibitorName().click();
	        Thread.sleep(10000);
	        atlexhdgshw.getNoteOptn().click();

	        // Add Note and verify Functionality for X (Close button)
	        atlexhdgshw.getNoteCloseBtn().click();
	        Assert.assertTrue(atlexhdgshw.getATLExhDigiShowPage().isDisplayed());
	        System.out.println("Close button at Note form works properly.");


	        // Verify save note option works properly
	        atlexhdgshw.getNoteOptn().click();
	        Thread.sleep(3000);
	        atlexhact.getNoteTitleTxtBx().sendKeys(genData.generateRandomString(6));
	        Thread.sleep(3000);
	        // Enter Note Content
	        atlexhact.getNoteContentTxtBx().sendKeys("TestNote" + genData.generateRandomString(15));
	        Thread.sleep(3000);
	        String NoteTitle = atlexhact.getNoteTitleTxtBx().getText();
	        // Click on 'Save' button
	        atlexhact.getNoteSaveBtn().click();
	        Thread.sleep(10000);
	        atlexhdgshw.getNoteOptn().click();
	        Thread.sleep(3000);
	        atlexhdgshw.getViewAllNotes().click();
	        Assert.assertTrue(atlexhdgshw.getVerifyAddedNote().getText().contains(NoteTitle));
	        System.out.println("Note is added successfully.");
	    }
	    
	    @Test(enabled=false)//priority = 10, groups="Non_MP"
	    public void TS019_VerifyExhibitorDigitalShowroomProductsComponentOrderOnJuniperMarketTest() throws InterruptedException, IOException {
	        // The purpose of this test case to verify:-
	        // T349: Exhibitor Digital showroom: Products Component: Order on JuniperMarket

	        atlgs = new ATLGlobalSearchPage(driver);
	        atlexhact = new ATLExhLineProdActionsPage(driver);
	        lap = new ATLLandingPage(driver);
	        atlexhdgshw = new ATLExhDigiShowroomPage(driver);

	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	        atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("exhibitor13")));
	        atlgs.getATLSearchButton().click();

	        Thread.sleep(15000);
	        // Store the 1st Exhibitor name in String variable
	        exhname = atlexhact.getExhibitorName().getText();
	        System.out.println("Exhibitor name: " + exhname);

	        atlexhdgshw.getExhibitorName().click();
	        Thread.sleep(5000);
	        //Scroll to Line Section
	        utl.scrollElementIntoMiddle(atlexhdgshw.getProductSection());
	        Thread.sleep(200);
	        //Click on Order On Juniper Market Btn
	        String OrderOnJuniperMarktURL=atlexhdgshw.getOrderOnJuniperMarktBtnCatalog().getAttribute("href");
	        String winHandleBefore = driver.getWindowHandle();
	        atlexhdgshw.getOrderOnJuniperMarktBtnCatalog().click();

	        for (String winHandle : driver.getWindowHandles()) {
	            driver.switchTo().window(winHandle);
	        }
	        Assert.assertTrue(driver.getCurrentUrl().contains(OrderOnJuniperMarktURL));
	        driver.close();
	        driver.switchTo().window(winHandleBefore);
	        System.out.println(" Products Component: Order on JuniperMarket Btn functionality is working properly.");
	    }
	    
	    @Test(enabled=false)//priority = 14, groups="Non_MP"
	    public void TS020_VerifyExhibitorDigitalShowroomCatalogsComponentOrderOnJuniperMarketTest() throws InterruptedException, IOException {
	        // The purpose of this test case to verify:-
	        // T352: Exhibitor Digital Sowroom: Catalogs Component: Order on JuniperMarket

	        atlgs = new ATLGlobalSearchPage(driver);
	        atlexhact = new ATLExhLineProdActionsPage(driver);
	        lap = new ATLLandingPage(driver);
	        atlexhdgshw = new ATLExhDigiShowroomPage(driver);

	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	        atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinputforInformation")));
	        atlgs.getATLSearchButton().click();

	        Thread.sleep(15000);
	        // Store the 1st Exhibitor name in String variable
	        exhname = atlexhact.getExhibitorName().getText();
	        System.out.println("Exhibitor name: " + exhname);

	        atlexhdgshw.getExhibitorName().click();
	        Thread.sleep(5000);
	        //Scroll to Line Section
	        utl.scrollElementIntoMiddle(atlexhdgshw.getATLCatalogSection());
	        Thread.sleep(200);
	        //Click on Order On Juniper Market Btn
	        String OrderOnJuniperMarktURL=atlexhdgshw.getOrderOnJuniperMarktBtnCatalog().getAttribute("href");
	        atlexhdgshw.getOrderOnJuniperMarktBtnCatalog().click();

	        Assert.assertTrue(driver.getCurrentUrl().contains(OrderOnJuniperMarktURL));
	        System.out.println(" Catalogs Component: Order on JuniperMarket Btn functionality is working properly.");
	    }
	    
	    @Test(enabled=false)//priority = 20, groups="Non_MP"
	    public void TS021_VerifyExhibitorDigitalShowroomHeroComponentOrderOnJuniperMarketTest() throws InterruptedException, IOException {
	        // The purpose of this test case to verify:-
	        // T303: Exhibitor Digital showroom: Hero component: Order on Juniper Market

	        atlgs = new ATLGlobalSearchPage(driver);
	        atlexhact = new ATLExhLineProdActionsPage(driver);
	        lap = new ATLLandingPage(driver);
	        atlexhdgshw = new ATLExhDigiShowroomPage(driver);

	        atlevents=new ATLEventsAndWebinarPage(driver);
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	        atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("exhibitor13")));
	        atlgs.getATLSearchButton().click();

	        Thread.sleep(15000);
	        //Store the 1st Exhibitor name in String variable
	        exhname = atlexhact.getExhibitorName().getText();
	        System.out.println("Exhibitor name: " + exhname);

	        //Get the Total Lines count on Search grid
	        atlexhdgshw.getExhibitorName().click();
	        Thread.sleep(5000);
	        String orderOnJuniperURL=atlexhdgshw.getheroComponentOrderOnJunperBtn().getAttribute("href");
	        //Click on Juniper Market Btn

	        String currnetWindowHanldeID=driver.getWindowHandle();
	        atlexhdgshw.getheroComponentOrderOnJunperBtn().click();
	        for (String  winddowHandle : driver.getWindowHandles()) {
	            driver.switchTo().window(winddowHandle);
	        }
	        Thread.sleep(7000);
	        String URL =driver.getCurrentUrl();
	        System.out.println(URL);
	        Assert.assertTrue(URL.contains(orderOnJuniperURL));
	        driver.close();
	        driver.switchTo().window(currnetWindowHanldeID);
	        System.out.println("Hero component: Order on Juniper Market Btn functionality is working properly.");
	    }


	@AfterClass(alwaysRun=true)
	public void tearDown() {
		//driver.quit();
	}

}

