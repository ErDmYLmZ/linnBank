package com.linnbank.pages;

import com.linnbank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage {
    public PasswordPage() {
    PageFactory.initElements(Driver.getDriver(), this);



}
    @FindBy (xpath = "//*[text()='Reset your password']")
    public WebElement resetTitle;

}
