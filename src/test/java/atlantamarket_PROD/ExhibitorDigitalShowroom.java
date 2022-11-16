package atlantamarket_PROD;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.AtlantaMarket.ATLExhDigiShowroomPage;
import pageObjects.AtlantaMarket.ATLExhLineProdActionsPage;
import pageObjects.AtlantaMarket.ATLGlobalSearchPage;
import pageObjects.AtlantaMarket.ATLLandingPage;
import pageObjects.AtlantaMarket.ATLLeftPaneFilters;
import pageObjects.AtlantaMarket.ATLLoginPage;
import pageObjects.AtlantaMarket.ATLMarketPlannerPage;
import pageObjects.AtlantaMarket.ATLProductDetailsPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

@Listeners({ TestListeners.class })
public class ExhibitorDigitalShowroom extends base {

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
	ATLLeftPaneFilters atlleftpane;

	List<WebElement> exhlist, linelist, prodlist, searchexhtypelist, searchproducttypelist, mplists, mpeditlistoptns,
	allnoteslist, favlist, searchlinetypelist, tagBlogPost, taglist, infoFilterList,favexhlist;

	@BeforeClass
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		// chromeVersion();
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);

		// Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("atlmrkturl_prod"));
		Thread.sleep(3000);
		lap.getIUnderstandBtn().click();
		Thread.sleep(3000);

		utl.verifyMPLoginFunctionality();
		Thread.sleep(5000);
		//lap.getIUnderstandBtn().click();
		//utl.CloseATLPopup();
	}
	
	@Test(priority = 1)
	public void TS001_VerifyAddToFavoritesTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T294: Add To Favorites

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		lap = new ATLLandingPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Search Exhibitor in global search option
		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("exhibitor1"));
		atlgs.getATLSearchButton().click();

		// Store the 1st Exhibitor name in String variable
		String exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		// Click on Exhibitor name and login to market planner
		atlexhdgshw.getSearchedExhibitor().click();
		//		utl.verifyMPLoginFunctionality();
		//		lap.getCloseMarktAdBtn().click();

		//Click Market Planner's Name and go to favorites under Lists tab and verify results
		//		lap.getMPLinkText().click();
		//		atlmppge.getMPHomeListsTab().click();
		//		//atlmppge.getATLMPListsPageFavoritesMenu().click();
		//		utl.scrollToElement(atlmppge.getmplistsenentsandseminars());
		//		Thread.sleep(5000);
		//		Assert.assertTrue(atlexhdgshw.getVerifyExhibitorInFavoritesLists().getText().contains("exhibitor1"));
		//		System.out.println("Exhibitor is properly displayed at Favorites tab.");


		atlexhdgshw.getFavoriteIcon().click();

		// Click on Market Planner link
		lap.getMPLinkText().click();

		// Click on Lists tab on MP home page
		atlmppge.getMPHomeListsTab().click();
		atlmppge.getATLMPListsPageFavoritesMenu().click();
		Thread.sleep(4000);
		
		// Verify that the added favorites exhibitor should be displayed in to Favorites list
		//Assert.assertTrue(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));

		favexhlist = atlmppge.getFavoriteExhibitorNames();

		for (int i = 0; i < favexhlist.size(); i++) {
			//System.out.println(favexhlist.get(i).getText());
			if (favexhlist.get(i).getText().equals(exhname)) {
				utl.scrollToElement(favexhlist.get(i));
				break;
			}
		}
		
		
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
	public void TS002_VerifyAddToExistingListWithPlusIconTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T297: The Add to existing list functionality for an Exhibitor using Plus icon

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("exhibitor1")));
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		String exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		// Click Exhibitor Name and click Plus icon
		atlexhdgshw.getExhibitorName().click();
		atlexhdgshw.getListButtonPlusIcon().click();
		
		/*//Login to Market Planner
		lp.getEmailAddress().sendKeys((prop.getProperty("username")));
		lp.getPassword().sendKeys((prop.getProperty("password")));
		lp.getSignInBtn().click();*/
		
		// Select Existing list name
		atlmppge.getATLMPExistingListName().click();
		
		// Store the existing list name
		String existinglistname = atlmppge.getATLMPExistingListName().getText();
		System.out.println("Existing list name: " + existinglistname);

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
	
	@Test(priority = 3)
	public void TS003_VerifyAddNoteListWithPlusIconTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T300: Add Note for an exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		lp = new ATLLoginPage(driver);
		genData = new GenerateData();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(10000);
		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("exhibitor1")));
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		
		// Click Exhibitor Name and click Plus icon
		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(10000);
		atlexhdgshw.getNoteOptn().click();
		
		// Add Note and verify Functionality for X (Close button)
		atlexhdgshw.getNoteCloseBtn().click();
		Assert.assertTrue(atlexhdgshw.getATLExhDigiShowPage().isDisplayed());
		System.out.println("Close button at Note form works properly.");
		
		
		// Verify save note option works properly
		atlexhdgshw.getNoteOptn().click();
		Thread.sleep(3000);
		atlexhact.getNoteTitleTxtBx().sendKeys(genData.generateRandomString(6));
		Thread.sleep(3000);
		// Enter Note Content
		atlexhact.getNoteContentTxtBx().sendKeys("TestNote" + genData.generateRandomString(15));
		Thread.sleep(3000);
		String NoteTitle = atlexhact.getNoteTitleTxtBx().getText();
		// Click on 'Save' button
		atlexhact.getNoteSaveBtn().click();
		Thread.sleep(10000);
		atlexhdgshw.getNoteOptn().click();
		Thread.sleep(3000);
		atlexhdgshw.getViewAllNotes().click();
		Assert.assertTrue(atlexhdgshw.getVerifyAddedNote().getText().contains(NoteTitle));
		System.out.println("Note is added successfully.");
		
	}
	
	@Test(priority = 4)
	public void TS004_VerifyClickOnLocationLinksForExhibitorDigitalShowroomTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T301: The click on 'Location Links' functionality for an Exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("atlmrkturl_prod"));
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		// Click on any of the Location link present in Exhibitor card and verify result
		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(5000);
		String locationlink = atlexhdgshw.getLocation().getAttribute("href");
		atlexhdgshw.getLocation().click();
		Thread.sleep(10000);
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Assert.assertTrue(locationlink.equals(driver.getCurrentUrl()));
		System.out.println("Locations page is displayed properly.");
		driver.close();
		driver.switchTo().window(winHandleBefore);

		
	}
	
	@Test(priority = 5)
	public void TS005_VerifyClickOnContactExhIconForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T302: The click on 'Contact Exhibitor' functionality for an Exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		genData = new GenerateData();
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("exhibitor1"));
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		// Click on any of the Location link present in Exhibitor card and verify result
		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(5000);
		atlexhdgshw.getContactExhibitor().click();

		// Enter Postal code
		atlexhact.getPostalCodeTxtBx().sendKeys(genData.generateRandomNumber(5));

		// Enter Message
		atlexhact.getMessageTxtBx().sendKeys(genData.generateRandomString(15));
		

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
	
	@Test(priority = 6)
	public void TS006_VerifyClickOnTotalProductsSeeAllLinkForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T368: The click on 'Total products-See All' functionality for an Exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		// Get the Total Products count on Search grid
		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(5000);
		utl.scrollToElement(atlexhdgshw.getProductSection());
		String temp = atlexhdgshw.getProductSection().getText();
		String totalprodcountonsearchgrid = temp.replaceAll("[^0-9]", "");
		System.out.println("Total Products Count on Search Results grid is: " + totalprodcountonsearchgrid);
		Assert.assertTrue(atlexhdgshw.getAllProductsButton().getText().contains(totalprodcountonsearchgrid));
		System.out.println("Total Products count is same at Products section title and See All button.");

		// Click on Total Products-See All link for 1st Exhibitor
		atlexhdgshw.getAllProductsButton().click();
		Thread.sleep(6000);

		// Verify that user should redirect to the Products page
		Assert.assertTrue(atlexhact.getValidateProductsPage().isDisplayed());
		System.out.println("All Products page is displayed properly.");
		Thread.sleep(6000);

		Assert.assertTrue(driver.getTitle().contains(""+exhname+" Products"));

		// Get the Total Products count on Products page
		String producttabtitle = atlexhact.getValidateProductsPage().getText();
		String totalprodcountonprodpage = producttabtitle.replaceAll("[^0-9]", "");
		System.out.println("Total Products Count on Products page is: " + totalprodcountonprodpage);

		//Get back to Exhibitor Showroom page and click any one product and verify if product details are displayed properly
		atlexhdgshw.getProductsPageBackButton().click();
		utl.scrollToElement(atlexhdgshw.getProductSection());
		atlexhdgshw.getProductsList().click();
		utl.scrollToElement(atlexhdgshw.getProductsDescription());
		Assert.assertTrue(atlexhdgshw.getProductsDescription().getText().contains("Product Description"));
		System.out.println("Product Details are displayed properly.");
		
	}
	
}

