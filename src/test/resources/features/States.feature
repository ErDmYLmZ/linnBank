@AllStates
Feature: read and delete states

  Background: set all states to response
    Given user sets all states to response using "https://www.gmibank.com/api/tp-states"


  Scenario: test all states
    Given user manipulates all states
    And user saves the states to correspondent files
    Then user validates all states


  Scenario Outline: delete more states

    Given user deletes a state using "<endPoint>" and "<id>"
Examples: all data
  | endPoint                               | id     |
  | https://www.gmibank.com/api/tp-states/ | 103700 |


  @CreateState
  Scenario Outline: create a state
    Given user sets the response using api end point "https://www.gmibank.com/api/tp-states" and creates states using "<idJson>" and "<nameJson>"



    Examples: create state
      | idJson | nameJson     |
      | 103790 | 1stOfCameron |



  @UpdateState
  Scenario Outline: update a state
    Given user sets the response using api end point "https://www.gmibank.com/api/tp-states" and updates states using "<idJson>" and "<nameJson>"



    Examples: create state
      |idJson|nameJson|
      |103699|very1stOfCameron|