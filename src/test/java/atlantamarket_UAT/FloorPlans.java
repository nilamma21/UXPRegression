package atlantamarket_UAT;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import atlantamarket_UAT.TestListeners;
import pageObjects.AtlantaMarket.ATLExhDigiShowroomPage;
import pageObjects.AtlantaMarket.ATLExhLineProdActionsPage;
import pageObjects.AtlantaMarket.ATLFloorPlansPage;
import pageObjects.AtlantaMarket.ATLGlobalSearchPage;
import pageObjects.AtlantaMarket.ATLLandingPage;
import pageObjects.AtlantaMarket.ATLLoginPage;
//import pageObjects.AtlantaMarket.ATLMarketPlannerPage;
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
	//ATLMarketPlannerPage atlmppge;
	ATLFloorPlansPage atlflpp;

	List<WebElement> exhlist, linelist, prodlist, searchexhtypelist, searchproducttypelist, mplists, mpeditlistoptns, allnoteslist,favlist, searchlinetypelist;

	@BeforeClass(alwaysRun=true)
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);

		// Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("atlmrkturl_uat"));
		lap.getIUnderstandBtn().click();
		Thread.sleep(7000);
		//lap.getCloseMarktAdBtn().click();

		//Login to Market Planner
		//utl.verifyMPLoginFunctionality();
		//utl.loginCheckATL();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(8000);
		//lap.getCloseMarktAdBtn().click();
	}
	@Test (enabled=false)
	public void verifyMPLoginFunctionality() throws IOException, InterruptedException {

		// The purpose of this test case to verify:-
		// TS1- Login to Market Planner

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);

		// Click on Login button from Landing Page
		lap.getLogin().click();
		
		// Enter the credentials on Login Page and click
		lp.getEmailAddress().sendKeys((prop.getProperty("username")));

		lp.getPassword().sendKeys((prop.getProperty("passwordW")));


		Thread.sleep(1000);
	//	lp.getPassword().sendKeys((prop.getProperty("password")));
		Thread.sleep(1000);

		lp.getSignInBtn().click();
		Thread.sleep(15000);
		Assert.assertTrue(driver.getTitle().contains("Atlanta Market at AmericasMart"));
	}
	
	@Test(priority = 1,groups="Non_MP")
	public void TS001_VerifyNavigationToDifferentFloorBuildingsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T627: To verify Floor Plans: Navigation to different floor/buildings
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp=new ATLFloorPlansPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Click on Exh And Product Tab
		atlflpp.getATLExhibitorsAndProductTab().click();
		Thread.sleep(500);
		//click on Floor plans link
		atlflpp.getATLFloorPlansLink().click();
		Thread.sleep(2000);

		//Verify that user should redirect to Floor plans page
		Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("atlmrkturl_uat")+"Market-Map"));

		//Click on Building/floor
		String floorName=atlflpp.getATLBuildingFloor().getText();
		System.out.println("Floor Name : " +floorName);

		String locationlink = atlflpp.getATLBuildingFloor().getAttribute("href");
		System.out.println(locationlink);
		
		utl.scrollToElement(atlflpp.getATLBuildingFloor());
		atlflpp.getATLBuildingFloor().click();
		Thread.sleep(3000);

		// Verify that selected building-floor plan page should be opened
		Assert.assertTrue(locationlink.equals(driver.getCurrentUrl()));
		String check = atlflpp.getATLFloorName().getText();
		System.out.println(check);
		//Verify selected floor name
		Assert.assertTrue(atlflpp.getATLFloorName().getText().contains(floorName));
		
		String actualNextFloorNumber=atlflpp.getATLNextFloorBtn().getText();
		System.out.println("Actual Next Floor Number: " +actualNextFloorNumber);
		atlflpp.getATLNextFloorBtn().click();
		Thread.sleep(5000);
		String exptectedFloorNumber=atlflpp.getATLExpectedFloorNumber().getText();
		System.out.println("Exptected Floor Number: " +exptectedFloorNumber);
		//Verify Next Floor
		Assert.assertTrue(exptectedFloorNumber.contains(actualNextFloorNumber));
		Thread.sleep(1000);
		//Previous floor Btn
		utl.scrollToElement(atlflpp.getATLPreviousFloorBtn());
		String actualPreviousFloorNumber=atlflpp.getATLPreviousFloorBtn().getText();
		System.out.println("Actual Previous Floor Number: " +actualPreviousFloorNumber);
		atlflpp.getATLPreviousFloorBtn().click();
		Thread.sleep(5000);
		String exptectedPeviousFloorNumber=atlflpp.getATLExpectedFloorNumber().getText();
		System.out.println("Exptected Pevious Floor Number: "+exptectedPeviousFloorNumber);
		//Verify Previous Floor
		Assert.assertTrue(exptectedPeviousFloorNumber.contains(actualPreviousFloorNumber));	
	}

	@Test(priority = 2,groups="Non_MP")
	public void TS002_VerifyNoExhibitorsOnThisFloorMessageTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T628: To verify Floor Plans: No Exhibitors or Loading message

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp=new ATLFloorPlansPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		// Click on Exh And Product Tab
		utl.scrollToElement(atlflpp.getATLExhibitorsAndProductTab());
		atlflpp.getATLExhibitorsAndProductTab().click();
		Thread.sleep(500);
		//click on Floor plans link
		atlflpp.getATLFloorPlansLink().click();
		Thread.sleep(1000);
		//click on Floor whose not having an Exhibitors
		String floorName=atlflpp.getATLBuildingFloor().getText();
		System.out.println("Floor Name : " +floorName);

		//click on No Exhibitor floor
		atlflpp.getATLNoExhibitorFloor().click();
		Thread.sleep(1000);
		//Verify that Loading Exhibitors msg should be displayed
		//Assert.assertTrue(atlflpp.getATLLoadingExhMsg().isDisplayed());

		//Verify that No Exhibitor msg should be displayed
		//Assert.assertTrue(atlflpp.getatlLoadingNoExhiMsg().isDisplayed());
		Assert.assertTrue(atlflpp.getatlLoadingNoExhiMsg().isDisplayed());
	}

	@Test(priority = 3,groups="Non_MP")
	public void TS003_VerifyZoomInOutLevelOnFloorPlansPageTest() throws InterruptedException, IOException {
		// The purpose of this test case:-
		// UXP-T629: To verify Floor Plans: Zoom Levels

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp=new ATLFloorPlansPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(3000);
		// Click on Exh And Product Tab
		atlflpp.getATLExhibitorsAndProductTab().click();
		Thread.sleep(500);
		//click on Floor plans link
		atlflpp.getATLFloorPlansLink().click();
		Thread.sleep(1000);
		//click on any floor
		utl.scrollToElement(atlflpp.getATLBuildingFloor());
		atlflpp.getATLBuildingFloor().click();
		Thread.sleep(3000);
		//Click on Zoom In icon
		String x0=atlflpp.getATLFloorPlanMapIamge().getAttribute("style");
        System.out.println("x0 = "+x0);
		atlflpp.getATLExhibitorFloorZoomIn().click();
		Thread.sleep(2000);
		//Store Zoom in Attribute
		String x1=atlflpp.getATLFloorPlanMapIamge().getAttribute("style");
		System.out.println("x1 = "+x1);
		atlflpp.getATLExhibitorFloorZoomIn().click();
		Thread.sleep(2000);
		//Stored Zoom in Attribute
		String x2=atlflpp.getATLFloorPlanMapIamge().getAttribute("style");
		System.out.println("x2 = "+x2);
		//Store Zoom in Attribute
		atlflpp.getATLExhibitorFloorZoomIn().click();
		Thread.sleep(2000);
		String x3=atlflpp.getATLFloorPlanMapIamge().getAttribute("style");
		System.out.println("x3 = "+x3);
		//Verify Zoom In functionality
		Assert.assertNotEquals(x2, x3);

		//Click on Zoom Out icon
		atlflpp.getATLExhibitorFloorZoomOut().click();
		atlflpp.getATLExhibitorFloorZoomOut().click();
		Thread.sleep(3000);
		//Stored Zoom out Attribute
		String out=atlflpp.getATLFloorPlanMapIamge().getAttribute("style");
		System.out.println("out = "+out);
		//Verify Zoom Out functionality
		System.out.println(x1);
		System.out.println(out);
		Assert.assertNotEquals(x1, out);
	}

	@Test(priority = 4,groups="Non_MP")
	public void TS004_VerifyIconsOnFloorPlansPageTest() throws InterruptedException, IOException {
		// The purpose of this test case to:-
		// UXP-T808: To verify Floor Plans: Icons

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp=new ATLFloorPlansPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		// Click on Exh And Product Tab
		utl.scrollToElement(atlflpp.getATLExhibitorsAndProductTab());
		atlflpp.getATLExhibitorsAndProductTab().click();
		Thread.sleep(1000);
		//click on Floor plans link
		atlflpp.getATLFloorPlansLink().click();
		Thread.sleep(1000);
		//click on any floor
		utl.scrollToElement(atlflpp.getATLBuildingFloor());
		atlflpp.getATLBuildingFloor().click();
		Thread.sleep(1000);
		//Click on Vending Machine icon on Map image
		atlflpp.getVendingMachineIconOnMap().click();
		Thread.sleep(1500);
		//Verify that Vending Machine Overlay should appeared on Map
		Assert.assertTrue(atlflpp.getVendingMachineOverlayOnMap().isDisplayed());

		//Click on Elevator icon on Map image
		atlflpp.getElevatorIconOnMap().click();
		Thread.sleep(1500);
		//Verify that Elevator Overlay should appeared on Map
		Assert.assertTrue(atlflpp.getElevatorOverlayOnMap().isDisplayed());

	/*	//Click on Water Fountain icon on Map image
		atlflpp.getWaterFountainIconOnMap().click();

		//Verify that Water Fountain Overlay should appeared on Map
		Assert.assertTrue(atlflpp.getWaterFountainOverlayOnMap().isDisplayed());
*/
		//Click on Phone icon on Map image
		atlflpp.getPhoneIconOnMap().click();
		Thread.sleep(1000);
		//Verify that Phone Overlay should appeared on Map
		Assert.assertTrue(atlflpp.getPhoneOverlayOnMap().isDisplayed());

		//Click on Overlay Close btn
		atlflpp.getOverlayCloseBtn().click();
		Thread.sleep(1000);
		//Click on Location pin of any Exhibitor on Map
		atlflpp.getLocationPinIconOnMap().click();
		Thread.sleep(500);
		//Verify that select Exhibitor's location details should be displayed in popup
		Assert.assertTrue(atlflpp.getExhibitorDetailsModal().isDisplayed());

		//Store the Exhibitor name on details modal
		String exhnameondetailsmodal = atlflpp.getExhNameOnExhibitorDetailsModal().getText();

		//Click on 'View Digital Showroom' button
		atlflpp.getViewDGShowroombtn().click();
		Thread.sleep(500);
		//Verify that user should redirected to Exh Digital Showroom page
		Assert.assertTrue(atlexhdgshw.getATLValidateExhDigiShowPage().isDisplayed());

		//Verify the Exhibitor name on Exh Digital Showroom
		Thread.sleep(10000);
		Assert.assertTrue(driver.getTitle().contains(""+exhnameondetailsmodal+" at Atlanta Market"));
	//	Assert.assertTrue(atlgs.getinfoTitleOnSeeDetailsPage().getText().contains(exhnameondetailsmodal));
	}

	@Test(priority = 5,groups="Non_MP")
	public void TS005_VerifyFunctionalityOfFiltersOnFloorPlansPageTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T290: To verify Floor Plans: Filter
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp=new ATLFloorPlansPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Click on Exh And Product Tab
		atlflpp.getATLExhibitorsAndProductTab().click();
		Thread.sleep(500);
		//click on Floor plans link
		atlflpp.getATLFloorPlansLink().click();
		Thread.sleep(500);
		//Click on Building floor
		atlflpp.getATLBuildingFloorForFilter().click();
		Thread.sleep(500);
		//Scroll Down to Exhibitor list
		utl.scrollToElement(atlflpp.getATLSelectBox());

		//Create current Exhibitor list without sort
		List<String> currentList=new ArrayList<String>();
		List<WebElement> elementList= driver.findElements(By.xpath("//a[@class='imc-type--title-5-link']"));
		for(WebElement we:elementList){
			currentList.add(we.getText().toLowerCase());
		}
		System.out.println("Current Exhibitor List : "+currentList);

		//Create sorted list
		List<String> sortedList = new ArrayList<String>();   
		for(String s:currentList){
			sortedList.add(s.toLowerCase());
		}
		Collections.sort(sortedList);
		//System.out.println("Sorted list : "+sortedList);

		//Select Filter Sort A-Z
		Select selectFilter=new Select(atlflpp.getATLSelectBox());
		selectFilter.selectByValue("Sort A-Z");
		Thread.sleep(25000);

		//Sorted list from filter Sort A-Z
		List<String> expectedSortedList = new ArrayList<String>(); 
		for(WebElement we:elementList){
			expectedSortedList.add(we.getText().toLowerCase());
		}
		//Thread.sleep(25000);
		System.out.println("Expected sorted Exhibitor List : "+expectedSortedList);
		//Verify Exhibitor List is Sorted or not
		Assert.assertEquals(sortedList, expectedSortedList, "Exhibitor List Should be sorted");
/*
		//Select Exhibitor on JuniperMarket from List
		selectFilter.selectByValue("Lines on JuniperMarket");
		Thread.sleep(10000);
		
		List<WebElement> currentJuniperMarketList= driver.findElements(By.xpath("//a[@class='imc-type--title-5-link']"));
		List<String> juniperMarketList = new ArrayList<String>(); 
		for(WebElement we:currentJuniperMarketList){

			juniperMarketList.add(we.getText());
		}
		//System.out.println("Expected sorted Exhibitor List : "+juniperMarketList);
		//Verify JuniperMarket List is Displayed or not
		Assert.assertTrue(!juniperMarketList.isEmpty(),"JuniperMarket Exhibitor list should displayed.");	
		
		Assert.assertTrue(atlflpp.getNoResultsMsgForLinesOnJuniper().isDisplayed());
	}
	*/
	}

	@Test(priority = 6,groups="Non_MP")
	public void TS006_VerifyPaginationOnFloorPlansPageTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T633: Floor Plans: Pagination
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp=new ATLFloorPlansPage(driver);

		driver.get(prop.getProperty("atlmrkturl_uat"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(1000);
		// Click on Exh And Product Tab
		atlflpp.getATLExhibitorsAndProductTab().click();
		Thread.sleep(1000);
		//click on Floor plans link
		atlflpp.getATLFloorPlansLink().click();
		Thread.sleep(1000);
		//Click on Building floor
		utl.scrollToElement(atlflpp.getATLBuildingFloor());
		atlflpp.getATLBuildingFloor().click();
		Thread.sleep(1000);
		//Scroll Down to Exhibitor list
		utl.scrollToElement(atlflpp.getATLNextFloorBtn());

		String actualNextFloorNumber=atlflpp.getATLNextFloorBtn().getText();
		System.out.println("Actual Next Floor Number: " +actualNextFloorNumber);
		atlflpp.getATLNextFloorBtn().click();
		Thread.sleep(5000);
		String exptectedFloorNumber=atlflpp.getATLExpectedFloorNumber().getText();
		System.out.println("Exptected Floor Number: " +exptectedFloorNumber);
		//Verify Next Floor
		Assert.assertTrue(exptectedFloorNumber.contains(actualNextFloorNumber));
		Thread.sleep(1000);
		//Previous floor Btn
		utl.scrollToElement(atlflpp.getATLPreviousFloorBtn());
		String actualPreviousFloorNumber=atlflpp.getATLPreviousFloorBtn().getText();
		System.out.println("Actual Previous Floor Number: " +actualPreviousFloorNumber);
		atlflpp.getATLPreviousFloorBtn().click();
		Thread.sleep(5000);
		String exptectedPeviousFloorNumber=atlflpp.getATLExpectedFloorNumber().getText();
		System.out.println("Exptected Pevious Floor Number: "+exptectedPeviousFloorNumber);
		//Verify Previous Floor
		Assert.assertTrue(exptectedPeviousFloorNumber.contains(actualPreviousFloorNumber));	
	}

	@Test(priority = 7,groups="Non_MP")
	public void TS007_VerifySelectionOfExhibitorOnFloorPlansPageTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T666: Floor Plans: Select Exhibitors
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp=new ATLFloorPlansPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		// Click on Exh And Product Tab
		utl.scrollToElement(atlflpp.getATLExhibitorsAndProductTab());
		atlflpp.getATLExhibitorsAndProductTab().click();
		Thread.sleep(2000);
		//click on Floor plans link
		atlflpp.getATLFloorPlansLink().click();
		Thread.sleep(2000);
		//Click on Building floor
		utl.scrollToElement(atlflpp.getATLBuilding1Floor3());
		atlflpp.getATLBuilding1Floor3().click();

		Thread.sleep(8000);
		//Scroll Down to Exhibitor list
		utl.scrollToElement(atlflpp.getATLExhibitorName());
		Thread.sleep(2000);
		//Stored 1st Exhibitor Name
		String exhibitorName=atlflpp.getatlExhibitorNamePROD().getText();
		System.out.println("Exhibitor Name: "+exhibitorName);
		Thread.sleep(5000);
		
		//Click on 1st Exhibitor
		atlflpp.getatlExhibitorNamePROD().click();

		Thread.sleep(12000);
		// Verify that Selected Exhibitor Digital Showroom page should be opened
		Assert.assertTrue(atlexhdgshw.getATLValidateExhDigiShowPage().isDisplayed());
		System.out.println("Exhibitor Digital Showroom - Hero image is visible");
		Assert.assertTrue(atlexhdgshw.getlvmvalidateexhdigishowpage_uat().isDisplayed());
		System.out.println("Exhibitor Digital Showroom - Product Categories section is visible");
		Thread.sleep(5000);
		//Verify Selected Exhibitor title
		//Assert.assertTrue(driver.getTitle().contains(""+exhibitorName+" at Atlanta Market"));
		//Verify Selected Exhibitor Name
		//Assert.assertTrue(atlexhdgshw.getExhibitorNameOnExhDirectImg().getText().contains(exhibitorName));
		Assert.assertTrue(atlgs.getinfoTitleOnSeeDetailsPage().getText().contains(exhibitorName));
		System.out.println("Verified that the Exhibitor name is in the breadcrumb");
	}

	@Test(priority = 8,groups="Non_MP")
	public void TS008_VerifyClickOnReturnToBuildingListBtnTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T669: Floor Plans: Return to Building list
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp=new ATLFloorPlansPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Click on Exh And Product Tab
		atlflpp.getATLExhibitorsAndProductTab().click();
		Thread.sleep(500);
		//click on Floor plans link
		atlflpp.getATLFloorPlansLink().click();
		Thread.sleep(1000);
		//Verify that user should redirect to Floor plans page
		Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("atlmrkturl_uat")+"Market-Map"));

		//Click on Building floor
		utl.scrollToElement(atlflpp.getATLBuildingFloor());
		atlflpp.getATLBuildingFloor().click();
		Thread.sleep(500);
		//Click on Return to Building Page link
		atlflpp.getATLReturnToBuildingList().click();
		Thread.sleep(5000);

		//Verify that user is again redirected to Floor plans page
		Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("atlmrkturl_uat")+"Market-Map"));
	}

	@Test(priority = 9,groups="Non_MP")
	public void TS009_VerifySearchFunctionalityForExhListOnFloorPlansPageTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP-T635: Exhibitor functionality on floor plans page
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp=new ATLFloorPlansPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		// Click on Exh And Product Tab
		utl.scrollToElement(atlflpp.getATLExhibitorsAndProductTab());
		atlflpp.getATLExhibitorsAndProductTab().click();
		Thread.sleep(500);
		//click on Floor plans link
		atlflpp.getATLFloorPlansLink().click();
		Thread.sleep(1000);
		//Click on building floor
		atlflpp.getATLBuildingFloor().click();
		Thread.sleep(500);
		utl.scrollToElement(atlflpp.getscrollexhibitorsection());
		Thread.sleep(5000);
		Assert.assertTrue(atlflpp.getatlexhibitorsection().isDisplayed());

		atlflpp.getatlexhibitorsearch().click();
		Thread.sleep(500);
		atlflpp.getatlexhibitorsearch().sendKeys(prop.getProperty("atlFloorPlanExhibitorSearch"));
		System.out.println("Search the Exhibitor: " +prop.getProperty("atlFloorPlanExhibitorSearch"));
		
		atlflpp.getatlserachexhibitorbtn().click();
		Thread.sleep(9000);
		Assert.assertTrue(atlflpp.getverifyexhibitor().getText().contains(prop.getProperty("atlFloorPlanExhibitorSearch")));
	}

	@Test(enabled=false)//(priority = 10,groups= "MP_Group",dependsOnMethods= "verifyMPLoginFunctionality")
	public void TS010_VerifyAddToListFunctionalityForExhibitorOnFloorPlansPageTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T313: Floor Plans: Exhibitor Options - Add to List
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp = new ATLFloorPlansPage(driver);
		//atlmppge = new ATLMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Click on Exh And Product Tab
		atlflpp.getATLExhibitorsAndProductTab().click();
		Thread.sleep(500);
		// click on Floor plans link
		atlflpp.getATLFloorPlansLink().click();
		Thread.sleep(500);
		// click on Exhibitor floor
		atlflpp.getATLBuildingFloor().click();
		Thread.sleep(500);
		// Scroll Down to Exhibitor list
		//utl.scrollToElement(atlflpp.getATLSelectBox());
		utl.scrollToElement(atlflpp.getATLNextFloorBtn());
		Thread.sleep(15000);

		// 1st Exhibitor Name
		String exhnameonfloorplan = atlflpp.getATLExhibitorName().getText();
		System.out.println("Exhibitor Name : " +exhnameonfloorplan );
		// Click on More option 3dots
		atlflpp.getATLMoreOptions().click();
		Thread.sleep(2000);
	
		// Click on Add To List
		atlflpp.getATLAddToList().click();
		Thread.sleep(3000);
		// Store the existing list name
		//String existinglistname = atlmppge.getATLMPExistingListNameNew().getText();
		//System.out.println("Existing list name: " + existinglistname);

		// Select Existing list name
		//atlmppge.getATLMPExistingListNameNew().click();

		// Scroll till Add to Selected button5
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				//atlmppge.getATLMPAddToSelectedBtn());
		//atlmppge.getATLMPAddToSelectedBtn().click();

		// Click on Go to Market Planner button
		//atlmppge.getGoToMarketPlannerBtn().click();

		// Click on Lists tab on MP home page
		//atlmppge.getMPHomeListsTab().click();
		//atlmppge.getListsPageListsMenu().click();

		//mplists = atlmppge.getATLMPListsNames();
		//mpeditlistoptns = atlmppge.getATLMPEditListOptns();

		/*for (int i = 0; i < mplists.size(); i++) {
			// System.out.println(mplists.get(i).getText());
			// System.out.println(mpeditlistoptns.get(i).getText());
			if (mplists.get(i).getText().equals(existinglistname)) {
				mpeditlistoptns.get(i).click();
				break;
			}
		}*/
		//Thread.sleep(5000);
		//Assert.assertTrue(atlmppge.getATLSavedExhNameInList().getText().contains(exhnameonfloorplan));
	}

	@Test (enabled=false)//(priority = 11,groups= "MP_Group",dependsOnMethods= "verifyMPLoginFunctionality")
	public void TS011_VerifyAddNoteFunctionalityForExhibitorOnFloorPlansPageTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T314: Floor Plans: Exhibitor Options - Add Note
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp = new ATLFloorPlansPage(driver);
		genData = new GenerateData();
		atlexhact = new ATLExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Click on Exh And Product Tab
		atlflpp.getATLExhibitorsAndProductTab().click();
		Thread.sleep(500);
		// click on Floor plans link
		atlflpp.getATLFloorPlansLink().click();
		Thread.sleep(500);
		// click on Exhibitor floor
		atlflpp.getATLBuildingFloor().click();
		Thread.sleep(500);
		// Scroll Down to Exhibitor list
		//utl.scrollToElement(atlflpp.getATLSelectBox());
		utl.scrollToElement(atlflpp.getATLNextFloorBtn());
		Thread.sleep(15000);
		
		// 1st Exhibitor Name
		String exhibitorName = atlflpp.getATLExhibitorName().getText();
		System.out.println("Exhibitor Name : " + exhibitorName);
		
		// Click on More option 3dots
		atlflpp.getATLMoreOptions().click();
		Thread.sleep(500);
		// Click on Add Note
		atlflpp.getATLAddNote().click();
		Thread.sleep(500);
		// Store the new note name
		String newnotetitle = "CybNote" + genData.generateRandomString(3);
		System.out.println("Newly added Note is: " + newnotetitle);

		// Enter Note title
		atlexhact.getNoteTitleTxtBx().sendKeys(newnotetitle);
		// Enter Note Content
		atlexhact.getNoteContentTxtBx().sendKeys("TestNote" + genData.generateRandomString(6));
		// Click on 'Save' button
		atlexhact.getNoteSaveBtn().click();
		Thread.sleep(5000);

		atlflpp.getATLMoreOptions().click();
		Thread.sleep(500);
		// Click on 'Add Note' icon for the same exhibitor
		atlflpp.getATLAddNote().click();
		Thread.sleep(4000);

		// Click on 'View all Notes for an Exhibitor' link on Add Notes pop-up
		atlexhact.getViewAllNotesLink().click();
		Thread.sleep(5000);

		allnoteslist = atlexhact.getSavedNoteNameInAllNotesList();

		// Verify that recently added note should be appear on 'All Notes For Exhibitor' modal
		for (int i = 0; i < allnoteslist.size(); i++) {
			// System.out.println(allnoteslist.get(i).getText());
			if (allnoteslist.get(i).getText().equals(newnotetitle)) {
				allnoteslist.get(i).click();
				break;
			}
		}

		// Delete the saved note
		atlexhact.getDeleteNoteBtn().click();
		Thread.sleep(500);
	}

	@Test(enabled=false)//(priority = 12,groups= "MP_Group",dependsOnMethods= "verifyMPLoginFunctionality")
	public void TS012_VerifyAddToFavoriteFunctionalityForExhibitorOnFloorPlansPageTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T316: Floor Plans: Exhibitors Option - Add to Favorite
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp = new ATLFloorPlansPage(driver);
		//atlmppge = new ATLMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Click on Exh And Product Tab
		atlflpp.getATLExhibitorsAndProductTab().click();
		Thread.sleep(500);
		// click on Floor plans link
		atlflpp.getATLFloorPlansLink().click();
		Thread.sleep(500);
		// click on Exhibitor floor
		//atlflpp.getATLBuildingFloor().click();//Old - disabled for fav option
		atlflpp.getATLBuildingFloorNew().click();//New
		Thread.sleep(500);
		// Scroll Down to Exhibitor list
		utl.scrollToElement(atlflpp.getatlserachexhibitorbtn());
		Thread.sleep(15000);

		// 1st Exhibitor Name
		String exhibitorName = atlflpp.getATLExhibitorName().getText();
		System.out.println("Exhibitor Name : " + exhibitorName);
		
		// Click on Favorite icon of 1st exhibitor
		atlflpp.getATLAddFev().click();
		Thread.sleep(500);
		// Click on Market Planner link
		lap.getMPLinkText().click();
		Thread.sleep(500);
		// Click on Lists tab on MP home page
		//atlmppge.getMPHomeListsTab().click();
		//atlmppge.getATLMPListsPageFavoritesMenu().click();

		//System.out.println(atlmppge.getATLSavedExhNameInList().getText());
		// Verify that the added favorites exhibitor should be displayed in to Favorites list
		//favlist = atlmppge.getFavExhList();
		for (int i = 0; i < favlist.size(); i++) {
			if(favlist.contains(exhibitorName)) {
				//System.out.println(prodcatgitemlist.get(i).getText());
				Assert.assertTrue(favlist.get(i).getText().contains(exhibitorName));
				break;
			}
		}

		// Delete that favorites exhibitor from list
		//atlmppge.getMoreBtnDeleteOptnExistingList_ATLPROD().click();
		//atlmppge.getATLEditListItemDeleteOptn().click();
		Thread.sleep(6000);

		// Verify that the added favorites exhibitor should be removed from Favorites list
		for (int i = 1; i < favlist.size(); i++) {
			//System.out.println(favlist.get(i).getText());
			Assert.assertFalse(favlist.get(i).getText().contains(exhibitorName));
		}
	}
	@AfterClass(alwaysRun=true)
	public void tearDown()
	{
		driver.quit();
	}

}

