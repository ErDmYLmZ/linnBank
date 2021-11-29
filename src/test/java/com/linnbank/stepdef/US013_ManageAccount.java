package com.linnbank.stepdef;
import com.linnbank.pages.ManageAccountsPage;
import com.linnbank.utilities.DateUtil;
import com.linnbank.utilities.Driver;
import com.linnbank.utilities.ReusableMethods;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;



public class US013_ManageAccount {
    ManageAccountsPage manageAccountsPage;

    @And("user clicks on the CreateANewAccount button")
    public void userClicksOnTheCreateANewAccountButton() {
        manageAccountsPage=new ManageAccountsPage();
       // ReusableMethods.waitForClickablility(manageAccountsPage.createAnewAccountButton, 40);
        manageAccountsPage.createAnewAccountButton.click();
    }

    @And("user enters Description {string}")
    public void user_enters_description(String description) {
       // manageAccountsPage=new ManageAccountsPage();
        //ReusableMethods.waitForVisibility(manageAccountsPage.descriptionTextBox, 20);
        manageAccountsPage.descriptionTextBox.sendKeys(description);
    }
    @And("user selects Account_Type")
    public void user_selects_account_type() {
        Select select = new Select(manageAccountsPage.accountTypeDropDown);
        select.getFirstSelectedOption().click();

    }
    @And("user selects Account_Status_type")
    public void user_selects_account_status_type() {
        Select select = new Select(manageAccountsPage.accountStatusDropDown);
        select.getFirstSelectedOption().click();

    }
    @And("user enters Balance {string}")
    public void user_enters_balance(String balance) {
        ReusableMethods.waitFor(1);
       manageAccountsPage.balanceTextBox.sendKeys(balance);
    }

    @And("user enters CreateDate {string}")
    public void user_enters_create_date(String CreateDate) {
        ReusableMethods.waitFor(1);
       manageAccountsPage.createDate.sendKeys(CreateDate);
    }

    @And("user enters ClosedDate {string}")
    public void user_enters_closed_date(String closedDate) {
        ReusableMethods.waitFor(1);
      manageAccountsPage.closeDate.sendKeys(closedDate);
    }

    @When("user clicks on the save button")
    public void user_clicks_on_the_save_button() {
        manageAccountsPage.saveButton.click();

    }
    @Then("verify no error_message is displayed on Description field")
    public void verify_no_is_displayed_on_description_field() {
        boolean descriptionErrorMsg = manageAccountsPage.descriptionTextBox.getAttribute("class").contains("invalid");
        Assert.assertFalse(descriptionErrorMsg);
    }
    @Then("the error_message should be displayed on Balance field")
    public void verify_no_is_displayed_on_balance_field() {
        boolean balanceErrorMsg = manageAccountsPage.balanceTextBox.getAttribute("class").contains("invalid");
        Assert.assertFalse(balanceErrorMsg);
    }
    @Then("verify no error_message is displayed on Create_Date field")
    public void verify_no_is_displayed_on_create_date_field() {
        boolean createDateErrorMsg = manageAccountsPage.createDate.getAttribute("class").contains("invalid");
        Assert.assertFalse(createDateErrorMsg);
    }
    @Then("verify no error_message is displayed on Closed_date field")
    public void verify_no_is_displayed_on_closed_date_field() {
        boolean closedDateErrorMsg = manageAccountsPage.closeDate.getAttribute("class").contains("invalid");
        Assert.assertFalse(closedDateErrorMsg);
    }
    @Then("verify the error_message is displayed on Description field")
    public void verify_the_is_displayed_on_description_field() {
        boolean descriptionErrorMsg = manageAccountsPage.descriptionTextBox.getAttribute("class").contains("invalid");
        Assert.assertTrue(descriptionErrorMsg);
    }
    @Then("verify the error_message is displayed on Balance field")
    public void verify_the_is_displayed_on_balance_field() {
        boolean balanceErrorMsg = manageAccountsPage.balanceTextBox.getAttribute("class").contains("invalid");
        Assert.assertTrue(balanceErrorMsg);
    }
    @Then("the error_message should be displayed on Create_date field")
    public void verify_the_is_displayed_on_create_date_field() {
        boolean createDateErrorMsg = manageAccountsPage.createDate.getAttribute("class").contains("invalid");
        Assert.assertFalse(createDateErrorMsg);
    }
    @Then("the error_message should be displayed on Closed_date field")
    public void verify_the_is_displayed_on_closed_date_field() {
        boolean closedDateErrorMsg = manageAccountsPage.closeDate.getAttribute("class").contains("invalid");
        ReusableMethods.waitFor(3);
        Assert.assertFalse(closedDateErrorMsg);
    }
    @Then("Close the application")
    public void close_the_application() {
        Driver.closeDriver();
    }


    @And("user enters CreateDate")
    public void userEntersCreateDate() {
        DateUtil.todaysDate().
    }
}
