package com.linnbank.stepdef;

import com.github.javafaker.Faker;
import com.linnbank.pages.RegisterPage;
import com.linnbank.utilities.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class US001_Registration {
    Faker faker = new Faker();
    RegisterPage registerPage=new RegisterPage();
    @Given("Enter {string} {string}")
    public void enter(String type, String field) {
        if (type.equals("valid")){
            switch (field){
                case "ssn":
                    registerPage.ssnInput.sendKeys(faker.idNumber().ssnValid());
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
                    registerPage.usernameInput.sendKeys(faker.animal().name());
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
        if (condition.equals("successfully")){
            Assert.assertFalse(registerPage.addressInput.isDisplayed());
        }else {
            Assert.assertTrue(registerPage.addressInput.isDisplayed());
        }
    }
    @Then("delete registrant")
    public void delete_registrant() {

    }
}
