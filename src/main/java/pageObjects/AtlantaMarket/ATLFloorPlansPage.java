package pageObjects.AtlantaMarket;

import java.time.Duration;

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
	By atlBuildingFloor = By.xpath("//div[@class='imc-campus-view']/div[3]/div[8]/div[3]/a[1]"); //Locator for Building floor
	By atlBuilding1Floor3 = By.xpath("(//a [@class='imc-campus-view-link' and @href='/Market Map/building/Building 1/floor/3'])[2]"); //Locator for Building floor 3
	By buildingFloor_lvmUAT = By.xpath("//div[@class='imc-campus-view']/div[3]/div[10]/div[3]/a[1]"); //Locator for Building floor 9th LVM UAT
	By lvmBuildingFloor = By.xpath("//div[@class='imc-campus-view']/div[3]/div[11]/div[3]/a[1]"); //Locator for Building floor
	By atlBuildingFloorForFilter = By.xpath("//div[@class='imc-campus-view']/div[3]/div[4]/div[3]/a"); //Locator for Building floor
	By atlBuildingFloorNumber = By.xpath("//div[@class='imc-campus-view']/div[3]/div[10]/div[3]/a"); //Locator for Building floor number
	By atlFloorName = By.xpath("(//div[@class='imc-type--title-6 imc-section--padded-top-large'])[1]");
	By atlNoExpMsg = By.xpath("//div[@class='imc-manufacturing-line--alternated-section imc-lines-overview']/p[2]"); //Locator for No exhibitor msg
	By atlLoadingExhMsg = By.xpath("(//div[@class='section-wrapper imc-section--'])[1]/section[1]/div[1]/div[1]/div[1]/div[3]/p[]"); //Locator for Exhibitor loading msg
	By atlNoExhibitorFloor = By.xpath("//div[@class='imc-campus-view']/div[1]/div[18]/div[3]/a[1]"); //Locator for No Exhibitor
	By lvmNoExhibitorFloor_uat = By.xpath("//div[@class='imc-campus-view']/div[2]/div[3]/div[2]/a[1]"); //Locator for No Exhibitor
	By atlnoexhibitorsmsg = By.xpath("//p[contains(text(),'No Exhibitors on This Floor')]"); //Locator for No exhibitor msg
	By atlNoExhibitorFloorATL = By.xpath("//a[contains(text(),'Buying Groups / Meeting Rooms')]"); //ATL No exhibitor floor
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
	By locationpinicononmap = By.xpath("//div[contains(@class,'imc-floor-plan')]//div[34]/button"); //Locator for location pin on map
	By exhibitordetailsmodal = By.xpath("//div[@class='imc-content--padded-medium-desktop']"); //Locator for Exhibitor Details Modal
	By exhnameonexhdetailsmodal = By.xpath("//div[@class='imc-content--padded-medium-desktop']/div/div/h5"); //Locator for Exhibitor name on Exh Details Modal
	By overlayclosebtn = By.xpath("//button[@data-testid='meridian--private--close-overlay']"); //Locator for Overlay close btn
	By atlNextFloorBtn = By.xpath("//div[@class='imc-floor-plan--floorButtons imc-section--padded-left-medium imc-section--padded-medium imc-section--padded-right-medium']/a[2]"); //Locator for previous Floor button
	By atlPreviousFloorBtn = By.xpath("//div[@class='imc-floor-plan--floorButtons imc-section--padded-left-medium imc-section--padded-medium imc-section--padded-right-medium']/a[1]"); //Locator for Next Floor button
	By atlExpectedFloorNumber = By.xpath("//span[@class='imc-floor-plan-name']/h1"); //Locator for expected Floor number
	By atlExhibitorName = By.xpath("//div[@class='imc-content--padded-top-bottom']/div[1]/div[1]/div[1]/div[2]/a"); //Locator for Exhibitor Name
	By atlExhibitorNameOnDGShowroomPage = By.xpath("//div[@class='imc-gallery imc-gallery--65-35 breadcrumbs__round']/div[1]/ul[1]/li[3]/a[1]"); //Locator for Exhibitor Name on DG showroom Page 
	By atlReturnToBuildingList = By.xpath("//div[@class='imc-floor-plan']/div[1]/div[1]/a[1]"); //Locator for Return to Building list link
	By scrollexhibitorsection = By.xpath("//span[text()='Exhibitors on This Floor']"); //Locator for scroll to exhibitor section
	By atlexhibitorsection = By.xpath("//div[@class = 'imc-content--padded-top-bottom']/div[1]"); //locator for exhibitor section at floor plans
	By atlexhibitorsearch = By.xpath("//input[@placeholder = 'Filter By Name']"); //Locator for search input box
	By atlserachexhibitorbtn = By.xpath("(//div[@class='imc-searchform--button--search']/button[@type='submit'])[2]"); //Locator for Search button for search input field
	By verifyexhibitor = By.xpath("//div[@class = 'imc-manufacturing-line']/div[2]/a[1]"); //Locator for verification for searched exhibitor
	By viewdgshowroombtn = By.xpath("//a[contains(text(),'View Digital Showroom')]"); //Locator for View Digital Showroom button
	By atlMoreOptions = By.xpath("//div[@class='imc-content--padded-top-bottom']/div[1]/div[2]/div[3]/div[1]"); //Locator for More Options 3dots
	By atlAddToList = By.xpath("//div[@id='popup-root']/div[2]/div[2]/div[1]/label"); //Locator for Add to List
	By atlAddNote = By.xpath("//div[@id='popup-root']/div[2]/div[2]/div[2]/label"); //Locator for Add Note
	By atlAddFev = By.xpath("//div[@class='imc-content--padded-top-bottom']/div[1]/div[2]/div[3]/div[2]/div[1]/button[1]"); //Locator for Add Fev
	By atlExhSearchField = By.xpath("(//div[@class='imc-searchform--row'])[2]/form[1]/div[1]/input[1]"); //Locator for Exh Search filed
	By atlExhSearchFieldBtn = By.xpath("(//div[@class='imc-searchform--row'])[2]/form[1]/button[2]"); //Locator for Exh Search filed Btn
	By noresultsforjuniperlinesmsg = By.xpath("//p[contains(text(),'Sorry, no results found.')]"); //Locator for No results found msg for Lines on Junipermarket filter
	By resultsforjuniperlinesmsg = By.xpath("//div[contains(@class,'imc-manufacturing-line-title-wrapper')]/a"); //Locator for results found  for Lines on Junipermarket filter
	By exhibitedonfloormsg = By.xpath("//span[contains(text(),'Exhibitors on This Floor')]");
	By atlLoadingNoExhiMsg = By.xpath("//p[contains(text(),'No Exhibitors on This Floor')]");//Loading Msg
	
	By atlExhibitorNamePROD = By.xpath("//div[@class='imc-content--padded-top-bottom']/div[1]/div[1]/div[1]/div[2]/a"); //Locator for Exhibitor Name
	By lvmBuildingFloorsix = By.xpath("//div[@class='imc-campus-view']/div[3]/div[13]/div[3]/a[1]"); //Locator for Building floor
	By atlBuildingFloornew = By.xpath("//div[@class='imc-campus-view']/div[3]/div[10]/div[3]/a[1]"); //Locator for Building floor
	
	public ATLFloorPlansPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 
	public WebElement getatlExhibitorNamePROD() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlExhibitorNamePROD));
		return driver.findElement(atlExhibitorNamePROD);
	}
	public WebElement getatlLoadingNoExhiMsg() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlLoadingNoExhiMsg));
		return driver.findElement(atlLoadingNoExhiMsg);
	}
	public WebElement getATLExhibitorsAndProductTab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlExhibitorsAndProductTab));
		return driver.findElement(atlExhibitorsAndProductTab);
	}

	public WebElement getATLFloorPlansLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlFloorPlansLink));
		return driver.findElement(atlFloorPlansLink);
	}
	public WebElement getATLBuildingFloor() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlBuildingFloor));
		return driver.findElement(atlBuildingFloor);
	}
	public WebElement getATLBuilding1Floor3() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlBuilding1Floor3));
		return driver.findElement(atlBuilding1Floor3);
	}
	public WebElement getATLBuildingFloorNumber() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlBuildingFloorNumber));
		return driver.findElement(atlBuildingFloorNumber);
	}
	public WebElement getATLFloorName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlFloorName));
		return driver.findElement(atlFloorName);
	}
	public WebElement getATLNoExpMsg() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlnoexhibitorsmsg));
		return driver.findElement(atlnoexhibitorsmsg);
	}
	public WebElement getATLNoExhibitorFloor() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlNoExhibitorFloor));
		return driver.findElement(atlNoExhibitorFloor);
	}

	public WebElement getATLExhibitorFloorZoomIn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlExhibitorFloorZoomIn));
		return driver.findElement(atlExhibitorFloorZoomIn);
	}
	public WebElement getATLExhibitorFloorZoomOut() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlExhibitorFloorZoomOut));
		return driver.findElement(atlExhibitorFloorZoomOut);
	}
	public WebElement getATLFloorPlanMapIamge() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlfloorplanmapimage));
		return driver.findElement(atlfloorplanmapimage);
	}

	public WebElement getATLSelectBox() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitedonfloormsg));
		return driver.findElement(atlSelectBox);
	}

	public WebElement getATLLoadingExhMsg() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlloadingexhmsg));
		return driver.findElement(atlloadingexhmsg);
	}
	public WebElement getVendingMachineIconOnMap() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(vendingmchineicononmap));
		return driver.findElement(vendingmchineicononmap);
	}
	public WebElement getVendingMachineOverlayOnMap() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(vendingmachineoverlay));
		return driver.findElement(vendingmachineoverlay);
	}
	public WebElement getElevatorIconOnMap() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(elevatoricononmap));
		return driver.findElement(elevatoricononmap);
	}
	public WebElement getElevatorOverlayOnMap() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(elevatoroverlay));
		return driver.findElement(elevatoroverlay);
	}
	public WebElement getWaterFountainIconOnMap() throws InterruptedException {
		//Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(waterfountainicononmap));
		return driver.findElement(waterfountainicononmap);
	}
	public WebElement getWaterFountainOverlayOnMap() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(waterfountainoverlay));
		return driver.findElement(waterfountainoverlay);
	}
	public WebElement getPhoneIconOnMap() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(phoneicononmap));
		return driver.findElement(phoneicononmap);
	}
	public WebElement getPhoneOverlayOnMap() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(phoneoverlay));
		return driver.findElement(phoneoverlay);
	}
	public WebElement getLocationPinIconOnMap() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(locationpinicononmap));
		return driver.findElement(locationpinicononmap);
	}
	public WebElement getExhibitorDetailsModal() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitordetailsmodal));
		return driver.findElement(exhibitordetailsmodal);
	}
	public WebElement getExhNameOnExhibitorDetailsModal() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhnameonexhdetailsmodal));
		return driver.findElement(exhnameonexhdetailsmodal);
	}
	public WebElement getOverlayCloseBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(overlayclosebtn));
		return driver.findElement(overlayclosebtn);
	}


	public WebElement getATLNextFloorBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlNextFloorBtn));
		return driver.findElement(atlNextFloorBtn);
	}
	public WebElement getATLPreviousFloorBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlPreviousFloorBtn));
		return driver.findElement(atlPreviousFloorBtn);
	}
	public WebElement getATLExpectedFloorNumber() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlExpectedFloorNumber));
		return driver.findElement(atlExpectedFloorNumber);
	}

	public WebElement getATLExhibitorName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlExhibitorName));
		return driver.findElement(atlExhibitorName);
	}
	public WebElement getATLExhibitorNameOnDGShowroomPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlExhibitorNameOnDGShowroomPage));
		return driver.findElement(atlExhibitorNameOnDGShowroomPage);
	}
	public WebElement getATLReturnToBuildingList() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlReturnToBuildingList));
		return driver.findElement(atlReturnToBuildingList);
	}
	public WebElement getatlexhibitorsection() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlexhibitorsection));
		return driver.findElement(atlexhibitorsection);
	}
	public WebElement getatlexhibitorsearch() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitedonfloormsg));
		return driver.findElement(atlexhibitorsearch);
	}
	public WebElement getatlserachexhibitorbtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlserachexhibitorbtn));
		return driver.findElement(atlserachexhibitorbtn);
	}
	public WebElement getverifyexhibitor() throws InterruptedException {
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(verifyexhibitor));
		return driver.findElement(verifyexhibitor);
	}
	public WebElement getscrollexhibitorsection() throws InterruptedException {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(scrollexhibitorsection));
		return driver.findElement(scrollexhibitorsection);
	}
	public WebElement getViewDGShowroombtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(viewdgshowroombtn));
		return driver.findElement(viewdgshowroombtn);
	}
	public WebElement getATLMoreOptions() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlMoreOptions));
		return driver.findElement(atlMoreOptions);
	}
	public WebElement getATLAddToList() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlAddToList));
		return driver.findElement(atlAddToList);
	}
	public WebElement getATLAddNote() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlAddNote));
		return driver.findElement(atlAddNote);
	}
	public WebElement getATLBuildingFloorForFilter() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlBuildingFloorForFilter));
		return driver.findElement(atlBuildingFloorForFilter);
	}

	public WebElement getATLAddFev() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlAddFev));
		return driver.findElement(atlAddFev);
	}
	public WebElement getATLExhSearchField() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlExhSearchField));
		return driver.findElement(atlExhSearchField);
	}
	public WebElement getATLExhSearchFieldBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlExhSearchFieldBtn));
		return driver.findElement(atlExhSearchFieldBtn);
	}
	public WebElement getNoResultsMsgForLinesOnJuniper() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(noresultsforjuniperlinesmsg));
		return driver.findElement(noresultsforjuniperlinesmsg);
	}
	public WebElement getlvmNoExhibitorFloor_uat() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmNoExhibitorFloor_uat));
		return driver.findElement(lvmNoExhibitorFloor_uat);
	}
	public WebElement getlvmflooricononmap_uat() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmflooricononmap_uat));
		return driver.findElement(lvmflooricononmap_uat);
	}
	public WebElement getbuildingFloor_lvmUAT() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(buildingFloor_lvmUAT));
		return driver.findElement(buildingFloor_lvmUAT);
	}
	public WebElement getlvmflooricononmap_lvmUAT() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmflooricononmap_lvmUAT));
		return driver.findElement(lvmflooricononmap_lvmUAT);
	}
	public WebElement getlvmflooriconoverlay_lvmUAT() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmflooriconoverlay_lvmUAT));
		return driver.findElement(lvmflooriconoverlay_lvmUAT);
	}
	public WebElement getExhibitedOnFloorMsg() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitedonfloormsg));
		return driver.findElement(exhibitedonfloormsg);
	}
	public WebElement getLVMBuildingFloor() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(lvmBuildingFloor));
		return driver.findElement(lvmBuildingFloor);
	}
	public WebElement getLVMBuildingFloorsix() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(lvmBuildingFloorsix));
		return driver.findElement(lvmBuildingFloorsix);
	}
	public WebElement getATLBuildingFloorNew() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(atlBuildingFloornew));
		return driver.findElement(atlBuildingFloornew);
	}
	public WebElement getResultsMsgForLinesOnJuniper() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(resultsforjuniperlinesmsg));
		return driver.findElement(resultsforjuniperlinesmsg);
	}
	public WebElement getatlNoExhibitorFloorATL() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlNoExhibitorFloorATL));
		return driver.findElement(atlNoExhibitorFloorATL);
	}
}



