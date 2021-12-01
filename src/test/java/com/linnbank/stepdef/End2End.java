package com.linnbank.stepdef;

import com.github.javafaker.Faker;
import com.linnbank.pages.ManageCustomersPage;
import com.linnbank.pojos.Container;
import com.linnbank.pojos.Registrant;
import com.linnbank.utilities.ConfigReader;
import com.linnbank.utilities.ReusableMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
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
}
