Feature: US003: Registration page should restrict password usage to a secure and high level passcode

  Background: Navigate to related page

    Given "unregistered" is on the "Register" page

  @registration_password_lowercase_test
  Scenario: There should be at least 1 lowercase char for stronger password and see the level chart change accordingly
    Given Enter "valid" "ssn"
    And Enter "valid" "firstname"
    And Enter "valid" "lastname"
    And Enter "valid" "address"
    And Enter "valid" "mobilephone"
    And Enter "valid" "username"
    And Enter "valid" "email"
    And Click on New Password textbox
    And Enter "ADMIN2021!" password
    And Click on New Password confirmation
    And Enter the same "ADMIN2021!" to verify
    Then User should see the chart level at the strongest "unsuccessfully"
    And Close the application

  @registration_password_lowercase_test
  Scenario: There should be at least 1 lowercase char for stronger password and see the level chart change accordingly
    Given Enter "valid" "ssn"
    And Enter "valid" "firstname"
    And Enter "valid" "lastname"
    And Enter "valid" "address"
    And Enter "valid" "mobilephone"
    And Enter "valid" "username"
    And Enter "valid" "email"
    And Click on New Password textbox
    And Enter "aDMIN2021!" password
    And Click on New Password confirmation
    And Enter the same "aDMIN2021!" to verify
    Then User should see the chart level at the strongest "successfully"
    And Close the application

  @registration_password_uppercase_test
  Scenario: There should be at least 1 uppercase char for stronger password and see the level chart change accordingly
    Given Enter "valid" "ssn"
    And Enter "valid" "firstname"
    And Enter "valid" "lastname"
    And Enter "valid" "address"
    And Enter "valid" "mobilephone"
    And Enter "valid" "username"
    And Enter "valid" "email"
    And Click on New Password textbox
    And Enter "admin2021!" password
    And Click on New Password confirmation
    And Enter the same "admin021!" to verify
    Then User should see the chart level at the strongest "unsuccessfully"
    And Close the application

  @registration_password_uppercase_test
  Scenario: There should be at least 1 uppercase char for stronger password and see the level chart change accordingly
    Given Enter "valid" "ssn"
    And Enter "valid" "firstname"
    And Enter "valid" "lastname"
    And Enter "valid" "address"
    And Enter "valid" "mobilephone"
    And Enter "valid" "username"
    And Enter "valid" "email"
    And Click on New Password textbox
    And Enter "Admin2021!" password
    And Click on New Password confirmation
    And Enter the same "Admin021!" to verify
    Then User should see the chart level at the strongest "successfully"
    And Close the application
