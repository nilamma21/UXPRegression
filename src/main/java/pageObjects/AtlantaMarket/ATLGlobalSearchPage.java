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
	By atlsearchresultslist = By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li/span/span"); //Locator for Search results list
	By atlsearchresultexhtypelist = By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li/span/span/span[2]"); //Locator for list of search results types
	By atlsearchresultlinetypelist = By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li/span/span/span[2]"); //Locator for list of search result Line type
	By atlproductsearchresultlist = By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li/span/span"); //Locator for Product suggestion search list
	By atlclearsearchbtn = By.xpath("(//button[@aria-label='Clear Search'])[position()=1]"); //Locator for Clear Search button
	By atlsearchresultproducttypelist = By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li/span/span/span[5]"); //Locator for list of search result product type
	//By atlsearchbtn = By.xpath("//button[@data-xpath='typesearchahead.submitBtn']");

	public ATLGlobalSearchPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getATLGlobalSearchTextBox() throws InterruptedException {
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
	public List<WebElement> getATLSearchResultExhTypeList() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlsearchresultexhtypelist));
		return driver.findElements(atlsearchresultexhtypelist);
	}
	public List<WebElement> getATLSearchResultTypeLineList() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlsearchresultlinetypelist));
		return driver.findElements(atlsearchresultlinetypelist);
	}
	public List<WebElement> getATLProductsSearchResultsList() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlproductsearchresultlist));
		return driver.findElements(atlproductsearchresultlist);
	}
	public WebElement getATLClearSearchBtn() {
		return driver.findElement(atlclearsearchbtn);
	}
	public List<WebElement> getATLSearchResultPorductTypeList() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlsearchresultproducttypelist));
		return driver.findElements(atlsearchresultproducttypelist);
	}
}



