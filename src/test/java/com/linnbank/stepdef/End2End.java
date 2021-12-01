package com.linnbank.stepdef;

import com.github.javafaker.Faker;
import com.linnbank.pages.ManageCustomersPage;
import com.linnbank.pojos.Container;
import com.linnbank.pojos.Registrant;
import com.linnbank.utilities.ConfigReader;
import com.linnbank.utilities.DatabaseUtility;
import com.linnbank.utilities.ReusableMethods;
import io.cucumber.java.en.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.linnbank.utilities.ReadTxt.returnAWholeRegistrant;
import static io.restassured.RestAssured.given;

public class End2End {
    ManageCustomersPage manageCustomersPage = new ManageCustomersPage();
    Faker faker = new Faker();

    @Then("user creates a customer")
    public void user_creates_a_customer() {
        manageCustomersPage.createNewCustomerButton.click();
    }

    @And("user search SSN,")
    public void userSearchSSN() {
//        List<Registrant> registrants = returnAWholeRegistrant("src/test/resources/testdata/Registrant.txt");
//        String ssn = registrants.stream().reduce((a,b)->b).get().getSsn();
        manageCustomersPage.ssnSearchField.sendKeys(Container.registrant.getSsn());
        manageCustomersPage.searchButton.click();
    }

    @And("user enter middleInitial, zipcode, city, country,")
    public void userEnterMiddleInitialZipcodeCityCountry() {
        ReusableMethods.clearAndSendText(manageCustomersPage.middleInitial, "A");
        ReusableMethods.clearAndSendText(manageCustomersPage.zipCode, faker.address().zipCode());
        ReusableMethods.clearAndSendText(manageCustomersPage.city, faker.address().city());
        Select select = new Select(manageCustomersPage.countryDropdown);
        select.selectByIndex(5);
        ReusableMethods.clearAndSendText(manageCustomersPage.phoneNumber, manageCustomersPage.mobilePhoneNumber.getAttribute("value"));
    }


//Response response;
//    String bearerToken = ConfigReader.getProperty("api_bearer_token");
//
//    @Given("user sets all response using api end point {string}")
//    public void user_sets_all_response_using_api_end_point(String url) {
//
//
//        response = given().headers(
//                        "Authorization",
//                        "Bearer " + bearerToken,
//                        "Content-Type",
//                        ContentType.JSON,
//                        "Accept",
//                        ContentType.JSON)
//                .when()
//                .get(url)
//                .then()
//                .contentType(ContentType.JSON)
//                .extract()
//                .response();
//
//        response.prettyPrint();
//
//    }

    @Given("User is connected to database")
    public void user_is_connected_to_database() {
        DatabaseUtility.createConnection();
    }
    @When("verify that user has {string} on application")
    public void verify_that_user_has_on_application(String string) throws Exception {
        switch (string){
            case "registered":
                String Q1 = "SELECT * FROM  jhi_user WHERE login = '"+ Container.registrant.getUserName()+"' AND activated = false";
                Long userId = (Long) (DatabaseUtility.getQueryResultList((Q1)).get(0).get(0));
                Container.registrant.setUserId(userId);
                break;
            case "activated":
                String Q2 = "SELECT * FROM  jhi_user WHERE login = '"+ Container.registrant.getUserName()+"' AND activated = true";
                DatabaseUtility.executeQuery(Q2);
                break;
            case "assigned":
                String Q3 = "SELECT * FROM  tp_customer WHERE user_id = "+ Container.registrant.getUserId();
                Long customerId = (Long) (DatabaseUtility.getQueryResultList((Q3)).get(0).get(0));
                Container.registrant.setCustomerId(customerId);
                break;
        }
        Assert.assertTrue(DatabaseUtility.getRowCount() > 0);

    }
}
