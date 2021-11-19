package com.linnbank.pages;

import com.linnbank.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class TransferMoneyPage {

    public TransferMoneyPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
