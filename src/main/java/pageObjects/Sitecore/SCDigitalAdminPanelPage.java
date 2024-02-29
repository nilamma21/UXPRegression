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
	By digitalAdminPanelListSortByOptions = By.xpath("//div[@class='dropdown-menu show']/div"); // Locator for List of SortBy options
	By digitalAdminPanelResultList = By.xpath("//table[@class='table table-bordered']/tbody/tr/td[2]");   //Digital Identity List
	By digitalAdminPanelLastNameList = By.xpath("//table[@class='table table-bordered']/tbody/tr/td[4]");  //Last Name list
	By digitalAdminPanelFilterByButton = By.xpath("//div[@class='sc-applicationHeader-actions']/div[1]/div[2]/button[1]"); // Locator for FilterBy Buttn
	
																								
	public SCDigitalAdminPanelPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	public WebElement getdigitalAdminPanelFilterByButton() throws InterruptedException {
		wait = new WebDriverWait(driver, 20);
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
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelSortByButton));
		return driver.findElement(digitalAdminPanelSortByButton);
	}
	public WebElement getdigitalAdminPanelSearchButton() throws InterruptedException {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelSearchButton));
		return driver.findElement(digitalAdminPanelSearchButton);
	}
	public WebElement getdigitalAdminPanelSearchBox() throws InterruptedException {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelSearchBox));
		return driver.findElement(digitalAdminPanelSearchBox);
	}
	public WebElement getdigitalAdminPanelSearch1stEmail() throws InterruptedException {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanelSearch1stEmail));
		return driver.findElement(digitalAdminPanelSearch1stEmail);
	}
	public WebElement getDigitalAdminPanel() throws InterruptedException {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(digitalAdminPanel));
		return driver.findElement(digitalAdminPanel);
	}

}
