package com.linnbank.stepdef;

import com.linnbank.pages.UserManagementPage;
import com.linnbank.pojos.Registrant;
import com.linnbank.utilities.JSUtils;
import com.linnbank.utilities.ReadTxt;
import com.linnbank.utilities.ReusableMethods;
import io.cucumber.java.en.And;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class UserManagement {
    static UserManagementPage userManagementPage = new UserManagementPage();

    @And("activate {string}")
    public void activeUserAs(String user) {

        if (user.equals("user")) {
            // get the latest registrant
            List<Registrant> registrants = ReadTxt.returnAWholeRegistrant("src/test/resources/testdata/Registrant.txt");
            user = registrants.stream().reduce((a,b)->b).get().getUserName();
        }

        // navigate "User Management" paga as "admin"
        US004_SignIn.user_is_on_the_page("admin", "User Management");
        userManagementPage.allPages.get(userManagementPage.allPages.size()-1).click();
        ReusableMethods.waitForVisibility(userManagementPage.allUsers.get(0),10);
        //to find row index of username, we need to map List<WebElement> into WebElement.getText()
        int index = userManagementPage.allUsers.stream().map(WebElement::getText).collect(Collectors.toList()).indexOf(user);

        //since we scroll the button, click it.
        JSUtils.scrollIntoViewJS(userManagementPage.allActivations.get(index));
        userManagementPage.allActivations.get(index).click();
    }
}
