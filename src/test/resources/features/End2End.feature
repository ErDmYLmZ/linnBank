Feature: End2End
  Background:

  @regression
  Scenario: Register with valid fields 1
    Given "unregistered" is on the "Register" page
    And Enter "valid" "ssn"
    And Enter "valid" "firstname"
    And Enter "valid" "lastname"
    And Enter "valid" "address"
    And Enter "valid" "mobilephone"
    And Enter "valid" "username"
    And Enter "valid" "email"
    And Enter "valid" "firstPassword"
    And Enter "valid" "secondPassword"
    Then Click on register
    And verify registered "successfully"

  Scenario: admin activates user
    Given "admin" is on the "User Management" page
    And Sign Out
  @regression
  Scenario: Register with valid fields 1
    Given "unregistered" is on the "Register" page
    And Enter "valid" "ssn"
    And Enter "valid" "firstname"
    And Enter "valid" "lastname"
    And Enter "valid" "address"
    And Enter "valid" "mobilephone"
    And Enter "valid" "username"
    And Enter "valid" "email"
    And Enter "valid" "firstPassword"
    And Enter "valid" "secondPassword"
    Then Click on register
    And verify registered "successfully"

  Scenario: Verify that user has been created on database
    Given User is connected to database
    When verify that user has "registered" on application

  Scenario: admin activates user
    Given "admin" is on the "User Management" page
    And activate "user"
    And Sign Out

  Scenario: Verify that user has been activated on database
    Given User is connected to database
    When verify that user has "activated" on application

  Scenario: Add customer
    Given "employee" is on the "Manage Customers" page
    Then user creates a customer
    And user search SSN,
    And user enter middleInitial, zipcode, city, country,
    And employee chooses two accounts from account section 1 and 5
    When employee clicks on Save button
    And Sign Out

  Scenario: Verify that user has been assigned on database
    Given User is connected to database
    When verify that user has "assigned" on application

  Scenario: Transfer Money
    Given "user" is on the "My Accounts" page
    And retrieve account data
    Then Sign Out
    Given "user" is on the "Transfer Money" page
    And customer choose first account to transfer money from
    And customer choose second account to transfer money to
    And customer enters the transaction amount
    And customer enters the description
    And customer clicks on make transfer button
    Then customer verify the success message
    Then close the application




  