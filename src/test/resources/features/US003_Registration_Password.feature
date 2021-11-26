Feature: US003: Registration page should restrict password usage to a secure and high level passcode

  Background: Navigate to related page

    Given "unregistered" is on the "Register" page

  @registration_password_lowercase_test
  Scenario: There should be at least 1 lowercase char for stronger password and see the level chart change accordingly
    When User fills all required fields correctly
    And Click on New Password textbox
    And Enter "ADMIN2021!" password
    And Click on New Password confirmation
    And Enter the same "ADMIN2021!" to verify
    Then User should see the chart level at the strongest "successfully"

  @registration_password_lowercase_test
  Scenario: There should be at least 1 lowercase char for stronger password and see the level chart change accordingly
    When User fills all required fields correctly
    And Click on New Password textbox
    And Enter "aDMIN2021!" password
    And Click on New Password confirmation
    And Enter the same "aDMIN2021!" to verify
    Then User should see the chart level at the strongest "unsuccessfully"



