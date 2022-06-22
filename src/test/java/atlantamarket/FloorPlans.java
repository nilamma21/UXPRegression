package atlantamarket;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.AtlantaMarket.ATLExhDigiShowroomPage;
import pageObjects.AtlantaMarket.ATLExhLineProdActionsPage;
import pageObjects.AtlantaMarket.ATLFloorPlansPage;
import pageObjects.AtlantaMarket.ATLGlobalSearchPage;
import pageObjects.AtlantaMarket.ATLLandingPage;
import pageObjects.AtlantaMarket.ATLLoginPage;
import pageObjects.AtlantaMarket.ATLMarketPlannerPage;
import pageObjects.AtlantaMarket.ATLProductDetailsPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

@Listeners({ TestListeners.class })
public class FloorPlans extends base {

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
	ATLFloorPlansPage atlflpp;

	List<WebElement> exhlist, linelist, prodlist, searchexhtypelist, searchproducttypelist, mplists, mpeditlistoptns, allnoteslist,favlist, searchlinetypelist;

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

		// Login to Market Planner
		utl.verifyMPLoginFunctionality();

		Thread.sleep(6000);
		lap.getCloseMarktAdBtn().click();
	}
	
	@Test(priority = 1)
	public void TS001_VerifyNavigationToDifferentFloorBuildingsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T285: To verify Floor Plans: Navigation to different floor/buildings
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp=new ATLFloorPlansPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Exh And Product Tab
		atlflpp.getATLExhibitorsAndProductTab().click();
		
		//click on Floor plans link
		atlflpp.getATLFloorPlansLink().click();

		Thread.sleep(5000);
		//Verify that user should redirect to Floor plans page
		Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("atlmrkturl_uat")+"Market-Map"));
		
		//Click on Building floor
		String floorName=atlflpp.getATLBuildingFloor().getText();
		System.out.println("Floor Name : " +floorName);
		atlflpp.getATLBuildingFloor().click();
		
		//Verify floor name
		Assert.assertTrue(atlflpp.getATLFloorName().getText().contains(floorName));
	}

	
	@Test(priority = 3)
	public void TS003_VerifyFloorPlansNoExhibitorsLoadingMessageTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T286: To verify Floor Plans: No Exhibitors or Loading message
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp=new ATLFloorPlansPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Exh And Product Tab
		atlflpp.getATLExhibitorsAndProductTab().click();
		//click on Floor plans link
		atlflpp.getATLFloorPlansLink().click();
		String floorPlansPageUrl=prop.getProperty("floorPlansPageURL");
		driver.getCurrentUrl().contains(floorPlansPageUrl);
		//Verify Floor plans page URL
		Assert.assertTrue(driver.getCurrentUrl().contains(floorPlansPageUrl));
		//Click on Building floor
		String floorName=atlflpp.getATLBuildingFloor().getText();
		System.out.println("Floor Name : " +floorName);
		//click on No Exhibitor floor
		atlflpp.getATLNoExhibitorFloor().click();
		String noExhMsg=atlflpp.getATLNoExpMsg().getText();
		System.out.println(noExhMsg);
		//Verify No Exhibitor msg
		Assert.assertTrue(atlflpp.getATLNoExpMsg().getText().contains(noExhMsg));
	}
	
	@Test(priority = 4)
	public void TS004_VerifyFloorPlansZoomInOutLevelTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T287: To verify Floor Plans: Zoom Levels
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp=new ATLFloorPlansPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Exh And Product Tab
		atlflpp.getATLExhibitorsAndProductTab().click();
		//click on Floor plans link
		atlflpp.getATLFloorPlansLink().click();
		String floorPlansPageUrl=prop.getProperty("floorPlansPageURL");
		driver.getCurrentUrl().contains(floorPlansPageUrl);
		//Verify Floor plans page URL
		Assert.assertTrue(driver.getCurrentUrl().contains(floorPlansPageUrl));
		//Click on Building floor
		String floorName=atlflpp.getATLBuildingFloor().getText();
		System.out.println("Floor Name : " +floorName);
		//click on No Exhibitor floor
		atlflpp.getATLNoExhibitorFloor().click();
		
		atlflpp.getATLExhibitorFloorZoomIn().click();
		//Stored Zoom in Attribute
		String x1=atlflpp.getATLZoomInOutAttribute().getAttribute("style");
		atlflpp.getATLExhibitorFloorZoomIn().click();
		//Stored Zoom in Attribute
		String x2=atlflpp.getATLZoomInOutAttribute().getAttribute("style");
		//Stored Zoom in Attribute
		atlflpp.getATLExhibitorFloorZoomIn().click();
		String x3=atlflpp.getATLZoomInOutAttribute().getAttribute("style");
		
		//Verify ZoomIn Attributes
		Assert.assertNotEquals(x2, x3);
		
		Thread.sleep(5000);
		//zoom Out
		atlflpp.getATLExhibitorFloorZoomOut().click();
		atlflpp.getATLExhibitorFloorZoomOut().click();
		//Stored Zoom out Attribute
		String out=atlflpp.getATLZoomInOutAttribute().getAttribute("style");
		//Verify ZoomOut
		Assert.assertNotEquals(x1, out);
		
	}

	@Test(priority = 5)
	public void TS005_VerifyFloorPlansIconsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T289: To verify Floor Plans: Icons
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp=new ATLFloorPlansPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Exh And Product Tab
		atlflpp.getATLExhibitorsAndProductTab().click();
		//click on Floor plans link
		atlflpp.getATLFloorPlansLink().click();
		String floorPlansPageUrl=prop.getProperty("floorPlansPageURL");
		driver.getCurrentUrl().contains(floorPlansPageUrl);
		//Verify Floor plans page URL
		Assert.assertTrue(driver.getCurrentUrl().contains(floorPlansPageUrl));
		//Click on Building floor
		String floorName=atlflpp.getATLBuildingFloor().getText();
		System.out.println("Floor Name : " +floorName);
		//click on No Exhibitor floor
		atlflpp.getATLNoExhibitorFloor().click();
		//Click on ZoomIn +button
		atlflpp.getATLExhibitorFloorZoomIn().click();
		atlflpp.getATLExhibitorFloorZoomIn().click();
		String atlIconHeader=atlflpp.getATLIconText().getText();
		System.out.println("Icon Header : "+atlIconHeader);
		//Click on Icon
		atlflpp.getATLIcon().click();
		
		//Verify Icon popup
		System.out.println("Popup Text : "+atlflpp.getATLIconPopupText().getText());
		Assert.assertTrue(atlflpp.getATLIconPopupText().getText().contains(atlIconHeader));
	}
	
	



	@AfterClass
	public void tearDown()
	{
		//driver.quit();
	}
}
