package com.linnbank.stepdef;

import com.linnbank.utilities.ConfigReader;
import com.linnbank.utilities.DatabaseUtility;
import com.linnbank.utilities.ReadTxt;
import com.linnbank.utilities.WriteToTxt;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class DbTestingSteps {
    List<Object>customerSSNIDs;
    String fileName = ConfigReader.getProperty("customerdb");

    @Given("user creates a connection with db using {string} , {string} and {string}")
        public void user_creates_a_connection_with_db_using_and(String url, String username, String password) {
            DatabaseUtility.createConnection(url,username,password);
        }

    @Given("user sends their query to db and gets related data {string} and {string}")
    public void user_sends_their_query_to_db_and_gets_related_data_and(String query, String column) {
    customerSSNIDs = DatabaseUtility.getColumnData(query, column);
        System.out.println(customerSSNIDs);
    }
    @Given("user sets DB data into correspondent files")
    public void user_sets_db_data_into_correspondent_files() {
        WriteToTxt.saveAllCustomersComingFromDB(fileName, customerSSNIDs);

    }
    @Then("user validates db data using records")
    public void user_validates_db_data_using_records() {
        List<String>actualSSNIDs = ReadTxt.returnCustomerSNNList(fileName);

        List<String>expectedSSNIDs = new ArrayList<>();
        expectedSSNIDs.add("355-88-2318");
        expectedSSNIDs.add("821-84-3971");

        Assert.assertTrue(actualSSNIDs.containsAll(expectedSSNIDs),"The data does not match");

    }
}
