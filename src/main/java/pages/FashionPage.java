package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FashionPage {
    WebDriver driver;
    @FindBy(xpath = "//h1[text()='Topwear']")
   public WebElement topWearText;

    public FashionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public  String getSortByText(){
       return topWearText.getText();

    }
}
