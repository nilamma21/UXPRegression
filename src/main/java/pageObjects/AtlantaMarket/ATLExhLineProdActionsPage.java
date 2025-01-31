package pageObjects.AtlantaMarket;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.base;

public class ATLExhLineProdActionsPage extends base{

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
	By totalprodseealllink = By.xpath("(//p[@class='imc-exhibitorcard--link imc-exhibitorcard--link--prod'][text()='See All'])[2]"); //Locator for Total Products-See All link for 1st Exhibitor
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
	By exhibitorNameLink = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/p[1]/a[1]"); //Locator for Order On Juniper Market Btn
	By lineLocationLink = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]"); //Locator for Location
	By seealllink = By.xpath("//div[@class = 'imc-exhibitorcard--text-container-row']/a[1]"); //Locator for Sell All link for exhibitors to find LInes
	By createlistbtn = By.xpath("//div[@class = 'imc-market-planner-quick-add-modal__content']/div[1]/div[2]/form[1]/div[2]/div[2]/div[1]/input[1]"); //Locator for Create and Add form for Add New List to Line page
	By seedetailsbtn = By.xpath("(//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div[2]/div/div/div/div/div/div[2]/div[2]/a)[1]"); //Locator for See Details button
	By exhibitorProdcut = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div/img"); //Locator for product
	By exhibitorProdcut_ATLPROD = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]"); //Locator for product
	By exhproductnameonsearchgrid = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/p"); //Locator for productName
	By productaddtofavbtn = By.xpath("(//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div[2]/div/div/div/div/div/div/div/div/span/div/button)[1]"); //Locator for Add to Favorite button for Product on Search Results grid
	By productaddtofavbtn_ATLPROD = By.xpath("(//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div[2]/div/div/div/div/div/div/div/div/span/div/button)[2]"); //Locator for Add to Favorite button for Product on Search Results grid

	By seeDetailsBtn = By.xpath("(//div[@class='searchItemThumb--container']/div/a/div/div)[1]"); //Locator for See Details button

	By seeDetailsBtnNew = By.xpath("(//div[@class='searchItemThumb--button-container']/div[1])[1]"); //Locator for See Details button

	By productmorebtn = By.xpath("(//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div[2]/div/div/div/div/div/div/div/div/span[2]/div)[1]"); //Locator for Add to List button for Product on Search Results grid
	By productformultiplecatg = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]"); //Locator for product to verify multiple Prod categ selection
	By seedetailsbtn3rdexhproduct = By.xpath("(//div[@class='imc-gallery imc-gallery--80-20 imc-exhibitorcard--gallery-nowrap'])[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/a"); //Locator for See Details button of 3rd exh product
	By imcexhibitorname = By.xpath("//h2[contains(text(),'IMC Test Company')]"); //Locator for IMC Exhibitor name from Search results grid
	By productFevBtn = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/button"); //Locator for Fev Btn
	By catalogstab = By.xpath("//a[@id='Catalogs']"); //Locator for Catalogs tab on Exhibitor products page
	By catalogstabDiv = By.xpath("//div[@id='Catalogs']"); //Locator for Catalogs tab on Exhibitor products page
	By catalogitem = By.xpath("(//div[@class='imc-gallery imc-vr--collosal imc-gallery--justify-left imc-catalog']//descendant::a)[2]"); //Locator for Catalog item
	By catalogitemPROD = By.xpath("//div[@class='imc-catalog__item_inner-content']"); //Locator for Catalog item
	By eventcardinsearch = By.xpath("//div[@class='imc-vr--xlarge imc-eventcard']");//Locator for Event card in search results
	By eventcardtitle = By.xpath("//span[contains(@class,'imc-eventcard__title')]"); //Locator for Event Card title
	By eventdetailsheader = By.xpath("//div[contains(@class,'imc-eventdetail--header')]/h1"); //Locator for header of Events details btn
	By eventdetailstag = By.xpath("//a[contains(@class,'imc-eventdetail--tag')]"); //Locator for tag on Event Details
	By eventcardtag = By.xpath("//ul[@class='imc-cardtags imc-content--light imc-eventcard__tag']/li/button"); //Locator for Event Card tag
	By catalogstabPROD = By.xpath("//div[@id='Catalogs']"); //Locator for Catalogs tab on Exhibitor products page
	By thirdexhname = By.xpath("//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][3]/div/div/div/div/a/h2"); //Locator for third Exhibitor name in Search grid
	By leftPaneFilterDGShowroom = By.xpath("//h4[contains(text(),'Digital Showroom')]"); //Locator for DG showroom Filter
	By leftPaneFilterDGShowroomCatalog = By.xpath("//h4[contains(text(),'Digital Showroom')]/../../.././../../div[2]/div[1]/div[1]/div[2]"); //Locator for DG showroom Filter Catalog
	
	By prodName = By.xpath("//a[@class='imc-type--title-5-ui']"); //Locator for DG showroom Filter Catalog
	By prodNameFromDGshhowroomPage = By.xpath("//div[@class = 'imc-content--display-flex-wrap']/span[text()='Products']/../../div[2]/div[1]/div[1]/div[1]/a"); //Locator for DG showroom Prod Name
	By secondexhproduct = By.xpath("//div[@class='imc-vr--xxlarge']/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]"); //Locator for Second exhibitor product
	By secondexhprodseedetailsbtn = By.xpath("//div[@class='imc-vr--xxlarge']/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]/div[1]/div[1]"); //Locator for Second exhibitor product see details btn
	By totalprodcountonsearchgridnew = By.xpath("//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div[2]/div[2]/div/div/p[1]");
	By totalprodseealllinknew = By.xpath("//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div[2]/div[2]/div/div/p[2]");
	By exhproductnameonsearchgridnew = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/h2");
	By prodNameUAT = By.xpath("(//div[@class='searchItemThumb--container'])[1]/p[1]"); //Locator for DG showroom Filter Catalog
	By addfaviconLVM_UAT = By.xpath("(//li[@class='imc-exhibitorcard--action imc-exhibitorcard--contact imc-exhibitorcard--contact--heart'])[position()=1]/div/button"); // Locator of add to Favorite icon		
	By productBlock = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]"); //Locator for Add to List button for Product on Search Results grid
	By seeDetailsProd = By.xpath("(//div[@class='imc-gallery imc-gallery--80-20 imc-exhibitorcard--gallery-nowrap'])[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/a[1]"); //Locator for See Detals btn
	By contactExhibitorHeroComponent = By.xpath("//div[@class='contact-exhibitor-wrapper']/button/span[1]"); //Locator for Contact Exhibitor icon of 1st Exhibitor
	By catalogitemName = By.xpath("(//div[@class='imc-gallery imc-vr--collosal imc-gallery--justify-left imc-catalog']//descendant::a)[2]/div/div"); //Locator for Catalog item
	By lineName = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]"); //Locator for 1st Line Name
	By exhLocationPROD = By.xpath("//div[@class='imc-gallery__item imc-content--full-width']/div[2]/div[1]/div[1]/div[1]/div/div/div/div[1]/div[2]/div[2]/div/a"); //Locator for location
	By lvmSeeAllLines = By.xpath("//div[@class='imc-gallery__item imc-content--full-width']/div[2]/div[1]/div[1]/div[1]/div/div/div/div[1]/div[1]/div/div/div/div/a"); //Locator for location
	By lvmTotalProductLink = By.xpath("//div[@class='imc-gallery__item imc-content--full-width']/div[2]/div[1]/div[1]/div[2]/div/span/a/span"); //Locator for location
	By lvmMatchingProductLink = By.xpath("//div[@class='imc-gallery__item imc-content--full-width']/div[2]/div[1]/div[1]/div[2]/div/a/span"); //Locator for location
	By lvmMatchingProductLinkForLines = By.xpath("(//p[contains(text(), 'Shown By')]//following::span[contains(text(), 'Matching Products')])[1]"); //Locator for location
	By lvmMatchingProductLinkForLineName = By.xpath("(//p[contains(text(), 'Shown By')]//following::span[contains(text(), 'Matching Products')])[1]/../../../..//h2[@class='imc-exhibitorcard__exhibitorname imc-exhibitorcard--title-hover']"); //Locator for location
	By lvmMatchingProductLinkForLines1 = By.xpath("(//span[contains(text(),'Matching Products') and //p[contains(text(),'Shown By')]])[1]"); //Locator for location
	By lvmTotalProductLinkForLines1 = By.xpath("(//span[contains(text(),'Total Products') and //p[contains(text(),'Shown By')]])[1]");
	By lvmTotalProductLinkForLines = By.xpath("(//p[contains(text(), 'Shown By')]//following::span[contains(text(), 'Total Products')])[1]"); //Locator for location
	
	
	public ATLExhLineProdActionsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			

	}
	public WebElement getlvmTotalProductLinkForLines() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmTotalProductLinkForLines));
		return driver.findElement(lvmTotalProductLinkForLines);
	}
	public WebElement getlvmTotalProductLinkForLines1() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmTotalProductLinkForLines1));
		return driver.findElement(lvmTotalProductLinkForLines1);
	}
	public WebElement getlvmMatchingProductLinkForLines1() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmMatchingProductLinkForLines1));
		return driver.findElement(lvmMatchingProductLinkForLines1);
	}
	public WebElement getlvmMatchingProductLinkForLineName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmMatchingProductLinkForLineName));
		return driver.findElement(lvmMatchingProductLinkForLineName);
	}
	public WebElement getlvmMatchingProductLinkForLines() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmMatchingProductLinkForLines));
		return driver.findElement(lvmMatchingProductLinkForLines);
	}
	public WebElement getlvmMatchingProductLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmMatchingProductLink));
		return driver.findElement(lvmMatchingProductLink);
	}
	public WebElement getlvmTotalProductBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmTotalProductLink));
		return driver.findElement(lvmTotalProductLink);
	}
	public WebElement getlvmSeeAllLines() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmSeeAllLines));
		return driver.findElement(lvmSeeAllLines);
	}
	public WebElement getexhLocationPROD() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhLocationPROD));
		return driver.findElement(exhLocationPROD);
	}
	public WebElement getlineName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lineName));
		return driver.findElement(lineName);
	}
	public WebElement getcontactExhibitorHeroComponent() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactExhibitorHeroComponent));
		return driver.findElement(contactExhibitorHeroComponent);
	}	
	public WebElement getseeDetailsProd() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(seeDetailsProd));
		return driver.findElement(seeDetailsProd);
	}
	public WebElement getproductBlock() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(productBlock));
		return driver.findElement(productBlock);
	}	
	public WebElement getaddfaviconLVM_UAT() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(addfaviconLVM_UAT));
		return driver.findElement(addfaviconLVM_UAT);
	}	
	public WebElement getprodNameUAT() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(prodNameUAT));
		return driver.findElement(prodNameUAT);
	}
	public WebElement getprodNameFromDGshhowroomPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(prodNameFromDGshhowroomPage));
		return driver.findElement(prodNameFromDGshhowroomPage);
	}
	public WebElement getprodName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(prodName));
		return driver.findElement(prodName);
	}
	public WebElement getleftPaneFilterDGShowroomCatalog() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(leftPaneFilterDGShowroomCatalog));
		return driver.findElement(leftPaneFilterDGShowroomCatalog);
	}
	public WebElement getleftPaneFilterDGShowroom() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(leftPaneFilterDGShowroom));
		return driver.findElement(leftPaneFilterDGShowroom);
	}
	public WebElement getcatalogitemPROD() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(catalogitemPROD));
		return driver.findElement(catalogitemPROD);
	}
	public WebElement getcatalogstabDiv() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(catalogstabDiv));
		return driver.findElement(catalogstabDiv);
	}

	public WebElement getcatalogstabPROD() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(catalogstabPROD));
		return driver.findElement(catalogstabPROD);
	}
	public WebElement getExhibitorName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitorname));
		return driver.findElement(exhibitorname);
	}
	
	public WebElement getAddFavIcon() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(addfavicon));
		return driver.findElement(addfavicon);
	}
	public WebElement getSearchResultMoreicon() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchresultmoreicon));
		return driver.findElement(searchresultmoreicon);
	}
	public WebElement getAddToListOptn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(addtolistoptn));
		return driver.findElement(addtolistoptn);
	}
	public WebElement getContactExhibitorIcon() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactexhibitoricon));
		return driver.findElement(contactexhibitoricon);
	}
	public WebElement getContactExhibitorModal() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactexhibitormodal));
		return driver.findElement(contactexhibitormodal);
	}
	public WebElement getPostalCodeTxtBx() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(postalcodetxtbx));
		return driver.findElement(postalcodetxtbx);
	}
	public WebElement getMessageTxtBx() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(messagetxtbx));
		return driver.findElement(messagetxtbx);
	}
	public WebElement getProductCateg1() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(prodcatg1));
		return driver.findElement(prodcatg1);
	}
	public WebElement getProductCateg2() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(prodcatg2));
		return driver.findElement(prodcatg2);
	}
	public WebElement getSendMessageBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(sendmessagebtn));
		return driver.findElement(sendmessagebtn);
	}
	public WebElement getLocationLinkInExhCard() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locationlinkinexhcard));
		return driver.findElement(locationlinkinexhcard);
	}
	public WebElement getLinesShownSeeAlLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lineshownseealllink));
		return driver.findElement(lineshownseealllink);
	}
	public WebElement getValidateLinesPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(validatelinespage));
		return driver.findElement(validatelinespage);
	}
	public WebElement getTotalProdSeeAllLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(totalprodseealllink));
		return driver.findElement(totalprodseealllink);
	}
	public WebElement getValidateProductsPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(validateproductspage));
		return driver.findElement(validateproductspage);
	}
	public WebElement getTotalProdCountOnSearchGrid() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(totalprodcountonsearchgrid));
		return driver.findElement(totalprodcountonsearchgrid);
	}
	public WebElement getMatchingProdCountOnSearchGrid() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(matchingprodcountonsearchgrid));
		return driver.findElement(matchingprodcountonsearchgrid);
	}
	public WebElement getMatchingProdSeeAllLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(matchingprodseealllink));
		return driver.findElement(matchingprodseealllink);
	}
	public WebElement getMatchingProdAddNoteIcon() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(matchingprodaddnoteicon));
		return driver.findElement(matchingprodaddnoteicon);
	}
	public WebElement getPopUpCloseBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(popupclosebtn));
		return driver.findElement(popupclosebtn);
	}
	public WebElement getNoteTitleTxtBx() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(notetitletxtbx));
		return driver.findElement(notetitletxtbx);
	}
	public WebElement getNoteContentTxtBx() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(notecontenttxtbx));
		return driver.findElement(notecontenttxtbx);
	}
	public WebElement getNoteSaveBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(notesavebtn));
		return driver.findElement(notesavebtn);
	}
	public WebElement getViewAllNotesLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(viewallnoteslink));
		return driver.findElement(viewallnoteslink);
	}
	public List <WebElement> getSavedNoteNameInAllNotesList() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(savednotenameinallnoteslist));
		return driver.findElements(savednotenameinallnoteslist);
	}
	public WebElement getNoteForAnExhibitorModal() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(noteforanexhibitormodal));
		return driver.findElement(noteforanexhibitormodal);
	}
	public WebElement getDeleteNoteBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(deletenotebtn));
		return driver.findElement(deletenotebtn);
	}
	public WebElement getOrderOnJuniperMarketBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(orderOnJuniperMarketBtn));
		return driver.findElement(orderOnJuniperMarketBtn);
	}

	public WebElement getExhibitorNameLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitorNameLink));
		return driver.findElement(exhibitorNameLink);
	}
	public WebElement getLineLocationLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lineLocationLink));
		return driver.findElement(lineLocationLink);
	}
	
	public WebElement getseealllink() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(seealllink));
		Thread.sleep(5000);
		return driver.findElement(seealllink);
	}
	public WebElement getcreatelistbtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(createlistbtn));
		return driver.findElement(createlistbtn);
	}
	public WebElement getSeeDetailsbtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(seedetailsbtn));
		return driver.findElement(seedetailsbtn);
	}
	public WebElement getExhibitorProduct() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitorProdcut));
		return driver.findElement(exhibitorProdcut);
	}
	public WebElement getExhProductNameOnSearchGrid() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhproductnameonsearchgrid));
		return driver.findElement(exhproductnameonsearchgrid);
	}
	public WebElement getProductAddToFavBtnOnSearchGrid() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(productaddtofavbtn));
		return driver.findElement(productaddtofavbtn);
	}

	public WebElement getProdSeeDetailsBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(seeDetailsBtnNew));
		return driver.findElement(seeDetailsBtnNew);
	}
	public WebElement getProductMoreBtnOnSearchGrid() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(productmorebtn));
		return driver.findElement(productmorebtn);
	}
	public WebElement getProductForMultipleCatg() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(productformultiplecatg));
		return driver.findElement(productformultiplecatg);
	}
	public WebElement getThirdExhProdSeeDetailsBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(seedetailsbtn3rdexhproduct));
		return driver.findElement(seedetailsbtn3rdexhproduct);
	}
	public WebElement getIMCExhibitorName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(imcexhibitorname));
		return driver.findElement(imcexhibitorname);
	}
	public WebElement getProductFevBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(productFevBtn));
		return driver.findElement(productFevBtn);
	}	
	public WebElement getCatalogsTab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(catalogstab));
		return driver.findElement(catalogstab);
	}
	public WebElement getCatalogsItem() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(catalogitem));
		return driver.findElement(catalogitem);
	}
	public WebElement getEventCardInSearch() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eventcardinsearch));
		return driver.findElement(eventcardinsearch);
	}
	public WebElement getEventCardTitle() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eventcardtitle));
		return driver.findElement(eventcardtitle);
	}
	public WebElement getEventDetailsHeader() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eventdetailsheader));
		return driver.findElement(eventdetailsheader);
	}
	public WebElement getEventDetailsTag() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eventdetailstag));
		return driver.findElement(eventdetailstag);
	}
	public WebElement getEventCardTag() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eventcardtag));
		return driver.findElement(eventcardtag);
	}
	public WebElement getproductaddtofavbtn_ATLPROD() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(productaddtofavbtn_ATLPROD));
		return driver.findElement(productaddtofavbtn_ATLPROD);
	}
	public WebElement getexhibitorProdcut_ATLPROD() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitorProdcut_ATLPROD));
		return driver.findElement(exhibitorProdcut_ATLPROD);
	}
	public WebElement getThirdExhName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(thirdexhname));
		return driver.findElement(thirdexhname);
	}

	public WebElement getSecondExhProduct() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(secondexhproduct));
		return driver.findElement(secondexhproduct);
	}
	public WebElement getSecondExhProductSeeDetailsBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(secondexhprodseedetailsbtn));
		return driver.findElement(secondexhprodseedetailsbtn);
	}
	public WebElement getTotalProdCountOnSearchGridNew() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(totalprodcountonsearchgridnew));
		return driver.findElement(totalprodcountonsearchgridnew);
	}
	public WebElement getTotalProdSeeAllLinkNew() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(totalprodseealllinknew));
		return driver.findElement(totalprodseealllinknew);
	}
	public WebElement getExhProductNameOnSearchGridNew() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhproductnameonsearchgridnew));
		return driver.findElement(exhproductnameonsearchgridnew);
	}
    public WebElement getCatalogsItemName() {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      wait.until(ExpectedConditions.visibilityOfElementLocated(catalogitemName));
      return driver.findElement(catalogitemName);
  }
}



