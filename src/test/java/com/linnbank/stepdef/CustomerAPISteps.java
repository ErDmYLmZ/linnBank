//package com.linnbank.stepdef;
//
//import com.linnbank.utilities.ConfigReader;
//import io.cucumber.java.en.*;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//
//import static io.restassured.RestAssured.*;
//
//public class CustomerAPISteps {
//    Response response;
//    String bearerToken = ConfigReader.getProperty("api_bearer_token");
//    @Given("user uses api end point {string} to get all customer data")
//    public void user_uses_api_end_point_to_get_all_customer_data(String url) {
//
//        response = given().headers(
//                "Authorization",
//                "Bearer " + bearerToken,
//                "Content-Type",
//                ContentType.JSON,
//                "Accept",
//                ContentType.JSON)
//                .when()
//                .get(url)
//                .then()
//                .contentType(ContentType.JSON)
//                .extract()
//                .response();
//        response.prettyPrint();
//    }
//    @Given("user should get all customer data and deserialize the data to java")
//    public void user_should_get_all_customer_data_and_deserialize_the_data_to_java() {
//
//    }
//    @Given("user saves the customer data to correspondent files")
//    public void user_saves_the_customer_data_to_correspondent_files() {
//
//    }
//    @Then("user needs to validate all customer api data")
//    public void user_needs_to_validate_all_customer_api_data() {
//
//    }
//}
