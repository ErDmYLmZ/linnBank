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

    @Then("verify user creation date is correct")
    public void verify_user_creation_date_is_correct() {
        Faker faker = new Faker();

        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String date = simpleDateFormat.format(faker.date().birthday(18, 79));
        System.out.println(date);

    }


    public static void main(String[] args) {
//    Faker faker = new Faker();
//
//    String pattern = "dd/MM/yyyy HH:mm a";
//    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//
//    String date = simpleDateFormat.format(faker.date());
//    System.out.println(date);
//        System.out.println(getCurrentDateFuture(-50));
        DateUtil dateUtil = new DateUtil();
//        System.out.println("DateUtil.getManipulatedDate(100,-5,-10) = " + DateUtil.getManipulatedDate(100, -5, -10));
        System.out.println( getManipulatedDate(12, -22));
        System.out.println("getManipulatedDate() = " + getManipulatedDate(1000,-7000));
//        System.out.println("DateUtil.getManipulatedDate(0,0,0) = " + DateUtil.getManipulatedDate(0, 0, 0));
//        System.out.println(date());
    }

    public static String getManipulatedDate(int minutes, int hours) {
        LocalDateTime curentDateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a");
        return dtf.format(curentDateTime.plusHours(hours).plusMinutes(minutes));


    }


    public static String date() {
        LocalDateTime curentDateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        return dtf.format(curentDateTime);
    }

//    public static String getCurrentTimeAsString(){
//      return null;
//    }
}
