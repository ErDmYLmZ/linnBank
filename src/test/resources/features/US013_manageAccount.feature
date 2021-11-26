@manage_account
Feature: Create_A_New_Account
  Background: Navigate to main page
    Given "employee" is on the "Manage Accounts" page
    And user clicks on the CreateANewAccount button


    Scenario Outline:Create_A_New_Account_With_Valid_Data
      And user enters Description "<Description>"
      And user selects Account_Type
      And user selects Account_Status_type
      And user enters Balance "<Balance>"
      And user enters CreateDate "<Create_Date>"
      And user enters ClosedDate "<Closed_date>"
      When user clicks on the save button
      Then verify no "<error_message>" is displayed on Description field
      Then verify no "<error_message>" is displayed on Balance field
      Then verify no "<error_message>" is displayed on Create_Date field
      Then verify no "<error_message>" is displayed on Closed_date field
      And Close the application




      Examples: Test Data
        | Description             | Balance | Create_Date       | Closed_date       | error_message          |
        | New Account_6thGenQA_01 |  1000   | 11/25/2021, 12:00 | 11/25/2022, 11:00 | This field is required |


#    @manage_account_descriptionBox_negative_Test
#    Scenario Outline:Create_A_New_Account_With_Empty_Description
#      Given user is on ManageAccountsPage
#      And user enters Description "<Description>"
#      And user selects Account_Type
#      And user selects Account_Status_type
#      And user enters Description "<Balance>"
#      And user enters Description "<Create_Date>"
#      And user enters Description "<Closed_date>"
#      When user clicks on the save button
#      Then verify the "<error_message>" is displayed on Description field
#      Then verify no "<error_message>" is displayed on Balance field
#      Then verify no "<error_message>" is displayed on Create_Date field
#      Then verify no "<error_message>" is displayed on Closed_date field
#      And Close the application
#
#      Examples: Test Data
#        | Description             | Balance | Create_Date       | Closed_date       | error_message          |
#        |                         | 2000    | 11/25/2021, 12:00 | 11/25/2022, 11:00 | This field is required |
#
#    @manage_account_balance_negative_Test
#    Scenario Outline:Create_A_New_Account_With_Invalid_Balance
#      Given user is on ManageAccountsPage
#      And user enters Description "<Description>"
#      And user selects Account_Type
#      And user selects Account_Status_type
#      And user enters Description "<Balance>"
#      And user enters Description "<Create_Date>"
#      And user enters Description "<Closed_date>"
#      When user clicks on the save button
#      Then verify no "<error_message>" is displayed on Description field
#      Then verify the "<error_message>" is displayed on Balance field
#      Then verify no "<error_message>" is displayed on Create_Date field
#      Then verify no "<error_message>" is displayed on Closed_date field
#      And Close the application
#
#
#
#      Examples: Test Data
#        | Description             | Balance | Create_Date       | Closed_date       | error_message          |
#        | New Account_6thGenQA_02 | ?/\][;- | 11/25/2021, 12:00 | 11/25/2022, 11:00 | This field is required |
#        | New Account_6thGenQA_02 | 0       | 11/25/2021, 12:00 | 11/25/2022, 11:00 | This field is required |
#        | New Account_6thGenQA_03 | -1000   | 11/25/2021, 12:00 | 11/25/2022, 11:00 | This field is required |
#
#    @manage_account_CreateDate_negative_Test
#    Scenario Outline:Create_A_New_Account_With_Early_CreateDate
#      Given user is on ManageAccountsPage
#      And user enters Description "<Description>"
#      And user selects Account_Type
#      And user selects Account_Status_type
#      And user enters Description "<Balance>"
#      And user enters Description "<Create_Date>"
#      And user enters Description "<Closed_date>"
#      When user clicks on the save button
#      Then verify no "<error_message>" is displayed on Description field
#      Then verify no "<error_message>" is displayed on Balance field
#      Then verify the "<error_message>" is displayed on Create_Date field
#      Then verify no "<error_message>" is displayed on Closed_date field
#      And Close the application
#
#      Examples: Test Data
#        | Description             | Balance | Create_Date       | Closed_date       | error_message          |
#        | New Account_6thGenQA_04 | 3000    | 11/25/2020, 12:00 | 11/25/2022, 11:00 | This field is required |
#
#    @manage_account_ClosedDate_negative_Test
#    Scenario Outline:Create_A_New_Account_With_Early_ClosedDate
#      Given user is on ManageAccountsPage
#      And user enters Description "<Description>"
#      And user selects Account_Type
#      And user selects Account_Status_type
#      And user enters Description "<Balance>"
#      And user enters Description "<Create_Date>"
#      And user enters Description "<Closed_date>"
#      When user clicks on the save button
#      Then verify no "<error_message>" is displayed on Description field
#      Then verify no "<error_message>" is displayed on Balance field
#      Then verify no "<error_message>" is displayed on Create_Date field
#      Then verify the "<error_message>" is displayed on Closed_date field
#      And Close the application
#
#      Examples: Test Data
#        | Description             | Balance | Create_Date       | Closed_date       | error_message          |
#        | New Account_6thGenQA_05 | 4000    | 11/25/2021, 12:00 | 11/25/2020, 11:00 | This field is required |