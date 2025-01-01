package utils;

import config.ConfigManager;
import enums.WaitStrategy;
import org.apache.logging.log4j.core.async.JCToolsBlockingQueueFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    public static Duration getTimeout(){
        String timeoutValue= ConfigManager.getProperty("timeout");
        int timeoutInSecond=(timeoutValue !=null)?Integer.parseInt(timeoutValue):10;

        return Duration.ofSeconds(timeoutInSecond);
    }
    public static void applyGlobalWait(){
        boolean enabledTimeout=Boolean.parseBoolean(ConfigManager.getProperty("EnableWait"));
        int timeoutInSeconds=Integer.parseInt(ConfigManager.getProperty("waitInSeconds"));
        System.out.println("is wait enable:"+ enabledTimeout);
        System.out.println("Time in seconds: "+ timeoutInSeconds);
        if (enabledTimeout&&timeoutInSeconds>0){
            try {
                Thread.sleep(timeoutInSeconds*1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public static WebElement applyWait(WebElement webElement, WebDriver driver, WaitStrategy waitStrategy){
        WebDriverWait wait=new WebDriverWait(driver,getTimeout());
        switch (waitStrategy){
            case CLICKABLE:
               return wait.until(ExpectedConditions.elementToBeClickable(webElement));
            case VISIBLE:
                return  wait.until(ExpectedConditions.visibilityOf(webElement));
            case NONE:
            default:
                return webElement;

        }

    }
    public static WebElement applyWait(WebElement webElement, WebDriver driver, WaitStrategy waitStrategy, By element){
        WebDriverWait wait=new WebDriverWait(driver,getTimeout());
        switch (waitStrategy){
            case CLICKABLE:
                return wait.until(ExpectedConditions.elementToBeClickable(webElement));
            case VISIBLE:
                return  wait.until(ExpectedConditions.visibilityOf(webElement));
            case PRESENCE:
                return wait.until(ExpectedConditions.presenceOfElementLocated(element));
            case NONE:
            default:
                return webElement;
        }

    }
    public static WebElement waitForPresence(WebDriver driver,By element){
        WebDriverWait wait=new WebDriverWait(driver,getTimeout());
        return wait.until(ExpectedConditions.presenceOfElementLocated(element));

    }




}
