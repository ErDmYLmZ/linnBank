package com.linnbank.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:reports/html-reports/default-cucumber-reports.html",
                "json:reports/json-reports/cucumber.json",
                "junit:reports/xml-report/cucumber.xml",
                "rerun:reports/failedRerun.txt",
//                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        features = "./src/test/resources/features",
        glue = "com/linnbank/stepdef",
        tags = "@regression",
        dryRun = true,
        monochrome = true
)
public class Runner {
      
}
