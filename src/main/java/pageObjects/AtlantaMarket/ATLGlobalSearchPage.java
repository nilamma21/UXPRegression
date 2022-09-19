package pageObjects.AtlantaMarket;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import bsh.This;

public class ATLGlobalSearchPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By atlglobalsearchtxtbx = By.xpath("//input[@id='input-1']"); // Locator for Global Search field 
	By atlInfosearchtxtbx = By.xpath("(//input[@id='input-1'])[2]"); // Locator for Information Search field
	By atlInfosearchbtn = By.xpath("(//button[@class = 'imc-searchform--button--search'])[2]"); //Locator for Seach button for global search
	By atlsearchbtn = By.xpath("//button[@class = 'imc-searchform--button--search']"); //Locator for Seach button for global search
	By lvmSearchBtnUAT = By.xpath("(//div[@class='imc-searchform--row'])[1]/form[1]/button[2]"); //Locator for Seach button for global search
	By atlverifyglobalseacrh = By.xpath("//div[@class = 'imc-gallery__item']/div[1]/section[1]/span[1]/div[1]"); // Locator for global search verification
	By atlsearchresultslist = By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li/span/span"); //Locator for Search results list
	By atlsearchresultexhtypelist = By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li/span/span/span[2]"); //Locator for list of search results types
	By atlsearchresultlinetypelist = By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li/span/span/span[2]"); //Locator for list of search result Line type
	By atlproductsearchresultlist = By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li/span/span"); //Locator for Product suggestion search list
	By atlclearsearchbtn = By.xpath("(//button[@aria-label='Clear Search'])[position()=1]"); //Locator for Clear Search button
	By atlsearchresultproducttypelist = By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li/span/span/span[5]"); //Locator for list of search result product type
	By atlsearchresultInfoLink = By.xpath("//a[@id='Information']"); //Locator for list of search result Info Link
	By atlCatalog = By.xpath("(//div[@class='imc-products-overview--gallery'])[2]/div[1]/div[1]/a[1]/div[1]/div[1]/span[1]/span[1]"); //Locator for list of search result Catalog 
	By CatalogHeaderName = By.xpath("//div[@class='imc-pdfview--display']/div[1]/h1[1]"); //Locator for Catalog header
	By atlsearchresultArticlesLink = By.xpath("//a[@id='Articles']"); //Locator for Article Link
	By atlsearchresultBlog = By.xpath("(//div[@class='imc-gallery__item'])[1]/section[1]/span[1]/div[1]"); //Locator for Article Link
	By atlsearchresult = By.xpath("//div[@class='alert-box  ']"); //Locator for Search result 
	By atlInfoSearchJuniperMarketBtn = By.xpath("//a[contains(text(),'See More Details')]"); //Locator for Juniper Market Btn
	By atlInfoSearchTopicsFilter = By.xpath("//a[@aria-label='Topics']"); //Locator for Topics filter
	By atlInfoSearchTopicsMarketSnapshot = By.xpath("//div[@class='imc-content--border imc-vr--xlarge imc-informationcard'][1]/div/div/div[2]/ul/li[2]/button"); //Locator for Topics filter Market snapshot
	//By atlInfoSearchSeeMoreDetailsBtn = By.xpath("//a[@href='/exhibitor']"); //Locator for See More Details Btn
	By atlInfoSearchSeeMoreDetailsBtn = By.xpath("//a[contains(text(),'See More Details')]"); //Locator for See More Details Btn

	By atlExhibitorFilter = By.xpath("(//label[@class='imc-checkbox--label imc-filteritem--label-width imc-type--title-2-ui'])[1]"); //Locator for Exhibitor filter
	By atlExhibitorHeader = By.xpath("//div[@class='imc-gallery imc-gallery--65-35 breadcrumbs__round']//ul//li[2]/a[1]"); //Locator for Exhibitor Header
	By atlExhibitorCatalogName = By.xpath("//div[@class='imc-exhibitors--alternated-section imc-section--full-width-mobile imc-content--display-flex imc-content--display-flex-grow-1']/div[1]/div[2]//div[1]/div[1]/div[1]//a[1]/div[1]/div[1]/span[1]/span[1]"); //Locator for Exhibitor Catalog name
	By atlArticleHeader = By.xpath("//div[@id='root']/section[1]/section[1]/section[1]/h1[1]"); //Locator for Article Header	
	By atlArticleTag = By.xpath("//div[@class='imc-blog-tag-module imc-vr--titan imc-breakpoint-display--hide-mobile']/span[1]"); //Locator for Article Tag
	By atlArticleName = By.xpath("//div[@class='imc-vr--xxlarge imc-margin--top--large--mobile']/div[1]/div[1]/a[1]"); //Locator for Article Name
	By atlArticleSeeMoreBtn = By.xpath("//div[@class='imc-vr--xxlarge imc-margin--top--large--mobile']/div[1]/div[2]/div[3]/a[1]"); //Locator for Article See More Btn
	By atlBlogSeeAllBtn = By.xpath("//div[@class='imc-vr--xxlarge imc-margin--top--large--mobile']/div[1]/div[2]/div[3]/a[1]"); //Locator for Blog See All Btn
	By atlseealllineslink = By.xpath("//div[@class = 'imc-exhibitorcard--text-container-row']/a[1]"); //Locator for Sell All lines link
	By atlShowSpecialsTab = By.xpath("//a[@id = 'Specials']"); //Locator for Show Specials tab
	By atlVerifyShowSpecials = By.xpath("//div[@class = 'imc-tabs__body imc-section']"); //Locator for Show Specials section
	By fourthbreadcrumbtxt = By.xpath("//li[@data-xpath='breadcrumb.active.link'][3]/a"); //Locator for 4th Breadcrumb text in app
	By atleventstabinsearch =  By.xpath("//div[@id='Events']"); //Locator for Events tab in Search
	By atlseemoredetailsbtn = By.xpath("//a[contains(text(),'See More Details')]"); //Locator for See More Details button
	By eventsatlmkttopicsfilter = By.xpath("//label[contains(text(),'Atlanta Market')]"); //Locator for Atlanta Market topics filter
	By clearfiltersbtn = By.xpath("//a[@class='clear-filter active']"); //Locator for Clear Filters btn
	By eventtypesfilter = By.xpath("//h4[contains(text(),'Event Types')]"); //Locator for Event Types filter
	By atmarketeventtypefilter = By.xpath("//label[contains(text(),'At Market')]"); //Locator for At Market Event Type
	By buyingeventtypefilter = By.xpath("//label[contains(text(),'Buying Event')]"); //Locator for Buying Event Type
	
	
	public ATLGlobalSearchPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
		PageFactory.initElements(driver, this);
	} 

	public WebElement getATLGlobalSearchTextBox() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlglobalsearchtxtbx));
		return driver.findElement(atlglobalsearchtxtbx);
	}

	public WebElement getATLSearchButton() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlsearchbtn));
		return driver.findElement(atlsearchbtn);
	}

	public WebElement getATLVerifyGlobalSeacrh() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlverifyglobalseacrh));
		return driver.findElement(atlverifyglobalseacrh);
	}
	public List<WebElement> getATLSearchResultsList() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlsearchresultslist));
		return driver.findElements(atlsearchresultslist);
	}
	public List<WebElement> getATLSearchResultExhTypeList() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlsearchresultexhtypelist));
		return driver.findElements(atlsearchresultexhtypelist);
	}
	public List<WebElement> getATLSearchResultTypeLineList() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlsearchresultlinetypelist));
		return driver.findElements(atlsearchresultlinetypelist);
	}
	public List<WebElement> getATLProductsSearchResultsList() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlproductsearchresultlist));
		return driver.findElements(atlproductsearchresultlist);
	}
	public WebElement getATLClearSearchBtn() {
		return driver.findElement(atlclearsearchbtn);
	}
	public List<WebElement> getATLSearchResultPorductTypeList() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlsearchresultproducttypelist));
		return driver.findElements(atlsearchresultproducttypelist);
	}
	public WebElement getLVMSearchBtnUAT() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(lvmSearchBtnUAT));
		return driver.findElement(lvmSearchBtnUAT);
	}
	public WebElement getATLsearchresultInfoLink() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlsearchresultInfoLink));
		return driver.findElement(atlsearchresultInfoLink);
	}
	public WebElement getAtlCatalog() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlCatalog));
		return driver.findElement(atlCatalog);
	}
	public WebElement getCatalogHeaderName() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(CatalogHeaderName));
		return driver.findElement(CatalogHeaderName);
	}
	public WebElement getATLsearchresultArticlesLink() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlsearchresultArticlesLink));
		return driver.findElement(atlsearchresultArticlesLink);
	}
	public WebElement getATLSearchResultBlog() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlsearchresultBlog));
		return driver.findElement(atlsearchresultBlog);
	}
	public WebElement getATLSearchResult() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlsearchresult));
		return driver.findElement(atlsearchresult);
	}		
	public WebElement getATLInfoSearchJuniperMarketBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlInfoSearchJuniperMarketBtn));
		return driver.findElement(atlInfoSearchJuniperMarketBtn);
	}		
	public WebElement getATLInfoSearchTopicsFilter() throws InterruptedException {

		Thread.sleep(5000);
		/*wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlInfoSearchTopicsFilter));*/
		return driver.findElement(atlInfoSearchTopicsFilter);
	}		
	public WebElement getATLInfoSearchTopicsMarketSnapshot() throws InterruptedException {
		/*wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlInfoSearchTopicsMarketSnapshot));*/
		Thread.sleep(5000);
		return driver.findElement(atlInfoSearchTopicsMarketSnapshot);
	}		
	public WebElement getATLInfoSearchSeeMoreDetailsBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlInfoSearchSeeMoreDetailsBtn));
		return driver.findElement(atlInfoSearchSeeMoreDetailsBtn);
	}		
									
	public WebElement getATLExhibitorFilter() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlExhibitorFilter));
		return driver.findElement(atlExhibitorFilter);
	}		
	public WebElement getATLExhibitorHeader() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlExhibitorHeader));
		return driver.findElement(atlExhibitorHeader);
	}								
	public WebElement getATLInfosearchtxtbx() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlInfosearchtxtbx));
		return driver.findElement(atlInfosearchtxtbx);
	}								
	public WebElement getATLInfosearchbtn() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(atlInfosearchbtn);
	}								
	public WebElement getATLExhibitorCatalogName() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(atlExhibitorCatalogName);
	}								
	public WebElement getATLArticleHeader() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(atlArticleHeader);
	}								
	public WebElement getATLArticleTag() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(atlArticleTag);
	}								
	public WebElement getATLArticleName() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(atlArticleName);
	}								
	public WebElement getATLArticleSeeMoreBtn() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(atlArticleSeeMoreBtn);
	}								
	public WebElement getATLBlogSeeAllBtn() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(atlBlogSeeAllBtn);
	}								
	public WebElement getatlseealllineslink() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlseealllineslink));
		return driver.findElement(atlseealllineslink);
	}	
	public WebElement getatlShowSpecialsTab() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlShowSpecialsTab));
		return driver.findElement(atlShowSpecialsTab);
	}
	public WebElement getatlVerifyShowSpecials() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlVerifyShowSpecials));
		return driver.findElement(atlVerifyShowSpecials);
	}
	public WebElement getFourthBreadcrumbTxtInApp() {
		return driver.findElement(fourthbreadcrumbtxt);
	}
	public WebElement getATLEventsTabInSearch() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atleventstabinsearch));
		return driver.findElement(atleventstabinsearch);
	}
	public WebElement getATLSeeMoreDetailsBtn() {
		return driver.findElement(atlseemoredetailsbtn);
	}
	public WebElement getEventsATLMktTopics() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eventsatlmkttopicsfilter));
		return driver.findElement(eventsatlmkttopicsfilter);
	}
	public WebElement getClearFiltersBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(clearfiltersbtn));
		return driver.findElement(clearfiltersbtn);
	}
	public WebElement getEventTypesFilter() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eventtypesfilter));
		return driver.findElement(eventtypesfilter);
	}
	public WebElement getAtMarketEventType() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atmarketeventtypefilter));
		return driver.findElement(atmarketeventtypefilter);
	}
	public WebElement getBuyingEventType() {
		return driver.findElement(buyingeventtypefilter);
	}
	
	
}



