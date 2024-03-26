package pageObjects.Sitecore;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SCDigitalAdminPanelUserProfilePage {

	public WebDriver driver;
	public WebDriverWait wait;

	By digitalAdminPanelUserProfilePageEmailId = By.xpath("//div[@class='panel panel-body']/h2[@id='mail']"); // Locator for User Profile page email id
	By digitalAdminPanelUserProfilePagePasswordResetCTA = By.xpath("//div[@class='sc-applicationHeader-contextSwitcher']/div[3]/button"); // Locator for User Profile page Password Reset CTA
	By digitalAdminPanelUserProfilePagePasswordResetCTAPopupMsg = By.xpath("//div[@id='popup']/div/form/p"); // Locator for User Profile page Password Reset CTA
	By digitalAdminPanelUserProfilePagePasswordResetPopupMsgCancelCTA = By.xpath("//div[@id='popup']/div/form/input[1]"); // Locator for User Profile page Password Reset CTA
	By digitalAdminPanelUserProfilePagePasswordResetPopupMsgSendCTA = By.xpath("//div[@id='popup']/div/form/input[2]"); // Locator for User Profile page Password Reset CTA
	By digitalAdminPanelMsgPanel = By.xpath("//div[@id='messagePanel']/p[1]"); // Locator for User Profile message panel
	By digitalAdminPanelEditUser = By.xpath("//div[@class='panel panel-body']/a[1]"); // Locator for User Profile Edit info
	By digitalAdminPanelEditUserPopup = By.xpath("//div[@id='popup']/div[1]/form"); // Locator for User Profile Edit info Poupup
	By digitalAdminPanelEditUserFname = By.xpath("//div[@id='popup']/div[1]/form/input[@name='firstName']"); // Locator for User Profile Edit F name
	By digitalAdminPanelEditUserLname = By.xpath("//div[@id='popup']/div[1]/form/input[@name='lastName']"); // Locator for User Profile Edit L name
	By digitalAdminPanelEditUserCname = By.xpath("//div[@id='popup']/div[1]/form/input[@name='companyName']"); // Locator for User Profile Edit C Name
	By digitalAdminPanelEditUserCancelCTA = By.xpath("//div[@id='popup']/div[1]/form/input[@value='Cancel']"); // Locator for User Profile Edit Cancel CTA
	By digitalAdminPanelEditUserSendCTA = By.xpath("//div[@id='popup']/div[1]/form/input[@value='Send']"); // Locator for User Profile Edit Send CTA
	By digitalAdminPanelUpdatedUserName = By.xpath("//div[@class='sc-navigation-content']/section/div[4]/h1"); // Locator for User Profile Updated User name
	By digitalAdminPanelUpdatedComapanyName = By.xpath("//div[@class='sc-navigation-content']/section/div[4]/div[2]"); // Locator for User Profile Updated User name
	By digitalAdminPanelAddCTA = By.xpath("//div[@class='sc-navigation-content']/section/div[6]/button[1]"); // Locator for User Profile Add CTA
	By digitalAdminPanelAddPopup = By.xpath("//div[@id='popup']/div/h2[contains(text(),'Associate Account with an Exhibitor')]"); // Locator for User Profile Add Popup
	By digitalAdminPanelAddPopupDiscard = By.xpath("//div[@id='popup']/div/form/input[@value='Discard']"); // Locator for User Profile Add Popup discard CTA
	By digitalAdminPanelAddPopupExhibitoName = By.xpath("//div[@id='popup']/div/input[1]"); // Locator for User Profile Add Popup Exh name
	By digitalAdminPanelAddPopupSelectExhibitoName = By.xpath("//div[@id='popup']/div/div[2]/div[1]/p[1]"); // Locator for User Profile Add Popup select Exh from suggetions
	By digitalAdminPanelAddPopupSelectAdminRadio = By.xpath("//div[@id='popup']/div[1]/form[1]/div[2]/label[1]"); // Locator for User Profile Add Popup select Exh from suggetions
	By digitalAdminPanelAddPopupSelectEditorRadio = By.xpath("//div[@id='popup']/div[1]/form[1]/div[2]/label[2]"); // Locator for User Profile Add Popup select Exh from suggetions
	By digitalAdminPanelAddPopupAdd = By.xpath("//div[@id='popup']/div/form/input[@value='Add']"); // Locator for User Profile Add Popup discard CTA
	By digitalAdminPanelListOfAddedExhibitors = By.xpath("//div[@class='sc-list']/div[1]/section/div[1]/div/section/div[6]/table/tbody/tr/td[1]"); // Locator for List Of all added exhibitors
	By digitalAdminPanelBackLink = By.xpath("//div[@class='container-narrow']/section/div/nav/div/a[1]"); // Locator for Back Link
	By digitalAdminPanelRemoveAddedExh = By.xpath("//div[@class='sc-list']/div[1]/section/div[1]/div/section/div[6]/table/tbody/tr[1]/td/button[1]"); // Locator for Remove added exh
	By digitalAdminPanelExhibitorError = By.xpath("//div[@class='exhibit-cart']/p[1]"); // Locator for Remove added exh
	By digitalAdminPanelDisabledAddCTA = By.xpath("//input[@id='associate-exhibitors' and @disabled='disabled']"); // Locator for Remove added exh
	By digitalAdminPanelDoesntHaveLeaseCTA = By.xpath("//div[@class='radio-toolbar']/label[2]"); // Locator for Remove added exh
	By digitalAdminPanelSelectDropdown = By.xpath("(//select[@name='channelName'])[1]"); // Locator for Select Dropdown
	
	public SCDigitalAdminPanelUserProfilePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	public WebElement getdigitalAdminPanelSelectDropdown() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelSelectDropdown));
		return driver.findElement(digitalAdminPanelSelectDropdown);
	}
	public WebElement getdigitalAdminPanelDoesntHaveLeaseCTA() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelDoesntHaveLeaseCTA));
		return driver.findElement(digitalAdminPanelDoesntHaveLeaseCTA);
	}
	public WebElement getdigitalAdminPanelDisabledAddCTA() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelDisabledAddCTA));
		return driver.findElement(digitalAdminPanelDisabledAddCTA);
	}
	public WebElement getdigitalAdminPanelExhibitorError() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelExhibitorError));
		return driver.findElement(digitalAdminPanelExhibitorError);
	}
	public WebElement getdigitalAdminPanelRemoveAddedExh() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelRemoveAddedExh));
		return driver.findElement(digitalAdminPanelRemoveAddedExh);
	}
	public WebElement getdigitalAdminPanelBackLink() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelBackLink));
		return driver.findElement(digitalAdminPanelBackLink);
	}
	public List <WebElement> getdigitalAdminPanelListOfAddedExhibitors() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(digitalAdminPanelListOfAddedExhibitors));
		return driver.findElements(digitalAdminPanelListOfAddedExhibitors);
	}
	public WebElement getdigitalAdminPanelAddPopupAdd() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelAddPopupAdd));
		return driver.findElement(digitalAdminPanelAddPopupAdd);
	}
	public WebElement getdigitalAdminPanelAddPopupSelectEditorRadio() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelAddPopupSelectEditorRadio));
		return driver.findElement(digitalAdminPanelAddPopupSelectEditorRadio);
	}
	public WebElement getdigitalAdminPanelAddPopupSelectAdminRadio() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelAddPopupSelectAdminRadio));
		return driver.findElement(digitalAdminPanelAddPopupSelectAdminRadio);
	}
	
	public WebElement getdigitalAdminPanelAddPopupSelectExhibitoName() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelAddPopupSelectExhibitoName));
		return driver.findElement(digitalAdminPanelAddPopupSelectExhibitoName);
	}
	public WebElement getdigitalAdminPanelAddPopupExhibitoName() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelAddPopupExhibitoName));
		return driver.findElement(digitalAdminPanelAddPopupExhibitoName);
	}
	public WebElement getdigitalAdminPanelAddPopupDiscard() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelAddPopupDiscard));
		return driver.findElement(digitalAdminPanelAddPopupDiscard);
	}
	public WebElement getdigitalAdminPanelAddCTA() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelAddCTA));
		return driver.findElement(digitalAdminPanelAddCTA);
	}
	public WebElement getdigitalAdminPanelAddPopup() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelAddPopup));
		return driver.findElement(digitalAdminPanelAddPopup);
	}
	public WebElement getdigitalAdminPanelUpdatedComapanyName() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelUpdatedComapanyName));
		return driver.findElement(digitalAdminPanelUpdatedComapanyName);
	}
	public WebElement getdigitalAdminPanelUpdatedUserName() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelUpdatedUserName));
		return driver.findElement(digitalAdminPanelUpdatedUserName);
	}
	public WebElement getdigitalAdminPanelEditUserFname() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelEditUserFname));
		return driver.findElement(digitalAdminPanelEditUserFname);
	}
	public WebElement getdigitalAdminPanelEditUserLname() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelEditUserLname));
		return driver.findElement(digitalAdminPanelEditUserLname);
	}
	public WebElement getdigitalAdminPanelEditUserCname() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelEditUserCname));
		return driver.findElement(digitalAdminPanelEditUserCname);
	}
	public WebElement getdigitalAdminPanelEditUserCancelCTA() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelEditUserCancelCTA));
		return driver.findElement(digitalAdminPanelEditUserCancelCTA);
	}
	public WebElement getdigitalAdminPanelEditUserSendCTA() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelEditUserSendCTA));
		return driver.findElement(digitalAdminPanelEditUserSendCTA);
	}
	public WebElement getdigitalAdminPanelEditUserPopup() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelEditUserPopup));
		return driver.findElement(digitalAdminPanelEditUserPopup);
	}
	public WebElement getdigitalAdminPanelEditUser() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelEditUser));
		return driver.findElement(digitalAdminPanelEditUser);
	}
	public WebElement getdigitalAdminPanelMsgPanel() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelMsgPanel));
		return driver.findElement(digitalAdminPanelMsgPanel);
	}
	public WebElement getdigitalAdminPanelUserProfilePagePasswordResetPopupMsgCancelCTA() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelUserProfilePagePasswordResetPopupMsgCancelCTA));
		return driver.findElement(digitalAdminPanelUserProfilePagePasswordResetPopupMsgCancelCTA);
	}
	public WebElement getdigitalAdminPanelUserProfilePagePasswordResetPopupMsgSendCTA() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelUserProfilePagePasswordResetPopupMsgSendCTA));
		return driver.findElement(digitalAdminPanelUserProfilePagePasswordResetPopupMsgSendCTA);
	}
	public WebElement getdigitalAdminPanelUserProfilePagePasswordResetCTAPopupMsg() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelUserProfilePagePasswordResetCTAPopupMsg));
		return driver.findElement(digitalAdminPanelUserProfilePagePasswordResetCTAPopupMsg);
	}
	public WebElement getdigitalAdminPanelUserProfilePagePasswordResetCTA() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelUserProfilePagePasswordResetCTA));
		return driver.findElement(digitalAdminPanelUserProfilePagePasswordResetCTA);
	}
	public WebElement getdigitalAdminPanelUserProfilePageEmailId() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelUserProfilePageEmailId));
		return driver.findElement(digitalAdminPanelUserProfilePageEmailId);
	}
}
