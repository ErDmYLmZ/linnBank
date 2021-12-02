Feature: Customer page
#The date cannot be typed earlier, in the past, at the time of creation a customer
#The date should be created as month, day, year, hour and minute
#User can choose a user from the registration and it cannot be blank
#There user can choose an account created on manage accounts
#User can select Zelle Enrolled optionally and save it
  Scenario: Add customer
    Given "employee" is on the "Manage Customers" page
    Then user creates a customer
    And user search SSN,
    And user enter middleInitial, zipcode, city, country,
    And employee chooses two accounts from account section 1 and 5
    When employee clicks on Save button

  @view_customer @verifycustomerdate
  Scenario: view customer data
    When employee navigates to last page on pagination
    And employee clicks on the 50 customer "View" button on the page
    Then verify that same user is displayed on the view page
    Then verify user creation date is correct

