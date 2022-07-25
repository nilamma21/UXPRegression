package pageObjects.LasVegasMarket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LVMFloorPlansPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By buildingFloor_lvmUAT = By.xpath("//div[@class='imc-campus-view']/div[3]/div[10]/div[3]/a[1]"); //Locator for Building floor 9th LVM UAT
	By lvmNoExhibitorFloor_uat = By.xpath("//div[@class='imc-campus-view']/div[2]/div[3]/div[2]/a[1]"); //Locator for No Exhibitor
	By lvmflooricononmap_uat = By.xpath("//div[@class = 'imc-map-container']/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]"); //Locator for Vending Machine icon on Map image
	By lvmflooricononmap_lvmUAT = By.xpath("(//button[@class='meridian-placemark-icon meridian-placemark-type-restroom_women meridian--private--ysqo7o-placemark-icon'])[1]"); //Locator for Vending Machine icon on Map image
	By lvmflooriconoverlay_lvmUAT = By.xpath("//div[@class='meridian--private--1llxh0s-overlay-image']"); //Locator for icon overlay on map
	
	public LVMFloorPlansPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 
	
	public WebElement getlvmNoExhibitorFloor_uat() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmNoExhibitorFloor_uat));
		return driver.findElement(lvmNoExhibitorFloor_uat);
	}
	public WebElement getlvmflooricononmap_uat() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmflooricononmap_uat));
		return driver.findElement(lvmflooricononmap_uat);
	}
	public WebElement getbuildingFloor_lvmUAT() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(buildingFloor_lvmUAT));
		return driver.findElement(buildingFloor_lvmUAT);
	}
	public WebElement getlvmflooricononmap_lvmUAT() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmflooricononmap_lvmUAT));
		return driver.findElement(lvmflooricononmap_lvmUAT);
	}
	public WebElement getlvmflooriconoverlay_lvmUAT() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmflooriconoverlay_lvmUAT));
		return driver.findElement(lvmflooriconoverlay_lvmUAT);
	}
	
	
}



