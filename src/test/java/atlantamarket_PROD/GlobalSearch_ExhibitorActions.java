package atlantamarket_PROD;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.AtlantaMarket.ATLExhDigiShowroomPage;
import pageObjects.AtlantaMarket.ATLExhLineProdActionsPage;
import pageObjects.AtlantaMarket.ATLGlobalSearchPage;
import pageObjects.AtlantaMarket.ATLLandingPage;
import pageObjects.AtlantaMarket.ATLLoginPage;
import pageObjects.AtlantaMarket.ATLMarketPlannerPage;
import pageObjects.AtlantaMarket.ATLProductDetailsPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

@Listeners({ TestListeners.class })
public class GlobalSearch_ExhibitorActions extends base {

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

	List<WebElement> exhlist, linelist, prodlist, searchexhtypelist, searchproducttypelist, mplists, mpeditlistoptns, allnoteslist,favlist, searchlinetypelist;

	@BeforeClass
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);

		// Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("atlmrkturl_prod"));
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
	public void TS001_VerifyAddToFavoriteForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T320: The Add to Favorite functionality for an Exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

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
		Thread.sleep(4000);
		// Verify that the added favorites exhibitor should be displayed in to Favorites list
		Assert.assertTrue(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));

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

	@Test(priority = 2)
	public void TS002_VerifyAddToNewListForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T422: The Add to Newly created list functionality for an Exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("atlmrkturl_prod"));
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
				atlmppge.getNewListModalCreateBtn());

		// Click on Create button
		atlmppge.getNewListModalCreateBtn().click();
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
		Thread.sleep(5000);
		Assert.assertTrue(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));
	}

	@Test(priority = 3)
	public void TS003_VerifyAddToExistingListForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T321: The Add to Newly created list functionality for an Exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		lap = new ATLLandingPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(prop.getProperty("atlmrkturl_prod"));
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

		// Store the existing list name
		String existinglistname = atlmppge.getATLMPExistingListName().getText();
		System.out.println("Existing list name: " + existinglistname);

		// Select Existing list name
		atlmppge.getATLMPExistingListName().click();

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
		Thread.sleep(10000);
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

	@Test(priority = 4)
	public void TS004_VerifyClickOnContactExhIconForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T323: The click on 'Contact Exhibitor' functionality for an Exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("atlmrkturl_prod"));
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();

		atlgs.getATLGlobalSearchTextBox().sendKeys("IMC Test");
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		// Click on Contact Exhibitor icon
		atlexhact.getContactExhibitorIcon().click();
		Assert.assertTrue(atlexhact.getContactExhibitorModal().isDisplayed());

		// Enter Postal code
		atlexhact.getPostalCodeTxtBx().sendKeys("99950");

		// Enter Message
		atlexhact.getMessageTxtBx().sendKeys("This is a Test Exhibitor");

		// Select 1st two Product Category
		atlexhact.getProductCateg1().click();
		atlexhact.getProductCateg2().click();

		utl.scrollToElement(atlexhact.getSendMessageBtn());

		// Click on Send Message button
		// Will send msg once test exhibitor will get
		// atlexhact.getSendMessageBtn().click();

		// Close the pop-up
		atlexhact.getPopUpCloseBtn().click();
	}

	@Test(priority = 5)
	public void TS005_VerifyClickOnLocationLinksForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T356: The click on 'Location Links' functionality for an Exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("atlmrkturl_prod"));
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		// Click on any of the Location link present in Exhibitor card
		String locationlink = atlexhact.getLocationLinkInExhCard().getAttribute("href");
		atlexhact.getLocationLinkInExhCard().click();
		Thread.sleep(5000);

		// Verify that selected building-floor plan page should be opened
		Assert.assertTrue(locationlink.equals(driver.getCurrentUrl()));
	}

	@Test(priority = 6)
	public void TS006_VerifyClickOnLinesShownLinkForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T325: The click on 'Lines Shown-See All' functionality for an Exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("atlmrkturl_prod"));
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("searchexhwithlinesinput")));
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		// Click on Lines shown- See All link for an Exhibitor
		atlexhact.getLinesShownSeeAlLink().click();

		Thread.sleep(10000);
		// Verify that user should redirect to the Lines page
		Assert.assertTrue(atlexhact.getValidateLinesPage().isDisplayed());
		Assert.assertTrue(driver.getTitle().contains("{"+exhname+"} Lines"));
	}

	@Test(priority = 7)
	public void TS007_VerifyClickOnTotalProductsSeeAllLinkForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T368: The click on 'Total products-See All' functionality for an Exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(prop.getProperty("atlmrkturl_prod"));
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();
		
		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		// Get the Total Products count on Search grid
		String temp = atlexhact.getTotalProdCountOnSearchGrid().getText();
		String totalprodcountonsearchgrid = temp.replaceAll("[^0-9]", "");
		System.out.println("Total Products Count on Search Results grid is: " + totalprodcountonsearchgrid);

		// Click on Total Products-See All link for 1st Exhibitor
		atlexhact.getTotalProdSeeAllLink().click();
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
	}

	@Test(priority = 8)
	public void TS008_VerifyClickOnMatchingProductsSeeAllLinkForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T327: The click on 'Matching products-See All' functionality for an Exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("atlmrkturl_prod"));
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		// Get the Matching Products count on Search grid
		String temp = atlexhact.getMatchingProdCountOnSearchGrid().getText();
		String matchingprodcountonsearchgrid = temp.replaceAll("[^0-9]", "");
		System.out.println("Matching Products Count on Search Results grid is: " + matchingprodcountonsearchgrid);

		// Click on Matching Products-See All link for 1st Exhibitor
		atlexhact.getMatchingProdSeeAllLink().click();

		// Verify that user should redirect to the Matching Products page
		Assert.assertTrue(atlexhact.getValidateProductsPage().isDisplayed());
		Thread.sleep(10000);
		Assert.assertTrue(driver.getTitle().contains("" + exhname + " Products"));

		// Get the Matching Products count on Products page
		String producttabtitle = atlexhact.getValidateProductsPage().getText();
		String matchingprodcountonprodpage = producttabtitle.replaceAll("[^0-9]", "");
		System.out.println("Matching Products Count on Products page is: " + matchingprodcountonprodpage);

		// Verify Matching Products count on Search grid should match with Products page
		Assert.assertEquals(matchingprodcountonsearchgrid, matchingprodcountonprodpage);
	}

	@Test(priority = 9)
	public void TS009_VerifyMatchingProductsAddNoteFunctionalityForExhibitorTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T322: The click on 'Matching products-Add Note' functionality for an Exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("atlmrkturl_prod"));
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
		WebElement addnotemodaltitle = driver
				.findElement(By.xpath("//h4[contains(text(),'Add a Note For " + exhname + "')]"));
		Assert.assertTrue(addnotemodaltitle.isDisplayed());

		// Store the new note name
		String newnotetitle = "CybNote" + genData.generateRandomString(3);
		System.out.println("Newly added Note is: " + newnotetitle);

		// Enter Note title
		atlexhact.getNoteTitleTxtBx().sendKeys(newnotetitle);
		// Enter Note Content
		atlexhact.getNoteContentTxtBx().sendKeys("TestNote" + genData.generateRandomString(6));
		// Click on 'Save' button
		atlexhact.getNoteSaveBtn().click();
		Thread.sleep(10000);

		// Click on 'Add Note' icon for the same exhibitor
		atlexhact.getMatchingProdAddNoteIcon().click();
		Thread.sleep(4000);

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
	}

	@Test(priority = 10)
	public void TS010_VerifySelectionOfExhibitorFromSearchResultsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T383: The selection of an Exhibitor from Search results grid

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		lap = new ATLLandingPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("atlmrkturl_prod"));
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		exhname = atlexhact.getExhibitorName().getText();

		System.out.println("Exhibitor name: " + exhname);

		//Click on Exhibitor name
		atlexhact.getExhibitorName().click();

		// Verify that Selected Exhibitor Digital Showroom page should be opened
		Assert.assertTrue(atlexhdgshw.getATLExhDigiShowPage().isDisplayed());
		Thread.sleep(10000);
		Assert.assertTrue(driver.getTitle().contains(""+exhname+" at Atlanta Market"));
		Assert.assertTrue(atlexhdgshw.getExhNameOnExhDirectImg().getText().contains(exhname));

		driver.get(prop.getProperty("atlmrkturl_prod"));
		//lap.getCloseMarktAdBtn().click();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
