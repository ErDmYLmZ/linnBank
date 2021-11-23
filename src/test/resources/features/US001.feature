Feature: US001

  Background: Given user is on the registration page

  Scenario Outline: There should be a valid SSN respecting the "-" where necessary, it should be 9 digits long
    When Enter all required information
    Then Click on register


