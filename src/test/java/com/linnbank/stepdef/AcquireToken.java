//package com.linnbank.stepdef;
//
//import com.linnbank.utilities.ConfigReader;
//import com.linnbank.utilities.Driver;
//import io.restassured.http.ContentType;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import org.junit.Test;
//import org.openqa.selenium.WebDriver;
//
//import java.util.HashMap;
//
//import static io.restassured.RestAssured.*;
//
//public class AcquireToken {

//    public String getToken(){
//
//        String url= ConfigReader.getProperty("gmibank_api_login_url");
//    System.out.println(url);
//        HashMap<String,String> requestBody = new HashMap<String,String>();
//        requestBody.put("email","MarjoryChristiansen@gmail.com");
//        requestBody.put("password","A#Ip6A*06S1Gs&");
//        System.out.println(requestBody);
//        Response response = given().
//                contentType(ContentType.JSON).
//                body(requestBody).
//                when().
//                post(url);
//
//        response.prettyPrint();
//        JsonPath json=response.jsonPath();
//        String useToken=json.getString("token");
//        return useToken;
//    }
//}
