package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {	

	// this is base class page where driver is initialized and data.properties mentioned. 
	// this class holds all the functions that commonly used by other pages.
	public static WebDriver driver;
	//public WebDriver driver; //For parallel execution
	public static Properties prop;

	public WebDriver initializeDriver() throws IOException
	{
		prop= new Properties();

		FileInputStream fls= new FileInputStream(System.getProperty("user.dir") +"/src/main/java/resources/data.properties");

		prop.load(fls);
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);

		if(browserName.equals("chrome"))
		{
			// you can mention chromedriver.exe path here to execute all the scripts.

			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver_102.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if (browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else if (browserName.equals("edge")) 
		{
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir") + "/Drivers/msedgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
		else if (browserName.equals("IE")) 
		{
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + "/Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}	

	public static String capture(WebDriver driver, String testMethodName) throws IOException 
	{
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenShotName = testMethodName + ".png";
		File Dest = new File("src/../screenshots/" + screenShotName);
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
	}
}