Feature:

  Background: Navigate to related page
    Given "customer" is on the "My Accounts" page

  Scenario: transfer between accounts
    And retrieve account data
    Then Sign Out
    Then "customer" is on the "Transfer Money" page
    And customer choose first account to transfer money from
    And customer choose second account to transfer money to
    And customer enters the transaction amount
    And customer enters the description
    And customer clicks on make transfer button
    Then customer verify the success message
    Then Sign Out
