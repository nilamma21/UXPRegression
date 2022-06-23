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
	//By atlBuildingFloor = By.xpath("//div[@class='imc-campus-view']/div[3]/div[12]/div[3]/a[1]"); //Locator for Building floor
	//By atlBuildingFloor = By.xpath("//div[@class='imc-campus-view']/div[1]/div[23]/div[3]/a[1]"); //Locator for Building floor
	By atlBuildingFloor = By.xpath("//div[@class='imc-campus-view']/div[3]/div[11]/div[3]/a[1]"); //Locator for Building floor
	By atlBuildingFloorNumber = By.xpath("//div[@class='imc-campus-view']/div[1]/div[23]/div[2]"); //Locator for Building floor number
	//By atlFloorName = By.xpath("//div[@class='imc-floor-plan']/div[1]/div[1]/span[1]/div[2]"); //Locator for floor name
	By atlFloorName = By.xpath("//div[@class='imc-type--title-6']");
	By atlNoExpMsg = By.xpath("(//div[@class='section-wrapper imc-section--'])[1]/section[1]/div[1]/div[1]/div[1]/div[3]/p[2]"); //Locator for No exhibitor msg
	By atlLoadingExhMsg = By.xpath("(//div[@class='section-wrapper imc-section--'])[1]/section[1]/div[1]/div[1]/div[1]/div[3]/p[]"); //Locator for Exhibitor loading msg
	By atlNoExhibitorFloor = By.xpath("//div[@class='imc-campus-view']/div[1]/div[18]/div[3]/a[1]"); //Locator for No Exhibitor
	By atlExhibitorFloorZoomIn = By.xpath("//div[@class='meridian-zoom-controls meridian--private--1qg3nfg']/button[1]"); //Locator for Zoom In Exhibitor
	By atlExhibitorFloorZoomOut = By.xpath("//div[@class='meridian-zoom-controls meridian--private--1qg3nfg']/button[2]"); //Locator for Zoom In Exhibitor
	By atlZoomInOutAttribute = By.xpath("//div[@class='imc-map-container']/div[1]/div[1]/div[5]/div[1]"); //Locator for Zoom In out Attribute
	By atlIcon = By.xpath("//div[@class='imc-map-container']/div[1]/div[1]/div[5]/div[1]/div[1]/div[19]"); //Locator for Icon
	By atlIconText = By.xpath("//div[@class='imc-map-container']/div[1]/div[1]/div[5]/div[1]/div[1]/div[19]/div[1]"); //Locator for Icon text
	By atlIconPopupText = By.xpath("//div[@class='imc-map-container']/div[1]/div[1]/div[3]/div[2]/p[1]"); //Locator for Icon popup Text
	By atlSelectBox = By.xpath("//select[@class='imc-searchform--dropdown imc-floor-plan--dropdown']"); //Locator Selectbox
	By atlNextFloorBtn = By.xpath("//div[@class='imc-floor-plan--floorButtons']/a[2]"); //Locator for previous Floor button
	By atlPreviousFloorBtn = By.xpath("//div[@class='imc-floor-plan--floorButtons']/a[1]"); //Locator for Next Floor button
	By atlExpectedFloorNumber = By.xpath("//div[@class='imc-content--omni']"); //Locator for expected Floor number
	
	
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlNoExpMsg));
		return driver.findElement(atlNoExpMsg);
	}
	public WebElement getATLLoadingExhMsg() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlLoadingExhMsg));
		return driver.findElement(atlLoadingExhMsg);
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
	public WebElement getATLZoomInOutAttribute() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlZoomInOutAttribute));
		return driver.findElement(atlZoomInOutAttribute);
	}
	public WebElement getATLIcon() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlIcon));
		return driver.findElement(atlIcon);
	}
	public WebElement getATLIconText() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlIconText));
		return driver.findElement(atlIconText);
	}
	public WebElement getATLIconPopupText() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlIconPopupText));
		return driver.findElement(atlIconPopupText);
	}
	public WebElement getATLSelectBox() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlSelectBox));
		return driver.findElement(atlSelectBox);
	}
	public WebElement getATLNextFloorBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlNextFloorBtn));
		return driver.findElement(atlNextFloorBtn);
	}
	public WebElement getATLPreviousFloorBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlPreviousFloorBtn));
		return driver.findElement(atlPreviousFloorBtn);
	}
	public WebElement getATLExpectedFloorNumber() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlExpectedFloorNumber));
		return driver.findElement(atlExpectedFloorNumber);
	}
}



