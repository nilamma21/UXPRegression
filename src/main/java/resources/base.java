package resources;

import java.io.*;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
    public static WebDriver driver;
    public static Properties prop;

    public static void chromeVersion() throws IOException {
        Runtime rt = Runtime.getRuntime();
        Process proc = rt.exec("reg query HKEY_CURRENT_USER\\Software\\Google\\Chrome\\BLBeacon /v version");

        try (BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
             BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()))) {

            System.out.println("Chrome Version Output:\n");
            String s;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            System.out.println("Chrome Version Errors (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        }
    }

    public static WebDriver initializeDriver() throws IOException {
        prop = new Properties();
        String propFilePath = System.getProperty("user.dir") + "/src/main/java/resources/data.properties";
        try (FileInputStream fis = new FileInputStream(propFilePath)) {
            prop.load(fis);
        } catch (IOException e) {
            System.err.println("Failed to load properties file: " + e.getMessage());
            throw e; // Re-throw to handle upstream
        }

        String browserName = prop.getProperty("browser");
        System.out.println("Launching browser: " + browserName);

        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().clearDriverCache().setup(); // Clear cache to avoid version conflicts
                ChromeOptions options = new ChromeOptions();
                options.setAcceptInsecureCerts(true);
                if ("true".equalsIgnoreCase(prop.getProperty("headless"))) {
                    options.addArguments("--headless");
                    options.addArguments("--disable-gpu");
                    options.addArguments("--window-size=1920,1080"); // Ensure consistent rendering
                }
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browserName + ". Supported browsers: chrome, firefox, edge, ie");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    // Method to clean up driver instance
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static String capture(WebDriver driver, String testMethodName) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenShotName = testMethodName + ".png";
        File dest = new File("screenshots/" + screenShotName);
        FileUtils.copyFile(scrFile, dest);
        return dest.getAbsolutePath();
    }
}