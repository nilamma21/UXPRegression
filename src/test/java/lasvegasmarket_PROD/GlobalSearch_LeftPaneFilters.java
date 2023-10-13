package lasvegasmarket_PROD;

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
import pageObjects.LasVegasMarket.LVMExhDigiShowroomPage;
import pageObjects.LasVegasMarket.LVMExhLineProdActionsPage;
import pageObjects.LasVegasMarket.LVMGlobalSearchPage;
import pageObjects.LasVegasMarket.LVMLandingPage;
import pageObjects.LasVegasMarket.LVMLeftPaneFilters;
import pageObjects.LasVegasMarket.LVMLoginPage;
import pageObjects.LasVegasMarket.LVMMarketPlannerPage;
import pageObjects.LasVegasMarket.LVMProductDetailsPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

@Listeners({ TestListeners.class })
public class GlobalSearch_LeftPaneFilters extends base {

	public WebDriverWait wait;
	public GenerateData genData;
	public Utility utl;
	public String exhname;
	LVMLoginPage lp;
	LVMLandingPage lap;
	LVMGlobalSearchPage lvmgs;
	LVMExhDigiShowroomPage lvmds;
	LVMProductDetailsPage lvmproddet;
	LVMExhLineProdActionsPage lvmexhact;
	LVMMarketPlannerPage lvmmpp;
	LVMLeftPaneFilters lvmleftpane;

	List<WebElement> exhproductlist,prodcatgitemlist,exhlist, linelist, prodlist, searchexhtypelist, searchproducttypelist, mplists, mpeditlistoptns, allnoteslist,favlist, searchlinetypelist;

	
	@BeforeClass
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		utl = new Utility(driver);
		lap = new LVMLandingPage(driver);

		// Navigate to Las Vegas Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(4000);
		lap.getIUnderstandBtn().click();
		Thread.sleep(7000);
		driver.navigate().refresh();
	}

	@Test(priority = 1)
	public void TS001_VerifySelectionOfApparelVintageProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T404: Selection Of Apparel, Vintage Prod Catg From Left Pane Filters

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		lvmleftpane = new LVMLeftPaneFilters(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		lvmgs.getLVMGlobalSearchTextBox().sendKeys((prop.getProperty("filtersglobalsearchinput")));//Previous input = filtersglobalsearchinput
		lvmgs.getLVMSearchButton().click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on Product Categories expand btn
		lvmleftpane.getLVMProdCatgExpandBtn().click();
		Thread.sleep(2000);
		utl.scrollToElement(lvmleftpane.getLVMApparelVintProdCatg());

		//Select 'Apparel, Vintage' prod category
		String expectedprodcatg = lvmleftpane.getLVMApparelVintProdCatg().getText();
		lvmleftpane.getLVMApparelVintProdCatg().click();
		Thread.sleep(8000);

		//Verify the selected Product Category on Exhibitor Digital Showroom page
		//Select 1st Exhibitor from Search results grid
		utl.scrollToElement(lvmleftpane.getLVMexhibitor());
		lvmleftpane.getLVMexhibitor().click();

		//Scroll till Product Categories section
		utl.scrollToElement(lvmds.getLVMProductCategSection());
		prodcatgitemlist = lvmds.getLVMProductCategItemList();

		for (int i = 0; i < prodcatgitemlist.size(); i++) {
			if(lvmds.getLVMProductCategTable().isDisplayed()) {
				//System.out.println(prodcatgitemlist.get(i).getText());
				Assert.assertTrue(prodcatgitemlist.get(i).getText().contains(expectedprodcatg));
				break;
			}
		}
		//driver.get(prop.getProperty("lvmurl_prod"));
	}

	@Test(priority = 2)
	public void TS002_VerifySelectionOfAntiqueVintageProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T404: Selection Of Antique/Vintage Prod Catg From Left Pane Filters

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		lvmleftpane = new LVMLeftPaneFilters(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		lvmgs.getLVMGlobalSearchTextBox().sendKeys((prop.getProperty("exhibitor6")));
		lvmgs.getLVMSearchButton().click();

		//Click on Product Categories expand btn
		lvmleftpane.getLVMProdCatgExpandBtn().click();

		utl.scrollToElement(lvmleftpane.getLVMAntiqueVintProdCatg());

		//Select 'Antique/Vintage' prod category
		String expectedprodcatg = lvmleftpane.getLVMAntiqueVintProdCatg().getText();
		lvmleftpane.getLVMAntiqueVintProdCatg().click();
		Thread.sleep(8000);
		
		//Verify the selected Product Category on Product details page
		//utl.scrollToElement(lvmexhact.getSecondExhProduct()); //For Prod
		utl.scrollToElement(lvmleftpane.getFirstVintageExhUat());
		lvmleftpane.getFirstVintageExhUat().click(); //For UAT
		
		/*Actions actions = new Actions(driver);
		actions.moveToElement(lvmexhact.getSecondExhProduct()).perform();
		// To mouseover on See Details btn
		actions.moveToElement(lvmexhact.getSecondExhProductSeeDetailsBtn()).perform();
		// Click on See Details button
		actions.click().perform();*/ //For Prod
		
		//Scroll till Product Categories section
		utl.scrollToElement(lvmds.getLVMProductCategSection());
		prodcatgitemlist = lvmds.getLVMProductCategItemList();

		for (int j = 0; j < prodcatgitemlist.size(); j++) {
			if(lvmds.getLVMProductCategTable().isDisplayed()) {
				//System.out.println(prodcatgitemlist.get(j).getText());
				Assert.assertTrue(prodcatgitemlist.get(j).getText().contains(expectedprodcatg));
				break;
			}
		}
		//driver.get(prop.getProperty("lvmurl_prod"));
	}

@Test(priority = 3)
	public void TS003_VerifyCombinationWithinProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T405: Combination within Prod Catgs From Left Pane Filters

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		lvmleftpane = new LVMLeftPaneFilters(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		lvmgs.getLVMGlobalSearchTextBox().sendKeys((prop.getProperty("exhibitor5")));//Previous input = filtersglobalsearchinput
		lvmgs.getLVMSearchButton().click();
		
		Thread.sleep(5000);
		//Click on Product Categories expand btn
		lvmleftpane.getLVMProdCatgExpandBtn().click();

		utl.scrollToElement(lvmleftpane.getLVMAntiqueVintProdCatg());

		//Select 'Antique/Vintage' prod category
		String expectedprodcatg1 = lvmleftpane.getLVMAntiqueVintProdCatg().getText();
		lvmleftpane.getLVMAntiqueVintProdCatg().click();
		Thread.sleep(6000);
		
		//Select 'Apparel, Vintage' prod category
		String expectedprodcatg2 = lvmleftpane.getLVMApparelVintProdCatg().getText();
		lvmleftpane.getLVMApparelVintProdCatg().click();
		Thread.sleep(8000);
/*
		//Verify the selected Product Category on Product details page
		utl.scrollToElement(lvmexhact.getProductForMultipleCatg());
		// Hovering on 1st Product
		Actions actions = new Actions(driver);
		actions.moveToElement(lvmexhact.getProductForMultipleCatg()).perform();
		// To mouseover on See Details btn
		actions.moveToElement(lvmexhact.getThirdExhProdSeeDetailsBtn()).perform();
		// Click on See Details button
		actions.click().perform();

		//Scroll till Product Categories section
		utl.scrollToElement(lvmds.getLVMProductCategSection());
		prodcatgitemlist = lvmds.getLVMProductCategItemList();

		for (int j = 0; j < prodcatgitemlist.size(); j++) {
			if(lvmds.getLVMProductCategTable().isDisplayed()) {
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
		utl.scrollToElement(lvmleftpane.getLVMexhibitor());
		lvmleftpane.getLVMexhibitor().click();
		Thread.sleep(2000);
		//Scroll till Product Categories section
		utl.scrollToElement(lvmds.getLVMProductCategSection());
		prodcatgitemlist = lvmds.getLVMProductCategItemList();

		for (int i = 0; i < prodcatgitemlist.size(); i++) {
			if(lvmds.getLVMProductCategTable().isDisplayed()) {

				Assert.assertTrue(prodcatgitemlist.get(i).getText().contains(expectedprodcatg1) || prodcatgitemlist.get(i).getText().contains(expectedprodcatg2));
				break;
			}
		}
		//driver.get(prop.getProperty("lvmurl_prod"));

	}

	@Test(priority = 4)
	public void TS004_VerifyCombinationOfProdCatgWithStylesFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T406: Combination of Prod Catgs with Styles From Left Pane Filters

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmleftpane = new LVMLeftPaneFilters(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lp = new LVMLoginPage(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		lvmgs.getLVMGlobalSearchTextBox().sendKeys((prop.getProperty("exhibitor6")));//Previous input = filtersglobalsearchinput
		lvmgs.getLVMSearchButton().click();

		//Click on Product Categories expand btn
		lvmleftpane.getLVMProdCatgExpandBtn().click();		

		/*//Expand btn code
		WebElement pseudoEle = driver.findElement(By.xpath("//label[contains(text(),'Accent Furniture')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String display = js.executeScript("return window.getComputedStyle(arguments[0], ':after').getPropertyValue('display');",pseudoEle).toString();
		System.out.println(display);*/

		utl.scrollToElement(lvmleftpane.getLVMAntiqueVintProdCatg());

		//Select 'Antique/Vintage' prod category
		String expectedprodcatg = lvmleftpane.getLVMAntiqueVintProdCatg().getText();
		lvmleftpane.getLVMAntiqueVintProdCatg().click();
		Thread.sleep(8000);

		//Click on Product Categories expand btn
		utl.scrollToElement(lvmleftpane.getLVMProdCatgExpandBtn());
		lvmleftpane.getLVMProdCatgExpandBtn().click();

		//Click on Styles expand btn
		lvmleftpane.getLVMStylesExpandBtn().click();

		//Select Style name 'Industrial'
		utl.scrollToElement(lvmleftpane.getLVMIndustrialStyle());
		//String expectedstyle = lvmleftpane.getLVMIndustrialStyle().getText();
		//System.out.println("Expected Style name:"+expectedstyle);
		lvmleftpane.getLVMIndustrialStyle().click();
		Thread.sleep(8000);

		//Click on IMC Test Exhibitor name in list
		//lvmexhact.getIMCExhibitorName().click(); //For prod
		utl.scrollToElement(lvmleftpane.getFirstVintageExhUat());
		lvmleftpane.getFirstVintageExhUat().click(); //For UAT

		//Scroll till Product Categories section
		utl.scrollToElement(lvmds.getLVMProductCategSection());
		prodcatgitemlist = lvmds.getLVMProductCategItemList();

		for (int i = 0; i < prodcatgitemlist.size(); i++) {
			if(lvmds.getLVMProductCategTable().isDisplayed()) {
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
		lvmleftpane.getEXPExhDropDown().click();

		//Select IMC Test Company exhibitor
		lvmleftpane.getTrippExhNameInEXP().click();

		//Click on Digital Showroom tab
		lvmleftpane.getEXPDigiShowroomTab().click();

		//Click on Profile Info menu
		lvmleftpane.getEXPProfileInfoMenu().click();
		Thread.sleep(6000);

		//Scroll till Product Categories section
		utl.scrollToElement(lvmleftpane.getEXPProductCategSection());

		//Verify that expected Style should be displayed on profile
		Assert.assertTrue(lvmleftpane.getEXPIndustrialStyleOnProfile().isDisplayed());
		driver.close();
		driver.switchTo().window(tabs.get(0));
		//driver.get(prop.getProperty("lvmurl_prod"));
	}

	@Test(priority = 5)
	public void TS005_VerifySelectionOfAccentFurnitureProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T404: Selection Of Accent Furniture Prod Catg From Left Pane Filters

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		lvmleftpane = new LVMLeftPaneFilters(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);

		lvmgs.getLVMGlobalSearchTextBox().sendKeys((prop.getProperty("exhibitor5")));//Previous input = filtersglobalsearchinput
		lvmgs.getLVMSearchButton().click();

		//Click on Product Categories expand btn
		lvmleftpane.getLVMProdCatgExpandBtn().click();

		utl.scrollToElement(lvmleftpane.getLVMAccentFurnitureProdCatg());

		//Select Accent Furniture prod category
		String expectedprodcatg = lvmleftpane.getLVMAccentFurnitureProdCatg().getText();
		lvmleftpane.getLVMAccentFurnitureProdCatg().click();
		Thread.sleep(8000);

		//Verify the selected Product Category on Exh Digital Showroom page
		//Select 1st Exhibitor from Search results grid
		utl.scrollToElement(lvmleftpane.getLVMexhibitor());
		lvmleftpane.getLVMexhibitor().click();

		//Scroll till Product Categories section
		utl.scrollToElement(lvmds.getLVMProductCategSection());
		prodcatgitemlist = lvmds.getLVMProductCategItemList();

		for (int i = 0; i < prodcatgitemlist.size(); i++) {
			if(lvmds.getLVMProductCategTable().isDisplayed()) {
				//System.out.println(prodcatgitemlist.get(i).getText());
				Assert.assertTrue(prodcatgitemlist.get(i).getText().contains(expectedprodcatg));
				break;
			}
		}
		//driver.get(prop.getProperty("lvmurl_prod"));
	}

	@Test(priority = 6)
	public void TS006_VerifySelectionOfHolidayProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T404: Selection Of Holiday/Seasonal Prod Catg From Left Pane Filters

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		lvmleftpane = new LVMLeftPaneFilters(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		lvmgs.getLVMGlobalSearchTextBox().sendKeys((prop.getProperty("leftpanefilterinput")));
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(7000);

		//Click on Product Categories expand btn
		utl.scrollToElement(lvmleftpane.getLVMProdCatgExpandBtn());
		lvmleftpane.getLVMProdCatgExpandBtn().click();

		utl.scrollToElement(lvmleftpane.getLVMHolidayProdCatg());

		//Select Holiday/Seasonal prod category
		String expectedprodcatg = lvmleftpane.getLVMHolidayProdCatg().getText();
		System.out.println(expectedprodcatg);
		lvmleftpane.getLVMHolidayProdCatg().click();
		Thread.sleep(8000);

		//Verify the selected Product Categories on Exhibitor Digital Showroom page
		//Select 1st Exhibitor from Search results grid
		utl.scrollToElement(lvmleftpane.getLVMexhibitor());
		lvmleftpane.getLVMexhibitor().click();

		//Scroll till Product Categories section
		utl.scrollToElement(lvmds.getLVMProductCategSection());
		prodcatgitemlist = lvmds.getLVMProductCategItemList();

		for (int i = 0; i < prodcatgitemlist.size(); i++) {
			if(lvmds.getLVMProductCategTable().isDisplayed()) {
				//System.out.println(prodcatgitemlist.get(i).getText());
				Assert.assertTrue(prodcatgitemlist.get(i).getText().contains(expectedprodcatg));
				break;
			}
		}
		driver.navigate().back();
		Thread.sleep(5000);

		/*//Verify the selected Product Category on Product details page
		utl.scrollToElement(lvmexhact.getProductForMultipleCatg());
		// Hovering on 1st Product
		Actions actions = new Actions(driver);
		actions.moveToElement(lvmexhact.getProductForMultipleCatg()).perform();
		// To mouseover on See Details btn
		actions.moveToElement(lvmexhact.getThirdExhProdSeeDetailsBtn()).perform();
		// Click on See Details button
		actions.click().perform();*/ //For Prod
		
		//Click on the first exhibitor
		lvmleftpane.getFirstVintageExhUat().click(); //For UAT

		//Scroll till Product Categories section
		utl.scrollToElement(lvmds.getLVMProductCategSection());
		prodcatgitemlist = lvmds.getLVMProductCategItemList();

		for (int j = 0; j < prodcatgitemlist.size(); j++) {
			if(lvmds.getLVMProductCategTable().isDisplayed()) {
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

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		lvmleftpane = new LVMLeftPaneFilters(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		lvmgs.getLVMGlobalSearchTextBox().sendKeys((prop.getProperty("exhibitor5")));
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(1000);
		
		//Click on Product Categories expand btn
		lvmleftpane.getLVMProdCatgExpandBtn().click();
		Thread.sleep(1000);
		utl.scrollToElement(lvmleftpane.getLVMDecorativeAccProdCatg());

		//Select Decorative Accessories prod category
		String expectedprodcatg = lvmleftpane.getLVMDecorativeAccProdCatg().getText();
		lvmleftpane.getLVMDecorativeAccProdCatg().click();
		Thread.sleep(8000);

		/*//Verify the selected Product Categories on product details page
		utl.scrollToElement(lvmexhact.getExhibitorProduct());
		// Hovering on 1st Product
		Actions actions = new Actions(driver);
		actions.moveToElement(lvmexhact.getExhibitorProduct()).perform();
		// To mouseover on See Details btn
		actions.moveToElement(lvmexhact.getProdSeeDetailsBtn()).perform();
		// Click on See Details button
		actions.click().perform();*/ //For Prod
		
		//Click on the 2nd exhibitor
utl.scrollToElement(lvmleftpane.getSecondExhUat());
		lvmleftpane.getSecondExhUat().click(); //For UAT

		//Scroll till Product Categories section
		utl.scrollToElement(lvmds.getLVMProductCategSection());
		prodcatgitemlist = lvmds.getLVMProductCategItemList();

		for (int j = 0; j < prodcatgitemlist.size(); j++) {
			if(lvmds.getLVMProductCategTable().isDisplayed()) {
				//System.out.println(prodcatgitemlist.get(j).getText());
				Assert.assertTrue(prodcatgitemlist.get(j).getText().contains(expectedprodcatg));
				break;
			}
		}
		//driver.get(prop.getProperty("lvmurl_prod"));
	}

	@Test(priority =8)
	public void TS008_VerifySelectionOfGeneralGiftProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T404: Selection Of General Gift Prod Catg From Left Pane Filters
		
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		lvmleftpane = new LVMLeftPaneFilters(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		
		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		lvmgs.getLVMGlobalSearchTextBox().sendKeys((prop.getProperty("leftpanefilterinput2")));
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(2000);
		
		//Click on Product Categories expand btn
		lvmleftpane.getLVMProdCatgExpandBtn().click();
		Thread.sleep(2000);
		utl.scrollToElement(lvmleftpane.getLVMGeneralGiftProdCatg());

		//Select General Gift prod category
		String expectedprodcatg = lvmleftpane.getLVMGeneralGiftProdCatg().getText();
		lvmleftpane.getLVMGeneralGiftProdCatg().click();
		Thread.sleep(8000);

		/*//Verify the selected Product Categories on product details page
		utl.scrollToElement(lvmexhact.getExhibitorProduct());
		// Hovering on 1st Product
		Actions actions = new Actions(driver);
		actions.moveToElement(lvmexhact.getExhibitorProduct()).perform();
		// To mouseover on See Details btn
		actions.moveToElement(lvmexhact.getProdSeeDetailsBtn()).perform();
		// Click on See Details button
		actions.click().perform();*/ //For Prod
		
		//Click on the first exhibitor
		//lvmleftpane.getSecondExhUat().click();
		utl.scrollToElement(lvmleftpane.getSecondExhUat());
		lvmleftpane.getSecondExhUat().click(); //For UAT
		
		//Scroll till Product Categories section
		utl.scrollToElement(lvmds.getLVMProductCategSection());
		Thread.sleep(2000);
		prodcatgitemlist = lvmds.getLVMProductCategItemList();

		for (int j = 0; j < prodcatgitemlist.size(); j++) {
			if(lvmds.getLVMProductCategTable().isDisplayed()) {
				//System.out.println(prodcatgitemlist.get(j).getText());
				Assert.assertTrue(prodcatgitemlist.get(j).getText().contains(expectedprodcatg));
				break;
			}
		}
		//driver.get(prop.getProperty("lvmurl_prod"));
	}

	@Test(priority = 9)
	public void TS009_VerifySelectionOfFashionAccProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T404: Selection Of Fashion Accessories/Jewelry Prod Catg From Left Pane Filters

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		lvmleftpane = new LVMLeftPaneFilters(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		lvmgs.getLVMGlobalSearchTextBox().sendKeys((prop.getProperty("filtersglobalsearchinput")));
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(6000);

		//Click on Product Categories expand btn
		lvmleftpane.getLVMProdCatgExpandBtn().click();

		utl.scrollToElement(lvmleftpane.getLVMFashionAccProdCatg());

		//Select Fashion Accessories/Jewelry prod category
		String expectedprodcatg = lvmleftpane.getLVMFashionAccProdCatg().getText();
		System.out.println(expectedprodcatg);
		lvmleftpane.getLVMFashionAccProdCatg().click();
		Thread.sleep(8000);

		//Verify the selected Product Categories on Exhibitor Digital Showroom page
		//Select 1st Exhibitor from Search results grid
		utl.scrollToElement(lvmleftpane.getLVMexhibitor());
		lvmleftpane.getLVMexhibitor().click();

		//Scroll till Product Categories section
		utl.scrollToElement(lvmds.getLVMProductCategSection());
		prodcatgitemlist = lvmds.getLVMProductCategItemList();

		for (int i = 0; i < prodcatgitemlist.size(); i++) {
			if(lvmds.getLVMProductCategTable().isDisplayed()) {
				//System.out.println(prodcatgitemlist.get(i).getText());
				Assert.assertTrue(prodcatgitemlist.get(i).getText().contains(expectedprodcatg));
				break;
			}
		}
		driver.navigate().back();
		Thread.sleep(6000);

		/*//Verify the selected Product Category on Product details page
		utl.scrollToElement(lvmexhact.getProductForMultipleCatg());
		// Hovering on 1st Product
		Actions actions = new Actions(driver);
		actions.moveToElement(lvmexhact.getProductForMultipleCatg()).perform();
		// To mouseover on See Details btn
		actions.moveToElement(lvmexhact.getThirdExhProdSeeDetailsBtn()).perform();
		// Click on See Details button
		actions.click().perform();*/ //For Prod
		
		//Click on the first exhibitor
		//lvmleftpane.getSecondExhUat().click(); //For UAT
		lvmleftpane.getFirstVintageExhUat().click();

		//Scroll till Product Categories section
		utl.scrollToElement(lvmds.getLVMProductCategSection());
		prodcatgitemlist = lvmds.getLVMProductCategItemList();

		for (int j = 0; j < prodcatgitemlist.size(); j++) {
			if(lvmds.getLVMProductCategTable().isDisplayed()) {
				Assert.assertTrue(prodcatgitemlist.get(j).getText().contains(expectedprodcatg));
				break;
			}
		}
		//driver.get(prop.getProperty("lvmurl_prod"));
	}

	@Test(priority =10)
	public void TS010_VerifySelectionOfFloralBotanicalsProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T404: Selection Of Floral / Botanicals Prod Catg From Left Pane Filters

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		lvmleftpane = new LVMLeftPaneFilters(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);

		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		lvmgs.getLVMGlobalSearchTextBox().sendKeys((prop.getProperty("leftpanefilterinput3")));
		Thread.sleep(2000);
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(3000);
		
		//Click on Product Categories expand btn
		lvmleftpane.getLVMProdCatgExpandBtn().click();

		utl.scrollToElement(lvmleftpane.getLVMFloralBotanicalsProdCatg());

		//Select Floral / Botanicals prod category
		String expectedprodcatg = lvmleftpane.getLVMFloralBotanicalsProdCatg().getText();
		System.out.println(expectedprodcatg);
		lvmleftpane.getLVMFloralBotanicalsProdCatg().click();
		Thread.sleep(8000);

		/*//Verify the selected Product Categories on product details page
		utl.scrollToElement(lvmexhact.getExhibitorProduct());
		// Hovering on 1st Product
		Actions actions = new Actions(driver);
		actions.moveToElement(lvmexhact.getExhibitorProduct()).perform();
		// To mouseover on See Details btn
		actions.moveToElement(lvmexhact.getProdSeeDetailsBtn()).perform();
		// Click on See Details button
		actions.click().perform();*/ //For Prod
		
		//Click on the 1st exhibitor
		//lvmleftpane.getSecondExhUat().click();
		utl.scrollToElement(lvmleftpane.getFirstVintageExhUat());
		lvmleftpane.getFirstVintageExhUat().click(); //For UAT

		//Scroll till Product Categories section
		utl.scrollToElement(lvmds.getLVMProductCategSection());
		prodcatgitemlist = lvmds.getLVMProductCategItemList();

		for (int j = 0; j < prodcatgitemlist.size(); j++) {
			if(lvmds.getLVMProductCategTable().isDisplayed()) {
				//System.out.println(prodcatgitemlist.get(j).getText());
				Assert.assertTrue(prodcatgitemlist.get(j).getText().contains(expectedprodcatg));
				break;
			}
		}
		//driver.get(prop.getProperty("lvmurl_prod"));
	}

	@Test(priority =11)
	public void TS011_VerifySelectionOfHomeTextilesProdCatgFromLeftPaneFiltersTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T404: Selection Of Home Textiles Prod Catg From Left Pane Filters

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		lvmleftpane = new LVMLeftPaneFilters(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		
		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		lvmgs.getLVMGlobalSearchTextBox().sendKeys((prop.getProperty("leftpanefilterinput4")));
		lvmgs.getLVMSearchButton().click();

		//Click on Product Categories expand btn
		lvmleftpane.getLVMProdCatgExpandBtn().click();

		utl.scrollToElement(lvmleftpane.getLVMHomeTextilesProdCatg());

		//Select Home Textiles prod category
		String expectedprodcatg = lvmleftpane.getLVMHomeTextilesProdCatg().getText();
		lvmleftpane.getLVMHomeTextilesProdCatg().click();
		Thread.sleep(8000);

		//Verify the selected Product Categories on product details page
		//Select 2nd Exhibitor from Search results grid
		//lvmleftpane.getLVMSecondExhibitor().click(); //For Prod
		
		//Click on the first exhibitor
		//lvmleftpane.getSecondExhUat().click(); 
		utl.scrollToElement(lvmleftpane.getLVMexhibitor());
		lvmleftpane.getLVMexhibitor().click();//For UAT

		//Scroll till Product Categories section
		utl.scrollToElement(lvmds.getLVMProductCategSection());
		prodcatgitemlist = lvmds.getLVMProductCategItemList();

		for (int i = 0; i < prodcatgitemlist.size(); i++) {
			if(lvmds.getLVMProductCategTable().isDisplayed()) {
				//System.out.println(prodcatgitemlist.get(i).getText());
				Assert.assertTrue(prodcatgitemlist.get(i).getText().contains(expectedprodcatg));
				break;
			}
		}
		driver.get(prop.getProperty("lvmurl_prod"));
	}
	
	@AfterClass
	public void tearDown()
	{
		//driver.quit();
	}
	 
}
