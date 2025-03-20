package lasvegasmarket_PROD;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.LasVegasMarket.LVMExhDigiShowroomPage;
import pageObjects.LasVegasMarket.LVMExhLineProdActionsPage;
import pageObjects.LasVegasMarket.LVMFloorPlansPage;
import pageObjects.LasVegasMarket.LVMLandingPage;
import pageObjects.LasVegasMarket.LVMMarketPlannerPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

@Listeners({ TestListeners.class })
public class FloorPlans extends base {

	public WebDriverWait wait;
	public GenerateData genData;
	public Utility utl;
	public String exhname;
	LVMExhLineProdActionsPage lvmexhact;
	LVMMarketPlannerPage lvmmppge;
	LVMFloorPlansPage lvmflpp;
	LVMExhDigiShowroomPage lvmexhdgshw;
	LVMLandingPage lap;

	List<WebElement> exhlist, linelist, prodlist, searchexhtypelist, searchproducttypelist, mplists, mpeditlistoptns, allnoteslist,favlist, searchlinetypelist;

	@BeforeClass
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		utl = new Utility(driver);
		lap = new LVMLandingPage(driver);

		// Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("lvmurl_prod"));
		lap.getIUnderstandBtn().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(7000);
		//lap.getCloseMarktAdBtn().click();

/*		//Login to Market Planner
		utl.verifyMPLoginFunctionality();
		utl.loginCheckLVM();
		//driver.navigate().refresh();
		Thread.sleep(8000);
		//		lap.getCloseMarktAdBtn().click();
*/	}

	@Test(priority = 1)
	public void TS001_VerifyNavigationToDifferentFloorBuildingsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T627: To verify Floor Plans: Navigation to different floor/buildings

		utl = new Utility(driver);
		lvmflpp= new LVMFloorPlansPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);
		// Click on Discover Tab
		lvmflpp.getlvmDiscoverBtn().click();

		//click on Floor plans link
		lvmflpp.getlvmFloorPlansLinkPROD().click();
		Thread.sleep(5000);

		//Verify that user should redirect to Floor plans page
		Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("lvmurl_prod")+"Market-Map"));

		//utl.scrollToElement(lvmflpp.getLVMBuildingFloor());
		//Click on Building/floor
		String floorName=lvmflpp.getLVMBuildingFloor().getText();
		System.out.println("Floor Name : " +floorName);

		String locationlink = lvmflpp.getLVMBuildingFloor().getAttribute("href");
		System.out.println(locationlink);
		Thread.sleep(5000);
		utl.scrollElementIntoMiddle(lvmflpp.getLVMBuildingFloor());
		
		//Click on list floor of first building.
		utl.scrollElementIntoMiddle(lvmflpp.getLVMBuildingFloor());
		Thread.sleep(200);
		lvmflpp.getLVMBuildingFloor().click();
		Thread.sleep(5000);

		// Verify that selected building-floor plan page should be opened
		Assert.assertTrue(locationlink.equals(driver.getCurrentUrl()));

		//Verify selected floor name
		Assert.assertTrue(lvmflpp.getLVMFloorName().getText().contains(floorName));
	}

	@Test(priority = 2)
	public void TS002_VerifyNoExhibitorsOnThisFloorMessageTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T628: To verify Floor Plans: No Exhibitors or Loading message

		utl = new Utility(driver);
		lvmflpp= new LVMFloorPlansPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		/*
		 * // Click on Exh And Product Tab
		 * lvmflpp.getLVMExhibitorsAndProductTab().click();
		 * 
		 * //click on Floor plans link lvmflpp.getLVMFloorPlansLink().click();
		 */
		// Click on Discover Tab
		lvmflpp.getlvmDiscoverBtn().click();

		// click on Floor plans link
		lvmflpp.getlvmFloorPlansLinkPROD().click();
		Thread.sleep(5000);

		//click on Floor whose not having an Exhibitors
		String floorName=lvmflpp.getLVMBuildingFloor().getText();
		System.out.println("Floor Name : " +floorName);

		//click on No Exhibitor floor
		
		lvmflpp.getlvmNoExhibitorFloor_uat().click();

		//Verify that Loading Exhibitors msg should be displayed
		//Assert.assertTrue(atlflpp.getATLLoadingExhMsg().isDisplayed());
		Thread.sleep(10000);
		//Verify that No Exhibitor msg should be displayed
		Assert.assertTrue(lvmflpp.getLVMNoExpMsg().isDisplayed());
	}

	@Test(priority = 3)
	public void TS003_VerifyZoomInOutLevelOnFloorPlansPageTest() throws InterruptedException, IOException {
		// The purpose of this test case:-
		// UXP-T629: To verify Floor Plans: Zoom Levels

		utl = new Utility(driver);
		lvmflpp=new LVMFloorPlansPage(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);

		// Click on Discover Tab
		lvmflpp.getlvmDiscoverBtn().click();

		// click on Floor plans link
		lvmflpp.getlvmFloorPlansLinkPROD().click();
		Thread.sleep(5000);

		
		//click on any floor
		utl.scrollElementIntoMiddle(lvmflpp.getLVMBuildingFloor());
		Thread.sleep(200);
		lvmflpp.getLVMBuildingFloor().click();

		//utl.scrollToElement(lvmflpp.getLVMExhibitorFloorZoomIn());
		//Click on Zoom In icon
		//lvmflpp.getLVMExhibitorFloorZoomIn().click();
		Actions action= new Actions(driver);
		action.moveToElement(lvmflpp.getLVMExhibitorFloorZoomIn()).click().perform();
		
		//Store Zoom in Attribute
		String x1= lvmflpp.getLVMFloorPlanMapIamge().getAttribute("style");

		//lvmflpp.getLVMExhibitorFloorZoomIn().click();
		action.moveToElement(lvmflpp.getLVMExhibitorFloorZoomIn()).click().perform();
		//Stored Zoom in Attribute
		String x2=lvmflpp.getLVMFloorPlanMapIamge().getAttribute("style");
System.out.println("x2 "+x2);
		//Store Zoom in Attribute
		//lvmflpp.getLVMExhibitorFloorZoomIn().click();
		action.moveToElement(lvmflpp.getLVMExhibitorFloorZoomIn()).click().perform();
		String x3=lvmflpp.getLVMFloorPlanMapIamge().getAttribute("style");
		System.out.println("x3 "+x3);
		//Verify Zoom In functionality
		Assert.assertNotEquals(x2, x3);
		Thread.sleep(5000);

		//Click on Zoom Out icon
		//lvmflpp.getLVMExhibitorFloorZoomOut().click();
		action.moveToElement(lvmflpp.getLVMExhibitorFloorZoomOut()).click().perform();
		//lvmflpp.getLVMExhibitorFloorZoomOut().click();
		action.moveToElement(lvmflpp.getLVMExhibitorFloorZoomOut()).click().perform();
		//Stored Zoom out Attribute
		String out=lvmflpp.getLVMFloorPlanMapIamge().getAttribute("style");
		Thread.sleep(5000);
		//Verify Zoom Out functionality
		Assert.assertNotEquals(x1, out);
	}

	@Test(priority = 4)
	public void TS004_VerifyIconsOnFloorPlansPageTest() throws InterruptedException, IOException {
		// The purpose of this test case to:-
		// UXP-T808: To verify Floor Plans: Icons

		utl = new Utility(driver);
		lvmflpp=new LVMFloorPlansPage(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		// Click on Discover Tab
		lvmflpp.getlvmDiscoverBtn().click();

		// click on Floor plans link
		lvmflpp.getlvmFloorPlansLinkPROD().click();
		Thread.sleep(5000);
		//click on any floor
		utl.scrollElementIntoMiddle(lvmflpp.getLVMBuildingFloor());
		Thread.sleep(200);
		lvmflpp.getLVMBuildingFloor().click();

		//Click on Vending Machine icon on Map image
		Thread.sleep(8000);
		//utl.scrollToElement(lvmflpp.getlvmflooricononmap_lvmUAT());
		lvmflpp.getlvmflooricononmap_lvmUAT().click();
		Thread.sleep(1000);
		//Verify that Vending Machine Overlay should appeared on Map
		Assert.assertTrue(lvmflpp.getlvmflooriconoverlay_lvmUAT().isDisplayed());

		/*//Click on Elevator icon on Map image
		atlflpp.getElevatorIconOnMap().click();

		//Verify that Elevator Overlay should appeared on Map
		Assert.assertTrue(atlflpp.getElevatorOverlayOnMap().isDisplayed());

		//Click on WateSr Fountain icon on Map image
		atlflpp.getWaterFountainIconOnMap().click();

		//Verify that Water Fountain Overlay should appeared on Map
		Assert.assertTrue(atlflpp.getWaterFountainOverlayOnMap().isDisplayed());

		//Click on Phone icon on Map image
		atlflpp.getPhoneIconOnMap().click();

		//Verify that Phone Overlay should appeared on Map
		Assert.assertTrue(atlflpp.getPhoneOverlayOnMap().isDisplayed());

		//Click on Overlay Close btn
		atlflpp.getOverlayCloseBtn().click();
*/
/*		Commented on UAT LVM
  		//Click on Location pin of any Exhibitor on Map
		atlflpp.getLocationPinIconOnMap().click();

		//Verify that select Exhibitor's location details should be displayed in popup
		Assert.assertTrue(atlflpp.getExhibitorDetailsModal().isDisplayed());

		//Store the Exhibitor name on details modal
		String exhnameondetailsmodal = atlflpp.getExhNameOnExhibitorDetailsModal().getText();
		System.out.println(exhnameondetailsmodal);
		//Click on 'View Digital Showroom' button
		atlflpp.getViewDGShowroombtn().click();

		//Verify that user should redirected to Exh Digital Showroom page
		Assert.assertTrue(atlexhdgshw.getATLValidateExhDigiShowPage().isDisplayed());

		//Verify the Exhibitor name on Exh Digital Showroom
		Thread.sleep(10000);
		System.out.println(atlexhdgshw.getExhibitorNameOnExhDirectImgLvm().getText());
		Assert.assertTrue(driver.getTitle().contains(""+exhnameondetailsmodal+" at Las Vegas Market"));
		Assert.assertTrue(atlexhdgshw.getExhibitorNameOnExhDirectImgLvm().getText().contains(exhnameondetailsmodal));
*/
	}

    @Test(priority = 5)
    public void TS005_VerifyFunctionalityOfFiltersOFloorPlansPageTest() throws InterruptedException, IOException {
        // The purpose of this test case to verify:-
        // UXP-T290: To verify Floor Plans: Filter

        utl = new Utility(driver);
        lvmflpp=new LVMFloorPlansPage(driver);
        
        driver.get(prop.getProperty("lvmurl_prod"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Thread.sleep(2000);
        
		// Click on Discover Tab
		lvmflpp.getlvmDiscoverBtn().click();

		// click on Floor plans link
		lvmflpp.getlvmFloorPlansLinkPROD().click();
		Thread.sleep(5000);       
        //Click on Building floor
        utl.scrollElementIntoMiddle(  lvmflpp.getLVMBuildingFloorForFilter());
        Thread.sleep(200);
        lvmflpp.getLVMBuildingFloorForFilter().click();
        Thread.sleep(6000);
        //Scroll Down to Exhibitor list
        //utl.scrollToElement(lvmflpp.getLVMSelectBox());
       // Thread.sleep(7000);
        
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
        Select selectFilter=new Select(lvmflpp.getLVMSelectBox());
        selectFilter.selectByValue("Sort A-Z");
        Thread.sleep(25000);

        //Sorted list from filter Sort A-Z
        List<String> expectedSortedList = new ArrayList<String>(); 
        for(WebElement we:elementList){
            expectedSortedList.add(we.getText().toLowerCase());
        }
        Thread.sleep(2000);
        //System.out.println("Expected sorted Exhibitor List : "+expectedSortedList);
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
        if(atlflpp.getResultsMsgForLinesOnJuniper().isDisplayed()) {
            System.out.println("Lines on JuniperMarket is present");
        }else {
            Assert.assertTrue(atlflpp.getNoResultsMsgForLinesOnJuniper().isDisplayed());
            System.out.println("Lines on JuniperMarket is not present");
        }
*/
    }
    
	@Test(priority = 6)
	public void TS006_VerifyPaginationOnFloorPlansPageTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T633: Floor Plans: Pagination

		utl = new Utility(driver);
		lvmflpp=new LVMFloorPlansPage(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		// Click on Discover Tab
				lvmflpp.getlvmDiscoverBtn().click();

				// click on Floor plans link
				lvmflpp.getlvmFloorPlansLinkPROD().click();
				Thread.sleep(5000);

		//Click on Building floor
		utl.scrollElementIntoMiddle(lvmflpp.getLVMBuildingFloor());
		Thread.sleep(200);
		lvmflpp.getLVMBuildingFloor().click();
		Thread.sleep(2000);
		//Scroll Down to Exhibitor list
		//utl.scrollToElement(lvmflpp.getLVMNextFloorBtn());

		utl.scrollElementIntoMiddle(lvmflpp.getLVMNextFloorBtn());
		Thread.sleep(200);
		String actualNextFloorNumber=lvmflpp.getLVMNextFloorBtn().getText();
		System.out.println(actualNextFloorNumber);
		lvmflpp.getLVMNextFloorBtn().click();
		Thread.sleep(5000);
		String exptectedFloorNumber=lvmflpp.getLVMExpectedFloorNumber().getText();
		System.out.println(exptectedFloorNumber);
		//Verify Next Floor
		Assert.assertTrue(exptectedFloorNumber.contains(actualNextFloorNumber));
		Thread.sleep(2000);
		//Previous floor Btn
		utl.scrollElementIntoMiddle(lvmflpp.getLVMPreviousFloorBtn());
		Thread.sleep(500);
		String actualPreviousFloorNumber=lvmflpp.getLVMPreviousFloorBtn().getText();
		System.out.println(actualPreviousFloorNumber);
		lvmflpp.getLVMPreviousFloorBtn().click();
		Thread.sleep(5000);
		String exptectedPeviousFloorNumber=lvmflpp.getLVMExpectedFloorNumber().getText();
		System.out.println(exptectedPeviousFloorNumber);
		//Verify Previous Floor
		Assert.assertTrue(exptectedPeviousFloorNumber.contains(actualPreviousFloorNumber));	
	}

	@Test(priority = 7)
	public void TS007_VerifySelectionOfExhibitorOnFloorPlansPageTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T666: Floor Plans: Select Exhibitors

		utl = new Utility(driver);
		lvmflpp=new LVMFloorPlansPage(driver);
		lvmexhdgshw = new LVMExhDigiShowroomPage(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);

		// Click on Discover Tab
		lvmflpp.getlvmDiscoverBtn().click();

		// click on Floor plans link
		lvmflpp.getlvmFloorPlansLinkPROD().click();
		Thread.sleep(5000);
		//Click on Building floor
		utl.scrollElementIntoMiddle(lvmflpp.getLVMBuildingFloor());
		Thread.sleep(200);
		lvmflpp.getLVMBuildingFloor().click();

		Thread.sleep(8000);
		//Scroll Down to Exhibitor list
		//utl.scrollToElement(lvmflpp.getLVMExhibitorName());
		//Thread.sleep(2000);
		//Stored 1st Exhibitor Name
		String exhibitorName=lvmflpp.getlvmFloorPlansFirstExhName().getText();
		System.out.println("Exhi Name: "+exhibitorName);
		Thread.sleep(5000);
		
		//Click on 1st Exhibitor
		utl.scrollElementIntoMiddle(lvmflpp.getlvmFloorPlansFirstExhName());
		Thread.sleep(200);
		lvmflpp.getlvmFloorPlansFirstExhName().click();

		Thread.sleep(12000);
		// Verify that Selected Exhibitor Digital Showroom page should be opened
		Assert.assertTrue(lvmexhdgshw.getlvmvalidateexhdigishowpage_uat().isDisplayed());
		Thread.sleep(5000);
		//Assert.assertTrue(driver.getTitle().contains(""+exhibitorName+" at Atlanta Market"));
		Assert.assertTrue(lvmexhdgshw.getexhNamePROD().getText().contains(exhibitorName));
	}

	@Test(priority = 8)
	public void TS008_VerifyClickOnReturnToBuildingListBtnTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T669: Floor Plans: Return to Building list

		utl = new Utility(driver);
		lvmflpp=new LVMFloorPlansPage(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);

		// Click on Discover Tab
		lvmflpp.getlvmDiscoverBtn().click();

		// click on Floor plans link
		lvmflpp.getlvmFloorPlansLinkPROD().click();
		Thread.sleep(5000);
		
		//Click on Building floor
		utl.scrollElementIntoMiddle(lvmflpp.getLVMBuildingFloor());
		Thread.sleep(200);
		lvmflpp.getLVMBuildingFloor().click();

		//Click on Return to Building Page link
		lvmflpp.getLVMReturnToBuildingList().click();
		Thread.sleep(5000);

		//Verify that user should redirect to Floor plans page
		Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("lvmurl_prod")+"Market-Map"));
	}

	@Test(priority = 9)
	public void TS009_VerifySearchFunctionalityForExhListOnFloorPlansPageTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP-T635: Exhibitor functionality on floor plans page

		utl = new Utility(driver);
		lvmflpp=new LVMFloorPlansPage(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		
		// Click on Discover Tab
		lvmflpp.getlvmDiscoverBtn().click();

		// click on Floor plans link
		lvmflpp.getlvmFloorPlansLinkPROD().click();
		Thread.sleep(5000);
		
		//Click on building floor
		utl.scrollElementIntoMiddle(lvmflpp.getLVMBuildingFloor());
		Thread.sleep(200);
		lvmflpp.getLVMBuildingFloor().click();

		//utl.scrollToElement(lvmflpp.getscrollexhibitorsection());
		Thread.sleep(8000);
		Assert.assertTrue(lvmflpp.getlvmexhibitorsection().isDisplayed());

		utl.scrollElementIntoMiddle(lvmflpp.getlvmexhibitorsearch());
		Thread.sleep(200);
		lvmflpp.getlvmexhibitorsearch().click();
		
		String exhibitorName=lvmflpp.getlvmFloorPlansFirstExhName().getText();
		System.out.println("Exhi Name: "+exhibitorName);
		
		lvmflpp.getlvmexhibitorsearch().sendKeys(exhibitorName);

		lvmflpp.getlvmFloorPlansSearchButton().click();
		driver.navigate().refresh();
		Thread.sleep(5000);
		Assert.assertTrue(lvmflpp.getverifyexhibitor().getText().contains(exhibitorName));

		driver.get(prop.getProperty("lvmurl_prod"));
		Thread.sleep(8000);
	}

	@Test(enabled=false)//priority = 10
	public void TS010_VerifyAddToListFunctionalityForExhibitorOnFloorPlansPageTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T313: Floor Plans: Exhibitor Options - Add to List

		utl = new Utility(driver);
		lvmflpp= new LVMFloorPlansPage(driver);
		lvmmppge = new LVMMarketPlannerPage(driver);
		
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Click on Exh And Product Tab
		Thread.sleep(3000);
		lvmflpp.getLVMExhibitorsAndProductTab().click();
		Thread.sleep(2000);
		// click on Floor plans link
		lvmflpp.getLVMFloorPlansLink().click();
		Thread.sleep(5000);
		// click on Exhibitor floor
		//atlflpp.getLVMBuildingFloor().click(); //8th Floor
		lvmflpp.getLVMBuildingFloorsix().click(); //6th floor
		Thread.sleep(12000);
		// Scroll Down to Exhibitor list
		utl.scrollElementIntoMiddle(lvmflpp.getLVMSelectBox());
		Thread.sleep(15000);

		// 1st Exhibitor Name
		String exhnameonfloorplan = lvmflpp.getLVMExhibitorName().getText();
		System.out.println("Exhibitor Name : " +exhnameonfloorplan );
		// Click on More option 3dots
		lvmflpp.getLVMMoreOptions().click();
		Thread.sleep(5000);
		
		// Click on Add To List
		lvmflpp.getLVMAddToList().click();
		Thread.sleep(2000);
		// Store the existing list name
		String existinglistname = lvmmppge.getLVMMPExistingListNameNew().getText();
		System.out.println("Existing list name: " + existinglistname);

		// Select Existing list name
		lvmmppge.getLVMMPExistingListNameNew().click();

		// Scroll till Add to Selected button5
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
		    lvmmppge.getLVMMPAddToSelectedBtn());
		lvmmppge.getLVMMPAddToSelectedBtn().click();

		// Click on Go to Market Planner button
		lvmmppge.getGoToMarketPlannerBtn().click();

		// Click on Lists tab on MP home page
		lvmmppge.getMPHomeListsTab().click();
		lvmmppge.getListsPageListsMenu().click();

		mplists = lvmmppge.getLVMMPListsNames();
		mpeditlistoptns = lvmmppge.getLVMMPEditListOptns();

		for (int i = 0; i < mplists.size(); i++) {
			// System.out.println(mplists.get(i).getText());
			// System.out.println(mpeditlistoptns.get(i).getText());
			if (mplists.get(i).getText().equals(existinglistname)) {
				mpeditlistoptns.get(i).click();
				break;
			}
		}
		Thread.sleep(5000);
		Assert.assertTrue(lvmmppge.getLVMSavedExhNameInList().getText().contains(exhnameonfloorplan));
	}

	@Test(enabled=false)//priority = 11
	public void TS011_VerifyAddNoteFunctionalityForExhibitorOnFloorPlansPageTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T314: Floor Plans: Exhibitor Options - Add Note

		utl = new Utility(driver);
		lvmflpp= new LVMFloorPlansPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		// Click on Exh And Product Tab
		lvmflpp.getLVMExhibitorsAndProductTab().click();
		// click on Floor plans link
		lvmflpp.getLVMFloorPlansLink().click();
		Thread.sleep(7000);
		// click on Exhibitor floor
		lvmflpp.getLVMBuildingFloor().click();
		// Scroll Down to Exhibitor list
		Thread.sleep(4000);
		utl.scrollElementIntoMiddle(lvmflpp.getLVMSelectBox());
		// 1st Exhibitor Name
		String exhibitorName = lvmflpp.getLVMExhibitorName().getText();
		System.out.println("Exhibitor Name : " + exhibitorName);
		
		// Click on More option 3dots
		lvmflpp.getLVMMoreOptions().click();
		Thread.sleep(2000);
		// Click on Add Note
		lvmflpp.getLVMAddNote().click();
		// Store the new note name
		String newnotetitle = "CybNote" + genData.generateRandomString(3);
		System.out.println("Newly added Note is: " + newnotetitle);

		// Enter Note title
		lvmexhact.getNoteTitleTxtBx().sendKeys(newnotetitle);
		// Enter Note Content
		lvmexhact.getNoteContentTxtBx().sendKeys("TestNote" + genData.generateRandomString(6));
		// Click on 'Save' button
		lvmexhact.getNoteSaveBtn().click();
		Thread.sleep(5000);

		lvmflpp.getLVMMoreOptions().click();
		// Click on 'Add Note' icon for the same exhibitor
		lvmflpp.getLVMAddNote().click();
		Thread.sleep(10000);

		// Click on 'View all Notes for an Exhibitor' link on Add Notes pop-up
		lvmexhact.getViewAllNotesLink().click();
		Thread.sleep(5000);

		allnoteslist = lvmexhact.getSavedNoteNameInAllNotesList();

		// Verify that recently added note should be appear on 'All Notes For Exhibitor' modal
		for (int i = 0; i < allnoteslist.size(); i++) {
			// System.out.println(allnoteslist.get(i).getText());
			if (allnoteslist.get(i).getText().equals(newnotetitle)) {
				allnoteslist.get(i).click();
				break;
			}
		}

		// Delete the saved note
		lvmexhact.getDeleteNoteBtn().click();
	}

	@Test(enabled=false)//priority = 12
	public void TS012_VerifyAddToFavoriteFunctionalityForExhibitorOnFloorPlansPageTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T316: Floor Plans: Exhibitors Option - Add to Favorite

		utl = new Utility(driver);
		lvmflpp= new LVMFloorPlansPage(driver);
		lvmmppge = new LVMMarketPlannerPage(driver);
		lap = new LVMLandingPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		// Click on Exh And Product Tab
		lvmflpp.getLVMExhibitorsAndProductTab().click();
		// click on Floor plans link
		lvmflpp.getLVMFloorPlansLink().click();

		// click on Exhibitor floor
		lvmflpp.getbuildingFloor_lvmUAT().click();
		Thread.sleep(5000);
		// Scroll Down to Exhibitor list
		utl.scrollElementIntoMiddle(lvmflpp.getLVMSelectBox());
		Thread.sleep(6000);
		// 1st Exhibitor Name
		String exhibitorName = lvmflpp.getLVMExhibitorName().getText();
		System.out.println("Exhibitor Name : " + exhibitorName);
		// Click on More option 3dots
		//atlflpp.getATLMoreOptions().click();

		// Click on Favorite icon of 1st exhibitor
		lvmflpp.getLVMAddFev().click();

		// Click on Market Planner link
		lap.getMPLinkText().click();

		// Click on Lists tab on MP home page
		lvmmppge.getMPHomeListsTab().click();
		lvmmppge.getLVMMPListsPageFavoritesMenu().click();
		Thread.sleep(7000);

		//System.out.println(atlmppge.getATLSavedExhNameInList().getText());
		// Verify that the added favorites exhibitor should be displayed in to Favorites list
		favlist = lvmmppge.getFavExhList();
		for (int i = 0; i < favlist.size(); i++) {
			if(favlist.contains(exhibitorName)) {
				//System.out.println(prodcatgitemlist.get(i).getText());
				Assert.assertTrue(favlist.get(i).getText().contains(exhibitorName));
				break;
			}
		}
		//Assert.assertTrue(atlmppge.getlvmsavedexhnameinlist_uat().getText().contains(exhibitorName));//old
		Thread.sleep(2000);
		// Delete that favorites exhibitor from list
		Actions action=new Actions(driver);
		//action.moveToElement(atlmppge.getMoreBtnDeleteOptn_lvmUAT()).perform();
		lvmmppge.getMoreBtnDeleteOptn_lvmUAT().click();
		lvmmppge.getLVMEditListItemDeleteOptn().click();
		Thread.sleep(7000);

		// Verify that the added favorites exhibitor should be removed from Favorites list
		for (int i = 1; i < favlist.size(); i++) {
			Assert.assertFalse(favlist.get(i).getText().contains(exhibitorName));
			break;
		}
	}
	

	@AfterClass
	public void tearDown()
	{
		//driver.quit();
	}

}
