package pageObjects.AtlantaMarket;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLMarketPlannerPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By atlmarketplannerhome = By.xpath("//div[@class='imc-section imc-market-planner-toolbar ']"); // Locator for market planner home page
	By atlfaveditlistbtn = By.xpath("//li[contains(text(),'Favorites')]/span"); //Locator for Edit list btn of Favorites list
	By editlistpage = By.xpath("//div[@class='imc-gallery imc-market-planner-list-display imc-vr--large']"); //Locator for Edit List page
	By savedexhnameinlist = By.xpath("//li[@class='imc-list-edit--draggable'][1]/div/div[1]/div[1]/a"); //Locator for Saved Exhibitor name in list
	By lvmsavedexhnameinlist_uat = By.xpath("//li[@class='imc-list-edit--draggable'][1]/div/div[1]/div[1]/a"); //Locator for Saved Exhibitor name in list
	By editlistitemmorebtn = By.xpath("//div[@class='imc-loading-relative']"); //Locator for More button of  list item
	By moreBtnDeleteOptnExistingList_ATLPROD = By.xpath("//div[@class='imc-loading-relative']/div[3]/li[1]/div[1]/div[1]/div[4]/div[1]/button[1]"); //Locator for Delete Option of 1st list item
	
	By moreBtnDeleteOptn_ATLPROD = By.xpath("//div[@class='imc-gallery__item imc-vertical-tabs-content']/div[1]/div[3]/li[1]/div[1]/div[1]/div[4]/div[1]/button[1]"); //Locator for Delete Option of 1st list item
	By moreBtnDeleteOptn_lvmUAT = By.xpath("(//li[@class=\"imc-list-edit--draggable\"])[1]/div/div[1]/div[4]/div/button"); //Locator for Delete Option of 1st list item
	By editlistitemdeleteoptn = By.xpath("//li[@class='imc-list-edit--draggable'][1]/div/div/div[4]/div/div/span[3]/a"); //Locator for Delete Option of 1st list item
	By createnewlistnametxtbx = By.xpath("//input[@name='listName']"); //Locator for List name text field on Create new list modal
	By newlistmodalcreatebtn = By.xpath("(//input[@type='submit'])[position()=2]"); //Locator for Create btn on Create new list modal
	By newlistmodalcreatebtn_LvmUAT = By.xpath("(//input[@type='submit'])[position()=3]"); //Locator for Create btn on Create new list modal LVM UAT
	By gotomarketplannerbtn = By.xpath("//a[contains(text(),'Go to Market Planner')]"); //Locator for Go to Market Planner button
	By mphomeliststab = By.xpath("//div[@class='imc-mp-toolbar imc-breakpoint-display--hide-mobile']/a[2]"); //Locator for Lists tab on MP Home
	By listspagelistsmenu = By.xpath("//div[@class='imc-vertical-tabs-nav']/a[1]"); //Locator for Lists left menu
	By atlmplistsnames = By.xpath("//ul[@class='imc-market-planner-list']/li/div[1]"); //Locator for the List names of MP lists
	By atlmpeditlistoptns = By.xpath("//ul[@class='imc-market-planner-list']/li/div[2]/span[2]/a"); //Locator for Edit List options on Lists page
	By atlmpeditlistoptn = By.xpath("(//ul[@class='imc-market-planner-list']/li/div[2]/span[2]/a[1])[1]"); //Locator for Edit List options on Lists page
	By atlmpexistinglistname = By.xpath("//form/div[4]/div[3]/label"); //Locator for existing list name
	By atladdtoseselectedbtn = By.xpath("//input[@data-xpath='quickAdd.saveList']"); //Locator for Add to Selected button
	By listspagefavoritesmenu = By.xpath("//div[@class='imc-vertical-tabs-nav']/div[contains(text(),'Favorites')]"); //Locator for Favorites left menu
	By addlistcreatebtn = By.xpath("//div[@class = 'imc-vr--medium']/input[1]"); //Locator for Create button on Add List modal
	By addlistcreatebtn_ATLPROD = By.xpath("//div[@class = 'imc-vr--medium-alt']/input[1]"); //Locator for Create button on Add List modal
	
	By savedproductnameinlist = By.xpath("//li[@class='imc-list-edit--draggable'][1]/div/div[3]/div/div/div/div/a"); //Locator for Saved Product Name in List
	By createAddListBtn = By.xpath("(//input[@type='submit'])[position()=3]"); //Locator for Create button on Add List modal		
	By newCreatedListName = By.xpath("//div[@class='imc-gallery imc-gallery--20-80 imc-gallery--1-2--mobile-full-width']/div[1]/div[1]/div[1]/div[1]/h3[1]"); //Locator for newly Created List name
	By selectChannel = By.xpath("//div[@class='imc-section imc-market-planner-toolbar ']/div[1]/div[1]/div[1]/div[1]/select[1]"); //Locator for channel Lst box
	By invalidPasswordError = By.xpath("//div[@class='error pageLevel']/p[1]"); //Locator for invalid Password
	By enterEmailErrorMsg = By.xpath("(//div[@class='error itemLevel']/p[1])[1]"); //Locator for Enter Email Error msg
	By enterPasswordErrorMsg = By.xpath("(//div[@class='error itemLevel']/p[1])[2]"); //Locator for Enter password error msg

	By mpListLeftPannel = By.xpath("//div[@class='imc-vertical-tabs-nav']/a[1]"); //Locator for List Left Pannel
	By mpEditListoption = By.xpath("(//ul[@class='imc-market-planner-list']/li/div[2]/span[2]/a[1])[1]"); //Locator for Edit List option 
	By mpQuickAdd = By.xpath("//div[@class='imc-gallery__item market-planner--list-sidebar imc-breakpoint-display--hide-mobile']//input[1]"); //Locator for QuickAdd
	By mpQuickAddAutosuggetion = By.xpath("//ul[@role='listbox']/li[1]/span[1]/span[1]"); //Locator for 1st Autsuggetion
	By mpQuickAddedExpName = By.xpath("//div[@class='imc-loading-relative']/div[3]/li[1]/div[1]/div[1]/div[1]/a[1]"); //Locator for 1st EXP
	By mpArrangeBtn = By.xpath("//div[@class='imc-gallery imc-gallery--1-2']/div[2]/button[1]"); //Locator for Arrange btn
	By mpListSortBtn = By.xpath("(//ul[@class='imc-market-planner-list']/li/div[2]/span[3])[1]"); //Locator for Sort btn
	
	By welcometext = By.xpath("//div[@class = 'imc-header-user-icon--wrapper']/button[1]"); //Locator for Market Planner welcome text
	By signout = By.xpath("//div[@class = 'imc-header-user-icon--links-settings']/a[3]"); //Locator for Signout link
	By verifysignout = By.xpath("//div[@class = 'imc-header__logo']"); //Locator for Verify Sign out
	By mpListNewListBtn = By.xpath("//div[@class='imc-gallery__item imc-vertical-tabs-content']/div[1]/div[1]/div[2]/button[2]"); //Locator for new list Btn
	By mpListNewGroupBtn = By.xpath("//div[@class='imc-gallery__item imc-vertical-tabs-content']/div[1]/div[1]/div[2]/button[3]"); //Locator for new Group Btn
	By mpListNewGroupPopupHeader = By.xpath("//div[@class='imc-modal--content imc-section imc-customlists-form']/h3[1]"); //Locator for new Group popup Header
	By mpListNewGroupNameTxt = By.xpath("//div[@class='imc-modal--content imc-section imc-customlists-form']/form[1]/div[2]/div[1]/div[1]/input[1]"); //Locator for new Group Text
	By mpListNameTxt = By.xpath("//div[@class='imc-modal--content imc-section imc-customlists-form']/form[1]/div[3]/div[1]/div[1]/input[1]"); //Locator for new List Text
	
	By mpListNewListCreateBtn = By.xpath("//div[@class='imc-modal--content imc-section imc-customlists-form']/form[1]/div[3]/div[3]/input[1]"); //Locator for new List Create Btn
	By mpListNewGroupCreateBtn = By.xpath("//div[@class='imc-modal--content imc-section imc-customlists-form']/form[1]/div[2]/div[2]/input[1]"); //Locator for new Group Create Btn
	By mpListNewSelectGroupDropdown = By.xpath("//select[@name='groupName']"); //Locator for Grou Dorpdown
	By mpListNewCreateBtn = By.xpath("//div[@class='imc-modal--content imc-section imc-customlists-form']/form[1]/div[2]/div[3]/input[1]"); //Locator for Create Btn

	By mpInvalidGrNameMsg = By.xpath("//div[@class='imc-modal--content imc-section imc-customlists-form']/form[1]/div[2]/ul[1]/li[1]"); //Locator for Invalid Gr name msg
	

	By mpdasboardtab = By.xpath("//div[@class='imc-section imc-market-planner-toolbar ']/div[1]/div[1]/div[2]/div[1]/a[1]"); //Locator for Dashboard tab
	By mpmyinfotab = By.xpath("//div[@class='imc-mp-toolbar imc-breakpoint-display--hide-mobile']/a[3]"); //Locator for My Info tab
	By mpregistrationtab = By.xpath("//div[@class='imc-mp-toolbar imc-breakpoint-display--hide-mobile']/a[4]"); //Locator for Registration tab
	By mpsavedsearchestab = By.xpath("//div[@class='imc-mp-toolbar imc-breakpoint-display--hide-mobile']/a[5]"); //Locator for Saved Searches tab
	By mpregistrationcard = By.xpath("//div[@class = 'imc-card  imc-register-card']"); //Locator for registration card
	By mplistscard = By.xpath("//div[@class='imc-section--content-with-image']/div[1]/div[1]/div[2]/div[1]"); //Locator for lists card
	By mpbookmyhotelcard = By.xpath("//div[@class='imc-section--content-with-image']/div[1]/div[1]/div[3]/div[1]"); //Locator for book my hotel card
	By mpbookmyhotelsection = By.xpath("//div[@class='imc-section--content-with-image']/div[1]/div[1]/div[3]/div[1]/div[1]"); //Locator for Book my Hotel section
	By mpfloorplanssection = By.xpath("//div[@class='imc-section--content-with-image']/div[1]/div[1]/div[3]/div[1]/div[2]"); //Locator for Book my Hotel section
	By mpexhibitorsectionsection = By.xpath("//div[@class='imc-section--content-with-image']/div[1]/div[1]/div[3]/div[1]/div[3]"); //Locator for Book my Hotel section
	By mpsavedsearchessection = By.xpath("//div[@class='imc-section--content-with-image']/div[1]/div[1]/div[3]/div[1]/div[4]"); //Locator for Book my Hotel section
	By mpmyinfosection = By.xpath("//div[@class='imc-section--content-with-image']/div[1]/div[1]/div[3]/div[1]/div[5]"); //Locator for Book my Hotel section
	By mpmarketnameregcard = By.xpath("//div[@class = 'imc-card  imc-register-card']/div[1]/div[2]"); //Locator for market name in registration card
	By mpmarketdateregcard = By.xpath("//div[@class = 'imc-card  imc-register-card']/div[1]/div[3]"); //Locator for market date in registration card
	By mpregistrationlink = By.xpath("//div[@class = 'imc-card-section imc-card-footer imc-card-centered']/a[1]"); //Locator for Registration Information link
	By mpverifyregistrationinformationlink = By.xpath("//div[@class = 'section-wrapper imc-section--basic-white']"); //Locator for verify registration page link
	By mpManageDropdown = By.xpath("(//div[@class='react-select__indicators css-1wy0on6'])[1]"); //Locator for Mnage DropDown
	By mpManageEditList = By.xpath("(//a[@class='imc-link--alt-darkred'])[1]"); //Locator for Mnage Edit list'
	By mpManageEditListSelectAllBtn = By.xpath("//div[@class='imc-loading-relative']/div[2]/div[2]/button[1]"); //Locator for Mnage Edit list Select All Btn
	By mpManageEditListCopyToBtn = By.xpath("//div[@class='imc-loading-relative']/div[2]/div[3]/button[1]"); //Locator for Mnage Edit list Copy to Btn
	By mpManageEditListMoveBtn = By.xpath("//div[@class='imc-loading-relative']/div[2]/div[4]/button[1]"); //Locator for Mnage Edit list Move Btn
	By mpManageEditListRemoveBtn = By.xpath("//div[@class='imc-loading-relative']/div[2]/div[5]/button[1]"); //Locator for Mnage Edit list Remove Btn
	
	By mpSelectListPopup = By.xpath("//div[@class='ReactModal__Content ReactModal__Content--after-open imc-modal--box imc-contactexhibitormodal']"); //Locator for Select List Popup
	By mpFevList = By.xpath("//div[@class='ReactModal__Content ReactModal__Content--after-open imc-modal--box imc-contactexhibitormodal']/div[1]/div[1]/ul[1]/li[2]/div[1]"); //Locator for Fev List
	By mpSelectFevList = By.xpath("//div[@class='ReactModal__Content ReactModal__Content--after-open imc-modal--box imc-contactexhibitormodal']/div[1]/div[1]/ul[1]/li[2]/div[2]/span[1]/a[1]"); //Locator for Select Fev List

	By mpDuplicateList = By.xpath("(//ul[@class='imc-market-planner-list']/li/div[2]/span[1]/a[1])[1]"); //Locator for Duplicate List
	By mpDuplicateListName = By.xpath("(//ul[@class='imc-market-planner-list']/li[1]/div[1])[1]"); //Locator for Duplicate List Name
	By mpDuplicateListInputBox = By.xpath("//div[@class='imc-modal--content imc-section imc-customlists-form']//form[1]/div[2]/div[1]/div[1]/input[1]"); //Locator for Duplicate List Input field
	By mpDuplicateBtn = By.xpath("//div[@class='imc-modal--content imc-section imc-customlists-form']//form[1]/div[2]//div[2]/input[1]"); //Locator for Duplicate btn
	By mpCurrentListName = By.xpath("//div[@class='imc-gallery imc-gallery--20-80 imc-gallery--1-2--mobile-full-width']/div[1]/div[1]/div[1]/div[1]/h3[1]"); //Locator for Current list name
	By mpRenameLink = By.xpath("//div[@class='imc-gallery imc-gallery--20-80 imc-gallery--1-2--mobile-full-width']/div[1]/div[1]/div[1]/div[1]/a[1]"); //Locator for rename link
	By mpRenameInputField = By.xpath("//div[@class='imc-gallery imc-gallery--20-80 imc-gallery--1-2--mobile-full-width']/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/input[1]"); //Locator for rename Input field
	By mpRenameInputSaveBtn = By.xpath("//div[@class='imc-gallery imc-gallery--20-80 imc-gallery--1-2--mobile-full-width']/div[1]/div[1]/div[1]/div[1]/form[1]/input[1]"); //Locator for rename Input Save Btn
	By mpRenameListName = By.xpath("//div[@class='imc-gallery imc-gallery--20-80 imc-gallery--1-2--mobile-full-width']/div[1]/div[1]/div[1]/div[1]/h3[1]"); //Locator for rename List Name
	By mpBackToList = By.xpath("//div[@class='imc-section--inner-content imc-section--align-fullwidth  imc-section-- imc-content--center-mobile']/div[1]/div[1]/div[1]/a[1]"); //Locator for back to List 
	By mpSourceLocationList = By.xpath("(//ul[@class='imc-market-planner-list']/li[1])[1]"); //Locator for Sourch List
	By mpDestinationLocationList = By.xpath("(//ul[@class='imc-market-planner-list']/li[3])[1]"); //Locator for Destination List
	By mpListName = By.xpath("(//ul[@class='imc-market-planner-list']/li[1]/div[1])[1]"); //Locator for 1list 

	By mpexistinglists = By.xpath("//div[@class = 'imc-section--content-with-image']/div[1]/div[1]/div[2]/div[1]/div[2]/ul[1]"); //Locator for Saved Searches under Lists card
	By mpalllists = By.xpath("//div[@class = 'imc-section--content-with-image']/div[1]/div[1]/div[2]/div[1]/div[3]/h6[1]/a[1]"); //Locator for All Lists under Lists card
	By mplisttab = By.xpath("//div[@class = 'imc-vertical-tabs-nav']/a[1]"); //Locator for Lists tab
	By mpnewlistbutton = By.xpath("//div[@class = 'imc-gallery__item imc-customlists-button-pad']/button[2]"); //Locator for new list button
	By createlistbutton = By.xpath("//div[@class = 'imc-vr--medium']/inout[1]"); //Locator Create List button

	
	public ATLMarketPlannerPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 
	public WebElement getATLMarketPlannerHome() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlmarketplannerhome));
		return driver.findElement(atlmarketplannerhome);
	}
	public WebElement getATLFavEditListBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlmarketplannerhome));
		return driver.findElement(atlfaveditlistbtn);
	}
	public WebElement getATLEditListPage() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(editlistpage));
		return driver.findElement(editlistpage);
	}
	public WebElement getATLSavedExhNameInList() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(savedexhnameinlist));
		return driver.findElement(savedexhnameinlist);
	}
	public WebElement getATLEditListItemMoreBtn() {
		return driver.findElement(editlistitemmorebtn);
	}
	public WebElement getATLEditListItemDeleteOptn() {
		return driver.findElement(editlistitemdeleteoptn);
	}
	public WebElement getCreateNewListNameTxtbx() {
		return driver.findElement(createnewlistnametxtbx);
	}
	public WebElement getNewListModalCreateBtn() {
		return driver.findElement(newlistmodalcreatebtn);
	}
	public WebElement getGoToMarketPlannerBtn() {
		return driver.findElement(gotomarketplannerbtn);
	}
	public WebElement getMPHomeListsTab() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlmarketplannerhome));
		return driver.findElement(mphomeliststab);
	}
	public WebElement getListsPageListsMenu() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(listspagelistsmenu));
		return driver.findElement(listspagelistsmenu);
	}
	public List <WebElement> getATLMPListsNames() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlmplistsnames));
		return driver.findElements(atlmplistsnames);
	}
	public List <WebElement> getATLMPEditListOptns() {
		return driver.findElements(atlmpeditlistoptns);
	}
	public WebElement getATLMPEditListOptn() {
		return driver.findElement(atlmpeditlistoptn);
	}
	public WebElement getATLMPExistingListName() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlmpexistinglistname));
		return driver.findElement(atlmpexistinglistname);
	}
	public WebElement getATLMPAddToSelectedBtn() {
		return driver.findElement(atladdtoseselectedbtn);
	}
	
	public WebElement getATLMPListsPageFavoritesMenu() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(listspagefavoritesmenu));
		return driver.findElement(listspagefavoritesmenu);
	}
	public WebElement getAddListCreateBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(addlistcreatebtn));
		return driver.findElement(addlistcreatebtn);
	}
	public WebElement getSavedProductNameInList() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(savedproductnameinlist));
		return driver.findElement(savedproductnameinlist);
	}
	public WebElement getCreateAddListBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(createAddListBtn));
		return driver.findElement(createAddListBtn);
	}	
	public WebElement getNewCreatedListName() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(newCreatedListName));
		return driver.findElement(newCreatedListName);
	}
	public WebElement getNewlistmodalcreatebtn_LvmUAT() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(newlistmodalcreatebtn_LvmUAT));
		return driver.findElement(newlistmodalcreatebtn_LvmUAT);
	}
	
	public WebElement getlvmsavedexhnameinlist_uat() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmsavedexhnameinlist_uat));
		return driver.findElement(lvmsavedexhnameinlist_uat);
	}
	public WebElement getMoreBtnDeleteOptn_lvmUAT() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(moreBtnDeleteOptn_lvmUAT));
		return driver.findElement(moreBtnDeleteOptn_lvmUAT);
	}
	public WebElement getselectChannel() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectChannel));
		return driver.findElement(selectChannel);
	}
	public WebElement getInvalidPasswordError() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(invalidPasswordError));
		return driver.findElement(invalidPasswordError);
	}
	public WebElement getEnterEmailErrorMsg() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(enterEmailErrorMsg));
		return driver.findElement(enterEmailErrorMsg);
	}
	public WebElement getEnterPasswordErrorMsg() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(enterPasswordErrorMsg));
		return driver.findElement(enterPasswordErrorMsg);
	}					

	public WebElement getMpListLeftPannel() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpListLeftPannel));
		return driver.findElement(mpListLeftPannel);
	}					
	public WebElement getMpEditListoption() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpEditListoption));
		return driver.findElement(mpEditListoption);
	}					
	public WebElement getMpQuickAdd() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpQuickAdd));
		return driver.findElement(mpQuickAdd);
	}					
	public WebElement getMpQuickAddAutosuggetion() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpQuickAddAutosuggetion));
		return driver.findElement(mpQuickAddAutosuggetion);
	}					
	public WebElement getMpQuickAddedExpName() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpQuickAddedExpName));
		return driver.findElement(mpQuickAddedExpName);
	}					
	public WebElement getMpArrangeBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpArrangeBtn));
		return driver.findElement(mpArrangeBtn);
	}					
	public WebElement getMpListSortBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpListSortBtn));
		return driver.findElement(mpListSortBtn);
	}					

	
	
	

	public WebElement getwelcometext() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(welcometext));
		return driver.findElement(welcometext);
	}
	public WebElement getsignout() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(signout));
		return driver.findElement(signout);
	}
	public WebElement getverifysignout() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(verifysignout));
		return driver.findElement(verifysignout);
	}
	public WebElement getMpListNewListBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpListNewListBtn));
		return driver.findElement(mpListNewListBtn);
	}
	public WebElement getMpListNewGroupBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpListNewGroupBtn));
		return driver.findElement(mpListNewGroupBtn);
	}
	public WebElement getMpListNewGroupPopupHeader() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpListNewGroupPopupHeader));
		return driver.findElement(mpListNewGroupPopupHeader);
	}
	public WebElement getMpListNewGroupNameTxt() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpListNewGroupNameTxt));
		return driver.findElement(mpListNewGroupNameTxt);
	}
	public WebElement getMpListNewGroupCreateBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpListNewGroupCreateBtn));
		return driver.findElement(mpListNewGroupCreateBtn);
	}
	public WebElement getmpListNewSelectGroupDropdown() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpListNewSelectGroupDropdown));
		return driver.findElement(mpListNewSelectGroupDropdown);
	}
	public WebElement getMpListNewCreateBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpListNewCreateBtn));
		return driver.findElement(mpListNewCreateBtn);
	}

	public WebElement getMpInvalidGrNameMsg() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpInvalidGrNameMsg));
		return driver.findElement(mpInvalidGrNameMsg);
	}
	public WebElement getMpListNameTxt() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpListNameTxt));
		return driver.findElement(mpListNameTxt);
	}
	public WebElement getMpListNewListCreateBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpListNewListCreateBtn));
		return driver.findElement(mpListNewListCreateBtn);
	}

		

	public WebElement getmpdasboardtab() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpdasboardtab));
		return driver.findElement(mpdasboardtab);
	}
	public WebElement getmpmyinfotab() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpmyinfotab));
		return driver.findElement(mpmyinfotab);
	}
	public WebElement getmpregistrationtab() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpregistrationtab));
		return driver.findElement(mpregistrationtab);
	}
	public WebElement getmpsavedsearchestab() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpsavedsearchestab));
		return driver.findElement(mpsavedsearchestab);
	}
	public WebElement getmpregistrationcard() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpregistrationcard));
		return driver.findElement(mpregistrationcard);
	}
	public WebElement getmplistscard() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mplistscard));
		return driver.findElement(mplistscard);
	}
	public WebElement getmpbookmyhotelcard() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpbookmyhotelcard));
		return driver.findElement(mpbookmyhotelcard);
	}
	public WebElement getmpbookmyhotelsection() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpbookmyhotelsection));
		return driver.findElement(mpbookmyhotelsection);
	}
	public WebElement getmpfloorplanssection() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpfloorplanssection));
		return driver.findElement(mpfloorplanssection);
	}
	public WebElement getmpexhibitorsectionsection() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpexhibitorsectionsection));
		return driver.findElement(mpexhibitorsectionsection);
	}
	public WebElement getmpsavedsearchessection() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpsavedsearchessection));
		return driver.findElement(mpsavedsearchessection);
	}
	public WebElement getmpmyinfosection() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpmyinfosection));
		return driver.findElement(mpmyinfosection);
	}
	public WebElement getmpmarketnameregcard() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpmarketnameregcard));
		return driver.findElement(mpmarketnameregcard);
	}
	public WebElement getmpmarketdateregcard() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpmarketdateregcard));
		return driver.findElement(mpmarketdateregcard);
	}
	public WebElement getmpregistrationlink() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpregistrationlink));
		return driver.findElement(mpregistrationlink);
	}
	public WebElement getmpverifyregistrationinformationlink() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpverifyregistrationinformationlink));
		return driver.findElement(mpverifyregistrationinformationlink);
	}
	public WebElement getMpManageDropdown() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpManageDropdown));
		return driver.findElement(mpManageDropdown);
	}
	public WebElement getMpManageEditList() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpManageEditList));
		return driver.findElement(mpManageEditList);
	}
	public WebElement getMpManageEditListSelectAllBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpManageEditListSelectAllBtn));
		return driver.findElement(mpManageEditListSelectAllBtn);
	}
	public WebElement getMpManageEditListCopyToBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpManageEditListCopyToBtn));
		return driver.findElement(mpManageEditListCopyToBtn);
	}
	public WebElement getMpSelectListPopup() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpSelectListPopup));
		return driver.findElement(mpSelectListPopup);
	}
	public WebElement getMpFevList() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpFevList));
		return driver.findElement(mpFevList);
	}


	public WebElement getMpDuplicateList() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpDuplicateList));
		return driver.findElement(mpDuplicateList);
	}
	public WebElement getMpDuplicateListName() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpDuplicateListName));
		return driver.findElement(mpDuplicateListName);
	}
	public WebElement getMpDuplicateListInputBox() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpDuplicateListInputBox));
		return driver.findElement(mpDuplicateListInputBox);
	}
	public WebElement getMpDuplicateBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpDuplicateBtn));
		return driver.findElement(mpDuplicateBtn);
	}				
	public WebElement getmpCurrentListName() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpCurrentListName));
		return driver.findElement(mpCurrentListName);
	}				
	public WebElement getmpRenameLink() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpRenameLink));
		return driver.findElement(mpRenameLink);
	}	
	public WebElement getmpRenameInputField() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpRenameInputField));
		return driver.findElement(mpRenameInputField);
	}	
	public WebElement getmpRenameInputSaveBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpRenameInputSaveBtn));
		return driver.findElement(mpRenameInputSaveBtn);
	}	
	public WebElement getmpRenameListName() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpRenameListName));
		return driver.findElement(mpRenameListName);
	}	
	public WebElement getmpBackToList() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpBackToList));
		return driver.findElement(mpBackToList);
	}	
	public WebElement getmpSourceLocationList() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpSourceLocationList));
		return driver.findElement(mpSourceLocationList);
	}	
	public WebElement getmpDestinationLocationList() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpDestinationLocationList));
		return driver.findElement(mpDestinationLocationList);
	}	
	public WebElement getmpListName() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpListName));
		return driver.findElement(mpListName);
	}	

	

	public WebElement getmpalllists() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpalllists));
		return driver.findElement(mpalllists);
	}
	public WebElement getmpexistinglists() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpexistinglists));
		return driver.findElement(mpexistinglists);
	}
	public WebElement getmplisttab() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mplisttab));
		return driver.findElement(mplisttab);
	}
	public WebElement getmpnewlistbutton() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpnewlistbutton));
		return driver.findElement(mpnewlistbutton);
	}
	public WebElement getMoreBtnDeleteOptn_ATLPROD() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(moreBtnDeleteOptn_ATLPROD));
		return driver.findElement(moreBtnDeleteOptn_ATLPROD);
	}
	public WebElement getMoreBtnDeleteOptnExistingList_ATLPROD() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(moreBtnDeleteOptnExistingList_ATLPROD));
		return driver.findElement(moreBtnDeleteOptnExistingList_ATLPROD);
	}
	public WebElement getaddlistcreatebtn_ATLPROD() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(addlistcreatebtn_ATLPROD));
		return driver.findElement(addlistcreatebtn_ATLPROD);
	}
	public WebElement getmpManageEditListMoveBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpManageEditListMoveBtn));
		return driver.findElement(mpManageEditListMoveBtn);
	}
	public WebElement getmpManageEditListRemoveBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpManageEditListRemoveBtn));
		return driver.findElement(mpManageEditListRemoveBtn);
	}

	
	
	
	
}



