package lasvegasmarket_PROD;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        lap.getIUnderstandBtn().click(); // Accept cookies/understand popup
        Thread.sleep(5000); // Wait for elements to load
        utl.CloseATLPopup(); // Close any popups if present
    }

    @Test(priority = 1)
    public void TS001_VerifyLineDigitalShowroomHeroComponentShownByExhibitorNamaeTest() throws InterruptedException, IOException {
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
  	    
  	    
        lvmgs.getGlobalSearchTextBoxNew().click(); // Click on the global search field
        lvmgs.getGlobalSearchEnterText().sendKeys("Anne"); // Enter search text "Anne"
        lvmgs.getSearchButtonNew().click(); // Click on search button

        String exhname = lvmds.getExhibitorNameNew().getText(); // Get exhibitor name
        System.out.println("Exhibitor name: " + exhname); // Print exhibitor name
        lvmds.getExhibitorNameNew().click(); // Click on the exhibitor name

        Assert.assertTrue(lvmdigish.getLVMLineDigiShowroomPageTitle().getText().contains(exhname),
                "Digital Showroom Page Title mismatch"); // Verify page title contains exhibitor name

        String heroCompName = lvmdigish.getdigiShowroomExhNamePROD().getText(); // Get hero component name
        lvmdigish.getdigiShowroomExhNamePROD().click(); // Click on hero component exhibitor name

        Assert.assertTrue(lvmgs.getlvmShowSpecialsTitle().getText().contains(heroCompName),
                "Exhibitor showroom title mismatch"); // Verify showroom title contains exhibitor name
    }

    @Test(priority = 2)
    public void TS002_VerifyLineDigitalShowroomHeroComponentLocationLinksTest() throws InterruptedException, IOException {
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

        lvmgs.getGlobalSearchTextBoxNew().click(); // Click on the global search field
        lvmgs.getGlobalSearchEnterText().sendKeys("Anne"); // Enter search text "Anne"
        Thread.sleep(2000); // Wait for suggestions to appear
        lvmgs.getSearchButtonNew().click(); // Click on search button

        exhname = lvmds.getExhibitorNameNew().getText(); // Get exhibitor name from results
        System.out.println("Exhibitor name: " + exhname); // Print exhibitor name
        lvmds.getExhibitorNameNew().click(); // Click on the exhibitor name
        Thread.sleep(10000); // Wait for page to load

        Assert.assertTrue(lvmdigish.getLVMLineDigiShowroomPageTitle().getText().contains(exhname)); // Verify exhibitor page

        String locationURL = lvmdigish.getlocationLinkPROD().getAttribute("href"); // Get location link
        String winHandleBefore = driver.getWindowHandle(); // Store current window handle
        lvmdigish.getlocationLinkPROD().click(); // Click on the location link

        Assert.assertTrue(driver.getCurrentUrl().contains(locationURL)); // Verify the URL contains expected location link
    }


	@Test(priority = 07)
	public void TS007_VerifyLineDigitalShowroomHeroComponentProductsComponentCountTest()throws InterruptedException, IOException {
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
		lvmdigish=new LVMLineDigitalShowroomPage(driver);
		
		//driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);
		
		lvmgs.getGlobalSearchTextBoxNew().click();
		
		lvmgs.getGlobalSearchEnterText().sendKeys("Anne");
		Thread.sleep(2000);
		lvmgs.getSearchButtonNew().click();
		//Click on 1st Suggetions
		//lvmdigish.getsuggetionList().click();
		exhname = lvmds.getExhibitorNameNew().getText();
		System.out.println("Exhibitor name: " + exhname);
		
		lvmds.getExhibitorNameNew().click();
		Thread.sleep(10000);
		//Thread.sleep(3000);
		//Verify Digi showrrom page
		System.out.println(lvmdigish.getLVMLineDigiShowroomPageTitle().getText());
		Assert.assertTrue(lvmdigish.getLVMLineDigiShowroomPageTitle().getText().contains(exhname));

		String seeAllProdBtn=lvmdigish.getseeAllProductBtnUat().getText(); //For UAT
		String seeAllProdCount = seeAllProdBtn.split(" ")[2].trim();
		//lvmdigish.getseeAllProductBtn().click();//For Prod
		lvmdigish.getseeAllProductBtnUat().click();//For UAT
		Thread.sleep(5000);
		String p=driver.findElement(By.xpath("//div[@id='Products']")).getText();
		String count=p.replaceAll("[()]", "");
		String trimCount = count.split(" ")[1].trim();
		//verify both count
		Assert.assertTrue(seeAllProdCount.equals(trimCount));	
		driver.get(prop.getProperty("lvmurl_prod"));
	}
	
	@Test(priority = 8)
	public void TS008_VerifyLineDigitalShowroomProductscomponentTest()throws InterruptedException, IOException {
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
		lvmdigish=new LVMLineDigitalShowroomPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
		Thread.sleep(2000);
		lvmgs.getGlobalSearchTextBoxNew().click();
		lvmgs.getGlobalSearchEnterText().sendKeys("Anne");
		Thread.sleep(2000);
		lvmgs.getSearchButtonNew().click();
		//Click on 1st Suggetions
		//lvmdigish.getsuggetionList().click();
		exhname = lvmds.getExhibitorNameNew().getText();
		System.out.println("Exhibitor name: " + exhname);
		
		lvmds.getExhibitorNameNew().click();
		Thread.sleep(10000);
		//Verify Digi showrrom page
		Assert.assertTrue(lvmdigish.getLVMLineDigiShowroomPageTitle().getText().contains(exhname)); //For Prod
		
		//Scroll to Product section
		utl.scrollToElement(lvmdigish.getproductTitle());
		Thread.sleep(5000);
		//Verify Product component and count displayed or not
		Assert.assertTrue(lvmdigish.getproductTitleAndCount().isDisplayed());
		int count=0;
		for (WebElement prodTile : lvmdigish.gelistOfproductTile()) {
			if(prodTile.isDisplayed())
			count++;
		}
		System.out.println(count);
	
		//Verify Bottom Product count Link CTA
		Assert.assertTrue(lvmdigish.getprodctCountBottomBtn().isDisplayed());
		
		//Trim count from See All Product btn
		String seeAllProdBtn=lvmdigish.getprodctCountBottomBtn().getText();
		String trimSeeAllProdCount = seeAllProdBtn.split(" ")[2].trim();
		
		//Trim count from Product Section titled
		String prodCount=lvmdigish.getproductCount().getText();
		String trimProdCount = prodCount.split(" ")[0].trim();
		
		//verify both count
	//	Assert.assertTrue(trimSeeAllProdCount.equals(trimProdCount));
		
		Assert.assertTrue(trimSeeAllProdCount.contains(trimProdCount));
		driver.get(prop.getProperty("lvmurl_prod"));
	}

	@Test(priority = 10)
	public void TS010_VerifyLineDigitalShowroomProductscomponentSeeAllProductsTest()throws InterruptedException, IOException {
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
		lvmdigish=new LVMLineDigitalShowroomPage(driver);

		Thread.sleep(2000);
		lvmgs.getGlobalSearchTextBoxNew().click();
		lvmgs.getGlobalSearchEnterText().sendKeys("Anne");
		Thread.sleep(2000);
		lvmgs.getSearchButtonNew().click();
		//Click on 1st Suggetions
		//lvmdigish.getsuggetionList().click();
		exhname = lvmds.getExhibitorNameNew().getText();
		System.out.println("Exhibitor name: " + exhname);
		
		lvmds.getExhibitorNameNew().click();
		Thread.sleep(10000);
		//Verify Digi showrrom page
		Assert.assertTrue(lvmdigish.getLVMLineDigiShowroomPageTitle().getText().contains(exhname)); //For Prod
		//Thread.sleep(5000);
		//Scroll to Product section
		utl.scrollToElement(lvmdigish.getproductTitle());
		//Click on See All Prod Btn
		String seeAllProdURL=lvmdigish.getSeeAllprodctCountBottomBtn().getAttribute("href");
		lvmdigish.getSeeAllprodctCountBottomBtn().click();
		//Verify See All Product CTA page
		Assert.assertTrue(driver.getCurrentUrl().contains(seeAllProdURL));
		driver.get(prop.getProperty("lvmurl_prod"));
	}
	@Test(priority = 11)
	public void TS011_VerifyLineDigitalShowroomProductscomponentSelectProductTest()throws InterruptedException, IOException {
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
		lvmdigish=new LVMLineDigitalShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Thread.sleep(2000);
		lvmgs.getGlobalSearchTextBoxNew().click();
		lvmgs.getGlobalSearchEnterText().sendKeys("Anne");
		Thread.sleep(2000);
		lvmgs.getSearchButtonNew().click();
		//Click on 1st Suggetions
		//lvmdigish.getsuggetionList().click();
		exhname = lvmds.getExhibitorNameNew().getText();
		System.out.println("Exhibitor name: " + exhname);
		
		lvmds.getExhibitorNameNew().click();
		Thread.sleep(10000);
		//Verify Digi showrrom page
		Assert.assertTrue(lvmdigish.getLVMLineDigiShowroomPageTitle().getText().contains(exhname)); //For Prod
		//Thread.sleep(5000);
		//Scroll to Product section
		utl.scrollToElement(lvmdigish.getproductTitle());
		//Click on Any Product Btn
		Thread.sleep(2000);
		try {
		String prodName=lvmdigish.getproductName().getText();
		String replaceProdName=prodName.replaceAll(".", "");
		Thread.sleep(2000);
		System.out.println(replaceProdName);
		lvmdigish.getproductName().click();
		Thread.sleep(2000);
		System.out.println(lvmdigish.getproductHeader().getText());
		//Verify See All Product details page
		Assert.assertTrue(lvmdigish.getproductHeader().getText().contains(replaceProdName));
		}catch (Exception e){
			String prodName=lvmdigish.getproductName1PROD().getText();
			String replaceProdName=prodName.replaceAll(".", "");
			Thread.sleep(2000);
			System.out.println(replaceProdName);
			lvmdigish.getproductName1PROD().click();
			Thread.sleep(2000);
			System.out.println(lvmdigish.getproductHeader().getText());
			//Verify See All Product details page
			Assert.assertTrue(lvmdigish.getproductHeader().getText().contains(replaceProdName));
			driver.get(prop.getProperty("lvmurl_prod"));
		}
	}
	@AfterClass
	public void tearDown() {
		 //driver.quit();
	}
}
