package com.linnbank.pages;

import com.linnbank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyAccountsPage {
    public MyAccountsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//table/tbody/tr/td[1]")
    public List<WebElement> allAccountsId;

    @FindBy(xpath = "//table/tbody/tr/td[3]")
    public List<WebElement> allAccountsBalance;

    @FindBy(xpath = "//table/tbody/tr/td[4]/button")
    public List<WebElement> allAccountsViewTransaction;

    @FindBy(xpath = "(//table)[2]")
    public WebElement transactionTable;

    @FindBy(xpath = "//button[@class='btn btn-success btn-sm']")
    public List<WebElement> viewTransaction;

    @FindBy(xpath = "(//th)[2]")
    public WebElement accountBalance;

}