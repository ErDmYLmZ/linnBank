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

public class US004 {

    MainPage mainPage;
    SignInPage signInPage;

    @Given("{string} is on the {string} page")
    public void user_is_on_the_page(String role, String page) {
        Driver.getDriver().get(ConfigReader.getProperty("gmibank_login_url"));
        mainPage = new MainPage();
        switch (page) {
            case "Main":
                break;
            case "Manage Accounts":
                break;
            case "Manage Customers":
                break;
            case "My Accounts":
                break;
            case "Password":
                break;
            case "Register":
                break;
            case "Sign In":
                mainPage.accountMenu.click();
                mainPage.signIn.click();
                break;
            case "Transfer Money":
                break;
            case "User Management":
                break;
            case "User Settings":
                break;
        }
    }

    @And("login with {string} and {string}")
    public void enter_credentials(String user, String pwd) {
        signInPage = new SignInPage();
        signInPage.login(user, pwd);
        Assert.assertTrue(mainPage.myOperations.isDisplayed());
    }

    @Then("close the application")
    public void close_the_application() {
        Driver.getDriver().close();
    }

}
