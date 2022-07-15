package pageObjects.AtlantaMarket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLExhDigiShowroomPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By atlvalidateexhdigishowpage = By.xpath("//img[@class='imc-image--responsive align-image-content imc-content--full-width imc-exhibitors--directory-image']"); // Locator to validate Exhibitor Digital Showroom page
	By exhibitornameonexhdirectimg = By.xpath("//span[@class='imc-heading imc-heading--giga-desktop ']"); //Locator for Exhibitor name on Exhibitor Directory image
	By exhdigishowroompage = By.xpath("//div[@class='imc-section--full-width-mobile imc-content--display-flex imc-content--display-flex-grow-1 imc-section--divided-bottom']"); //Locator for Exhibitor Digital Showroom page
	By exhnameonexhdirectimg = By.xpath("//span[@class='imc-heading imc-heading--giga-desktop imc-vr--medium imc-content--inline-block']"); //Locator for Exhibitor name on Exhibitor Directory image
	
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
}



