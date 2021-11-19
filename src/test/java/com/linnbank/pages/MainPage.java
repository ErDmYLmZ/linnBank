package com.linnbank.pages;

import com.linnbank.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
