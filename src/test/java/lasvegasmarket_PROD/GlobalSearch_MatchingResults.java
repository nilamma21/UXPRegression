package lasvegasmarket_PROD;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
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

public class GlobalSearch_MatchingResults extends base {
	
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
		try {
			lap.getIUnderstandBtn().click();
			}catch (Exception e) {
				// TODO: handle exception
			}
		Thread.sleep(5000);
		utl.CloseATLPopup();
		Thread.sleep(2000);
/*		utl.verifyMPLoginFunctionality();
		Thread.sleep(5000);
		utl.loginCheckLVM();*/
		//lap.getCloseMarktAdBtn().click();
	}
	
	  @Test(priority = 1)
	  public void TS001_VerifyGlobalSearchContainsAndStartsWithTest() throws InterruptedException, IOException {
		    // Test Purpose: Verify Global Search functionality for "Contains" and "StartsWith" behavior.
		    // Test Case ID: T814
		    // Blocked: Unclear about the acceptance criteria

		    // Initialize page objects
		    lvmgs = new LVMGlobalSearchPage(driver);
		    lvmds = new LVMExhDigiShowroomPage(driver);
		    lvmexhact = new LVMExhLineProdActionsPage(driver);

		    // Set implicit wait
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		    // Perform global search
		    lvmgs.getGlobalSearchTextBoxNew().click(); // Click on the global search text box
		    lvmgs.getGlobalSearchEnterText().sendKeys("tri"); // Enter search keyword "tri"
		    lvmgs.getSearchButtonNew().click(); // Click the search button

		    // Wait for search results to load (explicit wait is better than Thread.sleep)
			/*
			 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			 * wait.until(ExpectedConditions.visibilityOfAllElements(lvmgs.
			 * getlvmListOfExhibitors()));
			 */

		    // Fetch the list of exhibitors
		    List<WebElement> exhibitors = lvmgs.getlvmListOfExhibitors();

		    // Check if the list is not empty
		    if (exhibitors.isEmpty()) {
		        Assert.fail("No exhibitors found in the search results.");
		    }

		    // Join all exhibitor titles into a single string
		    StringBuilder joinedText = new StringBuilder();
		    for (WebElement exhibitor : exhibitors) {
		        String title = exhibitor.getText().trim().toLowerCase();
		        joinedText.append(title); // Append each title to the joinedText
		    }

		    // Convert the joined text to a single string
		    String concatenatedString = joinedText.toString();
		    System.out.println("Concatenated String: " + concatenatedString);

		    // Check if the concatenated string contains "tri"
		    if (concatenatedString.contains("tri")) {
		        System.out.println("✅ Test Passed: The substring 'tri' was found in the concatenated string.");
		    } else {
		        System.out.println("❌ Test Failed: The substring 'tri' was NOT found in the concatenated string.");
		    }

		    // Assert that the concatenated string contains "tri"
		    Assert.assertTrue(concatenatedString.contains("tri"), "The substring 'tri' was NOT found in the concatenated string.");
		}
	  
	  @Test(priority = 2)
	  public void TS002_VerifyGlobalSearchMatchingResultsSortWithinTest() throws InterruptedException, IOException {
	      // The purpose of this test case to verify:-
	      // T673: Global Search: Matching results- Sort- Search Within

	      lvmgs = new LVMGlobalSearchPage(driver);
	      lvmds = new LVMExhDigiShowroomPage(driver);
	      lvmexhact = new LVMExhLineProdActionsPage(driver);

	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	      
	  	

	      utl.globleSearchInput((prop.getProperty("globalsearch_input")));
		// Click on Sort Btn
	    
	      lvmgs.getLvmSortButton().click();
	     
	      
	      // Select Exhibitor Info Only
	      Select selectAMC = new Select(lvmgs.getlvmGlobalSearch_SearchWithinDropdwn());
	      selectAMC.selectByVisibleText("Exhibitor Info Only");
	      Thread.sleep(8000);
	      
	      // Verify All Exhibitor Titles
	      for (WebElement allExhDisply : lvmgs.getlvmListOfAllExh()) {
	          Assert.assertTrue(allExhDisply.isDisplayed());
	      }
	      System.out.println("Displayed All Exhibitors Title");

			

	      // Verify All Exhibitors Location Links
	      for (WebElement allExhLocationLinksDisplay : lvmgs.getLvmSortButtonListOfLocation()) {
	          Assert.assertTrue(allExhLocationLinksDisplay.isDisplayed());
	      }
	      System.out.println("Displayed All Exhibitors Location Links");
	      
	      

	      // Select Exhibitor and Product Info
	      selectAMC.selectByVisibleText("Exhibitor and Product Info");
	      Thread.sleep(8000);
	      
	      // Verify All Exhibitor Titles
	      for (WebElement allExhDisply : lvmgs.getlistOfAllExhibitorsAndProducts()) {
	          Assert.assertTrue(allExhDisply.isDisplayed());
	      }
	      System.out.println("Displayed All Exhibitors Title");


	      // Verify All Exhibitors Location Links
	      for (WebElement allExhLocationLinksDisplay : lvmgs.getLvmSortButtonListOfLocation()) {
	          Assert.assertTrue(allExhLocationLinksDisplay.isDisplayed());
	      }
	      System.out.println("Displayed All Exhibitors Location Links");
	      
	      // Verify All Exhibitors Location Links
	      for (WebElement allProductDisplay : lvmgs.getLvmSortButtonListOfLocation()) {
	          Assert.assertTrue(allProductDisplay.isDisplayed());
	      }
	      System.out.println("Displayed All Products");

	      // Select Product Info Only
	      selectAMC.selectByVisibleText("Product Info Only");
	      Thread.sleep(8000);
	      
	      // Verify All Exhibitor Titles
	      for (WebElement allExhDisply : lvmgs.getlvmListOfAllExh()) {
	          Assert.assertTrue(allExhDisply.isDisplayed());
	      }
	      System.out.println("Displayed All Exhibitors Title");

			
	      // Verify All Exhibitors Location Links
	      for (WebElement allExhLocationLinksDisplay : lvmgs.getLvmSortButtonListOfLocation()) {
	          Assert.assertTrue(allExhLocationLinksDisplay.isDisplayed());
	      }
	      System.out.println("Displayed All Exhibitors Location Links");
	      
	      // Verify All Exhibitors Location Links
	      for (WebElement allProductDisplay : lvmgs.getLvmSortButtonListOfProducts()) {
	          Assert.assertTrue(allProductDisplay.isDisplayed());
	      }
	      System.out.println("Displayed All Products");
	      driver.get(prop.getProperty("lvmurl_prod"));
	  }
	  
	  @Test(priority = 3)
	  public void TS003_VerifyGlobalSearchMatchingResultsSortSortByAscendingOrderTest() throws InterruptedException, IOException {
		    // The purpose of this test case is to verify:
		    // T676: Global Search: Matching results - Sort By
		    // Open bug - UXP-1991

		    lvmgs = new LVMGlobalSearchPage(driver);
		    lvmds = new LVMExhDigiShowroomPage(driver);
		    lvmexhact = new LVMExhLineProdActionsPage(driver);
		    utl = new Utility(driver);

		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		    utl.globleSearchInput((prop.getProperty("globalsearch_input")));
		    // Click on Sort Btn
		    lvmgs.getLvmSortButton().click();

		    // Select Exhibitor Sort By Relevance
		    Select selectAMC = new Select(lvmgs.getlvmGlobalSearch_SearchSortByDropdwn());
		    selectAMC.selectByVisibleText("Sort By Relevance");
		    Thread.sleep(8000);

		    // Verify All Exhibitor Titles
		    System.out.println("Displayed All Relevance ");
		    Thread.sleep(7000);

		    // Select "Sort by Name Ascending"
		    selectAMC.selectByVisibleText("Sort by Name Ascending");

		    // Wait for the sorted list to load
		    Thread.sleep(10000); // Consider using WebDriverWait instead for stability

		    // Fetch the updated exhibitor list
		    List<WebElement> exhibitorElements = lvmgs.getlistOfAllExhibitorTitles();

		    List<String> actualList = new ArrayList<>();
		    for (WebElement el : exhibitorElements) {
		        actualList.add(el.getText().trim());
		    }

		    // Create a sorted copy of the actual list
		    List<String> sortedList = new ArrayList<>(actualList);
		    Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);

		    // Print actual list
		    System.out.println("Fetched Exhibitor List:");
		    actualList.forEach(System.out::println);

		    // Verify sorting
		    boolean isSorted = true;
		    for (int i = 0; i < actualList.size(); i++) {
		        if (!actualList.get(i).equalsIgnoreCase(sortedList.get(i))) {
		            System.out.println("\n❌ Sorting failed at index " + i);
		            System.out.println("Expected: " + sortedList.get(i));
		            System.out.println("Actual: " + actualList.get(i));
		            isSorted = false;
		            break;
		        }
		    }

		    // Final Result
		    if (isSorted) {
		        System.out.println("\n✅ Exhibitors are correctly sorted in ascending order.");
		    } else {
		        System.out.println("\n❌ Exhibitors are NOT sorted in ascending order. Test case failed.");
		        Assert.fail("Exhibitors are NOT sorted in ascending order."); // Assert fail if not sorted
		    }
		    driver.get(prop.getProperty("lvmurl_prod"));
		}
	  @Test(priority = 4)
	  public void TS003_VerifyGlobalSearchMatchingResultsSortSortByDscendingOrderTest() throws InterruptedException, IOException {
		    // The purpose of this test case to verify:
		    // T676: Global Search: Matching results - Sort By
		    // Open bug - UXP-1991

		    lvmgs = new LVMGlobalSearchPage(driver);
		    lvmds = new LVMExhDigiShowroomPage(driver);
		    lvmexhact = new LVMExhLineProdActionsPage(driver);
		    utl = new Utility(driver);

		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		    utl.globleSearchInput((prop.getProperty("globalsearch_input")));
		    // Click on Sort Btn
		    lvmgs.getLvmSortButton().click();

		    // Select Exhibitor Sort By Relevance
		    Select selectAMC = new Select(lvmgs.getlvmGlobalSearch_SearchSortByDropdwn());
		    selectAMC.selectByVisibleText("Sort By Relevance");
		    Thread.sleep(8000);

		    // Verify All Exhibitor Titles
		    System.out.println("Displayed All Relevance ");
		    Thread.sleep(7000);

		    // Select "Sort by Name Descending"
		    selectAMC.selectByVisibleText("Sort by Name Descending");

		    // Wait for the sorted list to load
		    Thread.sleep(10000); // Prefer WebDriverWait for better practice

		    // Fetch the updated exhibitor list
		    List<WebElement> exhibitorElements = lvmgs.getlistOfAllExhibitorTitles();

		    List<String> actualList = new ArrayList<>();
		    for (WebElement el : exhibitorElements) {
		        actualList.add(el.getText().trim());
		    }

		    // Create a sorted copy of the list and reverse it for descending order
		    List<String> sortedList = new ArrayList<>(actualList);
		    sortedList.sort(String.CASE_INSENSITIVE_ORDER);
		    Collections.reverse(sortedList); // For descending

		    // Print actual list
		    System.out.println("Fetched Exhibitor List:");
		    actualList.forEach(System.out::println);

		    // Verify descending sort
		    boolean isSorted = true;
		    for (int i = 0; i < actualList.size(); i++) {
		        if (!actualList.get(i).equalsIgnoreCase(sortedList.get(i))) {
		            System.out.println("\n❌ Sorting failed at index " + i);
		            System.out.println("Expected: " + sortedList.get(i));
		            System.out.println("Actual: " + actualList.get(i));
		            isSorted = false;
		            break;
		        }
		    }

		    // Final Result
		    if (isSorted) {
		        System.out.println("\n✅ Exhibitors are correctly sorted in descending order.");
		    } else {
		        System.out.println("\n❌ Exhibitors are NOT sorted in descending order. Test case failed.");
		        Assert.fail("Exhibitors are NOT sorted in descending order."); // Assert fail if not sorted
		    }
		    driver.get(prop.getProperty("lvmurl_prod"));
		}
	  
	  @Test(priority = 4)
	  public void TS003_VerifyGlobalSearchMatchingResultsSortSortByMatchingProductCountDescendingTest() throws InterruptedException, IOException {
		    // The purpose of this test case is to verify:
		    // T676: Global Search: Matching results - Sort by Matching Product Count Descending

		    lvmgs = new LVMGlobalSearchPage(driver);
		    lvmds = new LVMExhDigiShowroomPage(driver);
		    lvmexhact = new LVMExhLineProdActionsPage(driver);
		    utl = new Utility(driver);

		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		    // Step 1: Perform global search
		    utl.globleSearchInput((prop.getProperty("globalsearch_input")));

		    // Step 2: Click Sort Button
		    lvmgs.getLvmSortButton().click();

		    // Step 3: Select "Sort By Matching Product Count Descending"
		    Select selectAMC = new Select(lvmgs.getlvmGlobalSearch_SearchSortByDropdwn());
		    selectAMC.selectByVisibleText("Sort By Matching Product Count Descending");

		    // Step 4: Wait for sorted list to load
		    Thread.sleep(10000);

		    // Step 5: Get updated exhibitor product count elements
		    List<WebElement> exhibitorElements = lvmgs.getlistOfAllMatchingProducts();

		    List<Integer> actualList = new ArrayList<>();
		    for (WebElement el : exhibitorElements) {
		        try {
		            // Extract the number from string (e.g., "23 Products" -> 23)
		            String text = el.getText().trim().replaceAll("[^0-9]", "");
		            if (!text.isEmpty()) {
		                actualList.add(Integer.parseInt(text));
		            }
		        } catch (NumberFormatException e) {
		            System.out.println("Skipping invalid number format: " + el.getText());
		        }
		    }

		    // Step 6: Create a sorted (descending) copy
		    List<Integer> sortedList = new ArrayList<>(actualList);
		    sortedList.sort(Collections.reverseOrder());

		    // Print actual list
		    System.out.println("Fetched Matching Product Counts:");
		    actualList.forEach(System.out::println);

		    // Step 7: Assert that actual list is sorted in descending order
		    Assert.assertEquals(actualList, sortedList, 
		        "\n❌ Matching Product Counts are NOT sorted in descending order. Test case failed.\n");

		    System.out.println("\n✅ Matching Product Counts are correctly sorted in descending order.");
		    driver.get(prop.getProperty("lvmurl_prod"));
		}

	  @Test(priority = 5)
	  public void TS003_VerifyGlobalSearchMatchingResultsSortSortByMatchingProductCountAscendingTest() throws InterruptedException, IOException {
		    // The purpose of this test case is to verify:
		    // T676: Global Search: Matching results - Sort by Matching Product Count Ascending

		    lvmgs = new LVMGlobalSearchPage(driver);
		    lvmds = new LVMExhDigiShowroomPage(driver);
		    lvmexhact = new LVMExhLineProdActionsPage(driver);
		    utl = new Utility(driver);

		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		    // Step 1: Perform a global search
		    utl.globleSearchInput((prop.getProperty("globalsearch_input")));

		    // Step 2: Click Sort Button
		    lvmgs.getLvmSortButton().click();

		    // Step 3: Select Sort By Relevance (optional, can be skipped)
		    Select selectAMC = new Select(lvmgs.getlvmGlobalSearch_SearchSortByDropdwn());
		    selectAMC.selectByVisibleText("Sort By Relevance");
		    Thread.sleep(8000);

		    System.out.println("Displayed All Relevance ");
		    Thread.sleep(7000);

		    // Step 4: Select "Sort By Matching Product Count Ascending"
		    selectAMC.selectByVisibleText("Sort By Matching Product Count Ascending");

		    // Step 5: Wait for the sorted results to load
		    Thread.sleep(10000);

		    // Step 6: Fetch the updated list of matching product counts
		    List<WebElement> exhibitorElements = lvmgs.getlistOfAllMatchingProducts();

		    List<Integer> actualList = new ArrayList<>();
		    for (WebElement el : exhibitorElements) {
		        try {
		            // Extract number from string (e.g., "12 Products" -> 12)
		            String text = el.getText().trim().replaceAll("[^0-9]", "");
		            if (!text.isEmpty()) {
		                actualList.add(Integer.parseInt(text));
		            }
		        } catch (NumberFormatException e) {
		            System.out.println("Skipping invalid number format: " + el.getText());
		        }
		    }

		    // Step 7: Sort the list for comparison
		    List<Integer> sortedList = new ArrayList<>(actualList);
		    Collections.sort(sortedList); // Ascending

		    // Print actual list
		    System.out.println("Fetched Matching Product Counts:");
		    actualList.forEach(System.out::println);

		    // Step 8: Compare
		    boolean isSorted = true;
		    for (int i = 0; i < actualList.size(); i++) {
		        if (!actualList.get(i).equals(sortedList.get(i))) {
		            System.out.println("\n❌ Sorting failed at index " + i);
		            System.out.println("Expected: " + sortedList.get(i));
		            System.out.println("Actual: " + actualList.get(i));
		            isSorted = false;
		            break;
		        }
		    }

		    // Step 9: Final Result
		    if (isSorted) {
		        System.out.println("\n✅ Matching Product Counts are correctly sorted in ascending order.");
		    } else {
		        System.out.println("\n❌ Matching Product Counts are NOT sorted in ascending order. Test case failed.");
		        Assert.fail("Matching Product Counts are NOT sorted in ascending order."); // Assert fail if not sorted
		    }
		    driver.get(prop.getProperty("lvmurl_prod"));
		}

	  
	  @Test(priority = 6)
	  public void TS004_VerifyGlobalSearchMatchingResultsSortFilterByNameTest() throws InterruptedException, IOException {
	      // The purpose of this test case to verify:-
	      // T677: Global Search: Matching results- Sort- Filter By Name

	      lvmgs = new LVMGlobalSearchPage(driver);
	      lvmds = new LVMExhDigiShowroomPage(driver);
	      lvmexhact = new LVMExhLineProdActionsPage(driver);
	      utl = new Utility(driver);

	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	      utl.globleSearchInput((prop.getProperty("globalsearch_input")));
			Thread.sleep(10000);
			// Click on Sort Btn
		    
		      lvmgs.getLvmSortButton().click();
	      // Select Character from Sort By Filter Name
	      Select selectLetter = new Select(lvmgs.getlvmFilterByNameDropDown());
	      selectLetter.selectByVisibleText("Y");
	      Thread.sleep(10000);
	      
	      try {
	      for (WebElement filterExhNames : lvmgs.getlvmExhiNameForFilterByNameNew()) {
	          //Assert.assertTrue(filterExhNames.isDisplayed());
	          
	          String expName=filterExhNames.getText();
	          System.out.println(expName);
	          boolean flag=false;
	          char fChar=expName.charAt(0);
	          String s=""+fChar;
	          System.out.println(s);
	          Assert.assertTrue(s.contains("Y"));
	      }
	      }catch (Exception e) {
	    	  for (WebElement filterExhNames : lvmgs.getlvmExhiNameForFilterByNameNewUAT()) {
	    		  
	              String expName=filterExhNames.getText();
	              System.out.println(expName);
	              boolean flag=false;
	              char fChar=expName.charAt(0);
	              String s=""+fChar;
	              System.out.println(s);
	              Assert.assertTrue(s.contains("Y"));
			}
		}
	      System.out.println("Displayed All Relevance ");
	      driver.get(prop.getProperty("lvmurl_prod"));
	  }
	
	@Test(enabled=false)//priority = 5
	public void TS005_VerifyGlobalSearchMatchingResultsSelectAddToFavoritesTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T330: Global Search: Matching results- Select- Add to Favorites

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lap = new LVMLandingPage(driver);
		lp = new LVMLoginPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		if(!lvmgs.getLVMGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			lvmgs.getlvmGlobalSearchClearTxt().click();
		}
		//utl.verifyMPLoginFunctionality();
		utl.CloseATLPopup();
		lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("exhibitor5"));//filtersglobalsearchinput
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(5000);
		// Click on Select Btn
		lvmgs.getlvmGlobalSearchSelectBtn().click();
		// Select 1st checkbox from searched result
		lvmgs.getlvmGlobalSearchExhCheckbox().click();
		String exhName = lvmgs.getlvm1STExhiName().getText();
		System.out.println(exhName);
		// Click on Add to fav Btn
		lvmgs.getlvmGlobalSearchAddToFavBtn().click();

		/*// Sign In to MP
		// Enter the credentials on Login Page and click
		lp.getEmailAddress().sendKeys((prop.getProperty("username")));
		lp.getPassword().sendKeys((prop.getProperty("password")));

		lp.getSignInBtn().click();
		Thread.sleep(15000);*/
		// Click on Market Planner
		lap.getMPLinkText().click();
		Thread.sleep(6000);

		// Click on List tab
		lvmmpp.getMPHomeListsTab().click();
		Thread.sleep(10000);
		// Verify Exhibitor present or not into MP Fav
		utl.checkItemPresentInListorNot(lvmmpp.getlistOfAllExh(), exhName);
		driver.get(prop.getProperty("lvmurl_prod"));
	}
	
	@Test(enabled=false)//priority = 6
	public void TS006_VerifyGlobalSearchMatchingResultsSelectAddToExistingListTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T331: Global Search: Matching results- Select- Add to Existing List

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lap = new LVMLandingPage(driver);
		lp = new LVMLoginPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//utl.verifyMPLoginFunctionality();
		utl.CloseATLPopup();
		//lvmgs.getlvmGlobalSearchClearTxt().click();
		if(!lvmgs.getLVMGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			lvmgs.getlvmGlobalSearchClearTxt().click();
		}
		lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));//filtersglobalsearchinput
		Thread.sleep(5000);
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(5000);
		// Click on Select Btn
		lvmgs.getlvmGlobalSearchSelectBtn().click();
		// Select 1st checkbox from searched result
		lvmgs.getlvmGlobalSearchExhCheckbox().click();
		String exhName = lvmgs.getlvm1STExhiName().getText();
		System.out.println(exhName);
		// Click on Add to Selected List Btn
		lvmgs.getlvmAddToExistingList().click();
		// Select Exiting List
		String exList = lvmgs.getlvmExistingList().getText();
		System.out.println(exList);
		lvmgs.getlvmExistingList().click();
		// Click Add to List Btn
		lvmgs.getlvmAddToSelectBtn().click();
		// CLick on Go To MP Btn
		lvmgs.getlvmGoToMPBtn().click();

		// Click on Market Planner
		lap.getMPLinkText().click();
		Thread.sleep(6000);

		// Click on List tab
		lvmmpp.getMPHomeListsTab().click();
		Thread.sleep(10000);
		// Click on List from left Panel
		lvmmpp.getMpListLeftPannel().click();
		// Open selected list
		utl.ClickOnEditBtnOfAnyList(lvmmpp.getallList(), exList);
		// Verify exhibitor present into selected list or not
		utl.checkItemPresentInListorNot(lvmmpp.getlistOfAllExh(), exhName);
		driver.get(prop.getProperty("lvmurl_prod"));
	}
	
	@Test(enabled=false)//priority = 7
	public void TS007_VerifyGlobalSearchMatchingResultsSelectAddToNewlyCreatedListTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T424: Global Search: Matching results- Select- Add to newly created list

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lap = new LVMLandingPage(driver);
		lp = new LVMLoginPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//utl.verifyMPLoginFunctionality();
		utl.CloseATLPopup();
		if(!lvmgs.getLVMGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			lvmgs.getlvmGlobalSearchClearTxt().click();
		}
		Thread.sleep(5000);
		lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("exhibitor5"));//filtersglobalsearchinput
		Thread.sleep(5000);
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(5000);
		String exhName = lvmgs.getlvm1STExhiName().getText();
		System.out.println(exhName);
		// Click on Select Btn
		lvmgs.getlvmGlobalSearchSelectBtn().click();
		// Select 1st checkbox from searched result
		lvmgs.getlvmGlobalSearchExhCheckbox().click();
		
		// Click on Add to Selected List Btn
		lvmgs.getlvmAddToExistingList().click();
		String lName = genData.generateRandomString(10);
		lvmmpp.getCreateNewListNameTxtbx().sendKeys(lName);
		// lvmmppge.getCreateNewListNameTxtbx().sendKeys();
		lvmmpp.getCreateAndAddListBtn().click();
		Thread.sleep(2000);
		// CLick on Go To MP Btn
		lvmgs.getlvmGoToMPBtn().click();

		// Click on Market Planner
		lap.getMPLinkText().click();
		Thread.sleep(6000);

		// Click on List tab
		lvmmpp.getMPHomeListsTab().click();
		Thread.sleep(10000);
		// Click on List from left Panel
		lvmmpp.getMpListLeftPannel().click();
		// Open selected list
		utl.ClickOnEditBtnOfAnyList(lvmmpp.getallList(), lName);
		// Verify exhibitor present into selected list or not
		Thread.sleep(7000);
		utl.checkItemPresentInListorNot(lvmmpp.getlistOfAllExh(), exhName);
		driver.get(prop.getProperty("lvmurl_prod"));
	}
	
	@Test(enabled=false)
	public void TS008_VerifyGlobalSearchMatchingResultsUsePreviousSavedSearchTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T329: Global Search: Matching results- Use previous saved Search

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		if(!lvmgs.getLVMGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			lvmgs.getlvmGlobalSearchClearTxt().click();
		}
		//utl.verifyMPLoginFunctionality();
		utl.CloseATLPopup();
	
		try {
			lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("savedSearchesInput"));
			Thread.sleep(3000);
			lvmgs.getLVMSearchButton().click();
			Thread.sleep(5000);
			// Click on Save Searches Btn
			lvmgs.getlvmSavedSearchesIcon().click();
			Select selectSavedSearched = new Select(lvmgs.getlvmSavedSearchesDropdown());
			selectSavedSearched.selectByIndex(1);
			String optin = selectSavedSearched.getOptions().get(1).getText();
			System.out.println(optin);
		//	Assert.assertTrue(lvmgs.getLVMInfosearchtxtbx().getAttribute("value").contains(optin));
			Thread.sleep(5000);
			Assert.assertTrue(lvmgs.getLVMVerifyGlobalSeacrh().getText().contains(optin));
			
		} catch (Exception e) {
			
			if(!lvmgs.getLVMGlobalSearchTextBox().getAttribute("value").isEmpty()) {
				lvmgs.getlvmGlobalSearchClearTxt().click();
			}
			lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("savedSearchesInput"));
			Thread.sleep(3000);
			lvmgs.getLVMSearchButton().click();
			Thread.sleep(5000);
			// Click on Save Searches Btn
			lvmgs.getlvmSavedSearchesIcon().click();
			//Click on Save Seach btn
			lvmgs.getlvmSavedSearchesBtn().click();
			
			String savedSearchesInput=prop.getProperty("savedSearchesInput");
			//Enter Search name into input box
			lvmgs.getlvmSavedSearchesInputBox().sendKeys(savedSearchesInput);
			//Click on Save Search Btn 
			lvmgs.getlvmSavedSearchesBtnForNewSaved().click();
			//Goto Home page
			driver.get(prop.getProperty("atlmrkturl_prod"));
			//Click on saved Searches btn
			lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("filtersglobalsearchinput"));
			Thread.sleep(5000);
			lvmgs.getLVMSearchButton().click();
			lvmgs.getlvmSavedSearchesIcon().click();
			//Select Saved Search from List
			Select selectSavedSearched = new Select(lvmgs.getlvmSavedSearchesDropdown());
			selectSavedSearched.selectByVisibleText(savedSearchesInput);
			//Vrfify Saved Searches output resultss
			Assert.assertTrue(lvmgs.getLVMInfosearchtxtbx().getAttribute("value").contains(prop.getProperty("savedSearchesInput")));
			Thread.sleep(5000);
			Assert.assertTrue(lvmgs.getLVMVerifyGlobalSeacrh().getText().contains(prop.getProperty("savedSearchesInput")));
			driver.get(prop.getProperty("lvmurl_prod"));
		}

	}
	@Test(enabled=false)//priority = 9
	public void TS009_VerifyGlobalSearchMatchingResultsSavedSearchesTest()
			throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T355: Global Search: Matching results -Saved Searches

		lvmgs = new LVMGlobalSearchPage(driver);
		lvmds = new LVMExhDigiShowroomPage(driver);
		lvmexhact = new LVMExhLineProdActionsPage(driver);
		utl = new Utility(driver);
		lap = new LVMLandingPage(driver);
		lp = new LVMLoginPage(driver);
		lvmmpp = new LVMMarketPlannerPage(driver);
		genData = new GenerateData();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		if(!lvmgs.getLVMGlobalSearchTextBox().getAttribute("value").isEmpty()) {
			lvmgs.getlvmGlobalSearchClearTxt().click();
		}
		//utl.verifyMPLoginFunctionality();
		utl.CloseATLPopup();
		lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("exhibitor5"));//savedSearchesInput
		Thread.sleep(3000);
		lvmgs.getLVMSearchButton().click();
		Thread.sleep(5000);
		// Click on Save Searches Btn
		lvmgs.getlvmSavedSearchesIcon().click();
		//Click on Save Seach btn
		lvmgs.getlvmSavedSearchesBtn().click();
		
		String savedSearchesInput=prop.getProperty("savedSearchesInput");
		//Enter Search name into input box
		lvmgs.getlvmSavedSearchesInputBox().sendKeys(savedSearchesInput);
		//Click on Save Search Btn 
		lvmgs.getlvmSavedSearchesBtnForNewSaved().click();
		lvmgs.getlvmSelectList().click();
		
		utl.checkItemPresentInListorNot(lvmgs.getlvmListOfAllSavedSearches(),savedSearchesInput);
		driver.get(prop.getProperty("lvmurl_prod"));
	}
	
	@AfterClass
	public void quit() throws InterruptedException {
		//Thread.sleep(1000);
		//driver.quit();
	}
	
}
