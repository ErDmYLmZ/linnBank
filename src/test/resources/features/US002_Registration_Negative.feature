Feature: Registration Negative Scenario

  Background: Navigate to related page
    Given "unregistered" is on the "Register" page

  Scenario Outline : Register with invalid fields
      And Register with "<ssn>" and "<firstname>" and "<lastname>" and "<address>" and "<mobilephone>" and "<username>" and "<email>" and "<firstPassword>" and "<secondPassword>"
      Then Click on register

    Examples:
      |ssn|firstname|lastname|address|mobilephone|username|email|firstPassword|secondPassword|
      |700-54-7402|claire|black|antalya|505-123-0000|claireblack|c123b@gmail.com|c123b|c123b|