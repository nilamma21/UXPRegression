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
import pageObjects.AtlantaMarket.ATLLeftPaneFilters;
import pageObjects.AtlantaMarket.ATLLoginPage;
import pageObjects.AtlantaMarket.ATLMarketPlannerPage;
import pageObjects.AtlantaMarket.ATLProductDetailsPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

@Listeners({ TestListeners.class })
public class GlobalSearch_LeftPaneFilters extends base {

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
		//utl.verifyMPLoginFunctionality();
		
		//Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();
	}
	
	@Test(priority = 1)
	public void TS001_VerifySelectionOfOneFilterOfProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T404: Selection Of One Filter Of Prod Catg From Left Pane Filters

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		atlleftpane = new ATLLeftPaneFilters(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("filtersglobalsearchinput")));
		atlgs.getATLSearchButton().click();

		//Click on Product Categories expand btn
		atlleftpane.getATLProdCatgExpandBtn().click();
		
		atlleftpane.getAccentFurnExpandBtn().click();
	}

	@Test(priority = 2)
	public void TS002_VerifySelectionOfMoreThanOneFilterOfProdCatgFromLeftPaneFiltersTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T405: Left pane Filters : Product Categories Filter : Combined within

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		atlleftpane = new ATLLeftPaneFilters(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("filtersglobalsearchinput")));
		atlgs.getATLSearchButton().click();

		// Click on Product Categories expand btn
		atlleftpane.getATLProdCatgExpandBtn().click();
		// Store All the filter list
		List<WebElement> filter = driver.findElements(By.xpath("//div[@class='imc-filteritem__option']"));
		boolean var=false;
		for (WebElement fl : filter) {
			// Click on 1st Filter
			if(fl.getText().equals(prop.getProperty("filter1"))) //Filter 1 :Women's Contemporary
			{
				String filterName1 = fl.getText();
				System.out.println("Click on 1nd Filter : " + filterName1);
				fl.click();
				var=true;
				break;
			}
		}
		Assert.assertTrue(var);
		boolean var2=false;
		for (WebElement fl : filter) {
			// Click on 2nd Filter
			if (fl.getText().equals(prop.getProperty("filter2"))) // filter2 : Women's Resort
			{
				String filterName2 = fl.getText();
				System.out.println("Click on 2nd Filter : " + filterName2);
				fl.click();
				var2=true;
				break;
			}
		}
		Assert.assertTrue(var2);
		
		// Store 1st exhibitor name
		String exhName = atlleftpane.getATLexhibitor().getText();
		System.out.println("Exhibitor Name : " + exhName);
		atlleftpane.getATLexhibitor().click();

		// List of All Product category
		List<WebElement> categoris = driver.findElements(By.xpath(
				"//div[@class='imc-gallery__item imc-gallery__item--no-padding-left imc-gallery__item--no-padding-right imc-type--title-8 imc-padding--bottom--xsmall']"));
		boolean var3=false;
		for (WebElement flC : categoris) {
			// Verify selected filter and its respected categories
			
			if (flC.getText().equals(prop.getProperty("filter1"))
					&& flC.getText().equals(prop.getProperty("filter2")));
			{
				System.out.println("CatName : " + flC.getText());
				var3=true;
				break;
			}
			
		}
		Assert.assertTrue(var3);
	}

	/*@AfterClass
	public void tearDown()
	{
		driver.quit();
	}*/
}
