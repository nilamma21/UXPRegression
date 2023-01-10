package pageObjects.LasVegasMarket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LVMMarketPlannerPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By lvmsavedexhnameinlist_uat = By.xpath("//li[@class='imc-list-edit--draggable'][1]/div/div[1]/div[1]/a"); //Locator for Saved Exhibitor name in list	
	By moreBtnDeleteOptn_lvmUAT = By.xpath("(//li[@class=\"imc-list-edit--draggable\"])[1]/div/div[1]/div[4]/div/button"); //Locator for Delete Option of 1st list item
	By newlistmodalcreatebtn_LvmUAT = By.xpath("(//input[@type='submit'])[position()=3]"); //Locator for Create btn on Create new list modal LVM UAT
	

	public LVMMarketPlannerPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 
	public WebElement getNewlistmodalcreatebtn_LvmUAT() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(newlistmodalcreatebtn_LvmUAT));
		return driver.findElement(newlistmodalcreatebtn_LvmUAT);
	}
	
	public WebElement getlvmsavedexhnameinlist_uat() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmsavedexhnameinlist_uat));
		return driver.findElement(lvmsavedexhnameinlist_uat);
	}
	public WebElement getMoreBtnDeleteOptn_lvmUAT() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(moreBtnDeleteOptn_lvmUAT));
		return driver.findElement(moreBtnDeleteOptn_lvmUAT);
	}
	
	
}



