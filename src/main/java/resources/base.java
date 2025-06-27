package resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {

    public WebDriver driver; // Non-static WebDriver instance
    public static Properties prop;

    public static void chromeVersion() throws IOException {
        Runtime rt = Runtime.getRuntime();
        Process proc = rt.exec("reg query " + "HKEY_CURRENT_USER\\Software\\Google\\Chrome\\BLBeacon " + "/v version");
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

        System.out.println("Here is the standard output of the command:\n");
        String s;
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }

        System.out.println("Here is the standard error of the command (if any):\n");
        while ((s = stdError.readLine()) != null) {
            System.out.println(s);
        }
    }

    public WebDriver initializeDriver() throws IOException {
        prop = new Properties();
        FileInputStream fls = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resources/data.properties");
        prop.load(fls);
        String browserName = prop.getProperty("browser");
        System.out.println(browserName);

        if (browserName.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            //options.addArguments("--headless"); // Uncomment for headless mode
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            driver = new ChromeDriver(options);
            driver.manage().window().setSize(new Dimension(1920, 1080));
            //driver.manage().window().maximize();
        } else if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else if (browserName.equals("edge")) {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        } else if (browserName.equals("IE")) {
            driver = new InternetExplorerDriver();
            driver.manage().window().maximize();
        } else {
            throw new RuntimeException("Invalid browser name: " + browserName);
        }

        Dimension size = driver.manage().window().getSize();
        System.out.println("Viewport size: " + size.getWidth() + "x" + size.getHeight());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver;
    }

    // Non-static screenshot capture method
    public String capture(String testMethodName) throws IOException {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized.");
        }
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new java.text.SimpleDateFormat("yyyyMMdd_HHmmss").format(new java.util.Date());
        String screenShotName = testMethodName + "_" + timestamp + ".png";
        File dest = new File(System.getProperty("user.dir") + "/screenshots/" + screenShotName);
        // Ensure directory exists
        dest.getParentFile().mkdirs();
        FileUtils.copyFile(scrFile, dest);
        return dest.getAbsolutePath();
    }

    // Clean up WebDriver
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Set to null to avoid reuse
        }
    }
}