package atlantamarket_PROD;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sun.jna.platform.win32.OaIdl.SYSKIND;

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

	@BeforeClass
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);

		// Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("atlmrkturl_prod"));
		//lap.getIUnderstandBtn().click();
		Thread.sleep(7000);
		//lap.getCloseMarktAdBtn().click();

		//Login to Market Planner
		//utl.verifyMPLoginFunctionality();

		//Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();
	}

	@Test(priority = 1)
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

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("filtersglobalsearchinput")));
		atlgs.getATLSearchButton().click();

		//Click on Product Categories expand btn
		atlleftpane.getATLProdCatgExpandBtn().click();

		utl.scrollToElement(atlleftpane.getATLApparelVintProdCatg());

		//Select 'Apparel, Vintage' prod category
		String expectedprodcatg = atlleftpane.getATLApparelVintProdCatg().getText();
		atlleftpane.getATLApparelVintProdCatg().click();
		Thread.sleep(8000);

		//Verify the selected Product Category on Exhibitor Digital Showroom page
		//Select 1st Exhibitor from Search results grid
		atlleftpane.getATLexhibitor().click();

		//Scroll till Product Categories section
		utl.scrollToElement(atlexhdgshw.getATLProductCategSection());
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

	@Test(priority = 2)
	public void TS002_VerifySelectionOfAntiqueVintageProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T404: Selection Of Antique/Vintage Prod Catg From Left Pane Filters

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		atlleftpane = new ATLLeftPaneFilters(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(prop.getProperty("atlmrkturl_prod"));

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("filtersglobalsearchinput")));
		atlgs.getATLSearchButton().click();

		//Click on Product Categories expand btn
		atlleftpane.getATLProdCatgExpandBtn().click();

		utl.scrollToElement(atlleftpane.getATLAntiqueVintProdCatg());

		//Select 'Antique/Vintage' prod category
		String expectedprodcatg = atlleftpane.getATLAntiqueVintProdCatg().getText();
		atlleftpane.getATLAntiqueVintProdCatg().click();
		Thread.sleep(8000);

		//Verify the selected Product Category on Product details page
		utl.scrollToElement(atlexhact.getExhibitorProduct());
		// Hovering on 1st Product
		Actions actions = new Actions(driver);
		actions.moveToElement(atlexhact.getExhibitorProduct()).perform();
		// To mouseover on See Details btn
		actions.moveToElement(atlexhact.getProdSeeDetailsBtn()).perform();
		// Click on See Details button
		actions.click().perform();

		//Scroll till Product Categories section
		utl.scrollToElement(atlexhdgshw.getATLProductCategSection());
		prodcatgitemlist = atlexhdgshw.getATLProductCategItemList();

		for (int j = 0; j < prodcatgitemlist.size(); j++) {
			if(atlexhdgshw.getATLProductCategTable().isDisplayed()) {
				System.out.println(prodcatgitemlist.get(j).getText());
				Assert.assertTrue(prodcatgitemlist.get(j).getText().contains(expectedprodcatg));
				break;
			}
		}
		//driver.get(prop.getProperty("atlmrkturl_prod"));
	}

	@Test(priority = 3)
	public void TS003_VerifyCombinationWithinProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T405: Combination within Prod Catgs From Left Pane Filters

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		atlleftpane = new ATLLeftPaneFilters(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(prop.getProperty("atlmrkturl_prod"));

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("filtersglobalsearchinput")));
		atlgs.getATLSearchButton().click();

		//Click on Product Categories expand btn
		atlleftpane.getATLProdCatgExpandBtn().click();

		utl.scrollToElement(atlleftpane.getATLAntiqueVintProdCatg());

		//Select 'Antique/Vintage' prod category
		String expectedprodcatg1 = atlleftpane.getATLAntiqueVintProdCatg().getText();
		atlleftpane.getATLAntiqueVintProdCatg().click();

		//Select 'Apparel, Vintage' prod category
		String expectedprodcatg2 = atlleftpane.getATLApparelVintProdCatg().getText();
		atlleftpane.getATLApparelVintProdCatg().click();
		Thread.sleep(8000);

		//Verify the selected Product Categories on Exhibitor Digital Showroom page
		//Select 1st Exhibitor from Search results grid
		atlleftpane.getATLexhibitor().click();

		//Scroll till Product Categories section
		utl.scrollToElement(atlexhdgshw.getATLProductCategSection());
		prodcatgitemlist = atlexhdgshw.getATLProductCategItemList();

		for (int i = 0; i < prodcatgitemlist.size(); i++) {
			if(atlexhdgshw.getATLProductCategTable().isDisplayed()) {
				System.out.println(prodcatgitemlist.get(i).getText());
				Assert.assertTrue(prodcatgitemlist.get(i).getText().contains(expectedprodcatg1) || prodcatgitemlist.get(i).getText().contains(expectedprodcatg2));
				break;
			}
		}
		driver.navigate().back();
		Thread.sleep(5000);

		//Verify the selected Product Category on Product details page
		utl.scrollToElement(atlexhact.getProductForMultipleCatg());
		// Hovering on 1st Product
		Actions actions = new Actions(driver);
		actions.moveToElement(atlexhact.getProductForMultipleCatg()).perform();
		// To mouseover on See Details btn
		actions.moveToElement(atlexhact.getThirdExhProdSeeDetailsBtn()).perform();
		// Click on See Details button
		actions.click().perform();

		//Scroll till Product Categories section
		utl.scrollToElement(atlexhdgshw.getATLProductCategSection());
		prodcatgitemlist = atlexhdgshw.getATLProductCategItemList();

		for (int j = 0; j < prodcatgitemlist.size(); j++) {
			if(atlexhdgshw.getATLProductCategTable().isDisplayed()) {
				System.out.println(prodcatgitemlist.get(j).getText());
				Assert.assertTrue(prodcatgitemlist.get(j).getText().contains(expectedprodcatg1) || prodcatgitemlist.get(j).getText().contains(expectedprodcatg2));
				break;
			}
		}
		//driver.get(prop.getProperty("atlmrkturl_prod"));
	}

	@Test(priority = 4)
	public void TS004_VerifyCombinationOfProdCatgWithStylesFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T406: Combination of Prod Catgs with Styles From Left Pane Filters

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlleftpane = new ATLLeftPaneFilters(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lp = new ATLLoginPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(prop.getProperty("atlmrkturl_prod"));

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("filtersglobalsearchinput")));
		atlgs.getATLSearchButton().click();

		//Click on Product Categories expand btn
		atlleftpane.getATLProdCatgExpandBtn().click();		

		/*//Expand btn code
		WebElement pseudoEle = driver.findElement(By.xpath("//label[contains(text(),'Accent Furniture')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String display = js.executeScript("return window.getComputedStyle(arguments[0], ':after').getPropertyValue('display');",pseudoEle).toString();
		System.out.println(display);*/

		utl.scrollToElement(atlleftpane.getATLAntiqueVintProdCatg());

		//Select 'Antique/Vintage' prod category
		String expectedprodcatg = atlleftpane.getATLAntiqueVintProdCatg().getText();
		atlleftpane.getATLAntiqueVintProdCatg().click();
		Thread.sleep(8000);

		//Click on Product Categories expand btn
		atlleftpane.getATLProdCatgExpandBtn().click();

		//Click on Styles expand btn
		atlleftpane.getATLStylesExpandBtn().click();

		//Select Style name 'Industrial'
		utl.scrollToElement(atlleftpane.getATLIndustrialStyle());
		String expectedstyle = atlleftpane.getATLIndustrialStyle().getText();
		System.out.println("Expected Style name:"+expectedstyle);
		atlleftpane.getATLIndustrialStyle().click();
		Thread.sleep(8000);

		//Click on IMC Test Exhibitor name in list
		atlexhact.getIMCExhibitorName().click();

		//Scroll till Product Categories section
		utl.scrollToElement(atlexhdgshw.getATLProductCategSection());
		prodcatgitemlist = atlexhdgshw.getATLProductCategItemList();

		for (int i = 0; i < prodcatgitemlist.size(); i++) {
			if(atlexhdgshw.getATLProductCategTable().isDisplayed()) {
				//System.out.println(prodcatgitemlist.get(i).getText());
				Assert.assertTrue(prodcatgitemlist.get(i).getText().contains(expectedprodcatg));
				break;
			}
		}

		driver.navigate().back();

		//Open Exhibitor Portal in new tab
		((JavascriptExecutor)driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("https://exhibitors.imcenters.com/");

		//Login to EXP
		lp.getEmailAddress().sendKeys((prop.getProperty("username")));
		lp.getPassword().sendKeys((prop.getProperty("password")));

		lp.getSignInBtn().click();
		Thread.sleep(15000);

		//In EXP click on Exhibitor association drop down
		atlleftpane.getEXPExhDropDown().click();

		//Select IMC Test Company exhibitor
		atlleftpane.getIMCExhNameInEXP().click();

		//Click on Digital Showroom tab
		atlleftpane.getEXPDigiShowroomTab().click();

		//Click on Profile Info menu
		atlleftpane.getEXPProfileInfoMenu().click();
		Thread.sleep(6000);

		//Scroll till Product Categories section
		utl.scrollToElement(atlleftpane.getEXPProductCategSection());

		//Verify that expected Style should be displayed on profile
		Assert.assertTrue(atlleftpane.getEXPIndustrialStyleOnProfile().isDisplayed());
		driver.close();
		driver.switchTo().window(tabs.get(0));
		//driver.get(prop.getProperty("atlmrkturl_prod"));
	}

	@Test(priority = 5)
	public void TS005_VerifySelectionOfAccentFurnitureProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T404: Selection Of Accent Furniture Prod Catg From Left Pane Filters

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		atlleftpane = new ATLLeftPaneFilters(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(prop.getProperty("atlmrkturl_prod"));

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("filtersglobalsearchinput")));
		atlgs.getATLSearchButton().click();

		//Click on Product Categories expand btn
		atlleftpane.getATLProdCatgExpandBtn().click();

		utl.scrollToElement(atlleftpane.getATLAccentFurnitureProdCatg());

		//Select Accent Furniture prod category
		String expectedprodcatg = atlleftpane.getATLAccentFurnitureProdCatg().getText();
		atlleftpane.getATLAccentFurnitureProdCatg().click();
		Thread.sleep(8000);

		//Verify the selected Product Category on Product details page
		utl.scrollToElement(atlexhact.getExhibitorProduct());
		// Hovering on 1st Product
		Actions actions = new Actions(driver);
		actions.moveToElement(atlexhact.getExhibitorProduct()).perform();
		// To mouseover on See Details btn
		actions.moveToElement(atlexhact.getProdSeeDetailsBtn()).perform();
		// Click on See Details button
		actions.click().perform();

		//Scroll till Product Categories section
		utl.scrollToElement(atlexhdgshw.getATLProductCategSection());
		prodcatgitemlist = atlexhdgshw.getATLProductCategItemList();

		for (int j = 0; j < prodcatgitemlist.size(); j++) {
			if(atlexhdgshw.getATLProductCategTable().isDisplayed()) {
				System.out.println(prodcatgitemlist.get(j).getText());
				Assert.assertTrue(prodcatgitemlist.get(j).getText().contains(expectedprodcatg));
				break;
			}
		}
		//driver.get(prop.getProperty("atlmrkturl_prod"));
	}

	@Test(priority = 6)
	public void TS006_VerifySelectionOfHolidayProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T404: Selection Of Holiday/Seasonal Prod Catg From Left Pane Filters

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		atlleftpane = new ATLLeftPaneFilters(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(prop.getProperty("atlmrkturl_prod"));

		atlgs.getATLGlobalSearchTextBox().sendKeys("Anne");
		atlgs.getATLSearchButton().click();
		Thread.sleep(6000);

		//Click on Product Categories expand btn
		atlleftpane.getATLProdCatgExpandBtn().click();

		utl.scrollToElement(atlleftpane.getATLHolidayProdCatg());

		//Select Holiday/Seasonal prod category
		String expectedprodcatg = atlleftpane.getATLHolidayProdCatg().getText();
		atlleftpane.getATLHolidayProdCatg().click();
		Thread.sleep(8000);

		//Verify the selected Product Categories on Exhibitor Digital Showroom page
		//Select 1st Exhibitor from Search results grid
		atlleftpane.getATLexhibitor().click();

		//Scroll till Product Categories section
		utl.scrollToElement(atlexhdgshw.getATLProductCategSection());
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
		utl.scrollToElement(atlexhact.getProductForMultipleCatg());
		// Hovering on 1st Product
		Actions actions = new Actions(driver);
		actions.moveToElement(atlexhact.getProductForMultipleCatg()).perform();
		// To mouseover on See Details btn
		actions.moveToElement(atlexhact.getThirdExhProdSeeDetailsBtn()).perform();
		// Click on See Details button
		actions.click().perform();

		//Scroll till Product Categories section
		utl.scrollToElement(atlexhdgshw.getATLProductCategSection());
		prodcatgitemlist = atlexhdgshw.getATLProductCategItemList();

		for (int j = 0; j < prodcatgitemlist.size(); j++) {
			if(atlexhdgshw.getATLProductCategTable().isDisplayed()) {
				//System.out.println(prodcatgitemlist.get(j).getText());
				Assert.assertTrue(prodcatgitemlist.get(j).getText().contains(expectedprodcatg));
				break;
			}
		}
	}

	@Test(priority =7)
	public void TS007_VerifySelectionOfDecorativeAccessProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T404: Selection Of Decorative Accessories Prod Catg From Left Pane Filters

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		atlleftpane = new ATLLeftPaneFilters(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(prop.getProperty("atlmrkturl_prod"));

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("filtersglobalsearchinput")));
		atlgs.getATLSearchButton().click();

		//Click on Product Categories expand btn
		atlleftpane.getATLProdCatgExpandBtn().click();

		utl.scrollToElement(atlleftpane.getATLDecorativeAccProdCatg());

		//Select Decorative Accessories prod category
		String expectedprodcatg = atlleftpane.getATLDecorativeAccProdCatg().getText();
		atlleftpane.getATLDecorativeAccProdCatg().click();
		Thread.sleep(8000);

		//Verify the selected Product Categories on product details page
		utl.scrollToElement(atlexhact.getExhibitorProduct());
		// Hovering on 1st Product
		Actions actions = new Actions(driver);
		actions.moveToElement(atlexhact.getExhibitorProduct()).perform();
		// To mouseover on See Details btn
		actions.moveToElement(atlexhact.getProdSeeDetailsBtn()).perform();
		// Click on See Details button
		actions.click().perform();

		//Scroll till Product Categories section
		utl.scrollToElement(atlexhdgshw.getATLProductCategSection());
		prodcatgitemlist = atlexhdgshw.getATLProductCategItemList();

		for (int j = 0; j < prodcatgitemlist.size(); j++) {
			if(atlexhdgshw.getATLProductCategTable().isDisplayed()) {
				System.out.println(prodcatgitemlist.get(j).getText());
				Assert.assertTrue(prodcatgitemlist.get(j).getText().contains(expectedprodcatg));
				break;
			}
		}
		//driver.get(prop.getProperty("atlmrkturl_prod"));
	}

	@Test(priority =8)
	public void TS008_VerifySelectionOfGeneralGiftProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T404: Selection Of General Gift Prod Catg From Left Pane Filters

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		atlleftpane = new ATLLeftPaneFilters(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(prop.getProperty("atlmrkturl_prod"));

		atlgs.getATLGlobalSearchTextBox().sendKeys("Anne");
		atlgs.getATLSearchButton().click();

		//Click on Product Categories expand btn
		atlleftpane.getATLProdCatgExpandBtn().click();

		utl.scrollToElement(atlleftpane.getATLGeneralGiftProdCatg());

		//Select General Gift prod category
		String expectedprodcatg = atlleftpane.getATLGeneralGiftProdCatg().getText();
		atlleftpane.getATLGeneralGiftProdCatg().click();
		Thread.sleep(8000);

		//Verify the selected Product Categories on product details page
		utl.scrollToElement(atlexhact.getExhibitorProduct());
		// Hovering on 1st Product
		Actions actions = new Actions(driver);
		actions.moveToElement(atlexhact.getExhibitorProduct()).perform();
		// To mouseover on See Details btn
		actions.moveToElement(atlexhact.getProdSeeDetailsBtn()).perform();
		// Click on See Details button
		actions.click().perform();

		//Scroll till Product Categories section
		utl.scrollToElement(atlexhdgshw.getATLProductCategSection());
		prodcatgitemlist = atlexhdgshw.getATLProductCategItemList();

		for (int j = 0; j < prodcatgitemlist.size(); j++) {
			if(atlexhdgshw.getATLProductCategTable().isDisplayed()) {
				System.out.println(prodcatgitemlist.get(j).getText());
				Assert.assertTrue(prodcatgitemlist.get(j).getText().contains(expectedprodcatg));
				break;
			}
		}
		//driver.get(prop.getProperty("atlmrkturl_prod"));
	}

	@Test(priority = 9)
	public void TS009_VerifySelectionOfFashionAccProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T404: Selection Of Fashion Accessories/Jewelry Prod Catg From Left Pane Filters

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		atlleftpane = new ATLLeftPaneFilters(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("atlmrkturl_prod"));

		atlgs.getATLGlobalSearchTextBox().sendKeys("Anne");
		atlgs.getATLSearchButton().click();
		Thread.sleep(6000);
		
		//Click on Product Categories expand btn
		atlleftpane.getATLProdCatgExpandBtn().click();

		utl.scrollToElement(atlleftpane.getATLFashionAccProdCatg());

		//Select Fashion Accessories/Jewelry prod category
		String expectedprodcatg = atlleftpane.getATLFashionAccProdCatg().getText();
		atlleftpane.getATLFashionAccProdCatg().click();
		Thread.sleep(8000);

		//Verify the selected Product Categories on Exhibitor Digital Showroom page
		//Select 1st Exhibitor from Search results grid
		atlleftpane.getATLexhibitor().click();

		//Scroll till Product Categories section
		utl.scrollToElement(atlexhdgshw.getATLProductCategSection());
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
		utl.scrollToElement(atlexhact.getProductForMultipleCatg());
		// Hovering on 1st Product
		Actions actions = new Actions(driver);
		actions.moveToElement(atlexhact.getProductForMultipleCatg()).perform();
		// To mouseover on See Details btn
		actions.moveToElement(atlexhact.getThirdExhProdSeeDetailsBtn()).perform();
		// Click on See Details button
		actions.click().perform();

		//Scroll till Product Categories section
		utl.scrollToElement(atlexhdgshw.getATLProductCategSection());
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

	@Test(priority =10)
	public void TS010_VerifySelectionOfFloralBotanicalsProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T404: Selection Of Floral / Botanicals Prod Catg From Left Pane Filters

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		atlleftpane = new ATLLeftPaneFilters(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(prop.getProperty("atlmrkturl_prod"));

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("filtersglobalsearchinput")));
		atlgs.getATLSearchButton().click();

		//Click on Product Categories expand btn
		atlleftpane.getATLProdCatgExpandBtn().click();

		utl.scrollToElement(atlleftpane.getATLFloralBotanicalsProdCatg());

		//Select Floral / Botanicals prod category
		String expectedprodcatg = atlleftpane.getATLFloralBotanicalsProdCatg().getText();
		atlleftpane.getATLFloralBotanicalsProdCatg().click();
		Thread.sleep(8000);

		//Verify the selected Product Categories on product details page
		utl.scrollToElement(atlexhact.getExhibitorProduct());
		// Hovering on 1st Product
		Actions actions = new Actions(driver);
		actions.moveToElement(atlexhact.getExhibitorProduct()).perform();
		// To mouseover on See Details btn
		actions.moveToElement(atlexhact.getProdSeeDetailsBtn()).perform();
		// Click on See Details button
		actions.click().perform();

		//Scroll till Product Categories section
		utl.scrollToElement(atlexhdgshw.getATLProductCategSection());
		prodcatgitemlist = atlexhdgshw.getATLProductCategItemList();

		for (int j = 0; j < prodcatgitemlist.size(); j++) {
			if(atlexhdgshw.getATLProductCategTable().isDisplayed()) {
				System.out.println(prodcatgitemlist.get(j).getText());
				Assert.assertTrue(prodcatgitemlist.get(j).getText().contains(expectedprodcatg));
				break;
			}
		}
		//driver.get(prop.getProperty("atlmrkturl_prod"));
	}

	@Test(priority =11)
	public void TS011_VerifySelectionOfHomeTextilesProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T404: Selection Of Home Textiles Prod Catg From Left Pane Filters

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		atlleftpane = new ATLLeftPaneFilters(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(prop.getProperty("atlmrkturl_prod"));

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("filtersglobalsearchinput")));
		atlgs.getATLSearchButton().click();

		//Click on Product Categories expand btn
		atlleftpane.getATLProdCatgExpandBtn().click();

		utl.scrollToElement(atlleftpane.getATLHomeTextilesProdCatg());

		//Select Home Textiles prod category
		String expectedprodcatg = atlleftpane.getATLHomeTextilesProdCatg().getText();
		atlleftpane.getATLHomeTextilesProdCatg().click();
		Thread.sleep(8000);

		//Verify the selected Product Categories on product details page
		utl.scrollToElement(atlexhact.getExhibitorProduct());
		// Hovering on 1st Product
		Actions actions = new Actions(driver);
		actions.moveToElement(atlexhact.getExhibitorProduct()).perform();
		// To mouseover on See Details btn
		actions.moveToElement(atlexhact.getProdSeeDetailsBtn()).perform();
		// Click on See Details button
		actions.click().perform();

		//Scroll till Product Categories section
		utl.scrollToElement(atlexhdgshw.getATLProductCategSection());
		prodcatgitemlist = atlexhdgshw.getATLProductCategItemList();

		for (int j = 0; j < prodcatgitemlist.size(); j++) {
			if(atlexhdgshw.getATLProductCategTable().isDisplayed()) {
				System.out.println(prodcatgitemlist.get(j).getText());
				Assert.assertTrue(prodcatgitemlist.get(j).getText().contains(expectedprodcatg));
				break;
			}
		}
		driver.get(prop.getProperty("atlmrkturl_prod"));
	}


	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
