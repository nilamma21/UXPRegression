package pageObjects.AtlantaMarket;

import java.time.Duration;
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
	By exhibitornameonexhdirectimg = By.xpath("//span[@class='imc-heading imc-heading--giga-desktop imc-vr--medium imc-content--inline-block']"); //Locator for Exhibitor name on Exhibitor Directory image
	By lvmexhibitornameonexhdirectimg_uat = By.xpath("//span[@class='imc-heading imc-heading--giga-desktop ']"); //Locator for Exhibitor name on Exhibitor Directory image
	By exhibitornameonexhdirectimg_lvmUAT = By.xpath("//span[@class='imc-heading imc-heading--giga-desktop imc-vr--medium imc-content--inline-block']"); //Locator for Exhibitor name on Exhibitor Directory image LVM UAT
	By exhdigishowroompage = By.xpath("//div[@class='imc-section--full-width-mobile imc-content--display-flex imc-content--display-flex-grow-1 imc-section--divided']"); //Locator for Exhibitor Digital Showroom page
	By exhnameonexhdirectimg = By.xpath("//section[@class='imc-site-wrapper']//descendant::span[@class='imc-heading imc-heading--giga-desktop ']"); //Locator for Exhibitor name on Exhibitor Directory image
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
	By Location = By.xpath("//div[@class='imc-content--block']/descendant::span[@class='imc-content--pipe']/a"); //Locator for Location text at Digital Showroom page
	By Location_uat = By.xpath("(//a[@class='imc-link imc-type--title-6 imc-content--inline-block imc-vr--large'])[1]"); //Locator for Location symbol at Digital Showroom page
	By ContactExhibitor = By.xpath("//div[@class = 'contact-exhibitor-wrapper']/button[1]"); //Locator for Contact Exhibitor button
	By ProductSection = By.xpath("//div[@class = 'imc-content--display-flex-wrap']/span[contains(text(),'Products Shown')]"); //Locator for Product section in Exhibitor Digital Showroom
	By AllProductsButton = By.xpath("//a[@class = 'imc-content--inline-block imc-button imc-button--primary-inverted imc-button--full-bleed-mobile']"); //Locator for See All Products button
	By ProductsPageBackButton = By.xpath("//button[@class = 'imc-icon-BackArrow imc-button--icon-only imc-button--no-border imc-heading--mega imc-heading--line-height-1 imc-content--display-flex']"); //Locator for Back arrow at Products page
	By ProductsList = By.xpath("//div[@class = 'imc-products-overview--gallery']/div[1]"); //Locator for first product in Product List at Exhibitor Digital Showroom
	By ProductsDescription = By.xpath("//h5[@class = 'imc-margin--bottom--medium']"); //Locator for Products section at Products page
	By LinesSection = By.xpath("//div[@id = 'digitalShowRoomLines']/div[1]/div[1]"); //Locator for Lines section
	By TotalLinesButton = By.xpath("//div[@class = 'imc-content--display-flex imc-content--display-flex-space-between imc-lines-overview-actions']/div[2]/a[1]"); //Locator for Sell All Lines button
	By ValidateLinesPage = By.xpath("//ul[@class = 'imc-breadcrumb']/li[4]"); //Locator for Validate Lines page
	By LinesCountAtLinesPage = By.xpath("//div[@id = 'Lines']"); //Locator for Lines tab at All Lines page
	By LinesOption = By.xpath("//div[@class = 'imc-content--display-flex-wrap imc-content--display-flex imc-content--display-flex-space-between']/div[1]/div[2]/a[1]"); //Locator for First Lines option
	By LinesPage = By.xpath("//section[@class = 'imc-site-wrapper']/div[2]/div[1]"); //Locator for Lines page
	By LinesOptionText = By.xpath("//div[@class = 'imc-manufacturing-line']/div[2]/a[1]"); //Locator for Lines option text
	By ProductText = By.xpath("//div[@class = 'imc-catalog__item_title multiSelectItem']"); //Locator for Product text
	By AlphabeticSorting = By.xpath("//div[@class = 'imc-content--display-flex']/a[1]"); //Locator for A to Z sorting
	By ProductSorting = By.xpath("//div[@class = 'imc-content--display-flex']/a[2]"); //Locator for sort by product
	By LinesWithProduct = By.xpath("//div[@class = 'imc-content--display-flex']/a[3]"); //Locator for Line with Product sorting
	By LinesOnJuniperMarket = By.xpath("//div[@class = 'imc-content--display-flex']/a[4]"); //Locator for Line with Juniper Market sorting
	By LineSearch = By.xpath("//input[@id = 'product-search']"); //Locator for line search
	//By LineSearchButton = By.xpath("//button[@class = 'imc-searchform--button--search']"); //Locator for line search button 		
	By VerifyLineSearch = By.xpath("//div[@class = 'imc-manufacturing-line-title-wrapper']/a[1]"); //Locator for verify line search  
	By VerifyLinePageTitle = By.xpath("//div[@class = 'imc-gallery imc-gallery--65-35 breadcrumbs__round']/div[1]/ul[1]/li[4]/a[1]"); //Locator for verify line page title
	By LineSearchButton = By.xpath("(//div[@class = 'imc-searchform--button--search'])[2]"); //Locator for line search button 		
	By SeeInOtherMarket = By.xpath("//button[@class = 'imc-button imc-button--full-bleed-mobile imc-button--primary-inverted imc-margin--all--none']"); //Locator for See In Other Markets button
	By VerifyOtherMarketsPage = By.xpath("//div[@class = 'ReactModal__Content ReactModal__Content--after-open imc-modal--box imc-modal--box-wide']"); //Locator for See In Other Markets page title
	By ClickShowroom = By.xpath("//div[@class = 'imc-other-markets-goto']/a[1]"); //Locator for Go to Showroom link
	By ValidateDigitalShowroomPage = By.xpath("//div[@class = 'imc-gallery__item imc-content--center-mobile']/span[1]"); //Locator for Exhibitor Digital Showroom page
	By ContactExhibitorInOtherMarket = By.xpath("//div[@class = 'imc-other-markets-contact']/div[1]/button[1]"); //Locator for Contact Exhibitor link at See in Other Markets page
	By VerifyContactExhibitorPage = By.xpath("//div[@class = 'imc-modal--content imc-contactexhibitormodal--position']"); //Locator for Contact Exhibitor Page
	By ContactExhibitorCloseButton = By.xpath("//div[@class = 'ReactModalPortal']/div[1]/button[1]"); //Locator for Close button at Contact Exhibitor page  		

	By CatalogSection = By.xpath("//div[@class = 'imc-exhibitors--alternated-section imc-section--full-width-mobile imc-content--display-flex imc-content--display-flex-grow-1']/div[1]/div/span[text()='Catalogs']"); //Locator for Catalog section  			
	By CatalogSeeAllBtn = By.xpath("(//span[contains(text(),'See') and contains(text(),'Catalog')])[1]"); //Locator for Catalog see All Btn
	By HeroComponentVisit = By.xpath("//span[contains(text(),'Visit ')]/.."); //Locator for Hero Component Visit Btn
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
	By See1CatalogButton_Uat = By.xpath("//section[@class = 'imc-site-wrapper']/div[5]/div[1]/div[3]/div[1]/a[1]"); //Locator for See 1 Catalog section
	By SelectCatalog = By.xpath("//span[contains(text(),'Catalogs')]//parent::div//parent::div//descendant::div[@class = 'imc-catalog__item_title multiSelectItem']"); //Locator for Catalog option in Catalogs section
	By showSpecialSection = By.xpath("//div[@class = 'imc-exhibitors--alternated-section imc-section--full-width-mobile imc-content--display-flex imc-content--display-flex-grow-1']/div[1]/div[1]/span[text()='Show Specials']"); //Locator for Show special Section
	By SeeAllshowSpecialBtn = By.xpath("//div[@class = 'imc-exhibitors--alternated-section imc-section--full-width-mobile imc-content--display-flex imc-content--display-flex-grow-1']/div[1]/div/span[text()='Show Specials']/../../div[3]/div[1]/a[1]/span[1]"); ////Locator for See All Show special Btn
	By ShowSpecialCount = By.xpath("//span[contains(text(),'Specials') and contains(text(),'Available')]"); ////Locator for See All Show special Count
	By ShowSpecialName = By.xpath("//div[@class = 'imc-exhibitors--alternated-section imc-section--full-width-mobile imc-content--display-flex imc-content--display-flex-grow-1']/div[1]/div[1]/span[text()='Show Specials']/../../div[2]/span[1]"); ////Locator for See All Show special Count
	By heroComponentOrderOnJunperBtn = By.xpath("//div[@class='imc-section imc-padding--left--xlarge imc-padding--right--xlarge imc-section--width-100-percent']/div//span[@class='imc-breakpoint-display--hide-mobile' and text()='Order on JuniperMarket']/.."); ////Locator for Order on Juniper CTA
	By closeBtnContactExh = By.xpath("//button[@class='imc-modal--close imc-button--modal-close imc-button--round']"); ////Locator for Closse Btn
	By linesshowntextonsearchgrid = By.xpath("(//div[@class='imc-exhibitorcard-title-row ']/descendant::div[@class='imc-exhibitorcard--text-container-row']/p)[1]"); //Locator for Line shown text on Search grid
	By linesshownseealllink = By.xpath("(//div[@class='imc-exhibitorcard-title-row'])[1]/div[1]/div[1]/a"); //Locator for Lines shown-see all link
	By exhibitornameonexhdirectimglvm = By.xpath("//span[@class='imc-heading imc-heading--giga-desktop ']"); //Locator for Exhibitor name on Exhibitor Directory image
	By EventNamePROD = By.xpath("(//div[@class='event-card--info'])[1]/div[1]/div[1]/a[1]/p"); //Locator for Events Section
	By exhnameonexhdirectimg1 = By.xpath("//section[@class='imc-site-wrapper']//descendant::span[@class='imc-heading imc-heading--giga-desktop imc-vr--medium imc-content--inline-block']"); //Locator for Exhibitor name on Exhibitor Directory image
	By ContactExhibitorHero = By.xpath("(//span[contains(text(),'Contact Exhibitor')])[1]");
	By ContactPopUp = By.xpath("//h2[@class='imc-heading--box-modal']");
	By ContactPopUpClose = By.xpath("//button[@class='imc-modal--close imc-button--modal-close imc-button--round']");
	By exhdigishowroompagenew = By.xpath("//div[@class='imc-section--full-width-mobile imc-content--display-flex imc-content--display-flex-grow-1 imc-section--divided-bottom imc-section--padded-bottom-none']");
	By ShownByTextValidate = By.xpath("//div[@class='imc-content imc-type--title-6 imc-type--color-neutral-heavy-medium imc-vr--small imc-content--inline-block imc-margin--left--small']"); //Shown By Text to validate the line digital showroom page with no image
	By LineExhName = By.xpath("//h1[@class='imc-heading--h4']"); //Shown By Text to validate the line digital showroom page with no image
	
	
	
	public ATLExhDigiShowroomPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	public WebElement getLineExhName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LineExhName));
		return driver.findElement(LineExhName);
	}
	public WebElement getEventNamePROD() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(EventNamePROD));
		return driver.findElement(EventNamePROD);
	}
	public WebElement getcloseBtnContactExh() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(closeBtnContactExh));
		return driver.findElement(closeBtnContactExh);
	}
	public WebElement getheroComponentOrderOnJunperBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(heroComponentOrderOnJunperBtn));
		return driver.findElement(heroComponentOrderOnJunperBtn);
	}
	public WebElement getShowSpecialName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShowSpecialName));
		return driver.findElement(ShowSpecialName);
	}
	public WebElement getShowSpecialCount() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShowSpecialCount));
		return driver.findElement(ShowSpecialCount);
	}
	public WebElement getSeeAllshowSpecialBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(SeeAllshowSpecialBtn));
		return driver.findElement(SeeAllshowSpecialBtn);
	}
	public WebElement getshowSpecialSection() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(showSpecialSection));
		return driver.findElement(showSpecialSection);
	}
	public WebElement getOrderOnJuniperMarktBtnCatalog() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(OrderOnJuniperMarktBtnCatalog));
		return driver.findElement(OrderOnJuniperMarktBtnCatalog);
	}
	public WebElement getEventName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(EventName));
		return driver.findElement(EventName);
	}
	public WebElement getSeeAllEventsBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(SeeAllEventsBtn));
		return driver.findElement(SeeAllEventsBtn);
	}
	public WebElement getEventsSection() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(EventsSection));
		return driver.findElement(EventsSection);
	}
	public WebElement getView3DshowroomClose() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(View3DshowroomClose));
		return driver.findElement(View3DshowroomClose);
	}
	public WebElement getView3DshowroomBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(View3DshowroomBtn));
		return driver.findElement(View3DshowroomBtn);
	}
	public WebElement getshowroomHeader3D() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(showroomHeader3D));
		return driver.findElement(showroomHeader3D);
	}
	public WebElement getHeroComponentVisit() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(HeroComponentVisit));
		return driver.findElement(HeroComponentVisit);
	}
	public WebElement getATLCatalogSeeAllBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(CatalogSeeAllBtn));
		return driver.findElement(CatalogSeeAllBtn);
	}
	public WebElement getATLCatalogSection() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(CatalogSection));
		return driver.findElement(CatalogSection);
	}
	public WebElement getATLVerifyLinePageTitle() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(VerifyLinePageTitle));
		return driver.findElement(VerifyLinePageTitle);
	}
	public WebElement getATLExhDigiShowPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhdigishowroompage));
		return driver.findElement(exhdigishowroompage);
	}
	public WebElement getATLValidateExhDigiShowPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlvalidateexhdigishowpage));
		return driver.findElement(atlvalidateexhdigishowpage);
	}
	public WebElement getExhibitorNameOnExhDirectImg() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitornameonexhdirectimg));
		return driver.findElement(exhibitornameonexhdirectimg);
	}
	public WebElement getExhNameOnExhDirectImg() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhnameonexhdirectimg));
		return driver.findElement(exhnameonexhdirectimg);
	}
	public WebElement getAtlvalidateexhdigishowpage_lvmUAT() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlvalidateexhdigishowpage_lvmUAT));
		return driver.findElement(atlvalidateexhdigishowpage_lvmUAT);
	}
	public WebElement getExhibitornameonexhdirectimg_lvmUAT() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitornameonexhdirectimg_lvmUAT));
		return driver.findElement(exhibitornameonexhdirectimg_lvmUAT);
	}
	public WebElement getlvmvalidateexhdigishowpage_uat() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmvalidateexhdigishowpage_uat));
		return driver.findElement(lvmvalidateexhdigishowpage_uat);
	}
	public WebElement getlvmexhibitornameonexhdirectimg_uat() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmexhibitornameonexhdirectimg_uat));
		return driver.findElement(lvmexhibitornameonexhdirectimg_uat);
	}
	public WebElement getATLProductCategSection() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(productcategsectn));
		return driver.findElement(productcategsectn);
	}
	public List<WebElement> getATLProductCategItemList() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(productcategitemlist));
		return driver.findElements(productcategitemlist);
	}
	public WebElement getATLProductCategTable() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(prodcatgtable));
		return driver.findElement(prodcatgtable);
	}
	
	//Prod Elements
	
	public WebElement getSearchedExhibitor() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(SearchedExhibitor));
		return driver.findElement(SearchedExhibitor);
	}
	public WebElement getVerifyExhibitorInFavoritesLists() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(VerifyExhibitorInFavoritesLists));
		return driver.findElement(VerifyExhibitorInFavoritesLists);
	}
	public WebElement getFavoriteIcon() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(favoriteicon));
		return driver.findElement(favoriteicon);
	}
	public WebElement getExhibitorName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExhibitorName));
		return driver.findElement(ExhibitorName);
	}
	public WebElement getListButtonPlusIcon() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ListButtonlusIcon));
		return driver.findElement(ListButtonlusIcon);
	}
	public WebElement getNoteOptn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(NoteOptn));
		return driver.findElement(NoteOptn);
	}
	public WebElement getNoteCloseBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(NoteCloseBtn));
		return driver.findElement(NoteCloseBtn);
	}
	public WebElement getNoteTitle() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(NoteTitle));
		return driver.findElement(NoteTitle);
	}
	public WebElement getNoteDescription() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(NoteDescription));
		return driver.findElement(NoteDescription);
	}
	public WebElement getSaveNotBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(SaveNotBtn));
		return driver.findElement(SaveNotBtn);
	}
	public WebElement getViewAllNotes() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ViewAllNotes));
		return driver.findElement(ViewAllNotes);
	}
	public WebElement getVerifyAddedNote() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(VerifyAddedNote));
		return driver.findElement(VerifyAddedNote);
	}
	public WebElement getSaveNoteOKButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(SaveNoteOKButton));
		return driver.findElement(SaveNoteOKButton);
	}
	public WebElement getLocation() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Location));
		return driver.findElement(Location);
	}
	public WebElement getLocation_uat() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Location_uat));
		return driver.findElement(Location_uat);
	}
	public WebElement getContactExhibitor() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ContactExhibitor));
		return driver.findElement(ContactExhibitor);
	}
	public WebElement getProductSection() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ProductSection));
		return driver.findElement(ProductSection);
	}
	public WebElement getAllProductsButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(AllProductsButton));
		return driver.findElement(AllProductsButton);
	}
	public WebElement getProductsPageBackButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ProductsPageBackButton));
		return driver.findElement(ProductsPageBackButton);
	}
	public WebElement getProductsList() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ProductsList));
		return driver.findElement(ProductsList);
	}
	public WebElement getProductsDescription() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ProductsDescription));
		return driver.findElement(ProductsDescription);
	}
	public WebElement getLinesSection() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LinesSection));
		return driver.findElement(LinesSection);
	}
	public WebElement getTotalLinesButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(TotalLinesButton));
		return driver.findElement(TotalLinesButton);
	}
	public WebElement getValidateLinesPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ValidateLinesPage));
		return driver.findElement(ValidateLinesPage);
	}
	public WebElement getLinesCountAtLinesPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LinesCountAtLinesPage));
		return driver.findElement(LinesCountAtLinesPage);
	}
	public WebElement getLinesOption() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LinesOption));
		return driver.findElement(LinesOption);
	}
	public WebElement getLinesPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LinesPage));
		return driver.findElement(LinesPage);
	}
	public WebElement getLinesOptionText() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LinesOptionText));
		return driver.findElement(LinesOptionText);
	}
	public WebElement getProductText() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ProductText));
		return driver.findElement(ProductText);
	} 
	public WebElement getAlphabeticSorting() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(AlphabeticSorting));
		return driver.findElement(AlphabeticSorting);
	}
	public WebElement getProductSorting() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ProductSorting));
		return driver.findElement(ProductSorting);
	}
	public WebElement getLinesWithProduct() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LinesWithProduct));
		return driver.findElement(LinesWithProduct);
	}
	public WebElement getLinesOnJuniperMarket() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LinesOnJuniperMarket));
		return driver.findElement(LinesOnJuniperMarket);
	}
	public WebElement getLineSearch() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LineSearch));
		return driver.findElement(LineSearch);
	}
	public WebElement getLineSearchButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LineSearchButton));
		return driver.findElement(LineSearchButton);
	}
	public WebElement getVerifyLineSearch() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(VerifyLineSearch));
		return driver.findElement(VerifyLineSearch);
	}
	public WebElement getSeeInOtherMarket() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(SeeInOtherMarket));
		return driver.findElement(SeeInOtherMarket);
	}
	public WebElement getVerifyOtherMarketsPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(VerifyOtherMarketsPage));
		return driver.findElement(VerifyOtherMarketsPage);
	}
	public WebElement getClickShowroom() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClickShowroom));
		return driver.findElement(ClickShowroom);
	}
	public WebElement getValidateDigitalShowroomPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ValidateDigitalShowroomPage));
		return driver.findElement(ValidateDigitalShowroomPage);
	}
	public WebElement getContactExhibitorInOtherMarket() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ContactExhibitorInOtherMarket));
		return driver.findElement(ContactExhibitorInOtherMarket);
	}
	public WebElement getVerifyContactExhibitorPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(VerifyContactExhibitorPage));
		return driver.findElement(VerifyContactExhibitorPage);
	}
	public WebElement getContactExhibitorCloseButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ContactExhibitorCloseButton));
		return driver.findElement(ContactExhibitorCloseButton);
	}
	public WebElement getCatalogsSection() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(CatalogsSection));
		return driver.findElement(CatalogsSection);
	}
	public WebElement getSeeAllCatalogsButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(SeeAllCatalogsButton));
		return driver.findElement(SeeAllCatalogsButton);
	}
	public WebElement getSee1CatalogButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(See1CatalogButton_Uat));
		return driver.findElement(See1CatalogButton_Uat);
	}
	public WebElement getSelectCatalog() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(SelectCatalog));
		return driver.findElement(SelectCatalog);
	}
	public WebElement getLinesShownTxtOnSearchGrid() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(linesshowntextonsearchgrid));
		return driver.findElement(linesshowntextonsearchgrid);
	}
	public WebElement getLinesShownSeeAllLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(linesshownseealllink));
		return driver.findElement(linesshownseealllink);
	}
	public WebElement getExhibitorNameOnExhDirectImgLvm() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitornameonexhdirectimglvm));
		return driver.findElement(exhibitornameonexhdirectimglvm);
	}
	 public WebElement getExhNameOnExhDirectImg1() {
	      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	      wait.until(ExpectedConditions.visibilityOfElementLocated(exhnameonexhdirectimg1));
	      return driver.findElement(exhnameonexhdirectimg1);
	 }
	  public WebElement getContactExhibitorHero() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ContactExhibitorHero));
        return driver.findElement(ContactExhibitorHero);
    }
	  public WebElement getContactPopUp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ContactPopUp));
        return driver.findElement(ContactPopUp);
    }
	 public WebElement getContactPopUpClose() {
	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	     wait.until(ExpectedConditions.visibilityOfElementLocated(ContactPopUpClose));
	     return driver.findElement(ContactPopUpClose);
	 }
	 public WebElement getATLExhDigiShowPageNew() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(exhdigishowroompagenew));
		 return driver.findElement(exhdigishowroompagenew);
	 }
	 public WebElement getShownByTextValidate() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(ShownByTextValidate));
		 return driver.findElement(ShownByTextValidate);
	 }
}


