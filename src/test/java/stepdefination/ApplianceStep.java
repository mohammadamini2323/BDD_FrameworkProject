package stepdefination;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AppliancePage;
import pages.HomePage;

public class ApplianceStep extends BaseTest {
    HomePage homePage;
    AppliancePage appliancePage;
    @Given("user is on  home page already")
    public void user_is_on_home_page_already(){
        setup();
    }
    @When("user clicks on appliance img")
    public void user_clicks_on_appliance_img(){
        homePage=new HomePage(driver);
        homePage.clickOnApplianceImg();
    }
    @Then("user should be navigated to appliance page")
    public void user_should_be_navigated_to_appliance_page(){
        appliancePage=new AppliancePage(driver);
        Assert.assertEquals(appliancePage.getBigBachetDayText(),"Big Bachat Days","did not matched");
    }
}
