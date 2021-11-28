Feature: US004

  @SignIn
  Scenario: There should be a valid username and password validating the success message to login
    Given "unregistered" is on the "Sign in" page
    And login with "user6thgen" and "Aa12345!"
    And Sign Out

  Scenario Outline: Login the application
    Given "unregistered" is on the "Sign in" page
    And login with "<username>" and "<password>"
    And Sign Out

    Examples: credentials
      | username       | password |
      | user6thgen     | Aa12345! |
      | employee6thgen | Aa12345! |
      | manager6thgen  | Aa12345! |
      | customer6thgen | Aa12345! |

  Scenario Outline: Navigate to page with specified role
    Given "<role>" is on the "<page>" page
#    And Sign Out
    Examples:
      | role         | page             |
#      | user         | User Info        |
#      | user         | Password         |
#      | admin        | User Management  |
#      | manager      | Manage Customers |
#      | manager      | Manage Accounts  |
      | employee     | Manage Customers |
#      | employee     | Manage Accounts  |
#      | customer     | My Accounts      |
#      | customer     | Transfer Money   |
#      | unregistered | Register         |
#      | unregistered | Sign in          |