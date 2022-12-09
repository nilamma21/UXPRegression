
package resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
<<<<<<< HEAD

import org.omg.CORBA.PUBLIC_MEMBER;
=======
//import org.omg.CORBA.PUBLIC_MEMBER;
>>>>>>> a533992e6639477f05b10efbe5f71138cc0815d0
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
<<<<<<< HEAD

import com.gargoylesoftware.htmlunit.javascript.host.media.webkitMediaStream;

import atlantamarket_UAT.MarketPlanner;
=======
import com.gargoylesoftware.htmlunit.javascript.host.media.webkitMediaStream;
//import atlantamarket_UAT.MarketPlanner;
>>>>>>> a533992e6639477f05b10efbe5f71138cc0815d0
import pageObjects.AtlantaMarket.ATLEventsAndWebinarPage;
import pageObjects.AtlantaMarket.ATLExhLineProdActionsPage;
import pageObjects.AtlantaMarket.ATLGlobalSearchPage;
import pageObjects.AtlantaMarket.ATLLandingPage;
import pageObjects.AtlantaMarket.ATLLoginPage;
import pageObjects.AtlantaMarket.ATLMarketPlannerPage;

public class Utility extends base {

	// public WebDriver driver;
	ATLLandingPage lap;
	ATLLoginPage lp;
	ATLExhLineProdActionsPage atlexhact;
	MarketPlanner mp;
	ATLMarketPlannerPage atlmppge;
	ATLGlobalSearchPage atlgs;
	ATLEventsAndWebinarPage atlevents;
	GenerateData genData;

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

		// Enter the credentials on Login Page and click
		lp.getEmailAddress().sendKeys((prop.getProperty("username")));
		lp.getPassword().sendKeys((prop.getProperty("password")));

		lp.getSignInBtn().click();
		Thread.sleep(15000);

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
			System.out.println(filterName + "s Present");
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
			System.out.println("List " + listName + "selected");
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

	// Check Exhibito Location
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
		Assert.assertEquals(sortedList, expectedSortedList, " List Should be sorted");

		System.out.println("Displayed " + filterName);

	}

	public void ClearGlobalSearch() throws IOException, InterruptedException {
<<<<<<< HEAD
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		atlgs=new ATLGlobalSearchPage(driver);
		
		if (!atlgs.getATLGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			atlgs.getatlGlobalSearchClearTxt().click();
		}
	}

=======

		if (!atlgs.getATLGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			atlgs.getatlGlobalSearchClearTxt().click();
		}
	}

>>>>>>> a533992e6639477f05b10efbe5f71138cc0815d0
	public void CloseATLPopup() throws IOException, InterruptedException {
		lap = new ATLLandingPage(driver);
		
		try {
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
			// Click on Attend Tab
			atlevents.getatlAttendTab().click(); 
			Thread.sleep(2000);
			//click on Events Link
			atlevents.getatlEventsLink().click();
			Thread.sleep(3000);
		}
		else {
			atlevents.getatlExploreMarketTab().click();  //For LVM Events
			Thread.sleep(2000);
			//click on Events Link
			atlevents.getatlEventsLink().click();
			Thread.sleep(3000);
		}
	
	}

}