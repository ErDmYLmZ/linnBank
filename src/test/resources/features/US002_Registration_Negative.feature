Feature: Registration Negative Scenario

  Background: Navigate to related page
    Given "unregistered" is on the "Register" page

  Scenario: Register with invalid fields
    And Enter "invalid" "ssn"
    And Enter "invalid" "firstname"
    And Enter "invalid" "lastname"
    And Enter "invalid" "address"
    And Enter "invalid" "mobilephone"
    And Enter "invalid" "username"
    And Enter "invalid" "email"
    And Enter "invalid" "firstPassword"
    And Enter "invalid" "secondPassword"
    Then Click on register
    And verify registered "unsuccessfully"
    And delete registrant

  Scenario Outline: Register with invalid fields
    And Register with "<ssn>" and "<firstname>" and "<lastname>" and "<address>" and "<mobilephone>" and "<username>" and "<email>" and "<firstPassword>" and "<secondPassword>"
    Then Click on register

    Examples:
      | ssn         | firstname | lastname | address | mobilephone  | username     | email           | firstPassword | secondPassword |
      | 700-54-7402 | claire    | black    | antalya | 505-123-0000 | claireblack  | c123b@gmail.com | c123b         | c123b          |
      | 700-54-7402 | claire    | black    | antalya | 505-123-0000 | claireblack  | c123b@gmail.com | c123b         | C123b!         |
      | 700-54-7402 | claire    | black    | antalya | 505-123-0000 | claireblack  | c123b@gmailcom  | C123b!        | C123b!         |
      | 700-54-7402 | claire    | black    |         | 505.123.0000 | claire&black | c123b@gmail.com | C123b         | c12C123b3b     |
      | 700-54-7402 | claire    |          | antalya | 505.123.0000 | claireblack  | c123b@gmail.com | C123b         | C123b          |
      | 700-54-7402 |           |          | antalya | 505.123.0000 | claireblack  | c123b@gmail.com | C123b         | C123b          |
      | 000-54-7402 | claire    |          | antalya | 505.123.0000 | claireblack  | c123b@gmail.com | C123b         | C123b          |