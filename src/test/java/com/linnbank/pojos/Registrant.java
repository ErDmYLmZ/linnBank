package com.linnbank.pojos;

import com.github.javafaker.Faker;

public class Registrant {


    private String ssn;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String userName;
    private String email;
    private String password;

    private static final Faker faker = new Faker();

    public Registrant(){
        this.ssn = faker.idNumber().ssnValid();
        this.address = faker.address().fullAddress();
        this.email = faker.internet().emailAddress();
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.password = faker.internet().password();
        this.phoneNumber = faker.phoneNumber().phoneNumber();
        this.userName = faker.name().username();
        this.password = faker.internet().password(7,12,true,true,true);
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
