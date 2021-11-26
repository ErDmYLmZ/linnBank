package com.linnbank.stepdef;

import com.github.javafaker.Faker;
import com.linnbank.pages.RegisterPage;
import com.linnbank.utilities.ConfigReader;
import com.linnbank.utilities.DatabaseUtility;
import com.linnbank.utilities.ReusableMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import javax.xml.crypto.Data;

public class Registration {
    Faker faker = new Faker();
    RegisterPage registerPage=new RegisterPage();
    String ssn = faker.idNumber().ssnValid();
    @Given("Enter {string} {string}")
    public void enter(String type, String field) {
        if (type.equals("valid")){
            switch (field){
                case "ssn":
                    registerPage.ssnInput.sendKeys(ssn);
                    System.out.println(ssn);
                    break;
                case "firstname":
                    registerPage.firstNameInput.sendKeys(faker.name().firstName());
                    break;
                case "lastname":
                    registerPage.lastNameInput.sendKeys(faker.name().lastName());
                    break;
                case "address":
                    registerPage.addressInput.sendKeys(faker.address().fullAddress());
                    break;
                case "mobilephone":
                    registerPage.phoneInput.sendKeys(faker.phoneNumber().cellPhone());
                    break;
                case "username":
                    registerPage.usernameInput.sendKeys(faker.name().username());
                    break;
                case "email":
                    registerPage.emailInput.sendKeys(faker.internet().emailAddress());
                    break;
                case "firstPassword":
                    registerPage.firstPasswordInput.sendKeys(ConfigReader.getProperty("userPassword"));
                    break;
                case "secondPassword":
                    registerPage.secondPasswordInput.sendKeys(ConfigReader.getProperty("userPassword"));
                    break;
            }
        }else if(type.equals("invalid")){
            switch (field){
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
//        ReusableMethods.waitForVisibility(registerPage.popupMessage, 10);
//        if (condition.equals("successfully")) {
//            Assert.assertTrue(registerPage.popupMessage.getAttribute("class").contains("success"));
//        } else {
//            Assert.assertTrue(registerPage.popupMessage.getAttribute("class").contains("error"));
//        }
    }
    @Then("delete registrant")
    public void delete_registrant() {
        DatabaseUtility.createConnection();
        System.out.println("DELETE FROM tpaccount_registration WHERE ssn ='" + ssn + "'");
        DatabaseUtility.executeUpdate("DELETE FROM tpaccount_registration WHERE ssn ='" + ssn + "'");
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