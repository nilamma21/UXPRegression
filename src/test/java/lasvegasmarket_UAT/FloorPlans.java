package lasvegasmarket_UAT;

import java.io.IOException;
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
import lasvegasmarket_PROD.TestListeners;
import pageObjects.AtlantaMarket.ATLExhDigiShowroomPage;
import pageObjects.AtlantaMarket.ATLExhLineProdActionsPage;
import pageObjects.AtlantaMarket.ATLFloorPlansPage;
import pageObjects.AtlantaMarket.ATLGlobalSearchPage;
import pageObjects.AtlantaMarket.ATLLandingPage;
import pageObjects.AtlantaMarket.ATLLoginPage;
import pageObjects.AtlantaMarket.ATLMarketPlannerPage;
import pageObjects.AtlantaMarket.ATLProductDetailsPage;
import pageObjects.LasVegasMarket.LVMExhDigiShowroomPage;
import pageObjects.LasVegasMarket.LVMFloorPlansPage;
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
    LVMFloorPlansPage lvmflpp;
    LVMExhDigiShowroomPage lvmexhdgshw;

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
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(7000);

  }

    @Test(priority = 1)
    public void TS001_VerifyNavigationToDifferentFloorBuildingsTest() throws InterruptedException, IOException {
        // The purpose of this test case to verify:-
        // UXP-T627: To verify Floor Plans: Navigation to different floor/buildings
        lap = new ATLLandingPage(driver);
        lp = new ATLLoginPage(driver);
        utl = new Utility(driver);
        lvmflpp= new LVMFloorPlansPage(driver);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
        // Click on Exh And Product Tab
        lvmflpp.getLVMExhibitorsAndProductTab().click();

        //click on Floor plans link
        lvmflpp.getLVMFloorPlansLink().click();
        Thread.sleep(5000);

        //Verify that user should redirect to Floor plans page
        Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("lvmurl_uat")+"Market-Map"));

        utl.scrollToElement(lvmflpp.getLVMBuildingFloor());
        //Click on Building/floor
        String floorName=lvmflpp.getLVMBuildingFloor().getText();
        System.out.println("Floor Name : " +floorName);

        String locationlink = lvmflpp.getLVMBuildingFloor().getAttribute("href");
        System.out.println(locationlink);

        //Click on !st floor of first building.
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

        lap = new ATLLandingPage(driver);
        lp = new ATLLoginPage(driver);
        utl = new Utility(driver);
        lvmflpp= new LVMFloorPlansPage(driver);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Click on Exh And Product Tab
        lvmflpp.getLVMExhibitorsAndProductTab().click();

        //click on Floor plans link
        lvmflpp.getLVMFloorPlansLink().click();

        //click on Floor whose not having an Exhibitors
        String floorName=lvmflpp.getLVMBuildingFloor().getText();
        System.out.println("Floor Name : " +floorName);

        //click on No Exhibitor floor
        
        lvmflpp.getlvmNoExhibitorFloor_uat().click();

        //Verify that Loading Exhibitors msg should be displayed
        //Assert.assertTrue(atlflpp.getATLLoadingExhMsg().isDisplayed());
        Thread.sleep(4000);
        //Verify that No Exhibitor msg should be displayed
        Assert.assertTrue(lvmflpp.getLVMNoExpMsg().isDisplayed());
    }

    @Test(priority = 3)
    public void TS003_VerifyZoomInOutLevelOnFloorPlansPageTest() throws InterruptedException, IOException {
        // The purpose of this test case:-
        // UXP-T629: To verify Floor Plans: Zoom Levels

        lap = new ATLLandingPage(driver);
        lp = new ATLLoginPage(driver);
        utl = new Utility(driver);
        lvmflpp=new LVMFloorPlansPage(driver);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Click on Exh And Product Tab
        lvmflpp.getLVMExhibitorsAndProductTab().click();

        //click on Floor plans link
        lvmflpp.getLVMFloorPlansLink().click();
        utl.scrollToElement(lvmflpp.getLVMBuildingFloor());
        
        //click on any floor
        lvmflpp.getLVMBuildingFloor().click();

        utl.scrollToElement(lvmflpp.getLVMExhibitorFloorZoomIn());
        //Click on Zoom In icon
        lvmflpp.getLVMExhibitorFloorZoomIn().click();
        //Store Zoom in Attribute
        String x1= lvmflpp.getLVMFloorPlanMapIamge().getAttribute("style");

        lvmflpp.getLVMExhibitorFloorZoomIn().click();
        //Stored Zoom in Attribute
        String x2=lvmflpp.getLVMFloorPlanMapIamge().getAttribute("style");

        //Store Zoom in Attribute
        lvmflpp.getLVMExhibitorFloorZoomIn().click();
        String x3=lvmflpp.getLVMFloorPlanMapIamge().getAttribute("style");

        //Verify Zoom In functionality
        Assert.assertNotEquals(x2, x3);
        Thread.sleep(5000);

        //Click on Zoom Out icon
        lvmflpp.getLVMExhibitorFloorZoomOut().click();
        lvmflpp.getLVMExhibitorFloorZoomOut().click();
        //Stored Zoom out Attribute
        String out=lvmflpp.getLVMFloorPlanMapIamge().getAttribute("style");

        //Verify Zoom Out functionality
        Assert.assertNotEquals(x1, out);
    }

    @Test(priority = 4)
    public void TS004_VerifyIconsOnFloorPlansPageTest() throws InterruptedException, IOException {
        // The purpose of this test case to:-
        // UXP-T808: To verify Floor Plans: Icons

        lap = new ATLLandingPage(driver);
        lp = new ATLLoginPage(driver);
        utl = new Utility(driver);
        lvmflpp=new LVMFloorPlansPage(driver);

        driver.get(prop.getProperty("lvmurl_uat"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(2000);
        // Click on Exh And Product Tab
        lvmflpp.getLVMExhibitorsAndProductTab().click();

        //click on Floor plans link
        lvmflpp.getLVMFloorPlansLink().click();

        utl.scrollToElement(lvmflpp.getLVMBuildingFloor());
        //click on any floor
        lvmflpp.getLVMBuildingFloor().click();

        //Click on Vending Machine icon on Map image
        Thread.sleep(5000);
        utl.scrollToElement(lvmflpp.getlvmflooricononmap_lvmUAT());
        lvmflpp.getlvmflooricononmap_lvmUAT().click();

        //Verify that Vending Machine Overlay should appeared on Map
        Assert.assertTrue(lvmflpp.getlvmflooriconoverlay_lvmUAT().isDisplayed());

    }

    

    @Test(priority = 5)
    public void TS005_VerifyPaginationOnFloorPlansPageTest() throws InterruptedException, IOException {
        // The purpose of this test case to verify:-
        // UXP-T633: Floor Plans: Pagination
        lap = new ATLLandingPage(driver);
        lp = new ATLLoginPage(driver);
        utl = new Utility(driver);
        lvmflpp=new LVMFloorPlansPage(driver);

        driver.get(prop.getProperty("lvmurl_uat"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(1000);
        // Click on Exh And Product Tab
        lvmflpp.getLVMExhibitorsAndProductTab().click();

        //click on Floor plans link
        lvmflpp.getLVMFloorPlansLink().click();

        utl.scrollToElement(lvmflpp.getLVMBuildingFloor());
        //Click on Building floor
        lvmflpp.getLVMBuildingFloor().click();

        //Scroll Down to Exhibitor list
        utl.scrollToElement(lvmflpp.getLVMNextFloorBtn());

        utl.scrollToElement(lvmflpp.getLVMNextFloorBtn());
        String actualNextFloorNumber=lvmflpp.getLVMNextFloorBtn().getText();
        System.out.println(actualNextFloorNumber);
        lvmflpp.getLVMNextFloorBtn().click();
        Thread.sleep(5000);
        String exptectedFloorNumber=lvmflpp.getLVMExpectedFloorNumber().getText();
        System.out.println(exptectedFloorNumber);
        //Verify Next Floor
        Assert.assertTrue(exptectedFloorNumber.contains(actualNextFloorNumber));
        Thread.sleep(1000);
        //Previous floor Btn
        utl.scrollToElement(lvmflpp.getLVMPreviousFloorBtn());
        String actualPreviousFloorNumber=lvmflpp.getLVMPreviousFloorBtn().getText();
        System.out.println(actualPreviousFloorNumber);
        lvmflpp.getLVMPreviousFloorBtn().click();
        Thread.sleep(5000);
        String exptectedPeviousFloorNumber=lvmflpp.getLVMExpectedFloorNumber().getText();
        System.out.println(exptectedPeviousFloorNumber);
        //Verify Previous Floor
        Assert.assertTrue(exptectedPeviousFloorNumber.contains(actualPreviousFloorNumber)); 
    }

    @Test(priority = 6)
    public void TS006_VerifySelectionOfExhibitorOnFloorPlansPageTest() throws InterruptedException, IOException {
        // The purpose of this test case to verify:-
        // UXP-T666: Floor Plans: Select Exhibitors
        lap = new ATLLandingPage(driver);
        lp = new ATLLoginPage(driver);
        utl = new Utility(driver);
        lvmflpp=new LVMFloorPlansPage(driver);
        lvmexhdgshw = new LVMExhDigiShowroomPage(driver);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Click on Exh And Product Tab
        lvmflpp.getLVMExhibitorsAndProductTab().click();

        //click on Floor plans link
        lvmflpp.getLVMFloorPlansLink().click();

        //Click on Building floor
        utl.scrollToElement(lvmflpp.getLVMBuildingFloor());
        lvmflpp.getLVMBuildingFloor().click();

        Thread.sleep(8000);
        //Scroll Down to Exhibitor list
        utl.scrollToElement(lvmflpp.getLVMExhibitorName());
        Thread.sleep(2000);
        //Stored 1st Exhibitor Name
        String exhibitorName=lvmflpp.getLVMExhibitorName().getText();
        System.out.println("Exhi Name: "+exhibitorName);
        Thread.sleep(5000);
        
        //Click on 1st Exhibitor
        lvmflpp.getLVMExhibitorName().click();

        Thread.sleep(12000);
        // Verify that Selected Exhibitor Digital Showroom page should be opened
        Assert.assertTrue(lvmexhdgshw.getlvmvalidateexhdigishowpage_uat().isDisplayed());
        Thread.sleep(5000);
        //Assert.assertTrue(driver.getTitle().contains(""+exhibitorName+" at Atlanta Market"));
        Assert.assertTrue(lvmexhdgshw.getlvmexhibitornameonexhdirectimg_uat().getText().contains(exhibitorName));
    }

    @Test(priority = 7)
    public void TS007_VerifyClickOnReturnToBuildingListBtnTest() throws InterruptedException, IOException {
        // The purpose of this test case to verify:-
        // UXP-T669: Floor Plans: Return to Building list
        lap = new ATLLandingPage(driver);
        lp = new ATLLoginPage(driver);
        utl = new Utility(driver);
        lvmflpp=new LVMFloorPlansPage(driver);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Click on Exh And Product Tab
        lvmflpp.getLVMExhibitorsAndProductTab().click();

        //click on Floor plans link
        lvmflpp.getLVMFloorPlansLink().click();

        //Click on Building floor
        utl.scrollToElement(lvmflpp.getLVMBuildingFloor());
        lvmflpp.getLVMBuildingFloor().click();

        //Click on Return to Building Page link
        lvmflpp.getLVMReturnToBuildingList().click();
        Thread.sleep(5000);

        //Verify that user should redirect to Floor plans page
        Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("lvmurl_uat")+"Market-Map"));
    }

    @Test(priority = 8)
    public void TS008_VerifySearchFunctionalityForExhListOnFloorPlansPageTest() throws InterruptedException, IOException {

        // The purpose of this test case to verify:-
        // UXP-T635: Exhibitor functionality on floor plans page
        lap = new ATLLandingPage(driver);
        lp = new ATLLoginPage(driver);
        utl = new Utility(driver);
        lvmflpp=new LVMFloorPlansPage(driver);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Click on Exh And Product Tab
        lvmflpp.getLVMExhibitorsAndProductTab().click();

        //click on Floor plans link
        lvmflpp.getLVMFloorPlansLink().click();

        //Click on building floor
        utl.scrollToElement(lvmflpp.getLVMBuildingFloor());
        lvmflpp.getLVMBuildingFloor().click();

        utl.scrollToElement(lvmflpp.getscrollexhibitorsection());
        Thread.sleep(5000);
        Assert.assertTrue(lvmflpp.getlvmexhibitorsection().isDisplayed());

        lvmflpp.getlvmexhibitorsearch().click();

        lvmflpp.getlvmexhibitorsearch().sendKeys(prop.getProperty("floorplanexhibitorseacrch"));

        lvmflpp.getlvmserachexhibitorbtn().click();
        Thread.sleep(8000);
        Assert.assertTrue(lvmflpp.getverifyexhibitor().getText().contains(prop.getProperty("floorplanexhibitorseacrch")));

        driver.get(prop.getProperty("lvmurl_uat"));
        Thread.sleep(8000);
    }

    @Test(enabled=false)//priority = 10
    public void TS009_VerifyAddToListFunctionalityForExhibitorOnFloorPlansPageTest() throws InterruptedException, IOException {
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
        Thread.sleep(3000);
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

    @Test(enabled=false)//priority = 11
    public void TS010_VerifyAddNoteFunctionalityForExhibitorOnFloorPlansPageTest() throws InterruptedException, IOException {
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

    @Test(enabled=false)//priority = 12
    public void TS011_VerifyAddToFavoriteFunctionalityForExhibitorOnFloorPlansPageTest() throws InterruptedException, IOException {
        // The purpose of this test case to verify:-
        // UXP-T316: Floor Plans: Exhibitors Option - Add to Favorite
        lap = new ATLLandingPage(driver);
        lp = new ATLLoginPage(driver);
        utl = new Utility(driver);
        atlflpp = new ATLFloorPlansPage(driver);
        atlmppge = new ATLMarketPlannerPage(driver);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(2000);
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
        favlist = atlmppge.getFavExhList();
        for (int i = 0; i < favlist.size(); i++) {
            if(favlist.contains(exhibitorName)) {
                System.out.println(exhibitorName);
                Assert.assertTrue(favlist.get(i).getText().contains(exhibitorName));
                break;
            }
        }
        //Assert.assertTrue(atlmppge.getlvmsavedexhnameinlist_uat().getText().contains(exhibitorName));//old
        Thread.sleep(2000);
        // Delete that favorites exhibitor from list
        //Actions action=new Actions(driver);
        //action.moveToElement(atlmppge.getMoreBtnDeleteOptn_lvmUAT()).perform();
        atlmppge.getMoreBtnDeleteOptn_lvmUAT().click();
        atlmppge.getATLEditListItemDeleteOptn().click();
        Thread.sleep(7000);

        // Verify that the added favorites exhibitor should be removed from Favorites list
        for (int i = 1; i < favlist.size(); i++) {
            Assert.assertFalse(favlist.get(i).getText().contains(exhibitorName));
            break;
        }
    }
    
    @Test(enabled=false)//priority = 5
    public void TS012_VerifyFunctionalityOfFiltersOFloorPlansPageTest() throws InterruptedException, IOException {
        // The purpose of this test case to verify:-
        // UXP-T290: To verify Floor Plans: Filter
        lap = new ATLLandingPage(driver);
        lp = new ATLLoginPage(driver);
        utl = new Utility(driver);
        lvmflpp=new LVMFloorPlansPage(driver);
        
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // Click on Exh And Product Tab
        lvmflpp.getLVMExhibitorsAndProductTab().click();
        Thread.sleep(2000);
        //click on Floor plans link
        lvmflpp.getLVMFloorPlansLink().click();
        Thread.sleep(2000);
        //Click on Building floorr
        lvmflpp.getLVMBuildingFloorForFilter().click();
        Thread.sleep(6000);
        //Scroll Down to Exhibitor list
        utl.scrollToElement(lvmflpp.getLVMSelectBox());
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


    }
    
    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

}
