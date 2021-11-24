package com.linnbank.stepdef;

import com.linnbank.pages.MainPage;
import com.linnbank.pages.SignInPage;
import com.linnbank.utilities.ConfigReader;
import com.linnbank.utilities.Driver;
import com.linnbank.utilities.ReusableMethods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class US004_SignIn {

    MainPage mainPage;
    SignInPage signInPage;

    @Given("{string} is on the {string} page")
    public void user_is_on_the_page(String role, String page) {
        Driver.getDriver().get(ConfigReader.getProperty("gmibank_login_url"));
        mainPage = new MainPage();
        signInPage = new SignInPage();

        // only registered user can be logged in
        if (!role.equals("unregistered")) {
            mainPage.accountMenu.click();
            signInPage.login(ConfigReader.getProperty(role + "Role"),
                    ConfigReader.getProperty(role + "Password"));
            mainPage.signIn.click();
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
        }
    }

    @Given("Sign Out")
    public void sign_out() {
        mainPage.accountMenu.click();
        mainPage.signOut.click();
    }

    @And("login with {string} and {string}")
    public void enter_credentials(String user, String pwd) {
        signInPage = new SignInPage();
        signInPage.login(user, pwd);
        Assert.assertTrue(mainPage.myOperations.isDisplayed());
    }

    @Then("close the application")
    public void close_the_application() {
        Driver.closeDriver();
    }

}
