package lasvegasmarket_PROD;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
import pageObjects.AtlantaMarket.ATLLoginPage;
import pageObjects.AtlantaMarket.ATLMarketPlannerPage;
import pageObjects.AtlantaMarket.ATLProductDetailsPage;
import pageObjects.LasVegasMarket.LVMGlobalSearchPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

@Listeners({ TestListeners.class })
public class GlobalSearch_ProductActions extends base {

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
	LVMGlobalSearchPage lvmgs;

	List<WebElement> exhlist, linelist, prodlist, searchexhtypelist, searchproducttypelist, mplists, mpeditlistoptns,
	allnoteslist, favlist, searchlinetypelist;

	@BeforeClass(alwaysRun=true)
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);

		// Navigate to Atlanta Market site
		//driver.manage().window().maximize();
		driver.get(prop.getProperty("lvmurl_prod"));
		try {
			lap.getIUnderstandBtn().click();
			}catch (Exception e) {
				// TODO: handle exception
			}
		Thread.sleep(7000);
		//lap.getCloseMarktAdBtn().click();
		//Login to Market Planner
		//utl.verifyMPLoginFunctionality();		
		/*driver.navigate().refresh();
		Thread.sleep(8000);
		utl.loginCheckLVM();*/
		//lap.getCloseMarktAdBtn().click();
	}

	@Test(priority = 1)
	public void TS001_VerifyClickOnProductSeeDetailsBtnOnSearchResultsGridTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T379: See Details functionality on Search Results grid

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlproddet = new ATLProductDetailsPage(driver);
		lap = new ATLLandingPage(driver);
		lvmgs = new LVMGlobalSearchPage(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);
		
		//Global Search input
		utl.globleSearchInput((prop.getProperty("globalsearch_input")));
		Thread.sleep(10000);
		// Store the 1st Product name of Exhibitor
		//String productNameOnSearchGrid = atlexhact.getExhProductNameOnSearchGrid().getText(); //Old
		String productNameOnSearchGrid = atlexhact.getlvmProductLinkForExh().getText(); //New
		System.out.println("Selected Product Name: " + productNameOnSearchGrid);
		Actions as= new Actions(driver);
		as.moveToElement(atlexhact.getlvmProductLinkForExh()).click().perform();
		
		

		// Store the Product Name on Product Details page
		String productNameOnProductDetails = atlproddet.getProductNameOnProductDetails().getText();
		System.out.println("Product Name On Product Details page: " + productNameOnProductDetails);
		// Verify that selected Product details page should be opened
		Assert.assertTrue(productNameOnSearchGrid.contains(productNameOnProductDetails));
		driver.get(prop.getProperty("lvmurl_prod"));
	}

	   @Test(priority = 2)
	    public void TS002_VerifyFullScreenViewerOnProductDetailsPageTest() throws InterruptedException, IOException {
	        // The purpose of this test case to verify:-
	        // T387: Full Screen Viewer functionality on Product Details page

	        atlgs = new ATLGlobalSearchPage(driver);
	        atlexhact = new ATLExhLineProdActionsPage(driver);
	        lap = new ATLLandingPage(driver);
	        atlmppge = new ATLMarketPlannerPage(driver);
	        utl = new Utility(driver);
	        atlexhdgshw = new ATLExhDigiShowroomPage(driver);
	        atlproddet = new ATLProductDetailsPage(driver);
	        lvmgs = new LVMGlobalSearchPage(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Thread.sleep(5000);
			
			utl.globleSearchInput((prop.getProperty("globalsearch_input")));
			Thread.sleep(15000);
			// Store the 1st Product name of Exhibitor
			
			String productNameOnSearchGrid = atlexhact.getlvmProductLinkForExh().getText(); //New
			System.out.println("Selected Product Name: " + productNameOnSearchGrid);
			
			
			Actions action=new Actions(driver);
			action.moveToElement(atlexhact.getlvmProductLinkForExh()).click().perform();
			
	        //Click on Product Full Screen Viewer button
	       utl.scrollElementIntoMiddle(atlproddet.getProductFullScreenViewerBtn());
	       Thread.sleep(200);
	        atlproddet.getProductFullScreenViewerBtn().click();

	        //Verify that Full Screen viewer should be displayed with Product images
	        Assert.assertTrue(atlproddet.getProductFullScreenViewer().isDisplayed());
	        Thread.sleep(5000);

	        //Verify the title of the Full screen viewer
	        System.out.println(atlproddet.getProductFullScreenViewerTitle().getText());
	        Assert.assertTrue(atlproddet.getProductFullScreenViewerTitle().getText().contains(productNameOnSearchGrid));

	        //Dismiss the Full Screen Viewer
	        atlproddet.getProductFullScreenViewer().click();
	        driver.get(prop.getProperty("lvmurl_prod"));
	    }
	
	//@Test(priority = 3)
	public void TS003_VerifyProductAddToNewListOnProductDetailsPageTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T435: Add to Newly created list functionality on Product details page

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlproddet = new ATLProductDetailsPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		lap = new ATLLandingPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get(prop.getProperty("lvmurl_prod"));
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();

		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("globalsearchinput"));
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		// Store the 1st Product name of Exhibitor
		//String productNameOnSearchGrid = atlexhact.getExhProductNameOnSearchGrid().getText(); //Old
		String productNameOnSearchGrid = atlexhact.getprodNameUAT().getText(); //New
		System.out.println("Selected Product Name: " + productNameOnSearchGrid);

		utl.scrollToElement(atlexhact.getExhibitorProduct());

		// Hover on Product
		Actions actions = new Actions(driver);
		actions.moveToElement(atlexhact.getExhibitorProduct()).perform();
		// To mouseover on See All btn
		actions.moveToElement(atlexhact.getProdSeeDetailsBtn()).perform();

		// Click On See Details button
		actions.click().perform();
		Thread.sleep(5000);

		// Click on Add to List button
		atlproddet.getAddToList().click();

		utl.scrollToElement(atlmppge.getCreateNewListNameTxtbx());

		// Enter new list name
		String newlistname = "CybProduct" + genData.generateRandomString(3);
		atlmppge.getCreateNewListNameTxtbx().sendKeys(newlistname);
		System.out.println("Newly created list is: " + newlistname);

		// Scroll till Create button
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				atlmppge.getNewListModalCreateBtn());

		// Click on Create button
		//atlmppge.getAddListCreateBtn().click(); //Old
		atlmppge.getCreateAddListBtn().click(); //New

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
		Thread.sleep(10000);
		Assert.assertTrue(atlmppge.getSavedProductNameInList().getText().contains(productNameOnSearchGrid));
		driver.get(prop.getProperty("lvmurl_prod"));
	}

	//@Test(priority = 4)
	public void TS004_VerifyProductAddToExistingListOnProductDetailsPageTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T384: Add to existing list functionality on Product details page

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		utl = new Utility(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlproddet = new ATLProductDetailsPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get(prop.getProperty("lvmurl_prod"));
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();

		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("globalsearchinput"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(15000);

		// Store the 1st Product name of Exhibitor
		//String productNameOnSearchGrid = atlexhact.getExhProductNameOnSearchGrid().getText(); //Old
		String productNameOnSearchGrid = atlexhact.getprodNameUAT().getText(); //New
		System.out.println("Selected Product Name: " + productNameOnSearchGrid);

		utl.scrollToElement(atlexhact.getExhibitorProduct());

		// Hovering on Product
		Actions actions = new Actions(driver);
		actions.moveToElement(atlexhact.getExhibitorProduct()).perform();
		// To mouseover on See Details btn
		actions.moveToElement(atlexhact.getProdSeeDetailsBtn()).perform();

		// Click on See Details button
		actions.click().perform();
		Thread.sleep(5000);

		// Click on Add to List button
		atlproddet.getAddToList().click();

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
		System.out.println("Saved Product Name in List:" + atlmppge.getSavedProductNameInList().getText());
		Assert.assertTrue(atlmppge.getSavedProductNameInList().getText().contains(productNameOnSearchGrid));

		// Delete that added Product from list
		utl.scrollToElement(atlmppge.getSavedProductNameInList());
		Thread.sleep(3000);
		atlmppge.getMoreBtnDeleteOptnExistingList_ATLPROD().click();
		Thread.sleep(3000);
		
		atlmppge.getATLEditListItemDeleteOptn().click();
		Thread.sleep(8000);

		favlist = driver.findElements(By.xpath("//li[@class='imc-list-edit--draggable']/div/div/div/a"));

		// Verify that the added Product should be removed from Existing list
		for (int i = 1; i < favlist.size(); i++) {
			// System.out.println(favlist.get(i).getText());
			Assert.assertFalse(favlist.get(i).getText().contains(productNameOnSearchGrid));
		}
		driver.get(prop.getProperty("lvmurl_prod"));
	}

	//@Test(priority = 5)
	public void TS005_VerifyAddToFavoriteOnProductDetailsPageTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T385: Add to Favorite functionality on Product Details page

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		utl = new Utility(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlproddet = new ATLProductDetailsPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get(prop.getProperty("lvmurl_prod"));
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();

		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("exhibitor4"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(15000);
		// Store the 1st Product name of Exhibitor
		String productNameOnSearchGrid = atlexhact.getExhProductNameOnSearchGrid().getText(); //Old
		//String productNameOnSearchGrid = atlexhact.getExhProductNameOnSearchGridNew().getText(); //New
		System.out.println("Selected Product Name: " + productNameOnSearchGrid);
	

		// Hovering on Product
		Actions actions = new Actions(driver);
		actions.moveToElement(atlexhact.getExhibitorProduct()).perform();
		// To mouseover on See Details btn
		actions.moveToElement(atlexhact.getProdSeeDetailsBtn()).perform();

		// Click on See Details button
		actions.click().perform();
		Thread.sleep(5000);

		// Click on 'Favorite' icon
		atlproddet.getProductAddToFavIcon().click();

		// Click on Market Planner link
		lap.getMPLinkText().click();

		// Click on Lists tab on MP home page
		atlmppge.getMPHomeListsTab().click();
		atlmppge.getATLMPListsPageFavoritesMenu().click();
		Thread.sleep(8000);

		// Verify that the added Product should be displayed in to Favorites list
		//Assert.assertTrue(atlmppge.getSavedProductNameInList().getText().contains(productNameOnSearchGrid));
		//utl.checkItemPresentInListorNot(atlmppge.getFavListProducts(), productNameOnSearchGrid);
		/*favlist = atlmppge.getFavExhList();
		for(WebElement nameOfExh : favlist) {
			Assert.assertTrue(nameOfExh.getText().contains(productNameOnSearchGrid));
			break;
		}
		
		// Delete that favorited product from list
		Thread.sleep(3000);
		atlmppge.getMoreBtnDeleteOptnExistingList_ATLPROD().click();
		Thread.sleep(3000);
		atlmppge.getATLEditListItemDeleteOptn().click();
		Thread.sleep(8000);*/
		favlist = atlmppge.getFavExhList();
		for (int i = 0; i < favlist.size(); i++) {
			String exhName = favlist.get(i).getText();
			if(exhName.equals(exhname)) {
				WebElement editOpt = favlist.get(i).findElement(By.xpath("./../../div[4]/div/button"));
				 new Actions(driver).clickAndHold(editOpt).perform();
				favlist.get(i).findElement(By.xpath("./../../div[4]/div/button/./../div/span[3]")).click();
				break;
			}			
		}

		//Verify that the added product should be removed from Favorites list
		for(int i=1; i< favlist.size(); i++)
		{			
			//System.out.println(favlist.get(i).getText());
			Assert.assertFalse(favlist.get(i).getText().contains(productNameOnSearchGrid)); 
		}
		driver.get(prop.getProperty("lvmurl_prod"));
	}

	//@Test(priority = 6)
	public void TS006_VerifyAddNoteOnProductDetailsPageTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T386: Add Note functionality on Product Details page

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlproddet = new ATLProductDetailsPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get(prop.getProperty("lvmurl_prod"));
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();
		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		// Click on Matching Products-See All link for 1st Exhibitor
		// atlexhact.getMatchingProdSeeAllLink().click();

		utl.scrollToElement(atlexhact.getExhibitorProduct());

		// Hovering on Product
		Actions actions = new Actions(driver);
		actions.moveToElement(atlexhact.getExhibitorProduct()).perform();
		// To mouseover on See Details btn
		actions.moveToElement(atlexhact.getProdSeeDetailsBtn()).perform();
		// Click on See Details button
		actions.click().perform();

		atlproddet.getProductAddNoteIcon().click();

		// Store the new note name
		String newnotetitle = "CybNote" + genData.generateRandomString(3);
		System.out.println("Newly added Note is: " + newnotetitle);
		Thread.sleep(2000);
		// Enter Note title
		atlexhact.getNoteTitleTxtBx().sendKeys(newnotetitle);
		// Enter Note Content
		Thread.sleep(2000);
		atlexhact.getNoteContentTxtBx().sendKeys("TestProdNote" + genData.generateRandomString(6));
		// Click on 'Save' button
		Thread.sleep(2000);
		atlexhact.getNoteSaveBtn().click();
		Thread.sleep(8000);
		// Click on 'Add Note' icon for the same exhibitor
		atlproddet.getProductAddNoteIcon().click();
		Thread.sleep(4000);

		// Click on 'View all Notes for an Exhibitor' link on Add Notes pop-up
		atlexhact.getViewAllNotesLink().click();
		Thread.sleep(5000);

		allnoteslist = atlexhact.getSavedNoteNameInAllNotesList();

		// Verify that recently added note should be appear on 'All Notes For Exhibitor' modal
		for (int i = 0; i < allnoteslist.size(); i++) {
			//System.out.println(allnoteslist.get(i).getText());
			if (allnoteslist.get(i).getText().equals(newnotetitle)) {
				allnoteslist.get(i).click();

				break;
			}
		}

		// Delete the saved note
		atlexhact.getDeleteNoteBtn().click();
		driver.get(prop.getProperty("lvmurl_prod"));
	}

	//@Test(priority = 7)
	public void TS007_VerifyProductAddToExistingListOnSearchResultsGridTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T377: Products Actions: + icon to add to existing list

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		utl = new Utility(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlproddet = new ATLProductDetailsPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get(prop.getProperty("lvmurl_prod"));
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();

		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("globalsearchinput"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(15000);
		// Store the 1st Product name of Exhibitor
		//String productNameOnSearchGrid = atlexhact.getExhProductNameOnSearchGrid().getText(); //Old
		String productNameOnSearchGrid = atlexhact.getprodNameUAT().getText(); //New
		System.out.println("Selected Product Name: " + productNameOnSearchGrid);

		// Hovering on Product
		Actions actions = new Actions(driver);
		actions.moveToElement(atlexhact.getExhibitorProduct()).perform();
		// To mouseover on More btn
		actions.moveToElement(atlexhact.getProductMoreBtnOnSearchGrid()).perform();

		//Click on Add To List button
		actions.click().perform();
		atlexhact.getAddToListOptn().click();
		Thread.sleep(5000);

		// Store the existing list name
		String existinglistname = atlmppge.getATLMPExistingListName().getText();
		System.out.println("Existing list name: " + existinglistname);

		// Select Existing list name
		atlmppge.getATLMPExistingListName().click();

		// Scroll till Add to Selected button
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",atlmppge.getATLMPAddToSelectedBtn());
		atlmppge.getATLMPAddToSelectedBtn().click();

		// Click on Go to Market Planner button
		atlmppge.getGoToMarketPlannerBtn().click();

		// Click on Lists tab on MP home page
		atlmppge.getMPHomeListsTab().click();
		//atlmppge.getListsPageListsMenu().click();
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
		Assert.assertTrue(atlmppge.getSavedProductNameInList().getText().contains(productNameOnSearchGrid));
		
		Thread.sleep(10000);

		// Delete that added Product from list
		//atlmppge.getATLEditListItemMoreBtn().click(); //Old
		utl.scrollToElement(atlmppge.getSavedProductNameInList());
		Thread.sleep(3000);
		atlmppge.getMoreBtnDeleteOptnExistingList_ATLPROD().click();
		Thread.sleep(3000);
		atlmppge.getATLEditListItemDeleteOptn().click();
		Thread.sleep(8000);

		favlist = driver.findElements(By.xpath("//li[@class='imc-list-edit--draggable']/div/div/div/a"));

		// Verify that the added Product should be removed from Existing list
		for (int i = 1; i < favlist.size(); i++) {
			// System.out.println(favlist.get(i).getText());
			Assert.assertFalse(favlist.get(i).getText().contains(productNameOnSearchGrid));
		}
		driver.get(prop.getProperty("lvmurl_prod"));
	}
/*
	@Test(priority = 7)
	public void TS007_VerifyFullScreenViewerOnProductDetailsPageTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T387: Full Screen Viewer functionality on Product Details page

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		utl = new Utility(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlproddet = new ATLProductDetailsPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get(prop.getProperty("lvmurl_prod"));
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();

		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("globalsearchinput"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(15000);
		//Store the 1st Product name of Exhibitor
		//String productNameOnSearchGrid = atlexhact.getExhProductNameOnSearchGrid().getText(); //Old
		String productNameOnSearchGrid = atlexhact.getprodNameUAT().getText(); //New
		System.out.println("Selected Product Name: "+productNameOnSearchGrid);

		utl.scrollToElement(atlexhact.getExhibitorProduct());

		// Hovering on Product
		Actions actions = new Actions(driver);
		actions.moveToElement(atlexhact.getExhibitorProduct()).perform();
		// To mouseover on See Details btn
		actions.moveToElement(atlexhact.getProdSeeDetailsBtn()).perform();

		//Click on See Details button
		actions.click().perform();
		Thread.sleep(5000);

		//Click on Product Full Screen Viewer button
		utl.scrollToElement(atlproddet.getProductFullScreenViewerBtn());
		atlproddet.getProductFullScreenViewerBtn().click();

		//Verify that Full Screen viewer should be displayed with Product images
		Assert.assertTrue(atlproddet.getProductFullScreenViewer().isDisplayed());
		Thread.sleep(5000);

		//Verify the title of the Full screen viewer
		System.out.println(atlproddet.getProductFullScreenViewerTitle().getText());
		Assert.assertTrue(atlproddet.getProductFullScreenViewerTitle().getText().equals(productNameOnSearchGrid));

		//Dismiss the Full Screen Viewer
		atlproddet.getProductFullScreenViewer().click();
		driver.get(prop.getProperty("lvmurl_prod"));
	}
*/

	//@Test(priority = 8)
	public void TS008_VerifyAddToFavoriteOnSearchResultsGridTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T378: Add To Favorite functionality for Product on Search Results grid

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlproddet = new ATLProductDetailsPage(driver);
		lap = new ATLLandingPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get(prop.getProperty("lvmurl_prod"));
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();

		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("exhibitor4"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(15000);
		//Store the 1st Product name of Exhibitor
		String productNameOnSearchGrid = atlexhact.getExhProductNameOnSearchGrid().getText(); //Old
		//String productNameOnSearchGrid = atlexhact.getExhProductNameOnSearchGridNew().getText(); //New
		System.out.println("Selected Product Name: "+productNameOnSearchGrid);

		utl.scrollToElement(atlexhact.getExhibitorProduct());

		// Hovering on Product
		Actions actions = new Actions(driver);
		actions.moveToElement(atlexhact.getExhibitorProduct()).perform();
		// To mouseover on Add to Fav btn
		actions.moveToElement(atlexhact.getProductAddToFavBtnOnSearchGrid()).perform();

		//Click on Add To Favorite button
		actions.click().perform();
		Thread.sleep(5000);

		// Click on Market Planner link
		lap.getMPLinkText().click();

		// Click on Lists tab on MP home page
		atlmppge.getMPHomeListsTab().click();
		atlmppge.getATLMPListsPageFavoritesMenu().click();
		Thread.sleep(8000);

		// Verify that the added product should be displayed in to Favorites list
		Assert.assertTrue(atlmppge.getSavedProductNameInList().getText().contains(productNameOnSearchGrid));

		// Delete that favorited product from list
		Thread.sleep(3000);
		atlmppge.getMoreBtnDeleteOptnExistingList_ATLPROD().click();
		Thread.sleep(3000);
		atlmppge.getATLEditListItemDeleteOptn().click();
		Thread.sleep(8000);

		favlist = driver.findElements(By.xpath("//li[@class='imc-list-edit--draggable']/div/div/div/a"));

		//Verify that the added product should be removed from Favorites list
		for(int i=1; i< favlist.size(); i++)
		{			
			//System.out.println(favlist.get(i).getText());
			Assert.assertFalse(favlist.get(i).getText().contains(productNameOnSearchGrid)); 
		}
		driver.get(prop.getProperty("lvmurl_prod"));
	}

	//@Test(priority = 9)
	public void TS009_VerifyProductAddToNewlyCreatedListOnSearchResultsGridTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T435: Add to Newly created list functionality on Product details page

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlproddet = new ATLProductDetailsPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		lap = new ATLLandingPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get(prop.getProperty("lvmurl_prod"));
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();

		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("globalsearchinput"));
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		// Store the 1st Product name of Exhibitor
		//String productNameOnSearchGrid = atlexhact.getExhProductNameOnSearchGrid().getText(); //Old
		String productNameOnSearchGrid = atlexhact.getExhProductNameOnSearchGridNew().getText(); //New
		System.out.println("Selected Product Name: " + productNameOnSearchGrid);

		// Hovering on Product
		Actions actions = new Actions(driver);
		actions.moveToElement(atlexhact.getExhibitorProduct()).perform();
		// To mouseover on More btn
		actions.moveToElement(atlexhact.getProductMoreBtnOnSearchGrid()).perform();

		//Click on Add To List button
		actions.click().perform();
		atlexhact.getAddToListOptn().click();
		Thread.sleep(5000);

		utl.scrollToElement(atlmppge.getCreateNewListNameTxtbx());

		// Enter new list name
		String newlistname = "CybProduct" + genData.generateRandomString(3);
		atlmppge.getCreateNewListNameTxtbx().sendKeys(newlistname);
		System.out.println("Newly created list is: " + newlistname);

		// Scroll till Create button
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				atlmppge.getNewListModalCreateBtn());

		// Click on Create button
		//atlmppge.getNewListModalCreateBtn().click(); //Old
		atlmppge.getCreateAddListBtn().click(); //New
		
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
		Thread.sleep(10000);
		//System.out.println(atlmppge.getNewCreatedListName().getText());
		Assert.assertTrue(atlmppge.getNewCreatedListName().getText().contains(newlistname));
		driver.get(prop.getProperty("lvmurl_prod"));
	}

	@AfterClass
	public void tearDown() {
		//driver.quit();
	}
}
