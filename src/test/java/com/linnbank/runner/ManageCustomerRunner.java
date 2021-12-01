package com.linnbank.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "/Users/erdem/IdeaProjects/linn_bank/src/test/resources/features",
        glue = {"stepdef"},
        tags = "@manage_account_Test",
        dryRun = false,
        monochrome = true
)

public class ManageCustomerRunner {
}
