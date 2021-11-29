Feature: US005

  @SignInWithInvalidCredentials
  Scenario Outline: There should be an invalid username and password validating the error message to login
    Given "unregistered" is on the "Sign in" page
    And do login with "<username>" and "<password>"
    And verify if there is an error message
    And navigate to "<page>" page
    And verify if it reaches to the "<page>" page


    Examples: credentials
      | username       | password | page  |
      | user7thgen     | Aa12345! | registration   |
      | employee6thgen | Bb12345! | forgetPassword |
      | manager5thgen  | Bb12345! | registration   |







