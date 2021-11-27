package com.linnbank.stepdef;

import com.linnbank.pages.MainPage;
import com.linnbank.pages.ManageCustomersPage;
import com.linnbank.pages.SignInPage;
import com.linnbank.utilities.BrowserUtils;
import com.linnbank.utilities.ConfigReader;
import com.linnbank.utilities.Driver;
import com.linnbank.utilities.JSUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;

public class US010_Adress_creating {

    ManageCustomersPage createCustomer;
    MainPage mainPage;
    SignInPage signInPage;




    @Given("employee goes to  Manage Customers page")
    public void employee_goes_to_manage_customers_page() {
        Driver.getDriver().get(ConfigReader.getProperty("gmibank_login_url"));
        mainPage=new MainPage();
        signInPage=new SignInPage();

        mainPage.accountMenu.click();
        mainPage.signIn.click();
        signInPage.login(ConfigReader.getProperty("employeeRole"),
                ConfigReader.getProperty("employeePassword"));
        JSUtils.clickElementByJS(mainPage.myOperations);
        JSUtils.clickElementByJS(mainPage.manageCustomers);
        BrowserUtils.wait(2);

        //mainPage.myOperations.click();
        //mainPage.manageCustomers.click();



    }

    @And("click create new customer")
    public void click_create_new_customer() {
        createCustomer=new ManageCustomersPage();
        JSUtils.clickElementByJS(createCustomer.createNewCustomerButton);
        BrowserUtils.wait(1);


    }

    @When("type new customers all necessary credentials")
    public void type_new_customers_all_necessary_credentials() {

    }

    @When("type city textbox")
    public void type_city_textbox() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("type state textbox")
    public void type_state_textbox() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("select from country dropdown")
    public void select_from_country_dropdown() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("type adress textbox {string}")
    public void type_adress_textbox(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify that Address isn't created")
    public void verify_that_address_isn_t_created() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("type customer adress textbox")
    public void type_customer_adress_textbox() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("type city textbox {string}")
    public void type_city_textbox(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("type state textbox {string}")
    public void type_state_textbox(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



}
