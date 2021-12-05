package com.linnbank.stepdef;
import com.linnbank.pages.ManageAccountsPage;
import com.linnbank.pages.MyAccountsPage;
import com.linnbank.utilities.DateUtil;
import com.linnbank.utilities.Driver;
import com.linnbank.utilities.ReusableMethods;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class US013_ManageAccount {
    ManageAccountsPage manageAccountsPage;
    MyAccountsPage myAccountsPage;

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
        Select selectAccountType = new Select(manageAccountsPage.accountTypeDropDown);
        ReusableMethods.selectRandomTextFromDropdown(selectAccountType);

    }
    @And("user selects Account_Status_type")
    public void user_selects_account_status_type() {
        Select selectAccountStatusType = new Select(manageAccountsPage.accountStatusDropDown);
        ReusableMethods.selectRandomTextFromDropdown(selectAccountStatusType);


    }
    @And("user enters Balance {string}")
    public void user_enters_balance(String balance) {
        ReusableMethods.waitFor(1);
       manageAccountsPage.balanceTextBox.sendKeys(balance);
    }

    @And("user enters CreateDate")
    public void user_enters_create_date() {
        String crtDate = DateUtil.getManipulatedDate(0, 0, 0);
        ReusableMethods.waitFor(2);
       manageAccountsPage.createDate.sendKeys(crtDate);
        System.out.println(crtDate);
        ReusableMethods.waitFor(2);
    }

    @And("user enters ClosedDate")
    public void user_enters_closed_date() {
        String clsDate = DateUtil.getManipulatedDate(5, 0, 0);
        ReusableMethods.waitFor(2);
        manageAccountsPage.closeDate.sendKeys(clsDate);
        System.out.println(clsDate);
        ReusableMethods.waitFor(2);
    }
    @And("user enters an early CreateDate")
    public void userEntersAnEarlyCreateDate() {
        String earlyCrtDate = DateUtil.getManipulatedDate(10, 1, 0);
        ReusableMethods.waitFor(2);
        manageAccountsPage.createDate.sendKeys(earlyCrtDate);
        System.out.println(earlyCrtDate);
        ReusableMethods.waitFor(2);
    }
    @And("user enters early ClosedDate")
    public void userEntersEarlyClosedDate() {
        String earlyClsDate = DateUtil.getManipulatedDate(-5, -1, -1);
        ReusableMethods.waitFor(2);
        manageAccountsPage.closeDate.sendKeys(earlyClsDate);
        System.out.println(earlyClsDate);
        ReusableMethods.waitFor(2);
    }

    @When("user clicks on the save button")
    public void user_clicks_on_the_save_button() {
        ReusableMethods.waitFor(5);
        manageAccountsPage.saveButton.click();

    }

    @Then("verify no error_message is displayed on Description field")
    public void verify_no_is_displayed_on_description_field() {
        ReusableMethods.assertByAttribute(manageAccountsPage.descriptionTextBox);
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

    @Given("user clicks on the viewTransaction button")
    public void user_clicks_on_the_view_transaction_button() {

    }

    @Given("verify if there is an account type")
    public void verify_if_there_is_an_account_type() {
        myAccountsPage = new MyAccountsPage();
        Assert.assertTrue(myAccountsPage.accountBalance.getText().equals("Account Balance"));
    }
    @Given("user clicks on the viewTransaction button and verify if there is a transaction table")
    public void user_clicks_on_the_view_transaction_button_and_verify_if_there_is_a_transaction_table() {

        myAccountsPage = new MyAccountsPage();
        for (WebElement elt : myAccountsPage.viewTransaction) {
            elt.click();
            Assert.assertTrue(myAccountsPage.transactionTable.isDisplayed());
        }
    }




    @Then("Close the application")
    public void close_the_application() {
        Driver.closeDriver();
    }

    @When("user uses api token to establish a connection")
    public void user_uses_api_token_to_establish_a_connection() {
        System.out.println(ReusableMethods.getToken());
    }



}
