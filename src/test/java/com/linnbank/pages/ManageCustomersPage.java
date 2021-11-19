package com.linnbank.pages;

import com.linnbank.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class ManageCustomersPage {
    public ManageCustomersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
