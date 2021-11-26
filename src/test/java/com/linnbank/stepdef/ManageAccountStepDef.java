package com.linnbank.stepdef;

import com.linnbank.pages.MainPage;
import com.linnbank.pages.ManageAccountsPage;
import com.linnbank.utilities.ConfigReader;
import com.linnbank.utilities.Driver;
import com.linnbank.utilities.ReusableMethods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class ManageAccountStepDef {
    MainPage mainPage = new MainPage();
    ManageAccountsPage manageAccountsPage = new ManageAccountsPage();
    Select select = new Select(mainPage.signIn_registerDropdown);

//    @Given("user is on ManageAccountsPage")
//    public void userIsOnManageAccountsPage() {
//    }
//    @Given("user enters Description {string}")
//    public void user_enters_description(String string) {
//
//    }
//    @Given("user selects Account_Type")
//    public void user_selects_account_type() {
//
//    }
//    @Given("user selects Account_Status_type")
//    public void user_selects_account_status_type() {
//
//    }
//    @When("user clicks on the save button")
//    public void user_clicks_on_the_save_button() {
//
//    }
//    @Then("verify no {string} is displayed on Description field")
//    public void verify_no_is_displayed_on_description_field(String string) {
//
//    }
//    @Then("verify no {string} is displayed on Balance field")
//    public void verify_no_is_displayed_on_balance_field(String string) {
//
//    }
//    @Then("verify no {string} is displayed on Create_Date field")
//    public void verify_no_is_displayed_on_create_date_field(String string) {
//
//    }
//    @Then("verify no {string} is displayed on Closed_date field")
//    public void verify_no_is_displayed_on_closed_date_field(String string) {
//
//    }
//    @Then("verify the {string} is displayed on Description field")
//    public void verify_the_is_displayed_on_description_field(String string) {
//
//    }
//    @Then("verify the {string} is displayed on Balance field")
//    public void verify_the_is_displayed_on_balance_field(String string) {
//
//    }
//    @Then("verify the {string} is displayed on Create_Date field")
//    public void verify_the_is_displayed_on_create_date_field(String string) {
//
//    }
//    @Then("verify the {string} is displayed on Closed_date field")
//    public void verify_the_is_displayed_on_closed_date_field(String string) {

 //   }

}
