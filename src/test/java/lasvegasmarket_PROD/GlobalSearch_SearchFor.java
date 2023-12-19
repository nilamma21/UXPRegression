package lasvegasmarket_PROD;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import atlantamarket_PROD.TestListeners;
import pageObjects.LasVegasMarket.LVMExhDigiShowroomPage;
import pageObjects.LasVegasMarket.LVMExhLineProdActionsPage;
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
	
	List<WebElement> exhlist, linelist, prodlist, searchexhtypelist, searchproducttypelist, mplists, mpeditlistoptns,
	allnoteslist, favlist, searchlinetypelist, tagBlogPost, taglist, infoFilterList, catlist;
	
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
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		lap.getIUnderstandBtn().click();
		Thread.sleep(5000);
		// lap.getCloseMarktAdBtn().click();
	}
	
	@Test(priority = 1)
	public void TS001_VerifyInformationTabInGlobalSearchTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T427: Global Search- Search for: Information

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("globalsearchinputforInfoTab"));//
		//lvmgs.getLVMGlobalSearchTextBox().sendKeys("Job Board");//
		Thread.sleep(1000);
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(8000);

	// Click on Info link
		lvmgs.getLVMsearchresultInfoLink().click();
		Thread.sleep(2000);
		String infoTitle=lvmgs.infoTitle().getText();
		System.out.println(infoTitle);

		Assert.assertTrue(lvmgs.getATLSearchResult().getText().contains(prop.getProperty("globalsearchinputforInfoTab")));
		//Assert.assertTrue(lvmgs.getATLSearchResult().getText().contains("Job Board"));
		String seeMoreDetailsURL=lvmgs.getatlInfoSearchMoreInfoBtn().getAttribute("href");
	
		// Click on See More details Btn from result
		lvmgs.getatlInfoSearchMoreInfoBtn().click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains(seeMoreDetailsURL));
		// Verify Juniper Market Page
		//Assert.assertTrue(driver.getTitle().contains(infoTitle));
		
		/*			String seeMoreDetailsURL=lvmgs.getLVMInfoSearchJuniperMarketBtn().getAttribute("href");
		System.out.println(seeMoreDetailsURL);
		Thread.sleep(2000);
		// Click on See More details Btn from result
		lvmgs.getLVMInfoSearchJuniperMarketBtn().click();
		
		// Verify Juniper Market Page
		Assert.assertTrue(driver.getCurrentUrl().contains(seeMoreDetailsURL));
		*/
		driver.get(prop.getProperty("lvmurl_prod"));
		Thread.sleep(5000);
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		utl.ClearGlobalSearch();
		Thread.sleep(2000);
		lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(5000);

		// Click on Info link
		lvmgs.getLVMsearchresultInfoLink().click();
		Thread.sleep(2000);
		String FirstInfoName=lvmgs.getFirstInfoName().getText();
		System.out.println(FirstInfoName);
		lvmgs.getLVMInfosearchtxtbx().sendKeys(FirstInfoName);
		Thread.sleep(1000);
		lvmgs.getLVMInfosearchbtn().click();
		Thread.sleep(2000);
		String searchResults=lvmgs.getLVMSearchResult().getText();
		System.out.println(searchResults);
		Thread.sleep(2000);
		String searchName=searchResults.split(" ")[4].trim();
		Thread.sleep(5000);
		System.out.println(searchName);
		Assert.assertTrue(FirstInfoName.contains(searchName));

		//String seeMoreDetailsURL=lvmgs.getLVMInfoSearchJuniperMarketBtn().getAttribute("href");
		// Click on See More details Btn from result
		//lvmgs.getLVMInfoSearchJuniperMarketBtn().click();
		
		// Verify Juniper Market Page
		//Assert.assertTrue(driver.getCurrentUrl().contains(seeMoreDetailsURL));
		
		////driver.get(prop.getProperty("lvmurl_prod"));
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(10000);
		utl.ClearGlobalSearch();
		Thread.sleep(2000);
		lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(12000);
		// Click on Info link
		lvmgs.getLVMsearchresultInfoLink().click();
		// click on Topics filter
		Thread.sleep(2000);
		lvmgs.getLVMInfoSearchTopicsFilter().click();
		Thread.sleep(3000);
		infoFilterList = driver.findElements(By.xpath("//div[@class='imc-filteritem__option']"));
		//taglist = driver.findElements(By.xpath("(//div[@class='imc-articlecard__tags imc-gallery__item'])[1]/ul/li/button"));

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
					lvmgs.getLVMInfoSearchSeeMoreDetailsBtn().click();
					Thread.sleep(5000);
					Assert.assertTrue(lvmgs.getLVMExhibitorHeader().getText().contains("Exhibitors & Products"));
					driver.navigate().back();
					Thread.sleep(5000);
					infoFilterList.get(i).click();
					break;
	
				/*	for (int l = 0; l < taglist.size(); l++) {
						utl.scrollToElement(taglist.get(l));
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
		Thread.sleep(5000);
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
		utl.ClearGlobalSearch();
		lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(5000);
		/*Assert.assertTrue(lvmgs.getLVMSearchResult().getText().contains(prop.getProperty("searchforCatalogsInput")));
		// Click on Matching Products-See All link for 1st Exhibitor
		lvmexhact.getMatchingProdSeeAllLink().click();
		Thread.sleep(5000);
		//Click on Catalogs tab
		try {
		lvmexhact.getCatalogsTab().click();
		Thread.sleep(2000);
		lvmexhact.getCatalogsTab().click();
		}
		catch(Exception e) {
			lvmexhact.getcatalogstabDiv().click();
			Thread.sleep(2000);
			lvmexhact.getcatalogstabDiv().click();
		}

		//Verify that Catalog item should be displayed
		Assert.assertTrue(lvmexhact.getCatalogsItem().isDisplayed());

		//Click on Catalog item
		String catalogName = lvmexhact.getCatalogsItem().getText();
		System.out.println(catalogName);
		
		lvmexhact.getCatalogsItem().click();
		Thread.sleep(2000);
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(5000);
		Assert.assertTrue(driver.getTitle().contains("Catalog View"));
		String Cname =lvmgs.getCatalogHeaderName().getText();
		Assert.assertTrue(catalogName.contains(Cname));
		Assert.assertTrue(catalogName.startsWith(Cname));

		driver.close();
		driver.switchTo().window(winHandleBefore);
		driver.get(prop.getProperty("lvmmrkturl_prod"));
		Thread.sleep(5000);*/
		
		//Click on DG showroom filter
		utl.scrollToElement(lvmexhact.getleftPaneFilterDGShowroom());
		lvmexhact.getleftPaneFilterDGShowroom().click();
		Thread.sleep(3000);
		//Click on Catalog sub filter
		utl.scrollToElement(lvmexhact.getleftPaneFilterDGShowroomCatalog());
		lvmexhact.getleftPaneFilterDGShowroomCatalog().click();
		Thread.sleep(3000);
		//Store Catalog name
		String catalogName = lvmgs.getFirstCatalogName().getText();
		System.out.println(catalogName);
		//click on 1st Exhibitor
		utl.scrollToElement(lvmgs.getlvm1STExhiName());
		lvmgs.getlvm1STExhiName().click();
		Thread.sleep(5000);
		//Scroll to Catalog Section
		utl.scrollToElement(lvmds.getSeeAllCatalogsButton());
		//Click on All Catalog Btn Btn
		lvmds.getSeeAllCatalogsButton().click();
		Thread.sleep(2000);
		Assert.assertTrue(lvmds.getLVMVerifyLinePageTitle().getText().contains("Catalogs"));
		Thread.sleep(2000);
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		//Click on Catalog
		//lvmexhact.getcatalogitemPROD_LVM().click();
		catlist = lvmexhact.getlistCatalogitemPROD();
			for(int i=0; i<catlist.size(); i++) {
				String catName = catlist.get(i).getText();
				if(catName.equalsIgnoreCase(catalogName)) {
				  utl.scrollToElement(catlist.get(i));
					catlist.get(i).click();
					break;
				}
			}
		Thread.sleep(2000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(7000);
		String Cname =lvmgs.getCatalogHeaderName().getText();
		System.out.println(Cname);
		Assert.assertTrue(catalogName.contains(Cname));
		driver.close();
		driver.switchTo().window(winHandleBefore);
		//driver.get(prop.getProperty("lvmurl_prod"));
		Thread.sleep(5000);
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		utl.ClearGlobalSearch();
		Thread.sleep(2000);
		lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("searchforArticlesInputLVM"));
		Thread.sleep(500);
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(8000);

		// Click on Article link
		lvmgs.getLVMsearchresultArticlesLink().click();
		Thread.sleep(3000);
		Assert.assertTrue(lvmgs.getLVMSearchResult().getText().contains(prop.getProperty("searchforArticlesInputLVM")));
		String filterResultTitle = lvmgs.getLVMArticleName().getText();
		utl.scrollToElement(lvmgs.getLVMArticleSeeMoreBtn());
		lvmgs.getLVMArticleSeeMoreBtn().click();
		Thread.sleep(3000);
		Assert.assertTrue(filterResultTitle.contains(lvmgs.getLVMArticleHeader().getText()));
		utl.scrollToElement(lvmgs.getLVMArticleTag());
		boolean temp = false;
		Thread.sleep(2000);
		tagBlogPost = driver.findElements(By.xpath("//span[@class='imc-blog-tag-module__tag']"));
		for (WebElement blogPost : tagBlogPost) {
			if (blogPost.getText().contains(prop.getProperty("searchforArticlesInputLVM"))) {
				temp = true;
				break;
			}
		}
		Thread.sleep(2000);
		Assert.assertTrue(temp);
		//driver.get(prop.getProperty("lvmurl_prod"));
		Thread.sleep(5000);
	}
	
	@Test(priority = 6)
	public void TS006_VerifyArticlesFiltersFunctionalityInGlobalSearchTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T440: Global Search- Search for : Articles : Filters

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		lvmleftpane = new LVMLeftPaneFilters(driver);
		utl = new Utility(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		utl.ClearGlobalSearch();
		Thread.sleep(2000);
		lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(6000);

		// Click on Articles link
		lvmgs.getLVMsearchresultArticlesLink().click();
		// click on Topics filter
		Thread.sleep(5000);
		lvmgs.getLVMInfoSearchTopicsFilter().click();
		Thread.sleep(2000);
		infoFilterList = driver.findElements(By.xpath("//div[@class='imc-filteritem__option']"));

		for (int i = 0; i < infoFilterList.size(); i++) {
			try {
				String f = infoFilterList.get(i).getText();
				switch (f) {
				/*case "Blog Post":
					infoFilterList.get(i).click();
					driver.navigate().refresh();
					Thread.sleep(5000);
					String filterResultTitle = lvmgs.getLVMArticleName().getText();
					lvmgs.getLVMArticleSeeMoreBtn().click();
					Assert.assertTrue(filterResultTitle.contains(lvmgs.getLVMArticleHeader().getText()));
					utl.scrollToElement(lvmgs.getLVMArticleTag());
					boolean temp = false;
					tagBlogPost = driver.findElements(By.xpath("//span[@class='imc-blog-tag-module__tag']"));
					for (WebElement blogPost : tagBlogPost) {
						if (blogPost.getText().equals(f)) {
							temp = true;
							break;
						}
					}
					Assert.assertTrue(temp);
					driver.navigate().back();
					Thread.sleep(5000);
					try {
						infoFilterList.get(i).click();
					} catch (StaleElementReferenceException e) {
						infoFilterList = driver.findElements(By.xpath("//div[@class='imc-filteritem__option']"));
						infoFilterList.get(i).click();
						lvmgs.getLVMInfoSearchTopicsFilter().click();
					}
					break;*/

				case "Atlanta Market":
					infoFilterList.get(i).click();
					Thread.sleep(5000);
					driver.navigate().refresh();
					Thread.sleep(3000);
					String filterResultTitle1 = lvmgs.getLVMArticleName().getText();
					lvmgs.getLVMArticleSeeMoreBtn().click();
					Thread.sleep(2000);
					Assert.assertTrue(filterResultTitle1.contains(lvmgs.getLVMArticleHeader().getText()));
					utl.scrollToElement(lvmgs.getLVMArticleTag());
					boolean temp1 = false;
					tagBlogPost = driver.findElements(By.xpath("//span[@class='imc-blog-tag-module__tag']"));
					for (WebElement blogPost : tagBlogPost) {
						if (blogPost.getText().equals(f)) {
							temp1 = true;
							break;
						}
					}
					Assert.assertTrue(temp1);
					driver.navigate().back();
					Thread.sleep(5000);
					try {
						infoFilterList.get(i).click();
					} catch (StaleElementReferenceException e) {
						infoFilterList = driver.findElements(By.xpath("//div[@class='imc-filteritem__option']"));
						infoFilterList.get(i).click();
						lvmgs.getLVMInfoSearchTopicsFilter().click();
					}
					break;
				case "Shop The Show":
					infoFilterList.get(i).click();
					Thread.sleep(5000);
					driver.navigate().refresh();
					Thread.sleep(500);
					String filterResultTitle2 = lvmgs.getLVMArticleName().getText();
					lvmgs.getLVMArticleSeeMoreBtn().click();
					Thread.sleep(500);
					Assert.assertTrue(filterResultTitle2.contains(lvmgs.getLVMArticleHeader().getText()));
					utl.scrollToElement(lvmgs.getLVMArticleTag());
					boolean temp2 = false;
					List<WebElement>tagBlogPost1 = driver.findElements(By.xpath("//span[@class='imc-blog-tag-module__tag']"));
					for (WebElement blogPost : tagBlogPost1) {
						if (blogPost.getText().equalsIgnoreCase(f)) {
							temp2 = true;
							break;
						}
					}
					Assert.assertTrue(temp2);
					driver.navigate().back();
					Thread.sleep(5000);
					try {
						infoFilterList.get(i).click();
					} catch (StaleElementReferenceException e) {
						infoFilterList = driver.findElements(By.xpath("//div[@class='imc-filteritem__option']"));
						infoFilterList.get(i).click();
						lvmgs.getLVMInfoSearchTopicsFilter().click();
					}
					break;
				case "Press Release":
					infoFilterList.get(i).click();
					Thread.sleep(5000);
					driver.navigate().refresh();
					Thread.sleep(2000);
					String filterResultTitle3 = lvmgs.getLVMArticleName().getText();
					utl.scrollToElement(lvmgs.getLVMArticleSeeMoreBtn());
					lvmgs.getLVMArticleSeeMoreBtn().click();
					Thread.sleep(2000);
					Assert.assertTrue(filterResultTitle3.contains(lvmgs.getLVMArticleHeader().getText()));
					utl.scrollToElement(lvmgs.getLVMArticleTag());
					boolean temp3 = false;
					tagBlogPost = driver.findElements(By.xpath("//span[@class='imc-blog-tag-module__tag']"));
					for (WebElement blogPost : tagBlogPost) {
						if (blogPost.getText().equals(f)) {
							temp3 = true;
							System.out.println("In Side 3::"+temp3);
							break;
						}
					}
					Assert.assertTrue(temp3);
					driver.navigate().back();
					Thread.sleep(5000);
					try {
						infoFilterList.get(i).click();
					} catch (StaleElementReferenceException e) {
						infoFilterList = driver.findElements(By.xpath("//div[@class='imc-filteritem__option']"));
						utl.scrollToElement(infoFilterList.get(i));
						infoFilterList.get(i).click();
						utl.scrollToElement(lvmgs.getLVMInfoSearchTopicsFilter());
						lvmgs.getLVMInfoSearchTopicsFilter().click();
					}
					break;
				case "Fall Design Week":
					//Thread.sleep(10000);
				    utl.scrollToElement(infoFilterList.get(i));
					infoFilterList.get(i).click();
					Thread.sleep(10000);
					driver.navigate().refresh();
					Thread.sleep(8000);
					String filterResultTitle4 = lvmgs.getLVMArticleName().getText();
					lvmgs.getLVMArticleSeeMoreBtn().click();
					Thread.sleep(2000);
					Assert.assertTrue(filterResultTitle4.contains(lvmgs.getLVMArticleHeader().getText()));
					utl.scrollToElement(lvmgs.getLVMArticleTag());
					boolean temp4 = false;
					tagBlogPost = driver.findElements(By.xpath("//span[@class='imc-blog-tag-module__tag']"));
					for (WebElement blogPost : tagBlogPost) {
						if (blogPost.getText().equals(f)) {
							temp4 = true;
							break;
						}
					}
					Assert.assertTrue(temp4);
					driver.navigate().back();
					Thread.sleep(5000);
					try {
						infoFilterList.get(i).click();
					} catch (StaleElementReferenceException e) {
					  Thread.sleep(1000);
						infoFilterList = driver.findElements(By.xpath("//div[@class='imc-filteritem__option']"));
						infoFilterList.get(i).click();
						//lvmgs.getLVMInfoSearchTopicsFilter().click();
					}
					break;
				case "Market Snapshot":
				  Thread.sleep(500);
				  utl.scrollToElement(infoFilterList.get(i));
					infoFilterList.get(i).click();
					Thread.sleep(5000);
					driver.navigate().refresh();
					Thread.sleep(1000);
					String filterResultTitle5 = lvmgs.getLVMArticleName().getText();
					utl.scrollToElement(lvmgs.getLVMArticleSeeMoreBtn());
					lvmgs.getLVMArticleSeeMoreBtn().click();
					Thread.sleep(2000);
					Assert.assertTrue(filterResultTitle5.contains(lvmgs.getLVMArticleHeader().getText()));
					utl.scrollToElement(lvmgs.getLVMArticleTag());
					boolean temp5 = false;
					tagBlogPost = driver.findElements(By.xpath("//span[@class='imc-blog-tag-module__tag']"));
					for (WebElement blogPost : tagBlogPost) {
						if (blogPost.getText().equals(f)) {
							temp5 = true;
							break;
						}
					}
					Assert.assertTrue(temp5);
					driver.navigate().back();
					Thread.sleep(5000);
					try {
						infoFilterList.get(i).click();
					} catch (StaleElementReferenceException e) {
						infoFilterList = driver.findElements(By.xpath("//div[@class='imc-filteritem__option']"));
						utl.scrollToElement(infoFilterList.get(i));
						infoFilterList.get(i).click();
						utl.scrollToElement(lvmgs.getLVMInfoSearchTopicsFilter());
						lvmgs.getLVMInfoSearchTopicsFilter().click();
					}
					break;
				case "Press Releases":
				  utl.scrollToElement(infoFilterList.get(i));
					infoFilterList.get(i).click();
					Thread.sleep(5000);
					driver.navigate().refresh();
					Thread.sleep(1000);
					String filterResultTitle6 = lvmgs.getLVMArticleName().getText();
					utl.scrollToElement(lvmgs.getLVMArticleSeeMoreBtn());
					lvmgs.getLVMArticleSeeMoreBtn().click();
					Thread.sleep(1000);
					Assert.assertTrue(filterResultTitle6.contains(lvmgs.getLVMArticleHeader().getText()));
					utl.scrollToElement(lvmgs.getLVMArticleTag());
					Thread.sleep(5000);
					boolean temp6 = false;
					tagBlogPost = driver.findElements(By.xpath("//span[@class='imc-blog-tag-module__tag']"));
					for (WebElement blogPost : tagBlogPost) {
						if (blogPost.getText().equals(f)) {
							temp6 = true;
							break;
						}
					}
					Assert.assertTrue(temp6);
					driver.navigate().back();
					Thread.sleep(5000);
					try {
						infoFilterList.get(i).click();
					} catch (StaleElementReferenceException e) {
						infoFilterList = driver.findElements(By.xpath("//div[@class='imc-filteritem__option']"));
						utl.scrollToElement(infoFilterList.get(i));
						infoFilterList.get(i).click();
						Thread.sleep(3000);
						utl.scrollToElement(lvmgs.getLVMInfoSearchTopicsFilter());
						lvmgs.getLVMInfoSearchTopicsFilter().click();
					}
					break;

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

		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(4000);
		utl.ClearGlobalSearch();
		Thread.sleep(4000);
		lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(5000);
		// Click on Info link
		lvmgs.getLVMsearchresultArticlesLink().click();
		Thread.sleep(2000);
		lvmgs.getLVMInfosearchtxtbx().sendKeys(prop.getProperty("searchforArticlesInputLVM"));
		Thread.sleep(1000);
		lvmgs.getLVMInfosearchbtn().click();

		Thread.sleep(5000);
		System.out.println(lvmgs.getLVMSearchResult().getText());
		System.out.println(prop.getProperty("searchforArticlesInput"));
		Thread.sleep(1000);
		Assert.assertTrue(lvmgs.getLVMSearchResult().getText().contains(prop.getProperty("searchforArticlesInputLVM")));

		driver.navigate().refresh();

		String filterResultTitle = lvmgs.getLVMArticleName().getText();
		utl.scrollToElement(lvmgs.getLVMArticleSeeMoreBtn());
		lvmgs.getLVMArticleSeeMoreBtn().click();
		Thread.sleep(2000);
		Assert.assertTrue(filterResultTitle.contains(lvmgs.getLVMArticleHeader().getText()));
		utl.scrollToElement(lvmgs.getLVMArticleTag());
		boolean temp5 = false;
		tagBlogPost = driver.findElements(By.xpath("//span[@class='imc-blog-tag-module__tag']"));
		for (WebElement blogPost : tagBlogPost) {
			if (blogPost.getText().contains(prop.getProperty("searchforArticlesInputLVM"))) {
				temp5 = true;
				break;
			}
		}
		Assert.assertTrue(temp5);
		//driver.get(prop.getProperty("lvmurl_prod"));
		Thread.sleep(5000);
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		utl.ClearGlobalSearch();
		Thread.sleep(4000);
		lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(15000);
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
		Thread.sleep(5000);
	}
	
	@Test(priority = 9)
	public void TS009_VerifyEventsFiltersFunctionalityInGlobalSearchTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T449: Global Search- Search for : Events: Filters

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
		utl.scrollToElement(  lvmgs.getLVMSeeMoreDetailsBtn());
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

		lvmexhact = new LVMExhLineProdActionsPage(driver);
		
		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);

		// click on Exhibitors And Product Tab
		lvmgs.getlvmExhibitorsAndProductTab().click();
		Thread.sleep(2000);
		// Click on Show Specials
		lvmgs.getlvmShowSpecialsLink().click();
		Thread.sleep(5000);
		List<WebElement> ss = driver.findElements(By.xpath("//div[@class='imc-showSpecial--tableContainer']/p[1]"));
		String ssName = " ";
		for (WebElement webElement : ss) {
			ssName = webElement.getText();
			break;
		}
		System.out.println(ssName);
		String ssFname =ssName.split(" ")[2].trim();
		
		//String ssSname =ssName.split(" ")[3].trim();

		//String ExhibitorName=ssFname +" " + ssSname;
		String ExhibitorName=ssFname;

		String ShowSpciaslDetails=lvmgs.getlvmShowSpecialsDetailsOnShowSpecialsPage().getText();
		
		System.out.println(ExhibitorName);
		
		utl.ClearGlobalSearch();
		lvmgs.getLVMGlobalSearchTextBox().sendKeys(ExhibitorName);
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(5000);

		/*lvmgs.getseeAllLinkMatchingProduct().click();
		//lvmgs.getseeAllLinkMatchingProduct().click();
		Thread.sleep(5000);

		lvmgs.getlvmShowSpecialsTab().click();
*/
		//Click on Exhibitor name
		lvmexhact.getExhibitorName().click();
		//Verify Show Specials section
		//Assert.assertTrue(lvmgs.getlvmVerifyShowSpecials().isDisplayed());
		Thread.sleep(5000);
		Assert.assertTrue(lvmgs.getthirdThbreadCrumbtxt().getText().contains(ExhibitorName));
		utl.scrollToElement(lvmgs.getlvmShowSpecialsSection());
		String ShowSpecialsDetails=lvmgs.getlvmShowSpecialsDetails().getText();
		
		Assert.assertTrue(ShowSpciaslDetails.contains(ShowSpecialsDetails));

		////driver.get(prop.getProperty("lvmurl_prod"));
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(4000);
		utl.ClearGlobalSearch();
		Thread.sleep(2000);
		lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(10000);
		//Click on Events & Seminars tab
		try {
			//Click on Events & Seminars tab
		  utl.scrollToElement(lvmgs.getLVMEventsTabInSearch());
			lvmgs.getLVMEventsTabInSearch().click();
			}
			catch(Exception e) {
			  utl.scrollToElement(lvmgs.getLVMEventsTabInSearchDiv());
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
		////driver.get(prop.getProperty("lvmurl_prod"));
		Thread.sleep(5000);
	}
	
    	@AfterClass
    	public void tearDown()
    	{
    		//driver.quit();
    	}

}
