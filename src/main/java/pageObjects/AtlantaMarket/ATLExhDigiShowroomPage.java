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
	
	public ATLExhDigiShowroomPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
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
}



