package pageObjects.Sitecore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SCDashboard {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	By showspecialapprovalsmenu = By.xpath("//a[@title = 'Show Specials Approvals']"); //Locator for Show Specials Approvals option
	By exheventsapprovalmenu = By.xpath("//a[@title = 'Exhibitor Events Approvals']"); //Locator forExh Events Approvals menu
	
	public SCDashboard(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}


	public WebElement getShowSpecialApprovals() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(showspecialapprovalsmenu));
		return driver.findElement(showspecialapprovalsmenu);
	}
	public WebElement getExhEventsApprovals() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(exheventsapprovalmenu));
		return driver.findElement(exheventsapprovalmenu);
	}

}
