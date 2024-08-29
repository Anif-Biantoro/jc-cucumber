package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class LoginTest {

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);
    private WebDriver driver;

    private LoginPage loginPage;


    @Given("I am on the OrangeHRM login page")
    public void I_am_on_the_OrangeHRM_login_page(){
        DriverSingleton.getInstance(Constants.CHROME);
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);
        loginPage = new LoginPage();
    }

    @When("I enter a valid username and password")
    public void I_enter_a_valid_username_and_password(){
        loginPage.login("Admin", "admin123");
    }

    @And("I click on the login button")
    public void I_click_on_the_login_button(){
       loginPage.setBtnLogin();
    }


    @Then("I should be redirected to the dashboard")
    public void I_should_be_redirected_to_the_dashboard(){
        Assert.assertEquals(loginPage.getTxtDashboard(),"Dashboard");
    }

    @When("I enter an invalid username and a valid password")
    public void I_enter_an_invalid_username_and_a_valid_password(){
        loginPage.logout();
        loginPage.login("invalid", "admin123");
    }

    @Then("I should see an error message for invalid credentials")
    public void I_should_see_an_error_message_for_invalid_credentials(){
        Assert.assertEquals(loginPage.getTxtInvalidCredentials(), "Invalid credentials");
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }
}
