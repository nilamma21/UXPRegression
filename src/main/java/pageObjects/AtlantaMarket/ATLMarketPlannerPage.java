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
	By atlmpexistinglistname = By.xpath("//form/div[4]/div[5]/label"); //Locator for existing list name
	
	By atladdtoseselectedbtn = By.xpath("//input[@data-xpath='quickAdd.saveList']"); //Locator for Add to Selected button
	By listspagefavoritesmenu = By.xpath("//div[@class='imc-vertical-tabs-nav']/div[contains(text(),'Favorites')]"); //Locator for Favorites left menu
	By addlistcreatebtn = By.xpath("//div[@class = 'imc-vr--medium']/input[1]"); //Locator for Create button on Add List modal
	By addlistcreatebtn_ATLPROD = By.xpath("//div[@class = 'imc-vr--medium-alt']/input[1]"); //Locator for Create button on Add List modal
	By mplistsfavorites = By.xpath("//div[@class = 'imc-vertical-tabs-nav']/div[1]"); //Locator for Favorites tab
	By mplistsallsavedproduts = By.xpath("//div[@class = 'imc-vertical-tabs-nav']/a[2]"); //Locator for All Saved Products tab
	By mplistsallsavedexhibitors = By.xpath("//div[@class = 'imc-vertical-tabs-nav']/a[3]"); //Locator for All Saved Exhibitors tab
	By mplistsenentsandseminars = By.xpath("//div[@class = 'imc-vertical-tabs-nav']/a[4]"); //Locator for Events and Seminars tab
	By mplistsmanagelist = By.xpath("//div[@class = 'imc-gallery__item imc-vertical-tabs-content']"); //Locator for List details
	By mpduplicatelistbtn = By.xpath("//div[@class = 'imc-market-planner-list_row_right_column imc-content--epsilon']/span[1]"); //Locator for Duplicate List button
	By mpeditlistbtn = By.xpath("//div[@class = 'imc-market-planner-list_row_right_column imc-content--epsilon']/span[2]"); //Locator for Edit List button
	By mparrangelistbtn = By.xpath("//div[@class = 'imc-gallery__item imc-customlists-button-pad']/button[1]"); //Locator for Arrange List button
	By mpnewlistbtn = By.xpath("//div[@class = 'imc-gallery__item imc-customlists-button-pad']/button[2]"); //Locator for New List button
	By mpnewgrpbtn = By.xpath("//div[@class = 'imc-gallery__item imc-customlists-button-pad']/button[3]"); //Locator for New Group button
	
	
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
	By mpFilterByDropdown = By.xpath("(//div[@class='react-select__indicators css-1wy0on6'])[2]"); //Locator for FilterBy DropDown
	By mpSortByDropdown = By.xpath("(//div[@class='react-select__indicators css-1wy0on6'])[3]"); //Locator for SortBy DropDown
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

	By mpbookhotel = By.xpath("//div[@class = 'imc-card imc-loading-relative']/div[1]/a[1]"); //Locator for Book a Hotel option
	By mpfloorplans = By.xpath("//div[@class = 'imc-card imc-loading-relative']/div[2]/a[1]"); //Locator for Floor Plans option
	By mpexpdirectory = By.xpath("//div[@class = 'imc-card imc-loading-relative']/div[3]/a[1]"); //Locator for Exhibitor Directory option
	By mpsavedsearches = By.xpath("//div[@class = 'imc-card imc-loading-relative']/div[4]/a[1]"); //Locator for saved Searches option
	By mpmyinfo = By.xpath("//div[@class = 'imc-card imc-loading-relative']/div[5]/a[1]"); //Locator for My Info option

	By filterByList = By.xpath("//div[@class='react-select__menu-list css-11unzgr']/div"); //Locator for My Info option
	By listOfAllExh = By.xpath("//a[@class='imc-link--alt-darkred']"); //Locator for My Info option
	By filterBytxt = By.xpath("//div[contains(text(),'Filter By')]"); //Locator for Filter By
	By nameofElement = By.xpath("//div[@class='imc-market-planner-list--item-body-data-left']/div[1]"); //Locator for Filter By
	By listOfmngDropdownElements = By.xpath("//div[@class='react-select__menu-list css-11unzgr']/div"); //Locator for Filter By
	By allList = By.xpath("//div[@class='imc-market-planner-list_row_title']"); //List for all list
	By addCustomItem = By.xpath("//div[@class='imc-gallery__item market-planner--list-sidebar imc-breakpoint-display--hide-mobile']/div[3]/button[1]"); //Add custom item
	By customTitle = By.xpath("//div[@class='imc-addnote-modal__padded']/form[1]/div[2]/div[1]/input[1]"); //Add custom item Title
	By customDesc = By.xpath("//div[@class='imc-addnote-modal__padded']/form[1]/div[5]/div[1]/textarea[1]"); //Add custom item Desc
	By customItemsubmitBtn = By.xpath("//div[@class='imc-addnote-modal__padded']/form[1]/div[7]/input[1]"); //Add custom item Submit Btn
	
	

	By newlycreatedgroupname = By.xpath("//div[@class='group-container'][2]/div/div/div[1]/h5"); //Locator for Newly created group name
	By nogroupname = By.xpath("//div[@class='group-container'][1]/div/div/div[1]/h5"); //Locator for No Group name
	By createnewgrppopupclosebtn = By.xpath("//button[@class='imc-modal--close imc-button--modal-close imc-button--round']"); //Locator for Create new group popup close btn
	By atlmpduplicatelistoptns = By.xpath("//ul[@class='imc-market-planner-list']/li/div[2]/span[1]/a"); //Locator for Duplicate List options on Lists page
	By atlmpGrByExhCheckbox = By.xpath("//div[@class='imc-gallery imc-market-planner-list-display imc-vr--large']/div[2]/div[1]/div[1]/div[1]"); //Locator for Gr By CheckBox
	By atlmpListView = By.xpath("//div[@class='imc-gallery imc-market-planner-list-display imc-vr--large']/div[2]/div[1]/div[2]/button[1]"); //Locator for List View
	By atlmpGridView = By.xpath("//div[@class='imc-gallery imc-market-planner-list-display imc-vr--large']/div[2]/div[1]/div[2]/button[2]"); //Locator for Grid view
	By atlmpVerifyGridView = By.xpath("//img[@class='imc-saved-exhibitors__img-grid']"); //Locator for Grid view
	By atlmpVerifyListView = By.xpath("//div[@class='imc-gallery imc-saved-exhibitors__outer-row imc-market-planner-list--mobile-overlays-left']"); //Locator for Grid view
	By atlmpVerifyLocationLink = By.xpath("//a[@class='imc-link imc-link--alt-darkred']"); //Locator for Location Link
	By listOfAllGroups = By.xpath("//h5[@class='accordion__item__title']"); //Locator for list of gr
	By duplicateListErrorMsg = By.xpath("//div[@class='imc-vr--large']/ul/li[1]"); //Locator for Invalid Group msg
	By customItemHeader = By.xpath("//div[@class='modal-wrapper']/div[1]/div[1]/h2[1]"); //Locator for Title of custom Item header
	By listOfCustomItems = By.xpath("//div[@class='imc-type--body-6-ui imc-content--padded-medium-desktop imc-content--padded-medium-left']"); //Locator for List of custom Item 
	By cancelBtnCustomItem = By.xpath("//div[@class='imc-addnote-modal__padded']/form[1]/div[7]/button[1]"); //Locator for Cancel Btn custom Item
	By addNoteBtn = By.xpath("//div[@class='imc-gallery__item market-planner--list-sidebar imc-breakpoint-display--hide-mobile']/div[4]/div[1]/button[1]"); //Locator for Note Btn 
	By newAddedNote = By.xpath("//div[@class='imc-gallery__item market-planner--list-sidebar imc-breakpoint-display--hide-mobile']/div[5]/ul[1]/li[1]/a[1]"); //Locator for Note Btn
	By listOfAllNewAddedNotes = By.xpath("//a[@class='imc-link imc-type--body-4-ui']");//List of All notes
	By closeNotePopup = By.xpath("//button[@class='imc-modal--close imc-addnote-modal__close']");////Locator for close Note popup
	By allSavedExhibiorMenu = By.xpath("//div[@class='imc-vertical-tabs-nav']/a[contains(text(),'All Saved Exhibitors')]");////Locator for All Saved Exhibitors
	By allSavedProductMenu = By.xpath("//div[@class='imc-vertical-tabs-nav']/a[contains(text(),'All Saved Products')]");////Locator for All Saved Product
	By allEventsAndSeminarMenu = By.xpath("//div[@class='imc-vertical-tabs-nav']/a[contains(text(),'All Events And Seminars')]");////Locator for All Saved Events And Seminar
	By mpRegistrationTab = By.xpath("//div[@class='imc-section imc-market-planner-toolbar ']/div[1]/div[1]/div[2]/div[1]/a[4]");////Locator for Reg tab
	By mpRegisterNowBtn = By.xpath("//div[@class='imc-gallery__item']/div[1]/a[1]");////Locator for Reg Btn
	By mpSavedSearchesTab = By.xpath("//div[@class='imc-section imc-market-planner-toolbar ']/div[1]/div[1]/div[2]/div[1]/a[5]");////Locator for Saved Searches tab
	By mpSavedSearchesIcon = By.xpath("//div[@class='imc-vr--large']/section[1]/div[1]/div[1]/div[1]");////Locator for Saved Searches icon
	By mpSaveSearcheBtn = By.xpath("//div[@class='imc-vr--large']/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]");////Locator for Saved Searches Btn
	By atlmpSaveSearcheBtn = By.xpath("//button[@class='imc-button--muted-inverted imc-icon--bookmark imc-button--full-width']");////Locator for Saved Searches Btn
	
	By mpSaveSearcheNameInput = By.xpath("//div[@class='imc-modal--box imc-savesearchmodal']/form[1]/div[1]/input[1]");////Locator for Saved Searche input
	By mpSaveSearcheInputBtn = By.xpath("//div[@class='imc-modal--box imc-savesearchmodal']/form[1]/div[2]/input[1]");////Locator for Saved Searche input Btn
	By mplistOfAllSaveSearches = By.xpath("//a[@class='imc-link imc-link--alt-darkred imc-content--display-flex  imc-content--display-flex-center']");////Locator for list of all Saved Searche 
	By mplistSearcheAlert = By.xpath("//div[@class='imc-vr--large']/section[1]/span[1]/div[1]");////Locator for list Search name
	By mpConfirmDeleteBtn = By.xpath("//button[@class='imc-market-planner-quick-add-modal__submit-btn imc-button']");////Locator for Confim Delete
	By mp1stExhiName = By.xpath("//div[@class='imc-gallery__item']//div/li[1]/div[1]/div[1]/div[1]/a");////Locator for 1st exh name
	By mpAddToScheduledHeader = By.xpath("//div[@class='imc-modal--content imc-section imc-customlists-form']/h2[1]");////Locator for Add to Scheduled
	By mpSelectStartDateCalendar = By.xpath("//div[@class='imc-modal--content imc-section imc-customlists-form']/form[1]/div[2]/div[1]/div[2]/div[1]");////Locator for Calendr
	By mpCalendarNextMonthArrow = By.xpath("//div[@class='DayPicker-NavBar']/span[2]");////Locator for Calendr Next Month Arrow
	By mpListOfAllCalendarDays = By.xpath("//div[@class='DayPicker-Day']");////Locator for List Of Calendr days
	By mpSelectEndDateCalendar = By.xpath("//div[@class='imc-modal--content imc-section imc-customlists-form']/form[1]/div[2]/div[2]/div[2]/div[1]");////Locator for Calendr
	By mpSelectStartTime = By.xpath("//div[@class='imc-modal--content imc-section imc-customlists-form']/form[1]/div[2]/div[1]/div[2]/div[2]/select[1]");////Locator for Start Time
	By mpSelectEndTime = By.xpath("//div[@class='imc-modal--content imc-section imc-customlists-form']/form[1]/div[2]/div[2]/div[2]/div[2]/select[1]");////Locator for End Time
	By mpAddToScheduledSaveBtn = By.xpath("//div[@class='imc-gallery imc-vr--medium']/div[1]/input[1]");////Locator for Save Btn
	By mpmonthName = By.xpath("//div[@class='DayPicker-Months']/div[1]/div[1]/div[1]");////Locator for Month
	By mpListOfAllProds = By.xpath("//div[@class='imc-saved-exhibitors__contentItems__col2-1 imc-heading--h7 imc-heading--primary-medium imc-saved-exhibitors__name-title']/a");////Locator for List of all products
	
	By myinfotab = By.xpath("//div[@class = 'imc-mp-toolbar imc-breakpoint-display--hide-mobile']/a[3]"); //Locator for My Info tab
	By myinfoeditprofile = By.xpath("//div[@class = 'imc-gallery__item']/a[1]"); //Locator Edit Profile button under My Info
	By myinfonamepencil = By.xpath("//div[class = 'imc-formfield imc-content']/div[1]/p[2]/span[1]"); //Locator for Pencil for Name field 
	By myinfofirstname = By.xpath("//input[@name = 'firstName']"); //Locator for First Name text box
	By myinfolastname = By.xpath("//input[@name = 'lastName']"); //Locator for Last Name text box
	By myinfodiscardbtn = By.xpath("//div[@class = 'imc-profile']/form[1]/div[2]/button[1]"); //Locator for Discard button
	By myinfosavebutton = By.xpath("//div[@class = 'imc-profile']/form[1]/div[2]/input[1]"); //Locator for Submit button
	By myinfoemail = By.xpath("//p[@class = 'imc-section--margin-medium']/a[1]"); //Locator for Add Email button
	By myinfoemailcancelbtn = By.xpath("//div[@class = 'imc-section--margin-small']/button[1]"); //Locator for Cancel button for Add Email
	By myinfemailclosebtn = By.xpath("//button[@class = 'imc-modal--close']"); //Locator for X button on email form
	By myinfoemailtxtbox = By.xpath("//input[@name = 'newEmailAddress']"); //Locator for Email text box
	By myinfoverifybtn = By.xpath("//div[@class = 'inline-form']/input[1]"); //Locator for Verify button
	By myinfocompanynamepencil = By.xpath("//div[@class = 'imc-formfield imc-content ']/p[1]/span[1]"); //Locator for Company Name pencil
	By myinfocompnametxt = By.xpath("//input[@name = 'companyName']"); //Locator for Company Name text box
	By myinfodiscard2btn = By.xpath("//div[@class = 'imc-profile']/form[1]/div[2]/button[1]"); //Locator for Discard button for Company Name
	By myinfosave2btn = By.xpath("//div[@class = 'imc-profile']/form[1]/div[2]/input[1]"); //Locator for Discard button for Company Name
	By verifymyinfopage = By.xpath("//div[@class = 'imc-gallery__item imc-vertical-tabs-content']"); //Locator for my info verification
	By verifymyinfoname = By.xpath("//div[@class = 'imc-formfield imc-content']/div[[1]/p[2]"); //Locator for Name 
	By myinfonewemail = By.xpath("//div[@class = 'imc-vr--large imc-vr--smallmedium-desktop']/div[1]"); //Locator for newly added email address
	By myinfoverifycompanyname = By.xpath("//div[@class = 'imc-formfield imc-content ']/p[1]"); //Locator for newly added Company Name
	By myinfoverifyeditprofile = By.xpath("//div[@class = 'imc-profile']"); //Locator for edit profile verification
	By myinfomyinquiriestab = By.xpath("//div[@class = 'imc-vertical-tabs-nav']/a[1]"); //Locator for My Inquiries tab
	By myinfoverifymyinquiries = By.xpath("//div[@class = 'imc-gallery__item imc-vertical-tabs-content']"); //Locator for My Inquiries tab
	By noSavedSearchesMsg = By.xpath("	//div[@class='imc-gallery__item imc-vertical-tabs-content']/div[1]/ul[1]/span[1]"); //Locator for No saved Searches msg

	By checkBox = By.xpath("(//div[@class='imc-formfield imc-content imc-saved-exhibitors__chk-container']/label[1])[1]"); //Locator for Checkbox
	By fExhpName = By.xpath("//div[@class='imc-loading-relative']/div[4]/li[1]/div[1]/div[1]/div[1]/a[1]"); //Locator for Checkbox
	By ATLAttendTab = By.xpath("//div[@class='imc-section']/div[1]/div[3]/div[1]/a[1]"); //Locator for Attend Tab
	By ATLAttendTabEventBtn = By.xpath("//a[@href='#events']"); //Locator for Attend Tab
	By ATLAttendTabEventMenu = By.xpath("//a[@href='/Attend/Events']"); //Locator for Attend Tab
	By ATLIMCEvent = By.xpath("//div[@class='event-list imc-loading__anchor']/div[1]/p[1]"); //Locator for IMC event Tab
	By ATLExhibitorEvent = By.xpath("//div[@class='event-list imc-loading__anchor']/div[1]/p[2]"); //Locator for Exhibitor Event Tab

	By ATLUseSavedSearchDropDown = By.xpath("//select[@name = 'Saved Searches']"); //Locator for Use Saved Search drop down 
	By EditListAtListTab = By.xpath("//ul[@class = 'imc-market-planner-list']/li[1]/div[2]/span[2]/a[1]"); //Locator for Edit list link
	By MoreOption = By.xpath("(//div[@class = 'imc-hover-menu'])[4]"); //locator for More option
	By AddToSchedule = By.xpath("//div[@class='imc-hover-menu__content']"); //locator for Add To Schedule option
	By AtlAddToSchedule = By.xpath("//div[@class='imc-hover-menu__content']/span[4]/a[1]"); //locator for Add To Schedule option
	
	
	By favexhnamelist = By.xpath("//div[@class='imc-loading-relative']/div[3]/li/div/div/div/a"); //Locator for Favorite Exhibitor names list
	
	By favIconlist = By.xpath("//button[@class='imc-selectableicon ']"); //Locator for Favorite Icon list
	
	
	
	public ATLMarketPlannerPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	}
	public WebElement getAtlAddToSchedule() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AtlAddToSchedule));
		return driver.findElement(AtlAddToSchedule);
	}
	public List <WebElement> getfavIconlist() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(favIconlist));
		return driver.findElements(favIconlist);
	}
	public WebElement getatlmpSaveSearcheBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlmpSaveSearcheBtn));
		return driver.findElement(atlmpSaveSearcheBtn);
	}
	public WebElement getATLExhibitorEvent() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLExhibitorEvent));
		return driver.findElement(ATLExhibitorEvent);
	}
	public WebElement getATLIMCEvent() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLIMCEvent));
		return driver.findElement(ATLIMCEvent);
	}
	public WebElement getATLAttendTabEventMenu() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLAttendTabEventMenu));
		return driver.findElement(ATLAttendTabEventMenu);
	}

	public WebElement getATLAttendTabEventBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLAttendTabEventBtn));
		return driver.findElement(ATLAttendTabEventBtn);
	}
	public WebElement getATLAttendTab() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLAttendTab));
		return driver.findElement(ATLAttendTab);
	}
	public WebElement getfirstExhName() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(fExhpName));
		return driver.findElement(fExhpName);
	}
	public WebElement getcheckBox() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkBox));
		return driver.findElement(checkBox);
	}
	public WebElement getnoSavedSearchesMsg() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(noSavedSearchesMsg));
		return driver.findElement(noSavedSearchesMsg);
	}
	public List <WebElement> getmpListOfAllProds() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpListOfAllProds));
		return driver.findElements(mpListOfAllProds);
	}
	public WebElement getmpmonthName() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpmonthName));
		return driver.findElement(mpmonthName);
	}
	public WebElement getmpAddToScheduledSaveBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpAddToScheduledSaveBtn));
		return driver.findElement(mpAddToScheduledSaveBtn);
	}
	
	public WebElement getmpSelectEndTime() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpSelectEndTime));
		return driver.findElement(mpSelectEndTime);
	}
	public WebElement getmpSelectStartTime() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpSelectStartTime));
		return driver.findElement(mpSelectStartTime);
	}
	public WebElement getmpSelectEndDateCalendar() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpSelectEndDateCalendar));
		return driver.findElement(mpSelectEndDateCalendar);
	}
	public List <WebElement> getmpListOfAllCalendarDays() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpListOfAllCalendarDays));
		return driver.findElements(mpListOfAllCalendarDays);
	}
	public WebElement getmpCalendarNextMonthArrow() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpCalendarNextMonthArrow));
		return driver.findElement(mpCalendarNextMonthArrow);
	}
	public WebElement getmpSelectStartDateCalendar() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpSelectStartDateCalendar));
		return driver.findElement(mpSelectStartDateCalendar);
	}
	public WebElement getmpAddToScheduledHeader() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpAddToScheduledHeader));
		return driver.findElement(mpAddToScheduledHeader);
	}
	public WebElement getmpmp1stExhiName() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mp1stExhiName));
		return driver.findElement(mp1stExhiName);
	}
	public WebElement getmpConfirmDeleteBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpConfirmDeleteBtn));
		return driver.findElement(mpConfirmDeleteBtn);
	}
	public WebElement getmplistSearcheAlert() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mplistSearcheAlert));
		return driver.findElement(mplistSearcheAlert);
	}

	public List <WebElement> getmplistOfAllSaveSearches() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mplistOfAllSaveSearches));
		return driver.findElements(mplistOfAllSaveSearches);
	}
	public WebElement getmpSaveSearcheInputBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpSaveSearcheInputBtn));
		return driver.findElement(mpSaveSearcheInputBtn);
	}
	public WebElement getmpSaveSearcheNameInput() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpSaveSearcheNameInput));
		return driver.findElement(mpSaveSearcheNameInput);
	}
	public WebElement getmpSaveSearcheBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpSaveSearcheBtn));
		return driver.findElement(mpSaveSearcheBtn);
	}
	public WebElement getmpSavedSearchesIcon() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpSavedSearchesIcon));
		return driver.findElement(mpSavedSearchesIcon);
	}
	public WebElement mpSavedSearchesTab() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpSavedSearchesTab));
		return driver.findElement(mpSavedSearchesTab);
	}
	public WebElement getmpRegisterNowBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpRegisterNowBtn));
		return driver.findElement(mpRegisterNowBtn);
	}
	public WebElement getmpRegistrationTab() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpRegistrationTab));
		return driver.findElement(mpRegistrationTab);
	}
	public WebElement getallEventsAndSeminarMenu() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(allEventsAndSeminarMenu));
		return driver.findElement(allEventsAndSeminarMenu);
	}
	public WebElement getallSavedProductMenu() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(allSavedProductMenu));
		return driver.findElement(allSavedProductMenu);
	}
	public WebElement getallSavedExhibiorMenu() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(allSavedExhibiorMenu));
		return driver.findElement(allSavedExhibiorMenu);
	}
	public WebElement getcloseNotePopup() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(closeNotePopup));
		return driver.findElement(closeNotePopup);
	}
	public List <WebElement> getlistOfAllNewAddedNotes() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(listOfAllNewAddedNotes));
		return driver.findElements(listOfAllNewAddedNotes);
	}
	public WebElement getaddNoteBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(addNoteBtn));
		return driver.findElement(addNoteBtn);
	}
	public WebElement getcancelBtnCustomItem() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cancelBtnCustomItem));
		return driver.findElement(cancelBtnCustomItem);
	}
	public List <WebElement> getATLlistOfCustomItems() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(listOfCustomItems));
		return driver.findElements(listOfCustomItems);
	}
	public WebElement getcustomItemHeader() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(customItemHeader));
		return driver.findElement(customItemHeader);
	}
	
	public WebElement getDuplicateListErrorMsg() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(duplicateListErrorMsg));
		return driver.findElement(duplicateListErrorMsg);
	}
	public List <WebElement> atlmpVerifyLocationLink() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlmpVerifyLocationLink));
		return driver.findElements(atlmpVerifyLocationLink);
	}
	public List <WebElement> getAtlListOfAllGroups() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(listOfAllGroups));
		return driver.findElements(listOfAllGroups);
	}
	
	
	public WebElement getATLmpVerifyListView() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlmpVerifyListView));
		return driver.findElement(atlmpVerifyListView);
	}
	public WebElement getATLmpVerifyGridView() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlmpVerifyGridView));
		return driver.findElement(atlmpVerifyGridView);
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
		wait = new WebDriverWait (driver,30);
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

	

	public WebElement getmpbookhotel() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpbookhotel));
		return driver.findElement(mpbookhotel);
	}
	public WebElement getmpfloorplans() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpfloorplans));
		return driver.findElement(mpfloorplans);
	}
	public WebElement getmpexpdirectory() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpexpdirectory));
		return driver.findElement(mpexpdirectory);
	}
	public WebElement getmpsavedsearches() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpsavedsearches));
		return driver.findElement(mpsavedsearches);
	}
	public WebElement getmpmyinfo() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpmyinfo));
		return driver.findElement(mpmyinfo);
	}
	public WebElement getmpFilterByDropdown() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpFilterByDropdown));
		return driver.findElement(mpFilterByDropdown);
	}


	public List <WebElement> getfilterByList() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(filterByList));
		return driver.findElements(filterByList);
	}
	public List <WebElement> getlistOfAllExh() {
		wait = new WebDriverWait (driver,35);
		wait.until(ExpectedConditions.visibilityOfElementLocated(listOfAllExh));
		return driver.findElements(listOfAllExh);
	}

	public WebElement getNoGroupName() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(nogroupname));
		return driver.findElement(nogroupname);
	}
	public WebElement getNewlyCreatedGrpName() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(newlycreatedgroupname));
		return driver.findElement(newlycreatedgroupname);
	}
	public WebElement getCreateNewGrpPopupCloseBtn() {
		return driver.findElement(createnewgrppopupclosebtn);
	}
	public List<WebElement> getATLMPDuplicateListOptns() {
		return driver.findElements(atlmpduplicatelistoptns);

	}
	
	public WebElement getfilterBytxt() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(filterBytxt));
		return driver.findElement(filterBytxt);
	}
	public List <WebElement> getnameofElement() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(nameofElement));
		return driver.findElements(nameofElement);
	}
	public List <WebElement> getlistOfmngDropdownElements() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(listOfmngDropdownElements));
		return driver.findElements(listOfmngDropdownElements);
	}
	public List <WebElement> getallList() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(allList));
		return driver.findElements(allList);
	}
	public WebElement getAddCustomItem() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(addCustomItem));
		return driver.findElement(addCustomItem);
	}		
	public WebElement getCustomTitle() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(customTitle));
		return driver.findElement(customTitle);
	}		
	public WebElement getCustomDesc() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(customDesc));
		return driver.findElement(customDesc);
	}		
	public WebElement getCustomItemsubmitBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(customItemsubmitBtn));
		return driver.findElement(customItemsubmitBtn);
	}		
	public WebElement getmpSortByDropdown() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpSortByDropdown));
		return driver.findElement(mpSortByDropdown);
	}		
	public WebElement getAtlmpGrByExhCheckbox() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlmpGrByExhCheckbox));
		return driver.findElement(atlmpGrByExhCheckbox);
	}		
	public WebElement getatlmpListView() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlmpListView));
		return driver.findElement(atlmpListView);
	}		
	public WebElement getatlmpGridView() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlmpGridView));
		return driver.findElement(atlmpGridView);
	}		
	public WebElement getmyinfotab() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(myinfotab));
		return driver.findElement(myinfotab);
	}		
	public WebElement getmyinfoeditprofile() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(myinfoeditprofile));
		return driver.findElement(myinfoeditprofile);
	}	
	public WebElement getmyinfonamepencil() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(myinfonamepencil));
		return driver.findElement(myinfonamepencil);
	}	
	public WebElement getmyinfofirstname() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(myinfofirstname));
		return driver.findElement(myinfofirstname);
	}	
	public WebElement getmyinfolastname() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(myinfolastname));
		return driver.findElement(myinfolastname);
	}	
	public WebElement getmyinfodiscardbtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(myinfodiscardbtn));
		return driver.findElement(myinfodiscardbtn);
	}	
	public WebElement getmyinfosavebutton() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(myinfosavebutton));
		return driver.findElement(myinfosavebutton);
	}	
	public WebElement getmyinfoemail() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(myinfoemail));
		return driver.findElement(myinfoemail);
	}	
	public WebElement getmyinfoemailcancelbtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(myinfoemailcancelbtn));
		return driver.findElement(myinfoemailcancelbtn);
	}	
	public WebElement getmyinfemailclosebtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(myinfemailclosebtn));
		return driver.findElement(myinfemailclosebtn);
	}	
	public WebElement getmyinfoemailtxtbox() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(myinfoemailtxtbox));
		return driver.findElement(myinfoemailtxtbox);
	}	
	
	public WebElement getmyinfoverifybtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(myinfoverifybtn));
		return driver.findElement(myinfoverifybtn);
	}	
	public WebElement getmyinfocompanynamepencil() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(myinfocompanynamepencil));
		return driver.findElement(myinfocompanynamepencil);
	}	
	public WebElement getmyinfocompnametxt() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(myinfocompnametxt));
		return driver.findElement(myinfocompnametxt);
	}	
	public WebElement getmyinfodiscard2btn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(myinfodiscard2btn));
		return driver.findElement(myinfodiscard2btn);
	}	
	public WebElement getmyinfosave2btn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(myinfosave2btn));
		return driver.findElement(myinfosave2btn);
	}	

	public WebElement getverifymyinfoname() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(verifymyinfoname));
		return driver.findElement(verifymyinfoname);
	}
	public WebElement getmyinfonewemail() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(myinfonewemail));
		return driver.findElement(myinfonewemail);
	}
	public WebElement getmyinfoverifycompanyname() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(myinfoverifycompanyname));
		return driver.findElement(myinfoverifycompanyname);
	}			
	public WebElement getverifymyinfopage() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(verifymyinfopage));
		return driver.findElement(verifymyinfopage);
	}
	public WebElement getmyinfoverifyeditprofile() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(myinfoverifyeditprofile));
		return driver.findElement(myinfoverifyeditprofile);
	}
	public WebElement getmyinfomyinquiriestab() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(myinfomyinquiriestab));
		return driver.findElement(myinfomyinquiriestab);
	}
	public WebElement getmplistsfavorites() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mplistsfavorites));
		return driver.findElement(mplistsfavorites);
	}
	public WebElement getmplistsallsavedproduts() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mplistsallsavedproduts));
		return driver.findElement(mplistsallsavedproduts);
	}
	public WebElement getmplistsallsavedexhibitors() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mplistsallsavedexhibitors));
		return driver.findElement(mplistsallsavedexhibitors);
	}
	public WebElement getmplistsenentsandseminars() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mplistsenentsandseminars));
		return driver.findElement(mplistsenentsandseminars);
	}
	public WebElement getmplistsmanagelist() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mplistsmanagelist));
		return driver.findElement(mplistsmanagelist);
	}
	public WebElement getmpduplicatelistbtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpduplicatelistbtn));
		return driver.findElement(mpduplicatelistbtn);
	}
	public WebElement getmpeditlistbtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpeditlistbtn));
		return driver.findElement(mpeditlistbtn);
	}
	public WebElement getmparrangelistbtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mparrangelistbtn));
		return driver.findElement(mparrangelistbtn);
	}
	public WebElement getmpnewlistbtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpnewlistbtn));
		return driver.findElement(mpnewlistbtn);
	}
	public WebElement getmpnewgrpbtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpnewgrpbtn));
		return driver.findElement(mpnewgrpbtn);
	}
	public WebElement getmyinfoverifymyinquiries() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(myinfoverifymyinquiries));
		return driver.findElement(myinfoverifymyinquiries);
	}
	public WebElement getATLUseSavedSearchDropDown() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLUseSavedSearchDropDown));
		return driver.findElement(ATLUseSavedSearchDropDown);
	}
	public WebElement getEditListAtListTab() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EditListAtListTab));
		return driver.findElement(EditListAtListTab);
	}
	public WebElement getMoreOption() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(MoreOption));
		return driver.findElement(MoreOption);
	}
	public WebElement getAddToSchedule() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AddToSchedule));
		return driver.findElement(AddToSchedule);
	}
	
	public List <WebElement> getFavoriteExhibitorNames() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(favexhnamelist));
		return driver.findElements(favexhnamelist);
	}
	

	
}



