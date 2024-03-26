package sitecore_PROD;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import atlantamarket_UAT.TestListeners;
import pageObjects.Sitecore.SCDashboard;
import pageObjects.Sitecore.SCDigitalAdminPanelPage;
import pageObjects.Sitecore.SCDigitalAdminPanelUserProfilePage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

@Listeners({ TestListeners.class })
public class ShowSpecialsApprovals extends base {


	public WebDriverWait wait;
	public GenerateData genData;
	public Utility utl;
	SCDigitalAdminPanelPage digiAdmin;
	SCDigitalAdminPanelUserProfilePage digiAdminUserProf;
	SCDashboard dashboard;

	@BeforeClass(alwaysRun=true)
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); 
		utl = new Utility(driver);
	
		//utl.siteCoreLogin();
		utl.siteCoreLoginUAT();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test(priority = 1) 
	public void TS001_VerifyDigitalAdminPanelSortByOptionsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-Digital Admin Functionality
		// UXP-T :
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("-----------------VerifyDigitalAdminPanelTest------------------------");
		
		digiAdmin=new SCDigitalAdminPanelPage(driver);
		dashboard=new SCDashboard(driver);
		//Click on Shop Specials 
		dashboard.getExhEventsApprovals().click();
		Thread.sleep(8000);
		//Click on SortBy Button
		digiAdmin.getdigitalAdminPanelSortByButton().click();
		//Verify SortBy options
		utl.checkItemPresentInListorNot(digiAdmin.getdigitalAdminPanelListSortByOptions(), prop.getProperty("SC_ShowSpecialsSortByOption1"));
		utl.checkItemPresentInListorNot(digiAdmin.getdigitalAdminPanelListSortByOptions(), prop.getProperty("SC_ShowSpecialsSortByOption2"));
		utl.checkItemPresentInListorNot(digiAdmin.getdigitalAdminPanelListSortByOptions(), prop.getProperty("SC_ShowSpecialsSortByOption3"));
		utl.checkItemPresentInListorNot(digiAdmin.getdigitalAdminPanelListSortByOptions(), prop.getProperty("SC_ShowSpecialsSortByOption4"));
		utl.checkItemPresentInListorNot(digiAdmin.getdigitalAdminPanelListSortByOptions(), prop.getProperty("SC_ShowSpecialsSortByOption4"));
		utl.checkItemPresentInListorNot(digiAdmin.getdigitalAdminPanelListSortByOptions(), prop.getProperty("SC_ShowSpecialsSortByOption5"));
		//goto Home page
		digiAdmin.getSCLaunchPad().click();
	}
	
	@Test(priority = 2) 
	public void TS002_VerifyDigitalAdminPanelSortByOptionsFunctinalityTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-Digital Admin SortBy Options Functinality
		// UXP-T :
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("-----------------VerifyDigitalAdminPanelTest------------------------");
		
		digiAdmin=new SCDigitalAdminPanelPage(driver);
		dashboard=new SCDashboard(driver);
		//Click on Digital Admin Panel
		//Click on Shop Specials 
		dashboard.getExhEventsApprovals().click();
		Thread.sleep(8000);
		//Click on SortBy Button
		digiAdmin.getdigitalAdminPanelSortByButton().click();
		//Click on Sort by Update Date
		//utl.SortingList(digiAdmin.getdigitalAdminPanelResultList(),digiAdmin.getdigitalAdminPanelListSortByOptions(),prop.getProperty("SC_SortByOption1"));
		utl.SortByDigitalIdentity(digiAdmin.getdigitalAdminPanelResultList(),digiAdmin.getdigitalAdminPanelListSortByOptions(),prop.getProperty("SC_ShowSpecialsSortByOption2"));
		digiAdmin.getdigitalAdminPanelSortByButton().click();
	    utl.SortByLastName(digiAdmin.getdigitalAdminPanelLastNameList(),digiAdmin.getdigitalAdminPanelListSortByOptions(),prop.getProperty("SC_ShowSpecialsSortByOption3"));
		//goto Home page
		digiAdmin.getSCLaunchPad().click();
	}
}

