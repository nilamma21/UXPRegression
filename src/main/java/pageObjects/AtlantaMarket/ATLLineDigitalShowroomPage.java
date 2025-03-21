package pageObjects.AtlantaMarket;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ATLLineDigitalShowroomPage {
	public WebDriver driver;
	public WebDriverWait wait;

	By atlLineDigiShowroomPageTitle = By.xpath("//div[@class='imc-gallery imc-gallery--65-35 breadcrumbs__round']/div[1]/ul[1]/li[4]/a[1]"); // Locator Line Digi showroom page title
	By digiShowroomExhName = By.xpath("//div[@class='imc-content imc-type--title-6 imc-type--color-neutral-heavy-medium imc-vr--small ']/a"); // Locator  Exhibitor name shown by Digital Showroom page
	By suggetionList = By.xpath("//div[@ID='react-autowhatever-input-1']"); // Locator Suggetion list 1st suggetion
	By locationLink = By.xpath("(//span[@class='imc-content--pipe']/a)[1]"); //Locator for Location liks
	By favIconDigiShowroom = By.xpath("//div[@class='imc-section--full-width-mobile imc-content--display-flex imc-content--display-flex-grow-1']/div[1]/div[1]/div[4]/ul[1]/li[1]/div[1]/button[1]"); //Locator for Exhibitor name on Exhibitor Directory image
	By addToListIcon = By.xpath("//div[@class='imc-section--full-width-mobile imc-content--display-flex imc-content--display-flex-grow-1']/div[1]/div[1]/div[4]/ul[1]/li[2]/button[1]"); //Locator for Add to list
	By atl1stListName = By.xpath("(//div[@class='imc-vr--xlarge'])[2]/div[1]/label[1]"); //Locator for 1st List name
	By addNoteIcon = By.xpath("//div[@class='imc-section--full-width-mobile imc-content--display-flex imc-content--display-flex-grow-1']/div[1]/div[1]/div[4]/ul[1]/li[3]/div[1]/div[1]/div[1]/button[1]"); //Locator for Add Note
	By orderOnJuniperBtn = By.xpath("//div[@class='imc-section imc-padding--left--xlarge imc-padding--right--xlarge imc-section--width-100-percent']/div[1]/div[2]/a[1]"); //Locator for Order on Juniper Btn
	By seeAllProductBtn = By.xpath("(//span[contains(text(),'See All')])[1]"); //Locator for See All Product Count Btn
	By productTitle = By.xpath("//div[@class='imc-section imc-section--width-100-percent']/div[1]/span[1]"); //Locator for Product  titele
	By productCount = By.xpath("//div[@class='imc-section imc-section--width-100-percent']/div[1]/span[2]"); //Locator for Product Count
	By productTitleAndCount = By.xpath("//div[@class='imc-section imc-section--width-100-percent']/div[1]/span[contains(text(),'Products Shown')]/../span[1]"); //Locator for Product  titele and count
	By listOfproductTile = By.xpath("//div[@class='imc-catalog__item_image-wrapper']"); //Locator for Lists of Product  tiles 
	By orderOnJuniperBtnLink = By.xpath("//div[@class='imc-products-overview--cta-bar__item']/a[1]"); //Locator for Order on Juniper Btn Bottom Link
	By prodctCountBottomBtn = By.xpath("//div[@class='imc-products-overview--cta-bar__item imc-padding--left--xlarge--desktop']/a[1]/span[1]"); //Locator for Product count Btn Bottom Link
	By seeAllprodctCountBottomBtn = By.xpath("//div[@class='imc-products-overview--cta-bar__item imc-padding--left--xlarge--desktop']/a[1]"); //Locator for Product count Btn Bottom Link
	By productName= By.xpath("//div[@class='imc-products-overview--gallery']/div[1]/div[1]/a[1]/div[1]/div[1]/span[1]/span[1]/span[1]"); //Locator for Product name
	By productHeader= By.xpath("//h2[@class='imc-padding--left--smallmedium imc-padding--bottom--small']"); //Locator for Product name
	By productName1= By.xpath("//div[@class='imc-products-overview--gallery']/div[1]/div[1]/a[1]/div[1]/div[1]"); //Locator for Product name
	By suggetionListUAT = By.xpath("(//div[@ID='react-autowhatever-input-1']/ul/li)[1]");
	By digiShowroomExhName1 = By.xpath("//section[@class='imc-site-wrapper']//descendant::span[@class='imc-heading imc-heading--giga-desktop imc-vr--medium imc-content--inline-block']"); // Locator  Exhibitor name shown by Digital Showroom page
	By digiShowroomExhNameUAT = By.xpath("//div[@class='imc-gallery imc-gallery--25-75 imc-gallery--align-flex-start-desktop']/div[2]/div[1]/a"); // Locator  Exhibitor name shown by Digital Showroom page
	
	public ATLLineDigitalShowroomPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	}
	public WebElement getdigiShowroomExhNameUAT() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(digiShowroomExhNameUAT));
		return driver.findElement(digiShowroomExhNameUAT);
	}

	public WebElement getproductName1() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(productName1));
		return driver.findElement(productName1);
	}
	public WebElement getproductHeader() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(productHeader));
		return driver.findElement(productHeader);
	}
	public WebElement getproductName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
		return driver.findElement(productName);
	}
	public WebElement getSeeAllprodctCountBottomBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(seeAllprodctCountBottomBtn));
		return driver.findElement(seeAllprodctCountBottomBtn);
	}
	public WebElement getprodctCountBottomBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(prodctCountBottomBtn));
		return driver.findElement(prodctCountBottomBtn);
	}
	public WebElement getorderOnJuniperBtnLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(orderOnJuniperBtnLink));
		return driver.findElement(orderOnJuniperBtnLink);
	}
	public List <WebElement> gelistOfproductTile() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(listOfproductTile));
		return driver.findElements(listOfproductTile);
	}
	public WebElement getproductTitleAndCount() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(productTitleAndCount));
		return driver.findElement(productTitleAndCount);
	}
	public WebElement getproductCount() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(productCount));
		return driver.findElement(productCount);
	}
	public WebElement getproductTitle() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));
		return driver.findElement(productTitle);
	}
	public WebElement getseeAllProductBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(seeAllProductBtn));
		return driver.findElement(seeAllProductBtn);
	}
	public WebElement getorderOnJuniperBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(orderOnJuniperBtn));
		return driver.findElement(orderOnJuniperBtn);
	}
	public WebElement getaddNoteIcon() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(addNoteIcon));
		return driver.findElement(addNoteIcon);
	}
	public WebElement getatl1stListName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atl1stListName));
		return driver.findElement(atl1stListName);
	}
	public WebElement getaddToListIcon() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(addToListIcon));
		return driver.findElement(addToListIcon);
	}
	public WebElement getfavIconDigiShowroom() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(favIconDigiShowroom));
		return driver.findElement(favIconDigiShowroom);
	}
	public WebElement getlocationLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locationLink));
		return driver.findElement(locationLink);
	}
	public WebElement getsuggetionList() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(suggetionList));
		return driver.findElement(suggetionList);
	}
	public WebElement getdigiShowroomExhName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(digiShowroomExhName));
		return driver.findElement(digiShowroomExhName);
	}
	public WebElement getAtlLineDigiShowroomPageTitle() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlLineDigiShowroomPageTitle));
		return driver.findElement(atlLineDigiShowroomPageTitle);
	}
    public WebElement getsuggetionListUAT() {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      wait.until(ExpectedConditions.visibilityOfElementLocated(suggetionListUAT));
      return driver.findElement(suggetionListUAT);
  }
	public WebElement getdigiShowroomExhName1() {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      wait.until(ExpectedConditions.visibilityOfElementLocated(digiShowroomExhName1));
      return driver.findElement(digiShowroomExhName1);
	}
}
