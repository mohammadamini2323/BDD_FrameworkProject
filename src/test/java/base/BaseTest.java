package base;

import config.ConfigManager;
import config.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
   protected static WebDriver driver;
   protected static final Logger logger= LogManager.getLogger(BaseTest.class);
   @BeforeMethod
   public static void setup(){
       driver= DriverFactory.initializeWebDriver();
       driver.get(ConfigManager.getProperty("baseUrl"));
       logger.info("test started with base url "+ConfigManager.getProperty("baseUrl"));
   }
   @AfterMethod
    public void tearDown(){
       DriverFactory.quitDriver();
   }
}
