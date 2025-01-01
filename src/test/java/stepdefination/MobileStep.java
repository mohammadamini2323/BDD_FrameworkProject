package stepdefination;

import base.BaseTest;
import config.DriverFactory;
import enums.WaitStrategy;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.MobilePage;
import utils.WaitUtils;

public class MobileStep extends BaseTest {
    HomePage homePage;
    MobilePage mobilePage;
    @Given("user is on  home page")
    public void user_is_on_home_page(){
        setup();
    }
    @When("user clicks on mobile img")
    public void user_clicks_on_mobile_img(){
        homePage=new HomePage(driver);
        WaitUtils.applyWait(homePage.mobileButton,driver, WaitStrategy.CLICKABLE);
        homePage.clickOnMobileButton();
    }
    @Then("user sould be navigated to mobiles page")
    public void user_should_be_navigated_to_mobiles_page(){
        mobilePage=new MobilePage(driver);
        Assert.assertEquals(mobilePage.GetMobilePhonesText(),"Mobile Phones","did not matched");

    }
    @After
    public void tearDown(){
        DriverFactory.quitDriver();
    }


}
