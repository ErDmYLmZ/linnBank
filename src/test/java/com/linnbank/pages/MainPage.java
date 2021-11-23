package com.linnbank.pages;


import com.linnbank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public MainPage() {

        PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath = "(//a[@class='dropdown-toggle nav-link'])[2]")
    public WebElement signIn_registerDropdown;

    @FindBy(id="login-item")
    public WebElement logInButton;

    @FindBy(id="username")
    public WebElement usernameBox;

    @FindBy(id="password")
    public WebElement passwordBox;

    @FindBy(xpath ="//button[@type='submit']")
    public WebElement signInButton;

    @FindBy(id = "entity-menu")
    public WebElement myOperations;

    @FindBy(id = "account-menu")
    public WebElement accountMenu;

    @FindBy(id = "login-item")
    public WebElement signIn;

    @FindBy(css = "//span[text()='Register']")
    public WebElement register;


}
