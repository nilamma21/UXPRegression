package pageObjects.AtlantaMarket;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLProductDetailsPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By atlvalidateproddetailspage = By.xpath("(//div[@class='imc-product-details--section'])[position()=1]"); // Locator to validate Product Details page
	By productnameonproddetails = By.xpath("(//div[@class='imc-product-details--section'])[1]/div[1]/h2[1]"); //Locator for productName on Details Page
	By addToList = By.xpath("(//button[@class='imc-selectableicon imc-exhibitor-card__type--color'])[2]"); //Locator for Add to list
	By listName = By.xpath("//div[@class='imc-formfield imc-content ']/input[1]"); //Locator for List Name
	By goToMPBtn = By.xpath("//div[@class='imc-modal--content']/div[1]/div[1]/a[1]"); //Locator for MP btn
	By list = By.xpath("//div[@class='    imc-gallery imc-gallery--space-between-mobile-flex-start-desktop']/div[2]/div[1]/a[2]"); //Locator for List
	By listLeftPanel = By.xpath("//div[@class='imc-section  imc-section--full-width imc-section--full-width-mobile ']/div[1]/div[1]/div[2]/a[1]"); //Locator for List
	By newListName = By.xpath("//span[@class='imc-type--title-2']"); //Locator for New List Name
	By allListNames = By.xpath("//li[@class='imc-market-planner-list-draggable-item']"); //Locator for All List Names
	By addToSelectedBtn = By.xpath("//div[@class='imc-button--justify-right']/input[1]"); //Locator for Add to Selected Btn
	By productNameFromList = By.xpath("(//div[@class='imc-saved-exhibitors__contentItems--item'])[1]/div[1]/div[1]/a[1]"); //Locator for product name from list
	By productaddtofavicon = By.xpath("//label[@aria-label='Favorite']"); //Locator for Add To Favorite icon for Product on details page
	By productAddNote = By.xpath("//div[@class='imc-addnote imc-expand-collapse']/div/button/label[1]"); //Locator for Add Note icon for Product on details page
	By addNotePopup = By.xpath("//div[@class='imc-addnote imc-expand-collapse']/div/button/label[1]"); //Locator for Add Note Popup 
	By addNoteTitleTextbox = By.xpath("(//div[@class='imc-formfield imc-content imc-addnote-modal__text-area imc-type--title-5-link'])[1]/input[1]"); //Locator for Add Note Text box
	By addNoteContainsTextArea= By.xpath("(//div[@class='imc-formfield imc-content imc-addnote-modal__text-area imc-type--title-5-link'])[2]/textarea[1]"); //Locator for Add Note Contains
	By addNoteSaveBtn= By.xpath("//div[@class='imc-addnote-modal__actions-wrapper']/input[@type='submit']"); //Locator for Save btn
	By viewAllNotes= By.xpath("//div[@class='imc-addnote-modal__actions-wrapper']/a[1]"); //Locator for View All Notes
	By viewAllNotesPopupHeader= By.xpath("//div[@class='ReactModal__Content ReactModal__Content--after-open imc-modal--box imc-addnote-modal']/div[1]/div[1]/div[1]/h4[1]"); //Locator for View All Notes Header
	By allNotesList= By.xpath("//ul[@class='imc-market-planner-list imc-addnote-modal__list']/li"); //Locator for All Notes
	By verifyNoteTitle= By.xpath("//div[@class='imc-addnote-modal__padded-top-bottom']/h5[1]"); //Locator for note title
	
	public ATLProductDetailsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getATLValidateProdDetailsPage() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlvalidateproddetailspage));
		return driver.findElement(atlvalidateproddetailspage);
	}
	
	
	public WebElement getProductNameOnProductDetails() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(productnameonproddetails));
		return driver.findElement(productnameonproddetails);
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
	public WebElement getAddToSelectedBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(addToSelectedBtn));
		return driver.findElement(addToSelectedBtn);
	}
	public WebElement getProductNameFromList() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(productNameFromList));
		return driver.findElement(productNameFromList);
	}
	public WebElement getProductAddToFavIcon() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(productaddtofavicon));
		return driver.findElement(productaddtofavicon);
	}
	public WebElement getProductAddNoteIcon() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(productAddNote));
		return driver.findElement(productAddNote);
	}
	public WebElement getAddNotePopup() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(addNotePopup));
		return driver.findElement(addNotePopup);
	}
	public WebElement getAddNoteTitleTextbox() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(addNoteTitleTextbox));
		return driver.findElement(addNoteTitleTextbox);
	}
	public WebElement getAddNoteContainsTextArea() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(addNoteContainsTextArea));
		return driver.findElement(addNoteContainsTextArea);
	}
	public WebElement getAddNoteSaveBtn() {
		wait = new WebDriverWait (driver,20);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(addNoteSaveBtn));
		wait.until(ExpectedConditions.elementToBeClickable(addNoteSaveBtn));
		return driver.findElement(addNoteSaveBtn);
	}
	public WebElement getViewAllNotes() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(viewAllNotes));
		return driver.findElement(viewAllNotes);
	}
	public WebElement getViewAllNotesPopupHeader() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(viewAllNotesPopupHeader));
		return driver.findElement(viewAllNotesPopupHeader);
	}
	
	public List <WebElement> getAllNotesList() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(allNotesList));
		return driver.findElements(allNotesList);
	}
	public WebElement getVerifyNoteTitle() {
			wait = new WebDriverWait (driver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(verifyNoteTitle));
			return driver.findElement(verifyNoteTitle);
		}
}



