package lasvegasmarket_PROD;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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
import pageObjects.AtlantaMarket.ATLMarketPlannerPage;
import pageObjects.AtlantaMarket.ATLProductDetailsPage;
import pageObjects.LasVegasMarket.LVMExhDigiShowroomPage;
import pageObjects.LasVegasMarket.LVMExhLineProdActionsPage;
import pageObjects.LasVegasMarket.LVMGlobalSearchPage;
import pageObjects.LasVegasMarket.LVMLandingPage;
import pageObjects.LasVegasMarket.LVMLineDigitalShowroomPage;
import pageObjects.LasVegasMarket.LVMLoginPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

@Listeners({ TestListeners.class })
public class GlobalSearch_ExhibitorActions extends base {

	public WebDriverWait wait;
	public GenerateData genData;
	public Utility utl;
	public String exhname;
	LVMLoginPage lp;
	LVMLandingPage lap;
	ATLGlobalSearchPage atlgs;
	ATLExhDigiShowroomPage atlexhdgshw;
	ATLProductDetailsPage atlproddet;
	ATLExhLineProdActionsPage atlexhact;
	LVMExhLineProdActionsPage lvmexhact;
	ATLMarketPlannerPage atlmppge;
	LVMLineDigitalShowroomPage lvmdigish;
	LVMGlobalSearchPage lvmgs;
	LVMExhDigiShowroomPage lvmds;

	List<WebElement> exhlist, linelist, prodlist, searchexhtypelist, searchproducttypelist, mplists, mpeditlistoptns, allnoteslist,favlist, searchlinetypelist;

	@BeforeClass
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		utl = new Utility(driver);
		lap = new LVMLandingPage(driver);

		// Navigate to Atlanta Market site
		//driver.manage().window().maximize();
		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		try {
			lap.getIUnderstandBtn().click();
			}catch (Exception e) {
				// TODO: handle exception
			}
		Thread.sleep(7000);
		//lap.getCloseMarktAdBtn().click();
		//Login to Market Planner
		//utl.verifyMPLoginFunctionality();
		//utl.loginCheckLVM();
		//driver.navigate().refresh();
		Thread.sleep(8000);
//		lap.getCloseMarktAdBtn().click();
	}
	

	@Test(priority = 1)
	public void TS001_VerifyClickOnContactExhIconForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T323: The click on 'Contact Exhibitor' functionality for an Exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new LVMLandingPage(driver);
		lvmdigish=new LVMLineDigitalShowroomPage(driver);
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		//driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		
		utl.commonMethodForExhibotrDGShowroomm((prop.getProperty("globalsearchinput")));
		
		
		// Click on Contact Exhibitor icon
		atlexhact.getcontactExhibitorHeroComponent().click();
		Assert.assertTrue(atlexhact.getContactExhibitorModal().isDisplayed());

	
	}

	@Test(priority = 2)
	public void TS002_VerifyClickOnLocationLinksForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T356: The click on 'Location Links' functionality for an Exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new LVMLandingPage(driver);
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();
		lvmgs.getGlobalSearchTextBoxNew().click();
		lvmgs.getGlobalSearchEnterText().sendKeys((prop.getProperty("exhibitor14")));
		Thread.sleep(2000);
		lvmgs.getSearchButtonNew().click();
		
		//lvmds.getExhibitorNameNew().click();
		Thread.sleep(10000);
		
		// Click on any of the Location link present in Exhibitor card
		String locationlink = atlexhact.getexhLocationPROD().getAttribute("href");
		atlexhact.getexhLocationPROD().click();
		Thread.sleep(5000);

		// Verify that selected building-floor plan page should be opened
		Assert.assertTrue(locationlink.equals(driver.getCurrentUrl()));
		//driver.get(prop.getProperty("lvmurl_prod"));
	}

	@Test(priority = 3)
	public void TS003_VerifyClickOnLinesShownLinkForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T325: The click on 'Lines Shown-See All' functionality for an Exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new LVMLandingPage(driver);
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();

		/*
		 * atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty(
		 * "globalsearchinput"))); atlgs.getATLSearchButton().click();
		 */
		
		//lap.getCloseMarktAdBtn().click();
		lvmgs.getGlobalSearchTextBoxNew().click();
		lvmgs.getGlobalSearchEnterText().sendKeys((prop.getProperty("globalsearchinput")));
		Thread.sleep(2000);
		lvmgs.getSearchButtonNew().click();
		Thread.sleep(10000);

		// Store the 1st Exhibitor name in String variable
		exhname = lvmds.getExhibitorNameNew().getText();
		System.out.println("Exhibitor name: " + exhname);
		//lvmds.getExhibitorNameNew().click();
		// Click on Lines shown- See All link for an Exhibitor
		atlexhact.getlvmSeeAllLines().click();

		Thread.sleep(15000);
		// Verify that user should redirect to the Lines page
		Assert.assertTrue(atlexhact.getValidateLinesPage().isDisplayed());
		System.out.println(driver.getTitle());
		//Assert.assertTrue(driver.getTitle().contains("{"+exhname+"} Lines")); //Old assertion
		Assert.assertTrue(driver.getTitle().contains(exhname +" Lines")); //New assertion statement
		//driver.get(prop.getProperty("lvmurl_prod"));
	}

	@Test(priority = 4)
	public void TS004_VerifyClickOnTotalProductsSeeAllLinkForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T368: The click on 'Total products-See All' functionality for an Exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new LVMLandingPage(driver);
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		
		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();
		/*
		 * atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("exhibitor3")));
		 * atlgs.getATLSearchButton().click();
		 */
		lvmgs.getGlobalSearchTextBoxNew().click();
		lvmgs.getGlobalSearchEnterText().sendKeys((prop.getProperty("exhibitor3")));
		Thread.sleep(2000);
		lvmgs.getSearchButtonNew().click();
		Thread.sleep(10000);

		// Store the 1st Exhibitor name in String variable
		exhname = lvmds.getExhibitorNameNew().getText();
		System.out.println("Exhibitor name: " + exhname);
		//lvmds.getExhibitorNameNew().click();
		// Get the Total Products count on Search grid
		String temp = atlexhact.getlvmTotalProductBtn().getText();
		
		String totalprodcountonsearchgrid = temp.replaceAll("[^0-9]", "");
		System.out.println("Total Products Count on Search Results grid is: " + totalprodcountonsearchgrid);
		Thread.sleep(5000);
		utl.scrollElementIntoMiddle(atlexhact.getlvmTotalProductBtn());
		// Click on Total Products-See All link for 1st Exhibitor
		atlexhact.getlvmTotalProductBtn().click(); 
		 
		Thread.sleep(6000);

		// Verify that user should redirect to the Products page
		Assert.assertTrue(atlexhact.getValidateProductsPage().isDisplayed());
		Thread.sleep(6000);

		Assert.assertTrue(driver.getTitle().contains(""+exhname+" Products"));

		// Get the Total Products count on Products page
		String producttabtitle = atlexhact.getValidateProductsPage().getText();
		String totalprodcountonprodpage = producttabtitle.replaceAll("[^0-9]", "");
		System.out.println("Total Products Count on Products page is: " + totalprodcountonprodpage);

		// Verify Total Products count on Search grid should match with Products page
		Assert.assertEquals(totalprodcountonsearchgrid, totalprodcountonprodpage);
		//driver.get(prop.getProperty("lvmurl_prod"));
	}

	//@Test(priority = 5)
	public void TS005_VerifyClickOnMatchingProductsSeeAllLinkForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T327: The click on 'Matching products-See All' functionality for an Exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new LVMLandingPage(driver);
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		
		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();

		/*
		 * atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty(
		 * "globalsearch_input"))); atlgs.getATLSearchButton().click();
		 */
		lvmgs.getGlobalSearchTextBoxNew().click();
		lvmgs.getGlobalSearchEnterText().sendKeys((prop.getProperty("globalsearch_input")));
		Thread.sleep(2000);
		lvmgs.getSearchButtonNew().click();
		Thread.sleep(10000);
		
		exhname = lvmds.getExhibitorNameNew().getText();
		System.out.println("Exhibitor name: " + exhname);
		//lvmds.getExhibitorNameNew().click();
		
		// Get the Matching Products count on Search grid
		String temp = atlexhact.getlvmMatchingProductLink().getText();
		String matchingprodcountonsearchgrid = temp.replaceAll("[^0-9]", "");
		System.out.println("Matching Products Count on Search Results grid is: " + matchingprodcountonsearchgrid);

		// Click on Matching Products-See All link for 1st Exhibitor
		atlexhact.getlvmMatchingProductLink().click();

		Thread.sleep(10000);
		// Verify that user should redirect to the Matching Products page
		Assert.assertTrue(atlexhact.getValidateProductsPage().isDisplayed());
		Assert.assertTrue(driver.getTitle().contains("" + exhname + " Products"));

		// Get the Matching Products count on Products page
		String producttabtitle = atlexhact.getValidateProductsPage().getText();
		String matchingprodcountonprodpage = producttabtitle.replaceAll("[^0-9]", "");
		System.out.println("Matching Products Count on Products page is: " + matchingprodcountonprodpage);

		// Verify Matching Products count on Search grid should match with Products page
		Assert.assertEquals(matchingprodcountonsearchgrid, matchingprodcountonprodpage);
		//driver.get(prop.getProperty("lvmurl_prod"));
	}

	@Test(priority = 6)
	public void TS006_VerifySelectionOfExhibitorFromSearchResultsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T383: The selection of an Exhibitor from Search results grid

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		lap = new LVMLandingPage(driver);
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();

		/*
		 * atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty(
		 * "globalsearchinput"))); atlgs.getATLSearchButton().click();
		 */
		lvmgs.getGlobalSearchTextBoxNew().click();
		lvmgs.getGlobalSearchEnterText().sendKeys((prop.getProperty("globalsearch_input")));
		Thread.sleep(2000);
		lvmgs.getSearchButtonNew().click();
		Thread.sleep(10000);
		
		exhname = lvmds.getExhibitorNameNew().getText();
		System.out.println("Exhibitor name: " + exhname);

		Thread.sleep(15000);
		String exhURL=lvmds.getExhibitorNameNew().getAttribute("href");
		
		//Click on Exhibitor name
		lvmds.getExhibitorNameNew().click();

		Thread.sleep(10000);
		String currentURL=driver.getCurrentUrl();
		// Verify that Selected Exhibitor Digital Showroom page should be opened
		//Assert.assertTrue(atlexhdgshw.getATLExhDigiShowPage().isDisplayed());
		Assert.assertTrue(exhURL.contains(currentURL));
		
		//Assert.assertTrue(driver.getTitle().contains(""+exhname+" at Las Vegas Market"));
		/*
		 * try {
		 * Assert.assertTrue(atlexhdgshw.getExhNameOnExhDirectImg().getText().contains(
		 * exhname)); }catch (Exception e) {
		 * Assert.assertTrue(atlexhdgshw.getExhNameOnExhDirectImg1().getText().contains(
		 * exhname)); }
		 */

		//driver.get(prop.getProperty("lvmurl_prod"));
		//lap.getCloseMarktAdBtn().click();
	}
	
	@Test(enabled=false)//priority = 1
    public void TS007_VerifyAddToFavoriteForExhibitorTest() throws InterruptedException, IOException {
        // The purpose of this test case to verify:-
        // T320: The Add to Favorite functionality for an Exhibitor

        atlgs = new ATLGlobalSearchPage(driver);
        atlexhact = new ATLExhLineProdActionsPage(driver);
        lap = new LVMLandingPage(driver);
        atlmppge = new ATLMarketPlannerPage(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
        atlgs.getATLSearchButton().click();
        Thread.sleep(15000);
        // Store the 1st Exhibitor name in String variable
        String exhname = atlexhact.getExhibitorName().getText();
        System.out.println("Exhibitor name: " + exhname);

        // Click on Favorite icon of 1st exhibitor
        atlexhact.getAddFavIcon().click();

        // Click on Market Planner link
        lap.getMPLinkText().click();

        // Click on Lists tab on MP home page
        atlmppge.getMPHomeListsTab().click();
        atlmppge.getATLMPListsPageFavoritesMenu().click();

        // Verify that the added favorites exhibitor should be displayed in to Favorites list
        Assert.assertTrue(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));

        // Delete that favorites exhibitor from list
        //atlmppge.getATLEditListItemMoreBtn().click();//Old
        //atlmppge.getATLEditListItemDeleteOptn().click();//old
        atlmppge.getMoreBtnDeleteOptnExistingList_ATLPROD().click();//new
        atlmppge.getATLEditListItemDeleteOptn().click();//new
        Thread.sleep(6000);

        favlist = driver.findElements(By.xpath("//li[@class='imc-list-edit--draggable']/div/div/div/a"));

        //Verify that the added favorites exhibitor should be removed from Favorites list
        for(int i=1; i< favlist.size(); i++)
        {           
            //System.out.println(favlist.get(i).getText());
            Assert.assertFalse(favlist.get(i).getText().contains(exhname)); 
        }
    }

    @Test(enabled=false)//priority = 2
    public void TS008_VerifyAddToNewListForExhibitorTest() throws InterruptedException, IOException {
        // The purpose of this test case to verify:-
        // T422: The Add to Newly created list functionality for an Exhibitor

        atlgs = new ATLGlobalSearchPage(driver);
        atlexhact = new ATLExhLineProdActionsPage(driver);
        atlmppge = new ATLMarketPlannerPage(driver);
        genData = new GenerateData();
        
        driver.get(prop.getProperty("lvmurl_prod"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
        Thread.sleep(6000);
        //lap.getCloseMarktAdBtn().click();

        atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
        atlgs.getATLSearchButton().click();
        Thread.sleep(15000);
        // Store the 1st Exhibitor name in String variable
        String exhname = atlexhact.getExhibitorName().getText();
        System.out.println("Exhibitor name: " + exhname);

        // Click on Add to List button for 1st Exhibitor
        atlexhact.getSearchResultMoreicon().click();
        atlexhact.getAddToListOptn().click();

        // Enter new list name
        String newlistname = "Cyb" + genData.generateRandomString(5);
        atlmppge.getCreateNewListNameTxtbx().sendKeys(newlistname);
        System.out.println("Newly created list is: " + newlistname);

        // Scroll till Create button
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
        atlmppge.getNewlistmodalcreatebtn_LvmUAT());

        // Click on Create button
        atlmppge.getNewlistmodalcreatebtn_LvmUAT().click();
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
            if (mplists.get(i).getText().equals(newlistname)) {
                mpeditlistoptns.get(i).click();
                break;
            }
        }
        Assert.assertTrue(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));
    }

    @Test(enabled=false)//priority = 3
    public void TS009_VerifyAddToExistingListForExhibitorTest() throws InterruptedException, IOException {
        // The purpose of this test case to verify:-
        // T321: The Add to Newly created list functionality for an Exhibitor

        atlgs = new ATLGlobalSearchPage(driver);
        atlexhact = new ATLExhLineProdActionsPage(driver);
        atlmppge = new ATLMarketPlannerPage(driver);
        lap = new LVMLandingPage(driver);
        
        driver.navigate().refresh();
        driver.get(prop.getProperty("lvmurl_prod"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Thread.sleep(6000);
        //lap.getCloseMarktAdBtn().click();
        
        atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
        atlgs.getATLSearchButton().click();

        Thread.sleep(15000);
        // Store the 1st Exhibitor name in String variable
        String exhname = atlexhact.getExhibitorName().getText();
        System.out.println("Exhibitor name: " + exhname);

        // Click on Add to List button for 1st Exhibitor
        atlexhact.getSearchResultMoreicon().click();
        atlexhact.getAddToListOptn().click();
        Thread.sleep(4000);
        // Store the existing list name
        String existinglistname = atlmppge.getATLMPExistingListNameNew().getText();
        System.out.println("Existing list name: " + existinglistname);

        // Select Existing list name
        atlmppge.getATLMPExistingListNameNew().click();

        // Scroll till Add to Selected button
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
        Assert.assertTrue(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));

        // Delete that added exhibitor from list
        //atlmppge.getATLEditListItemMoreBtn().click(); //Old btn not working
        atlmppge.getATLEditListItemMoreBtnNew().click(); // new btn
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

    @Test(enabled=false)//old priority 9
    public void TS010_VerifyMatchingProductsAddNoteFunctionalityForExhibitorTest()
            throws InterruptedException, IOException {
        // The purpose of this test case to verify:-
        // T322: The click on 'Matching products-Add Note' functionality for an Exhibitor

        atlgs = new ATLGlobalSearchPage(driver);
        atlexhact = new ATLExhLineProdActionsPage(driver);
        lap = new LVMLandingPage(driver);
        genData = new GenerateData();
        
        driver.get(prop.getProperty("lvmurl_prod"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Thread.sleep(6000);
        //lap.getCloseMarktAdBtn().click();

        atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
        atlgs.getATLSearchButton().click();

        Thread.sleep(15000);
        // Store the 1st Exhibitor name in String variable
        exhname = atlexhact.getExhibitorName().getText();
        System.out.println("Exhibitor name: " + exhname);

        // Click on Matching Products-See All link for 1st Exhibitor
        atlexhact.getMatchingProdSeeAllLink().click();

        // Click on 'Add Note' icon on Matching products page
        atlexhact.getMatchingProdAddNoteIcon().click();

        // Verify that Add note for selected exhibitor modal should be displayed
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement addnotemodaltitle = driver
                .findElement(By.xpath("//h4[contains(text(),'Add a Note For " + exhname + "')]"));
        Assert.assertTrue(addnotemodaltitle.isDisplayed());

        // Store the new note name
        String newnotetitle = "CybNote" + genData.generateRandomString(3);
        System.out.println("Newly added Note is: " + newnotetitle);
        Thread.sleep(1000);
        // Enter Note title
        atlexhact.getNoteTitleTxtBx().sendKeys(newnotetitle);
        Thread.sleep(1000);
        // Enter Note Content
        atlexhact.getNoteContentTxtBx().sendKeys("TestNote" + genData.generateRandomString(6));
        // Click on 'Save' button
        atlexhact.getNoteSaveBtn().click();
        Thread.sleep(7000);
        // Click on 'Add Note' icon for the same exhibitor
        atlexhact.getMatchingProdAddNoteIcon().click();
        Thread.sleep(5000);

        // Click on 'View all Notes for an Exhibitor' link on Add Notes pop-up
        atlexhact.getViewAllNotesLink().click();
        Thread.sleep(5000);

        // Verify that Add note for selected exhibitor modal should be displayed
        WebElement allnotesmodaltitle = driver
                .findElement(By.xpath("//h4[contains(text(),'All Notes For " + exhname + "')]"));

        Assert.assertTrue(allnotesmodaltitle.isDisplayed());

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
        driver.get(prop.getProperty("lvmurl_prod"));
    }

	@AfterClass
	public void tearDown()
	{
		//driver.quit();
	}
}
