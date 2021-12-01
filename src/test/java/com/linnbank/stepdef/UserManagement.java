package com.linnbank.stepdef;

import com.linnbank.pages.UserManagementPage;
import com.linnbank.pojos.Container;
import com.linnbank.pojos.Registrant;
import com.linnbank.utilities.Driver;
import com.linnbank.utilities.JSUtils;
import com.linnbank.utilities.ReadTxt;
import com.linnbank.utilities.ReusableMethods;
import io.cucumber.java.en.And;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

import static com.linnbank.utilities.Driver.getDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class UserManagement {
    UserManagementPage userManagementPage = new UserManagementPage();

    @And("activate {string}")
    public void activeUserAs(String user) {

        if (user.equals("user")) {
            user=Container.registrant.getUserName();
            // get the latest registrant
//            List<Registrant> registrants = ReadTxt.returnAWholeRegistrant("src/test/resources/testdata/Registrant.txt");
//            user = registrants.stream().reduce((a,b)->b).get().getUserName();
        }

//        String oldUrl = getDriver().getCurrentUrl();
        userManagementPage.allPages.get(userManagementPage.allPages.size()-1).click();
//        WebDriverWait wait = new WebDriverWait(getDriver(),10);
//        wait.until(not(urlToBe(oldUrl)));
//        wait.until(ExpectedConditions.stalenessOf(userManagementPage.allUsers.get(userManagementPage.allUsers.size()-1);
        ReusableMethods.waitFor(2);
        //to find row index of username, we need to map List<WebElement> into WebElement.getText()
        int index = userManagementPage.allUsers.stream().map(WebElement::getText).collect(Collectors.toList()).indexOf(user);

        //since we scroll the button, click it.
        JSUtils.scrollIntoViewJS(userManagementPage.allActivations.get(index));
        userManagementPage.allActivations.get(index).click();
    }
}
