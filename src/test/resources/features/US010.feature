@Customer_adress_creation
Feature: US010

  Background: Navigate to manage customer page
    Given "employee" is on the "Manage Customers" page
    And  click create new customer
    When type new customers all necessary credentials

  @adress_textbox_negative
  Scenario Outline:negative address
    And  type city textbox
    And  type state textbox
    And  select from country dropdown
    And employee clicks Zelle Enrolled if unchecked
    And employee chooses two accounts from account section 1 and 5
    And  type adress textbox "<newAdress>"
    Then verify that Address isn't created
    And Close the application

    Examples: Adress Data
    |newAdress|
    |frankfurter strasse|
    | 451    |
    |        |

    @city_textbox_negative
  Scenario Outline:negative city
    And  type customer adress textbox
    And  type state textbox
    And  select from country dropdown
    And employee clicks Zelle Enrolled if unchecked
    And employee chooses two accounts from account section 1 and 5
    And  type city textbox "<newCity>"
    Then verify that Address isn't created
    And Close the application

    Examples: City Data
      |newCity|
      |Frankfurt55|
      | 455    |
      |        |

      @state_textbox_negative
  Scenario Outline: negative state
    And  type city textbox
    And  type state textbox "<newState>"
    And  select from country dropdown
    And employee clicks Zelle Enrolled if unchecked
    And employee chooses two accounts from account section 1 and 5
    And  type customer adress textbox
    Then verify that Address isn't created
    #And  Close the application

    Examples: State Data
      |newState|
      |New York43|
     # | 451    |
      #|        |

        @country_negative_test
       Scenario:negative country
        And  type city textbox
        And  type state textbox
        And  select empty option from country dropdown
        And employee clicks Zelle Enrolled if unchecked
        And employee chooses two accounts from account section 1 and 5
        And  type customer adress textbox
        Then verify that Address isn't created
        And  Close the application
