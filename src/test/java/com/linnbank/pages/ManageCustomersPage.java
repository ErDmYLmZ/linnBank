package com.linnbank.pages;

import com.linnbank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageCustomersPage {
    public ManageCustomersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="tp-customer-heading")
    public WebElement PageHeading;

    @FindBy(id="jh-create-entity")
    public WebElement createNewCustomerButton;

    @FindBy(xpath="//table/tbody/tr/td[1]/a ")
    public WebElement allIDColumn;

    @FindBy(xpath="//table/tbody/tr/td[2]")
    public WebElement allFirstNameColumn;

    @FindBy(xpath="//table/tbody/tr/td[3]")
    public WebElement allLastNameColumn;

    @FindBy(xpath="//table/tbody/tr/td[4]")
    public WebElement allMiddleInitialColumn;

    @FindBy(xpath="//table/tbody/tr/td[5]")
    public WebElement allEmailColumn;

    @FindBy(xpath="//table/tbody/tr/td[6]")
    public WebElement allMobilePhoneNumberColumn;

    @FindBy(xpath="//table/tbody/tr/td[7]")
    public WebElement allPhoneNumberColumn;

    @FindBy(xpath="//table/tbody/tr/td[8]")
    public WebElement allAddressColumn;

    @FindBy(xpath="//span[text()='View']")
    public WebElement allViewButton;

    @FindBy(xpath="//span[text()='Edit']")
    public WebElement allEditButton;

    @FindBy(xpath="//span[text()='Delete']")
    public WebElement allDeleteButton;

    @FindBy(xpath="(//nav/ul/li)[1]")
    public WebElement paginationFirstPage;

    @FindBy(xpath="(//nav/ul/li)[8]")
    public WebElement paginationLastPage;

    @FindBy(xpath="(//nav/ul/li)[7]")
    public WebElement paginationNextPage;

    @FindBy(xpath="(//nav/ul/li)[2]")
    public WebElement paginationPreviousPage;
}
