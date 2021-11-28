package com.linnbank.pages;

import com.linnbank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferMoneyPage {
    public TransferMoneyPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name="fromAccountId")
    public WebElement fromAccountDropdown;

    @FindBy(name="toAccountId")
    public WebElement toAccountDropdown;

    @FindBy(name="balance")
    public WebElement amount;

    @FindBy(name="balancecent")
    public WebElement amountDecimal;

    @FindBy(xpath="//textarea[contains(@class, 'is-pristine')]")
    public WebElement description;

    @FindBy(id="make-transfer")
    public WebElement makeTransfer;

    @FindBy(xpath="//*[contains(@class,'Toastify__toast-body')]")
    public WebElement popupMessage;
}
