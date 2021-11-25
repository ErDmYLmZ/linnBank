Feature: US001 Registration

  Background:
    Given "unregistered" is on the "Register" page

  @register
  Scenario: Register with invalid fields
    And Enter "invalid" "ssn"
    And Enter "invalid" "firstname"
    And Enter "invalid" "lastname"
    And Enter "invalid" "address"
    And Enter "invalid" "mobilephone"
    And Enter "invalid" "username"
    And Enter "invalid" "email"
    And Enter "invalid" "firstPassword"
    And Enter "invalid" "secondPassword"
    Then Click on register
    And verify registered "unsuccessfully"
    And delete registrant





