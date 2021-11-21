package com.linnbank.pages;

import com.linnbank.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    public SignInPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
