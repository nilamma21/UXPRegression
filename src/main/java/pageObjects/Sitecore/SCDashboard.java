package pageObjects.Sitecore;

import java.time.Duration;

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
	By SC_DashboardCTA = By.xpath("//div[@class='sc-globalHeader-startButton']/a"); //Locator forExh Events Approvals menu
	By SC_ContentEditor = By.xpath("(//header[@class='sc-launchpad-group-title'])[3]/../div[1]/a[1]"); //Locator Content Editor menu
	By SC_ContentEditorIMCDropdown = By.xpath("//span[contains(text(),'IMC')]/../../img"); //Locator Content Editor menu
	By SC_ContentEditorIMCLVM = By.xpath("//span[contains(text(),'las-vegas-market')]/../../img"); //Locator Content Editor menu
	By SC_ContentEditorIMCLVMHome = By.xpath("(//span[contains(text(),'Home')])[2]/../../img"); //Locator Content Editor menu
	By SC_ContentEditorIMCLVMHomeEvents = By.xpath("//span[contains(text(),'Event')]/../../img"); //Locator Content Editor menu
	By SC_ContentEditorIMCLVMHomeEventYearFolder = By.xpath("//span[contains(text(),'Event')]/../../div[2]/div[2]"); //Locator Content Editor menu
	By SC_ContentEditorIMCLVMHomeEventsFirstFolder = By.xpath("//span[contains(text(),'Event')]/../../div[2]/div[2]"); //Locator Content Editor menu
	By SC_ContentEditorIMCLVMHomeEventsFirstFolderSubFolder = By.xpath("//a[@id='I{765CBA62-F3EC-454E-B07B-4BB563C23C01}']/div"); //Locator Content Editor menu
	By SC_ContentEditorIMCLVMHomeEventsFirstFolderSubFolder1 = By.xpath("//a[@id='I{35F58CC9-E97B-4FDF-B2A0-9719503EA9F4}']/div"); //Locator Content Editor menu
	By SC_ContentEditorIMCLVMHomeEventsFirstFolderSubFolder2 = By.xpath("//a[@id='I{41F4AC71-2B2F-49A9-837C-03BFE5BCEE64}']/div"); //Locator Content Editor menu
	By SC_ContentEditorIMCLVMHomeEventsLastPage = By.xpath("//a[@id='I{471FCF7F-ACFD-41FA-9A76-F1F105D336B9}']/div"); //Locator Content Editor menu
	
	
	public SCDashboard(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	public WebElement getSC_ContentEditorIMCLVMHomeEventsLastPage() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(SC_ContentEditorIMCLVMHomeEventsLastPage));
		return driver.findElement(SC_ContentEditorIMCLVMHomeEventsLastPage);
	}
	public WebElement getSC_ContentEditorIMCLVMHomeEventsFirstFolderSubFolder2() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(SC_ContentEditorIMCLVMHomeEventsFirstFolderSubFolder2));
		return driver.findElement(SC_ContentEditorIMCLVMHomeEventsFirstFolderSubFolder2);
	}
	public WebElement getSC_ContentEditorIMCLVMHomeEventsFirstFolderSubFolder1() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(SC_ContentEditorIMCLVMHomeEventsFirstFolderSubFolder1));
		return driver.findElement(SC_ContentEditorIMCLVMHomeEventsFirstFolderSubFolder1);
	}
	public WebElement getSC_ContentEditorIMCLVMHomeEventsFirstFolderSubFolder() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(SC_ContentEditorIMCLVMHomeEventsFirstFolderSubFolder));
		return driver.findElement(SC_ContentEditorIMCLVMHomeEventsFirstFolderSubFolder);
	}
	public WebElement getSC_ContentEditorIMCLVMHomeEventsFirstFolder() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(SC_ContentEditorIMCLVMHomeEventsFirstFolder));
		return driver.findElement(SC_ContentEditorIMCLVMHomeEventsFirstFolder);
	}
	public WebElement getSC_ContentEditorIMCLVMHomeEventYearFolder() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(SC_ContentEditorIMCLVMHomeEventYearFolder));
		return driver.findElement(SC_ContentEditorIMCLVMHomeEventYearFolder);
	}
	
	public WebElement getSC_ContentEditorIMCLVMHome() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(SC_ContentEditorIMCLVMHome));
		return driver.findElement(SC_ContentEditorIMCLVMHome);
	}
	
	public WebElement getSC_ContentEditorIMCLVMHomeEvents() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(SC_ContentEditorIMCLVMHomeEvents));
		return driver.findElement(SC_ContentEditorIMCLVMHomeEvents);
	}
	public WebElement getSC_ContentEditorIMCLVM() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(SC_ContentEditorIMCLVM));
		return driver.findElement(SC_ContentEditorIMCLVM);
	}
	public WebElement getSC_ContentEditorIMCDropdown() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(SC_ContentEditorIMCDropdown));
		return driver.findElement(SC_ContentEditorIMCDropdown);
	}
	public WebElement getSC_ContentEditor() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(SC_ContentEditor));
		return driver.findElement(SC_ContentEditor);
	}
	public WebElement getSC_DashboardCTA() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(SC_DashboardCTA));
		return driver.findElement(SC_DashboardCTA);
	}
	public WebElement getShowSpecialApprovals() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(showspecialapprovalsmenu));
		return driver.findElement(showspecialapprovalsmenu);
	}
	public WebElement getExhEventsApprovals() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(exheventsapprovalmenu));
		return driver.findElement(exheventsapprovalmenu);
	}

}
