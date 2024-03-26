package pageObjects.Sitecore;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SCDigitalAdminPanelPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By digitalAdminPanel = By.xpath("//div[@class='sc-launchpad']/div[1]/div[1]/a[1]/span[2]"); // Locator for Digital Admin Panel
	By digitalAdminPanelSearch1stEmail = By.xpath("//table[@class='table table-bordered']/tbody[1]/tr[1]/td[2]"); // Locator for 1st Email id
	By digitalAdminPanelSearchBox = By.xpath("//div[@class='sc-applicationHeader-actions']/div[1]/input[1]"); // Locator for Search box
	By digitalAdminPanelSearchButton = By.xpath("//div[@class='sc-applicationHeader-actions']/div[1]/button[1]"); // Locator for Search Buttn
	By digitalAdminPanelSortByButton = By.xpath("//div[@class='sc-applicationHeader-actions']/div[1]/div[1]/button[1]"); // Locator for SortBy Buttn
	By digitalAdminPanelListSortByOptions = By.xpath("//div[@id='dropdown-sort']/div"); // Locator for List of SortBy options _ FilterBy
	By digitalAdminPanelResultList = By.xpath("//table[@class='table table-bordered']/tbody/tr/td[2]");   //Digital Identity List
	By digitalAdminPanelLastNameList = By.xpath("//table[@class='table table-bordered']/tbody/tr/td[4]");  //Last Name list
	By digitalAdminPanelFilterByButton = By.xpath("//div[@class='sc-applicationHeader-actions']/div[1]/div[2]/button[1]"); // Locator for FilterBy Buttn
	By digitalAdminPanelAssociatedExhibitorList = By.xpath("//table[@class='table table-bordered']/tbody/tr/td[5]"); // Locator for FilterBy Buttn
	By digitalAdminPanelActionButton = By.xpath("//div[@class='sc-applicationHeader-actions']/div[4]/button[1]"); // Locator for Action Buttn																							
	By digitalAdminPanelActionEnable = By.xpath("//div[@class='sc-applicationHeader-actions']/div[4]/div[1]/div[1]"); // Locator for Action Enable
	By digitalAdminPanelActionDisable = By.xpath("//div[@class='sc-applicationHeader-actions']/div[4]/div[1]/div[2]"); // Locator for Action Disable
	By digitalAdminPanelActionDelete = By.xpath("//div[@class='sc-applicationHeader-actions']/div[4]/div[1]/div[3]"); // Locator for Action Delete
	By digitalAdminPanelListOfActionOptions = By.xpath("//div[@class='sc-applicationHeader-actions']/div[4]/div[1]/div"); // Locator for List of Action Buttn options
	By digitalAdminPanelCreateUserButton = By.xpath("//div[@class='sc-applicationHeader-actions']/div[5]/../button"); // Locator for Create User Button
	By digitalAdminPanelCreateUserPopup = By.xpath("//div[@class='sc-applicationHeader-actions']/div[3]/div/form/h3"); // Locator for Create User Button
	By digitalAdminPanelCreateUserFirstName = By.xpath("//div[@class='sc-applicationHeader-actions']/div[3]/div/form/input[1]"); // Locator for  first Name
	By digitalAdminPanelCreateUserLastName = By.xpath("//div[@class='sc-applicationHeader-actions']/div[3]/div/form/input[2]"); // Locator for  Last Name
	By digitalAdminPanelCreateUserEmail = By.xpath("//div[@class='sc-applicationHeader-actions']/div[3]/div/form/input[3]"); // Locator for Email Name
	By digitalAdminPanelCreateUserCancel = By.xpath("//div[@class='sc-applicationHeader-actions']/div[3]/div/form/input[4]"); // Locator for Cancel
	By digitalAdminPanelCreateUserSend = By.xpath("//div[@class='sc-applicationHeader-actions']/div[3]/div/form/input[5]"); // Locator for Send
	By digitalAdminPanelUserProfile = By.xpath("//div[@class='navbar-form right']/a"); // Locator for User Profile Btn
	By digitalAdminPanelCreateUserSendBtnErrorMsg = By.xpath("//div[@class='sc-applicationHeader-actions']/div[3]/div/form/div/p"); // Locator for Error msg
	By digitalAdminPanelHomePageHeader = By.xpath("//div[@class='sc-applicationHeader-title']/span"); // Locator for Home Page header
	By digitalAdminPanelHomePageFirstCheckbox = By.xpath("//table[@class='table table-bordered']/tbody/tr/td[1]"); // Locator for Home Page header First check box
	By digitalAdminPanelHomePageIsActiveStatus = By.xpath("//table[@class='table table-bordered']/tbody/tr/td[6]"); // Locator for Home Page Is Active Status
	By SCLaunchPad = By.xpath("//div[@class='container-narrow']/header/div/div/div/a[1]"); // Locator for Launch Pad
	By digitalAdminPanelHomePageAssociatedExhibitors = By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[5]"); // Locator for Launch Pad
	
	
	public SCDigitalAdminPanelPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	public WebElement getdigitalAdminPanelHomePageAssociatedExhibitors() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelHomePageAssociatedExhibitors));
		return driver.findElement(digitalAdminPanelHomePageAssociatedExhibitors);
	}
	public WebElement getSCLaunchPad() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(SCLaunchPad));
		return driver.findElement(SCLaunchPad);
	}
	public WebElement getdigitalAdminPanelHomePageIsActiveStatus() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelHomePageIsActiveStatus));
		return driver.findElement(digitalAdminPanelHomePageIsActiveStatus);
	}

	public WebElement getdigitalAdminPanelHomePageFirstCheckbox() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelHomePageFirstCheckbox));
		return driver.findElement(digitalAdminPanelHomePageFirstCheckbox);
	}
	public WebElement getdigitalAdminPanelHomePageHeader() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelHomePageHeader));
		return driver.findElement(digitalAdminPanelHomePageHeader);
	}
	public WebElement getdigitalAdminPanelCreateUserSendBtnErrorMsg() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelCreateUserSendBtnErrorMsg));
		return driver.findElement(digitalAdminPanelCreateUserSendBtnErrorMsg);
	}
	public WebElement getdigitalAdminPanelUserProfile() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelUserProfile));
		return driver.findElement(digitalAdminPanelUserProfile);
	}
	public WebElement getdigitalAdminPanelCreateUserSend() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelCreateUserSend));
		return driver.findElement(digitalAdminPanelCreateUserSend);
	}
	public WebElement getdigitalAdminPanelCreateUserCancel() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelCreateUserCancel));
		return driver.findElement(digitalAdminPanelCreateUserCancel);
	}
	public WebElement getdigitalAdminPanelCreateUserFirstName() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelCreateUserFirstName));
		return driver.findElement(digitalAdminPanelCreateUserFirstName);
	}
	public WebElement getdigitalAdminPanelCreateUserEmail() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelCreateUserEmail));
		return driver.findElement(digitalAdminPanelCreateUserEmail);
	}
	public WebElement getdigitalAdminPanelCreateUserLastName() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelCreateUserLastName));
		return driver.findElement(digitalAdminPanelCreateUserLastName);
	}
	public WebElement getdigitalAdminPanelCreateUserPopup() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelCreateUserPopup));
		return driver.findElement(digitalAdminPanelCreateUserPopup);
	}
	public WebElement getdigitalAdminPanelCreateUserButton() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelCreateUserButton));
		return driver.findElement(digitalAdminPanelCreateUserButton);
	}
	public List <WebElement> getdigitalAdminPanelListOfActionOptions() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(digitalAdminPanelListOfActionOptions));
		return driver.findElements(digitalAdminPanelListOfActionOptions);
	}
	public WebElement getdigitalAdminPanelActionDelete() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelActionDelete));
		return driver.findElement(digitalAdminPanelActionDelete);
	}
	public WebElement getdigitalAdminPanelActionEnable() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelActionEnable));
		return driver.findElement(digitalAdminPanelActionEnable);
	}
	public WebElement getdigitalAdminPanelActionDisable() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelActionDisable));
		return driver.findElement(digitalAdminPanelActionDisable);
	}
	
	public WebElement getdigitalAdminPanelActionButton() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelActionButton));
		return driver.findElement(digitalAdminPanelActionButton);
	}
	public List <WebElement> getdigitalAdminPanelAssociatedExhibitorList() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(digitalAdminPanelAssociatedExhibitorList));
		return driver.findElements(digitalAdminPanelAssociatedExhibitorList);
	}
	public WebElement getdigitalAdminPanelFilterByButton() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelFilterByButton));
		return driver.findElement(digitalAdminPanelFilterByButton);
	}
	public List <WebElement> getdigitalAdminPanelLastNameList() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(digitalAdminPanelLastNameList));
		return driver.findElements(digitalAdminPanelLastNameList);
	}
	public List <WebElement> getdigitalAdminPanelResultList() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(digitalAdminPanelResultList));
		return driver.findElements(digitalAdminPanelResultList);
	}
	public List <WebElement> getdigitalAdminPanelListSortByOptions() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(digitalAdminPanelListSortByOptions));
		return driver.findElements(digitalAdminPanelListSortByOptions);
	}
	public WebElement getdigitalAdminPanelSortByButton() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelSortByButton));
		return driver.findElement(digitalAdminPanelSortByButton);
	}
	public WebElement getdigitalAdminPanelSearchButton() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelSearchButton));
		return driver.findElement(digitalAdminPanelSearchButton);
	}
	public WebElement getdigitalAdminPanelSearchBox() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelSearchBox));
		return driver.findElement(digitalAdminPanelSearchBox);
	}
	public WebElement getdigitalAdminPanelSearch1stEmail() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelSearch1stEmail));
		return driver.findElement(digitalAdminPanelSearch1stEmail);
	}
	public WebElement getDigitalAdminPanel() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanel));
		return driver.findElement(digitalAdminPanel);
	}

}
