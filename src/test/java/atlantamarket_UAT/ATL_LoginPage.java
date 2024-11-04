package atlantamarket_UAT;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.AtlantaMarket.ATLLandingPage;
import pageObjects.AtlantaMarket.ATLLoginPage;
import resources.Utility;
import resources.base;

@Listeners({ TestListeners.class })
public class ATL_LoginPage extends base{
	
	public Utility utl;
	ATLLandingPage lp;
	ATLLoginPage logp;
	
	@BeforeTest
	public void driverInitialize() throws IOException {
		driver = initializeDriver();
		lp = new ATLLandingPage(driver);
		logp = new ATLLoginPage(driver);
	}
	
	@Test
	public void loginTest() throws InterruptedException {
		driver.get(prop.getProperty("atlmrkturl_uat"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		lp.getLogin().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		logp.getEmailAddress().sendKeys(prop.getProperty("username"));
		Thread.sleep(2000);
		logp.getPassword().sendKeys(prop.getProperty("password"));
		Thread.sleep(2000);
		logp.getSignInBtn().click();
		Thread.sleep(8000);
		System.out.println("Login Successful");
	}
	
	@AfterTest
	public void quitTest() {
		driver.quit();
		
	}
}
