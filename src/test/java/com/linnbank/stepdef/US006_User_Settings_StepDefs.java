package com.linnbank.stepdef;

import com.linnbank.pages.UserSettingsPage;
import com.linnbank.utilities.ConfigReader;
import com.linnbank.utilities.Driver;
import io.cucumber.java.en.*;

public class US006_User_Settings_StepDefs {
    UserSettingsPage userSettingsPage = new UserSettingsPage();

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
}
