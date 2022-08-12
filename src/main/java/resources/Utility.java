
package resources;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import pageObjects.AtlantaMarket.ATLExhLineProdActionsPage;
import pageObjects.AtlantaMarket.ATLLandingPage;
import pageObjects.AtlantaMarket.ATLLoginPage;


public class Utility extends base {

	// public WebDriver driver;
	ATLLandingPage lap;
	ATLLoginPage lp;
	ATLExhLineProdActionsPage atlexhact;

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

	public void verifyMPInvalidLoginFunctionality(String un,String pwd) throws IOException, InterruptedException {

		// The purpose of this test case to verify:-
		// TS1- Login to Market Planner

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);		

		// Click on Login button from Landing Page
		lap.getLogin().click();

		// Enter the credentials on Login Page and click
		lp.getEmailAddress().sendKeys(un);
		lp.getPassword().sendKeys(pwd);

		lp.getSignInBtn().click();
		Thread.sleep(15000);
	}
	
	
	public void mouseHover(WebElement mainMenu,WebElement subMenu) throws IOException, InterruptedException {

		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);		
		atlexhact = new ATLExhLineProdActionsPage(driver);
		//Instantiating Actions class
		Actions actions = new Actions(driver);
		//Hovering on main menu
		actions.moveToElement(mainMenu);
		//To mouseover on sub menu
		actions.moveToElement(subMenu);
		//build()- used to compile all the actions into a single step 
		actions.click().build().perform();

	}

	
}
