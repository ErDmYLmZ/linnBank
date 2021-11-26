Feature: US001 Registration

  Background:
    Given "unregistered" is on the "Register" page

  @register
  Scenario: Register with valid fields
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
    And delete registrant






