package resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;

public class base {	

	// this is base class page where driver is initialized and data.properties mentioned. 
	// this class holds all the functions that commonly used by other pages.
	public static WebDriver driver;
	//public WebDriver driver; //For parallel execution
	public static Properties prop;
	public static String s;

	public static void chromeVersion() throws IOException {

		Runtime rt = Runtime.getRuntime();
		Process proc = rt.exec("reg query " + "HKEY_CURRENT_USER\\Software\\Google\\Chrome\\BLBeacon " +  "/v version");
		BufferedReader stdInput = new BufferedReader(new 
				InputStreamReader(proc.getInputStream()));

		BufferedReader stdError = new BufferedReader(new 
				InputStreamReader(proc.getErrorStream()));

		// Read the output from the command
		System.out.println("Here is the standard output of the command:\n");
		String s = null;
		while ((s = stdInput.readLine()) != null) {
			System.out.println(s);
		}

		// Read any errors from the attempted command
		System.out.println("Here is the standard error of the command (if any):\n");
		while ((s = stdError.readLine()) != null) {
			System.out.println(s);
		}
	}

	public WebDriver initializeDriver() throws IOException
	{
		prop= new Properties();

		FileInputStream fls= new FileInputStream(System.getProperty("user.dir") +"/src/main/java/resources/data.properties");

		prop.load(fls);
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);

		if(browserName.equals("chrome"))
		{
			//Check for Specific browser version
			//WebDriverManager.chromedriver().browserVersion(prop.getProperty("browserversion")).setup();
			//WebDriverManager.chromedriver().driverVersion(prop.getProperty("driverversion")).setup();

			//Checks for the latest browser version
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if (browserName.equals("firefox"))
		{
			//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Drivers/geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else if (browserName.equals("edge")) 
		{
			//System.setProperty("webdriver.edge.driver",System.getProperty("user.dir") + "/Drivers/msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
		else if (browserName.equals("IE")) 
		{
			//System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + "/Drivers/IEDriverServer.exe");
			WebDriverManager.iedriver().setup();
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