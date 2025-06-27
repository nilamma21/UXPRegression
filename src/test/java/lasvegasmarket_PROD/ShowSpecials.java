package lasvegasmarket_PROD;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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
		//driver.manage().window().maximize();
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
		Thread.sleep(2000);
		utl.scrollElementIntoMiddle(lvmgs.getFirstShowSpecialName());
	    lvmgs.getFirstShowSpecialName().click();
		/*
		 * //Click on Show Special Exhibitor
		 * utl.scrollElementIntoMiddle(lvmgs.getFirstShowSpecialViewBrandDetailsBtn());
		 * Thread.sleep(200); lvmgs.getFirstShowSpecialViewBrandDetailsBtn().click();
		 * Thread.sleep(5000);
		 */
		
		//Verify Show Special Exh Page 
		Assert.assertTrue(lvmgs.getlvmShowSpecialsTitle().getText().contains(abc));
		//Verify Show special description
		
		Assert.assertTrue(lvmgs.getshowSpecialDescriptionDGShworoomPage().getText().contains(ShowSpecialDetails));
		//driver.get(prop.getProperty("lvmurl_prod"));
		
	}
	@Test(priority = 2)
	public void TS002_VerifyShowSpecialLocationLinkTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T382: Show Specials: Links - Location

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
		
		utl.scrollElementIntoMiddle(lvmgs.getFirstShowSpecialName());
		//utl.scrollToElement(lvmgs.getlvmShowSpecialsTitle());
		//verify Show special Page
		//Assert.assertTrue(lvmgs.getlvmShowSpecialsTitle().getText().contains(prop.getProperty("showSpecialTitle")));
		
		//Click on Show Special Exhibitor
		//String showroomName=lvmgs.getlvmShowroomLink().getText();
		String locationURL=lvmgs.getshowSpecialsLoactionURL().getAttribute("href");
		
		lvmgs.getshowSpecialsLoactionURL().click();

		Assert.assertTrue(driver.getCurrentUrl().contains(locationURL));
		/*
		 * //System.out.println(showroomName);
		 * ac.moveToElement(lvmgs.getlvmShowroomLink()).click().perform();
		 * 
		 * Thread.sleep(5000);
		 * 
		 * //Verify Show Special Exh Page
		 * Assert.assertTrue(driver.getCurrentUrl().contains(url));
		 */
		driver.get(prop.getProperty("lvmurl_prod"));
	}
	@Test(priority = 3)
	public void TS003_VerifyShowSpecialSearchBoxTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// : Show Specials: Links - Search Vendor

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
		
		utl.scrollElementIntoMiddle(lvmgs.getFirstShowSpecialName());
		 String ename = lvmgs.getFirstShowSpecialName().getText();
		lvmgs.getshowSpecialsSearchVendors().click();
		
		lvmgs.getshowSpecialsSearchVendors().sendKeys(ename);
		
		//verify vendor name in search results
		
		Assert.assertTrue(lvmgs.getFirstShowSpecialName().getText().contains(ename));
		
		
		
		
	}
	@Test(priority = 4)
	public void TS004_VerifyShowSpecialSortByDetailsTest() throws InterruptedException, IOException {
	    // The purpose of this test case to verify:-
	    // : Show Specials: Links - SortBy Details

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

	    // Click on Exhibitors And Product Tab
	    // Click on Discover tab
	    Actions ac = new Actions(driver);
	    ac.moveToElement(lvmgs.getLvmDiscoverTab()).click().perform();

	    // Click on Show Specials
	    lvmgs.getlvmShowSpecialsLink().click();
	    Thread.sleep(5000);
	    // Scroll to mid page
	    utl.scrollElementIntoMiddle(lvmgs.getFirstShowSpecialName());

	    Select select = new Select(lvmgs.getshowSpecialsSortByDropdown());
	    
	    
	    //*************Details sorting
	    List<WebElement> detailsElements = lvmgs.getListOfALLShowSpecialsDetails();

	    // Step 1: Print original list
	    System.out.println("\nOriginal list of details:");
	    List<String> originalDetails = new ArrayList<>();
	    for (WebElement element : detailsElements) {
	        String detail = element.getText().trim();
	        if (!detail.isEmpty()) { // Skip empty details
	            originalDetails.add(detail);
	        }
	        System.out.println(detail);
	    }

	    // Step 2: Sort and print the sorted list (A-Z)
	    List<String> javaSortedDetailsAZ = new ArrayList<>(originalDetails);
	    Collections.sort(javaSortedDetailsAZ);
	    System.out.println("\nJava sorted list of details (A-Z):");
	    for (String detail : javaSortedDetailsAZ) {
	        System.out.println(detail);
	    }

	    // Step 3: Select "Details (A-Z)" from dropdown
	    select.selectByVisibleText("Details (A-Z)");
	    Thread.sleep(8000); // Wait for page update

	    // Step 4: Get and print the resulting list from the page
	    List<WebElement> resultDetailsElementsAZ = lvmgs.getListOfALLShowSpecialsDetails();
	    System.out.println("\nList after selecting Details (A-Z):");
	    List<String> webSortedDetailsAZ = new ArrayList<>();
	    for (WebElement element : resultDetailsElementsAZ) {
	        String detail = element.getText().trim();
	        if (!detail.isEmpty()) { // Skip empty details
	            webSortedDetailsAZ.add(detail);
	        }
	        System.out.println(detail);
	    }

	    // Step 5: Compare the two lists (A-Z)
	    boolean areDetailsEqualAZ = javaSortedDetailsAZ.equals(webSortedDetailsAZ);
	    System.out.println("\nAre the A-Z details lists equal? " + areDetailsEqualAZ);
	    Assert.assertTrue(areDetailsEqualAZ, "A-Z sorted details lists do not match!");

	    // Step 6: Sort and print the sorted list (Z-A)
	    List<String> javaSortedDetailsZA = new ArrayList<>(originalDetails);
	    Collections.sort(javaSortedDetailsZA, Collections.reverseOrder());
	    System.out.println("\nJava sorted list of details (Z-A):");
	    for (String detail : javaSortedDetailsZA) {
	        System.out.println(detail);
	    }

	    // Step 7: Select "Details (Z-A)" from dropdown
	    select.selectByVisibleText("Details (Z-A)");
	    Thread.sleep(5000); // Wait for page update

	    // Step 8: Get and print the resulting list from the page
	    List<WebElement> resultDetailsElementsZA = lvmgs.getListOfALLShowSpecialsDetails();
	    System.out.println("\nList after selecting Details (Z-A):");
	    List<String> webSortedDetailsZA = new ArrayList<>();
	    for (WebElement element : resultDetailsElementsZA) {
	        String detail = element.getText().trim();
	        if (!detail.isEmpty()) { // Skip empty details
	            webSortedDetailsZA.add(detail);
	        }
	        System.out.println(detail);
	    }

	    // Step 9: Compare the two lists (Z-A)
	    boolean areDetailsEqualZA = javaSortedDetailsZA.equals(webSortedDetailsZA);
	    System.out.println("\nAre the Z-A details lists equal? " + areDetailsEqualZA);
	    Assert.assertTrue(areDetailsEqualZA, "Z-A sorted details lists do not match!");
	}
	
	@Test(priority = 5)
	public void TS05_VerifyShowSpecialSortByTest() throws InterruptedException, IOException {
	    // The purpose of this test case to verify:-
	    // : Show Specials: Links - SortBy

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

	    // Click on Exhibitors And Product Tab
	    // Click on Discover tab
	    Actions ac = new Actions(driver);
	    ac.moveToElement(lvmgs.getLvmDiscoverTab()).click().perform();

	    // Click on Show Specials
	    lvmgs.getlvmShowSpecialsLink().click();
	    Thread.sleep(5000);
	    // Scroll to mid page
	    utl.scrollElementIntoMiddle(lvmgs.getFirstShowSpecialName());

	    Select select = new Select(lvmgs.getshowSpecialsSortByDropdown());
	    
	    // Store all the showSpecials
	    // Get the list of show specials web elements
	    List<WebElement> showSpecialsName = lvmgs.getlistOfAllshowSpecials();

	    // Extract text before "showBy" and print original list
	    List<String> originalList = new ArrayList<>();
	    for (WebElement element : showSpecialsName) {
	        String text = element.getText().trim();
	        // Extract text before "showBy"
	        String name = text.contains("showBy") ? text.split("showBy")[0].trim() : text;
	        if (!name.isEmpty()) { // Skip empty names
	            originalList.add(name);
	        }
	    }
	    System.out.println("Original list (names before showBy): " + originalList);

	    // --- Ascending Order (A-Z) Verification ---
	    // Create a copy for sorting in Java (A-Z)
	    List<String> javaSortedListAZ = new ArrayList<>(originalList);
	    // Sort the list in Java (A-Z, case-sensitive)
	    Collections.sort(javaSortedListAZ);
	    System.out.println("Java sorted list (A-Z): " + javaSortedListAZ);

	    // Interact with the dropdown to sort on the webpage (A-Z)
	   
	    select.selectByVisibleText("Exhibitor Name (A-Z)");
	    Thread.sleep(5000); // Wait for page update

	    // Re-fetch the list of show specials after sorting on the webpage
	    List<WebElement> sortedShowSpecialsAZ = lvmgs.getlistOfAllshowSpecials();

	    // Extract text before "showBy" from updated web elements
	    List<String> webSortedListAZ = new ArrayList<>();
	    for (WebElement element : sortedShowSpecialsAZ) {
	        String text = element.getText().trim();
	        String name = text.contains("showBy") ? text.split("showBy")[0].trim() : text;
	        if (!name.isEmpty()) {
	            webSortedListAZ.add(name);
	        }
	    }
	    System.out.println("Web sorted list (A-Z): " + webSortedListAZ);

	    // Compare the two lists (A-Z)
	    boolean areListsEqualAZ = javaSortedListAZ.equals(webSortedListAZ);
	    System.out.println("Are the A-Z lists equal? " + areListsEqualAZ);
	    Assert.assertTrue(areListsEqualAZ, "A-Z sorted lists do not match!");

	    // --- Descending Order (Z-A) Verification ---
	    // Create a copy for sorting in Java (Z-A)
	    List<String> javaSortedListZA = new ArrayList<>(originalList);
	    // Sort the list in Java (Z-A, case-sensitive)
	    Collections.sort(javaSortedListZA, Collections.reverseOrder());
	    System.out.println("Java sorted list (Z-A): " + javaSortedListZA);

	    // Interact with the dropdown to sort on the webpage (Z-A)
	    select.selectByVisibleText("Exhibitor Name (Z-A)");
	    Thread.sleep(5000); // Wait for page update

	    // Re-fetch the list of show specials after sorting on the webpage
	    List<WebElement> sortedShowSpecialsZA = lvmgs.getlistOfAllshowSpecials();

	    // Extract text before "showBy" from updated web elements
	    List<String> webSortedListZA = new ArrayList<>();
	    for (WebElement element : sortedShowSpecialsZA) {
	        String text = element.getText().trim();
	        String name = text.contains("showBy") ? text.split("showBy")[0].trim() : text;
	        if (!name.isEmpty()) {
	            webSortedListZA.add(name);
	        }
	    }
	    System.out.println("Web sorted list (Z-A): " + webSortedListZA);

	    // Compare the two lists (Z-A)
	    boolean areListsEqualZA = javaSortedListZA.equals(webSortedListZA);
	    System.out.println("Are the Z-A lists equal? " + areListsEqualZA);
	    Assert.assertTrue(areListsEqualZA, "Z-A sorted lists do not match!");

	    //***************location
	    List<WebElement> locationElements = lvmgs.getListOfALlshowSpecialsLocations();

	    // Step 1: Print original list
	    System.out.println("Original list of locations:");
	    List<String> originalLocations = new ArrayList<>();
	    for (WebElement element : locationElements) {
	        String location = element.getText();
	        originalLocations.add(location);
	        System.out.println(location);
	    }

	    // Step 2: Sort and print the sorted list
	    List<String> sortedLocations = new ArrayList<>(originalLocations);
	    Collections.sort(sortedLocations);
	    System.out.println("\nSorted list (A-Z):");
	    for (String location : sortedLocations) {
	        System.out.println(location);
	    }

	    // Step 3: Select "Location (A-Z)" from dropdown
	    select.selectByVisibleText("Location (A-Z)");
	    Thread.sleep(5000); // Wait for page update

	    // Step 4: Get and print the resulting list from the page
	    List<WebElement> resultElements = lvmgs.getListOfALlshowSpecialsLocations();
	    System.out.println("\nList after selecting Location (A-Z):");
	    List<String> resultLocations = new ArrayList<>();
	    for (WebElement element : resultElements) {
	        String location = element.getText();
	        resultLocations.add(location);
	        System.out.println(location);
	    }

	    Assert.assertTrue(sortedLocations.equals(resultLocations), "A-Z sorted location lists do not match!");

	    //********************Descending order (Z-A) for Locations
	    // Step 5: Create a copy for sorting in Java (Z-A)
	    List<String> javaSortedLocationsZA = new ArrayList<>(originalLocations);
	    // Sort the list in Java (Z-A, case-sensitive)
	    Collections.sort(javaSortedLocationsZA, Collections.reverseOrder());
	    System.out.println("\nJava sorted list of locations (Z-A):");
	    for (String location : javaSortedLocationsZA) {
	        System.out.println(location);
	    }

	    // Step 6: Select "Location (Z-A)" from dropdown
	    select.selectByVisibleText("Location (Z-A)");
	    Thread.sleep(5000); // Wait for page update

	    // Step 7: Get and print the resulting list from the page
	    List<WebElement> resultElementsZA = lvmgs.getListOfALlshowSpecialsLocations();
	    System.out.println("\nList after selecting Location (Z-A):");
	    List<String> webSortedLocationsZA = new ArrayList<>();
	    for (WebElement element : resultElementsZA) {
	        String location = element.getText().trim();
	        if (!location.isEmpty()) { // Skip empty locations
	            webSortedLocationsZA.add(location);
	        }
	        System.out.println(location);
	    }

	    // Step 8: Compare the two lists (Z-A)
	    boolean expected = javaSortedLocationsZA.equals(webSortedLocationsZA);
	    System.out.println("\nAre the Z-A location lists equal? " + expected);
	    Assert.assertTrue(expected, "Z-A sorted location lists do not match!");

	    
	}
	
	@Test(priority = 6)
	public void TS06_VerifyShowSpecialResetButtonTest() throws InterruptedException, IOException {
	    // The purpose of this test case to verify:-
	    // : Show Specials: Links - SortBy

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

	    // Click on Exhibitors And Product Tab
	    // Click on Discover tab
	    Actions ac = new Actions(driver);
	    ac.moveToElement(lvmgs.getLvmDiscoverTab()).click().perform();

	    // Click on Show Specials
	    lvmgs.getlvmShowSpecialsLink().click();
	    Thread.sleep(5000);
	    // Scroll to mid page
	    utl.scrollElementIntoMiddle(lvmgs.getFirstShowSpecialName());

	    Select select = new Select(lvmgs.getshowSpecialsSortByDropdown());
	    
	    // Store all the showSpecials
	    // Get the list of show specials web elements
	    List<WebElement> showSpecialsName = lvmgs.getlistOfAllshowSpecials();

	    // Extract text before "showBy" and print original list
	    List<String> originalList = new ArrayList<>();
	    for (WebElement element : showSpecialsName) {
	        String text = element.getText().trim();
	        // Extract text before "showBy"
	        String name = text.contains("showBy") ? text.split("showBy")[0].trim() : text;
	        if (!name.isEmpty()) { // Skip empty names
	            originalList.add(name);
	        }
	    }
	    System.out.println("Original list : " + originalList);
	    
	    
	    select.selectByVisibleText("Exhibitor Name (A-Z)");
	    Thread.sleep(5000); // Wait for page update
	    
	    
	    lvmgs.getShowSpecialsPageResetButton().click();
	    Thread.sleep(3000);
	    
	    //**********************
	    
	    List<WebElement> showSpecialsNameAfterReset = lvmgs.getlistOfAllshowSpecials();

	    // Extract text before "showBy" and print original list
	    List<String> originalListAfterReset = new ArrayList<>();
	    for (WebElement element : showSpecialsNameAfterReset) {
	        String text = element.getText().trim();
	        // Extract text before "showBy"
	        String name = text.contains("showBy") ? text.split("showBy")[0].trim() : text;
	        if (!name.isEmpty()) { // Skip empty names
	        	originalListAfterReset.add(name);
	        }
	    }
	    System.out.println("Original After Reset list : " + originalListAfterReset);
	    
	    boolean expected = originalList.equals(originalListAfterReset);
	    System.out.println("\nAre the Z-A location lists equal? " + expected);
	    Assert.assertTrue(expected, "Z-A sorted location lists do not match!");
	    
	    
	    
	}
	    
	@AfterClass
	public void tearDown() {
		//driver.quit();
	}

}
