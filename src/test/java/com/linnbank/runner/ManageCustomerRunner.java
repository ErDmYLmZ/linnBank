package com.linnbank.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/test/resources/features",
        glue = "stepdef",
        tags = "@login_test",
        dryRun = false,
        monochrome = true
)

public class ManageCustomerRunner {
}
