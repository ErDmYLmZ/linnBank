package com.linnbank.pages;

import com.linnbank.pojos.Container;
import com.linnbank.utilities.Driver;
import com.linnbank.utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.WebStorage;
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

    @FindBy(xpath = "//div[@class='alert alert-danger fade show']")
    public WebElement errorMessage;

    @FindBy(linkText = "Register a new account")
    public WebElement registerLink;

    @FindBy(linkText = "Did you forget your password?")
    public WebElement forgetPassword;

    public void login(String user, String pwd) {
        username.sendKeys(user);
        password.sendKeys(pwd);
        submit.click();
        ReusableMethods.waitFor(1);
        WebStorage webStorage = (WebStorage) Driver.getDriver();
        Container.bearerToken = webStorage.getSessionStorage().getItem("jhi-authenticationToken").replaceAll("\"","");
//        ReusableMethods.waitForClickablility(submit,20).click();
    }
}
