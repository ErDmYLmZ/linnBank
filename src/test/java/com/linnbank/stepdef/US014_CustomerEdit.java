package com.linnbank.stepdef;

import com.linnbank.pages.ManageCustomersPage;
import com.linnbank.utilities.Driver;
import com.linnbank.utilities.JSUtils;
import com.linnbank.utilities.ReusableMethods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class US014_CustomerEdit {

    ManageCustomersPage manageCustomersPage = new ManageCustomersPage();
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

    @Then("employee checks fields and updates fields")
    public void employee_checks_fields_and_updates(DataTable data) {

        List<Map<String, String>> mapData = data.asMaps();

        ReusableMethods.clearAndSendText(manageCustomersPage.firstName, mapData.get(0).get("firstName"));
        ReusableMethods.clearAndSendText(manageCustomersPage.lastName, mapData.get(0).get("lastName"));
        ReusableMethods.clearAndSendText(manageCustomersPage.middleInitial, mapData.get(0).get("MiddleInitial"));
        ReusableMethods.clearAndSendText(manageCustomersPage.email, mapData.get(0).get("Email"));
        ReusableMethods.clearAndSendText(manageCustomersPage.mobilePhoneNumber, mapData.get(0).get("MobilePhone"));
        ReusableMethods.clearAndSendText(manageCustomersPage.phoneNumber, mapData.get(0).get("PhoneNumber"));
        ReusableMethods.clearAndSendText(manageCustomersPage.zipCode, mapData.get(0).get("ZipCode"));
        ReusableMethods.clearAndSendText(manageCustomersPage.adress, mapData.get(0).get("Address"));
        ReusableMethods.clearAndSendText(manageCustomersPage.city, mapData.get(0).get("City"));
        ReusableMethods.clearAndSendText(manageCustomersPage.ssn, mapData.get(0).get("SSN"));

        manageCustomersPage.createDate.clear();
        manageCustomersPage.createDate.sendKeys(mapData.get(0).get("CreateDate"), Keys.RIGHT);
        manageCustomersPage.createDate.sendKeys(mapData.get(0).get("CreateHour"));

        Select select = new Select(manageCustomersPage.countryDropdown);
        ReusableMethods.selectRandomTextFromDropdown(select);

        manageCustomersPage.state.clear();
    }

    @And("employee chooses two accounts from account section {int} and {int}")
    public void employeeChoosesTwoAccountsFromAccountSectionAnd(int a, int b) {
        Select select1 = new Select(manageCustomersPage.account);
        List<WebElement> accountOptionsList = select1.getOptions();
        ReusableMethods.doubleClick(accountOptionsList.get(a));
        act.keyDown(Keys.CONTROL).perform();
        accountOptionsList.get(b).click();
        act.keyUp(Keys.CONTROL).perform();
    }

    @Then("employee clicks Zelle Enrolled if unchecked")
    public void employee_clicks_zelle_enrolled_if_unchecked() {
        ReusableMethods.selectCheckBox(manageCustomersPage.zelleEnrolledCheckbox, true);
    }

    @Then("employee clicks on Save button")
    public void employee_clicks_on_save_button() {
        manageCustomersPage.saveButton.click();
    }


    @Then("employee verify the success message on the Manage Customer page")
    public void employee_verify_the_success_message_on_the_manage_customer_page() {
        ReusableMethods.waitForVisibility(manageCustomersPage.popupMessage, 5);
        Assert.assertTrue(manageCustomersPage.popupMessage.getText().contains("Customer.updated"));
    }

}
