package pageObjects.AtlantaMarket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLLandingPage {
	public WebDriver driver;
	public WebDriverWait wait;
	
	By loginbtn= By.xpath("//a[contains(text(),'Login')]"); //Locator for Login button on app landing Page
	By marketplannerlinktext = By.xpath("//span[contains(text(),'s Market Planner')][1]"); //Locator for Market Planner link text
	By iunderstandbtn = By.xpath("//button[@id='gdpr-btn']"); //Locator for I Understand button
	By mpsignoutbtn = By.xpath("(//a[@href='/imc-api/account/v1/logout'])[position()=1]"); //Locator for Sign out button
	By closemrktadbtn = By.xpath("//div[@class=' contact-exit']"); //Locator for Close button of Market ad
	By welcomeMsg = By.xpath("//button[@class='imc-header-user-icon--greeting ']"); //Locator for Welcome Msg
	By signOut = By.xpath("//a[contains(text(),'Sign Out')]"); //Locator for Sign Out
	By marketplannerlinktext1 = By.xpath("(//span[contains(text(),'s Market Planner')])[1]"); //Locator for Market Planner link text
	
	
	public ATLLandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 
	
	public WebElement getLogin() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(loginbtn));
		return driver.findElement(loginbtn);		
	}
	
	public WebElement getMPLinkText() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(marketplannerlinktext));
		return driver.findElement(marketplannerlinktext);		
	}	
	
	public WebElement getIUnderstandBtn() throws InterruptedException {
		Thread.sleep(8000);
		return driver.findElement(iunderstandbtn);		
	}
	
	public WebElement getMPSignOutBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpsignoutbtn));
		return driver.findElement(mpsignoutbtn);		
	}	
	public WebElement getCloseMarktAdBtn() throws InterruptedException{
		Thread.sleep(7000);
		return driver.findElement(closemrktadbtn);		
	}
	public WebElement getWelcomeMsg() throws InterruptedException{
		Thread.sleep(7000);
		return driver.findElement(welcomeMsg);		
	}
	public WebElement getSignOut() throws InterruptedException{
		Thread.sleep(7000);
		return driver.findElement(signOut);		
	}
	public WebElement getmarketplannerlinktext1() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(marketplannerlinktext1));
		return driver.findElement(marketplannerlinktext1);		
	}
	
	
}
