package pages;

import enums.WaitStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class MobilePage {
    WebDriver driver;
    @FindBy(xpath = "//h1[text()='Mobile Phones']")
    public WebElement mobilePhonesText;

    public MobilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public String GetMobilePhonesText(){
        WaitUtils.applyWait(mobilePhonesText,driver, WaitStrategy.VISIBLE);
        return mobilePhonesText.getText();
    }
}
