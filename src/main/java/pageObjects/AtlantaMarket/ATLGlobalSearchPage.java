package pageObjects.AtlantaMarket;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import bsh.This;

public class ATLGlobalSearchPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By atlglobalsearchtxtbx = By.xpath("//input[@id='input-1']"); // Locator for Global Search field 
	By atlInfosearchtxtbx = By.xpath("(//input[@id='input-1'])[2]"); // Locator for Information Search field
	By atlInfosearchbtn = By.xpath("(//div[@class = 'imc-searchform--button--search'])[2]"); //Locator for Seach button for global search
	By atlsearchbtn = By.xpath("//div[@class = 'imc-searchform--button--search']"); //Locator for Seach button for global search
	By lvmSearchBtnUAT = By.xpath("(//div[@class='imc-searchform--row'])[1]/form[1]/button[2]"); //Locator for Seach button for global search
	By atlverifyglobalseacrh = By.xpath("//div[@class = 'imc-gallery__item']/div[1]/section[1]/span[1]/div[1]"); // Locator for global search verification
	By atlsearchresultslist = By.xpath("//a[@class='imc-link--hover-underline imc-content--delta imc-content--pointer']"); //Locator for Search results list
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
	By atlInfoSearchMoreInfoBtn = By.xpath("(//a[contains(text(),'See More Details')])[1]"); //Locator for Juniper Market Btn
	
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
	
	By atlShowSpecialsTab = By.xpath("//div[@class='imc-content--display-flex--right imc-content--full-width-mobile imc-products-overview--cta-bar imc-content--display-flex imc-content--display-flex-center']/descendant::span[contains(text(),'Specials')][1]"); //Locator for Show Specials tab
	By atlVerifyShowSpecials = By.xpath("//div[@class = 'imc-tabs__body imc-section']"); //Locator for Show Specials section
	By atlVerifyShowSpecialsUAT = By.xpath("//a[@class = 'imc-tabs__body imc-section']"); //Locator for Show Specials section
	By fourthbreadcrumbtxt = By.xpath("//li[@data-xpath='breadcrumb.active.link'][3]/a"); //Locator for 4th Breadcrumb text in app
	By atleventstabinsearch =  By.xpath("//div[@id='Events']"); //Locator for Events tab in Search
	By atleventstabinsearchDiv =  By.xpath("//a[@id='Events']"); //Locator for Events tab in Search
	By atleventstabinsearchUAT =  By.xpath("//a[@id='Events']"); //Locator for Events tab in Search
	By atlseemoredetailsbtn = By.xpath("//a[contains(text(),'See More Details')]"); //Locator for See More Details button
	By eventsatlmkttopicsfilter = By.xpath("//label[contains(text(),'Atlanta Market')]"); //Locator for Atlanta Market topics filter
	By clearfiltersbtn = By.xpath("//a[@class='clear-filter active']"); //Locator for Clear Filters btn
	By eventtypesfilter = By.xpath("//h4[contains(text(),'Event Types')]"); //Locator for Event Types filter
	By atmarketeventtypefilter = By.xpath("//label[contains(text(),'At Market')]"); //Locator for At Market Event Type
	By buyingeventtypefilter = By.xpath("//label[contains(text(),'Buying Event')]"); //Locator for Buying Event Type
	By listOfAllArticles = By.xpath("//div[@class='imc-articlecard__header']"); //Locator for List of all articles
	By TitleOfArticle = By.xpath("//div[@class='imc-gallery imc-gallery--65-35 breadcrumbs__round']/div[1]/ul[1]/li[2]/a[1]"); //Locator for List of all articles
	By atlseealllineslinkUAT = By.xpath("//div[@class = 'imc-exhibitorcard-button-wrapper']/div[1]/div[1]/p[2]"); //Locator for Sell All lines link
	By fourthbreadcrumbtxtUAT = By.xpath("//ul[@class='imc-breadcrumb']/li[4]/a[1]"); //Locator for 4th Breadcrumb text in app
	By atlGlobalSearchSortBtn = By.xpath("//div[@class='imc-vr--large']/section[1]/div[1]/div[3]"); //Locator for Global Search Sort Btn
	By atlGlobalSearch_SearchWithinDropdwn = By.xpath("//select[@name='Search Type']"); //Locator for Global Search SearchWithhn Dropdown
	By atlListOfAllExh = By.xpath("//div[@class='imc-exhibitorcard-title-row ']"); //Locator for All Exhibitors
	By atlListOfAllExhLocation = By.xpath("//div[@class='imc-exhibitorcard-title-row ']/div[2]"); //Locator for All Exhibitors Location
	By atlListOfAllExhTotalProductLink = By.xpath("//div[@class='imc-exhibitorcard--prod-item-container']/p"); //Locator for All Exhibitors Total Product Links
	By atlListOfAllExhMatchingProductLink = By.xpath("//div[@class='imc-exhibitorcard--prod-item-container imc-exhibitorcard--prod-item-container--divider']/p"); //Locator for All Exhibitors Matching Product Links
	By atlListOfAllProducts = By.xpath("//div[@class='imc-exhibitorcard-products-row imc-content--display-flex-space-between-mobile ']"); //Locator for All Product Links
	By atlListOfAllProductsName = By.xpath("//div[@class='imc-exhibitorcard-products-row imc-content--display-flex-space-between-mobile ']/div/p"); //Locator for All Product Names
	By atlGlobalSearch_SearchSortByDropdwn = By.xpath("//select[@name='Sort by']");  //Locator for Global Search Sort By Dropdown
	By atlGlobalSearchExhLocationList = By.xpath("//div[@class='imc-exhibitorcard-title-row ']/div[2]/div[1]/div[1]/a");  //Locator for Location list
	By atlExhNames = By.xpath("//div[@class='imc-exhibitorcard-title-row ']/div[1]/a[1]/h2");  //Locator for Exhibitors Name list
	By atlMachingProductCount = By.xpath("//div[@class='imc-exhibitorcard--prod-item-container imc-exhibitorcard--prod-item-container--divider']/p[1]");  //Locator for Matching prod count list
	By atlFilterByNameDropDown = By.xpath("//select[@id='dropdown-filter-by-letter']");  //Locator for Filter By Name Dropdown
	By atlExhiNameForFilterByName = By.xpath("//div[@class='imc-exhibitorcard-title-row ']/div[1]");  //Locator for Exh Name for Filter by name
	By atlSelectBtn = By.xpath("//div[@class='imc-vr--large']/section[1]/div[1]/div[2]");  //Locator for Select Btn
	By atlExhCheckbox = By.xpath("(//div[@class='imc-padding--right--large']/input[1])[1]");  //Locator for Exh checkbox
	By atlAddToFavBtn = By.xpath("//div[@class='imc-searchform--bar--dropdown open']/div[2]/button[1]");  //Locator for Add To Fav Btn
	By atl1STExhiName = By.xpath("(//div[@class='imc-exhibitorcard-title-row ']/div[1]/a[1]/h2[1])[1]");  //Locator for Exh Name 
	By atlAddToExistingList = By.xpath("//div[@class='imc-searchform--bar--dropdown open']/div[3]/button[1]");  //Locator for Add Existing list Btn
	By atlExistingList = By.xpath("//div[@class='imc-vr--xlarge']/div[2]/label[1]");  //Locator for  Existing list
	By atlAddToSelectBtn = By.xpath("//div[@class='imc-button--justify-right']/input[1]");  //Locator for Add To list Btn
	By atlGoToMPBtn = By.xpath("//div[@class='imc-modal--content']/div[1]/div[1]/a[1]");  //Locator for Go to MP Btn
	By atlSavedSearchesIcon = By.xpath("//div[@class='imc-vr--large']/section[1]/div[1]/div[1]");  //Locator for Saved Searches Icon
	By atlSavedSearchesDropdown = By.xpath("//div[@class='imc-searchform--bar--dropdown open']/div[1]/div[1]/div[1]/div[1]/select[1]");  //Locator for Saved Searches Dropdown
	By atlSavedSearchesBtn = By.xpath("//button[@class='imc-button--muted-inverted imc-icon--bookmark imc-button--full-width']");  //Locator for Saved Searches Dropdown
	By atlSavedSearchesInputBox = By.xpath("//input[@name='searchName']");  //Locator for Saved Searches input box
	By atlSavedSearchesBtnForNewSaved = By.xpath("//input[@type='submit']");  //Locator for Saved Searches input box
	By atlListOfAllSavedSearches = By.xpath("//div[@class='imc-searchform--bar--dropdown open']/div[1]/div[1]/div[1]/div[1]/select[1]/option");  //Locator for Saved Searches input box
	By atlExhibitorsAndProductTab = By.xpath("//div[@class='imc-navigation imc-breakpoint-display--hide-mobile']/div[2]");  //Locator for Exhibitors And Product Tab
	By atlShowSpecialsLink = By.xpath("//a[contains(text(),'Show Specials')]");  //Locator for Show Secials
	By atlShowSpecialsTitle = By.xpath("//div[@class='imc-gallery imc-gallery--65-35 breadcrumbs__round']/div[1]/ul[1]/li[3]/a[1]");  //Locator for Show Secials Title
	By atlLineBreadcrumbForShowSpecials = By.xpath("//div[@class='imc-gallery imc-gallery--65-35 breadcrumbs__round']/div[1]/ul[1]/li[4]/a[1]");  //Locator for Show Secials Title
	By atlShowSpecialsExhName = By.xpath("//div[@class='imc-gallery imc-gallery--align-flex-start imc-gallery--1-4 imc-vr--collosal imc-fprod-cont imc-specials-list']/div[1]/div[1]/a[1]");  //Locator for Show Secials Name
	By atlShowroomLink = By.xpath("//div[@class='ag-center-cols-container']/div[1]/div[2]/a");  //Locator for Showroom Name
	By atlGlobalSearchClearTxt = By.xpath("//div[@class='imc-header-subnav']/div[1]/div[1]/section[1]/div[1]/form[1]/button[1]");  //Locator for Showroom Name
	
	By atlShowSpecialsExhNamePROD = By.xpath("(//div[@class='imc-showSpecial--tableContainer'])[1]/p[1]");  //Locator for Show Secials Name Exhibitor
	By atlSelectList = By.xpath("//select[@name='Saved Searches']");  //Locator for Show Secials Name
	By atlClosePopup = By.xpath("//div[@class=' contact-exit']");  //Locator for Show Secials Name
	By FirstInfoName = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/h2[1]");  //Locator for Show Secials Name
	By FirstEventName = By.xpath("//div[@class='imc-vr--xxlarge imc-margin--top--large--mobile']/div[1]/div[1]/span[1]");  //Locator for 1st name of Event
	By seeAllLinkMatchingProduct = By.xpath("(//div[@class='imc-gallery__item imc-exhibitorcard imc-line']/descendant::h2[@class='imc-exhibitorcard__exhibitorname imc-exhibitorcard--title-hover'])[1]");  //Locator for 1st name of Event
	By FirstCatalogName = By.xpath("(//div[@class='imc-exhibitorcard-products-row imc-content--display-flex-space-between-mobile '])[1]/div[2]/p[1]");  //Locator for 1st name of Catalog

	By viewbranddetailslink = By.xpath("(//div[@col-id='viewDetails'])[2]"); //Locator for View Brand details link of 1st Show Special

	By FirstShowSpecialName = By.xpath("(//div[@class='imc-showSpecial--tableContainer']/p[1])[1]");  //Locator for 1st name of Catalog
	By FirstShowSpecialViewBrandDetailsBtn = By.xpath("(//a[@class='imc-showSpecial--link'])[1]");  //Locator for 1st name of Catalog
	By infoTitleOnSeeDetailsPage = By.xpath("//div[@class='imc-gallery imc-gallery--65-35 breadcrumbs__round']//ul//li[3]/a[1]");  //Locator for 1st name of Catalog
	By infoTitle = By.xpath("(//h2[@class='imc-informationcard__title'])[1]");  //Locator for 1st name of Catalog
	By atlGlobalSearchSortBtnNew = By.xpath("//div[@id='searchBarButton-2']/button"); //Locator for Global Search Sort Btn
	By atlGlobalSearchSortBtnNewUAT = By.xpath("//button[@class='imc-searchform--bar--button ' and contains(text(), 'Sort')]"); //Locator for Global Search Sort Btn
	By atlInfosearchtxtbxclr = By.xpath("(//div[@class='imc-searchform--row']//descendant::button[@aria-label='Clear Search'])[2]");
	By atlEventFilterBuyingEvent= By.xpath("//label[contains(text(),'Buying Event')]");
	By atlInfoNameList= By.xpath("//h2[@class='imc-informationcard__title']");
	By atlShowSpecialsLineNamePROD = By.xpath("(//div[@class='imc-showSpecial--tableContainer'])[1]/p[1]");  //Locator for Show Secials Name Line
	
	By atlproductlNameList= By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li/span/span/span[contains(text(),'Product')]"); //Locator for Product suggestion search list
	By lvmSuggetionList1stName= By.xpath("(//div[@class='imc-searchform--drawer--suggestions']/ul/li)[1]"); 
	By ExhibitorTitle= By.xpath("//a[@class='imc-link--hover-underline imc-content--delta imc-content--pointer']/../../../div/h4"); 
	
	
	public ATLGlobalSearchPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getlExhibitorTitle() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExhibitorTitle));
		return driver.findElement(ExhibitorTitle);
	}
	
	public WebElement getlvmSuggetionList1stName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmSuggetionList1stName));
		return driver.findElement(lvmSuggetionList1stName);
	}
	public List<WebElement> getatlproductlNameList() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlproductlNameList));
		return driver.findElements(atlproductlNameList);
	}
	public List<WebElement> getatlInfoNameList() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlInfoNameList));
		return driver.findElements(atlInfoNameList);
	}
	
	public WebElement atlEventFilterBuyingEvent() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlEventFilterBuyingEvent));
		return driver.findElement(atlEventFilterBuyingEvent);
	}
	public WebElement infoTitle() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(infoTitle));
		return driver.findElement(infoTitle);
	}
	public WebElement getinfoTitleOnSeeDetailsPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(infoTitleOnSeeDetailsPage));
		return driver.findElement(infoTitleOnSeeDetailsPage);
	}
	public WebElement getatlInfoSearchMoreInfoBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlInfoSearchMoreInfoBtn));
		return driver.findElement(atlInfoSearchMoreInfoBtn);
	}
	public WebElement getFirstShowSpecialViewBrandDetailsBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(FirstShowSpecialViewBrandDetailsBtn));
		return driver.findElement(FirstShowSpecialViewBrandDetailsBtn);
	}
	public WebElement getFirstShowSpecialName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(FirstShowSpecialName));
		return driver.findElement(FirstShowSpecialName);
	}
	public WebElement getFirstCatalogName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(FirstCatalogName));
		return driver.findElement(FirstCatalogName);
	}
	public WebElement getseeAllLinkMatchingProduct() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(seeAllLinkMatchingProduct));
		return driver.findElement(seeAllLinkMatchingProduct);
	}
	public WebElement getATLFirstEventName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(FirstEventName));
		return driver.findElement(FirstEventName);
	}
	public WebElement getATLEventsTabInSearchDiv() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atleventstabinsearchDiv));
		return driver.findElement(atleventstabinsearchDiv);
	}
	public WebElement getFirstInfoName() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(FirstInfoName));
		return driver.findElement(FirstInfoName);
	}
	public WebElement getatlClosePopup() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlClosePopup));
		return driver.findElement(atlClosePopup);
	}
	public WebElement getatlSelectList() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlSelectList));
		return driver.findElement(atlSelectList);
	}
	public WebElement getatlShowSpecialsExhNamePROD() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlShowSpecialsExhNamePROD));
		return driver.findElement(atlShowSpecialsExhNamePROD);
	}
	public WebElement getatlGlobalSearchClearTxt() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlGlobalSearchClearTxt));
		return driver.findElement(atlGlobalSearchClearTxt);
	}
	public WebElement getatlShowroomLink() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlShowroomLink));
		return driver.findElement(atlShowroomLink);
	}
	public WebElement getatlShowSpecialsExhName() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlShowSpecialsExhName));
		return driver.findElement(atlShowSpecialsExhName);
	}
	public WebElement getatlShowSpecialsTitle() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlShowSpecialsTitle));
		return driver.findElement(atlShowSpecialsTitle);
	}
	public WebElement getatlLineBreadcrumbForShowSpecials() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlLineBreadcrumbForShowSpecials));
		return driver.findElement(atlLineBreadcrumbForShowSpecials);
	}
	public WebElement getatlShowSpecialsLink() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlShowSpecialsLink));
		return driver.findElement(atlShowSpecialsLink);
	}
	public WebElement getatlExhibitorsAndProductTab() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlExhibitorsAndProductTab));
		return driver.findElement(atlExhibitorsAndProductTab);
	}
	public List<WebElement> getatlListOfAllSavedSearches() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlListOfAllSavedSearches));
		return driver.findElements(atlListOfAllSavedSearches);
	}
	public WebElement getatlSavedSearchesBtnForNewSaved() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlSavedSearchesBtnForNewSaved));
		return driver.findElement(atlSavedSearchesBtnForNewSaved);
	}
	public WebElement getatlSavedSearchesInputBox() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlSavedSearchesInputBox));
		return driver.findElement(atlSavedSearchesInputBox);
	}
	public WebElement getatlSavedSearchesBtn() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlSavedSearchesBtn));
		return driver.findElement(atlSavedSearchesBtn);
	}
	public WebElement getatlSavedSearchesDropdown() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlSavedSearchesDropdown));
		return driver.findElement(atlSavedSearchesDropdown);
	}
	public WebElement getatlSavedSearchesIcon() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlSavedSearchesIcon));
		return driver.findElement(atlSavedSearchesIcon);
	}
	public WebElement getatlGoToMPBtn() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlGoToMPBtn));
		return driver.findElement(atlGoToMPBtn);
	}
	public WebElement getatlAddToSelectBtn() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlAddToSelectBtn));
		return driver.findElement(atlAddToSelectBtn);
	}
	public WebElement getatlExistingList() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlExistingList));
		return driver.findElement(atlExistingList);
	}
	public WebElement getatlAddToExistingList() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlAddToExistingList));
		return driver.findElement(atlAddToExistingList);
	}
	public WebElement getatl1STExhiName() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atl1STExhiName));
		return driver.findElement(atl1STExhiName);
	}
	public WebElement getatlGlobalSearchAddToFavBtn() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlAddToFavBtn));
		return driver.findElement(atlAddToFavBtn);
	}
	public WebElement getatlGlobalSearchExhCheckbox() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlExhCheckbox));
		return driver.findElement(atlExhCheckbox);
	}
	public WebElement getatlGlobalSearchSelectBtn() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlSelectBtn));
		return driver.findElement(atlSelectBtn);
	}
	public List<WebElement> getatlExhiNameForFilterByName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlExhiNameForFilterByName));
		return driver.findElements(atlExhiNameForFilterByName);
	}
	public WebElement getatlFilterByNameDropDown() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlFilterByNameDropDown));
		return driver.findElement(atlFilterByNameDropDown);
	}
	public List<WebElement> getatlMachingProductCount() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlMachingProductCount));
		return driver.findElements(atlMachingProductCount);
	}
	public List<WebElement> getatlExhNames() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlExhNames));
		return driver.findElements(atlExhNames);
	}
	public List<WebElement> getatlGlobalSearchExhLocationList() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlGlobalSearchExhLocationList));
		return driver.findElements(atlGlobalSearchExhLocationList);
	}
	public WebElement getatlGlobalSearch_SearchSortByDropdwn() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlGlobalSearch_SearchSortByDropdwn));
		return driver.findElement(atlGlobalSearch_SearchSortByDropdwn);
	}
	public List<WebElement> getatlListOfAllProductsName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlListOfAllProductsName));
		return driver.findElements(atlListOfAllProductsName);
	}
	public List<WebElement> getatlListOfAllProducts() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlListOfAllProducts));
		return driver.findElements(atlListOfAllProducts);
	}
	public List<WebElement> getatlListOfAllExhMatchingProductLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlListOfAllExhMatchingProductLink));
		return driver.findElements(atlListOfAllExhMatchingProductLink);
	}
	public List<WebElement> getatlListOfAllExhTotalProductLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlListOfAllExhTotalProductLink));
		return driver.findElements(atlListOfAllExhTotalProductLink);
	}
	public List<WebElement> getatlListOfAllExhLocation() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlListOfAllExhLocation));
		return driver.findElements(atlListOfAllExhLocation);
	}
	public List<WebElement> getatlListOfAllExh() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlListOfAllExh));
		return driver.findElements(atlListOfAllExh);
	}
	public WebElement getatlGlobalSearch_SearchWithinDropdwn() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlGlobalSearch_SearchWithinDropdwn));
		return driver.findElement(atlGlobalSearch_SearchWithinDropdwn);
	}
	public WebElement getatlGlobalSearchSortBtn() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlGlobalSearchSortBtn));
		return driver.findElement(atlGlobalSearchSortBtn);
	}
	public WebElement getfourthbreadcrumbtxtUAT() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(fourthbreadcrumbtxtUAT));
		return driver.findElement(fourthbreadcrumbtxtUAT);
	}
	public WebElement getatlseealllineslinkUAT() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlseealllineslinkUAT));
		return driver.findElement(atlseealllineslinkUAT);
	}
	public WebElement getatleventstabinsearchUAT() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atleventstabinsearchUAT));
		return driver.findElement(atleventstabinsearchUAT);
	}
	public WebElement getTitleOfArticle() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(TitleOfArticle));
		return driver.findElement(TitleOfArticle);
	}
	public List<WebElement> getATLlistOfAllArticles() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(listOfAllArticles));
		return driver.findElements(listOfAllArticles);
	}
	public WebElement getATLGlobalSearchTextBox() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlglobalsearchtxtbx));
		return driver.findElement(atlglobalsearchtxtbx);
	}
	public WebElement getATLSearchButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlsearchbtn));
		return driver.findElement(atlsearchbtn);
	}
	public WebElement getATLVerifyGlobalSeacrh() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlverifyglobalseacrh));
		return driver.findElement(atlverifyglobalseacrh);
	}
	public List<WebElement> getATLSearchResultsList() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlsearchresultslist));
		return driver.findElements(atlsearchresultslist);
	}
	public List<WebElement> getATLSearchResultExhTypeList() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlsearchresultexhtypelist));
		return driver.findElements(atlsearchresultexhtypelist);
	}
	public List<WebElement> getATLSearchResultTypeLineList() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlsearchresultlinetypelist));
		return driver.findElements(atlsearchresultlinetypelist);
	}
	public List<WebElement> getATLProductsSearchResultsList() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlproductsearchresultlist));
		return driver.findElements(atlproductsearchresultlist);
	}
	public WebElement getATLClearSearchBtn() {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      wait.until(ExpectedConditions.visibilityOfElementLocated(atlclearsearchbtn));
		return driver.findElement(atlclearsearchbtn);
	}
	public List<WebElement> getATLSearchResultPorductTypeList() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlsearchresultproducttypelist));
		return driver.findElements(atlsearchresultproducttypelist);
	}
	public WebElement getLVMSearchBtnUAT() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(lvmSearchBtnUAT));
		return driver.findElement(lvmSearchBtnUAT);
	}
	public WebElement getATLsearchresultInfoLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlsearchresultInfoLink));
		return driver.findElement(atlsearchresultInfoLink);
	}
	public WebElement getAtlCatalog() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlCatalog));
		return driver.findElement(atlCatalog);
	}
	public WebElement getCatalogHeaderName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(CatalogHeaderName));
		return driver.findElement(CatalogHeaderName);
	}
	public WebElement getATLsearchresultArticlesLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlsearchresultArticlesLink));
		return driver.findElement(atlsearchresultArticlesLink);
	}
	public WebElement getATLSearchResultBlog() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlsearchresultBlog));
		return driver.findElement(atlsearchresultBlog);
	}
	public WebElement getATLSearchResult() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlsearchresult));
		return driver.findElement(atlsearchresult);
	}		
	public WebElement getATLInfoSearchJuniperMarketBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlInfoSearchJuniperMarketBtn));
		return driver.findElement(atlInfoSearchJuniperMarketBtn);
	}		
	public WebElement getATLInfoSearchTopicsFilter() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlInfoSearchTopicsFilter));
		return driver.findElement(atlInfoSearchTopicsFilter);
	}		
	public WebElement getATLInfoSearchTopicsMarketSnapshot() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlInfoSearchTopicsMarketSnapshot));
		Thread.sleep(5000);
		return driver.findElement(atlInfoSearchTopicsMarketSnapshot);
	}		
	public WebElement getATLInfoSearchSeeMoreDetailsBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlInfoSearchSeeMoreDetailsBtn));
		return driver.findElement(atlInfoSearchSeeMoreDetailsBtn);
	}		
									
	public WebElement getATLExhibitorFilter() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlExhibitorFilter));
		return driver.findElement(atlExhibitorFilter);
	}		
	public WebElement getATLExhibitorHeader() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlExhibitorHeader));
		return driver.findElement(atlExhibitorHeader);
	}								
	public WebElement getATLInfosearchtxtbx() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlInfosearchtxtbx));
		return driver.findElement(atlInfosearchtxtbx);
	}								
	public WebElement getATLInfosearchbtn() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(atlInfosearchbtn));
		return driver.findElement(atlInfosearchbtn);
	}								
	public WebElement getATLExhibitorCatalogName() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(atlExhibitorCatalogName));
		return driver.findElement(atlExhibitorCatalogName);
	}								
	public WebElement getATLArticleHeader() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(atlArticleHeader));
		return driver.findElement(atlArticleHeader);
	}								
	public WebElement getATLArticleTag() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(atlArticleTag));
		return driver.findElement(atlArticleTag);
	}								
	public WebElement getATLArticleName() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(atlArticleName));
		return driver.findElement(atlArticleName);
	}								
	public WebElement getATLArticleSeeMoreBtn() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(atlArticleSeeMoreBtn));
		return driver.findElement(atlArticleSeeMoreBtn);
	}								
	public WebElement getATLBlogSeeAllBtn() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(atlBlogSeeAllBtn));
		return driver.findElement(atlBlogSeeAllBtn);
	}								
	public WebElement getatlseealllineslink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlseealllineslink));
		return driver.findElement(atlseealllineslink);
	}	
	public WebElement getatlShowSpecialsTab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlShowSpecialsTab));
		return driver.findElement(atlShowSpecialsTab);
	}
	public WebElement getatlVerifyShowSpecials() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlVerifyShowSpecials));
		return driver.findElement(atlVerifyShowSpecials);
	}
	public WebElement getFourthBreadcrumbTxtInApp() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(fourthbreadcrumbtxt));
		return driver.findElement(fourthbreadcrumbtxt);
	}
	public WebElement getATLEventsTabInSearch() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atleventstabinsearch));
		return driver.findElement(atleventstabinsearch);
	}
	public WebElement getATLSeeMoreDetailsBtn() {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      wait.until(ExpectedConditions.visibilityOfElementLocated(atlseemoredetailsbtn));
		return driver.findElement(atlseemoredetailsbtn);
	}
	public WebElement getEventsATLMktTopics() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eventsatlmkttopicsfilter));
		return driver.findElement(eventsatlmkttopicsfilter);
	}
	public WebElement getClearFiltersBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(clearfiltersbtn));
		return driver.findElement(clearfiltersbtn);
	}
	public WebElement getEventTypesFilter() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eventtypesfilter));
		return driver.findElement(eventtypesfilter);
	}
	public WebElement getAtMarketEventType() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atmarketeventtypefilter));
		return driver.findElement(atmarketeventtypefilter);
	}
	public WebElement getBuyingEventType() {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      wait.until(ExpectedConditions.visibilityOfElementLocated(buyingeventtypefilter));
		return driver.findElement(buyingeventtypefilter);
	}
	public WebElement getViewBrandDetailsLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(viewbranddetailslink));
		return driver.findElement(viewbranddetailslink);
	}
    public WebElement getatlGlobalSearchSortBtnNew() {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      wait.until(ExpectedConditions.visibilityOfElementLocated(atlGlobalSearchSortBtnNew));
      return driver.findElement(atlGlobalSearchSortBtnNew);
  }
    public WebElement getatlGlobalSearchSortBtnNewUAT() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(atlGlobalSearchSortBtnNewUAT));
        return driver.findElement(atlGlobalSearchSortBtnNewUAT);

    }
    public WebElement getATLInfosearchtxtbxClr() {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      wait.until(ExpectedConditions.elementToBeClickable(atlInfosearchtxtbxclr));
      return driver.findElement(atlInfosearchtxtbxclr);
  }   
	public WebElement getatlShowSpecialsLineNamePROD() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlShowSpecialsLineNamePROD));
		return driver.findElement(atlShowSpecialsLineNamePROD);
	}

}

