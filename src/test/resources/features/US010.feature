@Customer_adress_creation
Feature: US010


  @Adress_textbox_negative
  Scenario Outline:

    Given employee goes to  Manage Customers page
    And  click create new customer
    When type new customers all necessary credentials
    And  type city textbox
    And  type state textbox
    And  select from country dropdown
    And  type adress textbox "<newAdress>"
    Then verify that Address isn't created
    And close the application

    Examples: Adress Data
    |newAdress|
    |frankfurter strasse|
    | 451    |
    |        |

    @city_textbox_negative
  Scenario Outline:
    Given "employee" is on the "Manage Customers" page
    And  click create new customer
    When type new customers all necessary credentials
    And  type customer adress textbox
    And  type state textbox
    And  select from country dropdown
    And  type city textbox "<newCity>"
    Then verify that Address isn't created
    And close the application

    Examples: City Data
      |newCity|
      |Frankfurt55|
      | 451    |
      |        |

      @state_textbox_negative
  Scenario Outline:
    Given "employee" is on the "Manage Customers" page
    And  click create new customer
    When type new customers all necessary credentials
    And  type city textbox
    And  type state textbox "<newState>"
    And  select from country dropdown
    And  type customer adress textbox
    Then verify that Address isn't created
    And close the application

    Examples: Adress Data
      |newState|
      |New York43|
      | 451    |
      |        |
