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
	By atlmpexistinglistname = By.xpath("//form/div[4]/div[3]/label"); //Locator for existing list name
	By atladdtoseselectedbtn = By.xpath("//input[@data-xpath='quickAdd.saveList']"); //Locator for Add to Selected button
	By listspagefavoritesmenu = By.xpath("//div[@class='imc-vertical-tabs-nav']/div[contains(text(),'Favorites')]"); //Locator for Favorites left menu
	By addlistcreatebtn = By.xpath("(//input[@type='submit'])[position()=3]"); //Locator for Create button on Add List modal
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
	
	By mpListNewGroupCreateBtn = By.xpath("//div[@class='imc-modal--content imc-section imc-customlists-form']/form[1]/div[2]/div[2]/input[1]"); //Locator for new Group Create Btn
	By mpListNewSelectGroupDropdown = By.xpath("//select[@name='groupName']"); //Locator for Grou Dorpdown
	By mpListNewCreateBtn = By.xpath("//div[@class='imc-modal--content imc-section imc-customlists-form']/form[1]/div[2]/div[3]/input[1]"); //Locator for Create Btn
	
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

	
}



