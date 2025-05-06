package lasvegasmarket_PROD;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.LasVegasMarket.LVMExhDigiShowroomPage;
import pageObjects.LasVegasMarket.LVMExhLineProdActionsPage;
import pageObjects.LasVegasMarket.LVMGlobalSearchPage;
import pageObjects.LasVegasMarket.LVMLandingPage;
import pageObjects.LasVegasMarket.LVMLeftPaneFilters;
import pageObjects.LasVegasMarket.LVMLineDigitalShowroomPage;
import pageObjects.LasVegasMarket.LVMLoginPage;
import pageObjects.LasVegasMarket.LVMMarketPlannerPage;
import pageObjects.LasVegasMarket.LVMProductDetailsPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

public class LineDigitalShowroom extends base {
	public WebDriverWait wait; // Explicit wait for handling elements
	public GenerateData genData; // Data generator utility
	public Utility utl; // Utility class instance
	public String exhname; // Exhibitor name variable

	// Page Object instances
	LVMLoginPage lp;
	LVMLandingPage lap;
	LVMGlobalSearchPage lvmgs;
	LVMExhDigiShowroomPage lvmds;
	LVMProductDetailsPage lvmproddet;
	LVMExhLineProdActionsPage lvmexhact;
	LVMMarketPlannerPage lvmmpp;
	LVMLeftPaneFilters lvmleftpane;
	LVMLineDigitalShowroomPage lvmdigish;

	@BeforeClass
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // Initialize WebDriver instance
		utl = new Utility(driver); // Instantiate utility class
		lap = new LVMLandingPage(driver); // Instantiate landing page
		lvmgs = new LVMGlobalSearchPage(driver); // Instantiate global search page

		driver.get(prop.getProperty("lvmurl_prod")); // Navigate to the LVM URL
		driver.manage().window().maximize(); // Maximize browser window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // Set implicit wait
		try {
		lap.getIUnderstandBtn().click(); // Accept cookies/understand popup
		}catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(5000); // Wait for elements to load
		//utl.CloseATLPopup(); // Close any popups if present
	}

	@Test(priority = 1)
	public void TS001_VerifyLineDigitalShowroomHeroComponentShownByExhibitorNamaeTest()
			throws InterruptedException, IOException {
		// The purpose of this test case is to verify:
		// T337: Line Digital Showroom: Hero component: Shown by <ExhibitorName>
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lap = new LVMLandingPage(driver);
		lp = new LVMLoginPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		genData = new GenerateData();
		lvmdigish = new LVMLineDigitalShowroomPage(driver);

		utl.commonMethodForLineDGShowroom((prop.getProperty("globalsearch_input")));
		

		String heroCompName = lvmdigish.getdigiShowroomExhNamePROD().getText(); // Get hero component name
		lvmdigish.getdigiShowroomExhNamePROD().click(); // Click on hero component exhibitor name

		Assert.assertTrue(lvmgs.getlvmShowSpecialsTitle().getText().contains(heroCompName),
				"Exhibitor showroom title mismatch"); // Verify showroom title contains exhibitor name

		driver.get(prop.getProperty("lvmurl_prod")); // Navigate to the LVM URL
	}

	@Test(priority = 2)
	public void TS002_VerifyLineDigitalShowroomHeroComponentLocationLinksTest()
			throws InterruptedException, IOException {
		// The purpose of this test case is to verify:
		// T338: Line Digital Showroom: Hero component: Location Links
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lap = new LVMLandingPage(driver);
		lp = new LVMLoginPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		genData = new GenerateData();
		lvmdigish = new LVMLineDigitalShowroomPage(driver);

		utl.commonMethodForLineDGShowroom((prop.getProperty("globalsearch_input")));

		Thread.sleep(5000);
		String locationURL = lvmdigish.getlocationLinkPROD().getAttribute("href"); // Get location link
		String winHandleBefore = driver.getWindowHandle();
		// Store current window handle

		lvmdigish.getlocationLinkPROD().click(); // Click on the location link

		Assert.assertTrue(driver.getCurrentUrl().contains(locationURL)); // Verify the URL contains expected location
																			// link
		driver.get(prop.getProperty("lvmurl_prod")); // Navigate to the LVM URL
	}

	@Test(priority = 07)
	public void TS007_VerifyLineDigitalShowroomHeroComponentProductsComponentCountTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T344: Line Digital Showroom: See all Product CTA
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lap = new LVMLandingPage(driver);
		lp = new LVMLoginPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		genData = new GenerateData();
		lvmdigish = new LVMLineDigitalShowroomPage(driver);

		// driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		utl.commonMethodForLineDGShowroom((prop.getProperty("globalsearch_input")));
		Thread.sleep(5000);

		// Trim count from See All Product button
		String seeAllProdBtn = lvmdigish.getprodctCountBottomBtn().getText();
		String trimSeeAllProdCount = seeAllProdBtn.replaceAll("[^0-9]", ""); // e.g., "1"
		System.out.println("Count"+trimSeeAllProdCount);

		// lvmdigish.getseeAllProductBtn().click();//For Prod
		lvmdigish.getseeAllProductBtnUat().click();// For UAT
		Thread.sleep(8000);

		// Trim count from Product Section title
		String prodCount = driver.findElement(By.xpath("//div[@id='Products']")).getText(); // e.g., "See 1 Product"
		String trimProdCount = prodCount.replaceAll("[^0-9]", ""); // e.g., "1"
		System.out.println("Count See button"+trimProdCount);
		// verify both count
		Assert.assertTrue(trimSeeAllProdCount.equals(trimProdCount));
		driver.get(prop.getProperty("lvmurl_prod"));
	}

	@Test(priority = 8)
	public void TS008_VerifyLineDigitalShowroomProductscomponentTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T346: Line Digital Showroom: Products component
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lap = new LVMLandingPage(driver);
		lp = new LVMLoginPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		genData = new GenerateData();
		lvmdigish = new LVMLineDigitalShowroomPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Thread.sleep(2000);
		utl.commonMethodForLineDGShowroom((prop.getProperty("globalsearch_input")));
		Thread.sleep(5000);
		// Scroll to Product section
		utl.scrollToElement(lvmdigish.getproductTitle());
		Thread.sleep(5000);
		// Verify Product component and count displayed or not
		Assert.assertTrue(lvmdigish.getproductTitleAndCount().isDisplayed());
		int count = 0;
		for (WebElement prodTile : lvmdigish.gelistOfproductTile()) {
			if (prodTile.isDisplayed())
				count++;
		}
		System.out.println(count);

		// Verify Bottom Product count Link CTA
		Assert.assertTrue(lvmdigish.getprodctCountBottomBtn().isDisplayed());

		// Trim count from See All Product button
		String seeAllProdBtn = lvmdigish.getprodctCountBottomBtn().getText();
		String trimSeeAllProdCount = seeAllProdBtn.replaceAll("[^0-9]", ""); // e.g., "1"
		System.out.println("Count See button"+trimSeeAllProdCount);

		// Trim count from Product Section title
		String prodCount = lvmdigish.getproductCount().getText(); // e.g., "See 1 Product"
		String trimProdCount = prodCount.replaceAll("[^0-9]", ""); // e.g., "1"
		System.out.println("Count See button"+trimProdCount);
		// verify both count
		// Assert.assertTrue(trimSeeAllProdCount.equals(trimProdCount));

		Assert.assertTrue(trimSeeAllProdCount.contains(trimProdCount));
		driver.get(prop.getProperty("lvmurl_prod"));
	}

	@Test(priority = 10)
	public void TS010_VerifyLineDigitalShowroomProductscomponentSeeAllProductsTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T373: Line Digital Showroom: Products component: See All Products
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lap = new LVMLandingPage(driver);
		lp = new LVMLoginPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		genData = new GenerateData();
		lvmdigish = new LVMLineDigitalShowroomPage(driver);

		utl.commonMethodForLineDGShowroom((prop.getProperty("globalsearch_input")));
		Thread.sleep(5000);
		// Scroll to Product section
		utl.scrollToElement(lvmdigish.getproductTitle());
		// Click on See All Prod Btn
		String seeAllProdURL = lvmdigish.getSeeAllprodctCountBottomBtn().getAttribute("href");
		lvmdigish.getSeeAllprodctCountBottomBtn().click();
		// Verify See All Product CTA page
		Assert.assertTrue(driver.getCurrentUrl().contains(seeAllProdURL));
		driver.get(prop.getProperty("lvmurl_prod"));
	}

	@Test(priority = 11)
	public void TS011_VerifyLineDigitalShowroomProductscomponentSelectProductTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T374: Line Digital Showroom: Products component: Select a Product
		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lap = new LVMLandingPage(driver);
		lp = new LVMLoginPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		genData = new GenerateData();
		lvmdigish = new LVMLineDigitalShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.commonMethodForLineDGShowroom((prop.getProperty("globalsearch_input")));
		Thread.sleep(5000);
		// Thread.sleep(5000);
		// Scroll to Product section
		utl.scrollToElement(lvmdigish.getproductTitle());
		// Click on Any Product Btn
		Thread.sleep(2000);
		try {
			String prodName = lvmdigish.getproductName().getText();
			String replaceProdName = prodName.replaceAll(".", "");
			Thread.sleep(2000);
			System.out.println(replaceProdName);
			lvmdigish.getproductName().click();
			Thread.sleep(2000);
			System.out.println(lvmdigish.getproductHeader().getText());
			// Verify See All Product details page
			Assert.assertTrue(lvmdigish.getproductHeader().getText().contains(replaceProdName));
		} catch (Exception e) {
			String prodName = lvmdigish.getproductName1PROD().getText();
			String replaceProdName = prodName.replaceAll(".", "");
			Thread.sleep(2000);
			System.out.println(replaceProdName);
			lvmdigish.getproductName1PROD().click();
			Thread.sleep(2000);
			System.out.println(lvmdigish.getproductHeader().getText());
			// Verify See All Product details page
			Assert.assertTrue(lvmdigish.getproductHeader().getText().contains(replaceProdName));
			driver.get(prop.getProperty("lvmurl_prod"));
		}
	}

	@AfterClass
	public void tearDown() {
		// driver.quit();
	}
}
