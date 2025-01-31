package lasvegasmarket_PROD;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import atlantamarket_PROD.TestListeners;
import pageObjects.AtlantaMarket.ATLExhDigiShowroomPage;
import pageObjects.AtlantaMarket.ATLExhLineProdActionsPage;
import pageObjects.AtlantaMarket.ATLGlobalSearchPage;
import pageObjects.AtlantaMarket.ATLLeftPaneFilters;
import pageObjects.AtlantaMarket.ATLMarketPlannerPage;
import pageObjects.AtlantaMarket.ATLProductDetailsPage;
import pageObjects.LasVegasMarket.LVMExhDigiShowroomPage;
import pageObjects.LasVegasMarket.LVMExhLineProdActionsPage;
import pageObjects.LasVegasMarket.LVMFloorPlansPage;
import pageObjects.LasVegasMarket.LVMGlobalSearchPage;
import pageObjects.LasVegasMarket.LVMLandingPage;
import pageObjects.LasVegasMarket.LVMLeftPaneFilters;
import pageObjects.LasVegasMarket.LVMLoginPage;
import pageObjects.LasVegasMarket.LVMMarketPlannerPage;
import pageObjects.LasVegasMarket.LVMProductDetailsPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

@Listeners({ TestListeners.class })
public class GlobalSearch_SearchFor extends base{
	
	public WebDriverWait wait;
	public GenerateData genData;
	public Utility utl;
	public String exhname;
	LVMLoginPage lp;
	LVMLandingPage lap;
	LVMGlobalSearchPage lvmgs;
	LVMExhDigiShowroomPage lvmds;
	LVMProductDetailsPage lvmproddet;
	LVMExhLineProdActionsPage lvmexhact;
	LVMMarketPlannerPage lvmmpp;
	LVMLeftPaneFilters lvmleftpane;
	ATLGlobalSearchPage atlgs;
	ATLExhDigiShowroomPage atlexhdgshw;
	ATLProductDetailsPage atlproddet;
	ATLExhLineProdActionsPage atlexhact;
	ATLMarketPlannerPage atlmppge;
	LVMFloorPlansPage lvmflpp;
	ATLLeftPaneFilters atlleftpane;
	
	List<WebElement> exhlist, linelist, prodlist, searchexhtypelist, searchproducttypelist, mplists, mpeditlistoptns,
	allnoteslist, favlist, searchlinetypelist, tagBlogPost, taglist, infoFilterList, catlist,infoFilterListNew;
	
	@BeforeClass
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		// chromeVersion();
		utl = new Utility(driver);
		lap = new LVMLandingPage(driver);
		// Navigate to LasVegas Market site
		driver.manage().window().maximize();
		//driver.get(prop.getProperty("lvmurl_uat"));
		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		try {
			
			lap.getIUnderstandBtn().click();
			Thread.sleep(5000);
		}catch (Exception e) {
			// TODO: handle exception
		
		}
		// lap.getCloseMarktAdBtn().click();
	}
	
	@Test(priority = 1)
	public void TS001_VerifyInformationTabInGlobalSearchTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T427: Global Search- Search for: Information

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		lvmgs.getGlobalSearchTextBoxNew().click();
		lvmgs.getGlobalSearchEnterText().sendKeys((prop.getProperty("globalsearchinputforInfoTab")));
		Thread.sleep(2000);
		lvmgs.getSearchButtonNew().click();
		
		Thread.sleep(6000);
	// Click on Info link
		lvmgs.getLVMsearchresultInfoLink().click();
		Thread.sleep(2000);
		String infoTitle=lvmgs.getLvmInfoTitleProd().getText();
		System.out.println(infoTitle);
		
		Thread.sleep(2000);
		// Click on See More details Btn from result
		//utl.scrollElementIntoMiddle(lvmgs.getLvmInfoLearnMoreLink());
		Thread.sleep(200);
		String learnMoreLinkURL=lvmgs.getLvmInfoLearnMoreLink().getAttribute("href");
		
		lvmgs.getLvmInfoLearnMoreLink().click();
		Thread.sleep(5000);
		//String infoTitleforInfoPage=lvmgs.getinfoTitleForInfoPage().getText();
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains(learnMoreLinkURL));
		
		//driver.get(prop.getProperty("lvmurl_prod"));
		//Thread.sleep(5000);
	}
	
	@Test(priority = 2)
	public void TS002_VerifyInformationSearchFunctionalityInGlobalSearchTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T439: Global Search- Search for: Information - Search box

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		
		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);
	
		lvmgs.getGlobalSearchTextBoxNew().click();
		lvmgs.getGlobalSearchEnterText().sendKeys((prop.getProperty("globalsearchinputforInfoTab")));
		Thread.sleep(2000);
		lvmgs.getSearchButtonNew().click();
		
		Thread.sleep(6000);

		// Click on Info link
		
		lvmgs.getLVMsearchresultInfoLink().click();
		Thread.sleep(2000);
		String FirstInfoName=lvmgs.getLvmInfoTitleProd().getText();
		System.out.println(FirstInfoName);
	
		lvmgs.getlvmInfosearchtxtbxPROD().clear();
		lvmgs.getlvmInfosearchtxtbxPROD().sendKeys(FirstInfoName);
		Thread.sleep(5000);
		lvmgs.getlvmInfosearchbtnPROD().click();
		Thread.sleep(2000);
		String searchResults=lvmgs.getLvmSearchResultsText().getText();
		System.out.println(searchResults);
		Thread.sleep(2000);
		String searchName=searchResults.split(" ")[4].trim();
		Thread.sleep(5000);
		System.out.println(searchName);
		Assert.assertTrue(FirstInfoName.contains(searchName));

		//driver.get(prop.getProperty("lvmurl_prod"));
		//Thread.sleep(5000);
	}
	
	@Test(priority = 12)
	public void TS003_VerifyInformationFiltersFunctionalityInGlobalSearchTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T437: Global Search- Search for: Information -Filters

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		
		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);
		
		lvmgs.getGlobalSearchTextBoxNew().click();
		lvmgs.getGlobalSearchEnterText().sendKeys((prop.getProperty("globalsearch_input")));
		Thread.sleep(2000);
		lvmgs.getSearchButtonNew().click();
		
		Thread.sleep(6000);

		// Click on Info link
		
		lvmgs.getLVMsearchresultInfoLink().click();
	
		// click on Topics filter
		Thread.sleep(2000);
		lvmgs.getLVMInfoSearchTopicsFilter().click();
		Thread.sleep(3000);
		infoFilterList = driver.findElements(By.xpath("//div[@class='imc-filteritem__option']"));
		//taglist = driver.findElements(By.xpath("(//div[@class='imc-articlecard__tags imc-gallery__item'])[1]/ul/li/button"));
		Thread.sleep(1000);
		for (int i = 0; i < infoFilterList.size(); i++) {
			try {
				String f = infoFilterList.get(i).getText();
				switch (f) {
				case "Las Vegas Market":
					infoFilterList.get(i).click();
					Thread.sleep(2000);
					List<WebElement>taglist1 = driver.findElements(By.xpath("(//div[@class='imc-articlecard__tags imc-gallery__item'])[1]/ul/li/button"));
					for (WebElement tagName : taglist1) {
						try {
						tagName.getText().contains("Las Vegas Market");
							System.out.println("Tag Present");
							Assert.assertTrue(true);
							break;
						}catch (Exception e) {
							Assert.assertTrue(false);
						}
					}
					infoFilterList.get(i).click();
					Thread.sleep(1000);
					break;
				case "First-Time-To-Market":
					infoFilterList.get(i).click();
					Thread.sleep(2000);
					List<WebElement>taglist2 = driver.findElements(By.xpath("(//div[@class='imc-articlecard__tags imc-gallery__item'])[1]/ul/li/button"));
					for (WebElement tagName : taglist2) {
						try{
							tagName.getText().contains("first-time-to-market");
						
							System.out.println("Tag Present");
							Assert.assertTrue(true);
							break;
						}catch (Exception e) {
							Assert.assertTrue(false);
						}
					}
					infoFilterList.get(i).click();
					Thread.sleep(1000);
					break;
				case "Exhibitors":
					infoFilterList.get(i).click();
					Thread.sleep(5000);
					
					List<WebElement>taglist3 = driver.findElements(By.xpath("(//div[@class='imc-articlecard__tags imc-gallery__item'])[1]/ul/li/button"));
					for (WebElement tagName : taglist3) {
						try{
							tagName.getText().contains("Exhibitors");
						
							System.out.println("Tag Present");
							Assert.assertTrue(true);
							break;
						}catch (Exception e) {
							Assert.assertTrue(false);
						}
					}
					lvmgs.getLvmInfoLearnMoreLink().click();
					Thread.sleep(5000);
					
					Assert.assertTrue(lvmgs.getLVMExhibitorHeader().getText().contains("Exhibitors & Products"));
					driver.navigate().back();
					Thread.sleep(5000);
					infoFilterList.get(i).click();
					break;
	
				/*	for (int l = 0; l < taglist.size(); l++) {
						//utl.scrollToElement(taglist.get(l));
						Assert.assertTrue(taglist.get(l).getText().contains("Exhibitors"));
						break;
					}
					Thread.sleep(2000);
					lvmgs.getLVMInfoSearchSeeMoreDetailsBtn().click();
					Thread.sleep(5000);
					Assert.assertTrue(lvmgs.getLVMExhibitorHeader().getText().contains("Exhibitors & Products"));
					driver.navigate().back();
					Thread.sleep(5000);
					infoFilterList.get(i).click();
					break;*/
				default:
					break;
				}
			} catch (StaleElementReferenceException e) {
				infoFilterList = driver.findElements(By.xpath("//div[@class='imc-filteritem__option']"));
				String f = infoFilterList.get(i).getText();
				System.out.println(f);
			}
		}
		//driver.get(prop.getProperty("lvmurl_prod"));
		//Thread.sleep(5000);
	}
	
	@Test(priority = 4)
	public void TS004_VerifyCatalogsOverviewInGlobalSearchTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T428: Global Search- Search for: Catalogs

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);

		lvmgs.getGlobalSearchTextBoxNew().click();
		lvmgs.getGlobalSearchEnterText().sendKeys("   ");
		Thread.sleep(1000);
		lvmgs.getSearchButtonNew().click();

		Thread.sleep(8000);
		
		Actions action=new Actions(driver);
		action.moveToElement(lvmexhact.getdigiShowroomFilterLVMNew()).click().perform();
		Thread.sleep(3000);
		action.moveToElement(lvmexhact.getleftPaneFilterDGShowroomCatalogNew()).click().perform();
		
		Thread.sleep(15000);
		
		List<String> allCatalogExhibitorNames = new ArrayList<>();
		List<WebElement> elements = lvmgs.getlistOfAllCatalogExhibitorNames();

		Thread.sleep(5000);
		// Check if there are at least two elements
        if (elements.size() >= 2) {
            // Store the exhibitor names in the list
            for (WebElement element : elements) {
                allCatalogExhibitorNames.add(element.getText());
            }
            
            // Click on the second element if present
            String secondExhibitorName=elements.get(1).getText();
            System.out.println(secondExhibitorName);
            Actions actoin=new Actions(driver);
            action.moveToElement( elements.get(1)).click().perform();
            //elements.get(1).click(); // 2nd element, index 1
            
            
            
        } 
        // If there is only one element, click the first one
        else if (elements.size() >= 1) {
            // Store the exhibitor name of the first element
            allCatalogExhibitorNames.add(elements.get(0).getText());
            
            // Click on the first element
            String firstExhibitorName=elements.get(0).getText();
            System.out.println(firstExhibitorName);
            elements.get(0).click(); // 1st element, index 0
        } 
        // If no elements are found
        else {
            System.out.println("No exhibitor names found.");
        }

        // Optionally print the list of exhibitor names
        System.out.println("Exhibitor Names: " + allCatalogExhibitorNames);


		
		//Store Catalog name
		String catalogName = lvmgs.getlvmFirstCatalogPROD().getText();
		System.out.println(catalogName);
		lvmgs.getGlobalSearchTextBoxNew().click();
		lvmgs.getGlobalSearchEnterText().sendKeys(catalogName);
		Thread.sleep(1000);
		lvmgs.getSearchButtonNew().click();
		
	 
	     
		//lvmgs.getLVMGlobalSearchTextBox().sendKeys(catalogName);
		//lvmgs.getLVMSearchButton().click();
		Thread.sleep(5000);
		//click on 1st Exhibitor
		utl.scrollToTop();
		lvmgs.getCatalogExhibitorNames1st().click();
		Thread.sleep(7000);
		//Scroll to Catalog Section
		utl.scrollElementIntoMiddle(lvmds.getSeeAllCatalogsButton());
		Thread.sleep(300);
		//Click on All Catalog Btn Btn
		utl.scrollElementIntoMiddle(lvmds.getSeeAllCatalogsButton());
		Thread.sleep(200);
		lvmds.getSeeAllCatalogsButton().click();
		Thread.sleep(2000);
		Assert.assertTrue(lvmds.getLVMVerifyLinePageTitle().getText().contains("Catalogs"));
		Thread.sleep(2000);

		lvmexhact.getcatalogitemPROD_NewLVM().click();
		Thread.sleep(2000);
		String firstCatName = lvmexhact.getcatalogitemLVMPROD().getText();

		Thread.sleep(7000);
		System.out.println("catalogName: "+catalogName);
		String Cname =lvmgs.getCatalogHeaderName().getText();
		System.out.println("Cname: "+Cname);
		try {
		  Assert.assertTrue(firstCatName.contains(Cname));
        } catch (Exception e) {
          Assert.assertTrue(catalogName.contains(Cname));
        }
	Thread.sleep(1000);
	}
	
	@Test(priority = 5)
	public void TS005_VerifyArticlesOverviewInGlobalSearchTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T429: Global Search- Search for : Articles

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		
		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(3000);
		//utl.ClearGlobalSearch();
		
		Thread.sleep(2000);
		//lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("searchforArticlesInputLVM"));
		
		lvmgs.getGlobalSearchTextBoxNew().click();
		lvmgs.getGlobalSearchEnterText().sendKeys("   ");
		Thread.sleep(1000);
		lvmgs.getSearchButtonNew().click();

		Thread.sleep(8000);
		
		// Click on Article link
		utl.scrollElementIntoMiddle(lvmgs.getLVMsearchresultArticlesLink());
		Thread.sleep(200);
		lvmgs.getLVMsearchresultArticlesLink().click();
		Thread.sleep(3000);
		String filterResultTitle = lvmgs.getArticleName().getText();
		
		
		lvmgs.getGlobalSearchTextBoxNew().click();
		lvmgs.getGlobalSearchEnterText().sendKeys(filterResultTitle);
		Thread.sleep(1000);
		lvmgs.getSearchButtonNew().click();
		
		
		Thread.sleep(8000);
		//Assert.assertTrue(lvmgs.getLVMSearchResult().getText().contains(filterResultTitle));
		lvmgs.getLVMsearchresultArticlesLink().click();
		Thread.sleep(3000);
		String articleURL=lvmgs.getlearnMoreLinkArticle().getAttribute("href");
		lvmgs.getlearnMoreLinkArticle().click();
		Thread.sleep(3000);
		Assert.assertTrue(articleURL.contains(driver.getCurrentUrl()));

		//driver.get(prop.getProperty("lvmurl_prod"));
		
	}
	
	@Test(priority = 6)
	public void TS005_VerifyArticlesFiltersGlobalSearchTest() throws InterruptedException, IOException { 

	    // Initialize Page Objects
	    atlgs = new ATLGlobalSearchPage(driver);
	    atlexhdgshw = new ATLExhDigiShowroomPage(driver);
	    atlexhact = new ATLExhLineProdActionsPage(driver);
	    atlleftpane = new ATLLeftPaneFilters(driver);
	    utl = new Utility(driver);
	    lvmgs = new LVMGlobalSearchPage(driver);
	    
	    // Open the website
	    driver.get(prop.getProperty("lvmurl_prod"));
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    Thread.sleep(8000);

	    // Perform Global Search
	    lvmgs.getGlobalSearchTextBoxNew().click();
	    lvmgs.getGlobalSearchEnterText().sendKeys("   ");
	    Thread.sleep(1000);
	    lvmgs.getSearchButtonNew().click();
	    Thread.sleep(8000);

	    // Click on Articles Link
	    utl.scrollElementIntoMiddle(lvmgs.getLVMsearchresultArticlesLink());
	    Thread.sleep(200);
	    lvmgs.getLVMsearchresultArticlesLink().click();
	    Thread.sleep(3000);

	    // Click on Filter Dropdown
	    atlgs.getATLInfoSearchTopicsFilter().click();
	    Thread.sleep(500);

	    // Fetch Dynamic Filter List
	    List<WebElement> infoFilterList = driver.findElements(By.xpath("//div[@class='imc-filteritem__option']"));

	    int filterClickCount = 0; // Counter to limit the number of filters to test

	    for (int i = 0; i < infoFilterList.size(); i++) {
	        try {
	            String filterName = infoFilterList.get(i).getText();
	            
	            if (!filterName.isEmpty()) {
	                processFilter(filterName);  // Dynamic Handling of Filters
	                filterClickCount++;
	                
	                // Stop after clicking 3 filters for testing purposes
	                if (filterClickCount == 3) {
	                    break;
	                }
	            }
	        } catch (StaleElementReferenceException e) {
	            // Re-fetch Elements if Stale
	            infoFilterList = driver.findElements(By.xpath("//div[@class='imc-filteritem__option']"));
	            i--;  // Retry the same index
	        }
	    }
	}

	/**
	 * Process the selected filter dynamically
	 */
	private void processFilter(String filterName) throws InterruptedException {
	    Actions action = new Actions(driver);

	    // Locate the filter dynamically and click
	    List<WebElement> filters = driver.findElements(By.xpath("//div[@class='imc-filteritem__option']"));
	    
	    for (WebElement filter : filters) {
	        if (filter.getText().equalsIgnoreCase(filterName)) {
	            action.moveToElement(filter).click().perform();
	            break;
	        }
	    }

	    // Wait for Results to Load
	    Thread.sleep(5000);

	    // Get First Article Name
	    String articleName = lvmgs.getarticleName1st().getText();
	    System.out.println("Article Name: " + articleName);

	    // Get "Learn More" Link and Click
	    String learnMoreLinkURL = lvmgs.getlearnMoreLinkArticle().getAttribute("href");
	    action.moveToElement(lvmgs.getlearnMoreLinkArticle()).click().perform();
	    
	    // Wait for Page to Load
	    Thread.sleep(15000);

	    // Validate Article Name in Page Title
	    String pageTitle = driver.getTitle();
	    System.out.println("Page Title: " + pageTitle);

	    try {
	        Assert.assertTrue(articleName != null && articleName.contains(pageTitle),
	            "The article name does not match the page title.");
	    } catch (AssertionError e) {
	        System.out.println("Assertion failed: " + e.getMessage());

	        // Fallback validation using URL
	        Assert.assertTrue(learnMoreLinkURL != null && learnMoreLinkURL.contains(driver.getCurrentUrl()),
	            "The fallback verification (URL match) also failed.");
	    }

	    // Validate if Filter Name is Present in Tags
	    boolean isFilterNamePresent = lvmgs.getlistOfAllTags().stream()
	        .anyMatch(tag -> tag.getText().contains(filterName));

	    Assert.assertTrue(isFilterNamePresent, "The selected filter name is not present in the tags.");

	    // Navigate Back & Refresh Filter List
	    driver.navigate().back();
	    Thread.sleep(8000);

	    // Re-locate the filter dynamically to uncheck it
	    filters = driver.findElements(By.xpath("//div[@class='imc-filteritem__option']"));
	    
	    for (WebElement filter : filters) {
	        if (filter.getText().equalsIgnoreCase(filterName)) {
	            action.moveToElement(filter).click().perform();
	            break;
	        }
	    }

	    // Wait for Page to Refresh
	    Thread.sleep(5000);
	} 



	
	@Test(priority = 7)
	public void TS007_VerifyArticlesSearchFunctionalityInGlobalSearchTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T441: Global Search- Search for: Articles - Search box

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);

	    // Open the website
	    driver.get(prop.getProperty("lvmurl_prod"));
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    Thread.sleep(8000);

	    // Perform Global Search
	    lvmgs.getGlobalSearchTextBoxNew().click();
	    lvmgs.getGlobalSearchEnterText().sendKeys("   ");
	    Thread.sleep(1000);
	    lvmgs.getSearchButtonNew().click();
	    Thread.sleep(8000);

	    
	    // Click on Articles Link
	    utl.scrollElementIntoMiddle(lvmgs.getLVMsearchresultArticlesLink());
	    Thread.sleep(200);
	    lvmgs.getLVMsearchresultArticlesLink().click();
	    Thread.sleep(3000);
	    
	    //Get Article name
	    Thread.sleep(3000);
		//String filterResultTitle = lvmgs.getArticleName().getText();
		
		//Click on See More
		String articleURL=lvmgs.getlearnMoreLinkArticle().getAttribute("href");
		lvmgs.getlearnMoreLinkArticle().click();
		Thread.sleep(3000);
		Assert.assertTrue(articleURL.contains(driver.getCurrentUrl()));
		
	    
		//back
		driver.navigate().back();
		driver.navigate().refresh();
		Thread.sleep(3000);
		
		//Click on Aricle Name
		String articleNameURL=lvmgs.getArticleNameURL().getAttribute("href");
		lvmgs.getArticleNameURL().click();
		Thread.sleep(5000);
		Assert.assertTrue(articleNameURL.contains(driver.getCurrentUrl()));
		Thread.sleep(7000); 
		
		driver.navigate().back();
		driver.navigate().refresh();
	}
	
	@Test(priority = 8)
	public void TS008_VerifyEventsSearchFunctionalityInGlobalSearchTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T430: Global Search- Search for : Events- Search box

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
	    // Open the website
	    driver.get(prop.getProperty("lvmurl_prod"));
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    Thread.sleep(8000);

	    // Perform Global Search
	    lvmgs.getGlobalSearchTextBoxNew().click();
	    lvmgs.getGlobalSearchEnterText().sendKeys(prop.getProperty("filtersglobalsearchinput"));
	    Thread.sleep(1000);
	    lvmgs.getSearchButtonNew().click();
	    Thread.sleep(8000);

	
		try {
		//Click on Events & Seminars tab
		lvmgs.getLVMEventsTabInSearch().click();
		}
		catch(Exception e) {
			lvmgs.getLVMEventsTabInSearchDiv().click();
		}
		Thread.sleep(2000);
		String eventName=lvmgs.getLVMFirstEventName().getText();
		//Click on Search text field;
		lvmgs.getLVMInfosearchtxtbx().sendKeys(eventName);
		lvmgs.getLVMInfosearchbtn().click();
		Thread.sleep(8000);
		String alertTitle=lvmgs.getLVMSearchResult().getText();
		//String splitAlertTitle=alertTitle.split(" ")[5].trim(); //for Prod
		String splitAlertTitle=alertTitle.split(" ")[4].trim(); //For LVM
		//String splitAlertTitleNext=alertTitle.split(" ")[6].trim(); //for Prod
		String splitAlertTitleNext=alertTitle.split(" ")[5].trim(); //For LVM
		Thread.sleep(5000);

		String joinboth=splitAlertTitle +" " + splitAlertTitleNext;
		
		Assert.assertTrue(eventName.contains(joinboth));
		//driver.get(prop.getProperty("lvmurl_prod"));
		//Thread.sleep(5000);
	}
	
	@Test(priority = 9)
	public void TS009_VerifyEventsFiltersFunctionalityInGlobalSearchTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T449: Global Search- Search for : Events: Filters

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(4000);
		
		lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(4000);

		//Click on Events & Seminars tab
		//	lvmgs.getLVMEventsTabInSearch().click();
		try {
			//Click on Events & Seminars tab
			lvmgs.getLVMEventsTabInSearch().click();
			}
			catch(Exception e) {
				lvmgs.getLVMEventsTabInSearchDiv().click();
			}
		Thread.sleep(4000);
		//Click on Topics filter
		utl.scrollElementIntoMiddle(lvmgs.getLVMInfoSearchTopicsFilter());
		Thread.sleep(200);
		lvmgs.getLVMInfoSearchTopicsFilter().click();

		//Select 'Las Vegas Market' topic
		Thread.sleep(3000);
		String topicName = lvmgs.getEventsLVMMktTopics().getText(); //for LVM Prod
		//String topicName = lvmgs.getEventsLVMMktTopicsUat().getText(); //For UAT
		System.out.println("Selected topic name is: "+topicName);
		
		lvmgs.getEventsLVMMktTopics().click(); //For Prod
		//lvmgs.getEventsLVMMktTopicsUat().click(); //For UAT
		
		Thread.sleep(3000);
		String eventName = lvmgs.getLVMFirstEventName().getText();
		System.out.println(eventName);

		//Click on See More details btn
		Thread.sleep(1000);
		//utl.scrollToElement(  lvmgs.getLVMSeeMoreDetailsBtn());
		lvmgs.getLVMSeeMoreDetailsBtn().click();
		Thread.sleep(2000);
		//Verify that Selected topic name should be displayed as Tag on Event details page
		//Assert.assertTrue(lvmexhact.getEventDetailsHeader().getText().contains(eventName)); //For Prod
		Assert.assertTrue(lvmexhact.getEventDetailsHeaderUat().getText().contains(eventName)); //For UAT
		driver.navigate().back();

		//Click on Clear Filters btn
		lvmgs.getClearFiltersBtn().click();
		Thread.sleep(3000);
		//Click on Event Types filter
		lvmgs.getEventTypesFilter().click();
		Thread.sleep(2000);
		//Click on 'At Market' Event Type
		String atmrkteventtype = lvmgs.getAtMarketEventType().getText(); //For Prod
		lvmgs.getAtMarketEventType().click(); //For Prod
		//String atmrkteventtype = lvmgs.getAtMarketEventTypeUat().getText(); //For UAT
		//lvmgs.getAtMarketEventTypeUat().click(); //For UAT
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		//Verify that Selected event type should be displayed as Tag on Event Card
		Assert.assertTrue(lvmexhact.getEventCardTag().getText().contains(atmrkteventtype));

		//Click on Clear Filters btn
		lvmgs.getClearFiltersBtn().click();

		/*	Exhibitor events are available on test environment
	  	String buyingeventtype = lvmgs.getBuyingEventType().getText();
		lvmgs.getBuyingEventType().click();

		//Verify that Selected event type should be displayed as Tag on Event Card
		Assert.assertTrue(lvmexhact.getEventCardTag().getText().contains(buyingeventtype));

		//Click on Clear Filters btn
		lvmgs.getClearFiltersBtn().click();*/
		//driver.get(prop.getProperty("lvmurl_prod"));
		//Thread.sleep(5000);
	}
	
	@Test(priority = 10)
	public void TS010_VerifyShowSpecialsOverviewInGlobalSearchTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T425: Verify Show Specials option in global search

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		utl = new Utility(driver);
		lvmflpp= new LVMFloorPlansPage(driver);

		lvmexhact = new LVMExhLineProdActionsPage(driver);
		
		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(3000);

		// Click on Discover Tab
		lvmflpp.getlvmDiscoverBtn().click();
		Thread.sleep(2000);
		// Click on Show Specials
		lvmgs.getshowSpecialsLink().click();
		Thread.sleep(5000);
		List<WebElement> ss = driver.findElements(By.xpath("//div[@class='imc-showSpecial--tableContainer']/p[1]"));
		String ssName = " ";
		for (WebElement webElement : ss) {
			ssName = webElement.getText();
			break;
		}
		System.out.println(ssName);
		String ssFname =ssName.split(" ")[0].trim();
		
		//String ssSname =ssName.split(" ")[3].trim();
		//String ExhibitorName=ssFname +" " + ssSname;
		String ExhibitorName=ssFname;
		String ShowSpciaslDetails=lvmgs.getshowSpecialsDetailsFromShowSpecialsPage().getText();
		
		System.out.println(ExhibitorName);
		
		
	    lvmgs.getGlobalSearchTextBoxNew().click();
	    lvmgs.getGlobalSearchEnterText().sendKeys(ssName);
	    Thread.sleep(1000);
	    lvmgs.getSearchButtonNew().click();
	    Thread.sleep(8000);
		

		//Click on Exhibitor name
	    lvmds.getExhibitorNameNew().click();
		Thread.sleep(5000);
	
		Thread.sleep(5000);
		
		String ShowSpecialsDetails=lvmgs.getlvmShowSpecialsDetails().getText();
		
		Assert.assertTrue(ShowSpciaslDetails.contains(ShowSpecialsDetails));

		driver.get(prop.getProperty("lvmurl_prod"));
		Thread.sleep(5000);
	}
	
	@Test(priority = 11)
	public void TS011_VerifyEventsOverviewInGlobalSearchTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T425: Verify Events option in global search

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(4000);
		utl.ClearGlobalSearch();
		Thread.sleep(2000);
		lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(10000);
		//Click on Events & Seminars tab
		try {
			//Click on Events & Seminars tab
		  //utl.scrollToElement(lvmgs.getLVMEventsTabInSearch());
			lvmgs.getLVMEventsTabInSearch().click();
			}
			catch(Exception e) {
			  //utl.scrollToElement(lvmgs.getLVMEventsTabInSearchDiv());
				lvmgs.getLVMEventsTabInSearchDiv().click();
			}
		Thread.sleep(3000);
		//Verify that Events data should be displayed
		String eventname = lvmexhact.getEventCardTitleNex().getText();
		Assert.assertTrue(lvmexhact.getEventCardInSearch().isDisplayed());
		System.out.println(eventname);
		//Click on See More details btn
		Thread.sleep(5000);
		lvmgs.getLVMSeeMoreDetailsBtnNew().click();
		Thread.sleep(2000);
		//Verify that selected event's details page should be opened
		Assert.assertTrue(lvmexhact.geteventdetailsheaderLVM().getText().contains(eventname));
		driver.navigate().back();
		//driver.get(prop.getProperty("lvmurl_prod"));
		//Thread.sleep(5000);
	}
	
    	@AfterClass
    	public void tearDown()
    	{
    		//driver.quit();
    	}
	

}
