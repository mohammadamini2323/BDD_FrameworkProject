package pages;

import enums.WaitStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class AppliancePage {
    WebDriver driver;
    @FindBy(xpath = "//h1[text()='Big Bachat Days']")
   public WebElement bigBachetDaysText;
    public AppliancePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    public String getBigBachetDayText(){
        WaitUtils.applyWait(bigBachetDaysText,driver, WaitStrategy.VISIBLE);
        return bigBachetDaysText.getText();
    }
}
