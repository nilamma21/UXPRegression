package lasvegasmarket_PROD;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
import pageObjects.LasVegasMarket.LVMGlobalSearchPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

@Listeners({ TestListeners.class })
public class GlobalSearch_SuggestionList extends base {

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

	List<WebElement> exhlist, linelist, prodlist, searchexhtypelist, searchproducttypelist, mplists, mpeditlistoptns, allnoteslist,favlist, searchlinetypelist;

	@BeforeClass
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		//chromeVersion();
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
//		Thread.sleep(10000);
//		lap.getCloseMarktAdBtn().click();
	}

	@Test(priority = 1)
	public void TS001_VerifySelectionOfExhibitorFromAutoSuggestionListTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T419: The selection of an Exhibitor from Auto Suggestion List

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		lvmgs = new LVMGlobalSearchPage(driver);
		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(8000);

		lvmgs.getGlobalSearchTextBoxNew().click();
		lvmgs.getGlobalSearchEnterText().sendKeys((prop.getProperty("autosuggestexhibitor")));
		Thread.sleep(2000);

		exhlist = atlgs.getATLSearchResultsList();
		
		for (WebElement suggestion : exhlist) {
	        if (suggestion.getText().contains(prop.getProperty("autosuggestexhibitor"))&& atlgs.getlExhibitorTitle().getText().contains("Exhibitor")) {
	        	String suggetionName=suggestion.getText();
	        	System.out.println(suggetionName);
	        	Thread.sleep(5000);
	        	Actions ac=new Actions(driver);
	            ac.moveToElement(suggestion).click().build().perform();
	        	
	            break;
	            
	        }
		}
		Thread.sleep(8000);
		Assert.assertTrue(atlexhdgshw.getLineExhName().getText().contains((prop.getProperty("autosuggestexhibitor"))));
		
	}

	@Test(priority = 2)
	public void TS002_VerifySelectionOfLineFromAutoSuggestionListTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T420: The selection of a Line from Auto Suggestion List

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		lvmgs = new LVMGlobalSearchPage(driver);
		
		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(8000);

		lvmgs.getGlobalSearchTextBoxNew().click();
		lvmgs.getGlobalSearchEnterText().sendKeys((prop.getProperty("lineActionInput")));
		Thread.sleep(2000);

		exhlist = atlgs.getATLSearchResultsList();
		
		for (WebElement suggestion : exhlist) {
	        if (suggestion.getText().contains(prop.getProperty("lineActionInput"))&& atlgs.getlExhibitorTitle().getText().contains("Line")) {
	        	String suggetionName=suggestion.getText();
	        	System.out.println(suggetionName);
	        	Thread.sleep(5000);
	        	Actions ac=new Actions(driver);
	            ac.moveToElement(suggestion).click().build().perform();
	        	//suggestion.click();
	            break;
	            
	        }
		}
		Thread.sleep(8000);
		Assert.assertTrue(atlexhdgshw.getLineExhName().getText().contains((prop.getProperty("lineActionInput"))));
	}

	@Test(priority = 3)
	public void TS003_VerifySelectionOfProductFromAutoSuggestionListTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T420: The selection of a Product from Auto Suggestion List

		atlgs = new ATLGlobalSearchPage(driver);
		atlproddet = new ATLProductDetailsPage(driver);
		lvmgs = new LVMGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		
		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(8000);

		lvmgs.getGlobalSearchTextBoxNew().click();
		lvmgs.getGlobalSearchEnterText().sendKeys((prop.getProperty("autosuggestproduct_lvm")));
		Thread.sleep(2000);

		exhlist = atlgs.getATLSearchResultsList();
		
		for (WebElement suggestion : exhlist) {
	        if (suggestion.getText().contains(prop.getProperty("autosuggestproduct_lvm"))) {
	        	String suggetionName=suggestion.getText();
	        	System.out.println(suggetionName);
	        	Thread.sleep(5000);
	        	Actions ac=new Actions(driver);
	            ac.moveToElement(suggestion).click().build().perform();
	        	//suggestion.click();
	            break;
	            
	        }
		}
		Thread.sleep(8000);
		Assert.assertTrue(atlexhdgshw.getLineExhName().getText().contains((prop.getProperty("autosuggestproduct_lvm"))));
	}
	
	
	@AfterClass
	public void tearDown()
	{
		//driver.quit();
	}
}
