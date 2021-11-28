package com.linnbank.stepdef;

import com.github.javafaker.Faker;
import com.linnbank.pages.UserSettingsPage;
import com.linnbank.utilities.ConfigReader;
import com.linnbank.utilities.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.Select;

public class US006_User_Settings_StepDefs {
    UserSettingsPage userSettingsPage = new UserSettingsPage();
    Faker faker = new Faker();

//    @Given("user is on the application page")
//    public void user_is_on_the_application_page() {
//        Driver.getDriver().get(ConfigReader.getProperty("gmibank_login_url"));
//    }
//    @Given("user clicks sign in button")
//    public void user_clicks_sign_in_button() {
//
//        userSettingsPage.signIn_Register.click();
//        userSettingsPage.SignIn_Dropdown.click();
//   }
//    @Given("login with {string} and {string}")
//    public void login_with_and(String string, String string2) {
//        userSettingsPage.username.sendKeys(string);
//        userSettingsPage.password.sendKeys(string2);

//    }
//    @Given("user clicks submit button")
//    public void user_clicks_submit_button() {
//        userSettingsPage.submit.click();
//
//    }
//    @Given("close the application")
//    public void close_the_application() {
//        Driver.closeDriver();
//    }

    @Given("user edits  firstnamebox")
    public void user_edits_firstnamebox() {
        userSettingsPage.firstName.clear();
        userSettingsPage.firstName.sendKeys(faker.name().firstName());


    }
    @Given("user edits lastnamebox")
    public void user_edits_lastnamebox() {
        userSettingsPage.lastName.clear();
        userSettingsPage.lastName.sendKeys(faker.name().lastName());

    }
    @Given("user edits emailbox")
    public void user_edits_emailbox() {
        userSettingsPage.email.clear();
        userSettingsPage.email.sendKeys(faker.internet().emailAddress());
   }
    @Given("user chooses {string} or {string}")
    public void user_chooses_and(String string, String string2) {
        Select select = new Select(userSettingsPage.languageDropDown);
        select.selectByValue("tr");

    }
    @Given("user save the info")
    public void user_save_the_info() {
        userSettingsPage.submit.click();
    }
}
