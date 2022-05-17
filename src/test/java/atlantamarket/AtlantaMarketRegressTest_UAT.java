package atlantamarket;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.AtlantaMarket.ATLExhDigiShowroomPage;
import pageObjects.AtlantaMarket.ATLGlobalSearchPage;
import pageObjects.AtlantaMarket.ATLLandingPage;
import pageObjects.AtlantaMarket.ATLProductDetailsPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

@Listeners({TestListeners.class})
public class AtlantaMarketRegressTest_UAT extends base {
	
	public WebDriverWait wait;
	public GenerateData genData;
	public Utility utl;
	ATLLandingPage lap;
	ATLGlobalSearchPage atlgs;
	ATLExhDigiShowroomPage atlexhdgshw;
	ATLProductDetailsPage atlproddet;
	List<WebElement> exhlist, linelist, prodlist, searchtypelist;
	
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
	public void TS001_VerifySelectionOfExhibitorFromAutoSuggestionListTest() throws InterruptedException, IOException
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

	@Test(priority=2)
	public void TS002_VerifySelectionOfLineFromAutoSuggestionListTest() throws InterruptedException, IOException
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
	
	@Test(priority=3)
	public void TS003_VerifySelectionOfProductFromAutoSuggestionListTest() throws InterruptedException, IOException
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
}
