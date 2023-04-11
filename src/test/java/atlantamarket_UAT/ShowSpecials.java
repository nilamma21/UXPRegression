package atlantamarket_UAT;

import java.io.IOException;
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

	List<WebElement> exhlist, linelist, prodlist, searchexhtypelist, searchproducttypelist, mplists, mpeditlistoptns,
			allnoteslist, favlist, searchlinetypelist, tagBlogPost, taglist, infoFilterList;

	@BeforeClass(alwaysRun=true)
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		// chromeVersion();
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);
		atlgs=new ATLGlobalSearchPage(driver);
		
		// Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("atlmrkturl_uat"));
		
		lap.getIUnderstandBtn().click();
		Thread.sleep(5000);
		utl.CloseATLPopup();
		
		//lap.getCloseMarktAdBtn().click();
		
	}
	@Test
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
	

	@Test(priority = 1,groups="Non_MP")
	public void TS001_VerifyShowSpecialsLinksExhibitorNameTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T381: Show Specials: Links - Exhibitor Name

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);
		lp = new ATLLoginPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//click on Exhibitors And Product Tab
		atlgs.getatlExhibitorsAndProductTab().click();
		
		//Click on Show Specials 
		atlgs.getatlShowSpecialsLink().click();
		//verify Show special Page
		Thread.sleep(5000);
		Assert.assertTrue(atlgs.getatlShowSpecialsTitle().getText().contains(prop.getProperty("showSpecialTitle")));
		//Click on Show Special Exhibitor
		String showSpecialExhName=atlgs.getatlShowSpecialsExhNamePROD().getText();
		System.out.println(showSpecialExhName);
		atlgs.getatlShowSpecialsExhNamePROD().click();
		Thread.sleep(5000);
		//Verify Show Special Exh Page 
		Assert.assertTrue(atlgs.getatlShowSpecialsTitle().getText().contains(showSpecialExhName));
		
	}
	@Test(priority = 2,groups="Non_MP")
	public void TS002_VerifyShowSpecialsLinksShowroomTest()
			throws InterruptedException, IOException {
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

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//click on Exhibitors And Product Tab
		atlgs.getatlExhibitorsAndProductTab().click();
		//Click on Show Specials 
		atlgs.getatlShowSpecialsLink().click();
		Thread.sleep(5000);
		utl.scrollToElement(atlgs.getatlShowSpecialsTitle());
		//verify Show special Page
		Assert.assertTrue(atlgs.getatlShowSpecialsTitle().getText().contains(prop.getProperty("showSpecialTitle")));
		//Click on Show Special Exhibitor
		String showroomName=atlgs.getatlShowroomLink().getText();
		String url=atlgs.getatlShowroomLink().getAttribute("href");
		System.out.println(showroomName);
		atlgs.getatlShowroomLink().click();
		Thread.sleep(5000);
		//Verify Show Special Exh Page 
		Assert.assertTrue(driver.getCurrentUrl().contains(url));
		
	}

	@AfterClass(alwaysRun=true)
	public void tearDown() {
		 driver.quit();
	}
}
