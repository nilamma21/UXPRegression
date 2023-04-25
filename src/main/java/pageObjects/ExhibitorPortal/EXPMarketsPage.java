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
	By addeventsbtn = By.xpath("//span[contains(text(),'Add Event')]"); //Locator for Add Events button
	By eventtypedd = By.xpath("(//div[contains(@class,'DropDown_dropdown')])[2]"); //Locator for Select Event Type drop-down
	By demoeventtype = By.xpath("//span[contains(text(),'Demo')]"); //Locator for Demo Event Type
	By eventnametxtbox = By.xpath("//input[@name='eventName']"); //Locator for Event Name text box
	By eventdescriptiontxtbox = By.xpath("//textarea[@name='description']"); //Locator for Event description text box
	By chooselocationdd = By.xpath("(//div[contains(@class,'DropDown_dropdown')])[3]"); //Locator for Choose Location drop down
	By locationvalue = By.xpath("//div[contains(@class,'DropDown_values')]/span/span[1]"); //Locator for 1st Location value
	By eventstartdatetxtbx = By.xpath("//input[@aria-label='Start Date']"); //Locator for Event Start Date text field
	By eventenddatetxtbx = By.xpath("//input[@aria-label='End Date']"); //Locator for Event End date text field
	By eventstarttimedd = By.xpath("(//span[contains(@class,'DropDown_input')])[4]"); //Locator for Event Start time drop down
	By evenetendtimedd = By.xpath("(//span[contains(@class,'DropDown_input')])[5]"); //Locator for Event End time drop down
	By eventstarttimevalue = By.xpath("//span[contains(text(),'2:00 am')]"); //Locator for Event Start time value
	By eventendtimevalue = By.xpath("//span[contains(text(),'3:00 am')]"); //Locator for Event End time value
	By opentoeveryonechckbx = By.xpath("//span[contains(text(),'Open to Everyone')]"); //Locator for Open to Everyone checkbox
	By eventsavebtn = By.xpath("//span[contains(text(),'Save')]"); //Locator for Event Save btn
	By exheventssuccessmsg = By.xpath("//span[contains(text(),'You have successfully added your event.')]"); //Locator for Exhibitor events success msg
	By deleteexheventbtn = By.xpath(""); //Locator for Delete Exhibitor event btn

	
	
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
	public WebElement getAddEventsBtn() {
		return driver.findElement(addeventsbtn);
	}
	public WebElement getEventTypeDD() {
		return driver.findElement(eventtypedd);
	}
	public WebElement getDemoEventType() {
		return driver.findElement(demoeventtype);
	}
	public WebElement getEventNameTxtBox() {
		return driver.findElement(eventnametxtbox);
	}
	public WebElement getEventDescptnTxtBox() {
		return driver.findElement(eventdescriptiontxtbox);
	}
	public WebElement getChooseLocationDD() {
		return driver.findElement(chooselocationdd);
	}
	public WebElement getLocationValue() {
		return driver.findElement(locationvalue);
	}
	public WebElement getEventStartDateTxtBx() {
		return driver.findElement(eventstartdatetxtbx);
	}
	public WebElement getEventEndDateTxtBx() {
		return driver.findElement(eventenddatetxtbx);
	}
	public WebElement getEventStartTimeDD() {
		return driver.findElement(eventstarttimedd);
	}
	public WebElement getEventEndTimeDD() {
		return driver.findElement(evenetendtimedd);
	}
	public WebElement getEventStartTimeValue() {
		return driver.findElement(eventstarttimevalue);
	}
	public WebElement getEventEndTimeValue() {
		return driver.findElement(eventendtimevalue);
	}
	public WebElement getOpenToEveryoneChckBx() {
		return driver.findElement(opentoeveryonechckbx);
	}
	public WebElement getEventSaveBtn() {
		return driver.findElement(eventsavebtn);
	}
	public WebElement getExhEventsSuccessMsg() {
		return driver.findElement(exheventssuccessmsg);
	}
	public WebElement getDeleteExhEventBtn() {
		return driver.findElement(deleteexheventbtn);
	}
}
