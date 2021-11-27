package com.linnbank.pages;

import com.linnbank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserManagementPage {
    public UserManagementPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@class='page-item']")
    public List<WebElement> allPages;

    @FindBy(xpath = "//table/tbody/tr/td[2]")
    public List<WebElement> allUsers;

    @FindBy(xpath = "//table/tbody/tr/td[4]/button")
    public List<WebElement> allActivations;

    @FindBy(xpath = "//span[text()='Delete']")
    public List<WebElement> deleteActions;

}
