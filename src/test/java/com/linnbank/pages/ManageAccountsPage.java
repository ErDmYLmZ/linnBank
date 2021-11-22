package com.linnbank.pages;

import com.linnbank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageAccountsPage {
    public ManageAccountsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "tp-account-description")
    public WebElement descriptionTextBox;

    @FindBy(id = "tp-account-balance" )
    public WebElement balanceTextBox;

    @FindBy(id="tp-account-accountType")
    public WebElement accountTypeDropDown;

    @FindBy(id="tp-account-accountStatusType")
    public WebElement accountStatusDropDown;

    @FindBy(name="createDate")
    public WebElement createDate;

    @FindBy(name="closedDate")
    public WebElement closeDate;

    @FindBy(id="tp-account-employee")
    public WebElement employeeSelectionDropDown;

    @FindBy(id="cancel-save")
    public WebElement backButton;

    @FindBy(id="save-entity")
    public WebElement saveButton;


}
