package com.linnbank.stepdef;

import com.github.javafaker.Faker;
import com.linnbank.pages.ManageCustomersPage;
import com.linnbank.utilities.Driver;
import com.linnbank.utilities.JSUtils;
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
        JSUtils.clickElementByJS(allEditButton.get(allEditButton.size() - 1));
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


    }

    @Then("employee chooses two accounts from account section")
    public void employee_chooses_two_accounts_from_account_section() {
        ReusableMethods.waitFor(2);
        Select select1 = new Select(manageCustomersPage.account);

        List<WebElement>accountOptionsList= select1.getOptions();
        System.out.println("accountOptionsList.get(5) = " + accountOptionsList.get(5).getText());
        System.out.println("accountOptionsList.get(16) = " + accountOptionsList.get(16).getText());
//        select1.selectByIndex(accountOptionsList.indexOf("Adil hesap1"));
//        select1.selectByVisibleText(accountOptionsList.get(15).getText());
//        select1.selectByVisibleText(accountOptionsList.get(15).getText().click());
//        JSUtils.clickElementByJS(accountOptionsList.get(15));
        ReusableMethods.doubleClick(accountOptionsList.get(16));
        act.keyDown(Keys.CONTROL).perform();
        accountOptionsList.get(15).click();
        act.keyUp(Keys.CONTROL).perform();


    }
    @Then("employee clicks Zelle Enrolled if unchecked")
    public void employee_clicks_zelle_enrolled_if_unchecked() {
        if (!manageCustomersPage.zelleEnrolledCheckbox.isSelected()) {
            manageCustomersPage.zelleEnrolledCheckbox.click();
        }
    }
    @Then("employee clicks on Save button")
    public void employee_clicks_on_save_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
//    @Then("employee verify the success message on the Manage Customer page")
//    public void employee_verify_the_success_message_on_the_manage_customer_page() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }

}
