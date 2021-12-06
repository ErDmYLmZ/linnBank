package com.linnbank.stepdef;

import com.github.javafaker.Faker;
import com.linnbank.pages.MainPage;
import com.linnbank.pages.ManageCustomersPage;
import com.linnbank.pages.SignInPage;
import com.linnbank.pojos.Customer;
import com.linnbank.utilities.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import org.kohsuke.rngom.parse.host.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import java.util.Locale;

public class US010_Adress_creating {

    ManageCustomersPage manageCustomersPage=new ManageCustomersPage();
    MainPage mainPage=new MainPage();
    SignInPage signInPage=new SignInPage();
    Customer customer=new Customer();
    Faker faker=new Faker(new Locale("en-US"));




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
        manageCustomersPage=new ManageCustomersPage();
        JSUtils.clickElementByJS(manageCustomersPage.createNewCustomerButton);
        BrowserUtils.wait(1);


    }

    @When("type new customers all necessary credentials")
    public void type_new_customers_all_necessary_credentials() {

        manageCustomersPage.firstName.sendKeys(faker.name().firstName());
        manageCustomersPage.lastName.sendKeys(faker.name().lastName());
        manageCustomersPage.middleInitial.sendKeys(faker.name().name());
        manageCustomersPage.email.sendKeys(faker.internet().emailAddress());
        BrowserUtils.wait(1);
        manageCustomersPage.mobilePhoneNumber.sendKeys("123-456-7893");
        BrowserUtils.wait(1);
        manageCustomersPage.phoneNumber.sendKeys("213-456-7893");
        manageCustomersPage.zipCode.sendKeys(faker.address().zipCode());
        customer.setSsn(faker.idNumber().ssnValid());
        BrowserUtils.wait(2);
        manageCustomersPage.ssn.sendKeys(customer.getSsn());



//
//
//        manageCustomersPage.createDate.clear();
//        manageCustomersPage.createDate.sendKeys(mapData.get(0).get("CreateDate"), Keys.RIGHT);
//        manageCustomersPage.createDate.sendKeys(mapData.get(0).get("CreateHour"));
//
//        Select select = new Select(manageCustomersPage.countryDropdown);
//        ReusableMethods.selectRandomTextFromDropdown(select);

    }

    @When("type city textbox")
    public void type_city_textbox() {
        BrowserUtils.wait(1);
        manageCustomersPage.city.sendKeys(faker.address().city());
    }

    @When("type state textbox")
    public void type_state_textbox() {
        BrowserUtils.wait(1);
        manageCustomersPage.state.sendKeys(faker.address().state());
    }

    @When("select from country dropdown")
    public void select_from_country_dropdown() {
        Select select = new Select(manageCustomersPage.countryDropdown);

        select.selectByVisibleText("USA");

        //ReusableMethods.selectRandomTextFromDropdown(select);
    }
    @When("select empty option from country dropdown")
    public void select_empty_option_from_country_dropdown() {
        Select select = new Select(manageCustomersPage.countryDropdown);
        select.getFirstSelectedOption();
    }

    @When("type adress textbox {string}")
    public void type_adress_textbox(String address) {
        BrowserUtils.wait(1);
        manageCustomersPage.adress.sendKeys(address);

    }

    @Then("verify that Address isn't created")
    public void verify_that_address_isn_t_created() {
        BrowserUtils.wait(2);
        manageCustomersPage.saveButton.click();
        BrowserUtils.wait(10);
        System.out.println(customer.getSsn());


    }

    @When("type customer adress textbox")
    public void type_customer_adress_textbox() {
        BrowserUtils.wait(1);
        manageCustomersPage.adress.sendKeys(faker.address().streetAddress());
        BrowserUtils.wait(1);
        System.out.println(faker.address().streetAddress());
    }

    @When("type city textbox {string}")
    public void type_city_textbox(String invalidCity) {
        BrowserUtils.wait(1);
        manageCustomersPage.city.sendKeys(invalidCity);

    }

    @When("type state textbox {string}")
    public void type_state_textbox(String invalidState) {
        BrowserUtils.wait(1);
        manageCustomersPage.state.sendKeys(invalidState);

    }




}
