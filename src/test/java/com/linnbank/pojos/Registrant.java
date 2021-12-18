package com.linnbank.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.javafaker.Faker;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Registrant {

    private String ssn;
    private String firstName;
    private String lastName;
    private String address;
    private String mobilePhoneNumber;
    private String login;
    private String email;
    private String password;
    private Long userId;
    private Long customerId;
    private String langKey;

    private static final Faker faker = new Faker();

    public Registrant(){
        this.ssn = faker.idNumber().ssnValid();
        this.address = faker.address().fullAddress();
        this.email = faker.internet().emailAddress();
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.password = faker.internet().password()+"!";
        this.mobilePhoneNumber = faker.phoneNumber().phoneNumber();
        this.login = faker.name().username();
        this.password = faker.internet().password(8,12,true,true,true).replaceAll("@","!")+"!";
        this.langKey = "en";
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

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
    @JsonIgnore
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    @JsonIgnore
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getLangKey() {
        return langKey;
    }

    public void setLangKey(String langKey) {
        this.langKey = langKey;
    }
}
