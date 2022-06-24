package pageObjects.AtlantaMarket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLFloorPlansPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By atlExhibitorsAndProductTab = By.xpath("//div[@class='imc-section']/div[1]/div[2]/div[1]/a[1]"); // Locator for Exhibitor And Product tab 
	By atlFloorPlansLink = By.xpath("//div[@class='imc-section']/div[1]/div[2]/div[2]/div[1]/div[2]"); //Locator for floor plans Link
	By atlBuildingFloor = By.xpath("//div[@class='imc-campus-view']/div[3]/div[12]/div[3]/a[1]"); //Locator for Building floor
	By atlBuildingFloorNumber = By.xpath("//div[@class='imc-campus-view']/div[1]/div[23]/div[2]"); //Locator for Building floor number
	By atlFloorName = By.xpath("//div[@class='imc-type--title-6']");
	By atlnoexhibitorsmsg = By.xpath("//p[contains(text(),'No Exhibitors on This Floor')]"); //Locator for No exhibitor msg
	By atlloadingexhmsg = By.xpath("//p[contains(text(),'Loading Exhibitors Please Wait ...')]"); //Locator for Loading Exhibitors msg
	By atlNoExhibitorFloor = By.xpath("//a[contains(text(),'Buying Groups / Meeting Space')]"); //Locator for No Exhibitor
	By atlExhibitorFloorZoomIn = By.xpath("//div[@class='meridian-zoom-controls meridian--private--1qg3nfg']/button[1]"); //Locator for Zoom In Exhibitor
	By atlExhibitorFloorZoomOut = By.xpath("//div[@class='meridian-zoom-controls meridian--private--1qg3nfg']/button[2]"); //Locator for Zoom In Exhibitor
	By atlfloorplanmapimage = By.xpath("//div[@class='imc-map-container']/div[1]/div[1]/div[5]/div[1]"); //Locator for Zoom In out Attribute
	By atlSelectBox = By.xpath("//select[@class='imc-searchform--dropdown imc-floor-plan--dropdown']"); //Locator Selectbox
	By vendingmchineicononmap = By.xpath("//button[contains(@class, 'vending_machines')]"); //Locator for Vending Machine icon on Map image
	By vendingmachineoverlay = By.xpath("//div[contains(@style, 'vending_machines')]"); //Locator for Vending Machine overlay on Map
	By elevatoricononmap = By.xpath("(//button[contains(@class, 'elevator')])[position()=1]"); //Locator for elevator icon on Map image
	By elevatoroverlay = By.xpath("//div[contains(@style, 'elevator')]"); //Locator for elevator overlay on Map
	By waterfountainicononmap = By.xpath("(//button[contains(@class, 'water_fountain')])[position()=3]"); //Locator for Water Fountain icon on Map image
	By waterfountainoverlay = By.xpath("//div[contains(@style, 'water_fountain')]"); //Locator for Water Fountain overlay on Map
	By phoneicononmap = By.xpath("(//button[contains(@class, 'phone')])[position()=3]"); //Locator for Phone icon on Map image
	By phoneoverlay = By.xpath("//div[contains(@style, 'phone')]"); //Locator for Phone overlay on Map
	//By locationpinicononmap = By.xpath("(//div[@class='meridian-label meridian--private--nfhgl4-placemark-label'])[position()=10]"); //Locator for Location pin of any Exhibitor on Map
	By locationpinicononmap = By.xpath("(//button[contains(@class, 'generic')])[position()=9]");
	By exhibitordetailsmodal = By.xpath("//div[@class='imc-content--padded-medium-desktop']"); //Locator for Exhibitor Details Modal
	By exhnameonexhdetailsmodal = By.xpath("//div[@class='imc-content--padded-medium-desktop']/div/div/h5"); //Locator for Exhibitor name on Exh Details Modal
	By overlayclosebtn = By.xpath("//button[@data-testid='meridian--private--close-overlay']"); //Locator for Overlay close btn
	
	public ATLFloorPlansPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 
	public WebElement getATLExhibitorsAndProductTab(){
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlExhibitorsAndProductTab));
		return driver.findElement(atlExhibitorsAndProductTab);
	}

	public WebElement getATLFloorPlansLink() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlFloorPlansLink));
		return driver.findElement(atlFloorPlansLink);
	}
	public WebElement getATLBuildingFloor() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlBuildingFloor));
		return driver.findElement(atlBuildingFloor);
	}
	public WebElement getATLBuildingFloorNumber() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlBuildingFloorNumber));
		return driver.findElement(atlBuildingFloorNumber);
	}
	public WebElement getATLFloorName() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlFloorName));
		return driver.findElement(atlFloorName);
	}
	public WebElement getATLNoExpMsg() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlnoexhibitorsmsg));
		return driver.findElement(atlnoexhibitorsmsg);
	}
	public WebElement getATLNoExhibitorFloor() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlNoExhibitorFloor));
		return driver.findElement(atlNoExhibitorFloor);
	}
	
	public WebElement getATLExhibitorFloorZoomIn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlExhibitorFloorZoomIn));
		return driver.findElement(atlExhibitorFloorZoomIn);
	}
	public WebElement getATLExhibitorFloorZoomOut() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlExhibitorFloorZoomOut));
		return driver.findElement(atlExhibitorFloorZoomOut);
	}
	public WebElement getATLFloorPlanMapIamge() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlfloorplanmapimage));
		return driver.findElement(atlfloorplanmapimage);
	}

	public WebElement getATLSelectBox() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlSelectBox));
		return driver.findElement(atlSelectBox);
	}
	
	public WebElement getATLLoadingExhMsg() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlloadingexhmsg));
		return driver.findElement(atlloadingexhmsg);
	}
	public WebElement getVendingMachineIconOnMap() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(vendingmchineicononmap));
		return driver.findElement(vendingmchineicononmap);
	}
	public WebElement getVendingMachineOverlayOnMap() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(vendingmachineoverlay));
		return driver.findElement(vendingmachineoverlay);
	}
	public WebElement getElevatorIconOnMap() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(elevatoricononmap));
		return driver.findElement(elevatoricononmap);
	}
	public WebElement getElevatorOverlayOnMap() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(elevatoroverlay));
		return driver.findElement(elevatoroverlay);
	}
	public WebElement getWaterFountainIconOnMap() throws InterruptedException {
		//Thread.sleep(4000);
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(waterfountainicononmap));
		return driver.findElement(waterfountainicononmap);
	}
	public WebElement getWaterFountainOverlayOnMap() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(waterfountainoverlay));
		return driver.findElement(waterfountainoverlay);
	}
	public WebElement getPhoneIconOnMap() throws InterruptedException{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(phoneicononmap));
		return driver.findElement(phoneicononmap);
	}
	public WebElement getPhoneOverlayOnMap() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(phoneoverlay));
		return driver.findElement(phoneoverlay);
	}
	public WebElement getLocationPinIconOnMap() throws InterruptedException{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(locationpinicononmap));
		return driver.findElement(locationpinicononmap);
	}
	public WebElement getExhibitorDetailsModal() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitordetailsmodal));
		return driver.findElement(exhibitordetailsmodal);
	}
	public WebElement getExhNameOnExhibitorDetailsModal() {
		return driver.findElement(exhnameonexhdetailsmodal);
	}
	public WebElement getOverlayCloseBtn() {
		return driver.findElement(overlayclosebtn);
	}
}



