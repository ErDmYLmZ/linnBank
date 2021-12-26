package com.linnbank.stepdef;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.linnbank.pojos.Account;
import com.linnbank.pojos.Container;
import com.linnbank.pojos.Registrant;
import com.linnbank.utilities.ReusableMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class End2EndApi {
    Response response;
    Registrant registrant = new Registrant();
    String bearerToken = ReusableMethods.getToken();
    Account account = new Account();

    @Then("register with api")
    public void registerWithAPI() throws JsonProcessingException {
        Container.registrant = registrant;
        ObjectMapper mapper = new ObjectMapper();
        String reqBody = mapper.writeValueAsString(registrant);

        response = given().headers(
                        "Authorization",
                        "Bearer " + bearerToken,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when().body(reqBody)
                .post("https://gmibank.com/api/register")
                .then()
//                .contentType(ContentType.JSON)
                .extract()
                .response();
       // Assert.assertTrue(response.getStatusCode()==201);
    }

    //Erdem
    @Given("{string} is on the {string} page with api")
    public void is_on_the_page_with_api(String user, String myAccounts) throws IOException {

            String userId="105043"; // Container.
            response = given().headers(
                            "Authorization",
                            "Bearer " + "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJjdXN0b21lcjZ0aGdlbiIsImF1dGgiOiJST0xFX0NVU1RPTUVSIiwiZXhwIjoxNjQwMDkyNTI5fQ.cPX_O5rwUA8SZuYfRaAvAKlGlKoi1c7M60k1ngW_7R93eNL-kP3IKLW7GWdbJ7VvOm84-uNkN_NWgbO-ORJvmg", //bearerToken,
                            "Content-Type",
                            ContentType.JSON,
                            "Accept",
                            ContentType.JSON)
                    .when()
                    .get("https://www.gmibank.com/api/tp-customers/accounts/"+userId)
                    .then()
                    .contentType(ContentType.JSON)
                    .extract()
                    .response();

         ObjectMapper mapper = new ObjectMapper();
         Account[] account;
         account =mapper.readValue(response.asString(), Account[].class);
            response.prettyPrint();

        System.out.println(Arrays.asList(account));
       // Assert.assertTrue(response.asString().contains("105045"));
    }
    @Given("retrieve account data with api")
    public void retrieve_account_data_with_api() {

    }
    @Then("Sign Out with api")
    public void sign_out_with_api() {

    }
}
