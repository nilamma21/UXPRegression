package pageObjects.Sitecore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SCDigitalAdminPanelPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By digitalAdminPanel = By.xpath("//div[@class='sc-launchpad']/div[1]/div[1]/a[1]/span[2]"); // Locator for Digital Admin Panel
																								
	public SCDigitalAdminPanelPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getDigitalAdminPanel() throws InterruptedException {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanel));
		return driver.findElement(digitalAdminPanel);
	}

}
