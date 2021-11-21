package com.linnbank.pages;

import com.linnbank.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class MyAccountsPage {
    public MyAccountsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}