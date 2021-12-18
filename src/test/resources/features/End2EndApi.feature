Feature: End2EndApi

  @regression_api
# qarsli
  Scenario: Register with api
    Then register with api

  Scenario: Verify that user has been created on database
    Given User is connected to database
    When verify that user has "registered" on application
## qarsli
#  Scenario: admin activates user
#    Given "admin" is on the "User Management" page
#    And activate "user" with api
#    And Sign Out
#
#  Scenario: Verify that user has been activated on database
#    Given User is connected to database
#    When verify that user has "activated" on application
#
##  ali osman
#  Scenario: Add customer
#    Given "employee" is on the "Manage Customers" page
#    Then user creates a customer
#    And user search SSN,
#    And user enter middleInitial, zipcode, city, country,
#    And employee chooses two accounts from account section 1 and 5
#    When employee clicks on Save button
#    And Sign Out
#
#  Scenario: Verify that user has been assigned on database
#    Given User is connected to database
#    When verify that user has "assigned" on application
#
#  Scenario: Transfer Money
##    erdem
#    Given "user" is on the "My Accounts" page
#    And retrieve account data
#    Then Sign Out
##    enes
#    Given "user" is on the "Transfer Money" page
#    And customer choose first account to transfer money from
#    And customer choose second account to transfer money to
#    And customer enters the transaction amount
#    And customer enters the description
#    And customer clicks on make transfer button
#    Then customer verify the success message
#    Then close the application




  