package pageObjects.LasVegasMarket;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LVMLoginPage {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	By emailaddress = By.xpath("//input[@id='signInName']"); //Locator for field to enter Email Address from Login Page
	By password= By.xpath("//input[@id='password']"); //Locator for field to enter Password from Login Page
	By signinbtn= By.xpath("//button[@id='next']"); //Locator for field to click on Sign In button from Login Page
	By listOfAllExhibitors= By.xpath("//div[contains(@class,'EPHeader_exTable__ZVkAP')]/table/tr/td/a"); //Locator for field to click on Sign In button from Login Page
	By EXPYourDigiShowroom = By.xpath("//div[@id = 'root']/header[1]/div[1]/div[1]/div[1]/span[1]"); // Locator for Your Digi Showroom tab
	By EXPProfileInfo = By.xpath("//header[@class='EPHeader_header__MLVPr']/div/nav/div/div[2]/div/a");
	
	By EXPProfileInfoStyleElement = By.xpath("//div[contains(text(),'Styles')]/../div[2]/div/span[2]");
	By SCDigitalAdminPanel = By.xpath("//a[@title = 'Digital Admin Panel']"); //Locator for Digital Admin Panel option
	By SCDigitalAdminPanelSearchField = By.xpath("//input[@placeholder='Search']"); //Locator for Digital Admin Panel option
	By SCDigitalAdminPanelSearchButton= By.xpath("//button[@class='btn search-btn button-primary']"); //Locator for Digital Admin Panel option
	By SCDigitalAdminPanelOpenUserProf= By.xpath("//td[contains(text(),'swapnili@cybage.com')]");
	By SCDigitalAdminPanelUserProfAddButton= By.xpath("//button[contains(text(),'Add')]");
	
	
	public LVMLoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 
	public WebElement getSCDigitalAdminPanelUserProfAddButton() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(SCDigitalAdminPanelUserProfAddButton));
		return driver.findElement(SCDigitalAdminPanelUserProfAddButton);
	}
	public WebElement getSCDigitalAdminPanelOpenUserProf() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(SCDigitalAdminPanelOpenUserProf));
		return driver.findElement(SCDigitalAdminPanelOpenUserProf);
	}
	public WebElement getSCDigitalAdminPanelSearchButton() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(SCDigitalAdminPanelSearchButton));
		return driver.findElement(SCDigitalAdminPanelSearchButton);
	}
	public WebElement getSCDigitalAdminPanelSearchField() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(SCDigitalAdminPanelSearchField));
		return driver.findElement(SCDigitalAdminPanelSearchField);
	}
	public WebElement getSCDigitalAdminPanel() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(SCDigitalAdminPanel));
		return driver.findElement(SCDigitalAdminPanel);
	}
	public List<WebElement> getEXPProfileInfoStyleElement() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(EXPProfileInfoStyleElement));
		return driver.findElements(EXPProfileInfoStyleElement);
	}
	public WebElement getEXPProfileInfo() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(EXPProfileInfo));
		return driver.findElement(EXPProfileInfo);
	}
	public WebElement getEXPYourDigiShowroom() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(EXPYourDigiShowroom));
		return driver.findElement(EXPYourDigiShowroom);
	}
	public List<WebElement> getlistOfAllExhibitors() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(listOfAllExhibitors));
		return driver.findElements(listOfAllExhibitors);
	}
	public WebElement getEmailAddress() {
		//Wait till Sign In page is displayed
		return driver.findElement(emailaddress);		
	}
	
	public WebElement getPassword() {
		//Wait till Sign In page is displayed
		return driver.findElement(password);		
	}
	
	public WebElement getSignInBtn() {
		//Wait till Sign In page is displayed
		return driver.findElement(signinbtn);		
	}
}
