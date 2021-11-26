package com.linnbank.stepdef;

import com.linnbank.pages.UserManagementPage;
import com.linnbank.utilities.ReusableMethods;
import org.junit.Test;

public class UserManagement {
    static UserManagementPage userManagementPage = new UserManagementPage();

    @Test
    public void test() {

        US004_SignIn.user_is_on_the_page("admin", "User Management");
        userManagementPage.allPages.get(userManagementPage.allPages.size()-1).click();
        ReusableMethods.waitForVisibility(userManagementPage.allUsers.get(0),10);
        userManagementPage.allUsers.stream().forEach(x-> System.out.println(x.getText()));
        ReusableMethods.waitForClickablility(userManagementPage.deleteActions.get(userManagementPage.deleteActions.size()-1),10).click();
    }
}
