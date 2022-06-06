package pageObjects.AtlantaMarket;

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
	By totalprodseealllink = By.xpath("//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div[2]/div[2]/div/div[2]/p[2]"); //Locator for Total Products-See All link for 1st Exhibitor
	By validateproductspage = By.xpath("//div[@id='Products']"); //Locator for Products tab on Exhibitor products page
	By totalprodcountonsearchgrid = By.xpath("//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div[2]/div[2]/div/div[2]/p[1]"); //Locator for Total Products count on Search Results grid
	By matchingprodcountonsearchgrid = By.xpath("//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div[2]/div[2]/div/div[1]/p[1]"); //Locator for Matching Products count on Search Results grid
	By matchingprodseealllink = By.xpath("//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div[2]/div[2]/div/div[1]/p[2]"); //Locator for Matching Products-See All link for 1st Exhibitor
	By matchingprodaddnoteicon = By.xpath("//button[@class='imc-addnote__openModal imc-addnote__openModal--hideafter imc-link--alt-darkred imc-content imc-content--delta imc-expand-collapse__heading']"); //Locator for Add Note icon on Matching products page
	By popupclosebtn = By.xpath("//button[@class='imc-modal--close imc-button--modal-close imc-button--round']"); //Locator for Close pop-up button
	By notetitletxtbx = By.xpath("//input[@name='title']"); //Locator for Note title text field
	By notecontenttxtbx = By.xpath("//textarea[@name='notes']"); //Locator for Note Content text field
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
	By seeDetailsBtn = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/a[1]"); //Locator for See Details button
	By exhibitorProdcut = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]"); //Locator for product
	By exhibitorProdcutName = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/p[1]"); //Locator for productName
	By exhibitorProdcutNameDetails = By.xpath("(//div[@class='imc-product-details--section'])[1]/div[1]/h2[1]"); //Locator for productName on Details Page
	By addToList = By.xpath("(//button[@class='imc-selectableicon imc-exhibitor-card__type--color'])[2]"); //Locator for Add to list
	By listName = By.xpath("//div[@class='imc-formfield imc-content ']/input[1]"); //Locator for List Name
	By goToMPBtn = By.xpath("//div[@class='imc-modal--content']/div[1]/div[1]/a[1]"); //Locator for MP btn
	By list = By.xpath("//div[@class='    imc-gallery imc-gallery--space-between-mobile-flex-start-desktop']/div[2]/div[1]/a[2]"); //Locator for List
	
	By listLeftPanel = By.xpath("//div[@class='imc-section  imc-section--full-width imc-section--full-width-mobile ']/div[1]/div[1]/div[2]/a[1]"); //Locator for List
	By newListName = By.xpath("//div[@class='accordion-collapse-transition']/ul[1]/li[26]/div[1]"); //Locator for New List Name
	
	By allListNames = By.xpath("//li[@class='imc-market-planner-list-draggable-item']"); //Locator for All List Names
	public ATLExhLineProdActionsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getExhibitorName() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitorname));
		return driver.findElement(exhibitorname);
	}
	
	public WebElement getAddFavIcon() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(addfavicon));
		return driver.findElement(addfavicon);
	}
	public WebElement getSearchResultMoreicon() {
		return driver.findElement(searchresultmoreicon);
	}
	public WebElement getAddToListOptn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(addtolistoptn));
		return driver.findElement(addtolistoptn);
	}
	public WebElement getContactExhibitorIcon() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactexhibitoricon));
		return driver.findElement(contactexhibitoricon);
	}
	public WebElement getContactExhibitorModal() {
		wait = new WebDriverWait (driver,20);
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
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locationlinkinexhcard));
		return driver.findElement(locationlinkinexhcard);
	}
	public WebElement getLinesShownSeeAlLink() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lineshownseealllink));
		return driver.findElement(lineshownseealllink);
	}
	public WebElement getValidateLinesPage() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(validatelinespage));
		return driver.findElement(validatelinespage);
	}
	public WebElement getTotalProdSeeAllLink() {
		return driver.findElement(totalprodseealllink);
	}
	public WebElement getValidateProductsPage() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(validateproductspage));
		return driver.findElement(validateproductspage);
	}
	public WebElement getTotalProdCountOnSearchGrid() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(totalprodcountonsearchgrid));
		return driver.findElement(totalprodcountonsearchgrid);
	}
	public WebElement getMatchingProdCountOnSearchGrid() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(matchingprodcountonsearchgrid));
		return driver.findElement(matchingprodcountonsearchgrid);
	}
	public WebElement getMatchingProdSeeAllLink() {
		return driver.findElement(matchingprodseealllink);
	}
	public WebElement getMatchingProdAddNoteIcon() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(matchingprodaddnoteicon));
		return driver.findElement(matchingprodaddnoteicon);
	}
	public WebElement getPopUpCloseBtn() {
		return driver.findElement(popupclosebtn);
	}
	public WebElement getNoteTitleTxtBx() {
		return driver.findElement(notetitletxtbx);
	}
	public WebElement getNoteContentTxtBx() {
		return driver.findElement(notecontenttxtbx);
	}
	public WebElement getNoteSaveBtn() {
		return driver.findElement(notesavebtn);
	}
	public WebElement getViewAllNotesLink() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(viewallnoteslink));
		return driver.findElement(viewallnoteslink);
	}
	public List <WebElement> getSavedNoteNameInAllNotesList() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(savednotenameinallnoteslist));
		return driver.findElements(savednotenameinallnoteslist);
	}
	public WebElement getNoteForAnExhibitorModal() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(noteforanexhibitormodal));
		return driver.findElement(noteforanexhibitormodal);
	}
	public WebElement getDeleteNoteBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(noteforanexhibitormodal));
		return driver.findElement(deletenotebtn);
	}
	public WebElement getOrderOnJuniperMarketBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(orderOnJuniperMarketBtn));
		return driver.findElement(orderOnJuniperMarketBtn);
	}

	public WebElement getExhibitorNameLink() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitorNameLink));
		return driver.findElement(exhibitorNameLink);
	}
	public WebElement getLineLocationLink() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lineLocationLink));
		return driver.findElement(lineLocationLink);
	}
	

	public WebElement getseealllink() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(seealllink);
	}
	public WebElement getcreatelistbtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(createlistbtn));
		return driver.findElement(createlistbtn);
	}
	public WebElement getSeeDetailsbtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(seeDetailsBtn));
		return driver.findElement(seeDetailsBtn);
	}
	public WebElement getExhibitorProduct() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitorProdcut));
		return driver.findElement(exhibitorProdcut);
	}
	public WebElement getExhibitorProdcutName() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitorProdcutName));
		return driver.findElement(exhibitorProdcutName);
	}
	
	public WebElement getExhibitorProdcutNameDetails() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitorProdcutNameDetails));
		return driver.findElement(exhibitorProdcutNameDetails);
	}
	
	public WebElement getAddToList() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(addToList));
		return driver.findElement(addToList);
	}
	
	public WebElement getListName() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(listName));
		return driver.findElement(listName);
	}
	
	public WebElement getGoToMPBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(goToMPBtn));
		return driver.findElement(goToMPBtn);
	}
	
	public WebElement getList() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(list));
		return driver.findElement(list);
	}
	
	public WebElement getListLeftPanel() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(listLeftPanel));
		return driver.findElement(listLeftPanel);
	}
	public WebElement getnewListName() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(newListName));
		return driver.findElement(newListName);
	}
	
	public WebElement getAllListNames() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(allListNames));
		return driver.findElement(allListNames);
	}
}



