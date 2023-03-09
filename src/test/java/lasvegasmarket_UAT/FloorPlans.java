package lasvegasmarket_UAT;

import java.io.IOException;
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
		driver.get(prop.getProperty("lvmurl_uat"));
		lap.getIUnderstandBtn().click();
		Thread.sleep(7000);
		//lap.getCloseMarktAdBtn().click();

		//Login to Market Planner
		utl.verifyMPLoginFunctionality();
		driver.navigate().refresh();
		Thread.sleep(8000);
		//		lap.getCloseMarktAdBtn().click();
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
		Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("lvmurl_uat")+"Market-Map"));

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

	@Test(priority = 2)
	public void TS002_VerifyNoExhibitorsOnThisFloorMessageTest() throws InterruptedException, IOException {
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
		String floorName=atlflpp.getATLBuildingFloor().getText();
		System.out.println("Floor Name : " +floorName);

		//click on No Exhibitor floor
		
		atlflpp.getlvmNoExhibitorFloor_uat().click();

		//Verify that Loading Exhibitors msg should be displayed
		//Assert.assertTrue(atlflpp.getATLLoadingExhMsg().isDisplayed());
		Thread.sleep(4000);
		//Verify that No Exhibitor msg should be displayed
		Assert.assertTrue(atlflpp.getATLNoExpMsg().isDisplayed());
	}

	@Test(priority = 3)
	public void TS003_VerifyZoomInOutLevelOnFloorPlansPageTest() throws InterruptedException, IOException {
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
		//Store Zoom in Attribute
		String x1=atlflpp.getATLFloorPlanMapIamge().getAttribute("style");

		atlflpp.getATLExhibitorFloorZoomIn().click();
		//Stored Zoom in Attribute
		String x2=atlflpp.getATLFloorPlanMapIamge().getAttribute("style");

		//Store Zoom in Attribute
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

	@Test(priority = 4)
	public void TS004_VerifyIconsOnFloorPlansPageTest() throws InterruptedException, IOException {
		// The purpose of this test case to:-
		// UXP-T289: To verify Floor Plans: Icons

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp=new ATLFloorPlansPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Exh And Product Tab
		atlflpp.getATLExhibitorsAndProductTab().click();

		//click on Floor plans link
		atlflpp.getATLFloorPlansLink().click();

		//click on any floor
		atlflpp.getATLBuildingFloor().click();

		//Click on Vending Machine icon on Map image
		Thread.sleep(5000);
		atlflpp.getlvmflooricononmap_lvmUAT().click();

		//Verify that Vending Machine Overlay should appeared on Map
		Assert.assertTrue(atlflpp.getlvmflooriconoverlay_lvmUAT().isDisplayed());

		/*//Click on Elevator icon on Map image
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
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp=new ATLFloorPlansPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Click on Exh And Product Tab
		atlflpp.getATLExhibitorsAndProductTab().click();
		Thread.sleep(2000);
		//click on Floor plans link
		atlflpp.getATLFloorPlansLink().click();
		Thread.sleep(2000);
		//Click on Building floorr
		atlflpp.getATLBuildingFloorForFilter().click();
		Thread.sleep(5000);
		//Scroll Down to Exhibitor list
		utl.scrollToElement(atlflpp.getATLSelectBox());
		Thread.sleep(7000);
		
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
		Thread.sleep(2000);
		//System.out.println("Expected sorted Exhibitor List : "+expectedSortedList);
		//Verify Exhibitor List is Sorted or not
		Assert.assertEquals(sortedList, expectedSortedList, "Exhibitor List Should be sorted");

		//Select Exhibitor on JuniperMarket from List
		selectFilter.selectByValue("Lines on JuniperMarket");
		Thread.sleep(10000);
		
		/*List<WebElement> currentJuniperMarketList= driver.findElements(By.xpath("//a[@class='imc-type--title-5-link']"));
		List<String> juniperMarketList = new ArrayList<String>(); 
		for(WebElement we:currentJuniperMarketList){

			juniperMarketList.add(we.getText());
		}
		//System.out.println("Expected sorted Exhibitor List : "+juniperMarketList);
		//Verify JuniperMarket List is Displayed or not
		Assert.assertTrue(!juniperMarketList.isEmpty(),"JuniperMarket Exhibitor list should displayed.");	*/
		
		Assert.assertTrue(atlflpp.getNoResultsMsgForLinesOnJuniper().isDisplayed());
	}

	@Test(priority = 6)
	public void TS006_VerifyPaginationOnFloorPlansPageTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T291: Floor Plans: Pagination
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp=new ATLFloorPlansPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Exh And Product Tab
		atlflpp.getATLExhibitorsAndProductTab().click();

		//click on Floor plans link
		atlflpp.getATLFloorPlansLink().click();

		//Click on Building floor
		atlflpp.getATLBuildingFloor().click();

		//Scroll Down to Exhibitor list
		utl.scrollToElement(atlflpp.getATLNextFloorBtn());

		String actualNextFloorNumber=atlflpp.getATLNextFloorBtn().getText();
		atlflpp.getATLNextFloorBtn().click();
		Thread.sleep(5000);
		String exptectedFloorNumber=atlflpp.getATLExpectedFloorNumber().getText();
		//Verify Next Floor
		Assert.assertTrue(exptectedFloorNumber.contains(actualNextFloorNumber));

		//Previous floor Btn
		String actualPreviousFloorNumber=atlflpp.getATLPreviousFloorBtn().getText();
		atlflpp.getATLPreviousFloorBtn().click();
		Thread.sleep(5000);
		String exptectedPeviousFloorNumber=atlflpp.getATLExpectedFloorNumber().getText();
		//Verify Previous Floor
		Assert.assertTrue(exptectedPeviousFloorNumber.contains(actualPreviousFloorNumber));	
	}

	@Test(priority = 7)
	public void TS007_VerifySelectionOfExhibitorOnFloorPlansPageTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T324: Floor Plans: Select Exhibitors
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp=new ATLFloorPlansPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Exh And Product Tab
		atlflpp.getATLExhibitorsAndProductTab().click();

		//click on Floor plans link
		atlflpp.getATLFloorPlansLink().click();

		//Click on Building floor
		atlflpp.getATLBuildingFloor().click();

		//Scroll Down to Exhibitor list
		utl.scrollToElement(atlflpp.getATLNextFloorBtn());
		Thread.sleep(2000);
		//Stored 1st Exhibitor Name
		String exhibitorName=atlflpp.getATLExhibitorName().getText();
		System.out.println("Exhi Name: "+exhibitorName);
		Thread.sleep(5000);
		
		//Click on 1st Exhibitor
		atlflpp.getATLExhibitorName().click();

		Thread.sleep(12000);
		// Verify that Selected Exhibitor Digital Showroom page should be opened
		Assert.assertTrue(atlexhdgshw.getlvmvalidateexhdigishowpage_uat().isDisplayed());
		Thread.sleep(2000);
		//Assert.assertTrue(driver.getTitle().contains(""+exhibitorName+" at Atlanta Market"));
		Assert.assertTrue(atlexhdgshw.getlvmexhibitornameonexhdirectimg_uat().getText().contains(exhibitorName));
	}

	@Test(priority = 8)
	public void TS008_VerifyClickOnReturnToBuildingListBtnTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T328: Floor Plans: Return to Building list
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp=new ATLFloorPlansPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Exh And Product Tab
		atlflpp.getATLExhibitorsAndProductTab().click();

		//click on Floor plans link
		atlflpp.getATLFloorPlansLink().click();

		//Click on Building floor
		atlflpp.getATLBuildingFloor().click();

		//Click on Return to Building Page link
		atlflpp.getATLReturnToBuildingList().click();
		Thread.sleep(5000);

		//Verify that user should redirect to Floor plans page
		Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("lvmurl_uat")+"Market-Map"));
	}

	@Test(priority = 9)
	public void TS009_VerifySearchFunctionalityForExhListOnFloorPlansPageTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP-T293: Exhibitor functionality on floor plans page
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp=new ATLFloorPlansPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Exh And Product Tab
		atlflpp.getATLExhibitorsAndProductTab().click();

		//click on Floor plans link
		atlflpp.getATLFloorPlansLink().click();

		//Click on building floor
		atlflpp.getATLBuildingFloor().click();

		utl.scrollToElement(atlflpp.getscrollexhibitorsection());
		Thread.sleep(5000);
		Assert.assertTrue(atlflpp.getatlexhibitorsection().isDisplayed());

		atlflpp.getatlexhibitorsearch().click();

		atlflpp.getatlexhibitorsearch().sendKeys(prop.getProperty("floorplanexhibitorseacrch"));

		atlflpp.getatlserachexhibitorbtn().click();
		Thread.sleep(8000);
		Assert.assertTrue(atlflpp.getverifyexhibitor().getText().contains(prop.getProperty("floorplanexhibitorseacrch")));

		driver.get(prop.getProperty("lvmurl_uat"));
		Thread.sleep(8000);
	}

	@Test(priority = 10)
	public void TS010_VerifyAddToListFunctionalityForExhibitorOnFloorPlansPageTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T313: Floor Plans: Exhibitor Options - Add to List
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp = new ATLFloorPlansPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Click on Exh And Product Tab
		Thread.sleep(2000);
		atlflpp.getATLExhibitorsAndProductTab().click();
		Thread.sleep(2000);
		// click on Floor plans link
		atlflpp.getATLFloorPlansLink().click();
		Thread.sleep(5000);
		// click on Exhibitor floor
		//atlflpp.getLVMBuildingFloor().click(); //8th Floor
		atlflpp.getLVMBuildingFloorsix().click(); //6th floor
		Thread.sleep(12000);
		// Scroll Down to Exhibitor list
		utl.scrollToElement(atlflpp.getATLSelectBox());
		Thread.sleep(15000);

		// 1st Exhibitor Name
		String exhnameonfloorplan = atlflpp.getATLExhibitorName().getText();
		System.out.println("Exhibitor Name : " +exhnameonfloorplan );
		// Click on More option 3dots
		atlflpp.getATLMoreOptions().click();
		Thread.sleep(5000);
		
		// Click on Add To List
		atlflpp.getATLAddToList().click();
		Thread.sleep(2000);
		// Store the existing list name
		String existinglistname = atlmppge.getATLMPExistingListNameNew().getText();
		System.out.println("Existing list name: " + existinglistname);

		// Select Existing list name
		atlmppge.getATLMPExistingListNameNew().click();

		// Scroll till Add to Selected button5
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
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
		Assert.assertTrue(atlmppge.getATLSavedExhNameInList().getText().contains(exhnameonfloorplan));
	}

	@Test(priority = 11)
	public void TS011_VerifyAddNoteFunctionalityForExhibitorOnFloorPlansPageTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T314: Floor Plans: Exhibitor Options - Add Note
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp = new ATLFloorPlansPage(driver);
		genData = new GenerateData();
		atlexhact = new ATLExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		// Click on Exh And Product Tab
		atlflpp.getATLExhibitorsAndProductTab().click();
		// click on Floor plans link
		atlflpp.getATLFloorPlansLink().click();
		Thread.sleep(7000);
		// click on Exhibitor floor
		atlflpp.getATLBuildingFloor().click();
		// Scroll Down to Exhibitor list
		Thread.sleep(4000);
		utl.scrollToElement(atlflpp.getATLSelectBox());
		// 1st Exhibitor Name
		String exhibitorName = atlflpp.getATLExhibitorName().getText();
		System.out.println("Exhibitor Name : " + exhibitorName);
		
		// Click on More option 3dots
		atlflpp.getATLMoreOptions().click();
		Thread.sleep(2000);
		// Click on Add Note
		atlflpp.getATLAddNote().click();
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
		// Click on 'Add Note' icon for the same exhibitor
		atlflpp.getATLAddNote().click();
		Thread.sleep(10000);

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
	}

	@Test(priority = 12)
	public void TS012_VerifyAddToFavoriteFunctionalityForExhibitorOnFloorPlansPageTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T316: Floor Plans: Exhibitors Option - Add to Favorite
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);
		atlflpp = new ATLFloorPlansPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Exh And Product Tab
		atlflpp.getATLExhibitorsAndProductTab().click();
		// click on Floor plans link
		atlflpp.getATLFloorPlansLink().click();

		// click on Exhibitor floor
		atlflpp.getbuildingFloor_lvmUAT().click();
		Thread.sleep(5000);
		// Scroll Down to Exhibitor list
		utl.scrollToElement(atlflpp.getATLSelectBox());
		Thread.sleep(6000);
		// 1st Exhibitor Name
		String exhibitorName = atlflpp.getATLExhibitorName().getText();
		System.out.println("Exhibitor Name : " + exhibitorName);
		// Click on More option 3dots
		//atlflpp.getATLMoreOptions().click();

		// Click on Favorite icon of 1st exhibitor
		atlflpp.getATLAddFev().click();

		// Click on Market Planner link
		lap.getMPLinkText().click();

		// Click on Lists tab on MP home page
		atlmppge.getMPHomeListsTab().click();
		atlmppge.getATLMPListsPageFavoritesMenu().click();
		Thread.sleep(7000);

		//System.out.println(atlmppge.getATLSavedExhNameInList().getText());
		// Verify that the added favorites exhibitor should be displayed in to Favorites list
		Assert.assertTrue(atlmppge.getlvmsavedexhnameinlist_uat().getText().contains(exhibitorName));
		Thread.sleep(2000);
		// Delete that favorites exhibitor from list
		Actions action=new Actions(driver);
		//action.moveToElement(atlmppge.getMoreBtnDeleteOptn_lvmUAT()).perform();
		atlmppge.getMoreBtnDeleteOptn_lvmUAT().click();
		atlmppge.getATLEditListItemDeleteOptn().click();
		Thread.sleep(6000);

		favlist = driver.findElements(By.xpath("//li[@class='imc-list-edit--draggable']/div/div/div/a"));

		// Verify that the added favorites exhibitor should be removed from Favorites list
		for (int i = 1; i < favlist.size(); i++) {
			// System.out.println(favlist.get(i).getText());
			Assert.assertFalse(favlist.get(i).getText().contains(exhibitorName));
		}
	}
	@AfterClass
	public void tearDown()
	{
		//driver.quit();
	}

}
