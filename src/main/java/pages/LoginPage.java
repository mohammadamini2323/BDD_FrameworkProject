package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    @FindBy(xpath ="//a[text()='New to Flipkart? Create an account']" )
    public WebElement createAccountTestLink;
    @FindBy(xpath = "//span[text()='Login']")
    public WebElement loginText;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public  void clickOnCreateAccountLinkText(){
        this.createAccountTestLink.click();
    }
    public String getLogInText(){
       return loginText.getText();
    }
}
