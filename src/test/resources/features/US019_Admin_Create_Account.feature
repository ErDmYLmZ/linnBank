@admin_manage_account
Feature: Admin_Create_A_New_Account
  Background: Navigate to main page
    Given "admin" is on the "Manage Accounts" page
    And user clicks on the CreateANewAccount button

  Scenario Outline:Create_A_New_Account_With_Valid_Data
    And user enters Description "<Description>"
    And user selects Account_Type
    And user selects Account_Status_type
    And user enters Balance "<Balance>"
    And user enters CreateDate
    And user enters ClosedDate
    When user clicks on the save button
    Then verify no error_message is displayed on Description field
    And Close the application

    Examples: Test Data
      | Description             | Balance |
      | New Account_6thGenQA_01 |  1000   |