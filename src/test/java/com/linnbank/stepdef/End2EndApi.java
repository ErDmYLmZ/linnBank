package com.linnbank.stepdef;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.linnbank.pojos.Container;
import com.linnbank.pojos.Registrant;
import com.linnbank.utilities.ReusableMethods;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class End2EndApi {
    Response response;
    Registrant registrant = new Registrant();
    String bearerToken = ReusableMethods.getToken();

    @Then("register with api")
    public void test1() throws JsonProcessingException {
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
                .contentType(ContentType.JSON)
                .extract()
                .response();


    }
}
