package lasvegasmarket_PROD;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
import pageObjects.LasVegasMarket.LVMLoginPage;
import pageObjects.LasVegasMarket.LVMMarketPlannerPage;
import pageObjects.LasVegasMarket.LVMProductDetailsPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

public class ShowSpecials extends base{
	
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
	
	List<WebElement> exhlist, linelist, prodlist, searchexhtypelist, searchproducttypelist, mplists, mpeditlistoptns,
	allnoteslist, favlist, searchlinetypelist, tagBlogPost, taglist, infoFilterList;
	
	@BeforeClass
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		// chromeVersion();
		utl = new Utility(driver);
		lap = new LVMLandingPage(driver);
		lvmgs=new LVMGlobalSearchPage(driver);
		
		// Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		try {
		lap.getIUnderstandBtn().click();
		}catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(5000);
		utl.CloseATLPopup();
		
		//lap.getCloseMarktAdBtn().click();
		
	}
	@Test(priority = 1)
	public void TS001_VerifyViewBrandDetailsLinkForShowSpecialsTest()throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T381: Show Specials: Links - Exhibitor Name

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lap = new LVMLandingPage(driver);
		lp = new LVMLoginPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(9000);
		//click on Discover tab
		Actions ac=new Actions(driver);
		ac.moveToElement(lvmgs.getLvmDiscoverTab()).click().perform();
		//Click on Show Specials 
		lvmgs.getlvmShowSpecialsLink().click();
		Thread.sleep(5000);
		
	    // Store the name of Show Special Exhibitor
	    String ename = lvmgs.getFirstShowSpecialName().getText();
	    System.out.println(ename);

	    // Check if "Shown By" is present in the exhibitor name
	    String abc;
	    if (ename.contains("Shown By")) {
	        abc = ename.replace("Shown By ", "");
	    } else {
	        abc = ename; // Take the full name if "Shown By" is not present
	    }
	    System.out.println("Exhibitor Name for Search: " + abc);

	    String ShowSpecialDetails = lvmgs.getshowSpecialsDetailsFromShowSpecialsPage().getText();
	    System.out.println("Show Specials Page Details: " + ShowSpecialDetails);
		
		//Click on Show Special Exhibitor
		utl.scrollElementIntoMiddle(lvmgs.getFirstShowSpecialViewBrandDetailsBtn());
		Thread.sleep(200);
		lvmgs.getFirstShowSpecialViewBrandDetailsBtn().click();
		Thread.sleep(5000);
		
		//Verify Show Special Exh Page 
		Assert.assertTrue(lvmgs.getlvmShowSpecialsTitle().getText().contains(abc));
		//driver.get(prop.getProperty("lvmurl_prod"));
		
	}
	@Test(priority = 2)
	public void TS002_VerifyShowroomLinkForShowSpecialsTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T382: Show Specials: Links - Showroom

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lap = new LVMLandingPage(driver);
		lp = new LVMLoginPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.get(prop.getProperty("lvmurl_prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(3000);
		
		//click on Exhibitors And Product Tab
		//click on Discover tab
		Actions ac=new Actions(driver);
		ac.moveToElement(lvmgs.getLvmDiscoverTab()).click().perform();
		
		//Click on Show Specials 
		lvmgs.getlvmShowSpecialsLink().click();
		Thread.sleep(5000);
		
		//utl.scrollToElement(lvmgs.getlvmShowSpecialsTitle());
		//verify Show special Page
		//Assert.assertTrue(lvmgs.getlvmShowSpecialsTitle().getText().contains(prop.getProperty("showSpecialTitle")));
		
		//Click on Show Special Exhibitor
		//String showroomName=lvmgs.getlvmShowroomLink().getText();
		String url=lvmgs.getlvmShowroomLink().getAttribute("href");
		//System.out.println(showroomName);
		ac.moveToElement(lvmgs.getlvmShowroomLink()).click().perform();
		
		Thread.sleep(5000);
		
		//Verify Show Special Exh Page 
		Assert.assertTrue(driver.getCurrentUrl().contains(url));
		driver.get(prop.getProperty("lvmurl_prod"));
	}

	@AfterClass
	public void tearDown() {
		//driver.quit();
	}

}
