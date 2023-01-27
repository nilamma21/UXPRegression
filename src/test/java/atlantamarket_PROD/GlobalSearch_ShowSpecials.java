package atlantamarket_PROD;

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

public class GlobalSearch_ShowSpecials extends base  {
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

	@BeforeClass
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		// chromeVersion();
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);
		atlgs=new ATLGlobalSearchPage(driver);
		
		// Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("atlmrkturl_prod"));
		
		lap.getIUnderstandBtn().click();
		Thread.sleep(5000);
		utl.CloseATLPopup();
		
		//lap.getCloseMarktAdBtn().click();
		
	}
	@Test(priority = 1)
	public void TS001_VerifyViewBrandDetailsLinkForShowSpecialsTest()
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
		Thread.sleep(5000);
		
		//verify Show special Page
		Assert.assertTrue(atlgs.getatlShowSpecialsTitle().getText().contains(prop.getProperty("showSpecialTitle")));
		
		/*//Store the name of Show Special Exhibitor
		String showSpecialExhName=atlgs.getatlShowSpecialsExhNamePROD().getText();
		System.out.println(showSpecialExhName);*/
		
		String inbox = atlgs.getatlShowSpecialsExhNamePROD().getText();
		String[] data = inbox.split("Shown By ");
		String showSpecialExhName = data[1];
		System.out.println(showSpecialExhName);
		
		atlgs.getViewBrandDetailsLink().click();
		Thread.sleep(5000);
		//Verify Show Special Exh Page 
		Assert.assertTrue(atlgs.getatlShowSpecialsTitle().getText().contains(showSpecialExhName));
		
	}
	@Test(priority = 2)
	public void TS002_VerifyShowroomLinkForShowSpecialsTest()
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

	@AfterClass
	public void tearDown() {
		 driver.quit();
	}
}
