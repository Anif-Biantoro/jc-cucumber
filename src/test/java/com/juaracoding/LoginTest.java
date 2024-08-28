package com.juaracoding;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {

    @Given("I am on the OrangeHRM login page")
    public void I_am_on_the_OrangeHRM_login_page(){
        System.out.println("I am on the OrangeHRM login page");
    }

    @When("I enter a valid username and password")
    public void I_enter_a_valid_username_and_password(){
        System.out.println("I enter a valid username and password");
    }

    @And("I click on the login button")
    public void I_click_on_the_login_button(){
        System.out.println("I click on the login button");
    }


    @Then("I should be redirected to the dashboard")
    public void I_should_be_redirected_to_the_dashboard(){
        System.out.println("I should be redirected to the dashboard");
    }

    @When("I enter an invalid username and a valid password")
    public void I_enter_an_invalid_username_and_a_valid_password(){
        System.out.println("I enter an invalid username and a valid password");
    }

    @Then("I should see an error message for invalid credentials")
    public void I_should_see_an_error_message_for_invalid_credentials(){
        System.out.println("I should see an error message for invalid credentials");
    }
}
