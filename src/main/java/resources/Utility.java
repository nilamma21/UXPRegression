
package resources;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

//import atlantamarket_UAT.MarketPlanner;
import pageObjects.AtlantaMarket.ATLEventsAndWebinarPage;
import pageObjects.AtlantaMarket.ATLExhDigiShowroomPage;
import pageObjects.AtlantaMarket.ATLExhLineProdActionsPage;
import pageObjects.AtlantaMarket.ATLGlobalSearchPage;
import pageObjects.AtlantaMarket.ATLLandingPage;
import pageObjects.AtlantaMarket.ATLLeftPaneFilters;
import pageObjects.AtlantaMarket.ATLLoginPage;
import pageObjects.AtlantaMarket.ATLMarketPlannerPage;
import pageObjects.AtlantaMarket.ATLProductDetailsPage;
import pageObjects.ExhibitorPortal.EXPMarketsPage;
import pageObjects.LasVegasMarket.LVMEventsAndWebinarPage;
import pageObjects.LasVegasMarket.LVMMarketPlannerPage;
import pageObjects.Sitecore.SCDashboard;
import pageObjects.Sitecore.SCLoginPage;
import pageObjects.Sitecore.SCShowSpecials;

public class Utility extends base {

	public String neweventname = "";
	// public WebDriver driver;
	ATLLandingPage lap;
	ATLLoginPage lp;
	ATLExhLineProdActionsPage atlexhact;
	ATLMarketPlannerPage atlmppge;
	ATLGlobalSearchPage atlgs;
	ATLEventsAndWebinarPage atlevents;
	GenerateData genData;
	LVMMarketPlannerPage lvmmpp;
	LVMEventsAndWebinarPage lvmevents;
	ATLExhDigiShowroomPage atlexhdgshw;
	ATLProductDetailsPage atlproddet;
	ATLLeftPaneFilters atlleftpane;
	EXPMarketsPage expmrkttab;
	SCLoginPage sclogin;
	SCDashboard scdash;
	SCShowSpecials scshow;
	
	ArrayList<String> tabs;
	List<WebElement> showspecialslist, exheventslist, exheventnameslist, exheventdeletebtnlist;

	@SuppressWarnings("static-access")
	public Utility(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement scrollToElement(WebElement element) throws InterruptedException {
		WebElement scrollText = element;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", scrollText);
		Thread.sleep(4000);
		return element;
	}

	public void verifyMPLoginFunctionality() throws IOException, InterruptedException {

		// The purpose of this test case to verify:-
		// TS1- Login to Market Planner

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);

		// Click on Login button from Landing Page
		lap.getLogin().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Enter the credentials on Login Page and click
		lp.getEmailAddress().sendKeys((prop.getProperty("username")));
		lp.getPassword().sendKeys((prop.getProperty("password")));
		Thread.sleep(1000);

		lp.getSignInBtn().click();
		Thread.sleep(15000);
	}
	public String[] verifyMPLoginFunctionality_Test() throws IOException, InterruptedException {

		// The purpose of this test case to verify:-
		// TS1- Login to Market Planner

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);

		// Click on Login button from Landing Page
		try {
		lap.getLogin().click();
		}catch (Exception e) {
			// TODO: handle exception
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// Enter the credentials on Login Page and click
		lp.getEmailAddress().sendKeys((prop.getProperty("username")));

		lp.getPassword().sendKeys((prop.getProperty("password")));


		Thread.sleep(1000);
		/*lp.getPassword().sendKeys((prop.getProperty("password")));
		Thread.sleep(1000);*/

		lp.getSignInBtn().click();
		Thread.sleep(15000);
		}
		return null;

	}

	public void selectDropdown(String itemName, String channelURL) throws InterruptedException {
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		Select selectAMC = new Select(atlmppge.getselectChannel());
		selectAMC.selectByVisibleText(itemName);
		Thread.sleep(8000);
		Assert.assertTrue(driver.getCurrentUrl().contains(channelURL + "Market-Planner"));
		System.out.println("Verified " + itemName + "channel page");

	}

	public void mouseHover(WebElement mainMenu, WebElement subMenu) throws IOException, InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		// Instantiating Actions class
		Actions actions = new Actions(driver);
		// Hovering on main menu
		actions.moveToElement(mainMenu);
		// To mouseover on sub menu
		actions.moveToElement(subMenu);
		// build()- used to compile all the actions into a single step
		actions.click().build().perform();

	}

	public void addingExhProdLine(String name) throws IOException, InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		// Clear All
		atlmppge.getMpQuickAdd().sendKeys(Keys.CONTROL + "a");
		atlmppge.getMpQuickAdd().sendKeys(Keys.DELETE);

		// Enter New Exh
		Thread.sleep(5000);
		atlmppge.getMpQuickAdd().sendKeys(name);
		Thread.sleep(5000);
		atlmppge.getMpQuickAdd().sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		atlmppge.getMpQuickAdd().sendKeys(Keys.ENTER);
		Thread.sleep(5000);

	}

	public void addingExhForSorting(String name) throws IOException, InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);

		// Clear All
		atlgs.getATLGlobalSearchTextBox().sendKeys(Keys.CONTROL + "a");
		atlgs.getATLGlobalSearchTextBox().sendKeys(Keys.DELETE);

		// Enter New Exh
		Thread.sleep(2000);
		atlgs.getATLGlobalSearchTextBox().sendKeys(name);

		Thread.sleep(2000);
		atlgs.getATLGlobalSearchTextBox().sendKeys(Keys.ENTER);
		Thread.sleep(5000);

	}

	public void checkItemPresentInListorNot(List<WebElement> listOfProd, String filterName)
			throws IOException, InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		boolean flagLines = false;
		for (WebElement selectL : listOfProd) {
			if (selectL.getText().equals(filterName)) {
				flagLines = true;
				break;
			}
		}
		if (flagLines == true) {
			System.out.println(filterName +" Present");
			Assert.assertTrue(flagLines = true);
		} else {
			System.out.println(filterName + "s Not Present");
			Assert.assertTrue(flagLines = false);
		}
	}

	public void checkItemNotPresentInList(List<WebElement> listOfProd, String filterName)
			throws IOException, InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		boolean flagLines = false;
		for (WebElement selectL : listOfProd) {
			if (selectL.getText().equals(filterName)) {
				flagLines = true;
				break;
			}
		}
		if (flagLines == true) {
			System.out.println(filterName + "s Present");
			Assert.assertFalse(flagLines = true);
		} else {
			System.out.println(filterName + "s Not Present");
			Assert.assertTrue(flagLines = true);
		}
	}

	// Click on FilterBy Options(All , Exhibitor, Line , Product , etc)
	public void selectFilters(List<WebElement> list, String filterName) {

		boolean flag = false;
		for (WebElement listExhibitor : list) {
			if (listExhibitor.getText().contains(filterName)) {
				listExhibitor.click();
				flag = true;
				break;
			}
		}
		if (flag == true) {
			System.out.println(filterName + " Selected");
			Assert.assertTrue(flag = true);
		} else {
			System.out.println(filterName + " Not Selected");
			Assert.assertTrue(flag = false);
		}
	}

	public void createNewList() throws InterruptedException {
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		// click on New list btn
		atlmppge.getMpListNewListBtn().click();
		// verify New List Popup header
		Assert.assertTrue(
				atlmppge.getMpListNewGroupPopupHeader().getText().contains(prop.getProperty("CreateListPopupHeader")));
		// Enter List name
		String newlistname = "Cyb" + genData.generateRandomString(5);
		atlmppge.getMpListNewGroupNameTxt().sendKeys(newlistname);
		System.out.println("list name :: " + newlistname);
		// Click on Create Btn
		atlmppge.getMpListNewCreateBtn().click();
		Thread.sleep(5000);
	}

	public void addingCutomItem() throws IOException, InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		// Click on Add Custom item Btn
		atlmppge.getAddCustomItem().click();
		String newTitle = "Cyb" + genData.generateRandomString(5);
		atlmppge.getCustomTitle().sendKeys(newTitle);
		String newDesc = "Cyb" + genData.generateRandomString(20);
		atlmppge.getCustomDesc().sendKeys(newDesc);
		atlmppge.getCustomItemsubmitBtn().click();
	}

	public void ClickOnEditBtnOfAnyList(List<WebElement> list, String listName)
			throws IOException, InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		boolean flag = false;
		for (WebElement selectListName : list) {
			if (selectListName.getText().equals(listName)) {
				scrollToElement(selectListName);
				WebElement editBtn = driver.findElement(By.xpath("//div[text()='" + listName + "']/../div[2]/span[2]"));
				// click on Edit btn
				editBtn.click();
				Thread.sleep(5000);
				flag = true;
				break;
			}
		}
		if (flag == true) {
			System.out.println("List " + listName + " selected");
			Assert.assertTrue(flag = true);
		} else {
			Assert.assertTrue(flag = false);
		}

	}

	public void ClickOnListSelectBtn(List<WebElement> list, String listName) throws IOException, InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		boolean flag = false;
		for (WebElement selectListName : list) {
			if (selectListName.getText().equals(listName)) {
				scrollToElement(selectListName);
				WebElement editBtn = driver.findElement(By.xpath("//div[text()='" + listName + "']/../div[2]/span[1]"));
				// click on Edit btn
				editBtn.click();
				Thread.sleep(5000);
				flag = true;
				break;
			}
		}
		if (flag == true) {
			System.out.println("List " + listName + "selected");
			Assert.assertTrue(flag = true);
		} else {
			Assert.assertTrue(flag = false);
		}

	}

	// Check Exhibitor Location
	public void checkLocationLink(List<WebElement> list, String exhName) throws IOException, InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		boolean flag = false;
		for (WebElement selectListName : list) {
			if (selectListName.getText().equals(exhName)) {
				// scrollToElement(selectListName);
				WebElement locationLink = driver.findElement(
						By.xpath("//a[text()='" + exhName + "']/../../../div[2]/div[1]/div[2]/a[1]/div/span[2]"));
				// click on Edit btn
				String locationText = locationLink.getText();
				System.out.println("Location ::" + locationText);

				Thread.sleep(5000);
				flag = true;
				break;
			}
		}
		if (flag == true) {
			System.out.println("Exhibitor " + exhName + "Location Link Present");
			Assert.assertTrue(flag = true);
		} else {
			Assert.assertTrue(flag = false);
		}

	}

	// Click on Exhibitor Location
	public void clickOnLocationLink(List<WebElement> list, String exhName) throws IOException, InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		boolean flag = false;
		for (WebElement selectListName : list) {
			if (selectListName.getText().equals(exhName)) {
				// scrollToElement(selectListName);
				WebElement locationLink = driver.findElement(
						By.xpath("//a[text()='" + exhName + "']/../../../div[2]/div[1]/div[2]/a[1]/div[1]"));
				// click on Edit btn
				String locationText = locationLink.getText();
				System.out.println("Location ::" + locationText);
				locationLink.click();
				Thread.sleep(5000);
				System.out.println(driver.getTitle());
				// Assert.assertTrue(locationText.contains(driver.getTitle()));
				flag = true;
				break;
			}
		}
		if (flag == true) {
			System.out.println("Click on " + exhName + "location Link");
			Assert.assertTrue(flag = true);
		} else {
			Assert.assertTrue(flag = false);
		}

	}

	public void Sorting(List<WebElement> list, WebElement dropdown, String filterName)
			throws IOException, InterruptedException {

		// Store Current location list
		List<String> currentList = new ArrayList<String>();

		for (WebElement currentElement : list) {

			currentList.add(currentElement.getText().toLowerCase());
		}
		System.out.println("Current List : " + currentList);

		// Create sorted list
		List<String> sortedList = new ArrayList<String>();
		for (String s : currentList) {
			sortedList.add(s.toLowerCase());
		}
		if (filterName.contains("Ascending")) {
			Collections.sort(sortedList);
		} else {
			Collections.sort(sortedList, Collections.reverseOrder());
		}
		// Select Sort by Location Ascending Filter
		Select selectOption = new Select(dropdown);
		selectOption.selectByVisibleText(filterName);
		Thread.sleep(8000);

		List<String> expectedSortedList = new ArrayList<String>();
		for (WebElement ascLocationList : list) {
			expectedSortedList.add(ascLocationList.getText().toLowerCase());
		}
		// Thread.sleep(25000);
		System.out.println("Expected sorted Exhibitor List : " + expectedSortedList);
		// Verify Exhibitor List is Sorted or not
		//Assert.assertEquals(sortedList, expectedSortedList, " List Should be sorted");

		System.out.println("Displayed " + filterName);

	}

	public void ClearGlobalSearch() throws IOException, InterruptedException {
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		atlgs=new ATLGlobalSearchPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		if (!atlgs.getATLGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			Thread.sleep(1000);
			atlgs.getatlGlobalSearchClearTxt().click();
		}
	}
	public void CloseATLPopup() throws IOException, InterruptedException {
		lap = new ATLLandingPage(driver);

		try {
			Thread.sleep(1000);
			lap.getCloseMarktAdBtn().click();
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	public void clickOnEventLinkOfChannel() throws InterruptedException {


		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		atlevents=new ATLEventsAndWebinarPage(driver);

		if(driver.getCurrentUrl().contains(prop.getProperty("atlmrkturl_prod"))) {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// Click on Attend Tab
			Thread.sleep(2000);
			atlevents.getatlAttendTab().click();
			Thread.sleep(2000);
			//click on Events Link
			atlevents.getatlEventsLink().click();
			Thread.sleep(3000);
		}
		else {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(2000);
			atlevents.getatlExploreMarketTab().click();  //For LVM Events
			Thread.sleep(2000);
			//click on Events Link
			atlevents.getatlEventsLink().click();
			Thread.sleep(3000);
		}

	}

	public void clickOnEventLinkOfChannelLVM() throws InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);

		lvmmpp = new LVMMarketPlannerPage(driver);
		lvmevents=new LVMEventsAndWebinarPage(driver);

		if(driver.getCurrentUrl().contains(prop.getProperty("lvmurl_prod"))) {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// Click on Attend Tab
			Thread.sleep(2000);
			lvmevents.getlvmExploreMarketTab().click();
			Thread.sleep(2000);
			//click on Events Link
			lvmevents.getlvmEventsLink().click();
		}
			else {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				lvmevents.getlvmAttendTab().click();  //For LVM Events  
				Thread.sleep(2000);
				//click on Events Link
				lvmevents.getlvmEventsLink().click();

				atlevents.getatlExploreMarketTab().click();  //For LVM Events
				Thread.sleep(2000);
				//click on Events Link
				atlevents.getatlEventsLink().click();

				Thread.sleep(3000);
			}
	}

	public void clickOnEventLinkOfChannel_UAT() throws InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);

		lvmmpp = new LVMMarketPlannerPage(driver);
		lvmevents=new LVMEventsAndWebinarPage(driver);

		if(driver.getCurrentUrl().contains(prop.getProperty("lvmurl_uat"))) {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// Click on Attend Tab
			Thread.sleep(2000);
			lvmevents.getlvmExploreMarketTab().click();
			Thread.sleep(2000);
			//click on Events Link
			lvmevents.getlvmEventsLink().click();

			atlmppge = new ATLMarketPlannerPage(driver);
			atlevents=new ATLEventsAndWebinarPage(driver);

			if(driver.getCurrentUrl().contains(prop.getProperty("atlmrkturl_uat"))) {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				// Click on Attend Tab
				atlevents.getatlAttendTab().click();
				Thread.sleep(2000);
				//click on Events Link
				atlevents.getatlEventsLink().click();

				Thread.sleep(3000);
			}
			else {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				lvmevents.getlvmAttendTab().click();  //For LVM Events  
				Thread.sleep(2000);
				//click on Events Link
				lvmevents.getlvmEventsLink().click();

				atlevents.getatlExploreMarketTab().click();  //For LVM Events
				Thread.sleep(2000);
				//click on Events Link
				atlevents.getatlEventsLink().click();

				Thread.sleep(3000);
			}
		}
	}

	public void addNewShowSpecialFrmExp_UAT() throws InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlleftpane = new ATLLeftPaneFilters(driver);
		expmrkttab = new EXPMarketsPage(driver);
		sclogin = new SCLoginPage(driver);
		scdash = new SCDashboard(driver);
		scshow = new SCShowSpecials(driver);
		genData = new GenerateData();

		//Open Exhibitor Portal in new tab
		driver.get(prop.getProperty("expurl_uat"));
		Thread.sleep(5000);

		//Login to EXP
		lp.getEmailAddress().sendKeys((prop.getProperty("usernameSwapnil")));
		lp.getPassword().sendKeys((prop.getProperty("passwordSwapnil")));

		lp.getSignInBtn().click();
		Thread.sleep(15000);

		lap.getIUnderstandBtn().click();
		Thread.sleep(5000);

		//In EXP click on Exhibitor association drop down
		atlleftpane.getEXPExhDropDown().click();

		//Select IMC Test Company exhibitor
		atlleftpane.getIMCExhNameInEXP().click();

		//Click on Markets tab
		expmrkttab.getEXPMarketTab().click();

		if(expmrkttab.getATLMarket().getText().contains("Atlanta Market")) {
			expmrkttab.getATLWinterMarket().click();
		}

		//Click on Add show specials menu
		expmrkttab.getAddShowSpecialMenu().click();

		//Click on Add show special btn
		expmrkttab.getAddShowSpecialBtn().click();

		String showspecialname = "CybShowSpecial_"+genData.generateRandomString(3);
		//Enter show special name
		expmrkttab.getShowSpecialTxtBx().sendKeys(showspecialname);

		//Click on Submit btn
		expmrkttab.getShowSpecialSubmitBtn().click();

		Thread.sleep(4000);
		System.out.println(expmrkttab.getShowSpecialSuccessMsg().getText());
		Assert.assertTrue(expmrkttab.getShowSpecialSuccessMsg().getText().contains(showspecialname));

		//Dismiss the pop-up by click on Okay btn
		expmrkttab.getDismissSuccessModal().click();
		Thread.sleep(6000);
		showspecialslist = driver.findElements(By.xpath("//div[@col-id='showSpecial']"));

		for (int i = 1; i < showspecialslist.size(); i++) {
			Assert.assertTrue(showspecialslist.get(i).getText().contains(showspecialname));
			break;
		}

		//Open Sitecore in new tab
		((JavascriptExecutor)driver).executeScript("window.open()");
		tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get(prop.getProperty("sitecoreurl_uat"));
		Thread.sleep(5000);

		//Login to Sitecore
		sclogin.getSCUsername().sendKeys(prop.getProperty("scusername_uat"));
		sclogin.getSCPassword().sendKeys(prop.getProperty("scpassword_uat"));
		sclogin.getSCLoginbtn().click();

		//Click on Show special Approvals menu
		scdash.getShowSpecialApprovals().click();

		//Select Sort By dropdown
		scshow.getSSSortByOptn().click();

		//Click on Date added Desc optn
		scshow.getDateAddedDesc().click();

		Thread.sleep(6000);
		WebElement approvebtn = driver.findElement(By.xpath("//a[@data-special='"+showspecialname+"' and text()='Approve']"));

		//Click on Approve btn
		approvebtn.click();
		Thread.sleep(6000);
	}

	public void addNewShowSpecialFrmExp_PROD() throws InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlleftpane = new ATLLeftPaneFilters(driver);
		expmrkttab = new EXPMarketsPage(driver);
		sclogin = new SCLoginPage(driver);
		scdash = new SCDashboard(driver);
		scshow = new SCShowSpecials(driver);
		genData = new GenerateData();

		//Open Exhibitor Portal in new tab
		driver.get(prop.getProperty("expurl_prod"));
		Thread.sleep(5000);

		//Login to EXP
		lp.getEmailAddress().sendKeys((prop.getProperty("usernameSwapnil")));
		lp.getPassword().sendKeys((prop.getProperty("passwordSwapnil")));

		lp.getSignInBtn().click();
		Thread.sleep(15000);

		lap.getIUnderstandBtn().click();
		Thread.sleep(5000);

		//In EXP click on Exhibitor association drop down
		atlleftpane.getEXPExhDropDown().click();

		//Select IMC Test Company exhibitor
		atlleftpane.getIMCExhNameInEXP().click();

		//Click on Markets tab
		expmrkttab.getEXPMarketTab().click();

		if(expmrkttab.getATLMarket().getText().contains("Atlanta Market")) {
			expmrkttab.getATLWinterMarket().click();
		}

		//Click on Manage show specials menu
		expmrkttab.getManageShowSpecialMenu().click();

		//Click on Add show special btn
		expmrkttab.getAddShowSpecialBtn().click();

		String showspecialname = "CybShowSpecial_"+genData.generateRandomString(3);
		//Enter show special name
		expmrkttab.getShowSpecialTxtBx().sendKeys(showspecialname);

		//Click on Submit btn
		expmrkttab.getShowSpecialSubmitBtn().click();

		Thread.sleep(4000);
		System.out.println(expmrkttab.getShowSpecialSuccessMsg().getText());
		Assert.assertTrue(expmrkttab.getShowSpecialSuccessMsg().getText().contains(showspecialname));

		//Dismiss the pop-up by click on Okay btn
		expmrkttab.getDismissSuccessModal().click();
		Thread.sleep(6000);
		showspecialslist = driver.findElements(By.xpath("//div[@col-id='showSpecial']"));

		for (int i = 1; i < showspecialslist.size(); i++) {
			Assert.assertTrue(showspecialslist.get(i).getText().contains(showspecialname));
			break;
		}

		//Open Sitecore in new tab
		((JavascriptExecutor)driver).executeScript("window.open()");
		tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get(prop.getProperty("sitecoreurl_prod"));
		Thread.sleep(5000);

		//Login to Sitecore
		sclogin.getSCUsername().sendKeys(prop.getProperty("scusername_prod"));
		sclogin.getSCPassword().sendKeys(prop.getProperty("scpassword_prod"));
		sclogin.getSCLoginbtn().click();
		Thread.sleep(5000);
		driver.get(prop.getProperty("sitecoreurl_prod"));

		//Click on Show special Approvals menu
		scdash.getShowSpecialApprovals().click();

		//Select Sort By dropdown
		Thread.sleep(4000);
		scshow.getSSSortByOptn().click();

		//Click on Date added Desc optn
		scshow.getDateAddedDesc().click();

		Thread.sleep(6000);
		WebElement approvebtn = driver.findElement(By.xpath("//a[@data-special='"+showspecialname+"' and text()='Approve']"));

		//Click on Approve btn
		approvebtn.click();
		Thread.sleep(6000);
	}

	public void deleteShowSpecialFrmExp() throws InterruptedException {

		expmrkttab = new EXPMarketsPage(driver);

		((JavascriptExecutor)driver).executeScript("window.open()");
		tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));

		//Delete newly created Show special
		expmrkttab.getDeleteShowSpecialBtn().click();
		Thread.sleep(5000);
	}


	public void addNewExhibitorEventsFrmExp_UAT() throws InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlleftpane = new ATLLeftPaneFilters(driver);
		expmrkttab = new EXPMarketsPage(driver);
		sclogin = new SCLoginPage(driver);
		scdash = new SCDashboard(driver);
		scshow = new SCShowSpecials(driver);
		genData = new GenerateData();

		//Open Exhibitor Portal in new tab
		driver.get(prop.getProperty("expurl_uat"));
		Thread.sleep(5000);

		//Login to EXP
		lp.getEmailAddress().sendKeys((prop.getProperty("usernameSwapnil")));
		lp.getPassword().sendKeys((prop.getProperty("passwordSwapnil")));

		lp.getSignInBtn().click();
		Thread.sleep(15000);

		lap.getIUnderstandBtn().click();
		Thread.sleep(5000);

		//In EXP click on Exhibitor association drop down
		atlleftpane.getEXPExhDropDown().click();

		//Select IMC Test Company exhibitor
		atlleftpane.getIMCExhNameInEXP().click();

		//Click on Markets tab
		expmrkttab.getEXPMarketTab().click();

		if(expmrkttab.getATLMarket().getText().contains("Atlanta Market")) {
			expmrkttab.getATLWinterMarket().click();
		}

		//Click on Add Event btn
		expmrkttab.getAddEventsBtn().click();

		//Click on Add Event btn on Events page
		expmrkttab.getAddEventsBtn().click();

		//On Add Event form, fill all the required details
		//Click on Event Type drop down
		expmrkttab.getEventTypeDD().click();

		//Select 'Demo' Event type
		expmrkttab.getDemoEventType().click();

		neweventname = "CybEvent_"+genData.generateRandomString(3);
		//Enter the Event name
		expmrkttab.getEventNameTxtBox().sendKeys(neweventname);

		//Enter the event description
		expmrkttab.getEventDescptnTxtBox().sendKeys("Events testing");

		//Click on Choose location drop down
		expmrkttab.getChooseLocationDD().click();

		//Select any location
		expmrkttab.getLocationValue().click();

		//Click on Event Start Date text field
		expmrkttab.getEventStartDateTxtBx().click();

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		//get current date time with Date()
		Date date = new Date();

		// Now format the date
		String date1= dateFormat.format(date);

		// Print the Date
		System.out.println("Current date is " +date1);

		//Enter Event Start date
		expmrkttab.getEventStartDateTxtBx().sendKeys(date1);

		//Click on Event End Date text field
		expmrkttab.getEventEndDateTxtBx().click();

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 10);
		String futureDate = dateFormat.format(calendar.getTime());
		System.out.println("Future date: "+futureDate);

		//Enter Event End date
		expmrkttab.getEventEndDateTxtBx().sendKeys(futureDate);

		//Click on Event Start time Drop down
		expmrkttab.getEventStartTimeDD().click();

		//Select Event Start time
		expmrkttab.getEventStartTimeValue().click();

		//Click on Event End time Drop down
		expmrkttab.getEventEndTimeDD().click();

		//Select Event End time
		expmrkttab.getEventEndTimeValue().click();

		//Select Open to Everyone Checkbox
		expmrkttab.getOpenToEveryoneChckBx().click();

		//Click on Save button
		expmrkttab.getEventSaveBtn().click();
		Thread.sleep(4000);

		//Verify that Success msg should appeared
		Assert.assertTrue(expmrkttab.getShowSpecialSuccessMsg().isDisplayed());

		//Dismiss the pop-up by click on Okay btn
		expmrkttab.getDismissSuccessModal().click();
		Thread.sleep(6000);
		int i = 0; 
		exheventslist = driver.findElements(By.xpath("//ul[contains(@class,'EPManageEventsForMarket_eventsList')]/li["+i+"]/span[1]"));

		for (i = 1; i < exheventslist.size(); i++) {
			Assert.assertTrue(exheventslist.get(i).getText().contains(neweventname));
			break;
		}

		//Open Sitecore in new tab
		((JavascriptExecutor)driver).executeScript("window.open()");
		tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get(prop.getProperty("sitecoreurl_uat"));
		Thread.sleep(5000);

		//Login to Sitecore
		sclogin.getSCUsername().sendKeys(prop.getProperty("scusername_uat"));
		sclogin.getSCPassword().sendKeys(prop.getProperty("scpassword_uat"));
		sclogin.getSCLoginbtn().click();

		//Click on Exhibitor Events Approvals menu
		scdash.getExhEventsApprovals().click();

		//Select Sort By dropdown
		scshow.getSSSortByOptn().click();

		//Click on Date added Desc optn
		scshow.getDateAddedDesc().click();

		Thread.sleep(6000);
		WebElement approvebtn = driver.findElement(By.xpath("//a[@data-eventname='"+neweventname+"' and text()='Approve']"));

		//Click on Approve btn
		approvebtn.click();
		Thread.sleep(6000);
	}


	public void deleteExhEventFrmExp() throws InterruptedException {

		expmrkttab = new EXPMarketsPage(driver);

		System.out.println("In delete Exh event function");
		
		((JavascriptExecutor)driver).executeScript("window.open()");
		tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));

		System.out.println(neweventname);
		
		//Delete newly created Exhibitor Event
		int i = 0;
		exheventnameslist = driver.findElements(By.xpath("//li[contains(@class,'EPManageEventsForMarket_eventItem')]["+i+"]/span[1]"));
		exheventdeletebtnlist = driver.findElements(By.xpath("//li[contains(@class,'EPManageEventsForMarket_eventItem')]["+i+"]/div[3]/div[3]/span"));
		
		for (i = 1; i < exheventnameslist.size(); i++) {
			
			scrollToElement(exheventnameslist.get(i));
			
			System.out.println(exheventnameslist.get(i).getText());
			if(exheventnameslist.get(i).getText().contains(neweventname)) {
				exheventdeletebtnlist.get(i).click();
				break;
			}
		}
	}
	
	public void loginCheckATL() throws IOException, InterruptedException {
		String currentURL = driver.getCurrentUrl();
		String expectedURL = "https://www.atlantamarket.com/";
		if(currentURL.equals(expectedURL)) {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		else {
			driver.get(prop.getProperty("atlmrkturl_prod"));
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
	}
	
	public void loginCheckLVM() throws IOException, InterruptedException {
		String currentURL = driver.getCurrentUrl();
		String expectedURL = "https://www.lasvegasmarket.com/";
		if(currentURL.equals(expectedURL)) {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		else {
			driver.get(prop.getProperty("lvmurl_prod"));
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
	}
}