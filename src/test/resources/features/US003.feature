Feature: US003: Registration page should restrict password usage to a secure and high level passcode

  Background: Navigate to related page

    Given "user" is on the "registration" page

    @registration_password_test
    Scenario : There should be at least 1 lowercase char for stronger password and see the level chart change accordingly
      When User fills all required fields correctly
      And Click on New Password textbox
      And Enter "password" password
      And Click on New Password confirmation
      And Enter the same password to verify
      Then User should not see the chart level at the strongest



