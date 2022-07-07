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

	public ATLLeftPaneFilters(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 
	public WebElement getATLProdCatgExpandBtn(){
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(prodcatgexpandbtn));
		return driver.findElement(prodcatgexpandbtn);
	}

}



