package com.linnbank.pages;


import com.linnbank.utilities.Driver;
import org.openqa.selenium.By;
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

    @FindBy(xpath = "//span[text()='Register']")
    public WebElement register;

    @FindBy(xpath = "//span[text()='Manage Customers']")
    public WebElement manageCustomers;

    @FindBy(xpath = "//span[text()='Manage Accounts']")
    public WebElement manageAccounts;

    @FindBy(linkText = "My Accounts")
    public WebElement myAccounts;

    @FindBy(linkText = "Transfer Money")
    public WebElement transferMoney;

    @FindBy(xpath = "//span[text()='Password']")
    public WebElement password;

    @FindBy(xpath = "//span[text()='Administration']")
    public WebElement administration;

    @FindBy(xpath = "//span[text()='User management']")
    public WebElement userManagement;

    @FindBy(xpath = "//span[text()='User Info']")
    public WebElement userInfo;

    @FindBy(xpath = "//span[text()='Sign out']")
    public WebElement signOut;

    public By bySuccessMessage = By.xpath("//div[contains(@class, 'toast--success')]");

}

