package lasvegasmarket_PROD;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import atlantamarket_PROD.TestListeners;
import pageObjects.LasVegasMarket.LVMLandingPage;
import resources.Utility;
import resources.base;


@Listeners({ TestListeners.class })
public class sampleClass extends base {
	
	public Utility utl;
	LVMLandingPage lap;
	
	@BeforeClass
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver();
		utl = new Utility(driver);
		lap = new LVMLandingPage(driver);

		driver.manage().window().maximize();
		driver.get(prop.getProperty("lvmurl_prod"));
		System.out.println("Las Vegas Market site is started");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		try {
			lap.getIUnderstandBtn().click();
			}catch (Exception e) {
				// TODO: handle exception
			}
	}
	

}
