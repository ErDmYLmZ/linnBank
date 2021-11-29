Feature: End2End

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
    And activate "user"

  Scenario: Add customer
    Given "employee" is on the "Manage Customers" page
    Then user creates a customer
    And user search SSN,
    And user enter middleInitial, zipcode, city, country,
    And employee chooses two accounts from account section 1 and 5
    And employee clicks on Save button
