package pageObjects.ExhibitorPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EXPMarketsPage {

	public WebDriver driver;
	public WebDriverWait wait;
	
	
	By expmarketstab = By.xpath("//div[@id = 'root']/header[1]/div[1]/div[1]/div[1]/span[2]"); // Locator for Markets tab
	By atlmarket = By.xpath("//div[contains(@class,'HeaderNavbar_column')][4]/div/a"); //Locator for ATL Market
	By atlwintermarket = By.xpath("//div[contains(@class,'HeaderNavbar_column')][4]/div/ul[1]/li[1]/a"); //Locator for ATL Winter market
	By addshowspecialmenu = By.xpath("//span[contains(text(),'Add Show Special')]"); //Locator for Add show special menu
	By addshowspecialbtn = By.xpath("//span[contains(text(),'Add Show Special')]"); //Locator for Add show special btn
	By showspecialtxtbox = By.xpath("//input[@type='text']"); //Locator for Show special text box
	By showspecialsubmitbtn = By.xpath("//span[contains(text(),'Submit')]"); //Locator for Show special submit btn
	By showspecialsuccessmsg = By.xpath("//span[contains(text(),'You have successfully added')]"); //Locator for Show special success msg
	By dismisssuccessmodal = By.xpath("//span[contains(text(),'Okay')]");
	By deleteshowspecialbtn = By.xpath("//span[text()='Delete'][1]"); //Locator for Delete show special btn
	By manageshowspecialmenu = By.xpath("//span[contains(text(),'Manage Show Specials')]"); //Locator for Manage Show special menu
	
	public EXPMarketsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 
	}


	public WebElement getEXPMarketTab() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(expmarketstab);
	}
	public WebElement getATLMarket() {
		return driver.findElement(atlmarket);
	}
	public WebElement getATLWinterMarket() {
		return driver.findElement(atlwintermarket);
	}
	public WebElement getAddShowSpecialMenu() {
		return driver.findElement(addshowspecialmenu);
	}
	public WebElement getAddShowSpecialBtn() {
		return driver.findElement(addshowspecialbtn);
	}
	public WebElement getShowSpecialTxtBx() {
		return driver.findElement(showspecialtxtbox);
	}
	public WebElement getShowSpecialSubmitBtn() {
		return driver.findElement(showspecialsubmitbtn);
	}
	public WebElement getShowSpecialSuccessMsg() {
		return driver.findElement(showspecialsuccessmsg);
	}
	public WebElement getDismissSuccessModal() {
		return driver.findElement(dismisssuccessmodal);
	}
	public WebElement getDeleteShowSpecialBtn() {
		return driver.findElement(deleteshowspecialbtn);
	}
	public WebElement getManageShowSpecialMenu() {
		return driver.findElement(manageshowspecialmenu);
	}
}
