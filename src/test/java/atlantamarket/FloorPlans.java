package atlantamarket;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

		/*	// Login to Market Planner
		utl.verifyMPLoginFunctionality();

		Thread.sleep(8000);
		lap.getCloseMarktAdBtn().click();*/
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

		//Click on Building/floor
		String floorName=atlflpp.getATLBuildingFloor().getText();
		System.out.println("Floor Name : " +floorName);

		String locationlink = atlflpp.getATLBuildingFloor().getAttribute("href");
		System.out.println(locationlink);

		atlflpp.getATLBuildingFloor().click();
		Thread.sleep(5000);

		// Verify that selected building-floor plan page should be opened
		Assert.assertTrue(locationlink.equals(driver.getCurrentUrl()));

		//Verify selected floor name
		Assert.assertTrue(atlflpp.getATLFloorName().getText().contains(floorName));
	}

	@Test(priority = 3)
	public void TS003_VerifyNoExhibitorsOnThisFloorMessageTest() throws InterruptedException, IOException {
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

		//click on Floor whose not having an Exhibitors
		atlflpp.getATLNoExhibitorFloor().click();

		//Verify that Loading Exhibitors msg should be displayed
		Assert.assertTrue(atlflpp.getATLLoadingExhMsg().isDisplayed());

		//Verify that No Exhibitor msg should be displayed
		Assert.assertTrue(atlflpp.getATLNoExpMsg().isDisplayed());
	}

	@Test(priority = 4)
	public void TS004_VerifyZoomInOutLevelOnFloorPlansPageTest() throws InterruptedException, IOException {
		// The purpose of this test case:-
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

		//click on any floor
		atlflpp.getATLBuildingFloor().click();

		//Click on Zoom In icon
		atlflpp.getATLExhibitorFloorZoomIn().click();
		//Stored Zoom in Attribute
		String x1=atlflpp.getATLFloorPlanMapIamge().getAttribute("style");

		atlflpp.getATLExhibitorFloorZoomIn().click();
		//Stored Zoom in Attribute
		String x2=atlflpp.getATLFloorPlanMapIamge().getAttribute("style");

		//Stored Zoom in Attribute
		atlflpp.getATLExhibitorFloorZoomIn().click();
		String x3=atlflpp.getATLFloorPlanMapIamge().getAttribute("style");

		//Verify Zoom In functionality
		Assert.assertNotEquals(x2, x3);
		Thread.sleep(5000);

		//Click on Zoom Out icon
		atlflpp.getATLExhibitorFloorZoomOut().click();
		atlflpp.getATLExhibitorFloorZoomOut().click();
		//Stored Zoom out Attribute
		String out=atlflpp.getATLFloorPlanMapIamge().getAttribute("style");

		//Verify Zoom Out functionality
		Assert.assertNotEquals(x1, out);
	}

	@Test(priority = 5)
	public void TS005_VerifyFloorPlansIconsTest() throws InterruptedException, IOException {
		// The purpose of this test case to:-
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

		//click on any floor
		atlflpp.getATLBuildingFloor().click();

		//Click on Vending Machine icon on Map image
		atlflpp.getVendingMachineIconOnMap().click();

		//Verify that Vending Machine Overlay should appeared on Map
		Assert.assertTrue(atlflpp.getVendingMachineOverlayOnMap().isDisplayed());

		//Click on Elevator icon on Map image
		atlflpp.getElevatorIconOnMap().click();

		//Verify that Elevator Overlay should appeared on Map
		Assert.assertTrue(atlflpp.getElevatorOverlayOnMap().isDisplayed());

		//Click on Water Fountain icon on Map image
		atlflpp.getWaterFountainIconOnMap().click();

		//Verify that Water Fountain Overlay should appeared on Map
		Assert.assertTrue(atlflpp.getWaterFountainOverlayOnMap().isDisplayed());

		//Click on Phone icon on Map image
		atlflpp.getPhoneIconOnMap().click();

		//Verify that Phone Overlay should appeared on Map
		Assert.assertTrue(atlflpp.getPhoneOverlayOnMap().isDisplayed());
		
		//Click on Overlay Close btn
		atlflpp.getOverlayCloseBtn().click();
		
		
		//Not working below code
		/*//Click on Location pin of any Exhibitor on Map
		Actions act = new Actions(driver);
		act.doubleClick(atlflpp.getLocationPinIconOnMap()).perform();
		act.click(atlflpp.getLocationPinIconOnMap()).perform();
		
		//Verify that select Exhibitor's location details should be displayed in popup
		Assert.assertTrue(atlflpp.getExhibitorDetailsModal().isDisplayed());
		
		//Verify the Exhibitor name on Details modal
		String exhnameonlocationpin = atlflpp.getLocationPinIconOnMap().getText();
		Assert.assertEquals(atlflpp.getExhNameOnExhibitorDetailsModal().getText(), exhnameonlocationpin);*/

	}





	/*	@AfterClass
	public void tearDown()
	{
		//driver.quit();
	}*/
}
