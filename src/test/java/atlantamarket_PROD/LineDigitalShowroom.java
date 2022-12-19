package atlantamarket_PROD;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AtlantaMarket.ATLExhDigiShowroomPage;
import pageObjects.AtlantaMarket.ATLExhLineProdActionsPage;
import pageObjects.AtlantaMarket.ATLGlobalSearchPage;
import pageObjects.AtlantaMarket.ATLLandingPage;
import pageObjects.AtlantaMarket.ATLLeftPaneFilters;
import pageObjects.AtlantaMarket.ATLLineDigitalShowroomPage;
import pageObjects.AtlantaMarket.ATLLoginPage;
import pageObjects.AtlantaMarket.ATLMarketPlannerPage;
import pageObjects.AtlantaMarket.ATLProductDetailsPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

public class LineDigitalShowroom extends base {
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
	ATLLineDigitalShowroomPage atldigish;

	List<WebElement> exhlist, linelist, prodlist, searchexhtypelist, searchproducttypelist, mplists, mpeditlistoptns,
			allnoteslist, favlist, searchlinetypelist, tagBlogPost, taglist, infoFilterList;

	@BeforeClass
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		// chromeVersion();
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);
		atlgs=new ATLGlobalSearchPage(driver);
		
		// Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("atlmrkturl_prod"));
		
		lap.getIUnderstandBtn().click();
		Thread.sleep(5000);
		utl.CloseATLPopup();
		
		//lap.getCloseMarktAdBtn().click();
		
	}
	@Test(priority = 01)
	public void TS001_VerifyLineDigitalShowroomHeroComponentShownByExhibitorNamaeTest()throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T337: Line Digital Showroom: Hero component: Shown by <ExhibitorName>

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();
		atldigish=new ATLLineDigitalShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//click on Global Search Input filed
		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("HeroComponentExhName"));
		Thread.sleep(5000);
		//Click on 1st Suggetions
		atldigish.getsuggetionList().click();
		Thread.sleep(5000);
		//Verify Digi showrrom page
		Assert.assertTrue(atldigish.getAtlLineDigiShowroomPageTitle().getText().equals(prop.getProperty("HeroComponentExhName")));
		//Click on Shown By Exhibitor Name
		String heroompName=atldigish.getdigiShowroomExhName().getText();
		atldigish.getdigiShowroomExhName().click();
		
		//verify Selected exhitor digi showroom ppage
		Assert.assertTrue(atlgs.getatlShowSpecialsTitle().getText().equals(heroompName));
		
	}
	@Test(priority = 02)
	public void TS002_VerifyLineDigitalShowroomHeroComponentLocationLinksTest()throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T338: Line Digital Showroom: Hero component: Location Links
		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();
		atldigish=new ATLLineDigitalShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


		if(!atlgs.getATLGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			atlgs.getatlGlobalSearchClearTxt().click();
		}
	
		//click on Global Search Input filed
		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("HeroComponentExhName"));
		Thread.sleep(5000);
		//Click on 1st Suggetions
		atldigish.getsuggetionList().click();
		Thread.sleep(5000);
		//Verify Digi showrrom page
		Assert.assertTrue(atldigish.getAtlLineDigiShowroomPageTitle().getText().equals(prop.getProperty("HeroComponentExhName")));
		//Click on 1st Location Link
		String locationURL = atldigish.getlocationLink().getAttribute("href");
		
		
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		atldigish.getlocationLink().click();

		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		Thread.sleep(7000);
		//// verify Floor Plan page
		Assert.assertTrue(driver.getCurrentUrl().contains(locationURL));

		// Close the new window, if that window no more required
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
	}
	@Test(priority = 03)
	public void TS003_VerifyLineDigitalShowroomHeroComponentAddToFavoriteTest()throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T339: Line Digital Showroom: Hero component: Add to Favorite
		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();
		atldigish=new ATLLineDigitalShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		if(!atlgs.getATLGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			atlgs.getatlGlobalSearchClearTxt().click();
		}
	
		//click on Global Search Input filed
		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("HeroComponentExhName"));
		Thread.sleep(5000);
		//Click on 1st Suggetions
		atldigish.getsuggetionList().click();
		Thread.sleep(5000);
		//Verify Digi showrrom page
		Assert.assertTrue(atldigish.getAtlLineDigiShowroomPageTitle().getText().equals(prop.getProperty("HeroComponentExhName")));
		//Store Hero Comp Name
		String heroCompName=atldigish.getdigiShowroomExhName().getText();
		// Click on Fav Icon
		atldigish.getfavIconDigiShowroom().click();
		Thread.sleep(6000);
		// Sign In to MP
		// Enter the credentials on Login Page and click
		lp.getEmailAddress().sendKeys((prop.getProperty("username")));
		lp.getPassword().sendKeys((prop.getProperty("password")));

		lp.getSignInBtn().click();
		Thread.sleep(15000);
		// Click on Fav Icon
		atldigish.getfavIconDigiShowroom().click();
		lap.getMPLinkText().click();
		Thread.sleep(6000);

		// Click on List tab
		atlmppge.getMPHomeListsTab().click();
		Thread.sleep(10000);
		// Verify Exhibitor present or not into MP Fav
		utl.checkItemPresentInListorNot(atlmppge.getlistOfAllExh(), heroCompName);

	}
	@Test(priority = 04)
	public void TS004_VerifyLineDigitalShowroomHeroComponentAddTolistTest()throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T340: Line Digital Showroom: Hero component: + icon to add to list
		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();
		atldigish=new ATLLineDigitalShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		if(!atlgs.getATLGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			atlgs.getatlGlobalSearchClearTxt().click();
		}
	
		//click on Global Search Input filed
		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("HeroComponentExhName"));
		Thread.sleep(5000);
		//Click on 1st Suggetions
		atldigish.getsuggetionList().click();
		Thread.sleep(5000);
		//Verify Digi showrrom page
		Assert.assertTrue(atldigish.getAtlLineDigiShowroomPageTitle().getText().equals(prop.getProperty("HeroComponentExhName")));
		//Store Hero Comp Name
		String heroCompName=atldigish.getdigiShowroomExhName().getText();
		// Click on Add to List Icon
		atldigish.getaddToListIcon().click();
		Thread.sleep(6000);
/*		// Sign In to MP
		// Enter the credentials on Login Page and click
		lp.getEmailAddress().sendKeys((prop.getProperty("username")));
		lp.getPassword().sendKeys((prop.getProperty("password")));

		lp.getSignInBtn().click();
		Thread.sleep(15000);
		// Click on Add to List Icon
		Thread.sleep(5000);
		atldigish.getaddToListIcon().click();*/
		
		String exList = atlgs.getatlExistingList().getText();
		System.out.println(exList);
		atlgs.getatlExistingList().click();
		// Click Add to List Btn
		atlgs.getatlAddToSelectBtn().click();
		// CLick on Go To MP Btn
		atlgs.getatlGoToMPBtn().click();

		// Click on Market Planner
		lap.getMPLinkText().click();
		Thread.sleep(6000);

		// Click on List tab
		atlmppge.getMPHomeListsTab().click();
		Thread.sleep(10000);
		// Click on List from left Panel
		atlmppge.getMpListLeftPannel().click();
		// Open selected list
		utl.ClickOnEditBtnOfAnyList(atlmppge.getallList(), exList);
		// Verify exhibitor present into selected list or not
		utl.checkItemPresentInListorNot(atlmppge.getlistOfAllExh(), prop.getProperty("HeroComponentExhName"));
			

	}
	@Test(priority = 05)
	public void TS005_VerifyLineDigitalShowroomHeroComponentAddNoteTest()throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T341: Line Digital Showroom: Hero component: Add Note
		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();
		atldigish=new ATLLineDigitalShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		if(!atlgs.getATLGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			atlgs.getatlGlobalSearchClearTxt().click();
		}
	
		//click on Global Search Input filed
		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("HeroComponentExhName"));
		Thread.sleep(5000);
		//Click on 1st Suggetions
		atldigish.getsuggetionList().click();
		Thread.sleep(5000);
		//Verify Digi showrrom page
		Assert.assertTrue(atldigish.getAtlLineDigiShowroomPageTitle().getText().equals(prop.getProperty("HeroComponentExhName")));
		//Store Hero Comp Name
		String heroCompName=atldigish.getdigiShowroomExhName().getText();
		// Click on Add to List Icon
		atldigish.getaddNoteIcon().click();
		Thread.sleep(6000);
		/*// Sign In to MP
		// Enter the credentials on Login Page and click
		lp.getEmailAddress().sendKeys((prop.getProperty("username")));
		lp.getPassword().sendKeys((prop.getProperty("password")));

		lp.getSignInBtn().click();
		Thread.sleep(15000);*/
		// Click on Add to List Icon
		//atldigish.getaddNoteIcon().click();
		String newnotetitle = "CybNote" + genData.generateRandomString(3);
		// Enter Note title
		atlexhact.getNoteTitleTxtBx().sendKeys(newnotetitle);

		Thread.sleep(5000);
		// Enter Note Content
		atlexhact.getNoteContentTxtBx().sendKeys("TestprodNote" + genData.generateRandomString(6));
		Thread.sleep(5000);
		//atlexhact.getNoteTitleTxtBx().sendKeys(newnotetitle);
		// Click on 'Save' button
		atlexhact.getNoteSaveBtn().click();
		Thread.sleep(5000);

		atldigish.getaddNoteIcon().click();
		Thread.sleep(2000);
		// Click on 'View all Notes for an Exhibitor' link on Add Notes pop-up
		atlexhact.getViewAllNotesLink().click();
		Thread.sleep(5000);

		List<WebElement> allnoteslist = atlexhact.getSavedNoteNameInAllNotesList();

		utl.checkItemPresentInListorNot(allnoteslist, newnotetitle);
		utl.selectFilters(allnoteslist, newnotetitle);

		Thread.sleep(2000);
		// Delete the saved note
		atlexhact.getDeleteNoteBtn().click();
		atldigish.getaddNoteIcon().click();
		Thread.sleep(2000);
		// Click on 'View all Notes for an Exhibitor' link on Add Notes pop-up
		atlexhact.getViewAllNotesLink().click();
		Thread.sleep(2000);
		// Verify Deleted Note not present
		// utl.checkItemNotPresentInList(atlexhact.getSavedNoteNameInAllNotesList(),
		// newnotetitle);
		try {
			utl.checkItemNotPresentInList(atlexhact.getSavedNoteNameInAllNotesList(), newnotetitle);
		} catch (Exception e) {
			System.out.println("Note Deleted successully");
			Thread.sleep(2000);
			atlmppge.getcloseNotePopup().click();
		}
		atlmppge.getcloseNotePopup().click();	
	}
	@Test(priority = 06)
	public void TS006_VerifyLineDigitalShowroomHeroComponentOrderOnJuniperMarketTest()throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T343: Line Digital Showroom: Hero component: Order on Juniper Market
		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();
		atldigish=new ATLLineDigitalShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/*if(!atlgs.getATLGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			atlgs.getatlGlobalSearchClearTxt().click();
		}
	
		//click on Global Search Input filed
		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("HeroComponentExhName"));
		Thread.sleep(10000);
		//Click on 1st Suggetions
		atldigish.getsuggetionList().click();
		Thread.sleep(5000);*/
		//Verify Digi showrrom page
		Assert.assertTrue(atldigish.getAtlLineDigiShowroomPageTitle().getText().equals(prop.getProperty("HeroComponentExhName")));
		//Store Hero Comp Name
		String heroCompName = atldigish.getdigiShowroomExhName().getText();
		// Click on OrderOnJUniper Btn
		String orderOnJuniperURL = atldigish.getorderOnJuniperBtn().getAttribute("href");
		
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		atldigish.getorderOnJuniperBtn().click();

		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		Thread.sleep(7000);
		//// verify Floor Plan page
		Assert.assertTrue(driver.getCurrentUrl().contains(orderOnJuniperURL));

		// Close the new window, if that window no more required
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
			
	}
	@Test(priority = 07)
	public void TS007_VerifyLineDigitalShowroomHeroComponentProductsComponentCountTest()throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T344: Line Digital Showroom: See all Product CTA
		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();
		atldigish=new ATLLineDigitalShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/*if(!atlgs.getATLGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			atlgs.getatlGlobalSearchClearTxt().click();
		}
	
		//click on Global Search Input filed
		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("HeroComponentExhName"));
		Thread.sleep(5000);
		//Click on 1st Suggetions
		atldigish.getsuggetionList().click();
		Thread.sleep(5000);*/
		//Verify Digi showrrom page
		Assert.assertTrue(atldigish.getAtlLineDigiShowroomPageTitle().getText().equals(prop.getProperty("HeroComponentExhName")));
		//Store Hero Comp Name
		String heroCompName = atldigish.getdigiShowroomExhName().getText();
		// Click on OrderOnJUniper Btn
		
		String seeAllProdBtn=atldigish.getseeAllProductBtn().getText();
		String seeAllProdCount = seeAllProdBtn.split(" ")[2].trim();
		atldigish.getseeAllProductBtn().click();
		Thread.sleep(5000);
		String p=driver.findElement(By.xpath("//div[@id='Products']")).getText();
		String count=p.replaceAll("[()]", "");
		String trimCount = count.split(" ")[1].trim();
		//verify both count
		Assert.assertTrue(seeAllProdCount.equals(trimCount));
		
			
	}
	
	@Test(priority = 8)
	public void TS008_VerifyLineDigitalShowroomProductscomponentTest()throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T346: Line Digital Showroom: Products component
		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();
		atldigish=new ATLLineDigitalShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		if(!atlgs.getATLGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			atlgs.getatlGlobalSearchClearTxt().click();
		}
	
		//click on Global Search Input filed
		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("HeroComponentExhName"));
		Thread.sleep(5000);
		//Click on 1st Suggetions
		atldigish.getsuggetionList().click();
		Thread.sleep(5000);
		//Verify Digi showrrom page
		Assert.assertTrue(atldigish.getAtlLineDigiShowroomPageTitle().getText().equals(prop.getProperty("HeroComponentExhName")));
		//Scroll to Product section
		utl.scrollToElement(atldigish.getproductTitle());
		Thread.sleep(5000);
		//Verify Product component and count displayed or not
		Assert.assertTrue(atldigish.getproductTitleAndCount().isDisplayed());
		int count=0;
		for (WebElement prodTile : atldigish.gelistOfproductTile()) {
			if(prodTile.isDisplayed())
			count++;
		}
		System.out.println(count);
		//Verify Tiles count 6 or not
		Assert.assertTrue(count==6);
		//Verify Order on Juniper link
		Assert.assertTrue(atldigish.getorderOnJuniperBtnLink().isDisplayed());
		//Verify Bottom Product count Link CTA
		Assert.assertTrue(atldigish.getprodctCountBottomBtn().isDisplayed());
		
		//Trim count from See All Product btn
		String seeAllProdBtn=atldigish.getprodctCountBottomBtn().getText();
		String trimSeeAllProdCount = seeAllProdBtn.split(" ")[2].trim();
		
		//Trim count from Product Section titled
		String prodCount=atldigish.getproductCount().getText();
		String trimProdCount = prodCount.split(" ")[0].trim();
		
		//verify both count
		Assert.assertTrue(trimSeeAllProdCount.equals(trimProdCount));
	}
	@Test(priority = 9)
	public void TS009_VerifyLineDigitalShowroomProductscomponentOrderOnJuniperMarketTest()throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T372: Line Digital Showroom: Products component: Order on JuniperMarket
		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();
		atldigish=new ATLLineDigitalShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		if(!atlgs.getATLGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			atlgs.getatlGlobalSearchClearTxt().click();
		}
	
		//click on Global Search Input filed
		/*atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("HeroComponentExhName"));
		Thread.sleep(10000);
		//Click on 1st Suggetions
		atldigish.getsuggetionList().click();
		Thread.sleep(5000);*/
		//Scroll to Product section
		utl.scrollToElement(atldigish.getproductTitle());
		String orderOnJuniperURL=atldigish.getorderOnJuniperBtnLink().getAttribute("href");
		String winHandleBefore = driver.getWindowHandle();
		//CLick on Order on Juniper btn
		atldigish.getorderOnJuniperBtnLink().click();

		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		Thread.sleep(7000);
		//// verify Floor Plan page
		Assert.assertTrue(driver.getCurrentUrl().contains(orderOnJuniperURL));

		// Close the new window, if that window no more required
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
			
			
	}
	@Test(priority = 10)
	public void TS010_VerifyLineDigitalShowroomProductscomponentSeeAllProductsTest()throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T373: Line Digital Showroom: Products component: See All Products
		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();
		atldigish=new ATLLineDigitalShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		if(!atlgs.getATLGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			atlgs.getatlGlobalSearchClearTxt().click();
		}
	
		//click on Global Search Input filed
		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("HeroComponentExhName"));
		Thread.sleep(5000);
		//Click on 1st Suggetions
		atldigish.getsuggetionList().click();
		Thread.sleep(5000);
		//Scroll to Product section
		utl.scrollToElement(atldigish.getproductTitle());
		//Click on See All Prod Btn
		String seeAllProdURL=atldigish.getSeeAllprodctCountBottomBtn().getAttribute("href");
		atldigish.getSeeAllprodctCountBottomBtn().click();
		//Verify See All Product CTA page
		Assert.assertTrue(driver.getCurrentUrl().contains(seeAllProdURL));
	}
	@Test(priority = 11)
	public void TS011_VerifyLineDigitalShowroomProductscomponentSelectProductTest()throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T374: Line Digital Showroom: Products component: Select a Product
		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();
		atldigish=new ATLLineDigitalShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		if(!atlgs.getATLGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			atlgs.getatlGlobalSearchClearTxt().click();
		}
	
		//click on Global Search Input filed
		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("HeroComponentExhName"));
		Thread.sleep(5000);
		//Click on 1st Suggetions
		atldigish.getsuggetionList().click();
		Thread.sleep(5000);
		//Scroll to Product section
		utl.scrollToElement(atldigish.getproductTitle());
		//Click on Any Product Btn
		Thread.sleep(5000);
		try {
		String prodName=atldigish.getproductName().getText();
		String replaceProdName=prodName.replaceAll(".", "");
		Thread.sleep(5000);
		System.out.println(replaceProdName);
		atldigish.getproductName().click();
		Thread.sleep(5000);
		System.out.println(atldigish.getproductHeader().getText());
		//Verify See All Product details page
		Assert.assertTrue(atldigish.getproductHeader().getText().contains(replaceProdName));
		}catch (Exception e){
			String prodName=atldigish.getproductName1().getText();
			String replaceProdName=prodName.replaceAll(".", "");
			Thread.sleep(5000);
			System.out.println(replaceProdName);
			atldigish.getproductName().click();
			Thread.sleep(5000);
			System.out.println(atldigish.getproductHeader().getText());
			//Verify See All Product details page
			Assert.assertTrue(atldigish.getproductHeader().getText().contains(replaceProdName));
		}
		
	}

	
	@AfterClass
	public void tearDown() {
		 //driver.quit();
	}
}
