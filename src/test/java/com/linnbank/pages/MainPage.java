package com.linnbank.pages;


import com.linnbank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public MainPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "entity-menu")
    public WebElement myOperations;

    @FindBy(id = "account-menu")
    public WebElement accountMenu;

    @FindBy(id = "login-item")
    public WebElement signIn;

    @FindBy(css = "//span[text()='Register']")
    public WebElement register;

}
