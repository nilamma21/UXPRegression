package atlantamarket_PROD;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.AtlantaMarket.ATLExhDigiShowroomPage;
import pageObjects.AtlantaMarket.ATLExhLineProdActionsPage;
import pageObjects.AtlantaMarket.ATLGlobalSearchPage;
import pageObjects.AtlantaMarket.ATLLandingPage;
import pageObjects.AtlantaMarket.ATLLeftPaneFilters;
import pageObjects.AtlantaMarket.ATLLoginPage;
import pageObjects.AtlantaMarket.ATLMarketPlannerPage;
import pageObjects.AtlantaMarket.ATLProductDetailsPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

@Listeners({ TestListeners.class })
public class GlobalSearch_LeftPaneFilters extends base {

	public WebDriverWait wait;
	public GenerateData genData;
	public Utility utl;
	public String exhname;
	ATLLoginPage lp;
	ATLLandingPage lap;
	ATLGlobalSearchPage atlgs;
	ATLExhDigiShowroomPage atlexhdgshw;
	ATLProductDetailsPage atlproddet;
	ATLExhLineProdActionsPage atlexhact;
	ATLMarketPlannerPage atlmppge;
	ATLLeftPaneFilters atlleftpane;

	List<WebElement> exhproductlist,prodcatgitemlist,exhlist, linelist, prodlist, searchexhtypelist, searchproducttypelist, mplists, mpeditlistoptns, allnoteslist,favlist, searchlinetypelist;

	@BeforeClass(alwaysRun=true)
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);

		// Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("atlmrkturl_prod"));
		lap.getIUnderstandBtn().click();
		Thread.sleep(7000);
		//driver.navigate().refresh();
		//Thread.sleep(4000);
	}
	@Test(enabled=false)
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

		lp.getPassword().sendKeys((prop.getProperty("passwordW")));

		Thread.sleep(1000);
	//	lp.getPassword().sendKeys((prop.getProperty("password")));
		Thread.sleep(1000);

		lp.getSignInBtn().click();
		Thread.sleep(15000);
		Assert.assertTrue(driver.getTitle().contains("Atlanta Market at AmericasMart"));
	}
	
	
	@Test(priority = 1)//groups="Non_MP"
	
	public void TS001_VerifySelectionOfApparelVintageProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T404: Selection Of Apparel, Vintage Prod Catg From Left Pane Filters

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		atlleftpane = new ATLLeftPaneFilters(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		utl.loginCheckATL();
		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("filtersglobalsearchinput")));
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);
		
		//Click on Product Categories expand btn
		utl.scrollElementIntoMiddle(atlleftpane.getATLProdCatgExpandBtn());
		Thread.sleep(200);
		atlleftpane.getATLProdCatgExpandBtn().click();
		Thread.sleep(500);
		
		utl.scrollElementIntoMiddle(atlleftpane.getATLApparelVintProdCatg());
		Thread.sleep(200);
		//Select 'Apparel, Vintage' prod category
		String expectedprodcatg = atlleftpane.getATLApparelVintProdCatg().getText();
		atlleftpane.getATLApparelVintProdCatg().click();
		Thread.sleep(5000);

		//Verify the selected Product Category on Exhibitor Digital Showroom page
		//Select 1st Exhibitor from Search results grid
		utl.scrollElementIntoMiddle(atlleftpane.getATLexhibitor());
		Thread.sleep(200);
		atlleftpane.getATLexhibitor().click();
		//Scroll till Product Categories section
		utl.scrollElementIntoMiddle(atlexhdgshw.getATLProductCategSection());
		Thread.sleep(200);
		prodcatgitemlist = atlexhdgshw.getATLProductCategItemList();

		for (int i = 0; i < prodcatgitemlist.size(); i++) {
			if(atlexhdgshw.getATLProductCategTable().isDisplayed()) {
				//System.out.println(prodcatgitemlist.get(i).getText());
				Assert.assertTrue(prodcatgitemlist.get(i).getText().contains(expectedprodcatg));
				break;
			}
		}
		//driver.get(prop.getProperty("atlmrkturl_prod"));
	}

	@Test(priority = 2)//groups="Non_MP"
	public void TS002_VerifySelectionOfAntiqueVintageProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T404: Selection Of Antique/Vintage Prod Catg From Left Pane Filters

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		atlleftpane = new ATLLeftPaneFilters(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.get(prop.getProperty("atlmrkturl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);
		//Click on Product Categories expand btn
		atlleftpane.getATLProdCatgExpandBtn().click();

		utl.scrollElementIntoMiddle(atlleftpane.getATLAntiqueVintProdCatg());
		Thread.sleep(200);
		//Select 'Antique/Vintage' prod category
		String expectedprodcatg = atlleftpane.getATLAntiqueVintProdCatg().getText();
		atlleftpane.getATLAntiqueVintProdCatg().click();
		Thread.sleep(10000);
		//Verify the selected Product Category on Product details page
		utl.scrollElementIntoMiddle(atlexhact.getSecondExhProduct());
		Thread.sleep(200);
		Actions actions = new Actions(driver);
		actions.moveToElement(atlexhact.getSecondExhProduct()).perform();
		// To mouseover on See Details btn
		actions.moveToElement(atlexhact.getSecondExhProductSeeDetailsBtn()).perform();
		// Click on See Details button
		actions.click().perform();	

		//Scroll till Product Categories section
		utl.scrollElementIntoMiddle(atlexhdgshw.getATLProductCategSection());
		Thread.sleep(200);
		prodcatgitemlist = atlexhdgshw.getATLProductCategItemList();

		for (int j = 0; j < prodcatgitemlist.size(); j++) {
			if(atlexhdgshw.getATLProductCategTable().isDisplayed()) {
				//System.out.println(prodcatgitemlist.get(j).getText());
				Assert.assertTrue(prodcatgitemlist.get(j).getText().contains(expectedprodcatg));
				break;
			}
		}
		//driver.get(prop.getProperty("atlmrkturl_prod"));
	}

	@Test(priority = 3)//groups="Non_MP"
	public void TS003_VerifyCombinationWithinProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T405: Combination within Prod Catgs From Left Pane Filters

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		atlleftpane = new ATLLeftPaneFilters(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.get(prop.getProperty("atlmrkturl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("filtersglobalsearchinput")));
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);
		//Click on Product Categories expand btn
		atlleftpane.getATLProdCatgExpandBtn().click();

		utl.scrollElementIntoMiddle(atlleftpane.getATLAntiqueVintProdCatg());
		Thread.sleep(200);
		//Select 'Antique/Vintage' prod category
		String expectedprodcatg1 = atlleftpane.getATLAntiqueVintProdCatg().getText();
		atlleftpane.getATLAntiqueVintProdCatg().click();
		Thread.sleep(6000);
		
		//Select 'Apparel, Vintage' prod category
		String expectedprodcatg2 = atlleftpane.getATLApparelVintProdCatg().getText();
		atlleftpane.getATLApparelVintProdCatg().click();
		Thread.sleep(8000);
/*
		//Verify the selected Product Category on Product details page
		utl.scrollElementIntoMiddle(atlexhact.getProductForMultipleCatg());
		// Hovering on 1st Product
		Actions actions = new Actions(driver);
		actions.moveToElement(atlexhact.getProductForMultipleCatg()).perform();
		// To mouseover on See Details btn
		actions.moveToElement(atlexhact.getThirdExhProdSeeDetailsBtn()).perform();
		// Click on See Details button
		actions.click().perform();

		//Scroll till Product Categories section
		utl.scrollElementIntoMiddle(atlexhdgshw.getATLProductCategSection());
		prodcatgitemlist = atlexhdgshw.getATLProductCategItemList();

		for (int j = 0; j < prodcatgitemlist.size(); j++) {
			if(atlexhdgshw.getATLProductCategTable().isDisplayed()) {
				//System.out.println(prodcatgitemlist.get(j).getText());
				Assert.assertTrue(prodcatgitemlist.get(j).getText().contains(expectedprodcatg1) || prodcatgitemlist.get(j).getText().contains(expectedprodcatg2));
				break;
			}
		}

		driver.navigate().back();
		Thread.sleep(5000);
*/
		//Verify the selected Product Categories on Exhibitor Digital Showroom page
		//Select 1st Exhibitor from Search results grid
		utl.scrollElementIntoMiddle(atlleftpane.getATLexhibitor());
		Thread.sleep(200);
		atlleftpane.getATLexhibitor().click();

		//Scroll till Product Categories section
		utl.scrollElementIntoMiddle(atlexhdgshw.getATLProductCategSection());
		Thread.sleep(200);
		prodcatgitemlist = atlexhdgshw.getATLProductCategItemList();

		for (int i = 0; i < prodcatgitemlist.size(); i++) {
			if(atlexhdgshw.getATLProductCategTable().isDisplayed()) {
				//System.out.println(prodcatgitemlist.get(i).getText());
				Assert.assertTrue(prodcatgitemlist.get(i).getText().contains(expectedprodcatg1) || prodcatgitemlist.get(i).getText().contains(expectedprodcatg2));
				break;
			}
		}
		//driver.get(prop.getProperty("atlmrkturl_prod"));

	}

	@Test(priority = 4)//groups="Non_MP"
	public void TS004_VerifyCombinationOfProdCatgWithStylesFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T406: Combination of Prod Catgs with Styles From Left Pane Filters

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlleftpane = new ATLLeftPaneFilters(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lp = new ATLLoginPage(driver);

		driver.get(prop.getProperty("atlmrkturl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("filtersglobalsearchinput")));
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);
		//Click on Product Categories expand btn
		atlleftpane.getATLProdCatgExpandBtn().click();		
		Thread.sleep(3000);
		/*//Expand btn code
		WebElement pseudoEle = driver.findElement(By.xpath("//label[contains(text(),'Accent Furniture')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String display = js.executeScript("return window.getComputedStyle(arguments[0], ':after').getPropertyValue('display');",pseudoEle).toString();
		System.out.println(display);*/

		utl.scrollElementIntoMiddle(atlleftpane.getATLAntiqueVintProdCatg());
		//Select 'Antique/Vintage' prod category
		String expectedprodcatg = atlleftpane.getATLAntiqueVintProdCatg().getText();
		atlleftpane.getATLAntiqueVintProdCatg().click();
		Thread.sleep(8000);

		//Click on Product Categories expand btn
		utl.scrollElementIntoMiddle(atlleftpane.getATLProdCatgExpandBtn());
		atlleftpane.getATLProdCatgExpandBtn().click();
		Thread.sleep(2000);

		//Click on Styles expand btn
		utl.scrollElementIntoMiddle(atlleftpane.getATLStylesExpandBtn());
		atlleftpane.getATLStylesExpandBtn().click();
		Thread.sleep(7000);
		
		//Select Style name 'Industrial'
		utl.scrollElementIntoMiddle(atlleftpane.getATLIndustrialStyle());
		String expectedstyle = atlleftpane.getATLIndustrialStyle().getText();
		//System.out.println("Expected Style name:"+expectedstyle);
		atlleftpane.getATLIndustrialStyle().click();
		Thread.sleep(12000);

		//Click on IMC Test Exhibitor name in list
		//utl.scrollElementIntoMiddle(atlexhact.getIMCExhibitorName());
		//atlexhact.getIMCExhibitorName().click();
		
		//Click on first exhibitor name
		utl.scrollElementIntoMiddle(atlleftpane.getATLexhibitor());
        atlleftpane.getATLexhibitor().click();
        Thread.sleep(5000);

		//Scroll till Product Categories section
		utl.scrollElementIntoMiddle(atlexhdgshw.getATLProductCategSection());
		prodcatgitemlist = atlexhdgshw.getATLProductCategItemList();

		for (int i = 0; i < prodcatgitemlist.size(); i++) {
			if(atlexhdgshw.getATLProductCategTable().isDisplayed()) {
				//System.out.println(prodcatgitemlist.get(i).getText());
				Assert.assertTrue(prodcatgitemlist.get(i).getText().contains(expectedprodcatg));
				break;
			}
		}

		//Open Exhibitor Portal in new tab
		((JavascriptExecutor)driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("https://exhibitors.andmore.com/");
		Thread.sleep(2000);
		//Login to EXP
		lp.getEmailAddress().sendKeys((prop.getProperty("emailreceiver1")));
		lp.getPassword().sendKeys((prop.getProperty("mppassword")));
		Thread.sleep(500);
		lp.getSignInBtn().click();
		Thread.sleep(15000);

		//In EXP click on Exhibitor association drop down
		atlleftpane.getEXPExhDropDown().click();

		//Select IMC Test Company exhibitor
		//atlleftpane.getIMCExhNameInEXP().click();
		
		String exhibitorName = atlleftpane.getcurrentSelectedExhibitor().getText();
		
		//Check currently selected exhibitor is Garden Iron & More
		if(exhibitorName.contains("Garden Iron & More")) {
			System.out.println("Current selected exhibitor in EXP is: "+exhibitorName);
		}else {
			//Select the Exhibitor - Garden Iron & More
			atlleftpane.getleftPaneFilterExhibitor().click();
			System.out.println("Exhibitor Garden Iron & More is selected");
		}

		//Click on Digital Showroom tab
		atlleftpane.getEXPDigiShowroomTab().click();

		//Click on Profile Info menu
		atlleftpane.getEXPProfileInfoMenu().click();
		Thread.sleep(6000);

		//Scroll till Product Categories section
		utl.scrollElementIntoMiddle(atlleftpane.getEXPProductCategSection());
		Thread.sleep(500);
		//Verify that expected Style should be displayed on profile
		Assert.assertTrue(atlleftpane.getEXPIndustrialStyleOnProfile().isDisplayed());
		driver.close();
		driver.switchTo().window(tabs.get(0));
		//driver.get(prop.getProperty("atlmrkturl_prod"));
	}

	@Test(priority = 5)//groups="Non_MP"
	public void TS005_VerifySelectionOfAccentFurnitureProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T404: Selection Of Accent Furniture Prod Catg From Left Pane Filters

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		atlleftpane = new ATLLeftPaneFilters(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.get(prop.getProperty("atlmrkturl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("filtersglobalsearchinput")));
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);
		//Click on Product Categories expand btn
		atlleftpane.getATLProdCatgExpandBtn().click();
		Thread.sleep(200);
		utl.scrollElementIntoMiddle(atlleftpane.getATLAccentFurnitureProdCatg());
		Thread.sleep(200);
		//Select Accent Furniture prod category
		String expectedprodcatg = atlleftpane.getATLAccentFurnitureProdCatg().getText();
		atlleftpane.getATLAccentFurnitureProdCatg().click();
		Thread.sleep(8000);

		//Verify the selected Product Category on Exh Digital Showroom page
		//Select 1st Exhibitor from Search results grid
		atlleftpane.getATLexhibitor().click();
		Thread.sleep(2000);
		//Scroll till Product Categories section
		utl.scrollElementIntoMiddle(atlexhdgshw.getATLProductCategSection());
		Thread.sleep(200);
		prodcatgitemlist = atlexhdgshw.getATLProductCategItemList();

		for (int i = 0; i < prodcatgitemlist.size(); i++) {
			if(atlexhdgshw.getATLProductCategTable().isDisplayed()) {
				//System.out.println(prodcatgitemlist.get(i).getText());
				Assert.assertTrue(prodcatgitemlist.get(i).getText().contains(expectedprodcatg));
				break;
			}
		}
		//driver.get(prop.getProperty("atlmrkturl_prod"));
	}

	@Test(priority = 6)//groups="Non_MP"
	public void TS006_VerifySelectionOfHolidayProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T404: Selection Of Holiday/Seasonal Prod Catg From Left Pane Filters

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		atlleftpane = new ATLLeftPaneFilters(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.get(prop.getProperty("atlmrkturl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);

		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("leftpanefilterinput"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(6000);

		//Click on Product Categories expand btn
		atlleftpane.getATLProdCatgExpandBtn().click();

		utl.scrollElementIntoMiddle(atlleftpane.getATLHolidayProdCatg());
		Thread.sleep(200);
		//Select Holiday/Seasonal prod category
		String expectedprodcatg = atlleftpane.getATLHolidayProdCatg().getText();
		atlleftpane.getATLHolidayProdCatg().click();
		Thread.sleep(8000);

		//Verify the selected Product Categories on Exhibitor Digital Showroom page
		//Select 1st Exhibitor from Search results grid
		utl.scrollElementIntoMiddle(atlleftpane.getATLexhibitor());
		Thread.sleep(200);
		atlleftpane.getATLexhibitor().click();

		//Scroll till Product Categories section
		utl.scrollElementIntoMiddle(atlexhdgshw.getATLProductCategSection());
		Thread.sleep(200);
		prodcatgitemlist = atlexhdgshw.getATLProductCategItemList();

		for (int i = 0; i < prodcatgitemlist.size(); i++) {
			if(atlexhdgshw.getATLProductCategTable().isDisplayed()) {
				//System.out.println(prodcatgitemlist.get(i).getText());
				Assert.assertTrue(prodcatgitemlist.get(i).getText().contains(expectedprodcatg));
				break;
			}
		}
		driver.navigate().back();
		Thread.sleep(5000);

		//Verify the selected Product Category on Product details page
		utl.scrollElementIntoMiddle(atlexhact.getProductForMultipleCatg());
		Thread.sleep(1000);
		// Hovering on 1st Product
		Actions actions = new Actions(driver);
		actions.moveToElement(atlexhact.getProductForMultipleCatg()).perform();
		Thread.sleep(200);
		// To mouseover on See Details btn
		actions.moveToElement(atlexhact.getProdSeeDetailsBtn()).perform();
		// Click on See Details button
		actions.click().perform();
		Thread.sleep(2000);
		//Scroll till Product Categories section
		utl.scrollElementIntoMiddle(atlexhdgshw.getATLProductCategSection());
		Thread.sleep(200);
		prodcatgitemlist = atlexhdgshw.getATLProductCategItemList();

		for (int j = 0; j < prodcatgitemlist.size(); j++) {
			if(atlexhdgshw.getATLProductCategTable().isDisplayed()) {
				//System.out.println(prodcatgitemlist.get(j).getText());
				Assert.assertTrue(prodcatgitemlist.get(j).getText().contains(expectedprodcatg));
				break;
			}
		}
	}

	@Test(priority =7)//groups="Non_MP"
	public void TS007_VerifySelectionOfDecorativeAccessProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T404: Selection Of Decorative Accessories Prod Catg From Left Pane Filters

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		atlleftpane = new ATLLeftPaneFilters(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.get(prop.getProperty("atlmrkturl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(4000);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("leftpanefilterinput6")));
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);
		//Click on Product Categories expand btn
		atlleftpane.getATLProdCatgExpandBtn().click();

		utl.scrollElementIntoMiddle(atlleftpane.getATLDecorativeAccProdCatg());
		Thread.sleep(200);
		//Select Decorative Accessories prod category
		String expectedprodcatg = atlleftpane.getATLDecorativeAccProdCatg().getText();
		atlleftpane.getATLDecorativeAccProdCatg().click();
		Thread.sleep(8000);

		//Verify the selected Product Categories on product details page
		utl.scrollElementIntoMiddle(atlexhact.getExhibitorProduct());
		Thread.sleep(200);
		// Hovering on 1st Product
		Actions actions = new Actions(driver);
		actions.moveToElement(atlexhact.getExhibitorProduct()).perform();
		// To mouseover on See Details btn
		actions.moveToElement(atlexhact.getProdSeeDetailsBtn()).perform();
		// Click on See Details button
		actions.click().perform();
		Thread.sleep(2000);
		//Scroll till Product Categories section
		utl.scrollElementIntoMiddle(atlexhdgshw.getATLProductCategSection());
		Thread.sleep(200);
		prodcatgitemlist = atlexhdgshw.getATLProductCategItemList();

		for (int j = 0; j < prodcatgitemlist.size(); j++) {
			if(atlexhdgshw.getATLProductCategTable().isDisplayed()) {
				//System.out.println(prodcatgitemlist.get(j).getText());
				Assert.assertTrue(prodcatgitemlist.get(j).getText().contains(expectedprodcatg));
				break;
			}
		}
		//driver.get(prop.getProperty("atlmrkturl_prod"));
	}

	@Test(priority =8)//groups="Non_MP"
	public void TS008_VerifySelectionOfGeneralGiftProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T404: Selection Of General Gift Prod Catg From Left Pane Filters

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		atlleftpane = new ATLLeftPaneFilters(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.get(prop.getProperty("atlmrkturl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);

		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("leftpanefilterinput2"));
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);
		//Click on Product Categories expand btn
		atlleftpane.getATLProdCatgExpandBtn().click();

		utl.scrollElementIntoMiddle(atlleftpane.getATLGeneralGiftProdCatg());
		Thread.sleep(200);
		//Select General Gift prod category
		String expectedprodcatg = atlleftpane.getATLGeneralGiftProdCatg().getText();
		atlleftpane.getATLGeneralGiftProdCatg().click();
		Thread.sleep(10000);

		//Verify the selected Product Categories on product details page
		utl.scrollElementIntoMiddle(atlexhact.getExhibitorProduct());
		Thread.sleep(200);
		// Hovering on 1st Product
		Actions actions = new Actions(driver);
		actions.moveToElement(atlexhact.getExhibitorProduct()).perform();
		// To mouseover on See Details btn
		actions.moveToElement(atlexhact.getProdSeeDetailsBtn()).perform();
		// Click on See Details button
		actions.click().perform();

		//Scroll till Product Categories section
		utl.scrollElementIntoMiddle(atlexhdgshw.getATLProductCategSection());
		Thread.sleep(200);
		prodcatgitemlist = atlexhdgshw.getATLProductCategItemList();

		for (int j = 0; j < prodcatgitemlist.size(); j++) {
			if(atlexhdgshw.getATLProductCategTable().isDisplayed()) {
				//System.out.println(prodcatgitemlist.get(j).getText());
				Assert.assertTrue(prodcatgitemlist.get(j).getText().contains(expectedprodcatg));
				break;
			}
		}
		//driver.get(prop.getProperty("atlmrkturl_prod"));
	}

	@Test(priority = 9)//groups="Non_MP"
	public void TS009_VerifySelectionOfFashionAccProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T404: Selection Of Fashion Accessories/Jewelry Prod Catg From Left Pane Filters

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		atlleftpane = new ATLLeftPaneFilters(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.get(prop.getProperty("atlmrkturl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("leftpanefilterinput5")));
		atlgs.getATLSearchButton().click();
		Thread.sleep(6000);

		//Click on Product Categories expand btn
		atlleftpane.getATLProdCatgExpandBtn().click();

		utl.scrollElementIntoMiddle(atlleftpane.getATLFashionAccProdCatg());
		Thread.sleep(200);
		//Select Fashion Accessories/Jewelry prod category
		String expectedprodcatg = atlleftpane.getATLFashionAccProdCatg().getText();
		atlleftpane.getATLFashionAccProdCatg().click();
		Thread.sleep(8000);

		//Verify the selected Product Categories on Exhibitor Digital Showroom page
		//Select 1st Exhibitor from Search results grid
		utl.scrollElementIntoMiddle(atlleftpane.getATLexhibitor());
		Thread.sleep(200);
		atlleftpane.getATLexhibitor().click();

		//Scroll till Product Categories section
		utl.scrollElementIntoMiddle(atlexhdgshw.getATLProductCategSection());
		Thread.sleep(200);
		prodcatgitemlist = atlexhdgshw.getATLProductCategItemList();

		for (int i = 0; i < prodcatgitemlist.size(); i++) {
			if(atlexhdgshw.getATLProductCategTable().isDisplayed()) {
				//System.out.println(prodcatgitemlist.get(i).getText());
				Assert.assertTrue(prodcatgitemlist.get(i).getText().contains(expectedprodcatg));
				break;
			}
		}
		driver.navigate().back();
		Thread.sleep(8000);

/*		//Verify the selected Product Category on Product details page
		utl.scrollElementIntoMiddle(atlexhact.getProductForMultipleCatg());
		// Hovering on 1st Product
		Actions actions = new Actions(driver);
		actions.moveToElement(atlexhact.getProductForMultipleCatg()).perform();
		// To mouseover on See Details btn
		actions.moveToElement(atlexhact.getThirdExhProdSeeDetailsBtn()).perform();
		// Click on See Details button
		actions.click().perform();

		//Scroll till Product Categories section
		utl.scrollElementIntoMiddle(atlexhdgshw.getATLProductCategSection());
		prodcatgitemlist = atlexhdgshw.getATLProductCategItemList();

		for (int j = 0; j < prodcatgitemlist.size(); j++) {
			if(atlexhdgshw.getATLProductCategTable().isDisplayed()) {
				//System.out.println(prodcatgitemlist.get(j).getText());
				Assert.assertTrue(prodcatgitemlist.get(j).getText().contains(expectedprodcatg));
				break;
			}
		}*/
		//driver.get(prop.getProperty("atlmrkturl_prod"));
	}

	@Test(priority =10)//groups="Non_MP"
	public void TS010_VerifySelectionOfFloralBotanicalsProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T404: Selection Of Floral / Botanicals Prod Catg From Left Pane Filters

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		atlleftpane = new ATLLeftPaneFilters(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.get(prop.getProperty("atlmrkturl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(4000);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("leftpanefilterinput7")));
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);
		//Click on Product Categories expand btn
		utl.scrollElementIntoMiddle(atlleftpane.getATLProdCatgExpandBtn());
		Thread.sleep(200);
		atlleftpane.getATLProdCatgExpandBtn().click();
		Thread.sleep(3000);
		utl.scrollElementIntoMiddle(atlleftpane.getATLFloralBotanicalsProdCatg());
		Thread.sleep(200);
		//Select Floral / Botanicals prod category
		String expectedprodcatg = atlleftpane.getATLFloralBotanicalsProdCatg().getText();
		atlleftpane.getATLFloralBotanicalsProdCatg().click();
		Thread.sleep(8000);

		//Verify the selected Product Categories on product details page
		utl.scrollElementIntoMiddle(atlexhact.getExhibitorProduct());
		Thread.sleep(200);
		// Hovering on 1st Product
		Actions actions = new Actions(driver);
		actions.moveToElement(atlexhact.getExhibitorProduct()).perform();
		// To mouseover on See Details btn
		actions.moveToElement(atlexhact.getProdSeeDetailsBtn()).perform();
		// Click on See Details button
		actions.click().perform();
		Thread.sleep(3000);
		//Scroll till Product Categories section
		utl.scrollElementIntoMiddle(atlexhdgshw.getATLProductCategSection());
		prodcatgitemlist = atlexhdgshw.getATLProductCategItemList();

		for (int j = 0; j < prodcatgitemlist.size(); j++) {
			if(atlexhdgshw.getATLProductCategTable().isDisplayed()) {
				//System.out.println(prodcatgitemlist.get(j).getText());
				Assert.assertTrue(prodcatgitemlist.get(j).getText().contains(expectedprodcatg));
				break;
			}
		}
		//driver.get(prop.getProperty("atlmrkturl_prod"));
	}

	@Test(priority =11)//groups="Non_MP"
	public void TS011_VerifySelectionOfHomeTextilesProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T404: Selection Of Home Textiles Prod Catg From Left Pane Filters

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		atlleftpane = new ATLLeftPaneFilters(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.get(prop.getProperty("atlmrkturl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(1000);
		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("exhibitor8")));
		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);
		//Click on Product Categories expand btn
		utl.scrollElementIntoMiddle(atlleftpane.getATLProdCatgExpandBtn());
		atlleftpane.getATLProdCatgExpandBtn().click();

		utl.scrollElementIntoMiddle(atlleftpane.getATLHomeTextilesProdCatg());

		//Select Home Textiles prod category
		String expectedprodcatg = atlleftpane.getATLHomeTextilesProdCatg().getText();
		atlleftpane.getATLHomeTextilesProdCatg().click();
		Thread.sleep(8000);
		System.out.println(expectedprodcatg);
		//Verify the selected Product Categories on product details page
		//Select 1st Exhibitor from Search results grid
		utl.scrollElementIntoMiddle(atlleftpane.getATLexhibitor());
		Thread.sleep(200);
		atlleftpane.getATLexhibitor().click();
		
		//Scroll till Product Categories section
		utl.scrollElementIntoMiddle(atlexhdgshw.getATLProductCategSection());
		prodcatgitemlist = atlexhdgshw.getATLProductCategItemList();

		for (int i = 0; i < prodcatgitemlist.size(); i++) {
			if(atlexhdgshw.getATLProductCategTable().isDisplayed()) {
				//System.out.println(prodcatgitemlist.get(i).getText());
				Assert.assertTrue(prodcatgitemlist.get(i).getText().contains(expectedprodcatg));
				break;
			}
		}
		driver.get(prop.getProperty("atlmrkturl_prod"));
	}


	@AfterClass(alwaysRun=true)
	public void tearDown()
	{
		//driver.quit();
	}
}
