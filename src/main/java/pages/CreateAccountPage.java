package pages;

import enums.WaitStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class CreateAccountPage {
    WebDriver driver;
    @FindBy(xpath = "//span[text()='Existing User? Log in']")
    public WebElement existingUserButton;
    public CreateAccountPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public String getExistingUserButtonsText(){
        WaitUtils.applyWait(existingUserButton,driver, WaitStrategy.VISIBLE);
        return existingUserButton.getText();
    }

}
