Feature: Customer page

  Background: Navigate to related page
    Given "employee" is on the "Manage Customers" page

  @edit_customer
  Scenario: Edit customer information
    When employee navigates to last page on pagination
    And employee clicks on the 13 customer "Edit" button on the page
    Then employee checks fields and updates fields
      | firstName | lastName | MiddleInitial | Email                           | MobilePhone  | PhoneNumber  | ZipCode | Address        | City       | SSN         | CreateDate | CreateHour |
      | George    | Bush     | W.            | kiskananlarcatlasin@usamail.com | 555-555-5555 | 444-444-4444 | 00100   | cono mahallesi | Washington | 297-55-4639 | 12/18/2000 | 13:00      |
    And employee chooses two accounts from account section 1 and 5
    And employee clicks Zelle Enrolled if unchecked
    And employee clicks on Save button
    Then employee verify the success message on the Manage Customer page

  @view_customer
  Scenario: view customer data
    When employee navigates to last page on pagination
    And employee clicks on the 50 customer "View" button on the page
    Then verify that same user is displayed on the view page

  @delete_customer
  Scenario: delete customer
    When employee navigates to last page on pagination
    And employee clicks on the 5 customer "Delete" button on the page
    Then employee see a pop up message to confirm and approves
    Then employee see a successfully deleted message