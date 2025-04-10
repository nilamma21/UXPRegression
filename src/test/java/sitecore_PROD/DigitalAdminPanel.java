package sitecore_PROD;

import java.io.IOException;
import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
import pageObjects.Sitecore.SCDigitalAdminPanelUserProfilePage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

public class DigitalAdminPanel extends base {

	public WebDriverWait wait;
	public GenerateData genData;
	public Utility utl;
	SCDigitalAdminPanelPage digiAdmin;
	SCDigitalAdminPanelUserProfilePage digiAdminUserProf;

	@BeforeClass(alwaysRun=true)
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); 
		utl = new Utility(driver);
	
		//utl.siteCoreLogin();
		utl.siteCoreLoginUAT();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}

	@Test(priority = 8) 
	public void TS001_VerifyDigitalAdminPanelSearchFunctionalityTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-Digital Admin Functionality
		// UXP-T :
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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
		//goto Home page
		digiAdmin.getSCLaunchPad().click();
	}
	@Test(priority = 9) 
	public void TS002_VerifyDigitalAdminPanelSortByOptionsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-Digital Admin SortBy Options
		// UXP-T :
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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
		//goto Home page
		digiAdmin.getSCLaunchPad().click();
	}
	@Test(priority = 10) 
	public void TS003_VerifyDigitalAdminPanelSortByOptionsFunctinalityTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-Digital Admin SortBy Options Functinality
		// UXP-T :
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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
		//goto Home page
		digiAdmin.getSCLaunchPad().click();
	}
	@Test(priority = 4) 
	public void TS004_VerifyDigitalAdminPanelFilterByOptionsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-Digital Admin SortBy Options
		// UXP-T :
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("-----------------VerifyDigitalAdminPanelTest------------------------");
		
		digiAdmin=new SCDigitalAdminPanelPage(driver);
		//Click on Digital Admin Panel
		digiAdmin.getDigitalAdminPanel().click();
		Thread.sleep(8000);
		//Click on FilterBy Button
		digiAdmin.getdigitalAdminPanelFilterByButton().click();
		//Verify FilterBy options
		utl.checkItemPresentInListorNot(digiAdmin.getdigitalAdminPanelListSortByOptions(), prop.getProperty("SC_FilterByOption1"));
		utl.checkItemPresentInListorNot(digiAdmin.getdigitalAdminPanelListSortByOptions(), prop.getProperty("SC_FilterByOption2"));
		utl.checkItemPresentInListorNot(digiAdmin.getdigitalAdminPanelListSortByOptions(), prop.getProperty("SC_FilterByOption3"));
		utl.checkItemPresentInListorNot(digiAdmin.getdigitalAdminPanelListSortByOptions(), prop.getProperty("SC_FilterByOption4"));
		digiAdmin.getSCLaunchPad().click();
		Thread.sleep(5000);
		
	}
	@Test(priority = 5) 
	public void TS005_VerifyDigitalAdminPanelFilteByOptionsFunctinalityTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-Digital Admin SortBy Options Functinality
		// UXP-T :
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("-----------------VerifyDigitalAdminPanelTest------------------------");

		digiAdmin = new SCDigitalAdminPanelPage(driver);
		// Click on Digital Admin Panel
		digiAdmin.getDigitalAdminPanel().click();
		Thread.sleep(8000);
		// Store Current list
		List<String> currentList = new ArrayList<String>();
		for (WebElement currentElement : digiAdmin.getdigitalAdminPanelResultList()) {
			currentList.add(currentElement.getText().toLowerCase());
		}
		System.out.println("Current List : " + currentList);
		
		//Click on SortBy Button
		digiAdmin.getdigitalAdminPanelSortByButton().click();
		//Click on Sort by DititalIdentity
		utl.SortByDigitalIdentity(digiAdmin.getdigitalAdminPanelResultList(),digiAdmin.getdigitalAdminPanelListSortByOptions(),prop.getProperty("SC_SortByOption2"));
		//Click on FilterBy
		digiAdmin.getdigitalAdminPanelFilterByButton().click();
		//Click on Reset Filter option
		utl.selectFilters(digiAdmin.getdigitalAdminPanelListSortByOptions(), prop.getProperty("SC_FilterByOption1"));
		Thread.sleep(5000);
		//List after filter by applying
		List<String> listAfterApplyingResetFilter = new ArrayList<String>();
		for (WebElement currentElement : digiAdmin.getdigitalAdminPanelResultList()) {
			listAfterApplyingResetFilter.add(currentElement.getText().toLowerCase());
		}
		System.out.println("Reset Filter List : " + listAfterApplyingResetFilter);
		Assert.assertEquals(currentList, listAfterApplyingResetFilter);

		// Click on FilterBy
		digiAdmin.getdigitalAdminPanelFilterByButton().click();
		// Click on No Association option
		utl.selectFilters(digiAdmin.getdigitalAdminPanelListSortByOptions(), prop.getProperty("SC_FilterByOption2"));
		Thread.sleep(8000);
		//Verify No Association working or not
		//utl.siteCoreFiterByNoAssociation(digiAdmin.getdigitalAdminPanelAssociatedExhibitorList());
		utl.checkSiteCoreFilterByAssociation(digiAdmin.getdigitalAdminPanelAssociatedExhibitorList(),false);
		/*// Click on FilterBy
		digiAdmin.getdigitalAdminPanelFilterByButton().click();
		// Click on Buyers option
		utl.selectFilters(digiAdmin.getdigitalAdminPanelListSortByOptions(), prop.getProperty("SC_FilterByOption3"));
		Thread.sleep(8000);*/
		// Click on FilterBy
		digiAdmin.getdigitalAdminPanelFilterByButton().click();
		// Click on No Association option
		utl.selectFilters(digiAdmin.getdigitalAdminPanelListSortByOptions(), prop.getProperty("SC_FilterByOption4"));
		Thread.sleep(8000);
		//Verify No Association working or not
		//utl.siteCoreFiterByExhibitor(digiAdmin.getdigitalAdminPanelAssociatedExhibitorList());
		utl.checkSiteCoreFilterByAssociation(digiAdmin.getdigitalAdminPanelAssociatedExhibitorList(),true);
digiAdmin.getSCLaunchPad().click();
		Thread.sleep(5000);
		//goto Home page
		digiAdmin.getSCLaunchPad().click();
	}
	@Test(priority = 6) 
	public void TS006_VerifyDigitalAdminPanelActionsOptionsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-Digital Admin Actions Options
		// UXP-T :
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("-----------------VerifyDigitalAdminPanelTest------------------------");
		
		digiAdmin=new SCDigitalAdminPanelPage(driver);
		//Click on Digital Admin Panel
		digiAdmin.getDigitalAdminPanel().click();
		Thread.sleep(8000);
		//Click on Acions Button
		digiAdmin.getdigitalAdminPanelActionButton().click();
		//Verify Action button options
		utl.checkItemPresentInListorNot(digiAdmin.getdigitalAdminPanelListOfActionOptions(), prop.getProperty("SC_ActionOption1"));
		utl.checkItemPresentInListorNot(digiAdmin.getdigitalAdminPanelListOfActionOptions(), prop.getProperty("SC_ActionOption2"));
		utl.checkItemPresentInListorNot(digiAdmin.getdigitalAdminPanelListOfActionOptions(), prop.getProperty("SC_ActionOption3"));
digiAdmin.getSCLaunchPad().click();
		Thread.sleep(5000);
		//goto Home page
		digiAdmin.getSCLaunchPad().click();
	}
	@Test(priority = 7) 
	public void TS007_VerifyDigitalAdminPanelActionsOptionsFunctinalityTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-Digital Admin Actions Options Functinality
		// UXP-T :
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("-----------------VerifyDigitalAdminPanelTest------------------------");

		digiAdmin = new SCDigitalAdminPanelPage(driver);
		// Click on Digital Admin Panel
		digiAdmin.getDigitalAdminPanel().click();
		Thread.sleep(8000);
		//Select Any digital identity-->click on checkbox
		
		//---------------------Test Code----------

		digiAdmin.getdigitalAdminPanelSearchBox().sendKeys(prop.getProperty("SC_CreateUserEmail"));
		//Click on Search Button
		digiAdmin.getdigitalAdminPanelSearchButton().click();
		Thread.sleep(5000);
		//---------------------Test Code----------
		
		//Click on Checkbox
		digiAdmin.getdigitalAdminPanelHomePageFirstCheckbox().click();
		//Click on Actions button
		digiAdmin.getdigitalAdminPanelActionButton().click();
		//Click on Actions -->Disable
		utl.selectFilters(digiAdmin.getdigitalAdminPanelListOfActionOptions(), prop.getProperty("SC_ActionOption2"));
		Thread.sleep(10000);
		//---------------------Test Code----------

		digiAdmin.getdigitalAdminPanelSearchBox().sendKeys(prop.getProperty("SC_CreateUserEmail"));
		//Click on Search Button
		digiAdmin.getdigitalAdminPanelSearchButton().click();
		Thread.sleep(5000);
		//---------------------Test Code----------
		
		//Verify disable digital identity is-active status changes from true to false
		Assert.assertEquals(digiAdmin.getdigitalAdminPanelHomePageIsActiveStatus().getText(), prop.getProperty("SC_ActionFilterDisable"));
		
		
		//Click on Checkbox
		digiAdmin.getdigitalAdminPanelHomePageFirstCheckbox().click();
		//Select false status digital identity to change its status false to true
		digiAdmin.getdigitalAdminPanelActionButton().click();
		//Click on Actions -->Enable
		utl.selectFilters(digiAdmin.getdigitalAdminPanelListOfActionOptions(), prop.getProperty("SC_ActionOption1"));
		//Verify selected digital identity is-active status changes from false to true
		Thread.sleep(8000);
		//---------------------Test Code----------

		digiAdmin.getdigitalAdminPanelSearchBox().sendKeys(prop.getProperty("SC_CreateUserEmail"));
		//Click on Search Button
		digiAdmin.getdigitalAdminPanelSearchButton().click();
		Thread.sleep(5000);
		//---------------------Test Code----------
		
		//Verify disable digital identity is-active status changes from true to false
		Assert.assertEquals(digiAdmin.getdigitalAdminPanelHomePageIsActiveStatus().getText(), prop.getProperty("SC_ActionFilterEnable"));
		
		/*//Click on Checkbox
		digiAdmin.getdigitalAdminPanelHomePageFirstCheckbox().click();
		//Click on Actions button
		digiAdmin.getdigitalAdminPanelActionButton().click();
		//Click on Actions -->Delete ----code Pending
		utl.selectFilters(digiAdmin.getdigitalAdminPanelListOfActionOptions(), prop.getProperty("SC_ActionOption3"));*/
		//Verify disable digital identity delete or not/Present or not
		//goto Home page
		digiAdmin.getSCLaunchPad().click();
	}
	//Verification part NOT COMPLETED YET
	@Test(priority = 3) 
	public void TS008_VerifyDigitalAdminPanelCreateUserTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-Digital Admin User Name Functinality
		// UXP-T :
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("-----------------VerifyDigitalAdminPanelTest------------------------");

		digiAdmin = new SCDigitalAdminPanelPage(driver);
		// Click on Digital Admin Panel
		digiAdmin.getDigitalAdminPanel().click();
		Thread.sleep(8000);
		//Click on Create user btn
		digiAdmin.getdigitalAdminPanelCreateUserButton().click();
		//Verify Popup
		digiAdmin.getdigitalAdminPanelCreateUserPopup().isDisplayed();
		//Click on First Name
		digiAdmin.getdigitalAdminPanelCreateUserFirstName().sendKeys(prop.getProperty("SC_CreateUserFirstName"));
		//Click on Last Name
		digiAdmin.getdigitalAdminPanelCreateUserLastName().sendKeys(prop.getProperty("SC_CreateUserLastName"));
		//Click on Last Name
		digiAdmin.getdigitalAdminPanelCreateUserEmail().sendKeys(prop.getProperty("SC_CreateUserEmail"));
		//Click on Send btn
		digiAdmin.getdigitalAdminPanelCreateUserSend().click();
		
		try {
			//Click on Cancel
			digiAdmin.getdigitalAdminPanelCreateUserCancel().click();
		}catch (Exception e) {
			// TODO: handle exception
	
		//Verify Create User
			Thread.sleep(5000);
		//Enter email id into search box
		digiAdmin.getdigitalAdminPanelSearchBox().sendKeys(prop.getProperty("SC_CreateUserEmail"));
		//Click on Search Button
		digiAdmin.getdigitalAdminPanelSearchButton().click();
		Thread.sleep(2000);
		//Veriy search result
		Assert.assertEquals(prop.getProperty("SC_CreateUserEmail"),digiAdmin.getdigitalAdminPanelSearch1stEmail().getText());
	
		//goto Home page
		digiAdmin.getSCLaunchPad().click();
		}
	}

	@Test(priority = 2) 
	public void TS009_VerifyDigitalAdminPanelCreateUserErrorMsgTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-Digital Admin User Profile Error msg
		// UXP-T :
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("-----------------VerifyDigitalAdminPanelTest------------------------");

		digiAdmin = new SCDigitalAdminPanelPage(driver);
		// Click on Digital Admin Panel
		digiAdmin.getDigitalAdminPanel().click();
		Thread.sleep(8000);
		
		//Click on Create user btn
		digiAdmin.getdigitalAdminPanelCreateUserButton().click();
		//Click on Send btn without entering any info
		digiAdmin.getdigitalAdminPanelCreateUserSend().click();		
		//Verify Error msg
		String errorMsgForAllEmpty=digiAdmin.getdigitalAdminPanelCreateUserSendBtnErrorMsg().getText();
		System.out.println(errorMsgForAllEmpty);
		//Assert.assertEquals(prop.getProperty("SC_CreateUserSendBtnEmptyAllFiledsErrorMsg"), errorMsgForAllEmpty);
		Assert.assertEquals(prop.getProperty("SC_CreateUserSendBtnEmptyAllFiledsErrorMsg"), errorMsgForAllEmpty);
		System.out.println("For All Empty Fileds : Error msg displayed");
		
		Thread.sleep(5000);
		//Click on First Name
		digiAdmin.getdigitalAdminPanelCreateUserFirstName().sendKeys(prop.getProperty("SC_CreateUserFirstName"));
		//Click on Send btn with firstname filed
		digiAdmin.getdigitalAdminPanelCreateUserSend().click();		
		//Verify Error msg
		String errorMsgForLastNameEmail=digiAdmin.getdigitalAdminPanelCreateUserSendBtnErrorMsg().getText();
		System.out.println(errorMsgForLastNameEmail);
		//Assert.assertEquals((prop.getProperty("SC_CreateUserSendBtnErrorMsgFirstNameAdded")), errorMsgForLastNameEmail);
		Assert.assertEquals(prop.getProperty("SC_CreateUserSendBtnErrorMsgFirstNameAdded"), errorMsgForLastNameEmail);
		System.out.println("For Last and Email fileds empty : Error msg displayed");
		
		Thread.sleep(5000);
		digiAdmin.getdigitalAdminPanelCreateUserFirstName().clear();
		//Click on Last Name
		digiAdmin.getdigitalAdminPanelCreateUserLastName().sendKeys(prop.getProperty("SC_CreateUserLastName"));
		Thread.sleep(5000);
		//Click on Send btn with last name
		digiAdmin.getdigitalAdminPanelCreateUserSend().click();		
		//Verify Error msg
		String errorMsgFnameEmail=digiAdmin.getdigitalAdminPanelCreateUserSendBtnErrorMsg().getText();
		System.out.println(errorMsgFnameEmail);
		//Assert.assertEquals(prop.getProperty("SC_CreateUserEmail"), errorMsgFnameEmail);
		Assert.assertEquals(prop.getProperty("SC_CreateUserSendBtnErrorMsgLastNameAdded"), errorMsgFnameEmail);
		System.out.println("FIrst Name and Email  empty :Error msg displayed");
		
		Thread.sleep(5000);
		digiAdmin.getdigitalAdminPanelCreateUserLastName().clear();
		//Click on Email
		digiAdmin.getdigitalAdminPanelCreateUserEmail().sendKeys(prop.getProperty("SC_CreateUserEmail"));
		Thread.sleep(5000);
		//Click on Send btn
		digiAdmin.getdigitalAdminPanelCreateUserSend().click();
		//Verify Error msg
		String errorMsgFnameLname=digiAdmin.getdigitalAdminPanelCreateUserSendBtnErrorMsg().getText();
		System.out.println(errorMsgFnameLname);
		//Assert.assertEquals(prop.getProperty("SC_CreateUserEmail"), errorMsgFnameLname);
		Assert.assertEquals(prop.getProperty("SC_CreateUserSendBtnErrorMsgEmailAdded"), errorMsgFnameLname);
		System.out.println("FIrst Name and last name empty :Error msg displayed");

		Thread.sleep(5000);
		digiAdmin.getdigitalAdminPanelCreateUserEmail().clear();
		//Click on First Name
		digiAdmin.getdigitalAdminPanelCreateUserFirstName().sendKeys(prop.getProperty("SC_CreateUserFirstName"));
		//Click on Last Name
		digiAdmin.getdigitalAdminPanelCreateUserLastName().sendKeys(prop.getProperty("SC_CreateUserLastName"));
		//Click on Email
		digiAdmin.getdigitalAdminPanelCreateUserEmail().sendKeys(prop.getProperty("SC_CreateUserEmailWrong"));
		//Click on Send btn
		digiAdmin.getdigitalAdminPanelCreateUserSend().click();
		//Verify Error msg
		String errorMsgInvalidEmail=digiAdmin.getdigitalAdminPanelCreateUserSendBtnErrorMsg().getText();
		System.out.println(errorMsgInvalidEmail);
		Assert.assertEquals(prop.getProperty("SC_CreateUserSendBtnErrorMsgInvalidEmail"), errorMsgInvalidEmail);
		System.out.println("Invalid Email Id :Error msg displayed");
		
		//goto Home page
		digiAdmin.getSCLaunchPad().click();
		
	}
	@Test(priority = 1) 
	public void TS0010_VerifyDigitalAdminPanelCreateUserCancelButtonTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-Digital Admin User Profile Cancel Functinality
		// UXP-T :
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("-----------------VerifyDigitalAdminPanelTest------------------------");

		digiAdmin = new SCDigitalAdminPanelPage(driver);
		// Click on Digital Admin Panel
		digiAdmin.getDigitalAdminPanel().click();
		Thread.sleep(8000);
		//Click on Create user btn
		digiAdmin.getdigitalAdminPanelCreateUserButton().click();
		//Verify Popup
		digiAdmin.getdigitalAdminPanelCreateUserPopup().isDisplayed();
		//Click on Cancel
		digiAdmin.getdigitalAdminPanelCreateUserCancel().click();
		//Verify Popup shoud closed
		digiAdmin.getdigitalAdminPanelHomePageHeader().isDisplayed();
		System.out.println("Cancel Btn working");
		//goto Home page
		digiAdmin.getSCLaunchPad().click();
	}

	@Test(priority = 11) 
	public void TS011_VerifyDigitalAdminPanelOpenUserProfileTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-Digital Admin User Profile create new user Functinality
		// UXP-T :
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("-----------------VerifyDigitalAdminPanelTest------------------------");

		digiAdmin = new SCDigitalAdminPanelPage(driver);
		// Click on Digital Admin Panel
		digiAdmin.getDigitalAdminPanel().click();
		Thread.sleep(8000);
		//Click on Checkbox
		digiAdmin.getdigitalAdminPanelHomePageFirstCheckbox().click();
		//Get email id from table
		String emailId=digiAdmin.getdigitalAdminPanelSearch1stEmail().getText();
		//Click on user profile button
		digiAdmin.getdigitalAdminPanelUserProfile().click();
		Thread.sleep(5000);
		//verify user profile page 
		Assert.assertEquals(digiAdminUserProf.getdigitalAdminPanelUserProfilePageEmailId().getText(),emailId,"Passed");
		digiAdmin.getSCLaunchPad().click();
		Thread.sleep(5000);
	}
	
	@Test(priority = 12) 
	public void TS012_VerifyDigitalAdminPanelOpenUserProfileSendPasswordResetCTATest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-Digital Admin User Profile Send Password Reset CTA
		// UXP-T822 :Sitecore : Digital Admin Panel - Send Password Reset CTA
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("-----------------VerifyDigitalAdminPanelTest------------------------");

		digiAdmin = new SCDigitalAdminPanelPage(driver);
		digiAdminUserProf =new SCDigitalAdminPanelUserProfilePage(driver);
		// Click on Digital Admin Panel
		digiAdmin.getDigitalAdminPanel().click();
		Thread.sleep(8000);
		//---------------------Test Code----------
		
		digiAdmin.getdigitalAdminPanelSearchBox().sendKeys(prop.getProperty("SC_CreateUserEmail"));
		//Click on Search Button
		digiAdmin.getdigitalAdminPanelSearchButton().click();
		Thread.sleep(5000);
		//---------------------Test Code----------
		//Click on Checkbox
		digiAdmin.getdigitalAdminPanelHomePageFirstCheckbox().click();
		//Get email id from table
		String emailId=digiAdmin.getdigitalAdminPanelSearch1stEmail().getText();
		//Click on user profile button
		digiAdmin.getdigitalAdminPanelUserProfile().click();
		Thread.sleep(5000);
		//verify user profile page 
		Assert.assertEquals(digiAdminUserProf.getdigitalAdminPanelUserProfilePageEmailId().getText(),emailId,"Passed");
		//Click on Password REST CTA
		digiAdminUserProf.getdigitalAdminPanelUserProfilePagePasswordResetCTA().click();
		String actualPopupMsg=prop.getProperty("SC_CreateUserProfilePswdResetBtnPopupMsg");
		String expectedPopupMsg=digiAdminUserProf.getdigitalAdminPanelUserProfilePagePasswordResetCTAPopupMsg().getText();
		System.out.println(expectedPopupMsg);
		//Verify Popup msg
		digiAdminUserProf.getdigitalAdminPanelUserProfilePagePasswordResetCTAPopupMsg().isDisplayed();
		Assert.assertEquals(actualPopupMsg,expectedPopupMsg,"Passed");
		//Click on Cancel CTA
		digiAdminUserProf.getdigitalAdminPanelUserProfilePagePasswordResetPopupMsgCancelCTA().click();
		//Verify user Profile Page
		Assert.assertEquals(digiAdminUserProf.getdigitalAdminPanelUserProfilePageEmailId().getText(),emailId,"Passed");
		//Click on Password REST CTA
		digiAdminUserProf.getdigitalAdminPanelUserProfilePagePasswordResetCTA().click();
		//Click on Send CTA
		digiAdminUserProf.getdigitalAdminPanelUserProfilePagePasswordResetPopupMsgSendCTA().click();
		//Verify Send Msg
		Thread.sleep(10000);
		System.out.println(digiAdminUserProf.getdigitalAdminPanelMsgPanel().getText());
		
		Assert.assertEquals(digiAdminUserProf.getdigitalAdminPanelMsgPanel().getText(),prop.getProperty("SC_CreateUserProfileMessagePnaleMsg"),"Passed");
		/*driver.get(prop.getProperty("sitecoreurl_prod"));
		Thread.sleep(5000);*/
		digiAdmin.getSCLaunchPad().click();
	}
	@Test(priority = 13) 
	public void TS013_VerifyDigitalAdminPanelOpenUserProfileEditUserInfoPopup() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-Digital Admin User Profile Edit User Info popup
		// UXP
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("-----------------VerifyDigitalAdminPanelTest------------------------");

		digiAdmin = new SCDigitalAdminPanelPage(driver);
		digiAdminUserProf =new SCDigitalAdminPanelUserProfilePage(driver);
		// Click on Digital Admin Panel
		digiAdmin.getDigitalAdminPanel().click();
		Thread.sleep(8000);
		//---------------------Test Code----------
		
		digiAdmin.getdigitalAdminPanelSearchBox().sendKeys(prop.getProperty("SC_CreateUserEmail"));
		//Click on Search Button
		digiAdmin.getdigitalAdminPanelSearchButton().click();
		Thread.sleep(5000);
		//---------------------Test Code----------
		//Click on Checkbox
		digiAdmin.getdigitalAdminPanelHomePageFirstCheckbox().click();
		//Get email id from table
		String emailId=digiAdmin.getdigitalAdminPanelSearch1stEmail().getText();
		//Click on user profile button
		digiAdmin.getdigitalAdminPanelUserProfile().click();
		Thread.sleep(5000);
		//verify user profile page 
		Assert.assertEquals(digiAdminUserProf.getdigitalAdminPanelUserProfilePageEmailId().getText(),emailId,"Passed");
		//Click on Edit user liink
		digiAdminUserProf.getdigitalAdminPanelEditUser().click();
		//Verify edit user popup
		Thread.sleep(2000);
		digiAdminUserProf.getdigitalAdminPanelEditUserPopup().isDisplayed();
		digiAdmin.getSCLaunchPad().click();
	}
	@Test(priority = 14) 
	public void TS014_VerifyDigitalAdminPanelOpenUserProfileEditUserInfoPopupCancelCTA() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-Digital Admin User Profile Edit User Info popup Cancel CTA
		// UXP
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("-----------------VerifyDigitalAdminPanelTest------------------------");

		digiAdmin = new SCDigitalAdminPanelPage(driver);
		digiAdminUserProf =new SCDigitalAdminPanelUserProfilePage(driver);
		// Click on Digital Admin Panel
		digiAdmin.getDigitalAdminPanel().click();
		Thread.sleep(8000);
		//---------------------Test Code----------
		
		digiAdmin.getdigitalAdminPanelSearchBox().sendKeys(prop.getProperty("SC_CreateUserEmail"));
		//Click on Search Button
		digiAdmin.getdigitalAdminPanelSearchButton().click();
		Thread.sleep(5000);
		//---------------------Test Code----------
		//Click on Checkbox
		digiAdmin.getdigitalAdminPanelHomePageFirstCheckbox().click();
		//Get email id from table
		String emailId=digiAdmin.getdigitalAdminPanelSearch1stEmail().getText();
		//Click on user profile button
		digiAdmin.getdigitalAdminPanelUserProfile().click();
		Thread.sleep(5000);
		//verify user profile page 
		Assert.assertEquals(digiAdminUserProf.getdigitalAdminPanelUserProfilePageEmailId().getText(),emailId,"Passed");
		//Click on Edit user liink
		digiAdminUserProf.getdigitalAdminPanelEditUser().click();
		//Verify edit user popup
		Thread.sleep(2000);
		digiAdminUserProf.getdigitalAdminPanelEditUserPopup().isDisplayed();
		//Click on Cancel CTA
		digiAdminUserProf.getdigitalAdminPanelEditUserCancelCTA().click();
		//verify user profile page 
		Assert.assertEquals(digiAdminUserProf.getdigitalAdminPanelUserProfilePageEmailId().getText(),emailId,"Passed");
		digiAdmin.getSCLaunchPad().click();
	}
	@Test(priority = 15) 
	public void TS015_VerifyDigitalAdminPanelOpenUserProfileEditUserInfoPopupSendCTAWitoutEnteringInfo() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-Digital Admin User Profile Edit User Info popup Send CTA without entering any info
		// UXP
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("-----------------VerifyDigitalAdminPanelTest------------------------");

		digiAdmin = new SCDigitalAdminPanelPage(driver);
		digiAdminUserProf =new SCDigitalAdminPanelUserProfilePage(driver);
		// Click on Digital Admin Panel
		digiAdmin.getDigitalAdminPanel().click();
		Thread.sleep(8000);
		//---------------------Test Code----------
		
		digiAdmin.getdigitalAdminPanelSearchBox().sendKeys(prop.getProperty("SC_CreateUserEmail"));
		//Click on Search Button
		digiAdmin.getdigitalAdminPanelSearchButton().click();
		Thread.sleep(5000);
		//---------------------Test Code----------
		//Click on Checkbox
		digiAdmin.getdigitalAdminPanelHomePageFirstCheckbox().click();
		//Get email id from table
		String emailId=digiAdmin.getdigitalAdminPanelSearch1stEmail().getText();
		//Click on user profile button
		digiAdmin.getdigitalAdminPanelUserProfile().click();
		Thread.sleep(5000);
		//verify user profile page 
		Assert.assertEquals(digiAdminUserProf.getdigitalAdminPanelUserProfilePageEmailId().getText(),emailId,"Passed");
		//Click on Edit user liink
		digiAdminUserProf.getdigitalAdminPanelEditUser().click();
		//Verify edit user popup
		Thread.sleep(2000);
		digiAdminUserProf.getdigitalAdminPanelEditUserPopup().isDisplayed();
		//Click on Send CTA
		digiAdminUserProf.getdigitalAdminPanelEditUserSendCTA().click();
		//verify user profile page
		Thread.sleep(5000);
		digiAdminUserProf.getdigitalAdminPanelMsgPanel().isDisplayed();
		digiAdmin.getSCLaunchPad().click();
	}
	@Test(priority = 16) 
	public void TS016_VerifyDigitalAdminPanelOpenUserProfileEditUserInfoPopupSendCTAWithEnteringInfo() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-Digital Admin User Profile Edit User Info popup Send CTA without entering any info
		// UXP
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("-----------------VerifyDigitalAdminPanelTest------------------------");

		digiAdmin = new SCDigitalAdminPanelPage(driver);
		digiAdminUserProf =new SCDigitalAdminPanelUserProfilePage(driver);
		// Click on Digital Admin Panel
		digiAdmin.getDigitalAdminPanel().click();
		Thread.sleep(8000);
		//---------------------Test Code----------
		
		digiAdmin.getdigitalAdminPanelSearchBox().sendKeys(prop.getProperty("SC_CreateUserEmail"));
		//Click on Search Button
		digiAdmin.getdigitalAdminPanelSearchButton().click();
		Thread.sleep(5000);
		//---------------------Test Code----------
		//Click on Checkbox
		digiAdmin.getdigitalAdminPanelHomePageFirstCheckbox().click();
		//Get email id from table
		String emailId=digiAdmin.getdigitalAdminPanelSearch1stEmail().getText();
		//Click on user profile button
		digiAdmin.getdigitalAdminPanelUserProfile().click();
		Thread.sleep(5000);
		//verify user profile page 
		Assert.assertEquals(digiAdminUserProf.getdigitalAdminPanelUserProfilePageEmailId().getText(),emailId,"Passed");
		//Click on Edit user liink
		digiAdminUserProf.getdigitalAdminPanelEditUser().click();
		//Verify edit user popup
		Thread.sleep(2000);
		digiAdminUserProf.getdigitalAdminPanelEditUserPopup().isDisplayed();
		//Enter Fname
		digiAdminUserProf.getdigitalAdminPanelEditUserFname().sendKeys(prop.getProperty("SC_UserFirstName"));
		//Enter Lname
		digiAdminUserProf.getdigitalAdminPanelEditUserLname().sendKeys(prop.getProperty("SC_UserLastName"));
		//Enter Cname
		digiAdminUserProf.getdigitalAdminPanelEditUserCname().sendKeys(prop.getProperty("SC_Company"));
		//Click on Send CTA
		digiAdminUserProf.getdigitalAdminPanelEditUserSendCTA().click();
		//verify user profile page 
		Assert.assertEquals(digiAdminUserProf.getdigitalAdminPanelUserProfilePageEmailId().getText(),emailId,"Passed");
		//String mergeFnameLname=prop.getProperty("SC_UserFirstName")+prop.getProperty("SC_UserLastName");
		Thread.sleep(3000);
		//verify updated user name 
		//Assert.assertEquals(digiAdminUserProf.getdigitalAdminPanelUpdatedUserName().getText(),mergeFnameLname,"Passed");
		if(digiAdminUserProf.getdigitalAdminPanelUpdatedUserName().getText().contains((prop.getProperty("SC_UserFirstName")))) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertFalse(true);
		}
		if(digiAdminUserProf.getdigitalAdminPanelUpdatedUserName().getText().contains((prop.getProperty("SC_UserLastName")))) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertFalse(true);
		}
		if(digiAdminUserProf.getdigitalAdminPanelUpdatedUserName().getText().contains((prop.getProperty("SC_UserLastName")))) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertFalse(true);
		}
		if(digiAdminUserProf.getdigitalAdminPanelUpdatedComapanyName().getText().contains((prop.getProperty("SC_Company")))) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertFalse(true);
		}
		digiAdmin.getSCLaunchPad().click();
	}
	@Test(priority = 17) 
	public void TS017_VerifyDigitalAdminPanelOpenUserProfileAssociatedExhibitorDiscardCTA() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-Digital Admin User Profile Add popup and discard CTA
		// UXP
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("-----------------VerifyDigitalAdminPanelTest------------------------");

		digiAdmin = new SCDigitalAdminPanelPage(driver);
		digiAdminUserProf =new SCDigitalAdminPanelUserProfilePage(driver);
		// Click on Digital Admin Panel
		digiAdmin.getDigitalAdminPanel().click();
		Thread.sleep(8000);
		//---------------------Test Code----------
		
		digiAdmin.getdigitalAdminPanelSearchBox().sendKeys(prop.getProperty("SC_CreateUserEmail"));
		//Click on Search Button
		digiAdmin.getdigitalAdminPanelSearchButton().click();
		Thread.sleep(5000);
		//---------------------Test Code----------
		//Click on Checkbox
		digiAdmin.getdigitalAdminPanelHomePageFirstCheckbox().click();
		//Get email id from table
		String emailId=digiAdmin.getdigitalAdminPanelSearch1stEmail().getText();
		//Click on user profile button
		digiAdmin.getdigitalAdminPanelUserProfile().click();
		Thread.sleep(5000);
		//Click on Add CTA
		digiAdminUserProf.getdigitalAdminPanelAddCTA().click();
		//verify Associate Account with an Exhibitor Popup
		digiAdminUserProf.getdigitalAdminPanelAddPopup().isDisplayed();
		//Click on Discard CTA
		digiAdminUserProf.getdigitalAdminPanelAddPopupDiscard().click();
		Thread.sleep(5000);
		//verify user profile page or popup closed
		Assert.assertEquals(digiAdminUserProf.getdigitalAdminPanelUserProfilePageEmailId().getText(),emailId,"Passed");
		digiAdmin.getSCLaunchPad().click();
	}
	@Test(priority = 18) 
	public void TS018_VerifyDigitalAdminPanelOpenUserProfileAssociatedExhibitorSelectExhibitorAdminRadio() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-Digital Admin User Profile Add popup and Add Exhibitor Admin CTA
		// UXP
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("-----------------VerifyDigitalAdminPanelTest------------------------");

		digiAdmin = new SCDigitalAdminPanelPage(driver);
		digiAdminUserProf =new SCDigitalAdminPanelUserProfilePage(driver);
		// Click on Digital Admin Panel
		digiAdmin.getDigitalAdminPanel().click();
		Thread.sleep(8000);
		//---------------------Test Code----------
		
		digiAdmin.getdigitalAdminPanelSearchBox().sendKeys(prop.getProperty("SC_CreateUserEmail"));
		//Click on Search Button
		digiAdmin.getdigitalAdminPanelSearchButton().click();
		Thread.sleep(5000);
		//---------------------Test Code----------
		//Click on Checkbox
		digiAdmin.getdigitalAdminPanelHomePageFirstCheckbox().click();
		//Get email id from table
		String emailId=digiAdmin.getdigitalAdminPanelSearch1stEmail().getText();
		//Click on user profile button
		digiAdmin.getdigitalAdminPanelUserProfile().click();
		Thread.sleep(5000);
		//Click on Add CTA
		digiAdminUserProf.getdigitalAdminPanelAddCTA().click();
		//verify Associate Account with an Exhibitor Popup
		digiAdminUserProf.getdigitalAdminPanelAddPopup().isDisplayed();
		//Enter exhibitor into text filed
		digiAdminUserProf.getdigitalAdminPanelAddPopupExhibitoName().sendKeys((prop.getProperty("autosuggestexhibitor")));
		Thread.sleep(3000);
		//select 1st exhibitor from suggestion list
		digiAdminUserProf.getdigitalAdminPanelAddPopupSelectExhibitoName().click();
		//Click on Admin Radio Button
		digiAdminUserProf.getdigitalAdminPanelAddPopupSelectAdminRadio().click();
		//Click on Add CTA
		digiAdminUserProf.getdigitalAdminPanelAddPopupAdd().click();
		Thread.sleep(10000);
		//Click on Add CTA
		digiAdminUserProf.getdigitalAdminPanelAddCTA().click();
		//verify Associate Account with an Exhibitor Popup
		digiAdminUserProf.getdigitalAdminPanelAddPopup().isDisplayed();
		//Enter exhibitor into text filed
		digiAdminUserProf.getdigitalAdminPanelAddPopupExhibitoName().sendKeys((prop.getProperty("exhibitor4")));
		Thread.sleep(3000);
		//select 1st exhibitor from suggestion list
		digiAdminUserProf.getdigitalAdminPanelAddPopupSelectExhibitoName().click();
		//Click on Admin Radio Button
		digiAdminUserProf.getdigitalAdminPanelAddPopupSelectAdminRadio().click();
		//Click on Add CTA
		digiAdminUserProf.getdigitalAdminPanelAddPopupAdd().click();
		Thread.sleep(10000);
		//Verfiy added exhbitor
		utl.checkItemPresentInListorNot(digiAdminUserProf.getdigitalAdminPanelListOfAddedExhibitors(), (prop.getProperty("autosuggestexhibitor")));
		//Click on Back Link
		digiAdminUserProf.getdigitalAdminPanelBackLink().click();
		Thread.sleep(5000);
		digiAdmin.getdigitalAdminPanelSearchBox().sendKeys(prop.getProperty("SC_CreateUserEmail"));
		//Click on Search Button
		Thread.sleep(5000);
		digiAdmin.getdigitalAdminPanelSearchButton().click();
		//digiAdmin.getdigitalAdminPanelSearchButton().click();

		Thread.sleep(5000);
		//Verify Exhibitor added or not
		Assert.assertTrue(digiAdmin.getdigitalAdminPanelHomePageAssociatedExhibitors().getText().contains((prop.getProperty("autosuggestexhibitor"))));
		//Remove Added exhibiotr
		digiAdmin.getdigitalAdminPanelHomePageFirstCheckbox().click();
		//Click on user profile button
		digiAdmin.getdigitalAdminPanelUserProfile().click();
		Thread.sleep(5000);
		digiAdminUserProf.getdigitalAdminPanelRemoveAddedExh().click();
		Thread.sleep(3000);
		//Verfiy added exhbitor removed or not
		utl.checkItemNotPresentInList(digiAdminUserProf.getdigitalAdminPanelListOfAddedExhibitors(), (prop.getProperty("autosuggestexhibitor")));
		//Click on Back Link
		digiAdminUserProf.getdigitalAdminPanelBackLink().click();
		Thread.sleep(8000);
		digiAdmin.getdigitalAdminPanelSearchBox().sendKeys(prop.getProperty("SC_CreateUserEmail"));
		Thread.sleep(5000);
		//Click on Search Button
		digiAdmin.getdigitalAdminPanelSearchButton().click();
		Thread.sleep(5000);
		//Verify Exhibitor added or not
		Assert.assertFalse(digiAdmin.getdigitalAdminPanelHomePageAssociatedExhibitors().getText().contains((prop.getProperty("autosuggestexhibitor"))));
		
	}
	@Test(priority = 19) 
	public void TS019_VerifyDigitalAdminPanelOpenUserProfileAssociatedExhibitorSelectExhibitorEditorRadio() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-Digital Admin User Profile Add popup and Add Exhibitor Admin CTA
				// UXP
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				System.out.println("-----------------VerifyDigitalAdminPanelTest------------------------");

				digiAdmin = new SCDigitalAdminPanelPage(driver);
				digiAdminUserProf =new SCDigitalAdminPanelUserProfilePage(driver);
				// Click on Digital Admin Panel
				digiAdmin.getDigitalAdminPanel().click();
				Thread.sleep(8000);
				//---------------------Test Code----------
				
				digiAdmin.getdigitalAdminPanelSearchBox().sendKeys(prop.getProperty("SC_CreateUserEmail"));
				//Click on Search Button
				digiAdmin.getdigitalAdminPanelSearchButton().click();
				Thread.sleep(5000);
				//---------------------Test Code----------
				//Click on Checkbox
				digiAdmin.getdigitalAdminPanelHomePageFirstCheckbox().click();
				//Get email id from table
				String emailId=digiAdmin.getdigitalAdminPanelSearch1stEmail().getText();
				//Click on user profile button
				digiAdmin.getdigitalAdminPanelUserProfile().click();
				Thread.sleep(5000);
				//Click on Add CTA
				digiAdminUserProf.getdigitalAdminPanelAddCTA().click();
				//verify Associate Account with an Exhibitor Popup
				digiAdminUserProf.getdigitalAdminPanelAddPopup().isDisplayed();
				//Enter exhibitor into text filed
				digiAdminUserProf.getdigitalAdminPanelAddPopupExhibitoName().sendKeys((prop.getProperty("autosuggestexhibitor")));
				Thread.sleep(3000);
				//select 1st exhibitor from suggestion list
				digiAdminUserProf.getdigitalAdminPanelAddPopupSelectExhibitoName().click();
				//Click on Editor Radio Button
				digiAdminUserProf.getdigitalAdminPanelAddPopupSelectEditorRadio().click();
				//Click on Add CTA
				digiAdminUserProf.getdigitalAdminPanelAddPopupAdd().click();
				Thread.sleep(10000);
				//Click on Add CTA
				digiAdminUserProf.getdigitalAdminPanelAddCTA().click();
				//verify Associate Account with an Exhibitor Popup
				digiAdminUserProf.getdigitalAdminPanelAddPopup().isDisplayed();
				//Enter exhibitor into text filed
				digiAdminUserProf.getdigitalAdminPanelAddPopupExhibitoName().sendKeys((prop.getProperty("exhibitor4")));
				Thread.sleep(3000);
				//select 1st exhibitor from suggestion list
				digiAdminUserProf.getdigitalAdminPanelAddPopupSelectExhibitoName().click();
				//Click on Editor Radio Button
				digiAdminUserProf.getdigitalAdminPanelAddPopupSelectEditorRadio().click();
				//Click on Add CTA
				digiAdminUserProf.getdigitalAdminPanelAddPopupAdd().click();
				Thread.sleep(10000);
				//Verfiy added exhbitor
				utl.checkItemPresentInListorNot(digiAdminUserProf.getdigitalAdminPanelListOfAddedExhibitors(), (prop.getProperty("autosuggestexhibitor")));
				//Click on Back Link
				digiAdminUserProf.getdigitalAdminPanelBackLink().click();
				Thread.sleep(5000);
				digiAdmin.getdigitalAdminPanelSearchBox().sendKeys(prop.getProperty("SC_CreateUserEmail"));
				//Click on Search Button
				Thread.sleep(5000);
				digiAdmin.getdigitalAdminPanelSearchButton().click();
				//digiAdmin.getdigitalAdminPanelSearchButton().click();

				Thread.sleep(5000);
				//Verify Exhibitor added or not
				Assert.assertTrue(digiAdmin.getdigitalAdminPanelHomePageAssociatedExhibitors().getText().contains((prop.getProperty("autosuggestexhibitor"))));
				//Remove Added exhibiotr
				digiAdmin.getdigitalAdminPanelHomePageFirstCheckbox().click();
				//Click on user profile button
				digiAdmin.getdigitalAdminPanelUserProfile().click();
				Thread.sleep(5000);
				digiAdminUserProf.getdigitalAdminPanelRemoveAddedExh().click();
				Thread.sleep(3000);
				//Verfiy added exhbitor removed or not
				utl.checkItemNotPresentInList(digiAdminUserProf.getdigitalAdminPanelListOfAddedExhibitors(), (prop.getProperty("autosuggestexhibitor")));
				//Click on Back Link
				digiAdminUserProf.getdigitalAdminPanelBackLink().click();
				Thread.sleep(8000);
				digiAdmin.getdigitalAdminPanelSearchBox().sendKeys(prop.getProperty("SC_CreateUserEmail"));
				Thread.sleep(5000);
				//Click on Search Button
				digiAdmin.getdigitalAdminPanelSearchButton().click();
				Thread.sleep(5000);
				//Verify Exhibitor added or not
				Assert.assertFalse(digiAdmin.getdigitalAdminPanelHomePageAssociatedExhibitors().getText().contains((prop.getProperty("autosuggestexhibitor"))));
			
	}
	@Test(priority = 20) 
	public void TS020_VerifyDigitalAdminPanelOpenUserProfileAssociatedExhibitorEror() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-Digital Admin User Profile Add popup and Add same Exhibitor and check error 
				// UXP
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				System.out.println("-----------------VerifyDigitalAdminPanelTest------------------------");

				digiAdmin = new SCDigitalAdminPanelPage(driver);
				digiAdminUserProf =new SCDigitalAdminPanelUserProfilePage(driver);
				// Click on Digital Admin Panel
				digiAdmin.getDigitalAdminPanel().click();
				Thread.sleep(8000);
				//---------------------Test Code----------
				
				digiAdmin.getdigitalAdminPanelSearchBox().sendKeys(prop.getProperty("SC_CreateUserEmail"));
				//Click on Search Button
				digiAdmin.getdigitalAdminPanelSearchButton().click();
				Thread.sleep(5000);
				//---------------------Test Code----------
				//Click on Checkbox
				digiAdmin.getdigitalAdminPanelHomePageFirstCheckbox().click();
				//Get email id from table
				String emailId=digiAdmin.getdigitalAdminPanelSearch1stEmail().getText();
				//Click on user profile button
				digiAdmin.getdigitalAdminPanelUserProfile().click();
				Thread.sleep(5000);
				//Click on Add CTA
				digiAdminUserProf.getdigitalAdminPanelAddCTA().click();
				//verify Associate Account with an Exhibitor Popup
				digiAdminUserProf.getdigitalAdminPanelAddPopup().isDisplayed();
				//Enter exhibitor into text filed
				digiAdminUserProf.getdigitalAdminPanelAddPopupExhibitoName().sendKeys((prop.getProperty("autosuggestexhibitor")));
				Thread.sleep(3000);
				//select 1st exhibitor from suggestion list
				digiAdminUserProf.getdigitalAdminPanelAddPopupSelectExhibitoName().click();
				//Click on Editor Radio Button
				digiAdminUserProf.getdigitalAdminPanelAddPopupSelectEditorRadio().click();
				//Click on Add CTA
				digiAdminUserProf.getdigitalAdminPanelAddPopupAdd().click();
				Thread.sleep(10000);
				//Click on Add CTA
				digiAdminUserProf.getdigitalAdminPanelAddCTA().click();
				//verify Associate Account with an Exhibitor Popup
				digiAdminUserProf.getdigitalAdminPanelAddPopup().isDisplayed();
				//Enter exhibitor into text filed
				digiAdminUserProf.getdigitalAdminPanelAddPopupExhibitoName().sendKeys((prop.getProperty("autosuggestexhibitor")));
				Thread.sleep(3000);
				//select 1st exhibitor from suggestion list
				digiAdminUserProf.getdigitalAdminPanelAddPopupSelectExhibitoName().click();
				//Click on Editor Radio Button
				digiAdminUserProf.getdigitalAdminPanelAddPopupSelectEditorRadio().click();
				//Click on Add CTA
				digiAdminUserProf.getdigitalAdminPanelAddPopupAdd().click();
				Thread.sleep(3000);
				utl.scrollToElement(digiAdminUserProf.getdigitalAdminPanelAddCTA());
				//Click on Add CTA
				digiAdminUserProf.getdigitalAdminPanelAddCTA().click();
				//verify Associate Account with an Exhibitor Popup
				digiAdminUserProf.getdigitalAdminPanelAddPopup().isDisplayed();
				//Enter exhibitor into text filed
				digiAdminUserProf.getdigitalAdminPanelAddPopupExhibitoName().sendKeys((prop.getProperty("autosuggestexhibitor")));
				Thread.sleep(3000);
				//select 1st exhibitor from suggestion list
				digiAdminUserProf.getdigitalAdminPanelAddPopupSelectExhibitoName().click();
				//Click on Editor Radio Button
				digiAdminUserProf.getdigitalAdminPanelAddPopupSelectEditorRadio().click();
				//Verify error msg
				digiAdminUserProf.getdigitalAdminPanelExhibitorError().isDisplayed();
				//Verify Add CTA disabled
/*			//	Assert.assertFalse(digiAdminUserProf.getdigitalAdminPanelAddPopupAdd().isEnabled());
				
				

				 if (digiAdminUserProf.getdigitalAdminPanelDisabledAddCTA() != null) {
			            System.out.println("Button is disabled");
			        } else {
			            System.out.println("Button is enabled");
			        }*/
				//Click on Discard
				digiAdminUserProf.getdigitalAdminPanelAddPopupDiscard().click();
				//Remove added exhibitor
				digiAdminUserProf.getdigitalAdminPanelRemoveAddedExh().click();
				Thread.sleep(3000);
				digiAdminUserProf.getdigitalAdminPanelRemoveAddedExh().click();
				Thread.sleep(3000);
	}
	@Test(priority = 21) 
	public void TS021_VerifyDigitalAdminPanelOpenUserProfileAssociatedCTA2() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-Digital Admin User Profile Add popup Doesn't Have Lease CTA
				// UXP
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				System.out.println("-----------------VerifyDigitalAdminPanelTest------------------------");

				digiAdmin = new SCDigitalAdminPanelPage(driver);
				digiAdminUserProf =new SCDigitalAdminPanelUserProfilePage(driver);
				// Click on Digital Admin Panel
				digiAdmin.getDigitalAdminPanel().click();
				Thread.sleep(8000);
				//---------------------Test Code----------
				
				digiAdmin.getdigitalAdminPanelSearchBox().sendKeys(prop.getProperty("SC_CreateUserEmail"));
				//Click on Search Button
				digiAdmin.getdigitalAdminPanelSearchButton().click();
				Thread.sleep(5000);
				//---------------------Test Code----------
				//Click on Checkbox
				digiAdmin.getdigitalAdminPanelHomePageFirstCheckbox().click();
				//Get email id from table
				String emailId=digiAdmin.getdigitalAdminPanelSearch1stEmail().getText();
				//Click on user profile button
				digiAdmin.getdigitalAdminPanelUserProfile().click();
				Thread.sleep(5000);
				//Click on Add CTA
				digiAdminUserProf.getdigitalAdminPanelAddCTA().click();
				//verify Associate Account with an Exhibitor Popup
				digiAdminUserProf.getdigitalAdminPanelAddPopup().isDisplayed();
				//Click on Doesn't have Lease CTA
				digiAdminUserProf.getdigitalAdminPanelDoesntHaveLeaseCTA().click();
				//Click on Select Dropdown
				digiAdminUserProf.getdigitalAdminPanelSelectDropdown().click();
				Select dropdown=new Select(digiAdminUserProf.getdigitalAdminPanelSelectDropdown());
				
				List<WebElement>ExpectedchannelList=dropdown.getOptions();
				List<WebElement>ActulChannelList = null;
				
				for (WebElement dropdownElement : ExpectedchannelList) {
					System.out.println(dropdownElement.getText());
					
				}
				
				
	}
}
