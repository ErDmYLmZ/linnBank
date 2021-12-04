@customer_manage_account
Feature: Customer_Manage_Account
  Background: Navigate to main page
    Given "customer" is on the "My Accounts" page
    And user clicks on the viewTransaction button

  Scenario: view_all_transactions
    And verify if there is an account type
    And user clicks on the viewTransaction button and verify if there is a transaction table
    And Close the application


