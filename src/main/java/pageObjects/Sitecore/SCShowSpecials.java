package pageObjects.Sitecore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SCShowSpecials {

	public WebDriver driver;
	public WebDriverWait wait;
	
	By sssortbyoptn = By.xpath("//button[contains(text(),'Sort by')]"); //Locator for Sort By option
	By dateaddeddesc = By.xpath("//div[@data-value='DateAddedDesc']"); //Locator for Date added desc optn
	By firstrecordss = By.xpath("//tbody[@id='users-table-tr']/tr[1]/td[3]"); //Locator for 1st record of Show special
	
	
	public SCShowSpecials(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}


	public WebElement getSSSortByOptn() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(sssortbyoptn));
		return driver.findElement(sssortbyoptn);
	}
	public WebElement getDateAddedDesc() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(dateaddeddesc));
		return driver.findElement(dateaddeddesc);
	}
	public WebElement getFirstRecordSS() {
		return driver.findElement(firstrecordss);
	}
}
