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
	allnoteslist, favlist, searchlinetypelist, tagBlogPost, taglist, infoFilterList;
	
	@BeforeClass
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		// chromeVersion();
		utl = new Utility(driver);
		lap = new LVMLandingPage(driver);
		// Navigate to LasVegas Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("lvmurl_prod"));
		//driver.get(prop.getProperty("lvmurl_prod"));
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
		Thread.sleep(1000);
		lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("exhibitor5"));//globalsearchinputforInformation
		Thread.sleep(2000);
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(5000);

		// Click on Info link
		lvmgs.getLVMsearchresultInfoLink().click();
		Thread.sleep(3000);
		System.out.println(lvmgs.getLVMSearchResult().getText());
		Assert.assertTrue(lvmgs.getLVMSearchResult().getText().contains(prop.getProperty("exhibitor5")));//globalsearchinputforInformation

		String seeMoreDetailsURL=lvmgs.getLVMInfoSearchJuniperMarketBtn().getAttribute("href");
		System.out.println(seeMoreDetailsURL);
		Thread.sleep(2000);
		// Click on See More details Btn from result
		lvmgs.getLVMInfoSearchJuniperMarketBtn().click();
		
		// Verify Juniper Market Page
		Assert.assertTrue(driver.getCurrentUrl().contains(seeMoreDetailsURL));
		
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
		
		driver.navigate().refresh();
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

		
		String seeMoreDetailsURL=lvmgs.getLVMInfoSearchJuniperMarketBtn().getAttribute("href");
		// Click on See More details Btn from result
		lvmgs.getLVMInfoSearchJuniperMarketBtn().click();
		

		// Verify Juniper Market Page
		Assert.assertTrue(driver.getCurrentUrl().contains(seeMoreDetailsURL));
		
		driver.get(prop.getProperty("lvmurl_prod"));
		Thread.sleep(5000);
	}
	
	@Test(priority = 12)
	public void TS003_VerifyInformationFiltersFunctionalityInGlobalSearchTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T437: Global Search- Search for: Information -Filters

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);
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

		infoFilterList = driver.findElements(By.xpath("//div[@class='imc-filteritem__option']"));
		taglist = driver.findElements(By.xpath("//div[@class='imc-content--border imc-vr--xlarge imc-informationcard'][1]/div/div/div[2]/ul/li/button"));

		for (int i = 0; i < infoFilterList.size(); i++) {
			try {
				String f = infoFilterList.get(i).getText();
				switch (f) {
				case "Atlanta Market":
					infoFilterList.get(i).click();
					Thread.sleep(5000);
					for (int j = 0; j < taglist.size(); j++) {
						Assert.assertTrue(taglist.get(j).getText().contains("Atlanta Market"));
						break;
					}
					infoFilterList.get(i).click();
					break;
				case "Market Snapshot":
					infoFilterList.get(i).click();
					Thread.sleep(5000);
					for (int k = 1; k < taglist.size(); k++) {
						Assert.assertTrue(taglist.get(k).getText().contains("Market Snapshot"));
						break;
					}
					infoFilterList.get(i).click();
					break;
				case "Exhibitors":
					infoFilterList.get(i).click();
					Thread.sleep(5000);
					for (int l = 0; l < taglist.size(); l++) {
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
					break;
				default:
					break;
				}
			} catch (StaleElementReferenceException e) {
				infoFilterList = driver.findElements(By.xpath("//div[@class='imc-filteritem__option']"));
				String f = infoFilterList.get(i).getText();
			}
		}
		driver.get(prop.getProperty("lvmurl_prod"));
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
		lvmexhact.getleftPaneFilterDGShowroom().click();
		Thread.sleep(3000);
		//Click on Catalog sub filter
		lvmexhact.getleftPaneFilterDGShowroomCatalog().click();
		Thread.sleep(3000);
		//Store Catalog name
		String catalogName = lvmgs.getFirstCatalogName().getText();
		System.out.println(catalogName);
		//click on 1st Exhibitor
		lvmgs.getlvm1STExhiName().click();
		Thread.sleep(3000);
		//Scroll to Catalog Section
		utl.scrollToElement(lvmds.getLVMCatalogSection());
		//Click on All Catalog Btn Btn
		lvmds.getLVMCatalogSeeAllBtn().click();
		Assert.assertTrue(lvmds.getLVMVerifyLinePageTitle().getText().contains("Catalogs"));
		Thread.sleep(2000);
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		//Click on Catalog
		//lvmexhact.getCatalogsItem().click();//For Prod
		lvmexhact.getCatalogsItemNew().click();//For UAT
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(5000);
		String Cname =lvmgs.getCatalogHeaderName().getText();
		System.out.println(Cname);
		Assert.assertTrue(catalogName.contains(Cname));
		driver.close();
		driver.switchTo().window(winHandleBefore);
		driver.get(prop.getProperty("lvmurl_prod"));
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
		
		driver.navigate().refresh();
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
		driver.get(prop.getProperty("lvmurl_prod"));
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		utl.ClearGlobalSearch();
		Thread.sleep(2000);
		lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(6000);

		// Click on Articles link
		lvmgs.getLVMsearchresultArticlesLink().click();
		// click on Topics filter
		Thread.sleep(2000);
		lvmgs.getLVMInfoSearchTopicsFilter().click();
		infoFilterList = driver.findElements(By.xpath("//div[@class='imc-filteritem__option']"));

		for (int i = 0; i < infoFilterList.size(); i++) {
			try {
				String f = infoFilterList.get(i).getText();
				switch (f) {
				case "Blog Post":
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
					break;

				case "Atlanta Market":
					infoFilterList.get(i).click();
					Thread.sleep(5000);
					driver.navigate().refresh();

					String filterResultTitle1 = lvmgs.getLVMArticleName().getText();
					lvmgs.getLVMArticleSeeMoreBtn().click();

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

					String filterResultTitle2 = lvmgs.getLVMArticleName().getText();
					lvmgs.getLVMArticleSeeMoreBtn().click();

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

					String filterResultTitle3 = lvmgs.getLVMArticleName().getText();
					lvmgs.getLVMArticleSeeMoreBtn().click();

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
						infoFilterList.get(i).click();
						lvmgs.getLVMInfoSearchTopicsFilter().click();
					}
					break;
				case "Fall Design Week":
					//Thread.sleep(10000);
					infoFilterList.get(i).click();
					Thread.sleep(10000);
					driver.navigate().refresh();
					Thread.sleep(8000);
					String filterResultTitle4 = lvmgs.getLVMArticleName().getText();
					lvmgs.getLVMArticleSeeMoreBtn().click();
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
						infoFilterList = driver.findElements(By.xpath("//div[@class='imc-filteritem__option']"));
						infoFilterList.get(i).click();
						lvmgs.getLVMInfoSearchTopicsFilter().click();
					}
					break;
				case "Market Snapshot":
					infoFilterList.get(i).click();
					Thread.sleep(5000);
					driver.navigate().refresh();

					String filterResultTitle5 = lvmgs.getLVMArticleName().getText();
					lvmgs.getLVMArticleSeeMoreBtn().click();

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
						infoFilterList.get(i).click();
						lvmgs.getLVMInfoSearchTopicsFilter().click();
					}
					break;
				case "Press Releases":
					infoFilterList.get(i).click();
					Thread.sleep(5000);
					driver.navigate().refresh();

					String filterResultTitle6 = lvmgs.getLVMArticleName().getText();
					lvmgs.getLVMArticleSeeMoreBtn().click();

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
						infoFilterList.get(i).click();
						lvmgs.getLVMInfoSearchTopicsFilter().click();
					}
					break;

				default:
					break;
				}
			} catch (StaleElementReferenceException e) {
				infoFilterList = driver.findElements(By.xpath("//div[@class='imc-filteritem__option']"));
				String f = infoFilterList.get(i).getText();
			}
		}
		driver.get(prop.getProperty("lvmurl_prod"));
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		utl.ClearGlobalSearch();
		Thread.sleep(4000);
		lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(5000);
		// Click on Info link
		lvmgs.getLVMsearchresultArticlesLink().click();
		Thread.sleep(2000);
		lvmgs.getLVMInfosearchtxtbx().sendKeys(prop.getProperty("searchforArticlesInputLVM"));
		Thread.sleep(500);
		lvmgs.getLVMInfosearchbtn().click();

		Thread.sleep(5000);
		System.out.println(lvmgs.getLVMSearchResult().getText());
		System.out.println(prop.getProperty("searchforArticlesInput"));
		Thread.sleep(1000);
		Assert.assertTrue(lvmgs.getLVMSearchResult().getText().contains(prop.getProperty("searchforArticlesInputLVM")));

		driver.navigate().refresh();

		String filterResultTitle = lvmgs.getLVMArticleName().getText();
		lvmgs.getLVMArticleSeeMoreBtn().click();

		Assert.assertTrue(filterResultTitle.contains(lvmgs.getLVMArticleHeader().getText()));
		utl.scrollToElement(lvmgs.getLVMArticleTag());
		boolean temp5 = false;
		tagBlogPost = driver.findElements(By.xpath("//span[@class='imc-blog-tag-module__tag']"));
		for (WebElement blogPost : tagBlogPost) {
			if (blogPost.getText().equals(prop.getProperty("searchforArticlesInput"))) {
				temp5 = true;
				break;
			}
		}
		Assert.assertTrue(temp5);
		driver.get(prop.getProperty("lvmurl_prod"));
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
		driver.get(prop.getProperty("lvmurl_prod"));
		Thread.sleep(5000);
	}
	
	@Test(priority = 9)
	public void TS009_VerifyEventsFiltersFunctionalityInGlobalSearchTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T449: Global Search- Search for : Events: Filters

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);

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
		Thread.sleep(1000);
		//String topicName = lvmgs.getEventsLVMMktTopics().getText(); //for LVM Prod
		String topicName = lvmgs.getEventsLVMMktTopicsUat().getText(); //For UAT
		System.out.println("Selected topic name is: "+topicName);
		
		//lvmgs.getEventsLVMMktTopics().click(); //For Prod
		lvmgs.getEventsLVMMktTopicsUat().click(); //For UAT
		
		Thread.sleep(3000);
		String eventName = lvmgs.getLVMFirstEventName().getText();
		System.out.println(eventName);

		//Click on See More details btn
		Thread.sleep(1000);
		lvmgs.getLVMSeeMoreDetailsBtn().click();

		//Verify that Selected topic name should be displayed as Tag on Event details page
		//Assert.assertTrue(lvmexhact.getEventDetailsHeader().getText().contains(eventName)); //For Prod
		Assert.assertTrue(lvmexhact.getEventDetailsHeaderUat().getText().contains(eventName)); //For UAT
		driver.navigate().back();

		//Click on Clear Filters btn
		lvmgs.getClearFiltersBtn().click();

		//Click on Event Types filter
		lvmgs.getEventTypesFilter().click();

		//Click on 'At Market' Event Type
		//String atmrkteventtype = lvmgs.getAtMarketEventType().getText(); //For Prod
		//lvmgs.getAtMarketEventType().click(); //For Prod
		String atmrkteventtype = lvmgs.getAtMarketEventTypeUat().getText(); //For UAT
		lvmgs.getAtMarketEventTypeUat().click(); //For UAT
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
		driver.get(prop.getProperty("lvmurl_prod"));
		Thread.sleep(5000);
	}
	
	@Test(priority = 10)
	public void TS010_VerifyShowSpecialsOverviewInGlobalSearchTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T425: Verify Show Specials option in global search

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		utl = new Utility(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		utl.ClearGlobalSearch();
		lvmgs.getLVMGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinputforShowSpecials2")));
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(5000);

		lvmgs.getseeAllLinkMatchingProduct().click();
		//lvmgs.getseeAllLinkMatchingProduct().click();
		Thread.sleep(5000);

		lvmgs.getlvmShowSpecialsTab().click();

		//Verify Show Specials section
		Assert.assertTrue(lvmgs.getlvmVerifyShowSpecials().isDisplayed());
		Thread.sleep(5000);
		Assert.assertTrue(lvmgs.getFourthBreadcrumbTxtInApp().getText().contains("Specials"));
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
			lvmgs.getLVMEventsTabInSearch().click();
			}
			catch(Exception e) {
				lvmgs.getLVMEventsTabInSearchDiv().click();
			}

		//Verify that Events data should be displayed
		String eventname = lvmexhact.getEventCardTitleNex().getText();
		Assert.assertTrue(lvmexhact.getEventCardInSearch().isDisplayed());
		System.out.println(eventname);
		//Click on See More details btn
		Thread.sleep(3000);
		lvmgs.getLVMSeeMoreDetailsBtnNew().click();
		
		//Verify that selected event's details page should be opened
		Assert.assertTrue(lvmexhact.getEventDetailsHeaderNew().getText().contains(eventname));
		driver.navigate().back();
		driver.get(prop.getProperty("lvmurl_prod"));
		Thread.sleep(5000);
	}
	
	@AfterClass
	public void tearDown()
	{
		//driver.quit();
	}

}
