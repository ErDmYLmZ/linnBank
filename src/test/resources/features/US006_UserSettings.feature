@user_Settings_test
Feature: US006_User_Settings_StepDefs

  Background:
    Given "user" is on the "User Info" page

  Scenario: User_info_segment_should_be_editable_on_Homepage

#    Given user is on the application page
#    Given "user" is on the "User Info" page
#    And user clicks sign in button
#    And login with "<username>" and "<password>"
#    And user clicks submit button
#    And close the application

    Given user edits  firstnamebox
    And user edits lastnamebox
    And user edits emailbox
    And user chooses "English" or "Turkish"
    And user save the info

