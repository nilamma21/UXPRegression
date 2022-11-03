package pageObjects.AtlantaMarket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLLineDigitalShowroomPage {
	public WebDriver driver;
	public WebDriverWait wait;

	By atlLineDigiShowroomPageTitle = By.xpath("//div[@class='imc-gallery imc-gallery--65-35 breadcrumbs__round']/div[1]/ul[1]/li[4]/a[1]"); // Locator Line Digi showroom page title
	By digiShowroomExhName = By.xpath("//div[@class='imc-section--full-width-mobile imc-content--display-flex imc-content--display-flex-grow-1']/div[1]/div[1]/div[2]/a[1]"); // Locator  Exhibitor name shown by Digital Showroom page
	By suggetionList = By.xpath("//div[@ID='react-autowhatever-input-1']"); // Locator Suggetion list 1st suggetion
	By locationLink = By.xpath("//div[@class='imc-section--full-width-mobile imc-content--display-flex imc-content--display-flex-grow-1']/div[1]/div[1]/div[3]/span[2]/a[1]"); //Locator for Location liks
	By favIconDigiShowroom = By.xpath("//div[@class='imc-section--full-width-mobile imc-content--display-flex imc-content--display-flex-grow-1']/div[1]/div[1]/div[4]/ul[1]/li[1]/div[1]/button[1]"); //Locator for Exhibitor name on Exhibitor Directory image
	By addToListIcon = By.xpath("//div[@class='imc-section--full-width-mobile imc-content--display-flex imc-content--display-flex-grow-1']/div[1]/div[1]/div[4]/ul[1]/li[2]/button[1]"); //Locator for Add to list
	By atl1stListName = By.xpath("(//div[@class='imc-vr--xlarge'])[2]/div[1]/label[1]"); //Locator for 1st List name
	By addNoteIcon = By.xpath("//div[@class='imc-section--full-width-mobile imc-content--display-flex imc-content--display-flex-grow-1']/div[1]/div[1]/div[4]/ul[1]/li[3]/div[1]/div[1]/div[1]/button[1]"); //Locator for Add Note
	By productcategsectn = By.xpath("//h5[contains(text(),'Product Categories')]"); //Locator for Products Categories section title
	By productcategitemlist = By.xpath("//div[contains(@class,'imc-gallery imc-gallery--justify-left imc-gallery')]"); //Locator for Product Categories list
	By prodcatgtable = By.xpath("//div[@class='imc-gallery__item']"); //Locator for Product Categories table

	public ATLLineDigitalShowroomPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 
	public WebElement getaddNoteIcon() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(addNoteIcon));
		return driver.findElement(addNoteIcon);
	}
	public WebElement getatl1stListName() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atl1stListName));
		return driver.findElement(atl1stListName);
	}
	public WebElement getaddToListIcon() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(addToListIcon));
		return driver.findElement(addToListIcon);
	}
	public WebElement getfavIconDigiShowroom() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(favIconDigiShowroom));
		return driver.findElement(favIconDigiShowroom);
	}
	public WebElement getlocationLink() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locationLink));
		return driver.findElement(locationLink);
	}
	public WebElement getsuggetionList() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(suggetionList));
		return driver.findElement(suggetionList);
	}
	public WebElement getdigiShowroomExhName() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(digiShowroomExhName));
		return driver.findElement(digiShowroomExhName);
	}
	public WebElement getAtlLineDigiShowroomPageTitle() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlLineDigiShowroomPageTitle));
		return driver.findElement(atlLineDigiShowroomPageTitle);
	}
}
