package com.linnbank.stepdef;

import com.github.javafaker.Faker;
import com.linnbank.utilities.DateUtil;
import com.linnbank.utilities.ReusableMethods;
import io.cucumber.java.en.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class US011_Date_Of_The_Customer_Creation {



    public static void main(String[] args) {

        System.out.println("DateUtil.getManipulatedDate(0,0) = " + DateUtil.getManipulatedDate(0, 0));
        System.out.println("DateUtil.getManipulatedDate(5,5,5) = " + DateUtil.getManipulatedDate(5, 5, 5));

    }


}

