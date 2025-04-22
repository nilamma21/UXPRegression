package pageObjects.AtlantaMarket;

import java.time.Duration;
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

	By productfullscreenviewerbtn = By.xpath("//div[@class='imc-product-details--gallery--image-fullscreen']"); //Locator for Product Full Screen Viewer btn
	By productfullscreenviewer = By.xpath("//div[@class='imc-modal--gallery--section']"); //Locator for Product Full Screen Viewer
	By prodfullscreenviewertitle = By.xpath("//div[@class='imc-modal--gallery--section']/h2"); //Locator for Product Full Screen Viewer title
	


    public ATLProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    // Generic element getter with smart waiting
    private WebElement getElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Generic elements getter (for lists)
    private List<WebElement> getElements(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    // Page-specific methods
    public WebElement getATLValidateProdDetailsPage() {
        return getElement(atlvalidateproddetailspage);
    }

    public WebElement getProductNameOnProductDetails() {
        return getElement(productnameonproddetails);
    }

    public WebElement getAddToList() {
        return getElement(addToList);
    }

    public WebElement getListName() {
        return getElement(listName);
    }

    public WebElement getGoToMPBtn() {
        return getElement(goToMPBtn);
    }

    public WebElement getList() {
        return getElement(list);
    }

    public WebElement getListLeftPanel() {
        return getElement(listLeftPanel);
    }

    public WebElement getnewListName() {
        return getElement(newListName);
    }

    public WebElement getAllListNames() {
        return getElement(allListNames);
    }

    public WebElement getAddToSelectedBtn() {
        return getElement(addToSelectedBtn);
    }

    public WebElement getProductNameFromList() {
        return getElement(productNameFromList);
    }

    public WebElement getProductAddToFavIcon() {
        return getElement(productaddtofavicon);
    }

    public WebElement getProductAddNoteIcon() {
        return getElement(productAddNote);
    }

    public WebElement getAddNotePopup() {
        return getElement(addNotePopup);
    }

    public WebElement getAddNoteTitleTextbox() {
        return getElement(addNoteTitleTextbox);
    }

    public WebElement getAddNoteContainsTextArea() {
        return getElement(addNoteContainsTextArea);
    }

    public WebElement getAddNoteSaveBtn() {
        return wait.until(ExpectedConditions.elementToBeClickable(addNoteSaveBtn));
    }

    public WebElement getViewAllNotes() {
        return getElement(viewAllNotes);
    }

    public WebElement getViewAllNotesPopupHeader() {
        return getElement(viewAllNotesPopupHeader);
    }

    public List<WebElement> getAllNotesList() {
        return getElements(allNotesList);
    }

    public WebElement getVerifyNoteTitle() {
        return getElement(verifyNoteTitle);
    }

    public WebElement getProductFullScreenViewerBtn() {
        return getElement(productfullscreenviewerbtn);
    }

    public WebElement getProductFullScreenViewer() {
        return getElement(productfullscreenviewer);
    }

    public WebElement getProductFullScreenViewerTitle() {
        return getElement(prodfullscreenviewertitle);
    }
}





