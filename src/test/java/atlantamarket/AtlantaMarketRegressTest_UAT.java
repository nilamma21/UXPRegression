package atlantamarket;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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

@Listeners({TestListeners.class})
public class AtlantaMarketRegressTest_UAT extends base {

	public WebDriverWait wait;
	public GenerateData genData;
	public Utility utl;
	ATLLoginPage lp;
	ATLLandingPage lap;
	ATLGlobalSearchPage atlgs;
	ATLExhDigiShowroomPage atlexhdgshw;
	ATLProductDetailsPage atlproddet;
	ATLExhLineProdActionsPage atlexhact;
	ATLMarketPlannerPage atlmppge;
	List<WebElement> exhlist, linelist, prodlist, searchtypelist, mplists, mpeditlistoptns;

	@BeforeTest
	public void initialize() throws IOException, InterruptedException
	{
		driver = initializeDriver(); //requires for Parallel text execution
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);

		//Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("atlmrkturl_uat"));
		lap.getIUnderstandBtn().click();
		Thread.sleep(10000);
		lap.getCloseMarktAdBtn().click();
	}

	@Test(priority=1)
	public void TS001_VerifyMarketPlannerLoginTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-001: To verify the Market Planner overview and it's functionality

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		utl = new Utility(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Login to Market Planner
		utl.verifyMPLoginFunctionality();

		//Verify that Market Planner Home page should be displayed
		Assert.assertTrue(lap.getMPLinkText().isDisplayed());
		Thread.sleep(6000);
		lap.getCloseMarktAdBtn().click();
	}

	@Test(priority=2)
	public void TS002_VerifySelectionOfExhibitorFromAutoSuggestionListTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//T419: The selection of an Exhibitor from Auto Suggestion List

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("autosuggestexhibitor")));

		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li")));

		exhlist = atlgs.getATLSearchResultsList();
		searchtypelist = atlgs.getATLSearchResultTypeList();

		for(int i=0; i<10; i++)
		{			
			//System.out.println(list.get(i).getText());
			if(exhlist.get(i).getText().equals(prop.getProperty("autosuggestexhibitor")) && searchtypelist.get(i).getText().equals("Exhibitor"))
			{
				exhlist.get(i).click();
				break;
			} 
		}
		Assert.assertTrue(atlexhdgshw.getATLValidateExhDigiShowPage().isDisplayed());
		atlgs.getATLClearSearchBtn().click();
	}

	@Test(priority=3)
	public void TS003_VerifySelectionOfLineFromAutoSuggestionListTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//T420: The selection of a Line from Auto Suggestion List

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("autosuggestline")));

		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li")));

		linelist = atlgs.getATLSearchResultsList();
		searchtypelist = atlgs.getATLSearchResultTypeList();

		for(int i=0; i<10; i++)
		{			
			//System.out.println(list.get(i).getText());
			if(linelist.get(i).getText().equals(prop.getProperty("autosuggestline")) && searchtypelist.get(i).getText().equals("Line"))
			{
				linelist.get(i).click();
				break;
			} 
		}
		Assert.assertTrue(atlexhdgshw.getATLValidateExhDigiShowPage().isDisplayed());
		atlgs.getATLClearSearchBtn().click();
	}

	@Test(priority=4)
	public void TS004_VerifySelectionOfProductFromAutoSuggestionListTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//T420: The selection of a Product from Auto Suggestion List

		atlgs = new ATLGlobalSearchPage(driver);
		atlproddet = new ATLProductDetailsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("autosuggestproduct")));

		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li")));

		prodlist = atlgs.getATLProductsSearchResultsList();
		searchtypelist = atlgs.getATLSearchResultTypeList();

		for(int i=0; i<10; i++)
		{			
			//System.out.println(list.get(i).getText());
			if(prodlist.get(i).getText().equals(prop.getProperty("autosuggestproduct")) && searchtypelist.get(i).getText().equals("Product"))
			{
				prodlist.get(i).click();
				break;
			} 
		}
		Assert.assertTrue(atlproddet.getATLValidateProdDetailsPage().isDisplayed());
		atlgs.getATLClearSearchBtn().click();
	}

	@Test(priority=5)
	public void TS005_VerifyAddToFavoriteForExhibitorTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//T320: The Add to Favorite functionality for an Exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();

		//Store the 1st Exhibitor name in String variable
		String exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: "+exhname);

		//Click on Favorite icon of 1st exhibitor
		atlexhact.getAddFavIcon().click();

		//Click on Market Planner link
		lap.getMPLinkText().click();

		//Click on Lists tab on MP home page
		atlmppge.getMPHomeListsTab().click();
		atlmppge.getATLMPListsPageFavoritesMenu().click();

		//Verify that the added favorites exhibitor should be displayed in to Favorites list
		Assert.assertTrue(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));

		//Delete that favorites exhibitor from list
		atlmppge.getATLEditListItemMoreBtn().click();
		atlmppge.getATLEditListItemDeleteOptn().click();
		Thread.sleep(6000);

		//Verify that the added favorites exhibitor should be removed from Favorites list
		Assert.assertFalse(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));
	}

	@Test(priority=6)
	public void TS006_VerifyAddToNewListForExhibitorTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//T422: The Add to Newly created list functionality for an Exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();

		//Store the 1st Exhibitor name in String variable
		String exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: "+exhname);

		//Click on Add to List button for 1st Exhibitor
		atlexhact.getSearchResultMoreicon().click();
		atlexhact.getAddToListOptn().click();

		//Enter new list name
		String newlistname = "Cyb"+ genData.generateRandomString(5);
		atlmppge.getCreateNewListNameTxtbx().sendKeys(newlistname);
		System.out.println("Newly created list is: "+newlistname);

		//Scroll till Create button
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", atlmppge.getNewListModalCreateBtn());

		//Click on Create button
		atlmppge.getNewListModalCreateBtn().click();
		//Click on Go to Market Planner button
		atlmppge.getGoToMarketPlannerBtn().click();

		//Click on Lists tab on MP home page
		atlmppge.getMPHomeListsTab().click();
		atlmppge.getListsPageListsMenu().click();

		mplists = atlmppge.getATLMPListsNames();
		mpeditlistoptns = atlmppge.getATLMPEditListOptns();

		for(int i=0; i< mplists.size(); i++)
		{			
			System.out.println(mplists.get(i).getText());
			//System.out.println(mpeditlistoptns.get(i).getText());
			if(mplists.get(i).getText().equals(newlistname))
			{
				mpeditlistoptns.get(i).click();
				break;
			} 
		}
		Assert.assertTrue(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));
	}

	@Test(priority=7)
	public void TS007_VerifyAddToExistingListForExhibitorTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//T321: The Add to Newly created list functionality for an Exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();

		//Store the 1st Exhibitor name in String variable
		String exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: "+exhname);

		//Click on Add to List button for 1st Exhibitor
		atlexhact.getSearchResultMoreicon().click();
		atlexhact.getAddToListOptn().click();

		//Store the existing list name
		String existinglistname = atlmppge.getATLMPExistingListName().getText();
		System.out.println("Existing list name: "+existinglistname);

		//Select Existing list name
		atlmppge.getATLMPExistingListName().click();

		//Scroll till Add to Selected button
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", atlmppge.getATLMPAddToSelectedBtn());
		atlmppge.getATLMPAddToSelectedBtn().click();

		//Click on Go to Market Planner button
		atlmppge.getGoToMarketPlannerBtn().click();

		//Click on Lists tab on MP home page
		atlmppge.getMPHomeListsTab().click();
		atlmppge.getListsPageListsMenu().click();

		mplists = atlmppge.getATLMPListsNames();
		mpeditlistoptns = atlmppge.getATLMPEditListOptns();

		for(int i=0; i< mplists.size(); i++)
		{			
			System.out.println(mplists.get(i).getText());
			//System.out.println(mpeditlistoptns.get(i).getText());
			if(mplists.get(i).getText().equals(existinglistname))
			{
				mpeditlistoptns.get(i).click();
				break;
			} 
		}
		Assert.assertTrue(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));

		//Delete that added exhibitor from list
		atlmppge.getATLEditListItemMoreBtn().click();
		atlmppge.getATLEditListItemDeleteOptn().click();
		Thread.sleep(8000);

		//Verify that the added exhibitor should be removed from Existing list
		//Assert.assertFalse(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));
	}
	
	@Test(priority=8)
	public void TS008_VerifyClickOnContactExhIconForExhibitorTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//T323: The click on 'Contact Exhibitor' functionality for an Exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys("IMC Test");
		atlgs.getATLSearchButton().click();

		//Click on Contact Exhibitor icon
		atlexhact.getContactExhibitorIcon().click();
		Assert.assertTrue(atlexhact.getContactExhibitorModal().isDisplayed());
		
		//Enter Postal code
		atlexhact.getPostalCodeTxtBx().sendKeys("99950");
		
		//Enter Message
		atlexhact.getMessageTxtBx().sendKeys("This is a Test Exhibitor");
		
		//Select 1st two Product Category
		atlexhact.getProductCateg1().click();
		atlexhact.getProductCateg2().click();
		
		utl.scrollToElement(atlexhact.getSendMessageBtn());
		
		//Click on Send Message button
		//Will send msg once test exhibitor will get
		//atlexhact.getSendMessageBtn().click();
	}
	
	@Test(priority=9)
	public void TS009_VerifyClickOnLocationLinksForExhibitorTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//T356: The click on 'Location Links' functionality for an Exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();
		
		//Click on any of the Location link present in Exhibitor card
		String locationlink = atlexhact.getLocationLinkInExhCard().getAttribute("href");
		atlexhact.getLocationLinkInExhCard().click();
		Thread.sleep(5000);
		
		//Verify that selected building-floor plan page should be opened
		Assert.assertTrue(locationlink.equals(driver.getCurrentUrl()));
	}
}
