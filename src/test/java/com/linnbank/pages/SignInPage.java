package com.linnbank.pages;

import com.linnbank.utilities.Driver;
import com.linnbank.utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    public SignInPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(css = "button[type='submit']")
    public WebElement submit;

    public void login(String user, String pwd) {
        username.sendKeys(user);
        password.sendKeys(pwd);
        submit.click();
//        ReusableMethods.waitForClickablility(submit,20).click();
    }
}
