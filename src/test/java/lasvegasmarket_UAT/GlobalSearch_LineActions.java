package lasvegasmarket_UAT;


import java.io.IOException;
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
import lasvegasmarket_PROD.TestListeners;
import pageObjects.AtlantaMarket.ATLExhDigiShowroomPage;
import pageObjects.AtlantaMarket.ATLExhLineProdActionsPage;
import pageObjects.AtlantaMarket.ATLGlobalSearchPage;
import pageObjects.AtlantaMarket.ATLLandingPage;
import pageObjects.AtlantaMarket.ATLLoginPage;
import pageObjects.AtlantaMarket.ATLMarketPlannerPage;
import pageObjects.AtlantaMarket.ATLProductDetailsPage;
import pageObjects.LasVegasMarket.LVMExhDigiShowroomPage;
import pageObjects.LasVegasMarket.LVMExhLineProdActionsPage;
import pageObjects.LasVegasMarket.LVMGlobalSearchPage;
import pageObjects.LasVegasMarket.LVMLandingPage;
import pageObjects.LasVegasMarket.LVMLoginPage;
import pageObjects.LasVegasMarket.LVMMarketPlannerPage;
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
   
    ATLGlobalSearchPage atlgs;
    ATLExhDigiShowroomPage atlexhdgshw;
    ATLProductDetailsPage atlproddet;
    ATLExhLineProdActionsPage atlexhact;
    ATLMarketPlannerPage atlmppge;
    LVMLandingPage lap;
	LVMGlobalSearchPage lvmgs;
	LVMExhDigiShowroomPage lvmexhdgshw;
	LVMExhLineProdActionsPage lvmexhact;
	LVMMarketPlannerPage lvmmppge;
    List<WebElement> exhlist, linelist, prodlist, searchexhtypelist, searchproducttypelist, mplists, mpeditlistoptns, allnoteslist,favlist, searchlinetypelist;

    @BeforeClass
    public void initialize() throws IOException, InterruptedException {
        driver = initializeDriver(); // requires for Parallel text execution
        utl = new Utility(driver);
        lap = new LVMLandingPage(driver);

        // Navigate to Atlanta Market site
        driver.manage().window().maximize();
        driver.get(prop.getProperty("lvmurl_uat"));
        lap.getIUnderstandBtn().click();
        Thread.sleep(7000);
        //lap.getCloseMarktAdBtn().click();
        
        //Login to Market Planner
        //utl.verifyMPLoginFunctionality();
        //utl.loginCheckLVM();
        //Thread.sleep(8000);
//      lap.getCloseMarktAdBtn().click();
    }

    @Test(priority = 1)
    public void TS001_VerifyClickOnShownByExhibitorNameLinkForLineTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T433: The Lines actions: Shown By <ExhibitorName> link

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		lap = new LVMLandingPage(driver);
		lvmmppge = new LVMMarketPlannerPage(driver);
		utl = new Utility(driver);
		lvmexhdgshw = new LVMExhDigiShowroomPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(prop.getProperty("lvmurl_uat"));;
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();
		
		lvmgs.getLVMGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchlineinput")));
		lvmgs.getLVMSearchButton().click();

		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		String exhname = lvmexhact.getExhibitorName().getText();
		System.out.println("Line name: " + exhname);
		// Click on ExhibitorName
		lvmexhact.getExhibitorNameLink().click();
		// Verify DG showroom page
		Thread.sleep(3000);
		Assert.assertTrue(lvmexhdgshw.getLVMExhDigiShowPage().isDisplayed());
	}

	@Test(priority = 2)
	public void TS002_VerifyClickOnLocationLinkForLineTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T370: Lines Actions: Location links

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		lap = new LVMLandingPage(driver);
		lvmmppge = new LVMMarketPlannerPage(driver);
		utl = new Utility(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("lvmurl_uat"));;
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();

		lvmgs.getLVMGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchlineinput")));
		lvmgs.getLVMSearchButton().click();

		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		String exhname = lvmexhact.getExhibitorName().getText();
		System.out.println("Line name: " + exhname);
		String locationLink = lvmexhact.getLineLocationLink().getAttribute("href");
		// Click on Location Icon
		lvmexhact.getLineLocationLink().click();
		// Verify Location page
		Assert.assertTrue(locationLink.equals(driver.getCurrentUrl()));
	}

	@Test(priority = 3)
	public void TS003_VerifyClickOnMatchingProductsSeeAllLinkForLineTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T371: Lines Actions: Matching Products- See All

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		lap = new LVMLandingPage(driver);
		lvmmppge = new LVMMarketPlannerPage(driver);
		utl = new Utility(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("lvmurl_uat"));;
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();

		lvmgs.getLVMGlobalSearchTextBox().sendKeys("   ");
		lvmgs.getLVMSearchButton().click();

		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		String linename = lvmexhact.getExhibitorName().getText();
		System.out.println("Line name: " +linename);

		// Get the Matching Products count on Search grid
		String temp = lvmexhact.getMatchingProdCountOnSearchGrid().getText();
		String matchingprodcountonsearchgrid = temp.replaceAll("[^0-9]", "");
		System.out.println("Matching Products Count on Search Results grid is: " + matchingprodcountonsearchgrid);

		// Click on See All link
		lvmexhact.getMatchingProdSeeAllLink().click();
		Thread.sleep(15000);

		// Verify that user should redirect to the Matching Products page
		Assert.assertTrue(lvmexhact.getValidateProductsPage().isDisplayed());
		Thread.sleep(5000);
		//Assert.assertTrue(driver.getTitle().contains("Products for "+linename+""));
		Assert.assertTrue(driver.getTitle().contains(linename));

		// Get the Matching Products count on Products page
		String producttabtitle = lvmexhact.getValidateProductsPage().getText();
		String matchingprodcountonprodpage = producttabtitle.replaceAll("[^0-9]", "");
		System.out.println("Matching Products Count on Products page is: " + matchingprodcountonprodpage);

		// Verify Matching Products count on Search grid should match with Products page
		Assert.assertEquals(matchingprodcountonsearchgrid, matchingprodcountonprodpage);
	}

	@Test(priority = 4)
	public void TS004_VerifyClickOnTotalProductsSeeAllLinkForLineTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T369: Lines actions: Total Products- See all

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		lap = new LVMLandingPage(driver);
		lvmmppge = new LVMMarketPlannerPage(driver);
		utl = new Utility(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("lvmurl_uat"));;
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();

		lvmgs.getLVMGlobalSearchTextBox().sendKeys("   ");
		lvmgs.getLVMSearchButton().click();

		Thread.sleep(15000);
		// Store the 1st Line name in String variable
		String linename = lvmexhact.getExhibitorName().getText();
		System.out.println("Line name: " +linename);

		// Get the Matching Products count on Search grid
		String temp = lvmexhact.getMatchingProdCountOnSearchGrid().getText();
		String matchingprodcountonsearchgrid = temp.replaceAll("[^0-9]", "");
		System.out.println("Total Products Count on Search Results grid is: " + matchingprodcountonsearchgrid);
		Thread.sleep(2000);
		// Click on Total Product See All link
		//utl.scrollToElement(lvmexhact.getTotalProdSeeAllLink());
		lvmexhact.getTotalProdSeeAllLink().click();

		Thread.sleep(15000);
		// Verify that user should redirect to the Matching Products page
		Assert.assertTrue(lvmexhact.getValidateProductsPage().isDisplayed());
		/*String t=driver.getTitle();
		System.out.println(t);*/
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		//Assert.assertTrue(driver.getTitle().contains("Products for "+linename+""));
		Assert.assertTrue(driver.getTitle().contains(linename));

		// Get the Matching Products count on Products page
		String producttabtitle = lvmexhact.getValidateProductsPage().getText();
		String matchingprodcountonprodpage = producttabtitle.replaceAll("[^0-9]", "");
		System.out.println("Total Products Count on Products page is: " + matchingprodcountonprodpage);

		// Verify Total Products count on Search grid should match with Products page
		Assert.assertEquals(matchingprodcountonsearchgrid, matchingprodcountonprodpage);
		
		driver.get(prop.getProperty("lvmurl_uat"));;
		//lap.getCloseMarktAdBtn().click();
	}
	
	@Test(enabled=false)
	public void TS005_VerifyClickOnContactExhIconForLineTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T361: The click on 'Contact Exhibitor' functionality for a Line

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		lap = new LVMLandingPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("globalsearchlineinput"));
		lvmgs.getLVMSearchButton().click();

		Thread.sleep(15000);
		// Click on Contact Exhibitor icon
		lvmexhact.getContactExhibitorIcon().click();
		Assert.assertTrue(lvmexhact.getContactExhibitorModal().isDisplayed());

		// Enter Postal code
		lvmexhact.getPostalCodeTxtBx().sendKeys("99950");

		// Enter Message
		lvmexhact.getMessageTxtBx().sendKeys("This is a Test Line");

		// Select 1st two Product Category
		lvmexhact.getProductCateg1().click();
		lvmexhact.getProductCateg2().click();

		utl.scrollToElement(lvmexhact.getSendMessageBtn());

		// Click on Send Message button
		// Will send msg once test exhibitor will get
		// lvmexhact.getSendMessageBtn().click();

		// Close the pop-up
		lvmexhact.getPopUpCloseBtn().click();
	}

	@Test(enabled=false)
	public void TS006_VerifyAddToFavoriteForLineTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T360: The Add to Favorite functionality for a Line

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		lvmmppge = new LVMMarketPlannerPage(driver);
		lap = new LVMLandingPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("lvmurl_uat"));;
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();

		lvmgs.getLVMGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchInputForLines")));
		lvmgs.getLVMSearchButton().click();

		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		String exhname = lvmexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		// Click on Favorite icon of 1st exhibitor
		//lvmexhact.getaddfaviconLVM_UAT().click();
		Thread.sleep(8000);
		// Click on Market Planner link
		lap.getMPLinkText().click();

		// Click on Lists tab on MP home page
		lvmmppge.getMPHomeListsTab().click();
		lvmmppge.getLVMMPListsPageFavoritesMenu().click();
		Thread.sleep(5000);
		// Verify that the added favorites exhibitor should be displayed in to Favorites list
		//Assert.assertTrue(lvmmppge.getLVMSavedExhNameInList().getText().contains(exhname));
		favlist = lvmmppge.getFavExhList();
		for (int i = 0; i < favlist.size(); i++) {
			String exhName = favlist.get(i).getText();
			if(exhName.equals(exhname)) {
				WebElement editOpt = favlist.get(i).findElement(By.xpath("./../../div[4]/div/button"));
				 new Actions(driver).clickAndHold(editOpt).perform();
				favlist.get(i).findElement(By.xpath("./../../div[4]/div/button/./../div/span[3]")).click();
				break;
			}			
		}

		// Delete that favorites exhibitor from list
	/*	lvmmppge.getLVMEditListItemMoreBtn().click();
		lvmmppge.getLVMEditListItemDeleteOptn().click();
		Thread.sleep(6000)*/;
		//utl.scrollToElement(lvmmppge.getSavedProductNameInList());
		/*Thread.sleep(3000);
		lvmmppge.getMoreBtnDeleteOptnExistingList_ATLPROD().click();
		Thread.sleep(3000);
		lvmmppge.getLVMEditListItemDeleteOptn().click();
		Thread.sleep(8000);*/
		//favlist = driver.findElements(By.xpath("//li[@class='imc-list-edit--draggable']/div/div/div/a"));

		//Verify that the added product should be removed from Favorites list
		for(int i=1; i< favlist.size(); i++){
			Assert.assertFalse(favlist.get(i).getText().contains(exhname)); 
		}
		// Verify that the added favorites exhibitor should be removed from Favorites list
		//Assert.assertFalse(lvmmppge.getLVMSavedExhNameInList().getText().contains(exhname));
	}

	@Test(enabled=false)
	public void TS007_VerifyClickOnOrderOnJuniperMarketBtnForLineTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T376: The click on 'Order On JuniperMarket' button functionality for a Line

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		lvmmppge = new LVMMarketPlannerPage(driver);
		lap = new LVMLandingPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("lvmurl_uat"));;
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();

		lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("exhibitor6"));
		lvmgs.getLVMSearchButton().click();

		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		String exhname = lvmexhact.getExhibitorName().getText();
		System.out.println("Line name: " + exhname);

		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		lvmexhact.getOrderOnJuniperMarketBtn().click();

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

	@Test(enabled=false)
	public void TS008_VerifyAddToNewListForLineTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T423: The Add to Newly created list functionality for Line

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		lvmmppge = new LVMMarketPlannerPage(driver);
		genData = new GenerateData();
		lap = new LVMLandingPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(prop.getProperty("lvmurl_uat"));;
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();
		
		lvmgs.getLVMGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchInputForLines")));
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(15000);
		lvmexhact.getseealllink().click();

		// Store the 1st Exhibitor name in String variable
		String exhname = lvmexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		// Click on Add to List button for 1st Exhibitor
		lvmexhact.getSearchResultMoreicon().click();
		lvmexhact.getAddToListOptn().click();
		utl.scrollToElement(lvmmppge.getCreateNewListNameTxtbx());

		//Enter new list name
		String newlistname = "Cyb"+ genData.generateRandomString(5);
		lvmmppge.getCreateNewListNameTxtbx().sendKeys(newlistname);
		System.out.println("Newly created list is: " + newlistname);

		// Scroll till Create button
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				lvmmppge.getNewListModalCreateBtn());

		// Click on Create button
		lvmexhact.getcreatelistbtn().click();
		// Click on Go to Market Planner button
		lvmmppge.getGoToMarketPlannerBtn().click();

		// Click on Lists tab on MP home page
		lvmmppge.getMPHomeListsTab().click();
		lvmmppge.getListsPageListsMenu().click();

		mplists = lvmmppge.getLVMMPListsNames();
		mpeditlistoptns = lvmmppge.getLVMMPEditListOptns();

		for (int i = 0; i < mplists.size(); i++) {
			//System.out.println(mplists.get(i).getText());
			// System.out.println(mpeditlistoptns.get(i).getText());
			if (mplists.get(i).getText().equals(newlistname)) {
				mpeditlistoptns.get(i).click();
				break;
			}
		}
		System.out.println(lvmmppge.getLVMSavedExhNameInList().getText());
		Assert.assertTrue(lvmmppge.getLVMSavedExhNameInList().getText().contains(exhname));
	}

	@Test(enabled=false)
	public void TS009_VerifyAddToExistingListForLineTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T362: The Add to Newly created list functionality for a Line

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		lvmmppge = new LVMMarketPlannerPage(driver);
		lap = new LVMLandingPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("lvmurl_uat"));;
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();

		lvmgs.getLVMGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchInputForLines")));
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(15000);
		//lvmexhact.getseealllink().click();

		// Store the 1st Exhibitor name in String variable
		String exhname = lvmexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		// Click on Add to List button for 1st Exhibitor
		lvmexhact.getSearchResultMoreicon().click();
		lvmexhact.getAddToListOptn().click();

		// Store the existing list name
		String existinglistname = lvmmppge.getLVMMPExistingListName().getText();
		System.out.println("Existing list name: " + existinglistname);

		// Select Existing list name
		lvmmppge.getLVMMPExistingListName().click();

		// Scroll till Add to Selected button
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
			//System.out.println(mplists.get(i).getText());
			// System.out.println(mpeditlistoptns.get(i).getText());
			if (mplists.get(i).getText().equals(existinglistname)) {
				mpeditlistoptns.get(i).click();
				break;
			}
		}
		Thread.sleep(5000);
		Assert.assertTrue(lvmmppge.getLVMSavedExhNameInList().getText().contains(exhname));

/*		// Delete that added line from list
		//lvmmppge.getLVMEditListItemMoreBtn().click(); //Old 
		lvmmppge.getLVMEditListItemMoreBtnNew().click();
		// Hover on MoreOptions
				Actions actions = new Actions(driver);
				actions.moveToElement(lvmmppge.getLVMEditListItemMoreBtnNew()).perform();
				// To mouseover on See Details btn
				actions.moveToElement(lvmmppge.getLVMEditListItemDeleteOptn()).perform();

				// Click on See Details button
				actions.click().perform();*/
		Thread.sleep(3000);
		utl.scrollToElement(lvmmppge.getLVMSavedExhNameInList());
		lvmmppge.getMoreBtnDeleteOptnExistingList_LVMPROD().click();
		Thread.sleep(3000);
		lvmmppge.getLVMEditListItemDeleteOptn().click();
		Thread.sleep(8000);
		Assert.assertFalse(lvmmppge.getLVMSavedExhNameInList().getText().contains(exhname));
		driver.get(prop.getProperty("lvmurl_uat"));;
	}
	
	@AfterClass
	public void tearDown()
	{
		//driver.quit();
	}
}
