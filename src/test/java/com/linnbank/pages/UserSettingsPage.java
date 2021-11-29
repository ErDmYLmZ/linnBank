package com.linnbank.pages;

import com.linnbank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UserSettingsPage {
    public UserSettingsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id="account-menu")
    public WebElement signIn_Register;

    @FindBy(linkText = "Sign in")
    public WebElement SignIn_Dropdown;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;




    @FindBy(id="firstName")
    public WebElement firstName;

    @FindBy(id="lastName")
    public WebElement lastName;

    @FindBy(id="email")
    public WebElement email;

    @FindBy(id="langKey")
    public WebElement languageDropDown;


    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submit;





}
