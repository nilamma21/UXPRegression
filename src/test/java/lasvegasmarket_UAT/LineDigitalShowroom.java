package lasvegasmarket_UAT;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
import pageObjects.LasVegasMarket.LVMLineDigitalShowroomPage;
import pageObjects.LasVegasMarket.LVMLoginPage;
import pageObjects.LasVegasMarket.LVMMarketPlannerPage;
import pageObjects.LasVegasMarket.LVMProductDetailsPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

public class LineDigitalShowroom extends base{
  
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
  LVMLineDigitalShowroomPage lvmdigish;
  
  List<WebElement> exhlist, linelist, prodlist, searchexhtypelist, searchproducttypelist, mplists, mpeditlistoptns,
  allnoteslist, favlist, searchlinetypelist, tagBlogPost, taglist, infoFilterList;
  
  @BeforeClass
  public void initialize() throws IOException, InterruptedException {
      driver = initializeDriver(); // requires for Parallel text execution
      // chromeVersion();
      utl = new Utility(driver);
      lap = new LVMLandingPage(driver);
      lvmgs=new LVMGlobalSearchPage(driver);
      
      // Navigate to Las Vegas Market site
      driver.get(prop.getProperty("lvmurl_uat"));
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      /*utl.verifyMPLoginFunctionality();
      Thread.sleep(2000);
      utl.loginCheckLVM();*/
      lap.getIUnderstandBtn().click();
      Thread.sleep(5000);
      utl.CloseATLPopup();
  //  lap.getCloseMarktAdBtn().click();
  }
  @Test(priority = 01)
  public void TS001_VerifyLineDigitalShowroomHeroComponentShownByExhibitorNamaeTest()throws InterruptedException, IOException {
      // The purpose of this test case to verify:-
      // T337: Line Digital Showroom: Hero component: Shown by <ExhibitorName>

      lvmgs = new LVMGlobalSearchPage(driver);
      lvmds = new LVMExhDigiShowroomPage(driver);
      lvmexhact = new LVMExhLineProdActionsPage(driver);
      utl = new Utility(driver);
      lap = new LVMLandingPage(driver);
      lp = new LVMLoginPage(driver);
      lvmmpp = new LVMMarketPlannerPage(driver);
      genData = new GenerateData();
      lvmdigish=new LVMLineDigitalShowroomPage(driver);

      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      //click on Global Search Input filed
      lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("LvmUATLine"));
      Thread.sleep(2000);
      //Click on 1st Suggetions
      lvmdigish.getsuggetionList().click();
      Thread.sleep(3000);
      //Verify Digi showrrom page
      System.out.println(lvmdigish.getLVMLineDigiShowroomPageTitle().getText());
      Assert.assertTrue(lvmdigish.getLVMLineDigiShowroomPageTitle().getText().equals(prop.getProperty("LvmUATLine")));
      //Click on Shown By Exhibitor Name
      Thread.sleep(2000);
      //String heroompName=lvmdigish.getdigiShowroomExhName().getText();//LVM Prod
      //lvmdigish.getdigiShowroomExhName().click();//LVM Prod
      String heroompName=lvmdigish.getdigiShowroomExhNameUat().getText();//LVM UAT
      lvmdigish.getdigiShowroomExhNameUat().click();//LVM UAT
      //verify Selected exhitor digi showroom ppage
      Assert.assertTrue(lvmgs.getlvmShowSpecialsTitle().getText().equals(heroompName));
      driver.get(prop.getProperty("lvmurl_uat"));
  }
  @Test(priority = 02)
  public void TS002_VerifyLineDigitalShowroomHeroComponentLocationLinksTest()throws InterruptedException, IOException {
      // The purpose of this test case to verify:-
      // T338: Line Digital Showroom: Hero component: Location Links
      lvmgs = new LVMGlobalSearchPage(driver);
      lvmds = new LVMExhDigiShowroomPage(driver);
      lvmexhact = new LVMExhLineProdActionsPage(driver);
      utl = new Utility(driver);
      lap = new LVMLandingPage(driver);
      lp = new LVMLoginPage(driver);
      lvmmpp = new LVMMarketPlannerPage(driver);
      genData = new GenerateData();
      lvmdigish = new LVMLineDigitalShowroomPage(driver);
      driver.navigate().refresh();
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      if(!lvmgs.getLVMGlobalSearchTextBox().getAttribute("value").isEmpty()) {
          lvmgs.getlvmGlobalSearchClearTxt().click();
      }
      Thread.sleep(3000);
      //click on Global Search Input filed
      lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("LvmUATLine"));
      Thread.sleep(2000);
      //Click on 1st Suggetions
      lvmdigish.getsuggetionList().click();
      Thread.sleep(5000);
      //Verify Digi showrrom page
      Assert.assertTrue(lvmdigish.getLVMLineDigiShowroomPageTitle().getText().equals(prop.getProperty("LvmUATLine"))); //For Prod
      
      //Click on 1st Location Link
      
      String locationURL = lvmdigish.getlocationLinkUAT().getAttribute("href"); 
      // Store the current window handle
      String winHandleBefore = driver.getWindowHandle();
      //lvmdigish.getlocationLink().click(); //For Prod
      lvmdigish.getlocationLinkUAT().click(); //For UAT
      Assert.assertTrue(driver.getCurrentUrl().contains(locationURL));
      // Switch to new window opened
      /*for (String winHandle : driver.getWindowHandles()) {
          driver.switchTo().window(winHandle);
      }
      Thread.sleep(7000);
      //// verify Floor Plan page
      Assert.assertTrue(driver.getCurrentUrl().contains(locationURL));
      // Close the new window, if that window no more required
      driver.close();
      // Switch back to original browser (first window)
      driver.switchTo().window(winHandleBefore);*/
      driver.get(prop.getProperty("lvmurl_uat"));
  }
  //@Test(priority = 03)
  public void TS003_VerifyLineDigitalShowroomHeroComponentAddToFavoriteTest()throws InterruptedException, IOException {
      // The purpose of this test case to verify:-
      // T339: Line Digital Showroom: Hero component: Add to Favorite
      lvmgs = new LVMGlobalSearchPage(driver);
      lvmds = new LVMExhDigiShowroomPage(driver);
      lvmexhact = new LVMExhLineProdActionsPage(driver);
      utl = new Utility(driver);
      lap = new LVMLandingPage(driver);
      lp = new LVMLoginPage(driver);
      lvmmpp = new LVMMarketPlannerPage(driver);
      genData = new GenerateData();
      lvmdigish = new LVMLineDigitalShowroomPage(driver);
      Thread.sleep(4000);
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      if(!lvmgs.getLVMGlobalSearchTextBox().getAttribute("value").isEmpty()) {
          lvmgs.getlvmGlobalSearchClearTxt().click();
      }
      Thread.sleep(2000);
      //click on Global Search Input filed
      lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("searchexhwithlinesinput"));
      Thread.sleep(2000);
      //Click on 1st Suggetions
      lvmdigish.getsuggetionList().click();
      Thread.sleep(5000);
      //Verify Digi showrrom page
      Assert.assertTrue(lvmdigish.getLVMLineDigiShowroomPageTitle().getText().equals(prop.getProperty("searchexhwithlinesinput"))); //For Prod
      
      //Store Hero Comp Name
      String heroCompName=lvmdigish.getdigiShowroomExhNameUat().getText();
      System.out.println(heroCompName);
      // Click on Fav Icon
      //lvmdigish.getfavIconDigiShowroom().click(); // For Prod
      lvmdigish.getfavIconDigiShowroomUat().click(); //For UAT
      Thread.sleep(6000);
      // Sign In to MP
      // Enter the credentials on Login Page and click
      /*lp.getEmailAddress().sendKeys((prop.getProperty("username")));
      lp.getPassword().sendKeys((prop.getProperty("password")));
      lp.getSignInBtn().click();
      Thread.sleep(15000);*/
      
      // Click on Fav Icon
      //lvmdigish.getfavIconDigiShowroom().click(); // For Prod
      //lvmdigish.getfavIconDigiShowroomUat().click(); //For UAT
      lap.getMPLinkText().click();
      Thread.sleep(6000);

      // Click on List tab
      lvmmpp.getMPHomeListsTab().click();
      Thread.sleep(10000);
      // Verify Exhibitor present or not into MP Fav
      //utl.checkItemPresentInListorNot(lvmmpp.getlistOfAllExh(), heroCompName);
      favlist = lvmmpp.getlistOfAllExh();
      for (int i = 0; i < favlist.size(); i++) {
          if(favlist.contains(exhname)) {
              //System.out.println(prodcatgitemlist.get(i).getText());
              Assert.assertTrue(favlist.get(i).getText().contains(heroCompName));
              break;
          }
      }
      driver.get(prop.getProperty("lvmurl_uat"));
  }
  //@Test(priority = 04)
  public void TS004_VerifyLineDigitalShowroomHeroComponentAddTolistTest()throws InterruptedException, IOException {
      // The purpose of this test case to verify:-
      // T340: Line Digital Showroom: Hero component: + icon to add to list
      lvmgs = new LVMGlobalSearchPage(driver);
      lvmds = new LVMExhDigiShowroomPage(driver);
      lvmexhact = new LVMExhLineProdActionsPage(driver);
      utl = new Utility(driver);
      lap = new LVMLandingPage(driver);
      lp = new LVMLoginPage(driver);
      lvmmpp = new LVMMarketPlannerPage(driver);
      genData = new GenerateData();
      lvmdigish=new LVMLineDigitalShowroomPage(driver);
      Thread.sleep(4000);
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      if(!lvmgs.getLVMGlobalSearchTextBox().getAttribute("value").isEmpty()) {
          lvmgs.getlvmGlobalSearchClearTxt().click();
      }
      Thread.sleep(2000);
      //click on Global Search Input filed
      lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("searchexhwithlinesinput"));
      Thread.sleep(2000);
      //Click on 1st Suggetions
      lvmdigish.getsuggetionList().click();
      Thread.sleep(5000);
      //Verify Digi showrrom page
      Assert.assertTrue(lvmdigish.getLVMLineDigiShowroomPageTitle().getText().equals(prop.getProperty("searchexhwithlinesinput"))); //For Prod
      
      //Store Hero Comp Name
      //String heroCompName=lvmdigish.getdigiShowroomExhName().getText();
      // Click on Add to List Icon
      lvmdigish.getaddToListIcon().click();
      Thread.sleep(6000);
/*      // Sign In to MP
      // Enter the credentials on Login Page and click
      lp.getEmailAddress().sendKeys((prop.getProperty("username")));
      lp.getPassword().sendKeys((prop.getProperty("password")));

      lp.getSignInBtn().click();
      Thread.sleep(15000);
      // Click on Add to List Icon
      Thread.sleep(5000);
      lvmdigish.getaddToListIcon().click();*/
      
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
      utl.checkItemPresentInListorNot(lvmmpp.getlistOfAllExh(), prop.getProperty("searchexhwithlinesinput"));
  }
  //@Test(priority = 05)
  public void TS005_VerifyLineDigitalShowroomHeroComponentAddNoteTest()throws InterruptedException, IOException {
      // The purpose of this test case to verify:-
      // T341: Line Digital Showroom: Hero component: Add Note
      lvmgs = new LVMGlobalSearchPage(driver);
      lvmds = new LVMExhDigiShowroomPage(driver);
      lvmexhact = new LVMExhLineProdActionsPage(driver);
      utl = new Utility(driver);
      lap = new LVMLandingPage(driver);
      lp = new LVMLoginPage(driver);
      lvmmpp = new LVMMarketPlannerPage(driver);
      genData = new GenerateData();
      lvmdigish=new LVMLineDigitalShowroomPage(driver);

      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      Thread.sleep(1000);
      if(!lvmgs.getLVMGlobalSearchTextBox().getAttribute("value").isEmpty()) {
          lvmgs.getlvmGlobalSearchClearTxt().click();
      }
      Thread.sleep(4000);
      //click on Global Search Input filed
      lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("searchexhwithlinesinput"));
      Thread.sleep(5000);
      //Click on 1st Suggetions
      lvmdigish.getsuggetionList().click();
      Thread.sleep(5000);
      //Verify Digi showrrom page
      Assert.assertTrue(lvmdigish.getLVMLineDigiShowroomPageTitle().getText().equals(prop.getProperty("searchexhwithlinesinput"))); //For Prod
      
      //Store Hero Comp Name
      //String heroCompName=lvmdigish.getdigiShowroomExhName().getText();
      // Click on Add to List Icon
      lvmdigish.getaddNoteIcon().click();
      Thread.sleep(6000);
      /*// Sign In to MP
      // Enter the credentials on Login Page and click
      lp.getEmailAddress().sendKeys((prop.getProperty("username")));
      lp.getPassword().sendKeys((prop.getProperty("password")));
  
      lp.getSignInBtn().click();
      Thread.sleep(15000);*/
      // Click on Add to List Icon
      //lvmdigish.getaddNoteIcon().click();
      String newnotetitle = "CybNote" + genData.generateRandomString(3);
      // Enter Note title
      lvmexhact.getNoteTitleTxtBx().sendKeys(newnotetitle);
      Thread.sleep(5000);
      // Enter Note Content
      lvmexhact.getNoteContentTxtBx().sendKeys("TestprodNote" + genData.generateRandomString(6));
      Thread.sleep(5000);
      //lvmexhact.getNoteTitleTxtBx().sendKeys(newnotetitle);
      // Click on 'Save' button
      lvmexhact.getNoteSaveBtn().click();
      Thread.sleep(5000);

      lvmdigish.getaddNoteIcon().click();
      Thread.sleep(2000);
      // Click on 'View all Notes for an Exhibitor' link on Add Notes pop-up
      lvmexhact.getViewAllNotesLink().click();
      Thread.sleep(5000);

      List<WebElement> allnoteslist = lvmexhact.getSavedNoteNameInAllNotesList();
      utl.checkItemPresentInListorNot(allnoteslist, newnotetitle);
      utl.selectFilters(allnoteslist, newnotetitle);

      Thread.sleep(2000);
      // Delete the saved note
      lvmexhact.getDeleteNoteBtn().click();
      Thread.sleep(1000);
      lvmdigish.getaddNoteIcon().click();
      Thread.sleep(2000);
      // Click on 'View all Notes for an Exhibitor' link on Add Notes pop-up
      lvmexhact.getViewAllNotesLink().click();
      Thread.sleep(2000);
      // Verify Deleted Note not present
      // utl.checkItemNotPresentInList(lvmexhact.getSavedNoteNameInAllNotesList(),
      // newnotetitle);
      try {
          utl.checkItemNotPresentInList(lvmexhact.getSavedNoteNameInAllNotesList(), newnotetitle);
      } catch (Exception e) {
          System.out.println("Note Deleted successully");
          Thread.sleep(2000);
          //lvmmpp.getcloseNotePopup().click();
      }
      lvmmpp.getcloseNotePopup().click(); 
  }
  //@Test(priority = 12)//Previous priority is 06
  public void TS006_VerifyLineDigitalShowroomHeroComponentOrderOnJuniperMarketTest()throws InterruptedException, IOException {
      // The purpose of this test case to verify:-
      // T343: Line Digital Showroom: Hero component: Order on Juniper Market
      lvmgs = new LVMGlobalSearchPage(driver);
      lvmds = new LVMExhDigiShowroomPage(driver);
      lvmexhact = new LVMExhLineProdActionsPage(driver);
      utl = new Utility(driver);
      lap = new LVMLandingPage(driver);
      lp = new LVMLoginPage(driver);
      lvmmpp = new LVMMarketPlannerPage(driver);
      genData = new GenerateData();
      lvmdigish=new LVMLineDigitalShowroomPage(driver);
      driver.navigate().refresh();
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      Thread.sleep(4000);
      if(!lvmgs.getLVMGlobalSearchTextBox().getAttribute("value").isEmpty()) {
          lvmgs.getlvmGlobalSearchClearTxt().click();
      }
      //click on Global Search Input filed
      lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("searchexhwithlinesinput"));
      Thread.sleep(7000);
      //Click on 1st Suggetions
      lvmdigish.getsuggetionList().click();
      Thread.sleep(4000);
      //Verify Digi showrrom page
      Assert.assertTrue(lvmdigish.getLVMLineDigiShowroomPageTitle().getText().equals(prop.getProperty("searchexhwithlinesinput"))); //For Prod
      
      //Store Hero Comp Name
      //String heroCompName = lvmdigish.getdigiShowroomExhName().getText();
      // Click on OrderOnJUniper Btn
      String orderOnJuniperURL = lvmdigish.getorderOnJuniperBtn().getAttribute("href");
      
      // Store the current window handle
      String winHandleBefore = driver.getWindowHandle();
      lvmdigish.getorderOnJuniperBtn().click(); 

      // Switch to new window opened
      for (String winHandle : driver.getWindowHandles()) {
          driver.switchTo().window(winHandle);
      }
      Thread.sleep(7000);
      //// verify Floor Plan page
      Assert.assertTrue(driver.getCurrentUrl().contains(orderOnJuniperURL));
      // Close the new window, if that window no more required
      driver.close();
      // Switch back to original browser (first window)
      //driver.switchTo().window(winHandleBefore);
          
  }
  @Test(priority = 07)
  public void TS007_VerifyLineDigitalShowroomHeroComponentProductsComponentCountTest()throws InterruptedException, IOException {
      // The purpose of this test case to verify:-
      // T344: Line Digital Showroom: See all Product CTA
      lvmgs = new LVMGlobalSearchPage(driver);
      lvmds = new LVMExhDigiShowroomPage(driver);
      lvmexhact = new LVMExhLineProdActionsPage(driver);
      utl = new Utility(driver);
      lap = new LVMLandingPage(driver);
      lp = new LVMLoginPage(driver);
      lvmmpp = new LVMMarketPlannerPage(driver);
      genData = new GenerateData();
      lvmdigish=new LVMLineDigitalShowroomPage(driver);
      
      driver.navigate().refresh();
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      Thread.sleep(4000);
      if(!lvmgs.getLVMGlobalSearchTextBox().getAttribute("value").isEmpty()) {
          lvmgs.getlvmGlobalSearchClearTxt().click();
      }
  
      //click on Global Search Input filed
      lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("LvmUATLine"));
      Thread.sleep(4000);
      //Click on 1st Suggetions
      lvmdigish.getsuggetionList().click();
      Thread.sleep(4000);
      //Verify Digi showrrom page
      Assert.assertTrue(lvmdigish.getLVMLineDigiShowroomPageTitle().getText().equals(prop.getProperty("LvmUATLine"))); //For Prod
      
      //Store Hero Comp Name
      //String heroCompName = lvmdigish.getdigiShowroomExhName().getText();
      // Click on OrderOnJUniper Btn
      
      //String seeAllProdBtn=lvmdigish.getseeAllProductBtn().getText(); //For Prod
      String seeAllProdBtn=lvmdigish.getseeAllProductBtnUat().getText(); //For UAT
      String seeAllProdCount = seeAllProdBtn.split(" ")[2].trim();
      //lvmdigish.getseeAllProductBtn().click();//For Prod
      lvmdigish.getseeAllProductBtnUat().click();//For UAT
      Thread.sleep(5000);
      String p=driver.findElement(By.xpath("//div[@id='Products']")).getText();
      String count=p.replaceAll("[()]", "");
      String trimCount = count.split(" ")[1].trim();
      //verify both count
      Assert.assertTrue(seeAllProdCount.equals(trimCount));   
      driver.get(prop.getProperty("lvmurl_uat"));
  }
  
  @Test(priority = 8)
  public void TS008_VerifyLineDigitalShowroomProductscomponentTest()throws InterruptedException, IOException {
      // The purpose of this test case to verify:-
      // T346: Line Digital Showroom: Products component
      lvmgs = new LVMGlobalSearchPage(driver);
      lvmds = new LVMExhDigiShowroomPage(driver);
      lvmexhact = new LVMExhLineProdActionsPage(driver);
      utl = new Utility(driver);
      lap = new LVMLandingPage(driver);
      lp = new LVMLoginPage(driver);
      lvmmpp = new LVMMarketPlannerPage(driver);
      genData = new GenerateData();
      lvmdigish=new LVMLineDigitalShowroomPage(driver);
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      Thread.sleep(1000);
      if(!lvmgs.getLVMGlobalSearchTextBox().getAttribute("value").isEmpty()) {
          lvmgs.getlvmGlobalSearchClearTxt().click();
      }
      driver.navigate().refresh();
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      //click on Global Search Input filed
      Thread.sleep(2000);
      lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("LvmUATLine"));
      Thread.sleep(4000);
      //Click on 1st Suggetions
      lvmdigish.getsuggetionList().click();
      Thread.sleep(4000);
      //Verify Digi showrrom page
      Assert.assertTrue(lvmdigish.getLVMLineDigiShowroomPageTitle().getText().equals(prop.getProperty("LvmUATLine"))); //For Prod
      
      //Scroll to Product section
      utl.scrollToElement(lvmdigish.getproductTitle());
      Thread.sleep(5000);
      //Verify Product component and count displayed or not
      Assert.assertTrue(lvmdigish.getproductTitleAndCount().isDisplayed());
      int count=0;
      for (WebElement prodTile : lvmdigish.gelistOfproductTile()) {
          if(prodTile.isDisplayed())
          count++;
      }
      System.out.println(count);
      //Verify Tiles count 6 or not
      Assert.assertTrue(count==6);
      //Verify Order on Juniper link
      //Assert.assertTrue(lvmdigish.getorderOnJuniperBtnLink().isDisplayed()); //commented for test
      //Verify Bottom Product count Link CTA
      Assert.assertTrue(lvmdigish.getprodctCountBottomBtn().isDisplayed());
      
      //Trim count from See All Product btn
      String seeAllProdBtn=lvmdigish.getprodctCountBottomBtn().getText();
      String trimSeeAllProdCount = seeAllProdBtn.split(" ")[2].trim();
      
      //Trim count from Product Section titled
      String prodCount=lvmdigish.getproductCount().getText();
      String trimProdCount = prodCount.split(" ")[0].trim();
      
      //verify both count
      Assert.assertTrue(trimSeeAllProdCount.equals(trimProdCount));
      driver.get(prop.getProperty("lvmurl_uat"));
  }
  //@Test(priority = 9)
  public void TS009_VerifyLineDigitalShowroomProductscomponentOrderOnJuniperMarketTest()throws InterruptedException, IOException {
      // The purpose of this test case to verify:-
      // T372: Line Digital Showroom: Products component: Order on JuniperMarket
      lvmgs = new LVMGlobalSearchPage(driver);
      lvmds = new LVMExhDigiShowroomPage(driver);
      lvmexhact = new LVMExhLineProdActionsPage(driver);
      utl = new Utility(driver);
      lap = new LVMLandingPage(driver);
      lp = new LVMLoginPage(driver);
      lvmmpp = new LVMMarketPlannerPage(driver);
      genData = new GenerateData();
      lvmdigish=new LVMLineDigitalShowroomPage(driver);
      
      driver.navigate().refresh();
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      Thread.sleep(2000);
      if(!lvmgs.getLVMGlobalSearchTextBox().getAttribute("value").isEmpty()) {
          lvmgs.getlvmGlobalSearchClearTxt().click();
      }
      //Thread.sleep(2000);
      lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("HeroComponentExhName"));
      Thread.sleep(8000);
      //Click on 1st Suggetions
      lvmdigish.getsuggetionList().click();
      Thread.sleep(5000);
  
      //click on Global Search Input filed
      /*lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("HeroComponentExhName"));
      Thread.sleep(10000);
      //Click on 1st Suggetions
      lvmdigish.getsuggetionList().click();
      Thread.sleep(5000);*/
      //Scroll to Product section
      utl.scrollToElement(lvmdigish.getproductTitle());
      String orderOnJuniperURL=lvmdigish.getorderOnJuniperBtnLink().getAttribute("href");
      String winHandleBefore = driver.getWindowHandle();
      //CLick on Order on Juniper btn
      lvmdigish.getorderOnJuniperBtnLink().click();

      // Switch to new window opened
      for (String winHandle : driver.getWindowHandles()) {
          driver.switchTo().window(winHandle);
      }
      Thread.sleep(7000);
      //// verify Floor Plan page
      Assert.assertTrue(driver.getCurrentUrl().contains(orderOnJuniperURL));

      // Close the new window, if that window no more required
      driver.close();
      // Switch back to original browser (first window)
      driver.switchTo().window(winHandleBefore);  
  }
  @Test(priority = 10)
  public void TS010_VerifyLineDigitalShowroomProductscomponentSeeAllProductsTest()throws InterruptedException, IOException {
      // The purpose of this test case to verify:-
      // T373: Line Digital Showroom: Products component: See All Products
      lvmgs = new LVMGlobalSearchPage(driver);
      lvmds = new LVMExhDigiShowroomPage(driver);
      lvmexhact = new LVMExhLineProdActionsPage(driver);
      utl = new Utility(driver);
      lap = new LVMLandingPage(driver);
      lp = new LVMLoginPage(driver);
      lvmmpp = new LVMMarketPlannerPage(driver);
      genData = new GenerateData();
      lvmdigish=new LVMLineDigitalShowroomPage(driver);

      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      Thread.sleep(4000);
      if(!lvmgs.getLVMGlobalSearchTextBox().getAttribute("value").isEmpty()) {
          lvmgs.getlvmGlobalSearchClearTxt().click();
      }
      //click on Global Search Input filed
      Thread.sleep(2000);
      lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("LvmUATLine"));
      Thread.sleep(3000);
      //Click on 1st Suggetions
      lvmdigish.getsuggetionList().click();
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      //Thread.sleep(5000);
      //Scroll to Product section
      utl.scrollToElement(lvmdigish.getproductTitle());
      //Click on See All Prod Btn
      String seeAllProdURL=lvmdigish.getSeeAllprodctCountBottomBtn().getAttribute("href");
      lvmdigish.getSeeAllprodctCountBottomBtn().click();
      //Verify See All Product CTA page
      Assert.assertTrue(driver.getCurrentUrl().contains(seeAllProdURL));
      driver.get(prop.getProperty("lvmurl_uat"));
  }
  @Test(priority = 11)
  public void TS011_VerifyLineDigitalShowroomProductscomponentSelectProductTest()throws InterruptedException, IOException {
      // The purpose of this test case to verify:-
      // T374: Line Digital Showroom: Products component: Select a Product
      lvmgs = new LVMGlobalSearchPage(driver);
      lvmds = new LVMExhDigiShowroomPage(driver);
      lvmexhact = new LVMExhLineProdActionsPage(driver);
      utl = new Utility(driver);
      lap = new LVMLandingPage(driver);
      lp = new LVMLoginPage(driver);
      lvmmpp = new LVMMarketPlannerPage(driver);
      genData = new GenerateData();
      lvmdigish=new LVMLineDigitalShowroomPage(driver);

      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      //Thread.sleep(3000);
      if(!lvmgs.getLVMGlobalSearchTextBox().getAttribute("value").isEmpty()) {
          lvmgs.getlvmGlobalSearchClearTxt().click();
      }
      
      lvmgs.getLVMGlobalSearchTextBox().sendKeys(prop.getProperty("LvmUATLine"));
      Thread.sleep(2000);
      //Click on 1st Suggetions
      lvmdigish.getsuggetionList().click();
      //Thread.sleep(5000);
      //Scroll to Product section
      utl.scrollToElement(lvmdigish.getproductTitle());
      //Click on Any Product Btn
      Thread.sleep(2000);
      try {
      String prodName=lvmdigish.getproductName().getText();
      String replaceProdName=prodName.replaceAll(".", "");
      Thread.sleep(2000);
      System.out.println(replaceProdName);
      lvmdigish.getproductName().click();
      Thread.sleep(2000);
      System.out.println(lvmdigish.getproductHeader().getText());
      //Verify See All Product details page
      Assert.assertTrue(lvmdigish.getproductHeader().getText().contains(replaceProdName));
      }catch (Exception e){
          String prodName=lvmdigish.getproductName1PROD().getText();
          String replaceProdName=prodName.replaceAll(".", "");
          Thread.sleep(2000);
          System.out.println(replaceProdName);
          lvmdigish.getproductName1PROD().click();
          Thread.sleep(2000);
          System.out.println(lvmdigish.getproductHeader().getText());
          //Verify See All Product details page
          Assert.assertTrue(lvmdigish.getproductHeader().getText().contains(replaceProdName));
          driver.get(prop.getProperty("lvmurl_uat"));
      }
  }
  @AfterClass
  public void tearDown() {
       driver.quit();
  }
}
