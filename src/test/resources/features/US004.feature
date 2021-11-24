Feature: US004

  Background: Navigate to page
    Given user is on the Sign in page

  @login_test
  Scenario: There should be a valid username and password validating the success message to login
    And login with "user6thgen" and "Aa12345!"
    And close the application

  Scenario Outline:

    And login with "<username>" and "<password>"
    And close the application

    Examples: credentials
      | username       | password |
      | user6thgen     | Aa12345! |
      | employee6thgen | Aa12345! |
      | manager6thgen  | Aa12345! |
      | customer6thgen | Aa12345! |

