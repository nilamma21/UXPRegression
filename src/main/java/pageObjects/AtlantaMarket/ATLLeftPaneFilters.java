package pageObjects.AtlantaMarket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLLeftPaneFilters {

	public WebDriver driver;
	public WebDriverWait wait;

	By prodcatgexpandbtn = By.xpath("//a[@aria-label='Product Categories']");
	By accentfurnexpandbtn = By.xpath("//div[contains(@class,'imc-filter imc-content imc-expand-collapse')]//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]//div[1]//a[1]//div[1]//div[1]//div[1]");
	

	public ATLLeftPaneFilters(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 
	public WebElement getATLProdCatgExpandBtn(){
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(prodcatgexpandbtn));
		return driver.findElement(prodcatgexpandbtn);
	}
	public WebElement getAccentFurnExpandBtn(){
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(accentfurnexpandbtn));
		return driver.findElement(accentfurnexpandbtn);
	}

}



