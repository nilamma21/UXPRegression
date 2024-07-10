package atlantamarket_PROD;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
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
import pageObjects.AtlantaMarket.ATLLeftPaneFilters;
import pageObjects.AtlantaMarket.ATLLoginPage;
import pageObjects.AtlantaMarket.ATLMarketPlannerPage;
import pageObjects.AtlantaMarket.ATLProductDetailsPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

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
	ATLLeftPaneFilters atlleftpane;

	List<WebElement> exhlist, linelist, prodlist, searchexhtypelist, searchproducttypelist, mplists, mpeditlistoptns,
	allnoteslist, favlist, searchlinetypelist, tagBlogPost, taglist, infoFilterList;

	@BeforeClass(alwaysRun=true)
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		// chromeVersion();
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);

		// Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("atlmrkturl_prod"));
		//driver.get(prop.getProperty("lvmurl_prod"));
		lap.getIUnderstandBtn().click();
		Thread.sleep(5000);
		// lap.getCloseMarktAdBtn().click();
	}

	@Test(priority = 1)//groups="Non_MP"
	public void TS001_VerifyInformationTabInGlobalSearchTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T427: Global Search- Search for: Information

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		utl.loginCheckATL();
		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("globalsearchinputforInfoTab2"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(7000);

		// Click on Info link
		atlgs.getATLsearchresultInfoLink().click();
		Thread.sleep(2000);
		String infoTitle=atlgs.infoTitle().getText();
		System.out.println(infoTitle);
		Assert.assertTrue(atlgs.getATLSearchResult().getText().contains(prop.getProperty("globalsearchinputforInfoTab2")));

		String seeMoreDetailsURL=atlgs.getatlInfoSearchMoreInfoBtn().getAttribute("href");

		// Click on See More details Btn from result
		atlgs.getatlInfoSearchMoreInfoBtn().click();
		Thread.sleep(2000);

		// Verify Juniper Market Page
		//Assert.assertTrue(driver.getCurrentUrl().contains(seeMoreDetailsURL));
		Assert.assertTrue(driver.getCurrentUrl().contains(infoTitle));
		Thread.sleep(2000);
	}

	@Test(priority = 2)//groups="Non_MP"
	public void TS002_VerifyInformationSearchFunctionalityInGlobalSearchTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T439: Global Search- Search for: Information - Search box

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		
		driver.get(prop.getProperty("atlmrkturl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		utl.ClearGlobalSearch();
		
		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(8000);

		// Click on Info link
		utl.scrollElementIntoMiddle(atlgs.getATLsearchresultInfoLink());
		Thread.sleep(200);
		atlgs.getATLsearchresultInfoLink().click();
		Thread.sleep(8000);
		
		utl.scrollElementIntoMiddle(atlgs.getATLInfosearchtxtbxClr());
		Thread.sleep(200);
		String FirstInfoName=atlgs.getFirstInfoName().getText();
		atlgs.getATLInfosearchtxtbxClr().click();
		Thread.sleep(2000);
		atlgs.getATLInfosearchtxtbx().sendKeys(FirstInfoName);
		atlgs.getATLInfosearchbtn().click();
		Thread.sleep(2000);
		String searchResults=atlgs.getATLSearchResult().getText();
		System.out.println(searchResults);
		Thread.sleep(2000);
		String searchName=searchResults.split(" ")[4].trim();
		Thread.sleep(5000);
		System.out.println(searchName);
		Assert.assertTrue(FirstInfoName.contains(searchName));

		String seeMoreDetailsURL=atlgs.getatlInfoSearchMoreInfoBtn().getAttribute("href");
		// Click on See More details Btn from result
		utl.scrollElementIntoMiddle(atlgs.getatlInfoSearchMoreInfoBtn());
		Thread.sleep(200);
		atlgs.getatlInfoSearchMoreInfoBtn().click();
		Thread.sleep(5000);
		System.out.println("First Info Name: "+FirstInfoName);
		// Verify Juniper Market Page
		System.out.println("Page title: "+driver.getTitle());
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(FirstInfoName));
		Thread.sleep(2000);
	}

	@Test(priority = 3)//groups="Non_MP"
	public void TS003_VerifyInformationFiltersFunctionalityInGlobalSearchTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T437: Global Search- Search for: Information -Filters

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		
		driver.get(prop.getProperty("atlmrkturl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(8000);
		utl.ClearGlobalSearch();
		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(15000);

		// Click on Info link
		atlgs.getATLsearchresultInfoLink().click();
		Thread.sleep(500);
		// click on Topics filter
		atlgs.getATLInfoSearchTopicsFilter().click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
					Thread.sleep(500);
					break;
				case "Market Snapshot":
					infoFilterList.get(i).click();
					Thread.sleep(5000);
					for (int k = 1; k < taglist.size(); k++) {
						Assert.assertTrue(taglist.get(k).getText().contains("Market Snapshot"));
						break;
					}
					infoFilterList.get(i).click();
					Thread.sleep(500);
					break;
				case "Exhibitors":
					infoFilterList.get(i).click();
					Thread.sleep(8000);
					for (int l = 0; l < taglist.size(); l++) {
						Thread.sleep(3000);
						Assert.assertTrue(taglist.get(l).getText().contains("Exhibitors"));
						break;
					}
					atlgs.getATLInfoSearchSeeMoreDetailsBtn().click();
					Thread.sleep(5000);
					Assert.assertTrue(atlgs.getATLExhibitorHeader().getText().contains("Exhibitors & Products"));
					driver.navigate().back();
					Thread.sleep(5000);
					infoFilterList.get(i).click();
					Thread.sleep(500);
					break;
				default:
					break;
				}
			} catch (StaleElementReferenceException e) {
				infoFilterList = driver.findElements(By.xpath("//div[@class='imc-filteritem__option']"));
				String f = infoFilterList.get(i).getText();
			}
		}
		Thread.sleep(2000);
	}

	@Test(priority = 4)//groups=\"Non_MP")
	public void TS004_VerifyCatalogsOverviewInGlobalSearchTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T428: Global Search- Search for: Catalogs

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		
	    driver.get(prop.getProperty("atlmrkturl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(8000);
		
		utl.ClearGlobalSearch();
		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);
		/*Assert.assertTrue(atlgs.getATLSearchResult().getText().contains(prop.getProperty("searchforCatalogsInput")));
		// Click on Matching Products-See All link for 1st Exhibitor
		atlexhact.getMatchingProdSeeAllLink().click();
		Thread.sleep(5000);
		//Click on Catalogs tab
		try {
		atlexhact.getCatalogsTab().click();
		Thread.sleep(2000);
		atlexhact.getCatalogsTab().click();
		}
		catch(Exception e) {
			atlexhact.getcatalogstabDiv().click();
			Thread.sleep(2000);
			atlexhact.getcatalogstabDiv().click();
		}

		//Verify that Catalog item should be displayed
		Assert.assertTrue(atlexhact.getCatalogsItem().isDisplayed());

		//Click on Catalog item
		String catalogName = atlexhact.getCatalogsItem().getText();
		System.out.println(catalogName);
		
		atlexhact.getCatalogsItem().click();
		Thread.sleep(2000);
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(5000);
		Assert.assertTrue(driver.getTitle().contains("Catalog View"));
		String Cname =atlgs.getCatalogHeaderName().getText();
		Assert.assertTrue(catalogName.contains(Cname));
		Assert.assertTrue(catalogName.startsWith(Cname));

		driver.close();
		driver.switchTo().window(winHandleBefore);
		driver.get(prop.getProperty("atlmrkturl_prod"));
		Thread.sleep(5000);*/
		
		//Click on DG showroom filter
		utl.scrollElementIntoMiddle(atlexhact.getleftPaneFilterDGShowroom());
		Thread.sleep(500);
		atlexhact.getleftPaneFilterDGShowroom().click();
		Thread.sleep(3000);
		//Click on Catalog sub filter
		utl.scrollElementIntoMiddle(atlexhact.getleftPaneFilterDGShowroomCatalog());
		atlexhact.getleftPaneFilterDGShowroomCatalog().click();
		Thread.sleep(3000);
		//Store Catalog name
		String catalogName = atlgs.getFirstCatalogName().getText();
		System.out.println(catalogName);
		//click on 1st Exhibitor
		utl.scrollElementIntoMiddle(atlgs.getatl1STExhiName());
		Thread.sleep(200);
		atlgs.getatl1STExhiName().click();
		Thread.sleep(3000);
		//Scroll to Catalog Section
		utl.scrollElementIntoMiddle(atlexhdgshw.getATLCatalogSection());
		//Click on All Catalog Btn Btn
		Thread.sleep(200);
		utl.scrollElementIntoMiddle(atlexhdgshw.getATLCatalogSeeAllBtn());
		Thread.sleep(500);
		atlexhdgshw.getATLCatalogSeeAllBtn().click();
		Thread.sleep(2000);
		Assert.assertTrue(atlexhdgshw.getATLVerifyLinePageTitle().getText().contains("Catalogs"));
		Thread.sleep(2000);
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		//Click on Catalog
		utl.scrollElementIntoMiddle(atlexhact.getCatalogsItem());
		String CatName = atlexhact.getCatalogsItemName().getText();
		atlexhact.getCatalogsItem().click();
		//Thread.sleep(2000);
		/*	for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}*/
		Thread.sleep(5000);
		String Cname =atlgs.getCatalogHeaderName().getText();
		System.out.println(Cname);
		Assert.assertTrue(CatName.contains(Cname));
		//driver.close();
		//driver.switchTo().window(winHandleBefore);
		//Thread.sleep(2000);
	}

	@Test(priority = 5)//groups="Non_MP"
	public void TS005_VerifyArticlesOverviewInGlobalSearchTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T429: Global Search- Search for : Articles

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		
		driver.get(prop.getProperty("atlmrkturl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(7000);
		
		utl.ClearGlobalSearch();
		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("searchforArticlesInput2"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(8000);

		// Click on Article link
		utl.scrollElementIntoMiddle(atlgs.getATLsearchresultArticlesLink());
		Thread.sleep(200);
		atlgs.getATLsearchresultArticlesLink().click();
		Thread.sleep(3000);
		Assert.assertTrue(atlgs.getATLSearchResult().getText().contains(prop.getProperty("searchforArticlesInput2")));
		String filterResultTitle = atlgs.getATLArticleName().getText();
		System.out.println("Article Title on Search Page: "+filterResultTitle);
		
		utl.scrollToElement(atlgs.getATLArticleSeeMoreBtn());
		Thread.sleep(200);
		atlgs.getATLArticleSeeMoreBtn().click();
		Thread.sleep(3000);
		String articleTitle =atlgs.getATLArticleHeader().getText();
		System.out.println("Article Title on Details Page: "+articleTitle);
		Assert.assertTrue(filterResultTitle.contains(articleTitle));
		
		utl.scrollToElement(atlgs.getATLArticleTag());
		Thread.sleep(200);
		boolean temp = false;
		tagBlogPost = driver.findElements(By.xpath("//span[@class='imc-blog-tag-module__tag']"));
		for (WebElement blogPost : tagBlogPost) {
			if (blogPost.getText().contains(prop.getProperty("searchforArticlesInput"))) {
				temp = true;
				break;
			}
		}
		Assert.assertTrue(temp);
		Thread.sleep(2000);
	}

	@Test(priority = 6)//groups="Non_MP"
	public void TS006_VerifyArticlesFiltersFunctionalityInGlobalSearchTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T440: Global Search- Search for : Articles : Filters

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlleftpane = new ATLLeftPaneFilters(driver);
		utl = new Utility(driver);

        driver.get(prop.getProperty("atlmrkturl_prod"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(8000);
		utl.ClearGlobalSearch();

		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);

		// Click on Articles link
		utl.scrollElementIntoMiddle(atlgs.getATLsearchresultArticlesLink());
		Thread.sleep(200);
		atlgs.getATLsearchresultArticlesLink().click();
		Thread.sleep(500);
		// click on Topics filter
		atlgs.getATLInfoSearchTopicsFilter().click();
		Thread.sleep(500);
		infoFilterList = driver.findElements(By.xpath("//div[@class='imc-filteritem__option']"));

		for (int i = 0; i < infoFilterList.size(); i++) {
			try {
				String f = infoFilterList.get(i).getText();
				switch (f) {
				case "Blog Post":
					infoFilterList.get(i).click();
					Thread.sleep(500);
					driver.navigate().refresh();
					Thread.sleep(5000);
					String filterResultTitle = atlgs.getATLArticleName().getText();
					String filterResultTitleNew = filterResultTitle.replaceAll("[^a-zA-Z0-9 ]", "");
					System.out.println("Filter Result Title: "+filterResultTitleNew);
					utl.scrollElementIntoMiddle(atlgs.getATLArticleSeeMoreBtn());
					atlgs.getATLArticleSeeMoreBtn().click();
					Thread.sleep(3000);
					try {
						String articleTitle = atlgs.getATLArticleHeader().getText();
						String articleTitleNew = articleTitle.replaceAll("[^a-zA-Z0-9 ]", "");
						System.out.println(articleTitleNew);
						Assert.assertTrue(filterResultTitleNew.contains(articleTitleNew));
					} catch (Exception e) {
						Assert.assertTrue(filterResultTitleNew.contains(driver.getTitle()));
					}
					utl.scrollElementIntoMiddle(atlgs.getATLArticleTag());
					Thread.sleep(200);
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
						Thread.sleep(500);
					} catch (StaleElementReferenceException e) {
						infoFilterList = driver.findElements(By.xpath("//div[@class='imc-filteritem__option']"));
						Thread.sleep(100);
						infoFilterList.get(i).click();
						atlgs.getATLInfoSearchTopicsFilter().click();
						Thread.sleep(500);
					}
					break;

				case "Atlanta Market":
					infoFilterList.get(i).click();
					Thread.sleep(5000);
					driver.navigate().refresh();

					String filterResultTitle1 = atlgs.getATLArticleName().getText();
					utl.scrollElementIntoMiddle(atlgs.getATLArticleSeeMoreBtn());
					Thread.sleep(200);
					atlgs.getATLArticleSeeMoreBtn().click();
					Thread.sleep(500);
					Assert.assertTrue(filterResultTitle1.contains(atlgs.getATLArticleHeader().getText()));
					utl.scrollElementIntoMiddle(atlgs.getATLArticleTag());
					Thread.sleep(200);
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
						Thread.sleep(500);
					} catch (StaleElementReferenceException e) {
						infoFilterList = driver.findElements(By.xpath("//div[@class='imc-filteritem__option']"));
						infoFilterList.get(i).click();
						Thread.sleep(500);
						atlgs.getATLInfoSearchTopicsFilter().click();
					}
					break;
				case "Shop The Show":
					infoFilterList.get(i).click();
					Thread.sleep(5000);
					driver.navigate().refresh();

					String filterResultTitle2 = atlgs.getATLArticleName().getText();
					atlgs.getATLArticleSeeMoreBtn().click();
					Thread.sleep(500);
					Assert.assertTrue(filterResultTitle2.contains(atlgs.getATLArticleHeader().getText()));
					utl.scrollElementIntoMiddle(atlgs.getATLArticleTag());
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
						Thread.sleep(500);
					} catch (StaleElementReferenceException e) {
						infoFilterList = driver.findElements(By.xpath("//div[@class='imc-filteritem__option']"));
						infoFilterList.get(i).click();
						Thread.sleep(500);
						atlgs.getATLInfoSearchTopicsFilter().click();
						Thread.sleep(500);
					}
					break;
				case "Press Release":
					infoFilterList.get(i).click();
					Thread.sleep(5000);
					driver.navigate().refresh();

					String filterResultTitle3 = atlgs.getATLArticleName().getText();
					atlgs.getATLArticleSeeMoreBtn().click();
					Thread.sleep(500);
					Assert.assertTrue(filterResultTitle3.contains(atlgs.getATLArticleHeader().getText()));
					utl.scrollElementIntoMiddle(atlgs.getATLArticleTag());
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
						Thread.sleep(500);
					} catch (StaleElementReferenceException e) {
						infoFilterList = driver.findElements(By.xpath("//div[@class='imc-filteritem__option']"));
						infoFilterList.get(i).click();
						Thread.sleep(500);
						atlgs.getATLInfoSearchTopicsFilter().click();
						Thread.sleep(500);
					}
					break;
				case "Fall Design Week":
					//Thread.sleep(10000);
					infoFilterList.get(i).click();
					Thread.sleep(10000);
					driver.navigate().refresh();
					Thread.sleep(8000);
					String filterResultTitle4 = atlgs.getATLArticleName().getText();
					utl.scrollElementIntoMiddle(atlgs.getATLArticleSeeMoreBtn());
					Thread.sleep(200);
					atlgs.getATLArticleSeeMoreBtn().click();
					Thread.sleep(500);
					Assert.assertTrue(filterResultTitle4.contains(atlgs.getATLArticleHeader().getText()));
					utl.scrollElementIntoMiddle(atlgs.getATLArticleTag());
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
						Thread.sleep(500);
					} catch (StaleElementReferenceException e) {
						infoFilterList = driver.findElements(By.xpath("//div[@class='imc-filteritem__option']"));
						infoFilterList.get(i).click();
						Thread.sleep(500);
						atlgs.getATLInfoSearchTopicsFilter().click();
					}
					break;
				case "Market Snapshot":
					infoFilterList.get(i).click();
					Thread.sleep(5000);
					driver.navigate().refresh();

					String filterResultTitle5 = atlgs.getATLArticleName().getText();
					atlgs.getATLArticleSeeMoreBtn().click();
					Thread.sleep(500);
					Assert.assertTrue(filterResultTitle5.contains(atlgs.getATLArticleHeader().getText()));
					utl.scrollElementIntoMiddle(atlgs.getATLArticleTag());
					Thread.sleep(200);
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
						Thread.sleep(500);
					} catch (StaleElementReferenceException e) {
						infoFilterList = driver.findElements(By.xpath("//div[@class='imc-filteritem__option']"));
						infoFilterList.get(i).click();
						Thread.sleep(500);
						atlgs.getATLInfoSearchTopicsFilter().click();
						Thread.sleep(500);
					}
					break;
				case "Press Releases":
					infoFilterList.get(i).click();
					Thread.sleep(5000);
					driver.navigate().refresh();

					String filterResultTitle6 = atlgs.getATLArticleName().getText();
					atlgs.getATLArticleSeeMoreBtn().click();
					Thread.sleep(500);
					Assert.assertTrue(filterResultTitle6.contains(atlgs.getATLArticleHeader().getText()));
					utl.scrollElementIntoMiddle(atlgs.getATLArticleTag());
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
						Thread.sleep(500);
					} catch (StaleElementReferenceException e) {
						infoFilterList = driver.findElements(By.xpath("//div[@class='imc-filteritem__option']"));
						infoFilterList.get(i).click();
						Thread.sleep(500);
						atlgs.getATLInfoSearchTopicsFilter().click();
						Thread.sleep(500);
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
		Thread.sleep(2000);
	}
	@Test(priority = 7)//groups="Non_MP"
	public void TS007_VerifyArticlesSearchFunctionalityInGlobalSearchTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T441: Global Search- Search for: Articles - Search box

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		
        driver.get(prop.getProperty("atlmrkturl_prod"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(8000);
		utl.ClearGlobalSearch();

		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);
		
		// Click on Info link
		utl.scrollElementIntoMiddle(atlgs.getATLsearchresultArticlesLink());
		Thread.sleep(200);
		atlgs.getATLsearchresultArticlesLink().click();
		Thread.sleep(500);
		atlgs.getATLInfosearchtxtbxClr();
		atlgs.getATLInfosearchtxtbx().sendKeys(prop.getProperty("searchforArticlesInput2"));
		atlgs.getATLInfosearchbtn().click();

		Thread.sleep(5000);
		System.out.println(atlgs.getATLSearchResult().getText());
		System.out.println(prop.getProperty("searchforArticlesInput"));
		Assert.assertTrue(atlgs.getATLSearchResult().getText().contains(prop.getProperty("searchforArticlesInput2")));

		driver.navigate().refresh();
		Thread.sleep(3000);
		String filterResultTitle = atlgs.getATLArticleName().getText();
		utl.scrollToElement(atlgs.getATLArticleSeeMoreBtn());
		Thread.sleep(500);
		atlgs.getATLArticleSeeMoreBtn().click();
		Thread.sleep(2000);
		Assert.assertTrue(filterResultTitle.contains(atlgs.getATLArticleHeader().getText()));
		utl.scrollToElement(atlgs.getATLArticleTag());
		boolean temp5 = false;
		tagBlogPost = driver.findElements(By.xpath("//span[@class='imc-blog-tag-module__tag']"));
		for (WebElement blogPost : tagBlogPost) {
			if (blogPost.getText().equals(prop.getProperty("searchforArticlesInput2"))) {
				temp5 = true;
				break;
			}
		}
		Assert.assertTrue(temp5);
		Thread.sleep(2000);
	}


	@Test(priority = 8)//groups="Non_MP"
	public void TS008_VerifyEventsSearchFunctionalityInGlobalSearchTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T430: Global Search- Search for : Events- Search box

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		
        driver.get(prop.getProperty("atlmrkturl_prod"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(8000);
		utl.ClearGlobalSearch();
		
		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(15000);

		try {
		//Click on Events & Seminars tab
		atlgs.getATLEventsTabInSearch().click();
		Thread.sleep(500);
		}
		catch(Exception e) {
			atlgs.getATLEventsTabInSearchDiv().click();
			Thread.sleep(500);
		}

		String eventName=atlgs.getATLFirstEventName().getText();
		//Click on Search text field;
		atlgs.getATLInfosearchtxtbx().sendKeys(eventName);
		atlgs.getATLInfosearchbtn().click();
		Thread.sleep(8000);
		String alertTitle=atlgs.getATLSearchResult().getText();
		System.out.println(alertTitle);
		String splitAlertTitle=alertTitle.split(" ")[4].trim();
		
		String splitAlertTitleNext=alertTitle.split(" ")[5].trim();
		Thread.sleep(5000);
		
	
		String joinboth=splitAlertTitle +" " + splitAlertTitleNext;
		
		Assert.assertTrue(eventName.contains(joinboth));
		Thread.sleep(2000);
	}

	@Test(priority = 9)//groups="Non_MP"
	public void TS009_VerifyEventsFiltersFunctionalityInGlobalSearchTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T449: Global Search- Search for : Events: Filters

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

        driver.get(prop.getProperty("atlmrkturl_prod"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(8000);

		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(8000);

		//Click on Events & Seminars tab
		//	atlgs.getATLEventsTabInSearch().click();
		try {
			//Click on Events & Seminars tab
			atlgs.getATLEventsTabInSearch().click();
			Thread.sleep(500);
			}
			catch(Exception e) {
				atlgs.getATLEventsTabInSearchDiv().click();
				Thread.sleep(500);
			}
		//Click on Topics filter
		Thread.sleep(3000);
		atlgs.getATLInfoSearchTopicsFilter().click();
		Thread.sleep(4000);
		//atlgs.getEventsATLMktTopics();
		//Thread.sleep(3000);
		
		//Select 'Atlanta Market' topic
		atlgs.getEventsATLMktTopics().click();
		Thread.sleep(8000);
		String topicName = atlgs.getEventsATLMktTopics().getText();
		String eventName = atlgs.getATLFirstEventName().getText();
		System.out.println(eventName);
		//atlgs.getEventsATLMktTopics().click();
		Thread.sleep(800);
		//Click on See More details btn
		utl.scrollElementIntoMiddle(atlgs.getATLSeeMoreDetailsBtn());
		Thread.sleep(500);
		atlgs.getATLSeeMoreDetailsBtn().click();
		Thread.sleep(5000);
		//Verify that Selected topic name should be displayed as Tag on Event details page
		System.out.println(atlexhact.getEventDetailsHeader().getText());
		Assert.assertTrue(atlexhact.getEventDetailsHeader().getText().contains(eventName));
		driver.navigate().back();
		Thread.sleep(5000);
		//Click on Clear Filters btn
		atlgs.getClearFiltersBtn().click();
		Thread.sleep(2000);
		//Click on Event Types filter
		atlgs.getEventTypesFilter().click();
		Thread.sleep(2000);
		//Click on 'At Market' Event Type
		String atmrkteventtype = atlgs.getAtMarketEventType().getText();
		System.out.println(atmrkteventtype);
		Thread.sleep(2000);
		atlgs.getAtMarketEventType().click();
		Thread.sleep(10000);
		/*atlgs.getAtMarketEventType().click();
		atlgs.getAtMarketEventType().click();*/
		driver.navigate().refresh();
		//Verify that Selected event type should be displayed as Tag on Event Card
		System.out.println(atlexhact.getEventCardTag().getText());
		Assert.assertTrue(atlexhact.getEventCardTag().getText().contains(atmrkteventtype));

		//Click on Clear Filters btn
		atlgs.getClearFiltersBtn().click();
		//Thread.sleep(2000);
		/*	Exhibitor events are available on test environment
	  String buyingeventtype = atlgs.getBuyingEventType().getText();
		atlgs.getBuyingEventType().click();

		//Verify that Selected event type should be displayed as Tag on Event Card
		Assert.assertTrue(atlexhact.getEventCardTag().getText().contains(buyingeventtype));

		//Click on Clear Filters btn
		atlgs.getClearFiltersBtn().click();*/
	}

	@Test(priority = 10)//groups="Non_MP"
	public void TS010_VerifyShowSpecialsOverviewInGlobalSearchTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T425: Verify Show Specials option in global search

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		utl = new Utility(driver);
		
        driver.get(prop.getProperty("atlmrkturl_prod"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(8000);
        
		utl.ClearGlobalSearch();
		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinputforShowSpecials4")));
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);
		
		//Click on First Exhibitor
		utl.scrollElementIntoMiddle(atlgs.getseeAllLinkMatchingProduct());
		Thread.sleep(500);
		atlgs.getseeAllLinkMatchingProduct().click();
		Thread.sleep(5000);
		
		//Click on see all show specials button
		utl.scrollElementIntoMiddle(atlgs.getatlShowSpecialsTab());
		Thread.sleep(500);
		atlgs.getatlShowSpecialsTab().click();
		Thread.sleep(500);
		
		//Verify Show Specials section
		Assert.assertTrue(atlgs.getatlVerifyShowSpecials().isDisplayed());
		Thread.sleep(5000);
		Assert.assertTrue(atlgs.getFourthBreadcrumbTxtInApp().getText().contains("Specials"));
		Thread.sleep(2000);
	}

	@Test(priority = 11)//groups="Non_MP"
	public void TS011_VerifyEventsOverviewInGlobalSearchTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T425: Verify Events option in global search

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);

        driver.get(prop.getProperty("atlmrkturl_prod"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(8000);
        
		utl.ClearGlobalSearch();
		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(10000);

		//Click on Events & Seminars tab
		try {
			//Click on Events & Seminars tab
			atlgs.getATLEventsTabInSearch().click();
			}
			catch(Exception e) {
				atlgs.getATLEventsTabInSearchDiv().click();
			}
		Thread.sleep(2000);
		//Verify that Events data should be displayed
		String eventname = atlexhact.getEventCardTitle().getText();
		Assert.assertTrue(atlexhact.getEventCardInSearch().isDisplayed());
		System.out.println(eventname);
		//Click on See More details btn
		utl.scrollElementIntoMiddle(atlgs.getATLSeeMoreDetailsBtn());
		atlgs.getATLSeeMoreDetailsBtn().click();
		Thread.sleep(5000);
		System.out.println(atlexhact.getEventDetailsHeader().getText());
		//Verify that selected event's details page should be opened
		Assert.assertTrue(atlexhact.getEventDetailsHeader().getText().contains(eventname));
		driver.navigate().back();
		driver.get(prop.getProperty("atlmrkturl_prod"));
		Thread.sleep(2000);
	}
	
	   @Test(enabled=false)
	    public void verifyMPLoginFunctionality() throws IOException, InterruptedException {
	        // The purpose of this test case to verify:-
	        // TS1- Login to Market Planner

	        lap = new ATLLandingPage(driver);
	        lp = new ATLLoginPage(driver);

	        // Click on Login button from Landing Page
	        lap.getLogin().click();
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        driver.get(prop.getProperty("atlmrkturl_prod"));
	        // Enter the credentials on Login Page and click
	        lp.getEmailAddress().sendKeys((prop.getProperty("username")));

	        lp.getPassword().sendKeys((prop.getProperty("passwordW")));

	        Thread.sleep(1000);
	    //  lp.getPassword().sendKeys((prop.getProperty("password")));
	    //  Thread.sleep(1000);

	        lp.getSignInBtn().click();
	        Thread.sleep(15000);
	        Assert.assertTrue(driver.getTitle().contains("Atlanta Market at AmericasMart"));
	    }
	
	
	@AfterClass(alwaysRun=true)
	public void tearDown()
	{
		//driver.quit();
	}
}