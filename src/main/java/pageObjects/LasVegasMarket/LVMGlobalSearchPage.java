package pageObjects.LasVegasMarket;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LVMGlobalSearchPage {

	public WebDriver driver;
	public WebDriverWait wait;

	
	By lvmSearchBtnUAT = By.xpath("(//div[@class='imc-searchform--row'])[1]/form[1]/button[2]"); //Locator for Seach button for global search
	
	public LVMGlobalSearchPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getLVMSearchBtnUAT() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(lvmSearchBtnUAT));
		return driver.findElement(lvmSearchBtnUAT);
	}
}



