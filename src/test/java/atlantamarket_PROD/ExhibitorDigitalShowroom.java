package atlantamarket_PROD;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
		utl.CloseATLPopup();
		Thread.sleep(3000);

		utl.verifyMPLoginFunctionality();
		Thread.sleep(3000);
		lap.getIUnderstandBtn().click();
		utl.CloseATLPopup();
	}
	
	@Test(priority = 1)
	public void TS001_VerifyAddToFavoritesTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T294: Add To Favorites - Need to recheck

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

}

