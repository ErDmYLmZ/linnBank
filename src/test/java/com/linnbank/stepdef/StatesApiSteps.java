package com.linnbank.stepdef;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.linnbank.pojos.States;
import com.linnbank.utilities.ReadTxt;
import com.linnbank.utilities.ReusableMethods;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class StatesApiSteps {

    Response response;
    States[] states;
    String bearerToken = ReusableMethods.getToken();

    @Given("user sets all states to response using {string}")
    public void user_sets_all_states_to_response_using(String url) {

        response =given().headers(
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

    @Given("user manipulates all states")
    public void user_manipulates_all_states() throws Exception{

        ObjectMapper obj = new ObjectMapper();

        states = obj.readValue(response.asString(), States[].class);

    }

    @Given("user saves the states to correspondent files")
    public void user_saves_the_states_to_correspondent_files() {

//        WriteToTxt.saveAllStates("AllStates.txt", states);
    }

//    @Then("user validates all states")
//    public void user_validates_all_states() {
//
//        ReadTxt.returnAllStates("AllStates.txt");
//        for (States states : states){
//            System.out.println(states.getId());
//        }
//    }

    @Given("user deletes a state using {string} and {string}")
    public void user_deletes_a_state_using_and(String url, String id) {

        response =given().headers(
                        "Authorization",
                        "Bearer " + bearerToken,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when()
                .delete(url+id)
                .then()
                .extract()
                .response();



    }

    @Given("user sets the response using api end point {string} and creates states using {string} and {string}")
    public void user_sets_the_response_using_api_end_point_and_creates_states_using_and(String endPoint, String id, String name) {

        response = given().headers(
                        "Authorization",
                        "Bearer " + bearerToken,
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

    @Given("user sets the response using api end point {string} and updates states using {string} and {string}")
    public void user_sets_the_response_using_api_end_point_and_updates_states_using_and(String endPoint, String id, String name) {
        response = given().headers(
                        "Authorization",
                        "Bearer " + bearerToken,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when().body("{\"id\": "+id+",\"name\": \""+name+"\"}")
                .put(endPoint)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
    }


}
