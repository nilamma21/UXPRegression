package pageObjects.LasVegasMarket;

import java.time.Duration;
import java.util.List;

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
	By lvmBuildingFloor = By.xpath("(//div[@class='imc-campus-view--clickeable imc-campus-view--building'])[2]/div[14]/div[3]/a"); //Locator for Building floor
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
	By lvmDiscoverBtn = By.xpath("//div[@class='imc-content--display-flex imc-content--display-flex-gap-small imc-content--display-flex-justify-center imc-content--full-height']/div[3]"); //Locator for Building floor
	By lvmFloorPlansLinkPROD = By.xpath("//div[@class='imc-content--top-0 imc-content--absolute imc-navigation--wrapper-menu active']/div[1]/div/a[contains(text(),'Floor Plans')]"); //Locator for floor plans Link
	By lvmFloorPlansFirstExhName = By.xpath("//div[@class='imc-content--padded-top-bottom']/div/div[1]/div/div[2]/a"); //Locator for floor plans 1st exh
	By lvmFloorPlansSearchButton = By.xpath("//div[@class='imc-content--display-flex imc-content--display-flex-space-between imc-lines-overview-actions']/div/section/div/form/div[2]/button"); //Locator for floor plans Search btn

	By lvmFloorPlansNoExPresentATL = By.xpath("//div[@class='imc-campus-view']/div[3]/div[8]/div[3]/a[1]");
	
	public LVMFloorPlansPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    // Generic element getter with smart waiting
    private WebElement getElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Generic clickable element getter
    private WebElement getClickableElement(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Generic elements getter (for lists)
    private List<WebElement> getElements(By locator) {
        return (List<WebElement>) wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public WebElement getlvmFloorPlansNoExPresentATL() {
        return getElement(lvmFloorPlansNoExPresentATL);
    }
    public WebElement getlvmFloorPlansSearchButton() {
        return getElement(lvmFloorPlansSearchButton);
    }
    public WebElement getlvmFloorPlansFirstExhName() {
        return getElement(lvmFloorPlansFirstExhName);
    }
    public WebElement getlvmFloorPlansLinkPROD() {
        return getElement(lvmFloorPlansLinkPROD);
    }
    public WebElement getlvmDiscoverBtn() {
        return getElement(lvmDiscoverBtn);
    }
    public WebElement getlvmserachexhibitorbtnPROD() {
        return getElement(lvmserachexhibitorbtnPROD);
    }
    public WebElement getLVMExhibitorsAndProductTab() {
        return getElement(lvmExhibitorsAndProductTab);
    }
    public WebElement getLVMFloorPlansLink() {
        return getClickableElement(lvmFloorPlansLink);
    }
    public WebElement getLVMBuildingFloor() {
        return getClickableElement(lvmBuildingFloor);
    }
    public WebElement getLVMBuildingFloorNumber() {
        return getClickableElement(lvmBuildingFloorNumber);
    }
    public WebElement getLVMFloorName() {
        return getElement(lvmFloorName);
    }
    public WebElement getLVMNoExpMsg() {
        return getElement(lvmnoexhibitorsmsg);
    }
    public WebElement getLVMNoExhibitorFloor() {
        return getElement(lvmNoExhibitorFloor);
    }
    public WebElement getLVMExhibitorFloorZoomIn() {
        return getElement(lvmExhibitorFloorZoomIn);
    }
    public WebElement getLVMExhibitorFloorZoomOut() {
        return getElement(lvmExhibitorFloorZoomOut);
    }
    public WebElement getLVMFloorPlanMapIamge() {
        return getElement(lvmfloorplanmapimage);
    }
    public WebElement getLVMSelectBox() {
        return getElement(lvmSelectBox);
    }
    public WebElement getLVMLoadingExhMsg() {
        return getElement(lvmloadingexhmsg);
    }
    public WebElement getVendingMachineIconOnMap() {
        return getElement(vendingmchineicononmap);
    }
    public WebElement getVendingMachineOverlayOnMap() {
        return getElement(vendingmachineoverlay);
    }
    public WebElement getElevatorIconOnMap() {
        return getClickableElement(elevatoricononmap);
    }
    public WebElement getElevatorOverlayOnMap() {
        return getElement(elevatoroverlay);
    }
    public WebElement getWaterFountainIconOnMap() throws InterruptedException {
        return getClickableElement(waterfountainicononmap);
    }
    public WebElement getWaterFountainOverlayOnMap() {
        return getElement(waterfountainoverlay);
    }
    public WebElement getPhoneIconOnMap() throws InterruptedException {
        return getClickableElement(phoneicononmap);
    }
    public WebElement getPhoneOverlayOnMap() {
        return getElement(phoneoverlay);
    }
    public WebElement getLocationPinIconOnMap() throws InterruptedException {
        return getClickableElement(locationpinicononmap);
    }
    public WebElement getExhibitorDetailsModal() {
        return getElement(exhibitordetailsmodal);
    }
    public WebElement getExhNameOnExhibitorDetailsModal() {
        return driver.findElement(exhnameonexhdetailsmodal);
    }
    public WebElement getOverlayCloseBtn() {
        return driver.findElement(overlayclosebtn);
    }
    public WebElement getLVMNextFloorBtn() {
        return getElement(lvmNextFloorBtn);
    }
    public WebElement getLVMPreviousFloorBtn() {
        return getElement(lvmPreviousFloorBtn);
    }
    public WebElement getLVMExpectedFloorNumber() {
        return getElement(lvmExpectedFloorNumber);
    }
    public WebElement getLVMExhibitorName() {
        return getElement(lvmExhibitorName);
    }
    public WebElement getLVMExhibitorNameOnDGShowroomPage() {
        return getElement(lvmExhibitorNameOnDGShowroomPage);
    }
    public WebElement getLVMReturnToBuildingList() {
        return getElement(lvmReturnToBuildingList);
    }
    public WebElement getlvmexhibitorsection() throws InterruptedException {
        Thread.sleep(10000);
        return driver.findElement(lvmexhibitorsection);
    }
    public WebElement getlvmexhibitorsearch() {
        return getElement(lvmexhibitorsearch);
    }
    public WebElement getlvmserachexhibitorbtn() {
        return getElement(lvmserachexhibitorbtn);
    }
    public WebElement getverifyexhibitor() throws InterruptedException {
        Thread.sleep(8000);
        return getClickableElement(verifyexhibitor);
    }
    public WebElement getscrollexhibitorsection() throws InterruptedException {
        Thread.sleep(10000);
        return getClickableElement(scrollexhibitorsection);
    }
    public WebElement getViewDGShowroombtn() {
        return getClickableElement(viewdgshowroombtn);
    }
    public WebElement getLVMMoreOptions() {
        return getClickableElement(lvmMoreOptions);
    }
    public WebElement getLVMAddToList() {
        return getClickableElement(lvmAddToList);
    }
    public WebElement getLVMAddNote() {
        return getElement(lvmAddNote);
    }
    public WebElement getLVMBuildingFloorForFilter() {
        return getElement(lvmBuildingFloorForFilter);
    }
    public WebElement getLVMAddFev() {
        return getElement(lvmAddFev);
    }
    public WebElement getLVMExhSearchField() {
        return getElement(lvmExhSearchField);
    }
    public WebElement getLVMExhSearchFieldBtn() {
        return getElement(lvmExhSearchFieldBtn);
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
    public WebElement getLVMBuildingFloorsix() {
        return getClickableElement(lvmBuildingFloorsix);
    }
	
}



