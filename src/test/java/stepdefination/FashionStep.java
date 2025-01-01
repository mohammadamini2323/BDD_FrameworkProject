package stepdefination;

import base.BaseTest;
import config.DriverFactory;
import enums.WaitStrategy;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.Assertion;
import pages.FashionPage;
import pages.HomePage;
import utils.WaitUtils;

public class FashionStep extends BaseTest {
    HomePage homePage;
    Actions actions;
    FashionPage fashionPage;
    @Given("user is on landing page")
    public void user_is_on_landing_page(){
        setup();
    }
    @When("user moves mouse on fashion img")
   public void user_clicks_on_fashion_img(){
        homePage=new HomePage(driver);
        actions=new Actions(driver);
        WaitUtils.applyWait(homePage.fashionImg,driver, WaitStrategy.VISIBLE);
        actions.moveToElement(homePage.fashionImg).perform();
        WaitUtils.applyGlobalWait();

    }
    @Then("user should be navigated to fashion page")
    public void user_should_be_navigated_to_fashion_page(){
        WebElement all=driver.findElement(By.xpath("//a[text()='All']"));
        actions.moveToElement(all).click().perform();
        fashionPage=new FashionPage(driver);
        WaitUtils.applyWait(fashionPage.topWearText,driver,WaitStrategy.VISIBLE);
        System.out.println(fashionPage.getSortByText());
    }
    @After
    public void tearDown(){
        DriverFactory.quitDriver();
    }
}
