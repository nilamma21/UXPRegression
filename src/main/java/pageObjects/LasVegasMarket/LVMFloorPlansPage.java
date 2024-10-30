package pageObjects.LasVegasMarket;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LVMFloorPlansPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By lvmExhibitorsAndProductTab = By.xpath("//a[contains(text(),'Exhibitors & Products')]"); // Locator for Exhibitor And Product tab 
	By lvmFloorPlansLink = By.xpath("//a[contains(text(),'Floor Plans')]"); //Locator for floor plans Link
	By lvmBuildingFloor = By.xpath("(//a[@href='/Market Map/building/Building B/floor/3'])[2]"); //Locator for Building floor
	By buildingFloor_lvmUAT = By.xpath("//div[@class='imc-campus-view']/div[3]/div[10]/div[3]/a[1]"); //Locator for Building floor 9th LVM UAT
	By lvmBuildingFloorForFilter = By.xpath("//div[@class='imc-campus-view']/div[3]/div[4]/div[3]/a"); //Locator for Building floor
	By lvmBuildingFloorNumber = By.xpath("//div[@class='imc-campus-view']/div[3]/div[10]/div[3]/a"); //Locator for Building floor number
	By lvmFloorName = By.xpath("(//div[@class='imc-type--title-6 imc-section--padded-top-large'])[1]"); //Floor plan name Text
	By lvmNoExpMsg = By.xpath("//div[@class='imc-manufacturing-line--alternated-section imc-lines-overview']/p[2]"); //Locator for No exhibitor msg
	By lvmLoadingExhMsg = By.xpath("(//div[@class='section-wrapper imc-section--'])[1]/section[1]/div[1]/div[1]/div[1]/div[3]/p[]"); //Locator for Exhibitor loading msg
	By lvmNoExhibitorFloor = By.xpath("//div[@class='imc-campus-view']/div[1]/div[18]/div[3]/a[1]"); //Locator for No Exhibitor
	By lvmNoExhibitorFloor_uat = By.xpath("//div[@class='imc-campus-view']/div[2]/div[3]/div[2]/a[1]"); //Locator for No Exhibitor
	By lvmnoexhibitorsmsg = By.xpath("//p[contains(text(),'No Exhibitors on This Floor')]"); //Locator for No exhibitor msg
	By lvmloadingexhmsg = By.xpath("//p[contains(text(),'Loading Exhibitors Please Wait ...')]"); //Locator for Loading Exhibitors msg
	By lvmExhibitorFloorZoomIn = By.xpath("//div[@class='meridian-zoom-controls meridian--private--1qg3nfg']/button[1]"); //Locator for Zoom In Exhibitor
	By lvmExhibitorFloorZoomOut = By.xpath("//div[@class='meridian-zoom-controls meridian--private--1qg3nfg']/button[2]"); //Locator for Zoom In Exhibitor
	By lvmfloorplanmapimage = By.xpath("//div[@class='imc-map-container']/div[1]/div[1]/div[5]/div[1]"); //Locator for Zoom In out Attribute
	By lvmSelectBox = By.xpath("//select[@class='imc-searchform--dropdown imc-floor-plan--dropdown']"); //Locator Selectbox
	By vendingmchineicononmap = By.xpath("//button[contains(@class, 'vending_machines')]"); //Locator for Vending Machine icon on Map image
	By lvmflooricononmap_uat = By.xpath("//div[@class = 'imc-map-container']/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]"); //Locator for Vending Machine icon on Map image
	By lvmflooricononmap_lvmUAT = By.xpath("(//button[@class='meridian-placemark-icon meridian-placemark-type-restroom_women meridian--private--ysqo7o-placemark-icon'])[1]"); //Locator for Vending Machine icon on Map image
	By lvmflooriconoverlay_lvmUAT = By.xpath("//div[@class='meridian--private--1llxh0s-overlay-image']"); //Locator for icon overlay on map
	By vendingmachineoverlay = By.xpath("//div[contains(@style, 'vending_machines')]"); //Locator for floor overlay on Map
	By elevatoricononmap = By.xpath("(//button[contains(@class, 'elevator')])[position()=1]"); //Locator for elevator icon on Map image
	By elevatoroverlay = By.xpath("//div[contains(@style, 'elevator')]"); //Locator for elevator overlay on Map
	By waterfountainicononmap = By.xpath("(//button[contains(@class, 'water_fountain')])[position()=3]"); //Locator for Water Fountain icon on Map image
	By waterfountainoverlay = By.xpath("//div[contains(@style, 'water_fountain')]"); //Locator for Water Fountain overlay on Map
	By phoneicononmap = By.xpath("(//button[contains(@class, 'phone')])[position()=2]"); //Locator for Phone icon on Map image
	By phoneoverlay = By.xpath("//div[contains(@style, 'phone')]"); //Locator for Phone overlay on Map
	By locationpinicononmap = By.xpath("//div[contains(@class,'imc-floor-plan')]//div[25]/button"); //Locator for location pin on map
	By exhibitordetailsmodal = By.xpath("//div[@class='imc-content--padded-medium-desktop']"); //Locator for Exhibitor Details Modal
	By exhnameonexhdetailsmodal = By.xpath("//div[@class='imc-content--padded-medium-desktop']/div/div/h5"); //Locator for Exhibitor name on Exh Details Modal
	By overlayclosebtn = By.xpath("//button[@data-testid='meridian--private--close-overlay']"); //Locator for Overlay close btn
	By lvmNextFloorBtn = By.xpath("//div[@class='imc-floor-plan--floorButtons imc-section--padded-left-medium imc-section--padded-medium imc-section--padded-right-medium']/a[2]"); //Locator for previous Floor button
	By lvmPreviousFloorBtn = By.xpath("//div[@class='imc-floor-plan--floorButtons imc-section--padded-left-medium imc-section--padded-medium imc-section--padded-right-medium']/a[1]"); //Locator for Next Floor button
	By lvmExpectedFloorNumber = By.xpath("//span[@class='imc-floor-plan-name']/h1"); //Locator for expected Floor number
	By lvmExhibitorName = By.xpath("(//div[@class='imc-manufacturing-line-title-wrapper']/a)[1]"); //Locator for Exhibitor Name
	By lvmExhibitorNameOnDGShowroomPage = By.xpath("//div[@class='imc-gallery imc-gallery--65-35 breadcrumbs__round']/div[1]/ul[1]/li[3]/a[1]"); //Locator for Exhibitor Name on DG showroom Page 
	By lvmReturnToBuildingList = By.xpath("//div[@class='imc-floor-plan']/div[1]/div[1]/a[1]"); //Locator for Return to Building list link
	By scrollexhibitorsection = By.xpath("//span[text()='Exhibitors on This Floor']"); //Locator for scroll to exhibitor section
	By lvmexhibitorsection = By.xpath("//div[@class = 'imc-content--padded-top-bottom']/div[1]"); //locator for exhibitor section at floor plans
	By lvmexhibitorsearch = By.xpath("//input[@placeholder = 'Filter By Name']"); //Locator for search input box
	By lvmserachexhibitorbtn = By.xpath("(//button[@class='imc-searchform--button--search' and @type='submit'])[2]"); //Locator for Search button for search input field
	By lvmserachexhibitorbtnPROD = By.xpath("(//div[@class='imc-searchform--button--search'])[2]"); //Locator for Search button for search input field
	
	By verifyexhibitor = By.xpath("//div[@class = 'imc-manufacturing-line']/div[2]/a[1]"); //Locator for verification for searched exhibitor
	By viewdgshowroombtn = By.xpath("//a[contains(text(),'View Digital Showroom')]"); //Locator for View Digital Showroom button
	By lvmMoreOptions = By.xpath("//div[@class='imc-content--padded-top-bottom']/div[1]/div[1]/div[3]/div[1]"); //Locator for More Options 3dots
	By lvmAddToList = By.xpath("//div[@id='popup-root']/div[2]/div[2]/div[1]/label"); //Locator for Add to List
	By lvmAddNote = By.xpath("//div[@id='popup-root']/div[2]/div[2]/div[2]/div[1]/button[1]/label[1]"); //Locator for Add Note
	By lvmAddFev = By.xpath("//div[@class='imc-content--padded-top-bottom']/div[1]/div[1]/div[3]/div[2]/div[1]/button[1]"); //Locator for Add Fev
	By lvmExhSearchField = By.xpath("(//div[@class='imc-searchform--row'])[2]/form[1]/div[1]/input[1]"); //Locator for Exh Search filed
	By lvmExhSearchFieldBtn = By.xpath("(//div[@class='imc-searchform--row'])[2]/form[1]/button[2]"); //Locator for Exh Search filed Btn
	By noresultsforjuniperlinesmsg = By.xpath("//p[contains(text(),'Sorry, no results found.')]"); //Locator for No results found msg for Lines on Junipermarket filter
	By exhibitedonfloormsg = By.xpath("//span[contains(text(),'Exhibitors on This Floor')]");
	By lvmBuildingFloorsix = By.xpath("//div[@class='imc-campus-view']/div[3]/div[13]/div[3]/a[1]"); //Locator for Building floor

	
	public LVMFloorPlansPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	}
	public WebElement getlvmserachexhibitorbtnPROD() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmserachexhibitorbtnPROD));
		return driver.findElement(lvmserachexhibitorbtnPROD);
	}
	
	public WebElement getLVMExhibitorsAndProductTab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmExhibitorsAndProductTab));
		return driver.findElement(lvmExhibitorsAndProductTab);
	}

	public WebElement getLVMFloorPlansLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmFloorPlansLink));
		return driver.findElement(lvmFloorPlansLink);
	}
	public WebElement getLVMBuildingFloor() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmBuildingFloor));
		return driver.findElement(lvmBuildingFloor);
	}
	public WebElement getLVMBuildingFloorNumber() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmBuildingFloorNumber));
		return driver.findElement(lvmBuildingFloorNumber);
	}
	public WebElement getLVMFloorName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmFloorName));
		return driver.findElement(lvmFloorName);
	}
	public WebElement getLVMNoExpMsg() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmnoexhibitorsmsg));
		return driver.findElement(lvmnoexhibitorsmsg);
	}
	public WebElement getLVMNoExhibitorFloor() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmNoExhibitorFloor));
		return driver.findElement(lvmNoExhibitorFloor);
	}

	public WebElement getLVMExhibitorFloorZoomIn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmExhibitorFloorZoomIn));
		return driver.findElement(lvmExhibitorFloorZoomIn);
	}
	public WebElement getLVMExhibitorFloorZoomOut() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmExhibitorFloorZoomOut));
		return driver.findElement(lvmExhibitorFloorZoomOut);
	}
	public WebElement getLVMFloorPlanMapIamge() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmfloorplanmapimage));
		return driver.findElement(lvmfloorplanmapimage);
	}

	public WebElement getLVMSelectBox() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitedonfloormsg));
		return driver.findElement(lvmSelectBox);
	}

	public WebElement getLVMLoadingExhMsg() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmloadingexhmsg));
		return driver.findElement(lvmloadingexhmsg);
	}
	public WebElement getVendingMachineIconOnMap() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(vendingmchineicononmap));
		return driver.findElement(vendingmchineicononmap);
	}
	public WebElement getVendingMachineOverlayOnMap() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(vendingmachineoverlay));
		return driver.findElement(vendingmachineoverlay);
	}
	public WebElement getElevatorIconOnMap() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(elevatoricononmap));
		return driver.findElement(elevatoricononmap);
	}
	public WebElement getElevatorOverlayOnMap() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(elevatoroverlay));
		return driver.findElement(elevatoroverlay);
	}
	public WebElement getWaterFountainIconOnMap() throws InterruptedException {
		//Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(waterfountainicononmap));
		return driver.findElement(waterfountainicononmap);
	}
	public WebElement getWaterFountainOverlayOnMap() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(waterfountainoverlay));
		return driver.findElement(waterfountainoverlay);
	}
	public WebElement getPhoneIconOnMap() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(phoneicononmap));
		return driver.findElement(phoneicononmap);
	}
	public WebElement getPhoneOverlayOnMap() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(phoneoverlay));
		return driver.findElement(phoneoverlay);
	}
	public WebElement getLocationPinIconOnMap() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(locationpinicononmap));
		return driver.findElement(locationpinicononmap);
	}
	public WebElement getExhibitorDetailsModal() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitordetailsmodal));
		return driver.findElement(exhibitordetailsmodal);
	}
	public WebElement getExhNameOnExhibitorDetailsModal() {
		return driver.findElement(exhnameonexhdetailsmodal);
	}
	public WebElement getOverlayCloseBtn() {
		return driver.findElement(overlayclosebtn);
	}


	public WebElement getLVMNextFloorBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmNextFloorBtn));
		return driver.findElement(lvmNextFloorBtn);
	}
	public WebElement getLVMPreviousFloorBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmPreviousFloorBtn));
		return driver.findElement(lvmPreviousFloorBtn);
	}
	public WebElement getLVMExpectedFloorNumber() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmExpectedFloorNumber));
		return driver.findElement(lvmExpectedFloorNumber);
	}

	public WebElement getLVMExhibitorName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmExhibitorName));
		return driver.findElement(lvmExhibitorName);
	}
	public WebElement getLVMExhibitorNameOnDGShowroomPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmExhibitorNameOnDGShowroomPage));
		return driver.findElement(lvmExhibitorNameOnDGShowroomPage);
	}
	public WebElement getLVMReturnToBuildingList() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmReturnToBuildingList));
		return driver.findElement(lvmReturnToBuildingList);
	}
	public WebElement getlvmexhibitorsection() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElement(lvmexhibitorsection);
	}
	public WebElement getlvmexhibitorsearch() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitedonfloormsg));
		return driver.findElement(lvmexhibitorsearch);
	}
	public WebElement getlvmserachexhibitorbtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmserachexhibitorbtn));
		return driver.findElement(lvmserachexhibitorbtn);
	}
	public WebElement getverifyexhibitor() throws InterruptedException {
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(verifyexhibitor));
		return driver.findElement(verifyexhibitor);
	}
	public WebElement getscrollexhibitorsection() throws InterruptedException {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(scrollexhibitorsection));
		return driver.findElement(scrollexhibitorsection);
	}
	public WebElement getViewDGShowroombtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(viewdgshowroombtn));
		return driver.findElement(viewdgshowroombtn);
	}
	public WebElement getLVMMoreOptions() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmMoreOptions));
		return driver.findElement(lvmMoreOptions);
	}
	public WebElement getLVMAddToList() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lvmAddToList));
		return driver.findElement(lvmAddToList);
	}
	public WebElement getLVMAddNote() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmAddNote));
		return driver.findElement(lvmAddNote);
	}
	public WebElement getLVMBuildingFloorForFilter() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmBuildingFloorForFilter));
		return driver.findElement(lvmBuildingFloorForFilter);
	}

	public WebElement getLVMAddFev() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmAddFev));
		return driver.findElement(lvmAddFev);
	}
	public WebElement getLVMExhSearchField() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmExhSearchField));
		return driver.findElement(lvmExhSearchField);
	}
	public WebElement getLVMExhSearchFieldBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmExhSearchFieldBtn));
		return driver.findElement(lvmExhSearchFieldBtn);
	}
	public WebElement getNoResultsMsgForLinesOnJuniper() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(noresultsforjuniperlinesmsg));
		return driver.findElement(noresultsforjuniperlinesmsg);
	}
	public WebElement getlvmNoExhibitorFloor_uat() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmNoExhibitorFloor_uat));
		return driver.findElement(lvmNoExhibitorFloor_uat);
	}
	public WebElement getlvmflooricononmap_uat() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmflooricononmap_uat));
		return driver.findElement(lvmflooricononmap_uat);
	}
	public WebElement getbuildingFloor_lvmUAT() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(buildingFloor_lvmUAT));
		return driver.findElement(buildingFloor_lvmUAT);
	}
	public WebElement getlvmflooricononmap_lvmUAT() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmflooricononmap_lvmUAT));
		return driver.findElement(lvmflooricononmap_lvmUAT);
	}
	public WebElement getlvmflooriconoverlay_lvmUAT() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmflooriconoverlay_lvmUAT));
		return driver.findElement(lvmflooriconoverlay_lvmUAT);
	}
	public WebElement getExhibitedOnFloorMsg() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitedonfloormsg));
		return driver.findElement(exhibitedonfloormsg);
	}
	public WebElement getLVMBuildingFloorsix() {
	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	     wait.until(ExpectedConditions.elementToBeClickable(lvmBuildingFloorsix));
	     return driver.findElement(lvmBuildingFloorsix);
	 }
	
}



