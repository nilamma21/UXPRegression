package atlantamarket_UAT;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.AtlantaMarket.ATLExhDigiShowroomPage;
import pageObjects.AtlantaMarket.ATLExhLineProdActionsPage;
import pageObjects.AtlantaMarket.ATLGlobalSearchPage;
import pageObjects.AtlantaMarket.ATLLandingPage;
import pageObjects.AtlantaMarket.ATLLeftPaneFilters;
import pageObjects.AtlantaMarket.ATLLoginPage;
import pageObjects.AtlantaMarket.ATLMarketPlannerPage;
import pageObjects.AtlantaMarket.ATLProductDetailsPage;
import pageObjects.ExhibitorPortal.EXPMarketsPage;
import pageObjects.Sitecore.SCDashboard;
import pageObjects.Sitecore.SCLoginPage;
import pageObjects.Sitecore.SCShowSpecials;
import resources.GenerateData;
import resources.Utility;
import resources.base;

public class ShowSpecials extends base  {
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
	EXPMarketsPage expmrkttab;
	SCLoginPage sclogin;
	SCDashboard scdash;
	SCShowSpecials scshow;

	List<WebElement> exhlist, linelist, prodlist, searchexhtypelist, searchproducttypelist, mplists, mpeditlistoptns,
	allnoteslist, favlist, searchlinetypelist, tagBlogPost, taglist, infoFilterList, showspecialslist;

	ArrayList<String> tabs;

	@BeforeClass(alwaysRun=true)
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);
		atlgs=new ATLGlobalSearchPage(driver);
		
		driver.get(prop.getProperty("atlmrkturl_uat"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        lap.getIUnderstandBtn().click();
        Thread.sleep(5000);
		//Add new Show Special from EXP
		//utl.addNewShowSpecialFrmExp_PROD(); //Add show special for test.
	}

	@Test(priority = 1)//groups="Non_MP"
	public void TS001_VerifyViewBrandDetailsLinkForShowSpecialsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T381: Show Specials: Links - Exhibitor Name
		
		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlleftpane = new ATLLeftPaneFilters(driver);
		utl = new Utility(driver);
		expmrkttab = new EXPMarketsPage(driver);
		sclogin = new SCLoginPage(driver);
		scdash = new SCDashboard(driver);
		scshow = new SCShowSpecials(driver);
		genData = new GenerateData();
		
		//Open ATL market site in new tab
/*		((JavascriptExecutor)driver).executeScript("window.open()");
		tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(2));*/
/*		driver.get(prop.getProperty("atlmrkturl_uat"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);*/
		
		//click on Exhibitors And Product Tab
		atlgs.getatlExhibitorsAndProductTab().click();
		
		//Click on Show Specials sub-menu
		atlgs.getatlShowSpecialsLink().click();
		Thread.sleep(5000);
		
		utl.scrollToElement(atlgs.getatlShowSpecialsTitle());
		
		//Store the name of Show Special Exhibitor
		String inbox = atlgs.getatlShowSpecialsExhNamePROD().getText();
		String[] data = inbox.split("Shown By ");
		String showSpecialExhName = data[1];
		System.out.println(showSpecialExhName);
		utl.scrollToElement(atlgs.getViewBrandDetailsLink());
		//Click on View Brand Details link
		atlgs.getViewBrandDetailsLink().click();
		try {
		  System.out.println(atlexhdgshw.getExhNameOnExhDirectImg().getText());
	        //Verify the Show special exhibitor page
	        Assert.assertTrue(atlexhdgshw.getExhNameOnExhDirectImg().getText().contains(showSpecialExhName));
		}catch(Exception e){
		  System.out.println(atlexhdgshw.getExhNameOnExhDirectImg1().getText());
	        //Verify the Show special exhibitor page
	        Assert.assertTrue(atlexhdgshw.getExhNameOnExhDirectImg1().getText().contains(showSpecialExhName));
		}
	}
	
	@Test(priority = 2)//groups="Non_MP"
	public void TS002_VerifyLocationLinksForShowSpecialsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T382: Show Specials: Links - Showroom

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();
		
		driver.get(prop.getProperty("atlmrkturl_uat"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(4000);
		//click on Exhibitors And Product Tab
		atlgs.getatlExhibitorsAndProductTab().click();
		
		//Click on Show Specials menu
		atlgs.getatlShowSpecialsLink().click();
		Thread.sleep(5000);
		
		utl.scrollToElement(atlgs.getatlShowSpecialsTitle());
		
		//Click on Show Special Exhibitor
		String showroomName=atlgs.getatlShowroomLink().getText();
		String url=atlgs.getatlShowroomLink().getAttribute("href");
		System.out.println(showroomName);
		
		atlgs.getatlShowroomLink().click();
		Thread.sleep(5000);
		System.out.println(driver.getCurrentUrl());
		//Verify Floor plan page of selected location
		Assert.assertTrue(driver.getCurrentUrl().contains(url));
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
    //  lp.getPassword().sendKeys((prop.getProperty("password")));
        Thread.sleep(1000);

        lp.getSignInBtn().click();
        Thread.sleep(15000);
        Assert.assertTrue(driver.getTitle().contains("Atlanta Market at AmericasMart"));
    }
    

	@AfterClass(alwaysRun=true)
	public void tearDown() throws InterruptedException {
		//utl.deleteShowSpecialFrmExp(); // Delete created show special
		driver.quit();

	}
}
