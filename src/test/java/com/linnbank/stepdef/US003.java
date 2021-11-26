package com.linnbank.stepdef;

import com.linnbank.pages.RegisterPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US003 {
    RegisterPage registerPage = new RegisterPage();
    @When("User fills all required fields correctly")
    public void user_fills_all_required_fields_correctly() {

    }
    @When("Click on New Password textbox")
    public void click_on_new_password_textbox() {
        registerPage.firstPasswordInput.click();
    }
    @When("Enter {string} password")
    public void enter_password(String string) {
        registerPage.firstPasswordInput.sendKeys(string);
    }
    @When("Click on New Password confirmation")
    public void click_on_new_password_confirmation() {
        registerPage.secondPasswordInput.click();
    }
    @When("Enter the same {string} to verify")
    public void enter_the_same_password_to_verify(String string) {
        registerPage.secondPasswordInput.sendKeys(string);
    }
    @Then("User should see the chart level at the strongest {string}")
    public void user_should_not_see_the_chart_level_at_the_strongest(String result) {
        if (result.equals("unsuccessfully")) {
            Assert.assertTrue(registerPage.strengthBarList.stream().noneMatch(t -> t.getAttribute("style").contains("rgb(0, 255, 0)")));
        }else {
            Assert.assertTrue(registerPage.strengthBarList.stream().allMatch(t -> t.getAttribute("style").contains("rgb(0, 255, 0)")));
        }
    }
}
