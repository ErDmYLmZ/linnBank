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

    @Given("user is on the Sign in page")
    public void user_is_on_the_sign_in_page() {
        Driver.getDriver().get(ConfigReader.getProperty("gmibank_login_url"));
        mainPage = new MainPage();
        mainPage.accountMenu.click();
        mainPage.signIn.click();
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
