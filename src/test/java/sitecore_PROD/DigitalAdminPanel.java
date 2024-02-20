package sitecore_PROD;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import atlantamarket_UAT.TestListeners;
import bsh.util.Util;
import pageObjects.AtlantaMarket.ATLEventsAndWebinarPage;
import pageObjects.AtlantaMarket.ATLFloorPlansPage;
import pageObjects.AtlantaMarket.ATLGlobalSearchPage;
import pageObjects.AtlantaMarket.ATLLandingPage;
import pageObjects.AtlantaMarket.ATLLoginPage;
import pageObjects.Sitecore.SCDigitalAdminPanelPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

public class DigitalAdminPanel extends base {

	public WebDriverWait wait;
	public GenerateData genData;
	public Utility utl;
	SCDigitalAdminPanelPage digiAdmin;

	@BeforeClass(alwaysRun=true)
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); 
		utl = new Utility(driver);
	
		utl.siteCoreLogin();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(priority = 1) 
	public void TS001_VerifyDigitalAdminPanelTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-Digital Admin Functionality
		// UXP-T :
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("-----------------VerifyDigitalAdminPanelTest------------------------");
		
		digiAdmin=new SCDigitalAdminPanelPage(driver);
		//Click on Digital Admin Panel
		digiAdmin.getDigitalAdminPanel().click();
		Thread.sleep(5000);
	}

}
