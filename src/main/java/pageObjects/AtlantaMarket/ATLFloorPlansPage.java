package pageObjects.AtlantaMarket;

import java.time.Duration;
import java.util.List;

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
		this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }
	 // Generic element getter with smart waiting
    private WebElement getElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Generic elements getter (for lists)
    private List<WebElement> getElements(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
	public WebElement getatlExhibitorNamePROD() {
		 return getElement(atlExhibitorNamePROD);
	}
	public WebElement getatlLoadingNoExhiMsg() {
		 return getElement(atlLoadingNoExhiMsg);
	}
	public WebElement getATLExhibitorsAndProductTab() {
		 return getElement(atlExhibitorsAndProductTab);
	}

	public WebElement getATLFloorPlansLink() {
		 return getElement(atlFloorPlansLink);
	}
	public WebElement getATLBuildingFloor() {
		 return getElement(atlBuildingFloor);
	}
	public WebElement getATLBuilding1Floor3() {
		 return getElement(atlBuilding1Floor3);
	}
	public WebElement getATLBuildingFloorNumber() {
		 return getElement(atlBuildingFloorNumber);
	}
	public WebElement getATLFloorName() {
		 return getElement(atlFloorName);
	}
	public WebElement getATLNoExpMsg() {
		 return getElement(atlnoexhibitorsmsg);
	}
	public WebElement getATLNoExhibitorFloor() {
		 return getElement(atlNoExhibitorFloor);
	}

	public WebElement getATLExhibitorFloorZoomIn() {
		 return getElement(atlExhibitorFloorZoomIn);
	}
	public WebElement getATLExhibitorFloorZoomOut() {
		 return getElement(atlExhibitorFloorZoomOut);
	}
	public WebElement getATLFloorPlanMapIamge() {
		 return getElement(atlfloorplanmapimage);
	}

	public WebElement getATLSelectBox() {
		 return getElement(atlSelectBox);
	}

	public WebElement getATLLoadingExhMsg() {
		 return getElement(atlloadingexhmsg);
	}
	public WebElement getVendingMachineIconOnMap() {
		 return getElement(vendingmchineicononmap);
	}
	public WebElement getVendingMachineOverlayOnMap() {
		 return getElement(vendingmachineoverlay);
	}
	public WebElement getElevatorIconOnMap() {
		 return getElement(elevatoricononmap);
	}
	public WebElement getElevatorOverlayOnMap() {
		 return getElement(elevatoroverlay);
	}
	public WebElement getWaterFountainIconOnMap() throws InterruptedException {
		 return getElement(waterfountainicononmap);
	}
	public WebElement getWaterFountainOverlayOnMap() {
		 return getElement(waterfountainoverlay);
	}
	public WebElement getPhoneIconOnMap() throws InterruptedException{
		 return getElement(phoneicononmap);
	}
	public WebElement getPhoneOverlayOnMap() {
		 return getElement(phoneoverlay);
	}
	public WebElement getLocationPinIconOnMap() throws InterruptedException{
		 return getElement(locationpinicononmap);
	}
	public WebElement getExhibitorDetailsModal() {
		 return getElement(exhibitordetailsmodal);
	}
	public WebElement getExhNameOnExhibitorDetailsModal() {
		 return getElement(exhnameonexhdetailsmodal);
	}
	public WebElement getOverlayCloseBtn() {
		 return getElement(overlayclosebtn);
	}


	public WebElement getATLNextFloorBtn() {
		 return getElement(atlNextFloorBtn);
	}
	public WebElement getATLPreviousFloorBtn() {
		 return getElement(atlPreviousFloorBtn);
	}
	public WebElement getATLExpectedFloorNumber() {
		 return getElement(atlExpectedFloorNumber);
	}

	public WebElement getATLExhibitorName() {
		 return getElement(atlExhibitorName);
	}
	public WebElement getATLExhibitorNameOnDGShowroomPage() {
		return getElement(atlExhibitorNameOnDGShowroomPage);
	}
	public WebElement getATLReturnToBuildingList() {
		return getElement(atlReturnToBuildingList);
	}
	public WebElement getatlexhibitorsection() throws InterruptedException {
		return getElement(atlexhibitorsection);
	}
	public WebElement getatlexhibitorsearch() {
		return getElement(atlexhibitorsearch);
	}
	public WebElement getatlserachexhibitorbtn() {
		return getElement(atlserachexhibitorbtn);
	}
	public WebElement getverifyexhibitor() throws InterruptedException {
		return getElement(verifyexhibitor);
	}
	public WebElement getscrollexhibitorsection() throws InterruptedException {
		return getElement(scrollexhibitorsection);
	}
	public WebElement getViewDGShowroombtn() {
		return getElement(viewdgshowroombtn);
	}
	public WebElement getATLMoreOptions() {
		return getElement(atlMoreOptions);
	}
	public WebElement getATLAddToList() {
		return getElement(atlAddToList);
	}
	public WebElement getATLAddNote() {
		return getElement(atlAddNote);
	}
	public WebElement getATLBuildingFloorForFilter() {
		return getElement(atlBuildingFloorForFilter);
	}

	public WebElement getATLAddFev() {
		return getElement(atlAddFev);
	}
	public WebElement getATLExhSearchField() {
		return getElement(atlExhSearchField);
	}
	public WebElement getATLExhSearchFieldBtn() {
		return getElement(atlExhSearchFieldBtn);
	}
	public WebElement getNoResultsMsgForLinesOnJuniper() {
		return getElement(noresultsforjuniperlinesmsg);
	}
	public WebElement getlvmNoExhibitorFloor_uat() {
		return getElement(lvmNoExhibitorFloor_uat);
	}
	public WebElement getlvmflooricononmap_uat() {
		return getElement(lvmflooricononmap_uat);
	}
	public WebElement getbuildingFloor_lvmUAT() {
		return getElement(buildingFloor_lvmUAT);
	}
	public WebElement getlvmflooricononmap_lvmUAT() {
		return getElement(lvmflooricononmap_lvmUAT);
	}
	public WebElement getlvmflooriconoverlay_lvmUAT() {
		return getElement(lvmflooriconoverlay_lvmUAT);
	}
	public WebElement getExhibitedOnFloorMsg() {
		return getElement(exhibitedonfloormsg);
	}
	public WebElement getLVMBuildingFloor() {
		return getElement(lvmBuildingFloor);
	}
	public WebElement getLVMBuildingFloorsix() {
		return getElement(lvmBuildingFloorsix);
	}
	public WebElement getATLBuildingFloorNew() {
		return getElement(atlBuildingFloornew);
	}
	public WebElement getResultsMsgForLinesOnJuniper() {
		return getElement(resultsforjuniperlinesmsg);
	}
	public WebElement getatlNoExhibitorFloorATL() {
		return getElement(atlNoExhibitorFloorATL);
	}
}



