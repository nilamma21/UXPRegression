package pageObjects.LasVegasMarket;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LVMExhLineProdActionsPage {
	public WebDriver driver;
	public WebDriverWait wait;
	
	By addfavicon = By.xpath("(//li[@class='imc-exhibitorcard--action imc-exhibitorcard--contact imc-exhibitorcard--contact--heart'])[position()=1]"); // Locator of add to Favorite icon
	By exhibitorname = By.xpath("//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div/div/div/div/a/h2"); //Locator for 1st Exhibitor name from Search results grid
	By searchresultmoreicon = By.xpath("//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div/div/div/div[2]/div[2]/ul/li[3]"); //Locator for More icon for 1st item in search result
	By addtolistoptn = By.xpath("//div[@class='imc-popup--container']/div/label"); //Locator for Add to List option for 1st Search result item
	By contactexhibitoricon = By.xpath("//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div/div/div/div[2]/div[2]/ul/li[1]/div/button"); //Locator for Contact Exhibitor icon of 1st Exhibitor
	By contactexhibitormodal = By.xpath("//div[@class='imc-modal--content imc-contactexhibitormodal--position']"); //Locator for Contact Exhibitor Modal
	By postalcodetxtbx = By.xpath("//input[@data-xpath='contactexhibitormodal.postalCode']"); //Locator for Postal Code text field
	By messagetxtbx = By.xpath("//textarea[@data-xpath='contactexhibitormodal.message']"); //Locator for Message Text field
	By prodcatg1 = By.xpath("//div[@class='imc-formfield imc-content formfield-contact-exhibitor']/div[2]/div[1]"); //Locator for 1st Product Category on Contact Exhibitor form
	By prodcatg2 = By.xpath("//div[@class='imc-formfield imc-content formfield-contact-exhibitor']/div[2]/div[2]"); //Locator for 2nd Product Category on Contact Exhibitor form
	By sendmessagebtn = By.xpath("//input[@data-xpath='contactExhibitor.send']"); //Locator for end Message button
	By locationlinkinexhcard = By.xpath("//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div/div/div/div[2]/div[1]/div[1]/a"); //Locator for 1st Location link of an Exhibitor
	By lineshownseealllink = By.xpath("//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div/div/div/div/div/a[contains(text(), 'See All')]"); //Locator for Lines Shown-See All link for 1st Exhibitor
	By validatelinespage = By.xpath("//div[@id='Lines']"); //Locator for Lines tab on Lines page
	By totalprodseealllink = By.xpath("//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div[2]/div[2]/div/div[2]/p[2]"); //Locator for Total Products-See All link for 1st Exhibitor
	By validateproductspage = By.xpath("//div[@id='Products']"); //Locator for Products tab on Exhibitor products page
	By totalprodcountonsearchgrid = By.xpath("//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div[2]/div[2]/div/div[2]/p[1]"); //Locator for Total Products count on Search Results grid
	By matchingprodcountonsearchgrid = By.xpath("//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div[2]/div[2]/div/div[1]/p[1]"); //Locator for Matching Products count on Search Results grid
	By matchingprodseealllink = By.xpath("//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div[2]/div[2]/div/div[1]/p[2]"); //Locator for Matching Products-See All link for 1st Exhibitor
	By matchingprodaddnoteicon = By.xpath("//button[@class='imc-addnote__openModal imc-addnote__openModal--hideafter imc-link--alt-darkred imc-content imc-content--delta imc-expand-collapse__heading']"); //Locator for Add Note icon on Matching products page
	By popupclosebtn = By.xpath("//button[@class='imc-modal--close imc-button--modal-close imc-button--round']"); //Locator for Close pop-up button
	By notetitletxtbx = By.xpath("//div[@class='modal-wrapper']/div[1]/form[1]/div[1]/input[1]"); //Locator for Note title text field
	By notecontenttxtbx = By.xpath("//div[@class='modal-wrapper']/div[1]/form[1]/div[2]/textarea[1]"); //Locator for Note Content text field
	By notesavebtn = By.xpath("//input[@value='Save']"); //Locator for Save Note button
	By viewallnoteslink = By.xpath("//a[@href='#list']"); //Locator for View All Notes link
	By savednotenameinallnoteslist = By.xpath("//ul[@class='imc-market-planner-list imc-addnote-modal__list']/li/a"); //Locator for Saved Note name in All Notes list
	By noteforanexhibitormodal = By.xpath("//h4[contains(text(),'Note For exhibitor')]"); //Locator for Note for an Exhibitor modal
	By deletenotebtn = By.xpath("//a[@href='#delete']"); //Locator for Delete note button
	By orderOnJuniperMarketBtn = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[2]/div[2]/a[1]"); //Locator for Order On Juniper Market Btn
	By exhibitorNameLink = By.xpath("(//p[contains(text(),'Shown By')]/a)[1]"); //Locator for shown by exhibitor
	By lineLocationLink = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]"); //Locator for Location
	By seealllink = By.xpath("//div[@class = 'imc-exhibitorcard--text-container-row']/a[1]"); //Locator for Sell All link for exhibitors to find LInes
	By createlistbtn = By.xpath("//div[@class = 'imc-market-planner-quick-add-modal__content']/div[1]/div[2]/form[1]/div[2]/div[2]/div[1]/input[1]"); //Locator for Create and Add form for Add New List to Line page
	By seedetailsbtn = By.xpath("(//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div[2]/div/div/div/div/div/div[2]/div[2]/a)[1]"); //Locator for See Details button
	By exhibitorProdcut = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]"); //Locator for product
	By exhibitorProdcut_LVMPROD = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]"); //Locator for product
	By exhproductnameonsearchgrid = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/p[1]"); //Locator for productName
	By productaddtofavbtn = By.xpath("(//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div[2]/div/div/div/div/div/div/div/div/span/div/button)[1]"); //Locator for Add to Favorite button for Product on Search Results grid
	By productaddtofavbtn_LVMPROD = By.xpath("(//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div[2]/div/div/div/div/div/div/div/div/span/div/button)[2]"); //Locator for Add to Favorite button for Product on Search Results grid
	By seeDetailsBtn = By.xpath("(//div[@class='imc-gallery imc-gallery--80-20 imc-exhibitorcard--gallery-nowrap'])[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/a[1]"); //Locator for See Details button
	By productmorebtn = By.xpath("(//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div[2]/div/div/div/div/div/div/div/div/span[2]/div)[1]"); //Locator for Add to List button for Product on Search Results grid
	By productformultiplecatg = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]"); //Locator for product to verify multiple Prod categ selection
	By seedetailsbtn3rdexhproduct = By.xpath("(//div[@class='imc-gallery imc-gallery--80-20 imc-exhibitorcard--gallery-nowrap'])[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/a"); //Locator for See Details button of 3rd exh product
	By imcexhibitorname = By.xpath("//h2[contains(text(),'IMC test company')]"); //Locator for IMC Exhibitor name from Search results grid
	By productFevBtn = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/button[1]"); //Locator for Fev Btn
	By catalogstab = By.xpath("//a[@id='Catalogs']"); //Locator for Catalogs tab on Exhibitor products page
	By catalogstabDiv = By.xpath("//div[@id='Catalogs']"); //Locator for Catalogs tab on Exhibitor products page
	By catalogitem = By.xpath("//div[@class='imc-catalog__item_title multiSelectItem']/div/span/span"); //Locator for Catalog item
	By catalogitemPROD = By.xpath("//div[@class='imc-catalog__item_inner-content']"); //Locator for Catalog item
	By catalogitemLVMPROD = By.xpath("//div[@class='exhibitor-info-wrapper']"); //Locator for Catalog item
	
	By eventcardinsearch = By.xpath("//div[@class='imc-vr--xlarge imc-eventcard']");//Locator for Event card in search results
	By eventcardtitle = By.xpath("//span[contains(@class,'imc-eventcard__title')]"); //Locator for Event Card title
	By eventdetailsheader = By.xpath("//h1[contains(@class,'imc-heading')]"); //Locator for header of Events details btn
	By eventdetailstag = By.xpath("//a[contains(@class,'imc-eventdetail--tag')]"); //Locator for tag on Event Details
	By eventcardtag = By.xpath("//ul[@class='imc-cardtags imc-content--light imc-eventcard__tag']/li/button"); //Locator for Event Card tag
	By catalogstabPROD = By.xpath("//div[@id='Catalogs']"); //Locator for Catalogs tab on Exhibitor products page
	By thirdexhname = By.xpath("//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][3]/div/div/div/div/a/h2"); //Locator for third Exhibitor name in Search grid
	By leftPaneFilterDGShowroom = By.xpath("//h4[contains(text(),'Digital Showroom')]"); //Locator for DG showroom Filter
	By leftPaneFilterDGShowroomCatalog = By.xpath("//h4[contains(text(),'Digital Showroom')]/../../.././../../div[2]/div[1]/div[1]/div[2]"); //Locator for DG showroom Filter Catalog
	
	By prodName = By.xpath("//a[@class='imc-type--title-5-ui']"); //Locator for DG showroom Filter Catalog
	By prodNameFromDGshhowroomPage = By.xpath("//div[@class = 'imc-content--display-flex-wrap']/span[text()='Products']/../../div[2]/div[1]/div[1]/div[1]/a"); //Locator for DG showroom Prod Name
	By eventcardtitlenew = By.xpath("(//span[contains(@class,'imc-eventcard__title')])[1]");
	By eventdetailsheadernew = By.xpath("//div[@class='imc-eventdetail--header']/h1");
	By secondexhproduct = By.xpath("//div[@class='imc-vr--xxlarge']/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]"); //Locator for Second exhibitor product
	By secondexhprodseedetailsbtn = By.xpath("(//div[@class='imc-gallery imc-gallery--80-20 imc-exhibitorcard--gallery-nowrap'])[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/a"); //Locator for Second exhibitor product see details btn
	By eventdetailsheaderUat = By.xpath("//div[contains(@class,'imc-eventdetail--header')]/h1"); //Locator for header of Events details btn
	By catalogitemnew = By.xpath("//div[@class='imc-catalog__item_title multiSelectItem']/div/span/span"); //Locator for Catalog item
	By catalogitemUAT_LVM = By.xpath("(//div[@class='imc-catalog__item_title multiSelectItem']/div/span/span)[1]"); //Locator for Catalog item
	By catalogitemPROD_LVM = By.xpath("(//div[@class='imc-catalog__item_title multiSelectItem']/div[1])[1]"); //Locator for Catalog item
	
	By listCatalogitemPROD = By.xpath("//div[@class='imc-catalog__item_title multiSelectItem']/div"); //Locator for Catalog item
	By CatalogitemPROD = By.xpath("(//div[@class='imc-catalog__item_title multiSelectItem']/div)[1]");
	By eventdetailsheaderLVM = By.xpath("//div[@class='imc-eventdetail--header']/div[3]/section[1]/div[1]/h1[1]");
	By eventFirstExNameLVM = By.xpath("(//div[@class='event-card--multi-card-container'])[1]/div[1]/div[1]/div[1]/div[1]/a[1]");
	By digiShowroomFilterLVM = By.xpath("//h4[text()='Digital Showroom']");
	By digiShowroomFilterCatalogsLVM = By.xpath("//label[@for='filteritem638']");
	By digiShowroomFilterLVMNew = By.xpath("//h4[contains(text(),'Digital Showroom')]");
	By leftPaneFilterDGShowroomCatalogNew = By.xpath("//h4[contains(text(),'Digital Showroom')]/../../.././../../div[2]/div[1]/div[1]/div[3]"); //Locator for DG showroom Filter Catalog

	By mp = By.xpath("//h2[contains(text(),'Paseo Road')]/../../../../../../../../../../div[2]/div/a/span");
	By catalogitemPROD_NewLVM = By.xpath("(//div[@class='searchItemThumb--image-container'])[1]"); //Locator for Catalog item
	
	
	
	public LVMExhLineProdActionsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	}
	public WebElement getcatalogitemPROD_NewLVM() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(catalogitemPROD_NewLVM));
		return driver.findElement(catalogitemPROD_NewLVM);
	}
	public WebElement getmp() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(mp));
		return driver.findElement(mp);
	}
	public WebElement getleftPaneFilterDGShowroomCatalogNew() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(leftPaneFilterDGShowroomCatalogNew));
		return driver.findElement(leftPaneFilterDGShowroomCatalogNew);
	}
	public WebElement getdigiShowroomFilterLVMNew() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait.until(ExpectedConditions.visibilityOfElementLocated(digiShowroomFilterLVMNew));
		return driver.findElement(digiShowroomFilterLVMNew);
	}
	public WebElement getdigiShowroomFilterCatalogsLVM() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(digiShowroomFilterCatalogsLVM));
		return driver.findElement(digiShowroomFilterCatalogsLVM);
	}
	public WebElement getdigiShowroomFilterLVM() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(digiShowroomFilterLVM));
		return driver.findElement(digiShowroomFilterLVM);
	}
	public WebElement getcatalogitemLVMPROD() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(catalogitemLVMPROD));
		return driver.findElement(catalogitemLVMPROD);
	}
	public WebElement geteventFirstExNameLVM() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eventFirstExNameLVM));
		return driver.findElement(eventFirstExNameLVM);
	}
	public WebElement geteventdetailsheaderLVM() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eventdetailsheaderLVM));
		return driver.findElement(eventdetailsheaderLVM);
	}
	public List <WebElement>getlistCatalogitemPROD() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(listCatalogitemPROD));
		return driver.findElements(listCatalogitemPROD);
	}
	public WebElement getcatalogitemPROD_LVM() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(catalogitemPROD_LVM));
		return driver.findElement(catalogitemPROD_LVM);
	}
	public WebElement getcatalogitemUAT_LVM() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(catalogitemUAT_LVM));
		return driver.findElement(catalogitemUAT_LVM);
	}
	public WebElement getprodNameFromDGshhowroomPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(prodNameFromDGshhowroomPage));
		return driver.findElement(prodNameFromDGshhowroomPage);
	}
	public WebElement getprodName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(prodName));
		return driver.findElement(prodName);
	}
	public WebElement getleftPaneFilterDGShowroomCatalog() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(leftPaneFilterDGShowroomCatalog));
		return driver.findElement(leftPaneFilterDGShowroomCatalog);
	}
	public WebElement getleftPaneFilterDGShowroom() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(leftPaneFilterDGShowroom));
		return driver.findElement(leftPaneFilterDGShowroom);
	}
	public WebElement getcatalogitemPROD() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(catalogitemPROD));
		return driver.findElement(catalogitemPROD);
	}
	public WebElement getcatalogstabDiv() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(catalogstabDiv));
		return driver.findElement(catalogstabDiv);
	}
	public WebElement getcatalogstabPROD() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(catalogstabPROD));
		return driver.findElement(catalogstabPROD);
	}
	public WebElement getExhibitorName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitorname));
		return driver.findElement(exhibitorname);
	}
	
	public WebElement getAddFavIcon() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(addfavicon));
		return driver.findElement(addfavicon);
	}
	public WebElement getSearchResultMoreicon() {
		return driver.findElement(searchresultmoreicon);
	}
	public WebElement getAddToListOptn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(addtolistoptn));
		return driver.findElement(addtolistoptn);
	}
	public WebElement getContactExhibitorIcon() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactexhibitoricon));
		return driver.findElement(contactexhibitoricon);
	}
	public WebElement getContactExhibitorModal() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactexhibitormodal));
		return driver.findElement(contactexhibitormodal);
	}
	public WebElement getPostalCodeTxtBx() {
		return driver.findElement(postalcodetxtbx);
	}
	public WebElement getMessageTxtBx() {
		return driver.findElement(messagetxtbx);
	}
	public WebElement getProductCateg1() {
		return driver.findElement(prodcatg1);
	}
	public WebElement getProductCateg2() {
		return driver.findElement(prodcatg2);
	}
	public WebElement getSendMessageBtn() {
		return driver.findElement(sendmessagebtn);
	}
	public WebElement getLocationLinkInExhCard() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locationlinkinexhcard));
		return driver.findElement(locationlinkinexhcard);
	}
	public WebElement getLinesShownSeeAlLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lineshownseealllink));
		return driver.findElement(lineshownseealllink);
	}
	public WebElement getValidateLinesPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(validatelinespage));
		return driver.findElement(validatelinespage);
	}
	public WebElement getTotalProdSeeAllLink() {
		return driver.findElement(totalprodseealllink);
	}
	public WebElement getValidateProductsPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(validateproductspage));
		return driver.findElement(validateproductspage);
	}
	public WebElement getTotalProdCountOnSearchGrid() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(totalprodcountonsearchgrid));
		return driver.findElement(totalprodcountonsearchgrid);
	}
	public WebElement getMatchingProdCountOnSearchGrid() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(matchingprodcountonsearchgrid));
		return driver.findElement(matchingprodcountonsearchgrid);
	}
	public WebElement getMatchingProdSeeAllLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(matchingprodseealllink));
		return driver.findElement(matchingprodseealllink);
	}
	public WebElement getMatchingProdAddNoteIcon() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(matchingprodaddnoteicon));
		return driver.findElement(matchingprodaddnoteicon);
	}
	public WebElement getPopUpCloseBtn() {
		return driver.findElement(popupclosebtn);
	}
	public WebElement getNoteTitleTxtBx() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(notetitletxtbx));
		return driver.findElement(notetitletxtbx);
	}
	public WebElement getNoteContentTxtBx() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(notecontenttxtbx));
		return driver.findElement(notecontenttxtbx);
	}
	public WebElement getNoteSaveBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(notesavebtn));
		return driver.findElement(notesavebtn);
	}
	public WebElement getViewAllNotesLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(viewallnoteslink));
		return driver.findElement(viewallnoteslink);
	}
	public List <WebElement> getSavedNoteNameInAllNotesList() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(savednotenameinallnoteslist));
		return driver.findElements(savednotenameinallnoteslist);
	}
	public WebElement getNoteForAnExhibitorModal() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(noteforanexhibitormodal));
		return driver.findElement(noteforanexhibitormodal);
	}
	public WebElement getDeleteNoteBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(deletenotebtn));
		return driver.findElement(deletenotebtn);
	}
	public WebElement getOrderOnJuniperMarketBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(orderOnJuniperMarketBtn));
		return driver.findElement(orderOnJuniperMarketBtn);
	}

	public WebElement getExhibitorNameLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitorNameLink));
		return driver.findElement(exhibitorNameLink);
	}
	public WebElement getLineLocationLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lineLocationLink));
		return driver.findElement(lineLocationLink);
	}
	
	public WebElement getseealllink() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(seealllink);
	}
	public WebElement getcreatelistbtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(createlistbtn));
		return driver.findElement(createlistbtn);
	}
	public WebElement getSeeDetailsbtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(seedetailsbtn));
		return driver.findElement(seedetailsbtn);
	}
	public WebElement getExhibitorProduct() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitorProdcut));
		return driver.findElement(exhibitorProdcut);
	}
	public WebElement getExhProductNameOnSearchGrid() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhproductnameonsearchgrid));
		return driver.findElement(exhproductnameonsearchgrid);
	}
	public WebElement getProductAddToFavBtnOnSearchGrid() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(productaddtofavbtn));
		return driver.findElement(productaddtofavbtn);
	}

	public WebElement getProdSeeDetailsBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(seeDetailsBtn));
		return driver.findElement(seeDetailsBtn);
	}
	public WebElement getProductMoreBtnOnSearchGrid() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(productmorebtn));
		return driver.findElement(productmorebtn);
	}
	public WebElement getProductForMultipleCatg() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(productformultiplecatg));
		return driver.findElement(productformultiplecatg);
	}
	public WebElement getThirdExhProdSeeDetailsBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(seedetailsbtn3rdexhproduct));
		return driver.findElement(seedetailsbtn3rdexhproduct);
	}
	public WebElement getIMCExhibitorName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(imcexhibitorname));
		return driver.findElement(imcexhibitorname);
	}
	public WebElement getProductFevBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(productFevBtn));
		return driver.findElement(productFevBtn);
	}	
	public WebElement getCatalogsTab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(catalogstab));
		return driver.findElement(catalogstab);
	}
	public WebElement getCatalogsItem() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(catalogitem));
		return driver.findElement(catalogitem);
	}
	public WebElement getEventCardInSearch() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eventcardinsearch));
		return driver.findElement(eventcardinsearch);
	}
	public WebElement getEventCardTitle() {
		return driver.findElement(eventcardtitle);
	}
	public WebElement getEventDetailsHeader() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eventdetailsheader));
		return driver.findElement(eventdetailsheader);
	}
	public WebElement getEventDetailsTag() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eventdetailstag));
		return driver.findElement(eventdetailstag);
	}
	public WebElement getEventCardTag() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eventcardtag));
		return driver.findElement(eventcardtag);
	}
	public WebElement getproductaddtofavbtn_LVMPROD() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(productaddtofavbtn_LVMPROD));
		return driver.findElement(productaddtofavbtn_LVMPROD);
	}
	public WebElement getexhibitorProdcut_LVMPROD() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitorProdcut_LVMPROD));
		return driver.findElement(exhibitorProdcut_LVMPROD);
	}
	public WebElement getThirdExhName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(thirdexhname));
		return driver.findElement(thirdexhname);
	}
	public WebElement getEventCardTitleNex() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eventcardtitlenew));
		return driver.findElement(eventcardtitlenew);
	}
	public WebElement getEventDetailsHeaderNew() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eventdetailsheadernew));
		return driver.findElement(eventdetailsheadernew);
	}
	public WebElement getSecondExhProduct() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(secondexhproduct));
		return driver.findElement(secondexhproduct);
	}
	public WebElement getSecondExhProductSeeDetailsBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(secondexhprodseedetailsbtn));
		return driver.findElement(secondexhprodseedetailsbtn);
	}
	public WebElement getEventDetailsHeaderUat() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eventdetailsheaderUat));
		return driver.findElement(eventdetailsheaderUat);
	}
	public List <WebElement>getCatalogsItemNew() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(catalogitemnew));
		return driver.findElements(catalogitemnew);
	}
    public WebElement getCatalogitemPROD() {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
      wait.until(ExpectedConditions.visibilityOfElementLocated(CatalogitemPROD));
      return driver.findElement(CatalogitemPROD);
  }

}
