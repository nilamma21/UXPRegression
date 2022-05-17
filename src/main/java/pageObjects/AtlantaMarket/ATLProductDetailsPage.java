package pageObjects.AtlantaMarket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLProductDetailsPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By atlvalidateproddetailspage = By.xpath("(//div[@class='imc-product-details--section'])[position()=1]"); // Locator to validate Product Details page
	
	public ATLProductDetailsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getATLValidateProdDetailsPage() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlvalidateproddetailspage));
		return driver.findElement(atlvalidateproddetailspage);
	}
}



