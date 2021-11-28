@user_Settings_test
Feature: US006_User_Settings_StepDefs

  Scenario Outline: User_info_segment_should_be_editable_on_Homepage

#    Given user is on the application page
    Given "user" is on the "User Info" page
#    And user clicks sign in button
#    And login with "<username>" and "<password>"
#    And user clicks submit button
#    And close the application

    Examples: credentials
      | username       | password |
      | user6thgen     | Aa12345! |
      | employee6thgen | Aa12345! |
      | manager6thgen  | Aa12345! |
      | customer6thgen | Aa12345! |
