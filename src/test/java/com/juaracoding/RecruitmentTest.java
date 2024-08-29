package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.RecruitmentPage;
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

public class RecruitmentTest {

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);
    private WebDriver driver;

    private LoginPage loginPage;
    private RecruitmentPage recruitmentPage; // Tambahkan inisialisasi untuk RecruitmentPage

    @Given("I am logged into OrangeHRM as an HR manager")
    public void I_am_logged_into_OrangeHRM_as_an_HR_manager(){
        DriverSingleton.getInstance(Constants.CHROME);
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);
        loginPage = new LoginPage();
        loginPage.login("Admin", "admin123");
        loginPage.setBtnLogin();

        recruitmentPage = new RecruitmentPage(driver); // Inisialisasi RecruitmentPage dengan driver
    }

    @And("I navigate to the Recruitment page")
    public void I_navigate_to_the_Recruitment_page(){
        recruitmentPage.setMenuRecruitment();
    }

    @When("I click on the Add button in the Candidates section")
    public void I_click_on_the_Add_button_in_the_Candidates_section(){
        recruitmentPage.setAdd();
    }

    @And("I fill in all required candidate information with valid data")
    public void I_fill_in_all_required_candidate_information_with_valid_data(){
        recruitmentPage.setFirstName("Juara");
        recruitmentPage.setLastName("Coding");
        recruitmentPage.setEmail("admin@juaracoding.co.id");
        recruitmentPage.setResume("C:\\Users\\Anif Biantoro\\Documents");
    }

    @And("I click the Save button")
    public void I_click_the_Save_button(){
        recruitmentPage.setSave();
    }

    @Then("I should see the new candidate listed in the Candidates section")
    public void I_should_see_the_new_candidate_listed_in_the_Candidate_section(){
        Assert.assertEquals(recruitmentPage.getTxtCandidateProfile());
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }

    @And("I enter invalid format email")
    public void I_enter_invalid_format_email(){
        recruitmentPage.setFirstName("Juara");
        recruitmentPage.setLastName("Coding");
        recruitmentPage.setEmail("adminjuaracoding.co.id");
    }

    @Then("I should see an error message indicating that required fields are missing")
    public void I_should_see_an_error_message_indicating_that_required_fields_are_missing(){
        Assert.assertEquals(recruitmentPage.getTxtErrorFormatEmail(),"Expected format: admin@example.com");
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }


}
