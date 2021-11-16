package com.linnbank.stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;
import utilities.ReusableMethods;


import java.io.IOException;

public class Hooks {
/*
    hooks has Before and After annotations it runs before and after each Scenario
    In cucumber hooks we use reports and we take screenshots
    I designed my hooks as it takes screenshot when a test scenario fails.
*/

    @Before
    public void setUp(){

    }

    @After
    public void tearDown(Scenario scenario) throws IOException {

//        final byte[] screenshot =  ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
//
//        if(scenario.isFailed()){
//            String failed = ReusableMethods.getScreenshot("failed screenshot");
//            scenario.attach(screenshot, "image/png", "screenshot");
//        }
//        Driver.closeDriver();

    }

}
