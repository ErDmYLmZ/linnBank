package com.linnbank.stepdef;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.linnbank.pages.ManageCustomersPage;
import com.linnbank.pages.SignInPage;
import com.linnbank.pojos.Container;
import com.linnbank.pojos.Country;
import com.linnbank.pojos.Customer;
import com.linnbank.pojos.Registrant;
import com.linnbank.utilities.*;
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
    Response response;
    Object[] responseData;


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

    @Given("User is connected to database")
    public void user_is_connected_to_database() {
        DatabaseUtility.createConnection();
    }

    @Given("user sets all response using api end point {string}")
    public void user_sets_all_response_using_api_end_point(String resource) {
        String base_url = ConfigReader.getProperty("api_base_url");
        System.out.println(Container.bearerToken);
        response = given().headers(
                        "Authorization",
                        "Bearer " + Container.bearerToken,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when()
                .get(base_url+resource)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

        response.prettyPrint();

    }

    @Given("user deserializes {string} data as json to java pojo")
    public void user_deserializes_data_as_json_to_java_pojo(String type) throws JsonProcessingException {
        ObjectMapper obj = new  ObjectMapper();

        switch (type){
            case "customer":
                responseData = obj.readValue(response.asString(), Customer[].class);
                for (Customer each:(Customer[]) responseData) {
                    if(each.getUser() != null)
                        System.out.println("id: "+ each.getUser().getFirstName());
                }
                break;
            case "country":
                responseData = obj.readValue(response.asString(), Country[].class);

                break;
        }



//        for(int i=0; i<responseData.length;i++ ){
//
//            if(responseData[i].getUser() != null)
//                System.out.println("id: "+ customers[i].getUser().getFirstName());
//        }
    }

    @Then("user validates the {string} data")
    public void user_validates_the_data(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
