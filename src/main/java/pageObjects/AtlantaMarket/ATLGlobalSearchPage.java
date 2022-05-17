package pageObjects.AtlantaMarket;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLGlobalSearchPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By atlglobalsearchtxtbx = By.xpath("//input[@id='input-1']"); // Locator for Global Search field 
	By atlsearchbtn = By.xpath("//button[@class = 'imc-searchform--button--search']"); //Locator for Seach button for global search
	By atlverifyglobalseacrh = By.xpath("//div[@class = 'imc-gallery__item']/div[1]/section[1]/span[1]/div[1]"); // Locator for global search verification
	By atlsearchresultslist = By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li/span/span/span[1]"); //Locator for Search results list
	By atlsearchresulttypelist = By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li/span/span/span[3]"); //Locator for list of search results types
	By atlproductsearchresultlist = By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li/span/span/span[2]"); //Locator for Product suggestion search list
	By atlclearsearchbtn = By.xpath("(//button[@aria-label='Clear Search'])[position()=1]"); //Locator for Clear Search button
	
	public ATLGlobalSearchPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getATLGlobalSearchTextBox(){
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlglobalsearchtxtbx));
		return driver.findElement(atlglobalsearchtxtbx);
	}

	public WebElement getATLSearchButton() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlsearchbtn));
		return driver.findElement(atlsearchbtn);
	}
	public WebElement getATLVerifyGlobalSeacrh() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlverifyglobalseacrh));
		return driver.findElement(atlverifyglobalseacrh);
	}
	public List<WebElement> getATLSearchResultsList() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlsearchresultslist));
		return driver.findElements(atlsearchresultslist);
	}
	public List<WebElement> getATLSearchResultTypeList() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlsearchresulttypelist));
		return driver.findElements(atlsearchresulttypelist);
	}
	public List<WebElement> getATLProductsSearchResultsList() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlproductsearchresultlist));
		return driver.findElements(atlproductsearchresultlist);
	}
	public WebElement getATLClearSearchBtn() {
		return driver.findElement(atlclearsearchbtn);
	}
}



