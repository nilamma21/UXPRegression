
package resources;

import java.io.IOException;

import java.util.List;
import java.util.NoSuchElementException;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.gargoylesoftware.htmlunit.javascript.host.media.webkitMediaStream;

import atlantamarket_UAT.MarketPlanner;
import pageObjects.AtlantaMarket.ATLExhLineProdActionsPage;
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

	/*
	 * public void verifyMPInvalidLoginFunctionality(String un, String pwd) throws
	 * IOException, InterruptedException {
	 * 
	 * // The purpose of this test case to verify:- // TS1- Login to Market Planner
	 * 
	 * lap = new ATLLandingPage(driver); lp = new ATLLoginPage(driver); mp = new
	 * MarketPlanner(); try {
	 * 
	 * lap.getWelcomeMsg().isDisplayed(); lap.getSignOut().click();
	 * Thread.sleep(8000); lap.getLogin().click();
	 * 
	 * 
	 * mp.TS024_VerifyMarketPlannerSignOutTest(); lap.getLogin().click();
	 * 
	 * } catch (Exception e) { System.out.println(e); lap.getLogin().click(); }
	 * 
	 * // Enter the credentials on Login Page and click
	 * lp.getEmailAddress().sendKeys(un); lp.getPassword().sendKeys(pwd);
	 * 
	 * lp.getSignInBtn().click(); Thread.sleep(15000); }
	 */
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

public void checkItemPresentInListorNot(List<WebElement> listOfProd, String filterName) throws IOException, InterruptedException {

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
			if (listExhibitor.getText().equals(filterName)) {
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

public void createNewList(String newlistname) throws InterruptedException {
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
		newlistname = "Cyb" + genData.generateRandomString(5);
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

public void ClickOnEditBtnOfAnyList(List<WebElement> list, String listName)throws IOException, InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);

		boolean flag = false;
		for (WebElement selectListName : list) {
			if (selectListName.getText().equals(listName)) {
				scrollToElement(selectListName);
				WebElement editBtn = driver
						.findElement(By.xpath("//div[text()='" + listName + "']/../div[2]/span[2]"));
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
public void ClickOnListSelectBtn(List<WebElement> list, String listName)throws IOException, InterruptedException {

	lap = new ATLLandingPage(driver);
	lp = new ATLLoginPage(driver);
	atlmppge = new ATLMarketPlannerPage(driver);

	boolean flag = false;
	for (WebElement selectListName : list) {
		if (selectListName.getText().equals(listName)) {
			scrollToElement(selectListName);
			WebElement editBtn = driver
					.findElement(By.xpath("//div[text()='" + listName + "']/../div[2]/span[1]"));
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
}