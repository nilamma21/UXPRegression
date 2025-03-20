package pageObjects.LasVegasMarket;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LVMLeftPaneFilters {
	public WebDriver driver;
	public WebDriverWait wait;
	
	By prodcatgexpandbtn = By.xpath("//a[@aria-label='Product Categories']"); //Locator for Product category expand btn
	By accentfurnexpandbtn = By.xpath("//div[contains(@class,'imc-filter imc-content imc-expand-collapse')]//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]//div[1]//a[1]//div[1]//div[1]//div[1]");//Locator for accent furniture expan
	By atlAntiqueReprodAccbtn = By.xpath("(//div[contains(@class,'imc-filter imc-content imc-expand-collapse')]//div[1]//div[1]//div[2]//div[1]//div[20])[1]"); //Locator for Antique Reprod Accbtn
	By atlexhibitor = By.xpath("//div[@class='imc-vr--xxlarge']/div[2]/div[1]/div[1]/div/div[1]/a[1]/h2");//Locator for 1st Exhibitor
	By atlexhibitorLVM = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[1]/div[1]/div/div[1]/a[1]/h2");
	By stylesFilterbtn = By.xpath("//a[@aria-label='Styles']"); //Locator for Styles filter
	By apparelvintprodcatg = By.xpath("//label[contains(text(),'Apparel, Vintage')]"); //Locator for name of 'Apparel, Vintage' Categ.
	By antiquevintprodcatg = By.xpath("//label[contains(text(),'Antique/Vintage')]"); //Locator for name of 'Antique/Vintage' Categ.
	By stylesexpandbtn = By.xpath("//a[@aria-label='Styles']"); ////Locator for Styles expand btn
	By coastalstyle = By.xpath("//label[contains(text(),'Coastal')]"); //Locator for Coastal Styles
	By expexhdropdown = By.xpath("//div[contains(@class,'DropDown_dropdown')]"); //Locator for Exhibitor association drop down in EXP
	By trippexhnameinexp = By.xpath("(//*[contains(text(),\"Tripp's Tents\")])[1]"); //Locator for IMC Test Company exhibitor in EXP
	By expdidgitalshowroomtab  = By.xpath("//span[contains(text(),'Your Digital Showroom')]"); //Locator for EXP Digi Showroom tab
	By expprofileinfomenu = By.xpath("//a[contains(text(),'Profile Info')]"); //Locator for EXP Profile Info menu
	By expproductcategsectn = By.xpath("//h3[contains(text(),'Categories')]"); //Locator for Products Categories section title in EXP
	By expcoastalstyleonprofile = By.xpath("//span[contains(@class,'EPUpdateExhibitorProfile_categoriesList') and text()='Coastal']"); //Locator for Coastal Style on Profile
	By accentfurnitureprodcatg = By.xpath("//label[contains(text(),'Accent Furniture')]"); //Locator for name of Accent Furniture Categ.
	By holidayprodcatg = By.xpath("//label[contains(text(),'Holiday/Seasonal')]"); //Locator for name of Holiday/Seasonal Categ.
	By decorativeaccprodcatg = By.xpath("//label[contains(text(),'Decorative Accessories')]"); //Locator for name of Decorative Accessories Categ.
	By generalgiftprodcatg = By.xpath("//label[contains(text(),'General Gift')]"); //Locator for name of General Gift Categ.
	By fashionaccprodcatg = By.xpath("//label[contains(text(),'Fashion Accessories/Jewelry')]"); //Locator for name of Fashion Accessories/Jewelry Categ.
	By floralbotanicalsprodcatg = By.xpath("//label[contains(text(),'Floral / Botanicals')]"); //Locator for name of Floral / Botanicals Categ.
	By hometextilesprodcatg = By.xpath("//label[contains(text(),'Home Textiles')]"); //Locator for name of Home Textiles Categ.
	By secondexhibitor = By.xpath("//div[@class='imc-vr--xxlarge']/div[2]/div[1]/div[1]/div[1]//a[1]/h2[1]");//Locator for 2nd Exhibitor
	By firstVintageExhUat = By.xpath("(//div[contains(@class,'imc-exhibitorcard-title-row')]/div/a/h2)[1]");
	By SecondExhUat = By.xpath("(//div[contains(@class,'imc-exhibitorcard-title-row')]/div/a/h2)[2]");
	By industrialstyle = By.xpath("//label[contains(text(),'Contemporary')]"); //Locator for Industrial Styles
	By expindustrialstyleonprofile = By.xpath("//span[contains(@class,'EPUpdateExhibitorProfile_categoriesList') and text()='Industrial']"); //Locator for Industrial Style on Profile
	By ListLFsubMenus = By.xpath("//input[@type='checkbox' and @aria-checked='true']/../label[@class='imc-checkbox--label imc-filteritem--label-width imc-type--title-2-ui']"); //Locator for Industrial Style on Profile
	By listOfAllHolidayAndSeasonialFilterOptions = By.xpath("//label[contains(text(),'Holiday/Seasonal')]/../../../../../../div[2]/div/div/div/label");
	
	By HolidayAndSeasonialFilterExpandButton = By.xpath("//label[contains(text(),'Holiday/Seasonal')]/../../../../../../div[contains(@class, 'imc-expand-collapse__heading')]");
	
	By listOfAllDecorativeAccessoriesFilterOptions = By.xpath("//label[contains(text(),'Decorative Accessories')]/../../../../../../div[2]/div/div/div/label");
	By listOfAllGeneralGiftFilterOptions = By.xpath("//label[contains(text(),'General Gift')]/../../../../../../div[2]/div/div/div/label");
	By listOfAllFashionAccessoriesJewelryFilterOptions = By.xpath("//label[contains(text(),'Fashion Accessories/Jewelry')]/../../../../../../div[2]/div/div/div/label");
	By listOfAllFloralBotanicalsFilterOptions = By.xpath("//label[contains(text(),'Floral / Botanicals')]/../../../../../../div[2]/div/div/div/label");
	By listOfAllHomeTextilesFilterOptions = By.xpath("//label[contains(text(),'Home Textiles')]/../../../../../../div[2]/div/div/div/label");
	By listOfAllExhibitors = By.xpath("//div[@class='imc-exhibitorcard-title-row ']/div/div/div/div/div/a/h2");
	By isProductCategorySectionNotAvailable = By.xpath("//span[contains(text(),'Product Categories not available')]");
	By leftPaneFilterNewExhibitor = By.xpath("(//div[@class='imc-expand-collapse__content '])[1]/div/div/div[1]");
	By leftPaneFilterHasShowSpecials = By.xpath("(//div[@class='imc-expand-collapse__content '])[1]/div/div/div[2]");
	By leftPaneFilterTemporary = By.xpath("(//div[@class='imc-expand-collapse__content '])[1]/div/div/div[3]");
	By listOfAllExhibitorsHavingShowSpecialTag = By.xpath("//div[@class='imc-content--full-width']/div/div/a");
	By listOfExhibitors = By.xpath("//div[@class='imc-content--full-width']/div/div/div/a/h2");		
	
	
	public LVMLeftPaneFilters(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	}
	public List<WebElement> getlistOfExhibitors() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(listOfExhibitors));
		return driver.findElements(listOfExhibitors);
	}
	public List<WebElement> getlistOfAllExhibitorsHavingShowSpecialTag() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(listOfAllExhibitorsHavingShowSpecialTag));
		return driver.findElements(listOfAllExhibitorsHavingShowSpecialTag);
	}
	public WebElement getleftPaneFilterTemporary(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(leftPaneFilterTemporary));
		return driver.findElement(leftPaneFilterTemporary);
	}
	public WebElement getleftPaneFilterHasShowSpecials(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(leftPaneFilterHasShowSpecials));
		return driver.findElement(leftPaneFilterHasShowSpecials);
	}
	public WebElement getleftPaneFilterNewExhibitor(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(leftPaneFilterNewExhibitor));
		return driver.findElement(leftPaneFilterNewExhibitor);
	}
	public WebElement getisProductCategorySectionNotAvailable(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(isProductCategorySectionNotAvailable));
		return driver.findElement(isProductCategorySectionNotAvailable);
	}
	public List<WebElement> getlistOfAllExhibitors() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(listOfAllExhibitors));
		return driver.findElements(listOfAllExhibitors);
	}
	public List<WebElement> getlistOfAllHomeTextilesFilterOptions() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(listOfAllHomeTextilesFilterOptions));
		return driver.findElements(listOfAllHomeTextilesFilterOptions);
	}
	public List<WebElement> getlistOfAllFloralBotanicalsFilterOptions() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(listOfAllFloralBotanicalsFilterOptions));
		return driver.findElements(listOfAllFloralBotanicalsFilterOptions);
	}
	public List<WebElement> getlistOfAllFashionAccessoriesJewelryFilterOptions() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(listOfAllFashionAccessoriesJewelryFilterOptions));
		return driver.findElements(listOfAllFashionAccessoriesJewelryFilterOptions);
	}
	public List<WebElement> getlistOfAllGeneralGiftFilterOptions() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(listOfAllGeneralGiftFilterOptions));
		return driver.findElements(listOfAllGeneralGiftFilterOptions);
	}
	public List<WebElement> getlistOfAllDecorativeAccessoriesFilterOptions() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(listOfAllDecorativeAccessoriesFilterOptions));
		return driver.findElements(listOfAllDecorativeAccessoriesFilterOptions);
	}
	public List<WebElement> getlistOfAllHolidayAndSeasonialFilterOptions() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(listOfAllHolidayAndSeasonialFilterOptions));
		return driver.findElements(listOfAllHolidayAndSeasonialFilterOptions);
	}
	
	public WebElement getHolidayAndSeasonialFilterExpandButton(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(HolidayAndSeasonialFilterExpandButton));
		return driver.findElement(HolidayAndSeasonialFilterExpandButton);
	}
	
	public WebElement getatlexhibitorLVM(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlexhibitorLVM));
		return driver.findElement(atlexhibitorLVM);
	}
	public List<WebElement> getListLFsubMenus() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ListLFsubMenus));
		return driver.findElements(ListLFsubMenus);
	}
	
	public WebElement getLVMProdCatgExpandBtn(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(prodcatgexpandbtn));
		return driver.findElement(prodcatgexpandbtn);
	}
	public WebElement getAccentFurnExpandBtn(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(accentfurnexpandbtn));
		return driver.findElement(accentfurnexpandbtn);
	}
	public WebElement getLVMAntiqueReprodAccbtn(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlAntiqueReprodAccbtn));
		return driver.findElement(atlAntiqueReprodAccbtn);
	}

	public WebElement getLVMexhibitor(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlexhibitor));
		return driver.findElement(atlexhibitor);
	}
	public WebElement getLVMStylesFilterbtn(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(stylesFilterbtn));
		return driver.findElement(stylesFilterbtn);
	}
	public WebElement getLVMApparelVintProdCatg(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(apparelvintprodcatg));
		return driver.findElement(apparelvintprodcatg);
	}
	public WebElement getLVMAntiqueVintProdCatg(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(antiquevintprodcatg));
		return driver.findElement(antiquevintprodcatg);
	}
	public WebElement getLVMStylesExpandBtn(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(stylesexpandbtn));
		return driver.findElement(stylesexpandbtn);
	}
	public WebElement getLVMCoastalStyle(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(coastalstyle));
		return driver.findElement(coastalstyle);
	}
	public WebElement getEXPExhDropDown(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(expexhdropdown));
		return driver.findElement(expexhdropdown);
	}
	public WebElement getTrippExhNameInEXP(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(trippexhnameinexp));
		return driver.findElement(trippexhnameinexp);
	}
	public WebElement getEXPDigiShowroomTab(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(expdidgitalshowroomtab));
		return driver.findElement(expdidgitalshowroomtab);
	}
	
	public WebElement getEXPProfileInfoMenu(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(expprofileinfomenu));
		return driver.findElement(expprofileinfomenu);
	}
	public WebElement getEXPProductCategSection() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(expproductcategsectn));
		return driver.findElement(expproductcategsectn);
	}
	public WebElement getEXPCoastalStyleOnProfile() {
		return driver.findElement(expcoastalstyleonprofile);
	}
	public WebElement getLVMAccentFurnitureProdCatg(){
		return driver.findElement(accentfurnitureprodcatg);
	}
	public WebElement getLVMHolidayProdCatg(){
		return driver.findElement(holidayprodcatg);
	}
	public WebElement getLVMDecorativeAccProdCatg(){
		return driver.findElement(decorativeaccprodcatg);
	}
	public WebElement getLVMGeneralGiftProdCatg(){
		return driver.findElement(generalgiftprodcatg);
	}
	public WebElement getLVMFashionAccProdCatg(){
		return driver.findElement(fashionaccprodcatg);
	}
	public WebElement getLVMFloralBotanicalsProdCatg(){
		return driver.findElement(floralbotanicalsprodcatg);
	}
	public WebElement getLVMHomeTextilesProdCatg(){
		return driver.findElement(hometextilesprodcatg);
	}
	public WebElement getLVMSecondExhibitor(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(secondexhibitor));
		return driver.findElement(secondexhibitor);
	}
	public WebElement getFirstVintageExhUat() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstVintageExhUat));
		return driver.findElement(firstVintageExhUat);
	}
	public WebElement getSecondExhUat() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(SecondExhUat));
		return driver.findElement(SecondExhUat);
	}
	public WebElement getLVMIndustrialStyle(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(industrialstyle));
		return driver.findElement(industrialstyle);
	}
	public WebElement getEXPIndustrialStyleOnProfile() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(expindustrialstyleonprofile));
		return driver.findElement(expindustrialstyleonprofile);
	}
	
}
