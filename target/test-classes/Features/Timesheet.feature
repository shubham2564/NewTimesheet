Feature: Automate the Timesheet Page

  @Login
  Scenario: Login on home page
    Given Read data from excel
    And browser is open
    And user is on login page
    When user enters id
    And user clicks signin
    And user enters password
    And user again clicks signin
    And user is on home page

  @Automate
  Scenario: Automate the page
    And Again read data from excel
    And fetch the user details
    And Search ESA Timesheet
    And get the weeks details
    And Fill the details in timesheet
    Then get the rest details
