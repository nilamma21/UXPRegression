package pageObjects.AtlantaMarket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLFloorPlansPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By atlExhibitorsAndProductTab = By.xpath("//div[@class='imc-section']/div[1]/div[2]/div[1]/a[1]"); // Locator for Exhibitor And Product tab 
	By atlFloorPlansLink = By.xpath("//div[@class='imc-section']/div[1]/div[2]/div[2]/div[1]/div[2]"); //Locator for floor plans Link
	By atlBuildingFloor = By.xpath("//div[@class='imc-campus-view']/div[1]/div[22]/div[3]/a[1]"); //Locator for Building floor
	By atlBuildingFloorNumber = By.xpath("//div[@class='imc-campus-view']/div[1]/div[23]/div[2]"); //Locator for Building floor number
	//By atlFloorName = By.xpath("//div[@class='imc-floor-plan']/div[1]/div[1]/span[1]/div[2]"); //Locator for floor name
	By atlFloorName = By.xpath("//div[@class='imc-type--title-6']");
	
	public ATLFloorPlansPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 
	public WebElement getATLExhibitorsAndProductTab(){
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlExhibitorsAndProductTab));
		return driver.findElement(atlExhibitorsAndProductTab);
	}

	public WebElement getATLFloorPlansLink() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlFloorPlansLink));
		return driver.findElement(atlFloorPlansLink);
	}
	public WebElement getATLBuildingFloor() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlBuildingFloor));
		return driver.findElement(atlBuildingFloor);
	}
	public WebElement getATLBuildingFloorNumber() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlBuildingFloorNumber));
		return driver.findElement(atlBuildingFloorNumber);
	}
	public WebElement getATLFloorName() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlFloorName));
		return driver.findElement(atlFloorName);
	}

}



