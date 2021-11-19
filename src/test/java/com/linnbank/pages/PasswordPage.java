package com.linnbank.pages;

import com.linnbank.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage {

    public PasswordPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
