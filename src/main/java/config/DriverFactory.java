package config;

import enums.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
   public static WebDriver driver;
    public static WebDriver initializeWebDriver(){
        Browser browser=Browser.valueOf(ConfigManager.getProperty("browser").toUpperCase());
        Boolean isHeadless=Boolean.parseBoolean(ConfigManager.getProperty("isHeadless"));
        System.out.println("loaded configuration with headless mode:"+isHeadless);
        switch (browser){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions=new ChromeOptions();
                if (isHeadless){
                    chromeOptions.addArguments("--headless");
                }else {
                    driver= new ChromeDriver(chromeOptions);
                }
                break;

            case FIREFOX:
                // Setup FirefoxDriver using WebDriverManager to handle dependencies
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                // Add headless arguments if configured
                if (isHeadless) {
                    firefoxOptions.addArguments("--headless");
                }
                driver = new FirefoxDriver(firefoxOptions);  // Instantiate FirefoxDriver with the options
                break;

            case EDGE:
                // Setup EdgeDriver using WebDriverManager to handle dependencies
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                // Add headless arguments if configured
                if (isHeadless) {
                    edgeOptions.addArguments("--headless");
                }
                driver = new EdgeDriver(edgeOptions);  // Instantiate EdgeDriver with the options
                break;

            case SAFARI:
                // Setup SafariDriver (no options for headless support)
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();  // Instantiate SafariDriver
                break;

            default:
                // Throw an exception if the specified browser is unsupported
                throw new IllegalArgumentException("Browser not supported: " + browser);

        }
        driver.manage().window().maximize();


        return driver;
    }
    public static void quitDriver(){
        if (driver!=null){
        driver.quit();}
    }

}
