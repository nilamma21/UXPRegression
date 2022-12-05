package pageObjects.AtlantaMarket;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLExhDigiShowroomPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By atlvalidateexhdigishowpage = By.xpath("//img[@class='imc-image--responsive align-image-content imc-content--full-width imc-exhibitors--directory-image']"); // Locator to validate Exhibitor Digital Showroom page
	By lvmvalidateexhdigishowpage_uat = By.xpath("//div[@class='imc-gallery__item']"); // Locator to validate Exhibitor Digital Showroom page
	By atlvalidateexhdigishowpage_lvmUAT = By.xpath("//img[@class='imc-exhibitors--detail-image']"); // Locator to validate Exhibitor Digital Showroom page LVM UAT
	By exhibitornameonexhdirectimg = By.xpath("//span[@class='imc-heading imc-heading--giga-desktop ']"); //Locator for Exhibitor name on Exhibitor Directory image
	By lvmexhibitornameonexhdirectimg_uat = By.xpath("//span[@class='imc-heading imc-heading--giga-desktop imc-vr--medium imc-content--inline-block']"); //Locator for Exhibitor name on Exhibitor Directory image
	By exhibitornameonexhdirectimg_lvmUAT = By.xpath("//span[@class='imc-heading imc-heading--giga-desktop imc-vr--medium imc-content--inline-block']"); //Locator for Exhibitor name on Exhibitor Directory image LVM UAT
	By exhdigishowroompage = By.xpath("//div[@class='imc-section--full-width-mobile imc-content--display-flex imc-content--display-flex-grow-1 imc-section--divided-bottom']"); //Locator for Exhibitor Digital Showroom page
	By exhnameonexhdirectimg = By.xpath("//span[@class='imc-heading imc-heading--giga-desktop imc-vr--medium imc-content--inline-block']"); //Locator for Exhibitor name on Exhibitor Directory image
	By productcategsectn = By.xpath("//h5[contains(text(),'Product Categories')]"); //Locator for Products Categories section title
	By productcategitemlist = By.xpath("//div[contains(@class,'imc-gallery imc-gallery--justify-left imc-gallery')]"); //Locator for Product Categories list
	By prodcatgtable = By.xpath("//div[@class='imc-gallery__item']"); //Locator for Product Categories table
	
	// Prod Elements
	
	By SearchedExhibitor = By.xpath("//div[@class = 'imc-vr--xxlarge']/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]"); //Locator for Exhibitor Name searched through global search 
	By VerifyExhibitorInFavoritesLists = By.xpath("//*[contains(text(),'IMC test company')]"); //Locator for Favorites tab list of exhibitors
	By favoriteicon = By.xpath("//label[@data-xpath='event.addToFavs']"); //Locator for Favorite icon on Exh Digital Showroom
	By ExhibitorName = By.xpath("//div[@class = 'imc-gallery__item']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]"); //Locator for first exhibitor name in the list
	By ListButtonlusIcon = By.xpath("//button[@class = 'imc-selectableicon imc-exhibitor-card__type--color']"); //Locator for Plus icon for Add list
	By NoteOptn = By.xpath("//div[@class = 'imc-addnote imc-expand-collapse undefined']/button[1]"); //Locator for Note button
	By NoteCloseBtn = By.xpath("//button[@class = 'imc-modal--close imc-addnote-modal__close']"); //Locator for X button for Note pop up
	By NoteTitle = By.xpath("//input[@name = 'title']"); //Locator for Note title text box
	By NoteDescription = By.xpath("//*[@name = 'notes']"); //Locator for Notes Description
	By SaveNotBtn = By.xpath("//*[contains(text(),'Save')]"); //Locator for Save note button
	By ViewAllNotes = By.xpath("//a[contains(text(), 'View all Notes')]"); //Locator for View All Notes link
	By VerifyAddedNote = By.xpath("//ul[@class = 'imc-market-planner-list imc-addnote-modal__list']"); //Locator for Added Notes section
	By SaveNoteOKButton = By.xpath("//div[@class = 'imc-content imc-content--right']/button[1]"); //Locator for OK button for save note
	By Location = By.xpath("//section[@class='imc-site-wrapper']/div[2]/div[1]/div[1]/div[2]/div[1]/span[2]/a[1]"); //Locator for Location symbol at Digital Showroom page
	By ContactExhibitor = By.xpath("//div[@class = 'contact-exhibitor-wrapper']/button[1]"); //Locator for Contact Exhibitor button
	By ProductSection = By.xpath("//div[@class = 'imc-content--display-flex-wrap']/span[text()='Products']"); //Locator for Product section in Exhibitor Digital Showroom
	By AllProductsButton = By.xpath("//a[@class = 'imc-content--inline-block imc-button imc-button--primary-inverted imc-button--full-bleed-mobile']"); //Locator for See All Products button
	By ProductsPageBackButton = By.xpath("//button[@class = 'imc-icon-BackArrow imc-button--icon-only imc-button--no-border imc-heading--mega imc-heading--line-height-1 imc-content--display-flex']"); //Locator for Back arrow at Products page
	By ProductsList = By.xpath("//div[@class = 'imc-products-overview--gallery']/div[1]"); //Locator for first product in Product List at Exhibitor Digital Showroom
	By ProductsDescription = By.xpath("//h5[@class = 'imc-margin--bottom--medium']"); //Locator for Products section at Products page
	By LinesSection = By.xpath("//div[@id = 'digitalShowRoomLines']/div[1]/div[1]"); //Locator for Lines section
	By TotalLinesButton = By.xpath("//div[@class = 'imc-content--display-flex imc-content--display-flex-space-between imc-lines-overview-actions']/div[2]/a[1]"); //Locator for Sell All Lines button
	//By ValidateLinesPage = By.xpath("//ul[@class = 'imc-breadcrumb']/li[4]"); //Locator for Validate Lines page
	By ValidateLinesPage = By.xpath("//div[@class = 'imc-gallery imc-gallery--65-35 breadcrumbs__round']/div[1]/ul[1]/li[4]/a[1]"); //Locator for Validate Lines page
	
	By LinesCountAtLinesPage = By.xpath("//div[@id = 'Lines']"); //Locator for Lines tab at All Lines page
	By LinesOption = By.xpath("//div[@class = 'imc-content--display-flex-wrap imc-content--display-flex imc-content--display-flex-space-between']/div[1]/div[2]/a[1]"); //Locator for First Lines option
	By LinesPage = By.xpath("//section[@class = 'imc-site-wrapper']/div[2]/div[1]"); //Locator for Lines page
	By LinesOptionText = By.xpath("//div[@class = 'imc-manufacturing-line']/div[2]/a[1]"); //Locator for Lines option text
	By ProductText = By.xpath("//div[@class = 'imc-products-overview--gallery']/div[1]/div[1]/a[1]"); //Locator for Product text
	By AlphabeticSorting = By.xpath("//div[@class = 'imc-content--display-flex']/a[1]"); //Locator for A to Z sorting
	By ProductSorting = By.xpath("//div[@class = 'imc-content--display-flex']/a[2]"); //Locator for sort by product
	By LinesWithProduct = By.xpath("//div[@class = 'imc-content--display-flex']/a[3]"); //Locator for Line with Product sorting
	By LinesOnJuniperMarket = By.xpath("//div[@class = 'imc-content--display-flex']/a[4]"); //Locator for Line with Juniper Market sorting
	By LineSearch = By.xpath("//input[@id = 'product-search']"); //Locator for line search
	//By LineSearchButton = By.xpath("//button[@class = 'imc-searchform--button--search']"); //Locator for line search button 		
	By VerifyLineSearch = By.xpath("//div[@class = 'imc-manufacturing-line-title-wrapper']/a[1]"); //Locator for verify line search  
	By VerifyLinePageTitle = By.xpath("//div[@class = 'imc-gallery imc-gallery--65-35 breadcrumbs__round']/div[1]/ul[1]/li[4]/a[1]"); //Locator for verify line page title
	By LineSearchButton = By.xpath("(//button[@class = 'imc-searchform--button--search'])[2]"); //Locator for line search button 		
	By SeeInOtherMarket = By.xpath("//button[@class = 'imc-button imc-button--full-bleed-mobile imc-button--primary-inverted imc-margin--all--none']"); //Locator for See In Other Markets button
	By VerifyOtherMarketsPage = By.xpath("//div[@class = 'ReactModal__Content ReactModal__Content--after-open imc-modal--box imc-modal--box-wide']"); //Locator for See In Other Markets page title
	By ClickShowroom = By.xpath("//div[@class = 'imc-other-markets-goto']/a[1]"); //Locator for Go to Showroom link
	By ValidateDigitalShowroomPage = By.xpath("//div[@class = 'imc-gallery__item imc-content--center-mobile']/span[1]"); //Locator for Exhibitor Digital Showroom page
	By ContactExhibitorInOtherMarket = By.xpath("//div[@class = 'imc-other-markets-contact']/div[1]/button[1]"); //Locator for Contact Exhibitor link at See in Other Markets page
	By VerifyContactExhibitorPage = By.xpath("//div[@class = 'imc-contactexhibitormodal--body-panel imc-section--neutral-medium imc-content--full-width']"); //Locator for Contact Exhibitor Page
	By ContactExhibitorCloseButton = By.xpath("//div[@class = 'ReactModalPortal']/div[1]/button[1]"); //Locator for Close button at Contact Exhibitor page  		

	By CatalogSection = By.xpath("//div[@class = 'imc-exhibitors--alternated-section imc-section--full-width-mobile imc-content--display-flex imc-content--display-flex-grow-1']/div[1]/div/span[text()='Catalogs']"); //Locator for Catalog section  			
	By CatalogSeeAllBtn = By.xpath("(//span[contains(text(),'Catalogs')])[1]/../../div[3]/div/a/span[contains(text(),'See All') and @class='imc-breakpoint-display--hide-mobile']"); //Locator for Catalog see All Btn
	By HeroComponentVisit = By.xpath("//span[contains(text(),'Visit')]/.."); //Locator for Hero Component Visit Btn
	By showroomHeader3D = By.xpath("//div[@class='imc-content--display-flex imc-content--display-flex--center']/span[1]"); //Locator for 3D showroom Header
	By View3DshowroomBtn = By.xpath("//span[contains(text(),'View 3D Showroom')]"); //Locator for 3D showroom Header
	By View3DshowroomClose = By.xpath("//button[@class='imc-modal--close imc-button--modal-close imc-button--round']"); //Locator for 3D showroom Header
	By EventsSection = By.xpath("(//span[contains(text(),'Events')])[1]"); //Locator for Events Section
	By SeeAllEventsBtn = By.xpath("(//span[contains(text(),'Events')])[1]/../../div[3]/div[1]/a[1]"); //Locator for Events Section
	By EventName = By.xpath("(//span[contains(text(),'Events')])[1]/../../div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/h4[1]"); //Locator for Events Section
	By OrderOnJuniperMarktBtnCatalog = By.xpath("(//span[contains(text(),'Catalogs')])[1]/../../div[3]/div[1]/a[1]"); //Locator for Events Section
	
	//div[@class='imc-section imc-section--width-100-percent']/div[1]/span[contains(text(),'Products')]/../../div[3]/div[1]/a[1]/span[1]

	By CatalogsSection = By.xpath("//div[@class = 'imc-exhibitors--alternated-section imc-section--full-width-mobile imc-content--display-flex imc-content--display-flex-grow-1']/div[1]/div/span[text()='Catalogs']"); //Locator for Catalogs section
	By SeeAllCatalogsButton = By.xpath("//section[@class = 'imc-site-wrapper']/div[6]/div[1]/div[3]/div[1]/a[1]"); //Locator for See All Catalogs section
	By SelectCatalog = By.xpath("//div[@class = 'imc-catalog__item_title multiSelectItem']"); //Locator for Catalog option in Catalogs section
	By showSpecialSection = By.xpath("//div[@class = 'imc-exhibitors--alternated-section imc-section--full-width-mobile imc-content--display-flex imc-content--display-flex-grow-1']/div[1]/div[1]/span[text()='Show Specials']"); //Locator for Show special Section
	By SeeAllshowSpecialBtn = By.xpath("//div[@class = 'imc-exhibitors--alternated-section imc-section--full-width-mobile imc-content--display-flex imc-content--display-flex-grow-1']/div[1]/div/span[text()='Show Specials']/../../div[3]/div[1]/a[1]/span[1]"); ////Locator for See All Show special Btn
	By ShowSpecialCount = By.xpath("//div[@class = 'imc-exhibitors--alternated-section imc-section--full-width-mobile imc-content--display-flex imc-content--display-flex-grow-1']/div[1]/div/span[contains(text(),'Specials Available')]"); ////Locator for See All Show special Count
	By ShowSpecialName = By.xpath("//div[@class = 'imc-exhibitors--alternated-section imc-section--full-width-mobile imc-content--display-flex imc-content--display-flex-grow-1']/div[1]/div[1]/span[text()='Show Specials']/../../div[2]/span[1]"); ////Locator for See All Show special Count
	By heroComponentOrderOnJunperBtn = By.xpath("//div[@class='imc-section imc-padding--left--xlarge imc-padding--right--xlarge imc-section--width-100-percent']/div//span[@class='imc-breakpoint-display--hide-mobile' and text()='Order on JuniperMarket']/.."); ////Locator for Order on Juniper CTA
	By closeBtnContactExh = By.xpath("//button[@class='imc-modal--close imc-button--modal-close imc-button--round']"); ////Locator for Closse Btn
	
	
	public ATLExhDigiShowroomPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	}
	public WebElement getcloseBtnContactExh() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(closeBtnContactExh));
		return driver.findElement(closeBtnContactExh);
	}
	public WebElement getheroComponentOrderOnJunperBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(heroComponentOrderOnJunperBtn));
		return driver.findElement(heroComponentOrderOnJunperBtn);
	}
	public WebElement getShowSpecialName() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShowSpecialName));
		return driver.findElement(ShowSpecialName);
	}
	public WebElement getShowSpecialCount() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShowSpecialCount));
		return driver.findElement(ShowSpecialCount);
	}
	public WebElement getSeeAllshowSpecialBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SeeAllshowSpecialBtn));
		return driver.findElement(SeeAllshowSpecialBtn);
	}
	public WebElement getshowSpecialSection() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(showSpecialSection));
		return driver.findElement(showSpecialSection);
	}
	public WebElement getOrderOnJuniperMarktBtnCatalog() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(OrderOnJuniperMarktBtnCatalog));
		return driver.findElement(OrderOnJuniperMarktBtnCatalog);
	}
	public WebElement getEventName() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EventName));
		return driver.findElement(EventName);
	}
	public WebElement getSeeAllEventsBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SeeAllEventsBtn));
		return driver.findElement(SeeAllEventsBtn);
	}
	public WebElement getEventsSection() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EventsSection));
		return driver.findElement(EventsSection);
	}
	public WebElement getView3DshowroomClose() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(View3DshowroomClose));
		return driver.findElement(View3DshowroomClose);
	}
	public WebElement getView3DshowroomBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(View3DshowroomBtn));
		return driver.findElement(View3DshowroomBtn);
	}
	public WebElement getshowroomHeader3D() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(showroomHeader3D));
		return driver.findElement(showroomHeader3D);
	}
	public WebElement getHeroComponentVisit() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HeroComponentVisit));
		return driver.findElement(HeroComponentVisit);
	}
	public WebElement getATLCatalogSeeAllBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(CatalogSeeAllBtn));
		return driver.findElement(CatalogSeeAllBtn);
	}
	public WebElement getATLCatalogSection() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(CatalogSection));
		return driver.findElement(CatalogSection);
	}
	public WebElement getATLVerifyLinePageTitle() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(VerifyLinePageTitle));
		return driver.findElement(VerifyLinePageTitle);
	}
	public WebElement getATLExhDigiShowPage() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhdigishowroompage));
		return driver.findElement(exhdigishowroompage);
	}
	public WebElement getATLValidateExhDigiShowPage() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlvalidateexhdigishowpage));
		return driver.findElement(atlvalidateexhdigishowpage);
	}
	public WebElement getExhibitorNameOnExhDirectImg() {
		return driver.findElement(exhibitornameonexhdirectimg);
	}
	public WebElement getExhNameOnExhDirectImg() {
		return driver.findElement(exhnameonexhdirectimg);
	}
	public WebElement getAtlvalidateexhdigishowpage_lvmUAT() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlvalidateexhdigishowpage_lvmUAT));
		return driver.findElement(atlvalidateexhdigishowpage_lvmUAT);
	}
	public WebElement getExhibitornameonexhdirectimg_lvmUAT() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitornameonexhdirectimg_lvmUAT));
		return driver.findElement(exhibitornameonexhdirectimg_lvmUAT);
	}
	public WebElement getlvmvalidateexhdigishowpage_uat() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmvalidateexhdigishowpage_uat));
		return driver.findElement(lvmvalidateexhdigishowpage_uat);
	}
	public WebElement getlvmexhibitornameonexhdirectimg_uat() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmexhibitornameonexhdirectimg_uat));
		return driver.findElement(lvmexhibitornameonexhdirectimg_uat);
	}
	public WebElement getATLProductCategSection() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(productcategsectn));
		return driver.findElement(productcategsectn);
	}
	public List<WebElement> getATLProductCategItemList() {
		return driver.findElements(productcategitemlist);
	}
	public WebElement getATLProductCategTable() {
		return driver.findElement(prodcatgtable);
	}
	
	//Prod Elements
	
	public WebElement getSearchedExhibitor() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SearchedExhibitor));
		return driver.findElement(SearchedExhibitor);
	}
	public WebElement getVerifyExhibitorInFavoritesLists() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(VerifyExhibitorInFavoritesLists));
		return driver.findElement(VerifyExhibitorInFavoritesLists);
	}
	public WebElement getFavoriteIcon() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(favoriteicon));
		return driver.findElement(favoriteicon);
	}
	public WebElement getExhibitorName() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExhibitorName));
		return driver.findElement(ExhibitorName);
	}
	public WebElement getListButtonPlusIcon() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ListButtonlusIcon));
		return driver.findElement(ListButtonlusIcon);
	}
	public WebElement getNoteOptn() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(NoteOptn));
		return driver.findElement(NoteOptn);
	}
	public WebElement getNoteCloseBtn() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(NoteCloseBtn));
		return driver.findElement(NoteCloseBtn);
	}
	public WebElement getNoteTitle() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(NoteTitle));
		return driver.findElement(NoteTitle);
	}
	public WebElement getNoteDescription() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(NoteDescription));
		return driver.findElement(NoteDescription);
	}
	public WebElement getSaveNotBtn() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SaveNotBtn));
		return driver.findElement(SaveNotBtn);
	}
	public WebElement getViewAllNotes() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ViewAllNotes));
		return driver.findElement(ViewAllNotes);
	}
	public WebElement getVerifyAddedNote() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(VerifyAddedNote));
		return driver.findElement(VerifyAddedNote);
	}
	public WebElement getSaveNoteOKButton() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SaveNoteOKButton));
		return driver.findElement(SaveNoteOKButton);
	}
	public WebElement getLocation() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Location));
		return driver.findElement(Location);
	}
	public WebElement getContactExhibitor() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ContactExhibitor));
		return driver.findElement(ContactExhibitor);
	}
	public WebElement getProductSection() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ProductSection));
		return driver.findElement(ProductSection);
	}
	public WebElement getAllProductsButton() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AllProductsButton));
		return driver.findElement(AllProductsButton);
	}
	public WebElement getProductsPageBackButton() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ProductsPageBackButton));
		return driver.findElement(ProductsPageBackButton);
	}
	public WebElement getProductsList() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ProductsList));
		return driver.findElement(ProductsList);
	}
	public WebElement getProductsDescription() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ProductsDescription));
		return driver.findElement(ProductsDescription);
	}
	public WebElement getLinesSection() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LinesSection));
		return driver.findElement(LinesSection);
	}
	public WebElement getTotalLinesButton() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(TotalLinesButton));
		return driver.findElement(TotalLinesButton);
	}
	public WebElement getValidateLinesPage() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ValidateLinesPage));
		return driver.findElement(ValidateLinesPage);
	}
	public WebElement getLinesCountAtLinesPage() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LinesCountAtLinesPage));
		return driver.findElement(LinesCountAtLinesPage);
	}
	public WebElement getLinesOption() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LinesOption));
		return driver.findElement(LinesOption);
	}
	public WebElement getLinesPage() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LinesPage));
		return driver.findElement(LinesPage);
	}
	public WebElement getLinesOptionText() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LinesOptionText));
		return driver.findElement(LinesOptionText);
	}
	public WebElement getProductText() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ProductText));
		return driver.findElement(ProductText);
	} 
	public WebElement getAlphabeticSorting() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AlphabeticSorting));
		return driver.findElement(AlphabeticSorting);
	}
	public WebElement getProductSorting() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ProductSorting));
		return driver.findElement(ProductSorting);
	}
	public WebElement getLinesWithProduct() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LinesWithProduct));
		return driver.findElement(LinesWithProduct);
	}
	public WebElement getLinesOnJuniperMarket() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LinesOnJuniperMarket));
		return driver.findElement(LinesOnJuniperMarket);
	}
	public WebElement getLineSearch() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LineSearch));
		return driver.findElement(LineSearch);
	}
	public WebElement getLineSearchButton() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LineSearchButton));
		return driver.findElement(LineSearchButton);
	}
	public WebElement getVerifyLineSearch() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(VerifyLineSearch));
		return driver.findElement(VerifyLineSearch);
	}
	public WebElement getSeeInOtherMarket() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SeeInOtherMarket));
		return driver.findElement(SeeInOtherMarket);
	}
	public WebElement getVerifyOtherMarketsPage() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(VerifyOtherMarketsPage));
		return driver.findElement(VerifyOtherMarketsPage);
	}
	public WebElement getClickShowroom() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClickShowroom));
		return driver.findElement(ClickShowroom);
	}
	public WebElement getValidateDigitalShowroomPage() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ValidateDigitalShowroomPage));
		return driver.findElement(ValidateDigitalShowroomPage);
	}
	public WebElement getContactExhibitorInOtherMarket() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ContactExhibitorInOtherMarket));
		return driver.findElement(ContactExhibitorInOtherMarket);
	}
	public WebElement getVerifyContactExhibitorPage() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(VerifyContactExhibitorPage));
		return driver.findElement(VerifyContactExhibitorPage);
	}
	public WebElement getContactExhibitorCloseButton() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ContactExhibitorCloseButton));
		return driver.findElement(ContactExhibitorCloseButton);
	}
	public WebElement getCatalogsSection() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(CatalogsSection));
		return driver.findElement(CatalogsSection);
	}
	public WebElement getSeeAllCatalogsButton() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SeeAllCatalogsButton));
		return driver.findElement(SeeAllCatalogsButton);
	}
	public WebElement getSelectCatalog() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SelectCatalog));
		return driver.findElement(SelectCatalog);
	}
	
}



