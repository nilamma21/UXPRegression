package pageObjects.AtlantaMarket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLLeftPaneFilters {

	public WebDriver driver;
	public WebDriverWait wait;

	By prodcatgexpandbtn = By.xpath("//a[@aria-label='Product Categories']"); //Locator for Poduct category
	By accentfurnexpandbtn = By.xpath("//div[contains(@class,'imc-filter imc-content imc-expand-collapse')]//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]//div[1]//a[1]//div[1]//div[1]//div[1]");//Locator for accent furniture expan
	By atlAntiqueReprodAccbtn = By.xpath("(//div[contains(@class,'imc-filter imc-content imc-expand-collapse')]//div[1]//div[1]//div[2]//div[1]//div[20])[1]"); //Locator for Antique Reprod Accbtn
	By atlexhibitor = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[1]/div[1]/div[1]//a[1]/h2[1]");//Locator for 1st Exhibitor
	By stylesFilterbtn = By.xpath("//a[@aria-label='Styles']"); //Locator for Styles filter
	
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
	public WebElement getATLAntiqueReprodAccbtn(){
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlAntiqueReprodAccbtn));
		return driver.findElement(atlAntiqueReprodAccbtn);
	}

	public WebElement getATLexhibitor(){
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlexhibitor));
		return driver.findElement(atlexhibitor);
	}
	public WebElement getATLStylesFilterbtn(){
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(stylesFilterbtn));
		return driver.findElement(stylesFilterbtn);
	}
}



