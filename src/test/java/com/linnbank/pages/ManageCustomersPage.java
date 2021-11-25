package com.linnbank.pages;

import com.linnbank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ManageCustomersPage {
    public ManageCustomersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="tp-customer-heading")
    public WebElement PageHeading;

    @FindBy(id="jh-create-entity")
    public WebElement createNewCustomerButton;

    @FindBy(xpath="//table/tbody/tr/td[1]/a ")
    public List<WebElement> allIDColumn;

    @FindBy(xpath="//table/tbody/tr/td[2]")
    public List<WebElement> allFirstNameColumn;

    @FindBy(xpath="//table/tbody/tr/td[3]")
    public List<WebElement> allLastNameColumn;

    @FindBy(xpath="//table/tbody/tr/td[4]")
    public List<WebElement> allMiddleInitialColumn;

    @FindBy(xpath="//table/tbody/tr/td[5]")
    public List<WebElement> allEmailColumn;

    @FindBy(xpath="//table/tbody/tr/td[6]")
    public List<WebElement> allMobilePhoneNumberColumn;

    @FindBy(xpath="//table/tbody/tr/td[7]")
    public List<WebElement> allPhoneNumberColumn;

    @FindBy(xpath="//table/tbody/tr/td[8]")
    public List<WebElement> allAddressColumn;

    @FindBy(xpath="//span[text()='View']")
    public List<WebElement> allViewButton;

    @FindBy(xpath="//span[text()='Edit']")
    public List<WebElement> allEditButton;

    @FindBy(xpath="//span[text()='Delete']")
    public List<WebElement> allDeleteButton;

    @FindBy(linkText="««")
    public WebElement paginationFirstPage;

    @FindBy(linkText="»»")
    public WebElement paginationLastPage;

    @FindBy(xpath="//a[@aria-label='Next']")
    public WebElement paginationNextPage;

    @FindBy(xpath="//a[@aria-label='Previous']")
    public WebElement paginationPreviousPage;

    @FindBy(id = "gmibankfrontendApp.tPCustomer.home.createOrEditLabel")
    public WebElement createOrEditACustomerHeading;

    @FindBy(xpath = "//div[@class='invalid-feedback']")
    public WebElement thisFieldIsRequiredMessage;

    @FindBy(id = "search-ssn")
    public WebElement ssnSearchField;

    @FindBy(xpath = "//button[contains(text(),'Search')]")
    public WebElement searchButton;

    @FindBy(id = "tp-customer-firstName")
    public WebElement firstName;

    @FindBy(id = "tp-customer-lastName")
    public WebElement lastName;

    @FindBy(id = "tp-customer-middleInitial")
    public WebElement middleInitial;

    @FindBy(id = "tp-customer-email")
    public WebElement email;

    @FindBy(id = "tp-customer-mobilePhoneNumber")
    public WebElement mobilePhoneNumber;

    @FindBy(id = "tp-customer-phoneNumber")
    public WebElement phoneNumber;

    @FindBy(id = "tp-customer-zipCode")
    public WebElement zipCode;

    @FindBy(id = "tp-customer-address")
    public WebElement adress;

    @FindBy(id = "tp-customer-city")
    public WebElement city;

    @FindBy(id = "tp-customer-ssn")
    public WebElement ssn;

    @FindBy(id = "tp-customer-createDate")
    public WebElement createDate;

    @FindBy(id = "tp-customer-country")
    public WebElement countryDropdown;

    @FindBy(id = "tp-customer-state")
    public WebElement state;

    @FindBy(id = "tp-customer-user")
    public WebElement userDropdown;

    @FindBy(id = "tp-customer-account")
    public WebElement account;

    @FindBy(id = "tp-customer-zelleEnrolled")
    public WebElement zelleEnrolledCheckbox;

    @FindBy(id = "save-entity")
    public WebElement saveButton;
}
