package pages;

import enums.WaitStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class HomePage {
    WebDriver driver;
    @FindBy(xpath ="//a[@class='_1TOQfO' ]/span[text()='Login']" )
    public WebElement loginButton;
    @FindBy(xpath = "//img[@alt='Mobiles']")
    public WebElement mobileButton;
    @FindBy(xpath = "//img[@alt='Fashion']")
    public WebElement fashionImg;
    @FindBy(xpath = "//img[@alt='Appliances']")
    public WebElement applianceImg;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void clickOnMobileButton(){
        this.mobileButton.click();
    }
    public  void clickOnLoginButton(){
        this.loginButton.click();
    }
    public  void clickOnFashionImg(){
        this.fashionImg.click();
    }
    public void clickOnApplianceImg(){
        WaitUtils.applyWait(applianceImg,driver, WaitStrategy.CLICKABLE).click();
        //this.applianceImg.click();
    }
}
