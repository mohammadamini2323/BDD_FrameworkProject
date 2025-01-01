package stepdefination;

import base.BaseTest;
import enums.WaitStrategy;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.WaitUtils;

public class CreateAccountLinkStep extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    CreateAccountPage createAccountPage;
//    @Before
//    public void setupIt(){
//       setup();
//    }

    @Given("user is on login page")
    public void user_is_on_login_page() {
        setup();
        homePage=new HomePage(driver);
        WaitUtils.applyWait(homePage.loginButton,driver, WaitStrategy.CLICKABLE);
        homePage.clickOnLoginButton();
    }
    @When("user clicks on New to Flipkart? Create an account link text")
    public void user_clicks_on_new_to_flipkart_create_an_account_link_text() {
        loginPage=new LoginPage(driver);
        WaitUtils.applyWait(loginPage.createAccountTestLink,driver,WaitStrategy.CLICKABLE);
        loginPage.clickOnCreateAccountLinkText();
    }
    @Then("user should be navigated to thee creat new account page")
    public void user_should_be_navigated_to_thee_creat_new_account_page() {
        createAccountPage=new CreateAccountPage(driver);
        Assert.assertEquals("Existing User? Log in",createAccountPage.getExistingUserButtonsText(),"did not match");

    }
    @After
    public void tearDown(){
        super.tearDown();
    }

}
