package atlantamarket_PROD;

import static org.junit.Assert.assertArrayEquals;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import pageObjects.AtlantaMarket.ATLExhDigiShowroomPage;
import pageObjects.AtlantaMarket.ATLExhLineProdActionsPage;
import pageObjects.AtlantaMarket.ATLGlobalSearchPage;
import pageObjects.AtlantaMarket.ATLLandingPage;
import pageObjects.AtlantaMarket.ATLLeftPaneFilters;
import pageObjects.AtlantaMarket.ATLLoginPage;
import pageObjects.AtlantaMarket.ATLMarketPlannerPage;
import pageObjects.AtlantaMarket.ATLProductDetailsPage;
import pageObjects.LasVegasMarket.LVMGlobalSearchPage;
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
	ATLLeftPaneFilters atlleftpane;

	List<WebElement> exhlist, linelist, prodlist, searchexhtypelist, searchproducttypelist, mplists, mpeditlistoptns,
	allnoteslist, favlist, searchlinetypelist, tagBlogPost, taglist, infoFilterList;

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
	@Test(priority = 1)
	public void TS001_VerifyInformationTabInGlobalSearchTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T427: Global Search- Search for: Information

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("globalsearchinputforInformation"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);

		// Click on Info link
		atlgs.getATLsearchresultInfoLink().click();
		Assert.assertTrue(atlgs.getATLSearchResult().getText().contains(prop.getProperty("globalsearchinputforInformation")));

		// Click on See More details Btn from result
		atlgs.getATLInfoSearchJuniperMarketBtn().click();

		// Verify Juniper Market Page
		Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("atlmrkturl_prod")+"JuniperMarket"));
		driver.get(prop.getProperty("atlmrkturl_prod"));
	}

	@Test(priority = 2)
	public void TS002_VerifyInformationSearchFunctionalityInGlobalSearchTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T427: Global Search- Search for: Information - Search box

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);

		// Click on Info link
		atlgs.getATLsearchresultInfoLink().click();
		atlgs.getATLInfosearchtxtbx().sendKeys(prop.getProperty("globalsearchinputforInformation"));
		atlgs.getATLInfosearchbtn().click();

		Assert.assertTrue(atlgs.getATLSearchResult().getText().contains(prop.getProperty("globalsearchinputforInformation")));

		// Click on See More details Btn from result
		atlgs.getATLInfoSearchJuniperMarketBtn().click();

		// Verify Juniper Market Page
		Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("atlmrkturl_prod")+"JuniperMarket"));
		driver.get(prop.getProperty("atlmrkturl_prod"));
	}

	@Test(priority = 3)
	public void TS003_VerifyInformationFiltersFunctionalityInGlobalSearchTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T437: Global Search- Search for: Information -Filters

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);

		// Click on Info link
		atlgs.getATLsearchresultInfoLink().click();
		// click on Topics filter
		atlgs.getATLInfoSearchTopicsFilter().click();

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
					atlgs.getATLInfoSearchSeeMoreDetailsBtn().click();
					Assert.assertTrue(atlgs.getATLExhibitorHeader().getText().contains("Exhibitors & Products"));
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
		driver.get(prop.getProperty("atlmrkturl_prod"));
	}

	@Test(priority = 4)
	public void TS004_VerifyCatalogsOverviewInGlobalSearchTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T428: Global Search- Search for: Catalogs

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("searchforCatalogsInput"));
		atlgs.getATLSearchButton().click();
		Assert.assertTrue(atlgs.getATLSearchResult().getText().contains(prop.getProperty("searchforCatalogsInput")));
		Thread.sleep(5000);

		// Click on Matching Products-See All link for 1st Exhibitor
		atlexhact.getMatchingProdSeeAllLink().click();

		//Click on Catalogs tab
		atlexhact.getCatalogsTab().click();
		atlexhact.getCatalogsTab().click();

		//Verify that Catalog item should be displayed
		Assert.assertTrue(atlexhact.getCatalogsItem().isDisplayed());

		//Click on Catalog item
		String catalogName = atlexhact.getCatalogsItem().getText();
		atlexhact.getCatalogsItem().click();

		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(5000);
		Assert.assertTrue(driver.getTitle().contains("Catalog View"));
		Assert.assertTrue(atlgs.getCatalogHeaderName().getText().contains(catalogName));

		driver.close();
		driver.switchTo().window(winHandleBefore);
		driver.get(prop.getProperty("atlmrkturl_prod"));
	}

	@Test(priority = 5)
	public void TS005_VerifyArticlesOverviewInGlobalSearchTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T429: Global Search- Search for : Articles

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("searchforArticlesInput"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(8000);

		// Click on Article link
		atlgs.getATLsearchresultArticlesLink().click();
		Assert.assertTrue(atlgs.getATLSearchResult().getText().contains(prop.getProperty("searchforArticlesInput")));
		String filterResultTitle = atlgs.getATLArticleName().getText();
		atlgs.getATLArticleSeeMoreBtn().click();
		Assert.assertTrue(filterResultTitle.contains(atlgs.getATLArticleHeader().getText()));
		utl.scrollToElement(atlgs.getATLArticleTag());
		boolean temp = false;
		tagBlogPost = driver.findElements(By.xpath("//span[@class='imc-blog-tag-module__tag']"));
		for (WebElement blogPost : tagBlogPost) {
			if (blogPost.getText().equals(prop.getProperty("searchforArticlesInput"))) {
				temp = true;
				break;
			}
		}
		Assert.assertTrue(temp);
		driver.get(prop.getProperty("atlmrkturl_prod"));
	}

	@Test(priority = 6)
	public void TS006_VerifyArticlesFiltersFunctionalityInGlobalSearchTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T440: Global Search- Search for : Articles : Filters

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlleftpane = new ATLLeftPaneFilters(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);

		// Click on Articles link
		atlgs.getATLsearchresultArticlesLink().click();
		// click on Topics filter
		atlgs.getATLInfoSearchTopicsFilter().click();

		infoFilterList = driver.findElements(By.xpath("//div[@class='imc-filteritem__option']"));

		for (int i = 0; i < infoFilterList.size(); i++) {
			try {
				String f = infoFilterList.get(i).getText();
				switch (f) {
				case "Blog Post":
					infoFilterList.get(i).click();
					driver.navigate().refresh();
					Thread.sleep(5000);
					String filterResultTitle = atlgs.getATLArticleName().getText();
					atlgs.getATLArticleSeeMoreBtn().click();
					Assert.assertTrue(filterResultTitle.contains(atlgs.getATLArticleHeader().getText()));
					utl.scrollToElement(atlgs.getATLArticleTag());
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
						atlgs.getATLInfoSearchTopicsFilter().click();
					}
					break;

				case "Atlanta Market":
					infoFilterList.get(i).click();
					Thread.sleep(5000);
					driver.navigate().refresh();

					String filterResultTitle1 = atlgs.getATLArticleName().getText();
					atlgs.getATLArticleSeeMoreBtn().click();

					Assert.assertTrue(filterResultTitle1.contains(atlgs.getATLArticleHeader().getText()));
					utl.scrollToElement(atlgs.getATLArticleTag());
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
						atlgs.getATLInfoSearchTopicsFilter().click();
					}
					break;
				case "Shop The Show":
					infoFilterList.get(i).click();
					Thread.sleep(5000);
					driver.navigate().refresh();

					String filterResultTitle2 = atlgs.getATLArticleName().getText();
					atlgs.getATLArticleSeeMoreBtn().click();

					Assert.assertTrue(filterResultTitle2.contains(atlgs.getATLArticleHeader().getText()));
					utl.scrollToElement(atlgs.getATLArticleTag());
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
						atlgs.getATLInfoSearchTopicsFilter().click();
					}
					break;
				case "Press Release":
					infoFilterList.get(i).click();
					Thread.sleep(5000);
					driver.navigate().refresh();

					String filterResultTitle3 = atlgs.getATLArticleName().getText();
					atlgs.getATLArticleSeeMoreBtn().click();

					Assert.assertTrue(filterResultTitle3.contains(atlgs.getATLArticleHeader().getText()));
					utl.scrollToElement(atlgs.getATLArticleTag());
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
						atlgs.getATLInfoSearchTopicsFilter().click();
					}
					break;
				case "Fall Design Week":
					//Thread.sleep(10000);
					infoFilterList.get(i).click();
					Thread.sleep(10000);
					driver.navigate().refresh();
					Thread.sleep(8000);
					String filterResultTitle4 = atlgs.getATLArticleName().getText();
					atlgs.getATLArticleSeeMoreBtn().click();
					Assert.assertTrue(filterResultTitle4.contains(atlgs.getATLArticleHeader().getText()));
					utl.scrollToElement(atlgs.getATLArticleTag());
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
						atlgs.getATLInfoSearchTopicsFilter().click();
					}
					break;
				case "Market Snapshot":
					infoFilterList.get(i).click();
					Thread.sleep(5000);
					driver.navigate().refresh();

					String filterResultTitle5 = atlgs.getATLArticleName().getText();
					atlgs.getATLArticleSeeMoreBtn().click();

					Assert.assertTrue(filterResultTitle5.contains(atlgs.getATLArticleHeader().getText()));
					utl.scrollToElement(atlgs.getATLArticleTag());
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
						atlgs.getATLInfoSearchTopicsFilter().click();
					}
					break;
				case "Press Releases":
					infoFilterList.get(i).click();
					Thread.sleep(5000);
					driver.navigate().refresh();

					String filterResultTitle6 = atlgs.getATLArticleName().getText();
					atlgs.getATLArticleSeeMoreBtn().click();

					Assert.assertTrue(filterResultTitle6.contains(atlgs.getATLArticleHeader().getText()));
					utl.scrollToElement(atlgs.getATLArticleTag());
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
						atlgs.getATLInfoSearchTopicsFilter().click();
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
		driver.get(prop.getProperty("atlmrkturl_prod"));
	}
	@Test(priority = 7)
	public void TS007_VerifyArticlesSearchFunctionalityInGlobalSearchTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T427: Global Search- Search for: Articles - Search box

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);
		// Click on Info link
		atlgs.getATLsearchresultArticlesLink().click();
		atlgs.getATLInfosearchtxtbx().sendKeys(prop.getProperty("searchforArticlesInput"));
		atlgs.getATLInfosearchbtn().click();

		System.out.println(atlgs.getATLSearchResult().getText());
		System.out.println(prop.getProperty("searchforArticlesInput"));
		Assert.assertTrue(atlgs.getATLSearchResult().getText().contains(prop.getProperty("searchforArticlesInput")));

		driver.navigate().refresh();

		String filterResultTitle = atlgs.getATLArticleName().getText();
		atlgs.getATLArticleSeeMoreBtn().click();

		Assert.assertTrue(filterResultTitle.contains(atlgs.getATLArticleHeader().getText()));
		utl.scrollToElement(atlgs.getATLArticleTag());
		boolean temp5 = false;
		tagBlogPost = driver.findElements(By.xpath("//span[@class='imc-blog-tag-module__tag']"));
		for (WebElement blogPost : tagBlogPost) {
			if (blogPost.getText().equals(prop.getProperty("searchforArticlesInput"))) {
				temp5 = true;
				break;
			}
		}
		Assert.assertTrue(temp5);
		driver.get(prop.getProperty("atlmrkturl_prod"));
	}


	@Test(priority = 9)
	public void TS009_VerifyEventsSearchFunctionalityInGlobalSearchTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T428: Global Search- Search for: Articles -Blogs

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(15000);

		//Click on Events & Seminars tab
		atlgs.getATLEventsTabInSearch().click();

		//Click on Search text field;
		atlgs.getATLInfosearchtxtbx().sendKeys(prop.getProperty("autosuggestline"));
		atlgs.getATLInfosearchbtn().click();

		Assert.assertTrue(atlgs.getATLSearchResult().getText().contains(prop.getProperty("autosuggestline")));
		driver.get(prop.getProperty("atlmrkturl_prod"));
	}

	@Test(priority = 10)
	public void TS010_VerifyEventsFiltersFunctionalityInGlobalSearchTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T428: Global Search- Search for: Articles -Blogs

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(15000);

		//Click on Events & Seminars tab
		atlgs.getATLEventsTabInSearch().click();

		//Click on Topics filter
		atlgs.getATLInfoSearchTopicsFilter().click();

		//Select 'Atlanta Market' topic
		String topicName = atlgs.getEventsATLMktTopics().getText();
		atlgs.getEventsATLMktTopics().click();

		//Click on See More details btn
		atlgs.getATLSeeMoreDetailsBtn().click();

		//Verify that Selected topic name should be displayed as Tag on Event details page
		Assert.assertTrue(atlexhact.getEventDetailsTag().getText().contains(topicName));
		driver.navigate().back();

		//Click on Clear Filters btn
		atlgs.getClearFiltersBtn().click();

		//Click on Event Types filter
		atlgs.getEventTypesFilter().click();

		//Click on 'At Market' Event Type
		String atmrkteventtype = atlgs.getAtMarketEventType().getText();
		atlgs.getAtMarketEventType().click();

		//Verify that Selected event type should be displayed as Tag on Event Card
		Assert.assertTrue(atlexhact.getEventCardTag().getText().contains(atmrkteventtype));

		//Click on Clear Filters btn
		atlgs.getClearFiltersBtn().click();

		/*	Exhibitor events are available on test environment
	  String buyingeventtype = atlgs.getBuyingEventType().getText();
		atlgs.getBuyingEventType().click();

		//Verify that Selected event type should be displayed as Tag on Event Card
		Assert.assertTrue(atlexhact.getEventCardTag().getText().contains(buyingeventtype));

		//Click on Clear Filters btn
		atlgs.getClearFiltersBtn().click();*/
		driver.get(prop.getProperty("atlmrkturl_prod"));
	}


	@Test(priority = 11)
	public void TS011_VerifyShowSpecialsOverviewInGlobalSearchTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T425: Verify Show Specials option in global search

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearch")));

		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);

		atlgs.getatlseealllineslink().click();
		Thread.sleep(5000);

		atlgs.getatlShowSpecialsTab().click();

		//Verify Show Specials section
		Assert.assertTrue(atlgs.getatlVerifyShowSpecials().isDisplayed());
		Assert.assertTrue(atlgs.getFourthBreadcrumbTxtInApp().getText().contains("Specials"));
		driver.get(prop.getProperty("atlmrkturl_prod"));
	}

	@Test(priority = 8)
	public void TS008_VerifyEventsOverviewInGlobalSearchTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T425: Verify Events option in global search

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(10000);

		//Click on Events & Seminars tab
		atlgs.getATLEventsTabInSearch().click();

		//Verify that Events data should be displayed
		String eventname = atlexhact.getEventCardTitle().getText();
		Assert.assertTrue(atlexhact.getEventCardInSearch().isDisplayed());

		//Click on See More details btn
		atlgs.getATLSeeMoreDetailsBtn().click();

		//Verify that selected event's details page should be opened
		Assert.assertTrue(atlexhact.getEventDetailsHeader().getText().contains(eventname));
		driver.navigate().back();
		driver.get(prop.getProperty("atlmrkturl_prod"));
	}
}
