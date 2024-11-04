package pageObjects.Sitecore;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SCLoginPage {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	By scusername = By.xpath("//input[@id = 'Username']"); // Locator for Sitecore Username
	By scpassword = By.xpath("//input[@id = 'Password']"); //Locator for Sitecore Password
	By scloginbtn = By.xpath("//button[@name = 'button']"); //Locator for Sitecore Login button
	
	public SCLoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getSCUsername() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(scusername));
		return driver.findElement(scusername);
	}
	
	public WebElement getSCPassword() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(scpassword));
		return driver.findElement(scpassword);
	}
	public WebElement getSCLoginbtn() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(scloginbtn));
		return driver.findElement(scloginbtn);

	}

}
