package com.linnbank.pages;

import com.linnbank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterPage {

    public RegisterPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "ssn")
    public WebElement ssnInput;

    @FindBy(id = "firstname")
    public WebElement firstNameInput;

    @FindBy(id = "lastname")
    public WebElement lastNameInput;

    @FindBy(id = "address")
    public WebElement addressInput;

    @FindBy(id = "mobilephone")
    public WebElement phoneInput;

    @FindBy(id = "username")
    public WebElement usernameInput;

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(id = "firstPassword")
    public WebElement firstPasswordInput;

    @FindBy(id = "strengthBar")
    public WebElement passwordStrengthBar;

    @FindBy(id = "secondPassword")
    public WebElement secondPasswordInput;

    @FindBy(id = "register-submit")
    public WebElement submitRegisterButton;

    @FindBy(xpath = "//ul[@id='strengthBar']//li")
    public List<WebElement> strengthBarList;

    @FindAll
            ({
                    @FindBy(xpath = "//div[contains(@class, 'toast--error')]"),
                    @FindBy(xpath = "//div[contains(@class, 'toast--success')]")
            })
    public WebElement popupMessage;

//    @FindBy(xpath = "//div[contains(@class, 'toast--error')]")
//    public WebElement popupError;
//
//    @FindBy(xpath = "//div[contains(@class, 'toast--success')]")
//    public WebElement popupSuccess;

}
