package lasvegasmarket_PROD;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import resources.base;

public class HeadlessChromeTest extends base{
	public static void main(String[] args) {
        // Set path for ChromeDriver (if required)
       // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Set ChromeOptions for headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");  // Enable headless mode
        options.addArguments("--disable-gpu"); // Recommended for Windows

        // Initialize WebDriver
       // WebDriver driver = new ChromeDriver(options);
        WebDriver driver=new ChromeDriver(options);
        
        // Open website
        driver.get("https://www.google.com");

        // Print title
        System.out.println("Title: " + driver.getTitle());

        // Close driver
        driver.quit();
    }

}
