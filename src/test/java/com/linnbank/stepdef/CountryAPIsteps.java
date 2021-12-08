package com.linnbank.stepdef;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.linnbank.pojos.Country;
import com.linnbank.utilities.ReusableMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CountryAPIsteps {
    Response response;
    String bearerToken = ReusableMethods.getToken();
    Country[] countries;


    @Given("user sets the response using api end point {string} and creates country using {string} and {string}")
    public void user_sets_the_response_using_api_end_point_and_creates_country_using_and(String url, String type, String country) {

        Map<String, Object > data = new HashMap<>();
        data.put(type,country);


        response = given().headers("Authorization",
                        "Bearer "+bearerToken,
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON).
                when().body(data).
                post(url).
                then().
                contentType(ContentType.JSON).
                extract().
                response();
    }


    @Given("user sets the countries to response using {string}")
    public void user_sets_the_countries_to_response_using(String url) {
        response= given().headers("Authorization",
                        "Bearer "+bearerToken,
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON).
                when().
                get(url).
                then().
                contentType(ContentType.JSON).
                extract().
                response();
    }

    @Given("user saves the countries to correspondent files")
    public void user_saves_the_countries_to_correspondent_files() throws Exception {
        response.prettyPrint();
        ObjectMapper obj = new ObjectMapper();
        countries = obj.readValue(response.asString(), Country[].class);
        System.out.println(countries[0].getName());
    }


    @Then("user validates the countries")
    public void user_validates_the_countries() {

    }

    @Given("user deletes a country using endpoint {string} and its extension {string}")
    public void user_deletes_a_country_using_endpoint_and_its_extension(String endPoint, String id) {
        response =given().headers(
                        "Authorization",
                        "Bearer " + bearerToken,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when()
                .delete(endPoint+id)
                .then()
                .extract()
                .response();
    }

    @Given("user sees all logs {string}")
    public void user_sees_all_logs(String url) {
        response = given().headers(
                        "Authorization",
                        "Bearer " + bearerToken,
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
        response.prettyPrint();
    }

}