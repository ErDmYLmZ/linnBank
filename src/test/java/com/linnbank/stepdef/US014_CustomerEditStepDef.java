package com.linnbank.stepdef;

import com.github.javafaker.Faker;
import com.linnbank.pages.ManageCustomersPage;
import com.linnbank.utilities.Driver;
import com.linnbank.utilities.ReusableMethods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class US014_CustomerEditStepDef {

    ManageCustomersPage manageCustomersPage = new ManageCustomersPage();
    Faker fake = new Faker();
    WebDriver driver = Driver.getDriver();
    Actions act = new Actions(driver);

    @When("employee navigates to last page on pagination")
    public void employee_navigates_to_last_page_on_pagination() {
        try {
            manageCustomersPage.paginationLastPage.click();
        } catch (Exception e) {
            System.out.println("User is already at the last page");
        }
    }

    @When("employee clicks on the last added customer Edit button on the page")
    public void employee_clicks_on_the_last_added_customer_edit_button_on_the_page() {
        ReusableMethods.waitFor(3);
        List<WebElement> allEditButton = manageCustomersPage.allEditButton;
        allEditButton.get(allEditButton.size() - 1).click();
    }

    @Then("employee checks fields and updates {string}")
    public void employee_checks_fields_and_updates(String fieldname, DataTable data) {

        List<Map<String, String>> mapData = data.asMaps();

        if (manageCustomersPage.firstName.getAttribute("value").isBlank()) {
            manageCustomersPage.firstName.sendKeys(mapData.get(0).get(fieldname));
        }

        if (manageCustomersPage.lastName.getAttribute("value").isBlank()) {
            manageCustomersPage.lastName.sendKeys(mapData.get(0).get(fieldname));
        }

        if(manageCustomersPage.middleInitial.getAttribute("value").isBlank()){
            manageCustomersPage.middleInitial.sendKeys(mapData.get(0).get(fieldname));
        }

        if(manageCustomersPage.email.getAttribute("value").isBlank()){
            manageCustomersPage.email.sendKeys(mapData.get(0).get(fieldname));
        }

        if(manageCustomersPage.mobilePhoneNumber.getAttribute("value").isBlank()){
            manageCustomersPage.mobilePhoneNumber.sendKeys(mapData.get(0).get(fieldname));
        }

        if(manageCustomersPage.phoneNumber.getAttribute("value").isBlank()){
            manageCustomersPage.phoneNumber.sendKeys(mapData.get(0).get(fieldname));
        }

        if(manageCustomersPage.zipCode.getAttribute("value").isBlank()){
            manageCustomersPage.zipCode.sendKeys(mapData.get(0).get(fieldname));
        }

        if(manageCustomersPage.adress.getAttribute("value").isBlank()){
            manageCustomersPage.adress.sendKeys(mapData.get(0).get(fieldname));
        }

        if(manageCustomersPage.city.getAttribute("value").isBlank()){
            manageCustomersPage.city.sendKeys(mapData.get(0).get(fieldname));
        }

        if(manageCustomersPage.ssn.getAttribute("value").isBlank()){
            manageCustomersPage.ssn.sendKeys(mapData.get(0).get(fieldname));
        }

        if(manageCustomersPage.createDate.getAttribute("value").isBlank()){
            manageCustomersPage.createDate.sendKeys(mapData.get(0).get(fieldname));
        }

        if(manageCustomersPage.adress.getAttribute("value").isBlank()){
            manageCustomersPage.adress.sendKeys(mapData.get(0).get(fieldname));
        }

        Select select = new Select(manageCustomersPage.countryDropdown);
        System.out.println("country -->   "+select.getFirstSelectedOption().getText());
        if(select.getFirstSelectedOption().getText().isBlank()){
            select.selectByIndex(5);
        }

        if(!manageCustomersPage.state.getAttribute("value").isBlank()){
            System.out.println("state ->  "+manageCustomersPage.state.getText());
            manageCustomersPage.state.clear();
        }

        Select select1 = new Select(manageCustomersPage.account);
        act.keyDown(Keys.CONTROL).perform();
        select1.selectByVisibleText("abab");
        select1.selectByVisibleText("credit card");
        act.keyUp(Keys.CONTROL).perform();
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
