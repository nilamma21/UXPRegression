package atlantamarket;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertSame;

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
public class AtlantaMarketRegressTest_UAT extends base {

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
	List<WebElement> exhlist, linelist, prodlist, searchtypelist, mplists, mpeditlistoptns, allnoteslist, favlist,
			searchlinetypelist;

	@BeforeTest
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
	}

	@Test(priority = 1)
	public void TS001_VerifyMarketPlannerLoginTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-001: To verify the Market Planner overview and it's functionality

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Login to Market Planner
		utl.verifyMPLoginFunctionality();

		Thread.sleep(6000);
		lap.getCloseMarktAdBtn().click();

		// Verify that Market Planner Home page should be displayed
		Assert.assertTrue(lap.getMPLinkText().isDisplayed());
		
	}

	@Test(priority = 2)
	public void TS002_VerifySelectionOfExhibitorFromAutoSuggestionListTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T419: The selection of an Exhibitor from Auto Suggestion List

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("autosuggestexhibitor")));

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li")));

		exhlist = atlgs.getATLSearchResultsList();
		searchtypelist = atlgs.getATLSearchResultTypeList();

		for (int i = 0; i < 10; i++) {
			// System.out.println(list.get(i).getText());
			if (exhlist.get(i).getText().equals(prop.getProperty("autosuggestexhibitor"))
					&& searchtypelist.get(i).getText().equals("Exhibitor")) {
				exhlist.get(i).click();
				break;
			}
		}
		Assert.assertTrue(atlexhdgshw.getATLValidateExhDigiShowPage().isDisplayed());
		atlgs.getATLClearSearchBtn().click();
	}

	@Test(priority = 3)
	public void TS003_VerifySelectionOfLineFromAutoSuggestionListTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T420: The selection of a Line from Auto Suggestion List

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("autosuggestline")));

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li")));

		linelist = atlgs.getATLSearchResultsList();
		searchlinetypelist = atlgs.getATLSearchResultTypeLineList();

		for (int i = 0; i < 10; i++) {
			// System.out.println(list.get(i).getText());
			if (linelist.get(i).getText().equals(prop.getProperty("autosuggestline"))
					&& searchlinetypelist.get(i).getText().equals("Line")) {

				linelist.get(i).click();
				break;
			}
		}
		Assert.assertTrue(atlexhdgshw.getATLValidateExhDigiShowPage().isDisplayed());
		atlgs.getATLClearSearchBtn().click();
	}

	@Test(priority = 4)
	public void TS004_VerifySelectionOfProductFromAutoSuggestionListTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T420: The selection of a Product from Auto Suggestion List

		atlgs = new ATLGlobalSearchPage(driver);
		atlproddet = new ATLProductDetailsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("autosuggestproduct")));

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li")));

		prodlist = atlgs.getATLProductsSearchResultsList();
		searchtypelist = atlgs.getATLSearchResultTypeList();

		for (int i = 0; i < 10; i++) {
			// System.out.println(list.get(i).getText());
			if (prodlist.get(i).getText().equals(prop.getProperty("autosuggestproduct"))
					&& searchtypelist.get(i).getText().equals("Product")) {
				prodlist.get(i).click();
				break;
			}
		}
		Thread.sleep(5000);
		Assert.assertTrue(atlproddet.getATLValidateProdDetailsPage().isDisplayed());
		atlgs.getATLClearSearchBtn().click();
	}

	@Test(priority = 5)
	public void TS005_VerifyAddToFavoriteForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T320: The Add to Favorite functionality for an Exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();

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

		// Verify that the added favorites exhibitor should be displayed in to Favorites
		// list
		Assert.assertTrue(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));

		// Delete that favorites exhibitor from list
		atlmppge.getATLEditListItemMoreBtn().click();
		atlmppge.getATLEditListItemDeleteOptn().click();
		Thread.sleep(6000);

		// Verify that the added favorites exhibitor should be removed from Favorites
		// list
		Assert.assertFalse(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));

		// Verify that the added favorites exhibitor should be removed from Favorites
		// list
		for (int i = 1; i < 10; i++) {
			favlist = driver.findElements(By.xpath("//li[@class='imc-list-edit--draggable'][" + i + "]/div/div/div/a"));
			System.out.println(favlist.get(i).getText());
			/*
			 * Assert.assertequals(favlist.get(i).getText().contains(exhname));
			 * if(favlist.get(i).getText().contains(exhname)) { break; }
			 */
		}
		// Assert.assertFalse(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));
		atlgs.getATLClearSearchBtn().click();

	}

	@Test(priority = 6)
	public void TS006_VerifyAddToNewListForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T422: The Add to Newly created list functionality for an Exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();

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
		Assert.assertTrue(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));
		atlgs.getATLClearSearchBtn().click();
	}

	@Test(priority = 7)
	public void TS007_VerifyAddToExistingListForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T321: The Add to Newly created list functionality for an Exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();

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
		Thread.sleep(5000);
		Assert.assertTrue(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));

		// Delete that added exhibitor from list
		atlmppge.getATLEditListItemMoreBtn().click();
		atlmppge.getATLEditListItemDeleteOptn().click();
		Thread.sleep(8000);

		// Verify that the added exhibitor should be removed from Existing list
		// Assert.assertFalse(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));

		// Verify that the added exhibitor should be removed from Existing list
		// Assert.assertFalse(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));
		atlgs.getATLClearSearchBtn().click();

	}

	@Test(priority = 8)
	public void TS008_VerifyClickOnContactExhIconForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T323: The click on 'Contact Exhibitor' functionality for an Exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys("IMC Test");
		atlgs.getATLSearchButton().click();

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
		atlgs.getATLClearSearchBtn().click();
	}

	@Test(priority = 9)
	public void TS009_VerifyClickOnLocationLinksForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T356: The click on 'Location Links' functionality for an Exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();

		// Click on any of the Location link present in Exhibitor card
		String locationlink = atlexhact.getLocationLinkInExhCard().getAttribute("href");
		atlexhact.getLocationLinkInExhCard().click();
		Thread.sleep(5000);

		// Verify that selected building-floor plan page should be opened
		Assert.assertTrue(locationlink.equals(driver.getCurrentUrl()));
		atlgs.getATLClearSearchBtn().click();
	}

	@Test(priority = 10)
	public void TS010_VerifyClickOnLinesShownLinkForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T325: The click on 'Lines Shown-See All' functionality for an Exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("searchexhwithlinesinput")));
		atlgs.getATLSearchButton().click();

		// Store the 1st Exhibitor name in String variable
		exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		// Click on Lines shown- See All link for an Exhibitor
		atlexhact.getLinesShownSeeAlLink().click();

		// Verify that user should redirect to the Lines page
		Assert.assertTrue(atlexhact.getValidateLinesPage().isDisplayed());

		Assert.assertTrue(driver.getTitle().contains("{" + exhname + "} Lines"));

		Assert.assertTrue(driver.getTitle().contains("{" + exhname + "} Lines"));
		atlgs.getATLClearSearchBtn().click();

	}

	@Test(priority = 11)
	public void TS011_VerifyClickOnTotalProductsSeeAllLinkForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T368: The click on 'Total products-See All' functionality for an Exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();

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
		Assert.assertTrue(driver.getTitle().contains("" + exhname + " Products"));

		Assert.assertTrue(driver.getTitle().contains("" + exhname + " Products"));

		// Get the Total Products count on Products page
		String producttabtitle = atlexhact.getValidateProductsPage().getText();
		String totalprodcountonprodpage = producttabtitle.replaceAll("[^0-9]", "");
		System.out.println("Total Products Count on Products page is: " + totalprodcountonprodpage);

		// Verify Total Products count on Search grid should match with Products page
		Assert.assertEquals(totalprodcountonsearchgrid, totalprodcountonprodpage);
		atlgs.getATLClearSearchBtn().click();
	}

	@Test(priority = 12)
	public void TS012_VerifyClickOnMatchingProductsSeeAllLinkForExhibitorTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T327: The click on 'Matching products-See All' functionality for an Exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();

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
		Thread.sleep(6000);
		Assert.assertTrue(driver.getTitle().contains("" + exhname + " Products"));

		// Get the Matching Products count on Products page
		String producttabtitle = atlexhact.getValidateProductsPage().getText();
		String matchingprodcountonprodpage = producttabtitle.replaceAll("[^0-9]", "");
		System.out.println("Matching Products Count on Products page is: " + matchingprodcountonprodpage);

		// Verify Matching Products count on Search grid should match with Products page
		Assert.assertEquals(matchingprodcountonsearchgrid, matchingprodcountonprodpage);
		atlgs.getATLClearSearchBtn().click();
	}

	@Test(priority = 13)
	public void TS013_VerifyMatchingProductsAddNoteFunctionalityForExhibitorTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T322: The click on 'Matching products-Add Note' functionality for an
		// Exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();

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
		Thread.sleep(5000);

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

		// Verify that recently added note should be appear on 'All Notes For Exhibitor'
		// modal

		for (int i = 0; i < allnoteslist.size(); i++) {
			// System.out.println(allnoteslist.get(i).getText());
			if (allnoteslist.get(i).getText().equals(newnotetitle)) {
				allnoteslist.get(i).click();
				break;
			}
		}

		// Delete the saved note
		atlexhact.getDeleteNoteBtn().click();

		// Delete the saved note
		atlexhact.getDeleteNoteBtn().click();
		atlgs.getATLClearSearchBtn().click();
	}

	@Test(priority = 14)
	public void TS014_VerifySelectionOfExhibitorFromSearchResultsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T383: The selection of an Exhibitor from Search results grid

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();

		// Store the 1st Exhibitor name in String variable
		exhname = atlexhact.getExhibitorName().getText();

		System.out.println("Exhibitor name: " + exhname);

		// Click on Exhibitor name
		atlexhact.getExhibitorName().click();

		// Verify that Selected Exhibitor Digital Showroom page should be opened

		System.out.println("Exhibitor name: " + exhname);

		// Click on Exhibitor name
		atlexhact.getExhibitorName().click();

		// Verify that Selected Exhibitor Digital Showroom page should be opened

		Assert.assertTrue(atlexhdgshw.getATLValidateExhDigiShowPage().isDisplayed());
		Assert.assertTrue(driver.getTitle().contains("" + exhname + " at Atlanta Market"));
		Assert.assertTrue(atlexhdgshw.getExhibitorNameOnExhDirectImg().getText().contains(exhname));

		atlgs.getATLClearSearchBtn().click();
	}

	@Test(priority = 15)
	public void TS015_VerifyClickOnContactExhIconForLineTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T361: The click on 'Contact Exhibitor' functionality for a Line

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("globalsearchlineinput"));
		atlgs.getATLSearchButton().click();

		// Click on Contact Exhibitor icon
		atlexhact.getContactExhibitorIcon().click();
		Assert.assertTrue(atlexhact.getContactExhibitorModal().isDisplayed());

		// Enter Postal code
		atlexhact.getPostalCodeTxtBx().sendKeys("99950");

		// Enter Message
		atlexhact.getMessageTxtBx().sendKeys("This is a Test Line");

		// Select 1st two Product Category
		atlexhact.getProductCateg1().click();
		atlexhact.getProductCateg2().click();

		utl.scrollToElement(atlexhact.getSendMessageBtn());

		// Click on Send Message button
		// Will send msg once test exhibitor will get
		// atlexhact.getSendMessageBtn().click();

		// Close the pop-up
		atlexhact.getPopUpCloseBtn().click();

		atlgs.getATLClearSearchBtn().click();
	}

	@Test(priority = 16)
	public void TS016_VerifyAddToFavoriteForLineTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T360: The Add to Favorite functionality for a Line

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchlineinput")));
		atlgs.getATLSearchButton().click();

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

		// Verify that the added favorites exhibitor should be displayed in to Favorites
		// list
		Assert.assertTrue(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));

		// Delete that favorites exhibitor from list
		atlmppge.getATLEditListItemMoreBtn().click();
		atlmppge.getATLEditListItemDeleteOptn().click();
		Thread.sleep(6000);

		// Verify that the added favorites exhibitor should be removed from Favorites
		// list
		Assert.assertFalse(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));

		atlgs.getATLClearSearchBtn().click();
	}

	@Test(priority = 17)
	public void TS017_VerifyClickOnOrderOnJuniperMarketBtnForLineTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T376: The click on 'Order On JuniperMarket' button functionality for a Line

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchlineinput")));
		atlgs.getATLSearchButton().click();

		// Store the 1st Exhibitor name in String variable
		String exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Line name: " + exhname);

		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		atlexhact.getOrderOnJuniperMarketBtn().click();

		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		// Verify that 'Juniper Market' page should be displayed
		// driver.getTitle().contains("");
		// Assert.assertTrue(driver.getCurrentUrl().contains("https://dev.junipermarket.com/brands/3594/IPG"));
		// Assert.assertTrue(driver.getTitle().contains("Title"));
		// Close the new window, if that window no more required
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

		atlgs.getATLClearSearchBtn().click();
	}

	@Test(priority = 18)
	public void TS018_VerifyAddToNewListForLineTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T423: The Add to Newly created list functionality for Line

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchlineinput")));
		atlgs.getATLSearchButton().click();
		atlexhact.getseealllink().click();

		// Store the 1st Exhibitor name in String variable
		String exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		// Click on Add to List button for 1st Exhibitor
		atlexhact.getSearchResultMoreicon().click();
		atlexhact.getAddToListOptn().click();
		utl.scrollToElement(atlmppge.getCreateNewListNameTxtbx());

		// Enter new list name
		String newlistname = "Cyb" + genData.generateRandomString(5);
		atlmppge.getCreateNewListNameTxtbx().sendKeys(newlistname);
		System.out.println("Newly created list is: " + newlistname);

		// Scroll till Create button
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				atlmppge.getNewListModalCreateBtn());

		// Click on Create button
		atlexhact.getcreatelistbtn().click();
		// Click on Go to Market Planner button
		atlmppge.getGoToMarketPlannerBtn().click();

		// Click on Lists tab on MP home page
		atlmppge.getMPHomeListsTab().click();
		atlmppge.getListsPageListsMenu().click();

		mplists = atlmppge.getATLMPListsNames();
		mpeditlistoptns = atlmppge.getATLMPEditListOptns();

		for (int i = 0; i < mplists.size(); i++) {
			System.out.println(mplists.get(i).getText());
			// System.out.println(mpeditlistoptns.get(i).getText());
			if (mplists.get(i).getText().equals(newlistname)) {
				mpeditlistoptns.get(i).click();
				break;
			}
		}
		Assert.assertTrue(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));
		atlgs.getATLClearSearchBtn().click();
	}

	@Test(priority = 19)
	public void TS019_VerifyAddToExistingListForLineTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T362: The Add to Newly created list functionality for a Line

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchlineinput")));
		atlgs.getATLSearchButton().click();
		atlexhact.getseealllink().click();

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
			System.out.println(mplists.get(i).getText());
			// System.out.println(mpeditlistoptns.get(i).getText());
			if (mplists.get(i).getText().equals(existinglistname)) {
				mpeditlistoptns.get(i).click();
				break;
			}
		}
		Thread.sleep(5000);
		Assert.assertTrue(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));

		// Delete that added line from list
		atlmppge.getATLEditListItemMoreBtn().click();
		atlmppge.getATLEditListItemDeleteOptn().click();
		Thread.sleep(8000);

		atlgs.getATLClearSearchBtn().click();
	}

	@Test(priority = 20)
	public void TS020_VerifyLinesActionsShownByExhibitorNameLinkTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T433: The Lines actions: Shown By <ExhibitorName> link

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		utl = new Utility(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinputLine")));
		atlgs.getATLSearchButton().click();

		// Store the 1st Exhibitor name in String variable
		String exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Line name: " + exhname);
		// Click on ExhibitorName
		atlexhact.getExhibitorNameLink().click();
		// Verify DG showroom page
		Assert.assertTrue(atlexhdgshw.getATLValidateExhDigiShowPage().isDisplayed());

	}

	@Test(priority = 21)
	public void TS021_VerifyLinesActionsLocationLinksTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T370: Lines Actions: Location links

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		utl = new Utility(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinputLine")));
		atlgs.getATLSearchButton().click();

		// Store the 1st Exhibitor name in String variable
		String exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Line name: " + exhname);
		String locationLink = atlexhact.getLineLocationLink().getAttribute("href");
		// Click on Location Icon
		atlexhact.getLineLocationLink().click();
		// Verify Location page
		Assert.assertTrue(locationLink.equals(driver.getCurrentUrl()));

	}

	@Test(priority = 22)
	public void TS022_VerifyLinesActionsMatchingProductsSeeAllTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T371: Lines Actions: Matching Products- See All

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		utl = new Utility(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinputLine")));
		atlgs.getATLSearchButton().click();

		// Store the 1st Exhibitor name in String variable
		String exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Line name: " + exhname);

		// Get the Matching Products count on Search grid
		String temp = atlexhact.getMatchingProdCountOnSearchGrid().getText();
		String matchingprodcountonsearchgrid = temp.replaceAll("[^0-9]", "");
		System.out.println("Matching Products Count on Search Results grid is: " + matchingprodcountonsearchgrid);
		// Click on See All link
		atlexhact.getMatchingProdSeeAllLink().click();
		// Verify that user should redirect to the Matching Products page
		Assert.assertTrue(atlexhact.getValidateProductsPage().isDisplayed());
		Thread.sleep(15000);
		Assert.assertTrue(driver.getTitle().contains("Products"));
		// Get the Matching Products count on Products page
		String producttabtitle = atlexhact.getValidateProductsPage().getText();
		String matchingprodcountonprodpage = producttabtitle.replaceAll("[^0-9]", "");
		System.out.println("Matching Products Count on Products page is: " + matchingprodcountonprodpage);

		// Verify Matching Products count on Search grid should match with Products page
		Assert.assertEquals(matchingprodcountonsearchgrid, matchingprodcountonprodpage);

	}

	@Test(priority = 23)
	public void TS023_VerifyLinesActionsTotalProductsSeeAllTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T369: Lines actions: Total Products- See all

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		utl = new Utility(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinputLine")));
		atlgs.getATLSearchButton().click();

		// Store the 1st Exhibitor name in String variable
		String exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Line name: " + exhname);

		// Get the Matching Products count on Search grid
		String temp = atlexhact.getMatchingProdCountOnSearchGrid().getText();
		String matchingprodcountonsearchgrid = temp.replaceAll("[^0-9]", "");
		System.out.println("Matching Products Count on Search Results grid is: " + matchingprodcountonsearchgrid);
		// Click on Total Product See All link
		atlexhact.getTotalProdSeeAllLink().click();
		// Verify that user should redirect to the Matching Products page
		Assert.assertTrue(atlexhact.getValidateProductsPage().isDisplayed());
		Thread.sleep(15000);
		Assert.assertTrue(driver.getTitle().contains("Products"));
		// Get the Matching Products count on Products page
		String producttabtitle = atlexhact.getValidateProductsPage().getText();
		String matchingprodcountonprodpage = producttabtitle.replaceAll("[^0-9]", "");
		System.out.println("Matching Products Count on Products page is: " + matchingprodcountonprodpage);

		// Verify Matching Products count on Search grid should match with Products page
		Assert.assertEquals(matchingprodcountonsearchgrid, matchingprodcountonprodpage);

	}

	@Test(priority = 24)
	public void TS024_VerifyProductsActionsSeeDetailsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T379: Products Actions: See Details

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		utl = new Utility(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys("   ");
		atlgs.getATLSearchButton().click();

		// Store the 1st Exhibitor name in String variable
		String exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);
		// Instantiating Actions class
		Actions actions = new Actions(driver);
		String productName = atlexhact.getExhibitorProdcutName().getText();
		System.out.println(productName);
		// Hovering on Product
		actions.moveToElement(atlexhact.getExhibitorProduct()).perform();
		// To mouseover on See All btn
		actions.moveToElement(atlexhact.getSeeDetailsbtn());
		// build()- used to compile all the actions into a single step
		actions.click().perform();
		Thread.sleep(5000);
		String productDetailsPage = atlexhact.getExhibitorProdcutNameDetails().getText();
		System.out.println(productDetailsPage);
		// Verify deatils page
		Assert.assertTrue(productName.equals(productDetailsPage));

	}

	@Test(priority = 25)
	public void TS025_VerifyProductsActionsProductDetailsIcoToAddToNewlyCreatedListTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T379: Products Actions: See Details

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		utl = new Utility(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys("   ");
		atlgs.getATLSearchButton().click();

		// Instantiating Actions class
		Actions actions = new Actions(driver);
		String productName = atlexhact.getExhibitorProdcutName().getText();
		System.out.println(productName);
		// Hovering on Product
		actions.moveToElement(atlexhact.getExhibitorProduct()).perform();
		// To mouseover on See All btn
		actions.moveToElement(atlexhact.getSeeDetailsbtn());
		// build()- used to compile all the actions into a single step
		actions.click().perform();
		Thread.sleep(5000);

		atlexhact.getAddToList().click();
		// String listName= (prop.getProperty("listName"));
		String listName = prop.getProperty("listName");
		// Enter new List Name
		atlexhact.getListName().sendKeys(listName);
		atlexhact.getcreatelistbtn().click(); // Click on Create List button
		atlexhact.getGoToMPBtn().click(); // Click on MP button
		atlexhact.getList().click(); // click on List
		atlexhact.getListLeftPanel().click(); // click on liist from left panel
		// utl.scrollToElement(atlexhact.getnewListName()); // scroll down to list

		List<WebElement> ListNames = driver.findElements(By.xpath("//div[@class='imc-market-planner-list_row_title']"));

		for (WebElement ListName : ListNames) {

			String Name = ListName.getText();
			System.out.println("All Present List : " + Name);
			if (Name.contains(listName)) {

				System.out.println(Name + " = " + listName);
				break;

			}
			// Assert.assertTrue(Name.contains(listName), "Pass");
		}

	}

	@Test(priority = 26)
	public void TS026_VerifyProductsActionsProductDetaileIconToAddToExistingListTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T384: Products Actions: Product Details: + icon to add to existing list

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		utl = new Utility(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys("   ");
		atlgs.getATLSearchButton().click();
		System.out.println();
		// Instantiating Actions class
		Actions actions = new Actions(driver);
		String productName = atlexhact.getExhibitorProdcutName().getText();
		System.out.println(productName);
		// Hovering on Product
		actions.moveToElement(atlexhact.getExhibitorProduct()).perform();
		// To mouseover on See All btn
		actions.moveToElement(atlexhact.getSeeDetailsbtn());
		// build()- used to compile all the actions into a single step
		actions.click().perform();
		Thread.sleep(5000);
		// utl.mouseHover(atlexhact.getExhibitorProdcutName(), atlexhact.getSeeDetailsbtn());
		atlexhact.getAddToList().click();// click on Add to List icon
		
		List<WebElement> allCheckBoxes = driver.findElements(By.xpath("//label[@class='imc-checkbox--label ']"));
		
		String  selectCheckbox= prop.getProperty("listCheckbox");
		
		for (WebElement checkBox : allCheckBoxes) {
			
			String checkboxName = checkBox.getText();
			
			if (checkboxName.contains(selectCheckbox)) {
				checkBox.click();
			}
		}
		atlexhact.getAddToSelectedBtn().click();
		atlexhact.getGoToMPBtn().click(); // Click on MP button
		atlexhact.getList().click(); // click on List
		atlexhact.getListLeftPanel().click(); // click on liist from left panel
		
		List<WebElement> ListNames = driver.findElements(By.xpath("//div[@class='imc-market-planner-list_row_title']"));
		
		try {
			for (WebElement ListName : ListNames) {
				String Name = ListName.getText();
				
				if (Name.contains(selectCheckbox)) {
					
					String locator = String.format("//div[text()='%s']/following-sibling::div/span[2]/a[1]", Name);
					WebElement editBtn = driver.findElement(By.xpath(locator));
					utl.scrollToElement(editBtn);
					editBtn.click();
					String exListName = atlexhact.getProductNameFromList().getText();
					
				}
			}
			Assert.assertTrue(atlexhact.getExhibitorProdcutName().getText()
					.contains(atlexhact.getProductNameFromList().getText()), "Pass");
		} catch (Exception e) {

		}
	}

}
