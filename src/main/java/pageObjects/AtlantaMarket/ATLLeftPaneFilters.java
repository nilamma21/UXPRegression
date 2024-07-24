package pageObjects.AtlantaMarket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLLeftPaneFilters {

	public WebDriver driver;
	public WebDriverWait wait;

	By prodcatgexpandbtn = By.xpath("//a[@aria-label='Product Categories']"); //Locator for Product category expand btn
	By accentfurnexpandbtn = By.xpath("//div[contains(@class,'imc-filter imc-content imc-expand-collapse')]//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]//div[1]//a[1]//div[1]//div[1]//div[1]");//Locator for accent furniture expan
	By atlAntiqueReprodAccbtn = By.xpath("(//div[contains(@class,'imc-filter imc-content imc-expand-collapse')]//div[1]//div[1]//div[2]//div[1]//div[20])[1]"); //Locator for Antique Reprod Accbtn
	By atlexhibitor = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[1]/div[1]/div[1]//a[1]/h2[1]");//Locator for 1st Exhibitor
	By stylesFilterbtn = By.xpath("//a[@aria-label='Styles']"); //Locator for Styles filter
	By apparelvintprodcatg = By.xpath("//label[contains(text(),'Apparel, Vintage')]"); //Locator for name of 'Apparel, Vintage' Categ.
	By antiquevintprodcatg = By.xpath("//label[contains(text(),'Antique/Vintage')]"); //Locator for name of 'Antique/Vintage' Categ.
	By stylesexpandbtn = By.xpath("//a[@aria-label='Styles']"); ////Locator for Styles expand btn
	By industrialstyle = By.xpath("//label[contains(text(),'Industrial')]"); //Locator for Industrial Styles
	By expexhdropdown = By.xpath("//div[contains(@class,'DropDown_dropdown')]"); //Locator for Exhibitor association drop down in EXP
	By imcexhnameinexp = By.xpath("//a[contains(text(),'IMC test company')]"); //Locator for IMC Test Company exhibitor in EXP
	By expdidgitalshowroomtab  = By.xpath("//span[contains(text(),'Your Digital Showroom')]"); //Locator for EXP Digi Showroom tab
	By expprofileinfomenu = By.xpath("//a[contains(text(),'Profile Info')]"); //Locator for EXP Profile Info menu
	By expproductcategsectn = By.xpath("//h3[contains(text(),'Product Categories')]"); //Locator for Products Categories section title in EXP
	By expcoastalstyleonprofile = By.xpath("//span[contains(@class,'EPUpdateExhibitorProfile_categoriesList') and text()='Coastal']"); //Locator for Industrial Style on Profile
	By accentfurnitureprodcatg = By.xpath("//label[contains(text(),'Accent Furniture')]"); //Locator for name of Accent Furniture Categ.
	By holidayprodcatg = By.xpath("//label[contains(text(),'Holiday/Seasonal')]"); //Locator for name of Holiday/Seasonal Categ.
	By decorativeaccprodcatg = By.xpath("//label[contains(text(),'Decorative Accessories')]"); //Locator for name of Decorative Accessories Categ.
	By generalgiftprodcatg = By.xpath("//label[contains(text(),'General Gift')]"); //Locator for name of General Gift Categ.
	By fashionaccprodcatg = By.xpath("//label[contains(text(),'Fashion Accessories/Jewelry')]"); //Locator for name of Fashion Accessories/Jewelry Categ.
	By floralbotanicalsprodcatg = By.xpath("//label[contains(text(),'Floral / Botanicals')]"); //Locator for name of Floral / Botanicals Categ.
	By hometextilesprodcatg = By.xpath("//label[contains(text(),'Home Textiles')]"); //Locator for name of Home Textiles Categ.
	By secondexhibitor = By.xpath("//div[@class='imc-vr--xxlarge']/div[2]/div[1]/div[1]/div[1]//a[1]/h2[1]");//Locator for 2nd Exhibitor
	By expindustrialstyleonprofile = By.xpath("//span[contains(@class,'EPUpdateExhibitorProfile_categoriesList') and text()='Industrial']"); //Locator for Industrial Style on Profile
	By leftPaneFilterExhibitor = By.xpath("//a[contains(text(),'Garden Iron & More')]"); //Select exhibitor Garden Iron & More for EXP
	By currentSelectedExhibitor = By.xpath("//span[@class='EPHeader_username__2NOKO']"); //Locator to check currently selected exhibitor in EXP
	
	public ATLLeftPaneFilters(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 
	public WebElement getATLProdCatgExpandBtn(){
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(prodcatgexpandbtn));
		return driver.findElement(prodcatgexpandbtn);
	}
	public WebElement getAccentFurnExpandBtn(){
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(accentfurnexpandbtn));
		return driver.findElement(accentfurnexpandbtn);
	}
	public WebElement getATLAntiqueReprodAccbtn(){
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlAntiqueReprodAccbtn));
		return driver.findElement(atlAntiqueReprodAccbtn);
	}
	public WebElement getATLexhibitor(){
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlexhibitor));
		return driver.findElement(atlexhibitor);
	}
	public WebElement getATLStylesFilterbtn(){
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(stylesFilterbtn));
		return driver.findElement(stylesFilterbtn);
	}
	public WebElement getATLApparelVintProdCatg(){
		return driver.findElement(apparelvintprodcatg);
	}
	public WebElement getATLAntiqueVintProdCatg(){
		return driver.findElement(antiquevintprodcatg);
	}
	public WebElement getATLStylesExpandBtn(){
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(stylesexpandbtn));
		return driver.findElement(stylesexpandbtn);
	}
	public WebElement getATLIndustrialStyle(){
		return driver.findElement(industrialstyle);
	}
	public WebElement getEXPExhDropDown(){
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(expexhdropdown));
		return driver.findElement(expexhdropdown);
	}
	public WebElement getIMCExhNameInEXP(){
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(imcexhnameinexp));
		return driver.findElement(imcexhnameinexp);
	}
	public WebElement getEXPDigiShowroomTab(){
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(expdidgitalshowroomtab));
		return driver.findElement(expdidgitalshowroomtab);
	}
	public WebElement getEXPProfileInfoMenu(){
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(expprofileinfomenu));
		return driver.findElement(expprofileinfomenu);
	}
	public WebElement getEXPProductCategSection() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(expproductcategsectn));
		return driver.findElement(expproductcategsectn);
	}
	public WebElement getEXPCoastalStyleOnProfile() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(expcoastalstyleonprofile));
		return driver.findElement(expcoastalstyleonprofile);
	}
	public WebElement getATLAccentFurnitureProdCatg(){
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(accentfurnitureprodcatg));
		return driver.findElement(accentfurnitureprodcatg);
	}
	public WebElement getATLHolidayProdCatg(){
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(holidayprodcatg));
		return driver.findElement(holidayprodcatg);
	}
	public WebElement getATLDecorativeAccProdCatg(){
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(decorativeaccprodcatg));
		return driver.findElement(decorativeaccprodcatg);
	}
	public WebElement getATLGeneralGiftProdCatg(){
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(generalgiftprodcatg));
		return driver.findElement(generalgiftprodcatg);
	}
	public WebElement getATLFashionAccProdCatg(){
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(fashionaccprodcatg));
		return driver.findElement(fashionaccprodcatg);
	}
	public WebElement getATLFloralBotanicalsProdCatg(){
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(floralbotanicalsprodcatg));
		return driver.findElement(floralbotanicalsprodcatg);
	}
	public WebElement getATLHomeTextilesProdCatg(){
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(hometextilesprodcatg));
		return driver.findElement(hometextilesprodcatg);
	}
	public WebElement getATLSecondExhibitor(){
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(secondexhibitor));
		return driver.findElement(secondexhibitor);
	}
	public WebElement getEXPIndustrialStyleOnProfile() {
	  wait = new WebDriverWait (driver,30);
      wait.until(ExpectedConditions.visibilityOfElementLocated(expindustrialstyleonprofile));
		return driver.findElement(expindustrialstyleonprofile);
	}
	public WebElement getleftPaneFilterExhibitor() {
		  wait = new WebDriverWait (driver,30);
	      wait.until(ExpectedConditions.visibilityOfElementLocated(leftPaneFilterExhibitor));
			return driver.findElement(leftPaneFilterExhibitor);
		}
	public WebElement getcurrentSelectedExhibitor() {
		  wait = new WebDriverWait (driver,30);
	      wait.until(ExpectedConditions.visibilityOfElementLocated(currentSelectedExhibitor));
			return driver.findElement(currentSelectedExhibitor);
		}
	
}
