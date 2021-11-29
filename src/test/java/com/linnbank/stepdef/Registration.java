package com.linnbank.stepdef;

import com.github.javafaker.Faker;
import com.linnbank.pages.MainPage;
import com.linnbank.pages.RegisterPage;
import com.linnbank.pojos.Registrant;
import com.linnbank.utilities.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.xml.crypto.Data;

public class Registration{
    Faker faker = new Faker();
    MainPage mainPage = new MainPage();
    RegisterPage registerPage = new RegisterPage();
    Registrant registrant = new Registrant();

    @Given("Enter {string} {string}")
    public void addRegistrant(String type, String field) {
        if (type.equals("valid")) {
            switch (field) {

                case "ssn":
                    registerPage.ssnInput.sendKeys(registrant.getSsn());
//                    registerPage.ssnInput.sendKeys("397-26-7682");
                    break;
                case "firstname":
                    registerPage.firstNameInput.sendKeys(registrant.getFirstName());
                    break;
                case "lastname":
                    registerPage.lastNameInput.sendKeys(registrant.getLastName());
                    break;
                case "address":
                    registerPage.addressInput.sendKeys(registrant.getAddress());
                    break;
                case "mobilephone":
                    registerPage.phoneInput.sendKeys(registrant.getPhoneNumber());
                    break;
                case "username":
                    registerPage.usernameInput.sendKeys(registrant.getUserName());
                    break;
                case "email":
                    registerPage.emailInput.sendKeys(registrant.getEmail());
                    break;
                case "firstPassword":
                    registerPage.firstPasswordInput.sendKeys(registrant.getPassword());
                    break;
                case "secondPassword":
                    registerPage.secondPasswordInput.sendKeys(registrant.getPassword());
                    break;
            }
        } else if (type.equals("invalid")) {
            switch (field) {
                case "ssn":
                    registerPage.ssnInput.sendKeys(faker.idNumber().invalidSvSeSsn());
                    break;
                case "mobilephone":
                    registerPage.phoneInput.sendKeys(faker.name().name());
                    break;
                case "username":
                    registerPage.usernameInput.sendKeys("^#$½&/()");
                    break;
                case "email":
                    registerPage.emailInput.sendKeys(ConfigReader.getProperty("invalidEmail"));
                    break;
                case "firstPassword":
                    registerPage.firstPasswordInput.sendKeys(faker.gameOfThrones().house());
                    break;
                case "secondPassword":
                    registerPage.secondPasswordInput.sendKeys(faker.gameOfThrones().house());
                    break;
            }

        }

    }

    @Then("Click on register")
    public void click_on_register() {
        registerPage.submitRegisterButton.click();
    }

    @Then("verify registered {string}")
    public void verify_registered(String condition) {
        boolean isSuccess = ReusableMethods.isToastSuccess(mainPage.bySuccessMessage);
       if (condition.equals("successfully")) {
            Assert.assertTrue(isSuccess);
           WriteToTxt.saveRegistrantData("src/test/resources/testdata/Registrant.txt",registrant);
        } else {
            Assert.assertFalse(isSuccess);
        }
    }

    @Then("delete registrant")
    public void delete_registrant() {
        DatabaseUtility.createConnection();
        DatabaseUtility.execute("DELETE FROM tpaccount_registration WHERE ssn ='" + registrant.getSsn() + "'");
        DatabaseUtility.closeConnection();
    }

    @And("Register with {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string}")
    public void registerWithAll(String ssn, String firstname, String lastname, String address, String mobilephone, String username, String email, String firstPassword, String secondPassword) {
        registerPage.ssnInput.sendKeys(ssn);
        registerPage.firstNameInput.sendKeys(firstname);
        registerPage.lastNameInput.sendKeys(lastname);
        registerPage.addressInput.sendKeys(address);
        registerPage.emailInput.sendKeys(mobilephone);
        registerPage.usernameInput.sendKeys(username);
        registerPage.emailInput.sendKeys(email);
        registerPage.firstNameInput.sendKeys(firstPassword);
        registerPage.secondPasswordInput.sendKeys(secondPassword);

    }

}