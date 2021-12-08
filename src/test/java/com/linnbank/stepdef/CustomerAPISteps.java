package com.linnbank.stepdef;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.linnbank.pojos.Customer;
import com.linnbank.utilities.ConfigReader;
import com.linnbank.utilities.ReadTxt;
import com.linnbank.utilities.ReusableMethods;
import com.linnbank.utilities.WriteToTxt;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class CustomerAPISteps {
    Response response;
    String bearerToken = ReusableMethods.getToken();
    Customer[] customers;
    String fileName = ConfigReader.getProperty("fileNameOfCustomerSSN");

    @Given("user uses api end point {string} to get all customer data")
    public void user_uses_api_end_point_to_get_all_customer_data(String url) {
        response= given().headers(
                        "Authorization",
                        "Bearer "+ bearerToken,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when()
                .get(url)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
    }


    @Given("user should get all customer data and deserialize the data to java")
    public void user_should_get_all_customer_data_and_deserialize_the_data_to_java() throws Exception {
        ObjectMapper obj = new ObjectMapper();
        customers = obj.readValue(response.asString(), Customer[].class);

        for(int i = 0; i<customers.length; i++){
            if (customers[i].getCountry() != null)
                System.out.println(customers[i].getCountry().getName());

            if (customers[i].getUser() != null){
                System.out.println(customers[i].getUser().getFirstName());
            }
        }

    }
    @Given("user saves the customer data to correspondent files")
    public void user_saves_the_customer_data_to_correspondent_files() {
        WriteToTxt.saveDataInFileWithSSN(fileName, customers);

    }
    @Then("user needs to validate all customer api data")
    public void user_needs_to_validate_all_customer_api_data() {
        List<String> expectedSSNIds = new ArrayList<>();
        expectedSSNIds.add("092-73-5245");

        List<String> actualSSNIds = ReadTxt.returnCustomerSNNList(fileName);
        Assert.assertTrue("All SSn IDs are not matching",actualSSNIds.containsAll(expectedSSNIds));
    }
}