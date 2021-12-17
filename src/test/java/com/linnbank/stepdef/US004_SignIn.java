package com.linnbank.stepdef;
import com.linnbank.pages.MainPage;
import com.linnbank.pages.PasswordPage;
import com.linnbank.pages.RegisterPage;
import com.linnbank.pages.SignInPage;
import com.linnbank.pojos.Container;
import com.linnbank.utilities.ConfigReader;
import com.linnbank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.junit.Assert;


public class US004_SignIn {

    static MainPage mainPage;
    static SignInPage signInPage;


    @Given("{string} is on the {string} page")
    public static void user_is_on_the_page(String role, String page) {
        Driver.getDriver().get(ConfigReader.getProperty("gmibank_login_url"));
        mainPage = new MainPage();
        signInPage = new SignInPage();

        // only registered user can be logged in
        if (!role.equals("unregistered")) {
            mainPage.accountMenu.click();
            mainPage.signIn.click();
            if (!role.equals("user")) {
                signInPage.login(ConfigReader.getProperty(role + "Role"),
                        ConfigReader.getProperty(role + "Password"));
            } else {
                signInPage.login(Container.registrant.getLogin(),
                        Container.registrant.getPassword());
            }
        }

        switch (page) {
            case "Manage Accounts":
                mainPage.myOperations.click();
                mainPage.manageAccounts.click();
                break;
            case "Manage Customers":
                mainPage.myOperations.click();
                mainPage.manageCustomers.click();
                break;
            case "My Accounts":
                mainPage.myOperations.click();
                mainPage.myAccounts.click();
                break;
            case "Password":
                mainPage.accountMenu.click();
                mainPage.password.click();
                break;
            case "Register":
                mainPage.accountMenu.click();
                mainPage.register.click();
                break;
            case "Transfer Money":
                mainPage.myOperations.click();
                mainPage.transferMoney.click();
                break;
            case "User Management":
                mainPage.administration.click();
                mainPage.userManagement.click();
                break;
            case "User Info":
                mainPage.accountMenu.click();
                mainPage.userInfo.click();
                break;
            case "Sign in":
                mainPage.accountMenu.click();
                mainPage.signIn.click();
                break;
        }
    }

    @Given("Sign Out")
    public void sign_out() {
        mainPage.accountMenu.click();
        mainPage.signOut.click();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("logout"));
    }

    @And("login with {string} and {string}")
    public void enter_credentials(String user, String pwd) {
        signInPage = new SignInPage();
        signInPage.login(user, pwd);
        Assert.assertTrue(mainPage.myOperations.isDisplayed());
    }


    @Given("do login with {string} and {string}")
    public void do_login_with_and(String user, String pwd) {
        signInPage = new SignInPage();
        signInPage.login(user, pwd);
    }

    @Given("verify if there is an error message")
    public void verify_if_there_is_an_error_message() {
        Assert.assertTrue(signInPage.errorMessage.isDisplayed());
    }


    @Given("navigate to {string} page")
    public void navigate_to_page(String page) {
        switch (page) {
            case "registration" :
                signInPage.registerLink.click();
                break;

            case "forgetPassword" :
                signInPage.forgetPassword.click();
                break;
        }
    }

    @Given("verify if it reaches to the {string} page")
    public void verify_if_it_reaches_to_the_page(String page) throws InterruptedException {
        RegisterPage registerPage = new RegisterPage();
        PasswordPage passwordPage = new PasswordPage();

        switch (page) {
            case "registration" :
                Assert.assertTrue(registerPage.registerTitle.isDisplayed());
                break;

            case "forgetPassword" :
                Assert.assertTrue(passwordPage.resetTitle.isDisplayed());
                break;
        }
    }


    @Then("close the application")
    public void close_the_application() {
        Driver.closeDriver();
    }

}
