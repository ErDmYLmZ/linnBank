package com.linnbank.stepdef;

import com.github.javafaker.Faker;
import com.linnbank.exceptions.TextDoesNotMatchAnyException;
import com.linnbank.pages.ManageCustomersPage;
import com.linnbank.utilities.Driver;
import com.linnbank.utilities.JSUtils;
import com.linnbank.utilities.ReusableMethods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.apache.poi.hssf.dev.ReSave;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class ManageCustomers {

    ManageCustomersPage manageCustomersPage = new ManageCustomersPage();
    WebDriver driver = Driver.getDriver();
    Actions act = new Actions(driver);
    Faker fake = new Faker();

    private String id;

    @When("employee navigates to last page on pagination")
    public void employee_navigates_to_last_page_on_pagination() {
        try {
            manageCustomersPage.paginationLastPage.click();
            manageCustomersPage.paginationPreviousPage.click();
        } catch (Exception e) {
            System.out.println("User is already at the last page");
        }
    }

//    @And("employee clicks on the last added customer {string} button on the page")
//    public void employeeClicksOnTheLastAddedCustomerButtonOnThePage(String button) {
//        if (button.equals("Edit")) {
//            ReusableMethods.waitForClickablility(manageCustomersPage.allEditButton.get(0),3);
//            List<WebElement> allEditButton = manageCustomersPage.allEditButton;
//            JSUtils.clickElementByJS(allEditButton.get(allEditButton.size() - 5));
//        } else if (button.equals("View")) {
//            ReusableMethods.waitForClickablility(manageCustomersPage.allViewButton.get(0),3);
//            List<WebElement> allViewButton = manageCustomersPage.allViewButton;
//            id = manageCustomersPage.allIDColumn.get(manageCustomersPage.allIDColumn.size()-5).getText();
//            JSUtils.clickElementByJS(allViewButton.get(allViewButton.size() - 5));
//        } else if (button.equals("Delete")) {
//            ReusableMethods.waitForClickablility(manageCustomersPage.allDeleteButton.get(0), 3);
//            List<WebElement> allDeleteButton = manageCustomersPage.allDeleteButton;
//            JSUtils.clickElementByJS(allDeleteButton.get(allDeleteButton.size() - 5));
//        }
//    }

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
        ReusableMethods.clearAndSendText(manageCustomersPage.ssn, fake.idNumber().ssnValid());

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

    @Then("verify that same user is displayed on the view page")
    public void verifyThatSameUserIsDisplayedOnTheViewPage() {
        ReusableMethods.waitForVisibility(manageCustomersPage.customerViewId, 5);
        Assert.assertEquals(id, manageCustomersPage.customerViewId.getText());
    }

    @And("employee clicks on the {int} customer {string} button on the page")
    public void employeeClicksOnTheCustomerButtonOnThePage(int row, String button) {

        switch (button) {
            case "Edit":

                ReusableMethods.waitForClickablility(manageCustomersPage.allEditButton.get(0), 3);
                List<WebElement> allEditButton = manageCustomersPage.allEditButton;

                try {
                    JSUtils.clickElementByJS(allEditButton.get(row - 1));
                } catch (Exception e) {
                    System.err.println("\nThe specified row does not exist in the page. Process will be continued with first row!");
                    JSUtils.clickElementByJS(allEditButton.get(0));
                }

                break;
            case "View":

                ReusableMethods.waitForClickablility(manageCustomersPage.allViewButton.get(0), 3);
                List<WebElement> allViewButton = manageCustomersPage.allViewButton;

                try {
                    id = manageCustomersPage.allIDColumn.get(row - 1).getText();
                } catch (Exception e) {
                    id = manageCustomersPage.allIDColumn.get(0).getText();
                }

                try {
                    JSUtils.clickElementByJS(allViewButton.get(row - 1));
                } catch (Exception e) {
                    System.err.println("\nThe specified row does not exist in the page. Process will be continued with first row!");
                    JSUtils.clickElementByJS(allViewButton.get(0));
                }

                break;
            case "Delete":
                ReusableMethods.waitForClickablility(manageCustomersPage.allDeleteButton.get(0), 3);
                List<WebElement> allDeleteButton = manageCustomersPage.allDeleteButton;

                try {
                    id = manageCustomersPage.allIDColumn.get(row - 1).getText();
                } catch (Exception e) {
                    id = manageCustomersPage.allIDColumn.get(0).getText();
                }

                try {
                    JSUtils.clickElementByJS(allDeleteButton.get(row - 1));
                } catch (Exception e) {
                    System.err.println("\nThe specified row does not exist in the page. Process will be continued with first row!!!");
                    JSUtils.clickElementByJS(allDeleteButton.get(0));
                }

                break;
            default:

                try {
                    String msg = "The text you are looking for does not match any options.";
                    throw new TextDoesNotMatchAnyException(msg);
                } catch (TextDoesNotMatchAnyException e) {
                    e.printStackTrace();
                }

                break;
        }


    }

    @Then("employee see a pop up message to confirm and approves")
    public void employeeSeeAPopUpMessageToConfirmAndApproves() {
        ReusableMethods.waitForVisibility(manageCustomersPage.deletePopUpMessage, 5);
        Assert.assertTrue(manageCustomersPage.deletePopUpMessage.getText().contains(id));
        manageCustomersPage.confirmDeleteButton.click();
    }

    @Then("employee see a successfully deleted message")
    public void employeeSeeASuccessfullyDeletedMessage() {
        ReusableMethods.waitForVisibility(manageCustomersPage.popupMessage, 5);
        Assert.assertTrue(manageCustomersPage.popupMessage.getText().contains("Customer.deleted"));
    }


}
