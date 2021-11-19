package com.linnbank.pages;

import com.linnbank.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class ManageAccountsPage {
    public ManageAccountsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
