package pageObjects.LasVegasMarket;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LVMLineDigitalShowroomPage {
	public WebDriver driver;
	public WebDriverWait wait;

	By lvmLineDigiShowroomPageTitle = By.xpath("//div[@class='imc-gallery imc-gallery--65-35 breadcrumbs__round']/div[1]/ul[1]/li[4]/a[1]"); // Locator Line Digi showroom page title
	By digiShowroomExhName = By.xpath("//div[@class='imc-section--full-width-mobile imc-content--display-flex imc-content--display-flex-grow-1']/div[1]/div[1]/div[2]/a[1]"); // Locator  Exhibitor name shown by Digital Showroom page
	By suggetionList = By.xpath("(//div[@ID='react-autowhatever-input-1']/ul/li)[1]"); // Locator Suggetion list 1st suggetion //Old xPath- //div[@ID='react-autowhatever-input-1']
	By locationLink = By.xpath("//div[@class='imc-section--full-width-mobile imc-content--display-flex imc-content--display-flex-grow-1']/div[1]/div[1]/div[3]/span[2]/a[1]"); //Locator for Location liks
	By favIconDigiShowroom = By.xpath("//div[@class='imc-section--full-width-mobile imc-content--display-flex imc-content--display-flex-grow-1']/div[1]/div[1]/div[4]/ul[1]/li[1]/div[1]/button[1]"); //Locator for Exhibitor name on Exhibitor Directory image
	By addToListIcon = By.xpath("//label[contains(text(),'List')]"); //Locator for Add to list
	By lvm1stListName = By.xpath("(//div[@class='imc-vr--xlarge'])[2]/div[1]/label[1]"); //Locator for 1st List name
	By addNoteIcon = By.xpath("(//button[contains(@class,'imc-addnote__openModal')])[1]"); //Locator for Add Note
	By orderOnJuniperBtn = By.xpath("//div[@class='imc-section imc-padding--left--xlarge imc-padding--right--xlarge imc-section--width-100-percent']/div[1]/div[2]/a[1]"); //Locator for Order on Juniper Btn
	By seeAllProductBtn = By.xpath("//div[@class='imc-section imc-padding--left--xlarge imc-padding--right--xlarge imc-section--width-100-percent']/div[1]/div[3]/a[1]/span[1]"); //Locator for See All Product Count Btn
	By productTitle = By.xpath("//div[@class='imc-section imc-section--width-100-percent']/div[1]/span[1]"); //Locator for Product  titele
	By productCount = By.xpath("//div[@class='imc-section imc-section--width-100-percent']/div[1]/span[2]"); //Locator for Product Count
	By productTitleAndCount = By.xpath("//div[@class='imc-section imc-section--width-100-percent']/div[1]/span[contains(text(),'Products Shown')]/../span[1]"); //Locator for Product  titele and count
	By listOfproductTile = By.xpath("//div[@class='imc-catalog__item_image-wrapper']"); //Locator for Lists of Product  tiles 
	By orderOnJuniperBtnLink = By.xpath("//div[@class='imc-products-overview--cta-bar__item']/a[1]"); //Locator for Order on Juniper Btn Bottom Link
	By prodctCountBottomBtn = By.xpath("//div[@class='imc-products-overview--cta-bar__item imc-padding--left--xlarge--desktop']/a[1]/span[1]"); //Locator for Product count Btn Bottom Link
	By seeAllprodctCountBottomBtn = By.xpath("//div[@class='imc-products-overview--cta-bar__item imc-padding--left--xlarge--desktop']/a[1]"); //Locator for Product count Btn Bottom Link
	By productName= By.xpath("//div[@class='imc-products-overview--gallery']/div[1]/div[1]/a[1]/div[1]/div[1]/span[1]/span[1]/span[1]"); //Locator for Product name
	By productHeader= By.xpath("//h2[@class='imc-padding--left--smallmedium imc-padding--bottom--small']"); //Locator for Product name
	By productName1= By.xpath("//div[@class='imc-products-overview--gallery']/div[1]/div[1]/a[1]/div[1]/div[1]/span[1]/span[1]"); //Locator for Product name
	By lvmLineDigiShowroomPageTitleUAT = By.xpath("//div[@class='imc-gallery imc-gallery--65-35 breadcrumbs__round']/div[1]/ul[1]/li[3]/a[1]"); // Locator Line Digi showroom page title
	By locationLinkuat = By.xpath("//a[@class='imc-link imc-type--title-6 imc-content--inline-block imc-vr--large']"); //Locator for Location liks
	By orderOnJuniperBtnNew = By.xpath("(//span[contains(text(),'Order on JuniperMarket')])[1]");
	By digiShowroomExhNameUat = By.xpath("//a[@class='imc-link imc-type--title-6-link imc-type--color-neutral-medium']"); // Locator  Exhibitor name shown by Digital Showroom page
	By favIconDigiShowroomUat = By.xpath("//button[@class='imc-selectableicon ']/label"); //Locator for Exhibitor name on Exhibitor Directory image
	By seeAllProductBtnUat = By.xpath("(//span[contains(text(),'See All')])[1]"); //Locator for See All Product Count Btn

	
	public LVMLineDigitalShowroomPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	}
	
	public WebElement getproductName1() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(productName1));
		return driver.findElement(productName1);
	}
	public WebElement getproductHeader() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(productHeader));
		return driver.findElement(productHeader);
	}
	public WebElement getproductName() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
		return driver.findElement(productName);
	}
	public WebElement getSeeAllprodctCountBottomBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(seeAllprodctCountBottomBtn));
		return driver.findElement(seeAllprodctCountBottomBtn);
	}
	public WebElement getprodctCountBottomBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(prodctCountBottomBtn));
		return driver.findElement(prodctCountBottomBtn);
	}
	public WebElement getorderOnJuniperBtnLink() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(orderOnJuniperBtnLink));
		return driver.findElement(orderOnJuniperBtnLink);
	}

	public List <WebElement> gelistOfproductTile() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(listOfproductTile));
		return driver.findElements(listOfproductTile);
	}
	public WebElement getproductTitleAndCount() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(productTitleAndCount));
		return driver.findElement(productTitleAndCount);
	}
	public WebElement getproductCount() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(productCount));
		return driver.findElement(productCount);
	}
	public WebElement getproductTitle() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));
		return driver.findElement(productTitle);
	}
	public WebElement getseeAllProductBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(seeAllProductBtn));
		return driver.findElement(seeAllProductBtn);
	}
	public WebElement getorderOnJuniperBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(orderOnJuniperBtn));
		return driver.findElement(orderOnJuniperBtn);
	}
	public WebElement getaddNoteIcon() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(addNoteIcon));
		return driver.findElement(addNoteIcon);
	}
	public WebElement getlvm1stListName() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvm1stListName));
		return driver.findElement(lvm1stListName);
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
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(suggetionList));
		return driver.findElement(suggetionList);
	}
	public WebElement getdigiShowroomExhName() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(digiShowroomExhName));
		return driver.findElement(digiShowroomExhName);
	}
	public WebElement getLVMLineDigiShowroomPageTitle() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmLineDigiShowroomPageTitle));
		return driver.findElement(lvmLineDigiShowroomPageTitle);
	}
	public WebElement getLVMLineDigiShowroomPageTitleUAT() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmLineDigiShowroomPageTitleUAT));
		return driver.findElement(lvmLineDigiShowroomPageTitleUAT);
	}
	public WebElement getlocationLinkUAT() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locationLinkuat));
		return driver.findElement(locationLinkuat);
	}
	public WebElement getorderOnJuniperBtnNew() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(orderOnJuniperBtnNew));
		return driver.findElement(orderOnJuniperBtnNew);
	}
	public WebElement getdigiShowroomExhNameUat() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(digiShowroomExhNameUat));
		return driver.findElement(digiShowroomExhNameUat);
	}
	public WebElement getfavIconDigiShowroomUat() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(favIconDigiShowroomUat));
		return driver.findElement(favIconDigiShowroomUat);
	}
	public WebElement getseeAllProductBtnUat() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(seeAllProductBtnUat));
		return driver.findElement(seeAllProductBtnUat);
	}
}
