package com.linnbank.pages;

import com.linnbank.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class UserSettingsPage {
    public UserSettingsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
