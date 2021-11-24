Feature: Customer page

  Background: Navigate to related page
    Given "employee" is on the "Manage Customers" page

  Scenario: Edit customer information
    When employee navigates to last page on pagination
    And employee clicks on the last added customer Edit button on the page
    Then employee checks "<field>" fields and updates them
      | firstName | lastName | MiddleInıtial | Email            | MobilePhone  | PhoneNumber  | ZipCode | Address | City   | SSN         | CreateDate | State |
      | ali       | can      | veli          | alican@amail.com | 555-555-5555 | 444-444-4444 | 51100   |         | Ankara | 222-55-4679 | 12/18/2030 |       |
#    And employee chooses two accounts from account section
#    And employee clicks Zelle Enrolled if unchecked
#    And employee clicks on Save button
#    Then employee verify the success message on the Manage Customer page