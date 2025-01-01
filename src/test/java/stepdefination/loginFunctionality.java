package stepdefination;

import base.BaseTest;
import enums.WaitStrategy;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import utils.WaitUtils;

public class loginFunctionality extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;


    @Given("user is on FlipKart home page")
    public void user_is_on_FlipKart_home_page(){
        setup();
    }
    @When("user clicks on login button")
    public void user_clicks_on_login_button(){
        homePage=new HomePage(driver);
        WaitUtils.applyWait(homePage.loginButton,driver, WaitStrategy.CLICKABLE);
        homePage.clickOnLoginButton();
    }
    @Then("user should be navigated to the login page")
    public void user_should_be_navigated_to_login_page(){
loginPage=new LoginPage(driver);
        Assert.assertEquals("Login",loginPage.getLogInText()," did not matched");
    }
    @After
    public void tearDown(){

        super.tearDown();
    }
}
