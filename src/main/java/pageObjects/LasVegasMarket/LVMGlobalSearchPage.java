package pageObjects.LasVegasMarket;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LVMGlobalSearchPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By lvmglobalsearchtxtbx = By.xpath("//input[@id='input-1']"); // Locator for Global Search field 
	By lvmInfosearchtxtbx = By.xpath("(//input[@id='input-1'])[2]"); // Locator for Information Search field
	By lvmInfosearchbtn = By.xpath("(//div[@class = 'imc-searchform--button--search'])[2]"); //Locator for Seach button for global search
	//By lvmsearchbtn = By.xpath("//button[@class = 'imc-searchform--button--search']"); //Locator for Seach button for global search
	By lvmsearchbtn = By.xpath("//div[@class = 'imc-searchform--button--search']"); //Locator for Seach button for global search
	By lvmSearchBtnUAT = By.xpath("(//div[@class='imc-searchform--row'])[1]/form[1]/button[2]"); //Locator for Seach button for global search
	By lvmverifyglobalseacrh = By.xpath("//div[@class = 'imc-gallery__item']/div[1]/section[1]/span[1]/div[1]"); // Locator for global search verification
	By lvmsearchresultslist = By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li/span/span"); //Locator for Search results list
	By lvmsearchresultexhtypelist = By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li/span/span/span[2]"); //Locator for list of search results types
	By lvmsearchresultlinetypelist = By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li/span/span/span[2]"); //Locator for list of search result Line type
	By lvmproductsearchresultlist = By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li/span/span"); //Locator for Product suggestion search list
	By lvmclearsearchbtn = By.xpath("(//button[@aria-label='Clear Search'])[position()=1]"); //Locator for Clear Search button
	By lvmsearchresultproducttypelist = By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li/span/span/span[5]"); //Locator for list of search result product type
	By lvmsearchresultInfoLink = By.xpath("//a[@id='Information']"); //Locator for list of search result Info Link
	By lvmCatalog = By.xpath("(//div[@class='imc-products-overview--gallery'])[2]/div[1]/div[1]/a[1]/div[1]/div[1]/span[1]/span[1]"); //Locator for list of search result Catalog 
	By CatalogHeaderName = By.xpath("//div[@class='imc-pdfview--display']/div[1]/h1[1]"); //Locator for Catalog header
	By lvmsearchresultArticlesLink = By.xpath("//a[@id='Articles']"); //Locator for Article Link
	By lvmsearchresultBlog = By.xpath("(//div[@class='imc-gallery__item'])[1]/section[1]/span[1]/div[1]"); //Locator for Article Link
	By lvmsearchresult = By.xpath("//div[@class='imc-gallery__item imc-content--full-width']/div/section/span[2]"); //Locator for Search result 
	By lvmInfoSearchJuniperMarketBtn = By.xpath("//a[contains(text(),'See More Details')]"); //Locator for Juniper Market Btn
	By lvmInfoSearchMoreInfoBtn = By.xpath("(//a[contains(text(),'See More Details')])[1]"); //Locator for Juniper Market Btn
	By lvmInfoSearchTopicsFilter = By.xpath("//a[@aria-label='Topics']"); //Locator for Topics filter
	By lvmInfoSearchTopicsMarketSnapshot = By.xpath("//div[@class='imc-content--border imc-vr--xlarge imc-informationcard'][1]/div/div/div[2]/ul/li[2]/button"); //Locator for Topics filter Market snapshot
	//By lvmInfoSearchSeeMoreDetailsBtn = By.xpath("//a[@href='/exhibitor']"); //Locator for See More Details Btn
	By lvmInfoSearchSeeMoreDetailsBtn = By.xpath("//a[contains(text(),'See More Details')]"); //Locator for See More Details Btn
	By lvmExhibitorFilter = By.xpath("(//label[@class='imc-checkbox--label imc-filteritem--label-width imc-type--title-2-ui'])[1]"); //Locator for Exhibitor filter
	By lvmExhibitorHeader = By.xpath("//div[@class='imc-gallery imc-gallery--65-35 breadcrumbs__round']//ul//li[2]/a[1]"); //Locator for Exhibitor Header
	By lvmExhibitorCatalogName = By.xpath("//div[@class='imc-exhibitors--alternated-section imc-section--full-width-mobile imc-content--display-flex imc-content--display-flex-grow-1']/div[1]/div[2]//div[1]/div[1]/div[1]//a[1]/div[1]/div[1]/span[1]/span[1]"); //Locator for Exhibitor Catalog name
	By lvmArticleHeader = By.xpath("//div[@id='root']/section[1]/section[1]/section[1]/h1[1]"); //Locator for Article Header	
	By lvmArticleTitle = By.xpath("//section[@class='imc-site-wrapper']/section/section/h1"); //Locator for Article Header
	
	By lvmArticleTag = By.xpath("//div[@class='imc-blog-tag-module imc-vr--titan imc-breakpoint-display--hide-mobile']/span[1]"); //Locator for Article Tag
	By lvmArticleName = By.xpath("//div[@class='imc-vr--xxlarge imc-margin--top--large--mobile']/div[1]/div[1]/a[1]"); //Locator for Article Name
	By lvmArticleSeeMoreBtn = By.xpath("//div[@class='imc-vr--xxlarge imc-margin--top--large--mobile']/div[1]/div[2]/div[3]/a[1]"); //Locator for Article See More Btn
	By lvmBlogSeeAllBtn = By.xpath("//div[@class='imc-vr--xxlarge imc-margin--top--large--mobile']/div[1]/div[2]/div[3]/a[1]"); //Locator for Blog See All Btn
	By lvmseealllineslink = By.xpath("//div[@class = 'imc-exhibitorcard--text-container-row']/a[1]"); //Locator for Sell All lines link
	By lvmShowSpecialsTab = By.xpath("//a[@id = 'Specials']"); //Locator for Show Specials tab
	By lvmVerifyShowSpecials = By.xpath("//div[@class = 'imc-tabs__body imc-section']"); //Locator for Show Specials section
	By lvmVerifyShowSpecialsUAT = By.xpath("//a[@class = 'imc-tabs__body imc-section']"); //Locator for Show Specials section
	By fourthbreadcrumbtxt = By.xpath("//li[@data-xpath='breadcrumb.active.link'][3]/a"); //Locator for 4th Breadcrumb text in app
	By lvmeventstabinsearch =  By.xpath("//div[@id='Events']"); //Locator for Events tab in Search
	By lvmeventstabinsearchDiv =  By.xpath("//a[@id='Events']"); //Locator for Events tab in Search
	By lvmeventstabinsearchUAT =  By.xpath("//a[@id='Events']"); //Locator for Events tab in Search
	By lvmseemoredetailsbtn = By.xpath("//a[contains(text(),'See More Details')]"); //Locator for See More Details button
	By eventslvmmkttopicsfilter = By.xpath("//label[contains(text(),'Las Vegas Market')]"); //Locator for Atlanta Market topics filter
	By clearfiltersbtn = By.xpath("//button[contains(text(),'Clear Filters')]"); //Locator for Clear Filters btn
	By eventtypesfilter = By.xpath("//h4[contains(text(),'Event Types')]"); //Locator for Event Types filter
	By atmarketeventtypefilter = By.xpath("//label[@for='filteritem651']"); //Locator for At Market Event Type
	By buyingeventtypefilter = By.xpath("//label[contains(text(),'Buying Event')]"); //Locator for Buying Event Type
	By listOfAllArticles = By.xpath("//div[@class='imc-articlecard__header']"); //Locator for List of all articles
	By TitleOfArticle = By.xpath("//div[@class='imc-gallery imc-gallery--65-35 breadcrumbs__round']/div[1]/ul[1]/li[2]/a[1]"); //Locator for List of all articles
	By lvmseealllineslinkUAT = By.xpath("//div[@class = 'imc-exhibitorcard-button-wrapper']/div[1]/div[1]/p[2]"); //Locator for Sell All lines link
	By fourthbreadcrumbtxtUAT = By.xpath("//ul[@class='imc-breadcrumb']/li[4]/a[1]"); //Locator for 4th Breadcrumb text in app
	By lvmGlobalSearchSortBtn = By.xpath("//button[@class='imc-searchform--bar--button  ' and text()='Sort']"); //Locator for Global Search Sort Btn
	By lvmGlobalSearch_SearchWithinDropdwn = By.xpath("//select[@name='Search Type']"); //Locator for Global Search SearchWithhn Dropdown
	By lvmListOfAllExh = By.xpath("//div[@class='imc-exhibitorcard-title-row ']"); //Locator for All Exhibitors
	By lvmListOfAllExhLocation = By.xpath("//div[@class='imc-exhibitorcard-title-row ']/div[2]"); //Locator for All Exhibitors Location
	By lvmListOfAllExhTotalProductLink = By.xpath("//div[@class='imc-exhibitorcard--prod-item-container']/p"); //Locator for All Exhibitors Total Product Links
	By lvmListOfAllExhMatchingProductLink = By.xpath("//div[@class='imc-exhibitorcard--prod-item-container imc-exhibitorcard--prod-item-container--divider']/p"); //Locator for All Exhibitors Matching Product Links
	By lvmListOfAllProducts = By.xpath("//div[@class='imc-exhibitorcard-products-row imc-content--display-flex-space-between-mobile ']"); //Locator for All Product Links
	By lvmListOfAllProductsName = By.xpath("//div[@class='imc-exhibitorcard-products-row imc-content--display-flex-space-between-mobile ']/div/p"); //Locator for All Product Names
	By lvmGlobalSearch_SearchSortByDropdwn = By.xpath("//select[@name='Sort by']");  //Locator for Global Search Sort By Dropdown
	By lvmGlobalSearchExhLocationList = By.xpath("//div[@class='imc-exhibitorcard-title-row']/div[2]/div[1]/div[1]/a");  //Locator for Location list
	By lvmExhNames = By.xpath("//div[@class='imc-exhibitorcard-title-row ']/div[1]/a[1]/h2");  //Locator for Exhibitors Name list
	By lvmMachingProductCount = By.xpath("//div[@class='imc-exhibitorcard--prod-item-container imc-exhibitorcard--prod-item-container--divider']/p[1]");  //Locator for Matching prod count list
	By lvmFilterByNameDropDown = By.xpath("//select[@id='dropdown-filter-by-letter']");  //Locator for Filter By Name Dropdown
	By lvmExhiNameForFilterByName = By.xpath("//div[@class='imc-exhibitorcard-title-row']/div[1]");  //Locator for Exh Name for Filter by name
	By lvmSelectBtn = By.xpath("//div[@class='imc-vr--large']/section[1]/div[1]/div[2]");  //Locator for Select Btn
	By lvmExhCheckbox = By.xpath("(//div[@class='imc-padding--right--large']/input[1])[1]");  //Locator for Exh checkbox
	By lvmAddToFavBtn = By.xpath("//div[@class='imc-searchform--bar--dropdown open']/div[2]/button[1]");  //Locator for Add To Fav Btn
	By lvm1STExhiName = By.xpath("(//div[@class='imc-exhibitorcard-title-row']/div[1]/a[1]/h2[1])[1]");  //Locator for Exh Name 
	By lvmAddToExistingList = By.xpath("//div[@class='imc-searchform--bar--dropdown open']/div[3]/button[1]");  //Locator for Add Existing list Btn
	By lvm1STExhiNamePROD = By.xpath("(//div[@class='imc-exhibitorcard-title-row '])[1]/div[1]/a/h2");  //Locator for Add Existing list Btn
	
	By lvmExistingList = By.xpath("//div[@class='imc-vr--xlarge']/div[2]/label[1]");  //Locator for  Existing list
	By lvmAddToSelectBtn = By.xpath("//div[@class='imc-button--justify-right']/input[1]");  //Locator for Add To list Btn
	By lvmGoToMPBtn = By.xpath("//div[@class='imc-modal--content']/div[1]/div[1]/a[1]");  //Locator for Go to MP Btn
	By lvmSavedSearchesIcon = By.xpath("//div[@class='imc-vr--large']/section[1]/div[1]/div[1]");  //Locator for Saved Searches Icon
	By lvmSavedSearchesDropdown = By.xpath("//div[@class='imc-searchform--bar--dropdown open']/div[1]/div[1]/div[1]/div[1]/select[1]");  //Locator for Saved Searches Dropdown
	By lvmSavedSearchesBtn = By.xpath("//button[@class='imc-button--muted-inverted imc-icon--bookmark imc-button--full-width']");  //Locator for Saved Searches Dropdown
	By lvmSavedSearchesInputBox = By.xpath("//input[@name='searchName']");  //Locator for Saved Searches input box
	By lvmSavedSearchesBtnForNewSaved = By.xpath("//input[@type='submit']");  //Locator for Saved Searches input box
	By lvmListOfAllSavedSearches = By.xpath("//div[@class='imc-searchform--bar--dropdown open']/div[1]/div[1]/div[1]/div[1]/select[1]/option");  //Locator for Saved Searches input box
	By lvmExhibitorsAndProductTab = By.xpath("//div[@class='imc-navigation imc-breakpoint-display--hide-mobile']/div[2]");  //Locator for Exhibitors And Product Tab
	By lvmShowSpecialsLink = By.xpath("//span[contains(text(),'Show Specials')]");  //Locator for Show Secials
	By lvmShowSpecialsTitle = By.xpath("//div[@class='imc-gallery imc-gallery--65-35 breadcrumbs__round']/div[1]/ul[1]/li[3]/a[1]");  //Locator for Show Secials Title
	By lvmShowSpecialsExhName = By.xpath("//div[@class='imc-gallery imc-gallery--align-flex-start imc-gallery--1-4 imc-vr--collosal imc-fprod-cont imc-specials-list']/div[1]/div[1]/a[1]");  //Locator for Show Secials Name
	By lvmShowroomLink = By.xpath("//div[@class='ag-center-cols-container']/div[1]/div[2]/a");  //Locator for Showroom Name
	By lvmGlobalSearchClearTxt = By.xpath("//div[@class='imc-header-subnav']/div[1]/div[1]/section[1]/div[1]/form[1]/button[1]");  //Locator for Showroom Name
	By lvmShowSpecialsExhNamePROD = By.xpath("//p[contains(text(),'Shown By')]");  //Locator for Show Secials Name
	By lvmSelectList = By.xpath("//select[@name='Saved Searches']");  //Locator for Show Secials Name
	By lvmClosePopup = By.xpath("//div[@class=' contact-exit']");  //Locator for Show Secials Name
	By FirstInfoName = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/h2[1]");  //Locator for Show Secials Name
	By FirstEventName = By.xpath("(//p[@class='event-card--title imc-link--hover-underline normal-line-height'])[1]");  //Locator for 1st name of Event
	By seeAllLinkMatchingProduct = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[2]/div[2]/div[1]/div[1]/p[2]");  //Locator for 1st name of Event
	By FirstCatalogName = By.xpath("(//div[@class='imc-exhibitorcard-products-row imc-content--display-flex-space-between-mobile '])[1]/div[2]/p[1]");  //Locator for 1st name of Catalog
	By lvmseemoredetailsbtnnew = By.xpath("(//a[contains(text(),'Learn More')])[1]"); //Locator for See More Details button
	By FirstShowSpecialName = By.xpath("(//div[@class='imc-content--display-flex imc-content--display-flex-center imc-content--display-flex-gap-small']/a)[1]/../div/p/a/span");  //Locator for 1st name of Exh
	By FirstShowSpecialViewBrandDetailsBtn = By.xpath("(//a[@class='imc-showSpecial--link'])[1]");  //Locator for 1st name of Catalog
	By eventslvmmkttopicsfilterUat = By.xpath("//label[contains(text(),'Ahead of the Curve')]"); //Locator for Atlanta Market topics filter
	By atmarketeventtypefilterUat = By.xpath("//label[contains(text(),'Buying Event')]"); //Locator for At Market Event Type
	By lvmseemoredetailsbtnneww = By.xpath("//a[contains(text(),'View Brand Details')]"); //Locator for See More Details button
	By atmarketeventtypefilterUAT_LVM = By.xpath("(//div[@class='imc-filteritem__tier2'])[2]/div[1]/label[1]"); //Locator for At Market Event Type
	By lvmExhiNameForFilterByNameNew = By.xpath("(//div[@class='imc-exhibitorcard-title-row ']/div[1])[1]");  //Locator for Exh Name for Filter by name
	By infoTitle = By.xpath("//div[@class='imc-informationcard__body']/p[2]");  //Locator for 1st name of Catalog
	By infoTitleForInfoPage = By.xpath("(//div[@class='imc-section--inner-content imc-section--align-  imc-section-- imc-content--center-mobile'])[4]/div[3]/h2[1]/span/span[1]");  //Locator for 1st name of Catalog
	
	By lvmExhiNameForFilterByNameNewUAT = By.xpath("//div[@class='imc-exhibitorcard-title-row no-border-bottom']/div[1]");  //Locator for Exh Name for Filter by name
	
	
	By atlsearchresult = By.xpath("//div[@class='alert-box  ']"); //Locator for Search result 
	By atlInfoSearchMoreInfoBtn = By.xpath("(//a[contains(text(),'See More Details')])[1]"); //Locator for Juniper Market Btn
	By lvmShowSpecialsSection = By.xpath("//div[@class = 'imc-content--display-flex-wrap']/span[contains(text(),'Show Specials')]"); //Locator for Show Special Sections
	By lvmShowSpecialsDetailsOnShowSpecialsPage = By.xpath("//div[@class='ag-center-cols-clipper']/div[1]/div[1]/div[1]/div[3]"); //Locator for Show Special Sections
	By lvmShowSpecialsDetails = By.xpath("//div[@class = 'imc-content--display-flex-wrap']/span/span[1]"); //Locator for Show Special Sections
	By thirdThbreadCrumbtxt = By.xpath("//li[@data-xpath='breadcrumb.active.link'][2]"); //Locator for 4th Breadcrumb text in app
	By lvmShowSpecialsTitle2 = By.xpath("//div[@class='imc-gallery imc-gallery--65-35 breadcrumbs__round']/div[1]/ul[1]/li[4]/a[1]");  //Locator for Show Secials Title
	
	By lvmGlobalSearchSortBtnUAT = By.xpath("//button[@class='imc-searchform--bar--button  ' and text()='Sort']"); //Locator for Global Search Sort Btn
	
	By lvmGlobalSearchEventTypeFilterResult = By.xpath("//h4[contains(text(),'Event Types')]/following::label[1]"); //Locator for Global Search Sort Btn
	
	By GlobalSearchTextBoxNew = By.xpath("//button[@class='imc-button imc-button--search imc-button--transparent-mobile-header imc-button--transparent juniper-search-v3 ']"); // Locator for Global Search field 
	By SearchButtonNew = By.xpath("(//div[@class = 'imc-searchform--button--search'])[3]"); //Locator for Seach button for global search
	
	By VerifyGlobalSeacrhNew = By.xpath("//section[@class = 'imc-searchform--section  ']/span[1]/div[1]"); // Locator for global search verification
	
	By GlobalSearchEnterText = By.xpath("//div[@class='top-nav-dropdown-grid imc-content--relative']/div/div/section/div/form/div/input"); // Locator for Global Search field
	By LvmDiscoverTab = By.xpath("//div[@class='imc-content--display-flex imc-content--display-flex-gap-small imc-content--display-flex-justify-center imc-content--full-height']/div[3]/button/span/span[1]"); // Locator for Discover tab
	By LvmEventsMenu = By.xpath("(//a[contains(text(),'Events')])[2]"); // Locator for Events Menu
	By LvmExhibitorEvents = By.xpath("//div[@class='event-card--tab']/p[3]"); // Locator for Events Menu
	By LvmEventExhibitorName = By.xpath("(//div[@class='event-card--cal-card-container imc-content--display-flex imc-content--display-flex-gap-xlarge imc-content--relative']/div[2]/div[1]/div/div/div/div/div/div/div/div/div/div[1]/a[1])[1]"); // Locator for 1st event exhibitor name
	By LvmSortButton = By.xpath("//div[@class='imc-searchform--bar--button--wrapper']"); // Locator for 1st event exhibitor name
	By LvmSortButtonListOfLocation = By.xpath("//div[@class='imc-exhibitorcard--text-wrapper imc-content--display-flex-wrap']/div/a"); // Locator for 1st event exhibitor name
	
	By LvmSortButtonListOfProducts = By.xpath("//div[@class='imc-exhibitorcard-products-row imc-content--relative']"); // Locator for 1st event exhibitor name
	By LvmInfoTitleProd = By.xpath("//div[@class='imc-gallery__item imc-content--left']/div/div[1]/div/div/a/p"); // Locator for info title
	By LvmSearchResultsText = By.xpath("//div[@class='imc-gallery__item imc-content--full-width']/div[1]/section/span[2]/div"); // Locator for info title
	
	By LvmInfoLearnMoreLink = By.xpath("(//a[contains(text(),'Learn More')])[1]"); // Locator for info title
	
	By lvmInfosearchtxtbxPROD = By.xpath("(//input[@id='input-1'])[4]"); // Locator for Information Search field
	By lvmInfosearchbtnPROD = By.xpath("(//div[@class = 'imc-searchform--button--search'])[4]"); //Locator for Seach button for global search
	By lvmFirstCatalogPROD = By.xpath("//div[@class='imc-exhibitors--alternated-section imc-section--full-width-mobile imc-content--display-flex imc-content--display-flex-grow-1']/div/div[2]/div/div[1]"); //Locator for Seach button for global search
	By listOfAllCatalogExhibitorNames = By.xpath("//h2[@class='imc-exhibitorcard__exhibitorname imc-exhibitorcard--title-hover']"); //Locator for Seach button for global search
	By CatalogExhibitorNames1st = By.xpath("(//h2[@class='imc-exhibitorcard__exhibitorname imc-exhibitorcard--title-hover'])[1]"); //Locator for Seach button for global search
	By ArticleName = By.xpath("(//p[@class='event-card--title imc-link--hover-underline normal-line-height'])[1]"); //Locator for Seach button for global search
	By learnMoreLinkArticle = By.xpath("(//a[contains(text(),'Learn More')])[1]"); 
	
	By listOfAllTags = By.xpath("//span[@class='imc-blog-tag-module__tag']");
	
	By articleName1st = By.xpath("(//p[@class='event-card--title imc-link--hover-underline normal-line-height'])[1]");
	By ArticleNameURL = By.xpath("(//div[@class='imc-gallery__item imc-content--left'])[1]/div/div/div/div/a"); 
	By showSpecialsLink = By.xpath("//a[contains(@href,'Show-Specials')]"); 
	By showSpecialsDetailsFromShowSpecialsPage = By.xpath("(//div[@class='imc-content--display-flex imc-content--display-flex-center imc-content--display-flex-gap-small']/a)[1]/../../../td[3]/div"); 
	
	By lvmListOfExhibitors = By.xpath("//h2[@class='imc-exhibitorcard__exhibitorname imc-exhibitorcard--title-hover']"); 
	By listOfAllExhibitorsAndProducts = By.xpath("//div[@class='swiper-wrapper']/../../../../div[1]/div/div/div/div[1]/div[1]/div[1]/div/a/h2");
	
	By lvmEventsAndSeminar = By.xpath("//a[contains(text(),' Events & Seminars')]"); 
	By lvmEventsSearchNoTopicFilterText = By.xpath("//div[contains(text(),'No Topics Filters Selected')]"); 
	By EventsLink = By.xpath("(//a[contains(@href,'Events')])[2]"); 
	By listOfAllExhibitorTitles = By.xpath("//h2[@class='imc-exhibitorcard__exhibitorname imc-exhibitorcard--title-hover']");
	By listOfAllMatchingProducts = By.xpath("//span[contains(text(),'Matching Product')]/../span[1]");
	
	By eventtypeP = By.xpath("(//div[@class='imc-filteritem__tier2 imc-content--display-flex imc-content--display-flex-gap-medium imc-content--display-flex-column'])[2]/div[2]/label");
	By eventtypeNameEventCard = By.xpath("//div[@class='imc-gallery__item imc-content--left']/div/div/div[1]/p");
	By eventNameEventCard = By.xpath("(//div[@class='imc-gallery__item imc-content--left'])[1]/div/div/div[1]/div/a/p");
	By showSpecialDescriptionDGShworoomPage = By.xpath("//div[@class='imc-content--display-flex-wrap']//span[contains(text(),'Show Specials')]/../../div[3]/span/span[1]");
	By showSpecialsLoactionURL = By.xpath("(//td[@class='imc-breakpoint-display--hide-small-tablet'])[1]/div/a");
	By showSpecialsSearchVendors = By.xpath("//div[@class='imc-content--flex-grow']/input");
	By listOfAllshowSpecials = By.xpath("//div[@class='imc-content--display-flex imc-content--display-flex-center imc-content--display-flex-gap-small']/div");
	
	By showSpecialsSortByDropdown = By.xpath("//select[@id='dropdown-sort-search']");
	By ListOfALlshowSpecialsLocations = By.xpath("//td[@class='imc-breakpoint-display--hide-small-tablet']/div/a");
	By ListOfALLShowSpecialsDetails = By.xpath("//tr[@style='background-color: var(--basic-white); color: var(--neutral-heaviest);']/td[3]/div");
	
	By ShowSpecialsPageResetButton = By.xpath("//button[@class=' imc-searchform--bar--button']");
	
	public LVMGlobalSearchPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
		PageFactory.initElements(driver, this);
	}
	public WebElement getShowSpecialsPageResetButton(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(ShowSpecialsPageResetButton));
		return driver.findElement(ShowSpecialsPageResetButton);

	}
	public List<WebElement>getListOfALLShowSpecialsDetails() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ListOfALLShowSpecialsDetails));
		return driver.findElements(ListOfALLShowSpecialsDetails);
	}
	public List<WebElement>getListOfALlshowSpecialsLocations() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ListOfALlshowSpecialsLocations));
		return driver.findElements(ListOfALlshowSpecialsLocations);
	}
	public WebElement getshowSpecialsSortByDropdown(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(showSpecialsSortByDropdown));
		return driver.findElement(showSpecialsSortByDropdown);

	}
	public List<WebElement>getlistOfAllshowSpecials() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(listOfAllshowSpecials));
		return driver.findElements(listOfAllshowSpecials);
	}
	public WebElement getshowSpecialsSearchVendors(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(showSpecialsSearchVendors));
		return driver.findElement(showSpecialsSearchVendors);

	}
	public WebElement getshowSpecialsLoactionURL(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(showSpecialsLoactionURL));
		return driver.findElement(showSpecialsLoactionURL);

	}
	public WebElement getshowSpecialDescriptionDGShworoomPage(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(showSpecialDescriptionDGShworoomPage));
		return driver.findElement(showSpecialDescriptionDGShworoomPage);

	}
	public WebElement geteventNameEventCard(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(eventNameEventCard));
		return driver.findElement(eventNameEventCard);

	}
	public WebElement geteventtypeNameEventCard(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(eventtypeNameEventCard));
		return driver.findElement(eventtypeNameEventCard);

	}
	public WebElement geteventtypeP(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(eventtypeP));
		return driver.findElement(eventtypeP);

	}
	public List<WebElement>getlistOfAllMatchingProducts() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(listOfAllMatchingProducts));
		return driver.findElements(listOfAllMatchingProducts);
	}
	public List<WebElement>getlistOfAllExhibitorTitles() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(listOfAllExhibitorTitles));
		return driver.findElements(listOfAllExhibitorTitles);
	}
	public WebElement getEventsLink(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(EventsLink));
		return driver.findElement(EventsLink);

	}
	public WebElement getlvmEventsSearchNoTopicFilterText(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmEventsSearchNoTopicFilterText));
		return driver.findElement(lvmEventsSearchNoTopicFilterText);

	}
	public WebElement getlvmEventsAndSeminar() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmEventsAndSeminar));
		return driver.findElement(lvmEventsAndSeminar);

	}
	
	public List<WebElement>getlistOfAllExhibitorsAndProducts() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(listOfAllExhibitorsAndProducts));
		return driver.findElements(listOfAllExhibitorsAndProducts);
	}
	public List<WebElement>getlvmListOfExhibitors() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmListOfExhibitors));
		return driver.findElements(lvmListOfExhibitors);
	}
	public WebElement getshowSpecialsDetailsFromShowSpecialsPage() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(showSpecialsDetailsFromShowSpecialsPage));
		return driver.findElement(showSpecialsDetailsFromShowSpecialsPage);

	}
	public WebElement getshowSpecialsLink() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(showSpecialsLink));
		return driver.findElement(showSpecialsLink);

	}
	public WebElement getArticleNameURL() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(ArticleNameURL));
		return driver.findElement(ArticleNameURL);

	}
	public WebElement getarticleName1st() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(articleName1st));
		return driver.findElement(articleName1st);

	}
	public List<WebElement>getlistOfAllTags() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(listOfAllTags));
		return driver.findElements(listOfAllTags);
	}
	public WebElement getlearnMoreLinkArticle() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(learnMoreLinkArticle));
		return driver.findElement(learnMoreLinkArticle);

	}
	public WebElement getArticleName() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(ArticleName));
		return driver.findElement(ArticleName);

	}
	public WebElement getCatalogExhibitorNames1st() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(CatalogExhibitorNames1st));
		return driver.findElement(CatalogExhibitorNames1st);

	}
	public List<WebElement>getlistOfAllCatalogExhibitorNames() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(listOfAllCatalogExhibitorNames));
		return driver.findElements(listOfAllCatalogExhibitorNames);
	}
	public WebElement getlvmFirstCatalogPROD() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmFirstCatalogPROD));
		return driver.findElement(lvmFirstCatalogPROD);

	}
	public WebElement getlvmInfosearchbtnPROD() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmInfosearchbtnPROD));
		return driver.findElement(lvmInfosearchbtnPROD);

	}
	public WebElement getlvmInfosearchtxtbxPROD() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmInfosearchtxtbxPROD));
		return driver.findElement(lvmInfosearchtxtbxPROD);

	}
	public WebElement getLvmInfoLearnMoreLink() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LvmInfoLearnMoreLink));
		return driver.findElement(LvmInfoLearnMoreLink);

	}
	public WebElement getLvmSearchResultsText() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LvmSearchResultsText));
		return driver.findElement(LvmSearchResultsText);

	}
	public WebElement getLvmInfoTitleProd() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LvmInfoTitleProd));
		return driver.findElement(LvmInfoTitleProd);

	}
	public List<WebElement>getLvmSortButtonListOfProducts() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LvmSortButtonListOfProducts));
		return driver.findElements(LvmSortButtonListOfProducts);
	}
	public List<WebElement>getLvmSortButtonListOfLocation() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LvmSortButtonListOfLocation));
		return driver.findElements(LvmSortButtonListOfLocation);
	}
	public WebElement getLvmSortButton() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LvmSortButton));
		return driver.findElement(LvmSortButton);

	}
	public WebElement getLvmEventExhibitorName() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LvmEventExhibitorName));
		return driver.findElement(LvmEventExhibitorName);

	}
	public WebElement getLvmExhibitorEvents() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(LvmExhibitorEvents));
		return driver.findElement(LvmExhibitorEvents);

	}
	public WebElement getLvmEventsMenu() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LvmEventsMenu));
		return driver.findElement(LvmEventsMenu);

	}
	public WebElement getLvmDiscoverTab() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LvmDiscoverTab));
		return driver.findElement(LvmDiscoverTab);

	}
	public WebElement getGlobalSearchEnterText() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(GlobalSearchEnterText));
		return driver.findElement(GlobalSearchEnterText);
		

	}

	public WebElement getVerifyGlobalSeacrhNew() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(VerifyGlobalSeacrhNew));
		return driver.findElement(VerifyGlobalSeacrhNew);

	}
	public WebElement getSearchButtonNew() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(SearchButtonNew));
		return driver.findElement(SearchButtonNew);

	}
	public WebElement getGlobalSearchTextBoxNew() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(GlobalSearchTextBoxNew));
		return driver.findElement(GlobalSearchTextBoxNew);
	}
	public WebElement lvmGlobalSearchEventTypeFilterResult() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmGlobalSearchEventTypeFilterResult));
		return driver.findElement(lvmGlobalSearchEventTypeFilterResult);
	}
	public List<WebElement>getlvmExhiNameForFilterByNameNewUAT() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmExhiNameForFilterByNameNewUAT));
		return driver.findElements(lvmExhiNameForFilterByNameNewUAT);
	}
	public WebElement getlvmGlobalSearchSortBtnUAT() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmGlobalSearchSortBtnUAT));
		return driver.findElement(lvmGlobalSearchSortBtnUAT);
	}
	public WebElement getlvm1STExhiNamePROD() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvm1STExhiNamePROD));
		return driver.findElement(lvm1STExhiNamePROD);
	}
	public WebElement getinfoTitleForInfoPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(infoTitleForInfoPage));
		return driver.findElement(infoTitleForInfoPage);
	}
	public WebElement getlvmShowSpecialsTitle2() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmShowSpecialsTitle2));
		return driver.findElement(lvmShowSpecialsTitle2);
	}
	public WebElement getthirdThbreadCrumbtxt() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(thirdThbreadCrumbtxt));
		return driver.findElement(thirdThbreadCrumbtxt);
	}
	public WebElement getlvmShowSpecialsDetails() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmShowSpecialsDetails));
		return driver.findElement(lvmShowSpecialsDetails);
	}
	public WebElement getlvmShowSpecialsDetailsOnShowSpecialsPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmShowSpecialsDetailsOnShowSpecialsPage));
		return driver.findElement(lvmShowSpecialsDetailsOnShowSpecialsPage);
	}
	public WebElement getlvmShowSpecialsSection() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmShowSpecialsSection));
		return driver.findElement(lvmShowSpecialsSection);
	}
	public WebElement getatmarketeventtypefilterUAT_LVM() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atmarketeventtypefilterUAT_LVM));
		return driver.findElement(atmarketeventtypefilterUAT_LVM);
	}
	public WebElement getFirstCatalogName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(FirstCatalogName));
		return driver.findElement(FirstCatalogName);
	}
	public WebElement getseeAllLinkMatchingProduct() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(seeAllLinkMatchingProduct));
		return driver.findElement(seeAllLinkMatchingProduct);
	}
	public WebElement getLVMFirstEventName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(FirstEventName));
		return driver.findElement(FirstEventName);
	}
	public WebElement getLVMEventsTabInSearchDiv() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmeventstabinsearchDiv));
		return driver.findElement(lvmeventstabinsearchDiv);
	}
	public WebElement getFirstInfoName() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(FirstInfoName));
		return driver.findElement(FirstInfoName);
	}
	public WebElement getlvmClosePopup() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmClosePopup));
		return driver.findElement(lvmClosePopup);
	}
	public WebElement getlvmSelectList() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmSelectList));
		return driver.findElement(lvmSelectList);
	}
	public WebElement getlvmShowSpecialsExhNamePROD() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmShowSpecialsExhNamePROD));
		return driver.findElement(lvmShowSpecialsExhNamePROD);
	}
	public WebElement getlvmGlobalSearchClearTxt() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmGlobalSearchClearTxt));
		return driver.findElement(lvmGlobalSearchClearTxt);
	}
	public WebElement getlvmShowroomLink() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmShowroomLink));
		return driver.findElement(lvmShowroomLink);
	}
	public WebElement getlvmShowSpecialsExhName() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmShowSpecialsExhName));
		return driver.findElement(lvmShowSpecialsExhName);
	}
	public WebElement getlvmShowSpecialsTitle() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmShowSpecialsTitle));
		return driver.findElement(lvmShowSpecialsTitle);
	}
	public WebElement getlvmShowSpecialsLink() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmShowSpecialsLink));
		return driver.findElement(lvmShowSpecialsLink);
	}
	public WebElement getlvmExhibitorsAndProductTab() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmExhibitorsAndProductTab));
		return driver.findElement(lvmExhibitorsAndProductTab);
	}
	public List<WebElement> getlvmListOfAllSavedSearches() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmListOfAllSavedSearches));
		return driver.findElements(lvmListOfAllSavedSearches);
	}
	public WebElement getlvmSavedSearchesBtnForNewSaved() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmSavedSearchesBtnForNewSaved));
		return driver.findElement(lvmSavedSearchesBtnForNewSaved);
	}
	public WebElement getlvmSavedSearchesInputBox() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmSavedSearchesInputBox));
		return driver.findElement(lvmSavedSearchesInputBox);
	}
	public WebElement getlvmSavedSearchesBtn() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmSavedSearchesBtn));
		return driver.findElement(lvmSavedSearchesBtn);
	}
	public WebElement getlvmSavedSearchesDropdown() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmSavedSearchesDropdown));
		return driver.findElement(lvmSavedSearchesDropdown);
	}
	public WebElement getlvmSavedSearchesIcon() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmSavedSearchesIcon));
		return driver.findElement(lvmSavedSearchesIcon);
	}
	public WebElement getlvmGoToMPBtn() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmGoToMPBtn));
		return driver.findElement(lvmGoToMPBtn);
	}
	public WebElement getlvmAddToSelectBtn() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmAddToSelectBtn));
		return driver.findElement(lvmAddToSelectBtn);
	}
	
	public WebElement getlvmExistingList() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmExistingList));
		return driver.findElement(lvmExistingList);
	}
	
	public WebElement getlvmAddToExistingList() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmAddToExistingList));
		return driver.findElement(lvmAddToExistingList);
	}
	
	public WebElement getlvm1STExhiName() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvm1STExhiName));
		return driver.findElement(lvm1STExhiName);
	}
	public WebElement getlvmGlobalSearchAddToFavBtn() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmAddToFavBtn));
		return driver.findElement(lvmAddToFavBtn);
	}
	public WebElement getlvmGlobalSearchExhCheckbox() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmExhCheckbox));
		return driver.findElement(lvmExhCheckbox);
	}
	public WebElement getlvmGlobalSearchSelectBtn() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmSelectBtn));
		return driver.findElement(lvmSelectBtn);
	}
	public List<WebElement> getlvmExhiNameForFilterByName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmExhiNameForFilterByName));
		return driver.findElements(lvmExhiNameForFilterByName);
	}
	public WebElement getlvmFilterByNameDropDown() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmFilterByNameDropDown));
		return driver.findElement(lvmFilterByNameDropDown);
	}
	public List<WebElement> getlvmMachingProductCount() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmMachingProductCount));
		return driver.findElements(lvmMachingProductCount);
	}
	public List<WebElement> getlvmExhNames() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmExhNames));
		return driver.findElements(lvmExhNames);
	}
	public List<WebElement> getlvmGlobalSearchExhLocationList() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmGlobalSearchExhLocationList));
		return driver.findElements(lvmGlobalSearchExhLocationList);
	}
	public WebElement getlvmGlobalSearch_SearchSortByDropdwn() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmGlobalSearch_SearchSortByDropdwn));
		return driver.findElement(lvmGlobalSearch_SearchSortByDropdwn);
	}
	public List<WebElement> getlvmListOfAllProductsName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmListOfAllProductsName));
		return driver.findElements(lvmListOfAllProductsName);
	}
	public List<WebElement> getlvmListOfAllProducts() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmListOfAllProducts));
		return driver.findElements(lvmListOfAllProducts);
	}
	public List<WebElement> getlvmListOfAllExhMatchingProductLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmListOfAllExhMatchingProductLink));
		return driver.findElements(lvmListOfAllExhMatchingProductLink);
	}
	public List<WebElement> getlvmListOfAllExhTotalProductLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmListOfAllExhTotalProductLink));
		return driver.findElements(lvmListOfAllExhTotalProductLink);
	}
	public List<WebElement> getlvmListOfAllExhLocation() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmListOfAllExhLocation));
		return driver.findElements(lvmListOfAllExhLocation);
	}
	public List<WebElement> getlvmListOfAllExh() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmListOfAllExh));
		return driver.findElements(lvmListOfAllExh);
	}
	public WebElement getlvmGlobalSearch_SearchWithinDropdwn() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmGlobalSearch_SearchWithinDropdwn));
		return driver.findElement(lvmGlobalSearch_SearchWithinDropdwn);
	}
	public WebElement getlvmGlobalSearchSortBtn() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmGlobalSearchSortBtn));
		return driver.findElement(lvmGlobalSearchSortBtn);
	}
	public WebElement getfourthbreadcrumbtxtUAT() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(fourthbreadcrumbtxtUAT));
		return driver.findElement(fourthbreadcrumbtxtUAT);
	}
	public WebElement getlvmseealllineslinkUAT() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmseealllineslinkUAT));
		return driver.findElement(lvmseealllineslinkUAT);
	}
	public WebElement getlvmeventstabinsearchUAT() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmeventstabinsearchUAT));
		return driver.findElement(lvmeventstabinsearchUAT);
	}
	public WebElement getTitleOfArticle() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(TitleOfArticle));
		return driver.findElement(TitleOfArticle);
	}
	public List<WebElement> getLVMlistOfAllArticles() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(listOfAllArticles));
		return driver.findElements(listOfAllArticles);
	}
	public WebElement getLVMGlobalSearchTextBox() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmglobalsearchtxtbx));
		return driver.findElement(lvmglobalsearchtxtbx);
	}
	public WebElement getLVMSearchButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmsearchbtn));
		return driver.findElement(lvmsearchbtn);
	}
	public WebElement getLVMVerifyGlobalSeacrh() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmverifyglobalseacrh));
		return driver.findElement(lvmverifyglobalseacrh);
	}
	public List<WebElement> getLVMSearchResultsList() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmsearchresultslist));
		return driver.findElements(lvmsearchresultslist);
	}
	public List<WebElement> getLVMSearchResultExhTypeList() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmsearchresultexhtypelist));
		return driver.findElements(lvmsearchresultexhtypelist);
	}
	public List<WebElement> getLVMSearchResultTypeLineList() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmsearchresultlinetypelist));
		return driver.findElements(lvmsearchresultlinetypelist);
	}
	public List<WebElement> getLVMProductsSearchResultsList() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmproductsearchresultlist));
		return driver.findElements(lvmproductsearchresultlist);
	}
	public WebElement getLVMClearSearchBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmclearsearchbtn));
		return driver.findElement(lvmclearsearchbtn);
	}
	public List<WebElement> getLVMSearchResultPorductTypeList() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmsearchresultproducttypelist));
		return driver.findElements(lvmsearchresultproducttypelist);
	}
	public WebElement getLVMSearchBtnUAT() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmSearchBtnUAT));
		return driver.findElement(lvmSearchBtnUAT);
	}
	public WebElement getLVMsearchresultInfoLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmsearchresultInfoLink));
		return driver.findElement(lvmsearchresultInfoLink);
	}
	public WebElement getAtlCatalog() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmCatalog));
		return driver.findElement(lvmCatalog);
	}
	public WebElement getCatalogHeaderName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(CatalogHeaderName));
		return driver.findElement(CatalogHeaderName);
	}
	public WebElement getLVMsearchresultArticlesLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmsearchresultArticlesLink));
		return driver.findElement(lvmsearchresultArticlesLink);
	}
	public WebElement getLVMSearchResultBlog() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmsearchresultBlog));
		return driver.findElement(lvmsearchresultBlog);
	}
	public WebElement getLVMSearchResult() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmsearchresult));
		return driver.findElement(lvmsearchresult);
	}		
	public WebElement getLVMInfoSearchJuniperMarketBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmInfoSearchJuniperMarketBtn));
		return driver.findElement(lvmInfoSearchJuniperMarketBtn);
	}		
	public WebElement getLVMInfoSearchTopicsFilter() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmInfoSearchTopicsFilter));
		return driver.findElement(lvmInfoSearchTopicsFilter);
	}		
	public WebElement getLVMInfoSearchTopicsMarketSnapshot() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmInfoSearchTopicsMarketSnapshot));
		Thread.sleep(5000);
		return driver.findElement(lvmInfoSearchTopicsMarketSnapshot);
	}		
	public WebElement getLVMInfoSearchSeeMoreDetailsBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmInfoSearchSeeMoreDetailsBtn));
		return driver.findElement(lvmInfoSearchSeeMoreDetailsBtn);
	}		
									
	public WebElement getLVMExhibitorFilter() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmExhibitorFilter));
		return driver.findElement(lvmExhibitorFilter);
	}		
	public WebElement getLVMExhibitorHeader() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmExhibitorHeader));
		return driver.findElement(lvmExhibitorHeader);
	}								
	public WebElement getLVMInfosearchtxtbx() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmInfosearchtxtbx));
		return driver.findElement(lvmInfosearchtxtbx);
	}								
	public WebElement getLVMInfosearchbtn() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmInfosearchbtn));
		return driver.findElement(lvmInfosearchbtn);
	}								
	public WebElement getLVMExhibitorCatalogName() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmExhibitorCatalogName));
		Thread.sleep(5000);
		return driver.findElement(lvmExhibitorCatalogName);
	}								
	public WebElement getLVMArticleHeader() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmArticleHeader));
		Thread.sleep(5000);
		return driver.findElement(lvmArticleHeader);
	}								
	public WebElement getLVMArticleTag() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmArticleTag));
		Thread.sleep(5000);
		return driver.findElement(lvmArticleTag);
	}								
	public WebElement getLVMArticleName() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmArticleName));
		Thread.sleep(5000);
		return driver.findElement(lvmArticleName);
	}								
	public WebElement getLVMArticleSeeMoreBtn() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmArticleSeeMoreBtn));
		Thread.sleep(5000);
		return driver.findElement(lvmArticleSeeMoreBtn);
	}								
	public WebElement getLVMBlogSeeAllBtn() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmBlogSeeAllBtn));
		Thread.sleep(5000);
		return driver.findElement(lvmBlogSeeAllBtn);
	}								
	public WebElement getlvmseealllineslink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmseealllineslink));
		return driver.findElement(lvmseealllineslink);
	}	
	public WebElement getlvmShowSpecialsTab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmShowSpecialsTab));
		return driver.findElement(lvmShowSpecialsTab);
	}
	public WebElement getlvmVerifyShowSpecials() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmVerifyShowSpecials));
		return driver.findElement(lvmVerifyShowSpecials);
	}
	public WebElement getFourthBreadcrumbTxtInApp() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(fourthbreadcrumbtxt));
		return driver.findElement(fourthbreadcrumbtxt);
	}
	public WebElement getLVMEventsTabInSearch() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmeventstabinsearch));
		return driver.findElement(lvmeventstabinsearch);
	}
	public WebElement getLVMSeeMoreDetailsBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmseemoredetailsbtn));
		return driver.findElement(lvmseemoredetailsbtn);
	}
	public WebElement getEventsLVMMktTopics() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eventslvmmkttopicsfilter));
		return driver.findElement(eventslvmmkttopicsfilter);
	}
	public WebElement getClearFiltersBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(clearfiltersbtn));
		return driver.findElement(clearfiltersbtn);
	}
	public WebElement getEventTypesFilter() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eventtypesfilter));
		return driver.findElement(eventtypesfilter);
	}
	public WebElement getAtMarketEventType() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atmarketeventtypefilter));
		return driver.findElement(atmarketeventtypefilter);
	}
	public WebElement getBuyingEventType() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(buyingeventtypefilter));
		return driver.findElement(buyingeventtypefilter);
	}
	public WebElement getLVMSeeMoreDetailsBtnNew() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmseemoredetailsbtnnew));
		return driver.findElement(lvmseemoredetailsbtnnew);
	}
	public WebElement getFirstShowSpecialName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(FirstShowSpecialName));
		return driver.findElement(FirstShowSpecialName);
	}
	public WebElement getFirstShowSpecialViewBrandDetailsBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(FirstShowSpecialViewBrandDetailsBtn));
		return driver.findElement(FirstShowSpecialViewBrandDetailsBtn);
	}
	public WebElement getEventsLVMMktTopicsUat() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eventslvmmkttopicsfilterUat));
		return driver.findElement(eventslvmmkttopicsfilterUat);
	}
	public WebElement getAtMarketEventTypeUat() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atmarketeventtypefilterUat));
		return driver.findElement(atmarketeventtypefilterUat);
	}
	public WebElement getLVMSeeMoreDetailsBtnNeww() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmseemoredetailsbtnneww));
		return driver.findElement(lvmseemoredetailsbtnneww);
	}
	public List<WebElement> getlvmExhiNameForFilterByNameNew() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmExhiNameForFilterByNameNew));
		return driver.findElements(lvmExhiNameForFilterByNameNew);
	}
	public WebElement infoTitle() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(infoTitle));
		return driver.findElement(infoTitle);
	}
	public WebElement getATLSearchResult() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(atlsearchresult));
		return driver.findElement(atlsearchresult);
	}	
	public WebElement getatlInfoSearchMoreInfoBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlInfoSearchMoreInfoBtn));
		return driver.findElement(atlInfoSearchMoreInfoBtn);
	}
}



