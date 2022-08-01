package atlantamarket_PROD;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
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
import pageObjects.AtlantaMarket.ATLLoginPage;
import pageObjects.AtlantaMarket.ATLMarketPlannerPage;
import pageObjects.AtlantaMarket.ATLProductDetailsPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

@Test
@Listeners({ TestListeners.class })
public class GlobalSearch_SearchFor extends base {

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

	List<WebElement> exhlist, linelist, prodlist, searchexhtypelist, searchproducttypelist, mplists, mpeditlistoptns,
			allnoteslist, favlist, searchlinetypelist, infoFilterList;

	@BeforeClass
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		// chromeVersion();
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);

		// Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("atlmrkturl_prod"));
		lap.getIUnderstandBtn().click();
		Thread.sleep(5000);
		// lap.getCloseMarktAdBtn().click();
	}

	public void TS001_VerifyGlobalSearchSearchForInformationTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T427: Global Search- Search for: Information

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("globalsearchlineinputforInformation"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);
		// Click on Info link
		atlgs.getATLsearchresultInfoLink().click();
		Assert.assertTrue(
				atlgs.getATLSearchResult().getText().contains(prop.getProperty("globalsearchlineinputforInformation")));
		// Click on Juniper Market Btn from result
		atlgs.getATLInfoSearchJuniperMarketBtn().click();
		// Verify Juniper Market Page
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlantamarket.com/JuniperMarket"));

	}

	public void TS002_VerifyGlobalSearchSearchForInformationSearchBoxTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T427: Global Search- Search for: Information - Search box

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys("   ");
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);
		// Click on Info link
		atlgs.getATLsearchresultInfoLink().click();
		atlgs.getATLInfosearchtxtbx().sendKeys(prop.getProperty("globalsearchlineinputforInformation"));
		atlgs.getATLInfosearchbtn().click();

		Assert.assertTrue(
				atlgs.getATLSearchResult().getText().contains(prop.getProperty("globalsearchlineinputforInformation")));
		// Click on Juniper Market Btn from result
		atlgs.getATLInfoSearchJuniperMarketBtn().click();
		// Verify Juniper Market Page
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlantamarket.com/JuniperMarket"));

	}

	public void TS003_VerifyGlobalSearchSearchInformationAndFiltersTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T437: Global Search- Search for: Information -Filters

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys("   ");
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);
		// Click on Info link
		atlgs.getATLsearchresultInfoLink().click();
		// click on Topics filter
		atlgs.getATLInfoSearchTopicsFilter().click();

		
		
		infoFilterList = driver.findElements(By.xpath("//div[@class='imc-filteritem__option']"));
		
		for(int i=0;i<infoFilterList.size();i++)
		{
			infoFilterList.get(i).getText();
			System.out.println(infoFilterList.get(i));
			
			switch(infoFilterList.get(i).getText())
			{
			case "Exhibitors":

				infoFilterList.get(i).click();
				System.out.println(atlgs.getATLInfoSearchTopicsMarketSnapshot().getText());
				Assert.assertTrue(atlgs.getATLInfoSearchTopicsMarketSnapshot().getText().contains("exhibitor"));
				atlgs.getATLInfoSearchSeeMoreDetailsBtn().click();
				Assert.assertTrue(atlgs.getATLExhibitorHeader().getText().contains("Exhibitors & Products"));
				driver.navigate().back();
				infoFilterList.get(i).click();
				driver.navigate().refresh();
				Thread.sleep(5000);
				// Click on Info link
				atlgs.getATLsearchresultInfoLink().click();
				// click on Topics filter
				atlgs.getATLInfoSearchTopicsFilter().click();
				break;
				
			case "Atlanta Market":
				infoFilterList.get(i).click();
				infoFilterList.get(i).click();
				break;

			case "Market Snapshot":
				infoFilterList.get(i).click();
				//infoFilterList.get(i).click();
				// atlgs.getATLInfoSearchTopicsMarketSnapshot().getTagName();
				Assert.assertTrue(atlgs.getATLInfoSearchTopicsMarketSnapshot().getText().contains("Market Snapshot"));

				infoFilterList.get(i).click();
				break;

			default:
				break;
			}
		}
		
		
		
		
		
		/*
		for (WebElement filters : infoFilterList) {
			
			// System.out.println(filters.getSize());
			// String s = filters.getText();
			
			
			for(WebElement f:infoFilterList)
			{
			switch (f.getText()) {
			case "Exhibitors":

				filters.click();
				System.out.println(atlgs.getATLInfoSearchTopicsMarketSnapshot().getText());
				Assert.assertTrue(atlgs.getATLInfoSearchTopicsMarketSnapshot().getText().contains("exhibitor"));
				atlgs.getATLInfoSearchSeeMoreDetailsBtn().click();
				Assert.assertTrue(atlgs.getATLExhibitorHeader().getText().contains("Exhibitors & Products"));
				driver.navigate().back();
				Thread.sleep(5000);
				//44driver.navigate().refresh();
				// click on Topics filter
			
				break;

			case "Atlanta Market":
				filters.click();
				filters.click();
				break;

			case "Market Snapshot":
				filters.click();
				// atlgs.getATLInfoSearchTopicsMarketSnapshot().getTagName();
				Assert.assertTrue(atlgs.getATLInfoSearchTopicsMarketSnapshot().getText().contains("Market Snapshot"));

				filters.click();
				break;

			default:
				break;
			}

		}
}
*/		
		

	}

	public void TS004_VerifyGlobalSearchSearchForCatalogsTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T428: Global Search- Search for: Catalogs

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys("   ");
		atlgs.getATLSearchButton().click();
		Thread.sleep(15000);
		// Click on Info link
		// Store the 1st Exhibitor name in String variable
		String exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);
		atlexhact.getExhibitorName().click();

		utl.scrollToElement(atlgs.getAtlCatalog());
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		atlgs.getAtlCatalog().click();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(5000);
		Assert.assertTrue(driver.getTitle().contains("Catalog View"));
		Assert.assertTrue(atlgs.getCatalogHeaderName().getText().contains("Catalog"));
		driver.close();
		driver.switchTo().window(winHandleBefore);
	}

	public void TS005_VerifyGlobalSearchSearchForArticlesTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T429: Global Search- Search for : Articles

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
		atlgs.getATLGlobalSearchTextBox().sendKeys("   ");
		atlgs.getATLSearchButton().click();
		Thread.sleep(8000);
		// Click on Article link
		atlgs.getATLsearchresultArticlesLink().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlantamarket.com/search/articles"));

	}

	public void TS004_VerifyGlobalSearchSearchForBlogTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T428: Global Search- Search for: Articles -Blogs

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys("blog");
		atlgs.getATLSearchButton().click();
		Thread.sleep(15000);
		// Click on Info link
		atlgs.getATLsearchresultArticlesLink().click();

		Assert.assertTrue(atlgs.getATLSearchResultBlog().getText().contains("blog"));

	}

	/*
	 * @AfterClass public void tearDown() { driver.quit(); }
	 */

}
