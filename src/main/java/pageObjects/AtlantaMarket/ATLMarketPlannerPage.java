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
	By editlistitemmorebtn = By.xpath("//li[@class='imc-list-edit--draggable'][1]/div/div/div[4]/div/button"); //Locator for More button of 1st list item
	By editlistitemdeleteoptn = By.xpath("//li[@class='imc-list-edit--draggable'][1]/div/div/div[4]/div/div/span[3]/a"); //Locator for Delete Option of 1st list item
	By createnewlistnametxtbx = By.xpath("//input[@name='listName']"); //Locator for List name text field on Create new list modal
	By newlistmodalcreatebtn = By.xpath("(//input[@type='submit'])[position()=2]"); //Locator for Create btn on Create new list modal
	By gotomarketplannerbtn = By.xpath("//a[contains(text(),'Go to Market Planner')]"); //Locator for Go to Market Planner button
	By mphomeliststab = By.xpath("//div[@class='imc-mp-toolbar imc-breakpoint-display--hide-mobile']/a[2]"); //Locator for Lists tab on MP Home
	By listspagelistsmenu = By.xpath("//div[@class='imc-vertical-tabs-nav']/a[1]"); //Locator for Lists left menu
	By atlmplistsnames = By.xpath("//ul[@class='imc-market-planner-list']/li/div[1]"); //Locator for the List names of MP lists
	By atlmpeditlistoptns = By.xpath("//ul[@class='imc-market-planner-list']/li/div[2]/span[2]/a"); //Locator for Edit List options on Lists page
	By atlmpexistinglistname = By.xpath("//form/div[4]/div[1]/label"); //Locator for existing list name
	By atladdtoseselectedbtn = By.xpath("//input[@data-xpath='quickAdd.saveList']"); //Locator for Add to Selected button
	By listspagefavoritesmenu = By.xpath("//div[@class='imc-vertical-tabs-nav']/div[contains(text(),'Favorites')]"); //Locator for Favorites left menu
	By addlistcreatebtn = By.xpath("//input[@value='Create']"); //Locator for Create button on Add List modal
	By savedproductnameinlist = By.xpath("//li[@class='imc-list-edit--draggable'][1]/div/div[3]/div/div/div/div/a"); //Locator for Saved Product Name in List
			
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
	
	
}



