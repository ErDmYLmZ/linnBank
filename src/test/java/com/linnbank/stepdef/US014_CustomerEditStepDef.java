package com.linnbank.stepdef;

import com.github.javafaker.Faker;
import com.linnbank.pages.ManageCustomersPage;
import com.linnbank.utilities.Driver;
import com.linnbank.utilities.ReusableMethods;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class US014_CustomerEditStepDef {

    ManageCustomersPage manageCustomersPage = new ManageCustomersPage();
    Faker fake = new Faker();

    WebDriver driver = Driver.getDriver();

    @When("employee navigates to last page on pagination")
    public void employee_navigates_to_last_page_on_pagination() {
        try {
            manageCustomersPage.paginationLastPage.click();
        }catch (Exception e){
            System.out.println("User is already at the last page");
        }
    }
    @When("employee clicks on the last added customer Edit button on the page")
    public void employee_clicks_on_the_last_added_customer_edit_button_on_the_page() {
        ReusableMethods.waitFor(3);
        List<WebElement> allEditButton = manageCustomersPage.allEditButton;
        allEditButton.get(allEditButton.size()-1).click();
    }


    @Then("employee checks {string} fields and fill {string} if empty")
    public void employee_checks_fields_and_fill_if_empty(String field, String string2) {
        if(manageCustomersPage.firstName.getAttribute("value").isBlank()){
            manageCustomersPage.firstName.sendKeys(fake.gameOfThrones().character());
        }
    }

//    @Then("employee chooses two accounts from account section")
//    public void employee_chooses_two_accounts_from_account_section() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("employee clicks Zelle Enrolled if unchecked")
//    public void employee_clicks_zelle_enrolled_if_unchecked() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("employee clicks on Save button")
//    public void employee_clicks_on_save_button() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("employee verify the success message on the Manage Customer page")
//    public void employee_verify_the_success_message_on_the_manage_customer_page() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }

}
