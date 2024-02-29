package sitecore_PROD;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
	public void TS001_VerifyDigitalAdminPanelSearchFunctionalityTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-Digital Admin Functionality
		// UXP-T :
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("-----------------VerifyDigitalAdminPanelTest------------------------");
		
		digiAdmin=new SCDigitalAdminPanelPage(driver);
		//Click on Digital Admin Panel
		digiAdmin.getDigitalAdminPanel().click();
		//Get email id from table
		String emailId=digiAdmin.getdigitalAdminPanelSearch1stEmail().getText();
		//Enter email id into search box
		digiAdmin.getdigitalAdminPanelSearchBox().sendKeys(emailId);
		//Click on Search Button
		digiAdmin.getdigitalAdminPanelSearchButton().click();
		//Veriy search result
		Assert.assertEquals(emailId, digiAdmin.getdigitalAdminPanelSearch1stEmail().getText());
		Thread.sleep(5000);
	}
	@Test(priority = 2) 
	public void TS002_VerifyDigitalAdminPanelSortByOptionsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-Digital Admin SortBy Options
		// UXP-T :
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("-----------------VerifyDigitalAdminPanelTest------------------------");
		
		digiAdmin=new SCDigitalAdminPanelPage(driver);
		//Click on Digital Admin Panel
		digiAdmin.getDigitalAdminPanel().click();
		Thread.sleep(8000);
		//Click on SortBy Button
		digiAdmin.getdigitalAdminPanelSortByButton().click();
		//Verify SortBy options
		utl.checkItemPresentInListorNot(digiAdmin.getdigitalAdminPanelListSortByOptions(), prop.getProperty("SC_SortByOption1"));
		utl.checkItemPresentInListorNot(digiAdmin.getdigitalAdminPanelListSortByOptions(), prop.getProperty("SC_SortByOption2"));
		utl.checkItemPresentInListorNot(digiAdmin.getdigitalAdminPanelListSortByOptions(), prop.getProperty("SC_SortByOption3"));
	}
	@Test(priority = 3) 
	public void TS003_VerifyDigitalAdminPanelSortByOptionsFunctinalityTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-Digital Admin SortBy Options Functinality
		// UXP-T :
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("-----------------VerifyDigitalAdminPanelTest------------------------");
		
		digiAdmin=new SCDigitalAdminPanelPage(driver);
		//Click on Digital Admin Panel
		digiAdmin.getDigitalAdminPanel().click();
		Thread.sleep(8000);
		//Click on SortBy Button
		digiAdmin.getdigitalAdminPanelSortByButton().click();
		//Click on Sort by Update Date
		//utl.SortingList(digiAdmin.getdigitalAdminPanelResultList(),digiAdmin.getdigitalAdminPanelListSortByOptions(),prop.getProperty("SC_SortByOption1"));
		utl.SortByDigitalIdentity(digiAdmin.getdigitalAdminPanelResultList(),digiAdmin.getdigitalAdminPanelListSortByOptions(),prop.getProperty("SC_SortByOption2"));
		digiAdmin.getdigitalAdminPanelSortByButton().click();
	    utl.SortByLastName(digiAdmin.getdigitalAdminPanelLastNameList(),digiAdmin.getdigitalAdminPanelListSortByOptions(),prop.getProperty("SC_SortByOption3"));
	}
	@Test(priority = 4) 
	public void TS004_VerifyDigitalAdminPanelFilterByOptionsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-Digital Admin SortBy Options
		// UXP-T :
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("-----------------VerifyDigitalAdminPanelTest------------------------");
		
		digiAdmin=new SCDigitalAdminPanelPage(driver);
		//Click on Digital Admin Panel
		digiAdmin.getDigitalAdminPanel().click();
		Thread.sleep(8000);
		//Click on SortBy Button
		digiAdmin.getdigitalAdminPanelFilterByButton().click();
		//Verify SortBy options
		utl.checkItemPresentInListorNot(digiAdmin.getdigitalAdminPanelListSortByOptions(), prop.getProperty("SC_SortByOption1"));
		utl.checkItemPresentInListorNot(digiAdmin.getdigitalAdminPanelListSortByOptions(), prop.getProperty("SC_SortByOption2"));
		utl.checkItemPresentInListorNot(digiAdmin.getdigitalAdminPanelListSortByOptions(), prop.getProperty("SC_SortByOption3"));
	}
}
