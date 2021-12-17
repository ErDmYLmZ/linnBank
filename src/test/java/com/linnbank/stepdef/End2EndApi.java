package com.linnbank.stepdef;

import com.linnbank.pojos.Container;
import com.linnbank.pojos.Registrant;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class End2EndApi {
    Response response;
    Registrant registrant = new Registrant();

    @Then("register with api")
    public void test1() {
        response = given().headers(
                        "Authorization",
                        "Bearer " + ,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when().body("{\"countryId\": "+id+",\"name\": \""+name+"\"}")
                .post(endPoint)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();


    }
}
