package pageObjects.AtlantaMarket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLFloorPlansPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By atlExhibitorsAndProductTab = By.xpath("//a[contains(text(),'Exhibitors & Products')]"); // Locator for Exhibitor And Product tab 
	By atlFloorPlansLink = By.xpath("//a[contains(text(),'Floor Plans')]"); //Locator for floor plans Link
	By atlBuildingFloor = By.xpath("//div[@class='imc-campus-view']/div[3]/div[11]/div[3]/a[1]"); //Locator for Building floor
	By buildingFloor_lvmUAT = By.xpath("//div[@class='imc-campus-view']/div[3]/div[10]/div[3]/a[1]"); //Locator for Building floor 9th LVM UAT
	
	By atlBuildingFloorForFilter = By.xpath("//div[@class='imc-campus-view']/div[3]/div[4]/div[3]/a"); //Locator for Building floor
	By atlBuildingFloorNumber = By.xpath("//div[@class='imc-campus-view']/div[3]/div[10]/div[3]/a"); //Locator for Building floor number
	By atlFloorName = By.xpath("//div[@class='imc-type--title-6']");
	By atlNoExpMsg = By.xpath("//div[@class='imc-manufacturing-line--alternated-section imc-lines-overview']/p[2]"); //Locator for No exhibitor msg
	By atlLoadingExhMsg = By.xpath("(//div[@class='section-wrapper imc-section--'])[1]/section[1]/div[1]/div[1]/div[1]/div[3]/p[]"); //Locator for Exhibitor loading msg
	By atlNoExhibitorFloor = By.xpath("//div[@class='imc-campus-view']/div[1]/div[18]/div[3]/a[1]"); //Locator for No Exhibitor
	By lvmNoExhibitorFloor_uat = By.xpath("//div[@class='imc-campus-view']/div[2]/div[3]/div[2]/a[1]"); //Locator for No Exhibitor
	By atlnoexhibitorsmsg = By.xpath("//p[contains(text(),'No Exhibitors on This Floor')]"); //Locator for No exhibitor msg
	
	By atlloadingexhmsg = By.xpath("//p[contains(text(),'Loading Exhibitors Please Wait ...')]"); //Locator for Loading Exhibitors msg
	By atlExhibitorFloorZoomIn = By.xpath("//div[@class='meridian-zoom-controls meridian--private--1qg3nfg']/button[1]"); //Locator for Zoom In Exhibitor
	By atlExhibitorFloorZoomOut = By.xpath("//div[@class='meridian-zoom-controls meridian--private--1qg3nfg']/button[2]"); //Locator for Zoom In Exhibitor
	By atlfloorplanmapimage = By.xpath("//div[@class='imc-map-container']/div[1]/div[1]/div[5]/div[1]"); //Locator for Zoom In out Attribute
	By atlSelectBox = By.xpath("//select[@class='imc-searchform--dropdown imc-floor-plan--dropdown']"); //Locator Selectbox
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
	By atlNextFloorBtn = By.xpath("//div[@class='imc-floor-plan--floorButtons']/a[2]"); //Locator for previous Floor button
	By atlPreviousFloorBtn = By.xpath("//div[@class='imc-floor-plan--floorButtons']/a[1]"); //Locator for Next Floor button
	By atlExpectedFloorNumber = By.xpath("//div[@class='imc-content--omni']"); //Locator for expected Floor number
	By atlExhibitorName = By.xpath("//div[@class='imc-content--padded-top-bottom']/div[1]/div[1]/div[2]/a[1]"); //Locator for Exhibitor Name
	By atlExhibitorNameOnDGShowroomPage = By.xpath("//div[@class='imc-gallery imc-gallery--65-35 breadcrumbs__round']/div[1]/ul[1]/li[3]/a[1]"); //Locator for Exhibitor Name on DG showroom Page 
	By atlReturnToBuildingList = By.xpath("//div[@class='imc-floor-plan']/div[1]/div[1]/a[1]"); //Locator for Return to Building list link
	By scrollexhibitorsection = By.xpath("//div[@class = 'imc-manufacturing-line--alternated-section imc-lines-overview']"); //Locator for scroll to exhibitor section
	By atlexhibitorsection = By.xpath("//div[@class = 'imc-content--padded-top-bottom']/div[1]"); //locator for exhibitor section at floor plans
	By atlexhibitorsearch = By.xpath("//input[@placeholder = 'Filter By Name']"); //Locator for search input box
	By atlserachexhibitorbtn = By.xpath("//section[@class = 'imc-site-wrapper']/div[1]/section[1]/div[1]/div[1]/div[1]/div[3]/div[3]/div[1]/div[1]/section[1]/div[1]/form[1]/button[2]"); //Locator for Search button for search input field
	By verifyexhibitor = By.xpath("//div[@class = 'imc-manufacturing-line']/div[2]/a[1]"); //Locator for verification for searched exhibitor
	By viewdgshowroombtn = By.xpath("//a[contains(text(),'View Digital Showroom')]"); //Locator for View Digital Showroom button
	By atlMoreOptions = By.xpath("//div[@class='imc-content--padded-top-bottom']/div[1]/div[1]/div[3]/div[1]"); //Locator for More Options 3dots
	By atlAddToList = By.xpath("//div[@id='popup-root']/div[2]/div[2]/div[1]/label"); //Locator for Add to List
	By atlAddNote = By.xpath("//div[@id='popup-root']/div[2]/div[2]/div[2]/div[1]/button[1]/label[1]"); //Locator for Add Note
	By atlAddFev = By.xpath("//div[@class='imc-content--padded-top-bottom']/div[1]/div[1]/div[3]/div[2]/div[1]/button[1]"); //Locator for Add Fev
	By atlExhSearchField = By.xpath("(//div[@class='imc-searchform--row'])[2]/form[1]/div[1]/input[1]"); //Locator for Exh Search filed
	By atlExhSearchFieldBtn = By.xpath("(//div[@class='imc-searchform--row'])[2]/form[1]/button[2]"); //Locator for Exh Search filed Btn
	By noresultsforjuniperlinesmsg = By.xpath("//p[contains(text(),'Sorry, no results found.')]"); //Locator for No results found msg for Lines on Junipermarket filter
	
	By exhibitedonfloormsg = By.xpath("//span[contains(text(),'Exhibited on this floor:')]");
	By atlLoadingNoExhiMsg = By.xpath("//div[@class='imc-manufacturing-line--alternated-section imc-lines-overview']/p[1]");//Loading Msg
	
	
	
	public ATLFloorPlansPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 
	public WebElement getatlLoadingNoExhiMsg() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlLoadingNoExhiMsg));
		return driver.findElement(atlLoadingNoExhiMsg);
	}
	public WebElement getATLExhibitorsAndProductTab() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlExhibitorsAndProductTab));
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitedonfloormsg));
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

	public WebElement getATLExhibitorName() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlExhibitorName));
		return driver.findElement(atlExhibitorName);
	}
	public WebElement getATLExhibitorNameOnDGShowroomPage() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlExhibitorNameOnDGShowroomPage));
		return driver.findElement(atlExhibitorNameOnDGShowroomPage);
	}
	public WebElement getATLReturnToBuildingList() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlReturnToBuildingList));
		return driver.findElement(atlReturnToBuildingList);
	}
	public WebElement getatlexhibitorsection() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElement(atlexhibitorsection);
	}
	public WebElement getatlexhibitorsearch() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitedonfloormsg));
		return driver.findElement(atlexhibitorsearch);
	}
	public WebElement getatlserachexhibitorbtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlserachexhibitorbtn));
		return driver.findElement(atlserachexhibitorbtn);
	}
	public WebElement getverifyexhibitor() throws InterruptedException {
		Thread.sleep(8000);
		return driver.findElement(verifyexhibitor);
	}
	public WebElement getscrollexhibitorsection() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElement(scrollexhibitorsection);
	}
	public WebElement getViewDGShowroombtn() {
		return driver.findElement(viewdgshowroombtn);
	}
	public WebElement getATLMoreOptions() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlMoreOptions));
		return driver.findElement(atlMoreOptions);
	}
	public WebElement getATLAddToList() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlAddToList));
		return driver.findElement(atlAddToList);
	}
	public WebElement getATLAddNote() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlAddNote));
		return driver.findElement(atlAddNote);
	}
	public WebElement getATLBuildingFloorForFilter() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlBuildingFloorForFilter));
		return driver.findElement(atlBuildingFloorForFilter);
	}

	public WebElement getATLAddFev() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlAddFev));
		return driver.findElement(atlAddFev);
	}
	public WebElement getATLExhSearchField() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlExhSearchField));
		return driver.findElement(atlExhSearchField);
	}
	public WebElement getATLExhSearchFieldBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlExhSearchFieldBtn));
		return driver.findElement(atlExhSearchFieldBtn);
	}
	public WebElement getNoResultsMsgForLinesOnJuniper() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(noresultsforjuniperlinesmsg));
		return driver.findElement(noresultsforjuniperlinesmsg);
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
	public WebElement getExhibitedOnFloorMsg() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitedonfloormsg));
		return driver.findElement(exhibitedonfloormsg);
	}
	
}



