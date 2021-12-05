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
      And user enters CreateDate
      And user enters ClosedDate
      When user clicks on the save button
      Then verify no error_message is displayed on Description field
      And Close the application

      Examples: Test Data
        | Description             | Balance |
        | New Account_6thGenQA_01 |  1000   |


    @manage_account_descriptionBox_negative_Test
    Scenario Outline:Create_A_New_Account_With_Empty_Description
      And user enters Description "<Description>"
      And user selects Account_Type
      And user selects Account_Status_type
      And user enters Balance "<Balance>"
      And user enters CreateDate
      And user enters ClosedDate
      When user clicks on the save button
      Then verify the error_message is displayed on Description field
      And Close the application

      Examples: Test Data
        | Description             | Balance |
        |                         | 2000    |

    @manage_account_balance_negative_Test
    Scenario Outline:Create_A_New_Account_With_Invalid_Balance
      And user enters Description "<Description>"
      And user selects Account_Type
      And user selects Account_Status_type
      And user enters Balance "<Balance>"
      And user enters CreateDate
      And user enters ClosedDate
      When user clicks on the save button
      Then verify the error_message is displayed on Balance field
      And Close the application

      Examples: Test Data
        | Description             | Balance |
        | New Account_6thGenQA_02 | ?/\][;- |

  @manage_account_balance_negative_Test_2
  Scenario Outline:Create_A_New_Account_With_Invalid_Balance_2
    And user enters Description "<Description>"
    And user selects Account_Type
    And user selects Account_Status_type
    And user enters Balance "<Balance>"
    And user enters CreateDate
    And user enters ClosedDate
    When user clicks on the save button
    Then the error_message should be displayed on Balance field
    And Close the application

    Examples: Test Data
      | Description             | Balance |
      | New Account_6thGenQA_03 | 0       |
      | New Account_6thGenQA_04 | -1000   |

    @manage_account_CreateDate_negative_Test
    Scenario Outline:Create_A_New_Account_With_Early_CreateDate
      And user enters Description "<Description>"
      And user selects Account_Type
      And user selects Account_Status_type
      And user enters Balance "<Balance>"
      And user enters an early CreateDate
      And user enters ClosedDate
      When user clicks on the save button
      Then the error_message should be displayed on Create_date field
      And Close the application

      Examples: Test Data
        | Description             | Balance |
        | New Account_6thGenQA_05 | 3000    |

    @manage_account_ClosedDate_negative_Test
    Scenario Outline:Create_A_New_Account_With_Early_ClosedDate
      And user enters Description "<Description>"
      And user selects Account_Type
      And user selects Account_Status_type
      And user enters Balance "<Balance>"
      And user enters CreateDate
      And user enters early ClosedDate
      When user clicks on the save button
      Then the error_message should be displayed on Closed_date field
      And Close the application

      Examples: Test Data
        | Description             | Balance |
        | New Account_6thGenQA_06 | 4000    |

      @GetToken
      Scenario: Getting the api token
        When user uses api token to establish a connection