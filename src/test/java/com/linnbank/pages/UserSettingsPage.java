package com.linnbank.pages;

import com.linnbank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserSettingsPage {
    public UserSettingsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

   @FindBy(id="firstName")
    public WebElement firstName;

    @FindBy(id="lastName")
    public WebElement lastName;

    @FindBy(id="email")
    public WebElement email;

    @FindBy(id="langKey")
    public WebElement LanguageDropDown;



}
