package lasvegasmarket_UAT;

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
public class GlobalSearch_LineActions extends base {

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
		driver.get(prop.getProperty("atlmrkturl_uat"));
		lap.getIUnderstandBtn().click();
		Thread.sleep(7000);
		//lap.getCloseMarktAdBtn().click();
		
		//Login to Market Planner
		utl.verifyMPLoginFunctionality();
		driver.navigate().refresh();
		Thread.sleep(8000);
		
//		Thread.sleep(6000);
//		lap.getCloseMarktAdBtn().click();
	}

	@Test(priority = 1)
	public void TS001_VerifyClickOnContactExhIconForLineTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T361: The click on 'Contact Exhibitor' functionality for a Line

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();
		Thread.sleep(15000);
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
	}

	@Test(priority = 2)
	public void TS002_VerifyAddToFavoriteForLineTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T360: The Add to Favorite functionality for a Line

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		lap = new ATLLandingPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("atlmrkturl_uat"));
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchlineinput")));
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
		atlmppge.getATLEditListItemMoreBtn().click();
		atlmppge.getATLEditListItemDeleteOptn().click();
		Thread.sleep(6000);

		// Verify that the added favorites exhibitor should be removed from Favorites list
		Assert.assertFalse(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));
	}

	@Test(priority = 3)
	public void TS003_VerifyClickOnOrderOnJuniperMarketBtnForLineTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T376: The click on 'Order On JuniperMarket' button functionality for a Line

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		lap = new ATLLandingPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("atlmrkturl_uat"));
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchlineinput")));
		atlgs.getATLSearchButton().click();
		Thread.sleep(15000);
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

		Thread.sleep(7000);
		// Verify that 'Juniper Market' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("junipermarket.com"));

		// Close the new window, if that window no more required
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
	}

	@Test(priority = 4)
	public void TS004_VerifyAddToNewListForLineTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T423: The Add to Newly created list functionality for Line

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();
		lap = new ATLLandingPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(prop.getProperty("atlmrkturl_uat"));
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();
		
		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchlineinput")));
		atlgs.getATLSearchButton().click();
		Thread.sleep(15000);
		atlexhact.getseealllink().click();

		// Store the 1st Exhibitor name in String variable
		String exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		// Click on Add to List button for 1st Exhibitor
		atlexhact.getSearchResultMoreicon().click();
		atlexhact.getAddToListOptn().click();
		utl.scrollToElement(atlmppge.getCreateNewListNameTxtbx());

		//Enter new list name
		String newlistname = "Cyb"+ genData.generateRandomString(5);
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
			//System.out.println(mplists.get(i).getText());
			// System.out.println(mpeditlistoptns.get(i).getText());
			if (mplists.get(i).getText().equals(newlistname)) {
				mpeditlistoptns.get(i).click();
				break;
			}
		}
		Assert.assertTrue(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));
	}

	@Test(priority = 5)
	public void TS005_VerifyAddToExistingListForLineTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T362: The Add to Newly created list functionality for a Line

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		lap = new ATLLandingPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("atlmrkturl_uat"));
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchlineinput")));
		atlgs.getATLSearchButton().click();
		Thread.sleep(15000);
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
	}

	@Test(priority = 06)
	public void TS006_VerifyClickOnShownByExhibitorNameLinkForLineTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T433: The Lines actions: Shown By <ExhibitorName> link

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		utl = new Utility(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(prop.getProperty("atlmrkturl_uat"));
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();
		
		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchlineinput")));
		atlgs.getATLSearchButton().click();
		Thread.sleep(15000);
		
		// Store the 1st Exhibitor name in String variable
		String exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Line name: " + exhname);
		// Click on ExhibitorName
		atlexhact.getExhibitorNameLink().click();
		// Verify DG showroom page
		Assert.assertTrue(atlexhdgshw.getATLValidateExhDigiShowPage().isDisplayed());
	}

	@Test(priority = 7)
	public void TS007_VerifyClickOnLocationLinkForLineTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T370: Lines Actions: Location links

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		utl = new Utility(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("atlmrkturl_uat"));
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchlineinput")));
		atlgs.getATLSearchButton().click();
		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		String exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Line name: " + exhname);
		String locationLink = atlexhact.getLineLocationLink().getAttribute("href");
		// Click on Location Icon
		atlexhact.getLineLocationLink().click();
		// Verify Location page
		Assert.assertTrue(locationLink.equals(driver.getCurrentUrl()));
	}

	@Test(priority = 8)
	public void TS008_VerifyClickOnMatchingProductsSeeAllLinkForLineTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T371: Lines Actions: Matching Products- See All

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		utl = new Utility(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("atlmrkturl_uat"));
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchlineinput")));
		atlgs.getATLSearchButton().click();
		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		String linename = atlexhact.getExhibitorName().getText();
		System.out.println("Line name: " +linename);

		// Get the Matching Products count on Search grid
		String temp = atlexhact.getMatchingProdCountOnSearchGrid().getText();
		String matchingprodcountonsearchgrid = temp.replaceAll("[^0-9]", "");
		System.out.println("Matching Products Count on Search Results grid is: " + matchingprodcountonsearchgrid);

		// Click on See All link
		atlexhact.getMatchingProdSeeAllLink().click();
		Thread.sleep(15000);

		// Verify that user should redirect to the Matching Products page
		Assert.assertTrue(atlexhact.getValidateProductsPage().isDisplayed());
		Assert.assertTrue(driver.getTitle().contains("Products by "+linename+""));

		// Get the Matching Products count on Products page
		String producttabtitle = atlexhact.getValidateProductsPage().getText();
		String matchingprodcountonprodpage = producttabtitle.replaceAll("[^0-9]", "");
		System.out.println("Matching Products Count on Products page is: " + matchingprodcountonprodpage);

		// Verify Matching Products count on Search grid should match with Products page
		Assert.assertEquals(matchingprodcountonsearchgrid, matchingprodcountonprodpage);
	}

	@Test(priority = 9)
	public void TS009_VerifyClickOnTotalProductsSeeAllLinkForLineTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T369: Lines actions: Total Products- See all

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		utl = new Utility(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("atlmrkturl_uat"));
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchlineinput")));
		atlgs.getATLSearchButton().click();
		Thread.sleep(15000);

		// Store the 1st Line name in String variable
		String linename = atlexhact.getExhibitorName().getText();
		System.out.println("Line name: " +linename);

		// Get the Matching Products count on Search grid
		String temp = atlexhact.getMatchingProdCountOnSearchGrid().getText();
		String matchingprodcountonsearchgrid = temp.replaceAll("[^0-9]", "");
		System.out.println("Total Products Count on Search Results grid is: " + matchingprodcountonsearchgrid);

		// Click on Total Product See All link
		atlexhact.getTotalProdSeeAllLink().click();

		Thread.sleep(15000);
		// Verify that user should redirect to the Matching Products page
		Assert.assertTrue(atlexhact.getValidateProductsPage().isDisplayed());
		Assert.assertTrue(driver.getTitle().contains("Products by "+linename+""));

		// Get the Matching Products count on Products page
		String producttabtitle = atlexhact.getValidateProductsPage().getText();
		String matchingprodcountonprodpage = producttabtitle.replaceAll("[^0-9]", "");
		System.out.println("Total Products Count on Products page is: " + matchingprodcountonprodpage);

		// Verify Total Products count on Search grid should match with Products page
		Assert.assertEquals(matchingprodcountonsearchgrid, matchingprodcountonprodpage);
		
		driver.get(prop.getProperty("atlmrkturl_uat"));
		//lap.getCloseMarktAdBtn().click();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
